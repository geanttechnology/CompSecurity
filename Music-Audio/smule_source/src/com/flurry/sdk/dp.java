// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;

// Referenced classes of package com.flurry.sdk:
//            dq, r, ap, cy, 
//            cv, gd, dt, aw

public class dp extends dq
{

    private static final String b = com/flurry/sdk/dp.getSimpleName();
    private int c;
    private boolean d;
    private float e;
    private float f;

    public dp(Context context, r r1, ec.a a1)
    {
        boolean flag = false;
        super(context, r1, a1);
        c = 0;
        d = false;
        e = 0.0F;
        f = 0.0F;
        setAutoPlay(r1.k().a().videoAutoPlay);
        setVideoUri(c(a(r1.k())));
        if (!TextUtils.isEmpty(b(r1.k())))
        {
            flag = true;
        }
        d = flag;
        e = (float)r1.k().a().videoPctCompletionForMoreInfo / 100F;
        f = (float)r1.k().a().videoPctCompletionForReward / 100F;
    }

    private String a(ap ap1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            return cv.a(ap1.f());
        } else
        {
            return null;
        }
    }

    private String b(ap ap1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.i();
            if (!TextUtils.isEmpty(ap1))
            {
                return cv.a(ap1);
            }
        }
        return null;
    }

    private void g()
    {
        gd.a(3, b, "Reward granted: ");
        getAdController().m().f(true);
    }

    public void a(String s)
    {
        super.a(s);
        if (f == 0.0F)
        {
            a(aw.I, Collections.emptyMap());
        }
    }

    public void a(String s, float f1, float f2)
    {
        super.a(s, f1, f2);
        if (f2 > 3000F)
        {
            int i;
            long l;
            if (d)
            {
                i = c | 4;
            } else
            {
                i = c;
            }
            c = i;
        }
        if (f2 > 3F)
        {
            c = c | 2;
            c = c & -9;
        }
        l = getAdController().a().closableTimeMillis15SecOrLess;
        if (f1 > 15000F)
        {
            l = getAdController().a().closableTimeMillisLongerThan15Sec;
        }
        if (f2 > (float)l)
        {
            c = c | 1;
        }
        s = getAdController().m();
        if (f > 0.0F && f2 >= f * f1 && !s.g())
        {
            g();
            a(aw.I, Collections.emptyMap());
        }
    }

    public void b()
    {
        c = c & -9;
        super.b();
    }

    protected int getViewParams()
    {
        if (c == 0)
        {
            c = getAdController().m().i();
        }
        return c;
    }

    public void setAutoPlay(boolean flag)
    {
        super.setAutoPlay(flag);
        if (getAdController().m().a() <= 3)
        {
            int i;
            if (flag)
            {
                i = c;
            } else
            {
                i = c | 8;
            }
            c = i;
        }
    }

}
