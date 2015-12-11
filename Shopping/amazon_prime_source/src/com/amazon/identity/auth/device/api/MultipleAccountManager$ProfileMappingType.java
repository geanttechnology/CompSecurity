// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MultipleAccountManager

public static class ype extends ype
{

    public static ype createCurrentProfile(Context context)
    {
        return new <init>(0);
    }

    public static <init> createCurrentViewableProfile(Context context)
    {
        return new <init>(0);
    }

    public static boolean isSupportedOnThisPlatform(Context context)
    {
        MAPLog.e(MultipleAccountManager.access$100(), "ProfileMappingType is deprecated. Please use PrimaryUserMappingType instead");
        return false;
    }

    public ype(int i)
    {
        super(i, (byte)0);
    }
}
