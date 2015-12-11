// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.clientlib.impl.livenessAndTM.FrameProcessingSettingsTemplateMatcher;
import com.jumio.clientlib.impl.livenessAndTM.FrameProcessorTemplateMatcher;
import com.jumio.clientlib.impl.livenessAndTM.HierarchicalClusteringSettings;
import com.jumio.netverify.sdk.core.ModelTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

// Referenced classes of package jumiomobile:
//            jj, jk, hk, an, 
//            pk, pj, ka, ke, 
//            ht, ii, av, ab, 
//            jl

class jq
    implements Runnable
{

    final jk a;

    private jq(jk jk1)
    {
        a = jk1;
        super();
    }

    jq(jk jk1, jl jl)
    {
        this(jk1);
    }

    public void run()
    {
        Object obj = jk.l(a);
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        Object obj3;
        obj1 = new HierarchicalClusteringSettings();
        obj3 = ((pk)hk.d().a(jk.m(a), "BenchmarkService")).c();
        if (obj3 != pj.c) goto _L2; else goto _L1
_L1:
        jk.a(a, 15);
_L8:
        int j;
        int i = jk.n(a);
        j = jk.n(a);
        obj1 = new FrameProcessingSettingsTemplateMatcher(500, true, ((HierarchicalClusteringSettings) (obj1)), i, j);
        jk.a(a, new ka(jk.o(a)));
        jk.a(a, new FrameProcessorTemplateMatcher(((FrameProcessingSettingsTemplateMatcher) (obj1)), jk.p(a)));
        obj2 = jk.q(a).f();
        obj3 = ((ke)hk.d().a(jk.r(a), "TemplateDatabaseService")).c(((com.jumio.netverify.sdk.core.vo.Country) (obj2)), jk.s(a).v).iterator();
_L7:
        if (!((Iterator) (obj3)).hasNext()) goto _L4; else goto _L3
_L3:
        String s = (String)((Iterator) (obj3)).next();
        if (jk.j(a).addTemplatesFromBinaryFile(s)) goto _L6; else goto _L5
_L5:
        jk.t(a).a(ht.l);
        av.b(s);
        jk.u(a).shutdownNow();
        ab.e("TemplateMatcher", (new StringBuilder("Could not push file ")).append(s).append(" to template matcher").toString());
          goto _L7
        obj2;
        ab.e("TemplateMatcher", ((jj) (obj2)).getMessage());
        jk.a(a, true);
        System.gc();
        synchronized (jk.v(a))
        {
            ab.a("Lifecycle", (new StringBuilder("LoadingTask: done (N=")).append(j).append(")").toString());
            jk.v(a).notifyAll();
        }
        synchronized (a)
        {
            jk.b(a, false);
        }
_L9:
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (obj3 != pj.b)
        {
            break MISSING_BLOCK_LABEL_403;
        }
        jk.a(a, 10);
          goto _L8
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        jk.a(a, 7);
          goto _L8
_L6:
        ab.c("TemplateMatcher", (new StringBuilder("pushed template ")).append(obj2).append(" to template matcher").toString());
          goto _L7
        obj2;
        jk.a(a, true);
        System.gc();
        synchronized (jk.v(a))
        {
            ab.a("Lifecycle", (new StringBuilder("LoadingTask: done (N=")).append(j).append(")").toString());
            jk.v(a).notifyAll();
        }
        synchronized (a)
        {
            jk.b(a, false);
        }
        throw obj2;
_L4:
        jk.a(a, true);
        System.gc();
        synchronized (jk.v(a))
        {
            ab.a("Lifecycle", (new StringBuilder("LoadingTask: done (N=")).append(j).append(")").toString());
            jk.v(a).notifyAll();
        }
        synchronized (a)
        {
            jk.b(a, false);
        }
          goto _L9
        obj4;
        obj2;
        JVM INSTR monitorexit ;
        throw obj4;
        obj4;
        obj2;
        JVM INSTR monitorexit ;
        throw obj4;
        obj4;
        obj2;
        JVM INSTR monitorexit ;
        throw obj4;
        obj4;
        obj2;
        JVM INSTR monitorexit ;
        throw obj4;
        exception;
        obj4;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj4;
        JVM INSTR monitorexit ;
        throw exception1;
          goto _L7
    }
}
