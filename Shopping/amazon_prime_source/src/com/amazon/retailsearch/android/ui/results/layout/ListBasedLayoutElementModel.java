// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.util.Utils;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            LayoutElementModel

public class ListBasedLayoutElementModel
    implements LayoutElementModel
{

    private List models;

    public ListBasedLayoutElementModel(List list)
    {
        models = list;
    }

    public static ListBasedLayoutElementModel create(List list)
    {
        return new ListBasedLayoutElementModel(list);
    }

    public List getAllModels()
    {
        return models;
    }

    public Object getCanonicalModel()
    {
        if (Utils.isEmpty(models))
        {
            return null;
        } else
        {
            return models.get(0);
        }
    }
}
