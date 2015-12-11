// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Contributor;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ContributorEntity extends RetailSearchEntity
    implements Contributor
{

    private String displayableRole;
    private String name;
    private String role;
    private String url;

    public ContributorEntity()
    {
    }

    public String getDisplayableRole()
    {
        return displayableRole;
    }

    public String getName()
    {
        return name;
    }

    public String getRole()
    {
        return role;
    }

    public String getUrl()
    {
        return url;
    }

    public void setDisplayableRole(String s)
    {
        displayableRole = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setRole(String s)
    {
        role = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
