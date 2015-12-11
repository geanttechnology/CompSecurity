// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ActionLabel;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ActionLabelEntity extends RetailSearchEntity
    implements ActionLabel
{

    private List label;
    private String type;

    public ActionLabelEntity()
    {
    }

    public List getLabel()
    {
        return label;
    }

    public String getType()
    {
        return type;
    }

    public void setLabel(List list)
    {
        label = list;
    }

    public void setType(String s)
    {
        type = s;
    }
}
