// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive.latency;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazon.client.metrics.DataPoint;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.retailsearch.adaptive.NetworkType;
import com.amazon.retailsearch.adaptive.framework.AdaptiveTreatmentEnum;
import com.amazon.retailsearch.adaptive.framework.BaseAdaptiveManager;
import com.amazon.retailsearch.adaptive.framework.ModelAdapter;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.adaptive.latency:
//            LatencyAdaptiveDataSourceListener, LatencyRecordsManager, ImageQualityTreatment

public class LatencyAdaptiveManager extends BaseAdaptiveManager
    implements LatencyAdaptiveDataSourceListener
{

    private static int ATF_P50 = 0;
    private static int ATF_P90 = 0;
    private static final String METRIC_NAME = "clickToATF";
    private static int emulationLvl = 0;
    private static LatencyRecordsManager recordManager = LatencyRecordsManager.getInstance();
    private ConnectivityManager cm;
    Lazy context;
    private AdaptiveTreatmentEnum imageQualityTreatment;
    Lazy retailSearchDataProvider;
    private boolean updateTreatment;
    private boolean validMetricData;

    public LatencyAdaptiveManager()
    {
        imageQualityTreatment = ImageQualityTreatment.HIGH;
        updateTreatment = false;
        validMetricData = false;
        RetailSearchDaggerGraphController.inject(this);
        cm = (ConnectivityManager)((Context)context.get()).getSystemService("connectivity");
        recoverData();
    }

    private void gatherMetricData()
    {
        String s = ((IRetailSearchDataProvider)retailSearchDataProvider.get()).getLatency("clickToAtfP50");
        String s1 = ((IRetailSearchDataProvider)retailSearchDataProvider.get()).getLatency("clickToAtfP90");
        if (s != null)
        {
            ATF_P50 = Integer.parseInt(s);
        }
        if (s1 != null)
        {
            ATF_P90 = Integer.parseInt(s1);
        }
    }

    private NetworkType getNetworkType()
    {
        NetworkInfo networkinfo = cm.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            return NetworkType.NotConnected;
        }
        switch (networkinfo.getType())
        {
        default:
            return NetworkType.Unknown;

        case 0: // '\0'
            return NetworkType.Mobile;

        case 1: // '\001'
            return NetworkType.Wifi;
        }
    }

    private boolean isValidMetricData()
    {
        return ATF_P50 != 0x7fffffff && ATF_P90 != 0x7fffffff;
    }

    public static void setEmulationLevel(String s)
    {
        if (s.equals(ImageQualityTreatment.HIGH.getATFLevel()))
        {
            emulationLvl = 0;
        } else
        {
            if (s.equals(ImageQualityTreatment.MEDIUM.getATFLevel()))
            {
                emulationLvl = 1;
                return;
            }
            if (s.equals(ImageQualityTreatment.LOW.getATFLevel()))
            {
                emulationLvl = 2;
                return;
            }
            if (s.equals(ImageQualityTreatment.VERY_LOW.getATFLevel()))
            {
                emulationLvl = 3;
                return;
            }
        }
    }

    public Object adaptModel(Object obj, ModelAdapter modeladapter)
    {
        if (obj == null || modeladapter == null)
        {
            return obj;
        }
        if (updateTreatment)
        {
            updateAdaptiveTreatment();
        }
        return modeladapter.adapt(obj, imageQualityTreatment);
    }

    public void addData(MetricEvent metricevent)
    {
        int j = 0x80000000;
        metricevent = metricevent.getAsDataPoints().iterator();
        int i;
        do
        {
            i = j;
            if (!metricevent.hasNext())
            {
                break;
            }
            DataPoint datapoint = (DataPoint)metricevent.next();
            if (!"clickToATF".equals(datapoint.getName()))
            {
                continue;
            }
            i = Double.valueOf(datapoint.getValue()).intValue();
            break;
        } while (true);
        if (i < 0)
        {
            return;
        } else
        {
            recordManager.addLatency(i, imageQualityTreatment, getNetworkType());
            updateTreatment = true;
            return;
        }
    }

    public volatile void addData(Object obj)
    {
        addData((MetricEvent)obj);
    }

    public void recoverData()
    {
        recordManager.recoverRecords((Context)context.get());
    }

    public void saveData()
    {
        recordManager.saveRecords((Context)context.get());
    }

    protected void updateAdaptiveTreatment()
    {
        updateTreatment = false;
        double d = recordManager.getMeanLatency(getNetworkType());
        if (Double.isNaN(d))
        {
            return;
        }
        if (!validMetricData)
        {
            gatherMetricData();
            validMetricData = isValidMetricData();
        }
        if (d > (double)ATF_P90)
        {
            imageQualityTreatment = ImageQualityTreatment.LOW;
        } else
        if (d > (double)ATF_P50)
        {
            imageQualityTreatment = ImageQualityTreatment.MEDIUM;
        } else
        {
            imageQualityTreatment = ImageQualityTreatment.HIGH;
        }
        switch (emulationLvl)
        {
        default:
            return;

        case 1: // '\001'
            imageQualityTreatment = ImageQualityTreatment.MEDIUM;
            return;

        case 2: // '\002'
            imageQualityTreatment = ImageQualityTreatment.LOW;
            return;

        case 3: // '\003'
            imageQualityTreatment = ImageQualityTreatment.VERY_LOW;
            break;
        }
    }

    static 
    {
        ATF_P50 = 0x7fffffff;
        ATF_P90 = 0x7fffffff;
    }
}
