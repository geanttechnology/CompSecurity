// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user;

import com.comcast.cim.android.authentication.UserCredentials;
import com.comcast.cim.cmasl.utils.executor.ExceptionHandlingSingleThreadExecutor;
import com.comcast.cim.model.user.service.UserSettingsDao;

// Referenced classes of package com.comcast.cim.model.user:
//            UserManager, UserDao, CurrentUser, AuthKeys, 
//            XipUser

public abstract class XipUserManager extends UserManager
{

    public XipUserManager(UserDao userdao, UserSettingsDao usersettingsdao, CurrentUser currentuser, ExceptionHandlingSingleThreadExecutor exceptionhandlingsinglethreadexecutor)
    {
        super(userdao, usersettingsdao, currentuser, exceptionhandlingsinglethreadexecutor);
    }

    public abstract XipUser createUser(UserCredentials usercredentials, AuthKeys authkeys);
}
