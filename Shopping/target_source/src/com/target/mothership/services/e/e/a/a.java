// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.a;

import com.target.mothership.common.product.ProductIdentifier;
import java.util.List;

public class a
{

    private final List mIds;
    private final boolean mRequiredStoreInfo;
    private final String mStoreId;
    private final ProductIdentifier mType;

    public a(ProductIdentifier productidentifier, List list, String s, boolean flag)
    {
        mType = productidentifier;
        mIds = list;
        mStoreId = s;
        mRequiredStoreInfo = flag;
    }

    public com.target.mothership.common.product.ProductIdentifier.a a()
    {
        return mType.a();
    }

    public List b()
    {
        return mType.a(mIds);
    }

    public String c()
    {
        return mStoreId;
    }

    public boolean d()
    {
        return mRequiredStoreInfo;
    }
}
