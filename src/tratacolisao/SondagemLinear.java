package tratacolisao;

public class SondagemLinear
{
    long[] vetor;
    int numColisoes;

    public SondagemLinear(int tam)
    {
        vetor = new long[tam];
        for(int i=0; i<tam; i++)
        {
            vetor[i] = -1;
        }
        setNumColisoes(0);
    }

    public void setNumColisoes(int n)
    {
        numColisoes = n;
    }

    public int getNumColisoes()
    {
        return numColisoes;
    }

    public long[] getVetor()
    {
        return vetor;
    }

    public void setVetor(long[] vetor)
    {
        this.vetor = vetor;
    }

    public int k (long dado, int colisao)
    {
        return (int)((dado + colisao)%vetor.length);
    }

    public void insere (long dado)
    {
        int indice = k(dado,numColisoes);
        while(vetor[indice] != -1)
        {
                numColisoes++;
                indice = k(dado,numColisoes);
        }
        vetor[indice] = dado;
    }

    public boolean busca(long b)
    {
        int colisao = 0;
        int pos = k(b,colisao);
        while(vetor[pos] != -1)
        {
            if(vetor[pos] == b)
            {
                return true;
            }
            colisao++;
            pos = k(b,colisao);
        }
    return false;
    }
}
