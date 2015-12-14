// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.picsart.collages:
//            a

public class CollageCellSelectorView extends View
{

    private List a;
    private float b;
    private Paint c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;

    public CollageCellSelectorView(Context context)
    {
        super(context);
        a = new ArrayList();
        b = 3F;
        c = null;
        d = 1.0F;
        e = 1.0F;
        f = 1.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0.0F;
        a();
    }

    public CollageCellSelectorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ArrayList();
        b = 3F;
        c = null;
        d = 1.0F;
        e = 1.0F;
        f = 1.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0.0F;
        a();
    }

    public CollageCellSelectorView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        a = new ArrayList();
        b = 3F;
        c = null;
        d = 1.0F;
        e = 1.0F;
        f = 1.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0.0F;
        a();
    }

    private void a()
    {
        c = new Paint();
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        c.setAntiAlias(true);
        c.setColor(-1);
    }

    public final Bitmap a(int j, int k)
    {
        Bitmap bitmap = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0xff000000);
        if (f > 1.0F)
        {
            d = j;
            e = d / f;
        } else
        {
            d = (float)k * f;
            e = k;
        }
        canvas.drawRect(g, h, g + d, h + e, c);
        canvas.save();
        k = a.size();
        if (k == 0)
        {
            canvas.restore();
            return null;
        }
        for (j = 0; j < k; j++)
        {
            if (((a)a.get(j)).e.width() == 0.0F && ((a)a.get(j)).e.height() == 0.0F)
            {
                canvas.restore();
                return null;
            }
            ((a)a.get(j)).a(canvas, b + g, b + h, false);
        }

        canvas.restore();
        return bitmap;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawColor(0xff000000);
        float f1;
        float f2;
        int k;
        if (f > 1.0F)
        {
            f2 = i;
            f1 = i / f;
        } else
        {
            f2 = i;
            float f3 = f;
            f1 = i;
            f2 = f3 * f2;
        }
        canvas.drawRect(g, h, f2 + g, h + f1, c);
        canvas.save();
        k = a.size();
        for (int j = 0; j < k; j++)
        {
            ((a)a.get(j)).a(canvas, b + g, b + h, false);
        }

        canvas.restore();
    }

    public void setCollageCellsArray(List list, float f1, float f2)
    {
        a = list;
        d = f1;
        e = f2;
        f = f1 / f2;
        i = ((a)list.get(0)).o;
        if (f > 1.0F)
        {
            g = 0.0F;
            h = (i - i / f) / 2.0F;
        } else
        {
            h = 0.0F;
            g = (i - i * f) / 2.0F;
        }
        invalidate();
    }
}
