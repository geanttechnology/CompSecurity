// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class FeedAutoRefreshFeature
{
    class Feature
    {

        int auto_refresh_interval;
        boolean enabled;
        final FeedAutoRefreshFeature this$0;

        Feature()
        {
            this$0 = FeedAutoRefreshFeature.this;
            super();
            enabled = false;
        }
    }


    Feature android;

    public FeedAutoRefreshFeature()
    {
    }

    public int geAutoRefreshIntervalInSeconds()
    {
        return android.auto_refresh_interval;
    }

    public boolean isEnabled()
    {
        if (android == null)
        {
            return false;
        } else
        {
            return android.enabled;
        }
    }
}
