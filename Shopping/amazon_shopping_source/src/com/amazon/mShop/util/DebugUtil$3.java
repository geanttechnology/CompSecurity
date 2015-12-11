// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.mShop.feature.FeatureStateSubscriber;
import com.amazon.mShop.feature.Features;

// Referenced classes of package com.amazon.mShop.util:
//            DebugUtil

static final class > extends WebViewClient
{

    final FeatureStateSubscriber val$subscriber;

    public void onPageFinished(WebView webview, String s)
    {
        Features.getInstance().addFeatureStateSubscriber(val$subscriber);
        Features.getInstance().fetchFeatureStates(true);
    }

    ateSubscriber(FeatureStateSubscriber featurestatesubscriber)
    {
        val$subscriber = featurestatesubscriber;
        super();
    }
}
