// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
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
//            zzmk, zznt, zzmv

public class zznm
    implements BleApi
{
    private static class zza extends zznv.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(BleDevicesResult bledevicesresult)
        {
            zzQz.zzn(bledevicesresult);
        }

        private zza(com.google.android.gms.common.api.zzc.zzb zzb)
        {
            zzQz = zzb;
        }

    }


    public zznm()
    {
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return googleapiclient.zzb(new zzmk.zzc(googleapiclient, bledevice) {

            final zznm zzaoP;
            final BleDevice zzaoS;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmk)zzb);
            }

            protected void zza(zzmk zzmk1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmk1.getContext().getPackageName();
                ((zzmv)zzmk1.zzoA()).zza(new ClaimBleDeviceRequest(zzaoS.getAddress(), zzaoS, zznt1, s));
            }

            
            {
                zzaoP = zznm.this;
                zzaoS = bledevice;
                super(googleapiclient);
            }
        });
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzmk.zzc(googleapiclient, s) {

            final zznm zzaoP;
            final String zzaoR;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmk)zzb);
            }

            protected void zza(zzmk zzmk1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s1 = zzmk1.getContext().getPackageName();
                ((zzmv)zzmk1.zzoA()).zza(new ClaimBleDeviceRequest(zzaoR, null, zznt1, s1));
            }

            
            {
                zzaoP = zznm.this;
                zzaoR = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listClaimedBleDevices(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzmk.zza(googleapiclient) {

            final zznm zzaoP;

            protected BleDevicesResult zzH(Status status)
            {
                return BleDevicesResult.zzP(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmk)zzb1);
            }

            protected void zza(zzmk zzmk1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzmk1.getContext().getPackageName();
                ((zzmv)zzmk1.zzoA()).zza(new ListClaimedBleDevicesRequest(zza1, s));
            }

            protected Result zzb(Status status)
            {
                return zzH(status);
            }

            
            {
                zzaoP = zznm.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult startBleScan(GoogleApiClient googleapiclient, StartBleScanRequest startblescanrequest)
    {
        return googleapiclient.zza(new zzmk.zzc(googleapiclient, startblescanrequest) {

            final StartBleScanRequest zzaoO;
            final zznm zzaoP;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmk)zzb);
            }

            protected void zza(zzmk zzmk1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmk1.getContext().getPackageName();
                ((zzmv)zzmk1.zzoA()).zza(new StartBleScanRequest(zzaoO, zznt1, s));
            }

            
            {
                zzaoP = zznm.this;
                zzaoO = startblescanrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopBleScan(GoogleApiClient googleapiclient, BleScanCallback blescancallback)
    {
        return googleapiclient.zza(new zzmk.zzc(googleapiclient, blescancallback) {

            final zznm zzaoP;
            final BleScanCallback zzaoQ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmk)zzb);
            }

            protected void zza(zzmk zzmk1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmk1.getContext().getPackageName();
                ((zzmv)zzmk1.zzoA()).zza(new StopBleScanRequest(zzaoQ, zznt1, s));
            }

            
            {
                zzaoP = zznm.this;
                zzaoQ = blescancallback;
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
        return googleapiclient.zzb(new zzmk.zzc(googleapiclient, s) {

            final zznm zzaoP;
            final String zzaoR;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzmk)zzb);
            }

            protected void zza(zzmk zzmk1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s1 = zzmk1.getContext().getPackageName();
                ((zzmv)zzmk1.zzoA()).zza(new UnclaimBleDeviceRequest(zzaoR, zznt1, s1));
            }

            
            {
                zzaoP = zznm.this;
                zzaoR = s;
                super(googleapiclient);
            }
        });
    }
}
