package MiniWeb.mini.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String UserId;
	private String UserPwd;
	private String UserName;
	private String UserEmail;
	private int UserPhone;
	private String UserGrade;

}
