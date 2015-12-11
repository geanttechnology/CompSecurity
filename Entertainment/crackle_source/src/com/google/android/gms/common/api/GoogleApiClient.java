// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.eg;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            Api, Releasable, Scope

public final class GoogleApiClient
{
    public static interface ApiOptions
    {
    }

    public static final class Builder
    {

        private String jG;
        private final Context mContext;
        private final Set ns;
        private int nt;
        private View nu;
        private String nv;
        private final Map nw;
        private final Set nx;
        private final Set ny;

        public Builder addApi(Api api)
        {
            return addApi(api, null);
        }

        public Builder addApi(Api api, ApiOptions apioptions)
        {
            nw.put(api, apioptions);
            api = api.bk();
            int k = api.size();
            for (int j = 0; j < k; j++)
            {
                ns.add(((Scope)api.get(j)).br());
            }

            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectioncallbacks)
        {
            nx.add(connectioncallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener)
        {
            ny.add(onconnectionfailedlistener);
            return this;
        }

        public Builder addScope(Scope scope)
        {
            ns.add(scope.br());
            return this;
        }

        public dt bq()
        {
            return new dt(jG, ns, nt, nu, nv);
        }

        public GoogleApiClient build()
        {
            return new GoogleApiClient(mContext, bq(), nw, nx, ny);
        }

        public Builder setAccountName(String s)
        {
            jG = s;
            return this;
        }

        public Builder setGravityForPopups(int j)
        {
            nt = j;
            return this;
        }

        public Builder setViewForPopups(View view)
        {
            nu = view;
            return this;
        }

        public Builder useDefaultAccount()
        {
            return setAccountName("<<default account>>");
        }

        public Builder(Context context)
        {
            ns = new HashSet();
            nw = new HashMap();
            nx = new HashSet();
            ny = new HashSet();
            mContext = context;
            nv = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectioncallbacks, OnConnectionFailedListener onconnectionfailedlistener)
        {
            this(context);
            eg.b(connectioncallbacks, "Must provide a connected listener");
            nx.add(connectioncallbacks);
            eg.b(onconnectionfailedlistener, "Must provide a connection failed listener");
            ny.add(onconnectionfailedlistener);
        }
    }

    public static interface ConnectionCallbacks
    {

        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        public abstract void onConnected(Bundle bundle);

        public abstract void onConnectionSuspended(int j);
    }

    public static interface OnConnectionFailedListener
        extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener
    {
    }

    public static interface a
    {

        public abstract void b(b b1);
    }

    public static interface b
    {

        public abstract void a(a a1);

        public abstract void b(Api.a a1);

        public abstract Api.b bj();
    }


    private final Object mV;
    private final a nc;
    private final dx ne;
    final Queue nf;
    private ConnectionResult ng;
    private int nh;
    private int ni;
    private int nj;
    private final Bundle nk;
    private final Map nl;
    private boolean nm;
    final Set nn;
    final ConnectionCallbacks no;
    private final com.google.android.gms.internal.dx.b np;

    private GoogleApiClient(Context context, dt dt, Map map, Set set, Set set1)
    {
        mV = new Object();
        nf = new LinkedList();
        ni = 4;
        nk = new Bundle();
        nl = new HashMap();
        nn = new HashSet();
        nc = new a() {

            final GoogleApiClient nq;

            public void b(b b1)
            {
                synchronized (GoogleApiClient.c(nq))
                {
                    nq.nn.remove(b1);
                }
                return;
                b1;
                obj1;
                JVM INSTR monitorexit ;
                throw b1;
            }

            
            {
                nq = GoogleApiClient.this;
                super();
            }
        };
        no = new ConnectionCallbacks() {

            final GoogleApiClient nq;

            public void onConnected(Bundle bundle)
            {
                Object obj1 = GoogleApiClient.c(nq);
                obj1;
                JVM INSTR monitorenter ;
                if (GoogleApiClient.d(nq) != 1)
                {
                    break MISSING_BLOCK_LABEL_43;
                }
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_36;
                }
                GoogleApiClient.e(nq).putAll(bundle);
                GoogleApiClient.f(nq);
                obj1;
                JVM INSTR monitorexit ;
                return;
                bundle;
                obj1;
                JVM INSTR monitorexit ;
                throw bundle;
            }

            public void onConnectionSuspended(int j)
            {
                Object obj1 = GoogleApiClient.c(nq);
                obj1;
                JVM INSTR monitorenter ;
                GoogleApiClient.a(nq, j);
                if (j != 2)
                {
                    break MISSING_BLOCK_LABEL_30;
                }
                nq.connect();
                obj1;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                nq = GoogleApiClient.this;
                super();
            }
        };
        np = new com.google.android.gms.internal.dx.b() {

            final GoogleApiClient nq;

            public Bundle aU()
            {
                return null;
            }

            public boolean bp()
            {
                return GoogleApiClient.g(nq);
            }

            public boolean isConnected()
            {
                return nq.isConnected();
            }

            
            {
                nq = GoogleApiClient.this;
                super();
            }
        };
        ne = new dx(context, np);
        ConnectionCallbacks connectioncallbacks;
        for (set = set.iterator(); set.hasNext(); ne.registerConnectionCallbacks(connectioncallbacks))
        {
            connectioncallbacks = (ConnectionCallbacks)set.next();
        }

        for (set = set1.iterator(); set.hasNext(); ne.registerConnectionFailedListener(set1))
        {
            set1 = (OnConnectionFailedListener)set.next();
        }

        Object obj;
        for (set = map.keySet().iterator(); set.hasNext(); nl.put(set1, set1.b(context, dt, ((ApiOptions) (obj)), no, new OnConnectionFailedListener(set1) {

        final GoogleApiClient nq;
        final Api.b nr;

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            synchronized (GoogleApiClient.c(nq))
            {
                if (GoogleApiClient.h(nq) == null || nr.getPriority() < GoogleApiClient.i(nq))
                {
                    GoogleApiClient.a(nq, connectionresult);
                    GoogleApiClient.b(nq, nr.getPriority());
                }
                GoogleApiClient.f(nq);
            }
            return;
            connectionresult;
            obj1;
            JVM INSTR monitorexit ;
            throw connectionresult;
        }

            
            {
                nq = GoogleApiClient.this;
                nr = b1;
                super();
            }
    })))
        {
            obj = (Api)set.next();
            set1 = ((Api) (obj)).bj();
            obj = (ApiOptions)map.get(obj);
        }

    }


    private void A(int j)
    {
        Object obj = mV;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (ni == 3)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        flag = isConnected();
        ni = 3;
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        nf.clear();
        Iterator iterator = nn.iterator();
_L1:
        b b1;
        boolean flag1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_133;
            }
            b1 = (b)iterator.next();
            flag1 = b1 instanceof Releasable;
        } while (!flag1);
        ((Releasable)b1).release();
          goto _L1
        Exception exception1;
        exception1;
        Log.w("GoogleApiClient", (new StringBuilder()).append("Unable to release ").append(b1).toString(), exception1);
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        nn.clear();
        nm = false;
        Iterator iterator1 = nl.values().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Api.a a1 = (Api.a)iterator1.next();
            if (a1.isConnected())
            {
                a1.disconnect();
            }
        } while (true);
        nm = true;
        ni = 4;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        ne.J(j);
        nm = false;
        obj;
        JVM INSTR monitorexit ;
    }

    static ConnectionResult a(GoogleApiClient googleapiclient, ConnectionResult connectionresult)
    {
        googleapiclient.ng = connectionresult;
        return connectionresult;
    }

    private void a(b b1)
    {
        Object obj = mV;
        obj;
        JVM INSTR monitorenter ;
        eg.a(isConnected(), "GoogleApiClient is not connected yet.");
        boolean flag;
        if (b1.bj() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.a(flag, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
        if (b1 instanceof Releasable)
        {
            nn.add(b1);
            b1.a(nc);
        }
        b1.b(a(b1.bj()));
        obj;
        JVM INSTR monitorexit ;
        return;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
    }

    static void a(GoogleApiClient googleapiclient, int j)
    {
        googleapiclient.A(j);
    }

    static int b(GoogleApiClient googleapiclient, int j)
    {
        googleapiclient.nh = j;
        return j;
    }

    private void bn()
    {
        Object obj1 = mV;
        obj1;
        JVM INSTR monitorenter ;
        nj = nj - 1;
        if (nj != 0) goto _L2; else goto _L1
_L1:
        if (ng == null) goto _L4; else goto _L3
_L3:
        A(3);
        ne.a(ng);
        nm = false;
_L2:
        return;
_L4:
        ni = 2;
        bo();
        if (!nk.isEmpty())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        Object obj = null;
_L5:
        ne.b(((Bundle) (obj)));
          goto _L2
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj = nk;
          goto _L5
    }

    private void bo()
    {
        eg.a(isConnected(), "GoogleApiClient is not connected yet.");
        Object obj = mV;
        obj;
        JVM INSTR monitorenter ;
        for (; !nf.isEmpty(); a((b)nf.remove())) { }
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    static Object c(GoogleApiClient googleapiclient)
    {
        return googleapiclient.mV;
    }

    static int d(GoogleApiClient googleapiclient)
    {
        return googleapiclient.ni;
    }

    static Bundle e(GoogleApiClient googleapiclient)
    {
        return googleapiclient.nk;
    }

    static void f(GoogleApiClient googleapiclient)
    {
        googleapiclient.bn();
    }

    static boolean g(GoogleApiClient googleapiclient)
    {
        return googleapiclient.nm;
    }

    static ConnectionResult h(GoogleApiClient googleapiclient)
    {
        return googleapiclient.ng;
    }

    static int i(GoogleApiClient googleapiclient)
    {
        return googleapiclient.nh;
    }

    public Api.a a(Api.b b1)
    {
        b1 = (Api.a)nl.get(b1);
        eg.b(b1, "Appropriate Api was not requested.");
        return b1;
    }

    public a.a a(a.a a1)
    {
        Object obj = mV;
        obj;
        JVM INSTR monitorenter ;
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_24;
        }
        b(a1);
_L2:
        return a1;
        nf.add(a1);
        if (true) goto _L2; else goto _L1
_L1:
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public a.a b(a.a a1)
    {
        eg.a(isConnected(), "GoogleApiClient is not connected yet.");
        bo();
        a(a1);
        return a1;
    }

    public void connect()
    {
label0:
        {
            synchronized (mV)
            {
                if (!isConnected() && !isConnecting())
                {
                    break label0;
                }
            }
            return;
        }
        nm = true;
        ng = null;
        ni = 1;
        nk.clear();
        nj = nl.size();
        for (Iterator iterator = nl.values().iterator(); iterator.hasNext(); ((Api.a)iterator.next()).connect()) { }
        break MISSING_BLOCK_LABEL_105;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public void disconnect()
    {
        A(-1);
    }

    public boolean isConnected()
    {
        Object obj = mV;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (ni == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isConnecting()
    {
        boolean flag;
        flag = true;
        synchronized (mV)
        {
            if (ni != 1)
            {
                flag = false;
            }
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectioncallbacks)
    {
        return ne.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onconnectionfailedlistener)
    {
        return ne.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void reconnect()
    {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectioncallbacks)
    {
        ne.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener)
    {
        ne.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectioncallbacks)
    {
        ne.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener)
    {
        ne.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }
}
