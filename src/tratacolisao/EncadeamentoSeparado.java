package tratacolisao;

public class EncadeamentoSeparado
{
    private HashNo[] vetor;
    private int numColisoes;

    public EncadeamentoSeparado (int tam)
    {
       vetor = new HashNo[tam/4];
    }

    public void setVetor(HashNo[] vetor)
    {
        this.vetor = vetor;
    }

    public HashNo[] getVetor()
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


    public int indiceHashMulti(long valor)
    {
        int indice = (int)Math.floor(vetor.length*(valor - Math.floor(valor)));
        return indice;
    }

    public void insereEncadSeparado(long valor)
    {
        int indice = indiceHashMulti(valor);
        if(vetor[indice] == null)
        {
            vetor[indice] = new HashNo(valor);
        }
        else
        {
            vetor[indice]= new HashNo(vetor[indice],valor);
        }
    }

    public boolean buscaEncadSeparado(long valor)
    {
        int indice = indiceHashMulti(valor);
        boolean aux = false;
        while(vetor[indice] != null)
        {
            if(vetor[indice].getValor() == valor)
            {
                aux = true;
                break;
            }
            else
            {
                vetor[indice] = vetor[indice].getProximoNo();
            }
        }
        return aux;
    }


}
