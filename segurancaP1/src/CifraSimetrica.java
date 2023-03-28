public class CifraSimetrica {
    private String chave;

    public CifraSimetrica(String chave) {
        this.chave = chave;
    }

    // Implementação da cifra de Vigenère
    public String criptografarVigenere(String mensagem) {
        String mensagemCriptografada = "";
        int tamanhoChave = chave.length();
        int j = 0;
        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);
            if (caractere >= 'A' && caractere <= 'Z') {
                mensagemCriptografada += (char)((caractere + chave.charAt(j) - 2 * 'A') % 26 + 'A');
                j = (j + 1) % tamanhoChave;
            } else if (caractere >= 'a' && caractere <= 'z') {
                mensagemCriptografada += (char)((caractere + chave.charAt(j) - 2 * 'a') % 26 + 'a');
                j = (j + 1) % tamanhoChave;
            } else {
                mensagemCriptografada += caractere;
            }
        }
        return mensagemCriptografada;
    }

    public String descriptografarVigenere(String mensagemCriptografada) {
        String mensagem = "";
        int tamanhoChave = chave.length();
        int j = 0;
        for (int i = 0; i < mensagemCriptografada.length(); i++) {
            char caractere = mensagemCriptografada.charAt(i);
            if (caractere >= 'A' && caractere <= 'Z') {
                mensagem += (char)((caractere - chave.charAt(j) + 26) % 26 + 'A');
                j = (j + 1) % tamanhoChave;
            } else if (caractere >= 'a' && caractere <= 'z') {
                mensagem += (char)((caractere - chave.charAt(j) + 26) % 26 + 'a');
                j = (j + 1) % tamanhoChave;
            } else {
                mensagem += caractere;
            }
        }
        return mensagem;
    }

    // Implementação da cifra de Vernam
    public String criptografarVernam(String mensagem) {
        int tamanhoMsg = mensagem.length();
        String chaveFinal = key.chaveIgual(chave, tamanhoMsg);

        String mensagemCriptografada = "";
        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);
            mensagemCriptografada += (char)(caractere ^ chaveFinal.charAt(i));
        }
        return mensagemCriptografada;
    }

    public String descriptografarVernam(String mensagemCriptografada) {
        int tamanhoMsg = mensagemCriptografada.length();
        String chaveFinal = key.chaveIgual(chave, tamanhoMsg);

        String mensagem = "";
        for (int i = 0; i < mensagemCriptografada.length(); i++) {
            char caractere = mensagemCriptografada.charAt(i);
            mensagem += (char)(caractere ^ chaveFinal.charAt(i));
        }
        return mensagem;
    }
}
