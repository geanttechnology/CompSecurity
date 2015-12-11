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
//            er

public final class ei
{
    final class a extends Handler
    {

        final ei BP;

        public void handleMessage(Message message)
        {
            if (message.what == 1)
            {
                synchronized (ei.a(BP))
                {
                    if (ei.b(BP).dC() && ei.b(BP).isConnected() && ei.a(BP).contains(message.obj))
                    {
                        Bundle bundle = ei.b(BP).cY();
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
            BP = ei.this;
            super(looper);
        }
    }

    public static interface b
    {

        public abstract Bundle cY();

        public abstract boolean dC();

        public abstract boolean isConnected();
    }


    private final b BJ;
    private ArrayList BK;
    final ArrayList BL = new ArrayList();
    private boolean BM;
    private ArrayList BN;
    private boolean BO;
    private final Handler mHandler;

    public ei(Context context, Looper looper, b b1)
    {
        BM = false;
        BO = false;
        BK = new ArrayList();
        BN = new ArrayList();
        BJ = b1;
        mHandler = new a(looper);
    }

    static ArrayList a(ei ei1)
    {
        return ei1.BK;
    }

    static b b(ei ei1)
    {
        return ei1.BJ;
    }

    public void P(int i)
    {
        mHandler.removeMessages(1);
        ArrayList arraylist = BK;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int k;
        BM = true;
        arraylist1 = BK;
        k = arraylist1.size();
        int j = 0;
_L2:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (BJ.dC())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        BM = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        if (BK.contains(arraylist1.get(j)))
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
        ArrayList arraylist = BN;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int j;
        BO = true;
        arraylist1 = BN;
        j = arraylist1.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (BJ.dC())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        if (BN.contains(arraylist1.get(i)))
        {
            ((com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener)arraylist1.get(i)).onConnectionFailed(connectionresult);
        }
        break MISSING_BLOCK_LABEL_103;
        BO = false;
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
        ArrayList arraylist = BK;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int i;
        int j;
        boolean flag;
        if (!BM)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.v(flag);
        mHandler.removeMessages(1);
        BM = true;
        if (BL.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        er.v(flag);
        arraylist1 = BK;
        j = arraylist1.size();
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        if (BJ.dC() && BJ.isConnected())
        {
            break MISSING_BLOCK_LABEL_117;
        }
        BL.clear();
        BM = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        BL.size();
        if (!BL.contains(arraylist1.get(i)))
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

    protected void bo()
    {
        synchronized (BK)
        {
            b(BJ.cY());
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        er.f(connectioncallbacks);
        boolean flag;
        synchronized (BK)
        {
            flag = BK.contains(connectioncallbacks);
        }
        return flag;
        connectioncallbacks;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        er.f(onconnectionfailedlistener);
        boolean flag;
        synchronized (BN)
        {
            flag = BN.contains(onconnectionfailedlistener);
        }
        return flag;
        onconnectionfailedlistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        er.f(connectioncallbacks);
        ArrayList arraylist = BK;
        arraylist;
        JVM INSTR monitorenter ;
        if (!BK.contains(connectioncallbacks))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionCallbacks(): listener ").append(connectioncallbacks).append(" is already registered").toString());
_L2:
        if (BJ.isConnected())
        {
            mHandler.sendMessage(mHandler.obtainMessage(1, connectioncallbacks));
        }
        return;
        if (BM)
        {
            BK = new ArrayList(BK);
        }
        BK.add(connectioncallbacks);
        if (true) goto _L2; else goto _L1
_L1:
        connectioncallbacks;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectioncallbacks;
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        er.f(onconnectionfailedlistener);
        ArrayList arraylist = BN;
        arraylist;
        JVM INSTR monitorenter ;
        if (!BN.contains(onconnectionfailedlistener))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionFailedListener(): listener ").append(onconnectionfailedlistener).append(" is already registered").toString());
_L2:
        return;
        if (BO)
        {
            BN = new ArrayList(BN);
        }
        BN.add(onconnectionfailedlistener);
        if (true) goto _L2; else goto _L1
_L1:
        onconnectionfailedlistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw onconnectionfailedlistener;
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        er.f(connectioncallbacks);
        ArrayList arraylist = BK;
        arraylist;
        JVM INSTR monitorenter ;
        if (BK == null) goto _L2; else goto _L1
_L1:
        if (BM)
        {
            BK = new ArrayList(BK);
        }
        if (BK.remove(connectioncallbacks)) goto _L4; else goto _L3
_L3:
        Log.w("GmsClientEvents", (new StringBuilder()).append("unregisterConnectionCallbacks(): listener ").append(connectioncallbacks).append(" not found").toString());
_L2:
        return;
_L4:
        if (BM && !BL.contains(connectioncallbacks))
        {
            BL.add(connectioncallbacks);
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
        er.f(onconnectionfailedlistener);
        synchronized (BN)
        {
            if (BN != null)
            {
                if (BO)
                {
                    BN = new ArrayList(BN);
                }
                if (!BN.remove(onconnectionfailedlistener))
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
