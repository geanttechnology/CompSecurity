// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.l;
import com.facebook.ads.internal.util.m;
import java.util.ArrayList;
import java.util.EnumSet;

// Referenced classes of package com.facebook.ads:
//            NativeAd, AdListener

class a
    implements l
{

    final n a;
    final ters.n b;

    public void a()
    {
        com.facebook.ads.NativeAd.a(b.b, a);
        NativeAd.e(b.b);
        if (com.facebook.ads.NativeAd.a(b.b) != null)
        {
            com.facebook.ads.NativeAd.a(b.b).onAdLoaded(b.b);
        }
    }

    ters.n(ters.n n, n n1)
    {
        b = n;
        a = n1;
        super();
    }

    // Unreferenced inner class com/facebook/ads/NativeAd$1

/* anonymous class */
    class NativeAd._cls1 extends a
    {

        final EnumSet a;
        final NativeAd b;

        public void a()
        {
            if (com.facebook.ads.NativeAd.b(b) != null)
            {
                com.facebook.ads.NativeAd.b(b).c();
            }
        }

        public void a(n n1)
        {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(com.facebook.ads.internal.util.b.b.a, AdPlacementType.NATIVE, System.currentTimeMillis() - com.facebook.ads.NativeAd.c(b), null));
            if (n1 == null)
            {
                return;
            }
            ArrayList arraylist = new ArrayList(2);
            if (a.contains(NativeAd.MediaCacheFlag.ICON) && n1.k() != null)
            {
                arraylist.add(n1.k().getUrl());
            }
            if (a.contains(NativeAd.MediaCacheFlag.IMAGE) && n1.l() != null)
            {
                arraylist.add(n1.l().getUrl());
            }
            m.a(NativeAd.d(b), arraylist, new NativeAd._cls1._cls1(this, n1));
        }

        public void a(com.facebook.ads.internal.b b1)
        {
            if (com.facebook.ads.NativeAd.a(b) != null)
            {
                com.facebook.ads.NativeAd.a(b).onError(b, b1.b());
            }
        }

        public void b()
        {
            if (com.facebook.ads.NativeAd.a(b) != null)
            {
                com.facebook.ads.NativeAd.a(b).onAdClicked(b);
            }
        }

        public void c()
        {
            throw new IllegalStateException("Native ads manager their own impressions.");
        }

            
            {
                b = nativead;
                a = enumset;
                super();
            }
    }

}
