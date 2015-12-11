// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Decorations;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class DecorationsEntity extends RetailSearchEntity
    implements Decorations
{

    private List actionLabels;
    private List header;
    private List tracking;

    public DecorationsEntity()
    {
    }

    public List getActionLabels()
    {
        return actionLabels;
    }

    public List getHeader()
    {
        return header;
    }

    public List getTracking()
    {
        return tracking;
    }

    public void setActionLabels(List list)
    {
        actionLabels = list;
    }

    public void setHeader(List list)
    {
        header = list;
    }

    public void setTracking(List list)
    {
        tracking = list;
    }
}
