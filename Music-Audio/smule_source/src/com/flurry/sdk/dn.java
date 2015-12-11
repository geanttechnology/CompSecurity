// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;

// Referenced classes of package com.flurry.sdk:
//            dq, r, ap, aw, 
//            dt

public class dn extends dq
{

    private int b;

    public dn(Context context, r r1, ec.a a1)
    {
        super(context, r1, a1);
        b = 0;
        setAutoPlay(r1.k().a().videoAutoPlay);
        setVideoUri(c(a(r1.k())));
    }

    private String a(ap ap1)
    {
        return ap1.j().display;
    }

    public void a()
    {
        a(aw.s, Collections.emptyMap());
    }

    public void a(String s, float f, float f1)
    {
        super.a(s, f, f1);
        if (f1 > 3F)
        {
            b = b | 2;
            b = b & -9;
        }
        long l = getAdController().a().closableTimeMillis15SecOrLess;
        if (f > 15000F)
        {
            l = getAdController().a().closableTimeMillisLongerThan15Sec;
        }
        if (f1 > (float)l)
        {
            b = b | 1;
        }
    }

    public void b()
    {
        b = b & -9;
        super.b();
    }

    protected int getViewParams()
    {
        if (b == 0)
        {
            b = getAdController().m().i();
        }
        return b;
    }

    public void setAutoPlay(boolean flag)
    {
        super.setAutoPlay(flag);
        if (getAdController().m().a() <= 3)
        {
            int i;
            if (flag)
            {
                i = b;
            } else
            {
                i = b | 8;
            }
            b = i;
        }
    }
}
