package tratacolisao;

public class DuploHash
{
    private long[] vetor;
    private int numColisoes;

    public DuploHash(int tam)
    {
        vetor = new long[tam];
        setNumColisoes(0);
        for(int i=0; i<tam; i++)
        {
            vetor[i] = -1;
        }
    }

    public void setVetor(long[] vetor)
    {
        this.vetor = vetor;
    }

    public long[] getVetor()
    {
        return vetor;
    }

    public void setNumColisoes(int num)
    {
        numColisoes = num;
    }

    public int getNumColisoes()
    {
        return numColisoes;
    }

    public int indiceHashM(long valor)//Multiplica
    {
        int indice = (int)Math.floor(vetor.length*(valor - Math.floor(valor)));
        return indice;
    }

    public int indiceHashD(long valor)//Divisao
    {
        int indice = (int)valor%vetor.length;
        return indice;
    }

    public void insereDuploHash(long valor)
    {
        int indice = (indiceHashD(valor)+numColisoes*indiceHashM(valor))%vetor.length;

        if(vetor[indice] != -1)
        {
            numColisoes++;

           indice = (indiceHashD(valor)+numColisoes*indiceHashM(valor))%vetor.length;
        }
        vetor[indice] = valor;
    }

    public boolean buscaDuploHash(long valor)
    {
        int colisoes = 0;
        boolean aux = false;
        int indice = (indiceHashD(valor)+numColisoes*indiceHashM(valor))%vetor.length;

        while(vetor[indice]!= -1)
        {
            if(vetor[indice] == valor)
            {
                aux = true;
                break;
            }
            colisoes++;
            indice = (indiceHashD(valor)+numColisoes*indiceHashM(valor))%vetor.length;
        }
    return aux;
    }
}
