// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class lang.Object
    implements Runnable
{

    final vx a;
    final vy b;

    public void run()
    {
label0:
        {
            synchronized (vy.a(b))
            {
                if (vy.b(b) == -2)
                {
                    break label0;
                }
            }
            return;
        }
        vy.a(b, vy.c(b));
        if (vy.d(b) != null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        b.a(4);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        a.a(b);
        vy.a(b, a);
        obj;
        JVM INSTR monitorexit ;
    }

    >(vy vy1, vx vx1)
    {
        b = vy1;
        a = vx1;
        super();
    }
}
