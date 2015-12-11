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
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
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
    private final ResultLayoutType resultLayoutType;

    public SearchMetricEvent(MetricEvent metricevent, Context context)
    {
        RetailSearchDaggerGraphController.inject(this);
        event = metricevent;
        resultLayoutType = preferencesManager.getResultLayoutType();
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
            event.removeTimer(MetricName.ClickToATFWifi.name());
        } else
        if (connectionType == 0)
        {
            event.removeCounter(MetricName.SearchCell.name());
            event.removeTimer(MetricName.ClickToATFCell.name());
            return;
        }
    }

    private void clearResultLayoutType()
    {
        static class _cls1
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

        switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.ResultLayoutType[resultLayoutType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            event.removeCounter(MetricName.SearchGrid.name());
            event.removeTimer(MetricName.ClickToATFGrid.name());
            return;

        case 2: // '\002'
            event.removeCounter(MetricName.SearchList.name());
            event.removeTimer(MetricName.ClickToATFList.name());
            return;

        case 3: // '\003'
            event.removeCounter(MetricName.SearchImage.name());
            event.removeTimer(MetricName.ClickToATFImage.name());
            return;

        case 4: // '\004'
            event.removeCounter(MetricName.SearchSplit.name());
            break;
        }
        event.removeTimer(MetricName.ClickToATFSplit.name());
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
            startTimer(MetricName.ClickToATFWifi.name());
        } else
        if (connectionType == 0)
        {
            addCounter(MetricName.SearchCell.name(), 1.0D);
            startTimer(MetricName.ClickToATFCell.name());
            return;
        }
    }

    public void startResultLayoutTypeMetrics()
    {
        switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.ResultLayoutType[resultLayoutType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            addCounter(MetricName.SearchGrid.name(), 1.0D);
            startTimer(MetricName.ClickToATFGrid.name());
            return;

        case 2: // '\002'
            addCounter(MetricName.SearchList.name(), 1.0D);
            startTimer(MetricName.ClickToATFList.name());
            return;

        case 3: // '\003'
            addCounter(MetricName.SearchImage.name(), 1.0D);
            startTimer(MetricName.ClickToATFImage.name());
            return;

        case 4: // '\004'
            addCounter(MetricName.SearchSplit.name(), 1.0D);
            break;
        }
        startTimer(MetricName.ClickToATFSplit.name());
    }

    public void startTimer(String s)
    {
        event.startTimer(s);
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
                stopTimer(MetricName.ClickToATFWifi.name());
                return;
            }
            if (connectionType == 0)
            {
                stopTimer(MetricName.ClickToATFCell.name());
                return;
            }
        }
    }

    public void stopResultLayoutTypeMetrics()
    {
        if (resultLayoutType != preferencesManager.getResultLayoutType())
        {
            clearResultLayoutType();
            return;
        }
        switch (_cls1..SwitchMap.com.amazon.retailsearch.android.ui.results.ResultLayoutType[resultLayoutType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            stopTimer(MetricName.ClickToATFGrid.name());
            return;

        case 2: // '\002'
            stopTimer(MetricName.ClickToATFList.name());
            return;

        case 3: // '\003'
            stopTimer(MetricName.ClickToATFImage.name());
            return;

        case 4: // '\004'
            stopTimer(MetricName.ClickToATFSplit.name());
            break;
        }
    }

    public void stopTimer(String s)
    {
        event.stopTimer(s);
    }
}
