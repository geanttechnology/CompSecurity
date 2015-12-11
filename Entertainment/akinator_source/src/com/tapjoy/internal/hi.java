// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;

// Referenced classes of package com.tapjoy.internal:
//            ap, ah, gw, hj

public final class hi extends ap
{

    private final gw a;
    private final hj b;
    private ah c;

    public hi(Context context, gw gw1, hj hj1)
    {
        super(context);
        a = gw1;
        b = hj1;
        addView(hj1, new android.view.ViewGroup.LayoutParams(-1, -1));
        c = null;
    }

    protected final void onMeasure(int i, int j)
    {
        ah ah2 = ah.a(getContext());
        ah ah1;
        if (a.a())
        {
            if (a.b())
            {
                if (ah2.a())
                {
                    ah1 = ah.b;
                } else
                if (!ah2.b() && ah.b(getContext()).a())
                {
                    ah1 = ah.b;
                } else
                {
                    ah1 = ah.c;
                }
                setRotationCount(0);
            } else
            {
                ah1 = ah.b;
                if (ah2.b())
                {
                    if (ah2.c() == 3)
                    {
                        setRotationCount(1);
                    } else
                    {
                        setRotationCount(3);
                    }
                } else
                {
                    setRotationCount(0);
                }
            }
        } else
        {
            ah1 = ah.c;
            if (ah2.a())
            {
                if (ah2.c() == 3)
                {
                    setRotationCount(1);
                } else
                {
                    setRotationCount(1);
                }
            } else
            {
                setRotationCount(0);
            }
        }
        if (c != ah1)
        {
            c = ah1;
            b.setLandscape(c.b());
        }
        super.onMeasure(i, j);
    }
}
