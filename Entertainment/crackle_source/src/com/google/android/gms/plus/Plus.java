// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.hu;
import com.google.android.gms.internal.hx;
import com.google.android.gms.internal.hy;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.ia;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            Account, a, Moments, People

public final class Plus
{
    public static final class PlusOptions
        implements com.google.android.gms.common.api.GoogleApiClient.ApiOptions
    {

        final String Ds;
        final Set Dt;

        public static Builder builder()
        {
            return new Builder();
        }

        private PlusOptions()
        {
            Ds = null;
            Dt = new HashSet();
        }


        private PlusOptions(Builder builder1)
        {
            Ds = builder1.Ds;
            Dt = builder1.Dt;
        }

    }

    public static final class PlusOptions.Builder
    {

        String Ds;
        final Set Dt = new HashSet();

        public transient PlusOptions.Builder addActivityTypes(String as[])
        {
            eg.b(as, "activityTypes may not be null.");
            for (int i = 0; i < as.length; i++)
            {
                Dt.add(as[i]);
            }

            return this;
        }

        public PlusOptions build()
        {
            return new PlusOptions(this);
        }

        public PlusOptions.Builder setServerClientId(String s)
        {
            Ds = s;
            return this;
        }

        public PlusOptions.Builder()
        {
        }
    }

    public static abstract class a extends com.google.android.gms.common.api.a.a
    {

        public a(com.google.android.gms.common.api.Api.b b)
        {
            super(b);
        }
    }


    public static final Api API;
    public static final Account AccountApi;
    public static final com.google.android.gms.plus.a Dr;
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    static final com.google.android.gms.common.api.Api.b jO;

    private Plus()
    {
    }

    public static hs a(GoogleApiClient googleapiclient, com.google.android.gms.common.api.Api.b b)
    {
        boolean flag1 = true;
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "GoogleApiClient parameter is required.");
        eg.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (hs)googleapiclient.a(b);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.a(flag, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    static 
    {
        jO = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return g(context, dt1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public hs g(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                Object obj = new PlusOptions();
                String s;
                String s1;
                if (apioptions != null)
                {
                    eg.b(apioptions instanceof PlusOptions, "Must provide valid PlusOptions!");
                    apioptions = (PlusOptions)apioptions;
                } else
                {
                    apioptions = ((com.google.android.gms.common.api.GoogleApiClient.ApiOptions) (obj));
                }
                obj = dt1.bF();
                dt1 = dt1.bI();
                apioptions = (String[])((PlusOptions) (apioptions)).Dt.toArray(new String[0]);
                s = context.getPackageName();
                s1 = context.getPackageName();
                return new hs(context, connectioncallbacks, onconnectionfailedlistener, new hu(((String) (obj)), dt1, apioptions, new String[0], s, s1, null));
            }

            public int getPriority()
            {
                return 2;
            }

        };
        API = new Api(jO, new Scope[0]);
        MomentsApi = new hz(jO);
        PeopleApi = new ia(jO);
        AccountApi = new hx(jO);
        Dr = new hy(jO);
    }
}
