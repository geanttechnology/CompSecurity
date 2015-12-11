// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.AnimatorSet;
import com.a.b.j;

// Referenced classes of package com.wishabi.flipp.widget:
//            db, dk, dj

final class dh
    implements j
{

    final db a;

    dh(db db1)
    {
        a = db1;
        super();
    }

    public final void a()
    {
        while (!db.e(a) || db.f(a) == null) 
        {
            return;
        }
        a.setState$282bce2c(dk.c);
        db.f(a).start();
    }

    public final void b()
    {
        if (db.a(a) != null)
        {
            db.a(a).d(a);
        }
    }
}
