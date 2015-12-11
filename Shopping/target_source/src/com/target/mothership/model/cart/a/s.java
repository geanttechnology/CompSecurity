// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.n;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class s
    implements g
{

    h mErrorSetTransformer;
    l mJsonTransformer;

    public s()
    {
        mJsonTransformer = new l();
    }

    public n a(x x1)
    {
        n n1 = new n();
        mErrorSetTransformer = new h(mJsonTransformer, n1);
        return (n)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
