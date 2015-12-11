// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity, an

class a
    implements Runnable
{

    final GlobeActivity a;

    public void run()
    {
        String s = String.format(a.getResources().getString(0x7f0c01fa), new Object[] {
            GlobeActivity.h(a).song.title
        });
        GlobeActivity.a(a, new an(a, s));
        GlobeActivity.v(a).a(a);
        GlobeActivity.v(a).setCancelable(true);
        GlobeActivity.z(a);
    }

    (GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
