// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import com.facebook.ads.internal.adapters.b;

// Referenced classes of package com.facebook.ads:
//            NativeAd, ImpressionListener

private class <init> extends b
{

    final NativeAd a;

    public boolean a()
    {
        return false;
    }

    public void d()
    {
        if (NativeAd.m(a) != null)
        {
            NativeAd.m(a).onLoggingImpression(a);
        }
        if ((NativeAd.a(a) instanceof ImpressionListener) && NativeAd.a(a) != NativeAd.m(a))
        {
            ((ImpressionListener)NativeAd.a(a)).onLoggingImpression(a);
        }
    }

    public void e()
    {
    }

    private istener(NativeAd nativead)
    {
        a = nativead;
        super();
    }

    apters.b(NativeAd nativead, apters.b b1)
    {
        this(nativead);
    }
}
