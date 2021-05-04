package encryptdecrypt;

class EncryptShift extends Encrypt {
    @Override
    public String action(String text, int key) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < key; j++) {
                if (charArray[i] == 'z') {
                    charArray[i] = 'a';
                    continue;
                }
                if (charArray[i] == 'Z') {
                    charArray[i] = 'A';
                    continue;
                }
                if (charArray[i] >= 'a' && charArray[i] <= 'z' ||
                        charArray[i] >= 'A' && charArray[i] <= 'Z') {
                    charArray[i] = (char) ((int) charArray[i] + 1);
                }
            }
        }
        text = new String(charArray);
        return text;
    }
}
class EncryptUnicode extends Encrypt {
    @Override
    public String action(String text, int key) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < key; j++) {
                charArray[i] = (char) ((int) charArray[i] + 1);
            }
        }
        text = new String(charArray);
        return text;
    }
}
