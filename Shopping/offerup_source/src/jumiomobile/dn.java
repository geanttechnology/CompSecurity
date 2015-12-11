// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.view.OrientationEventListener;

// Referenced classes of package jumiomobile:
//            dm, ao, w, g

class dn extends OrientationEventListener
{

    final dm a;

    dn(dm dm1, Context context, int i)
    {
        a = dm1;
        super(context, i);
    }

    public void onOrientationChanged(int i)
    {
        if (i != -1)
        {
            w w1 = a.q.d();
            a.q.e();
            if (a.q.m() && (w1 == w.b && a.q.d() == w.d || w1 == w.d && a.q.d() == w.b || a.q.c() && w1 == w.a && a.q.d() == w.c || a.q.c() && w1 == w.c && a.q.d() == w.a))
            {
                a.p.o();
                return;
            }
        }
    }
}
