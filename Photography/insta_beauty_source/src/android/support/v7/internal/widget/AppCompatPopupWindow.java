// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import ab;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import dx;

public class AppCompatPopupWindow extends PopupWindow
{

    private final boolean a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = dx.a(context, attributeset, ab.PopupWindow, i, 0);
        a = context.a(ab.PopupWindow_overlapAnchor, false);
        setBackgroundDrawable(context.a(ab.PopupWindow_android_popupBackground));
        context.b();
    }

    public void showAsDropDown(View view, int i, int j)
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

    public void showAsDropDown(View view, int i, int j, int k)
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

    public void update(View view, int i, int j, int k, int l)
    {
        if (android.os.Build.VERSION.SDK_INT < 21 && a)
        {
            j -= view.getHeight();
        }
        super.update(view, i, j, k, l);
    }
}
