// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.widget.ListAdapter;

public class dp extends ListPopupWindow
    implements ds
{

    final SpinnerCompat a;
    private CharSequence c;
    private ListAdapter d;

    public dp(SpinnerCompat spinnercompat, Context context, AttributeSet attributeset, int i)
    {
        a = spinnercompat;
        super(context, attributeset, i);
        a(spinnercompat);
        a(true);
        a(0);
        a(new dq(this, spinnercompat));
    }

    static ListAdapter a(dp dp1)
    {
        return dp1.d;
    }

    public void a(ListAdapter listadapter)
    {
        super.a(listadapter);
        d = listadapter;
    }

    public void a(CharSequence charsequence)
    {
        c = charsequence;
    }
}
