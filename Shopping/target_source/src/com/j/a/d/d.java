// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.j.a.d:
//            ai, c, b, ac

class d
    implements android.content.DialogInterface.OnKeyListener
{

    final ai a;

    d(ai ai1)
    {
        a = ai1;
        super();
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            a.b.a.a.c.dismiss();
            a.b.a.a.b.show();
        }
        return true;
    }
}
