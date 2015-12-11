// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.services.k;

public class e extends k
{

    private String mProductId;
    private String mRewardOptionId;

    public e(CatEntryId catentryid, String s)
    {
        mProductId = catentryid.b();
        mRewardOptionId = s;
    }
}
