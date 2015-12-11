// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            ci, bv, as, a, 
//            cc

public class d
{

    private final String a = "umeng_it.cache";
    private File b;
    private as c;
    private long d;
    private long e;
    private Set f;

    public d(Context context)
    {
        c = null;
        f = new HashSet();
        b = new File(context.getFilesDir(), "umeng_it.cache");
        e = 0x5265c00L;
    }

    private void a(as as1)
    {
        if (as1 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        this;
        JVM INSTR monitorenter ;
        as1 = (new ci()).a(as1);
        this;
        JVM INSTR monitorexit ;
        if (as1 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        bv.a(b, as1);
        return;
        as1;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw as1;
        }
        // Misplaced declaration of an exception variable
        catch (as as1)
        {
            as1.printStackTrace();
        }
        return;
    }

    private void g()
    {
        as as1;
        HashMap hashmap;
        ArrayList arraylist;
        Iterator iterator;
        as1 = new as();
        hashmap = new HashMap();
        arraylist = new ArrayList();
        iterator = f.iterator();
_L2:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        as1.a(arraylist);
        as1.a(hashmap);
        this;
        JVM INSTR monitorenter ;
        c = as1;
        this;
        JVM INSTR monitorexit ;
        return;
        a a1 = (a)iterator.next();
        if (a1.c())
        {
            if (a1.d() != null)
            {
                hashmap.put(a1.b(), a1.d());
            }
            if (a1.e() != null && !a1.e().isEmpty())
            {
                arraylist.addAll(a1.e());
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private as h()
    {
        if (!b.exists())
        {
            return null;
        }
        Object obj1 = new FileInputStream(b);
        Object obj = obj1;
        byte abyte0[] = bv.b(((java.io.InputStream) (obj1)));
        obj = obj1;
        as as1 = new as();
        obj = obj1;
        (new cc()).a(as1, abyte0);
        bv.c(((java.io.InputStream) (obj1)));
        return as1;
        Object obj2;
        obj2;
        obj1 = null;
_L4:
        obj = obj1;
        ((Exception) (obj2)).printStackTrace();
        bv.c(((java.io.InputStream) (obj1)));
        return null;
        obj;
        java.io.InputStream inputstream;
        inputstream = null;
        obj1 = obj;
_L2:
        bv.c(inputstream);
        throw obj1;
        obj1;
        inputstream = ((java.io.InputStream) (obj));
        if (true) goto _L2; else goto _L1
_L1:
        inputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a()
    {
        long l = System.currentTimeMillis();
        if (l - d < e) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        boolean flag;
        iterator = f.iterator();
        flag = false;
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (flag)
        {
            g();
            f();
        }
        d = l;
_L2:
        return;
_L4:
        a a1 = (a)iterator.next();
        if (!a1.c())
        {
            flag = true;
        } else
        if (a1.a())
        {
            flag = true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(long l)
    {
        e = l;
    }

    public void a(a a1)
    {
        f.add(a1);
    }

    public as b()
    {
        return c;
    }

    public String c()
    {
        return null;
    }

    public void d()
    {
        Iterator iterator = f.iterator();
        boolean flag = false;
        do
        {
            a a1;
            do
            {
                if (!iterator.hasNext())
                {
                    if (flag)
                    {
                        c.b(false);
                        f();
                    }
                    return;
                }
                a1 = (a)iterator.next();
            } while (!a1.c() || a1.e() == null || a1.e().isEmpty());
            a1.a(null);
            flag = true;
        } while (true);
    }

    public void e()
    {
        Object obj1;
        obj1 = h();
        if (obj1 == null)
        {
            return;
        }
        Object obj = new ArrayList(f.size());
        this;
        JVM INSTR monitorenter ;
        c = ((as) (obj1));
        obj1 = f.iterator();
_L3:
        if (((Iterator) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        obj = ((List) (obj)).iterator();
_L4:
        if (((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_117;
        }
        this;
        JVM INSTR monitorexit ;
        g();
        return;
_L2:
        a a2 = (a)((Iterator) (obj1)).next();
        a2.a(c);
        if (!a2.c())
        {
            ((List) (obj)).add(a2);
        }
          goto _L3
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        a a1 = (a)((Iterator) (obj)).next();
        f.remove(a1);
          goto _L4
    }

    public void f()
    {
        if (c != null)
        {
            a(c);
        }
    }
}
