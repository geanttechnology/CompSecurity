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
        if (a.isFinishing())
        {
            return;
        }
        a.a(false);
        if (GlobeActivity.v(a) == null)
        {
            GlobeActivity.a(a, new an(a, a.getResources().getString(0x7f0c0045)));
        }
        GlobeActivity.v(a).a(true);
        GlobeActivity.v(a).a(2, a.getResources().getString(0x7f0c0045), true);
    }

    (GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
