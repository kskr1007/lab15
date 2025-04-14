public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){
        //edge case for null message
        if(message == null){
            return null;
        }
        //making char array
        char arr[] = message.toCharArray();
        //iterate through chars
        for(int i = 0; i<arr.length;i++){
            //mark start
            int startIndex = rotors[2].indexOf(arr[i]);
            //mark middle
            char middleTempChar = rotors[1].charAt(startIndex);
            //mark outer
            int outer = rotors[2].indexOf(middleTempChar);
            //decrypt
            arr[i] = rotors[0].charAt(outer);
            //rotate after every decryption
            rotate();
        }
        //create string
        String result = new String(arr);
        //return decrypted message
        return result;
    }


    
    public String encrypt(String message){
        //edge case for null message
        if(message == null){
            return null;
        }
        //make char array
        char arr[] = message.toCharArray();
        //iterate through chars
        for(int i = 0; i<arr.length;i++){
            //mark start
            int startIndex = rotors[0].indexOf(arr[i]);
            //mark outer
            char outerTempChar = rotors[2].charAt(startIndex);
            //mark middle
            int middle = rotors[1].indexOf(outerTempChar);
            //encrypt
            arr[i] = rotors[2].charAt(middle);
            //rotate after every encryption
            rotate();
        }
        //create string
        String result = new String(arr);
        //return encrypted message
        return result;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}