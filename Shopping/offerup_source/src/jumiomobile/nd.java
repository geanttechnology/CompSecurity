// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;

// Referenced classes of package jumiomobile:
//            nh, bg, ne, nf, 
//            at, ng

public class nd extends View
{

    private ProgressBar A;
    private ng B;
    float a;
    float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private PorterDuffXfermode i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    private Bitmap m;
    private Bitmap n;
    private int o;
    private int p;
    private nh q;
    private Paint r;
    private Paint s;
    private int t;
    private int u;
    private int v;
    private String w;
    private String x;
    private Bitmap y;
    private Bitmap z;

    public nd(Context context)
    {
        super(context);
        a = 0.0F;
        b = 0.0F;
        q = nh.b;
        t = 0xff000000;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        g = bg.b(context, 17F);
        c = bg.a(context, 2.0F);
        d = bg.a(context, 10F);
        e = bg.a(context, 21F);
        f = bg.a(context, 20F);
        i = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP);
        r = new Paint();
        r.setFilterBitmap(false);
        s = new Paint();
        s.setAntiAlias(true);
        s.setColor(-1);
        s.setTextSize(g);
        s.setTypeface(Typeface.create("sans-serif-light", 0));
        h = 1.0F;
    }

    static float a(nd nd1)
    {
        return nd1.h;
    }

    static float a(nd nd1, float f1)
    {
        nd1.h = f1;
        return f1;
    }

    private Bitmap a(int i1, int j1)
    {
        int k1 = i1 / 2;
        Bitmap bitmap = Bitmap.createBitmap((int)(e + c / 2.0F) + k1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        if (q == nh.c)
        {
            i1 = p;
        } else
        {
            i1 = o;
        }
        paint.setColor(i1);
        canvas.drawRect(0.0F, 0.0F, k1, j1, paint);
        canvas.drawCircle(k1, (float)j1 / 2.0F, e, paint);
        return bitmap;
    }

    private Bitmap a(int i1, int j1, boolean flag)
    {
        i1 /= 2;
        Bitmap bitmap = Bitmap.createBitmap((int)e + i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        if (flag)
        {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
        }
        paint.setColor(t);
        paint.setStrokeWidth(c);
        canvas.drawCircle(e + c / 2.0F, (float)j1 / 2.0F, e, paint);
        canvas.drawRect(e * 2.0F - c / 2.0F, (float)j1 / 2.0F - d / 2.0F, ((float)i1 - e) + c / 2.0F, (float)j1 / 2.0F + d / 2.0F, paint);
        canvas.drawCircle((float)i1 - f - c / 2.0F, (float)j1 / 2.0F, e, paint);
        return bitmap;
    }

    private void a()
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.setDuration(600L);
        valueanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueanimator.addUpdateListener(new ne(this));
        valueanimator.addListener(new nf(this));
        valueanimator.start();
    }

    static void a(nd nd1, nh nh1)
    {
        nd1.setStatus(nh1);
    }

    static ng b(nd nd1)
    {
        return nd1.B;
    }

    private void setStatus(nh nh1)
    {
        boolean flag;
        if (nh1 == nh.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        if (q != nh1)
        {
            q = nh1;
            if (j != null)
            {
                j.recycle();
            }
            if (u != 0 && v != 0)
            {
                j = a(u, v);
                return;
            }
        }
    }

    public void a(boolean flag)
    {
        ProgressBar progressbar = A;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        progressbar.setVisibility(i1);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(l, b + f, 0.0F, r);
        canvas.drawText(w, (b + f + e) - s.measureText(w) / 2.0F, (float)canvas.getHeight() / 2.0F + e * 2.0F, s);
        canvas.drawText(x, (b + (float)canvas.getWidth() / 2.0F) - c / 2.0F - s.measureText(x) / 2.0F, (float)canvas.getHeight() / 2.0F + e * 2.0F, s);
        int i1 = canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), null, 31);
        canvas.drawBitmap(k, b + f, 0.0F, r);
        r.setXfermode(i);
        canvas.drawBitmap(j, 0.0F, 0.0F, r);
        r.setXfermode(null);
        canvas.restoreToCount(i1);
        if (y != null)
        {
            canvas.drawBitmap(y, (b + c / 2.0F + f + e) - (float)y.getWidth() / 2.0F, (float)canvas.getHeight() / 2.0F - (float)y.getHeight() / 2.0F, null);
        }
        if (z != null)
        {
            canvas.drawBitmap(z, (b + (float)canvas.getWidth() / 2.0F) - c / 2.0F - (float)z.getWidth() / 2.0F, (float)canvas.getHeight() / 2.0F - (float)z.getHeight() / 2.0F, null);
        }
    }

    public void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        i1 = (int)(4F * e + 2.0F * g);
        int k1 = android.view.View.MeasureSpec.getMode(j1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        u = getMeasuredWidth();
        if (k1 == 0x40000000)
        {
            v = j1;
        } else
        if (k1 == 0x80000000)
        {
            v = Math.min(i1, j1);
        } else
        {
            v = i1;
        }
        setMeasuredDimension(u, v);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (j1 == 0 || u == 0)
        {
            return;
        } else
        {
            j = a(u, j1);
            k = a(u, j1, false);
            l = a(u, j1, true);
            a = (float)(u / 2 - (int)e) - f - c / 2.0F;
            b = a * h;
            return;
        }
    }

    public void setCallback(ng ng1)
    {
        B = ng1;
    }

    public void setErrorColor(int i1)
    {
        p = i1;
    }

    public void setErrorIcon(Bitmap bitmap)
    {
        n = bitmap;
    }

    public void setFinishStatus(nh nh1)
    {
        if (nh1 == nh.b)
        {
            z = m;
        } else
        if (nh1 == nh.c)
        {
            z = n;
        } else
        {
            z = null;
        }
        setStatus(nh1);
        invalidate();
    }

    public void setFinishText(String s1)
    {
        x = s1;
    }

    public void setLoadingIndicator(ProgressBar progressbar)
    {
        A = progressbar;
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)progressbar.getLayoutParams();
        layoutparams.topMargin = (int)(2.0F * e + g) - layoutparams.height / 2;
        progressbar.setLayoutParams(layoutparams);
        at.a(progressbar.getIndeterminateDrawable(), -1);
    }

    public void setOKColor(int i1)
    {
        o = i1;
    }

    public void setOKIcon(Bitmap bitmap)
    {
        m = bitmap;
    }

    public void setTextColor(int i1)
    {
        s.setColor(i1);
    }

    public void setTrackColor(int i1)
    {
        t = i1;
        if (k != null && l != null)
        {
            k.recycle();
            k = a(u, v, false);
            l.recycle();
            l = a(u, v, true);
            invalidate();
        }
    }

    public void setUploadStatus(nh nh1)
    {
        if (nh1 == nh.b)
        {
            y = m;
            a();
            B.g();
        } else
        if (nh1 == nh.c)
        {
            y = n;
        } else
        {
            y = null;
        }
        setStatus(nh1);
        invalidate();
    }

    public void setUploadText(String s1)
    {
        w = s1;
    }
}
