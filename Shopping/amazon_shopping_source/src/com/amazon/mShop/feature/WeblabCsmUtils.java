// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import android.util.Log;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ClientLogInfo;
import com.amazon.rio.j2me.client.services.mShop.ClientMetrics;
import com.amazon.rio.j2me.client.services.mShop.FeatureExperience;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.PostMetricsResponseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.feature:
//            Features

public class WeblabCsmUtils
{

    protected static final boolean DEBUG = DebugSettings.isDebugEnabled();

    public WeblabCsmUtils()
    {
    }

    public static void postFeatureTrigger(String s)
    {
        postFeatureTriggerWithTreatment(s, Features.getInstance().getFeatureState(s), Features.getInstance().getFeatureCacheStamp(s));
    }

    public static void postFeatureTriggerWithTreatment(String s, String s1, Integer integer)
    {
        if (!Util.isEmpty(s1) && Features.getInstance().isAllowClientTrigger(s))
        {
            FeatureExperience featureexperience = new FeatureExperience();
            featureexperience.setFeatureName(s);
            featureexperience.setTreatment(s1);
            featureexperience.setCacheStamp(integer);
            s = new ClientLogInfo();
            s1 = new ArrayList(1);
            s1.add(featureexperience);
            s.setFeatures(new Vector(s1));
            s.setPageAssemblyType("main");
            s1 = new ClientMetrics();
            s1.setLogInfo(s);
            postMetrics(s1);
        }
    }

    public static void postMetrics(ClientMetrics clientmetrics)
    {
        PostMetricsResponseListener postmetricsresponselistener = new PostMetricsResponseListener() {

            public void cancelled(ServiceCall servicecall)
            {
                if (WeblabCsmUtils.DEBUG)
                {
                    Log.d("WeblabCsmUtils", "post metrics cancelled");
                }
            }

            public void completed(Null null1, ServiceCall servicecall)
            {
                if (WeblabCsmUtils.DEBUG)
                {
                    Log.d("WeblabCsmUtils", "post metrics completed");
                }
            }

            public void error(Exception exception, ServiceCall servicecall)
            {
                if (WeblabCsmUtils.DEBUG)
                {
                    Log.w("WeblabCsmUtils", (new StringBuilder()).append("post metrics failed: ").append(exception).toString());
                }
            }

        };
        ServiceController.getMShopService().postMetrics(clientmetrics, postmetricsresponselistener);
    }

}
