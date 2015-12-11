// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.models:
//            GiftingImages

public class GiftingTheme
{

    protected static final GiftingImages defaultImages = new GiftingImages();
    public String categoryUuid;
    public Collection categoryUuids;
    public String channel;
    public String id;
    public String imageBackgroundUrl;
    public String imageThumbnailUrl;
    public GiftingImages images;
    public Date modificationDate;
    public Long primaryKey;
    public String remoteId;

    public GiftingTheme()
    {
        images = defaultImages;
        imageThumbnailUrl = "";
        imageBackgroundUrl = "";
        categoryUuid = "";
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (images != null)
        {
            imageThumbnailUrl = images.imageThumbnail.url;
            imageBackgroundUrl = images.imageBackground.url;
        }
        if (categoryUuids != null && categoryUuids.size() >= 1)
        {
            categoryUuid = (String)categoryUuids.iterator().next();
        }
    }

}
