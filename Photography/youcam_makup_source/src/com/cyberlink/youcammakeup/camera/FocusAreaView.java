// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class FocusAreaView extends View
{

    private static final int a[] = {
        0x7f0206cf, 0x7f0206d0, 0x7f0206d3
    };
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private RectF f;
    private float g;
    private boolean h;
    private Handler i;
    private Runnable j = new Runnable() {

        final FocusAreaView a;

        public void run()
        {
            FocusAreaView.a(a, false);
            a.invalidate();
        }

            
            {
                a = FocusAreaView.this;
                super();
            }
    };

    public FocusAreaView(Context context)
    {
        super(context);
        f = new RectF();
        h = false;
        i = new Handler();
    }

    public FocusAreaView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = new RectF();
        h = false;
        i = new Handler();
    }

    public FocusAreaView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        f = new RectF();
        h = false;
        i = new Handler();
    }

    static boolean a(FocusAreaView focusareaview, boolean flag)
    {
        focusareaview.h = flag;
        return flag;
    }

    public void a()
    {
        if (e != null)
        {
            return;
        } else
        {
            Resources resources = getResources();
            b = BitmapFactory.decodeResource(resources, a[0]);
            c = BitmapFactory.decodeResource(resources, a[1]);
            d = BitmapFactory.decodeResource(resources, a[2]);
            e = b;
            g = resources.getDimensionPixelSize(0x7f0802b5);
            return;
        }
    }

    public void a(float f1, float f2)
    {
        f.set(f1 - g, f2 - g, g + f1, g + f2);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            e = d;
        } else
        {
            e = c;
        }
        postInvalidate();
        i.postDelayed(j, 1000L);
    }

    public void b()
    {
        if (e == null)
        {
            return;
        } else
        {
            b.recycle();
            c.recycle();
            d.recycle();
            e = null;
            b = null;
            c = null;
            d = null;
            return;
        }
    }

    public void c()
    {
        h = true;
        e = b;
        i.removeCallbacks(j);
        postInvalidate();
    }

    public RectF getFocusRect()
    {
        return f;
    }

    protected void onDraw(Canvas canvas)
    {
        if (h && e != null)
        {
            canvas.drawBitmap(e, null, f, null);
        }
    }

}
