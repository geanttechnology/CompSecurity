// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.AlertDialog;
import com.j.a.g.o;
import com.j.a.g.w;

// Referenced classes of package com.j.a.d:
//            e, c, ac

class b
    implements Runnable
{

    final ac a;

    b(ac ac1)
    {
        a = ac1;
        super();
    }

    public void run()
    {
        try
        {
            if (e.e().p() != null && e.e().i())
            {
                ac ac1 = a;
                c c1 = new c(this);
                ac1.a = o.a("Taplytics", new String[] {
                    "Show Experiments", "Clear"
                }, c1).create();
                o.a(a.a, 80);
                a.a.dismiss();
                a.a.show();
            }
            return;
        }
        catch (Exception exception)
        {
            w.b("dialog err", exception);
        }
    }
}
