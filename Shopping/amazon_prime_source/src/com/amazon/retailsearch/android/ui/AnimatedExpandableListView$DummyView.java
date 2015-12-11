// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            AnimatedExpandableListView

private static class views extends View
{

    private Drawable divider;
    private int dividerHeight;
    private int dividerWidth;
    private List views;

    public void addFakeView(View view)
    {
        view.layout(0, 0, getWidth(), getHeight());
        views.add(view);
    }

    public void clearViews()
    {
        views.clear();
    }

    public void dispatchDraw(Canvas canvas)
    {
        canvas.save();
        divider.setBounds(0, 0, dividerWidth, dividerHeight);
        int j = views.size();
        for (int i = 0; i < j; i++)
        {
            View view = (View)views.get(i);
            view.draw(canvas);
            canvas.translate(0.0F, view.getMeasuredHeight());
            divider.draw(canvas);
            canvas.translate(0.0F, dividerHeight);
        }

        canvas.restore();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        int j1 = views.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((View)views.get(i1)).layout(i, j, k, l);
        }

    }

    public void setDivider(Drawable drawable, int i, int j)
    {
        divider = drawable;
        dividerWidth = i;
        dividerHeight = j;
        drawable.setBounds(0, 0, i, j);
    }

    public (Context context)
    {
        super(context);
        views = new ArrayList();
    }
}
