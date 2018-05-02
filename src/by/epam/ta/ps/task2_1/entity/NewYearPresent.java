package by.epam.ta.ps.task2_1.entity;

import java.util.ArrayList;
import java.util.List;

public class NewYearPresent {
	private List<Sweets> presents = new ArrayList<Sweets>();
	
	public NewYearPresent(){
	}
	
	public void add(Sweets present){
		presents.add(present);
	}
	
	public void remove(Sweets present){
		presents.remove(present);
	}

	public List<Sweets> getPresent() {
		return presents;
	}

	public void setPresents(List<Sweets> presents) {
		this.presents = presents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((presents == null) ? 0 : presents.hashCode());
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
		NewYearPresent other = (NewYearPresent) obj;
		if (presents == null) {
			if (other.presents != null)
				return false;
		} else if (!presents.equals(other.presents))
			return false;
		return true;
	}
	
	

}
