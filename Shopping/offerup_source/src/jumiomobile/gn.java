// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.view.OrientationEventListener;

// Referenced classes of package jumiomobile:
//            gm, ao, w, g

class gn extends OrientationEventListener
{

    final gm a;

    gn(gm gm1, Context context, int i)
    {
        a = gm1;
        super(context, i);
    }

    public void onOrientationChanged(int i)
    {
        if (i != -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        w w1;
        w w2;
        w1 = a.d.d();
        a.d.e();
        w2 = a.d.d();
        if (!a.d.m() || (w1 != w.b || w2 != w.d) && (w1 != w.d || w2 != w.b) && (!a.d.c() || w1 != w.a || w2 != w.c) && (!a.d.c() || w1 != w.c || w2 != w.a)) goto _L1; else goto _L3
_L3:
        synchronized (a.r)
        {
            a.b.o();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
