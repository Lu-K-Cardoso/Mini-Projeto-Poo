import java.util.ArrayList;

public class Combo extends ItemCardapio {
    private ArrayList <ItemCardapio> itens;
    private double percentualDesconto;
        public Combo(String nome, String descricao, double percentualDesconto){
            super(nome, descricao);
            if (percentualDesconto < 0 || percentualDesconto > 100) {
                throw new ValorInvalidoException("o combo não pdoe ser nem maior que 100 e nem menor que zero");
            }else{
                this.percentualDesconto = percentualDesconto;
            }
            this.itens = new ArrayList<>();
        }
        public void adicionarItemCombo(ItemCardapio item){
            if (item == null) {
                throw new ValorInvalidoException("Nao pode ser nulo o item");
            }else{
                this.itens.add(item);
            }
        }
        @Override
        public double calcularPreco(){
            double somaTotal = 0.0;
                for (ItemCardapio item : this.itens) {
                    somaTotal += item.calcularPreco();
                }
                double valorDesconto = somaTotal * (this.percentualDesconto/100);
                return somaTotal - valorDesconto;
        }
    
}
