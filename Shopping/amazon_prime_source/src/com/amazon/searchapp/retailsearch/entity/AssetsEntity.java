// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Assets;
import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class AssetsEntity extends RetailSearchEntity
    implements Assets
{

    private Map media;
    private Map strings;

    public AssetsEntity()
    {
    }

    public Map getMedia()
    {
        return media;
    }

    public Map getStrings()
    {
        return strings;
    }

    public void setMedia(Map map)
    {
        media = map;
    }

    public void setStrings(Map map)
    {
        strings = map;
    }
}
