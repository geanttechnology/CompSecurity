// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzlg, zzli, zzqw

class zzabU extends zzabU
{

    final zzlg zzabL;
    private final Map zzabU;

    public void zznO()
    {
        int i = zzlg.zzb(zzabL).isGooglePlayServicesAvailable(zzlg.zza(zzabL));
        if (i != 0)
        {
            ConnectionResult connectionresult = new ConnectionResult(i, null);
            class _cls1 extends zzli.zzb
            {

                final ConnectionResult zzabV;
                final zzlg.zze zzabW;

                public void zznO()
                {
                    zzlg.zza(zzabW.zzabL, zzabV);
                }

            _cls1(zzlj zzlj, ConnectionResult connectionresult)
            {
                zzabW = zzlg.zze.this;
                zzabV = connectionresult;
                super(zzlj);
            }
            }

            zzlg.zzd(zzabL).zza(new _cls1(zzabL, connectionresult));
        } else
        {
            if (zzlg.zze(zzabL))
            {
                zzlg.zzf(zzabL).connect();
            }
            Iterator iterator = zzabU.keySet().iterator();
            while (iterator.hasNext()) 
            {
                com.google.android.gms.common.api.ult ult = (com.google.android.gms.common.api.abU)iterator.next();
                ult.za((com.google.android.gms.common.api.Client.zza)zzabU.get(ult));
            }
        }
    }

    public piClient.zza(zzlg zzlg1, Map map)
    {
        zzabL = zzlg1;
        super(zzlg1, null);
        zzabU = map;
    }
}
