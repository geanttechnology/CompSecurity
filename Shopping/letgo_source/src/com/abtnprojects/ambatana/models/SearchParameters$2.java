// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;


// Referenced classes of package com.abtnprojects.ambatana.models:
//            SearchParameters

static class stance
{

    static final int $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[];
    static final int $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[];

    static 
    {
        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy = new int[rtBy.values().length];
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[rtBy.PROXIMITY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[rtBy.PRICE_DESC.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[rtBy.PRICE_ASC.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$SortBy[rtBy.PUBLISH_DATE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance = new int[stance.values().length];
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[stance.NEARBY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[stance.MY_AREA.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[stance.MY_CITY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$abtnprojects$ambatana$models$SearchParameters$Distance[stance.FAR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
