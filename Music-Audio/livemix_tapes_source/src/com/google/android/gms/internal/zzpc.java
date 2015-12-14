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
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;

// Referenced classes of package com.google.android.gms.internal:
//            zzpf, zzpb

public final class zzpc extends zzj
{
    private static final class zza extends zzb
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzii(int i)
            throws RemoteException
        {
            zzQz.zzn(new Status(i));
        }

        public zza(com.google.android.gms.common.api.zzc.zzb zzb1, zzl zzl)
        {
            super(zzl);
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzv(zzb1);
        }
    }

    private static class zzb extends zzpb
    {

        private final zzl zzaJk;

        public void onDisconnected(String s)
            throws RemoteException
        {
            zzaJk.zza(new com.google.android.gms.common.api.zzl.zzb(this, s) {

                final String zzaJl;
                final zzb zzaJn;

                public void zza(com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
                {
                    messagelistener.onDisconnected(zzaJl);
                }

                public void zznh()
                {
                }

                public void zzo(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.MessageListener)obj);
                }

            
            {
                zzaJn = zzb1;
                zzaJl = s;
                super();
            }
            });
        }

        public void onMessageReceived(String s, byte abyte0[], boolean flag)
            throws RemoteException
        {
            zzaJk.zza(new com.google.android.gms.common.api.zzl.zzb(this, s, abyte0, flag) {

                final String zzaJl;
                final boolean zzaJm;
                final zzb zzaJn;
                final byte zzavP[];

                public void zza(com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
                {
                    messagelistener.onMessageReceived(zzaJl, zzavP, zzaJm);
                }

                public void zznh()
                {
                }

                public void zzo(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.MessageListener)obj);
                }

            
            {
                zzaJn = zzb1;
                zzaJl = s;
                zzavP = abyte0;
                zzaJm = flag;
                super();
            }
            });
        }

        zzb(zzl zzl1)
        {
            zzaJk = zzl1;
        }
    }

    private static class zzc extends zzpb
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaJo;

        public void zzij(int i)
            throws RemoteException
        {
            zzaJo.zzn(new Status(i));
        }

        zzc(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaJo = zzb1;
        }
    }

    private static final class zzd extends zzb
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;
        private final zzl zzaJp;

        public void zza(String s, int i, byte abyte0[])
            throws RemoteException
        {
            zzaJp.zza(new com.google.android.gms.common.api.zzl.zzb(this, s, i, abyte0) {

                final int zzXm;
                final String zzaJl;
                final zzd zzaJq;
                final byte zzavP[];

                public void zza(com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback connectionresponsecallback)
                {
                    connectionresponsecallback.onConnectionResponse(zzaJl, new Status(zzXm), zzavP);
                }

                public void zznh()
                {
                }

                public void zzo(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback)obj);
                }

            
            {
                zzaJq = zzd1;
                zzaJl = s;
                zzXm = i;
                zzavP = abyte0;
                super();
            }
            });
        }

        public void zzih(int i)
            throws RemoteException
        {
            zzQz.zzn(new Status(i));
        }

        public zzd(com.google.android.gms.common.api.zzc.zzb zzb1, zzl zzl1, zzl zzl2)
        {
            super(zzl2);
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzv(zzb1);
            zzaJp = (zzl)zzx.zzv(zzl1);
        }
    }

    private static final class zze extends zzpb
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;
        private final zzl zzaJr;

        public void onConnectionRequest(String s, String s1, String s2, byte abyte0[])
            throws RemoteException
        {
            zzaJr.zza(new com.google.android.gms.common.api.zzl.zzb(this, s, s1, s2, abyte0) {

                final String zzaJl;
                final String zzaJs;
                final String zzaJt;
                final zze zzaJu;
                final byte zzavP[];

                public void zza(com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener connectionrequestlistener)
                {
                    connectionrequestlistener.onConnectionRequest(zzaJl, zzaJs, zzaJt, zzavP);
                }

                public void zznh()
                {
                }

                public void zzo(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener)obj);
                }

            
            {
                zzaJu = zze1;
                zzaJl = s;
                zzaJs = s1;
                zzaJt = s2;
                zzavP = abyte0;
                super();
            }
            });
        }

        public void zzk(int i, String s)
            throws RemoteException
        {
            zzQz.zzn(new zzf(new Status(i), s));
        }

        zze(com.google.android.gms.common.api.zzc.zzb zzb1, zzl zzl1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzv(zzb1);
            zzaJr = (zzl)zzx.zzv(zzl1);
        }
    }

    private static final class zzf
        implements com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    {

        private final Status zzQA;
        private final String zzaJv;

        public String getLocalEndpointName()
        {
            return zzaJv;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        zzf(Status status, String s)
        {
            zzQA = status;
            zzaJv = s;
        }
    }

    private static final class zzg extends zzpb
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;
        private final zzl zzaJr;

        public void onEndpointFound(String s, String s1, String s2, String s3)
            throws RemoteException
        {
            zzaJr.zza(new com.google.android.gms.common.api.zzl.zzb(s, s1, s2, s3) {

                final String val$name;
                final String zzaJw;
                final String zzaJx;
                final String zzaJy;
                final zzg zzaJz;

                public void zza(com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener endpointdiscoverylistener)
                {
                    endpointdiscoverylistener.onEndpointFound(zzaJw, zzaJx, zzaJy, name);
                }

                public void zznh()
                {
                }

                public void zzo(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener)obj);
                }

            
            {
                zzaJz = final_zzg1;
                zzaJw = s;
                zzaJx = s1;
                zzaJy = s2;
                name = s3;
                super();
            }
            });
        }

        public void onEndpointLost(String s)
            throws RemoteException
        {
            zzaJr.zza(new com.google.android.gms.common.api.zzl.zzb(this, s) {

                final String zzaJw;
                final zzg zzaJz;

                public void zza(com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener endpointdiscoverylistener)
                {
                    endpointdiscoverylistener.onEndpointLost(zzaJw);
                }

                public void zznh()
                {
                }

                public void zzo(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener)obj);
                }

            
            {
                zzaJz = zzg1;
                zzaJw = s;
                super();
            }
            });
        }

        public void zzif(int i)
            throws RemoteException
        {
            zzQz.zzn(new Status(i));
        }

        zzg(com.google.android.gms.common.api.zzc.zzb zzb1, zzl zzl1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzv(zzb1);
            zzaJr = (zzl)zzx.zzv(zzl1);
        }
    }


    private final long zzasQ = (long)hashCode();

    public zzpc(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 54, zzf1, connectioncallbacks, onconnectionfailedlistener);
    }

    public void disconnect()
    {
        if (isConnected())
        {
            try
            {
                ((zzpf)zzoA()).zzE(zzasQ);
            }
            catch (RemoteException remoteexception)
            {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", remoteexception);
            }
        }
        super.disconnect();
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzde(ibinder);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, long l, zzl zzl)
        throws RemoteException
    {
        ((zzpf)zzoA()).zza(new zzg(zzb1, zzl), s, l, zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, AppMetadata appmetadata, long l, zzl zzl)
        throws RemoteException
    {
        ((zzpf)zzoA()).zza(new zze(zzb1, zzl), s, appmetadata, l, zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, byte abyte0[], zzl zzl, zzl zzl1)
        throws RemoteException
    {
        ((zzpf)zzoA()).zza(new zzd(zzb1, zzl, zzl1), s, s1, abyte0, zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, byte abyte0[], zzl zzl)
        throws RemoteException
    {
        ((zzpf)zzoA()).zza(new zza(zzb1, zzl), s, abyte0, zzasQ);
    }

    public void zza(String as[], byte abyte0[])
    {
        try
        {
            ((zzpf)zzoA()).zza(as, abyte0, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", as);
        }
    }

    public void zzb(String as[], byte abyte0[])
    {
        try
        {
            ((zzpf)zzoA()).zzb(as, abyte0, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", as);
        }
    }

    protected zzpf zzde(IBinder ibinder)
    {
        return zzpf.zza.zzdg(ibinder);
    }

    public void zzec(String s)
    {
        try
        {
            ((zzpf)zzoA()).zzf(s, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", s);
        }
    }

    public void zzed(String s)
    {
        try
        {
            ((zzpf)zzoA()).zzg(s, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", s);
        }
    }

    protected String zzfA()
    {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((zzpf)zzoA()).zza(new zzc(zzb1), s, zzasQ);
    }

    public String zzyk()
    {
        String s;
        try
        {
            s = ((zzpf)zzoA()).zzQ(zzasQ);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
        return s;
    }

    public String zzyl()
    {
        String s;
        try
        {
            s = ((zzpf)zzoA()).zzyl();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
        return s;
    }

    public void zzym()
    {
        try
        {
            ((zzpf)zzoA()).zzN(zzasQ);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", remoteexception);
        }
    }

    public void zzyn()
    {
        try
        {
            ((zzpf)zzoA()).zzP(zzasQ);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", remoteexception);
        }
    }
}
