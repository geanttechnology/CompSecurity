// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;


// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            TextLoopView, am

class b
    implements Runnable
{

    final int a;
    final boolean b;
    final TextLoopView c;

    public void run()
    {
        if (TextLoopView.e(c) != null)
        {
            TextLoopView.e(c).a(a, b);
        }
    }

    A(TextLoopView textloopview, int i, boolean flag)
    {
        c = textloopview;
        a = i;
        b = flag;
        super();
    }
}
