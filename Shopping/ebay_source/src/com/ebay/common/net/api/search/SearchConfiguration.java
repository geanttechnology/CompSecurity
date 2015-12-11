// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.content.EbayCguidPersister;
import com.ebay.nautilus.domain.net.CosVersionType;

public final class SearchConfiguration
{

    public final int adDeliveryMaxItems;
    public final int adDeliveryResultCountThreshold;
    public final EbayCguidPersister cguidPersister;
    public final CosVersionType cosVersionType;
    public boolean isAdDeliveryEnabled;
    public final boolean isEEKEnabled;
    public final boolean isEbayPlusEnabled;
    public final boolean isGbhEnabled;
    public final boolean isIncludeLocalItemsOnlyEnabled;
    public final boolean isItemTitleTranslationEnabled;
    public final boolean isMadlanDisplayStringsEnabled;
    public final boolean isOAuthEndpointEnabled;
    public final boolean isPickupAndDropOffHackRequired;
    public final boolean isRedLaserFallbackEnabled;
    public final boolean isRelatedSearchesEnabled;
    public final boolean isSearchCorrectionEnabled;
    public final boolean isSearchExpansionsEnabled;
    public final boolean isSearchServiceEnabled;
    public final boolean isSpellAutoCorrectEnabled;
    public final boolean isUseSearchServiceV2;
    public final boolean isUseUvccEnabled;

    public SearchConfiguration(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, boolean flag6, 
            boolean flag7, boolean flag8, boolean flag9, boolean flag10, boolean flag11, boolean flag12, int i, 
            int j, EbayCguidPersister ebaycguidpersister, boolean flag13, boolean flag14, boolean flag15, boolean flag16)
    {
        isPickupAndDropOffHackRequired = flag10;
        isSearchServiceEnabled = flag;
        isUseSearchServiceV2 = flag1;
        isSearchCorrectionEnabled = flag2;
        isSearchExpansionsEnabled = flag3;
        isGbhEnabled = flag4;
        isRedLaserFallbackEnabled = flag5;
        isRelatedSearchesEnabled = flag6;
        isIncludeLocalItemsOnlyEnabled = flag8;
        isUseUvccEnabled = flag9;
        if (flag7 && ebaycguidpersister != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isAdDeliveryEnabled = flag;
        isEEKEnabled = flag11;
        isOAuthEndpointEnabled = flag12;
        adDeliveryMaxItems = i;
        adDeliveryResultCountThreshold = j;
        cguidPersister = ebaycguidpersister;
        isItemTitleTranslationEnabled = flag13;
        isMadlanDisplayStringsEnabled = flag14;
        isSpellAutoCorrectEnabled = flag15;
        isEbayPlusEnabled = flag16;
        if (isOAuthEndpointEnabled)
        {
            cosVersionType = CosVersionType.V2;
            return;
        } else
        {
            cosVersionType = CosVersionType.V1;
            return;
        }
    }
}
