// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzie;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zzh, zzi, zzk, GInAppPurchaseManagerInfoParcel, 
//            zzb, zzf, zzj

public class zze extends com.google.android.gms.internal.zzft.zza
    implements ServiceConnection
{

    private final Activity mActivity;
    private com.google.android.gms.ads.internal.purchase.zzb zzCD;
    zzh zzCE;
    private zzk zzCG;
    private Context zzCL;
    private zzfr zzCM;
    private zzf zzCN;
    private zzj zzCO;
    private String zzCP;

    public zze(Activity activity)
    {
        zzCP = null;
        mActivity = activity;
        zzCE = zzh.zzw(mActivity.getApplicationContext());
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i != 1001) goto _L2; else goto _L1
_L1:
        boolean flag = false;
        i = zzp.zzbF().zzd(intent);
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        zzp.zzbF();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (zzCG.zza(zzCP, j, intent))
        {
            flag = true;
        }
_L3:
        zzCM.recordPlayBillingResolution(i);
        mActivity.finish();
        zza(zzCM.getProductId(), flag, j, intent);
        zzCP = null;
_L2:
        return;
        zzCE.zza(zzCN);
          goto _L3
        intent;
        zzb.zzaH("Fail to process purchase result.");
        mActivity.finish();
        zzCP = null;
        return;
        intent;
        zzCP = null;
        throw intent;
    }

    public void onCreate()
    {
        Object obj = GInAppPurchaseManagerInfoParcel.zzc(mActivity.getIntent());
        zzCO = ((GInAppPurchaseManagerInfoParcel) (obj)).zzCy;
        zzCG = ((GInAppPurchaseManagerInfoParcel) (obj)).zzqE;
        zzCM = ((GInAppPurchaseManagerInfoParcel) (obj)).zzCw;
        zzCD = new com.google.android.gms.ads.internal.purchase.zzb(mActivity.getApplicationContext());
        zzCL = ((GInAppPurchaseManagerInfoParcel) (obj)).zzCx;
        if (mActivity.getResources().getConfiguration().orientation == 2)
        {
            mActivity.setRequestedOrientation(zzp.zzbx().zzgG());
        } else
        {
            mActivity.setRequestedOrientation(zzp.zzbx().zzgH());
        }
        obj = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        ((Intent) (obj)).setPackage("com.android.vending");
        mActivity.bindService(((Intent) (obj)), this, 1);
    }

    public void onDestroy()
    {
        mActivity.unbindService(this);
        zzCD.destroy();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        zzCD.zzN(ibinder);
        zzCP = zzCG.zzfq();
        componentname = zzCD.zzb(mActivity.getPackageName(), zzCM.getProductId(), zzCP);
        ibinder = (PendingIntent)componentname.getParcelable("BUY_INTENT");
        if (ibinder == null)
        {
            try
            {
                int i = zzp.zzbF().zzc(componentname);
                zzCM.recordPlayBillingResolution(i);
                zza(zzCM.getProductId(), false, i, null);
                mActivity.finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            break MISSING_BLOCK_LABEL_182;
        }
        zzCN = new zzf(zzCM.getProductId(), zzCP);
        zzCE.zzb(zzCN);
        mActivity.startIntentSenderForResult(ibinder.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        return;
        zzb.zzd("Error when connecting in-app billing service", componentname);
        mActivity.finish();
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        zzb.zzaG("In-app billing service disconnected.");
        zzCD.destroy();
    }

    protected void zza(String s, boolean flag, int i, Intent intent)
    {
        if (zzCO != null)
        {
            zzCO.zza(s, flag, i, intent, zzCN);
        }
    }
}
