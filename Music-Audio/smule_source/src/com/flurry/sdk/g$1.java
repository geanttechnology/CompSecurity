// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;

// Referenced classes of package com.flurry.sdk:
//            hq, g, cv, cu, 
//            r, ap, gd

class init> extends hq
{

    final String a;
    final Context b;
    final boolean c;
    final r d;
    final boolean e;
    final boolean f;
    final g g;

    public void safeRun()
    {
label0:
        {
            String s;
            boolean flag1;
label1:
            {
                if (TextUtils.isEmpty(a))
                {
                    break label0;
                }
                s = cv.a(a);
                if (!TextUtils.isEmpty(s))
                {
                    flag1 = false;
                    if (cv.d(s))
                    {
                        flag1 = cu.a(b, s);
                    }
                    boolean flag = flag1;
                    if (!flag1)
                    {
                        flag = flag1;
                        if (cv.f(s))
                        {
                            flag = cu.b(b, s);
                        }
                    }
                    flag1 = flag;
                    if (!flag)
                    {
                        flag1 = flag;
                        if (cv.e(s))
                        {
                            flag1 = cu.c(b, s);
                        }
                    }
                    if (!flag1 || !c)
                    {
                        break label1;
                    }
                    com.flurry.sdk.g.a(g, b, d);
                }
                return;
            }
            ap ap1 = d.k();
            if (!flag1 && ap1.r())
            {
                com.flurry.sdk.g.a(g, d, s, c, e);
                return;
            }
            if (!flag1 && f)
            {
                cu.a(b, d, s, c, e);
                return;
            } else
            {
                cu.a(b, s, e);
                return;
            }
        }
        gd.a(6, com.flurry.sdk.g.c(), (new StringBuilder()).append("Failed to launch: ").append(a).toString());
    }

    text(g g1, String s, Context context, boolean flag, r r1, boolean flag1, boolean flag2)
    {
        g = g1;
        a = s;
        b = context;
        c = flag;
        d = r1;
        e = flag1;
        f = flag2;
        super();
    }
}
