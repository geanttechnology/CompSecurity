// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.FavoritesError;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class FavoritesErrorEntity extends RetailSearchEntity
    implements FavoritesError
{

    private String id;
    private String message;

    public FavoritesErrorEntity()
    {
    }

    public String getId()
    {
        return id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setMessage(String s)
    {
        message = s;
    }
}
