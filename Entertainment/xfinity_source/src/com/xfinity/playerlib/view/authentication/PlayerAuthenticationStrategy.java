// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.authentication;

import com.comcast.cim.android.authentication.AuthenticationStrategy;
import com.comcast.cim.model.user.UserManager;

// Referenced classes of package com.xfinity.playerlib.view.authentication:
//            PlayNowAuthenticationActivity

public class PlayerAuthenticationStrategy
    implements AuthenticationStrategy
{

    private final UserManager userManager;

    public PlayerAuthenticationStrategy(UserManager usermanager)
    {
        userManager = usermanager;
    }

    public Class getAuthenticationActivityClass()
    {
        return com/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;
    }

    public boolean isAuthenticated()
    {
        return userManager.getUser() != null;
    }
}
