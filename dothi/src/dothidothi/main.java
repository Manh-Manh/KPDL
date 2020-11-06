package dothidothi;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import org.jfree.ui.RefineryUtilities;

public class main {

	public static void main(String[] args) throws CloneNotSupportedException, IOException {
		readFile rf=new readFile();
		List<Obj> lstO=rf.read();
		final int k=5;
		int d=lstO.size()/k;
		List<Integer> lstM=new ArrayList<Integer>();
		for(int i=0;i<k;i++) {
			lstM.add(i*d);
		}
		kMedoid m = new kMedoid(lstO,lstM);
//		m.print();
		kMedoid c = null;
		try {
			c = m.doCluster(m).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (c.doCluster(c) != null) {
			c = c.doCluster(c).clone();
		}
		System.out.println("Final:");
		c.print();
		chart t =new chart(c.getListObj(), c.getListMedoid());
		t.setVisible(true);
	}
}