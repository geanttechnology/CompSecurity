// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzhu;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zzb, zzi

class zzry
    implements ServiceConnection
{

    final zzi zzDa;
    final Context zzry;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        boolean flag = false;
        componentname = new zzb(zzry.getApplicationContext(), false);
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

    (zzi zzi, Context context)
    {
        zzDa = zzi;
        zzry = context;
        super();
    }
}
