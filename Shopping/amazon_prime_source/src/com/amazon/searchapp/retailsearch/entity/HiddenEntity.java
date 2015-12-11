// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Hidden;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class HiddenEntity extends RetailSearchEntity
    implements Hidden
{

    private String label;
    private String type;

    public HiddenEntity()
    {
    }

    public String getLabel()
    {
        return label;
    }

    public String getType()
    {
        return type;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setType(String s)
    {
        type = s;
    }
}
