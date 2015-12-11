// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            fc

final class fd
    implements Runnable
{

    private boolean a;
    private boolean b;
    private fc c;

    public fd(fc fc1)
    {
        b = false;
        c = fc1;
        a = true;
    }

    public final boolean a()
    {
        return b;
    }

    public final void run()
    {
        if (a)
        {
            b = c.c();
            return;
        } else
        {
            c.b();
            return;
        }
    }
}
