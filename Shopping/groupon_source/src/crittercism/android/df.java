// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            db, cb, aw, dd, 
//            dc

public final class df
{

    private db a;
    private dc b;
    private dd c;

    public df()
    {
    }

    public final dc a()
    {
        this;
        JVM INSTR monitorenter ;
        dc dc1 = b;
        this;
        JVM INSTR monitorexit ;
        return dc1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(aw aw1)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        a = db.a.a(aw1);
        if (a.a())
        {
            break MISSING_BLOCK_LABEL_123;
        }
        j = aw1.b(cb.k.a(), cb.k.b());
        int i;
        i = j;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        i = aw1.b(cb.l.a(), cb.l.b());
        dd dd1 = new dd(i);
        dd1.a = dd1.a + 1;
        c = dd1;
        aw1 = dc.a.a(aw1, cb.h.a(), cb.h.b());
        aw1.c = ((dc) (aw1)).c + 1;
        b = aw1;
        this;
        JVM INSTR monitorexit ;
        return;
        aw1;
        throw aw1;
    }

    public final void a(dc dc1)
    {
        this;
        JVM INSTR monitorenter ;
        b = dc1;
        this;
        JVM INSTR monitorexit ;
        return;
        dc1;
        throw dc1;
    }

    public final dd b()
    {
        this;
        JVM INSTR monitorenter ;
        dd dd1 = c;
        this;
        JVM INSTR monitorexit ;
        return dd1;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = true;
        if (a != null)
        {
            flag = a.a();
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
