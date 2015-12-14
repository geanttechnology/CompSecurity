// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import cd;
import ce;
import db;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat

public class a extends db
{

    final cd a;
    final SpinnerCompat b;

    public ListPopupWindow a()
    {
        return a;
    }

    public boolean b()
    {
        if (!SpinnerCompat.a(b).b())
        {
            SpinnerCompat.a(b).c();
        }
        return true;
    }

    (SpinnerCompat spinnercompat, View view, cd cd)
    {
        b = spinnercompat;
        a = cd;
        super(view);
    }
}
