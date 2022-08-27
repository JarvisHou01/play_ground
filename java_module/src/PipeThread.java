import java.io.*;
 
class Writer extends Thread {
	private PipedOutputStream pos;
 
	public Writer(PipedOutputStream pos) {
		this.pos = pos;
	}
 
	public void run() {
		PrintStream p = new PrintStream(pos);
		for (int i = 1; i < 11; i++) {
			try {
				Thread.currentThread().sleep(250);
			} catch (Exception e) {
			}
			p.println(i);
			System.out.println("Write：" + i);
		}
		System.out.println("已经写入完毕");
		p.flush();
		p.close();
	}
}
 
class Reader extends Thread {
	private PipedInputStream pis;
	private String line;
 
	public Reader(PipedInputStream pis) {
		this.pis = pis;
	}
 
	public void run() {
		BufferedReader r = new BufferedReader(new InputStreamReader(pis));
		try {
			do {
				line = r.readLine();
				if (line != null)
					System.out.println("Read:" + line);
				else
					System.out.println("已经读取完毕");
				Thread.currentThread().sleep(500);
			} while (r != null && line != null);
		} catch (Exception e) {
		}
	}
}
 
public class PipeThread {
	public static void main(String args[]) throws IOException {
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream(pos);
		new Writer(pos).start();
		new Reader(pis).start();
	}
}