// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.support.v7.ll;
import android.support.v7.mc;
import android.support.v7.qc;
import android.support.v7.qd;
import android.support.v7.ul;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.x;
import java.util.Map;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzh, zzb

public class zzg extends zzh
{

    private Object zzpc;
    private qc zzvZ;
    private qd zzwa;
    private final zzn zzwb;
    private zzh zzwc;
    private boolean zzwd;

    private zzg(Context context, zzn zzn1, mc mc)
    {
        super(context, zzn1, null, mc, null, null, null);
        zzwd = false;
        zzpc = new Object();
        zzwb = zzn1;
    }

    public zzg(Context context, zzn zzn1, mc mc, qc qc1)
    {
        this(context, zzn1, mc);
        zzvZ = qc1;
    }

    public zzg(Context context, zzn zzn1, mc mc, qd qd1)
    {
        this(context, zzn1, mc);
        zzwa = qd1;
    }

    public void recordImpression()
    {
        x.b("recordImpression must be called on the main UI thread.");
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        zzl(true);
        if (zzwc == null) goto _L2; else goto _L1
_L1:
        zzwc.recordImpression();
_L5:
        zzwb.recordImpression();
        return;
_L2:
        if (zzvZ == null || zzvZ.k()) goto _L4; else goto _L3
_L3:
        zzvZ.i();
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
        if (zzwa == null || zzwa.i()) goto _L5; else goto _L6
_L6:
        zzwa.g();
          goto _L5
    }

    public com.google.android.gms.ads.internal.formats.zzb zza(android.view.View.OnClickListener onclicklistener)
    {
        return null;
    }

    public void zzb(View view, Map map)
    {
        x.b("performClick must be called on the main UI thread.");
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        if (zzwc == null) goto _L2; else goto _L1
_L1:
        zzwc.zzb(view, map);
_L3:
        zzwb.onAdClicked();
        return;
_L2:
        if (zzvZ != null && !zzvZ.k())
        {
            zzvZ.a(ll.a(view));
        }
        if (zzwa != null && !zzwa.i())
        {
            zzvZ.a(ll.a(view));
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
        synchronized (zzpc)
        {
            zzwc = zzh1;
        }
        return;
        zzh1;
        obj;
        JVM INSTR monitorexit ;
        throw zzh1;
    }

    public boolean zzdx()
    {
        boolean flag;
        synchronized (zzpc)
        {
            flag = zzwd;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ul zzdy()
    {
        return null;
    }

    public void zzh(View view)
    {
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        zzwd = true;
        if (zzvZ == null) goto _L2; else goto _L1
_L1:
        zzvZ.b(ll.a(view));
_L4:
        zzwd = false;
        return;
_L2:
        if (zzwa == null) goto _L4; else goto _L3
_L3:
        zzwa.b(ll.a(view));
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
