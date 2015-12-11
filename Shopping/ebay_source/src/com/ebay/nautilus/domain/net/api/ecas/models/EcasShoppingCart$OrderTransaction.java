// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static class onversion extends onversion
{

    public Date createdAt;
    public ItemCurrency fullPrice;
    public onversion price;
    public String transactionId;

    public onversion()
    {
    }
}
