// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

final class ntState extends Drawable
{

    private static final zza zzZB = new <init>();
    private static final zza zzZC = new zza(null);

    static ntState zznq()
    {
        return zzZB;
    }

    public void draw(Canvas canvas)
    {
    }

    public android.graphics.drawable.ConstantState getConstantState()
    {
        return zzZC;
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


    private ntState()
    {
    }

    class zza extends android.graphics.drawable.Drawable.ConstantState
    {

        public int getChangingConfigurations()
        {
            return 0;
        }

        public Drawable newDrawable()
        {
            return zzkg.zza.zznq();
        }

            private zza()
            {
            }

            zza(zzkg._cls1 _pcls1)
            {
                this();
            }
    }

}
