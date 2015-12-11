// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            ImageType

public class Media
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x32cd159ce399eeabL;
    private ImageType listImage;
    private ImageType primaryImage;
    private ImageType thumbnailImage;

    public Media()
    {
    }

    public ImageType getListImage()
    {
        return listImage;
    }

    public ImageType getPrimaryImage()
    {
        return primaryImage;
    }

    public ImageType getThumbnailImage()
    {
        return thumbnailImage;
    }

    public void setListImage(ImageType imagetype)
    {
        listImage = imagetype;
    }

    public void setPrimaryImage(ImageType imagetype)
    {
        primaryImage = imagetype;
    }

    public void setThumbnailImage(ImageType imagetype)
    {
        thumbnailImage = imagetype;
    }
}
