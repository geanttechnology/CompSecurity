// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity, an

class a
    implements Runnable
{

    final GlobeActivity a;

    public void run()
    {
        while (a.isFinishing() || GlobeActivity.v(a) != null) 
        {
            return;
        }
        GlobeActivity.a(a, new an(a, a.getResources().getString(0x7f0c029f)));
        GlobeActivity.v(a).a(a);
        GlobeActivity.v(a).setCancelable(false);
        GlobeActivity.v(a).a(false);
    }

    (GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
