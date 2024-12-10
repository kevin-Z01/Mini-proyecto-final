public class Impresora extends Servicios{

    public Impresora(int valorColor, int costoColor, int costoBN, int valorBn) {
        super(valorColor, costoColor, costoBN, valorBn);
    }

    @Override
    public int ganancia() {
        return super.ganancia();
    }
    public int costo(){
        return getCantidadBN()*getCostoBN() + getCanitdadColor()*getCostoColor();
    }

    @Override
    public String toString() {
        return  "___________________________"+
                "\nCopia laser a color = " + getCanitdadColor() +
                "\nCopia laser blanco/Negro = " + getCantidadBN() +
                "\nValor Pagado = " + getValorPagado() +
                "\nGanancia = " + ganancia()+
                "\n____________________________";
    }




}
