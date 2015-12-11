// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class SellerInfo
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x6bb6d70ae1f4ff74L;
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
}
