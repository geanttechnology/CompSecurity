// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.r;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class w
    implements g
{

    h mErrorSetTransformer;
    l mJsonTransformer;

    public w()
    {
        mJsonTransformer = new l();
    }

    public r a(x x1)
    {
        r r1 = new r();
        mErrorSetTransformer = new h(mJsonTransformer, r1);
        return (r)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
