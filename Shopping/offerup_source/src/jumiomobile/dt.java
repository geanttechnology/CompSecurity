// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            dm, dy, ao, g, 
//            dz

class dt
    implements Runnable
{

    final dz a;
    final dm b;

    dt(dm dm1, dz dz)
    {
        b = dm1;
        a = dz;
        super();
    }

    public void run()
    {
label0:
        {
            synchronized (b.I)
            {
                if (b.z != null && b.p != null && b.D != null)
                {
                    break label0;
                }
            }
            return;
        }
        b.A.presentError(a, b.D, b.C);
        b.A.prepareBlurView(b.q.f());
        b.A.showBlurView();
        b.p.d(true);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
