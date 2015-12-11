// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import java.util.List;

// Referenced classes of package com.google.android.gms.e:
//            dg

final class b
    implements Runnable
{

    final List a;
    final long b;
    final dg c;

    public final void run()
    {
        dg.a(c, a, b);
    }

    (dg dg1, List list, long l)
    {
        c = dg1;
        a = list;
        b = l;
        super();
    }
}
