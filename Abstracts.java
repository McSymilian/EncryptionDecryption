package encryptdecrypt;

abstract class Algorithm {
    public abstract String action(String text, int key);
}
abstract class Encrypt extends Algorithm {}
abstract class Decrypt extends Algorithm {}
