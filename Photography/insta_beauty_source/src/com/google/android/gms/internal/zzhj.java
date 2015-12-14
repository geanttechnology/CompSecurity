// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Future;

public final class zzhj
{

    static SharedPreferences zzF(Context context)
    {
        return zzv(context);
    }

    public static Future zza(Context context, int i)
    {
        return (new _cls3(context, i)).zzgi();
    }

    public static Future zza(Context context, zzb zzb1)
    {
        return (new _cls2(context, zzb1)).zzgi();
    }

    public static Future zza(Context context, boolean flag)
    {
        return (new _cls1(context, flag)).zzgi();
    }

    public static Future zzb(Context context, zzb zzb1)
    {
        return (new _cls4(context, zzb1)).zzgi();
    }

    private static SharedPreferences zzv(Context context)
    {
        return context.getSharedPreferences("admob", 0);
    }

    private class _cls3 extends zza
    {
        private class zza extends zzhh
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


        final int zzGd;
        final Context zzqV;

        public void zzdP()
        {
            android.content.SharedPreferences.Editor editor = zzhj.zzF(zzqV).edit();
            editor.putInt("webview_cache_version", zzGd);
            editor.commit();
        }

        _cls3(Context context, int i)
        {
            zzqV = context;
            zzGd = i;
            super(null);
        }
    }


    private class _cls2 extends zza
    {

        final zzb zzGc;
        final Context zzqV;

        public void zzdP()
        {
            SharedPreferences sharedpreferences = zzhj.zzF(zzqV);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", sharedpreferences.getBoolean("use_https", true));
            if (zzGc != null)
            {
                zzGc.zzc(bundle);
            }
        }

        _cls2(Context context, zzb zzb1)
        {
            zzqV = context;
            zzGc = zzb1;
            super(null);
        }

        private class zzb
        {

            public abstract void zzc(Bundle bundle);
        }

    }


    private class _cls1 extends zza
    {

        final boolean zzGb;
        final Context zzqV;

        public void zzdP()
        {
            android.content.SharedPreferences.Editor editor = zzhj.zzF(zzqV).edit();
            editor.putBoolean("use_https", zzGb);
            editor.commit();
        }

        _cls1(Context context, boolean flag)
        {
            zzqV = context;
            zzGb = flag;
            super(null);
        }
    }


    private class _cls4 extends zza
    {

        final zzb zzGc;
        final Context zzqV;

        public void zzdP()
        {
            SharedPreferences sharedpreferences = zzhj.zzF(zzqV);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", sharedpreferences.getInt("webview_cache_version", 0));
            if (zzGc != null)
            {
                zzGc.zzc(bundle);
            }
        }

        _cls4(Context context, zzb zzb1)
        {
            zzqV = context;
            zzGc = zzb1;
            super(null);
        }
    }

}
