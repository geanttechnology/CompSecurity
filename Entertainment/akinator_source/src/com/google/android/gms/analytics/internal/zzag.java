// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzf, zzaf, zzb

class zzag extends BroadcastReceiver
{

    static final String zzPu = com/google/android/gms/analytics/internal/zzag.getName();
    private final zzf zzME;
    private boolean zzPv;
    private boolean zzPw;

    zzag(zzf zzf1)
    {
        zzx.zzw(zzf1);
        zzME = zzf1;
    }

    private Context getContext()
    {
        return zzME.getContext();
    }

    private zzb zzhP()
    {
        return zzME.zzhP();
    }

    private zzaf zziu()
    {
        return zzME.zziu();
    }

    private void zzkI()
    {
        zziu();
        zzhP();
    }

    public boolean isConnected()
    {
        if (!zzPv)
        {
            zzME.zziu().zzbd("Connectivity unknown. Receiver not registered");
        }
        return zzPw;
    }

    public boolean isRegistered()
    {
        return zzPv;
    }

    public void onReceive(Context context, Intent intent)
    {
        zzkI();
        context = intent.getAction();
        zzME.zziu().zza("NetworkBroadcastReceiver received action", context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(context))
        {
            boolean flag = zzkK();
            if (zzPw != flag)
            {
                zzPw = flag;
                zzhP().zzI(flag);
            }
        } else
        if ("com.google.analytics.RADIO_POWERED".equals(context))
        {
            if (!intent.hasExtra(zzPu))
            {
                zzhP().zzio();
                return;
            }
        } else
        {
            zzME.zziu().zzd("NetworkBroadcastReceiver received unknown action", context);
            return;
        }
    }

    public void unregister()
    {
        if (!isRegistered())
        {
            return;
        }
        zzME.zziu().zzba("Unregistering connectivity change receiver");
        zzPv = false;
        zzPw = false;
        Context context = getContext();
        try
        {
            context.unregisterReceiver(this);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            zziu().zze("Failed to unregister the network broadcast receiver", illegalargumentexception);
        }
    }

    public void zzkH()
    {
        zzkI();
        if (zzPv)
        {
            return;
        } else
        {
            Context context = getContext();
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentfilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentfilter.addCategory(context.getPackageName());
            context.registerReceiver(this, intentfilter);
            zzPw = zzkK();
            zzME.zziu().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(zzPw));
            zzPv = true;
            return;
        }
    }

    public void zzkJ()
    {
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            return;
        } else
        {
            Context context = getContext();
            Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
            intent.addCategory(context.getPackageName());
            intent.putExtra(zzPu, true);
            context.sendOrderedBroadcast(intent, null);
            return;
        }
    }

    protected boolean zzkK()
    {
        Object obj = (ConnectivityManager)getContext().getSystemService("connectivity");
        boolean flag;
        try
        {
            obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        }
        catch (SecurityException securityexception)
        {
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        flag = ((NetworkInfo) (obj)).isConnected();
        if (flag)
        {
            return true;
        }
        return false;
    }

}
