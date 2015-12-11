// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results;

import com.amazon.retailsearch.android.api.display.DisplayComponent;
import com.amazon.retailsearch.android.api.display.results.listeners.MetricEventListeners;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;

// Referenced classes of package com.amazon.retailsearch.android.api.display.results:
//            ResultsDisplayListeners

public interface ResultsDisplay
    extends DisplayComponent, ResultsDisplayListeners, MetricEventListeners
{

    public abstract void search(RetailSearchQuery retailsearchquery);
}
