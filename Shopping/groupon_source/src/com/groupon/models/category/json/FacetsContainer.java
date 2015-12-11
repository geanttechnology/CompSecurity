// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.category.json;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.models.category.json:
//            Facet

public class FacetsContainer
{

    public List facets;

    public FacetsContainer()
    {
    }

    public List getCategories(int i)
    {
        if (facets.size() > i)
        {
            return ((Facet)facets.get(i)).categories;
        } else
        {
            return Collections.EMPTY_LIST;
        }
    }
}
