// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            ns, vn

public class nt
{

    boolean a;
    private final List b = new LinkedList();
    private final Map c = new LinkedHashMap();
    private final Object d = new Object();
    private String e;
    private ns f;

    public nt(boolean flag, String s, String s1)
    {
        a = flag;
        c.put("action", s);
        c.put("ad_format", s1);
    }

    private transient boolean a(ns ns1, long l, String as[])
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        int j = as.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ns ns2 = new ns(l, as[i], ns1);
        b.add(ns2);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorexit ;
        return true;
        ns1;
        obj;
        JVM INSTR monitorexit ;
        throw ns1;
    }

    public ns a()
    {
        return a(zzp.zzbB().b());
    }

    public ns a(long l)
    {
        if (!a)
        {
            return null;
        } else
        {
            return new ns(l, null, null);
        }
    }

    public void a(String s)
    {
        if (!a)
        {
            return;
        }
        synchronized (d)
        {
            e = s;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(String s, String s1)
    {
        if (!a)
        {
            return;
        }
        synchronized (d)
        {
            c.put(s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public transient boolean a(ns ns1, String as[])
    {
        if (!a || ns1 == null)
        {
            return false;
        } else
        {
            return a(ns1, zzp.zzbB().b(), as);
        }
    }

    public void b()
    {
        synchronized (d)
        {
            f = a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String c()
    {
        Object obj1 = new StringBuilder();
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = b.iterator();
_L2:
        String s;
        ns ns1;
        long l;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_118;
            }
            ns1 = (ns)iterator.next();
            l = ns1.a();
            s = ns1.b();
            ns1 = ns1.c();
        } while (ns1 == null || l <= 0L);
        long l1 = ns1.a();
        ((StringBuilder) (obj1)).append(s).append('.').append(l - l1).append(',');
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        b.clear();
        if (TextUtils.isEmpty(e)) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj1)).append(e);
_L6:
        obj1 = ((StringBuilder) (obj1)).toString();
        obj;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
_L4:
        if (((StringBuilder) (obj1)).length() <= 0) goto _L6; else goto _L5
_L5:
        ((StringBuilder) (obj1)).setLength(((StringBuilder) (obj1)).length() - 1);
          goto _L6
    }

    Map d()
    {
        Map map;
        synchronized (d)
        {
            map = c;
        }
        return map;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ns e()
    {
        ns ns1;
        synchronized (d)
        {
            ns1 = f;
        }
        return ns1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
