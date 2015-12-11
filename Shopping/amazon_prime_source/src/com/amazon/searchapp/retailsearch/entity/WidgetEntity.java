// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Widget;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class WidgetEntity extends RetailSearchEntity
    implements Widget
{

    private String id;

    public WidgetEntity()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String s)
    {
        id = s;
    }
}
