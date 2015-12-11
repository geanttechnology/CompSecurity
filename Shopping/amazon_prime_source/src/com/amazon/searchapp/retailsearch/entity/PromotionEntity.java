// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Promotion;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PromotionEntity extends RetailSearchEntity
    implements Promotion
{

    private String text;
    private String type;

    public PromotionEntity()
    {
    }

    public String getText()
    {
        return text;
    }

    public String getType()
    {
        return type;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setType(String s)
    {
        type = s;
    }
}
