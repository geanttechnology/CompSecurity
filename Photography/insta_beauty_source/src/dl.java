// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;

public class dl extends ez
{

    final dp a;
    final SpinnerCompat b;

    public dl(SpinnerCompat spinnercompat, View view, dp dp)
    {
        b = spinnercompat;
        a = dp;
        super(view);
    }

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
}
