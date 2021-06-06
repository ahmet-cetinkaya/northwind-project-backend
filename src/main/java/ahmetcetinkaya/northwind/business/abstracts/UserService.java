package ahmetcetinkaya.northwind.business.abstracts;

import ahmetcetinkaya.northwind.core.entities.User;
import ahmetcetinkaya.northwind.core.utilities.results.DataResult;
import ahmetcetinkaya.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);

	DataResult<User> getByEmail(String email);
}
