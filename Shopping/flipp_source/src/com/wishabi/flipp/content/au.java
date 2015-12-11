// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.view.View;
import com.wishabi.flipp.widget.db;

// Referenced classes of package com.wishabi.flipp.content:
//            as, ShoppingList, ay

final class au
    implements android.view.View.OnFocusChangeListener
{

    final db a;
    final as b;

    au(as as1, db db1)
    {
        b = as1;
        a = db1;
        super();
    }

    public final void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            a.setSubmitted(false);
        }
        if (b.c != null)
        {
            b.c.b(a, b.d.b(a.getLongTag()), flag);
        }
    }
}
