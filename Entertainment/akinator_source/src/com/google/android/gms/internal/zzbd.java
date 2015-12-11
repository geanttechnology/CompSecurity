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

    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls4 {}

}
