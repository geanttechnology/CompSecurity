// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.registry:
//            ProfileUserData

public class ProfileResponse
    implements gu, Serializable
{

    private ProfileUserData userData;

    public ProfileResponse()
    {
    }

    public ProfileUserData getUserData()
    {
        return userData;
    }

    public void setUserData(ProfileUserData profileuserdata)
    {
        userData = profileuserdata;
    }
}
