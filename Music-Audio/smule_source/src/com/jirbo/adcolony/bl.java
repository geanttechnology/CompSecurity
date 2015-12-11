// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, ap

class bl
{

    static bl a = new bl(0, false);
    static bl b = new bl(1, false);
    static bl c = new bl(2, true);
    static bl d = new bl(3, true);
    int e;
    boolean f;
    StringBuilder g;

    bl(int i, boolean flag)
    {
        g = new StringBuilder();
        e = i;
        f = flag;
    }

    bl a(char c1)
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
        ak.a(e, g.toString());
        g.setLength(0);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    bl a(double d1)
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
        ap.a(d1, 2, g);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    bl a(int i)
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

    bl a(Object obj)
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

    bl a(String s)
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
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        g.append("null");
        break; /* Loop/switch isn't completed */
        int j = s.length();
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        a(s.charAt(i));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        s;
        throw s;
    }

    bl a(boolean flag)
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

    bl b(double d1)
    {
        this;
        JVM INSTR monitorenter ;
        bl bl1;
        a(d1);
        bl1 = a('\n');
        this;
        JVM INSTR monitorexit ;
        return bl1;
        Exception exception;
        exception;
        throw exception;
    }

    bl b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        bl bl1;
        a(i);
        bl1 = a('\n');
        this;
        JVM INSTR monitorexit ;
        return bl1;
        Exception exception;
        exception;
        throw exception;
    }

    bl b(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        a(obj);
        obj = a('\n');
        this;
        JVM INSTR monitorexit ;
        return ((bl) (obj));
        obj;
        throw obj;
    }

    bl b(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        bl bl1;
        a(flag);
        bl1 = a('\n');
        this;
        JVM INSTR monitorexit ;
        return bl1;
        Exception exception;
        exception;
        throw exception;
    }

    boolean b(String s)
    {
        a((new StringBuilder()).append(s).append('\n').toString());
        return false;
    }

    int c(String s)
    {
        a((new StringBuilder()).append(s).append('\n').toString());
        return 0;
    }

}
