// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            dy

final class mState
{
    public class a
        implements ServiceConnection
    {

        final dy.a pJ;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            java.util.HashMap hashmap = dy.a(pJ.pI);
            hashmap;
            JVM INSTR monitorenter ;
            dy.a.a(pJ, ibinder);
            dy.a.a(pJ, componentname);
            for (Iterator iterator = dy.a.a(pJ).iterator(); iterator.hasNext(); ((dw.f)iterator.next()).onServiceConnected(componentname, ibinder)) { }
            break MISSING_BLOCK_LABEL_76;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            dy.a.a(pJ, 1);
            hashmap;
            JVM INSTR monitorexit ;
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            java.util.HashMap hashmap = dy.a(pJ.pI);
            hashmap;
            JVM INSTR monitorenter ;
            dy.a.a(pJ, null);
            dy.a.a(pJ, componentname);
            for (Iterator iterator = dy.a.a(pJ).iterator(); iterator.hasNext(); ((dw.f)iterator.next()).onServiceDisconnected(componentname)) { }
            break MISSING_BLOCK_LABEL_72;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            dy.a.a(pJ, 2);
            hashmap;
            JVM INSTR monitorexit ;
        }

        public a()
        {
            pJ = dy.a.this;
            super();
        }
    }


    private int mState;
    private final String pC;
    private final a pD = new a();
    private final HashSet pE = new HashSet();
    private boolean pF;
    private IBinder pG;
    private ComponentName pH;
    final dy pI;

    static int a(a.pJ pj, int i)
    {
        pj.mState = i;
        return i;
    }

    static ComponentName a(mState mstate, ComponentName componentname)
    {
        mstate.pH = componentname;
        return componentname;
    }

    static IBinder a(pH ph, IBinder ibinder)
    {
        ph.pG = ibinder;
        return ibinder;
    }

    static HashSet a(pG pg)
    {
        return pg.pE;
    }

    public void a(pE pe)
    {
        pE.add(pe);
    }

    public void b(pE pe)
    {
        pE.remove(pe);
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

    public boolean c(pE pe)
    {
        return pE.contains(pe);
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

    public a.pJ(dy dy1, String s)
    {
        pI = dy1;
        super();
        pC = s;
        mState = 0;
    }
}
