// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.b;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTGuest, TGTAccountDetails

public class m
    implements aa
{

    public m()
    {
    }

    public Guest a(b b1)
    {
        TGTGuest tgtguest = new TGTGuest();
        tgtguest.b(b1.e());
        tgtguest.a(b1.f());
        tgtguest.c(b1.g());
        tgtguest.a(b1.h());
        tgtguest.a(false);
        TGTAccountDetails tgtaccountdetails = new TGTAccountDetails();
        tgtaccountdetails.c(b1.d());
        tgtaccountdetails.a(b1.b());
        tgtaccountdetails.b(b1.c());
        tgtaccountdetails.a(b1.a());
        tgtguest.a(tgtaccountdetails);
        return tgtguest;
    }

    public volatile Object a(Object obj)
    {
        return a((b)obj);
    }
}
