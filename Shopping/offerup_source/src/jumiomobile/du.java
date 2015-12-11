// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            dm, g, ao, fl

class du
    implements Runnable
{

    final byte a[];
    final int b;
    final int c;
    final dm d;

    du(dm dm1, byte abyte0[], int i, int j)
    {
        d = dm1;
        a = abyte0;
        b = i;
        c = j;
        super();
    }

    public void run()
    {
        Object obj1 = d.H;
        obj1;
        JVM INSTR monitorenter ;
        if (d.p == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        Object obj;
        String s;
        if (d.p.c())
        {
            obj = "front";
        } else
        {
            obj = "back";
        }
        if (d.q.f())
        {
            s = "portrait";
        } else
        {
            s = "landscape";
        }
        d.o.a(d.k, a, b, c, ((String) (obj)), s, d.p.f(), Boolean.toString(d.p.d()));
        dm.a(d, "cardDetection", System.currentTimeMillis() - d.y);
        obj1;
        JVM INSTR monitorexit ;
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
