// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.image.Dimension;
import com.amazon.gallery.foundation.image.ImageUtils;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            DiskStore, Asset, DiskStorageUtils, DiskEvictor

public class CloudDriveAssetDiskCache
    implements DiskStore
{

    private static final String TAG = com/amazon/gallery/framework/data/store/CloudDriveAssetDiskCache.getName();
    private final File cacheStorageLocation;
    private final DiskEvictor diskEvictor;
    private final DiskStorageUtils diskStorageUtils;
    private final File originalStorageLocation;

    public CloudDriveAssetDiskCache(File file, DiskStorageUtils diskstorageutils, DiskEvictor diskevictor)
    {
        cacheStorageLocation = file;
        diskStorageUtils = diskstorageutils;
        diskEvictor = diskevictor;
        if (!file.exists() && !file.mkdir())
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to create cache directory: ").append(file.getAbsolutePath()).toString());
        }
        originalStorageLocation = new File(file, "originals");
        if (!originalStorageLocation.exists() && !originalStorageLocation.mkdir())
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to create originals cache directory: ").append(originalStorageLocation.getAbsolutePath()).toString());
        } else
        {
            return;
        }
    }

    public Asset getAsset(MediaItem mediaitem, int i, int j, Asset.AssetType assettype)
    {
        return getAsset(mediaitem, i, j, assettype, ScaleMode.SCALE_TO_FIT);
    }

    public Asset getAsset(MediaItem mediaitem, int i, int j, Asset.AssetType assettype, ScaleMode scalemode)
    {
        i = getBound(mediaitem, i, j, scalemode);
        mediaitem = Asset.createFromParameters(diskStorageUtils, cacheStorageLocation, mediaitem, i, assettype);
        if (mediaitem.getAsset().exists())
        {
            mediaitem.getAsset().setLastModified(System.currentTimeMillis());
        }
        return mediaitem;
    }

    public List getAssets(MediaItem mediaitem)
    {
        return getAssets(mediaitem, Asset.AssetType.JPG);
    }

    public List getAssets(MediaItem mediaitem, Asset.AssetType assettype)
    {
        Object obj = mediaitem.getObjectId();
        File file = diskStorageUtils.getMediaItemSizesPartition(cacheStorageLocation, ((ObjectID) (obj)));
        obj = new ArrayList();
        File afile[] = file.listFiles();
        if (afile != null)
        {
            int i = 0;
            while (i < afile.length) 
            {
                Asset asset = Asset.createFromSizeDir(diskStorageUtils, afile[i], mediaitem, assettype);
                if (asset != null && asset.getAsset().exists())
                {
                    ((List) (obj)).add(asset);
                }
                i++;
            }
        }
        return ((List) (obj));
    }

    public Asset getBestExistingAsset(MediaItem mediaitem, int i)
    {
        Object obj = null;
        Iterator iterator = getAssets(mediaitem).iterator();
        mediaitem = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Asset asset = (Asset)iterator.next();
            if (asset.getAsset().exists() && (mediaitem == null || asset.getP2Size() > mediaitem.getP2Size() && asset.getP2Size() <= i))
            {
                mediaitem = asset;
            }
        } while (true);
        return mediaitem;
    }

    protected int getBound(MediaItem mediaitem, int i, int j, ScaleMode scalemode)
    {
        int l = mediaitem.getHeight();
        int k = mediaitem.getWidth();
        mediaitem = new Dimension(i, j);
        mediaitem = ImageUtils.scaleDimension(new Dimension(k, l), mediaitem, scalemode);
        if (l > k)
        {
            return Math.min(((Dimension) (mediaitem)).height, 2048);
        }
        if (l < k)
        {
            return Math.min(((Dimension) (mediaitem)).width, 2048);
        }
        if (i <= j)
        {
            i = j;
        }
        return Math.min(Math.min(k, i), 2048);
    }

    public DiskStorageUtils getDiskStorageUtils()
    {
        return diskStorageUtils;
    }

    public File getOriginal(MediaItem mediaitem)
    {
        String s1 = (new StringBuilder()).append(".").append(FilenameUtils.getExtension(mediaitem.getName())).toString();
        String s = s1;
        if (mediaitem.getGroupType() == GroupType.LENTICULAR)
        {
            s = (new StringBuilder()).append(".len").append(s1).toString();
        }
        return new File(originalStorageLocation, (new StringBuilder()).append(mediaitem.getObjectId().toString()).append(s).toString());
    }

    public File getTempFileForAsset(long l, MediaItem mediaitem, int i, int j, Asset.AssetType assettype, ScaleMode scalemode)
    {
        i = getBound(mediaitem, i, j, scalemode);
        mediaitem = Asset.createFromParameters(diskStorageUtils, cacheStorageLocation, mediaitem, i, assettype);
        return diskStorageUtils.createFile((new StringBuilder()).append(mediaitem.getAsset().getAbsolutePath()).append(".tmp").append(l).toString());
    }

    public File getTempFileForOriginal(MediaItem mediaitem)
    {
        mediaitem = diskStorageUtils.createFile(getOriginal(mediaitem).getAbsolutePath());
        return diskStorageUtils.createFile((new StringBuilder()).append(mediaitem).append(".tmp").toString());
    }

    public void setProfiler(Profiler profiler)
    {
        diskEvictor.setProfiler(profiler);
    }

    public File storeAsset(long l, MediaItem mediaitem, int i, int j, Asset.AssetType assettype, ScaleMode scalemode)
    {
        if (diskEvictor.shouldPerformCleanup())
        {
            diskEvictor.cleanUp();
        }
        i = getBound(mediaitem, i, j, scalemode);
        assettype = Asset.createFromParameters(diskStorageUtils, cacheStorageLocation, mediaitem, i, assettype);
        scalemode = diskStorageUtils.createFile((new StringBuilder()).append(assettype.getAsset().getAbsolutePath()).append(".tmp").append(l).toString());
        File file = diskStorageUtils.createFile(assettype.getAsset().getAbsolutePath());
        if (file.exists())
        {
            GLogger.d(TAG, "Asset already exists, returning existing file.", new Object[0]);
            scalemode.delete();
            return file;
        }
        try
        {
            diskStorageUtils.storeFile(scalemode, file);
        }
        // Misplaced declaration of an exception variable
        catch (Asset.AssetType assettype)
        {
            GLogger.exf(TAG, assettype, "IOException in storing the file - %s", new Object[] {
                mediaitem.getObjectId()
            });
            return null;
        }
        if (file.exists())
        {
            boolean flag = mediaitem.hasProperty(CommonMediaProperty.LOCAL);
            diskEvictor.onStoreAsset(assettype, flag);
            return file;
        } else
        {
            return null;
        }
    }

    public File storeAsset(InputStream inputstream, long l, MediaItem mediaitem, int i, int j, Asset.AssetType assettype)
    {
        if (diskEvictor.shouldPerformCleanup())
        {
            diskEvictor.cleanUp();
        }
        i = getBound(mediaitem, i, j, ScaleMode.SCALE_TO_FILL);
        assettype = Asset.createFromParameters(diskStorageUtils, cacheStorageLocation, mediaitem, i, assettype);
        File file = diskStorageUtils.createFile((new StringBuilder()).append(assettype.getAsset().getAbsolutePath()).append(".tmp").append(Thread.currentThread().getId()).toString());
        File file1 = diskStorageUtils.createFile(assettype.getAsset().getAbsolutePath());
        if (file1.exists() && l == file1.length())
        {
            GLogger.d(TAG, "Asset already exists, returning existing file.", new Object[0]);
            file.delete();
            IOUtils.closeQuietly(inputstream);
            return file1;
        }
        try
        {
            diskStorageUtils.storeFile(inputstream, l, file, file1);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            GLogger.w(TAG, "IOException in storing the file - %s", new Object[] {
                mediaitem.getObjectId()
            });
            return null;
        }
        if (file1.exists())
        {
            boolean flag = mediaitem.hasProperty(CommonMediaProperty.LOCAL);
            diskEvictor.onStoreAsset(assettype, flag);
            return file1;
        } else
        {
            return null;
        }
    }

    public File storeOriginal(MediaItem mediaitem)
    {
        if (diskEvictor.shouldPerformCleanup())
        {
            diskEvictor.cleanUp();
        }
        File file = diskStorageUtils.createFile(getOriginal(mediaitem).getAbsolutePath());
        File file1 = diskStorageUtils.createFile((new StringBuilder()).append(file).append(".tmp").toString());
        if (file.exists())
        {
            GLogger.d(TAG, "Original already exists, returning existing file.", new Object[0]);
            file1.delete();
        } else
        {
            try
            {
                diskStorageUtils.storeFile(file1, file);
            }
            catch (IOException ioexception)
            {
                GLogger.w(TAG, "IOException in storing the file - %s", new Object[] {
                    mediaitem.getObjectId()
                });
                return null;
            }
            if (!file.exists())
            {
                return null;
            }
        }
        return file;
    }

}
