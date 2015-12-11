// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.i;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public class PlusClient
    implements GooglePlayServicesClient
{
    public static class Builder
    {

        private final com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks QS;
        private final com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener QT;
        private final i QU;
        private final Context mContext;

        public PlusClient build()
        {
            return new PlusClient(new e(mContext, QS, QT, QU.hA()));
        }

        public Builder clearScopes()
        {
            QU.hz();
            return this;
        }

        public Builder setAccountName(String s)
        {
            QU.aS(s);
            return this;
        }

        public transient Builder setActions(String as[])
        {
            QU.f(as);
            return this;
        }

        public transient Builder setScopes(String as[])
        {
            QU.e(as);
            return this;
        }

        public Builder(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            mContext = context;
            QS = connectioncallbacks;
            QT = onconnectionfailedlistener;
            QU = new i(mContext);
        }
    }

    public static interface OnAccessRevokedListener
    {

        public abstract void onAccessRevoked(ConnectionResult connectionresult);
    }

    public static interface OnMomentsLoadedListener
    {

        public abstract void onMomentsLoaded(ConnectionResult connectionresult, MomentBuffer momentbuffer, String s, String s1);
    }

    public static interface OnPeopleLoadedListener
    {

        public abstract void onPeopleLoaded(ConnectionResult connectionresult, PersonBuffer personbuffer, String s);
    }

    public static interface OrderBy
    {

        public static final int ALPHABETICAL = 0;
        public static final int BEST = 1;
    }


    final e QN;

    PlusClient(e e1)
    {
        QN = e1;
    }

    public void clearDefaultAccount()
    {
        QN.clearDefaultAccount();
    }

    public void connect()
    {
        QN.connect();
    }

    public void disconnect()
    {
        QN.disconnect();
    }

    public String getAccountName()
    {
        return QN.getAccountName();
    }

    public Person getCurrentPerson()
    {
        return QN.getCurrentPerson();
    }

    e hj()
    {
        return QN;
    }

    public boolean isConnected()
    {
        return QN.isConnected();
    }

    public boolean isConnecting()
    {
        return QN.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return QN.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return QN.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void loadMoments(OnMomentsLoadedListener onmomentsloadedlistener)
    {
        QN.i(new com.google.android.gms.common.api.a.c(onmomentsloadedlistener) {

            final OnMomentsLoadedListener QO;
            final PlusClient QP;

            public void a(Moments.LoadMomentsResult loadmomentsresult)
            {
                QO.onMomentsLoaded(loadmomentsresult.getStatus().dG(), loadmomentsresult.getMomentBuffer(), loadmomentsresult.getNextPageToken(), loadmomentsresult.getUpdated());
            }

            public void b(Object obj)
            {
                a((Moments.LoadMomentsResult)obj);
            }

            
            {
                QP = PlusClient.this;
                QO = onmomentsloadedlistener;
                super();
            }
        });
    }

    public void loadMoments(OnMomentsLoadedListener onmomentsloadedlistener, int i, String s, Uri uri, String s1, String s2)
    {
        QN.a(new com.google.android.gms.common.api.a.c(onmomentsloadedlistener) {

            final OnMomentsLoadedListener QO;
            final PlusClient QP;

            public void a(Moments.LoadMomentsResult loadmomentsresult)
            {
                QO.onMomentsLoaded(loadmomentsresult.getStatus().dG(), loadmomentsresult.getMomentBuffer(), loadmomentsresult.getNextPageToken(), loadmomentsresult.getUpdated());
            }

            public void b(Object obj)
            {
                a((Moments.LoadMomentsResult)obj);
            }

            
            {
                QP = PlusClient.this;
                QO = onmomentsloadedlistener;
                super();
            }
        }, i, s, uri, s1, s2);
    }

    public void loadPeople(OnPeopleLoadedListener onpeopleloadedlistener, Collection collection)
    {
        QN.a(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient QP;
            final OnPeopleLoadedListener QQ;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                QQ.onPeopleLoaded(loadpeopleresult.getStatus().dG(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public void b(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                QP = PlusClient.this;
                QQ = onpeopleloadedlistener;
                super();
            }
        }, collection);
    }

    public transient void loadPeople(OnPeopleLoadedListener onpeopleloadedlistener, String as[])
    {
        QN.c(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient QP;
            final OnPeopleLoadedListener QQ;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                QQ.onPeopleLoaded(loadpeopleresult.getStatus().dG(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public void b(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                QP = PlusClient.this;
                QQ = onpeopleloadedlistener;
                super();
            }
        }, as);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onpeopleloadedlistener, int i, String s)
    {
        QN.a(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient QP;
            final OnPeopleLoadedListener QQ;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                QQ.onPeopleLoaded(loadpeopleresult.getStatus().dG(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public void b(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                QP = PlusClient.this;
                QQ = onpeopleloadedlistener;
                super();
            }
        }, i, s);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onpeopleloadedlistener, String s)
    {
        QN.i(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient QP;
            final OnPeopleLoadedListener QQ;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                QQ.onPeopleLoaded(loadpeopleresult.getStatus().dG(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public void b(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                QP = PlusClient.this;
                QQ = onpeopleloadedlistener;
                super();
            }
        }, s);
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        QN.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        QN.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void removeMoment(String s)
    {
        QN.removeMoment(s);
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener onaccessrevokedlistener)
    {
        QN.k(new com.google.android.gms.common.api.a.c(onaccessrevokedlistener) {

            final PlusClient QP;
            final OnAccessRevokedListener QR;

            public void K(Status status)
            {
                QR.onAccessRevoked(status.getStatus().dG());
            }

            public void b(Object obj)
            {
                K((Status)obj);
            }

            
            {
                QP = PlusClient.this;
                QR = onaccessrevokedlistener;
                super();
            }
        });
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        QN.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        QN.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    public void writeMoment(Moment moment)
    {
        QN.a(null, moment);
    }
}
