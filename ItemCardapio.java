public abstract class ItemCardapio {
    private String nome, descricao;
    private boolean disponivel;
        public ItemCardapio(String nome, String descricao){
            if (nome == null || nome.isEmpty()) {
                throw new ValorInvalidoException("O nome do item não pode ser nulo ou vazio");
            }else{
                this.nome = nome;
                this.descricao = descricao;
                this.disponivel = true;
            }
        }
        public abstract double calcularPreco();
        public String getNome(){
            return nome;
        }
        public String getDescricao(){
            return descricao;
        }
        public boolean getDisponivel(){
            return disponivel;
        }
        public void setDisponivel(boolean disponivel){
            this.disponivel = disponivel;
        }
        @Override
        public String toString(){
            String status;
            if (this.disponivel) {
                status = "Disponivel";
            }else{
                status = "Indisponivel";
            }
            return "Item: " +nome+ " | Status: " +status+ " | Preço: " +calcularPreco(); 
        }
}
