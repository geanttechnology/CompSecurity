// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results;

import android.view.View;
import com.amazon.retailsearch.android.api.display.DisplayComponent;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidget;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidgetSlot;
import com.amazon.retailsearch.android.api.display.results.listeners.MetricEventListeners;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.data.stores.StoreManager;

// Referenced classes of package com.amazon.retailsearch.android.api.display.results:
//            ResultsDisplayListeners, ResultsInfoBarWidgetType

public interface ResultsDisplay
    extends DisplayComponent, ResultsDisplayListeners, MetricEventListeners
{

    public abstract void addCandidateWidget(ExternalSearchWidget externalsearchwidget, ExternalSearchWidgetSlot externalsearchwidgetslot);

    public abstract StoreManager getStoreManager();

    public abstract void search(RetailSearchQuery retailsearchquery);

    public abstract void setResultsInfoBarWidgetType(ResultsInfoBarWidgetType resultsinfobarwidgettype, View view);

    public abstract void setWidgetListeners();
}
