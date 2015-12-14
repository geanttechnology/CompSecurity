// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.zzg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzal, DisconnectRequest, zzad, AddEventListenerRequest, 
//            zzbr, RemoveEventListenerRequest, CancelPendingActionsRequest

public class zzt extends zzj
{

    private final String zzQl;
    final com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks zzadB;
    private final Bundle zzaip;
    private final boolean zzaiq;
    private DriveId zzair;
    private DriveId zzais;
    final Map zzait = new HashMap();
    final Map zzaiu = new HashMap();
    final Map zzaiv = new HashMap();
    final Map zzaiw = new HashMap();

    public zzt(Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, Bundle bundle)
    {
        super(context, looper, 11, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzQl = zzf1.zzol();
        zzadB = connectioncallbacks;
        zzaip = bundle;
        looper = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
        looper.setPackage(context.getPackageName());
        context = context.getPackageManager().queryIntentServices(looper, 0);
        switch (context.size())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("AndroidManifest.xml can only define one service that handles the ").append(looper.getAction()).append(" action").toString());

        case 0: // '\0'
            zzaiq = false;
            return;

        case 1: // '\001'
            context = ((ResolveInfo)context.get(0)).serviceInfo;
            break;
        }
        if (!((ServiceInfo) (context)).exported)
        {
            throw new IllegalStateException((new StringBuilder()).append("Drive event service ").append(((ServiceInfo) (context)).name).append(" must be exported in AndroidManifest.xml").toString());
        } else
        {
            zzaiq = true;
            return;
        }
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid)
    {
        zzx.zzb(zzg.zza(i, driveid), "id");
        zzx.zza(isConnected(), "Client must be connected");
        return googleapiclient.zzb(new zzs.zza(googleapiclient, driveid, i) {

            final zzt zzaiB;
            final DriveId zzaix;
            final int zzaiy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new RemoveEventListenerRequest(zzaix, zzaiy), null, null, new zzbr(this));
            }

            
            {
                zzaiB = zzt.this;
                zzaix = driveid;
                zzaiy = i;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid, ChangesAvailableOptions changesavailableoptions)
    {
        zzx.zzb(zzg.zza(i, driveid), "id");
        zzx.zza(isConnected(), "Client must be connected");
        if (!zzaiq)
        {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        } else
        {
            return googleapiclient.zzb(new zzs.zza(googleapiclient, driveid, i, changesavailableoptions) {

                final zzt zzaiB;
                final DriveId zzaix;
                final int zzaiy;
                final ChangesAvailableOptions zzaiz;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzt)zzb1);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zzt1.zzqF().zza(new AddEventListenerRequest(zzaix, zzaiy, zzaiz), null, null, new zzbr(this));
                }

            
            {
                zzaiB = zzt.this;
                zzaix = driveid;
                zzaiy = i;
                zzaiz = changesavailableoptions;
                super(googleapiclient);
            }
            });
        }
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid, zzad zzad1)
    {
        return googleapiclient.zzb(new zzs.zza(googleapiclient, driveid, i, zzad1) {

            final zzad zzaiA;
            final zzt zzaiB;
            final DriveId zzaix;
            final int zzaiy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new RemoveEventListenerRequest(zzaix, zzaiy), zzaiA, null, new zzbr(this));
            }

            
            {
                zzaiB = zzt.this;
                zzaix = driveid;
                zzaiy = i;
                zzaiA = zzad1;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid, zzad zzad1, ChangesAvailableOptions changesavailableoptions)
    {
        return googleapiclient.zzb(new zzs.zza(googleapiclient, driveid, i, changesavailableoptions, zzad1) {

            final zzad zzaiA;
            final zzt zzaiB;
            final DriveId zzaix;
            final int zzaiy;
            final ChangesAvailableOptions zzaiz;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new AddEventListenerRequest(zzaix, zzaiy, zzaiz), zzaiA, null, new zzbr(this));
            }

            
            {
                zzaiB = zzt.this;
                zzaix = driveid;
                zzaiy = i;
                zzaiz = changesavailableoptions;
                zzaiA = zzad1;
                super(googleapiclient);
            }
        });
    }

    PendingResult cancelPendingActions(GoogleApiClient googleapiclient, List list)
    {
        boolean flag1 = true;
        boolean flag;
        if (list != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        if (!list.isEmpty())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzx.zza(isConnected(), "Client must be connected");
        return googleapiclient.zzb(new zzs.zza(googleapiclient, list) {

            final zzt zzaiB;
            final List zzaiC;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new CancelPendingActionsRequest(zzaiC), new zzbr(this));
            }

            
            {
                zzaiB = zzt.this;
                zzaiC = list;
                super(googleapiclient);
            }
        });
    }

    public void disconnect()
    {
        if (isConnected())
        {
            try
            {
                ((zzal)zzoA()).zza(new DisconnectRequest());
            }
            catch (RemoteException remoteexception) { }
        }
        super.disconnect();
        synchronized (zzait)
        {
            zzait.clear();
        }
        synchronized (zzaiu)
        {
            zzaiu.clear();
        }
        synchronized (zzaiv)
        {
            zzaiv.clear();
        }
        synchronized (zzaiw)
        {
            zzaiw.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        map;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        map;
        JVM INSTR monitorexit ;
        throw exception2;
        exception3;
        map;
        JVM INSTR monitorexit ;
        throw exception3;
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzaR(ibinder);
    }

    PendingResult zza(GoogleApiClient googleapiclient, DriveId driveid)
    {
        return zza(googleapiclient, 1, driveid, ((ChangesAvailableOptions) (null)));
    }

    PendingResult zza(GoogleApiClient googleapiclient, DriveId driveid, ChangeListener changelistener)
    {
        zzx.zzb(zzg.zza(1, driveid), "id");
        zzx.zzb(changelistener, "listener");
        zzx.zza(isConnected(), "Client must be connected");
        Map map = zzait;
        map;
        JVM INSTR monitorenter ;
        Object obj = (Map)zzait.get(driveid);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = new HashMap();
        zzait.put(driveid, obj);
        zzad zzad1 = (zzad)((Map) (obj)).get(changelistener);
        if (zzad1 != null) goto _L2; else goto _L1
_L1:
        zzad1 = new zzad(getLooper(), getContext(), 1, changelistener);
        ((Map) (obj)).put(changelistener, zzad1);
        changelistener = zzad1;
_L4:
        changelistener.zzcJ(1);
        googleapiclient = zza(googleapiclient, 1, driveid, ((zzad) (changelistener)), null);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
_L2:
        if (!zzad1.zzcK(1))
        {
            break MISSING_BLOCK_LABEL_180;
        }
        googleapiclient = new zzr.zzj(googleapiclient, Status.zzaaD);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        googleapiclient;
        map;
        JVM INSTR monitorexit ;
        throw googleapiclient;
        changelistener = zzad1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            zzair = (DriveId)bundle.getParcelable("com.google.android.gms.drive.root_id");
            zzais = (DriveId)bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.zza(i, ibinder, bundle, j);
    }

    protected zzal zzaR(IBinder ibinder)
    {
        return zzal.zza.zzaS(ibinder);
    }

    PendingResult zzb(GoogleApiClient googleapiclient, DriveId driveid)
    {
        return zza(googleapiclient, 1, driveid);
    }

    PendingResult zzb(GoogleApiClient googleapiclient, DriveId driveid, ChangeListener changelistener)
    {
        zzx.zzb(zzg.zza(1, driveid), "id");
        zzx.zza(isConnected(), "Client must be connected");
        zzx.zzb(changelistener, "listener");
        Map map = zzait;
        map;
        JVM INSTR monitorenter ;
        Map map1 = (Map)zzait.get(driveid);
        if (map1 != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        googleapiclient = new zzr.zzj(googleapiclient, Status.zzaaD);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        changelistener = (zzad)map1.remove(changelistener);
        if (changelistener != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        googleapiclient = new zzr.zzj(googleapiclient, Status.zzaaD);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        googleapiclient;
        map;
        JVM INSTR monitorexit ;
        throw googleapiclient;
        if (map1.isEmpty())
        {
            zzait.remove(driveid);
        }
        googleapiclient = zza(googleapiclient, 1, driveid, changelistener);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
    }

    protected String zzfA()
    {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    protected Bundle zzli()
    {
        String s = getContext().getPackageName();
        zzx.zzv(s);
        Bundle bundle;
        boolean flag;
        if (!zzoy().zzoj().isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzY(flag);
        bundle = new Bundle();
        if (!s.equals(zzQl))
        {
            bundle.putString("proxy_package_name", zzQl);
        }
        bundle.putAll(zzaip);
        return bundle;
    }

    public boolean zzlm()
    {
        return !getContext().getPackageName().equals(zzQl) || !zzqE();
    }

    public boolean zzoC()
    {
        return true;
    }

    boolean zzqE()
    {
        return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
    }

    public zzal zzqF()
        throws DeadObjectException
    {
        return (zzal)zzoA();
    }

    public DriveId zzqG()
    {
        return zzair;
    }

    public DriveId zzqH()
    {
        return zzais;
    }

    public boolean zzqI()
    {
        return zzaiq;
    }
}
