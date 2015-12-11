// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.v;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class aa
    implements g
{

    h mErrorSetTransformer;
    l mJsonTransformer;

    public aa()
    {
        mJsonTransformer = new l();
    }

    public v a(x x1)
    {
        v v1 = new v();
        mErrorSetTransformer = new h(mJsonTransformer, v1);
        return (v)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
