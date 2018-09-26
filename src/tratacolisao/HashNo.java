package tratacolisao;

public class HashNo
{
    private HashNo proximoNo;
    private long valor;

    public HashNo(long valor)
    {
        setValor(valor);
        setProximoNo(null);
    }

    public HashNo(HashNo no, long valor)
    {
        setValor(valor);
        setProximoNo(no);
    }

    public void setProximoNo(HashNo no)
    {
        proximoNo = no;
    }

    public HashNo getProximoNo()
    {
        return proximoNo;
    }

    public void setValor(long valor)
    {
        this.valor = valor;
    }

    public long getValor()
    {
        return valor;
    }
}
