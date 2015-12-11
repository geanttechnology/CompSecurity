// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import android.text.TextUtils;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.results.layout.FilterRequestListener;
import com.amazon.retailsearch.android.ui.results.layout.widget.AppIntentType;
import com.amazon.searchapp.retailsearch.model.AppIntent;
import com.amazon.searchapp.retailsearch.model.ImageSparkle;
import com.amazon.searchapp.retailsearch.model.RefinementFilter;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import java.util.Iterator;
import java.util.List;

public class ImageSparkleModel
{
    public static class Builder
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
                return new ImageSparkleModel(imageSparkle, resourceProvider, filterRequestListener, refinements);
            }
        }

        public Builder setFilterRequestListener(FilterRequestListener filterrequestlistener)
        {
            filterRequestListener = filterrequestlistener;
            return this;
        }

        public Builder setRefinements(Refinements refinements1)
        {
            refinements = refinements1;
            return this;
        }

        public Builder(ImageSparkle imagesparkle, ResourceProvider resourceprovider)
        {
            imageSparkle = imagesparkle;
            resourceProvider = resourceprovider;
        }
    }


    private FilterRequestListener filterRequestListener;
    private ImageSparkle imageSparkle;
    private ResourceProvider resourceProvider;
    private boolean shouldDisplay;

    private ImageSparkleModel(ImageSparkle imagesparkle, ResourceProvider resourceprovider, FilterRequestListener filterrequestlistener, Refinements refinements)
    {
        imageSparkle = imagesparkle;
        resourceProvider = resourceprovider;
        filterRequestListener = filterrequestlistener;
        computeShouldDisplay(refinements);
    }


    public void computeShouldDisplay(Refinements refinements)
    {
        if (imageSparkle != null) goto _L2; else goto _L1
_L1:
        shouldDisplay = false;
_L8:
        return;
_L2:
        String s;
        if (imageSparkle.getAction() == null || !AppIntentType.FILTER_BY_ID.getValue().equals(imageSparkle.getAction().getType()))
        {
            shouldDisplay = true;
            return;
        }
        s = imageSparkle.getAction().getValue();
        if (TextUtils.isEmpty(s))
        {
            shouldDisplay = false;
            return;
        }
        if (refinements == null || refinements.getFilters() == null)
        {
            shouldDisplay = false;
            return;
        }
        refinements = refinements.getFilters().iterator();
_L4:
        Object obj;
        do
        {
            if (!refinements.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (RefinementFilter)refinements.next();
        } while (obj == null || ((RefinementFilter) (obj)).getValues() == null);
        obj = ((RefinementFilter) (obj)).getValues().iterator();
_L6:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        RefinementLink refinementlink = (RefinementLink)((Iterator) (obj)).next();
        if (!s.equals(refinementlink.getId())) goto _L6; else goto _L5
_L5:
        if (!refinementlink.getSelected())
        {
            shouldDisplay = true;
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
        shouldDisplay = false;
        return;
    }

    public FilterRequestListener getFilterRequestListener()
    {
        return filterRequestListener;
    }

    public ImageSparkle getImageSparkle()
    {
        return imageSparkle;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public boolean shouldDisplay()
    {
        return shouldDisplay;
    }
}
