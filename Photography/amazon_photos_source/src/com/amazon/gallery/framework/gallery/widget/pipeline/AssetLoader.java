// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.pipeline;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class AssetLoader
{

    private static final String TAG = com/amazon/gallery/framework/gallery/widget/pipeline/AssetLoader.getName();
    private final DiskStore diskStore;
    private final NetworkStore networkStore;

    public AssetLoader(DiskStore diskstore, NetworkStore networkstore)
    {
        diskStore = diskstore;
        networkStore = networkstore;
    }

    private boolean isAssetValid(Asset asset)
    {
        return asset != null && asset.getAsset().exists();
    }

    public File load(MediaItem mediaitem, int i, int j)
    {
        if (!mediaitem.hasProperty(CommonMediaProperty.LOCAL)) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaitem.getType().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 54
    //                   2 68;
           goto _L3 _L4 _L5
_L3:
        DebugAssert.assertTrue(false);
_L7:
        return null;
_L4:
        return new File(mediaitem.getLocalPath());
_L5:
        Asset asset = diskStore.getAsset(mediaitem, i, j, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG);
        if (isAssetValid(asset))
        {
            return asset.getAsset();
        }
        Object obj1 = ThumbnailUtils.createVideoThumbnail(mediaitem.getLocalPath(), 1);
        if (obj1 == null)
        {
            GLogger.e(TAG, "Can't generate video thumbnail for %s", new Object[] {
                mediaitem.getObjectId()
            });
            return null;
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ((Bitmap) (obj1)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, bytearrayoutputstream);
            obj1 = new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
            return diskStore.storeAsset(((java.io.InputStream) (obj1)), bytearrayoutputstream.size(), mediaitem, i, j, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG);
        }
_L2:
        Object obj = ScaleMode.SCALE_TO_FILL;
        Asset asset1 = diskStore.getAsset(mediaitem, i, j, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG, ((ScaleMode) (obj)));
        if (isAssetValid(asset1))
        {
            return asset1.getAsset();
        }
        if (networkStore.loadContentSynchronously(mediaitem, i, j, ((ScaleMode) (obj)), com.amazon.gallery.framework.data.store.Asset.AssetType.JPG, true))
        {
            obj = diskStore.getAsset(mediaitem, i, j, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG, ((ScaleMode) (obj)));
            if (isAssetValid(((Asset) (obj))))
            {
                return ((Asset) (obj)).getAsset();
            }
            GLogger.e(TAG, "No Asset found from disk store after a successful network load. Item: %s", new Object[] {
                mediaitem.getObjectId()
            });
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

}
