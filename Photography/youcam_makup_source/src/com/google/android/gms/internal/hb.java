// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            hm, hc, hd, hi

public abstract class hb
    implements com.google.android.gms.common.api.Api.a, hc.b
{

    public static final String Gh[] = {
        "service_esmobile", "service_googleme"
    };
    private final Looper DF;
    private final hc DS;
    private IInterface Gb;
    private final ArrayList Gc;
    private f Gd;
    private volatile int Ge;
    private final String Gf[];
    boolean Gg;
    private final Context mContext;
    final Handler mHandler;

    protected transient hb(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as[])
    {
        Gc = new ArrayList();
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

    protected transient hb(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String as[])
    {
        this(context, context.getMainLooper(), ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new g(onconnectionfailedlistener))), as);
    }

    static IInterface a(hb hb1, IInterface iinterface)
    {
        hb1.Gb = iinterface;
        return iinterface;
    }

    static f a(hb hb1, f f)
    {
        hb1.Gd = f;
        return f;
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
            a(hi.a.L(ibinder), new e());
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

    public final void a(b b1)
    {
        synchronized (Gc)
        {
            Gc.add(b1);
        }
        mHandler.sendMessage(mHandler.obtainMessage(2, b1));
        return;
        b1;
        arraylist;
        JVM INSTR monitorexit ;
        throw b1;
    }

    protected abstract void a(hi hi, e e1);

    public void an(int i)
    {
        mHandler.sendMessage(mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

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

    public final String[] fs()
    {
        return Gf;
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

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return DS.isConnectionCallbacksRegistered(new c(connectioncallbacks));
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return DS.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    protected void onConnected()
    {
    }

    protected void onDisconnected()
    {
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        DS.registerConnectionCallbacks(new c(connectioncallbacks));
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        DS.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        DS.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        DS.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        DS.unregisterConnectionCallbacks(new c(connectioncallbacks));
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        DS.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    protected abstract IInterface x(IBinder ibinder);


    /* member class not found */
    class a {}


    /* member class not found */
    class c {}


    /* member class not found */
    class g {}


    /* member class not found */
    class e {}


    /* member class not found */
    class h {}


    /* member class not found */
    class f {}


    /* member class not found */
    class b {}

}
