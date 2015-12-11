// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class bx extends View
{

    private int a;
    private int b;
    private BitmapShader c;
    private Paint d;
    private Matrix e;
    private RectF f;
    private float g;

    public bx(Context context)
    {
        super(context);
        a = 0;
        b = 0;
        a();
    }

    private void a()
    {
        d = new Paint();
        d.setAntiAlias(true);
    }

    private void b()
    {
        e = new Matrix();
        f = new RectF(0.0F, 0.0F, a, b);
        RectF rectf = new RectF(0.0F, 0.0F, getWidth(), getHeight());
        e.setRectToRect(f, rectf, android.graphics.Matrix.ScaleToFit.CENTER);
    }

    public void a(Bitmap bitmap, float f1)
    {
        a = bitmap.getWidth();
        b = bitmap.getHeight();
        g = f1;
        b();
        c = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        d.setShader(c);
        requestLayout();
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        canvas.save();
        canvas.concat(e);
        canvas.drawRoundRect(f, g, g, d);
        canvas.restore();
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag1 = false;
        int k = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getSize(j);
        boolean flag;
        if (k == 0x80000000 || k == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (l == 0x80000000 || l == 0)
        {
            flag1 = true;
        }
        l = i;
        if (flag)
        {
            l = i;
            if (a != 0)
            {
                l = i;
                if (j1 < a)
                {
                    l = android.view.View.MeasureSpec.makeMeasureSpec(a, 0x40000000);
                }
            }
        }
        i = j;
        if (flag1)
        {
            i = j;
            if (b != 0)
            {
                i = j;
                if (i1 < b)
                {
                    i = android.view.View.MeasureSpec.makeMeasureSpec(b, 0x40000000);
                }
            }
        }
        super.onMeasure(l, i);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        b();
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        a(bitmap, 0.0F);
    }
}
