// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Arrays;

// Referenced classes of package com.tapjoy.internal:
//            fr, ha, bu, gy, 
//            fv, fs, fw

abstract class gr
    implements fr
{

    private static final String a[];

    gr()
    {
    }

    public static gr a(String s, bu bu1)
    {
        if ("reward".equals(s))
        {
            return (gr)bu1.b(ha.a);
        }
        if ("purchase".equals(s))
        {
            return (gr)bu1.b(gy.a);
        } else
        {
            return null;
        }
    }

    public static boolean a(String s)
    {
        return Arrays.binarySearch(a, s) >= 0;
    }

    public final void a(fs fs1)
    {
        if (this instanceof fv)
        {
            fv fv1 = (fv)this;
            fs1.a(fv1.a(), fv1.b());
        } else
        if (this instanceof fw)
        {
            fw fw1 = (fw)this;
            fs1.a(fw1.a(), fw1.b(), fw1.c(), fw1.d());
            return;
        }
    }

    static 
    {
        String as[] = new String[3];
        as[0] = "reward";
        as[1] = "purchase";
        as[2] = "custom_action";
        a = as;
        Arrays.sort(as);
    }
}
