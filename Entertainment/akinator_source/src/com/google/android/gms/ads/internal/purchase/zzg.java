// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.stats.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zzi, zzb, zzh, zzf

public final class zzg extends com.google.android.gms.internal.zzfv.zza
    implements ServiceConnection
{

    private Context mContext;
    com.google.android.gms.ads.internal.purchase.zzb zzCD;
    private String zzCJ;
    private zzf zzCN;
    private boolean zzCT;
    private int zzCU;
    private Intent zzCV;

    public zzg(Context context, String s, boolean flag, int i, Intent intent, zzf zzf)
    {
        zzCT = false;
        zzCJ = s;
        zzCU = i;
        zzCV = intent;
        zzCT = flag;
        mContext = context;
        zzCN = zzf;
    }

    public void finishPurchase()
    {
        int i = zzp.zzbF().zzd(zzCV);
        if (zzCU != -1 || i != 0)
        {
            return;
        } else
        {
            zzCD = new com.google.android.gms.ads.internal.purchase.zzb(mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            zzb.zzqh().zza(mContext, intent, this, 1);
            return;
        }
    }

    public String getProductId()
    {
        return zzCJ;
    }

    public Intent getPurchaseData()
    {
        return zzCV;
    }

    public int getResultCode()
    {
        return zzCU;
    }

    public boolean isVerified()
    {
        return zzCT;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service connected.");
        zzCD.zzN(ibinder);
        componentname = zzp.zzbF().zze(zzCV);
        componentname = zzp.zzbF().zzap(componentname);
        if (componentname == null)
        {
            return;
        }
        if (zzCD.zzi(mContext.getPackageName(), componentname) == 0)
        {
            zzh.zzw(mContext).zza(zzCN);
        }
        zzb.zzqh().zza(mContext, this);
        zzCD.destroy();
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
        zzCD.destroy();
    }
}
