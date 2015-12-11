// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzbb, zzjb, zziz, zzid, 
//            zzja, zzbg, zzan, zzdg, 
//            zzdm, zzdo, zzfi, zzdk, 
//            zzbf

public class zzbd
    implements zzbb
{

    private final zziz zzoM;

    public zzbd(Context context, VersionInfoParcel versioninfoparcel, zzan zzan)
    {
        zzoM = zzp.zzbw().zza(context, new AdSizeParcel(), false, false, zzan, versioninfoparcel);
        zzoM.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable)
    {
        if (zzl.zzcF().zzgT())
        {
            runnable.run();
            return;
        } else
        {
            zzid.zzIE.post(runnable);
            return;
        }
    }

    static zziz zza(zzbd zzbd1)
    {
        return zzbd1.zzoM;
    }

    public void destroy()
    {
        zzoM.destroy();
    }

    public void zza(com.google.android.gms.ads.internal.client.zza zza1, zzg zzg, zzdg zzdg, zzn zzn, boolean flag, zzdm zzdm, zzdo zzdo, 
            zze zze1, zzfi zzfi)
    {
        zzoM.zzhe().zzb(zza1, zzg, zzdg, zzn, flag, zzdm, zzdo, new zze(false), zzfi);
    }

    public void zza(zzbb.zza zza1)
    {
        zzoM.zzhe().zza(new _cls6(zza1));
    }

    public void zza(String s, zzdk zzdk)
    {
        zzoM.zzhe().zza(s, zzdk);
    }

    public void zza(String s, String s1)
    {
        runOnUiThread(new _cls2(s, s1));
    }

    public void zza(String s, JSONObject jsonobject)
    {
        runOnUiThread(new _cls1(s, jsonobject));
    }

    public void zzb(String s, zzdk zzdk)
    {
        zzoM.zzhe().zzb(s, zzdk);
    }

    public void zzb(String s, JSONObject jsonobject)
    {
        zzoM.zzb(s, jsonobject);
    }

    public zzbf zzci()
    {
        return new zzbg(this);
    }

    public void zzs(String s)
    {
        runOnUiThread(new _cls3(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[] {
            s
        })));
    }

    public void zzt(String s)
    {
        runOnUiThread(new _cls5(s));
    }

    public void zzu(String s)
    {
        runOnUiThread(new _cls4(s));
    }

    private class _cls6
        implements zzja.zza
    {

        final zzbd zzrH;
        final zzbb.zza zzrK;

        public void zza(zziz zziz1, boolean flag)
        {
            zzrK.zzcj();
        }

        _cls6(zzbb.zza zza1)
        {
            zzrH = zzbd.this;
            zzrK = zza1;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final String zzrF;
        final zzbd zzrH;
        final String zzrI;

        public void run()
        {
            com.google.android.gms.internal.zzbd.zza(zzrH).zza(zzrF, zzrI);
        }

        _cls2(String s, String s1)
        {
            zzrH = zzbd.this;
            zzrF = s;
            zzrI = s1;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final String zzrF;
        final JSONObject zzrG;
        final zzbd zzrH;

        public void run()
        {
            com.google.android.gms.internal.zzbd.zza(zzrH).zza(zzrF, zzrG);
        }

        _cls1(String s, JSONObject jsonobject)
        {
            zzrH = zzbd.this;
            zzrF = s;
            zzrG = jsonobject;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final zzbd zzrH;
        final String zzrJ;

        public void run()
        {
            com.google.android.gms.internal.zzbd.zza(zzrH).loadData(zzrJ, "text/html", "UTF-8");
        }

        _cls3(String s)
        {
            zzrH = zzbd.this;
            zzrJ = s;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final String zzrC;
        final zzbd zzrH;

        public void run()
        {
            com.google.android.gms.internal.zzbd.zza(zzrH).loadUrl(zzrC);
        }

        _cls5(String s)
        {
            zzrH = zzbd.this;
            zzrC = s;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final zzbd zzrH;
        final String zzrJ;

        public void run()
        {
            com.google.android.gms.internal.zzbd.zza(zzrH).loadData(zzrJ, "text/html", "UTF-8");
        }

        _cls4(String s)
        {
            zzrH = zzbd.this;
            zzrJ = s;
            super();
        }
    }

}
