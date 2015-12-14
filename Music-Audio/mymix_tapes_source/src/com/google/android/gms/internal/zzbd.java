// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzbb, zzir, zzip, zzhu, 
//            zziq, zzbg, zzan, zzdd, 
//            zzdi, zzdk, zzfc, zzdg, 
//            zzbf

public class zzbd
    implements zzbb
{

    private final zzip zzoL;

    public zzbd(Context context, VersionInfoParcel versioninfoparcel, zzan zzan)
    {
        zzoL = zzp.zzby().zza(context, new AdSizeParcel(), false, false, zzan, versioninfoparcel);
        zzoL.setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable)
    {
        if (zzk.zzcE().zzgI())
        {
            runnable.run();
            return;
        } else
        {
            zzhu.zzHK.post(runnable);
            return;
        }
    }

    static zzip zza(zzbd zzbd1)
    {
        return zzbd1.zzoL;
    }

    public void destroy()
    {
        zzoL.destroy();
    }

    public void zza(com.google.android.gms.ads.internal.client.zza zza1, zzg zzg, zzdd zzdd, zzn zzn, boolean flag, zzdi zzdi, zzdk zzdk, 
            zze zze1, zzfc zzfc)
    {
        zzoL.zzgS().zzb(zza1, zzg, zzdd, zzn, flag, zzdi, zzdk, new zze(false), zzfc);
    }

    public void zza(zzbb.zza zza1)
    {
        zzoL.zzgS().zza(new _cls6(zza1));
    }

    public void zza(String s, zzdg zzdg)
    {
        zzoL.zzgS().zza(s, zzdg);
    }

    public void zza(String s, String s1)
    {
        runOnUiThread(new _cls2(s, s1));
    }

    public void zza(String s, JSONObject jsonobject)
    {
        runOnUiThread(new _cls1(s, jsonobject));
    }

    public void zzb(String s, zzdg zzdg)
    {
        zzoL.zzgS().zzb(s, zzdg);
    }

    public void zzb(String s, JSONObject jsonobject)
    {
        zzoL.zzb(s, jsonobject);
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
