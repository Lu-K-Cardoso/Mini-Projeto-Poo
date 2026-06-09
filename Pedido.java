import java.util.ArrayList;

public class Pedido {
    private int id;
    private String cliente;
    private ArrayList <ItemCardapio> itens;
        public Pedido(int id, String cliente){
            if (cliente == null || cliente.isEmpty()) {
                throw new ValorInvalidoException("O cliente precisa ter um nome");
            }else{
                this.cliente = cliente;
            }
            this.id = id;
            this.itens = new ArrayList<>();
        }
        public void adicionarItem(ItemCardapio item){
            if (item == null) {
                throw new ValorInvalidoException("item não pode ser nulo");
            }else if(item.getDisponivel()){
                throw new ItemIndisponivelException(item.getNome());
            }else{
                this.itens.add(item);
            }
        }
        public double calcularTotalPedido(){
            if (this.itens.isEmpty()) {
                throw new PedidoVazioException();
            }
            double total = 0.0;
            for (ItemCardapio item : this.itens) {
                total += item.calcularPreco();
            }
            return total;
        }
        public String gerarCupomFiscal(){
            String idFormato = String.format("%03d", this.id);
            String cupom = "╔══════════════════════════════════════╗\n";
            cupom +="║          CANTINA DA BRUNA            ║\n";
            cupom +="║ Pedido #" +idFormato+ "— Cliente: " +this.cliente+"║\n";
            cupom += "╚══════════════════════════════════════╝\n";
            for (ItemCardapio item : this.itens) {
                cupom += item.toString() + "\n";
            }
            cupom += "──────────────────────────────────────\n";
            try{
                double total = calcularTotalPedido();
                cupom += "TOTAL ..................... R$ "+total+"\n";
                }
            catch(PedidoVazioException e){
                cupom += "ERRO: o pedido esta vazio\n";
            }
                cupom += "══════════════════════════════════════";
                return cupom;
        }
}
