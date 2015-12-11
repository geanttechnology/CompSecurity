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
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.hc;

// Referenced classes of package com.google.android.gms.identity.intents:
//            UserAddressRequest

public final class Address
{
    public static final class AddressOptions
        implements com.google.android.gms.common.api.GoogleApiClient.ApiOptions
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

    private static abstract class a extends com.google.android.gms.common.api.a.a
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        public a()
        {
            super(Address.va);
        }
    }


    public static final Api API;
    static final com.google.android.gms.common.api.Api.b va;

    public Address()
    {
    }

    public static void requestUserAddress(GoogleApiClient googleapiclient, UserAddressRequest useraddressrequest, int i)
    {
        googleapiclient.a(new a(useraddressrequest, i) {

            final UserAddressRequest Kw;
            final int Kx;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((hc)a1);
            }

            protected void a(hc hc1)
                throws RemoteException
            {
                hc1.a(Kw, Kx);
                a(((Result) (Status.zQ)));
            }

            
            {
                Kw = useraddressrequest;
                Kx = i;
                super();
            }
        });
    }

    static 
    {
        va = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return f(context, looper, ee1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public hc f(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                er.b(context instanceof Activity, "An Activity must be used for Address APIs");
                AddressOptions addressoptions = new AddressOptions();
                if (apioptions != null)
                {
                    er.b(apioptions instanceof AddressOptions, "Must use AddressOptions with Address API");
                    apioptions = (AddressOptions)apioptions;
                } else
                {
                    apioptions = addressoptions;
                }
                return new hc((Activity)context, looper, connectioncallbacks, onconnectionfailedlistener, ee1.getAccountName(), ((AddressOptions) (apioptions)).theme);
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

        };
        API = new Api(va, new Scope[0]);
    }
}
