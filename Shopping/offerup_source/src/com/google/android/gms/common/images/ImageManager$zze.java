// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class zzadL
    implements ComponentCallbacks2
{

    private final size zzadL;

    public final void onConfigurationChanged(Configuration configuration)
    {
    }

    public final void onLowMemory()
    {
        zzadL.evictAll();
    }

    public final void onTrimMemory(int i)
    {
        if (i >= 60)
        {
            zzadL.evictAll();
        } else
        if (i >= 20)
        {
            zzadL.trimToSize(zzadL.size() / 2);
            return;
        }
    }

    public ( )
    {
        zzadL = ;
    }
}
