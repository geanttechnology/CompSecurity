// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat

class gListener extends android.support.v7.widget.ForwardingListener
{

    final show a;
    final SpinnerCompat b;

    public ListPopupWindow getPopup()
    {
        return a;
    }

    public boolean onForwardingStarted()
    {
        if (!SpinnerCompat.a(b).isShowing())
        {
            SpinnerCompat.a(b).show();
        }
        return true;
    }

    gListener(SpinnerCompat spinnercompat, View view, gListener glistener)
    {
        b = spinnercompat;
        a = glistener;
        super(view);
    }
}
