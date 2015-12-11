// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Current;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class CurrentEntity extends RetailSearchEntity
    implements Current
{

    private List labels;

    public CurrentEntity()
    {
    }

    public List getLabels()
    {
        return labels;
    }

    public void setLabels(List list)
    {
        labels = list;
    }
}
