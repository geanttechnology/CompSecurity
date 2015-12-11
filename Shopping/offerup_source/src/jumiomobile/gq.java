// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            gm, g

class gq
    implements Runnable
{

    final boolean a;
    final boolean b;
    final gm c;

    gq(gm gm1, boolean flag, boolean flag1)
    {
        c = gm1;
        a = flag;
        b = flag1;
        super();
    }

    public void run()
    {
        synchronized (c.r)
        {
            if (c.b != null)
            {
                c.b.b(a);
                if (b)
                {
                    c.b.j();
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
