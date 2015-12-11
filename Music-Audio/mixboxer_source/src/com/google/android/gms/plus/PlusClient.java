// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.hv;
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

        private final hv DA;
        private final com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks Dz;
        private final com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener jE;
        private final Context mContext;

        public PlusClient build()
        {
            return new PlusClient(new hs(mContext, Dz, jE, DA.eZ()));
        }

        public Builder clearScopes()
        {
            DA.eY();
            return this;
        }

        public Builder setAccountName(String s)
        {
            DA.aA(s);
            return this;
        }

        public transient Builder setActions(String as[])
        {
            DA.e(as);
            return this;
        }

        public transient Builder setScopes(String as[])
        {
            DA.d(as);
            return this;
        }

        public Builder(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            mContext = context;
            Dz = connectioncallbacks;
            jE = onconnectionfailedlistener;
            DA = new hv(mContext);
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


    final hs Du;

    PlusClient(hs hs1)
    {
        Du = hs1;
    }

    public void clearDefaultAccount()
    {
        Du.clearDefaultAccount();
    }

    public void connect()
    {
        Du.connect();
    }

    public void disconnect()
    {
        Du.disconnect();
    }

    hs eK()
    {
        return Du;
    }

    public String getAccountName()
    {
        return Du.getAccountName();
    }

    public Person getCurrentPerson()
    {
        return Du.getCurrentPerson();
    }

    public boolean isConnected()
    {
        return Du.isConnected();
    }

    public boolean isConnecting()
    {
        return Du.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return Du.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return Du.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void loadMoments(OnMomentsLoadedListener onmomentsloadedlistener)
    {
        Du.j(new com.google.android.gms.common.api.a.c(onmomentsloadedlistener) {

            final OnMomentsLoadedListener Dv;
            final PlusClient Dw;

            public void a(Moments.LoadMomentsResult loadmomentsresult)
            {
                Dv.onMomentsLoaded(loadmomentsresult.getStatus().bu(), loadmomentsresult.getMomentBuffer(), loadmomentsresult.getNextPageToken(), loadmomentsresult.getUpdated());
            }

            public volatile void a(Object obj)
            {
                a((Moments.LoadMomentsResult)obj);
            }

            
            {
                Dw = PlusClient.this;
                Dv = onmomentsloadedlistener;
                super();
            }
        });
    }

    public void loadMoments(OnMomentsLoadedListener onmomentsloadedlistener, int i, String s, Uri uri, String s1, String s2)
    {
        Du.a(new com.google.android.gms.common.api.a.c(onmomentsloadedlistener) {

            final OnMomentsLoadedListener Dv;
            final PlusClient Dw;

            public void a(Moments.LoadMomentsResult loadmomentsresult)
            {
                Dv.onMomentsLoaded(loadmomentsresult.getStatus().bu(), loadmomentsresult.getMomentBuffer(), loadmomentsresult.getNextPageToken(), loadmomentsresult.getUpdated());
            }

            public volatile void a(Object obj)
            {
                a((Moments.LoadMomentsResult)obj);
            }

            
            {
                Dw = PlusClient.this;
                Dv = onmomentsloadedlistener;
                super();
            }
        }, i, s, uri, s1, s2);
    }

    public void loadPeople(OnPeopleLoadedListener onpeopleloadedlistener, Collection collection)
    {
        Du.a(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient Dw;
            final OnPeopleLoadedListener Dx;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                Dx.onPeopleLoaded(loadpeopleresult.getStatus().bu(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public volatile void a(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                Dw = PlusClient.this;
                Dx = onpeopleloadedlistener;
                super();
            }
        }, collection);
    }

    public transient void loadPeople(OnPeopleLoadedListener onpeopleloadedlistener, String as[])
    {
        Du.a(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient Dw;
            final OnPeopleLoadedListener Dx;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                Dx.onPeopleLoaded(loadpeopleresult.getStatus().bu(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public volatile void a(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                Dw = PlusClient.this;
                Dx = onpeopleloadedlistener;
                super();
            }
        }, as);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onpeopleloadedlistener, int i, String s)
    {
        Du.a(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient Dw;
            final OnPeopleLoadedListener Dx;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                Dx.onPeopleLoaded(loadpeopleresult.getStatus().bu(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public volatile void a(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                Dw = PlusClient.this;
                Dx = onpeopleloadedlistener;
                super();
            }
        }, i, s);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onpeopleloadedlistener, String s)
    {
        Du.i(new com.google.android.gms.common.api.a.c(onpeopleloadedlistener) {

            final PlusClient Dw;
            final OnPeopleLoadedListener Dx;

            public void a(People.LoadPeopleResult loadpeopleresult)
            {
                Dx.onPeopleLoaded(loadpeopleresult.getStatus().bu(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
            }

            public volatile void a(Object obj)
            {
                a((People.LoadPeopleResult)obj);
            }

            
            {
                Dw = PlusClient.this;
                Dx = onpeopleloadedlistener;
                super();
            }
        }, s);
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        Du.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Du.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void removeMoment(String s)
    {
        Du.removeMoment(s);
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener onaccessrevokedlistener)
    {
        Du.l(new com.google.android.gms.common.api.a.c(onaccessrevokedlistener) {

            final PlusClient Dw;
            final OnAccessRevokedListener Dy;

            public void a(Status status)
            {
                Dy.onAccessRevoked(status.getStatus().bu());
            }

            public volatile void a(Object obj)
            {
                a((Status)obj);
            }

            
            {
                Dw = PlusClient.this;
                Dy = onaccessrevokedlistener;
                super();
            }
        });
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        Du.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Du.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    public void writeMoment(Moment moment)
    {
        Du.writeMoment(moment);
    }
}
