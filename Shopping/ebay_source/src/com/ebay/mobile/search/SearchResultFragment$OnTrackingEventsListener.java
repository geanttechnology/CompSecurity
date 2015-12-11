// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;


// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragment

public static interface 
{

    public abstract void onBarcodeSearchComplete(String s, String s1);

    public abstract void onBarcodeSearchFailed(String s, String s1);

    public abstract void onPromptOfEbayNowCorrection();

    public abstract void onRefineAspect();

    public abstract void onRefineAuctionType();

    public abstract void onRefineCategory();

    public abstract void onRefineCondition();

    public abstract void onRefineMaxDistance();

    public abstract void onRefineNear();

    public abstract void onRefineOpen();

    public abstract void onRefinePreferredLocation();

    public abstract void onRefinePriceRange();

    public abstract void onRefineSort(String s);

    public abstract void onRelatedSearchesAvailable();

    public abstract void onZeroResults(boolean flag);
}
