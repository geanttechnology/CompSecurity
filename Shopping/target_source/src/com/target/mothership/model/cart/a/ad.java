// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.x;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class ad
    implements g
{

    h mErrorSetTransformer;
    l mJsonTransformer;

    public ad()
    {
        mJsonTransformer = new l();
    }

    public x a(com.target.mothership.services.x x1)
    {
        x x2 = new x();
        mErrorSetTransformer = new h(mJsonTransformer, x2);
        return (x)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.x)obj);
    }
}
