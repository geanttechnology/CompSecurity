// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.network.models.ListingV2;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity

class a
    implements Runnable
{

    final GlobeActivity a;

    public void run()
    {
        GlobeActivity.a(a, GlobeActivity.h(a).song);
        GlobeActivity.c(a);
    }

    (GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
