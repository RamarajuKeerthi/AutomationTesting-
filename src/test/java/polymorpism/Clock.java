package polymorpism;

public class Clock {
	int hr,mm,soc;
	
	public void SetClocks()
	{
		hr=10;
		mm=10;
		soc=10;
	}
	public void Setclock(int hr)
	{
		this.hr=hr;
	}
	public void Setclock(int hr,int mm)
	{
		this.hr=hr;
		this.hr=mm;
	}
	public void Setclock(int hr,int mm,int soc)
	{
		this.hr=hr;
		this.hr=mm;
		this.hr=soc;
	}
	public void Isdisplay()
	{
		System.out.format("Time is %02d;%02d;%02d",hr,mm,soc);
	}
}
