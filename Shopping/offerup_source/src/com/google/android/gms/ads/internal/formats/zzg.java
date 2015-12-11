// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zziz;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzh, zzb

public class zzg extends zzh
{

    private Object zzpd;
    private zzeq zzwD;
    private zzer zzwE;
    private final zzn zzwF;
    private zzh zzwG;
    private boolean zzwH;

    private zzg(Context context, zzn zzn1, zzan zzan)
    {
        super(context, zzn1, null, zzan, null, null, null);
        zzwH = false;
        zzpd = new Object();
        zzwF = zzn1;
    }

    public zzg(Context context, zzn zzn1, zzan zzan, zzeq zzeq1)
    {
        this(context, zzn1, zzan);
        zzwD = zzeq1;
    }

    public zzg(Context context, zzn zzn1, zzan zzan, zzer zzer1)
    {
        this(context, zzn1, zzan);
        zzwE = zzer1;
    }

    public void recordImpression()
    {
        zzx.zzci("recordImpression must be called on the main UI thread.");
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzl(true);
        if (zzwG == null) goto _L2; else goto _L1
_L1:
        zzwG.recordImpression();
_L5:
        zzwF.recordImpression();
        return;
_L2:
        if (zzwD == null || zzwD.getOverrideClickHandling()) goto _L4; else goto _L3
_L3:
        zzwD.recordImpression();
          goto _L5
        Object obj1;
        obj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call recordImpression", ((Throwable) (obj1)));
          goto _L5
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
_L4:
        if (zzwE == null || zzwE.getOverrideClickHandling()) goto _L5; else goto _L6
_L6:
        zzwE.recordImpression();
          goto _L5
    }

    public com.google.android.gms.ads.internal.formats.zzb zza(android.view.View.OnClickListener onclicklistener)
    {
        return null;
    }

    public void zza(View view, Map map, JSONObject jsonobject, JSONObject jsonobject1)
    {
        zzx.zzci("performClick must be called on the main UI thread.");
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzwG == null) goto _L2; else goto _L1
_L1:
        zzwG.zza(view, map, jsonobject, jsonobject1);
_L3:
        zzwF.onAdClicked();
        return;
_L2:
        if (zzwD != null && !zzwD.getOverrideClickHandling())
        {
            zzwD.zzc(zze.zzy(view));
        }
        if (zzwE != null && !zzwE.getOverrideClickHandling())
        {
            zzwD.zzc(zze.zzy(view));
        }
          goto _L3
        view;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call performClick", view);
          goto _L3
        view;
        obj;
        JVM INSTR monitorexit ;
        throw view;
    }

    public void zzb(zzh zzh1)
    {
        synchronized (zzpd)
        {
            zzwG = zzh1;
        }
        return;
        zzh1;
        obj;
        JVM INSTR monitorexit ;
        throw zzh1;
    }

    public boolean zzdB()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzwH;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zziz zzdC()
    {
        return null;
    }

    public void zzh(View view)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzwH = true;
        if (zzwD == null) goto _L2; else goto _L1
_L1:
        zzwD.zzd(zze.zzy(view));
_L4:
        zzwH = false;
        return;
_L2:
        if (zzwE == null) goto _L4; else goto _L3
_L3:
        zzwE.zzd(zze.zzy(view));
          goto _L4
        view;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call prepareAd", view);
          goto _L4
        view;
        obj;
        JVM INSTR monitorexit ;
        throw view;
    }
}
