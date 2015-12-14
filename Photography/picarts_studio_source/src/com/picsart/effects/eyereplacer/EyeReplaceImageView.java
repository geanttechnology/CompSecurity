// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.apiv3.util.Inventory;
import myobfuscated.bc.a;
import myobfuscated.bc.b;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            c, d

public class EyeReplaceImageView extends View
{

    RectF a;
    Bitmap b;
    c c;
    PointF d;
    float e;
    private int f;
    private int g;
    private int h;
    private RectF i;
    private Rect j;
    private boolean k;
    private PointF l;
    private float m;
    private float n;
    private Paint o;

    public EyeReplaceImageView(Context context)
    {
        super(context);
        f = 0;
        g = 0;
        h = 0;
        a = new RectF();
        i = new RectF();
        j = new Rect();
        b = null;
        k = false;
        d = new PointF();
        l = new PointF();
        e = -1F;
        m = 0.0F;
        n = 0.0F;
        o = new Paint(2);
        a();
    }

    public EyeReplaceImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = 0;
        g = 0;
        h = 0;
        a = new RectF();
        i = new RectF();
        j = new Rect();
        b = null;
        k = false;
        d = new PointF();
        l = new PointF();
        e = -1F;
        m = 0.0F;
        n = 0.0F;
        o = new Paint(2);
        a();
    }

    private void a()
    {
        super.setClickable(true);
        if (getContext().getResources().getConfiguration().orientation == 1)
        {
            f = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (b != null && !b.isRecycled())
        {
            canvas.drawBitmap(b, j, a, o);
            if (c != null)
            {
                if (k)
                {
                    Object obj = new PointF();
                    float f1 = a.width() / (float)b.getWidth();
                    if (d.x > 0.0F && d.x < (float)g && d.y > 0.0F && d.y < (float)h)
                    {
                        obj.x = d.x * f1 + a.left;
                        obj.y = d.y * f1 + a.top;
                    } else
                    {
                        obj.x = l.x / 2.0F;
                        obj.y = l.y / 2.0F;
                    }
                    c.a(((PointF) (obj)));
                    if (e > 0.0F)
                    {
                        obj = c;
                        float f2 = e;
                        ((c) (obj)).b.a(f1 * f2);
                    }
                    k = false;
                }
                obj = c;
                canvas.drawCircle(((c) (obj)).b.a.x, ((c) (obj)).b.a.y, ((c) (obj)).b.b, ((c) (obj)).c);
                canvas.drawCircle(((c) (obj)).b.a.x, ((c) (obj)).b.a.y, ((c) (obj)).b.b + 2.0F, ((c) (obj)).d);
                canvas.drawBitmap(((c) (obj)).j, ((c) (obj)).b.c.x - (float)(((c) (obj)).j.getWidth() / 2), ((c) (obj)).b.c.y - (float)(((c) (obj)).j.getHeight() / 2), ((c) (obj)).e);
                return;
            }
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        float f1 = 0.0F;
        if (Inventory.isAdsEnabled())
        {
            f1 = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        }
        int i2 = (int)((float)j1 - f1);
        f1 = Math.min((float)i1 / (float)g, (float)i2 / (float)h);
        int j2 = Math.round((float)g * f1);
        int k2 = Math.round(f1 * (float)h);
        int l2 = (i1 - j2) / 2;
        int i3 = (i2 - k2) / 2;
        a.set(l2, i3, j2 + l2, k2 + i3);
        i.set(a);
        if (c != null)
        {
            com.picsart.effects.eyereplacer.c.a(Math.min((float)i1 / 2.0F, (float)i2 / 2.0F));
        }
        l.x = i1;
        l.y = j1;
        k = true;
        super.onSizeChanged(i1, j1, k1, l1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (myobfuscated.bc.a.a().a && myobfuscated.bc.b.a().a(motionevent, a, i, 10F, 0.7F))
        {
            invalidate();
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 72
    //                   0 74
    //                   1 841
    //                   2 367;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        if (c == null) goto _L6; else goto _L5
_L5:
        c c1 = c;
        float f1 = motionevent.getX();
        float f4 = motionevent.getY();
        if (Math.sqrt(Math.pow(c1.b.a.x - f1, 2D) + Math.pow(c1.b.a.y - f4, 2D)) <= (double)c1.b.b)
        {
            c1.f = true;
            c1.h = f1;
            c1.i = f4;
            flag = true;
        } else
        {
            flag = flag1;
            if (f1 >= c1.b.c.x - (float)(c1.j.getWidth() / 2) - 5F)
            {
                flag = flag1;
                if (f1 <= c1.b.c.x + (float)(c1.j.getWidth() / 2) + 5F)
                {
                    flag = flag1;
                    if (f4 >= c1.b.c.y - (float)(c1.j.getHeight() / 2) - 5F)
                    {
                        flag = flag1;
                        if (f4 <= c1.b.c.y + (float)(c1.j.getHeight() / 2) + 5F)
                        {
                            c1.g = true;
                            c1.h = f1;
                            c1.i = f4;
                            flag = true;
                        }
                    }
                }
            }
        }
        if (flag) goto _L1; else goto _L6
_L6:
        m = motionevent.getX();
        n = motionevent.getY();
          goto _L1
_L4:
        c c2 = c;
        float f2 = motionevent.getX();
        float f5 = motionevent.getY();
        if (c2.f)
        {
            float f7 = f2 - c2.h;
            float f9 = f5 - c2.i;
            if (Math.abs(f7) >= 2.0F || Math.abs(f9) > 2.0F)
            {
                d d1 = c2.b;
                float f11 = c2.b.a.x;
                float f14 = c2.b.a.y;
                d1.a.x = f7 + f11;
                d1.a.y = f9 + f14;
                d1.a();
                c2.h = f2;
                c2.i = f5;
            }
            flag = true;
        } else
        if (c2.g)
        {
            float f8 = f2 - c2.h;
            float f10 = f5 - c2.i;
            if (Math.abs(f8) >= 2.0F || Math.abs(f10) > 2.0F)
            {
                if (f8 >= 0.0F && f10 >= 0.0F && c2.b.b + Math.max(f8, f10) <= com.picsart.effects.eyereplacer.c.a)
                {
                    d d2 = c2.b;
                    float f12 = c2.b.b;
                    d2.a(Math.max(f8, f10) + f12);
                    c2.h = f2;
                    c2.i = f5;
                } else
                if (f8 <= 0.0F && f10 <= 0.0F && c2.b.b + Math.min(f8, f10) > 7F)
                {
                    d d3 = c2.b;
                    float f13 = c2.b.b;
                    d3.a(Math.min(f8, f10) + f13);
                    c2.h = f2;
                    c2.i = f5;
                }
            }
            flag = true;
        }
        if (flag)
        {
            invalidate();
        } else
        {
            float f3 = motionevent.getX() - m;
            float f6 = motionevent.getY() - n;
            if (Math.abs(f3) >= 2.0F || Math.abs(f6) > 2.0F)
            {
                a.set(a.left + f3, a.top + f6, f3 + a.right, f6 + a.bottom);
                invalidate();
                m = motionevent.getX();
                n = motionevent.getY();
            }
        }
          goto _L1
_L3:
        motionevent = c;
        motionevent.f = false;
        motionevent.g = false;
        return false;
    }

    public void setImageFitCenter(Bitmap bitmap)
    {
        b = bitmap;
        g = bitmap.getWidth();
        h = bitmap.getHeight();
        float f2 = getWidth();
        float f1 = f2;
        if (f2 == 0.0F)
        {
            f1 = (float)getContext().getResources().getDisplayMetrics().widthPixels - 0.0F;
        }
        float f3 = getHeight();
        f2 = f3;
        if (f3 == 0.0F)
        {
            f2 = (float)getContext().getResources().getDisplayMetrics().heightPixels - (float)f;
        }
        f3 = Math.min(f1 / (float)g, f2 / (float)h);
        int i1 = Math.round((float)g * f3);
        int j1 = Math.round(f3 * (float)h);
        int k1 = (int)((f1 - (float)i1) / 2.0F);
        int l1 = (int)((f2 - (float)j1) / 2.0F);
        a.set(k1, l1, i1 + k1, j1 + l1);
        i.set(a);
        j.set(0, 0, g, h);
        c.a(new PointF(f1 / 2.0F, f2 / 2.0F));
        com.picsart.effects.eyereplacer.c.a(Math.min(f1 / 2.0F, f2 / 2.0F));
        invalidate();
    }

    public void setTouchCircleDrawer(c c1)
    {
        c = c1;
    }
}
