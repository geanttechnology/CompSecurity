// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;


// Referenced classes of package e.g:
//            b

final class c
    implements Runnable
{

    private b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public final void run()
    {
        a.b();
    }
}
