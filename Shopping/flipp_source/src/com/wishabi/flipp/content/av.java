// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import com.wishabi.flipp.widget.db;

// Referenced classes of package com.wishabi.flipp.content:
//            as, ShoppingList, ay

final class av
    implements com.wishabi.flipp.widget.av
{

    final db a;
    final as b;

    av(as as1, db db1)
    {
        b = as1;
        a = db1;
        super();
    }

    public final void a()
    {
        if (b.c != null)
        {
            b.c.d(b.d.b(a.getLongTag()));
        }
    }
}
