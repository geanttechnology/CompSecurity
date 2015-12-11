// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            lp, lq

final class me
    implements android.view.View.OnClickListener
{

    final lp a;

    private me(lp lp1)
    {
        a = lp1;
        super();
    }

    me(lp lp1, lq lq)
    {
        this(lp1);
    }

    public final void onClick(View view)
    {
        view.setEnabled(false);
        lp.a(a, null);
        lp.a(a, true);
        lp.d(a);
    }
}
