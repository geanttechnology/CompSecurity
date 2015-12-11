// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.dl;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            Snackbar, ba

final class au extends dl
{

    private Snackbar a;

    au(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }

    public final void onAnimationEnd(View view)
    {
        if (Snackbar.d(a) != null)
        {
            Snackbar.d(a);
        }
        ba.a().b(Snackbar.a(a));
    }

    public final void onAnimationStart(View view)
    {
        Snackbar.c(a).a(70, 180);
    }
}
