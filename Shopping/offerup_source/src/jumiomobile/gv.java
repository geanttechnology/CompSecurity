// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            gs, mu

class gv
    implements Runnable
{

    final gs a;

    gv(gs gs1)
    {
        a = gs1;
        super();
    }

    public void run()
    {
        if (a.a instanceof mu)
        {
            ((mu)a.a).a(false, false, false, false);
        }
    }
}
