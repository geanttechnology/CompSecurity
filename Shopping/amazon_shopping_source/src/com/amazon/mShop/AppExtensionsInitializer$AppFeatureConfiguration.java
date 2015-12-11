// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import com.amazon.mShop.feature.Features;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;

// Referenced classes of package com.amazon.mShop:
//            AppExtensionsInitializer

private static class <init>
    implements FeatureConfiguration
{

    public String getFeatureState(String s)
    {
        return Features.getInstance().getFeatureState(s);
    }

    public boolean isFeatureActivated(String s)
    {
        return Features.getInstance().isFeatureActivated(s);
    }

    private ration()
    {
    }

    ration(ration ration)
    {
        this();
    }
}
