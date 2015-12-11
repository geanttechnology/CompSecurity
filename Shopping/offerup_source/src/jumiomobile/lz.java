// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            lp, lq

final class lz
    implements android.view.View.OnClickListener
{

    final lp a;

    private lz(lp lp1)
    {
        a = lp1;
        super();
    }

    lz(lp lp1, lq lq)
    {
        this(lp1);
    }

    public final void onClick(View view)
    {
        view.setEnabled(false);
        lp.a(a, 100);
    }
}
