public class key {
    public static String chaveIgual(String chave, int tamanhoChave) {
        String chaveFinal = chave;
        if (chave.length() > tamanhoChave) {
            chaveFinal = "";
            for (int index = 0; index < tamanhoChave; index++) {
                chaveFinal += chave.charAt(index);
            }
        } else {
            for (int index = chave.length(); index < tamanhoChave; index++) {
                chaveFinal += chave.charAt(index % chave.length());
            }            
        }
        return chaveFinal;
    }
}
