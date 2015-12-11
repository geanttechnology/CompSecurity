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
//            zzmx

public final class zzls extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{

    private int mFrom;
    private long zzNY;
    private boolean zzaea;
    private int zzaeh;
    private int zzaei;
    private int zzaej;
    private int zzaek;
    private int zzael;
    private boolean zzaem;
    private zzb zzaen;
    private Drawable zzaeo;
    private Drawable zzaep;
    private boolean zzaeq;
    private boolean zzaer;
    private boolean zzaes;
    private int zzaet;

    public zzls(Drawable drawable, Drawable drawable1)
    {
        this(null);
        Object obj = drawable;
        if (drawable == null)
        {
            obj = zza.zzoG();
        }
        zzaeo = ((Drawable) (obj));
        ((Drawable) (obj)).setCallback(this);
        drawable = zzaen;
        drawable.zzaex = ((zzb) (drawable)).zzaex | ((Drawable) (obj)).getChangingConfigurations();
        drawable = drawable1;
        if (drawable1 == null)
        {
            drawable = zza.zzoG();
        }
        zzaep = drawable;
        drawable.setCallback(this);
        drawable1 = zzaen;
        drawable1.zzaex = ((zzb) (drawable1)).zzaex | drawable.getChangingConfigurations();
    }

    zzls(zzb zzb1)
    {
        zzaeh = 0;
        zzaej = 255;
        zzael = 0;
        zzaea = true;
        zzaen = new zzb(zzb1);
    }

    public final boolean canConstantState()
    {
        if (!zzaeq)
        {
            boolean flag;
            if (zzaeo.getConstantState() != null && zzaep.getConstantState() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzaer = flag;
            zzaeq = true;
        }
        return zzaer;
    }

    public final void draw(Canvas canvas)
    {
        int i;
        int j;
        boolean flag;
        j = 1;
        i = 1;
        flag = false;
        zzaeh;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 106
    //                   2 125;
           goto _L1 _L2 _L3
_L1:
        Drawable drawable;
        Drawable drawable1;
        boolean flag1;
        j = zzael;
        flag1 = zzaea;
        drawable = zzaeo;
        drawable1 = zzaep;
        if (i != 0)
        {
            if (!flag1 || j == 0)
            {
                drawable.draw(canvas);
            }
            if (j == zzaej)
            {
                drawable1.setAlpha(zzaej);
                drawable1.draw(canvas);
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        zzNY = SystemClock.uptimeMillis();
        zzaeh = 2;
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (zzNY >= 0L)
        {
            float f = (float)(SystemClock.uptimeMillis() - zzNY) / (float)zzaek;
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
                zzaeh = 0;
            }
            f = Math.min(f, 1.0F);
            f1 = mFrom;
            zzael = (int)(f * (float)(zzaei - mFrom) + f1);
        }
        continue; /* Loop/switch isn't completed */
        if (flag1)
        {
            drawable.setAlpha(zzaej - j);
        }
        drawable.draw(canvas);
        if (flag1)
        {
            drawable.setAlpha(zzaej);
        }
        if (j > 0)
        {
            drawable1.setAlpha(j);
            drawable1.draw(canvas);
            drawable1.setAlpha(zzaej);
        }
        invalidateSelf();
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | zzaen.zzaew | zzaen.zzaex;
    }

    public final android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        if (canConstantState())
        {
            zzaen.zzaew = getChangingConfigurations();
            return zzaen;
        } else
        {
            return null;
        }
    }

    public final int getIntrinsicHeight()
    {
        return Math.max(zzaeo.getIntrinsicHeight(), zzaep.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth()
    {
        return Math.max(zzaeo.getIntrinsicWidth(), zzaep.getIntrinsicWidth());
    }

    public final int getOpacity()
    {
        if (!zzaes)
        {
            zzaet = Drawable.resolveOpacity(zzaeo.getOpacity(), zzaep.getOpacity());
            zzaes = true;
        }
        return zzaet;
    }

    public final void invalidateDrawable(Drawable drawable)
    {
        if (zzmx.zzqu())
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
        if (!zzaem && super.mutate() == this)
        {
            if (!canConstantState())
            {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            zzaeo.mutate();
            zzaep.mutate();
            zzaem = true;
        }
        return this;
    }

    protected final void onBoundsChange(Rect rect)
    {
        zzaeo.setBounds(rect);
        zzaep.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        if (zzmx.zzqu())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.scheduleDrawable(this, runnable, l);
            }
        }
    }

    public final void setAlpha(int i)
    {
        if (zzael == zzaej)
        {
            zzael = i;
        }
        zzaej = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        zzaeo.setColorFilter(colorfilter);
        zzaep.setColorFilter(colorfilter);
    }

    public final void startTransition(int i)
    {
        mFrom = 0;
        zzaei = zzaej;
        zzael = 0;
        zzaek = i;
        zzaeh = 1;
        invalidateSelf();
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (zzmx.zzqu())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.unscheduleDrawable(this, runnable);
            }
        }
    }

    public final Drawable zzoF()
    {
        return zzaep;
    }

    private class zza extends Drawable
    {

        private static final zza zzaeu = new zza();
        private static final zza zzaev = new zza(null);

        static zza zzoG()
        {
            return zzaeu;
        }

        public final void draw(Canvas canvas)
        {
        }

        public final android.graphics.drawable.Drawable.ConstantState getConstantState()
        {
            return zzaev;
        }

        public final int getOpacity()
        {
            return -2;
        }

        public final void setAlpha(int i)
        {
        }

        public final void setColorFilter(ColorFilter colorfilter)
        {
        }


        private zza()
        {
        }

        class zza extends android.graphics.drawable.Drawable.ConstantState
        {

            public final int getChangingConfigurations()
            {
                return 0;
            }

            public final Drawable newDrawable()
            {
                return zza.zzoG();
            }

                private zza()
                {
                }

                zza(_cls1 _pcls1)
                {
                    this();
                }
        }

    }


    private class zzb extends android.graphics.drawable.Drawable.ConstantState
    {

        int zzaew;
        int zzaex;

        public final int getChangingConfigurations()
        {
            return zzaew;
        }

        public final Drawable newDrawable()
        {
            return new zzls(this);
        }

        zzb(zzb zzb1)
        {
            if (zzb1 != null)
            {
                zzaew = zzb1.zzaew;
                zzaex = zzb1.zzaex;
            }
        }
    }

}
