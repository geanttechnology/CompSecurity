// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.util.l;

// Referenced classes of package com.facebook.ads:
//            NativeAd, AdListener

class a
    implements l
{

    final n a;
    final ters.n b;

    public void a()
    {
        NativeAd.a(b.b, a);
        NativeAd.e(b.b);
        if (NativeAd.a(b.b) != null)
        {
            NativeAd.a(b.b).onAdLoaded(b.b);
        }
    }

    ters.n(ters.n n, n n1)
    {
        b = n;
        a = n1;
        super();
    }
}
