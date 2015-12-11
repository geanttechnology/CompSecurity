// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.user;

import com.comcast.cim.model.user.service.UserSettings;

// Referenced classes of package com.comcast.cim.model.user:
//            UserManager, User

public static interface 
{

    public abstract void onUserChanged(User user, UserSettings usersettings);

    public abstract void onUserLoaded(User user, UserSettings usersettings);

    public abstract void onUserLoggedIn(User user, UserSettings usersettings);

    public abstract void onUserLoggedOut();
}
