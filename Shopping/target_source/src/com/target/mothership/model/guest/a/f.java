// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.target.mothership.b;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.common.a.h;
import com.target.mothership.model.common.a.i;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.a:
//            m, n, l

public class f
    implements g
{

    private h mErrorSetTransformer;
    private i mErrorTransformer;
    private m mGuestErrorSetTransformer;
    private n mGuestErrorTransformer;

    public f()
    {
        mGuestErrorSetTransformer = new m();
        mGuestErrorTransformer = new n();
    }

    private boolean b(x x1)
    {
        com.google.b.f f1 = com.target.mothership.b.a().k();
        try
        {
            x1 = (l)f1.a(x1.a(), com/target/mothership/model/guest/a/l);
        }
        // Misplaced declaration of an exception variable
        catch (x x1)
        {
            return false;
        }
        return x1 != null && x1.a() != null;
    }

    public com.target.mothership.model.guest.interfaces.a.f a(x x1)
    {
        com.target.mothership.model.guest.interfaces.a.f f1 = new com.target.mothership.model.guest.interfaces.a.f();
        if (b(x1))
        {
            mErrorSetTransformer = new h(mGuestErrorSetTransformer, f1);
            return (com.target.mothership.model.guest.interfaces.a.f)mErrorSetTransformer.a(x1);
        } else
        {
            mErrorTransformer = new i(mGuestErrorTransformer, f1);
            return (com.target.mothership.model.guest.interfaces.a.f)mErrorTransformer.a(x1);
        }
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
