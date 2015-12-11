// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.details;

import com.ebay.nautilus.domain.data.experience.checkout.summary.Summary;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.details:
//            LineItemType, Logistics

public class LineItem
{

    public Map actions;
    public boolean defaultItem;
    public List errors;
    public String lineItemId;
    public LineItemType lineItemType;
    public List listingSummaries;
    public Logistics logistics;
    public List promotions;
    public boolean selected;
    public Summary summary;

    public LineItem()
    {
    }
}
