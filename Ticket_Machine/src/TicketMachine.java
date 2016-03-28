
import java.util.Iterator;

/**
 * Marcelo Vironda Rozanti 31417485
 * <p>
 * Gustavo Fernandes Queiroz 41486374
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {//

    protected int valor;//Comissão: valor não está especificado no diagrama de classes
    protected int saldo;//Comissão: saldo não está especificado no diagrama de classes
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;//Computação: a saldo é atribuido 0 e nunca mais é atribuido um inteiro a saldo em todo o programa. Isso compromete getSaldo() e imprimir()
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[1] == quantia) {//Desempenho: apenas o papelMoeda de valor 5 está sendo comparado à quantia em todo o loop tornando-o desnecessário
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {//Inicialização: o retorno deste método, por ser sempre null, ao tentar ser utilizado, gerará uma NullPointerException; 
        //Comissão: getTroco() no diagrama de classes retorna um TrocoIterator e não um Iterator<Integer>
        return null;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
