// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.internal:
//            zzlg, zzli

class zzabT
    implements com.google.android.gms.common.api.Client.zza
{

    private final WeakReference zzabM;
    private final Api zzabS;
    private final int zzabT;

    public void zza(ConnectionResult connectionresult)
    {
        zzlg zzlg1;
        boolean flag = false;
        zzlg1 = (zzlg)zzabM.get();
        if (zzlg1 == null)
        {
            return;
        }
        if (Looper.myLooper() == zzlg.zzd(zzlg1).getLooper())
        {
            flag = true;
        }
        zzx.zza(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zzlg.zzc(zzlg1).lock();
        boolean flag1 = zzlg.zza(zzlg1, 0);
        if (!flag1)
        {
            zzlg.zzc(zzlg1).unlock();
            return;
        }
        if (!connectionresult.isSuccess())
        {
            zzlg.zza(zzlg1, connectionresult, zzabS, zzabT);
        }
        if (zzlg.zzk(zzlg1))
        {
            zzlg.zzl(zzlg1);
        }
        zzlg.zzc(zzlg1).unlock();
        return;
        connectionresult;
        zzlg.zzc(zzlg1).unlock();
        throw connectionresult;
    }

    public void zzb(ConnectionResult connectionresult)
    {
        zzlg zzlg1;
        boolean flag = true;
        zzlg1 = (zzlg)zzabM.get();
        if (zzlg1 == null)
        {
            return;
        }
        if (Looper.myLooper() != zzlg.zzd(zzlg1).getLooper())
        {
            flag = false;
        }
        zzx.zza(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
        zzlg.zzc(zzlg1).lock();
        flag = zzlg.zza(zzlg1, 1);
        if (!flag)
        {
            zzlg.zzc(zzlg1).unlock();
            return;
        }
        if (!connectionresult.isSuccess())
        {
            zzlg.zza(zzlg1, connectionresult, zzabS, zzabT);
        }
        if (zzlg.zzk(zzlg1))
        {
            zzlg.zzm(zzlg1);
        }
        zzlg.zzc(zzlg1).unlock();
        return;
        connectionresult;
        zzlg.zzc(zzlg1).unlock();
        throw connectionresult;
    }

    public esult(zzlg zzlg1, Api api, int i)
    {
        zzabM = new WeakReference(zzlg1);
        zzabS = api;
        zzabT = i;
    }
}
