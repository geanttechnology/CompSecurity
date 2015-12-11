// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.utils:
//            SwipeView

class b
    implements Runnable
{

    final int a;
    final int b;
    final View c;
    final List d;
    final SwipeView e;

    public void run()
    {
        SwipeView.a(e, c.getMeasuredWidth());
        if (a == 0)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager)e.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
            int i = (displaymetrics.widthPixels - SwipeView.a(e)) / 2;
            c.setPadding(i + c.getPaddingLeft(), c.getPaddingTop(), c.getPaddingRight(), c.getPaddingBottom());
        }
        if (a == d.size() - 1)
        {
            DisplayMetrics displaymetrics1 = new DisplayMetrics();
            ((WindowManager)e.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics1);
            int j = (displaymetrics1.widthPixels - SwipeView.a(e)) / 2;
            c.setPadding(c.getPaddingLeft(), c.getPaddingTop(), j + c.getPaddingRight(), c.getPaddingBottom());
            SwipeView.b(e, SwipeView.b(e).size() - 1);
        }
    }

    (SwipeView swipeview, int i, View view, List list)
    {
        e = swipeview;
        b = i;
        c = view;
        d = list;
        super();
        a = b;
    }
}
