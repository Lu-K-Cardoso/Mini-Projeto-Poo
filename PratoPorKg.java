public class PratoPorKg extends ItemCardapio {
    private double precoKg;
    private int pesoGramas;
        public PratoPorKg(String nome, String descricao, double precoKg){
            super(nome, descricao);
                if (precoKg <= 0) {
                    throw new ValorInvalidoException("o preço do kg tem que ser maior que 0");    
                }else{
                    this.precoKg = precoKg;
                }
                pesoGramas = 0;
        }
        public void setPesoGrama(int peso){
            if (peso <= 0) {
                throw new ValorInvalidoException("o peso tem que ser negativo maior que 0");
            }else{
                this.pesoGramas = peso;
            }
        }
        @Override
        public double calcularPreco(){
            return (this.pesoGramas / 1000) * this.precoKg;
        }
        public double getPrecoKg(){
            return  this.precoKg;
        }
        public int getPesoGramas(){
            return this.pesoGramas;
        }
}
