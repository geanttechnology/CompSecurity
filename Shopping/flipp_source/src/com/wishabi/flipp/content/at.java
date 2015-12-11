// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.view.KeyEvent;
import android.widget.TextView;
import com.wishabi.flipp.widget.db;

// Referenced classes of package com.wishabi.flipp.content:
//            as, ShoppingList, ay

final class at
    implements android.widget.TextView.OnEditorActionListener
{

    final db a;
    final as b;

    at(as as1, db db1)
    {
        b = as1;
        a = db1;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        i;
        JVM INSTR tableswitch 6 6: default 20
    //                   6 22;
           goto _L1 _L2
_L1:
        return false;
_L2:
        a.setSubmitted(true);
        if (b.c != null)
        {
            return b.c.a(a, b.d.b(a.getLongTag()));
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
