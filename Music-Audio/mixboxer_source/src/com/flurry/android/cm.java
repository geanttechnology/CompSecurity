// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            fp, FlurryAdSize, FlurryAds

final class cm extends fp
{

    private FlurryAds du;
    private Context n;

    cm(FlurryAds flurryads, Context context)
    {
        du = flurryads;
        n = context;
        super();
    }

    public final void c()
    {
        java.util.List list = du.a(n, "", null, true, FlurryAdSize.BANNER_BOTTOM);
        du.b(n, list);
    }
}
