// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzjh, zzjc

class eApiClient extends c
{

    final String zzPX;
    final UsageInfo zzPY[];
    final zzjh zzPZ;

    protected void zza(zzjc zzjc1)
        throws RemoteException
    {
        zzjc1.zza(new d(this), zzPX, zzPY);
    }

    eApiClient(zzjh zzjh1, GoogleApiClient googleapiclient, String s, UsageInfo ausageinfo[])
    {
        zzPZ = zzjh1;
        zzPX = s;
        zzPY = ausageinfo;
        super(googleapiclient);
    }
}
