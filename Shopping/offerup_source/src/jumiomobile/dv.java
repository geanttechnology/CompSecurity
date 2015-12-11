// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            dm, g

class dv
    implements Runnable
{

    final boolean a;
    final boolean b;
    final dm c;

    dv(dm dm1, boolean flag, boolean flag1)
    {
        c = dm1;
        a = flag;
        b = flag1;
        super();
    }

    public void run()
    {
        synchronized (c.H)
        {
            if (c.p != null)
            {
                c.p.b(a);
                if (b)
                {
                    c.p.j();
                }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
