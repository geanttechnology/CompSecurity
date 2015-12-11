// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;


// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchViewPresenter

static class archType
{

    static final int $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[];

    static 
    {
        $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType = new int[archType.values().length];
        try
        {
            $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[archType.BY_DESTINATION.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[archType.BY_QUERY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$getaways$search$GetawaysSearchViewPresenter$SearchType[archType.BY_CURRENT_LOCATION.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
