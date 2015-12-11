// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import java.util.Locale;

public final class mTheme
{

    private int mTheme;
    private int zzbdL;

    static int zza(mTheme mtheme)
    {
        return mtheme.zzbdL;
    }

    static int zzb(zzbdL zzbdl)
    {
        return zzbdl.mTheme;
    }

    public final mTheme build()
    {
        return new mTheme(this, null);
    }

    public final mTheme setEnvironment(int i)
    {
        if (i == 0 || i == 2 || i == 1 || i == 3)
        {
            zzbdL = i;
            return this;
        } else
        {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[] {
                Integer.valueOf(i)
            }));
        }
    }

    public final zzbdL setTheme(int i)
    {
        if (i == 0 || i == 1)
        {
            mTheme = i;
            return this;
        } else
        {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[] {
                Integer.valueOf(i)
            }));
        }
    }

    public ()
    {
        zzbdL = 3;
        mTheme = 0;
    }
}
