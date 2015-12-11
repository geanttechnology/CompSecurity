// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets.a;

import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.model.coupon_wallets.interfaces.a.b;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.coupon_wallets.a:
//            b

public class c
    implements g
{

    h mErrorSetTransformer;
    com.target.mothership.model.coupon_wallets.a.b mJsonTransformer;

    public c()
    {
        mJsonTransformer = new com.target.mothership.model.coupon_wallets.a.b();
    }

    public b a(x x1)
    {
        b b1 = new b();
        mErrorSetTransformer = new h(mJsonTransformer, b1);
        return (b)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
