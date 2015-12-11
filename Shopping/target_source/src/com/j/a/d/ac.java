// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import com.j.a.g.o;
import com.j.a.g.w;

// Referenced classes of package com.j.a.d:
//            e, b

public class ac
{

    private static ac d = null;
    AlertDialog a;
    AlertDialog b;
    AlertDialog c;

    public ac()
    {
    }

    public static ac a()
    {
        if (d != null)
        {
            return d;
        } else
        {
            d = new ac();
            return d;
        }
    }

    public void b()
    {
        try
        {
            if (e.e().p() != null)
            {
                (new Handler(Looper.getMainLooper())).post(new b(this));
            }
            return;
        }
        catch (Exception exception)
        {
            w.b("dialog err", exception);
        }
    }

    public void c()
    {
        try
        {
            if (a != null && a.isShowing())
            {
                a.dismiss();
            }
            if (b != null && a != null && a.isShowing())
            {
                b.dismiss();
            }
            if (c != null && c.isShowing())
            {
                c.dismiss();
            }
            return;
        }
        catch (Exception exception)
        {
            w.b("problem killing dialogs", exception);
        }
    }

    public boolean d()
    {
        return o.a(a) || o.a(b) || o.a(c);
    }

}
