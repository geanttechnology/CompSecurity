// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class zzRW
    implements ComponentCallbacks2
{

    private final size zzRW;

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onLowMemory()
    {
        zzRW.evictAll();
    }

    public void onTrimMemory(int i)
    {
        if (i >= 60)
        {
            zzRW.evictAll();
        } else
        if (i >= 20)
        {
            zzRW.trimToSize(zzRW.size() / 2);
            return;
        }
    }

    public ( )
    {
        zzRW = ;
    }
}
