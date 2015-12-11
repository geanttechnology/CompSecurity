// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.PreloadImages;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PreloadImagesEntity extends RetailSearchEntity
    implements PreloadImages
{

    private List images;

    public PreloadImagesEntity()
    {
    }

    public List getImages()
    {
        return images;
    }

    public void setImages(List list)
    {
        images = list;
    }
}
