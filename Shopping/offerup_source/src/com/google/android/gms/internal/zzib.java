// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Future;

public final class zzib
{

    static SharedPreferences zzG(Context context)
    {
        return zzv(context);
    }

    public static Future zza(Context context, int i)
    {
        return (new _cls3(context, i)).zzgz();
    }

    public static Future zza(Context context, zzb zzb1)
    {
        return (new _cls2(context, zzb1)).zzgz();
    }

    public static Future zza(Context context, boolean flag)
    {
        return (new _cls1(context, flag)).zzgz();
    }

    public static Future zzb(Context context, zzb zzb1)
    {
        return (new _cls4(context, zzb1)).zzgz();
    }

    private static SharedPreferences zzv(Context context)
    {
        return context.getSharedPreferences("admob", 0);
    }

    private class _cls3 extends zza
    {
        private class zza extends zzhz
        {

            public void onStop()
            {
            }

            private zza()
            {
            }

            zza(_cls1 _pcls1)
            {
                this();
            }
        }


        final int zzIq;
        final Context zzry;

        public final void zzbn()
        {
            android.content.SharedPreferences.Editor editor = zzib.zzG(zzry).edit();
            editor.putInt("webview_cache_version", zzIq);
            editor.apply();
        }

        _cls3(Context context, int i)
        {
            zzry = context;
            zzIq = i;
            super(null);
        }
    }


    private class _cls2 extends zza
    {

        final zzb zzIp;
        final Context zzry;

        public final void zzbn()
        {
            SharedPreferences sharedpreferences = zzib.zzG(zzry);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", sharedpreferences.getBoolean("use_https", true));
            if (zzIp != null)
            {
                zzIp.zzd(bundle);
            }
        }

        _cls2(Context context, zzb zzb1)
        {
            zzry = context;
            zzIp = zzb1;
            super(null);
        }

        private class zzb
        {

            public abstract void zzd(Bundle bundle);
        }

    }


    private class _cls1 extends zza
    {

        final boolean zzIo;
        final Context zzry;

        public final void zzbn()
        {
            android.content.SharedPreferences.Editor editor = zzib.zzG(zzry).edit();
            editor.putBoolean("use_https", zzIo);
            editor.apply();
        }

        _cls1(Context context, boolean flag)
        {
            zzry = context;
            zzIo = flag;
            super(null);
        }
    }


    private class _cls4 extends zza
    {

        final zzb zzIp;
        final Context zzry;

        public final void zzbn()
        {
            SharedPreferences sharedpreferences = zzib.zzG(zzry);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", sharedpreferences.getInt("webview_cache_version", 0));
            if (zzIp != null)
            {
                zzIp.zzd(bundle);
            }
        }

        _cls4(Context context, zzb zzb1)
        {
            zzry = context;
            zzIp = zzb1;
            super(null);
        }
    }

}
