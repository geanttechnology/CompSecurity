// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            Account, Moments, People, zzb, 
//            zza

public final class Plus
{
    public static final class PlusOptions
        implements com.google.android.gms.common.api.Api.ApiOptions.Optional
    {

        final String zzaLe;
        final Set zzaLf;

        public static Builder builder()
        {
            return new Builder();
        }

        private PlusOptions()
        {
            zzaLe = null;
            zzaLf = new HashSet();
        }


        private PlusOptions(Builder builder1)
        {
            zzaLe = builder1.zzaLe;
            zzaLf = builder1.zzaLf;
        }

    }

    public static final class PlusOptions.Builder
    {

        String zzaLe;
        final Set zzaLf = new HashSet();

        public transient PlusOptions.Builder addActivityTypes(String as[])
        {
            zzx.zzb(as, "activityTypes may not be null.");
            for (int i = 0; i < as.length; i++)
            {
                zzaLf.add(as[i]);
            }

            return this;
        }

        public PlusOptions build()
        {
            return new PlusOptions(this);
        }

        public PlusOptions.Builder setServerClientId(String s)
        {
            zzaLe = s;
            return this;
        }

        public PlusOptions.Builder()
        {
        }
    }

    public static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(Plus.zzQf, googleapiclient);
        }
    }


    public static final Api API;
    public static final com.google.android.gms.plus.Account AccountApi = new zzpn();
    public static final Moments MomentsApi = new zzpq();
    public static final People PeopleApi = new zzpr();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    public static final com.google.android.gms.common.api.Api.zzc zzQf;
    static final com.google.android.gms.common.api.Api.zza zzQg;
    public static final zzb zzaLc = new zzpp();
    public static final com.google.android.gms.plus.zza zzaLd = new zzpo();

    private Plus()
    {
    }

    public static zze zzf(GoogleApiClient googleapiclient, boolean flag)
    {
        boolean flag1;
        if (googleapiclient != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzx.zzb(flag1, "GoogleApiClient parameter is required.");
        zzx.zza(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        zzx.zza(googleapiclient.zza(API), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        flag1 = googleapiclient.hasConnectedApi(API);
        if (flag && !flag1)
        {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
        if (flag1)
        {
            return (zze)googleapiclient.zza(zzQf);
        } else
        {
            return null;
        }
    }

    static 
    {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new com.google.android.gms.common.api.Api.zza() {

            public int getPriority()
            {
                return 2;
            }

            public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zza(context, looper, zzf1, (PlusOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zze zza(Context context, Looper looper, zzf zzf1, PlusOptions plusoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                PlusOptions plusoptions1 = plusoptions;
                if (plusoptions == null)
                {
                    plusoptions1 = new PlusOptions();
                }
                plusoptions = zzf1.zzog().name;
                String as1[] = zzly.zzc(zzf1.zzoj());
                String as[] = (String[])plusoptions1.zzaLf.toArray(new String[0]);
                String s = context.getPackageName();
                String s1 = context.getPackageName();
                PlusCommonExtras pluscommonextras = new PlusCommonExtras();
                return new zze(context, looper, zzf1, new PlusSession(plusoptions, as1, as, new String[0], s, s1, null, pluscommonextras), connectioncallbacks, onconnectionfailedlistener);
            }

        };
        API = new Api("Plus.API", zzQg, zzQf);
    }
}
