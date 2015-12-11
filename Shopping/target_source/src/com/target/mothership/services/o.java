// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.target.mothership.b;
import com.target.mothership.model.guest.interfaces.Guest;

// Referenced classes of package com.target.mothership.services:
//            s, x, z, a

public class o extends s
{

    private com.target.mothership.services.f.a.b.b mRequest;
    private a mResponseBroker;

    public o(com.target.mothership.services.f.a.b.b b1, a a1)
    {
        mRequest = b1;
        mResponseBroker = a1;
    }

    public void a()
    {
        if (c())
        {
            com.target.mothership.b.a().a(mRequest, mResponseBroker);
            return;
        } else
        {
            mResponseBroker.a(x.a("maximum number of requests exceeded").a(z.MAXIMUM_RETRY_EXCEEDED).a(), null);
            return;
        }
    }

    public final void a(Guest guest)
    {
        mRequest.a("Authorization", (new StringBuilder()).append("Bearer ").append(guest.getAccessToken()).toString());
    }

    public final void a(boolean flag)
    {
        com.target.mothership.services.f.a.b.b b1 = mRequest;
        String s1;
        if (flag)
        {
            s1 = "true";
        } else
        {
            s1 = "false";
        }
        b1.a("X-REQUIRE-STORE-INFO", s1);
    }

    public int b()
    {
        return mRequest.b();
    }
}
