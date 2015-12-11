// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            bi

public final class bv extends View
{

    public Bitmap a;
    public Canvas b;
    float c;
    float d;
    private final Paint e = new Paint();
    private final Paint f = new Paint();
    private final Matrix g = new Matrix();
    private float h;
    private List i;

    public bv(Context context)
    {
        super(context);
        e.setARGB(128, 0, 0, 0);
        f.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        g.setScale(2.0F, 2.0F);
    }

    public final List getHighlightAnnotations()
    {
        return i;
    }

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (i == null || a == null || b == null)
        {
            return;
        }
        int j = b.save();
        b.scale(h * 0.5F, h * 0.5F);
        b.translate(-c, -d);
        b.drawRect(c, d, c + (float)getWidth() / h, d + (float)getHeight() / h, f);
        b.drawRect(c, d, c + (float)getWidth() / h, d + (float)getHeight() / h, e);
        bi bi1;
        for (Iterator iterator = i.iterator(); iterator.hasNext(); b.drawRoundRect(bi1.a(false), 10F, 10F, f))
        {
            bi1 = (bi)iterator.next();
        }

        b.restoreToCount(j);
        canvas.drawBitmap(a, g, null);
    }

    protected final void onSizeChanged(int j, int k, int l, int i1)
    {
        super.onSizeChanged(j, k, l, i1);
        if (j / 2 > 0 && k / 2 > 0)
        {
            a = Bitmap.createBitmap(j / 2, k / 2, android.graphics.Bitmap.Config.ALPHA_8);
            b = new Canvas(a);
            return;
        } else
        {
            a = null;
            b = null;
            return;
        }
    }

    public final void setHighlightAnnotations(List list)
    {
        if (list == null)
        {
            i = null;
        } else
        {
            i = new ArrayList();
            list = list.iterator();
            while (list.hasNext()) 
            {
                bi bi1 = (bi)list.next();
                i.add(bi1);
            }
        }
        invalidate();
    }

    public final void setZoomScale(float f1)
    {
        h = f1;
        invalidate();
    }
}
