// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.idunnololz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class b extends View
{

    private List a;
    private Drawable b;
    private int c;
    private int d;

    public b(Context context)
    {
        super(context);
        a = new ArrayList();
    }

    public void a()
    {
        a.clear();
    }

    public void a(Drawable drawable, int i, int j)
    {
        b = drawable;
        c = i;
        d = j;
        drawable.setBounds(0, 0, i, j);
    }

    public void a(View view)
    {
        view.layout(0, 0, getWidth(), getHeight());
        a.add(view);
    }

    public void dispatchDraw(Canvas canvas)
    {
        canvas.save();
        b.setBounds(0, 0, c, d);
        int j = a.size();
        for (int i = 0; i < j; i++)
        {
            View view = (View)a.get(i);
            view.draw(canvas);
            canvas.translate(0.0F, view.getMeasuredHeight());
            b.draw(canvas);
            canvas.translate(0.0F, d);
        }

        canvas.restore();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        int j1 = a.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((View)a.get(i1)).layout(i, j, k, l);
        }

    }
}
