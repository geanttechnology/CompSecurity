// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;


// Referenced classes of package c.a.a.a.a.b:
//            k, u

final class v extends k
{

    private Runnable a;

    v(u u, Runnable runnable)
    {
        a = runnable;
        super();
    }

    public final void onRun()
    {
        a.run();
    }
}
