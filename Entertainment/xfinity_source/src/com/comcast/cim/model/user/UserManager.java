// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user;

import com.comcast.cim.cmasl.utils.executor.ExceptionHandlingSingleThreadExecutor;
import com.comcast.cim.model.user.service.UserSaveTask;
import com.comcast.cim.model.user.service.UserSettings;
import com.comcast.cim.model.user.service.UserSettingsDao;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.comcast.cim.model.user:
//            CurrentUser, UserDao, User

public abstract class UserManager
{
    public static interface UserManagerListener
    {

        public abstract void onUserChanged(User user, UserSettings usersettings);

        public abstract void onUserLoaded(User user, UserSettings usersettings);

        public abstract void onUserLoggedIn(User user, UserSettings usersettings);

        public abstract void onUserLoggedOut();
    }


    private final CurrentUser currentUser;
    private final Set listeners = Collections.synchronizedSet(new HashSet());
    private User loggedInUser;
    private UserSettings loggedInUserSettings;
    private ExceptionHandlingSingleThreadExecutor saveUserExecutor;
    private final UserDao userDao;
    private final UserSettingsDao userSettingsDao;

    public UserManager(UserDao userdao, UserSettingsDao usersettingsdao, CurrentUser currentuser, ExceptionHandlingSingleThreadExecutor exceptionhandlingsinglethreadexecutor)
    {
        userDao = userdao;
        userSettingsDao = usersettingsdao;
        currentUser = currentuser;
        saveUserExecutor = exceptionhandlingsinglethreadexecutor;
    }

    private UserSaveTask createUserSaveTask(User user, UserSettings usersettings)
    {
        return new UserSaveTask(this, user, usersettings);
    }

    private void loadCurrentUser()
    {
        User user = null;
        Object obj = null;
        Object obj1 = currentUser.getKey();
        UserSettings usersettings = obj;
        if (obj1 != null)
        {
            obj1 = userDao.get(((String) (obj1)));
            user = ((User) (obj1));
            usersettings = obj;
            if (obj1 != null)
            {
                usersettings = userSettingsDao.get(((User) (obj1)));
                user = ((User) (obj1));
            }
        }
        loggedInUser = user;
        loggedInUserSettings = usersettings;
        if (loggedInUser != null)
        {
            onUserLoaded(user, usersettings);
        }
    }

    private void onUserLoaded(User user, UserSettings usersettings)
    {
        Set set = listeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((UserManagerListener)iterator.next()).onUserLoaded(user, usersettings)) { }
        break MISSING_BLOCK_LABEL_53;
        user;
        set;
        JVM INSTR monitorexit ;
        throw user;
        set;
        JVM INSTR monitorexit ;
    }

    public void addUserManagerListener(UserManagerListener usermanagerlistener)
    {
        listeners.add(usermanagerlistener);
    }

    public String getHashedOmnitureGuid()
    {
        Object obj = getUser();
        if (obj == null)
        {
            obj = "";
        } else
        {
            String s = ((User) (obj)).getOmnitureTrackingKey();
            obj = s;
            if (s == null)
            {
                return "";
            }
        }
        return ((String) (obj));
    }

    public User getUser()
    {
        this;
        JVM INSTR monitorenter ;
        User user;
        if (loggedInUser == null)
        {
            loadCurrentUser();
        }
        user = loggedInUser;
        this;
        JVM INSTR monitorexit ;
        return user;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public UserSettings getUserSettings()
    {
        this;
        JVM INSTR monitorenter ;
        if (loggedInUserSettings == null)
        {
            throw new IllegalStateException("UserSettings for the logged in User is null");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        UserSettings usersettings = loggedInUserSettings;
        this;
        JVM INSTR monitorexit ;
        return usersettings;
    }

    public void onUserChanged(User user, UserSettings usersettings)
    {
        Set set = listeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((UserManagerListener)iterator.next()).onUserChanged(user, usersettings)) { }
        break MISSING_BLOCK_LABEL_53;
        user;
        set;
        JVM INSTR monitorexit ;
        throw user;
        set;
        JVM INSTR monitorexit ;
    }

    public void onUserLoggedIn(User user, UserSettings usersettings)
    {
        Set set = listeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((UserManagerListener)iterator.next()).onUserLoggedIn(user, usersettings)) { }
        break MISSING_BLOCK_LABEL_53;
        user;
        set;
        JVM INSTR monitorexit ;
        throw user;
        set;
        JVM INSTR monitorexit ;
    }

    public void onUserLoggedOut()
    {
        Set set = listeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((UserManagerListener)iterator.next()).onUserLoggedOut()) { }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        set;
        JVM INSTR monitorexit ;
    }

    public void saveUser(User user, UserSettings usersettings)
    {
        this;
        JVM INSTR monitorenter ;
        if (user == null || usersettings == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        userDao.put(user);
        userSettingsDao.put(user, usersettings);
        this;
        JVM INSTR monitorexit ;
        return;
        user;
        this;
        JVM INSTR monitorexit ;
        throw user;
    }

    public void saveUserAsync()
    {
        saveUserExecutor.submit(createUserSaveTask(loggedInUser, loggedInUserSettings));
    }

    public void setUser(User user)
    {
        this;
        JVM INSTR monitorenter ;
        String s = user.getUserKey();
        String s1 = currentUser.setKey(s);
        userDao.put(user);
        UserSettings usersettings = userSettingsDao.get(user);
        loggedInUser = user;
        loggedInUserSettings = usersettings;
        if (!s.equals(s1))
        {
            onUserChanged(user, usersettings);
        }
        onUserLoggedIn(user, usersettings);
        this;
        JVM INSTR monitorexit ;
        return;
        user;
        this;
        JVM INSTR monitorexit ;
        throw user;
    }

    public void signOutUser()
    {
        currentUser.forget();
        loggedInUser = null;
        onUserLoggedOut();
    }
}
