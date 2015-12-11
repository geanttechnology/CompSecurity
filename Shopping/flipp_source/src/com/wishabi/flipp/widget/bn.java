// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.wishabi.flipp.widget:
//            bj

public final class bn extends View
{

    float a;
    float b;
    public int c;
    public int d;
    public final HashMap e = new HashMap();
    public boolean f;
    private float g;

    public bn(Context context)
    {
        super(context);
    }

    public final void a()
    {
        f = false;
        for (Iterator iterator = e.entrySet().iterator(); iterator.hasNext();)
        {
            bj bj1 = (bj)((java.util.Map.Entry)iterator.next()).getValue();
            bj1.g.reset();
            bj1.h.setEmpty();
            bj1.i.setEmpty();
            bj1.j.setEmpty();
            bj1.l = false;
            bj1.n = -1L;
            bj1.m = false;
        }

        invalidate();
    }

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (f) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator;
        boolean flag;
        int j;
        j = canvas.save();
        canvas.scale(g, g);
        canvas.translate(-a, -b);
        iterator = e.entrySet().iterator();
        flag = false;
_L5:
        bj bj1;
        int i;
        int k;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_649;
        }
        bj1 = (bj)((java.util.Map.Entry)iterator.next()).getValue();
        float f1 = 1.0F / g;
        i = c;
        k = d;
        bj1.g.setTranslate(-bj1.b.x + bj1.c, -bj1.b.y + bj1.d);
        bj1.g.postScale(f1, f1);
        bj1.g.postTranslate(bj1.b.x, bj1.b.y);
        bj1.g.mapRect(bj1.h, bj1.f);
        bj1.i.set((int)bj1.h.left, (int)bj1.h.top, (int)bj1.h.right, (int)bj1.h.bottom);
        canvas.getClipBounds(bj1.j);
        Drawable drawable;
        long l;
        if (!bj1.l && !bj1.o ? bj1.i.left >= 0 && bj1.i.top >= 0 && bj1.i.right <= i && bj1.i.bottom <= k ? !bj1.j.contains(bj1.i) && bj1.j.width() >= bj1.i.width() && bj1.j.height() >= bj1.i.height() : !bj1.j.intersects(bj1.i.left, bj1.i.top, bj1.i.right, bj1.i.bottom) : !bj1.j.intersects(bj1.i.left, bj1.i.top, bj1.i.right, bj1.i.bottom)) goto _L4; else goto _L3
_L4:
        i = 0;
_L7:
        if (i != 0 || flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L5
_L3:
        l = System.nanoTime() / 0xf4240L;
        if (!bj1.l)
        {
            bj1.l = true;
            bj1.n = l;
            bj1.o = true;
        }
        if (bj1.m)
        {
            i = bj1.a.size() - 1;
        } else
        {
            float f3 = (float)(l - bj1.n) / (float)bj1.k;
            float f2 = f3;
            if (f3 > 1.0F)
            {
                bj1.m = true;
                f2 = 1.0F;
            }
            i = (int)(f2 * (float)(bj1.a.size() - 1));
        }
        drawable = (Drawable)bj1.a.get(i);
        drawable.setBounds(bj1.i);
        drawable.draw(canvas);
        if (bj1.m) goto _L4; else goto _L6
_L6:
        i = 1;
          goto _L7
        canvas.restoreToCount(j);
        if (flag)
        {
            invalidate();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public final void setZoomScale(float f1)
    {
        g = f1;
        invalidate();
    }
}
