// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.managers.bbyscan;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import mj;

public final class ViewfinderView extends View
{

    private static final int a[] = {
        0, 64, 128, 192, 255, 192, 128, 64
    };
    private final Paint b = new Paint();
    private Bitmap c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private int i;
    private final AtomicReference j = new AtomicReference();
    private final AtomicReference k = new AtomicReference();

    public ViewfinderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = getResources();
        d = context.getColor(0x7f0b0055);
        e = context.getColor(0x7f0b0040);
        f = context.getColor(0x7f0b0053);
        g = context.getColor(0x7f0b0054);
        h = context.getColor(0x7f0b003e);
        i = 0;
        j.set(new ArrayList(5));
    }

    public void a()
    {
        c = null;
        invalidate();
    }

    public void a(Bitmap bitmap)
    {
        c = bitmap;
        invalidate();
    }

    public void a(ResultPoint resultpoint)
    {
        List list = (List)j.get();
        list.add(resultpoint);
        if (list.size() > 20)
        {
            list.subList(0, list.size() - 10).clear();
        }
    }

    public void onDraw(Canvas canvas)
    {
        Rect rect = mj.a().g();
        if (rect == null)
        {
            return;
        }
        int k1 = canvas.getWidth();
        int l1 = canvas.getHeight();
        Object obj = b;
        int l;
        if (c != null)
        {
            l = e;
        } else
        {
            l = d;
        }
        ((Paint) (obj)).setColor(l);
        canvas.drawRect(0.0F, 0.0F, k1, rect.top, b);
        canvas.drawRect(0.0F, rect.top, rect.left, rect.bottom + 1, b);
        canvas.drawRect(rect.right + 1, rect.top, k1, rect.bottom + 1, b);
        canvas.drawRect(0.0F, rect.bottom + 1, k1, l1, b);
        if (c != null)
        {
            b.setAlpha(160);
            canvas.save();
            canvas.rotate(90F);
            canvas.drawBitmap(c, null, rect, b);
            return;
        }
        b.setColor(getResources().getColor(0x7f0b0063));
        b.setStrokeWidth(20F);
        float f1 = (rect.bottom - rect.top) / 3;
        canvas.drawLine(rect.right - 1, rect.top, rect.right - 1, (float)rect.top + f1, b);
        canvas.drawLine(rect.right - 1, rect.bottom + 1, rect.right - 1, (float)rect.bottom - f1, b);
        canvas.drawLine((float)rect.right - f1, rect.bottom + 1, rect.right - 1, rect.bottom + 1, b);
        canvas.drawLine(rect.left + 1, rect.bottom + 1, (float)rect.left + f1, rect.bottom + 1, b);
        canvas.drawLine(rect.left + 1, rect.bottom + 1, rect.left + 1, (float)rect.bottom - f1, b);
        canvas.drawLine(rect.left + 1, (float)rect.top + f1, rect.left + 1, rect.top - 1, b);
        canvas.drawLine(rect.left, rect.top + 1, (float)rect.left + f1, rect.top + 1, b);
        canvas.drawLine((float)rect.right - f1, rect.top + 1, rect.right - 1, rect.top + 1, b);
        obj = mj.a().h();
        f1 = (float)rect.width() / (float)((Rect) (obj)).width();
        float f2 = (float)rect.height() / (float)((Rect) (obj)).height();
        Object obj1 = (List)j.get();
        obj = (List)k.get();
        if (((List) (obj1)).isEmpty())
        {
            k.set(null);
        } else
        {
            j.set(new ArrayList(5));
            k.set(obj1);
            b.setAlpha(160);
            b.setColor(h);
            obj1 = ((List) (obj1)).iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                ResultPoint resultpoint = (ResultPoint)((Iterator) (obj1)).next();
                float f4 = rect.left + (int)(resultpoint.getX() * f1);
                int j1 = rect.top;
                canvas.drawCircle(f4, (int)(resultpoint.getY() * f2) + j1, 6F, b);
            }
        }
        if (obj != null)
        {
            b.setAlpha(80);
            b.setColor(h);
            float f3;
            int i1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); canvas.drawCircle(f3, (int)(((ResultPoint) (obj1)).getY() * f2) + i1, 3F, b))
            {
                obj1 = (ResultPoint)((Iterator) (obj)).next();
                f3 = rect.left + (int)(((ResultPoint) (obj1)).getX() * f1);
                i1 = rect.top;
            }

        }
        postInvalidateDelayed(80L, rect.left, rect.top, rect.right, rect.bottom);
    }

}
