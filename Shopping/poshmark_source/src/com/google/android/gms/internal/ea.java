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
//            fr

public final class ea extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{
    private static final class a extends Drawable
    {

        private static final a Bh = new a();
        private static final a Bi = new a();

        static a dP()
        {
            return Bh;
        }

        public void draw(Canvas canvas)
        {
        }

        public android.graphics.drawable.Drawable.ConstantState getConstantState()
        {
            return Bi;
        }

        public int getOpacity()
        {
            return -2;
        }

        public void setAlpha(int i)
        {
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
        }


        private a()
        {
        }
    }

    private static final class a.a extends android.graphics.drawable.Drawable.ConstantState
    {

        public int getChangingConfigurations()
        {
            return 0;
        }

        public Drawable newDrawable()
        {
            return a.dP();
        }

        private a.a()
        {
        }

    }

    static final class b extends android.graphics.drawable.Drawable.ConstantState
    {

        int Bj;
        int Bk;

        public int getChangingConfigurations()
        {
            return Bj;
        }

        public Drawable newDrawable()
        {
            return new ea(this);
        }

        b(b b1)
        {
            if (b1 != null)
            {
                Bj = b1.Bj;
                Bk = b1.Bk;
            }
        }
    }


    private boolean AO;
    private int AS;
    private long AT;
    private int AU;
    private int AV;
    private int AW;
    private int AX;
    private int AY;
    private boolean AZ;
    private b Ba;
    private Drawable Bb;
    private Drawable Bc;
    private boolean Bd;
    private boolean Be;
    private boolean Bf;
    private int Bg;

    public ea(Drawable drawable, Drawable drawable1)
    {
        this(null);
        Object obj = drawable;
        if (drawable == null)
        {
            obj = a.dP();
        }
        Bb = ((Drawable) (obj));
        ((Drawable) (obj)).setCallback(this);
        drawable = Ba;
        drawable.Bk = ((b) (drawable)).Bk | ((Drawable) (obj)).getChangingConfigurations();
        drawable = drawable1;
        if (drawable1 == null)
        {
            drawable = a.dP();
        }
        Bc = drawable;
        drawable.setCallback(this);
        drawable1 = Ba;
        drawable1.Bk = ((b) (drawable1)).Bk | drawable.getChangingConfigurations();
    }

    ea(b b1)
    {
        AS = 0;
        AW = 255;
        AY = 0;
        AO = true;
        Ba = new b(b1);
    }

    public boolean canConstantState()
    {
        if (!Bd)
        {
            boolean flag;
            if (Bb.getConstantState() != null && Bc.getConstantState() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Be = flag;
            Bd = true;
        }
        return Be;
    }

    public Drawable dO()
    {
        return Bc;
    }

    public void draw(Canvas canvas)
    {
        int i;
        int j;
        boolean flag;
        j = 1;
        i = 1;
        flag = false;
        AS;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 106
    //                   2 125;
           goto _L1 _L2 _L3
_L1:
        Drawable drawable;
        Drawable drawable1;
        boolean flag1;
        j = AY;
        flag1 = AO;
        drawable = Bb;
        drawable1 = Bc;
        if (i != 0)
        {
            if (!flag1 || j == 0)
            {
                drawable.draw(canvas);
            }
            if (j == AW)
            {
                drawable1.setAlpha(AW);
                drawable1.draw(canvas);
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        AT = SystemClock.uptimeMillis();
        AS = 2;
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (AT >= 0L)
        {
            float f = (float)(SystemClock.uptimeMillis() - AT) / (float)AX;
            float f1;
            if (f >= 1.0F)
            {
                i = j;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                AS = 0;
            }
            f = Math.min(f, 1.0F);
            f1 = AU;
            AY = (int)(f * (float)(AV - AU) + f1);
        }
        continue; /* Loop/switch isn't completed */
        if (flag1)
        {
            drawable.setAlpha(AW - j);
        }
        drawable.draw(canvas);
        if (flag1)
        {
            drawable.setAlpha(AW);
        }
        if (j > 0)
        {
            drawable1.setAlpha(j);
            drawable1.draw(canvas);
            drawable1.setAlpha(AW);
        }
        invalidateSelf();
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | Ba.Bj | Ba.Bk;
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        if (canConstantState())
        {
            Ba.Bj = getChangingConfigurations();
            return Ba;
        } else
        {
            return null;
        }
    }

    public int getIntrinsicHeight()
    {
        return Math.max(Bb.getIntrinsicHeight(), Bc.getIntrinsicHeight());
    }

    public int getIntrinsicWidth()
    {
        return Math.max(Bb.getIntrinsicWidth(), Bc.getIntrinsicWidth());
    }

    public int getOpacity()
    {
        if (!Bf)
        {
            Bg = Drawable.resolveOpacity(Bb.getOpacity(), Bc.getOpacity());
            Bf = true;
        }
        return Bg;
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (fr.eJ())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate()
    {
        if (!AZ && super.mutate() == this)
        {
            if (!canConstantState())
            {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            Bb.mutate();
            Bc.mutate();
            AZ = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        Bb.setBounds(rect);
        Bc.setBounds(rect);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        if (fr.eJ())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.scheduleDrawable(this, runnable, l);
            }
        }
    }

    public void setAlpha(int i)
    {
        if (AY == AW)
        {
            AY = i;
        }
        AW = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        Bb.setColorFilter(colorfilter);
        Bc.setColorFilter(colorfilter);
    }

    public void startTransition(int i)
    {
        AU = 0;
        AV = AW;
        AY = 0;
        AX = i;
        AS = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (fr.eJ())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.unscheduleDrawable(this, runnable);
            }
        }
    }
}
