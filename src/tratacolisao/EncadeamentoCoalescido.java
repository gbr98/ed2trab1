package tratacolisao;

public class EncadeamentoCoalescido
{
    private long[][] tabela;
    private int numColisoes;

    public EncadeamentoCoalescido(int tam)
    {
        long[][] tabela = new long[tam/4][1];
        for(int i=0; i<tam/4; i++)
        {
            tabela[i][1] = -2;
        }
        setNumColisoes(0);
    }

    public void setTabela(long[][] tabela)
    {
        this.tabela = tabela;
    }

    public long[][] getTabela()
    {
        return tabela;
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

        int indice = (int)Math.floor(tabela.length*(valor - Math.floor(valor)));
        return indice;
    }

    public void insereEncadCoalescido(long valor)
    {
        int indice = indiceHashMulti(valor);
        int aux = tabela.length-1;

        if(tabela[indice][1] == -2)
        {
            tabela[indice][0] = valor;
            tabela[indice][1] = -1;
        }
        else
        {
            while(tabela[indice][1] != -1)
            {
                indice = (int)tabela[indice][1];
                  numColisoes++;
            }
            while(tabela[aux][1]!= -2)
            {
                aux--;
                if(aux<0)
                {
                    System.out.println("Tabela cheia");
                    return;
                }
            }
        }
            tabela[aux][0] = valor;
            tabela[aux][1] = -1;
            tabela[indice][1] = aux;
        }


    public boolean buscaEncadCoalescido(long valor)
    {
        int indice = indiceHashMulti(valor);
        boolean aux = false;
        if(tabela[indice][1] == -2)
        {
            aux = false;
        }
        else
        {
            while(tabela[indice][1] != -1)
            {
                    indice = (int)tabela[indice][1];
            }
            if(tabela[indice][0] == valor)
            {
                aux = true;
            }
        }
        return aux;
    }
}
