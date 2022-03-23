package labe;


class SingleUseMethodException extends Exception {
    public SingleUseMethodException() {
        super("Method can only be called once per instantiation");
    }
}
