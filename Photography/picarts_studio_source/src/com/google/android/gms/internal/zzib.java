// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzhz

public final class zzib
{

    static SharedPreferences zzG(Context context)
    {
        return zzv(context);
    }

    public static Future zza(Context context, int i)
    {
        return (new zza(context, i) {

            final int zzIq;
            final Context zzry;

            public final void zzbn()
            {
                android.content.SharedPreferences.Editor editor = zzib.zzG(zzry).edit();
                editor.putInt("webview_cache_version", zzIq);
                editor.apply();
            }

            
            {
                zzry = context;
                zzIq = i;
                super();
            }
        }).zzgz();
    }

    public static Future zza(Context context, zzb zzb1)
    {
        return (new zza(context, zzb1) {

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

            
            {
                zzry = context;
                zzIp = zzb1;
                super();
            }

            private class zzb
            {

                public abstract void zzd(Bundle bundle);
            }

        }).zzgz();
    }

    public static Future zza(Context context, boolean flag)
    {
        return (new zza(context, flag) {
            private class zza extends zzhz
            {

                public void onStop()
                {
                }

                private zza()
                {
                }

            }


            final boolean zzIo;
            final Context zzry;

            public final void zzbn()
            {
                android.content.SharedPreferences.Editor editor = zzib.zzG(zzry).edit();
                editor.putBoolean("use_https", zzIo);
                editor.apply();
            }

            
            {
                zzry = context;
                zzIo = flag;
                super();
            }
        }).zzgz();
    }

    public static Future zzb(Context context, zzb zzb1)
    {
        return (new zza(context, zzb1) {

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

            
            {
                zzry = context;
                zzIp = zzb1;
                super();
            }
        }).zzgz();
    }

    private static SharedPreferences zzv(Context context)
    {
        return context.getSharedPreferences("admob", 0);
    }
}
