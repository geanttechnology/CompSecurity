// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.db.models.Features;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.Relevance;
import com.groupon.models.search.data.Facet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public class RapiSearchResponse
{

    public List cards;
    public List dealSubsetAttributes;
    public List facets;
    public Features features;
    public Pagination pagination;
    public Relevance relevanceService;

    public RapiSearchResponse()
    {
        facets = new ArrayList();
    }

    public boolean containsFacet(String s)
    {
        for (Iterator iterator = facets.iterator(); iterator.hasNext();)
        {
            Facet facet = (Facet)iterator.next();
            if (Strings.equals(s, facet.id) && !facet.getValues().isEmpty())
            {
                return true;
            }
        }

        return false;
    }
}
