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

    private static boolean zzZl = false;
    protected final String mTag;
    private final boolean zzZm;
    private boolean zzZn;
    private boolean zzZo;
    private String zzZp;

    public zzl(String s)
    {
        this(s, zznh());
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
        zzZm = flag1;
        zzZn = flag;
        zzZo = false;
    }

    public static boolean zznh()
    {
        return zzZl;
    }

    public void zzX(boolean flag)
    {
        zzZn = flag;
    }

    public transient void zza(String s, Object aobj[])
    {
        if (zzng())
        {
            Log.v(mTag, zzg(s, aobj));
        }
    }

    public transient void zzb(String s, Object aobj[])
    {
        if (zznf() || zzZl)
        {
            Log.d(mTag, zzg(s, aobj));
        }
    }

    public transient void zzb(Throwable throwable, String s, Object aobj[])
    {
        if (zznf() || zzZl)
        {
            Log.d(mTag, zzg(s, aobj), throwable);
        }
    }

    public void zzbS(String s)
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
        zzZp = s;
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
        if (!TextUtils.isEmpty(zzZp))
        {
            aobj = (new StringBuilder()).append(zzZp).append(s).toString();
        }
        return ((String) (aobj));
    }

    public boolean zznf()
    {
        return zzZn || zzZm && Log.isLoggable(mTag, 3);
    }

    public boolean zzng()
    {
        return zzZo;
    }

}
