package MiniWeb.mini.service;

import MiniWeb.mini.domain.User;

public interface UserEnrollService {
	public boolean confirmDuplicationId(String targetId);
	public boolean enrollUser(User targetUser);
}
