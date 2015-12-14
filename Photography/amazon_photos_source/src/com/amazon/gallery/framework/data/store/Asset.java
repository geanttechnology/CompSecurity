// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            DiskStorageUtils, AssetPathBuilder

public class Asset
{
    public static final class AssetType extends Enum
    {

        private static final AssetType $VALUES[];
        public static final AssetType GIF;
        public static final AssetType JPG;
        public static final AssetType MP4;
        public static final AssetType SQUARE_JPG;
        public final String ext;
        private final String fileExtension;

        public static AssetType getAssetType(MediaType mediatype)
        {
            static class _cls3
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

            switch (_cls3..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediatype.ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("No asset type for ").append(mediatype).append(" is defined.").toString());

            case 1: // '\001'
                return JPG;

            case 2: // '\002'
                return MP4;
            }
        }

        public static AssetType getAssetType(String s)
        {
            if (s.equalsIgnoreCase(".mp4"))
            {
                return MP4;
            }
            if (s.equalsIgnoreCase(".gif"))
            {
                return GIF;
            } else
            {
                return JPG;
            }
        }

        public static AssetType valueOf(String s)
        {
            return (AssetType)Enum.valueOf(com/amazon/gallery/framework/data/store/Asset$AssetType, s);
        }

        public static AssetType[] values()
        {
            return (AssetType[])$VALUES.clone();
        }

        public String getFileExtension()
        {
            return fileExtension;
        }

        static 
        {
            JPG = new AssetType("JPG", 0, "", ".jpg");
            SQUARE_JPG = new AssetType("SQUARE_JPG", 1, "", ".jpg");
            MP4 = new AssetType("MP4", 2, ".mp4", ".mp4");
            GIF = new AssetType("GIF", 3, ".gif", ".gif");
            $VALUES = (new AssetType[] {
                JPG, SQUARE_JPG, MP4, GIF
            });
        }

        private AssetType(String s, int i, String s1, String s2)
        {
            super(s, i);
            ext = s1;
            fileExtension = s2;
        }
    }

    public static final class BoundingSize extends Enum
    {

        private static final BoundingSize $VALUES[];
        public static final BoundingSize BOUND_0;
        public static final BoundingSize BOUND_1;
        public static final BoundingSize BOUND_1024;
        public static final BoundingSize BOUND_128;
        public static final BoundingSize BOUND_16;
        public static final BoundingSize BOUND_2;
        public static final BoundingSize BOUND_2048;
        public static final BoundingSize BOUND_256;
        public static final BoundingSize BOUND_32;
        public static final BoundingSize BOUND_4;
        public static final BoundingSize BOUND_4096;
        public static final BoundingSize BOUND_512;
        public static final BoundingSize BOUND_64;
        public static final BoundingSize BOUND_8;
        int value;

        static BoundingSize getBoundingSize(int i)
            throws BoundingSizeDoesNotExistException
        {
            switch (i)
            {
            default:
                throw new BoundingSizeDoesNotExistException();

            case 0: // '\0'
                return BOUND_0;

            case 1: // '\001'
                return BOUND_1;

            case 2: // '\002'
                return BOUND_2;

            case 4: // '\004'
                return BOUND_4;

            case 8: // '\b'
                return BOUND_8;

            case 16: // '\020'
                return BOUND_16;

            case 32: // ' '
                return BOUND_32;

            case 64: // '@'
                return BOUND_64;

            case 128: 
                return BOUND_128;

            case 256: 
                return BOUND_256;

            case 512: 
                return BOUND_512;

            case 1024: 
                return BOUND_1024;

            case 2048: 
                return BOUND_2048;

            case 4096: 
                return BOUND_4096;
            }
        }

        public static BoundingSize valueOf(String s)
        {
            return (BoundingSize)Enum.valueOf(com/amazon/gallery/framework/data/store/Asset$BoundingSize, s);
        }

        public static BoundingSize[] values()
        {
            return (BoundingSize[])$VALUES.clone();
        }

        public int getSize()
        {
            return value;
        }

        static 
        {
            BOUND_0 = new BoundingSize("BOUND_0", 0, 0);
            BOUND_1 = new BoundingSize("BOUND_1", 1, 1);
            BOUND_2 = new BoundingSize("BOUND_2", 2, 2);
            BOUND_4 = new BoundingSize("BOUND_4", 3, 4);
            BOUND_8 = new BoundingSize("BOUND_8", 4, 8);
            BOUND_16 = new BoundingSize("BOUND_16", 5, 16);
            BOUND_32 = new BoundingSize("BOUND_32", 6, 32);
            BOUND_64 = new BoundingSize("BOUND_64", 7, 64);
            BOUND_128 = new BoundingSize("BOUND_128", 8, 128);
            BOUND_256 = new BoundingSize("BOUND_256", 9, 256);
            BOUND_512 = new BoundingSize("BOUND_512", 10, 512);
            BOUND_1024 = new BoundingSize("BOUND_1024", 11, 1024);
            BOUND_2048 = new BoundingSize("BOUND_2048", 12, 2048);
            BOUND_4096 = new BoundingSize("BOUND_4096", 13, 4096);
            $VALUES = (new BoundingSize[] {
                BOUND_0, BOUND_1, BOUND_2, BOUND_4, BOUND_8, BOUND_16, BOUND_32, BOUND_64, BOUND_128, BOUND_256, 
                BOUND_512, BOUND_1024, BOUND_2048, BOUND_4096
            });
        }

        private BoundingSize(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    static class BoundingSizeDoesNotExistException extends IllegalArgumentException
    {

        BoundingSizeDoesNotExistException()
        {
        }
    }


    private static final File DUMMY_FILE = new File("/dev/null") {

        public boolean exists()
        {
            return false;
        }

    };
    private static final String TAG = com/amazon/gallery/framework/data/store/Asset.getName();
    private static final ThreadLocal pathBuilder = new ThreadLocal() {

        protected AssetPathBuilder initialValue()
        {
            return new AssetPathBuilder();
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

    };
    private final File asset;
    private final AssetType assetType;
    private final BoundingSize boundingSize;

    private Asset(File file, BoundingSize boundingsize, AssetType assettype)
    {
        asset = file;
        boundingSize = boundingsize;
        assetType = assettype;
    }

    public static Asset createFromFilePath(File file)
    {
        try
        {
            BoundingSize boundingsize = getBoundingSize(file.getParentFile());
            String s = file.getName();
            file = new Asset(file, boundingsize, AssetType.getAssetType(s.substring(s.lastIndexOf("."))));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            GLogger.ix(TAG, file.getMessage(), file);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            GLogger.i(TAG, "IllegalArgumentException happens for some file, use debug build to get more information", new Object[0]);
            if (BuildFlavors.isDebug())
            {
                GLogger.ix(TAG, file.getMessage(), file);
            }
            return null;
        }
        return file;
    }

    public static Asset createFromParameters(DiskStorageUtils diskstorageutils, File file, MediaItem mediaitem, int i, AssetType assettype)
    {
        BoundingSize boundingsize = BoundingSize.getBoundingSize(MathUtils.roundPower2(i));
        file = diskstorageutils.getMediaItemSizePartition(file, mediaitem, boundingsize);
        if (file != null)
        {
            diskstorageutils = diskstorageutils.createFile(getFilePathString(file, mediaitem, assettype));
            if (diskstorageutils != null)
            {
                return new Asset(diskstorageutils, boundingsize, assettype);
            }
        }
        return new Asset(DUMMY_FILE, boundingsize, assettype);
    }

    public static Asset createFromSizeDir(DiskStorageUtils diskstorageutils, File file, MediaItem mediaitem, AssetType assettype)
    {
        try
        {
            BoundingSize boundingsize = getBoundingSize(file);
            diskstorageutils = new Asset(diskstorageutils.createFile(getFilePathString(file, mediaitem, assettype)), boundingsize, assettype);
        }
        // Misplaced declaration of an exception variable
        catch (DiskStorageUtils diskstorageutils)
        {
            return null;
        }
        return diskstorageutils;
    }

    public static BoundingSize getBoundingSize(File file)
    {
        return BoundingSize.getBoundingSize(Integer.parseInt(file.getName()));
    }

    public static String getFilePathString(File file, MediaItem mediaitem, AssetType assettype)
    {
        AssetPathBuilder assetpathbuilder = (AssetPathBuilder)pathBuilder.get();
        assetpathbuilder.setBaseStorageLocation(file).setMediaItem(mediaitem).setAssetType(assettype);
        return assetpathbuilder.build();
    }

    public static String getTag(boolean flag)
    {
        if (flag)
        {
            return "cloud";
        } else
        {
            return "device";
        }
    }

    public File getAsset()
    {
        return asset;
    }

    public int getP2Size()
    {
        return boundingSize.getSize();
    }

}
