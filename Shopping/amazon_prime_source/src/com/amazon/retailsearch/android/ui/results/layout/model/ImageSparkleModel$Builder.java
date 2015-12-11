// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.results.layout.FilterRequestListener;
import com.amazon.searchapp.retailsearch.model.ImageSparkle;
import com.amazon.searchapp.retailsearch.model.Refinements;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.model:
//            ImageSparkleModel

public static class resourceProvider
{

    private FilterRequestListener filterRequestListener;
    private ImageSparkle imageSparkle;
    private Refinements refinements;
    private ResourceProvider resourceProvider;

    public ImageSparkleModel build()
    {
        if (imageSparkle == null || resourceProvider == null)
        {
            return null;
        } else
        {
            return new ImageSparkleModel(imageSparkle, resourceProvider, filterRequestListener, refinements, null);
        }
    }

    public refinements setFilterRequestListener(FilterRequestListener filterrequestlistener)
    {
        filterRequestListener = filterrequestlistener;
        return this;
    }

    public filterRequestListener setRefinements(Refinements refinements1)
    {
        refinements = refinements1;
        return this;
    }

    public (ImageSparkle imagesparkle, ResourceProvider resourceprovider)
    {
        imageSparkle = imagesparkle;
        resourceProvider = resourceprovider;
    }
}
