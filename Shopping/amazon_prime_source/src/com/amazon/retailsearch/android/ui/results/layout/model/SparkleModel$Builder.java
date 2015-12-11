// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.searchapp.retailsearch.model.Sparkle;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.model:
//            SparkleModel

public static class sparkle
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
            return new SparkleModel(sparkle, resourceProvider, hasMargin, null);
        }
    }

    public hasMargin setHasMargin(boolean flag)
    {
        hasMargin = flag;
        return this;
    }

    public hasMargin setResourceProvider(ResourceProvider resourceprovider)
    {
        resourceProvider = resourceprovider;
        return this;
    }

    public (Sparkle sparkle1)
    {
        sparkle = sparkle1;
    }
}
