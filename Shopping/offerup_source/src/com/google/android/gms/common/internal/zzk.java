// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx

public final class zzk
    implements android.os.Handler.Callback
{

    private final Handler mHandler;
    private final zza zzafP;
    private final ArrayList zzafQ = new ArrayList();
    final ArrayList zzafR = new ArrayList();
    private final ArrayList zzafS = new ArrayList();
    private volatile boolean zzafT;
    private final AtomicInteger zzafU = new AtomicInteger(0);
    private boolean zzafV;
    private final Object zzpd = new Object();

    public zzk(Looper looper, zza zza)
    {
        zzafT = false;
        zzafV = false;
        zzafP = zza;
        mHandler = new Handler(looper, this);
    }

    public final boolean handleMessage(Message message)
    {
        if (message.what == 1)
        {
            com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)message.obj;
            synchronized (zzpd)
            {
                if (zzafT && zzafP.isConnected() && zzafQ.contains(connectioncallbacks))
                {
                    connectioncallbacks.onConnected(zzafP.zzmS());
                }
            }
            return true;
        } else
        {
            Log.wtf("GmsClientEvents", (new StringBuilder("Don't know how to handle message: ")).append(message.what).toString(), new Exception());
            return false;
        }
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean isConnectionCallbacksRegistered(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        zzx.zzw(connectioncallbacks);
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzafQ.contains(connectioncallbacks);
        }
        return flag;
        connectioncallbacks;
        obj;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public final boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzx.zzw(onconnectionfailedlistener);
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzafS.contains(onconnectionfailedlistener);
        }
        return flag;
        onconnectionfailedlistener;
        obj;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }

    public final void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        zzx.zzw(connectioncallbacks);
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!zzafQ.contains(connectioncallbacks))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionCallbacks(): listener ")).append(connectioncallbacks).append(" is already registered").toString());
_L2:
        if (zzafP.isConnected())
        {
            mHandler.sendMessage(mHandler.obtainMessage(1, connectioncallbacks));
        }
        return;
        zzafQ.add(connectioncallbacks);
        if (true) goto _L2; else goto _L1
_L1:
        connectioncallbacks;
        obj;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public final void registerConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzx.zzw(onconnectionfailedlistener);
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!zzafS.contains(onconnectionfailedlistener))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionFailedListener(): listener ")).append(onconnectionfailedlistener).append(" is already registered").toString());
_L2:
        return;
        zzafS.add(onconnectionfailedlistener);
        if (true) goto _L2; else goto _L1
_L1:
        onconnectionfailedlistener;
        obj;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }

    public final void unregisterConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        zzx.zzw(connectioncallbacks);
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzafQ.remove(connectioncallbacks)) goto _L2; else goto _L1
_L1:
        Log.w("GmsClientEvents", (new StringBuilder("unregisterConnectionCallbacks(): listener ")).append(connectioncallbacks).append(" not found").toString());
_L4:
        return;
_L2:
        if (zzafV)
        {
            zzafR.add(connectioncallbacks);
        }
        if (true) goto _L4; else goto _L3
_L3:
        connectioncallbacks;
        obj;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public final void unregisterConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzx.zzw(onconnectionfailedlistener);
        synchronized (zzpd)
        {
            if (!zzafS.remove(onconnectionfailedlistener))
            {
                Log.w("GmsClientEvents", (new StringBuilder("unregisterConnectionFailedListener(): listener ")).append(onconnectionfailedlistener).append(" not found").toString());
            }
        }
        return;
        onconnectionfailedlistener;
        obj;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }

    public final void zzbG(int i)
    {
        boolean flag = false;
        if (Looper.myLooper() == mHandler.getLooper())
        {
            flag = true;
        }
        zzx.zza(flag, "onUnintentionalDisconnection must only be called on the Handler thread");
        mHandler.removeMessages(1);
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzafV = true;
        Object obj1 = new ArrayList(zzafQ);
        int j = zzafU.get();
        obj1 = ((ArrayList) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)((Iterator) (obj1)).next();
            if (!zzafT || zzafU.get() != j)
            {
                break;
            }
            if (zzafQ.contains(connectioncallbacks))
            {
                connectioncallbacks.onConnectionSuspended(i);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_139;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzafR.clear();
        zzafV = false;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void zzh(Bundle bundle)
    {
        Object obj;
        boolean flag;
        boolean flag1 = true;
        Object obj1;
        com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks;
        int i;
        if (Looper.myLooper() == mHandler.getLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "onConnectionSuccess must only be called on the Handler thread");
        obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!zzafV)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        mHandler.removeMessages(1);
        zzafV = true;
        if (zzafR.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        obj1 = new ArrayList(zzafQ);
        i = zzafU.get();
        obj1 = ((ArrayList) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            connectioncallbacks = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)((Iterator) (obj1)).next();
            if (!zzafT || !zzafP.isConnected() || zzafU.get() != i)
            {
                break;
            }
            if (!zzafR.contains(connectioncallbacks))
            {
                connectioncallbacks.onConnected(bundle);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_203;
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
        zzafR.clear();
        zzafV = false;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void zzi(ConnectionResult connectionresult)
    {
        Object obj;
        Object obj1;
        com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener;
        int i;
        boolean flag;
        if (Looper.myLooper() == mHandler.getLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "onConnectionFailure must only be called on the Handler thread");
        mHandler.removeMessages(1);
        obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        obj1 = new ArrayList(zzafS);
        i = zzafU.get();
        obj1 = ((ArrayList) (obj1)).iterator();
_L2:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_134;
        }
        onconnectionfailedlistener = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener)((Iterator) (obj1)).next();
        if (!zzafT || zzafU.get() != i)
        {
            return;
        }
        if (zzafS.contains(onconnectionfailedlistener))
        {
            onconnectionfailedlistener.onConnectionFailed(connectionresult);
        }
        if (true) goto _L2; else goto _L1
_L1:
        connectionresult;
        obj;
        JVM INSTR monitorexit ;
        throw connectionresult;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void zzpk()
    {
        zzafT = false;
        zzafU.incrementAndGet();
    }

    public final void zzpl()
    {
        zzafT = true;
    }

    private class zza
    {

        public abstract boolean isConnected();

        public abstract Bundle zzmS();
    }

}
