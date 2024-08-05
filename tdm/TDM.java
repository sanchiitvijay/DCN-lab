import java.util.Scanner;

public class TDM{
    public static void main(String args[]){

        int numberOfStations, i, frameSize, completedStations = 0, timeQuantum, totalProcessingTime = 0;
        int[] processingTime, waitingTime, turnaroundTime, remainingTime;
        
        // float averageWaitingTime, averageTurnaroundTime;

        processingTime = new int[10];
        waitingTime = new int[10];
        turnaroundTime = new int[10];
        remainingTime = new int[10];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of stations (maximum 10) = ");
        numberOfStations = sc.nextInt();
        System.out.print("Enter the processing time for each channel\n");

        for (i = 0; i < numberOfStations; i++){
            System.out.print("S" + i + " = ");
            processingTime[i] = sc.nextInt();
            remainingTime[i] = processingTime[i];
        }

        System.out.print("Enter the frame size: ");
        frameSize = sc.nextInt();
        
        while(true){
            for (i = 0, completedStations = 0; i < numberOfStations; i++){
                timeQuantum = frameSize;
                if(remainingTime[i] == 0){
                    completedStations++;
                    continue;
                }

                if(remainingTime[i] > frameSize)
                    remainingTime[i] -= frameSize;
                else {
                    if(remainingTime[i] >= 0){
                        timeQuantum = remainingTime[i];
                        remainingTime[i] = 0;
                    }
                }
                totalProcessingTime += timeQuantum;
                turnaroundTime[i] = totalProcessingTime;
            }

            if(numberOfStations == completedStations)
                break;
        }

        System.out.print("------------------------------------------------------------------------------");
        System.out.print("\nStation\t Processing Time\t Completion Time\t Waiting Time\n");
        System.out.print("------------------------------------------------------------------------------");

        for(i = 0; i < numberOfStations; i++) {
            waitingTime[i] = turnaroundTime[i] - processingTime[i];
            // averageWaitingTime += waitingTime[i];
            // averageTurnaroundTime += turnaroundTime[i];
            System.out.print("\n \t" + (i + 1) + "\t \t" + processingTime[i] + "\t\t " + turnaroundTime[i] + "\t\t\t " + waitingTime[i] + "\n");
        }
    }
}
