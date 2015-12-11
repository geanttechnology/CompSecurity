// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            cm, dn, co, cu, 
//            ai, bg, cn

final class x
{

    final cm a;
    private final dn b;
    private final cu c;
    private final cn d;
    private final co e;
    private volatile boolean f;

    public x(String s)
    {
        this(s, cm.a(), dn.a(), new co(), new cu());
    }

    private x(String s, cm cm1, dn dn1, co co1, cu cu1)
    {
        f = false;
        a = cm1;
        b = dn1;
        e = co1;
        d = co.a(s);
        c = cu1;
    }

    public final void a(Context context)
    {
        if (!f)
        {
            a.a(context);
            a.b.d = new ai();
            f = true;
        }
    }
}
