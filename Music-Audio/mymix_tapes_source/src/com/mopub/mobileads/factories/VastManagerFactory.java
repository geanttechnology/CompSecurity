// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.VastManager;

public class VastManagerFactory
{

    protected static VastManagerFactory instance = new VastManagerFactory();

    public VastManagerFactory()
    {
    }

    public static VastManager create(Context context)
    {
        return instance.internalCreate(context, true);
    }

    public static VastManager create(Context context, boolean flag)
    {
        return instance.internalCreate(context, flag);
    }

    public static void setInstance(VastManagerFactory vastmanagerfactory)
    {
        instance = vastmanagerfactory;
    }

    public VastManager internalCreate(Context context, boolean flag)
    {
        return new VastManager(context, flag);
    }

}
