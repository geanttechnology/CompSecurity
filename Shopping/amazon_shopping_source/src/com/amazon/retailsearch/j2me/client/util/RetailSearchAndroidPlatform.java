// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.j2me.client.util;

import android.content.Context;
import android.os.Handler;

// Referenced classes of package com.amazon.retailsearch.j2me.client.util:
//            Platform

public class RetailSearchAndroidPlatform
    implements Platform
{

    private Handler handler;

    public RetailSearchAndroidPlatform(Context context)
    {
        handler = new Handler(context.getMainLooper());
    }

    public void invokeLater(Runnable runnable)
    {
        handler.post(runnable);
    }

    public void invokeLater(Runnable runnable, long l)
    {
        handler.postDelayed(runnable, l);
    }
}
