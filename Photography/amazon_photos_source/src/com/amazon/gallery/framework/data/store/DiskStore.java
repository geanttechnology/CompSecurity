// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;
import java.io.InputStream;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            Asset, DiskStorageUtils

public interface DiskStore
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent CacheEvict;
        public static final MetricsEvent CacheHit;
        public static final MetricsEvent CacheMiss;
        public static final MetricsEvent CachePartialHit;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/data/store/DiskStore$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            CacheEvict = new MetricsEvent("CacheEvict", 0);
            CacheHit = new MetricsEvent("CacheHit", 1);
            CachePartialHit = new MetricsEvent("CachePartialHit", 2);
            CacheMiss = new MetricsEvent("CacheMiss", 3);
            $VALUES = (new MetricsEvent[] {
                CacheEvict, CacheHit, CachePartialHit, CacheMiss
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract Asset getAsset(MediaItem mediaitem, int i, int j, Asset.AssetType assettype);

    public abstract Asset getAsset(MediaItem mediaitem, int i, int j, Asset.AssetType assettype, ScaleMode scalemode);

    public abstract Asset getBestExistingAsset(MediaItem mediaitem, int i);

    public abstract DiskStorageUtils getDiskStorageUtils();

    public abstract File getOriginal(MediaItem mediaitem);

    public abstract File getTempFileForAsset(long l, MediaItem mediaitem, int i, int j, Asset.AssetType assettype, ScaleMode scalemode);

    public abstract File getTempFileForOriginal(MediaItem mediaitem);

    public abstract File storeAsset(long l, MediaItem mediaitem, int i, int j, Asset.AssetType assettype, ScaleMode scalemode);

    public abstract File storeAsset(InputStream inputstream, long l, MediaItem mediaitem, int i, int j, Asset.AssetType assettype);

    public abstract File storeOriginal(MediaItem mediaitem);
}
