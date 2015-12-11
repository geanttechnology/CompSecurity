// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            q, s

public final class aj
{

    static aj a = new aj(0, false);
    static aj b = new aj(1, false);
    public static aj c = new aj(2, true);
    static aj d = new aj(3, true);
    int e;
    boolean f;
    StringBuilder g;

    private aj(int i, boolean flag)
    {
        g = new StringBuilder();
        e = i;
        f = flag;
    }

    private aj a(char c1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        g.append(c1);
        if (c1 != '\n')
        {
            continue; /* Loop/switch isn't completed */
        }
        q.a(e, g.toString());
        g.setLength(0);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final aj a(double d1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        s.a(d1, g);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final aj a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        g.append(i);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final aj a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!f) goto _L2; else goto _L1
_L1:
        if (obj != null) goto _L4; else goto _L3
_L3:
        a("null");
_L2:
        this;
        JVM INSTR monitorexit ;
        return this;
_L4:
        a(obj.toString());
        if (true) goto _L2; else goto _L5
_L5:
        obj;
        throw obj;
    }

    final aj a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        g.append("null");
        break; /* Loop/switch isn't completed */
        int j = s1.length();
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        a(s1.charAt(i));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        s1;
        throw s1;
    }

    final aj a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = f;
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        g.append(flag);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final aj b(double d1)
    {
        this;
        JVM INSTR monitorenter ;
        aj aj1;
        a(d1);
        aj1 = a('\n');
        this;
        JVM INSTR monitorexit ;
        return aj1;
        Exception exception;
        exception;
        throw exception;
    }

    final aj b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        aj aj1;
        a(i);
        aj1 = a('\n');
        this;
        JVM INSTR monitorexit ;
        return aj1;
        Exception exception;
        exception;
        throw exception;
    }

    public final aj b(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        a(obj);
        obj = a('\n');
        this;
        JVM INSTR monitorexit ;
        return ((aj) (obj));
        obj;
        throw obj;
    }

    final aj b(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        aj aj1;
        a(flag);
        aj1 = a('\n');
        this;
        JVM INSTR monitorexit ;
        return aj1;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean b(String s1)
    {
        a((new StringBuilder()).append(s1).append('\n').toString());
        return false;
    }

    final int c(String s1)
    {
        a((new StringBuilder()).append(s1).append('\n').toString());
        return 0;
    }

}
