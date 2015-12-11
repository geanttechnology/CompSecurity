// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;


// Referenced classes of package com.ebay.mobile.search:
//            SearchRefineFragment, DetailMode

static class entLockType
{

    static final int $SwitchMap$com$ebay$mobile$search$DetailMode[];
    static final int $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType = new int[entLockType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.CONDITION.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror32) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.BUYINGFORMAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror31) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.BESTOFFER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror30) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.SORTORDER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror29) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.EBAYPLUS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.MINPRICE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.MAXPRICE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.FREESHIPPING.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.EXPEDITEDSHIPPING.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.INSTOREPICKUP.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.LOCALPICKUP.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.ZIPCODE.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.MAXDISTANCE.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.COMPLETEDITEMS.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.SOLDITEMS.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.DESCRIPTIONSEARCH.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.SEARCHLOCALCOUNTRY.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.SEARCHOTHERCOUNTRIES.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.RETURNSACCEPTED.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.EBAYGIVINGWORKS.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$RefinementLocks$RefinementLockType[entLockType.EBN.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        $SwitchMap$com$ebay$mobile$search$DetailMode = new int[DetailMode.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.ASPECTS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.AUCTION_FORMAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.CONDITION.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.PRICE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.SORT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.DELIVERY_OPTIONS.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.SL_DISTANCE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.SL_ITEMLOCATION.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.NEAR.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.NONE.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.ROOT.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$DetailMode[DetailMode.CATEGORIES.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
