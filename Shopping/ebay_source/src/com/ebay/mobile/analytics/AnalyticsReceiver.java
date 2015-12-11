// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.analytics.model.TrackingFlags;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.analytics:
//            TrackingType, AnalyticsUtil

public class AnalyticsReceiver extends BroadcastReceiver
{

    public AnalyticsReceiver()
    {
    }

    private TrackingData convertBundleToTrackingData(Bundle bundle)
    {
        if (bundle != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((TrackingData) (obj));
_L2:
        {
            Object obj1 = bundle.getString("eventName");
            bundle.remove("eventName");
            obj = null;
            if (TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (SourceIdentification)bundle.getParcelable("com.ebay.mobile.analytics.sid");
            bundle.remove("com.ebay.mobile.analytics.sid");
            Object obj2 = (TrackingFlags)bundle.getParcelable("com.ebay.mobile.analytics.tracking_flags");
            bundle.remove("com.ebay.mobile.analytics.tracking_flags");
            flattenBundle(bundle);
            obj1 = new TrackingData(((String) (obj1)), TrackingType.EVENT);
            ((TrackingData) (obj1)).addSourceIdentification(((SourceIdentification) (obj)));
            if (obj2 != null)
            {
                ((TrackingData) (obj1)).setTrackingFlags(((TrackingFlags) (obj2)));
            } else
            if (bundle.containsKey("keyFlagsetName") || bundle.containsKey("keyFlagsetId"))
            {
                if (bundle.containsKey("keyFlagsetName") && bundle.containsKey("keyFlagsetId"))
                {
                    TrackingFlags trackingflags = new TrackingFlags(bundle.getString("keyFlagsetName"));
                    for (Iterator iterator = bundle.getIntegerArrayList("keyFlagsetId").iterator(); iterator.hasNext(); trackingflags.setBitPosition(((Integer)iterator.next()).intValue())) { }
                    ((TrackingData) (obj1)).setTrackingFlags(trackingflags);
                }
                bundle.remove("keyFlagsetName");
                bundle.remove("keyFlagsetId");
            }
            obj2 = bundle.keySet().iterator();
        }
        obj = obj1;
        if (((Iterator) (obj2)).hasNext())
        {
            obj = (String)((Iterator) (obj2)).next();
            ((TrackingData) (obj1)).addKeyValuePair(((String) (obj)), bundle.getString(((String) (obj))));
            break MISSING_BLOCK_LABEL_108;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void flattenBundle(Bundle bundle)
    {
        Object obj = new HashSet(bundle.keySet());
        ((Set) (obj)).remove("keyFlagsetId");
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            String s1 = bundle.getString(s);
            if (s1 == null || s1.equals("null") || s1.equals(""))
            {
                bundle.remove(s);
            }
        } while (true);
    }

    public void onReceive(Context context, Intent intent)
    {
        if (AnalyticsUtil.debugLogger.isLoggable)
        {
            FwLog.logMethod(AnalyticsUtil.debugLogger, new Object[] {
                this, intent
            });
        }
        TrackingData trackingdata = convertBundleToTrackingData(intent.getExtras());
        if (trackingdata != null)
        {
            trackingdata.send(context, null);
        } else
        if (AnalyticsUtil.debugLogger.isLoggable)
        {
            AnalyticsUtil.debugLogger.log((new StringBuilder()).append("Unable to convert Bundle to TrackingData in ").append(com/ebay/mobile/analytics/AnalyticsReceiver.getSimpleName()).append(" : ").append(intent).toString());
            return;
        }
    }
}
