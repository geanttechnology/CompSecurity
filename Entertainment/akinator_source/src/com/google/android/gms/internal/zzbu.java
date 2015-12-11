// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzbv, zzbx

public abstract class zzbu
{

    private final String zzue;
    private final Object zzuf;

    private zzbu(String s, Object obj)
    {
        zzue = s;
        zzuf = obj;
        zzp.zzbD().zza(this);
    }

    zzbu(String s, Object obj, _cls1 _pcls1)
    {
        this(s, obj);
    }

    public static zzbu zzP(String s)
    {
        s = zzc(s, (String)null);
        zzp.zzbD().zzb(s);
        return s;
    }

    public static zzbu zzQ(String s)
    {
        s = zzc(s, (String)null);
        zzp.zzbD().zzc(s);
        return s;
    }

    public static zzbu zza(String s, int i)
    {
        return new _cls2(s, Integer.valueOf(i));
    }

    public static zzbu zza(String s, Boolean boolean1)
    {
        return new _cls1(s, boolean1);
    }

    public static zzbu zzb(String s, long l)
    {
        return new _cls3(s, Long.valueOf(l));
    }

    public static zzbu zzc(String s, String s1)
    {
        return new _cls4(s, s1);
    }

    public Object get()
    {
        return zzp.zzbE().zzd(this);
    }

    public String getKey()
    {
        return zzue;
    }

    protected abstract Object zza(SharedPreferences sharedpreferences);

    public Object zzde()
    {
        return zzuf;
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}

}
