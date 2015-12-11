// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            fp, FlurryAds

final class cp extends fp
{

    private String eG;
    private Context n;

    cp(FlurryAds flurryads, Context context, String s)
    {
        n = context;
        eG = s;
        super();
    }

    public final void c()
    {
        FlurryAds.i(n, eG);
    }
}
