// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            eg, dx, dy, ec

public abstract class dw
    implements GooglePlayServicesClient, com.google.android.gms.common.api.Api.a, dx.b
{
    final class a extends Handler
    {

        final dw pl;

        public void handleMessage(Message message)
        {
            if (message.what == 1 && !pl.isConnecting())
            {
                message = (b)message.obj;
                message.aL();
                message.unregister();
                return;
            }
            synchronized (dw.b(pl))
            {
                pl.pi = false;
            }
            if (message.what == 3)
            {
                dw.a(pl).a(new ConnectionResult(((Integer)message.obj).intValue(), null));
                return;
            }
            break MISSING_BLOCK_LABEL_97;
            message;
            obj;
            JVM INSTR monitorexit ;
            throw message;
            if (message.what == 4)
            {
                dw.a(pl).J(((Integer)message.obj).intValue());
                return;
            }
            if (message.what == 2 && !pl.isConnected())
            {
                message = (b)message.obj;
                message.aL();
                message.unregister();
                return;
            }
            if (message.what == 2 || message.what == 1)
            {
                ((b)message.obj).bR();
                return;
            } else
            {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
                return;
            }
        }

        public a(Looper looper)
        {
            pl = dw.this;
            super(looper);
        }
    }

    protected abstract class b
    {

        private Object mListener;
        final dw pl;
        private boolean pm;

        protected abstract void aL();

        protected abstract void b(Object obj);

        public void bR()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            obj = mListener;
            if (pm)
            {
                Log.w("GmsClient", (new StringBuilder()).append("Callback proxy ").append(this).append(" being reused. This is not safe.").toString());
            }
            this;
            JVM INSTR monitorexit ;
            Object obj1;
            if (obj != null)
            {
                try
                {
                    b(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    aL();
                    throw obj1;
                }
            } else
            {
                aL();
            }
            this;
            JVM INSTR monitorenter ;
            pm = true;
            this;
            JVM INSTR monitorexit ;
            unregister();
            return;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
        }

        public void bS()
        {
            this;
            JVM INSTR monitorenter ;
            mListener = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void unregister()
        {
            bS();
            synchronized (dw.c(pl))
            {
                dw.c(pl).remove(this);
            }
            return;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public b(Object obj)
        {
            pl = dw.this;
            super();
            mListener = obj;
            pm = false;
        }
    }

    public static final class c
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    {

        private final com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks pn;

        public boolean equals(Object obj)
        {
            if (obj instanceof c)
            {
                return pn.equals(((c)obj).pn);
            } else
            {
                return pn.equals(obj);
            }
        }

        public void onConnected(Bundle bundle)
        {
            pn.onConnected(bundle);
        }

        public void onConnectionSuspended(int i)
        {
            pn.onDisconnected();
        }

        public c(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
        {
            pn = connectioncallbacks;
        }
    }

    public abstract class d extends b
    {

        private final DataHolder nE;
        final dw pl;

        protected abstract void a(Object obj, DataHolder dataholder);

        protected void aL()
        {
            if (nE != null)
            {
                nE.close();
            }
        }

        protected final void b(Object obj)
        {
            a(obj, nE);
        }

        public volatile void bR()
        {
            super.bR();
        }

        public volatile void bS()
        {
            super.bS();
        }

        public volatile void unregister()
        {
            super.unregister();
        }

        public d(Object obj, DataHolder dataholder)
        {
            pl = dw.this;
            super(obj);
            nE = dataholder;
        }
    }

    public static final class e extends eb.a
    {

        private dw po;

        public void b(int i, IBinder ibinder, Bundle bundle)
        {
            eg.b("onPostInitComplete can be called only once per call to getServiceFromBroker", po);
            po.a(i, ibinder, bundle);
            po = null;
        }

        public e(dw dw1)
        {
            po = dw1;
        }
    }

    final class f
        implements ServiceConnection
    {

        final dw pl;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            pl.w(ibinder);
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            dw.a(pl, null);
            dw.a(pl).J(1);
        }

        f()
        {
            pl = dw.this;
            super();
        }
    }

    public static final class g
        implements com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        private final com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener pp;

        public boolean equals(Object obj)
        {
            if (obj instanceof g)
            {
                return pp.equals(((g)obj).pp);
            } else
            {
                return pp.equals(obj);
            }
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            pp.onConnectionFailed(connectionresult);
        }

        public g(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            pp = onconnectionfailedlistener;
        }
    }

    protected final class h extends b
    {

        final dw pl;
        public final Bundle pq;
        public final IBinder pr;
        public final int statusCode;

        protected void aL()
        {
        }

        protected void b(Boolean boolean1)
        {
            if (boolean1 == null)
            {
                return;
            }
            switch (statusCode)
            {
            default:
                if (pq != null)
                {
                    boolean1 = (PendingIntent)pq.getParcelable("pendingIntent");
                } else
                {
                    boolean1 = null;
                }
                if (dw.e(pl) != null)
                {
                    dy.s(dw.f(pl)).b(pl.am(), dw.e(pl));
                    dw.a(pl, null);
                }
                dw.a(pl, null);
                dw.a(pl).a(new ConnectionResult(statusCode, boolean1));
                return;

            case 0: // '\0'
                try
                {
                    boolean1 = pr.getInterfaceDescriptor();
                    if (pl.an().equals(boolean1))
                    {
                        dw.a(pl, pl.p(pr));
                        if (dw.d(pl) != null)
                        {
                            dw.a(pl).bT();
                            return;
                        }
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Boolean boolean1) { }
                dy.s(dw.f(pl)).b(pl.am(), dw.e(pl));
                dw.a(pl, null);
                dw.a(pl, null);
                dw.a(pl).a(new ConnectionResult(8, null));
                return;

            case 10: // '\n'
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            }
        }

        protected volatile void b(Object obj)
        {
            b((Boolean)obj);
        }

        public h(int i, IBinder ibinder, Bundle bundle)
        {
            pl = dw.this;
            super(Boolean.valueOf(true));
            statusCode = i;
            pr = ibinder;
            pq = bundle;
        }
    }


    public static final String pk[] = {
        "service_esmobile", "service_googleme"
    };
    private final String jF[];
    private final Context mContext;
    final Handler mHandler;
    private final dx ne;
    private IInterface pe;
    private final ArrayList pf;
    private f pg;
    boolean ph;
    boolean pi;
    private final Object pj;

    protected transient dw(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String as[])
    {
        this(context, ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new g(onconnectionfailedlistener))), as);
    }

    protected transient dw(Context context, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as[])
    {
        pf = new ArrayList();
        ph = false;
        pi = false;
        pj = new Object();
        mContext = (Context)eg.f(context);
        ne = new dx(context, this, null);
        mHandler = new a(context.getMainLooper());
        a(as);
        jF = as;
        registerConnectionCallbacks((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)eg.f(connectioncallbacks));
        registerConnectionFailedListener((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener)eg.f(onconnectionfailedlistener));
    }

    static IInterface a(dw dw1, IInterface iinterface)
    {
        dw1.pe = iinterface;
        return iinterface;
    }

    static f a(dw dw1, f f1)
    {
        dw1.pg = f1;
        return f1;
    }

    static dx a(dw dw1)
    {
        return dw1.ne;
    }

    static Object b(dw dw1)
    {
        return dw1.pj;
    }

    static ArrayList c(dw dw1)
    {
        return dw1.pf;
    }

    static IInterface d(dw dw1)
    {
        return dw1.pe;
    }

    static f e(dw dw1)
    {
        return dw1.pg;
    }

    static Context f(dw dw1)
    {
        return dw1.mContext;
    }

    public void I(int i)
    {
        mHandler.sendMessage(mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected void a(int i, IBinder ibinder, Bundle bundle)
    {
        mHandler.sendMessage(mHandler.obtainMessage(1, new h(i, ibinder, bundle)));
    }

    public final void a(b b1)
    {
        synchronized (pf)
        {
            pf.add(b1);
        }
        mHandler.sendMessage(mHandler.obtainMessage(2, b1));
        return;
        b1;
        arraylist;
        JVM INSTR monitorexit ;
        throw b1;
    }

    protected abstract void a(ec ec, e e1)
        throws RemoteException;

    protected transient void a(String as[])
    {
    }

    public Bundle aU()
    {
        return null;
    }

    protected abstract String am();

    protected abstract String an();

    public final String[] bO()
    {
        return jF;
    }

    protected final void bP()
    {
        if (!isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    protected final IInterface bQ()
    {
        bP();
        return pe;
    }

    public boolean bp()
    {
        return ph;
    }

    public void connect()
    {
        ph = true;
        synchronized (pj)
        {
            pi = true;
        }
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mContext);
        if (i != 0)
        {
            mHandler.sendMessage(mHandler.obtainMessage(3, Integer.valueOf(i)));
        } else
        {
            if (pg != null)
            {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                pe = null;
                dy.s(mContext).b(am(), pg);
            }
            pg = new f();
            if (!dy.s(mContext).a(am(), pg))
            {
                Log.e("GmsClient", (new StringBuilder()).append("unable to connect to service: ").append(am()).toString());
                mHandler.sendMessage(mHandler.obtainMessage(3, Integer.valueOf(9)));
                return;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void disconnect()
    {
        ph = false;
        synchronized (pj)
        {
            pi = false;
        }
        obj = pf;
        obj;
        JVM INSTR monitorenter ;
        int j = pf.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((b)pf.get(i)).bS();
        i++;
        if (true) goto _L2; else goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        pf.clear();
        obj;
        JVM INSTR monitorexit ;
        pe = null;
        if (pg != null)
        {
            dy.s(mContext).b(am(), pg);
            pg = null;
            ne.J(-1);
        }
        return;
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final Context getContext()
    {
        return mContext;
    }

    public boolean isConnected()
    {
        return pe != null;
    }

    public boolean isConnecting()
    {
        boolean flag;
        synchronized (pj)
        {
            flag = pi;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return ne.isConnectionCallbacksRegistered(new c(connectioncallbacks));
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return ne.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    protected abstract IInterface p(IBinder ibinder);

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        ne.registerConnectionCallbacks(new c(connectioncallbacks));
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        ne.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        ne.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        ne.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        ne.unregisterConnectionCallbacks(new c(connectioncallbacks));
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        ne.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    protected final void w(IBinder ibinder)
    {
        try
        {
            a(ec.a.y(ibinder), new e(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            Log.w("GmsClient", "service died");
        }
    }

}
