// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user.service;

import com.comcast.cim.model.user.User;
import com.comcast.cim.model.user.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.model.user.service:
//            UserSettings

public class UserSaveTask
    implements Runnable
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/model/user/service/UserSaveTask);
    private User user;
    UserManager userManager;
    private UserSettings userSettings;

    public UserSaveTask(UserManager usermanager, User user1, UserSettings usersettings)
    {
        userManager = usermanager;
        user = user1;
        userSettings = usersettings;
    }

    public void run()
    {
        userManager.saveUser(user, userSettings);
    }

}
