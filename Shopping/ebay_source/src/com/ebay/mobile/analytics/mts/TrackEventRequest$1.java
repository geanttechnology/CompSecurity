// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import com.ebay.mobile.analytics.TrackingType;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            TrackEventRequest

static class 
{

    static final int $SwitchMap$com$ebay$mobile$analytics$TrackingType[];

    static 
    {
        $SwitchMap$com$ebay$mobile$analytics$TrackingType = new int[TrackingType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$analytics$TrackingType[TrackingType.EVENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$analytics$TrackingType[TrackingType.PAGE_IMPRESSION.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$analytics$TrackingType[TrackingType.ROI.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
