// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzpq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            Api, zzm, zzg, zzn, 
//            Scope

public interface GoogleApiClient
{
    public static final class Builder
    {

        private final Context mContext;
        private Account zzMY;
        private String zzOd;
        private String zzOe;
        private FragmentActivity zzWA;
        private int zzWB;
        private int zzWC;
        private OnConnectionFailedListener zzWD;
        private Api.zza zzWE;
        private final Set zzWF = new HashSet();
        private final Set zzWG = new HashSet();
        private com.google.android.gms.internal.zzpt.zza zzWH;
        private Looper zzWt;
        private final Set zzWv = new HashSet();
        private int zzWw;
        private View zzWx;
        private final Map zzWy = new HashMap();
        private final Map zzWz = new HashMap();

        private GoogleApiClient zzmy()
        {
            zzm zzm1 = zzm.zza(zzWA);
            zzg zzg1 = new zzg(mContext.getApplicationContext(), zzWt, zzmx(), zzWE, zzWz, zzWF, zzWG, zzWB, -1);
            zzm1.zza(zzWB, zzg1, zzWD);
            return zzg1;
        }

        private GoogleApiClient zzmz()
        {
            zzn zzn1 = zzn.zzb(zzWA);
            GoogleApiClient googleapiclient = zzn1.zzbc(zzWC);
            Object obj = googleapiclient;
            if (googleapiclient == null)
            {
                obj = new zzg(mContext.getApplicationContext(), zzWt, zzmx(), zzWE, zzWz, zzWF, zzWG, -1, zzWC);
            }
            zzn1.zza(zzWC, ((GoogleApiClient) (obj)), zzWD);
            return ((GoogleApiClient) (obj));
        }

        public Builder addApi(Api api)
        {
            zzWz.put(api, null);
            zzWv.addAll(api.zzmr());
            return this;
        }

        public Builder addApi(Api api, Api.ApiOptions.HasOptions hasoptions)
        {
            zzu.zzb(hasoptions, "Null options are not permitted for this Api");
            zzWz.put(api, hasoptions);
            zzWv.addAll(api.zzmr());
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectioncallbacks)
        {
            zzWF.add(connectioncallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener)
        {
            zzWG.add(onconnectionfailedlistener);
            return this;
        }

        public Builder addScope(Scope scope)
        {
            zzWv.add(scope);
            return this;
        }

        public GoogleApiClient build()
        {
            boolean flag;
            if (!zzWz.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzu.zzb(flag, "must call addApi() to add at least one API");
            if (zzWB >= 0)
            {
                return zzmy();
            }
            if (zzWC >= 0)
            {
                return zzmz();
            } else
            {
                return new zzg(mContext, zzWt, zzmx(), zzWE, zzWz, zzWF, zzWG, -1, -1);
            }
        }

        public Builder requestServerAuthCode(String s, ServerAuthCodeCallbacks serverauthcodecallbacks)
        {
            zzWH.zza(s, serverauthcodecallbacks);
            return this;
        }

        public Builder setAccountName(String s)
        {
            if (s == null)
            {
                s = null;
            } else
            {
                s = new Account(s, "com.google");
            }
            zzMY = s;
            return this;
        }

        public zze zzmx()
        {
            return new zze(zzMY, zzWv, zzWy, zzWw, zzWx, zzOe, zzOd, zzWH.zzyc());
        }

        public Builder(Context context)
        {
            zzWB = -1;
            zzWC = -1;
            zzWH = new com.google.android.gms.internal.zzpt.zza();
            mContext = context;
            zzWt = context.getMainLooper();
            zzOe = context.getPackageName();
            zzOd = context.getClass().getName();
            zzWE = zzpq.zzNY;
        }
    }

    public static interface ConnectionCallbacks
    {

        public abstract void onConnected(Bundle bundle);

        public abstract void onConnectionSuspended(int i);
    }

    public static interface ConnectionProgressReportCallbacks
    {

        public abstract void onReportAccountValidation(ConnectionResult connectionresult);

        public abstract void onReportServiceBinding(ConnectionResult connectionresult);
    }

    public static interface OnConnectionFailedListener
    {

        public abstract void onConnectionFailed(ConnectionResult connectionresult);
    }

    public static interface ServerAuthCodeCallbacks
    {

        public abstract CheckResult onCheckServerAuthorization(String s, Set set);

        public abstract boolean onUploadServerAuthCode(String s, String s1);
    }

    public static class ServerAuthCodeCallbacks.CheckResult
    {

        private boolean zzWI;
        private Set zzWJ;

        public static ServerAuthCodeCallbacks.CheckResult newAuthNotRequiredResult()
        {
            return new ServerAuthCodeCallbacks.CheckResult(false, null);
        }

        public static ServerAuthCodeCallbacks.CheckResult newAuthRequiredResult(Set set)
        {
            boolean flag;
            if (set != null && !set.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzu.zzb(flag, "A non-empty scope set is required if further auth is needed.");
            return new ServerAuthCodeCallbacks.CheckResult(true, set);
        }

        public boolean zzmA()
        {
            return zzWI;
        }

        public Set zzmB()
        {
            return zzWJ;
        }

        private ServerAuthCodeCallbacks.CheckResult(boolean flag, Set set)
        {
            zzWI = flag;
            zzWJ = set;
        }
    }


    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract Context getContext();

    public abstract Looper getLooper();

    public abstract boolean hasConnectedApi(Api api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract Api.Client zza(Api.ClientKey clientkey);

    public abstract zza.zza zza(zza.zza zza1);

    public abstract boolean zza(Api api);

    public abstract zza.zza zzb(zza.zza zza1);
}
