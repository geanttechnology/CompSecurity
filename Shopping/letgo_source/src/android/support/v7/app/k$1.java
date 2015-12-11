// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;


// Referenced classes of package android.support.v7.app:
//            k

class a
    implements Runnable
{

    final k a;

    public void run()
    {
        if ((k.a(a) & 1) != 0)
        {
            k.a(a, 0);
        }
        if ((k.a(a) & 0x100) != 0)
        {
            k.a(a, 8);
        }
        k.a(a, false);
        k.b(a, 0);
    }

    (k k1)
    {
        a = k1;
        super();
    }
}
