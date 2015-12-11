// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.dl;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            Snackbar

final class aw extends dl
{

    private int a;
    private Snackbar b;

    aw(Snackbar snackbar, int i)
    {
        b = snackbar;
        a = i;
        super();
    }

    public final void onAnimationEnd(View view)
    {
        Snackbar.b(b, a);
    }

    public final void onAnimationStart(View view)
    {
        Snackbar.c(b).b(0, 180);
    }
}
