// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AppIntent;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class AppIntentEntity extends RetailSearchEntity
    implements AppIntent
{

    private String type;
    private String value;

    public AppIntentEntity()
    {
    }

    public String getType()
    {
        return type;
    }

    public String getValue()
    {
        return value;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
