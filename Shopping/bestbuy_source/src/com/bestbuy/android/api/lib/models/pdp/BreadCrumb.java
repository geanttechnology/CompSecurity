// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            Link

public class BreadCrumb
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String categoryId;
    private String displayName;
    private Link link;

    public BreadCrumb()
    {
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public Link getLink()
    {
        return link;
    }

    public void setCategoryId(String s)
    {
        categoryId = s;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }
}
