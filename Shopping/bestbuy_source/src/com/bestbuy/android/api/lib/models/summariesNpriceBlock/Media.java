// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            MediaImage

public class Media
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private MediaImage listImage;
    private MediaImage primaryImage;
    private MediaImage thumbnailImage;

    public Media()
    {
    }

    public MediaImage getListImage()
    {
        return listImage;
    }

    public MediaImage getPrimaryImage()
    {
        return primaryImage;
    }

    public MediaImage getThumbnailImage()
    {
        return thumbnailImage;
    }

    public void setListImage(MediaImage mediaimage)
    {
        listImage = mediaimage;
    }

    public void setPrimaryImage(MediaImage mediaimage)
    {
        primaryImage = mediaimage;
    }

    public void setThumbnailImage(MediaImage mediaimage)
    {
        thumbnailImage = mediaimage;
    }
}
