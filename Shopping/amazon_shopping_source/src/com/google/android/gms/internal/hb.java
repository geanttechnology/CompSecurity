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
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            hm, hc, hd, hi

public abstract class hb
    implements com.google.android.gms.common.api.Api.a, hc.b
{
    final class a extends Handler
    {

        final hb Gi;

        public void handleMessage(Message message)
        {
            if (message.what == 1 && !Gi.isConnecting())
            {
                message = (b)message.obj;
                message.fu();
                message.unregister();
                return;
            }
            if (message.what == 3)
            {
                hb.a(Gi).a(new ConnectionResult(((Integer)message.obj).intValue(), null));
                return;
            }
            if (message.what == 4)
            {
                hb.a(Gi, 1);
                hb.a(Gi, null);
                hb.a(Gi).ao(((Integer)message.obj).intValue());
                return;
            }
            if (message.what == 2 && !Gi.isConnected())
            {
                message = (b)message.obj;
                message.fu();
                message.unregister();
                return;
            }
            if (message.what == 2 || message.what == 1)
            {
                ((b)message.obj).fv();
                return;
            } else
            {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
                return;
            }
        }

        public a(Looper looper)
        {
            Gi = hb.this;
            super(looper);
        }
    }

    protected abstract class b
    {

        final hb Gi;
        private boolean Gj;
        private Object mListener;

        protected abstract void d(Object obj);

        protected abstract void fu();

        public void fv()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            obj = mListener;
            if (Gj)
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
                    d(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    fu();
                    throw obj1;
                }
            } else
            {
                fu();
            }
            this;
            JVM INSTR monitorenter ;
            Gj = true;
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

        public void fw()
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
            fw();
            synchronized (hb.b(Gi))
            {
                hb.b(Gi).remove(this);
            }
            return;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public b(Object obj)
        {
            Gi = hb.this;
            super();
            mListener = obj;
            Gj = false;
        }
    }

    public static final class e extends hh.a
    {

        private hb Gl;

        public void b(int i, IBinder ibinder, Bundle bundle)
        {
            hm.b("onPostInitComplete can be called only once per call to getServiceFromBroker", Gl);
            Gl.a(i, ibinder, bundle);
            Gl = null;
        }

        public e(hb hb1)
        {
            Gl = hb1;
        }
    }

    final class f
        implements ServiceConnection
    {

        final hb Gi;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            Gi.I(ibinder);
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            Gi.mHandler.sendMessage(Gi.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }

        f()
        {
            Gi = hb.this;
            super();
        }
    }

    protected final class h extends b
    {

        final hb Gi;
        public final Bundle Gn;
        public final IBinder Go;
        public final int statusCode;

        protected void b(Boolean boolean1)
        {
            if (boolean1 == null)
            {
                hb.a(Gi, 1);
                return;
            }
            switch (statusCode)
            {
            default:
                if (Gn != null)
                {
                    boolean1 = (PendingIntent)Gn.getParcelable("pendingIntent");
                } else
                {
                    boolean1 = null;
                }
                if (hb.d(Gi) != null)
                {
                    hd.E(hb.e(Gi)).b(Gi.bu(), hb.d(Gi));
                    hb.a(Gi, null);
                }
                hb.a(Gi, 1);
                hb.a(Gi, null);
                hb.a(Gi).a(new ConnectionResult(statusCode, boolean1));
                return;

            case 0: // '\0'
                try
                {
                    boolean1 = Go.getInterfaceDescriptor();
                    if (Gi.bv().equals(boolean1))
                    {
                        hb.a(Gi, Gi.x(Go));
                        if (hb.c(Gi) != null)
                        {
                            hb.a(Gi, 3);
                            hb.a(Gi).cp();
                            return;
                        }
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Boolean boolean1) { }
                hd.E(hb.e(Gi)).b(Gi.bu(), hb.d(Gi));
                hb.a(Gi, null);
                hb.a(Gi, 1);
                hb.a(Gi, null);
                hb.a(Gi).a(new ConnectionResult(8, null));
                return;

            case 10: // '\n'
                hb.a(Gi, 1);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            }
        }

        protected void d(Object obj)
        {
            b((Boolean)obj);
        }

        protected void fu()
        {
        }

        public h(int i, IBinder ibinder, Bundle bundle)
        {
            Gi = hb.this;
            super(Boolean.valueOf(true));
            statusCode = i;
            Go = ibinder;
            Gn = bundle;
        }
    }


    public static final String Gh[] = {
        "service_esmobile", "service_googleme"
    };
    private final Looper DF;
    private final hc DS;
    private IInterface Gb;
    private final ArrayList Gc = new ArrayList();
    private f Gd;
    private volatile int Ge;
    private final String Gf[];
    boolean Gg;
    private final Context mContext;
    final Handler mHandler;

    protected transient hb(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as[])
    {
        Ge = 1;
        Gg = false;
        mContext = (Context)hm.f(context);
        DF = (Looper)hm.b(looper, "Looper must not be null");
        DS = new hc(context, looper, this);
        mHandler = new a(looper);
        b(as);
        Gf = as;
        registerConnectionCallbacks((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)hm.f(connectioncallbacks));
        registerConnectionFailedListener((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener)hm.f(onconnectionfailedlistener));
    }

    static IInterface a(hb hb1, IInterface iinterface)
    {
        hb1.Gb = iinterface;
        return iinterface;
    }

    static f a(hb hb1, f f1)
    {
        hb1.Gd = f1;
        return f1;
    }

    static hc a(hb hb1)
    {
        return hb1.DS;
    }

    static void a(hb hb1, int i)
    {
        hb1.am(i);
    }

    private void am(int i)
    {
        int j = Ge;
        Ge = i;
        if (j != i)
        {
            if (i == 3)
            {
                onConnected();
            } else
            if (j == 3 && i == 1)
            {
                onDisconnected();
                return;
            }
        }
    }

    static ArrayList b(hb hb1)
    {
        return hb1.Gc;
    }

    static IInterface c(hb hb1)
    {
        return hb1.Gb;
    }

    static f d(hb hb1)
    {
        return hb1.Gd;
    }

    static Context e(hb hb1)
    {
        return hb1.mContext;
    }

    protected final void I(IBinder ibinder)
    {
        try
        {
            a(hi.a.L(ibinder), new e(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            Log.w("GmsClient", "service died");
        }
    }

    protected void a(int i, IBinder ibinder, Bundle bundle)
    {
        mHandler.sendMessage(mHandler.obtainMessage(1, new h(i, ibinder, bundle)));
    }

    protected abstract void a(hi hi, e e1)
        throws RemoteException;

    protected transient void b(String as[])
    {
    }

    protected abstract String bu();

    protected abstract String bv();

    protected final void cn()
    {
        if (!isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    public void connect()
    {
        Gg = true;
        am(2);
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mContext);
        if (i != 0)
        {
            am(1);
            mHandler.sendMessage(mHandler.obtainMessage(3, Integer.valueOf(i)));
        } else
        {
            if (Gd != null)
            {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                Gb = null;
                hd.E(mContext).b(bu(), Gd);
            }
            Gd = new f();
            if (!hd.E(mContext).a(bu(), Gd))
            {
                Log.e("GmsClient", (new StringBuilder()).append("unable to connect to service: ").append(bu()).toString());
                mHandler.sendMessage(mHandler.obtainMessage(3, Integer.valueOf(9)));
                return;
            }
        }
    }

    public void disconnect()
    {
        Gg = false;
        ArrayList arraylist = Gc;
        arraylist;
        JVM INSTR monitorenter ;
        int j = Gc.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((b)Gc.get(i)).fw();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Gc.clear();
        arraylist;
        JVM INSTR monitorexit ;
        am(1);
        Gb = null;
        if (Gd != null)
        {
            hd.E(mContext).b(bu(), Gd);
            Gd = null;
        }
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean eO()
    {
        return Gg;
    }

    public Bundle ef()
    {
        return null;
    }

    public final IInterface ft()
    {
        cn();
        return Gb;
    }

    public final Context getContext()
    {
        return mContext;
    }

    public final Looper getLooper()
    {
        return DF;
    }

    public boolean isConnected()
    {
        return Ge == 3;
    }

    public boolean isConnecting()
    {
        return Ge == 2;
    }

    protected void onConnected()
    {
    }

    protected void onDisconnected()
    {
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        DS.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        DS.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    protected abstract IInterface x(IBinder ibinder);

}
