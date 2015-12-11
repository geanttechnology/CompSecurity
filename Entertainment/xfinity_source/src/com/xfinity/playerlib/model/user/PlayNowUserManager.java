// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.user;

import com.comcast.cim.android.authentication.UserCredentials;
import com.comcast.cim.cmasl.utils.executor.ExceptionHandlingSingleThreadExecutor;
import com.comcast.cim.model.user.AuthKeys;
import com.comcast.cim.model.user.CurrentUser;
import com.comcast.cim.model.user.XipUser;
import com.comcast.cim.model.user.XipUserManager;
import com.comcast.cim.model.user.service.UserSettingsDao;
import com.xfinity.playerlib.model.user.service.PlayNowUserDao;

// Referenced classes of package com.xfinity.playerlib.model.user:
//            PlayNowUser

public class PlayNowUserManager extends XipUserManager
{

    public PlayNowUserManager(PlayNowUserDao playnowuserdao, UserSettingsDao usersettingsdao, CurrentUser currentuser, ExceptionHandlingSingleThreadExecutor exceptionhandlingsinglethreadexecutor)
    {
        super(playnowuserdao, usersettingsdao, currentuser, exceptionhandlingsinglethreadexecutor);
    }

    public volatile XipUser createUser(UserCredentials usercredentials, AuthKeys authkeys)
    {
        return createUser(usercredentials, authkeys);
    }

    public PlayNowUser createUser(UserCredentials usercredentials, AuthKeys authkeys)
    {
        return new PlayNowUser(usercredentials, authkeys);
    }
}
