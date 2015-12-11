// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.guest.a.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            m

public class c extends b
{

    private d mCreateAccountFailureTransformer;
    private final m mSuccessTransformer = new m();

    public c(com.target.mothership.model.d d1)
    {
        super(d1);
    }

    protected Guest a(com.target.mothership.services.apigee.f.b.b b1)
    {
        return mSuccessTransformer.a(b1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.f.b.b)obj);
    }

    protected com.target.mothership.model.guest.interfaces.a.d b(x x)
    {
        mCreateAccountFailureTransformer = new d();
        return mCreateAccountFailureTransformer.a(x);
    }
}
