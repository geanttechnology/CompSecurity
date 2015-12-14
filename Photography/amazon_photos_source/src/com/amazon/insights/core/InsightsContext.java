// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core;

import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.UserProfile;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.system.System;
import com.amazon.insights.core.util.SDKInfo;
import com.amazon.insights.delivery.DeliveryClient;

public interface InsightsContext
{

    public abstract Configuration getConfiguration();

    public abstract InsightsCredentials getCredentials();

    public abstract DeliveryClient getDeliveryClient();

    public abstract HttpClient getHttpClient();

    public abstract SDKInfo getSDKInfo();

    public abstract System getSystem();

    public abstract Id getUniqueId();

    public abstract UserProfile getUserProfile();

    public abstract void synchronize();
}
