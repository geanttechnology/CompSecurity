// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpc

public final class zzpd
    implements Connections
{
    private static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(zzpd.zzQf, googleapiclient);
        }
    }

    private static abstract class zzb extends zza
    {

        public com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult zzaV(Status status)
        {
            return new com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult(this, status) {

                final Status zzQs;
                final zzb zzaJH;

                public String getLocalEndpointName()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzaJH = zzb1;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaV(status);
        }

        private zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class zzc extends zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        private zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public static final com.google.android.gms.common.api.Api.zzc zzQf = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zza zzQg = new com.google.android.gms.common.api.Api.zza() {

        public com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzo(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzpc zzo(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzpc(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
        }

    };

    public zzpd()
    {
    }

    public static zzpc zzd(GoogleApiClient googleapiclient, boolean flag)
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
        return zze(googleapiclient, flag);
    }

    public static zzpc zze(GoogleApiClient googleapiclient, boolean flag)
    {
        zzx.zza(googleapiclient.zza(Nearby.CONNECTIONS_API), "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean flag1 = googleapiclient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (flag && !flag1)
        {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
        if (flag1)
        {
            return (zzpc)googleapiclient.zza(zzQf);
        } else
        {
            return null;
        }
    }

    public PendingResult acceptConnectionRequest(GoogleApiClient googleapiclient, String s, byte abyte0[], com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, s, abyte0, googleapiclient.zzp(messagelistener)) {

            final zzpd zzaJD;
            final zzl zzaJG;
            final String zzaJl;
            final byte zzavP[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzpc)zzb1);
            }

            protected void zza(zzpc zzpc1)
                throws RemoteException
            {
                zzpc1.zza(this, zzaJl, zzavP, zzaJG);
            }

            
            {
                zzaJD = zzpd.this;
                zzaJl = s;
                zzavP = abyte0;
                zzaJG = zzl;
                super(googleapiclient);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient googleapiclient, String s)
    {
        zzd(googleapiclient, false).zzed(s);
    }

    public String getLocalDeviceId(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient, true).zzyl();
    }

    public String getLocalEndpointId(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient, true).zzyk();
    }

    public PendingResult rejectConnectionRequest(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, s) {

            final zzpd zzaJD;
            final String zzaJl;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzpc)zzb1);
            }

            protected void zza(zzpc zzpc1)
                throws RemoteException
            {
                zzpc1.zzp(this, zzaJl);
            }

            
            {
                zzaJD = zzpd.this;
                zzaJl = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult sendConnectionRequest(final GoogleApiClient final_googleapiclient, String s, String s1, byte abyte0[], com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback connectionresponsecallback, com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
    {
        return final_googleapiclient.zzb(new zzc(s, s1, abyte0, final_googleapiclient.zzp(connectionresponsecallback), final_googleapiclient.zzp(messagelistener)) {

            final String val$name;
            final zzpd zzaJD;
            final zzl zzaJF;
            final zzl zzaJG;
            final String zzaJl;
            final byte zzavP[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzpc)zzb1);
            }

            protected void zza(zzpc zzpc1)
                throws RemoteException
            {
                zzpc1.zza(this, name, zzaJl, zzavP, zzaJF, zzaJG);
            }

            
            {
                zzaJD = zzpd.this;
                name = s;
                zzaJl = s1;
                zzavP = abyte0;
                zzaJF = zzl;
                zzaJG = zzl1;
                super(final_googleapiclient);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient googleapiclient, String s, byte abyte0[])
    {
        zzd(googleapiclient, false).zza(new String[] {
            s
        }, abyte0);
    }

    public void sendReliableMessage(GoogleApiClient googleapiclient, List list, byte abyte0[])
    {
        zzd(googleapiclient, false).zza((String[])list.toArray(new String[list.size()]), abyte0);
    }

    public void sendUnreliableMessage(GoogleApiClient googleapiclient, String s, byte abyte0[])
    {
        zzd(googleapiclient, false).zzb(new String[] {
            s
        }, abyte0);
    }

    public void sendUnreliableMessage(GoogleApiClient googleapiclient, List list, byte abyte0[])
    {
        zzd(googleapiclient, false).zzb((String[])list.toArray(new String[list.size()]), abyte0);
    }

    public PendingResult startAdvertising(final GoogleApiClient final_googleapiclient, String s, AppMetadata appmetadata, long l, com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener connectionrequestlistener)
    {
        return final_googleapiclient.zzb(new zzb(s, appmetadata, l, final_googleapiclient.zzp(connectionrequestlistener)) {

            final String val$name;
            final AppMetadata zzaJA;
            final long zzaJB;
            final zzl zzaJC;
            final zzpd zzaJD;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzpc)zzb1);
            }

            protected void zza(zzpc zzpc1)
                throws RemoteException
            {
                zzpc1.zza(this, name, zzaJA, zzaJB, zzaJC);
            }

            
            {
                zzaJD = zzpd.this;
                name = s;
                zzaJA = appmetadata;
                zzaJB = l;
                zzaJC = zzl;
                super(final_googleapiclient);
            }
        });
    }

    public PendingResult startDiscovery(GoogleApiClient googleapiclient, String s, long l, com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener endpointdiscoverylistener)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, s, l, googleapiclient.zzp(endpointdiscoverylistener)) {

            final long zzaJB;
            final zzpd zzaJD;
            final zzl zzaJE;
            final String zzaJy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzpc)zzb1);
            }

            protected void zza(zzpc zzpc1)
                throws RemoteException
            {
                zzpc1.zza(this, zzaJy, zzaJB, zzaJE);
            }

            
            {
                zzaJD = zzpd.this;
                zzaJy = s;
                zzaJB = l;
                zzaJE = zzl;
                super(googleapiclient);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient googleapiclient)
    {
        zzd(googleapiclient, false).zzym();
    }

    public void stopAllEndpoints(GoogleApiClient googleapiclient)
    {
        zzd(googleapiclient, false).zzyn();
    }

    public void stopDiscovery(GoogleApiClient googleapiclient, String s)
    {
        zzd(googleapiclient, false).zzec(s);
    }

}
