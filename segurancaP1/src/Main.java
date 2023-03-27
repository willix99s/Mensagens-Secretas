public class Main {
    public static void main(String[] args) {
        Comunicacao comunicacao = new Comunicacao();
        CifraSimetrica cifra = new CifraSimetrica("chave");

        Emissor emissor1 = new Emissor(1, comunicacao, cifra);
        Emissor emissor2 = new Emissor(2, comunicacao, cifra);

        Receptor receptor1 = new Receptor(1, comunicacao, cifra);
        Receptor receptor2 = new Receptor(2, comunicacao, cifra);

        emissor1.enviarMensagemVi("Olá, receptor 1!", 1); // envia mensagem para receptor 1
        emissor2.enviarMensagemVe("Olá, receptor 2!", 2); // envia mensagem para receptor 2

        emissor1.enviarMensagemBroadcastVi("Oi, pessoal!"); // envia mensagem para todos os receptores, exceto ele mesmo
    }
}

