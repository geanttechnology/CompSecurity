// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.mopub.c.p;

// Referenced classes of package com.mopub.mobileads:
//            an, x

final class b
    implements b
{

    final x a;
    final Context b;
    final an c;

    public final void a()
    {
        c.a("com.mopub.action.interstitial.click");
        p.a(a.d, null, Integer.valueOf(c.w), null, b);
        a.a(b, null);
    }

    (an an1, x x1, Context context)
    {
        c = an1;
        a = x1;
        b = context;
        super();
    }
}
