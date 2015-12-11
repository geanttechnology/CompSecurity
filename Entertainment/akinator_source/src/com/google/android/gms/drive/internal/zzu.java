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
//            zzam, DisconnectRequest, zzae, AddEventListenerRequest, 
//            zzbt, RemoveEventListenerRequest, CancelPendingActionsRequest

public class zzu extends zzj
{

    private final String zzRq;
    final com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks zzafE;
    private final Bundle zzakC;
    private final boolean zzakD;
    private volatile DriveId zzakE;
    private volatile DriveId zzakF;
    private volatile boolean zzakG;
    final Map zzakH = new HashMap();
    final Map zzakI = new HashMap();
    final Map zzakJ = new HashMap();
    final Map zzakK = new HashMap();

    public zzu(Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, Bundle bundle)
    {
        super(context, looper, 11, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzakG = false;
        zzRq = zzf1.zzoN();
        zzafE = connectioncallbacks;
        zzakC = bundle;
        looper = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
        looper.setPackage(context.getPackageName());
        context = context.getPackageManager().queryIntentServices(looper, 0);
        switch (context.size())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("AndroidManifest.xml can only define one service that handles the ").append(looper.getAction()).append(" action").toString());

        case 0: // '\0'
            zzakD = false;
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
            zzakD = true;
            return;
        }
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid)
    {
        zzx.zzb(zzg.zza(i, driveid), "id");
        zzx.zza(isConnected(), "Client must be connected");
        return googleapiclient.zzb(new zzt.zza(googleapiclient, driveid, i) {

            final DriveId zzakL;
            final int zzakM;
            final zzu zzakP;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new RemoveEventListenerRequest(zzakL, zzakM), null, null, new zzbt(this));
            }

            
            {
                zzakP = zzu.this;
                zzakL = driveid;
                zzakM = i;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid, ChangesAvailableOptions changesavailableoptions)
    {
        zzx.zzb(zzg.zza(i, driveid), "id");
        zzx.zza(isConnected(), "Client must be connected");
        if (!zzakD)
        {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        } else
        {
            return googleapiclient.zzb(new zzt.zza(googleapiclient, driveid, i, changesavailableoptions) {

                final DriveId zzakL;
                final int zzakM;
                final ChangesAvailableOptions zzakN;
                final zzu zzakP;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzu)zzb1);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzu1.zzrm().zza(new AddEventListenerRequest(zzakL, zzakM, zzakN), null, null, new zzbt(this));
                }

            
            {
                zzakP = zzu.this;
                zzakL = driveid;
                zzakM = i;
                zzakN = changesavailableoptions;
                super(googleapiclient);
            }
            });
        }
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid, zzae zzae1)
    {
        return googleapiclient.zzb(new zzt.zza(googleapiclient, driveid, i, zzae1) {

            final DriveId zzakL;
            final int zzakM;
            final zzae zzakO;
            final zzu zzakP;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new RemoveEventListenerRequest(zzakL, zzakM), zzakO, null, new zzbt(this));
            }

            
            {
                zzakP = zzu.this;
                zzakL = driveid;
                zzakM = i;
                zzakO = zzae1;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, int i, DriveId driveid, zzae zzae1, ChangesAvailableOptions changesavailableoptions)
    {
        return googleapiclient.zzb(new zzt.zza(googleapiclient, driveid, i, changesavailableoptions, zzae1) {

            final DriveId zzakL;
            final int zzakM;
            final ChangesAvailableOptions zzakN;
            final zzae zzakO;
            final zzu zzakP;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new AddEventListenerRequest(zzakL, zzakM, zzakN), zzakO, null, new zzbt(this));
            }

            
            {
                zzakP = zzu.this;
                zzakL = driveid;
                zzakM = i;
                zzakN = changesavailableoptions;
                zzakO = zzae1;
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
        zzx.zzaa(flag);
        if (!list.isEmpty())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzx.zza(isConnected(), "Client must be connected");
        return googleapiclient.zzb(new zzt.zza(googleapiclient, list) {

            final zzu zzakP;
            final List zzakQ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new CancelPendingActionsRequest(zzakQ), new zzbt(this));
            }

            
            {
                zzakP = zzu.this;
                zzakQ = list;
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
                ((zzam)zzpc()).zza(new DisconnectRequest());
            }
            catch (RemoteException remoteexception) { }
        }
        super.disconnect();
        synchronized (zzakH)
        {
            zzakH.clear();
        }
        synchronized (zzakI)
        {
            zzakI.clear();
        }
        synchronized (zzakJ)
        {
            zzakJ.clear();
        }
        synchronized (zzakK)
        {
            zzakK.clear();
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

    protected IInterface zzW(IBinder ibinder)
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
        Map map = zzakH;
        map;
        JVM INSTR monitorenter ;
        Object obj = (Map)zzakH.get(driveid);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = new HashMap();
        zzakH.put(driveid, obj);
        zzae zzae1 = (zzae)((Map) (obj)).get(changelistener);
        if (zzae1 != null) goto _L2; else goto _L1
_L1:
        zzae1 = new zzae(getLooper(), getContext(), 1, changelistener);
        ((Map) (obj)).put(changelistener, zzae1);
        changelistener = zzae1;
_L4:
        changelistener.zzcP(1);
        googleapiclient = zza(googleapiclient, 1, driveid, ((zzae) (changelistener)), null);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
_L2:
        if (!zzae1.zzcQ(1))
        {
            break MISSING_BLOCK_LABEL_180;
        }
        googleapiclient = new zzs.zzj(googleapiclient, Status.zzabb);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        googleapiclient;
        map;
        JVM INSTR monitorexit ;
        throw googleapiclient;
        changelistener = zzae1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            zzakE = (DriveId)bundle.getParcelable("com.google.android.gms.drive.root_id");
            zzakF = (DriveId)bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            zzakG = true;
        }
        super.zza(i, ibinder, bundle, j);
    }

    protected zzam zzaR(IBinder ibinder)
    {
        return zzam.zza.zzaS(ibinder);
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
        Map map = zzakH;
        map;
        JVM INSTR monitorenter ;
        Map map1 = (Map)zzakH.get(driveid);
        if (map1 != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        googleapiclient = new zzs.zzj(googleapiclient, Status.zzabb);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        changelistener = (zzae)map1.remove(changelistener);
        if (changelistener != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        googleapiclient = new zzs.zzj(googleapiclient, Status.zzabb);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        googleapiclient;
        map;
        JVM INSTR monitorexit ;
        throw googleapiclient;
        if (map1.isEmpty())
        {
            zzakH.remove(driveid);
        }
        googleapiclient = zza(googleapiclient, 1, driveid, changelistener);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
    }

    protected String zzfK()
    {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public boolean zzlN()
    {
        return !getContext().getPackageName().equals(zzRq) || !zzrl();
    }

    protected Bundle zzly()
    {
        String s = getContext().getPackageName();
        zzx.zzw(s);
        Bundle bundle;
        boolean flag;
        if (!zzpa().zzoL().isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        bundle = new Bundle();
        if (!s.equals(zzRq))
        {
            bundle.putString("proxy_package_name", zzRq);
        }
        bundle.putAll(zzakC);
        return bundle;
    }

    public boolean zzpe()
    {
        return true;
    }

    boolean zzrl()
    {
        return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
    }

    public zzam zzrm()
        throws DeadObjectException
    {
        return (zzam)zzpc();
    }

    public DriveId zzrn()
    {
        return zzakE;
    }

    public DriveId zzro()
    {
        return zzakF;
    }

    public boolean zzrp()
    {
        return zzakG;
    }

    public boolean zzrq()
    {
        return zzakD;
    }
}
