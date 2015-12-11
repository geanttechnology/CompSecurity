// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.PantryBoxFill;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PantryBoxFillEntity extends RetailSearchEntity
    implements PantryBoxFill
{

    private String message;

    public PantryBoxFillEntity()
    {
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String s)
    {
        message = s;
    }
}
