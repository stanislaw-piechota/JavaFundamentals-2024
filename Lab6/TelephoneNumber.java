package Lab6;

public class TelephoneNumber implements Comparable<TelephoneNumber> {
    final static int DEFAULT_CODE_LENGTH = 2;
    private String countryCode;
    private String localNumber;

    public TelephoneNumber(String code, String number){
        this.countryCode = code;
        this.localNumber = number;
    }

    private static int compareStrings(String s1, String s2){
        char[] s1array = s1.toCharArray(), s2array = s2.toCharArray();
        int length = s1.length() >= s2.length() ? s2.length() : s1.length();
        for (int i=0; i < length; i++){
            if (s1array[i] < s2array[i])
                return -1;
            if (s1array[i] > s2array[i])
                return 1;
        }

        if (s1.length() < s2.length())
            return -1;
        else if (s1.length() == s2.length())
            return 0;
        else
            return 1;
    }

    @Override
    public int compareTo(TelephoneNumber other){
        return compareStrings(
            this.countryCode.concat(this.localNumber),
            other.countryCode.concat(other.localNumber)
        );
    }

    public String toString(){
        return this.countryCode + " " + this.localNumber;
    }

    public static TelephoneNumber fromString(String number){
        String code = "", local = "";
        if (!number.contains(" ")){
            if (!number.startsWith("+")){
                code += "+";
                code += number.substring(0, DEFAULT_CODE_LENGTH);
            } else {
                code += number.substring(0, DEFAULT_CODE_LENGTH+1);
            }
            local = number.substring(DEFAULT_CODE_LENGTH+1, number.length());
        } else {
            code = number.substring(0, number.indexOf(' '));
            local = number.substring(number.indexOf(' '), number.length());
        }
        return new TelephoneNumber(code, local);
    }
}