// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
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
//            zzns, zzou, zzod

public class zzot
    implements SessionsApi
{
    private static class zza extends zzoh.zza
    {

        private final zzlb.zzb zzagy;

        public void zza(SessionReadResult sessionreadresult)
            throws RemoteException
        {
            zzagy.zzp(sessionreadresult);
        }

        private zza(zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }

    }

    private static class zzb extends zzoi.zza
    {

        private final zzlb.zzb zzagy;

        public void zza(SessionStopResult sessionstopresult)
        {
            zzagy.zzp(sessionstopresult);
        }

        private zzb(zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }

    }


    public zzot()
    {
    }

    private PendingResult zza(final GoogleApiClient final_googleapiclient, String s, String s1)
    {
        return final_googleapiclient.zzb(new zzns.zza(s, s1) {

            final String val$name;
            final zzot zzarQ;
            final String zzarR;

            protected SessionStopResult zzN(Status status)
            {
                return SessionStopResult.zzU(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzns)zzb1);
            }

            protected void zza(zzns zzns1)
                throws RemoteException
            {
                zzb zzb1 = new zzb(this);
                ((zzod)zzns1.zzpc()).zza(new SessionStopRequest(name, zzarR, zzb1));
            }

            protected Result zzb(Status status)
            {
                return zzN(status);
            }

            
            {
                zzarQ = zzot.this;
                name = s;
                zzarR = s1;
                super(final_googleapiclient);
            }
        });
    }

    public PendingResult insertSession(GoogleApiClient googleapiclient, SessionInsertRequest sessioninsertrequest)
    {
        return googleapiclient.zza(new zzns.zzc(googleapiclient, sessioninsertrequest) {

            final zzot zzarQ;
            final SessionInsertRequest zzarS;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzns)zzb1);
            }

            protected void zza(zzns zzns1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzod)zzns1.zzpc()).zza(new SessionInsertRequest(zzarS, zzou1));
            }

            
            {
                zzarQ = zzot.this;
                zzarS = sessioninsertrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readSession(GoogleApiClient googleapiclient, SessionReadRequest sessionreadrequest)
    {
        return googleapiclient.zza(new zzns.zza(googleapiclient, sessionreadrequest) {

            final zzot zzarQ;
            final SessionReadRequest zzarT;

            protected SessionReadResult zzO(Status status)
            {
                return SessionReadResult.zzT(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzns)zzb1);
            }

            protected void zza(zzns zzns1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                ((zzod)zzns1.zzpc()).zza(new SessionReadRequest(zzarT, zza1));
            }

            protected Result zzb(Status status)
            {
                return zzO(status);
            }

            
            {
                zzarQ = zzot.this;
                zzarT = sessionreadrequest;
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
        return googleapiclient.zzb(new zzns.zzc(googleapiclient, session) {

            final Session zzarP;
            final zzot zzarQ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzns)zzb1);
            }

            protected void zza(zzns zzns1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzod)zzns1.zzpc()).zza(new SessionStartRequest(zzarP, zzou1));
            }

            
            {
                zzarQ = zzot.this;
                zzarP = session;
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
        return googleapiclient.zzb(new zzns.zzc(googleapiclient, pendingintent) {

            final PendingIntent zzarJ;
            final zzot zzarQ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzns)zzb1);
            }

            protected void zza(zzns zzns1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzod)zzns1.zzpc()).zza(new SessionUnregistrationRequest(zzarJ, zzou1));
            }

            
            {
                zzarQ = zzot.this;
                zzarJ = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult zza(GoogleApiClient googleapiclient, PendingIntent pendingintent, int i)
    {
        return googleapiclient.zzb(new zzns.zzc(googleapiclient, pendingintent, i) {

            final PendingIntent zzarJ;
            final zzot zzarQ;
            final int zzarU;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzns)zzb1);
            }

            protected void zza(zzns zzns1)
                throws RemoteException
            {
                zzou zzou1 = new zzou(this);
                ((zzod)zzns1.zzpc()).zza(new SessionRegistrationRequest(zzarJ, zzou1, zzarU));
            }

            
            {
                zzarQ = zzot.this;
                zzarJ = pendingintent;
                zzarU = i;
                super(googleapiclient);
            }
        });
    }
}
