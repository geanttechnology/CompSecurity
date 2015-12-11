// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            MoPubActivity, p, g, o, 
//            s

final class a
    implements a
{

    final MoPubActivity a;

    public final void a()
    {
        MoPubActivity.a(a).loadUrl(a.a());
    }

    public final void a(s s)
    {
        o.a(a, ((g) (a)).c.longValue(), "com.mopub.action.interstitial.fail");
        a.finish();
    }

    public final void b()
    {
    }

    public final void c()
    {
        o.a(a, ((g) (a)).c.longValue(), "com.mopub.action.interstitial.click");
    }

    public final void d()
    {
    }

    (MoPubActivity mopubactivity)
    {
        a = mopubactivity;
        super();
    }
}
