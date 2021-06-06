package ahmetcetinkaya.northwind.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.northwind.business.abstracts.UserService;
import ahmetcetinkaya.northwind.core.dataAccess.UserDao;
import ahmetcetinkaya.northwind.core.entities.User;
import ahmetcetinkaya.northwind.core.utilities.results.DataResult;
import ahmetcetinkaya.northwind.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.northwind.core.utilities.results.Result;
import ahmetcetinkaya.northwind.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	private UserDao userDao;

	@Autowired
	public UserManager(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result add(final User user) {
		userDao.save(user);

		return new SuccessResult("User has added.");
	}

	@Override
	public DataResult<User> getByEmail(final String email) {
		final Optional<User> user = userDao.findByEmail(email);

		if (user.isEmpty())
			return new ErrorDataResult<User>("User not found.");

		return new SuccessDataResult<User>(user.get());
	}

}
