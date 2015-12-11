// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class a
    implements g
{

    h mErrorSetTransformer;
    l mJsonTransformer;

    public a()
    {
        mJsonTransformer = new l();
    }

    public com.target.mothership.model.cart.interfaces.a.a a(x x1)
    {
        com.target.mothership.model.cart.interfaces.a.a a1 = new com.target.mothership.model.cart.interfaces.a.a();
        mErrorSetTransformer = new h(mJsonTransformer, a1);
        return (com.target.mothership.model.cart.interfaces.a.a)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
