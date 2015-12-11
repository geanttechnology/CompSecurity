// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;


// Referenced classes of package c.a.a.a.a.c:
//            h

final class i
    implements Runnable
{

    private Runnable a;
    private h b;

    i(h h1, Runnable runnable)
    {
        b = h1;
        a = runnable;
        super();
    }

    public final void run()
    {
        a.run();
        b.a();
        return;
        Exception exception;
        exception;
        b.a();
        throw exception;
    }
}
