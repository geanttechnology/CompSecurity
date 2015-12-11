// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


// Referenced classes of package netswipe:
//            ai, bi

class aj
    implements Runnable
{

    final ai a;

    aj(ai ai1)
    {
        a = ai1;
        super();
    }

    public void run()
    {
        if (ai.a(a) != null)
        {
            ai.a(a).b();
        }
    }
}
