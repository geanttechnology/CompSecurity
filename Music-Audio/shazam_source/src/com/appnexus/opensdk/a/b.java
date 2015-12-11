// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.a;

import android.content.Context;
import android.widget.ViewAnimator;

// Referenced classes of package com.appnexus.opensdk.a:
//            g, a, i, h

public final class b extends ViewAnimator
{

    private g a;
    private i b;
    private h c;
    private long d;

    public b(Context context, i i, h h)
    {
        super(context);
        a = null;
        b = i;
        c = h;
        d = 1000L;
    }

    public final void a()
    {
        if (a != null)
        {
            setInAnimation(a.a());
            setOutAnimation(a.b());
        }
    }

    public final void clearAnimation()
    {
        setInAnimation(null);
        setOutAnimation(null);
    }

    public final h getTransitionDirection()
    {
        return c;
    }

    public final long getTransitionDuration()
    {
        return d;
    }

    public final i getTransitionType()
    {
        return b;
    }

    public final void setTransitionDirection(h h)
    {
        if (c != h)
        {
            c = h;
            a = com.appnexus.opensdk.a.a.a(b, d, h);
            a();
        }
    }

    public final void setTransitionDuration(long l)
    {
        if (d != l)
        {
            d = l;
            a = com.appnexus.opensdk.a.a.a(b, l, c);
            a();
        }
    }

    public final void setTransitionType(i i)
    {
        if (b != i)
        {
            b = i;
            a = com.appnexus.opensdk.a.a.a(i, d, c);
            a();
        }
    }
}
