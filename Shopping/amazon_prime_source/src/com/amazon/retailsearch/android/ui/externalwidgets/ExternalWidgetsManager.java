// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.externalwidgets;

import android.view.View;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidgetSlot;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchPageLoadListener;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.interaction.SearchChangeListener;
import com.amazon.retailsearch.metrics.SearchMetricsListener;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.externalwidgets:
//            ExternalWidgetState, SingleExternalWidgetSlotController, ExternalWidgetSlotController

public class ExternalWidgetsManager
    implements SearchPageLoadListener, SearchChangeListener, SearchMetricsListener
{
    private class TaskListener extends com.amazon.retailsearch.data.SearchTask.SearchTaskListener
    {

        final ExternalWidgetsManager this$0;

        public void trackingInfo(TrackingInfo trackinginfo)
        {
            if (trackinginfo == null)
            {
                return;
            } else
            {
                externalWidgetState.setStore(trackinginfo.getStore());
                return;
            }
        }

        private TaskListener()
        {
            this$0 = ExternalWidgetsManager.this;
            super();
        }

    }


    private final ExternalWidgetState externalWidgetState = new ExternalWidgetState();
    private final Map slotControllers = new HashMap();
    private TaskListener taskListener;
    private boolean wasATFReached;

    public ExternalWidgetsManager()
    {
        taskListener = new TaskListener();
        slotControllers.put(ExternalSearchWidgetSlot.NAV_BAR_ABOVE_RIB, new SingleExternalWidgetSlotController(externalWidgetState, ExternalSearchWidgetSlot.NAV_BAR_ABOVE_RIB.getWidgetWhitelist()));
    }

    private void hideAllSlots()
    {
        for (Iterator iterator = slotControllers.entrySet().iterator(); iterator.hasNext(); ((ExternalWidgetSlotController)((java.util.Map.Entry)iterator.next()).getValue()).hide()) { }
    }

    public void endPage(View view)
    {
    }

    public void endResult()
    {
        if (!wasATFReached)
        {
            getSlotController(ExternalSearchWidgetSlot.NAV_BAR_ABOVE_RIB).show();
        }
    }

    public com.amazon.retailsearch.data.SearchTask.SearchTaskListener getSearchTaskListener()
    {
        return taskListener;
    }

    public ExternalWidgetSlotController getSlotController(ExternalSearchWidgetSlot externalsearchwidgetslot)
    {
        return (ExternalWidgetSlotController)slotControllers.get(externalsearchwidgetslot);
    }

    public void onNewSearch(SearchTask searchtask)
    {
        wasATFReached = false;
        externalWidgetState.setStore(null);
        hideAllSlots();
    }

    public void onSearchATFReached()
    {
        wasATFReached = true;
        getSlotController(ExternalSearchWidgetSlot.NAV_BAR_ABOVE_RIB).show();
    }

    public void onSearchSRDSCompleted()
    {
    }

    public void onSearchSRDSStarted()
    {
    }

    public void onSearchStarted()
    {
    }

    public void startPage(View view, int i)
    {
    }

    public void startResult()
    {
    }

}
