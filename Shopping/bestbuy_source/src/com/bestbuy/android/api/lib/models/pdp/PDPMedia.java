// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import gu;
import java.io.Serializable;
import java.util.List;

public class PDPMedia
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private MediaImage backImage;
    private List galleryImages;
    private MediaImage primaryImage;

    public PDPMedia()
    {
    }

    public MediaImage getBackImage()
    {
        return backImage;
    }

    public List getGalleryImages()
    {
        return galleryImages;
    }

    public MediaImage getPrimaryImage()
    {
        return primaryImage;
    }

    public void setBackImage(MediaImage mediaimage)
    {
        backImage = mediaimage;
    }

    public void setGalleryImages(List list)
    {
        galleryImages = list;
    }

    public void setPrimaryImage(MediaImage mediaimage)
    {
        primaryImage = mediaimage;
    }
}
