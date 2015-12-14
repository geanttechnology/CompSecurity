// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.flurry.sdk:
//            io, ij, ir, ik, 
//            il, kg, lt

public class in
{

    private static final String a = com/flurry/sdk/io.getName();
    private long b;
    private long c;
    private long d;
    private ir e;
    private boolean f;
    private int g;
    private String h;
    private int i;
    private AtomicInteger j;
    private Map k;

    public in(String s, boolean flag, long l, long l1, ir ir1, 
            Map map)
    {
        h = s;
        f = flag;
        b = l;
        d = l1;
        e = ir1;
        c = System.currentTimeMillis();
        k = map;
        if (map != null)
        {
            for (s = map.keySet().iterator(); s.hasNext(); ((ij)map.get(s.next())).a(this)) { }
            i = map.size();
        } else
        {
            i = 0;
        }
        j = new AtomicInteger(0);
    }

    static int a(in in1, int l)
    {
        in1.g = l;
        return l;
    }

    static long a(in in1)
    {
        return in1.b;
    }

    static long a(in in1, long l)
    {
        in1.c = l;
        return l;
    }

    static Map a(in in1, Map map)
    {
        in1.k = map;
        return map;
    }

    static AtomicInteger a(in in1, AtomicInteger atomicinteger)
    {
        in1.j = atomicinteger;
        return atomicinteger;
    }

    static int b(in in1, int l)
    {
        in1.i = l;
        return l;
    }

    static long b(in in1)
    {
        return in1.c;
    }

    static long c(in in1)
    {
        return in1.d;
    }

    static ir d(in in1)
    {
        return in1.e;
    }

    static boolean e(in in1)
    {
        return in1.f;
    }

    static int f(in in1)
    {
        return in1.g;
    }

    static String g(in in1)
    {
        return in1.h;
    }

    static int h(in in1)
    {
        return in1.i;
    }

    static AtomicInteger i(in in1)
    {
        return in1.j;
    }

    static Map j(in in1)
    {
        return in1.k;
    }

    public int a()
    {
        return g;
    }

    public void a(int l)
    {
        g = l;
    }

    public long b()
    {
        return b;
    }

    public String c()
    {
        return h;
    }

    public List d()
    {
        if (k != null)
        {
            return new ArrayList(k.values());
        } else
        {
            return Collections.emptyList();
        }
    }

    public Map e()
    {
        return k;
    }

    public boolean f()
    {
        this;
        JVM INSTR monitorenter ;
        int l;
        int i1;
        l = j.intValue();
        i1 = i;
        boolean flag;
        if (l >= i1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        j.incrementAndGet();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public byte[] h()
    {
        Object obj = null;
        Object obj1;
        Object obj2;
        obj2 = new ByteArrayOutputStream();
        obj1 = new DataOutputStream(((java.io.OutputStream) (obj2)));
        ((DataOutputStream) (obj1)).writeShort(e.a());
        ((DataOutputStream) (obj1)).writeLong(b);
        ((DataOutputStream) (obj1)).writeLong(d);
        ((DataOutputStream) (obj1)).writeBoolean(f);
        if (f)
        {
            ((DataOutputStream) (obj1)).writeShort(g);
            ((DataOutputStream) (obj1)).writeUTF(h);
        }
        ((DataOutputStream) (obj1)).writeShort(k.size());
        if (k != null)
        {
            for (obj = k.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
            {
                Object obj3 = (java.util.Map.Entry)((Iterator) (obj)).next();
                ij ij1 = (ij)((java.util.Map.Entry) (obj3)).getValue();
                ((DataOutputStream) (obj1)).writeLong(((Long)((java.util.Map.Entry) (obj3)).getKey()).longValue());
                ((DataOutputStream) (obj1)).writeUTF(ij1.t());
                ((DataOutputStream) (obj1)).writeShort(ij1.a.size());
                obj3 = ij1.a.iterator();
                while (((Iterator) (obj3)).hasNext()) 
                {
                    ik ik1 = (ik)((Iterator) (obj3)).next();
                    ((DataOutputStream) (obj1)).writeShort(ik1.a);
                    ((DataOutputStream) (obj1)).writeLong(ik1.b);
                    ((DataOutputStream) (obj1)).writeLong(ik1.c);
                    ((DataOutputStream) (obj1)).writeBoolean(ik1.d);
                    ((DataOutputStream) (obj1)).writeShort(ik1.e);
                    ((DataOutputStream) (obj1)).writeShort(ik1.f.a());
                    if ((ik1.e < 200 || ik1.e >= 400) && ik1.g != null)
                    {
                        byte abyte0[] = ik1.g.getBytes();
                        ((DataOutputStream) (obj1)).writeShort(abyte0.length);
                        ((DataOutputStream) (obj1)).write(abyte0);
                    }
                    ((DataOutputStream) (obj1)).writeShort(ik1.h);
                    ((DataOutputStream) (obj1)).writeInt((int)ik1.k);
                }
            }

        }
          goto _L1
        obj2;
        obj = obj1;
        obj1 = obj2;
_L5:
        kg.a(6, a, "Error when generating report", ((Throwable) (obj1)));
        throw obj1;
        obj2;
        obj1 = obj;
        obj = obj2;
_L3:
        lt.a(((java.io.Closeable) (obj1)));
        throw obj;
_L1:
        obj = ((ByteArrayOutputStream) (obj2)).toByteArray();
        lt.a(((java.io.Closeable) (obj1)));
        return ((byte []) (obj));
        obj;
        obj1 = null;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        obj1;
        if (true) goto _L5; else goto _L4
_L4:
    }

}
