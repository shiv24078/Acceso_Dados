
/**
 * U1EX01 - Un programa que accede a un fichero de texto mediante las clases de Java
 *
 * @author Shiv Alamchandani
 * @date 07/10/2023
 * Instruciones: Run el .java directamente en VSCode
 * java version "21" 2023-09-19 LTS
   Java(TM) SE Runtime Environment (build 21+35-LTS-2513)
   Java HotSpot(TM) 64-Bit Server VM (build 21+35-LTS-2513, mixed mode, sharing)
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccessY4609624R {
    // Constantes
    public static final String READ_ERROR = "YOU CAN NOT READ THE FILE";
    public static final String WRITE_ERROR = "YOU CAN NOT WRITE TO THE FILE";
    public static final String path = "srcY4609624R.txt";
    public static final String texto = "Activadad 1 Shiv";
    public static final String starting_message = "- Empezando a acceder al fichero";
    public static final String ending_message = "- Acabado de acceder al fichero";

    // Clase principal
    public class Execute {

        public static void main(String[] args) throws IOException {
            try {
                // Crear el fichero
                File newFile = new File(path);
                if (newFile.createNewFile()) {
                    System.out.println("File created: " + newFile.getName());
                }
                // Acceder al fichero con las diferentes clases
                System.out.println(starting_message + " con FileWriter");
                AccessFileWriterY4609624R fileWriter = new AccessY4609624R().new AccessFileWriterY4609624R();
                fileWriter.FileWriter(path, texto);
                System.out.println(ending_message);
                System.out.println(starting_message + " con FileReader");
                AccessFileReaderY4609624R fileReader = new AccessY4609624R().new AccessFileReaderY4609624R();
                fileReader.FileReader(path);
                System.out.println(ending_message);
                System.out.println(starting_message + " con FileInputStream");
                AccessFileInputStream fileInputStream = new AccessY4609624R().new AccessFileInputStream();
                fileInputStream.FileInputStream(path);
                System.out.println(ending_message);
                System.out.println(starting_message + " con FileOutputStream");
                AccessFileOutputStream fileOutputStream = new AccessY4609624R().new AccessFileOutputStream();
                fileOutputStream.FileOutputStream(path);
                System.out.println(ending_message);
                System.out.println(starting_message + " con RandomAccessFile");
                RandomAccessFile randomAccessFile = new AccessY4609624R().new RandomAccessFile();
                randomAccessFile.AccessRandomAccessFile(path);
                System.out.println(ending_message);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    // Metodo para comprobar los permisos
    public boolean checkPermission(File file, String type) {
        if ("read".equals(type)) {
            return file.canRead();
        } else if ("write".equals(type)) {
            return file.canWrite();
        } else {
            return false;
        }
    }
    // Clases para acceder al fichero

    class AccessFileWriterY4609624R {
        public void FileWriter(String ruta, String texto) throws IOException {
            File file = new File(ruta);
            FileWriter fileWriter = null;
            try {
                if (!checkPermission(file, "write")) {
                    throw new SecurityException(WRITE_ERROR);
                }
                fileWriter = new FileWriter(file);
                fileWriter.write(texto);
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            } catch (IOException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
        }
    }

    class AccessFileReaderY4609624R {
        public void FileReader(String ruta) throws IOException {
            File file = new File(ruta);
            if (!checkPermission(file, "read")) {
                System.out.println(READ_ERROR);
            }
            FileReader fileReader = null;
            BufferedReader bf = null;
            try {
                fileReader = new FileReader(file);
                bf = new BufferedReader(fileReader);
                String linea = bf.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = bf.readLine();
                }
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            } catch (IOException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                fileReader.close();
                bf.close();
            }
        }
    }

    class AccessFileInputStream {
        public void FileInputStream(String ruta) throws IOException {
            FileInputStream fis = null;
            if (!checkPermission(new File(ruta), "read")) {
                System.out.println(READ_ERROR);
            }
            try {
                fis = new FileInputStream(ruta);
                byte[] data = new byte[(int) fis.available()];
                fis.read(data);
                String content = new String(data);
                System.out.println(content);
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            } catch (IOException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }
        }
    }

    class AccessFileOutputStream {
        public void FileOutputStream(String ruta) throws IOException {
            String content = "Actividad 1 Shiv-outputstream";
            java.io.FileOutputStream fos = null;
            if (!checkPermission(new File(ruta), "write")) {
                System.out.println(WRITE_ERROR);
            }
            try {
                fos = new java.io.FileOutputStream(ruta);
                byte[] data = content.getBytes();
                fos.write(data);
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            } catch (IOException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (fos != null) {
                    fos.close();
                }
            }
        }
    }

    class RandomAccessFile {
        public void AccessRandomAccessFile(String ruta) throws IOException {
            String content = "Actividad 1 Shiv-randommethod";
            java.io.RandomAccessFile raf = null;
            if (!checkPermission(new File(ruta), "write")) {
                System.out.println(WRITE_ERROR);
            }
            try {
                raf = new java.io.RandomAccessFile(ruta, "rw");
                raf.writeUTF(content);
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            } catch (IOException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (raf != null) {
                    raf.close();
                }
            }

        }
    }

}
