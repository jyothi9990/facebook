package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.facebook.daointerface.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebook.exception.ReservedWordException;

public class FacebookDAO implements FacebookDAOInterface {
        Connection con=null;
        public FacebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","jyothi");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
        }
        public int signUpProfileDAO(FacebookUser fu) {
        	int i=0;
			try {
				if(fu.getName().equals("Facebook"))  {throw new ReservedWordException();}
			PreparedStatement ps=con.prepareStatement("insert into facebook values(?,?,?,?)");
			ps.setString(1,fu.getName());
			ps.setString(2,fu.getPassword());
			ps.setString(3,fu.getEmail());
			ps.setString(4,fu.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	    return i;

}
		
		
			
		public int deleteProfileDAO(FacebookUser fu) {
			int i=0;
			try {
				PreparedStatement ps=con.prepareStatement("delete from facebook where email=?");
				ps.setString(1,fu.getEmail());
				i=ps.executeUpdate();
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return i;
		}
		public FacebookUser viewProfileDAO(FacebookUser fu) {
			FacebookUser f=null;
			
			try {
				PreparedStatement ps=con.prepareStatement("select * from facebook where email=?");
				ps.setString(1,fu.getEmail());
				ResultSet res=ps.executeQuery();
				while(res.next()) {
					String n=res.getString(1);
					String p=res.getString(2);
					String e=res.getString(3);
					String a=res.getString(4);
					
					f=new FacebookUser();
					f.setName(n);
					f.setPassword(p);
					f.setEmail(e);
					f.setAddress(a);
					
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return f;
		}
		@Override
		public List<FacebookUser> viewAllProfilesDAO() {
			FacebookUser f=null;
			List<FacebookUser> ll=new ArrayList<FacebookUser>();
			try {
				PreparedStatement ps=con.prepareStatement("select * from facebook");
				
				ResultSet res=ps.executeQuery();
				while(res.next()) {
					String n=res.getString(1);
					String p=res.getString(2);
					String e=res.getString(3);
					String a=res.getString(4);
					
					f=new FacebookUser();
					f.setName(n);
					f.setPassword(p);
					f.setEmail(e);
					f.setAddress(a);
					ll.add(f);
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return ll;
			
		}
		
		public int editProfileDAO(FacebookUser fu) {
			int i=0;
			try {
				PreparedStatement ps=con.prepareStatement("update facebook set name=?,password=?,address=? where email=?");
				ps.setString(1,fu.getName());
				ps.setString(2,fu.getPassword());
				ps.setString(3,fu.getAddress());
				ps.setString(4,fu.getEmail());
				
				i=ps.executeUpdate();
		
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return i;
}
		
		public List<FacebookUser> searchProfileService(FacebookUser fu) {
	    
		FacebookUser f=null;
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from where name=?");
			ps.setString(1,fu.getName());
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				f=new FacebookUser();
				f.setName(n);
				f.setPassword(p);
				f.setEmail(e);
				f.setAddress(a);
				
				ll.add(f);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			return ll;
		}
		@Override
		public List<FacebookUser> searchProfileDAO(FacebookUser fu) {
			FacebookUser f=null;
			List<FacebookUser> ll=new ArrayList<FacebookUser>();
			try {
			 PreparedStatement ps=con.prepareStatement("select * from facebook where name=?");
			 ps.setString(1,fu.getName());
			 ResultSet res=ps.executeQuery();
			 while(res.next()) {
				 String n=res.getString(1);
					String p=res.getString(2);
					String e=res.getString(3);
					String a=res.getString(4);
					
					f=new FacebookUser();
					f.setName(n);
					f.setPassword(p);
					f.setEmail(e);
					f.setAddress(a);
					
					ll.add(f);
			 }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return ll;
		}
		
		
		public FacebookUser signInProfileDAO(FacebookUser fu) {
			FacebookUser f=null;
			try {
				PreparedStatement ps=con.prepareStatement("select * from facebook where email=? and password=?");
				ps.setString(1,fu.getEmail());
				ps.setString(2,fu.getPassword());
				ResultSet res=ps.executeQuery();
				if(res.next()) {
					String n=res.getString(1);
					String p=res.getString(2);
					String e=res.getString(3);
					String a=res.getString(4);
					f=new FacebookUser();
					f.setName(n);
					f.setPassword(p);
					f.setEmail(e);
					f.setAddress(a);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return f;
		}
		
		public int createTimelineDAO(TimelineDetails tld) {
			int i=0;
			try {
				PreparedStatement ps=con.prepareStatement("insert into TimelineDetails values(?,?,?,?)");
				ps.setString(1,tld.getMessageid());
				ps.setString(2,tld.getSender());
				ps.setString(3,tld.getReciever());
				ps.setString(4,tld.getMessage());
				i=ps.executeUpdate();
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return i;
		}
		
		
}
