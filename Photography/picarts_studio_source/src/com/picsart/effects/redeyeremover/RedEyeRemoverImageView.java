// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import myobfuscated.bc.a;
import myobfuscated.bc.b;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            a, b

public class RedEyeRemoverImageView extends ImageView
{

    RectF a;
    RectF b;
    com.picsart.effects.redeyeremover.a c;
    Bitmap d;
    ByteBuffer e;
    ByteBuffer f;
    Point g;
    float h;
    private int i;
    private int j;
    private int k;
    private RectF l;
    private Paint m;
    private float n;
    private float o;
    private Matrix p;
    private boolean q;
    private Point r;

    public RedEyeRemoverImageView(Context context)
    {
        super(context);
        i = 0;
        j = 0;
        k = 0;
        a = new RectF();
        l = new RectF();
        b = new RectF();
        m = new Paint();
        n = 0.0F;
        o = 0.0F;
        c = null;
        d = null;
        e = null;
        f = null;
        p = new Matrix();
        q = false;
        g = new Point();
        r = new Point();
        h = -1F;
        b();
    }

    public RedEyeRemoverImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        i = 0;
        j = 0;
        k = 0;
        a = new RectF();
        l = new RectF();
        b = new RectF();
        m = new Paint();
        n = 0.0F;
        o = 0.0F;
        c = null;
        d = null;
        e = null;
        f = null;
        p = new Matrix();
        q = false;
        g = new Point();
        r = new Point();
        h = -1F;
        b();
    }

    private void b()
    {
        super.setClickable(true);
        if (getContext().getResources().getConfiguration().orientation == 1)
        {
            i = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        }
        m.setColor(0xff000000);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    public final void a()
    {
        if (d != null && !d.isRecycled())
        {
            com.socialin.android.util.c.a(d);
            d = null;
        }
        if (e != null)
        {
            ImageOp.a(e);
        }
        if (f != null)
        {
            ImageOp.a(f);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        Bitmap bitmap = null;
        if (getDrawable() != null)
        {
            bitmap = ((BitmapDrawable)getDrawable()).getBitmap();
        }
        if (bitmap == null || !bitmap.isRecycled())
        {
            super.onDraw(canvas);
            if (c != null)
            {
                if (q)
                {
                    float af[] = new float[9];
                    getImageMatrix().getValues(af);
                    float f1;
                    float f2;
                    com.picsart.effects.redeyeremover.a a1;
                    com.picsart.effects.redeyeremover.a a2;
                    if (g.x > 0 && g.x < j && g.y > 0 && g.y < k)
                    {
                        f1 = g.x;
                        f2 = af[0];
                        f2 = af[2] + f1 * f2;
                        f1 = (float)g.y * af[4] + af[5];
                    } else
                    {
                        f2 = (float)r.x / 2.0F;
                        f1 = (float)r.y / 2.0F;
                    }
                    a2 = c;
                    if (a2.b != null)
                    {
                        a2.b.a(f2, f1);
                    }
                    if (h > 0.0F)
                    {
                        com.picsart.effects.redeyeremover.a a3 = c;
                        f1 = af[0] / h;
                        a3.b.a(a3.b.b * f1);
                    }
                    q = false;
                }
                a1 = c;
                canvas.drawCircle(a1.b.a.x, a1.b.a.y, a1.b.b, a1.c);
                canvas.drawCircle(a1.b.a.x, a1.b.a.y, a1.b.b + 2.0F, a1.d);
                canvas.drawBitmap(a1.j, a1.b.c.x - (float)(a1.j.getWidth() / 2), a1.b.c.y - (float)(a1.j.getHeight() / 2), a1.e);
                return;
            }
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        q = true;
        int j2 = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        int i2 = 0;
        if (Inventory.isAdsEnabled())
        {
            i2 = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        }
        r.x = i1;
        r.y = j1 - j2;
        int i3 = j1 - (i2 + j2);
        float f1 = Math.min((float)i1 / (float)j, (float)i3 / (float)k);
        i2 = Math.round((float)j * f1);
        int k2 = Math.round(f1 * (float)k);
        int l2 = (i1 - i2) / 2;
        j2 = (i3 - k2) / 2 + j2;
        a.set(l2, j2, i2 + l2, j2 + k2);
        l.set(a);
        p.setRectToRect(b, a, android.graphics.Matrix.ScaleToFit.START);
        setImageMatrix(p);
        super.onSizeChanged(i1, j1, k1, l1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (myobfuscated.bc.a.a().a && myobfuscated.bc.b.a().a(motionevent, a, l, 8F, 0.7F))
        {
            p.setRectToRect(b, a, android.graphics.Matrix.ScaleToFit.START);
            setImageMatrix(p);
            invalidate();
            return true;
        }
        if (c == null)
        {
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 112
    //                   0 114
    //                   1 873
    //                   2 400;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        com.picsart.effects.redeyeremover.a a1 = c;
        float f1 = motionevent.getX();
        float f4 = motionevent.getY();
        if (Math.sqrt(Math.pow(a1.b.a.x - f1, 2D) + Math.pow(a1.b.a.y - f4, 2D)) <= (double)a1.b.b)
        {
            a1.f = true;
            a1.h = f1;
            a1.i = f4;
            flag = true;
        } else
        {
            flag = flag1;
            if (f1 >= a1.b.c.x - (float)(a1.j.getWidth() / 2) - 5F)
            {
                flag = flag1;
                if (f1 <= a1.b.c.x + (float)(a1.j.getWidth() / 2) + 5F)
                {
                    flag = flag1;
                    if (f4 >= a1.b.c.y - (float)(a1.j.getHeight() / 2) - 5F)
                    {
                        flag = flag1;
                        if (f4 <= a1.b.c.y + (float)(a1.j.getHeight() / 2) + 5F)
                        {
                            a1.g = true;
                            a1.h = f1;
                            a1.i = f4;
                            flag = true;
                        }
                    }
                }
            }
        }
        if (!flag)
        {
            n = motionevent.getX();
            o = motionevent.getY();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        com.picsart.effects.redeyeremover.a a2 = c;
        float f2 = motionevent.getX();
        float f5 = motionevent.getY();
        if (a2.f)
        {
            float f7 = f2 - a2.h;
            float f9 = f5 - a2.i;
            if (Math.abs(f7) >= 2.0F || Math.abs(f9) > 2.0F)
            {
                a2.b.a(f7 + a2.b.a.x, f9 + a2.b.a.y);
                a2.h = f2;
                a2.i = f5;
            }
            flag = true;
        } else
        if (a2.g)
        {
            float f8 = f2 - a2.h;
            float f10 = f5 - a2.i;
            if (Math.abs(f8) >= 2.0F || Math.abs(f10) > 2.0F)
            {
                if (f8 >= 0.0F && f10 >= 0.0F && a2.b.b + Math.max(f8, f10) <= com.picsart.effects.redeyeremover.a.a)
                {
                    com.picsart.effects.redeyeremover.b b1 = a2.b;
                    float f11 = a2.b.b;
                    b1.a(Math.max(f8, f10) + f11);
                    a2.h = f2;
                    a2.i = f5;
                } else
                if (f8 <= 0.0F && f10 <= 0.0F && a2.b.b + Math.min(f8, f10) > 5F)
                {
                    com.picsart.effects.redeyeremover.b b2 = a2.b;
                    float f12 = a2.b.b;
                    b2.a(Math.min(f8, f10) + f12);
                    a2.h = f2;
                    a2.i = f5;
                }
            }
            flag = true;
        }
        if (flag)
        {
            invalidate();
        } else
        {
            float f3 = motionevent.getX() - n;
            float f6 = motionevent.getY() - o;
            if (Math.abs(f3) >= 2.0F || Math.abs(f6) > 2.0F)
            {
                a.set(a.left + f3, a.top + f6, f3 + a.right, f6 + a.bottom);
                p.setRectToRect(b, a, android.graphics.Matrix.ScaleToFit.START);
                setImageMatrix(p);
                invalidate();
                n = motionevent.getX();
                o = motionevent.getY();
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        motionevent = c;
        motionevent.f = false;
        motionevent.g = false;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setImageFitCenter(Bitmap bitmap, com.picsart.effects.redeyeremover.a a1)
    {
        d = bitmap;
        super.setImageBitmap(bitmap);
        j = bitmap.getWidth();
        k = bitmap.getHeight();
        if (e != null)
        {
            ImageOp.a(e);
            e = null;
        }
        if (f != null)
        {
            ImageOp.a(f);
            f = null;
        }
        e = ImageOp.a(j * k * 4);
        e.position(0);
        bitmap.copyPixelsToBuffer(e);
        f = ImageOp.a(j * k * 4);
        f.position(0);
        bitmap.copyPixelsToBuffer(f);
        float f2 = getWidth();
        float f1 = f2;
        if (f2 == 0.0F)
        {
            Log.e("RedEyeRemoverImageView", (new StringBuilder("width = ")).append(f2).toString());
            f1 = (float)getContext().getResources().getDisplayMetrics().widthPixels - 0.0F;
        }
        float f3 = getHeight();
        f2 = f3;
        if (f3 == 0.0F)
        {
            Log.e("RedEyeRemoverImageView", (new StringBuilder("height = ")).append(f3).toString());
            f2 = (float)getContext().getResources().getDisplayMetrics().heightPixels - (float)i;
        }
        f3 = Math.min(f1 / (float)j, f2 / (float)k);
        int i1 = Math.round((float)j * f3);
        int j1 = Math.round(f3 * (float)k);
        int k1 = (int)((f1 - (float)i1) / 2.0F);
        int l1 = (int)((f2 - (float)j1) / 2.0F);
        a.set(k1, l1, i1 + k1, j1 + l1);
        l.set(a);
        b.set(0.0F, 0.0F, j, k);
        p.setRectToRect(b, a, android.graphics.Matrix.ScaleToFit.START);
        setImageMatrix(p);
        c = a1;
        bitmap = new PointF(f1 / 2.0F, f2 / 2.0F);
        a1.b = new com.picsart.effects.redeyeremover.b(bitmap, 25F);
        com.picsart.effects.redeyeremover.a.a = Math.min(((PointF) (bitmap)).x, ((PointF) (bitmap)).y);
        g.x = j / 2;
        g.y = k / 2;
        invalidate();
    }
}
