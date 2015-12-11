// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;

// Referenced classes of package jumiomobile:
//            lp, lq

class lx
    implements android.content.DialogInterface.OnClickListener
{

    final lp a;

    private lx(lp lp1)
    {
        a = lp1;
        super();
    }

    lx(lp lp1, lq lq)
    {
        this(lp1);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.f();
        lp.a(a, false);
        lp.a(a, null);
    }
}
