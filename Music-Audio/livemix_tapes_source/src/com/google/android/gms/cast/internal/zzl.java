// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Locale;

public class zzl
{

    private static boolean zzXv = false;
    protected final String mTag;
    private final boolean zzXw;
    private boolean zzXx;
    private boolean zzXy;
    private String zzXz;

    public zzl(String s)
    {
        this(s, zzmL());
    }

    public zzl(String s, boolean flag)
    {
        zzx.zzh(s, "The log tag cannot be null or empty.");
        mTag = s;
        boolean flag1;
        if (s.length() <= 23)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzXw = flag1;
        zzXx = flag;
        zzXy = false;
    }

    public static boolean zzmL()
    {
        return zzXv;
    }

    public void zzW(boolean flag)
    {
        zzXx = flag;
    }

    public transient void zza(String s, Object aobj[])
    {
        if (zzmK())
        {
            Log.v(mTag, zzg(s, aobj));
        }
    }

    public transient void zzb(String s, Object aobj[])
    {
        if (zzmJ() || zzXv)
        {
            Log.d(mTag, zzg(s, aobj));
        }
    }

    public transient void zzb(Throwable throwable, String s, Object aobj[])
    {
        if (zzmJ() || zzXv)
        {
            Log.d(mTag, zzg(s, aobj), throwable);
        }
    }

    public void zzbR(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            s = null;
        } else
        {
            s = String.format("[%s] ", new Object[] {
                s
            });
        }
        zzXz = s;
    }

    public transient void zzc(String s, Object aobj[])
    {
        Log.e(mTag, zzg(s, aobj));
    }

    public transient void zzc(Throwable throwable, String s, Object aobj[])
    {
        Log.w(mTag, zzg(s, aobj), throwable);
    }

    public transient void zze(String s, Object aobj[])
    {
        Log.i(mTag, zzg(s, aobj));
    }

    public transient void zzf(String s, Object aobj[])
    {
        Log.w(mTag, zzg(s, aobj));
    }

    protected transient String zzg(String s, Object aobj[])
    {
        if (aobj.length != 0)
        {
            s = String.format(Locale.ROOT, s, aobj);
        }
        aobj = s;
        if (!TextUtils.isEmpty(zzXz))
        {
            aobj = (new StringBuilder()).append(zzXz).append(s).toString();
        }
        return ((String) (aobj));
    }

    public boolean zzmJ()
    {
        return zzXx || zzXw && Log.isLoggable(mTag, 3);
    }

    public boolean zzmK()
    {
        return zzXy;
    }

}
