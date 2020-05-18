package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {
    private final NandGate Nand1;
    private final NandGate Nand2;
    private final NandGate Nand3;
    private final NandGate Nand4;


    public And3Gate() {
        super("And3Gate", 3);
        Nand1 = new NandGate();
        Nand2 = new NandGate();
        Nand3 = new NandGate();
        Nand4 = new NandGate();

        Nand4.connect(0, Nand3);
        Nand4.connect(1, Nand3);
        Nand3.connect(0, Nand2);
        Nand2.connect(0, Nand1);
        Nand2.connect(1,Nand1);

    }


    @Override
    public boolean read() {
        return Nand4.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {

        if (inputIndex > 1 || inputIndex < 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }

        if (inputIndex == 0){
            Nand1.connect(0, emitter);
        }

        else if (inputIndex == 1){
            Nand1.connect(1, emitter);
        }

        else{
            Nand3.connect(1, emitter);
        }

    }
}
