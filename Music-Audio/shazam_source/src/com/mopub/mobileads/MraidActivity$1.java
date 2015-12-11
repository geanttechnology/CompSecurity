// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.b.c;
import com.mopub.common.c.a;

// Referenced classes of package com.mopub.mobileads:
//            MraidActivity, g, o

final class a
    implements com.mopub.b.ivity._cls1
{

    final MraidActivity a;

    public final void a()
    {
        com.mopub.mobileads.MraidActivity.a(a).b(com.mopub.mobileads.a.a);
    }

    public final void b()
    {
        com.mopub.common.c.a.b("MraidActivity failed to load. Finishing the activity");
        com.mopub.mobileads.o.a(a, ((g) (a)).c.longValue(), "com.mopub.action.interstitial.fail");
        a.finish();
    }

    public final void c()
    {
        com.mopub.mobileads.MraidActivity.a(a).b(a.a);
        a.finish();
    }

    public final void d()
    {
        com.mopub.mobileads.o.a(a, ((g) (a)).c.longValue(), "com.mopub.action.interstitial.click");
    }

    (MraidActivity mraidactivity)
    {
        a = mraidactivity;
        super();
    }
}
