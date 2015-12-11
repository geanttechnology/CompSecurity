// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzv, zzp, zzq, zzu

class zzr extends BroadcastReceiver
{

    static final String zzPu = com/google/android/gms/measurement/internal/zzr.getName();
    private boolean zzPv;
    private boolean zzPw;
    private final zzv zzaKG;

    zzr(zzv zzv1)
    {
        zzx.zzw(zzv1);
        zzaKG = zzv1;
    }

    private Context getContext()
    {
        return zzaKG.getContext();
    }

    static zzv zza(zzr zzr1)
    {
        return zzr1.zzaKG;
    }

    private zzp zzyd()
    {
        return zzaKG.zzyd();
    }

    public boolean isRegistered()
    {
        zzaKG.zzis();
        return zzPv;
    }

    public void onReceive(Context context, Intent intent)
    {
        zzaKG.zziE();
        context = intent.getAction();
        zzyd().zzzQ().zzj("NetworkBroadcastReceiver received action", context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(context))
        {
            boolean flag = zzaKG.zzAe().zzkK();
            if (zzPw != flag)
            {
                zzPw = flag;
                zzaKG.zzzr().zzh(new Runnable(flag) {

                    final boolean zzaNe;
                    final zzr zzaNf;

                    public void run()
                    {
                        zzr.zza(zzaNf).zzI(zzaNe);
                    }

            
            {
                zzaNf = zzr.this;
                zzaNe = flag;
                super();
            }
                });
            }
            return;
        } else
        {
            zzyd().zzzL().zzj("NetworkBroadcastReceiver received unknown action", context);
            return;
        }
    }

    public void unregister()
    {
        zzaKG.zziE();
        zzaKG.zzis();
        if (!isRegistered())
        {
            return;
        }
        zzyd().zzzQ().zzec("Unregistering connectivity change receiver");
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
            zzyd().zzzK().zzj("Failed to unregister the network broadcast receiver", illegalargumentexception);
        }
    }

    public void zzkH()
    {
        zzaKG.zziE();
        zzaKG.zzis();
        if (zzPv)
        {
            return;
        } else
        {
            getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            zzPw = zzaKG.zzAe().zzkK();
            zzyd().zzzQ().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(zzPw));
            zzPv = true;
            return;
        }
    }

}
