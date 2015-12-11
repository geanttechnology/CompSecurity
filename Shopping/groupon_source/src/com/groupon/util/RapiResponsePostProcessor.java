// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.RapiSearchResponse;
import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RapiResponsePostProcessor
{

    private RapiSearchResponse response;

    public RapiResponsePostProcessor()
    {
    }

    public RapiResponsePostProcessor(RapiSearchResponse rapisearchresponse)
    {
        response = rapisearchresponse;
    }

    private void applyDepthRecursivelyToChildFacetValues(int i, FacetValue facetvalue)
    {
        facetvalue.derivedDepth = i;
        for (facetvalue = facetvalue.children.iterator(); facetvalue.hasNext(); applyDepthRecursivelyToChildFacetValues(i + 1, (FacetValue)facetvalue.next())) { }
    }

    public RapiResponsePostProcessor addDepthToChildFacetValues()
    {
        if (response == null)
        {
            throw new IllegalStateException("Should set response before calling addDepthToChildFacetValues");
        }
        if (response.facets != null)
        {
            Iterator iterator = response.facets.iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (Facet)iterator.next();
                if (((Facet) (obj)).isNested())
                {
                    obj = ((Facet) (obj)).getValues().iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        applyDepthRecursivelyToChildFacetValues(0, (FacetValue)((Iterator) (obj)).next());
                    }
                }
            }
        }
        return this;
    }

    public RapiSearchResponse finish()
    {
        return response;
    }

    public RapiResponsePostProcessor removeBlacklistedFacetsById(List list)
    {
        if (list != null && list.size() > 0)
        {
            Object obj = new ArrayList();
            Iterator iterator = response.facets.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Facet facet = (Facet)iterator.next();
                if (list.contains(facet.id))
                {
                    ((List) (obj)).add(facet);
                }
            } while (true);
            for (list = ((List) (obj)).iterator(); list.hasNext(); response.facets.remove(obj))
            {
                obj = (Facet)list.next();
            }

        }
        return this;
    }

    public RapiResponsePostProcessor setResponse(RapiSearchResponse rapisearchresponse)
    {
        response = rapisearchresponse;
        return this;
    }
}
