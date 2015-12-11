// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;

// Referenced classes of package android.support.design.widget:
//            Snackbar

final class aq
    implements android.view.View.OnClickListener
{

    private android.view.View.OnClickListener a;
    private Snackbar b;

    aq(Snackbar snackbar, android.view.View.OnClickListener onclicklistener)
    {
        b = snackbar;
        a = onclicklistener;
        super();
    }

    public final void onClick(View view)
    {
        a.onClick(view);
        Snackbar.a(b, 1);
    }
}
