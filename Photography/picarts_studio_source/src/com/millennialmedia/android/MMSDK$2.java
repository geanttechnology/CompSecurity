// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK, CachedAd, MMLog

final class Iterator extends Iterator
{

    private Context a;

    final boolean a(CachedAd cachedad)
    {
        String s1 = cachedad.getTypeString();
        String s2 = cachedad.getId();
        String s;
        if (cachedad.isOnDisk(a))
        {
            s = "";
        } else
        {
            s = "not ";
        }
        if (cachedad.isExpired())
        {
            cachedad = "";
        } else
        {
            cachedad = "not ";
        }
        MMLog.c("MMSDK", String.format("%s %s is %son disk. Is %sexpired.", new Object[] {
            s1, s2, s, cachedad
        }));
        return true;
    }

    (Context context)
    {
        a = context;
        super();
    }
}
