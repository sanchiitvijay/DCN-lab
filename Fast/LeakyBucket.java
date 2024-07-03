import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter bucket size and rate: ");
        int bucket_cap = sc.nextInt();  
        int rate = sc.nextInt();        

        System.out.print("\nEnter no. of packets: ");
        int n = sc.nextInt();          
        int[] packets = new int[n];     
        System.out.println("Enter size of packets:");
        for (int i = 0; i < n; ++i) {
            System.out.print("\tpacket[" + (i + 1) + "]: ");
            packets[i] = sc.nextInt();  
        }

        int bucket_rem = 0; 
        for (int i = 0; i < n; ++i) {
            int packetSize = packets[i];
            boolean packetDropped = false;
            
            if (packetSize + bucket_rem > bucket_cap) {
                packetDropped = true;
            } else {
                bucket_rem += packetSize;
            }

            int sent = Math.min(bucket_rem, rate);
            bucket_rem -= sent;

            System.out.println("\nPacket[" + (i + 1) + "]: " + packetSize);
            if (packetDropped) {
                System.out.println("Packet dropped!!");
            } else {
                System.out.println("Received: " + packetSize);
                System.out.println("Sent: " + sent);
                System.out.println("Remaining: " + bucket_rem);
            }
        }
        
        sc.close();
    }
}
