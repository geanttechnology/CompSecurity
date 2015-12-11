// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.ConditionVariable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public final class ata
    implements ass
{

    final File a;
    private final ast b;
    private final HashMap c = new HashMap();
    private final HashMap d = new HashMap();
    private final HashMap e = new HashMap();
    private long f;

    public ata(File file, ast ast1)
    {
        f = 0L;
        a = file;
        b = ast1;
        file = new ConditionVariable();
        (new atb(this, file)).start();
        file.block();
    }

    private void b()
    {
        Iterator iterator = d.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Iterator iterator1 = ((TreeSet)((java.util.Map.Entry)iterator.next()).getValue()).iterator();
            boolean flag = true;
            while (iterator1.hasNext()) 
            {
                asy asy1 = (asy)iterator1.next();
                if (!asy1.e.exists())
                {
                    iterator1.remove();
                    if (asy1.d)
                    {
                        f = f - asy1.c;
                    }
                    f(asy1);
                } else
                {
                    flag = false;
                }
            }
            if (flag)
            {
                iterator.remove();
            }
        } while (true);
    }

    private asy d(asy asy1)
    {
        this;
        JVM INSTR monitorenter ;
        asy asy2 = e(asy1);
        if (!asy2.d) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (TreeSet)d.get(asy2.a);
        a.b(((TreeSet) (obj)).remove(asy2));
        long l = System.currentTimeMillis();
        asy1 = asy.a(asy2.e.getParentFile(), asy2.a, asy2.b, l);
        asy2.e.renameTo(asy1);
        asy1 = asy.a(asy2.a, asy2.b, l, asy1);
        ((TreeSet) (obj)).add(asy1);
        obj = (ArrayList)e.get(asy2.a);
        if (obj == null) goto _L4; else goto _L3
_L3:
        int i = ((ArrayList) (obj)).size() - 1;
_L5:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ast)((ArrayList) (obj)).get(i)).a(this, asy2, asy1);
        i--;
        if (true) goto _L5; else goto _L4
_L4:
        b.a(this, asy2, asy1);
_L7:
        this;
        JVM INSTR monitorexit ;
        return asy1;
_L2:
        if (c.containsKey(asy1.a))
        {
            break MISSING_BLOCK_LABEL_200;
        }
        c.put(asy1.a, asy2);
        asy1 = asy2;
        continue; /* Loop/switch isn't completed */
        asy1 = null;
        if (true) goto _L7; else goto _L6
_L6:
        asy1;
        throw asy1;
    }

    private asy e(asy asy1)
    {
_L6:
        Object obj;
        TreeSet treeset;
        long l;
        obj = asy1.a;
        l = asy1.b;
        treeset = (TreeSet)d.get(obj);
        if (treeset != null) goto _L2; else goto _L1
_L1:
        obj = asy.b(((String) (obj)), asy1.b);
_L4:
        return ((asy) (obj));
_L2:
        asy asy2;
        asy2 = (asy)treeset.floor(asy1);
        if (asy2 == null || asy2.b > l || l >= asy2.b + asy2.c)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = asy2;
        if (asy2.e.exists()) goto _L4; else goto _L3
_L3:
        b();
        if (true) goto _L6; else goto _L5
_L5:
        asy asy3 = (asy)treeset.ceiling(asy1);
        if (asy3 == null)
        {
            return asy.b(((String) (obj)), asy1.b);
        } else
        {
            return asy.a(((String) (obj)), asy1.b, asy3.b - asy1.b);
        }
    }

    private void f(asy asy1)
    {
        ArrayList arraylist = (ArrayList)e.get(asy1.a);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((ast)arraylist.get(i)).a(asy1);
            }

        }
        b.a(asy1);
    }

    private void g(asy asy1)
    {
        ArrayList arraylist = (ArrayList)e.get(asy1.a);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((ast)arraylist.get(i)).a(this, asy1);
            }

        }
        b.a(this, asy1);
    }

    public final long a()
    {
        this;
        JVM INSTR monitorenter ;
        long l = f;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final asy a(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = asy.a(s, l);
_L1:
        asy asy1 = d(s);
        if (asy1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        this;
        JVM INSTR monitorexit ;
        return asy1;
        wait();
          goto _L1
        s;
        throw s;
    }

    public final File a(String s, long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        a.b(c.containsKey(s));
        if (!a.exists())
        {
            b();
            a.mkdirs();
        }
        b.a(this, l1);
        s = asy.a(a, s, l, System.currentTimeMillis());
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final void a(asy asy1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (asy1 == c.remove(asy1.a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        asy1;
        throw asy1;
    }

    public final void a(File file)
    {
        this;
        JVM INSTR monitorenter ;
        asy asy1 = asy.a(file);
        boolean flag;
        if (asy1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        a.b(c.containsKey(asy1.a));
        flag = file.exists();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (file.length() != 0L)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        file.delete();
          goto _L1
        file;
        throw file;
        c(asy1);
        notifyAll();
          goto _L1
    }

    public final asy b(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = d(asy.a(s, l));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final void b(asy asy1)
    {
        this;
        JVM INSTR monitorenter ;
        TreeSet treeset = (TreeSet)d.get(asy1.a);
        f = f - asy1.c;
        a.b(treeset.remove(asy1));
        asy1.e.delete();
        if (treeset.isEmpty())
        {
            d.remove(asy1.a);
        }
        f(asy1);
        this;
        JVM INSTR monitorexit ;
        return;
        asy1;
        throw asy1;
    }

    public final boolean b(String s, long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = (TreeSet)d.get(s);
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        s = (asy)((TreeSet) (obj)).floor(asy.a(s, l));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        if (((asy) (s)).b + ((asy) (s)).c <= l)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        l1 = l + l1;
        l = ((asy) (s)).b + ((asy) (s)).c;
        if (l >= l1)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        s = ((TreeSet) (obj)).tailSet(s, false).iterator();
_L3:
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_177;
        }
        obj = (asy)s.next();
        if (((asy) (obj)).b > l)
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        long l2 = ((asy) (obj)).b;
        l = Math.max(l, ((asy) (obj)).c + l2);
        if (l >= l1)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
        flag = false;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    void c(asy asy1)
    {
        TreeSet treeset1 = (TreeSet)d.get(asy1.a);
        TreeSet treeset = treeset1;
        if (treeset1 == null)
        {
            treeset = new TreeSet();
            d.put(asy1.a, treeset);
        }
        treeset.add(asy1);
        f = f + asy1.c;
        g(asy1);
    }
}
