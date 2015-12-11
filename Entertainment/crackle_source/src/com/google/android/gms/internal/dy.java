// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class dy
    implements android.os.Handler.Callback
{
    final class a
    {

        private int mState;
        private final String pC;
        private final a pD = new a(this);
        private final HashSet pE = new HashSet();
        private boolean pF;
        private IBinder pG;
        private ComponentName pH;
        final dy pI;

        static int a(a a1, int i)
        {
            a1.mState = i;
            return i;
        }

        static ComponentName a(a a1, ComponentName componentname)
        {
            a1.pH = componentname;
            return componentname;
        }

        static IBinder a(a a1, IBinder ibinder)
        {
            a1.pG = ibinder;
            return ibinder;
        }

        static HashSet a(a a1)
        {
            return a1.pE;
        }

        public void a(dw.f f)
        {
            pE.add(f);
        }

        public void b(dw.f f)
        {
            pE.remove(f);
        }

        public a bU()
        {
            return pD;
        }

        public String bV()
        {
            return pC;
        }

        public boolean bW()
        {
            return pE.isEmpty();
        }

        public boolean c(dw.f f)
        {
            return pE.contains(f);
        }

        public IBinder getBinder()
        {
            return pG;
        }

        public ComponentName getComponentName()
        {
            return pH;
        }

        public int getState()
        {
            return mState;
        }

        public boolean isBound()
        {
            return pF;
        }

        public void q(boolean flag)
        {
            pF = flag;
        }

        public a(String s1)
        {
            pI = dy.this;
            super();
            pC = s1;
            mState = 0;
        }
    }

    public class a.a
        implements ServiceConnection
    {

        final a pJ;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            HashMap hashmap = dy.a(pJ.pI);
            hashmap;
            JVM INSTR monitorenter ;
            a.a(pJ, ibinder);
            a.a(pJ, componentname);
            for (Iterator iterator = a.a(pJ).iterator(); iterator.hasNext(); ((dw.f)iterator.next()).onServiceConnected(componentname, ibinder)) { }
            break MISSING_BLOCK_LABEL_76;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.a(pJ, 1);
            hashmap;
            JVM INSTR monitorexit ;
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            HashMap hashmap = dy.a(pJ.pI);
            hashmap;
            JVM INSTR monitorenter ;
            a.a(pJ, null);
            a.a(pJ, componentname);
            for (Iterator iterator = a.a(pJ).iterator(); iterator.hasNext(); ((dw.f)iterator.next()).onServiceDisconnected(componentname)) { }
            break MISSING_BLOCK_LABEL_72;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.a(pJ, 2);
            hashmap;
            JVM INSTR monitorexit ;
        }

        public a.a(a a1)
        {
            pJ = a1;
            super();
        }
    }


    private static dy pA;
    private static final Object pz = new Object();
    private final Context iT;
    private final Handler mHandler;
    private final HashMap pB = new HashMap();

    private dy(Context context)
    {
        mHandler = new Handler(context.getMainLooper(), this);
        iT = context.getApplicationContext();
    }

    static HashMap a(dy dy1)
    {
        return dy1.pB;
    }

    public static dy s(Context context)
    {
        synchronized (pz)
        {
            if (pA == null)
            {
                pA = new dy(context.getApplicationContext());
            }
        }
        return pA;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public boolean a(String s1, dw.f f)
    {
        HashMap hashmap = pB;
        hashmap;
        JVM INSTR monitorenter ;
        a a1 = (a)pB.get(s1);
        if (a1 != null) goto _L2; else goto _L1
_L1:
        a1 = new a(s1);
        a1.a(f);
        f = (new Intent(s1)).setPackage("com.google.android.gms");
        a1.q(iT.bindService(f, a1.bU(), 129));
        pB.put(s1, a1);
        s1 = a1;
_L7:
        boolean flag = s1.isBound();
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        mHandler.removeMessages(0, a1);
        if (a1.c(f))
        {
            throw new IllegalStateException((new StringBuilder()).append("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=").append(s1).toString());
        }
        break MISSING_BLOCK_LABEL_147;
        s1;
        hashmap;
        JVM INSTR monitorexit ;
        throw s1;
        a1.a(f);
        a1.getState();
        JVM INSTR tableswitch 1 2: default 235
    //                   1 180
    //                   2 197;
           goto _L3 _L4 _L5
_L4:
        f.onServiceConnected(a1.getComponentName(), a1.getBinder());
        s1 = a1;
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = (new Intent(s1)).setPackage("com.google.android.gms");
        a1.q(iT.bindService(s1, a1.bU(), 129));
        s1 = a1;
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = a1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void b(String s1, dw.f f)
    {
        HashMap hashmap = pB;
        hashmap;
        JVM INSTR monitorenter ;
        a a1 = (a)pB.get(s1);
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        throw new IllegalStateException((new StringBuilder()).append("Nonexistent connection status for service action: ").append(s1).toString());
        s1;
        hashmap;
        JVM INSTR monitorexit ;
        throw s1;
        if (!a1.c(f))
        {
            throw new IllegalStateException((new StringBuilder()).append("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=").append(s1).toString());
        }
        a1.b(f);
        if (a1.bW())
        {
            s1 = mHandler.obtainMessage(0, a1);
            mHandler.sendMessageDelayed(s1, 5000L);
        }
        hashmap;
        JVM INSTR monitorexit ;
    }

    public boolean handleMessage(Message message)
    {
        a a1;
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            a1 = (a)message.obj;
            break;
        }
        synchronized (pB)
        {
            if (a1.bW())
            {
                iT.unbindService(a1.bU());
                pB.remove(a1.bV());
            }
        }
        return true;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
