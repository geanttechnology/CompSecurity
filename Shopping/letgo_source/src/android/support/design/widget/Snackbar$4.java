// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bd;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            Snackbar, e

class a extends bd
{

    final Snackbar a;

    public void onAnimationEnd(View view)
    {
        e.a().c(Snackbar.a(a));
    }

    public void onAnimationStart(View view)
    {
        Snackbar.c(a).a(70, 180);
    }

    ackbarLayout(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }
}
