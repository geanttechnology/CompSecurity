// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import android.content.Intent;
import com.amazon.mas.client.deviceservice.MasDsClient;
import com.amazon.mas.client.http.WebHttpClient;
import com.amazon.zeroes.intentservice.ZeroesPurchaseRequestDecorator;
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;
import dagger.Lazy;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            GetBalanceAction, GetBundleDetailsAction, GetPreferencesAction, SetPreferencesAction, 
//            GetTaxPreviewAction, PurchaseBundleAction, HttpGetAction, SubmitMetricAction, 
//            PopulateCacheAction, ZeroesAction

public class ActionFactory
{

    private Lazy lazyCache;
    private Lazy lazyDecorator;
    private Lazy lazyMasDsClient;
    private Lazy lazyWebHttpClient;

    public ActionFactory(Lazy lazy, Lazy lazy1, Lazy lazy2, Lazy lazy3)
    {
        lazyMasDsClient = lazy;
        lazyWebHttpClient = lazy1;
        lazyCache = lazy2;
        lazyDecorator = lazy3;
    }

    public ZeroesAction getActionFromIntent(Intent intent)
        throws Exception
    {
        String s = intent.getAction();
        if (GetBalanceAction.ACTION_REQUEST.equals(s))
        {
            return new GetBalanceAction(intent, (MasDsClient)lazyMasDsClient.get(), (ZeroesCache)lazyCache.get());
        }
        if (GetBundleDetailsAction.ACTION_REQUEST.equals(s))
        {
            return new GetBundleDetailsAction(intent, (MasDsClient)lazyMasDsClient.get(), (ZeroesCache)lazyCache.get());
        }
        if (GetPreferencesAction.ACTION_REQUEST.equals(s))
        {
            return new GetPreferencesAction(intent, (MasDsClient)lazyMasDsClient.get(), (ZeroesCache)lazyCache.get());
        }
        if (SetPreferencesAction.ACTION_REQUEST.equals(s))
        {
            return new SetPreferencesAction(intent, (MasDsClient)lazyMasDsClient.get(), (ZeroesCache)lazyCache.get());
        }
        if (GetTaxPreviewAction.ACTION_REQUEST.equals(s))
        {
            return new GetTaxPreviewAction(intent, (MasDsClient)lazyMasDsClient.get());
        }
        if (PurchaseBundleAction.ACTION_REQUEST.equals(s))
        {
            return new PurchaseBundleAction(intent, (MasDsClient)lazyMasDsClient.get(), (ZeroesCache)lazyCache.get(), (ZeroesPurchaseRequestDecorator)lazyDecorator.get());
        }
        if (HttpGetAction.ACTION_REQUEST.equals(s))
        {
            return new HttpGetAction(intent, (WebHttpClient)lazyWebHttpClient.get());
        }
        if (SubmitMetricAction.ACTION_REQUEST.equals(s))
        {
            return new SubmitMetricAction(intent);
        }
        if (PopulateCacheAction.ACTION_REQUEST.equals(s))
        {
            return new PopulateCacheAction(intent, (ZeroesCache)lazyCache.get());
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("Unknown action: ").append(s).toString());
        }
    }
}
