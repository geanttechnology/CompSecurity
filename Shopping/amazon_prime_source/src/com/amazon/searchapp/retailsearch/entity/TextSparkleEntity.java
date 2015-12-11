// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.TextSparkle;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class TextSparkleEntity extends RetailSearchEntity
    implements TextSparkle
{

    private String id;
    private List text;
    private String url;

    public TextSparkleEntity()
    {
    }

    public String getId()
    {
        return id;
    }

    public List getText()
    {
        return text;
    }

    public String getUrl()
    {
        return url;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setText(List list)
    {
        text = list;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
