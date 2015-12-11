// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            fq, fs, hx

public final class fp extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{

    public Drawable a;
    private int b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private fs k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;

    public fp(Drawable drawable, Drawable drawable1)
    {
        this(null);
        Object obj = drawable;
        if (drawable == null)
        {
            obj = fq.a();
        }
        l = ((Drawable) (obj));
        ((Drawable) (obj)).setCallback(this);
        drawable = k;
        drawable.b = ((fs) (drawable)).b | ((Drawable) (obj)).getChangingConfigurations();
        drawable = drawable1;
        if (drawable1 == null)
        {
            drawable = fq.a();
        }
        a = drawable;
        drawable.setCallback(this);
        drawable1 = k;
        drawable1.b = ((fs) (drawable1)).b | drawable.getChangingConfigurations();
    }

    fp(fs fs1)
    {
        b = 0;
        f = 255;
        h = 0;
        i = true;
        k = new fs(fs1);
    }

    private boolean b()
    {
        if (!m)
        {
            boolean flag;
            if (l.getConstantState() != null && a.getConstantState() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            n = flag;
            m = true;
        }
        return n;
    }

    public final void a()
    {
        d = 0;
        e = f;
        h = 0;
        g = 250;
        b = 1;
        invalidateSelf();
    }

    public final void draw(Canvas canvas)
    {
        int i1;
        int j1;
        boolean flag;
        j1 = 1;
        i1 = 1;
        flag = false;
        b;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 106
    //                   2 125;
           goto _L1 _L2 _L3
_L1:
        Drawable drawable;
        Drawable drawable1;
        boolean flag1;
        j1 = h;
        flag1 = i;
        drawable = l;
        drawable1 = a;
        if (i1 != 0)
        {
            if (!flag1 || j1 == 0)
            {
                drawable.draw(canvas);
            }
            if (j1 == f)
            {
                drawable1.setAlpha(f);
                drawable1.draw(canvas);
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        c = SystemClock.uptimeMillis();
        b = 2;
        i1 = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (c >= 0L)
        {
            float f1 = (float)(SystemClock.uptimeMillis() - c) / (float)g;
            float f2;
            if (f1 >= 1.0F)
            {
                i1 = j1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                b = 0;
            }
            f1 = Math.min(f1, 1.0F);
            f2 = d;
            h = (int)(f1 * (float)(e - d) + f2);
        }
        continue; /* Loop/switch isn't completed */
        if (flag1)
        {
            drawable.setAlpha(f - j1);
        }
        drawable.draw(canvas);
        if (flag1)
        {
            drawable.setAlpha(f);
        }
        if (j1 > 0)
        {
            drawable1.setAlpha(j1);
            drawable1.draw(canvas);
            drawable1.setAlpha(f);
        }
        invalidateSelf();
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | k.a | k.b;
    }

    public final android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        if (b())
        {
            k.a = getChangingConfigurations();
            return k;
        } else
        {
            return null;
        }
    }

    public final int getIntrinsicHeight()
    {
        return Math.max(l.getIntrinsicHeight(), a.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth()
    {
        return Math.max(l.getIntrinsicWidth(), a.getIntrinsicWidth());
    }

    public final int getOpacity()
    {
        if (!o)
        {
            p = Drawable.resolveOpacity(l.getOpacity(), a.getOpacity());
            o = true;
        }
        return p;
    }

    public final void invalidateDrawable(Drawable drawable)
    {
        if (hx.a(11))
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.invalidateDrawable(this);
            }
        }
    }

    public final Drawable mutate()
    {
        if (!j && super.mutate() == this)
        {
            if (!b())
            {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            l.mutate();
            a.mutate();
            j = true;
        }
        return this;
    }

    protected final void onBoundsChange(Rect rect)
    {
        l.setBounds(rect);
        a.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long l1)
    {
        if (hx.a(11))
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.scheduleDrawable(this, runnable, l1);
            }
        }
    }

    public final void setAlpha(int i1)
    {
        if (h == f)
        {
            h = i1;
        }
        f = i1;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        l.setColorFilter(colorfilter);
        a.setColorFilter(colorfilter);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (hx.a(11))
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.unscheduleDrawable(this, runnable);
            }
        }
    }
}
