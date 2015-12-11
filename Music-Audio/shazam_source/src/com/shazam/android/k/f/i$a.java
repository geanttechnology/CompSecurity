// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import com.shazam.android.al.c;
import com.shazam.model.advert.AdvertInfo;
import com.shazam.model.analytics.AnalyticsInfo;

// Referenced classes of package com.shazam.android.k.f:
//            i

public static final class ertInfo
{

    public AnalyticsInfo a;
    public AdvertInfo b;
    public c c;

    public static ertInfo a(i j)
    {
        ertInfo ertinfo = new <init>();
        ertinfo.a = i.a(j);
        ertinfo.b = i.b(j);
        ertinfo.c = com.shazam.android.k.f.i.c(j);
        return ertinfo;
    }

    public final i a()
    {
        return new i(this, (byte)0);
    }

    public ertInfo()
    {
    }
}
