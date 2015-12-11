// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.widget.ListView;
import b.a.a.a.a;
import b.a.a.a.b;
import b.a.a.a.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ab

public final class NavBarLayout_ extends ab
    implements a, b
{

    private boolean d;
    private final c e;

    public NavBarLayout_(Context context)
    {
        super(context);
        d = false;
        e = new c();
        i();
    }

    public NavBarLayout_(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = false;
        e = new c();
        i();
    }

    public NavBarLayout_(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        d = false;
        e = new c();
        i();
    }

    private void i()
    {
        c c1 = c.a(e);
        c.a(this);
        c.a(c1);
    }

    public void a(a a1)
    {
        b = (ListView)a1.findViewById(0x7f0a016e);
        c = (DrawerLayout)a1.findViewById(0x7f0a016b);
        d();
    }

    public void onFinishInflate()
    {
        if (!d)
        {
            d = true;
            e.a(this);
        }
        super.onFinishInflate();
    }
}
