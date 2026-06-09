import java.util.ArrayList;

public class MainCardapio {
    public static void main(String[] args) {
        
        try {
            Prato pratoInvalido = new Prato("X-Tudo", "Lanche", -5.00, "Lanches");
        } catch (ValorInvalidoException e) {
            System.out.println("Erro pego com sucesso: " + e.getMessage());
        }
        System.out.println();


        try {
            Pedido pedidoVazio = new Pedido(2, "Lucas");
            pedidoVazio.calcularTotalPedido();
        } catch (PedidoVazioException e) {
            System.out.println("Erro pego com sucesso: " + e.getMessage());
        }
        System.out.println();


        try {
            Pedido pedidoTeste = new Pedido(3, "Ana");
            Prato coxinhaIndisponivel = new Prato("Coxinha", "Salgado frito", 7.30, "Salgados");
            coxinhaIndisponivel.setDisponivel(false);
            pedidoTeste.adicionarItem(coxinhaIndisponivel);
        } catch (ItemIndisponivelException e) {
            System.out.println("Erro pego com sucesso: " + e.getMessage());
        }
        System.out.println();


        Prato pizza = new Prato("Pizza", "Fatia de pizza de muçarela", 32.90, "Pizza");
        pizza.setDisponivel(true);
        
        Prato coxinha = new Prato("Coxinha", "Coxinha de frango com catupiry", 7.30, "Salgado");
        coxinha.setDisponivel(true);
        
        PratoPorKg buffet = new PratoPorKg("Buffet", "Almoço no quilo", 50.00); 
        buffet.setPesoGrama(450);
        buffet.setDisponivel(true);
        
        Bebida suco = new Bebida("Suco de Laranja", "Suco natural 500ml", 7.00, 2, false);
        suco.setDisponivel(true);
        
        Combo comboFamilia = new Combo("Combo Família", "2 Pratos + 1 Bebida", 10.0);
        comboFamilia.setDisponivel(true);
        Prato p1 = new Prato("Item Combo 1", "Prato do combo", 40.00, "Almoço");
        Prato p2 = new Prato("Item Combo 2", "Prato do combo", 40.00, "Almoço");
        comboFamilia.adicionarItemCombo(p1);
        comboFamilia.adicionarItemCombo(p2);

        try {
            Pedido pedidoValido = new Pedido(1, "Ed Carlos");
            pedidoValido.adicionarItem(pizza);
            pedidoValido.adicionarItem(buffet);
            pedidoValido.adicionarItem(coxinha);
            pedidoValido.adicionarItem(suco);
            pedidoValido.adicionarItem(comboFamilia);
            
            System.out.println(pedidoValido.gerarCupomFiscal());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        System.out.println();


        ArrayList<ItemCardapio> listaPolimorfica = new ArrayList<>();
        listaPolimorfica.add(pizza);
        listaPolimorfica.add(buffet);
        listaPolimorfica.add(suco);
        listaPolimorfica.add(comboFamilia);

        for (ItemCardapio item : listaPolimorfica) {
            System.out.println("Item: " + item.getNome() + " | Preço: R$ " + item.calcularPreco());
        }
    }
}