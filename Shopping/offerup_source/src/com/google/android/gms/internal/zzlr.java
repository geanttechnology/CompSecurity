// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzlr
{

    private static zza zzadc = null;
    private static int zzadd = 0;
    private static String zzade = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzpy = new Object();
    private Object zzOX;
    protected final String zzue;
    protected final Object zzuf;

    protected zzlr(String s, Object obj)
    {
        zzOX = null;
        zzue = s;
        zzuf = obj;
    }

    public static boolean isInitialized()
    {
        return zzadc != null;
    }

    public static zzlr zza(String s, Float float1)
    {
        return new _cls4(s, float1);
    }

    public static zzlr zza(String s, Integer integer)
    {
        return new _cls3(s, integer);
    }

    public static zzlr zza(String s, Long long1)
    {
        return new _cls2(s, long1);
    }

    public static zzlr zzg(String s, boolean flag)
    {
        return new _cls1(s, Boolean.valueOf(flag));
    }

    public static int zzoo()
    {
        return zzadd;
    }

    static zza zzoq()
    {
        return zzadc;
    }

    public static zzlr zzu(String s, String s1)
    {
        return new _cls5(s, s1);
    }

    public final Object get()
    {
        if (zzOX != null)
        {
            return zzOX;
        } else
        {
            return zzbY(zzue);
        }
    }

    protected abstract Object zzbY(String s);

    public final Object zzop()
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


    private class _cls4 extends zzlr
    {

        protected final Object zzbY(String s)
        {
            return zzcc(s);
        }

        protected final Float zzcc(String s)
        {
            return zzlr.zzoq().zzb(zzue, (Float)zzuf);
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


    private class _cls3 extends zzlr
    {

        protected final Object zzbY(String s)
        {
            return zzcb(s);
        }

        protected final Integer zzcb(String s)
        {
            return zzlr.zzoq().zzb(zzue, (Integer)zzuf);
        }

        _cls3(String s, Integer integer)
        {
            super(s, integer);
        }
    }


    private class _cls2 extends zzlr
    {

        protected final Object zzbY(String s)
        {
            return zzca(s);
        }

        protected final Long zzca(String s)
        {
            return zzlr.zzoq().getLong(zzue, (Long)zzuf);
        }

        _cls2(String s, Long long1)
        {
            super(s, long1);
        }
    }


    private class _cls1 extends zzlr
    {

        protected final Object zzbY(String s)
        {
            return zzbZ(s);
        }

        protected final Boolean zzbZ(String s)
        {
            return zzlr.zzoq().zzb(zzue, (Boolean)zzuf);
        }

        _cls1(String s, Boolean boolean1)
        {
            super(s, boolean1);
        }
    }


    private class _cls5 extends zzlr
    {

        protected final Object zzbY(String s)
        {
            return zzcd(s);
        }

        protected final String zzcd(String s)
        {
            return zzlr.zzoq().getString(zzue, (String)zzuf);
        }

        _cls5(String s, String s1)
        {
            super(s, s1);
        }
    }

}
