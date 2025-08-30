package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    // Interface: Visibilidade deveria ser 'private', respeitando encapsulamento
    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            // Comissão: Comparação deveria ser feita com papelMoeda[i], para iterar sobre todo o array de papelMoeda[]
            if (papelMoeda[1] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            // Omissão: Falta de implantação de mensagem informando o erro para facilitar identificação pelo usuário
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    // Interface: Método deveria ser do tipo 'PapelMoeda', e não 'Integer'
    // Interface: Deveria implementar método para retornar papéis moeda ou objeto vazio, mas não nulo
    public Iterator<Integer> getTroco() {
        return null;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            // Omissão: Falta de implantação de mensagem informando o erro para facilitar identificação pelo usuário
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        // Computação: Deveria imprimir o valor que foi sacado, e não o saldo remanescente da conta
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        // Omissão: Falta de método ou cálculo para retirar do saldo o valor que foi sacado
        return result;
    }
}
