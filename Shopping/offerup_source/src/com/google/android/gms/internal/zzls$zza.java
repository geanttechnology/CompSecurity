// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

final class ntState extends Drawable
{

    private static final zza zzaeu = new <init>();
    private static final zza zzaev = new zza(null);

    static ntState zzoG()
    {
        return zzaeu;
    }

    public final void draw(Canvas canvas)
    {
    }

    public final android.graphics.drawable.ConstantState getConstantState()
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


    private ntState()
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
            return zzls.zza.zzoG();
        }

            private zza()
            {
            }

            zza(zzls._cls1 _pcls1)
            {
                this();
            }
    }

}
