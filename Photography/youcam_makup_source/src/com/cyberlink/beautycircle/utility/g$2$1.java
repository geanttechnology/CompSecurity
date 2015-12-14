// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.widget.ImageView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            g, h

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        if (g.i(a.a) != null)
        {
            g.i(a.a).setVisibility(8);
            g.i(a.a).setImageDrawable(null);
        }
        g.j(a.a);
    }

    it>(it> it>)
    {
        a = it>;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/utility/g$2

/* anonymous class */
    class g._cls2 extends AdListener
    {

        final g a;

        public void onAdClosed()
        {
            e.c(new Object[] {
                "PublisherAdView onAdClosed"
            });
            g.a(a, false);
        }

        public void onAdFailedToLoad(int i)
        {
            e.c(new Object[] {
                (new StringBuilder()).append("PublisherAdView mCurrentAdSizeCount=").append(g.a(a)).append(" onAdFailedToLoad : ").append(g.a(i)).toString()
            });
            g.a(a, false);
            if (g.b(a) < 3)
            {
                g.c(a);
                g.d(a);
            } else
            if (com.cyberlink.beautycircle.utility.g.e(a) != null)
            {
                g.b(a, false);
                com.cyberlink.beautycircle.utility.g.e(a).b();
                return;
            }
        }

        public void onAdLeftApplication()
        {
            e.c(new Object[] {
                " PublisherAdViewonAdLeftApplication"
            });
        }

        public void onAdLoaded()
        {
            e.c(new Object[] {
                (new StringBuilder()).append("PublisherAdView onAdLoaded size:").append(g.f(a).getAdSize()).toString()
            });
            if (g.g(a)) goto _L2; else goto _L1
_L1:
            if (!g.h(a)) goto _L4; else goto _L3
_L3:
            g.d(a);
_L6:
            return;
_L4:
            g.b(a, false);
            g.a(a, 0);
            e.e(new Object[] {
                "onAdLoaded, no any proper size!"
            });
            return;
_L2:
            g.a(a, true);
            a.a();
            if (g.i(a) != null)
            {
                g.f(a).postDelayed(new g._cls2._cls1(this), 1000L);
            } else
            {
                g.j(a);
            }
            if (com.cyberlink.beautycircle.utility.g.e(a) != null)
            {
                com.cyberlink.beautycircle.utility.g.e(a).a();
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public void onAdOpened()
        {
            e.c(new Object[] {
                "PublisherAdView onAdOpened"
            });
        }

            
            {
                a = g1;
                super();
            }
    }

}
