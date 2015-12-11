// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.List;

public class Facets
{
    public class Facet
    {

        public String _type;
        public int missing;
        public int other;
        public List terms;
        final Facets this$0;
        public int total;

        public Facet()
        {
            this$0 = Facets.this;
            super();
        }
    }

    public class FacetItem
    {

        public int count;
        public String term;
        final Facets this$0;

        public String getDisplay()
        {
            return term;
        }

        public String getName()
        {
            return term;
        }

        public FacetItem()
        {
            this$0 = Facets.this;
            super();
        }
    }


    Facet availability;
    Facet brand;
    Facet category_feature;
    Facet category_v2;
    Facet color;
    Facet condition;
    Facet size;

    public Facets()
    {
    }

    public List getAvailabilityFacets()
    {
        if (availability != null)
        {
            return availability.terms;
        } else
        {
            return null;
        }
    }

    public List getBrandFacets()
    {
        if (brand != null)
        {
            return brand.terms;
        } else
        {
            return null;
        }
    }

    public List getCategoryFacets()
    {
        if (category_v2 != null)
        {
            return category_v2.terms;
        } else
        {
            return null;
        }
    }

    public List getColorFacets()
    {
        if (color != null)
        {
            return color.terms;
        } else
        {
            return null;
        }
    }

    public List getConditionFacets()
    {
        if (condition != null)
        {
            return condition.terms;
        } else
        {
            return null;
        }
    }

    public List getSizeFacets()
    {
        if (size != null)
        {
            return size.terms;
        } else
        {
            return null;
        }
    }

    public List getStyleTagsFacets()
    {
        if (category_feature != null)
        {
            return category_feature.terms;
        } else
        {
            return null;
        }
    }
}
