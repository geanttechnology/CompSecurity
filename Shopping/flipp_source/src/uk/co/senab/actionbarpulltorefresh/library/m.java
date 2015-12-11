// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;


// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            j, f

final class m
    implements Runnable
{

    final j a;

    m(j j1)
    {
        a = j1;
        super();
    }

    public final void run()
    {
        j j1 = a;
        if (!j1.d())
        {
            j1.a.d();
        }
    }
}
