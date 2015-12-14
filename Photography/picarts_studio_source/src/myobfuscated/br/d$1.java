// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;


// Referenced classes of package myobfuscated.br:
//            d

final class it>
    implements Runnable
{

    private Runnable a;

    public final void run()
    {
        if (a != null)
        {
            a.run();
        }
    }

    (Runnable runnable)
    {
        a = runnable;
        super();
    }
}
