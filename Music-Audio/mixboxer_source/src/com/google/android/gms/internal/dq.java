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
//            fg

public final class dq extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{
    private static final class a extends Drawable
    {

        private static final a oQ = new a();
        private static final a oR = new a();

        static a bD()
        {
            return oQ;
        }

        public void draw(Canvas canvas)
        {
        }

        public android.graphics.drawable.Drawable.ConstantState getConstantState()
        {
            return oR;
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
            return a.bD();
        }

        private a.a()
        {
        }

    }

    static final class b extends android.graphics.drawable.Drawable.ConstantState
    {

        int oS;
        int oT;

        public int getChangingConfigurations()
        {
            return oS;
        }

        public Drawable newDrawable()
        {
            return new dq(this);
        }

        b(b b1)
        {
            if (b1 != null)
            {
                oS = b1.oS;
                oT = b1.oT;
            }
        }
    }


    private int oB;
    private long oC;
    private int oD;
    private int oE;
    private int oF;
    private int oG;
    private int oH;
    private boolean oI;
    private b oJ;
    private Drawable oK;
    private Drawable oL;
    private boolean oM;
    private boolean oN;
    private boolean oO;
    private int oP;
    private boolean oy;

    public dq(Drawable drawable, Drawable drawable1)
    {
        this(null);
        Object obj = drawable;
        if (drawable == null)
        {
            obj = a.bD();
        }
        oK = ((Drawable) (obj));
        ((Drawable) (obj)).setCallback(this);
        drawable = oJ;
        drawable.oT = ((b) (drawable)).oT | ((Drawable) (obj)).getChangingConfigurations();
        drawable = drawable1;
        if (drawable1 == null)
        {
            drawable = a.bD();
        }
        oL = drawable;
        drawable.setCallback(this);
        drawable1 = oJ;
        drawable1.oT = ((b) (drawable1)).oT | drawable.getChangingConfigurations();
    }

    dq(b b1)
    {
        oB = 0;
        oF = 255;
        oH = 0;
        oy = true;
        oJ = new b(b1);
    }

    public Drawable bC()
    {
        return oL;
    }

    public boolean canConstantState()
    {
        if (!oM)
        {
            boolean flag;
            if (oK.getConstantState() != null && oL.getConstantState() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            oN = flag;
            oM = true;
        }
        return oN;
    }

    public void draw(Canvas canvas)
    {
        int i;
        int j;
        boolean flag;
        j = 1;
        i = 1;
        flag = false;
        oB;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 106
    //                   2 125;
           goto _L1 _L2 _L3
_L1:
        Drawable drawable;
        Drawable drawable1;
        boolean flag1;
        j = oH;
        flag1 = oy;
        drawable = oK;
        drawable1 = oL;
        if (i != 0)
        {
            if (!flag1 || j == 0)
            {
                drawable.draw(canvas);
            }
            if (j == oF)
            {
                drawable1.setAlpha(oF);
                drawable1.draw(canvas);
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        oC = SystemClock.uptimeMillis();
        oB = 2;
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (oC >= 0L)
        {
            float f = (float)(SystemClock.uptimeMillis() - oC) / (float)oG;
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
                oB = 0;
            }
            f = Math.min(f, 1.0F);
            f1 = oD;
            oH = (int)(f * (float)(oE - oD) + f1);
        }
        continue; /* Loop/switch isn't completed */
        if (flag1)
        {
            drawable.setAlpha(oF - j);
        }
        drawable.draw(canvas);
        if (flag1)
        {
            drawable.setAlpha(oF);
        }
        if (j > 0)
        {
            drawable1.setAlpha(j);
            drawable1.draw(canvas);
            drawable1.setAlpha(oF);
        }
        invalidateSelf();
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | oJ.oS | oJ.oT;
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        if (canConstantState())
        {
            oJ.oS = getChangingConfigurations();
            return oJ;
        } else
        {
            return null;
        }
    }

    public int getIntrinsicHeight()
    {
        return Math.max(oK.getIntrinsicHeight(), oL.getIntrinsicHeight());
    }

    public int getIntrinsicWidth()
    {
        return Math.max(oK.getIntrinsicWidth(), oL.getIntrinsicWidth());
    }

    public int getOpacity()
    {
        if (!oO)
        {
            oP = Drawable.resolveOpacity(oK.getOpacity(), oL.getOpacity());
            oO = true;
        }
        return oP;
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (fg.cD())
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
        if (!oI && super.mutate() == this)
        {
            if (!canConstantState())
            {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            oK.mutate();
            oL.mutate();
            oI = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        oK.setBounds(rect);
        oL.setBounds(rect);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        if (fg.cD())
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
        if (oH == oF)
        {
            oH = i;
        }
        oF = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        oK.setColorFilter(colorfilter);
        oL.setColorFilter(colorfilter);
    }

    public void startTransition(int i)
    {
        oD = 0;
        oE = oF;
        oH = 0;
        oG = i;
        oB = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (fg.cD())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.unscheduleDrawable(this, runnable);
            }
        }
    }
}
