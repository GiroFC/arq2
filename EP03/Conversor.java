import java.io.*;
import java.util.*;

class Conversor{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new FileReader("Ar.txt"));
        try (RandomAccessFile raf = new RandomAccessFile("Arhex.hex","rw")) {
            int X = 0,Y = 0,W = 0;

            try{
                String line = sc.nextLine();
                while(sc.hasNextLine() && !line.equals("fim.")){
                    line = sc.nextLine();
                    if(line.contains("X=")){
                        line = line.replaceAll("X=", "");
                        line = line.replaceAll(";", "");
                        X = Integer.parseInt(line,16);
                    }

                    else if(line.contains("Y=")){
                        line = line.replaceAll("Y=", "");
                        line = line.replaceAll(";", "");
                        Y = Integer.parseInt(line,16);
                    }
                    
                    else if(line.contains("W=")){
                        line = line.replaceAll("W=", "");
                        line = line.replaceAll(";", "");
                        int codigo = 0;

                        if(line.equals("A'") || line.equals("An")){
                            W = ~ -(X) ;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 0;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("nAoB")){
                            W = -~ (X | Y);
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 1;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("AnB")){
                            W = ~ (X) & Y;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 2;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("zeroL")){
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 3;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("nAeB")){
                            W = -~ (X & Y);
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 4;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("Bn")){
                            W = ~ -Y;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 5;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("AxB")){
                            W = X ^ Y;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(X).toUpperCase();
                            codigo = 6;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("ABn")){
                            W = X & ~(Y);
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(X).toUpperCase();
                            codigo = 7;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("AnoB")){
                            W = (~X) & Y;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 8;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("nAxB")){
                            W = (~ -(X ^ Y));
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 9;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("copiaB") || line.equals("B")){
                            W = Y;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 10;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");        
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("AB")){
                            W = X & Y;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 11;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("umL")){
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 12;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("AoBn")){
                            W = X | (~Y);
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(X).toUpperCase();
                            codigo = 13;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }

                        else if(line.equals("AoB") || line.equals("A+B")){
                            W = X | Y;
                            line = Integer.toHexString(W);

                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 14;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }                    

                        else if(line.equals("copiaA") || line.equals("A")  ){
                            W = X;
                            line = Integer.toHexString(W);
                            
                            String hexaX = Integer.toHexString(X).toUpperCase();
                            String hexaY = Integer.toHexString(Y).toUpperCase();
                            codigo = 15;
                            String hexacodigo = Integer.toHexString(codigo).toUpperCase();

                            raf.writeUTF(hexaX + hexaY + hexacodigo + "\n");
                            System.out.println(hexaX + hexaY + hexacodigo);
                        }                   
                      }
                    }
                }catch(IOException e){
                    System.out.println("Erro na escrita");
                }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}