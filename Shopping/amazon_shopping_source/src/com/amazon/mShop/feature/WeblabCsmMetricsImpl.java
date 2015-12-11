// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.net.PageMetricsEventListener;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ClientLogInfo;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import com.amazon.rio.j2me.client.services.mShop.ClientMetrics;
import com.amazon.rio.j2me.client.services.mShop.FeatureExperience;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.feature:
//            Features, WeblabCsmUtils

public class WeblabCsmMetricsImpl
    implements PageMetricsEventListener
{

    protected static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private final String mCsmLatencyType;
    private final String mFeatureName;
    private final String mMainRequestId;
    private final String mPageAssemblyType;
    private final String mPageType;

    public WeblabCsmMetricsImpl(String s, String s1, String s2, String s3, String s4)
    {
        mMainRequestId = s;
        mPageType = s1;
        mPageAssemblyType = s2;
        mFeatureName = s3;
        mCsmLatencyType = s4;
    }

    private ClientLogInfo buildClientLogInfo()
    {
        ClientLogInfo clientloginfo = new ClientLogInfo();
        clientloginfo.setPageType(mPageType);
        clientloginfo.setPageAssemblyType(mPageAssemblyType);
        clientloginfo.setRelatedRequestId(mMainRequestId);
        ArrayList arraylist = new ArrayList(1);
        String s = Features.getInstance().getFeatureState(mFeatureName);
        if (!Util.isEmpty(s) && Features.getInstance().isAllowClientTrigger(mFeatureName))
        {
            FeatureExperience featureexperience = new FeatureExperience();
            featureexperience.setFeatureName(mFeatureName);
            featureexperience.setTreatment(s);
            arraylist.add(featureexperience);
            if (DEBUG)
            {
                Log.v("WeblabCsmUtils", (new StringBuilder()).append("FeatureExperience:").append(featureexperience.getFeatureName()).append(' ').append(featureexperience.getTreatment()).toString());
            }
        }
        clientloginfo.setFeatures(new Vector(arraylist));
        if (DEBUG)
        {
            Log.v("WeblabCsmUtils", (new StringBuilder()).append("buildClientLogInfo:").append(clientloginfo.getPageAssemblyType()).append(' ').append(clientloginfo.getPageType()).append(' ').append(clientloginfo.getRelatedRequestId()).append(' ').append(clientloginfo.getSessionId()).toString());
        }
        return clientloginfo;
    }

    private List buildLatencyMetrics(PageMetricsObserver pagemetricsobserver)
    {
        ClientMetric clientmetric = new ClientMetric();
        int i = pagemetricsobserver.getTotalTime();
        clientmetric.setName(mCsmLatencyType);
        clientmetric.setTime(Integer.valueOf(i));
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(clientmetric);
        if (DEBUG)
        {
            Log.v("WeblabCsmUtils", (new StringBuilder()).append("Csm Latency for ").append(pagemetricsobserver.getPageIdentifier()).append(": ").append(clientmetric.getName()).append("/").append(clientmetric.getTime()).toString());
        }
        return arraylist;
    }

    public void onPageCancelled(PageMetricsObserver pagemetricsobserver, String s)
    {
        if (DEBUG)
        {
            Log.v("WeblabCsmUtils", (new StringBuilder()).append("onPageCancelled ").append(s).toString());
        }
    }

    public void onPageComplete(PageMetricsObserver pagemetricsobserver, String s)
    {
        if (DEBUG)
        {
            Log.v("WeblabCsmUtils", (new StringBuilder()).append("onPageComplete ").append(s).toString());
        }
        s = new ClientMetrics();
        s.setLogInfo(buildClientLogInfo());
        s.setMetrics(new Vector(buildLatencyMetrics(pagemetricsobserver)));
        WeblabCsmUtils.postMetrics(s);
    }

    public void onPageStart(PageMetricsObserver pagemetricsobserver, String s)
    {
        if (DEBUG)
        {
            Log.v("WeblabCsmUtils", (new StringBuilder()).append("onPageStart ").append(s).toString());
        }
    }

}
