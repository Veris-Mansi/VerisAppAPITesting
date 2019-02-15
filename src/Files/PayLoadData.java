package Files;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PayLoadData {
//7248083876
	public static String correctCredentials()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\":\"9993483676\",\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
			return s;	
	}
	public static String incorrectCredentials9()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\":\"903511151\",\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
			return s;	
	}public static String incorrectCredentials11()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\":\"90351115111\",\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
			return s;	
	}public static String invalidCountrycode()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 33,\r\n" + 
				"  \"mobile_number\":\"9035111511\",\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
			return s;	
	}public static String emptyContactNumber()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\":\"\",\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
			return s;	
	}
	public static String VerifyOTPCredentials()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\": 9993483676,\r\n" + 
				"  \"otp_code\": 69052,\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
		return s;
	}public static String VerifyIncorrectOTPCredentials4()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\": 9993483676,\r\n" + 
				"  \"otp_code\": 8089,\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
		return s;
	}public static String VerifyIncorrectOTPCredentials6()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\": 9993483676,\r\n" + 
				"  \"otp_code\": 808985,\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
		return s;
	}public static String VerifyIncorrectOTPCredentials()
	{
		String s="{\r\n" + 
				"  \"dial_code\": 91,\r\n" + 
				"  \"mobile_number\": 9993483676,\r\n" + 
				"  \"otp_code\": 80498,\r\n" + 
				"  \"app_key\": \"j($scxgi195^rn+gn56@5z7fr^dc7hh=jb$ijvhux1o83mblr23bfi-31@a3!3f%hdx6q_88$tbkhd6&1=b50zpr!g%fd1j_7ago\",\r\n" + 
				"  \"app_secret\": \"sj4le$sag@mvxxtrzwt*pk%cf!fvs)4*^0zy5ws^*v82i44ljad4$1z)xb*5(rh_15!c&&da4*#a=#xndl&6hg%5pa7vmt2pq#@e+jx13=%p_kd9o4wx#&vsgye8l7&428^30ex2+!s==gm)vj4vculfv3dhu+9wh&gg%ym9i9)wk@!o-d#4*y$hwt5i3+m8!(o#m%0qwo1_52c=b4q+&-0$f!66f348gi8c)*1zgu47yd&idpk6**9)rx\"\r\n" + 
				"}";
		return s;
	}
	public static String getProfileData()
	{
		String token = "cd678e647599edc27b26812b405b7e7c27d3397b";
		//String token=Resource.verifyCorrectOTP();
		return token;
	}
	public static String getProfileIncorrectData()
	{
		String invalid_token="cd678e647599edc27b26812b405b7e7c27d3397";
		return invalid_token;
	}
}
