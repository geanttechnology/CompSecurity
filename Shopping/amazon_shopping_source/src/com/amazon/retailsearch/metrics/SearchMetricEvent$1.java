// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.android.ui.results.ViewType;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            SearchMetricEvent

static class _cls9
{

    static final int $SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType[];

    static 
    {
        $SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType = new int[ViewType.values().length];
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType[ViewType.GridView.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType[ViewType.ListView.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType[ViewType.GalleryView.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$ViewType[ViewType.SplitView.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
