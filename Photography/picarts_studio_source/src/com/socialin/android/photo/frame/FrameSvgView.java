// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.brushlib.svg.e;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.l;

public class FrameSvgView extends View
{

    static final String a = com/socialin/android/photo/frame/FrameSvgView.getSimpleName();
    private static boolean i;
    private static float j = 4F;
    private static float k = 0.2F;
    private static final Paint l = new Paint(3);
    boolean b;
    int c;
    Bitmap d;
    Path e;
    RectF f;
    ScaleRotateGestureDetector g;
    RectF h;
    private Paint m;
    private Paint n;
    private RectF o;
    private RectF p;
    private Matrix q;
    private Matrix r;
    private boolean s;

    public FrameSvgView(Context context, AttributeSet attributeset)
    {
        boolean flag = true;
        super(context, attributeset);
        m = new Paint();
        n = new Paint();
        e = new Path();
        o = new RectF();
        f = new RectF();
        p = new RectF();
        q = new Matrix();
        r = new Matrix();
        s = true;
        h = new RectF();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setLayerType(1, null);
        }
        context = getResources();
        float f1 = j;
        float f2 = k;
        if (i)
        {
            flag = false;
        }
        g = new ScaleRotateGestureDetector(context, f1, f2, flag);
        m.setColor(0xbb000000);
        m.setStyle(android.graphics.Paint.Style.FILL);
        n.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        n.setStyle(android.graphics.Paint.Style.FILL);
    }

    public static int b()
    {
        return 42;
    }

    final Path a()
    {
        e e1 = new e();
        e1.a(getContext().getResources().openRawResource(c), "isFrame");
        return e1.a;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (b)
        {
            canvas.save();
            canvas.drawBitmap(d, g.f, l);
            canvas.saveLayer(o, m, 31);
            canvas.drawRect(o, m);
            canvas.concat(q);
            canvas.drawPath(e, n);
            canvas.restore();
            canvas.restore();
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        o.set(0.0F, 0.0F, i1, j1);
        if (s)
        {
            s = false;
            if (b)
            {
                r.setRectToRect(f, o, android.graphics.Matrix.ScaleToFit.CENTER);
                g.a(r);
                float f1 = com.socialin.android.util.l.a(r);
                if (k > f1)
                {
                    k = f1;
                }
                if (j < f1)
                {
                    j = f1;
                }
                g.a(j, k);
                q.setRectToRect(p, f, android.graphics.Matrix.ScaleToFit.CENTER);
                q.postConcat(r);
            }
            return;
        } else
        {
            Matrix matrix = new Matrix();
            matrix.setTranslate((i1 - k1) / 2, (j1 - l1) / 2);
            q.postConcat(matrix);
            r = g.f;
            r.postConcat(matrix);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        g.a(motionevent);
        invalidate();
        return true;
    }

    public void setSvgColor(int i1)
    {
    }

    public void setSvgRes(int i1)
    {
        c = i1;
        r.setRectToRect(f, o, android.graphics.Matrix.ScaleToFit.CENTER);
        g.a(r);
        float f1 = com.socialin.android.util.l.a(r);
        if (k > f1)
        {
            k = f1;
        }
        if (j < f1)
        {
            j = f1;
        }
        g.a(j, k);
        q.setRectToRect(p, f, android.graphics.Matrix.ScaleToFit.CENTER);
        q.postConcat(r);
        e.set(a());
        invalidate();
    }

    static 
    {
        i = Build.MODEL.equals("Nexus One");
    }
}
