// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.f;
import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l

public class g
    implements com.target.mothership.model.common.a.g
{

    h mErrorSetTransformer;
    l mJsonTransformer;

    public g()
    {
        mJsonTransformer = new l();
    }

    public f a(x x1)
    {
        f f1 = new f();
        mErrorSetTransformer = new h(mJsonTransformer, f1);
        return (f)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
