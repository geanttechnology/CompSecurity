// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;

// Referenced classes of package android.support.design.widget:
//            Snackbar

class a
    implements ackbarLayout.a
{

    final Snackbar a;

    public void a(View view, int i, int j, int k, int l)
    {
        Snackbar.b(a);
        Snackbar.c(a).setOnLayoutChangeListener(null);
    }

    ackbarLayout(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }
}
