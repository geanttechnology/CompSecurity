// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Domain;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class DomainEntity extends RetailSearchEntity
    implements Domain
{

    private List domains;
    private String id;
    private String label;
    private String value;

    public DomainEntity()
    {
    }

    public List getDomains()
    {
        return domains;
    }

    public String getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public String getValue()
    {
        return value;
    }

    public void setDomains(List list)
    {
        domains = list;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
