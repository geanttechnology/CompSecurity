// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            zzmq, zznt, zznb

public class zzns
    implements SessionsApi
{
    private static class zza extends zznf.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(SessionReadResult sessionreadresult)
            throws RemoteException
        {
            zzQz.zzn(sessionreadresult);
        }

        private zza(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }

    }

    private static class zzb extends zzng.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(SessionStopResult sessionstopresult)
        {
            zzQz.zzn(sessionstopresult);
        }

        private zzb(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }

    }


    public zzns()
    {
    }

    private PendingResult zza(final GoogleApiClient final_googleapiclient, String s, String s1)
    {
        return final_googleapiclient.zzb(new zzmq.zza(s, s1) {

            final String val$name;
            final zzns zzapt;
            final String zzapu;

            protected SessionStopResult zzN(Status status)
            {
                return SessionStopResult.zzV(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmq)zzb1);
            }

            protected void zza(zzmq zzmq1)
                throws RemoteException
            {
                zzb zzb1 = new zzb(this);
                String s2 = zzmq1.getContext().getPackageName();
                ((zznb)zzmq1.zzoA()).zza(new SessionStopRequest(name, zzapu, zzb1, s2));
            }

            protected Result zzb(Status status)
            {
                return zzN(status);
            }

            
            {
                zzapt = zzns.this;
                name = s;
                zzapu = s1;
                super(final_googleapiclient);
            }
        });
    }

    public PendingResult insertSession(GoogleApiClient googleapiclient, SessionInsertRequest sessioninsertrequest)
    {
        return googleapiclient.zza(new zzmq.zzc(googleapiclient, sessioninsertrequest) {

            final zzns zzapt;
            final SessionInsertRequest zzapv;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmq)zzb1);
            }

            protected void zza(zzmq zzmq1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmq1.getContext().getPackageName();
                ((zznb)zzmq1.zzoA()).zza(new SessionInsertRequest(zzapv, zznt1, s));
            }

            
            {
                zzapt = zzns.this;
                zzapv = sessioninsertrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readSession(GoogleApiClient googleapiclient, SessionReadRequest sessionreadrequest)
    {
        return googleapiclient.zza(new zzmq.zza(googleapiclient, sessionreadrequest) {

            final zzns zzapt;
            final SessionReadRequest zzapw;

            protected SessionReadResult zzO(Status status)
            {
                return SessionReadResult.zzU(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmq)zzb1);
            }

            protected void zza(zzmq zzmq1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzmq1.getContext().getPackageName();
                ((zznb)zzmq1.zzoA()).zza(new SessionReadRequest(zzapw, zza1, s));
            }

            protected Result zzb(Status status)
            {
                return zzO(status);
            }

            
            {
                zzapt = zzns.this;
                zzapw = sessionreadrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult registerForSessions(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return zza(googleapiclient, pendingintent, 0);
    }

    public PendingResult startSession(GoogleApiClient googleapiclient, Session session)
    {
        zzx.zzb(session, "Session cannot be null");
        boolean flag;
        if (session.getEndTime(TimeUnit.MILLISECONDS) == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Cannot start a session which has already ended");
        return googleapiclient.zzb(new zzmq.zzc(googleapiclient, session) {

            final Session zzaps;
            final zzns zzapt;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmq)zzb1);
            }

            protected void zza(zzmq zzmq1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmq1.getContext().getPackageName();
                ((zznb)zzmq1.zzoA()).zza(new SessionStartRequest(zzaps, zznt1, s));
            }

            
            {
                zzapt = zzns.this;
                zzaps = session;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopSession(GoogleApiClient googleapiclient, String s)
    {
        return zza(googleapiclient, ((String) (null)), s);
    }

    public PendingResult unregisterForSessions(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zzmq.zzc(googleapiclient, pendingintent) {

            final PendingIntent zzapm;
            final zzns zzapt;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmq)zzb1);
            }

            protected void zza(zzmq zzmq1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmq1.getContext().getPackageName();
                ((zznb)zzmq1.zzoA()).zza(new SessionUnregistrationRequest(zzapm, zznt1, s));
            }

            
            {
                zzapt = zzns.this;
                zzapm = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult zza(GoogleApiClient googleapiclient, PendingIntent pendingintent, int i)
    {
        return googleapiclient.zzb(new zzmq.zzc(googleapiclient, pendingintent, i) {

            final PendingIntent zzapm;
            final zzns zzapt;
            final int zzapx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzmq)zzb1);
            }

            protected void zza(zzmq zzmq1)
                throws RemoteException
            {
                zznt zznt1 = new zznt(this);
                String s = zzmq1.getContext().getPackageName();
                ((zznb)zzmq1.zzoA()).zza(new SessionRegistrationRequest(zzapm, zznt1, s, zzapx));
            }

            
            {
                zzapt = zzns.this;
                zzapm = pendingintent;
                zzapx = i;
                super(googleapiclient);
            }
        });
    }
}
