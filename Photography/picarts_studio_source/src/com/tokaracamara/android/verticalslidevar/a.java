// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tokaracamara.android.verticalslidevar;


// Referenced classes of package com.tokaracamara.android.verticalslidevar:
//            VerticalProgressBar

final class a
    implements Runnable
{

    int a;
    int b;
    boolean c;
    private VerticalProgressBar d;

    a(VerticalProgressBar verticalprogressbar, int i, int j, boolean flag)
    {
        d = verticalprogressbar;
        super();
        a = i;
        b = j;
        c = flag;
    }

    public final void run()
    {
        VerticalProgressBar.a(d, a, b, c);
        VerticalProgressBar.a(d, this);
    }
}
