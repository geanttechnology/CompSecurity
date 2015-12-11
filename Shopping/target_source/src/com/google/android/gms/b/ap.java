// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.os.Handler;
import com.google.android.gms.ads.internal.c;

// Referenced classes of package com.google.android.gms.b:
//            bw, ar, aq, bz, 
//            cj

public class ap extends bw
{

    final cj a;
    final ar b;
    private final String c;

    ap(cj cj, String s)
    {
        a = cj;
        b = new ar(cj);
        c = s;
        com.google.android.gms.ads.internal.c.k().a(this);
    }

    public void a()
    {
        b.a(c);
        bz.a.post(new _cls1());
        return;
        Exception exception;
        exception;
        bz.a.post(new _cls1());
        throw exception;
    }

    /* member class not found */
    class _cls1 {}

}
