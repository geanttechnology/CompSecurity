// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.List;

// Referenced classes of package com.target.ui.view.shop:
//            WeeklyAdView

private class <init> extends android.support.v7.widget.nit>
{

    final WeeklyAdView this$0;

    public void a(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.nit> nit>)
    {
        if (WeeklyAdView.a(WeeklyAdView.this).size() != 1)
        {
            super.a(rect, view, recyclerview, nit>);
            return;
        }
        int i;
        if (view.getWidth() != 0)
        {
            i = view.getWidth();
        } else
        {
            i = Math.round((float)recyclerview.getHeight() * 0.8F);
        }
        rect.set(Math.round((float)(recyclerview.getWidth() - i) / 2.0F) - recyclerview.getPaddingLeft() - ((android.support.v7.widget.tPaddingLeft)view.getLayoutParams()).leftMargin, 0, 0, 0);
    }

    private q()
    {
        this$0 = WeeklyAdView.this;
        super();
    }

    f(f f)
    {
        this();
    }
}
