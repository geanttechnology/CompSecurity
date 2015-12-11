// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import com.google.ads.l;
import com.google.ads.n;

// Referenced classes of package com.google.ads.internal:
//            c, ActivationOverlay

class a
    implements Runnable
{

    final c a;

    public void run()
    {
        ((ActivationOverlay)((n)c.b(a).a.a()).e.a()).loadUrl(c.c(a));
    }

    vationOverlay(c c1)
    {
        a = c1;
        super();
    }
}
