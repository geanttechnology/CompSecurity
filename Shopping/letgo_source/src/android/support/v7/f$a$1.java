// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.View;

// Referenced classes of package android.support.v7:
//            f

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        float f1 = ((float)(a(a) - a(a)) * 1.0F) / (float)a(a);
        if (f1 > 1.0F || a.a.getParent() == null)
        {
            f1 = 1.0F;
        }
        nt(a, f1);
        a(a);
        if (a(a) >= 1.0F)
        {
            a(a);
            return;
        } else
        {
            a.a.postDelayed(ayed(a), 16L);
            return;
        }
    }

    ( )
    {
        a = ;
        super();
    }
}
