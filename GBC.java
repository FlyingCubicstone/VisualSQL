package Win_SQL;

import java.awt.GridBagConstraints;

public class GBC extends GridBagConstraints{
	public GBC(int grid_x,int grid_y){
		this.gridx=grid_x;
		gridy=grid_y;
	}
	public GBC setAnchor(int anchor){
		this.anchor=anchor;
		return this;
	}
	public GBC setWeigth(int weightx,int weighty){
		this.weightx=weightx;
		this.weighty=weighty;
		return this;
	}
	public GBC setFill(int fill){
		this.fill=fill;
		return this;
	}
}
