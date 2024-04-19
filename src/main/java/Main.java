import java.util.List;

public class Main {
    TipoPrenda REMERA = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    TipoPrenda ZAPATILLA = new TipoPrenda(Categoria.CALZADO);
    TipoPrenda PANTALON = new TipoPrenda(Categoria.PARTE_INFERIOR);
    Prenda miprenda = new Prenda(REMERA);
}



enum Tela{LANA,ALGODON,POLIESTER}
enum Trama{LISA,RAYADA,LUNARES,CUADROS,ESTAMPADO}
enum Color{ROJO,BLANCO,AZUL,NEGRO,VIOLETA}


class Material{
    Tela tela;
    Trama trama;
    public Material(Tela tela){
        this.trama = Trama.LISA;
        this.tela = tela;
    }
    public Material(Tela tela,Trama trama){
        this.trama = trama;
        this.tela = tela;
    }

    public Trama getTrama() {
        return trama;
    }

    public Tela getTela() {
        return tela;
    }
}
enum Categoria{
    PARTE_SUPERIOR,
    CALZADO,
    PARTE_INFERIOR,
    ACCESORIO
}

class TipoPrenda{
    Categoria categoria;
    TipoPrenda(Categoria categoria) {
        this.categoria = categoria;
    }
    List<Color> colores;
    List<Material> materiales;

    public Categoria getCategoria(){
        return this.categoria;
    }
    private boolean colorValido(Color color){
        return this.colores.contains(color);
    }
    private boolean materialValido(Material material){
        return this.materiales.contains(material);
    }
    public boolean validarPrenda(Prenda prenda){
        return (materialValido(prenda.getMaterial()) && colorValido(prenda.getColor_primario()));
    }
}

class Prenda{
    TipoPrenda tipo_prenda;
    Categoria categoria;
    Material material;
    Color color_primario;
    Color color_secundario = null;
    public Prenda(TipoPrenda tipo_prenda){
        this.tipo_prenda=tipo_prenda;
        this.categoria = tipo_prenda.getCategoria();
    }

    public void cargarMateriales(Material material,Color color_primario){
            this.material = material;
            this.color_primario = color_primario;
        }

    public void agregarColorSecundario(Color color){
        this.color_secundario = color;
    }
    void guardarPrenda(){
        if(this.tipo_prenda.validarPrenda(this)) {
            //Se guarda la prenda
        }else{
            throw new RuntimeException();
        }
    }

    public Color getColor_primario() {
        return color_primario;
    }

    public Material getMaterial() {
        return material;
    }
}


