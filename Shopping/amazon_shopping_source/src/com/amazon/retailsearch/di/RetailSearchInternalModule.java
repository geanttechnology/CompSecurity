// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.di;

import android.content.Context;
import com.amazon.ansel.fetch.LoaderContext;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.experimentation.WeblabClient;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.data.RetailSearchDataProvider;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.SearchUserInteractionListener;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.metrics.SearchMetricsListenerInvoker;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;

public class RetailSearchInternalModule
{

    private Context context;
    private FeatureConfiguration featureConfiguration;
    private WeblabClient weblabClient;

    public RetailSearchInternalModule()
    {
        context = null;
        featureConfiguration = null;
    }

    public RetailSearchInternalModule(Context context1, FeatureConfiguration featureconfiguration, WeblabClient weblabclient)
    {
        context = context1;
        featureConfiguration = featureconfiguration;
        weblabClient = weblabclient;
    }

    UserPreferenceManager providUserPreferenceManager(Context context1)
    {
        return new UserPreferenceManager(context1);
    }

    UserInteractionListener provideActionListener()
    {
        return new SearchUserInteractionListener();
    }

    Context provideContext()
    {
        return context;
    }

    FeatureConfiguration provideFeatureConfiguration()
    {
        return featureConfiguration;
    }

    LoaderContext provideLoaderContext(Context context1)
    {
        return (new com.amazon.ansel.fetch.LoaderContext.Builder(context1)).setUseWeakResourceListeners(true).build();
    }

    ResourceProvider provideResourceProvider(LoaderContext loadercontext)
    {
        return new ResourceProvider(loadercontext);
    }

    RetailSearchAndroidPlatform provideRetailSearchAndroidPlatform(Context context1)
    {
        return new RetailSearchAndroidPlatform(context1);
    }

    IRetailSearchDataProvider provideRetailSearchDataProvider()
    {
        return new RetailSearchDataProvider();
    }

    SearchDataSource provideSearchDataSource()
    {
        return new SearchDataSource();
    }

    SearchMetricsListenerInvoker provideSearchMetricsListenerInvoker()
    {
        return new SearchMetricsListenerInvoker();
    }
}
