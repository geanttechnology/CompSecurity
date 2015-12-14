// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadBatch, UploadStrategy

public class UploadBatchFactory
{
    public static final class UploadBatchType extends Enum
    {

        private static final UploadBatchType $VALUES[];
        public static final UploadBatchType CAMERA_PHOTO;
        public static final UploadBatchType CAMERA_VIDEO;
        public static final UploadBatchType NONE;
        public static final UploadBatchType NON_CAMERA_PHOTO;
        public static final UploadBatchType NON_CAMERA_VIDEO;

        public static UploadBatchType valueOf(String s)
        {
            return (UploadBatchType)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadBatchFactory$UploadBatchType, s);
        }

        public static UploadBatchType[] values()
        {
            return (UploadBatchType[])$VALUES.clone();
        }

        static 
        {
            CAMERA_PHOTO = new UploadBatchType("CAMERA_PHOTO", 0);
            CAMERA_VIDEO = new UploadBatchType("CAMERA_VIDEO", 1);
            NON_CAMERA_PHOTO = new UploadBatchType("NON_CAMERA_PHOTO", 2);
            NON_CAMERA_VIDEO = new UploadBatchType("NON_CAMERA_VIDEO", 3);
            NONE = new UploadBatchType("NONE", 4);
            $VALUES = (new UploadBatchType[] {
                CAMERA_PHOTO, CAMERA_VIDEO, NON_CAMERA_PHOTO, NON_CAMERA_VIDEO, NONE
            });
        }

        private UploadBatchType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final EnumSet PHOTO_BATCHES;
    private static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/UploadBatchFactory.getName();
    public static final EnumSet VIDEO_BATCHES;

    public UploadBatchFactory()
    {
    }

    static Map createBatchMap(List list, UploadStrategy uploadstrategy)
    {
        GLogger.v(TAG, "Creating new batch map from media item list of size %d", new Object[] {
            Integer.valueOf(list.size())
        });
        HashMap hashmap = new HashMap(4);
        MediaItem mediaitem;
        UploadBatchType uploadbatchtype;
        for (list = list.iterator(); list.hasNext(); ((UploadBatch)hashmap.get(uploadbatchtype)).addToBatch(mediaitem))
        {
            mediaitem = (MediaItem)list.next();
            uploadbatchtype = getBatchType(mediaitem);
            if (!hashmap.containsKey(uploadbatchtype))
            {
                GLogger.d(TAG, "Created new batch type %s in batch map", new Object[] {
                    uploadbatchtype
                });
                hashmap.put(uploadbatchtype, new UploadBatch(uploadstrategy, uploadbatchtype));
            }
        }

        return hashmap;
    }

    private static UploadBatchType getBatchType(MediaItem mediaitem)
    {
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

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaitem.getType().ordinal()])
        {
        default:
            DebugAssert.assertMsg("Invalid batch type!");
            return UploadBatchType.NONE;

        case 1: // '\001'
            if (mediaitem.hasProperty(CommonMediaProperty.CAMERA))
            {
                return UploadBatchType.CAMERA_PHOTO;
            } else
            {
                return UploadBatchType.NON_CAMERA_PHOTO;
            }

        case 2: // '\002'
            break;
        }
        if (mediaitem.hasProperty(CommonMediaProperty.CAMERA))
        {
            return UploadBatchType.CAMERA_VIDEO;
        } else
        {
            return UploadBatchType.NON_CAMERA_VIDEO;
        }
    }

    static 
    {
        PHOTO_BATCHES = EnumSet.of(UploadBatchType.CAMERA_PHOTO, UploadBatchType.NON_CAMERA_PHOTO);
        VIDEO_BATCHES = EnumSet.of(UploadBatchType.CAMERA_VIDEO, UploadBatchType.NON_CAMERA_VIDEO);
    }
}
