// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;


// Referenced classes of package android.support.v7.a:
//            l

final class a
    implements Runnable
{

    final l a;

    public final void run()
    {
        if ((a.t & 1) != 0)
        {
            l.a(a, 0);
        }
        if ((a.t & 0x100) != 0)
        {
            l.a(a, 8);
        }
        a.s = false;
        a.t = 0;
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
