// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sonyericsson.zoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.sonyericsson.zoom:
//            a, c, b

public class ImageZoomView extends ImageView
    implements Observer
{

    private Paint a;
    private Rect b;
    private Rect c;
    public a e;
    public Bitmap f;
    public c g;
    public b h;

    public ImageZoomView(Context context)
    {
        super(context);
        a = new Paint(2);
        b = new Rect();
        c = new Rect();
        e = new a();
    }

    public ImageZoomView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new Paint(2);
        b = new Rect();
        c = new Rect();
        e = new a();
    }

    public void a()
    {
        g.c(0.5F);
        g.d(0.5F);
        g.e(1.0F);
        g.notifyObservers();
    }

    public final int c()
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (f != null)
        {
            i = ((flag) ? 1 : 0);
            if (g != null)
            {
                float f1 = e.a;
                int l = f.getWidth();
                int j = getWidth();
                f1 = (Math.min(1.0F, f1 * 1.0F) * (float)j) / (float)l;
                i = (int)(0.5F * (float)l - (float)j / (2.0F * f1));
                float f2 = i;
                int i1 = (int)((float)j / f1 + f2);
                int k;
                if (i < 0)
                {
                    i = (int)((float)(-i) * f1 + 0.0F);
                } else
                {
                    i = 0;
                }
                k = getRight() - getLeft();
                j = k;
                if (i1 > l)
                {
                    j = (int)((float)k - (float)(i1 - l) * f1);
                }
                if (c.left > i + 0)
                {
                    i = 1;
                } else
                {
                    i = ((flag) ? 1 : 0);
                    if (c.right < j + 0)
                    {
                        return 2;
                    }
                }
            }
        }
        return i;
    }

    public void onDraw(Canvas canvas)
    {
        if (f != null && g != null && !f.isRecycled())
        {
            float f2 = e.a;
            int k = getWidth();
            int l = getHeight();
            int i = f.getWidth();
            int j = f.getHeight();
            float f3 = g.b;
            float f4 = g.c;
            float f1 = (g.a(f2) * (float)k) / (float)i;
            f2 = (g.b(f2) * (float)l) / (float)j;
            b.left = (int)(f3 * (float)i - (float)k / (f1 * 2.0F));
            b.top = (int)(f4 * (float)j - (float)l / (f2 * 2.0F));
            Rect rect = b;
            f3 = b.left;
            rect.right = (int)((float)k / f1 + f3);
            rect = b;
            f3 = b.top;
            rect.bottom = (int)((float)l / f2 + f3);
            k = getLeft();
            c.left = 0;
            c.top = getTop();
            c.right = getRight() - k;
            c.bottom = getBottom();
            if (b.left < 0)
            {
                Rect rect1 = c;
                rect1.left = (int)((float)rect1.left + (float)(-b.left) * f1);
                b.left = 0;
            }
            if (b.right > i)
            {
                Rect rect2 = c;
                rect2.right = (int)((float)rect2.right - (float)(b.right - i) * f1);
                b.right = i;
            }
            if (b.top < 0)
            {
                Rect rect3 = c;
                rect3.top = (int)((float)rect3.top + (float)(-b.top) * f2);
                b.top = 0;
            }
            if (b.bottom > j)
            {
                Rect rect4 = c;
                rect4.bottom = (int)((float)rect4.bottom - f2 * (float)(b.bottom - j));
                b.bottom = j;
            }
            canvas.drawBitmap(f, b, c, a);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (f != null)
        {
            e.a(k - i, l - j, f.getWidth(), f.getHeight());
            e.notifyObservers();
        }
    }

    public void setImage(Bitmap bitmap)
    {
        f = bitmap;
        e.a(getWidth(), getHeight(), f.getWidth(), f.getHeight());
        e.notifyObservers();
        invalidate();
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        super.setOnTouchListener(ontouchlistener);
    }

    public void setZoomControl(b b1)
    {
        h = b1;
        if (h != null)
        {
            setZoomState(h.a);
        }
    }

    public void setZoomState(c c1)
    {
        if (g != null)
        {
            g.deleteObserver(this);
        }
        g = c1;
        g.addObserver(this);
        invalidate();
    }

    public void update(Observable observable, Object obj)
    {
        invalidate();
    }
}
