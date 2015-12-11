// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.groupon.db.models:
//            Price

public interface CommonOptions
{

    public abstract Price getDiscount();

    public abstract int getDiscountPercent();

    public abstract Date getEndAt();

    public abstract Date getEndRedemptionAt();

    public abstract Date getExpiresAt();

    public abstract ArrayList getLegalDisclosures();

    public abstract int getMinimumPurchaseQuantity();

    public abstract Price getPrice();

    public abstract int getSoldQuantity();

    public abstract String getSoldQuantityMessage();

    public abstract String getStatus();

    public abstract String getTitle();

    public abstract Price getValue();

    public abstract boolean isSoldOut();
}
