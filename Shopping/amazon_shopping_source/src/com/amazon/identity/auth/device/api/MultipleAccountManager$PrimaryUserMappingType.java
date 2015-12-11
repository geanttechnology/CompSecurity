// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.framework.AndroidUser;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MultipleAccountManager

public static class <init> extends <init>
{

    public static <init> createPrimaryMappingForProfile(int i)
    {
        return new <init>(i);
    }

    public static boolean isSupportedOnThisPlatform(Context context)
    {
        return true;
    }

    public ()
    {
        this(AndroidUser.getMyUserId());
    }

    private <init>(int i)
    {
        super("com.amazon.dcp.sso.property.account.extratokens.account_profiles", Integer.toString(i));
    }

    t>(int i, t> t>)
    {
        this(i);
    }
}
