// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core;

import android.content.Context;
import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.InsightsProcessingService;
import com.amazon.insights.UserProfile;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.configuration.HttpCachingConfiguration;
import com.amazon.insights.core.http.ClientInfoInterceptor;
import com.amazon.insights.core.http.DefaultHttpClient;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.http.LogInterceptor;
import com.amazon.insights.core.http.SDKInfoInterceptor;
import com.amazon.insights.core.http.SignatureInterceptor;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.idresolver.SharedPrefsUniqueIdService;
import com.amazon.insights.core.idresolver.UniqueIdService;
import com.amazon.insights.core.system.AndroidSystem;
import com.amazon.insights.core.system.System;
import com.amazon.insights.core.util.SDKInfo;
import com.amazon.insights.delivery.DefaultDeliveryClient;
import com.amazon.insights.delivery.DeliveryClient;
import com.amazon.insights.profile.DefaultUserProfile;
import java.util.Map;

// Referenced classes of package com.amazon.insights.core:
//            InsightsContext

public class DefaultInsightsContext
    implements InsightsContext
{

    private final Configuration configuration;
    private final InsightsCredentials credentials;
    private final DeliveryClient deliveryClient;
    private final HttpClient httpClient = new DefaultHttpClient();
    private final SDKInfo sdkInfo;
    private final System system;
    private Id uniqueId;
    private final UniqueIdService uniqueIdService = SharedPrefsUniqueIdService.newInstance();
    private final UserProfile userProfile;

    public DefaultInsightsContext(InsightsCredentials insightscredentials, Context context, UserProfile userprofile, SDKInfo sdkinfo, boolean flag, Map map)
    {
        credentials = insightscredentials;
        userProfile = userprofile;
        sdkInfo = sdkinfo;
        system = new AndroidSystem(context, insightscredentials);
        uniqueId = uniqueIdService.getUniqueId(this);
        httpClient.addInterceptor(new SDKInfoInterceptor(sdkinfo));
        httpClient.addInterceptor(new ClientInfoInterceptor(context));
        httpClient.addInterceptor(new SignatureInterceptor(insightscredentials.getPrivateKey()));
        httpClient.addInterceptor(new LogInterceptor());
        configuration = HttpCachingConfiguration.newInstance(this, map);
        deliveryClient = DefaultDeliveryClient.newInstance(this, flag);
        InsightsProcessingService.cancelPendingIntent(context, "SubmitMeasurements");
        InsightsProcessingService.cancelPendingIntent(context, "SyncConfiguration");
    }

    public static InsightsContext newInstance(InsightsCredentials insightscredentials, Context context, SDKInfo sdkinfo, boolean flag, Map map)
    {
        return new DefaultInsightsContext(insightscredentials, context, new DefaultUserProfile(), sdkinfo, flag, map);
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }

    public InsightsCredentials getCredentials()
    {
        return credentials;
    }

    public DeliveryClient getDeliveryClient()
    {
        return deliveryClient;
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public SDKInfo getSDKInfo()
    {
        return sdkInfo;
    }

    public System getSystem()
    {
        return system;
    }

    public Id getUniqueId()
    {
        return uniqueId;
    }

    public UserProfile getUserProfile()
    {
        return userProfile;
    }

    public void synchronize()
    {
        uniqueId = uniqueIdService.getUniqueId(this);
        configuration.refresh();
    }
}
