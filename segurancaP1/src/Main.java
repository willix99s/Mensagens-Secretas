public class Main {
    public static void main(String[] args) {
        Comunicacao comunicacao = new Comunicacao();
        CifraSimetrica cifra = new CifraSimetrica("moeda");

        Emissor emissor1 = new Emissor(1, comunicacao, cifra);
        Emissor emissor2 = new Emissor(2, comunicacao, cifra);

        Receptor receptor3 = new Receptor(3, comunicacao, cifra);
        Receptor receptor4 = new Receptor(4, comunicacao, cifra);

        // emissor1.enviarMensagemVi("Olá, receptor 1!", 3); // envia mensagem para receptor 1
        // emissor2.enviarMensagemVe("Olá, receptor 2!", 4); // envia mensagem para receptor 2

        emissor1.enviarMensagemBroadcastVi("Oi, pessoal!"); // envia mensagem para todos os receptores, exceto ele mesmo
        emissor2.enviarMensagemBroadcastVe("Oi, pessoal!"); // envia mensagem para todos os receptores, exceto ele mesmo
    }
}

