// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;

// Referenced classes of package com.flurry.sdk:
//            dq, r, ap, dt

public class do extends dq
{

    private int b;

    public do(Context context, r r1, ec.a a1)
    {
        super(context, r1, a1);
        b = 0;
        setAutoPlay(r1.k().a().videoAutoPlay);
    }

    public void a(String s, float f, float f1)
    {
        super.a(s, f, f1);
        if (f1 > 0.0F)
        {
            b = b | 1;
        }
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
        super.setAutoPlay(true);
    }
}
