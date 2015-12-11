// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;


// Referenced classes of package com.google.android.gms.common.api:
//            ResultCallback, zzg, Status, zzk, 
//            GoogleApiClient, Result

class zzMO
    implements ResultCallback
{

    final GoogleApiClient zzMO;
    final zzg zzQJ;
    final zzk zzQN;
    final boolean zzQO;

    public void onResult(Result result)
    {
        zzi((Status)result);
    }

    public void zzi(Status status)
    {
        if (status.isSuccess() && zzQJ.isConnected())
        {
            zzQJ.reconnect();
        }
        zzQN.setResult(status);
        if (zzQO)
        {
            zzMO.disconnect();
        }
    }

    ApiClient(zzg zzg1, zzk zzk1, boolean flag, GoogleApiClient googleapiclient)
    {
        zzQJ = zzg1;
        zzQN = zzk1;
        zzQO = flag;
        zzMO = googleapiclient;
        super();
    }
}
