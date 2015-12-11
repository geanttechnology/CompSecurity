// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.a.a.a;
import b.a.a.a.b;
import b.a.a.a.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ba

public final class SubscriptionButton_ extends ba
    implements a, b
{

    private boolean f;
    private final c g;

    public SubscriptionButton_(Context context)
    {
        super(context);
        f = false;
        g = new c();
        a();
    }

    public SubscriptionButton_(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = false;
        g = new c();
        a();
    }

    private void a()
    {
        c c1 = c.a(g);
        c.a(this);
        c.a(c1);
    }

    public void a(a a1)
    {
        d = (LinearLayout)a1.findViewById(0x7f0a01fa);
        c = (TextView)a1.findViewById(0x7f0a01fd);
        a = (TextView)a1.findViewById(0x7f0a01fb);
        b = (TextView)a1.findViewById(0x7f0a01fc);
    }

    public void onFinishInflate()
    {
        if (!f)
        {
            f = true;
            g.a(this);
        }
        super.onFinishInflate();
    }
}
