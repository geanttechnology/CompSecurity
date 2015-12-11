// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

public class SellerInfo
    implements gu, Serializable
{

    private String seller;

    public SellerInfo()
    {
    }

    public String getSeller()
    {
        return seller;
    }

    public void setSeller(String s)
    {
        seller = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [seller = ").append(seller).append("]").toString();
    }
}
