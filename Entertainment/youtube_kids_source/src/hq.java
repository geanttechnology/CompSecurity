// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

public final class hq extends PopupWindow
{

    private final boolean a;

    public hq(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = ib.a(context, attributeset, gl.k, i, 0);
        a = context.a(1, false);
        setBackgroundDrawable(context.a(0));
        ((ib) (context)).a.recycle();
    }

    public final void showAsDropDown(View view, int i, int j)
    {
        int k = j;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            k = j;
            if (a)
            {
                k = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, k);
    }

    public final void showAsDropDown(View view, int i, int j, int k)
    {
        int l = j;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            l = j;
            if (a)
            {
                l = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, l, k);
    }

    public final void update(View view, int i, int j, int k, int l)
    {
        if (android.os.Build.VERSION.SDK_INT < 21 && a)
        {
            j -= view.getHeight();
        }
        super.update(view, i, j, k, l);
    }
}
