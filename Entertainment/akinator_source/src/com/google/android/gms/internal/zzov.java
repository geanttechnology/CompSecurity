// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzov
    implements BleApi
{

    private static final Status zzarV = new Status(5007);

    public zzov()
    {
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return PendingResults.zza(zzarV, googleapiclient);
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return PendingResults.zza(zzarV, googleapiclient);
    }

    public PendingResult listClaimedBleDevices(GoogleApiClient googleapiclient)
    {
        return PendingResults.zza(BleDevicesResult.zzP(zzarV), googleapiclient);
    }

    public PendingResult startBleScan(GoogleApiClient googleapiclient, StartBleScanRequest startblescanrequest)
    {
        return PendingResults.zza(zzarV, googleapiclient);
    }

    public PendingResult stopBleScan(GoogleApiClient googleapiclient, BleScanCallback blescancallback)
    {
        return PendingResults.zza(zzarV, googleapiclient);
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return PendingResults.zza(zzarV, googleapiclient);
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return PendingResults.zza(zzarV, googleapiclient);
    }

}
