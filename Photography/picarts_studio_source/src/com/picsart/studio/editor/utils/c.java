// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.utils;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public final class c
{

    public Rect a;
    public Rect b;
    public Paint c;
    public boolean d;
    public float e;
    public float f;
    public Matrix g;
    private boolean h;
    private int i;
    private int j;
    private View k;

    public c(View view, int l, int i1)
    {
        b = new Rect();
        d = false;
        e = 0.0F;
        f = 0.0F;
        h = true;
        i = 0;
        j = 0;
        g = new Matrix();
        k = view;
        j = i1;
        i = l;
        view.getWidth();
        view.getHeight();
        a();
        c = new Paint();
        c.setFilterBitmap(true);
    }

    public final void a()
    {
        if (a == null)
        {
            a = new Rect();
        }
        a.set(j, j, j + i, j + i);
        h = true;
    }

    public final boolean a(float f1, float f2)
    {
        boolean flag1 = true;
        boolean flag = false;
        int l = (int)f1;
        int i1 = (int)f2;
        if (a.contains(l, i1))
        {
            b.set(a);
            if (h)
            {
                if (k != null)
                {
                    a.set(k.getWidth() - j - i, j, k.getWidth() - j, j + i);
                }
            } else
            {
                a.set(j, j, j + i, j + i);
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
        e = (float)a.centerX() - f1;
        f = (float)a.centerY() - f2;
        return flag;
    }
}
