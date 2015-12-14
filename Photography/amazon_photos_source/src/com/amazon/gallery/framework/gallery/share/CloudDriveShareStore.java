// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.gfx.texture.LocalVideoThumbnailResource;
import com.amazon.gallery.foundation.image.VideoThumbnailUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskStorageUtils;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.lenticular.GalleryLenticularHelper;
import com.amazon.gallery.framework.gallery.utils.GifGenerator;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.Frame;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.amazon.gallery.framework.gallery.share:
//            ShareStore

public class CloudDriveShareStore
    implements ShareStore
{

    private static final String TAG = com/amazon/gallery/framework/gallery/share/CloudDriveShareStore.getName();
    private final Context context;
    private final DiskStore diskStore;
    private final GifGenerator gifGenerator = new GifGenerator();
    private final GalleryLenticularHelper lenticularHelper;
    private final NetworkStore networkStore;
    private final File sharedDirectory;

    public CloudDriveShareStore(Context context1, File file, DiskStore diskstore, NetworkStore networkstore, GalleryLenticularHelper gallerylenticularhelper)
    {
        context = context1;
        sharedDirectory = file;
        diskStore = diskstore;
        networkStore = networkstore;
        lenticularHelper = gallerylenticularhelper;
    }

    private File generateLenticularGif(OrderedGroupPhoto orderedgroupphoto)
    {
        Object obj = null;
        List list1;
        com.amazon.gallery.framework.gallery.utils.GifEncoderParams.Builder builder;
        double d = 300D / (double)Math.max(orderedgroupphoto.getHeight(), orderedgroupphoto.getWidth());
        builder = (new com.amazon.gallery.framework.gallery.utils.GifEncoderParams.Builder()).withDelay(500).withQuality(15).withRepeat(100).withDimension(orderedgroupphoto.getWidth(), orderedgroupphoto.getHeight()).withScale(d).withOutputFileName(File.createTempFile("tmp", ".gif", sharedDirectory).getAbsolutePath());
        list1 = orderedgroupphoto.getFrames();
        List list;
        if (list1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        list = list1;
        if (list1.size() != 0)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        list = lenticularHelper.loadFrames(orderedgroupphoto);
        if (list == null) goto _L2; else goto _L1
_L1:
        if (list.size() != 0) goto _L3; else goto _L2
_L3:
        for (orderedgroupphoto = list.iterator(); orderedgroupphoto.hasNext(); builder.withInputFileName(((Frame)orderedgroupphoto.next()).getLocalPath())) { }
          goto _L4
_L5:
        return orderedgroupphoto;
_L4:
        try
        {
            orderedgroupphoto = gifGenerator.generate(builder.build());
        }
        // Misplaced declaration of an exception variable
        catch (OrderedGroupPhoto orderedgroupphoto)
        {
            GLogger.ex(TAG, "Failed to generate GIF file.", orderedgroupphoto);
            orderedgroupphoto = obj;
        }
        if (true) goto _L5; else goto _L2
_L2:
        return null;
    }

    private String getExtension(File file)
    {
        file = file.getName();
        int i = file.lastIndexOf('.');
        if (i > 0)
        {
            return file.substring(i);
        } else
        {
            return null;
        }
    }

    private File moveToDirectory(File file, File file1, String s)
        throws IOException
    {
        s = diskStore.getDiskStorageUtils().createFile(file1, s);
        file1 = s;
        if (s.exists())
        {
            file1 = s;
            if (s.length() != file.length())
            {
                file1 = resolveNameConflict(s, file.length());
            }
        }
        if (file1.exists() && file1.length() == file.length())
        {
            return file1;
        } else
        {
            diskStore.getDiskStorageUtils().storeFile(file, file1);
            return file1;
        }
    }

    private boolean needsReencode(MediaItem mediaitem, com.amazon.gallery.framework.data.store.Asset.AssetType assettype)
    {
        return mediaitem.getMIMEType().equals("image/gif") && com.amazon.gallery.framework.data.store.Asset.AssetType.JPG == assettype || MediaItemUtil.isFreeTime(mediaitem);
    }

    private boolean needsResize(MediaItem mediaitem, int i, int j)
    {
        return mediaitem.getType() == MediaType.PHOTO && (mediaitem.getWidth() > i || mediaitem.getHeight() > j);
    }

    private File prepareMediaItemForSharingRepeatIfFailure(MediaItem mediaitem, int i, int j, com.amazon.gallery.framework.data.store.Asset.AssetType assettype, int k, int l, File file)
    {
        if (l != k) goto _L2; else goto _L1
_L1:
        Object obj;
        assettype = TAG;
        if (mediaitem == null)
        {
            mediaitem = "mediaitem null";
        } else
        {
            mediaitem = mediaitem.getObjectId().toString();
        }
        GLogger.e(assettype, "giving up, retry limit %d reached for %s", new Object[] {
            Integer.valueOf(k), mediaitem
        });
        obj = null;
_L4:
        return ((File) (obj));
_L2:
        Object obj1;
        boolean flag = true;
        boolean flag1 = true;
        if (file == null)
        {
            GLogger.e(TAG, "No share directory available", new Object[0]);
            return null;
        }
        if (!file.exists())
        {
            file.mkdirs();
        }
        String s;
        String s1;
        if (GroupType.LENTICULAR == mediaitem.getGroupType() && com.amazon.gallery.framework.data.store.Asset.AssetType.GIF == assettype)
        {
            obj = generateLenticularGif((OrderedGroupPhoto)mediaitem);
            if (obj == null)
            {
                mediaitem = diskStore.getBestExistingAsset(mediaitem, Math.min(i, j));
                if (mediaitem == null)
                {
                    return null;
                } else
                {
                    return mediaitem.getAsset();
                }
            }
            obj1 = getExtension(((File) (obj)));
        } else
        {
label0:
            {
                if (!mediaitem.hasProperty(CommonMediaProperty.LOCAL))
                {
                    break label0;
                }
                obj = mediaitem.getLocalPath();
                if (GroupType.LENTICULAR == mediaitem.getGroupType() && com.amazon.gallery.framework.data.store.Asset.AssetType.GIF == assettype)
                {
                    obj = generateLenticularGif((OrderedGroupPhoto)mediaitem);
                } else
                if (needsResize(mediaitem, i, j) || needsReencode(mediaitem, assettype))
                {
                    obj = resizeLocalFile(mediaitem, ((String) (obj)), i, j, file);
                } else
                {
                    flag = false;
                    obj = diskStore.getDiskStorageUtils().createFile(((String) (obj)));
                }
                if (obj == null || !((File) (obj)).exists())
                {
                    return null;
                }
                obj1 = getExtension(((File) (obj)));
                flag1 = flag;
            }
        }
_L5:
        s1 = mediaitem.getName();
        s = s1;
        if (s1 == null)
        {
            s = mediaitem.getObjectId().toString();
        }
        if (flag1)
        {
            int i1;
            try
            {
                obj = moveToDirectory(((File) (obj)), file, (new StringBuilder()).append(FilenameUtils.getBaseName(s)).append(((String) (obj1))).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                GLogger.e(TAG, "#prepareMediaItemForSharingRepeatIfFailure: IOException %s", new Object[] {
                    ((IOException) (obj)).toString()
                });
                return prepareMediaItemForSharingRepeatIfFailure(mediaitem, i, j, assettype, k, l + 1, file);
            }
            return ((File) (obj));
        } else
        {
            return ((File) (obj));
        }
        obj1 = diskStore.getAsset(mediaitem, i, j, assettype);
        if (obj1 != null)
        {
            obj = obj1;
            i1 = l;
            if (((Asset) (obj1)).getAsset().exists())
            {
                break MISSING_BLOCK_LABEL_497;
            }
        }
        networkStore.loadContentSynchronously(mediaitem, i, j, ScaleMode.SCALE_TO_FIT, assettype, true);
        i1 = l + 1;
        obj1 = prepareMediaItemForSharingRepeatIfFailure(mediaitem, i, j, assettype, k, i1, file);
        obj = obj1;
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        obj1 = diskStore.getBestExistingAsset(mediaitem, Math.min(i, j));
        obj = obj1;
        if (obj1 == null)
        {
            return null;
        }
        obj = ((Asset) (obj)).getAsset();
        obj1 = assettype.getFileExtension();
        l = i1;
          goto _L5
    }

    private File prepareThumbnailRepeatIfFailure(MediaItem mediaitem, int i, int j, int k, int l, File file)
    {
        if (l == k)
        {
            file = TAG;
            if (mediaitem == null)
            {
                mediaitem = "mediaitem null";
            } else
            {
                mediaitem = mediaitem.getObjectId().toString();
            }
            GLogger.e(file, "giving up, video retry limit %d reached for %s", new Object[] {
                Integer.valueOf(k), mediaitem
            });
            return null;
        }
        if (mediaitem.getType() != MediaType.VIDEO || !MediaItemUtil.isLocalMediaItem(mediaitem))
        {
            return prepareMediaItemForSharingRepeatIfFailure(mediaitem, i, j, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG, k, l, file);
        }
        if (!file.exists())
        {
            file.mkdirs();
        }
        Object obj = new LocalVideoThumbnailResource(mediaitem.getObjectId(), mediaitem.getLocalPath(), mediaitem.getName());
        File file1 = VideoThumbnailUtils.getThumbnailFromCache(context, ((LocalVideoThumbnailResource) (obj)), 2);
        obj = file1;
        if (needsResize(mediaitem, i, j))
        {
            obj = resizeLocalFile(mediaitem, file1.getPath(), i, j, file);
        }
        try
        {
            obj = moveToDirectory(((File) (obj)), file, (new StringBuilder()).append(mediaitem.getName()).append(getExtension(((File) (obj)))).toString());
        }
        catch (IOException ioexception)
        {
            GLogger.e(TAG, "#prepareThumbnailRepeatIfFailure: IOException %s", new Object[] {
                ioexception.toString()
            });
            return prepareThumbnailRepeatIfFailure(mediaitem, i, j, k, l + 1, file);
        }
        return ((File) (obj));
    }

    private void pushOrientationToFile(File file, MediaItem mediaitem)
        throws IOException
    {
        mediaitem = new ExifInterface(mediaitem.getLocalPath());
        file = new ExifInterface(file.getAbsolutePath());
        mediaitem = mediaitem.getAttribute("Orientation");
        if (mediaitem != null)
        {
            file.setAttribute("Orientation", mediaitem);
            file.saveAttributes();
        }
    }

    private File resizeLocalFile(MediaItem mediaitem, String s, int i, int j, File file)
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        j = Math.max(i, j);
        i = Math.max(mediaitem.getWidth(), mediaitem.getHeight());
        int k = MathUtils.roundPower2(j);
        j = (int)(((float)k * (float)mediaitem.getWidth()) / (float)i);
        i = (int)(((float)k * (float)mediaitem.getHeight()) / (float)i);
        obj7 = null;
        obj8 = null;
        obj5 = null;
        obj2 = null;
        obj3 = null;
        s = null;
        obj6 = null;
        obj4 = null;
        obj = s;
        Bitmap bitmap = GlideWrapper.loadBitmap(context.getApplicationContext(), mediaitem, j, i);
        if (bitmap == null)
        {
            IOUtils.closeQuietly(null);
            return null;
        }
        obj = s;
        s = new File(file, (new StringBuilder()).append(FilenameUtils.getBaseName(mediaitem.getName())).append(".jpg").toString());
        file = new FileOutputStream(s);
        if (!bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, file) || !s.exists()) goto _L2; else goto _L1
_L1:
        pushOrientationToFile(s, mediaitem);
_L3:
        IOUtils.closeQuietly(file);
        mediaitem = s;
_L4:
        return mediaitem;
_L2:
        GLogger.e(TAG, "Unable to resize bitmap", new Object[0]);
          goto _L3
        obj;
        mediaitem = s;
        s = ((String) (obj));
_L9:
        obj = file;
        GLogger.ex(TAG, "File not found exception when resizing local asset", s);
        IOUtils.closeQuietly(file);
          goto _L4
        file;
        mediaitem = obj7;
        s = obj2;
_L8:
        obj = s;
        GLogger.ex(TAG, "Failed for uncaught Exception while resizing local asset", file);
        IOUtils.closeQuietly(s);
          goto _L4
        s;
        mediaitem = obj8;
        file = obj3;
_L7:
        obj = file;
        GLogger.ex(TAG, "Out of memory while resizing local asset", s);
        IOUtils.closeQuietly(file);
          goto _L4
        mediaitem;
_L6:
        IOUtils.closeQuietly(((java.io.OutputStream) (obj)));
        throw mediaitem;
        mediaitem;
        obj = obj6;
        continue; /* Loop/switch isn't completed */
        mediaitem;
        obj = file;
        if (true) goto _L6; else goto _L5
_L5:
        file;
        mediaitem = s;
        s = file;
        file = obj3;
          goto _L7
        Object obj1;
        obj1;
        mediaitem = s;
        s = ((String) (obj1));
          goto _L7
        file;
        mediaitem = s;
        s = obj2;
          goto _L8
        obj1;
        mediaitem = s;
        s = file;
        file = ((File) (obj1));
          goto _L8
        s;
        file = obj4;
        mediaitem = obj5;
          goto _L9
        file;
        mediaitem = s;
        s = file;
        file = obj4;
          goto _L9
    }

    public File getSharedDirectory()
    {
        return sharedDirectory;
    }

    public File prepareMediaItemForSharing(MediaItem mediaitem, int i, int j, com.amazon.gallery.framework.data.store.Asset.AssetType assettype)
    {
        return prepareMediaItemForSharingRepeatIfFailure(mediaitem, i, j, assettype, 3, 0, sharedDirectory);
    }

    public File prepareMediaItemForSharing(MediaItem mediaitem, int i, int j, com.amazon.gallery.framework.data.store.Asset.AssetType assettype, int k)
    {
        return prepareMediaItemForSharingRepeatIfFailure(mediaitem, i, j, assettype, k, 0, sharedDirectory);
    }

    public File prepareThumbnailForSharing(MediaItem mediaitem, int i, int j)
    {
        return prepareThumbnailRepeatIfFailure(mediaitem, i, j, 3, 0, sharedDirectory);
    }

    public File resolveNameConflict(File file, long l)
    {
        boolean flag = false;
        String s1 = file.getName();
        int i = 0;
        if (s1.contains("."))
        {
            i = s1.lastIndexOf('.');
        }
        String s = s1.substring(0, i);
        s1 = s1.substring(i);
        File file1 = file.getParentFile();
        i = ((flag) ? 1 : 0);
        for (; file.exists() && file.length() != l; file = diskStore.getDiskStorageUtils().createFile(file1, (new StringBuilder()).append(s).append(" (").append(i).append(")").append(s1).toString()))
        {
            i++;
        }

        return file;
    }

}
