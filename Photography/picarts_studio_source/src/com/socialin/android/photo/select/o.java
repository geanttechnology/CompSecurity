// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.socialin.android.util.Utils;

public final class o
{

    public RectF a;
    public Rect b;
    public Rect c;
    public Paint d;
    public boolean e;
    public float f;
    public float g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private View l;

    public o(RectF rectf, int i1, int j1)
    {
        c = new Rect();
        e = false;
        f = 0.0F;
        g = 0.0F;
        h = true;
        i = 0;
        j = 0;
        k = 0;
        a = rectf;
        j = j1;
        k = j1;
        i = i1;
        d = new Paint();
        d.setFilterBitmap(true);
    }

    public final void a()
    {
        if (b == null)
        {
            b = new Rect();
        }
        b.set(j, k, j + i, k + i);
        h = true;
    }

    public final void a(View view)
    {
        int j1 = 10;
        l = view;
        if (view != null)
        {
            Context context = view.getContext();
            int i1;
            if (context.getResources().getConfiguration().orientation == 1)
            {
                i1 = 58;
            } else
            {
                j1 = 66;
                i1 = 10;
            }
            j = (int)Utils.a(j1, context);
            k = (int)Utils.a(i1, context);
            view.getWidth();
            view.getHeight();
            a();
        }
    }

    public final boolean a(float f1, float f2)
    {
        boolean flag1 = true;
        boolean flag = false;
        int i1 = (int)f1;
        int j1 = (int)f2;
        if (b.contains(i1, j1))
        {
            c.set(b);
            if (h)
            {
                if (l != null)
                {
                    b.set(l.getWidth() - j - i, k, l.getWidth() - j, k + i);
                }
            } else
            {
                b.set(j, k, j + i, k + i);
            }
            if (!h)
            {
                flag = true;
            }
            h = flag;
            flag = flag1;
        } else
        {
            flag = false;
        }
        f = (float)b.centerX() - f1;
        g = (float)b.centerY() - f2;
        return flag;
    }
}
