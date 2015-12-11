// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;


// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageAdapter, SearchPrefixType

static class I
{

    static final int $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType = new int[SearchPrefixType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[SearchPrefixType.EAN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[SearchPrefixType.UPC.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$search$SearchLandingPage$SearchPrefixType[SearchPrefixType.SELLER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
