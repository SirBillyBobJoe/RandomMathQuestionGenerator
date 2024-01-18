package Operators;

public abstract class Operator {
    protected String string;
    protected int answer;
    @Override
    public String toString(){
        return string;
    }

    public int answer(){
        return answer;
    }
}
