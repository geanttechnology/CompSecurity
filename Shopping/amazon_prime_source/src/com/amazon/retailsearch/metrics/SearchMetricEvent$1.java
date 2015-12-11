// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.android.ui.results.ResultLayoutType;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            SearchMetricEvent

static class outType
{

    static final int $SwitchMap$com$amazon$retailsearch$android$ui$results$ResultLayoutType[];

    static 
    {
        $SwitchMap$com$amazon$retailsearch$android$ui$results$ResultLayoutType = new int[ResultLayoutType.values().length];
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ResultLayoutType[ResultLayoutType.GridView.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ResultLayoutType[ResultLayoutType.ListView.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ResultLayoutType[ResultLayoutType.GalleryView.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ResultLayoutType[ResultLayoutType.SplitView.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
