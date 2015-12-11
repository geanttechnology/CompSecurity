// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


// Referenced classes of package netswipe:
//            ai, bi

class ak
    implements Runnable
{

    final ai a;

    ak(ai ai1)
    {
        a = ai1;
        super();
    }

    public void run()
    {
        ai.a(a).a();
    }
}
