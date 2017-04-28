package com.note.goodluckskeleton;

public class SkeleCount implements ISkeleCount {

	private int skele_count = 0;
	
	@Override
	public void add() {
		if(this.skele_count < 5) {
			this.skele_count++;
		}
	}

	@Override
	public void sub() {
		if(this.skele_count > 0) {
			this.skele_count--;
		}
	}
	
	@Override
	public void set(int count) {
		this.skele_count = count;
	}


	@Override
	public int getCount() {
		return this.skele_count;
	}

}
