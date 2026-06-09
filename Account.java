public class Account {
    private Double saldo;
    private Double chequeEspecial;
    private Double chequeBase;
    public Account (Double deposito) {
        saldo = deposito;
        chequeBase = deposito > 500 ? deposito / 2 : 50.0;
        chequeEspecial = chequeBase;
    }
    public Double getSaldo(){
        return saldo;
    }
    public Double getChequeEspecial(){
        return chequeEspecial;
    }
    public void depositar(Double valor){
        if (valor > 0) {
            if (chequeEspecial < chequeBase) {
                saldo += valor - (chequeBase - chequeEspecial);
                chequeEspecial = chequeBase;
                System.out.println("Transação efetuada com sucesso.");
            } else {
                saldo += valor;
                System.out.println("Transação efetuada com sucesso.");
            }
        } else {
            System.out.println("Valor incorreto, tente novamente.");
        }
    }
    public void transacao(Double valor){
        if (valor > 0) {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.println("Transação efetuada com sucesso.");
            } else {
                if (valor <= saldo + chequeEspecial) {
                    chequeEspecial = saldo + chequeEspecial - valor;
                    saldo = 0.0;
                    System.out.println("Transação efetuada com sucesso.");
                } else {
                    System.out.println("Limite insuficiente.");
                }
            }
        } else {
            System.out.println("Valor incorreto, tente novamente.");
        }
    }
    public void statusCheque(){
        if (chequeEspecial < chequeBase) {
            System.out.println("Cheque especial em uso.");
        } else {
            System.out.println("Cheque especial sem uso.");
        }
    }
}
