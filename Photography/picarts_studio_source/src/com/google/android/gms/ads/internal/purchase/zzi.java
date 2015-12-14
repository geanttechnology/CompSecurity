// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzid;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            GInAppPurchaseManagerInfoParcel, zzb

public class zzi
{

    public zzi()
    {
    }

    public void zza(Context context, boolean flag, GInAppPurchaseManagerInfoParcel ginapppurchasemanagerinfoparcel)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", flag);
        GInAppPurchaseManagerInfoParcel.zza(intent, ginapppurchasemanagerinfoparcel);
        zzp.zzbv().zzb(context, intent);
    }

    public String zzao(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = (new JSONObject(s)).getString("developerPayload");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzaH("Fail to parse purchase data");
            return null;
        }
        return s;
    }

    public String zzap(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = (new JSONObject(s)).getString("purchaseToken");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzaH("Fail to parse purchase data");
            return null;
        }
        return s;
    }

    public int zzc(Bundle bundle)
    {
        bundle = ((Bundle) (bundle.get("RESPONSE_CODE")));
        if (bundle == null)
        {
            zzb.zzaH("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (bundle instanceof Integer)
        {
            return ((Integer)bundle).intValue();
        }
        if (bundle instanceof Long)
        {
            return (int)((Long)bundle).longValue();
        } else
        {
            zzb.zzaH((new StringBuilder("Unexpected type for intent response code. ")).append(bundle.getClass().getName()).toString());
            return 5;
        }
    }

    public int zzd(Intent intent)
    {
        if (intent == null)
        {
            return 5;
        }
        intent = ((Intent) (intent.getExtras().get("RESPONSE_CODE")));
        if (intent == null)
        {
            zzb.zzaH("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (intent instanceof Integer)
        {
            return ((Integer)intent).intValue();
        }
        if (intent instanceof Long)
        {
            return (int)((Long)intent).longValue();
        } else
        {
            zzb.zzaH((new StringBuilder("Unexpected type for intent response code. ")).append(intent.getClass().getName()).toString());
            return 5;
        }
    }

    public String zze(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return intent.getStringExtra("INAPP_PURCHASE_DATA");
        }
    }

    public String zzf(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return intent.getStringExtra("INAPP_DATA_SIGNATURE");
        }
    }

    public void zzx(Context context)
    {
        ServiceConnection serviceconnection = new ServiceConnection(context) {

            final zzi zzDa;
            final Context zzry;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                boolean flag = false;
                componentname = new com.google.android.gms.ads.internal.purchase.zzb(zzry.getApplicationContext(), false);
                componentname.zzN(ibinder);
                int i = componentname.zza(3, zzry.getPackageName(), "inapp");
                ibinder = zzp.zzby();
                if (i == 0)
                {
                    flag = true;
                }
                ibinder.zzB(flag);
                zzry.unbindService(this);
                componentname.destroy();
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
            }

            
            {
                zzDa = zzi.this;
                zzry = context;
                super();
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        context.bindService(intent, serviceconnection, 1);
    }
}
