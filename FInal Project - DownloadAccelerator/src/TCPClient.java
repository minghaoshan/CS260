import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The TCP client will: 1. Create 5 threads and a Socket object in each thread
 * 2. Each Socket object will request a connection to the corresponding Server's
 * thread 3. Once connection is established it will then accept a file partition
 * from the Server and save it onto the disk 4. Once all 5 threads are done
 * downloading: the client program will then merge these 5 downloaded partitions
 * into one file and save it onto the disk.
 * 
 * @author Minghao Shan
 * @version 11/22/2017
 */
public class TCPClient {
	// 5 thread downloads files into 5 separated files.

	/**
	 * Create 5 threads and a Socket object in each thread
	 */
	public static void createThreads(String fileName) {
		Thread[] clientThreads = new Thread [5];
		int threadNum = 0;
		for (Thread t : clientThreads) {
			t = new Thread(new ClientThread(threadNum));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadNum ++;
		}
		mergeFile(fileName);
	}

	/**
     *
     */
	public static void mergeFile(String fileName) {
		BufferedWriter writer;
		for(int i = 0; i < 5 ; i ++) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader("part (" + i + ") " + fileName));
				writer = new BufferedWriter(new FileWriter(fileName, true));
				
				//read character by character and write them
				int fileSize = (int) Files.size(Paths.get("part (" + i + ") " + fileName));
				for(int j = 0; j < (fileSize); j ++) {
					char data = (char) reader.read();
					writer.write(data);
				}
				reader.close();
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}

	public static void main(String[] args) {
		String fileName = "test.txt";
		
		System.out.println("Client start!");
		createThreads(fileName);
		
	}
}
