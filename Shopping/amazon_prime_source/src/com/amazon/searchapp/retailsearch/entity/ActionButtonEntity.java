// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ActionButton;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ActionButtonEntity extends RetailSearchEntity
    implements ActionButton
{

    private String type;

    public ActionButtonEntity()
    {
    }

    public String getType()
    {
        return type;
    }

    public void setType(String s)
    {
        type = s;
    }
}
