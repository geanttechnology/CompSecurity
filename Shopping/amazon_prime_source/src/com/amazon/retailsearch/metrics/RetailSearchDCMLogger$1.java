// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


// Referenced classes of package com.amazon.retailsearch.metrics:
//            RetailSearchDCMLogger, DetailPageType

static class 
{

    static final int $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[];

    static 
    {
        $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType = new int[DetailPageType.values().length];
        try
        {
            $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.NEWER_EDITION.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.TWISTER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.FORCED_PRIME.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.VIEW_OPTIONS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
