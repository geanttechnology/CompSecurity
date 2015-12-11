// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.model.guest.interfaces.a.k;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.a:
//            m

public class o
    implements g
{

    private h mErrorSetTransformer;
    private m mGuestErrorSetTransformer;

    public o()
    {
        mGuestErrorSetTransformer = new m();
    }

    public k a(x x1)
    {
        k k1 = new k();
        mErrorSetTransformer = new h(mGuestErrorSetTransformer, k1);
        return (k)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
