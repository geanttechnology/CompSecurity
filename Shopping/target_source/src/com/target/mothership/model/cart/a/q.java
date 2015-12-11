// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.l;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class q
    implements g
{

    h mErrorSetTransformer;
    com.target.mothership.model.cart.a.l mJsonTransformer;

    public q()
    {
        mJsonTransformer = new com.target.mothership.model.cart.a.l();
    }

    public l a(x x1)
    {
        l l1 = new l();
        mErrorSetTransformer = new h(mJsonTransformer, l1);
        return (l)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
