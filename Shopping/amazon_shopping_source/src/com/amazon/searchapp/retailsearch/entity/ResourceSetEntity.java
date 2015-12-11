// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ResourceSet;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ResourceSetEntity extends RetailSearchEntity
    implements ResourceSet
{

    private String id;
    private List images;
    private List strings;
    private String version;

    public ResourceSetEntity()
    {
    }

    public String getId()
    {
        return id;
    }

    public List getImages()
    {
        return images;
    }

    public List getStrings()
    {
        return strings;
    }

    public String getVersion()
    {
        return version;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setImages(List list)
    {
        images = list;
    }

    public void setStrings(List list)
    {
        strings = list;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
