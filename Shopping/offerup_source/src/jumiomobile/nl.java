// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.view.View;

// Referenced classes of package jumiomobile:
//            no, nm, nn, bg

public class nl extends View
{

    private boolean a;
    private Paint b;
    private Paint c;
    private float d;
    private no e;
    private RectF f;
    private Xfermode g;
    private Rect h;
    private float i;
    private final float j = -90F;
    private String k;

    public nl(Context context)
    {
        super(context);
        a = false;
        i = 0.0F;
        k = "";
        b = new Paint(1);
        b.setColor(0xb3ffffff);
        b.setStyle(android.graphics.Paint.Style.STROKE);
        b.setTypeface(Typeface.create("sans-serif-light", 2));
        c = new Paint(1);
        c.setStyle(android.graphics.Paint.Style.FILL);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        e = no.a;
        setBorderWidth(3);
        g = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
        h = new Rect();
    }

    static boolean a(nl nl1, boolean flag)
    {
        nl1.a = flag;
        return flag;
    }

    private void b(PointF pointf)
    {
        pointf = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("X", new float[] {
                getX(), pointf.x - (float)getWidth() / 2.0F
            }), PropertyValuesHolder.ofFloat("Y", new float[] {
                getY(), pointf.y - (float)getHeight() / 2.0F
            })
        });
        pointf.setDuration(150L);
        pointf.addUpdateListener(new nm(this));
        pointf.addListener(new nn(this));
        pointf.start();
    }

    public void a(int l, String s)
    {
        k = s;
        setProgress(l);
        invalidate();
    }

    public void a(PointF pointf)
    {
        if (!a)
        {
            b(pointf);
        }
    }

    public void a(no no1)
    {
        e = no1;
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (f == null)
        {
            return;
        }
        int l = canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), null, 31);
        c.setXfermode(null);
        c.setStrokeWidth(d);
        canvas.drawCircle(f.centerX(), f.centerY(), f.width() / 2.0F + d, c);
        c.setXfermode(g);
        c.setStrokeWidth(0.0F);
        float f1;
        float f2;
        float f3;
        float f4;
        if (e.equals(no.a))
        {
            canvas.drawArc(f, -90F, i - 360F, true, c);
        } else
        {
            canvas.drawArc(f, -90F, 360F - i, true, c);
        }
        canvas.restoreToCount(l);
        b.getTextBounds(k, 0, k.length(), h);
        f1 = f.centerX();
        f2 = b.measureText(k) / 2.0F;
        f3 = f.centerY();
        f4 = (float)h.height() / 2.0F;
        canvas.drawText(k, f1 - f2, f3 + f4, b);
    }

    protected void onSizeChanged(int l, int i1, int j1, int k1)
    {
        super.onSizeChanged(l, i1, j1, k1);
        f = new RectF(d, d, (float)l - d, (float)i1 - d);
        b.setTextSize((float)i1 / 2.3F);
    }

    public void setBorderWidth(int l)
    {
        d = bg.a(getContext(), l);
        invalidate();
    }

    public void setColor(int l)
    {
        c.setColor(l);
        invalidate();
    }

    public void setProgress(int l)
    {
        float f1 = (360F * (float)l) / 100F;
        if (Math.ceil(f1) != Math.ceil(i))
        {
            invalidate();
        }
        i = f1;
    }
}
