// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication.xip;

import com.comcast.cim.android.authentication.AuthenticationStrategy;
import com.comcast.cim.model.user.UserManager;

public abstract class XipAuthStrategy
    implements AuthenticationStrategy
{

    private final UserManager userManager;

    public boolean isAuthenticated()
    {
        return userManager.getUser() != null;
    }
}
