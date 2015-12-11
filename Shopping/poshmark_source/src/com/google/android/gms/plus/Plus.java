// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.il;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.h;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            Account, Moments, People, a

public final class Plus
{
    public static final class PlusOptions
        implements com.google.android.gms.common.api.GoogleApiClient.ApiOptions
    {

        final String QL;
        final Set QM;

        public static Builder builder()
        {
            return new Builder();
        }

        private PlusOptions()
        {
            QL = null;
            QM = new HashSet();
        }


        private PlusOptions(Builder builder1)
        {
            QL = builder1.QL;
            QM = builder1.QM;
        }

    }

    public static final class PlusOptions.Builder
    {

        String QL;
        final Set QM = new HashSet();

        public transient PlusOptions.Builder addActivityTypes(String as[])
        {
            er.b(as, "activityTypes may not be null.");
            for (int i = 0; i < as.length; i++)
            {
                QM.add(as[i]);
            }

            return this;
        }

        public PlusOptions build()
        {
            return new PlusOptions(this);
        }

        public PlusOptions.Builder setServerClientId(String s)
        {
            QL = s;
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
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final com.google.android.gms.plus.a QK;
    public static final Scope SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    static final com.google.android.gms.common.api.Api.b va;

    private Plus()
    {
    }

    public static e a(GoogleApiClient googleapiclient, com.google.android.gms.common.api.Api.b b)
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
        er.b(flag, "GoogleApiClient parameter is required.");
        er.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (e)googleapiclient.a(b);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        er.a(flag, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    static 
    {
        va = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return h(context, looper, ee1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public int getPriority()
            {
                return 2;
            }

            public e h(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                Object obj = new PlusOptions();
                String s;
                String s1;
                PlusCommonExtras pluscommonextras;
                if (apioptions != null)
                {
                    er.b(apioptions instanceof PlusOptions, "Must provide valid PlusOptions!");
                    apioptions = (PlusOptions)apioptions;
                } else
                {
                    apioptions = ((com.google.android.gms.common.api.GoogleApiClient.ApiOptions) (obj));
                }
                obj = ee1.dR();
                ee1 = ee1.dU();
                apioptions = (String[])((PlusOptions) (apioptions)).QM.toArray(new String[0]);
                s = context.getPackageName();
                s1 = context.getPackageName();
                pluscommonextras = new PlusCommonExtras();
                return new e(context, looper, connectioncallbacks, onconnectionfailedlistener, new h(((String) (obj)), ee1, apioptions, new String[0], s, s1, null, pluscommonextras));
            }

        };
        API = new Api(va, new Scope[0]);
        MomentsApi = new ik(va);
        PeopleApi = new il(va);
        AccountApi = new ii(va);
        QK = new ij(va);
    }
}
