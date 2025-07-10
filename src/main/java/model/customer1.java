package model;

public class customer1 
{
	private int user_id;
	private int user_ps;
    private String user_name;
    private String user_email;
    private static int currentUserId;
    
    
    public customer1() {
		super();
		this.user_id = user_id;
		this.user_ps = user_ps;
		this.user_name = user_name;
		this.user_email = user_email;
	}


	public int getUser_id() 
    {
        return user_id;
    }

    public void setUser_id(int user_id) 
    {
        this.user_id = user_id;
    }

    public int getUser_ps() 
    {
        return user_ps;
    }

    public void setUser_ps(int user_ps)
    {
        this.user_ps = user_ps;
    }

    public String getUser_name()
    {
        return user_name;
    }

    public void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }

    public String getUser_email() 
    {
        return user_email;
    }

    public void setUser_email(String user_email) 
    {
        this.user_email = user_email;
    }

    public static void setCurrentUserId(int id) 
    {
        currentUserId = id;
    }

    public static int getCurrentUserId() 
    {
        return currentUserId;
    }

	@Override
	public String toString() {
		return "customer [user_id=" + user_id + ", user_ps=" + user_ps + ", user_name=" + user_name + ", user_email="
				+ user_email + "]";
	}
    

}
