// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjn;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateBuffer

public final class AppStateManager
{
    public static interface StateConflictResult
        extends Releasable, Result
    {

        public abstract byte[] getLocalData();

        public abstract String getResolvedVersion();

        public abstract byte[] getServerData();

        public abstract int getStateKey();
    }

    public static interface StateDeletedResult
        extends Result
    {

        public abstract int getStateKey();
    }

    public static interface StateListResult
        extends Result
    {

        public abstract AppStateBuffer getStateBuffer();
    }

    public static interface StateLoadedResult
        extends Releasable, Result
    {

        public abstract byte[] getLocalData();

        public abstract int getStateKey();
    }

    public static interface StateResult
        extends Releasable, Result
    {

        public abstract StateConflictResult getConflictResult();

        public abstract StateLoadedResult getLoadedResult();
    }

    public static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(AppStateManager.zzQf, googleapiclient);
        }
    }

    private static abstract class zzb extends zza
    {

        zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static abstract class zzc extends zza
    {

        public Result zzb(Status status)
        {
            return zzi(status);
        }

        public StateListResult zzi(Status status)
        {
            return new StateListResult(this, status) {

                final Status zzQs;
                final zzc zzQy;

                public AppStateBuffer getStateBuffer()
                {
                    return new AppStateBuffer(null);
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzQy = zzc1;
                zzQs = status;
                super();
            }
            };
        }

        public zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static abstract class zzd extends zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        public zzd(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static abstract class zze extends zza
    {

        public Result zzb(Status status)
        {
            return zzj(status);
        }

        public StateResult zzj(Status status)
        {
            return AppStateManager.zzg(status);
        }

        public zze(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public static final Api API;
    public static final Scope SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");
    static final com.google.android.gms.common.api.Api.zzc zzQf;
    private static final com.google.android.gms.common.api.Api.zza zzQg;

    private AppStateManager()
    {
    }

    public static PendingResult delete(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i) {

            final int zzQt;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzjn)zzb1);
            }

            protected void zza(zzjn zzjn1)
                throws RemoteException
            {
                zzjn1.zza(this, zzQt);
            }

            public Result zzb(Status status)
            {
                return zzh(status);
            }

            public StateDeletedResult zzh(Status status)
            {
                return new StateDeletedResult(this, status) {

                    final Status zzQs;
                    final _cls5 zzQv;

                    public int getStateKey()
                    {
                        return zzQv.zzQt;
                    }

                    public Status getStatus()
                    {
                        return zzQs;
                    }

            
            {
                zzQv = _pcls5;
                zzQs = status;
                super();
            }
                };
            }

            
            {
                zzQt = i;
                super(googleapiclient);
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleapiclient)
    {
        return zza(googleapiclient).zzlo();
    }

    public static int getMaxStateSize(GoogleApiClient googleapiclient)
    {
        return zza(googleapiclient).zzln();
    }

    public static PendingResult list(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzc(googleapiclient) {

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzjn)zzb1);
            }

            protected void zza(zzjn zzjn1)
                throws RemoteException
            {
                zzjn1.zza(this);
            }

        });
    }

    public static PendingResult load(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new zze(googleapiclient, i) {

            final int zzQt;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzjn)zzb1);
            }

            protected void zza(zzjn zzjn1)
                throws RemoteException
            {
                zzjn1.zzb(this, zzQt);
            }

            
            {
                zzQt = i;
                super(googleapiclient);
            }
        });
    }

    public static PendingResult resolve(GoogleApiClient googleapiclient, int i, String s, byte abyte0[])
    {
        return googleapiclient.zzb(new zze(googleapiclient, i, s, abyte0) {

            final int zzQt;
            final String zzQw;
            final byte zzQx[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzjn)zzb1);
            }

            protected void zza(zzjn zzjn1)
                throws RemoteException
            {
                zzjn1.zza(this, zzQt, zzQw, zzQx);
            }

            
            {
                zzQt = i;
                zzQw = s;
                zzQx = abyte0;
                super(googleapiclient);
            }
        });
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzd(googleapiclient) {

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzjn)zzb1);
            }

            protected void zza(zzjn zzjn1)
                throws RemoteException
            {
                zzjn1.zzb(this);
            }

        });
    }

    public static void update(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        googleapiclient.zzb(new zze(googleapiclient, i, abyte0) {

            final int zzQt;
            final byte zzQu[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzjn)zzb1);
            }

            protected void zza(zzjn zzjn1)
                throws RemoteException
            {
                zzjn1.zza(null, zzQt, zzQu);
            }

            
            {
                zzQt = i;
                zzQu = abyte0;
                super(googleapiclient);
            }
        });
    }

    public static PendingResult updateImmediate(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        return googleapiclient.zzb(new zze(googleapiclient, i, abyte0) {

            final int zzQt;
            final byte zzQu[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzjn)zzb1);
            }

            protected void zza(zzjn zzjn1)
                throws RemoteException
            {
                zzjn1.zza(this, zzQt, zzQu);
            }

            
            {
                zzQt = i;
                zzQu = abyte0;
                super(googleapiclient);
            }
        });
    }

    public static zzjn zza(GoogleApiClient googleapiclient)
    {
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "GoogleApiClient parameter is required.");
        zzx.zza(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        zzx.zza(googleapiclient.zza(API), "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjn)googleapiclient.zza(zzQf);
    }

    private static StateResult zzf(Status status)
    {
        return new StateResult(status) {

            final Status zzQs;

            public StateConflictResult getConflictResult()
            {
                return null;
            }

            public StateLoadedResult getLoadedResult()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            public void release()
            {
            }

            
            {
                zzQs = status;
                super();
            }
        };
    }

    static StateResult zzg(Status status)
    {
        return zzf(status);
    }

    static 
    {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new com.google.android.gms.common.api.Api.zza() {

            public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zzc(context, looper, zzf1, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public List zza(com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions)
            {
                return Arrays.asList(new Scope[] {
                    AppStateManager.SCOPE_APP_STATE
                });
            }

            public zzjn zzc(Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzjn(context, looper, zzf1, connectioncallbacks, onconnectionfailedlistener);
            }

            public List zzl(Object obj)
            {
                return zza((com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj);
            }

        };
        API = new Api("AppStateManager.API", zzQg, zzQf);
    }
}
