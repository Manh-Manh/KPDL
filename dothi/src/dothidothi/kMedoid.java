package dothidothi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class kMedoid implements Cloneable {
	public List<Obj> listObj = new ArrayList<Obj>();
	public List<Integer> listMedoid = new ArrayList<Integer>();
	private int k;
	private Double cost = Double.MAX_VALUE;
	private Double newCost = Double.MAX_VALUE;

	public void generateData() {
		this.listObj.add(new Obj(2d, 6d));
		this.listObj.add(new Obj(3d, 4d));
		this.listObj.add(new Obj(3d, 8d));
		this.listObj.add(new Obj(4d, 7d));
		this.listObj.add(new Obj(6d, 2d));
		this.listObj.add(new Obj(6d, 4d));
		this.listObj.add(new Obj(7d, 3d));
		this.listObj.add(new Obj(7d, 4d));
		this.listObj.add(new Obj(8d, 5d));
		this.listObj.add(new Obj(7d, 6d));
		if (this.listMedoid == null || this.listMedoid.size() == 0) {
			this.listMedoid.add(0);
			this.listMedoid.add(6);
			this.k = 2;
		}
	}

	public kMedoid(List<Obj> listObj, List<Integer> listMedoid) {
		this.listMedoid = listMedoid;
		this.listObj = listObj;
		this.k = listMedoid.size();
		this.medoids();
	}

	public kMedoid(List<Integer> listMedoid) {
		this.listMedoid = listMedoid;
		this.k = listMedoid.size();
		this.generateData();
		this.medoids();
	}

	public kMedoid() {
		this.generateData();
		this.medoids();
	}

	public kMedoid clone() throws CloneNotSupportedException {
		kMedoid personCloned = (kMedoid) super.clone();
		personCloned.listObj = this.cloneList(this.listObj);
		personCloned.listMedoid = (List) ((ArrayList<Integer>) this.listMedoid).clone();
		return personCloned;
	}

	public static List<Obj> cloneList(List<Obj> list) {
		List<Obj> clone = new ArrayList<Obj>(list.size());
		for (Obj item : list)
			try {
				clone.add(item.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return clone;
	}

	public static List<Integer> cloneListint(List<Integer> list) throws CloneNotSupportedException {
		List<Integer> clone = new ArrayList<Integer>();

		for (Integer item : list)
			clone.add(item);
		return clone;
	}

	private void doCluster2() {
		// TODO Auto-generated method stub
		kMedoid knew;
		List<Obj> listObjNew = new ArrayList<Obj>();
		List<Integer> listMedoidNew = new ArrayList<Integer>();
		for (Obj o : listObj) {
			listMedoidNew = new ArrayList<Integer>();
			for (int i : this.listMedoid) {
				listMedoidNew.add(i);
			}
			listObjNew = new ArrayList<Obj>();
			for (Obj oo : this.listObj) {
				listObjNew.add(oo);
			}

			if (!o.isMedoid) {
				for (int i : listMedoidNew) {
					Collections.replaceAll(listMedoidNew, i, listObjNew.indexOf(o));
					knew = new kMedoid(listMedoidNew);
					if (knew.getCost() < this.getCost()) {
						// gan lai tam
						this.listMedoid = new ArrayList<Integer>();
						this.listMedoid = knew.getListMedoid();
						// gan lai cost
						this.cost = knew.getCost();
						// this.doCluster();
						break;
					}
				}
			}
		}
	}

	// Phan cum
	public void medoids() {
		for (Obj o : listObj) {
			o.setMedoid(false);
			o.setMedoid(null);
		}
		// Gan tam
		for (int i : listMedoid) {
			Obj m = new Obj(listObj.get(i).getxValue(), listObj.get(i).getyValue());
			listObj.get(i).setMedoid(m);
			listObj.get(i).setMedoid(true);
		}
		// Tinh khoang cach va gan cum
		// Tam
		for (Obj obj : listObj) {
			if (obj.isMedoid) {
				obj.setDistance(0d);
				continue;
			}
			obj.setMedoid(listObj.get(listMedoid.get(0)));
			obj.setDistance(obj.getDistance());
			Double min = obj.getDistance();

			for (int i : listMedoid) {
				Obj Medoid = listObj.get(i);
				Obj m = new Obj(obj.getxValue(), obj.getyValue(), obj.getMedoid());
				if (m.getMedoid() != Medoid) {
					m.setMedoid(Medoid);
					if (m.getDistance() < min) {
						min = m.getDistance();
						obj.setMedoid(Medoid);
						obj.setDistance(m.getDistance());
					}
				}
			}
		}
		// Tinh cost
		double c = 0;
		for (Obj obj : listObj) {
			c += obj.getDistance();
		}
		this.cost = c;

	}

	public void print() {
		System.out.println("List Tam: ");
		for (int ii : listMedoid) {
			System.out.print(ii + "= (" + listObj.get(ii).getxValue() + ";" + listObj.get(ii).getyValue() + ")	");
		}
		System.out.println("");
		for (int i : listMedoid) {
			System.out.println("Tam " + listObj.get(i).getxValue() + ";" + listObj.get(i).getyValue() + " :");
			for (Obj obj : listObj) {
				if (obj.getMedoid().equals(listObj.get(i))) {
					System.out.print(" (" + obj.getxValue() + ";" + obj.getyValue() + "); ");

				}
			}
			System.out.println("");
		}
		System.out.println("\nCOST: " + this.getCost());
	}

	// GET?SET
	public List<Obj> getListObj() {
		return listObj;
	}

	public void setListObj(List<Obj> listObj) {
		this.listObj = listObj;
	}

	public List<Integer> getListMedoid() {
		return listMedoid;
	}

	public void setListMedoid(List<Integer> listMedoid) {
		this.listMedoid = listMedoid;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getNewCost() {
		return newCost;
	}

	public void setNewCost(Double newCost) {
		this.newCost = newCost;
	}

	//
	public kMedoid doCluster(final kMedoid kM) {
		System.out.println("###############################################");
		kM.print();
		System.out.println("###############################################");
		kMedoid knew = null;
		try {
			knew = kM.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Obj> listObjNew = new ArrayList<Obj>();
		List<Integer> listMedoidNew = new ArrayList<Integer>();
		listObjNew = new ArrayList<Obj>();
		for (Obj oo : knew.getListObj()) {
			listObjNew.add(oo);
		}
		int p = 0;
		for (Obj o : listObjNew) {
			listMedoidNew = new ArrayList<Integer>();
			if (!o.isMedoid) {

				for (int i : knew.getListMedoid()) {
					listMedoidNew = new ArrayList<Integer>();
					for (int ii : kM.getListMedoid()) {
						listMedoidNew.add(ii);
					}
					Collections.replaceAll(listMedoidNew, i, listObjNew.indexOf(o));
					knew = new kMedoid(listObjNew, listMedoidNew);
					System.out
							.println("Orandom= " + listObjNew.indexOf(o) + ": " + o.getxValue() + ";" + o.getyValue());
					System.out.println("Lap " + (++p));
					knew.print();
					System.out.println("--------------------------------------------");
					if (knew.getCost() < kM.getCost()) {
						System.out.println("********************************************");
						knew.print();
						System.out.println("*********************************************");
						return knew;
					}
				}
			}
			System.out.println("////////////////////////////////////////////////////////////////////////");
		}
		return null;
	}
}
