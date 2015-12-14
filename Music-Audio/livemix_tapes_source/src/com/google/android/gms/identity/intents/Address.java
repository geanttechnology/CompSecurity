// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznx;

// Referenced classes of package com.google.android.gms.identity.intents:
//            UserAddressRequest

public final class Address
{
    public static final class AddressOptions
        implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
    {

        public final int theme;

        public AddressOptions()
        {
            theme = 0;
        }

        public AddressOptions(int i)
        {
            theme = i;
        }
    }

    private static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(Address.zzQf, googleapiclient);
        }
    }


    public static final Api API;
    static final com.google.android.gms.common.api.Api.zzc zzQf;
    private static final com.google.android.gms.common.api.Api.zza zzQg;

    public Address()
    {
    }

    public static void requestUserAddress(GoogleApiClient googleapiclient, UserAddressRequest useraddressrequest, int i)
    {
        googleapiclient.zza(new zza(googleapiclient, useraddressrequest, i) {

            final UserAddressRequest zzaAx;
            final int zzaAy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zznx)zzb);
            }

            protected void zza(zznx zznx1)
                throws RemoteException
            {
                zznx1.zza(zzaAx, zzaAy);
                zza(((Result) (Status.zzaaD)));
            }

            
            {
                zzaAx = useraddressrequest;
                zzaAy = i;
                super(googleapiclient);
            }
        });
    }

    static 
    {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new com.google.android.gms.common.api.Api.zza() {

            public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zza(context, looper, zzf, (AddressOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zznx zza(Context context, Looper looper, zzf zzf, AddressOptions addressoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                zzx.zzb(context instanceof Activity, "An Activity must be used for Address APIs");
                AddressOptions addressoptions1 = addressoptions;
                if (addressoptions == null)
                {
                    addressoptions1 = new AddressOptions();
                }
                return new zznx((Activity)context, looper, zzf, addressoptions1.theme, connectioncallbacks, onconnectionfailedlistener);
            }

        };
        API = new Api("Address.API", zzQg, zzQf);
    }
}
