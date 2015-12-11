// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b;

import com.target.mothership.services.z;
import java.util.List;

public class c
{

    private final List mProductDetails;
    private final z mResponseCode;

    public c(List list, z z)
    {
        mProductDetails = list;
        mResponseCode = z;
    }

    public z a()
    {
        return mResponseCode;
    }

    public List b()
    {
        return mProductDetails;
    }
}
