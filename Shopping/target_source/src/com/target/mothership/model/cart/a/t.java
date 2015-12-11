// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.o;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class t
    implements g
{

    h mErrorSetTransformer;
    l mJsonTransformer;

    public t()
    {
        mJsonTransformer = new l();
    }

    public o a(x x1)
    {
        o o1 = new o();
        mErrorSetTransformer = new h(mJsonTransformer, o1);
        return (o)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
