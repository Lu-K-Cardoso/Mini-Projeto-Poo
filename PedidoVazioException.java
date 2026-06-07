public class PedidoVazioException extends RuntimeException {
    public PedidoVazioException(){
        super("O pedido não contem itens");
    }
}
