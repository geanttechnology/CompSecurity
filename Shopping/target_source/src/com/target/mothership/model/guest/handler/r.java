// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.f;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.apigee.f.b.e;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTGuest

public class r extends f
{

    private Guest mRefreshThisGuest;

    public r(h h, Guest guest)
    {
        super(h);
        mRefreshThisGuest = guest;
    }

    protected Guest a(e e1)
    {
        TGTGuest tgtguest = new TGTGuest();
        tgtguest.a(e1.b());
        tgtguest.c(e1.c());
        tgtguest.a(e1.a());
        tgtguest.b(mRefreshThisGuest.getGuestId());
        tgtguest.a(mRefreshThisGuest.isAnonymous());
        if (mRefreshThisGuest.getAccountDetails().b())
        {
            tgtguest.a((AccountDetails)mRefreshThisGuest.getAccountDetails().c());
        }
        return tgtguest;
    }

    protected volatile Object a(Object obj)
    {
        return a((e)obj);
    }
}
