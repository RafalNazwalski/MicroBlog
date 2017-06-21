package pl.microblog.model;

public class Follower {
	
	private Integer Idfollower;
	private Integer Idfollowee;
	
	public Follower(){
	}
	
	public Follower(Integer idfollower, Integer idfollowee) {
		Idfollower = idfollower;
		Idfollowee = idfollowee;
	}
	public Integer getIdfollower() {
		return Idfollower;
	}
	public void setIdfollower(Integer idfollower) {
		Idfollower = idfollower;
	}
	public Integer getIdfollowee() {
		return Idfollowee;
	}
	public void setIdfollowee(Integer idfollowee) {
		Idfollowee = idfollowee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Idfollowee == null) ? 0 : Idfollowee.hashCode());
		result = prime * result + ((Idfollower == null) ? 0 : Idfollower.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follower other = (Follower) obj;
		if (Idfollowee == null) {
			if (other.Idfollowee != null)
				return false;
		} else if (!Idfollowee.equals(other.Idfollowee))
			return false;
		if (Idfollower == null) {
			if (other.Idfollower != null)
				return false;
		} else if (!Idfollower.equals(other.Idfollower))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Follower [Idfollower=" + Idfollower + ", Idfollowee=" + Idfollowee + "]";
	}
}
