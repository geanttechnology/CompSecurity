// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznj

public class zznu
    implements BleApi
{

    private static final Status zzapy = new Status(5007);

    public zznu()
    {
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return new zznj(zzapy);
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return new zznj(zzapy);
    }

    public PendingResult listClaimedBleDevices(GoogleApiClient googleapiclient)
    {
        return new zznj(BleDevicesResult.zzP(zzapy));
    }

    public PendingResult startBleScan(GoogleApiClient googleapiclient, StartBleScanRequest startblescanrequest)
    {
        return new zznj(zzapy);
    }

    public PendingResult stopBleScan(GoogleApiClient googleapiclient, BleScanCallback blescancallback)
    {
        return new zznj(zzapy);
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return new zznj(zzapy);
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return new zznj(zzapy);
    }

}
