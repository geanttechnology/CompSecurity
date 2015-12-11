// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.externalwidgets;

import android.view.View;
import android.view.ViewGroup;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidget;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidgetName;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.android.ui.externalwidgets:
//            ExternalWidgetSlotController, ExternalWidgetUtils, ExternalWidgetState

public class SingleExternalWidgetSlotController
    implements ExternalWidgetSlotController
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/externalwidgets/SingleExternalWidgetSlotController);
    private ExternalSearchWidget activeWidget;
    private final List prioritizedWidgetWhitelist;
    private ExternalWidgetState resultsWidgetState;
    private RetailSearchLogger retailSearchLogger;
    private final Map widgetCandidates = new HashMap();
    private ViewGroup widgetContainer;

    public SingleExternalWidgetSlotController(ExternalWidgetState externalwidgetstate, List list)
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        prioritizedWidgetWhitelist = list;
        resultsWidgetState = externalwidgetstate;
    }

    private ExternalSearchWidget chooseSingleWidget()
    {
        Iterator iterator = prioritizedWidgetWhitelist.iterator();
_L2:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (ExternalSearchWidgetName)iterator.next();
        obj = (ExternalSearchWidget)widgetCandidates.get(obj);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        View view;
        boolean flag;
        flag = ((ExternalSearchWidget) (obj)).shouldDisplay(resultsWidgetState);
        view = ((ExternalSearchWidget) (obj)).getView();
        if (view != null && flag && (view.getParent() == null || obj == activeWidget))
        {
            return ((ExternalSearchWidget) (obj));
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        retailSearchLogger.error((new StringBuilder()).append("Error choosing widget: ").append(ExternalWidgetUtils.getWidgetNameAsString(((ExternalSearchWidget) (obj)))).toString(), exception);
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    private ExternalSearchWidgetName getWidgetName(ExternalSearchWidget externalsearchwidget)
    {
        if (externalsearchwidget == null)
        {
            return null;
        }
        try
        {
            externalsearchwidget = externalsearchwidget.getWidgetName();
        }
        // Misplaced declaration of an exception variable
        catch (ExternalSearchWidget externalsearchwidget)
        {
            retailSearchLogger.error("Error getting the widget name enum", externalsearchwidget);
            return null;
        }
        return externalsearchwidget;
    }

    public void addCandidateWidget(ExternalSearchWidget externalsearchwidget)
    {
        if (externalsearchwidget == null)
        {
            log.error("addCandidateWidget called with a null widget");
        } else
        {
            ExternalSearchWidgetName externalsearchwidgetname = getWidgetName(externalsearchwidget);
            if (externalsearchwidgetname != null)
            {
                widgetCandidates.put(externalsearchwidgetname, externalsearchwidget);
                return;
            }
        }
    }

    public void hide()
    {
        if (widgetContainer == null)
        {
            return;
        }
        try
        {
            widgetContainer.removeAllViews();
            if (activeWidget != null)
            {
                activeWidget.onRemovedFromSlot();
            }
        }
        catch (Exception exception)
        {
            retailSearchLogger.error((new StringBuilder()).append("Unable to hide slot containing widget: ").append(ExternalWidgetUtils.getWidgetNameAsString(activeWidget)).toString(), exception);
        }
        widgetContainer.setVisibility(8);
        activeWidget = null;
    }

    public void setWidgetContainer(ViewGroup viewgroup)
    {
        widgetContainer = viewgroup;
    }

    public void show()
    {
        if (widgetContainer == null || resultsWidgetState == null || !resultsWidgetState.isValid())
        {
            hide();
            return;
        }
        ExternalSearchWidget externalsearchwidget = chooseSingleWidget();
        if (externalsearchwidget == null)
        {
            hide();
            return;
        }
        if (externalsearchwidget.equals(activeWidget))
        {
            widgetContainer.setVisibility(0);
            return;
        }
        try
        {
            widgetContainer.removeAllViews();
            widgetContainer.addView(externalsearchwidget.getView());
            if (activeWidget != null)
            {
                activeWidget.onRemovedFromSlot();
            }
            activeWidget = externalsearchwidget;
            widgetContainer.setVisibility(0);
            activeWidget.onAddedToSlot();
            return;
        }
        catch (Exception exception)
        {
            retailSearchLogger.error((new StringBuilder()).append("Unable to show slot containing widget: ").append(ExternalWidgetUtils.getWidgetNameAsString(externalsearchwidget)).toString(), exception);
        }
        hide();
    }

}
