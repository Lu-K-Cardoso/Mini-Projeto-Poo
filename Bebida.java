public class Bebida extends ItemCardapio {
    private double precoUnitario;
    private int quant;
    private boolean alcoolico;
        public Bebida(String nome, String descricao, double precoUnitario, int quant, boolean alcoolico){
            super(nome, descricao);
            if (precoUnitario <= 0 || quant < 1) {
                throw new ValorInvalidoException("o preco unitario tem q ser maior que 0");
            }else{
                this.precoUnitario = precoUnitario;
                this.quant = quant;
            }
            this.alcoolico = alcoolico;
        }
        public void adicionarUnidade(){
            this.quant += 1;
        }
        public void removerUnidade(){
            if (quant == 1) {
                throw new ValorInvalidoException("a quantidade não pode ser menor que 1");
            }else{
                this.quant -= 1;
            }
        }
        @Override
        public double calcularPreco(){
            return this.precoUnitario * this.quant;
        }
        public int getQuant(){
            return quant;
        }
        public boolean getAlcoolico(){
            return alcoolico;
        }

}
