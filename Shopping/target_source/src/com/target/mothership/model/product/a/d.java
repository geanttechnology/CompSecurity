// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.a;

import com.target.mothership.model.product.interfaces.a.a;
import com.target.mothership.services.x;

public class d
    implements a
{

    private x mError;
    private com.target.mothership.model.product.interfaces.a.a.a mReason;

    d()
    {
    }

    public x a()
    {
        return mError;
    }

    public void a(com.target.mothership.model.product.interfaces.a.a.a a1)
    {
        mReason = a1;
    }

    public void a(x x)
    {
        mError = x;
    }
}
