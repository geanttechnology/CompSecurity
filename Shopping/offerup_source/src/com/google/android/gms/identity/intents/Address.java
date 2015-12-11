// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.identity.intents:
//            UserAddressRequest

public final class Address
{

    public static final Api API;
    static final com.google.android.gms.common.api.Api.zzc zzRk;
    private static final com.google.android.gms.common.api.Api.zza zzRl;

    public Address()
    {
    }

    public static void requestUserAddress(GoogleApiClient googleapiclient, UserAddressRequest useraddressrequest, int i)
    {
        googleapiclient.zza(new _cls2(googleapiclient, useraddressrequest, i));
    }

    static 
    {
        zzRk = new com.google.android.gms.common.api.Api.zzc();
        zzRl = new _cls1();
        API = new Api("Address.API", zzRl, zzRk);
    }

    private class _cls2 extends zza
    {
        private class zza extends com.google.android.gms.internal.zzlb.zza
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
                super(Address.zzRk, googleapiclient);
            }
        }


        final UserAddressRequest zzaDf;
        final int zzaDg;

        protected final volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzoy)zzb);
        }

        protected final void zza(zzoy zzoy1)
        {
            zzoy1.zza(zzaDf, zzaDg);
            zzb(Status.zzabb);
        }

        _cls2(GoogleApiClient googleapiclient, UserAddressRequest useraddressrequest, int i)
        {
            zzaDf = useraddressrequest;
            zzaDg = i;
            super(googleapiclient);
        }
    }


    private class _cls1 extends com.google.android.gms.common.api.Api.zza
    {

        public final volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (AddressOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final zzoy zza(Context context, Looper looper, zzf zzf, AddressOptions addressoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            zzx.zzb(context instanceof Activity, "An Activity must be used for Address APIs");
            AddressOptions addressoptions1 = addressoptions;
            if (addressoptions == null)
            {
                addressoptions1 = new AddressOptions();
            }
            return new zzoy((Activity)context, looper, zzf, addressoptions1.theme, connectioncallbacks, onconnectionfailedlistener);
        }

        _cls1()
        {
        }

        private class AddressOptions
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

    }

}
