// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzfi;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzb, zzg, zzq, zzp, 
//            zzd, zze

public abstract class zzc extends com.google.android.gms.ads.internal.zzb
    implements zzg, zzfi
{

    public zzc(Context context, AdSizeParcel adsizeparcel, String s, zzem zzem, VersionInfoParcel versioninfoparcel, zzd zzd)
    {
        super(context, adsizeparcel, s, zzem, versioninfoparcel, zzd);
    }

    public void recordClick()
    {
        onAdClicked();
    }

    public void recordImpression()
    {
        zza(zzot.zzqo, false);
    }

    protected zziz zza(com.google.android.gms.internal.zzhs.zza zza1, zze zze)
    {
        Object obj = zzot.zzqk.getNextView();
        if (!(obj instanceof zziz)) goto _L2; else goto _L1
_L1:
        zzb.zzaF("Reusing webview...");
        obj = (zziz)obj;
        ((zziz) (obj)).zza(zzot.context, zzot.zzqn, zzoo);
_L4:
        ((zziz) (obj)).zzhe().zzb(this, this, this, this, false, this, null, zze, this);
        ((zziz) (obj)).zzaJ(zza1.zzHC.zzEC);
        return ((zziz) (obj));
_L2:
        if (obj != null)
        {
            zzot.zzqk.removeView(((View) (obj)));
        }
        obj = zzp.zzbw().zza(zzot.context, zzot.zzqn, false, false, zzot.zzqi, zzot.zzqj, zzoo, zzow);
        if (zzot.zzqn.zztg == null)
        {
            zzb(((zziz) (obj)).getView());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void zza(int i, int j, int k, int l)
    {
        zzaS();
    }

    public void zza(zzck zzck)
    {
        zzx.zzci("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        zzot.zzqC = zzck;
    }

    protected void zza(com.google.android.gms.internal.zzhs.zza zza1, zzcg zzcg)
    {
        if (zza1.errorCode != -2)
        {
            zzid.zzIE.post(new _cls1(zza1));
            return;
        }
        if (zza1.zzqn != null)
        {
            zzot.zzqn = zza1.zzqn;
        }
        if (zza1.zzHD.zzEK)
        {
            zzot.zzqH = 0;
            zzot.zzqm = zzp.zzbu().zza(zzot.context, this, zza1, zzot.zzqi, null, zzox, this, zzcg);
            return;
        } else
        {
            zzid.zzIE.post(new _cls2(zza1, zzcg));
            return;
        }
    }

    protected boolean zza(zzhs zzhs1, zzhs zzhs2)
    {
        if (zzot.zzbN() && zzot.zzqk != null)
        {
            zzot.zzqk.zzbT().zzaC(zzhs2.zzEP);
        }
        return super.zza(zzhs1, zzhs2);
    }

    public void zzbc()
    {
        zzaQ();
    }

    public void zzc(View view)
    {
        zzot.zzqG = view;
        zzb(new zzhs(zzot.zzqp, null, null, null, null, null, null));
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
