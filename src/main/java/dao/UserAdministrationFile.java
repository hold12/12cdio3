package dao;

import logindto.User;

import java.util.List;

/**
 * Created by freya on 14-02-2017.
 */
@SuppressWarnings("ALL")
public class UserAdministrationFile implements IUserAdministration {
    //TODO: Implement after implementation of UserAdministrationDB.

    @Override
    public String[] getUserRoles() throws DataAccessException {
        return new String[0];
    }

    @Override
    public User getUser(int userId) throws DataAccessException {
        return null;
    }

    @Override
    public User getUser(String username) throws DataAccessException {
        return null;
    }

    @Override
    public List<User> getUserList() throws DataAccessException {
        return null;
    }

    @Override
    public void createUser(User user) throws DataAccessException {

    }

    @Override
    public void updateUser(User user) throws DataAccessException {

    }

    @Override
    public void deleteUser(int userId) throws DataAccessException {

    }
}
