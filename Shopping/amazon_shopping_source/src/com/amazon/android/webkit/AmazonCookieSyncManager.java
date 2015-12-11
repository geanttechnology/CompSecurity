// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.Context;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebKitFactories, AmazonWebKitFactory

public abstract class AmazonCookieSyncManager
{

    protected AmazonCookieSyncManager()
    {
    }

    public static AmazonCookieSyncManager getInstance()
    {
        return AmazonWebKitFactories.getDefaultFactory().getCookieSyncManager();
    }

    public static void initialize(Context context)
    {
        AmazonWebKitFactories.getDefaultFactory().getCookieSyncManager().createInstance(context);
    }

    public abstract void createInstance(Context context);

    public abstract void sync();
}
