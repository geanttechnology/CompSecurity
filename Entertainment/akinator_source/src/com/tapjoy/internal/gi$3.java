// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;

// Referenced classes of package com.tapjoy.internal:
//            gi, e, gw, gv, 
//            gd, fy, ge

final class d
    implements d
{

    final e a;
    final Activity b;
    final Activity c;
    final ge d;
    final gi e;

    public final void a()
    {
        a.cancel();
    }

    public final void a(gv gv1)
    {
        e.a.a(e.c.k, gv1.b);
        gi.a(b, gv1.d);
        if (gv1.e != null)
        {
            e.e.a(c, gv1.e);
            e.f = true;
        }
        d.a(e.b, gv1.f);
        if (gv1.c)
        {
            a.dismiss();
        }
    }

    public final void b()
    {
        gi gi1 = e;
        boolean flag;
        if (!e.g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gi1.g = flag;
    }

    (gi gi1, e e1, Activity activity, Activity activity1, ge ge1)
    {
        e = gi1;
        a = e1;
        b = activity;
        c = activity1;
        d = ge1;
        super();
    }
}
