import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner inp=new Scanner(System.in);
        BinarySearchTree bst=new BinarySearchTree();

        boolean status=true;
        do{
            System.out.println("Selamat datang di Password Manager!");
            System.out.println("Apa yang ingin anda lakukan?");
            System.out.println("1. Masukan akun baru");
            System.out.println("2. Lihat list akun yang telah ditambahkan");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda : ");
            int pilihan=inp.nextInt();
            System.out.println("");

            switch (pilihan){
                case 1:{
                    System.out.print("Masukan username : ");
                    String username=inp.next();
                    /*
                    System.out.print("Masukan password : ");
                    String password=inp.next();
                    System.out.print("Masukan nama situs : ");
                    String situs=inp.next();*/
                    bst.insert(username/*,password,situs*/);
                    System.out.println("\n");
                    break;
                }

                case 2:{
                    bst.inorder();
                    int loop=1;
                        do{
                            if (bst.root==null){
                              loop=2;
                            }
                            else{
                              System.out.println("\n\nApa yang ingin anda lakukan?");
                              System.out.println("1. Cari akun");
                              System.out.println("2. Edit akun");
                              System.out.println("3. Hapus akun");
                              System.out.println("4. Kembali");
                              System.out.print("Pilihan Anda : ");
                              int pilih=inp.nextInt();
                              System.out.println("");
      
                              switch (pilih){
                                  case 1:{
                                      System.out.print("Username: ");
                                      String cari=inp.next();
                                      boolean cek=bst.search(cari);
                                      if (cek==true){
                                        System.out.println("Username ditemukan");
                                      }
                                      else{
                                          System.out.println("Username tidak ditemukan");
                                      }
                                      System.out.println();
                                      bst.inorder();
                                      break;
                                  }
                                  case 2:{
                                      System.out.print("Username: ");
                                      String hapus=inp.next();
                                      //if (bst.search(hapus)==true){
                                        bst.delete(hapus);
                                        System.out.print("Username baru: ");
                                        String ganti=inp.next();
                                        bst.insert(ganti);
                                      /*}
                                      else{
                                          System.out.println("Username tidak ditemukan");
                                      }*/
                                      System.out.println();
                                      bst.inorder();
                                      break;
                                  }
                                  case 3:{
                                      System.out.print("Username: ");
                                      String hapus=inp.next();
                                      bst.delete(hapus);
                                      System.out.println();
                                      bst.inorder();
                                      break;
                                  }
                                  case 4:{
                                      loop=2;
                                      break;
                                  }
                                  default:{
                                      System.out.println("Pilihan tidak tersedia\n\n");
                                  }
                              }
                            }
                        }
                        while (loop!=2);
                    break;
                }

                case 3:{
                    status=false;
                    break;
                }

                default:{
                    System.out.println("Pilihan tidak tersedia\n\n");
                }
            }
        } 
        while (status!=false);
        System.out.println("Terima kasih telah menggunakan program ini");
    }
}
