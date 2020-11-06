package dothidothi;

public class Obj implements Cloneable{
	protected boolean isMedoid=false; // La tam hay k
	protected Double distance; // Khoang cach den tam
	protected Obj medoid; // Tam
	protected Double xValue;
	protected Double yValue;
	protected Double cost; // Tong kc (neu la tam)
	public Obj clone() throws CloneNotSupportedException {
        Obj personCloned = (Obj) super.clone();
		if (this.medoid != null) {
			personCloned.medoid = this.medoid.clone();
		}
        return personCloned;
    }
	public Obj(Double x, Double y) {
		this.xValue = x;
		this.yValue = y;
		this.distance=distance();
	}

	public Obj(Double x, Double y, Obj medoid) {
		this.xValue = x;
		this.yValue = y;
		this.medoid = medoid;
		this.isMedoid = false;
		this.distance=distance();
	}

	private Double distance() {
		return this.medoid == null ? null
				: Math.abs(medoid.xValue - this.xValue) + Math.abs(medoid.yValue - this.yValue);
	}
	
	public boolean equals(Obj obj) {
		return (this.xValue == obj.xValue && this.yValue == obj.yValue);
	}
	// GET/SET
	public boolean isMedoid() {
		return isMedoid;
	}

	public void setMedoid(boolean isMedoid) {
		this.isMedoid = isMedoid;
	}

	public Double getDistance() {
		return this.medoid == null ? null
				: Math.abs(medoid.xValue - this.xValue) + Math.abs(medoid.yValue - this.yValue);
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Obj getMedoid() {
		return medoid;
	}

	public void setMedoid(Obj medoid) {
		this.medoid = medoid;
	}

	public Double getxValue() {
		return xValue;
	}

	public void setxValue(Double xValue) {
		this.xValue = xValue;
	}

	public Double getyValue() {
		return yValue;
	}

	public void setyValue(Double yValue) {
		this.yValue = yValue;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}
