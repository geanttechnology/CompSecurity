// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAds;

// Referenced classes of package com.smule.pianoandroid.ads:
//            g

class c
    implements Runnable
{

    final Context a;
    final Activity b;
    final int c;
    final g d;

    public void run()
    {
        FlurryAds.fetchAd(a, g.a(d), (ViewGroup)b.findViewById(c), FlurryAdSize.FULLSCREEN);
    }

    (g g1, Context context, Activity activity, int i)
    {
        d = g1;
        a = context;
        b = activity;
        c = i;
        super();
    }
}
