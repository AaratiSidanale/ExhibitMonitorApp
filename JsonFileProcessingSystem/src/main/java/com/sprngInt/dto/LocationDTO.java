package com.sprngInt.dto;

public class LocationDTO {
	 private String _id;

	    private String state;

	    private String[] loc;

	    private String pop;

	    private String city;

	    public String get_id ()
	    {
	        return _id;
	    }

	    public void set_id (String _id)
	    {
	        this._id = _id;
	    }

	    public String getState ()
	    {
	        return state;
	    }

	    public void setState (String state)
	    {
	        this.state = state;
	    }

	    public String[] getLoc ()
	    {
	        return loc;
	    }

	    public void setLoc (String[] loc)
	    {
	        this.loc = loc;
	    }

	    public String getPop ()
	    {
	        return pop;
	    }

	    public void setPop (String pop)
	    {
	        this.pop = pop;
	    }

	    public String getCity ()
	    {
	        return city;
	    }

	    public void setCity (String city)
	    {
	        this.city = city;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [_id = "+_id+", state = "+state+", loc = "+loc+", pop = "+pop+", city = "+city+"]";
	    }
}
