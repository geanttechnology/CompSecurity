// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.searchapp.retailsearch.model.Sparkle;

public class SparkleModel
{
    public static class Builder
    {

        private boolean hasMargin;
        private ResourceProvider resourceProvider;
        private Sparkle sparkle;

        public SparkleModel build()
        {
            if (sparkle == null)
            {
                return null;
            } else
            {
                return new SparkleModel(sparkle, resourceProvider, hasMargin);
            }
        }

        public Builder setHasMargin(boolean flag)
        {
            hasMargin = flag;
            return this;
        }

        public Builder setResourceProvider(ResourceProvider resourceprovider)
        {
            resourceProvider = resourceprovider;
            return this;
        }

        public Builder(Sparkle sparkle1)
        {
            sparkle = sparkle1;
        }
    }


    private boolean hasMargin;
    private ResourceProvider resourceProvider;
    private Sparkle sparkle;

    private SparkleModel(Sparkle sparkle1, ResourceProvider resourceprovider, boolean flag)
    {
        sparkle = sparkle1;
        resourceProvider = resourceprovider;
        hasMargin = flag;
    }


    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public Sparkle getSparkle()
    {
        return sparkle;
    }

    public boolean hasMargin()
    {
        return hasMargin;
    }
}
