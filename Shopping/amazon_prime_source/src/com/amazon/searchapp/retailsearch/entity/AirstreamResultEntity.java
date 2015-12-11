// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AirstreamResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class AirstreamResultEntity extends RetailSearchEntity
    implements AirstreamResult
{

    private String cursor;
    private String favoritesRequestToken;
    private boolean newCursor;
    private String queryId;
    private String requestId;

    public AirstreamResultEntity()
    {
    }

    public String getCursor()
    {
        return cursor;
    }

    public String getFavoritesRequestToken()
    {
        return favoritesRequestToken;
    }

    public boolean getNewCursor()
    {
        return newCursor;
    }

    public String getQueryId()
    {
        return queryId;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public void setCursor(String s)
    {
        cursor = s;
    }

    public void setFavoritesRequestToken(String s)
    {
        favoritesRequestToken = s;
    }

    public void setNewCursor(boolean flag)
    {
        newCursor = flag;
    }

    public void setQueryId(String s)
    {
        queryId = s;
    }

    public void setRequestId(String s)
    {
        requestId = s;
    }
}
