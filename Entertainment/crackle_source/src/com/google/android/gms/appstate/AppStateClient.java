// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.appstate:
//            OnStateDeletedListener, OnStateListLoadedListener, OnStateLoadedListener, OnSignOutCompleteListener

public final class AppStateClient
    implements GooglePlayServicesClient
{
    public static final class Builder
    {

        private static final String jC[] = {
            "https://www.googleapis.com/auth/appstate"
        };
        private com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks jD;
        private com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener jE;
        private String jF[];
        private String jG;
        private Context mContext;

        public AppStateClient create()
        {
            return new AppStateClient(mContext, jD, jE, jG, jF);
        }

        public Builder setAccountName(String s)
        {
            jG = (String)eg.f(s);
            return this;
        }

        public transient Builder setScopes(String as[])
        {
            jF = as;
            return this;
        }


        public Builder(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            mContext = context;
            jD = connectioncallbacks;
            jE = onconnectionfailedlistener;
            jF = jC;
            jG = "<<default account>>";
        }
    }

    private static final class a
        implements com.google.android.gms.common.api.a.c
    {

        private final OnStateLoadedListener jH;

        public void a(AppStateManager.StateResult stateresult)
        {
            if (jH == null)
            {
                return;
            }
            if (stateresult.getStatus().getStatusCode() == 2000)
            {
                stateresult = stateresult.getConflictResult();
                ds.d(stateresult);
                jH.onStateConflict(stateresult.getStateKey(), stateresult.getResolvedVersion(), stateresult.getLocalData(), stateresult.getServerData());
                return;
            } else
            {
                stateresult = stateresult.getLoadedResult();
                ds.d(stateresult);
                jH.onStateLoaded(stateresult.getStatus().getStatusCode(), stateresult.getStateKey(), stateresult.getLocalData());
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((AppStateManager.StateResult)obj);
        }

        a(OnStateLoadedListener onstateloadedlistener)
        {
            jH = onstateloadedlistener;
        }
    }


    public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
    public static final int STATUS_DEVELOPER_ERROR = 7;
    public static final int STATUS_INTERNAL_ERROR = 1;
    public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
    public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
    public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
    public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
    public static final int STATUS_OK = 0;
    public static final int STATUS_STATE_KEY_LIMIT_EXCEEDED = 2003;
    public static final int STATUS_STATE_KEY_NOT_FOUND = 2002;
    public static final int STATUS_WRITE_OUT_OF_DATE_VERSION = 2000;
    public static final int STATUS_WRITE_SIZE_EXCEEDED = 2001;
    private final dc jx;

    private AppStateClient(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String s, String as[])
    {
        jx = new dc(context, connectioncallbacks, onconnectionfailedlistener, s, as);
    }


    public void connect()
    {
        jx.connect();
    }

    public void deleteState(OnStateDeletedListener onstatedeletedlistener, int i)
    {
        jx.a(new com.google.android.gms.common.api.a.c(onstatedeletedlistener) {

            final OnStateDeletedListener jy;
            final AppStateClient jz;

            public void a(AppStateManager.StateDeletedResult statedeletedresult)
            {
                jy.onStateDeleted(statedeletedresult.getStatus().getStatusCode(), statedeletedresult.getStateKey());
            }

            public volatile void a(Object obj)
            {
                a((AppStateManager.StateDeletedResult)obj);
            }

            
            {
                jz = AppStateClient.this;
                jy = onstatedeletedlistener;
                super();
            }
        }, i);
    }

    public void disconnect()
    {
        jx.disconnect();
    }

    public int getMaxNumKeys()
    {
        return jx.getMaxNumKeys();
    }

    public int getMaxStateSize()
    {
        return jx.getMaxStateSize();
    }

    public boolean isConnected()
    {
        return jx.isConnected();
    }

    public boolean isConnecting()
    {
        return jx.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return jx.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return jx.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void listStates(OnStateListLoadedListener onstatelistloadedlistener)
    {
        jx.a(new com.google.android.gms.common.api.a.c(onstatelistloadedlistener) {

            final OnStateListLoadedListener jA;
            final AppStateClient jz;

            public void a(AppStateManager.StateListResult statelistresult)
            {
                jA.onStateListLoaded(statelistresult.getStatus().getStatusCode(), statelistresult.getStateBuffer());
            }

            public volatile void a(Object obj)
            {
                a((AppStateManager.StateListResult)obj);
            }

            
            {
                jz = AppStateClient.this;
                jA = onstatelistloadedlistener;
                super();
            }
        });
    }

    public void loadState(OnStateLoadedListener onstateloadedlistener, int i)
    {
        jx.b(new a(onstateloadedlistener), i);
    }

    public void reconnect()
    {
        jx.disconnect();
        jx.connect();
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        jx.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        jx.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void resolveState(OnStateLoadedListener onstateloadedlistener, int i, String s, byte abyte0[])
    {
        jx.a(new a(onstateloadedlistener), i, s, abyte0);
    }

    public void signOut()
    {
        jx.b(new com.google.android.gms.common.api.a.c() {

            final AppStateClient jz;

            public void a(Status status)
            {
            }

            public volatile void a(Object obj)
            {
                a((Status)obj);
            }

            
            {
                jz = AppStateClient.this;
                super();
            }
        });
    }

    public void signOut(OnSignOutCompleteListener onsignoutcompletelistener)
    {
        eg.b(onsignoutcompletelistener, "Must provide a valid listener");
        jx.b(new com.google.android.gms.common.api.a.c(onsignoutcompletelistener) {

            final OnSignOutCompleteListener jB;
            final AppStateClient jz;

            public void a(Status status)
            {
                jB.onSignOutComplete();
            }

            public volatile void a(Object obj)
            {
                a((Status)obj);
            }

            
            {
                jz = AppStateClient.this;
                jB = onsignoutcompletelistener;
                super();
            }
        });
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        jx.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        jx.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    public void updateState(int i, byte abyte0[])
    {
        jx.a(new a(null), i, abyte0);
    }

    public void updateStateImmediate(OnStateLoadedListener onstateloadedlistener, int i, byte abyte0[])
    {
        eg.b(onstateloadedlistener, "Must provide a valid listener");
        jx.a(new a(onstateloadedlistener), i, abyte0);
    }
}
