// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.location.Location;
import android.view.View;
import android.widget.TextView;
import com.smule.android.c.a;
import com.smule.android.c.f;
import com.smule.android.f.c;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.PerformanceManager;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.PerformanceV2;
import com.smule.pianoandroid.magicpiano.a.e;
import com.smule.pianoandroid.utils.m;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity, MagicApplication

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        PerformanceV2 performancev2 = a.a;
        performancev2.totalLoves = performancev2.totalLoves + 1;
        com.smule.pianoandroid.magicpiano.GlobeActivity.e(a.a.a).setText(String.valueOf(a.a.totalLoves));
        c.a(com.smule.pianoandroid.magicpiano.GlobeActivity.f(a.a.a), a.a.a.getResources().getDrawable(0x7f0200f7));
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GlobeActivity$1LoveRunnable$1

/* anonymous class */
    class GlobeActivity._cls1LoveRunnable._cls1
        implements NetworkResponseCallback
    {

        final PerformanceV2 a;
        final GlobeActivity.a b;

        public void handleResponse(o o1)
        {
            if (o1 != null && o1.a == p.a && o1.b == 0)
            {
                b.a.post(new GlobeActivity._cls1LoveRunnable._cls1._cls1(this));
                return;
            } else
            {
                com.smule.android.network.core.b.a(o1);
                MagicApplication.getInstance().showToast(b.b.getResources().getString(0x7f0c0045), 0);
                return;
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((o)obj);
        }

            
            {
                b = a1;
                a = performancev2;
                super();
            }
    }


    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GlobeActivity$a
    class GlobeActivity.a
        implements Runnable
    {

        View a;
        final GlobeActivity b;

        public void run()
        {
            float f2 = 0.0F;
            PerformanceV2 performancev2 = com.smule.pianoandroid.magicpiano.GlobeActivity.b(b);
            if (!com.smule.pianoandroid.utils.o.a(b))
            {
                return;
            }
            String s = performancev2.performanceKey;
            String s1 = performancev2.songUid;
            float f1;
            Object obj;
            if (performancev2.ensembleType.equalsIgnoreCase("MIX"))
            {
                obj = f.e;
            } else
            {
                obj = f.a;
            }
            com.smule.android.c.a.a(s, s1, ((f) (obj)), null);
            GlobeActivity.d(b).setClickable(false);
            obj = com.smule.android.f.f.a(b);
            if (obj != null)
            {
                f2 = (float)((Location) (obj)).getLatitude();
                f1 = (float)((Location) (obj)).getLongitude();
            } else
            {
                f1 = 0.0F;
            }
            PerformanceManager.a().a(performancev2.performanceKey, f2, f1, new GlobeActivity._cls1LoveRunnable._cls1(this, performancev2));
            if (GlobeActivity.g(b) == null) goto _L2; else goto _L1
_L1:
            e.a("loved_perf", GlobeActivity.g(b));
_L4:
            m.a(b);
            return;
_L2:
            if (GlobeActivity.h(b) != null && GlobeActivity.h(b).song != null)
            {
                e.a("loved_perf", GlobeActivity.h(b).song);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            GlobeActivity.a(GlobeActivity globeactivity, View view)
            {
                b = globeactivity;
                super();
                a = view;
            }
    }

}
