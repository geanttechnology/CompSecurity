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

public final class ej
    implements android.os.Handler.Callback
{
    final class a
    {

        private final String BT;
        private final a BU = new a(this);
        private final HashSet BV = new HashSet();
        private boolean BW;
        private IBinder BX;
        private ComponentName BY;
        final ej BZ;
        private int mState;

        static int a(a a1, int i)
        {
            a1.mState = i;
            return i;
        }

        static ComponentName a(a a1, ComponentName componentname)
        {
            a1.BY = componentname;
            return componentname;
        }

        static IBinder a(a a1, IBinder ibinder)
        {
            a1.BX = ibinder;
            return ibinder;
        }

        static HashSet a(a a1)
        {
            return a1.BV;
        }

        public void a(eh.f f)
        {
            BV.add(f);
        }

        public void b(eh.f f)
        {
            BV.remove(f);
        }

        public boolean c(eh.f f)
        {
            return BV.contains(f);
        }

        public a ee()
        {
            return BU;
        }

        public String ef()
        {
            return BT;
        }

        public boolean eg()
        {
            return BV.isEmpty();
        }

        public IBinder getBinder()
        {
            return BX;
        }

        public ComponentName getComponentName()
        {
            return BY;
        }

        public int getState()
        {
            return mState;
        }

        public boolean isBound()
        {
            return BW;
        }

        public void w(boolean flag)
        {
            BW = flag;
        }

        public a(String s)
        {
            BZ = ej.this;
            super();
            BT = s;
            mState = 0;
        }
    }

    public class a.a
        implements ServiceConnection
    {

        final a Ca;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            HashMap hashmap = ej.a(Ca.BZ);
            hashmap;
            JVM INSTR monitorenter ;
            a.a(Ca, ibinder);
            a.a(Ca, componentname);
            for (Iterator iterator = a.a(Ca).iterator(); iterator.hasNext(); ((eh.f)iterator.next()).onServiceConnected(componentname, ibinder)) { }
            break MISSING_BLOCK_LABEL_76;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.a(Ca, 1);
            hashmap;
            JVM INSTR monitorexit ;
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            HashMap hashmap = ej.a(Ca.BZ);
            hashmap;
            JVM INSTR monitorenter ;
            a.a(Ca, null);
            a.a(Ca, componentname);
            for (Iterator iterator = a.a(Ca).iterator(); iterator.hasNext(); ((eh.f)iterator.next()).onServiceDisconnected(componentname)) { }
            break MISSING_BLOCK_LABEL_72;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.a(Ca, 2);
            hashmap;
            JVM INSTR monitorexit ;
        }

        public a.a(a a1)
        {
            Ca = a1;
            super();
        }
    }


    private static final Object BQ = new Object();
    private static ej BR;
    private final HashMap BS = new HashMap();
    private final Handler mHandler;
    private final Context qe;

    private ej(Context context)
    {
        mHandler = new Handler(context.getMainLooper(), this);
        qe = context.getApplicationContext();
    }

    static HashMap a(ej ej1)
    {
        return ej1.BS;
    }

    public static ej y(Context context)
    {
        synchronized (BQ)
        {
            if (BR == null)
            {
                BR = new ej(context.getApplicationContext());
            }
        }
        return BR;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public boolean a(String s, eh.f f)
    {
        HashMap hashmap = BS;
        hashmap;
        JVM INSTR monitorenter ;
        a a1 = (a)BS.get(s);
        if (a1 != null) goto _L2; else goto _L1
_L1:
        a1 = new a(s);
        a1.a(f);
        f = (new Intent(s)).setPackage("com.google.android.gms");
        a1.w(qe.bindService(f, a1.ee(), 129));
        BS.put(s, a1);
        s = a1;
_L7:
        boolean flag = s.isBound();
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        mHandler.removeMessages(0, a1);
        if (a1.c(f))
        {
            throw new IllegalStateException((new StringBuilder()).append("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_147;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        a1.a(f);
        a1.getState();
        JVM INSTR tableswitch 1 2: default 235
    //                   1 180
    //                   2 197;
           goto _L3 _L4 _L5
_L4:
        f.onServiceConnected(a1.getComponentName(), a1.getBinder());
        s = a1;
        continue; /* Loop/switch isn't completed */
_L5:
        s = (new Intent(s)).setPackage("com.google.android.gms");
        a1.w(qe.bindService(s, a1.ee(), 129));
        s = a1;
        continue; /* Loop/switch isn't completed */
_L3:
        s = a1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void b(String s, eh.f f)
    {
        HashMap hashmap = BS;
        hashmap;
        JVM INSTR monitorenter ;
        a a1 = (a)BS.get(s);
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        throw new IllegalStateException((new StringBuilder()).append("Nonexistent connection status for service action: ").append(s).toString());
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        if (!a1.c(f))
        {
            throw new IllegalStateException((new StringBuilder()).append("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=").append(s).toString());
        }
        a1.b(f);
        if (a1.eg())
        {
            s = mHandler.obtainMessage(0, a1);
            mHandler.sendMessageDelayed(s, 5000L);
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
        synchronized (BS)
        {
            if (a1.eg())
            {
                qe.unbindService(a1.ee());
                BS.remove(a1.ef());
            }
        }
        return true;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
