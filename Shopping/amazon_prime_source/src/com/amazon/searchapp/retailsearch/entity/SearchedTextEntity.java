// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.SearchedText;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SearchedTextEntity extends RetailSearchEntity
    implements SearchedText
{

    private String alias;
    private String deleteUrl;
    private String displayAlias;
    private long eventTimestamp;
    private String id;
    private String keywords;

    public SearchedTextEntity()
    {
    }

    public String getAlias()
    {
        return alias;
    }

    public String getDeleteUrl()
    {
        return deleteUrl;
    }

    public String getDisplayAlias()
    {
        return displayAlias;
    }

    public long getEventTimestamp()
    {
        return eventTimestamp;
    }

    public String getId()
    {
        return id;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public void setAlias(String s)
    {
        alias = s;
    }

    public void setDeleteUrl(String s)
    {
        deleteUrl = s;
    }

    public void setDisplayAlias(String s)
    {
        displayAlias = s;
    }

    public void setEventTimestamp(long l)
    {
        eventTimestamp = l;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setKeywords(String s)
    {
        keywords = s;
    }
}
