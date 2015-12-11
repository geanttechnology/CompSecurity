// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.b;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.a.j;

public class a
    implements aa
{

    public a()
    {
    }

    public j a(AddressParams addressparams)
    {
        j j1 = new j(addressparams.f(), addressparams.h(), addressparams.a(), addressparams.b(), addressparams.c(), addressparams.d(), addressparams.i(), addressparams.j());
        j1.a(addressparams.g());
        j1.a(addressparams.k().booleanValue());
        return j1;
    }

    public volatile Object a(Object obj)
    {
        return a((AddressParams)obj);
    }
}
