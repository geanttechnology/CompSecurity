// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import java.util.Stack;

// Referenced classes of package jumiomobile:
//            bw

public class bv extends View
{

    private int a;
    private android.graphics.Matrix.ScaleToFit b;
    private Paint c;
    private Stack d;
    private RectF e;
    private Matrix f;
    private RectF g;

    public bv(Context context)
    {
        super(context);
        a = 0xff000000;
        b = android.graphics.Matrix.ScaleToFit.CENTER;
        d = new Stack();
        f = new Matrix();
        g = new RectF();
        c = new Paint(1);
        c.setStyle(android.graphics.Paint.Style.FILL);
        c.setColor(a);
    }

    private RectF a(RectF rectf, RectF rectf1)
    {
        if (rectf1.left < rectf.left)
        {
            rectf.left = rectf1.left;
        }
        if (rectf1.right > rectf.right)
        {
            rectf.right = rectf1.right;
        }
        if (rectf1.top < rectf.top)
        {
            rectf.top = rectf1.top;
        }
        if (rectf1.bottom > rectf.bottom)
        {
            rectf.bottom = rectf1.bottom;
        }
        return rectf;
    }

    private RectF getMaxBoundsFromPaths()
    {
        int i = 1;
        RectF rectf = new RectF();
        RectF rectf1 = new RectF();
        ((Path)d.get(0)).computeBounds(rectf, true);
        for (; i < d.size(); i++)
        {
            ((Path)d.get(i)).computeBounds(rectf1, false);
            rectf = a(rectf, rectf1);
        }

        return rectf;
    }

    public int getPaintColor()
    {
        return c.getColor();
    }

    public android.graphics.Matrix.ScaleToFit getScaleType()
    {
        return b;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.concat(f);
        for (int i = 0; i < d.size(); i++)
        {
            canvas.drawPath((Path)d.get(i), c);
        }

    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        g.left = getPaddingLeft();
        g.top = getPaddingTop();
        g.right = getMeasuredWidth() - getPaddingRight();
        g.bottom = getMeasuredHeight() - getPaddingBottom();
        f.setRectToRect(e, g, b);
    }

    public void setPaintColor(int i)
    {
        c.setColor(i);
        invalidate();
    }

    public void setPathStringStack(Stack stack)
    {
        for (int i = 0; i < stack.size(); i++)
        {
            d.add(bw.a((String)stack.get(i)));
        }

        e = getMaxBoundsFromPaths();
        invalidate();
    }

    public void setScaleMatrixType(android.graphics.Matrix.ScaleToFit scaletofit)
    {
        b = scaletofit;
        invalidate();
    }
}
