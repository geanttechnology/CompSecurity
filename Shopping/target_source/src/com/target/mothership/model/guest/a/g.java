// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.target.mothership.model.common.a.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.a:
//            m

public class g
    implements com.target.mothership.model.common.a.g
{

    private h mErrorSetTransformer;
    private m mGuestErrorSetTransformer;

    public g()
    {
        mGuestErrorSetTransformer = new m();
    }

    public com.target.mothership.model.guest.interfaces.a.g a(x x1)
    {
        com.target.mothership.model.guest.interfaces.a.g g1 = new com.target.mothership.model.guest.interfaces.a.g();
        mErrorSetTransformer = new h(mGuestErrorSetTransformer, g1);
        return (com.target.mothership.model.guest.interfaces.a.g)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
