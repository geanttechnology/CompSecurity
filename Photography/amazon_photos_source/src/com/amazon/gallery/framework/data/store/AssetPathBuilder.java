// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            Asset

public class AssetPathBuilder
{

    private Asset.AssetType assetType;
    private File baseStorageLocation;
    private boolean isCloudPhoto;
    private MediaItem mediaItem;
    private final StringBuilder stringBuilder = new StringBuilder();

    public AssetPathBuilder()
    {
    }

    public String build()
    {
        stringBuilder.setLength(0);
        stringBuilder.append(baseStorageLocation.getAbsolutePath());
        stringBuilder.append("/");
        stringBuilder.append(mediaItem.getObjectId());
        stringBuilder.append(".");
        stringBuilder.append(mediaItem.getAssetHash());
        stringBuilder.append(".");
        stringBuilder.append(Asset.getTag(isCloudPhoto));
        if (assetType == Asset.AssetType.SQUARE_JPG)
        {
            stringBuilder.append(".");
            stringBuilder.append("square");
        }
        stringBuilder.append(assetType.ext);
        return stringBuilder.toString();
    }

    public AssetPathBuilder setAssetType(Asset.AssetType assettype)
    {
        assetType = assettype;
        return this;
    }

    public AssetPathBuilder setBaseStorageLocation(File file)
    {
        baseStorageLocation = file;
        return this;
    }

    public AssetPathBuilder setMediaItem(MediaItem mediaitem)
    {
        mediaItem = mediaitem;
        boolean flag;
        if (!mediaitem.hasProperty(CommonMediaProperty.LOCAL))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isCloudPhoto = flag;
        return this;
    }

    public String toString()
    {
        return build();
    }
}
