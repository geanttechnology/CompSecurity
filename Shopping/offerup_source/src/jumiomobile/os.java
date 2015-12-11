// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            ox, ot, pz, oq, 
//            pw, pv, po, pm, 
//            pn, pu, pr, pt, 
//            ps, ou, ov, oy, 
//            oz, ow, pa, ph, 
//            pg, pb, pe, pd, 
//            pc, pf, or

public class os
{

    private static HashMap a;
    private static List b = new ArrayList();
    private static List c = new ArrayList();

    public static pz a(ox ox1)
    {
        Object obj = ox1.a();
        obj = (ConcurrentLinkedQueue)a.get(obj);
        if (obj != null)
        {
            return ox1.a(((ConcurrentLinkedQueue) (obj)));
        } else
        {
            return null;
        }
    }

    public static void a()
    {
        a.clear();
        b();
    }

    public static void a(File file, String s)
    {
        file = new ot(file);
        c.add(file);
        List list = c();
        list.add(new pz("ScanReference", s));
        for (s = c.iterator(); s.hasNext(); ((oq)s.next()).a(list)) { }
        c.remove(file);
    }

    public static void a(String s)
    {
        List list = c();
        list.add(new pz("ScanReference", s));
        for (s = c.iterator(); s.hasNext(); ((oq)s.next()).a(list)) { }
    }

    public static void a(or or)
    {
        jumiomobile/os;
        JVM INSTR monitorenter ;
        Class class1;
        ConcurrentLinkedQueue concurrentlinkedqueue;
        class1 = or.getClass();
        concurrentlinkedqueue = (ConcurrentLinkedQueue)a.get(class1);
        if (concurrentlinkedqueue == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (!class1.equals(jumiomobile/pw) || concurrentlinkedqueue.size() <= 0) goto _L2; else goto _L1
_L1:
        boolean flag = concurrentlinkedqueue.toArray()[concurrentlinkedqueue.size() - 1] instanceof pw;
        if (!flag) goto _L2; else goto _L3
_L3:
        jumiomobile/os;
        JVM INSTR monitorexit ;
        return;
_L2:
        concurrentlinkedqueue.add(or);
          goto _L3
        or;
        throw or;
        System.err.println((new StringBuilder("no event queue found for type ")).append(class1.getSimpleName()).toString());
          goto _L3
    }

    private static void b()
    {
        a = new HashMap();
        ConcurrentLinkedQueue concurrentlinkedqueue = new ConcurrentLinkedQueue();
        a.put(jumiomobile/pv, concurrentlinkedqueue);
        a.put(jumiomobile/po, concurrentlinkedqueue);
        a.put(jumiomobile/pw, concurrentlinkedqueue);
        a.put(jumiomobile/pm, new ConcurrentLinkedQueue());
        a.put(jumiomobile/pn, new ConcurrentLinkedQueue());
        a.put(jumiomobile/pu, new ConcurrentLinkedQueue());
        a.put(jumiomobile/pr, new ConcurrentLinkedQueue());
        a.put(jumiomobile/pt, new ConcurrentLinkedQueue());
        a.put(jumiomobile/ps, new ConcurrentLinkedQueue());
    }

    private static List c()
    {
        Vector vector = new Vector();
        vector.add(a(new ou()));
        vector.add(a(new ov()));
        vector.add(a(new oy()));
        vector.add(a(new oz()));
        vector.add(a(new ow()));
        vector.add(a(new pa()));
        vector.add(a(new ph()));
        vector.add(a(new pg()));
        vector.add(a(new pb()));
        vector.add(a(new pe()));
        vector.add(a(new pd()));
        vector.add(a(new pc()));
        vector.add(a(new pf()));
        for (Iterator iterator = b.iterator(); iterator.hasNext(); vector.add(a((ox)iterator.next()))) { }
        return vector;
    }

    static 
    {
        b();
    }
}
