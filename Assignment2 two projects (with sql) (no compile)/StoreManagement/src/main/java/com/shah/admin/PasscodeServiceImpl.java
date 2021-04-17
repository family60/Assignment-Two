package com.shah.admin;

import com.shah.entity.Passcode;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(PasscodeService.class)
public class PasscodeServiceImpl implements PasscodeService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean login(String code, boolean isAdminLogin) {
        Passcode passcode = (Passcode) em.createQuery("SELECT p from Passcode p where " +
                "p.passCode = :code")
                .setParameter("code", code)
                .getSingleResult();
        return passcode != null && !passcode.isAdmin() && passcode.getPassCode().equals(code);
    }
}
