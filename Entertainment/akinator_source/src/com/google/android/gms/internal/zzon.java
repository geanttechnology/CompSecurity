// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznm, zzou, zznx

public class zzon
    implements BleApi
{
    private static class zza extends zzow.zza
    {

        private final zzlb.zzb zzagy;

        public void zza(BleDevicesResult bledevicesresult)
        {
            zzagy.zzp(bledevicesresult);
        }

        private zza(zzlb.zzb zzb)
        {
            zzagy = zzb;
        }

    }


    public zzon()
    {
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return googleapiclient.zzb(new zznm.zzc(googleapiclient, bledevice) {

            final zzon zzarm;
            final BleDevice zzarp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznm)zzb);
            }

            protected void zza(zznm zznm1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zznx)zznm1.zzpc()).zza(new ClaimBleDeviceRequest(zzarp.getAddress(), zzarp, zzou1));
            }

            
            {
                zzarm = zzon.this;
                zzarp = bledevice;
                super(googleapiclient);
            }
        });
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zznm.zzc(googleapiclient, s) {

            final zzon zzarm;
            final String zzaro;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznm)zzb);
            }

            protected void zza(zznm zznm1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zznx)zznm1.zzpc()).zza(new ClaimBleDeviceRequest(zzaro, null, zzou1));
            }

            
            {
                zzarm = zzon.this;
                zzaro = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listClaimedBleDevices(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zznm.zza(googleapiclient) {

            final zzon zzarm;

            protected BleDevicesResult zzH(Status status)
            {
                return BleDevicesResult.zzP(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zznm)zzb1);
            }

            protected void zza(zznm zznm1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                ((zznx)zznm1.zzpc()).zza(new ListClaimedBleDevicesRequest(zza1));
            }

            protected Result zzb(Status status)
            {
                return zzH(status);
            }

            
            {
                zzarm = zzon.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult startBleScan(GoogleApiClient googleapiclient, StartBleScanRequest startblescanrequest)
    {
        return googleapiclient.zza(new zznm.zzc(googleapiclient, startblescanrequest) {

            final StartBleScanRequest zzarl;
            final zzon zzarm;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznm)zzb);
            }

            protected void zza(zznm zznm1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zznx)zznm1.zzpc()).zza(new StartBleScanRequest(zzarl, zzou1));
            }

            
            {
                zzarm = zzon.this;
                zzarl = startblescanrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopBleScan(GoogleApiClient googleapiclient, BleScanCallback blescancallback)
    {
        return googleapiclient.zza(new zznm.zzc(googleapiclient, blescancallback) {

            final zzon zzarm;
            final BleScanCallback zzarn;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznm)zzb);
            }

            protected void zza(zznm zznm1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zznx)zznm1.zzpc()).zza(new StopBleScanRequest(zzarn, zzou1));
            }

            
            {
                zzarm = zzon.this;
                zzarn = blescancallback;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return unclaimBleDevice(googleapiclient, bledevice.getAddress());
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zznm.zzc(googleapiclient, s) {

            final zzon zzarm;
            final String zzaro;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznm)zzb);
            }

            protected void zza(zznm zznm1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zznx)zznm1.zzpc()).zza(new UnclaimBleDeviceRequest(zzaro, zzou1));
            }

            
            {
                zzarm = zzon.this;
                zzaro = s;
                super(googleapiclient);
            }
        });
    }
}
