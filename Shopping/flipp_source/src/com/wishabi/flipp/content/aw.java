// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import com.wishabi.flipp.widget.db;
import com.wishabi.flipp.widget.dj;
import com.wishabi.flipp.widget.dk;

// Referenced classes of package com.wishabi.flipp.content:
//            as, ShoppingList, ay

public final class aw
    implements dj
{

    final as a;

    protected aw(as as1)
    {
        a = as1;
        super();
    }

    public final void a(db db1)
    {
        db1 = a.d.b(db1.getLongTag());
        if (a.c == null || db1 == null)
        {
            return;
        } else
        {
            a.c.a(db1);
            return;
        }
    }

    public final void a(db db1, boolean flag)
    {
        az az = a.d.b(db1.getLongTag());
        if (a.c == null || az == null)
        {
            return;
        } else
        {
            a.c.a(db1, az, flag);
            return;
        }
    }

    public final void b(db db1)
    {
        az az = a.d.b(db1.getLongTag());
        if (a.c == null || az == null)
        {
            return;
        } else
        {
            a.c.a(db1);
            return;
        }
    }

    public final void c(db db1)
    {
        db1 = a.d.b(db1.getLongTag());
        if (a.c == null || db1 == null)
        {
            return;
        } else
        {
            a.c.c(db1);
            return;
        }
    }

    public final void d(db db1)
    {
        db1.setState$282bce2c(dk.a);
    }
}
