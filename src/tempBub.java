
public class tempBub {
	int Xpos;
	int Ypos;
	int isBurst;
	
	tempBub(){
		Xpos = -1;
		Ypos = -1;
		isBurst = 2;
	}
	
	public void changeloc(int x, int y) {
		Xpos = x;
		Ypos = y;
		if(x==-1 && y==-1)
			isBurst = 1;
		else
			isBurst = 0;
	}

}
