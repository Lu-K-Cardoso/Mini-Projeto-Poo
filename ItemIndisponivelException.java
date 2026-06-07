public class ItemIndisponivelException extends RuntimeException{
    public ItemIndisponivelException(String nome){
        super("o item "+ nome + " esta indisponivel no momento");
    }
}
