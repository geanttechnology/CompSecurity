// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Feature

public class FeedLazyLoadFeature extends com.poshmark.data_model.models.inner_models.Feature
{
    class Feature
    {

        int bubble_display_interval;
        boolean enabled;
        final FeedLazyLoadFeature this$0;
        String title;

        Feature()
        {
            this$0 = FeedLazyLoadFeature.this;
            super();
            enabled = false;
        }
    }


    Feature android;

    public FeedLazyLoadFeature()
    {
    }

    public int geBubbleDisplayIntervalInSeconds()
    {
        return android.bubble_display_interval;
    }

    public String getTitle()
    {
        return android.title;
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
