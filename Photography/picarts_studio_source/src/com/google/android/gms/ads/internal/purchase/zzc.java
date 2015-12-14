// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zzb, zzh, zzf, zzi, 
//            zzk, zzg

public class zzc extends zzhz
    implements ServiceConnection
{

    private Context mContext;
    private boolean zzCB;
    private zzfw zzCC;
    private com.google.android.gms.ads.internal.purchase.zzb zzCD;
    private zzh zzCE;
    private List zzCF;
    private zzk zzCG;
    private final Object zzpd;

    public zzc(Context context, zzfw zzfw, zzk zzk)
    {
        this(context, zzfw, zzk, new com.google.android.gms.ads.internal.purchase.zzb(context), zzh.zzw(context.getApplicationContext()));
    }

    zzc(Context context, zzfw zzfw, zzk zzk, com.google.android.gms.ads.internal.purchase.zzb zzb1, zzh zzh1)
    {
        zzpd = new Object();
        zzCB = false;
        zzCF = null;
        mContext = context;
        zzCC = zzfw;
        zzCG = zzk;
        zzCD = zzb1;
        zzCE = zzh1;
        zzCF = zzCE.zzg(10L);
    }

    static zzk zza(zzc zzc1)
    {
        return zzc1.zzCG;
    }

    static Context zzb(zzc zzc1)
    {
        return zzc1.mContext;
    }

    static zzfw zzc(zzc zzc1)
    {
        return zzc1.zzCC;
    }

    private void zze(long l)
    {
        do
        {
            if (!zzf(l))
            {
                com.google.android.gms.ads.internal.util.client.zzb.v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!zzCB);
    }

    private boolean zzf(long l)
    {
        l = 60000L - (SystemClock.elapsedRealtime() - l);
        if (l <= 0L)
        {
            return false;
        }
        try
        {
            zzpd.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        synchronized (zzpd)
        {
            zzCD.zzN(ibinder);
            zzfm();
            zzCB = true;
            zzpd.notify();
        }
        return;
        ibinder;
        componentname;
        JVM INSTR monitorexit ;
        throw ibinder;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
        zzCD.destroy();
    }

    public void onStop()
    {
        synchronized (zzpd)
        {
            com.google.android.gms.common.stats.zzb.zzqh().zza(mContext, this);
            zzCD.destroy();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void zza(final zzf final_zzf1, String s, String s1)
    {
        Intent intent = new Intent();
        zzp.zzbF();
        intent.putExtra("RESPONSE_CODE", 0);
        zzp.zzbF();
        intent.putExtra("INAPP_PURCHASE_DATA", s);
        zzp.zzbF();
        intent.putExtra("INAPP_DATA_SIGNATURE", s1);
        zzid.zzIE.post(new Runnable(intent) {

            final Intent val$intent;
            final zzf zzCH;
            final zzc zzCI;

            public void run()
            {
                if (zzc.zza(zzCI).zza(zzCH.zzCR, -1, intent))
                {
                    zzc.zzc(zzCI).zza(new zzg(com.google.android.gms.ads.internal.purchase.zzc.zzb(zzCI), zzCH.zzCS, true, -1, intent, zzCH));
                    return;
                }
                try
                {
                    zzc.zzc(zzCI).zza(new zzg(com.google.android.gms.ads.internal.purchase.zzc.zzb(zzCI), zzCH.zzCS, false, -1, intent, zzCH));
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to verify and dispatch pending transaction");
                }
                return;
            }

            
            {
                zzCI = zzc.this;
                zzCH = final_zzf1;
                intent = intent1;
                super();
            }
        });
    }

    public void zzbn()
    {
        synchronized (zzpd)
        {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            com.google.android.gms.common.stats.zzb.zzqh().zza(mContext, intent, this, 1);
            zze(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.zzqh().zza(mContext, this);
            zzCD.destroy();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void zzfm()
    {
        if (!zzCF.isEmpty())
        {
            HashMap hashmap = new HashMap();
            zzf zzf1;
            for (Iterator iterator = zzCF.iterator(); iterator.hasNext(); hashmap.put(zzf1.zzCS, zzf1))
            {
                zzf1 = (zzf)iterator.next();
            }

            Object obj = null;
            do
            {
                obj = zzCD.zzj(mContext.getPackageName(), ((String) (obj)));
                if (obj == null || zzp.zzbF().zzc(((Bundle) (obj))) != 0)
                {
                    break;
                }
                ArrayList arraylist = ((Bundle) (obj)).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList arraylist1 = ((Bundle) (obj)).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList arraylist2 = ((Bundle) (obj)).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                obj = ((Bundle) (obj)).getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < arraylist.size(); i++)
                {
                    if (!hashmap.containsKey(arraylist.get(i)))
                    {
                        continue;
                    }
                    String s1 = (String)arraylist.get(i);
                    String s2 = (String)arraylist1.get(i);
                    String s3 = (String)arraylist2.get(i);
                    zzf zzf2 = (zzf)hashmap.get(s1);
                    String s4 = zzp.zzbF().zzao(s2);
                    if (zzf2.zzCR.equals(s4))
                    {
                        zza(zzf2, s2, s3);
                        hashmap.remove(s1);
                    }
                }

            } while (obj != null && !hashmap.isEmpty());
            obj = hashmap.keySet().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = (String)((Iterator) (obj)).next();
                zzCE.zza((zzf)hashmap.get(s));
            }
        }
    }
}
