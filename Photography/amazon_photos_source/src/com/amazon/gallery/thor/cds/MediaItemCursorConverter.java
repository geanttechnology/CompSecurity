// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.database.Cursor;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.LenticularHelper;
import com.amazon.gallery.framework.data.store.RewindHelper;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.mixtape.utils.MixtapeCursorUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSUtil

class MediaItemCursorConverter
{

    private final MediaItemDao mediaItemDao;

    public MediaItemCursorConverter(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }

    public MediaItem convert(Cursor cursor)
    {
        Object obj;
        Object obj1;
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

        String s;
        int i;
        long l;
        boolean flag;
        if (MixtapeCursorUtils.getBooleanFromCursor(cursor, "is_video"))
        {
            obj1 = MediaType.VIDEO;
        } else
        {
            obj1 = MediaType.PHOTO;
        }
        s = MixtapeCursorUtils.getStringFromCursor(cursor, "name");
        obj = GroupType.NONE;
        if (LenticularHelper.isLenticular(s))
        {
            obj = GroupType.LENTICULAR;
        } else
        if (RewindHelper.getInstance().isRewindPhoto(s))
        {
            obj = GroupType.REWIND;
        }
        obj1 = mediaItemDao.create(((MediaType) (obj1)), ((GroupType) (obj)));
        ((MediaItem) (obj1)).setTags(new HashSet());
        ((MediaItem) (obj1)).setEventId(MixtapeCursorUtils.getLongFromCursor(cursor, "event_id"));
        ((MediaItem) (obj1)).setProperties(Collections.emptySet());
        ((MediaItem) (obj1)).setMetadata(new HashMap());
        ((MediaItem) (obj1)).setObjectId(CDSUtil.getObjectId(MixtapeCursorUtils.getStringFromCursor(cursor, "node_id")));
        ((MediaItem) (obj1)).setName(s);
        ((MediaItem) (obj1)).setMIMEType(MixtapeCursorUtils.getStringFromCursor(cursor, "content_type"));
        if (cursor.getInt(cursor.getColumnIndex("hidden")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((MediaItem) (obj1)).setHidden(flag);
        ((MediaItem) (obj1)).setAssetHash(cursor.getInt(cursor.getColumnIndex("content_version")));
        obj = null;
        i = cursor.getColumnIndex("content_date");
        if (!cursor.isNull(i))
        {
            obj = cursor.getString(i);
        }
        l = CDSUtil.getUnixTimestamp(((String) (obj)));
        ((MediaItem) (obj1)).setDateCreatedMs(l);
        ((MediaItem) (obj1)).setDateCreatedUTCMs(l);
        obj = null;
        i = cursor.getColumnIndex("created_date");
        if (!cursor.isNull(i))
        {
            obj = cursor.getString(i);
        }
        ((MediaItem) (obj1)).setDateAddedMs(CDSUtil.getUnixTimestamp(((String) (obj))));
        obj = ((MediaItem) (obj1)).getLocalMetadata();
        ((MediaItem) (obj1)).setSize(cursor.getInt(cursor.getColumnIndex("content_size")));
        _cls1..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[((MediaItem) (obj1)).getType().ordinal()];
        JVM INSTR tableswitch 1 2: default 340
    //                   1 427
    //                   2 493;
           goto _L1 _L2 _L3
_L1:
        ((MediaItem) (obj1)).setTimestampMs(MediaItemUtil.createTimestamp(((MediaItem) (obj1))));
        ((MediaItem) (obj1)).setSyncState(SyncState.SYNCED);
        i = cursor.getColumnIndex("content_md5");
        if (!cursor.isNull(i))
        {
            ((MediaItem) (obj1)).setFullMd5(cursor.getString(i));
        }
        return ((MediaItem) (obj1));
_L2:
        ((MediaItem) (obj1)).setWidth(cursor.getInt(cursor.getColumnIndex("image_width")));
        ((MediaItem) (obj1)).setHeight(cursor.getInt(cursor.getColumnIndex("image_height")));
        ((Map) (obj)).put("image_date_time_original", cursor.getString(cursor.getColumnIndex("image_date_time_original")));
        continue; /* Loop/switch isn't completed */
_L3:
        ((MediaItem) (obj1)).setWidth(cursor.getInt(cursor.getColumnIndex("video_width")));
        ((MediaItem) (obj1)).setHeight(cursor.getInt(cursor.getColumnIndex("video_height")));
        ((MediaItem) (obj1)).setDateCreatedMs(DateUtils.applyCurrentTimeZone(((MediaItem) (obj1)).getDateCreatedUTCMs()));
        long l1 = (long)(cursor.getDouble(cursor.getColumnIndex("video_duration")) * 1000D);
        ((Video)obj1).setDuration(l1);
        if (true) goto _L1; else goto _L4
_L4:
    }
}
