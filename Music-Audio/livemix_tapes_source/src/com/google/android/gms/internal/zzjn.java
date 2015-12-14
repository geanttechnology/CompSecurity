// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzjp, zzjm

public final class zzjn extends zzj
{
    private static final class zza extends zzjm
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzg(int i, int j)
        {
            Status status = new Status(i);
            zzQz.zzn(new zzb(status, j));
        }

        public zza(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Result holder must not be null");
        }
    }

    private static final class zzb
        implements com.google.android.gms.appstate.AppStateManager.StateDeletedResult
    {

        private final Status zzQA;
        private final int zzQB;

        public int getStateKey()
        {
            return zzQB;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public zzb(Status status, int i)
        {
            zzQA = status;
            zzQB = i;
        }
    }

    private static final class zzc extends zzjm
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(DataHolder dataholder)
        {
            zzQz.zzn(new zzd(dataholder));
        }

        public zzc(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Result holder must not be null");
        }
    }

    private static final class zzd extends com.google.android.gms.common.api.zze
        implements com.google.android.gms.appstate.AppStateManager.StateListResult
    {

        private final AppStateBuffer zzQC;

        public AppStateBuffer getStateBuffer()
        {
            return zzQC;
        }

        public zzd(DataHolder dataholder)
        {
            super(dataholder);
            zzQC = new AppStateBuffer(dataholder);
        }
    }

    private static final class zze extends zzjm
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(int i, DataHolder dataholder)
        {
            zzQz.zzn(new zzf(i, dataholder));
        }

        public zze(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Result holder must not be null");
        }
    }

    private static final class zzf extends com.google.android.gms.common.api.zze
        implements com.google.android.gms.appstate.AppStateManager.StateConflictResult, com.google.android.gms.appstate.AppStateManager.StateLoadedResult, com.google.android.gms.appstate.AppStateManager.StateResult
    {

        private final int zzQB;
        private final AppStateBuffer zzQC;

        private boolean zzlp()
        {
            return zzQA.getStatusCode() == 2000;
        }

        public com.google.android.gms.appstate.AppStateManager.StateConflictResult getConflictResult()
        {
            if (zzlp())
            {
                return this;
            } else
            {
                return null;
            }
        }

        public com.google.android.gms.appstate.AppStateManager.StateLoadedResult getLoadedResult()
        {
            zzf zzf1 = this;
            if (zzlp())
            {
                zzf1 = null;
            }
            return zzf1;
        }

        public byte[] getLocalData()
        {
            if (zzQC.getCount() == 0)
            {
                return null;
            } else
            {
                return zzQC.get(0).getLocalData();
            }
        }

        public String getResolvedVersion()
        {
            if (zzQC.getCount() == 0)
            {
                return null;
            } else
            {
                return zzQC.get(0).getConflictVersion();
            }
        }

        public byte[] getServerData()
        {
            if (zzQC.getCount() == 0)
            {
                return null;
            } else
            {
                return zzQC.get(0).getConflictData();
            }
        }

        public int getStateKey()
        {
            return zzQB;
        }

        public void release()
        {
            zzQC.release();
        }

        public zzf(int i, DataHolder dataholder)
        {
            super(dataholder);
            zzQB = i;
            zzQC = new AppStateBuffer(dataholder);
        }
    }

    private static final class zzg extends zzjm
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzll()
        {
            Status status = new Status(0);
            zzQz.zzn(status);
        }

        public zzg(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }


    public zzjn(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 7, zzf1, connectioncallbacks, onconnectionfailedlistener);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzal(ibinder);
    }

    protected Set zza(Set set)
    {
        zzx.zza(set.contains(new Scope("https://www.googleapis.com/auth/appstate")), String.format("App State APIs requires %s to function.", new Object[] {
            "https://www.googleapis.com/auth/appstate"
        }));
        return set;
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1)
        throws RemoteException
    {
        ((zzjp)zzoA()).zza(new zzc(zzb1));
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i)
        throws RemoteException
    {
        ((zzjp)zzoA()).zzb(new zza(zzb1), i);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, String s, byte abyte0[])
        throws RemoteException
    {
        ((zzjp)zzoA()).zza(new zze(zzb1), i, s, abyte0);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, byte abyte0[])
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new zze(zzb1);
        }
        ((zzjp)zzoA()).zza(zzb1, i, abyte0);
    }

    protected zzjp zzal(IBinder ibinder)
    {
        return zzjp.zza.zzan(ibinder);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1)
        throws RemoteException
    {
        ((zzjp)zzoA()).zzb(new zzg(zzb1));
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, int i)
        throws RemoteException
    {
        ((zzjp)zzoA()).zza(new zze(zzb1), i);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public boolean zzlm()
    {
        return true;
    }

    public int zzln()
    {
        int i;
        try
        {
            i = ((zzjp)zzoA()).zzln();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    public int zzlo()
    {
        int i;
        try
        {
            i = ((zzjp)zzoA()).zzlo();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }
}
