// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.j.a.c.e;
import com.j.a.g.o;

// Referenced classes of package com.j.a.d:
//            c, b, x, ac, 
//            d

class ai
    implements android.content.DialogInterface.OnClickListener
{

    final e a;
    final c b;

    ai(c c1, e e1)
    {
        b = c1;
        a = e1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        b.a.a.c = o.a("Variation", a.a(i), new x(this, i)).create();
        b.a.a.c.setOnKeyListener(new d(this));
        b.a.a.c.show();
        b.a.a.b.dismiss();
        o.a(b.a.a.c, 80);
    }
}
