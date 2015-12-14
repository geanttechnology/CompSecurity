// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.configuration;

import com.amazon.clouddrive.metrics.MetricListener;

public class ClientConfiguration
{

    private int mConnectionTimeOutMillis;
    private String mMasterEndpoint;
    private int mMaxErrorRetry;
    private MetricListener mMetricListener;
    private int mReadTimeOutMillis;
    private String mUserAgent;

    public ClientConfiguration(ClientConfiguration clientconfiguration)
    {
        mMasterEndpoint = "https://drive.amazonaws.com/drive/v1/";
        mUserAgent = clientconfiguration.mUserAgent;
        mConnectionTimeOutMillis = clientconfiguration.mConnectionTimeOutMillis;
        mReadTimeOutMillis = clientconfiguration.mReadTimeOutMillis;
        mMasterEndpoint = clientconfiguration.mMasterEndpoint;
        setMaxErrorRetry(clientconfiguration.getMaxErrorRetry());
        mMetricListener = clientconfiguration.getMetricListener();
    }

    public ClientConfiguration(String s)
    {
        mMasterEndpoint = "https://drive.amazonaws.com/drive/v1/";
        mUserAgent = s;
        mConnectionTimeOutMillis = 60000;
        mReadTimeOutMillis = 60000;
        setMaxErrorRetry(5);
    }

    public int getConnectionTimeOutMillis()
    {
        return mConnectionTimeOutMillis;
    }

    public String getMasterEndpoint()
    {
        return mMasterEndpoint;
    }

    public int getMaxErrorRetry()
    {
        return mMaxErrorRetry;
    }

    public MetricListener getMetricListener()
    {
        return mMetricListener;
    }

    public int getReadTimeOutMillis()
    {
        return mReadTimeOutMillis;
    }

    public String getUserAgent()
    {
        return mUserAgent;
    }

    public void setMaxErrorRetry(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("The maxErrorRetry must be greater than or equal to zero.");
        } else
        {
            mMaxErrorRetry = i;
            return;
        }
    }

    public void setMetricListener(MetricListener metriclistener)
    {
        mMetricListener = metriclistener;
    }
}
