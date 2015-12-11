// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a;

import android.app.Activity;
import android.os.RemoteException;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.a.a.a.f;
import com.google.android.a.a.a.p;
import com.google.android.a.a.a.r;
import com.google.android.a.a.a.t;

// Referenced classes of package com.google.android.a.a:
//            e

final class a
    implements com.google.android.a.a.a.
{

    final Activity a;
    final e b;

    public final void a()
    {
        if (e.a(b) != null)
        {
            e.a(b, a);
        }
        e.b(b);
    }

    public final void b()
    {
        if (!e.c(b) && e.d(b) != null)
        {
            Object obj = e.d(b);
            try
            {
                ((t) (obj)).a.q();
            }
            catch (RemoteException remoteexception)
            {
                throw new r(remoteexception);
            }
        }
        obj = e.e(b);
        ((p) (obj)).a.setVisibility(8);
        ((p) (obj)).b.setVisibility(8);
        if (b.indexOfChild(e.e(b)) < 0)
        {
            b.addView(e.e(b));
            b.removeView(com.google.android.a.a.e.f(b));
        }
        e.g(b);
        e.h(b);
        e.b(b);
    }

    a(e e1, Activity activity)
    {
        b = e1;
        a = activity;
        super();
    }
}
