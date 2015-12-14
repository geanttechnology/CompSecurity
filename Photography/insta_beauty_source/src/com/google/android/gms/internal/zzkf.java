// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzkf
{

    private static zza zzYj = null;
    private static int zzYk = 0;
    private static String zzYl = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzoW = new Object();
    private Object zzLS;
    protected final String zztw;
    protected final Object zztx;

    protected zzkf(String s, Object obj)
    {
        zzLS = null;
        zztw = s;
        zztx = obj;
    }

    public static boolean isInitialized()
    {
        return zzYj != null;
    }

    public static zzkf zza(String s, Float float1)
    {
        return new _cls4(s, float1);
    }

    public static zzkf zza(String s, Integer integer)
    {
        return new _cls3(s, integer);
    }

    public static zzkf zza(String s, Long long1)
    {
        return new _cls2(s, long1);
    }

    public static zzkf zzg(String s, boolean flag)
    {
        return new _cls1(s, Boolean.valueOf(flag));
    }

    public static int zzmY()
    {
        return zzYk;
    }

    static zza zzna()
    {
        return zzYj;
    }

    public static zzkf zzs(String s, String s1)
    {
        return new _cls5(s, s1);
    }

    public final Object get()
    {
        if (zzLS != null)
        {
            return zzLS;
        } else
        {
            return zzbP(zztw);
        }
    }

    protected abstract Object zzbP(String s);

    public final Object zzmZ()
    {
        long l = Binder.clearCallingIdentity();
        Object obj = get();
        Binder.restoreCallingIdentity(l);
        return obj;
        Exception exception;
        exception;
        Binder.restoreCallingIdentity(l);
        throw exception;
    }


    private class _cls4 extends zzkf
    {

        protected Object zzbP(String s)
        {
            return zzbT(s);
        }

        protected Float zzbT(String s)
        {
            return zzkf.zzna().zzb(zztw, (Float)zztx);
        }

        _cls4(String s, Float float1)
        {
            super(s, float1);
        }

        private class zza
        {

            public abstract Long getLong(String s, Long long1);

            public abstract String getString(String s, String s1);

            public abstract Boolean zzb(String s, Boolean boolean1);

            public abstract Float zzb(String s, Float float1);

            public abstract Integer zzb(String s, Integer integer);
        }

    }


    private class _cls3 extends zzkf
    {

        protected Object zzbP(String s)
        {
            return zzbS(s);
        }

        protected Integer zzbS(String s)
        {
            return zzkf.zzna().zzb(zztw, (Integer)zztx);
        }

        _cls3(String s, Integer integer)
        {
            super(s, integer);
        }
    }


    private class _cls2 extends zzkf
    {

        protected Object zzbP(String s)
        {
            return zzbR(s);
        }

        protected Long zzbR(String s)
        {
            return zzkf.zzna().getLong(zztw, (Long)zztx);
        }

        _cls2(String s, Long long1)
        {
            super(s, long1);
        }
    }


    private class _cls1 extends zzkf
    {

        protected Object zzbP(String s)
        {
            return zzbQ(s);
        }

        protected Boolean zzbQ(String s)
        {
            return zzkf.zzna().zzb(zztw, (Boolean)zztx);
        }

        _cls1(String s, Boolean boolean1)
        {
            super(s, boolean1);
        }
    }


    private class _cls5 extends zzkf
    {

        protected Object zzbP(String s)
        {
            return zzbU(s);
        }

        protected String zzbU(String s)
        {
            return zzkf.zzna().getString(zztw, (String)zztx);
        }

        _cls5(String s, String s1)
        {
            super(s, s1);
        }
    }

}
