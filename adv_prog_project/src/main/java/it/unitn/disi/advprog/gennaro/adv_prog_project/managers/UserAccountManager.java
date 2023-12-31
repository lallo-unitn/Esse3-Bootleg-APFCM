package it.unitn.disi.advprog.gennaro.adv_prog_project.managers;

import it.unitn.disi.advprog.gennaro.adv_prog_project.beans.UserAccountBean;
import it.unitn.disi.advprog.gennaro.adv_prog_project.entities.UserAccount;
import jakarta.ejb.*;
import jakarta.persistence.NoResultException;
import org.jboss.logging.Logger;

@Stateless
@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserAccountManager {
    private static final Logger logger = Logger.getLogger(StudentManager.class);

    @EJB
    private UserAccountBean userAccountBean;

    public UserAccount getUserAccountByCredentials(String username, String password) throws EJBTransactionRolledbackException {
        return userAccountBean.getUserAccountByCredentials(username, password);
    }

    public boolean addUserAccount(UserAccount userAccount) {
        return this.userAccountBean.addUserAccount(userAccount);
    }

}
