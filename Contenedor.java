class Contenedor {
    private int id;
    private String nombreProducto;
    private int peso;
    private String destino;

    public Contenedor(int id, String nombreProducto, int peso, String destino) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.peso = peso;
        this.destino = destino;
    }

    public int getID() {
        return id;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getPeso() {
        return peso;
    }

    public String getDestino() {
        return destino;
    }

}