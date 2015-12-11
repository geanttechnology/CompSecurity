// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzqc;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx

public final class zzo
{

    public static final int zzagk = 15;
    private static final String zzagl = null;
    private final String zzagm;
    private final String zzagn;

    public zzo(String s)
    {
        this(s, zzagl);
    }

    public zzo(String s, String s1)
    {
        com.google.android.gms.common.internal.zzx.zzb(s, "log tag cannot be null");
        boolean flag;
        if (s.length() <= 23)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzx.zzb(flag, "tag \"%s\" is longer than the %d character maximum", new Object[] {
            s, Integer.valueOf(23)
        });
        zzagm = s;
        if (s1 == null || s1.length() <= 0)
        {
            zzagn = zzagl;
            return;
        } else
        {
            zzagn = s1;
            return;
        }
    }

    private String zzcp(String s)
    {
        if (zzagn == null)
        {
            return s;
        } else
        {
            return zzagn.concat(s);
        }
    }

    public final void zza(Context context, String s, String s1, Throwable throwable)
    {
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < astacktraceelement.length && i < 2; i++)
        {
            stringbuilder.append(astacktraceelement[i].toString());
            stringbuilder.append("\n");
        }

        context = new zzqc(context, 10);
        context.zza("GMS_WTF", null, new String[] {
            "GMS_WTF", stringbuilder.toString()
        });
        context.send();
        if (zzbH(7))
        {
            Log.e(s, zzcp(s1), throwable);
            Log.wtf(s, zzcp(s1), throwable);
        }
    }

    public final void zza(String s, String s1, Throwable throwable)
    {
        if (zzbH(4))
        {
            Log.i(s, zzcp(s1), throwable);
        }
    }

    public final void zzb(String s, String s1, Throwable throwable)
    {
        if (zzbH(5))
        {
            Log.w(s, zzcp(s1), throwable);
        }
    }

    public final boolean zzbH(int i)
    {
        return Log.isLoggable(zzagm, i);
    }

    public final void zzc(String s, String s1, Throwable throwable)
    {
        if (zzbH(6))
        {
            Log.e(s, zzcp(s1), throwable);
        }
    }

    public final void zzx(String s, String s1)
    {
        if (zzbH(3))
        {
            Log.d(s, zzcp(s1));
        }
    }

    public final void zzy(String s, String s1)
    {
        if (zzbH(5))
        {
            Log.w(s, zzcp(s1));
        }
    }

    public final void zzz(String s, String s1)
    {
        if (zzbH(6))
        {
            Log.e(s, zzcp(s1));
        }
    }

}
