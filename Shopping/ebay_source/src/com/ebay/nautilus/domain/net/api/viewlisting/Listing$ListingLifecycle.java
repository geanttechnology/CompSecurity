// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class 
{

    public com.ebay.nautilus.domain.data.stingLifecycle actualEndDate;
    public List ancestry;
    public boolean autoRelist;
    public com.ebay.nautilus.domain.data.stingLifecycle creationDate;
    public  endReason;
    public boolean goodTillCancelled;
    public boolean keepOutOfStockItemAlive;
    public com.ebay.nautilus.domain.data.dReasonEnum lastDescriptionModifiedDate;
    public um listingDuration;
    public List listingRevisions;
    public com.ebay.nautilus.domain.data.atusEnum listingStatus;
    public Integer revisionCount;
    public com.ebay.nautilus.domain.data.atusEnum scheduledEndDate;
    public com.ebay.nautilus.domain.data.atusEnum scheduledStartDate;
    public com.ebay.nautilus.domain.data.on timeRemaining;
    public int versionCount;

    public um()
    {
        listingStatus = com.ebay.nautilus.domain.data.atusEnum.ACTIVE;
    }
}
