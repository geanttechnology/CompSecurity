// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.SuggestionDepartment;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SuggestionDepartmentEntity extends RetailSearchEntity
    implements SuggestionDepartment
{

    private String alias;
    private String name;

    public SuggestionDepartmentEntity()
    {
    }

    public String getAlias()
    {
        return alias;
    }

    public String getName()
    {
        return name;
    }

    public void setAlias(String s)
    {
        alias = s;
    }

    public void setName(String s)
    {
        name = s;
    }
}
