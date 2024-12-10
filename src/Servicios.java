public class Servicios {

    //Atributos compartidos que tienen todas las clases
    private int valorColor;
    private int costoColor;
    private int valorBn;
    private int costoBN;
    private int canitdadColor;
    private int cantidadBN;
    private int ganancia;
    private int valorPagado;

    public Servicios() {
    }

    public Servicios(int valorColor, int costoColor, int costoBN, int valorBn) {

        this.valorColor = valorColor;
        this.costoColor = costoColor;
        this.costoBN = costoBN;
        this.valorBn = valorBn;
        this.canitdadColor = 0;
        this.cantidadBN = 0;
        this.valorPagado = 0;
    }

    public int getValorColor() {
        return valorColor;
    }

    public void setValorColor(int valorColor) {
        this.valorColor = valorColor;
    }

    public int getCostoColor() {
        return costoColor;
    }

    public void setCostoColor(int costoColor) {
        this.costoColor = costoColor;
    }

    public int getCostoBN() {
        return costoBN;
    }

    public void setCostoBN(int costoBN) {
        this.costoBN = costoBN;
    }

    public int getValorBn() {
        return valorBn;
    }

    public void setValorBn(int valorBn) {
        this.valorBn = valorBn;
    }

    public int getCanitdadColor() {
        return canitdadColor;
    }
    public int getCantidadBN() {
        return cantidadBN;
    }


    public void setCanitdadColor(int canitdad) {
        this.canitdadColor = this.canitdadColor + canitdad;
    }
    public void setCantidadBN(int cantidadBN){
        this.cantidadBN = this.cantidadBN + cantidadBN;
    }

    public int getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(int valorPagado) {
        this.valorPagado = this.valorPagado + valorPagado;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }
    public int ganancia(){
        int ganancia;
        ganancia = getValorPagado()-getCanitdadColor() * getCostoColor() - getCantidadBN()*getCostoBN();
        return ganancia;
    }

    public String toString() {
        return  "HC = " + canitdadColor +
                "\nHBN = " + cantidadBN +
                "\nValor Pagado = " + valorPagado +
                "\nGanancia = " + ganancia ;
    }


}
