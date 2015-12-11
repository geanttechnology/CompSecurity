// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            eg

public final class dx
{
    final class a extends Handler
    {

        final dx py;

        public void handleMessage(Message message)
        {
            if (message.what == 1)
            {
                synchronized (dx.a(py))
                {
                    if (dx.b(py).bp() && dx.b(py).isConnected() && dx.a(py).contains(message.obj))
                    {
                        Bundle bundle = dx.b(py).aU();
                        ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)message.obj).onConnected(bundle);
                    }
                }
                return;
            } else
            {
                Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
                return;
            }
            message;
            arraylist;
            JVM INSTR monitorexit ;
            throw message;
        }

        public a(Looper looper)
        {
            py = dx.this;
            super(looper);
        }
    }

    public static interface b
    {

        public abstract Bundle aU();

        public abstract boolean bp();

        public abstract boolean isConnected();
    }


    private final Handler mHandler;
    private final b ps;
    private ArrayList pt;
    final ArrayList pu;
    private boolean pv;
    private ArrayList pw;
    private boolean px;

    public dx(Context context, b b1)
    {
        this(context, b1, null);
    }

    dx(Context context, b b1, Handler handler)
    {
        pu = new ArrayList();
        pv = false;
        px = false;
        context = handler;
        if (handler == null)
        {
            context = new a(Looper.getMainLooper());
        }
        pt = new ArrayList();
        pw = new ArrayList();
        ps = b1;
        mHandler = context;
    }

    static ArrayList a(dx dx1)
    {
        return dx1.pt;
    }

    static b b(dx dx1)
    {
        return dx1.ps;
    }

    public void J(int i)
    {
        mHandler.removeMessages(1);
        ArrayList arraylist = pt;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int k;
        pv = true;
        arraylist1 = pt;
        k = arraylist1.size();
        int j = 0;
_L2:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (ps.bp())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        pv = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        if (pt.contains(arraylist1.get(j)))
        {
            ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)arraylist1.get(j)).onConnectionSuspended(i);
        }
        break MISSING_BLOCK_LABEL_100;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void a(ConnectionResult connectionresult)
    {
        mHandler.removeMessages(1);
        ArrayList arraylist = pw;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int j;
        px = true;
        arraylist1 = pw;
        j = arraylist1.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (ps.bp())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        if (pw.contains(arraylist1.get(i)))
        {
            ((com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener)arraylist1.get(i)).onConnectionFailed(connectionresult);
        }
        break MISSING_BLOCK_LABEL_103;
        px = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        connectionresult;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectionresult;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void b(Bundle bundle)
    {
        boolean flag1 = true;
        ArrayList arraylist = pt;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int i;
        int j;
        boolean flag;
        if (!pv)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.p(flag);
        mHandler.removeMessages(1);
        pv = true;
        if (pu.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.p(flag);
        arraylist1 = pt;
        j = arraylist1.size();
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        if (ps.bp() && ps.isConnected())
        {
            break MISSING_BLOCK_LABEL_117;
        }
        pu.clear();
        pv = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        pu.size();
        if (!pu.contains(arraylist1.get(i)))
        {
            ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)arraylist1.get(i)).onConnected(bundle);
        }
        break MISSING_BLOCK_LABEL_176;
        bundle;
        arraylist;
        JVM INSTR monitorexit ;
        throw bundle;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void bT()
    {
        synchronized (pt)
        {
            b(ps.aU());
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        eg.f(connectioncallbacks);
        boolean flag;
        synchronized (pt)
        {
            flag = pt.contains(connectioncallbacks);
        }
        return flag;
        connectioncallbacks;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        eg.f(onconnectionfailedlistener);
        boolean flag;
        synchronized (pw)
        {
            flag = pw.contains(onconnectionfailedlistener);
        }
        return flag;
        onconnectionfailedlistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        eg.f(connectioncallbacks);
        ArrayList arraylist = pt;
        arraylist;
        JVM INSTR monitorenter ;
        if (!pt.contains(connectioncallbacks))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionCallbacks(): listener ").append(connectioncallbacks).append(" is already registered").toString());
_L2:
        if (ps.isConnected())
        {
            mHandler.sendMessage(mHandler.obtainMessage(1, connectioncallbacks));
        }
        return;
        if (pv)
        {
            pt = new ArrayList(pt);
        }
        pt.add(connectioncallbacks);
        if (true) goto _L2; else goto _L1
_L1:
        connectioncallbacks;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        eg.f(onconnectionfailedlistener);
        ArrayList arraylist = pw;
        arraylist;
        JVM INSTR monitorenter ;
        if (!pw.contains(onconnectionfailedlistener))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionFailedListener(): listener ").append(onconnectionfailedlistener).append(" is already registered").toString());
_L2:
        return;
        if (px)
        {
            pw = new ArrayList(pw);
        }
        pw.add(onconnectionfailedlistener);
        if (true) goto _L2; else goto _L1
_L1:
        onconnectionfailedlistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        eg.f(connectioncallbacks);
        ArrayList arraylist = pt;
        arraylist;
        JVM INSTR monitorenter ;
        if (pt == null) goto _L2; else goto _L1
_L1:
        if (pv)
        {
            pt = new ArrayList(pt);
        }
        if (pt.remove(connectioncallbacks)) goto _L4; else goto _L3
_L3:
        Log.w("GmsClientEvents", (new StringBuilder()).append("unregisterConnectionCallbacks(): listener ").append(connectioncallbacks).append(" not found").toString());
_L2:
        return;
_L4:
        if (pv && !pu.contains(connectioncallbacks))
        {
            pu.add(connectioncallbacks);
        }
        if (true) goto _L2; else goto _L5
_L5:
        connectioncallbacks;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        eg.f(onconnectionfailedlistener);
        synchronized (pw)
        {
            if (pw != null)
            {
                if (px)
                {
                    pw = new ArrayList(pw);
                }
                if (!pw.remove(onconnectionfailedlistener))
                {
                    Log.w("GmsClientEvents", (new StringBuilder()).append("unregisterConnectionFailedListener(): listener ").append(onconnectionfailedlistener).append(" not found").toString());
                }
            }
        }
        return;
        onconnectionfailedlistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }
}
