// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;

// Referenced classes of package com.flurry.sdk:
//            ds, dp, do, dn, 
//            r, dq

public class dr
{

    public dr()
    {
    }

    public static dq a(Context context, ds ds1, r r, ec.a a1)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[ds.values().length];
                try
                {
                    a[ds.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ds.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ds.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[ds1.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new dp(context, r, a1);

        case 2: // '\002'
            return new do(context, r, a1);

        case 3: // '\003'
            return new dn(context, r, a1);
        }
    }
}
