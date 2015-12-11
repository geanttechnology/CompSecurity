// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.c.aa;
import com.smule.android.f.n;
import com.smule.android.network.a.r;
import com.smule.android.network.models.PerformanceV2;
import java.io.File;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity

class b
    implements Runnable
{

    final PerformanceV2 a;
    final boolean b;
    final GlobeActivity c;

    public void run()
    {
        aa.c(GlobeActivity.a, (new StringBuilder()).append("Fetching performance midi for: ").append(a.songUid).toString());
        if (!b && GlobeActivity.k(c) != null && GlobeActivity.k(c).exists())
        {
            GlobeActivity.k(c).delete();
        }
        aa.a(GlobeActivity.a, "file deteled");
        (new File((new StringBuilder()).append(n.b(c)).append("globe_cache").toString())).mkdirs();
        if (b)
        {
            GlobeActivity.a(c, r.a(a.origTrackUrl, (new StringBuilder()).append("globe_cache").append(a.performanceKey).toString(), c));
            aa.a(GlobeActivity.a, "prefetch file downloaded");
        } else
        if (GlobeActivity.l(c) != null && GlobeActivity.l(c).exists())
        {
            GlobeActivity.b(c, GlobeActivity.l(c));
        } else
        {
            GlobeActivity.b(c, r.a(a.origTrackUrl, (new StringBuilder()).append("globe_cache").append(a.performanceKey).toString(), c));
        }
        if (!c.isFinishing())
        {
            if (GlobeActivity.m(c))
            {
                c.a(false);
                return;
            }
            if (!b)
            {
                if (com.smule.pianoandroid.magicpiano.GlobeActivity.n(c))
                {
                    GlobeActivity.o(c);
                    return;
                } else
                {
                    GlobeActivity.a(c, true);
                    return;
                }
            }
        }
    }

    (GlobeActivity globeactivity, PerformanceV2 performancev2, boolean flag)
    {
        c = globeactivity;
        a = performancev2;
        b = flag;
        super();
    }
}
