// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            MetricName

public class SearchMetricEvent
{

    private final int connectionType;
    private final ConnectivityManager connectivityManager;
    private final MetricEvent event;
    UserPreferenceManager preferencesManager;
    private final ViewType viewType;

    public SearchMetricEvent(MetricEvent metricevent, Context context)
    {
        RetailSearchDaggerGraphController.inject(this);
        event = metricevent;
        viewType = preferencesManager.getViewType();
        connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        metricevent = connectivityManager.getActiveNetworkInfo();
        int i;
        if (metricevent == null)
        {
            i = -1;
        } else
        {
            i = metricevent.getType();
        }
        connectionType = i;
        addOrientationMetrics(context.getResources().getConfiguration().orientation);
    }

    private void addOrientationMetrics(int i)
    {
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            event.addCounter(MetricName.SearchLandscape.name(), 1.0D);
            return;

        case 1: // '\001'
            event.addCounter(MetricName.SearchPortrait.name(), 1.0D);
            return;
        }
    }

    private void clearConnectionTypeMetrics()
    {
        if (connectionType == 1)
        {
            event.removeCounter(MetricName.SearchWifi.name());
            event.removeTimer(MetricName.TapToATFWifi.name());
        } else
        if (connectionType == 0)
        {
            event.removeCounter(MetricName.SearchCell.name());
            event.removeTimer(MetricName.TapToATFCell.name());
            return;
        }
    }

    private void clearViewType()
    {
        static class _cls1
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

        switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.ViewType[viewType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            event.removeCounter(MetricName.SearchGrid.name());
            event.removeTimer(MetricName.TapToATFGrid.name());
            return;

        case 2: // '\002'
            event.removeCounter(MetricName.SearchList.name());
            event.removeTimer(MetricName.TapToATFList.name());
            return;

        case 3: // '\003'
            event.removeCounter(MetricName.SearchImage.name());
            event.removeTimer(MetricName.TapToATFImage.name());
            return;

        case 4: // '\004'
            event.removeCounter(MetricName.SearchSplit.name());
            break;
        }
        event.removeTimer(MetricName.TapToATFSplit.name());
    }

    public void addCounter(String s, double d)
    {
        event.addCounter(s, d);
    }

    public void addString(String s, String s1)
    {
        event.addString(s, s1);
    }

    public MetricEvent getEvent()
    {
        return event;
    }

    public void startConnectionTypeMetrics()
    {
        if (connectionType == 1)
        {
            addCounter(MetricName.SearchWifi.name(), 1.0D);
            startTimer(MetricName.TapToATFWifi.name());
        } else
        if (connectionType == 0)
        {
            addCounter(MetricName.SearchCell.name(), 1.0D);
            startTimer(MetricName.TapToATFCell.name());
            return;
        }
    }

    public void startTimer(String s)
    {
        event.startTimer(s);
    }

    public void startViewTypeMetrics()
    {
        switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.ViewType[viewType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            addCounter(MetricName.SearchGrid.name(), 1.0D);
            startTimer(MetricName.TapToATFGrid.name());
            return;

        case 2: // '\002'
            addCounter(MetricName.SearchList.name(), 1.0D);
            startTimer(MetricName.TapToATFList.name());
            return;

        case 3: // '\003'
            addCounter(MetricName.SearchImage.name(), 1.0D);
            startTimer(MetricName.TapToATFImage.name());
            return;

        case 4: // '\004'
            addCounter(MetricName.SearchSplit.name(), 1.0D);
            break;
        }
        startTimer(MetricName.TapToATFSplit.name());
    }

    public void stopConnectionTypeMetrics()
    {
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        if (networkinfo == null || networkinfo.getType() != connectionType)
        {
            clearConnectionTypeMetrics();
        } else
        {
            if (connectionType == 1)
            {
                stopTimer(MetricName.TapToATFWifi.name());
                return;
            }
            if (connectionType == 0)
            {
                stopTimer(MetricName.TapToATFCell.name());
                return;
            }
        }
    }

    public void stopTimer(String s)
    {
        event.stopTimer(s);
    }

    public void stopViewTypeMetrics()
    {
        if (viewType != preferencesManager.getViewType())
        {
            clearViewType();
            return;
        }
        switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.ViewType[viewType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            stopTimer(MetricName.TapToATFGrid.name());
            return;

        case 2: // '\002'
            stopTimer(MetricName.TapToATFList.name());
            return;

        case 3: // '\003'
            stopTimer(MetricName.TapToATFImage.name());
            return;

        case 4: // '\004'
            stopTimer(MetricName.TapToATFSplit.name());
            break;
        }
    }
}
