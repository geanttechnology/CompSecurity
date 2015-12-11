// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;


// Referenced classes of package android.support.v4.widget:
//            w

final class x
    implements Runnable
{

    private w a;

    x(w w1)
    {
        a = w1;
        super();
    }

    public final void run()
    {
        w.a(a);
    }
}
