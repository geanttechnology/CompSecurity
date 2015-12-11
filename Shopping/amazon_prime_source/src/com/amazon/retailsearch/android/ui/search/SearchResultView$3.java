// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.retailsearch.android.ui.results.layout.SearchLayoutType;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            SearchResultView

static class tType
{

    static final int $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[];

    static 
    {
        $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType = new int[SearchLayoutType.values().length];
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.List.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Grid.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Gallery.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType[SearchLayoutType.Split.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
