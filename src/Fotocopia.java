public class Fotocopia extends Servicios{

    public Fotocopia(int valorColor, int costoColor, int costoBN, int valorBn) {
        super(valorColor, costoColor, costoBN, valorBn);
    }

    @Override
    public int ganancia() {
        return super.ganancia();
    }
    public int costo(){
        return this.getCanitdadColor()*this.getCostoColor() + this.getCantidadBN()*this.getCostoBN();
    }

    public String toString() {
        return  "______________________"+
                "\nCopia a color = " + getCanitdadColor() +
                "\nCopia blanco/Negro = " + getCantidadBN() +
                "\nValor Pagado = " + getValorPagado() +
                "\nGanancia = " + ganancia()+
                "\n_______________________";
    }

}
