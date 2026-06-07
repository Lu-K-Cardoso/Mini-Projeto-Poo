public class Prato extends ItemCardapio {
    private double precoBase;
    private String categoria;
        public Prato(String nome, String descricao, double precoBase, String categoria){
            super(nome, descricao);
            if (categoria == null || categoria.isEmpty() ||precoBase <= 0) {
                throw new ValorInvalidoException("O item precisa de um preco e uma categoria");
            }else{
                this.precoBase = precoBase;
                this.categoria = categoria;
            }
        }
        @Override
        public double calcularPreco(){
            
        }
}
