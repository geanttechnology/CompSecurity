// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.model.guest.interfaces.a.l;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.a:
//            m

public class q
    implements g
{

    private h mErrorSetTransformer;
    private m mGuestErrorSetTransformer;

    public q()
    {
        mGuestErrorSetTransformer = new m();
    }

    public l a(x x1)
    {
        l l1 = new l();
        mErrorSetTransformer = new h(mGuestErrorSetTransformer, l1);
        return (l)mErrorSetTransformer.a(x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
