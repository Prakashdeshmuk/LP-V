import mpi.*;
import java.util.Random;

public class PracMPI {
    public static void main(String args[]) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size(); 
        int[] send = null;
        int n = 8; 
        int chunkSize = n / size;
        int[] recv = new int[chunkSize];
        if (rank == 0) {
            send = new int[]{1,2,3,4,5,6,7,8};

        } else {
            send = new int[n]; // dummy array for other processes
        }
        MPI.COMM_WORLD.Scatter(send, 0, chunkSize, MPI.INT,
             recv, 0, chunkSize, MPI.INT, 0);
        int sum = 0;
        for (int i = 0; i < recv.length; i++) {
            sum += recv[i];
        }
        System.out.println("Process " + rank + " Sum: " + sum);
        MPI.Finalize();
    }
}