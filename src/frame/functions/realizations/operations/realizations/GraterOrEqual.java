package frame.functions.realizations.operations.realizations;

import frame.functions.realizations.operations.Operation;

/**
 * Created by ����� on 22.10.2015.
 */
public class GraterOrEqual implements Operation {
    // o1 <= o2
    private Operation o1;
    private Operation o2;

    public GraterOrEqual() {
    }

    public GraterOrEqual(Operation o1, Operation o2) {
        this.o1 = o1.copy();
        this.o2 = o2.copy();
    }

    public Operation getO1() {
        return o1;
    }

    public Operation getO2() {
        return o2;
    }

    @Override
    public double eval() {
        return o1.eval() >= o2.eval() ? 1:-1;
    }

    @Override
    public Operation dif() {
        return this;
    }

    @Override
    public Operation partialDerivative(Var v) {
        return this;
    }

    @Override
    public Operation copy() {
        return new GraterOrEqual(o1.copy(), o2.copy());
    }

    @Override
    public Operation simplify() {
        return this;
    }

    @Override
    public Operation toStand() {
        Operation o1_old = o1;
        Operation o2_old = o2;
        while (!((o1 = o1.toStand()).equals(o1_old) && (o2 = o2.toStand()).equals(o2_old))) {
            o1_old = o1;
            o2_old = o2;
        }
        return this;
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean equals(Operation origin) {
        return false;
    }

    @Override
    public String toString() {
        return o1.toString() + " >= " + o2.toString();
    }
}
