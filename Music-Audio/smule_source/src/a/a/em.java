// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            ei, eh, df, y, 
//            ek

public final class em
{

    private eh a;
    private ek b;

    public em()
    {
    }

    public final ek a()
    {
        this;
        JVM INSTR monitorenter ;
        ek ek1 = b;
        this;
        JVM INSTR monitorexit ;
        return ek1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(y y1)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        a = ei.a(y1);
        if (a.a())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        j = y1.b(df.j.a(), df.j.b());
        int i;
        i = j;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        i = y1.b(df.k.a(), df.k.b());
        y1 = new ek(i);
        y1.a = ((ek) (y1)).a + 1;
        b = y1;
        this;
        JVM INSTR monitorexit ;
        return;
        y1;
        throw y1;
    }

    public final boolean b()
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
