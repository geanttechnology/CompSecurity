// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.Cursor;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.TagPropertyDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.LocalMediaItemDaoSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.MediaItemSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagSqliteImpl;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            GalleryDBConnectionManager

public class SQLiteDaoUtil
{
    public static class MediaItemColumnIndices
    {

        int ASSET_HASH;
        int CAPTION;
        int DATE_ADDED;
        int DATE_CREATED;
        int DATE_CREATED_UTC;
        int DATE_MODIFIED;
        int DURATION;
        int EVENT_ID;
        int FULL_MD5;
        int GROUP_TYPE;
        int HEIGHT;
        int HIDDEN;
        int ID;
        int LAT;
        int LOCAL_PATH;
        int LON;
        int MIME_TYPE;
        int NAME;
        int OBJECT_ID_HIGH;
        int OBJECT_ID_LOW;
        int ORIENTATION;
        int PARENT_MEDIA_ID_HIGH;
        int PARENT_MEDIA_ID_LOW;
        int SIZE;
        int SYNC_STATE;
        int TIME_STAMP;
        int TYPE;
        int UPLOADED_OBJECT_ID_HIGH;
        int UPLOADED_OBJECT_ID_LOW;
        int WIDTH;
        boolean initialized;

        void initialize(Cursor cursor)
        {
            if (!initialized)
            {
                TYPE = cursor.getColumnIndex("type");
                GROUP_TYPE = cursor.getColumnIndexOrThrow("group_type");
                ID = cursor.getColumnIndex("id");
                OBJECT_ID_HIGH = cursor.getColumnIndex("object_id_hi");
                OBJECT_ID_LOW = cursor.getColumnIndex("object_id_low");
                ASSET_HASH = cursor.getColumnIndex("asset_hash");
                WIDTH = cursor.getColumnIndex("width");
                HEIGHT = cursor.getColumnIndex("height");
                NAME = cursor.getColumnIndex("name");
                CAPTION = cursor.getColumnIndex("caption");
                DATE_CREATED = cursor.getColumnIndex("date_created");
                DATE_CREATED_UTC = cursor.getColumnIndex("date_created_utc");
                DATE_MODIFIED = cursor.getColumnIndex("date_modified");
                DATE_ADDED = cursor.getColumnIndex("date_added");
                TIME_STAMP = cursor.getColumnIndex("time_stamp");
                MIME_TYPE = cursor.getColumnIndex("mime_type");
                LOCAL_PATH = cursor.getColumnIndex("local_path");
                LAT = cursor.getColumnIndex("lat");
                LON = cursor.getColumnIndex("lon");
                UPLOADED_OBJECT_ID_HIGH = cursor.getColumnIndex("uploaded_id_hi");
                UPLOADED_OBJECT_ID_LOW = cursor.getColumnIndex("uploaded_id_low");
                PARENT_MEDIA_ID_HIGH = cursor.getColumnIndex("parent_media_id_hi");
                PARENT_MEDIA_ID_LOW = cursor.getColumnIndex("parent_media_id_low");
                SYNC_STATE = cursor.getColumnIndex("sync_state");
                ORIENTATION = cursor.getColumnIndex("orientation");
                DURATION = cursor.getColumnIndex("duration");
                EVENT_ID = cursor.getColumnIndex("event_id");
                FULL_MD5 = cursor.getColumnIndex("full_md5");
                SIZE = cursor.getColumnIndex("file_size");
                HIDDEN = cursor.getColumnIndex("hidden");
                if (HIDDEN == -1)
                {
                    GLogger.ex(SQLiteDaoUtil.TAG, "Hidden column was -1, do not set initialized true", new Throwable());
                    if (SQLiteDaoUtil.profiler != null)
                    {
                        SQLiteDaoUtil.profiler.trackEvent(MetricEvent.HiddenColumnMissing);
                        return;
                    }
                } else
                {
                    initialized = true;
                    return;
                }
            }
        }

        public MediaItemColumnIndices()
        {
            initialized = false;
        }
    }

    public static final class MetricEvent extends Enum
    {

        private static final MetricEvent $VALUES[];
        public static final MetricEvent HiddenColumnMissing;

        public static MetricEvent valueOf(String s)
        {
            return (MetricEvent)Enum.valueOf(com/amazon/gallery/framework/data/dao/sqlite/SQLiteDaoUtil$MetricEvent, s);
        }

        public static MetricEvent[] values()
        {
            return (MetricEvent[])$VALUES.clone();
        }

        static 
        {
            HiddenColumnMissing = new MetricEvent("HiddenColumnMissing", 0);
            $VALUES = (new MetricEvent[] {
                HiddenColumnMissing
            });
        }

        private MetricEvent(String s, int i)
        {
            super(s, i);
        }
    }

    private static class TagColumnIndices
    {

        int COVER_ID_HIGH;
        int COVER_ID_LOW;
        int CUSTOM_COVER_ID_HIGH;
        int CUSTOM_COVER_ID_LOW;
        int DATABASE_VERSION;
        int DATE_CREATED;
        int HAS_SORT_DATE;
        int ID;
        int LABEL;
        int LOCAL_PATH;
        int MEDIA_ITEMS_SYNC_VERSION;
        int OBJECT_ID_HIGH;
        int OBJECT_ID_LOW;
        int SORT_DATE;
        int TAG_REVISION_ID;
        int TAG_SYNC_VERSION;
        int TIME_STAMP;
        int TYPE;
        int VALID;
        boolean initialized;
        TagPropertyDao tagProperties;

        void initialize(Cursor cursor)
        {
            if (initialized)
            {
                return;
            } else
            {
                ID = cursor.getColumnIndex("id");
                TYPE = cursor.getColumnIndex("type");
                OBJECT_ID_LOW = cursor.getColumnIndex("object_id_low");
                OBJECT_ID_HIGH = cursor.getColumnIndex("object_id_hi");
                LABEL = cursor.getColumnIndex("label");
                DATE_CREATED = cursor.getColumnIndex("date_created");
                SORT_DATE = cursor.getColumnIndex("sort_date");
                HAS_SORT_DATE = cursor.getColumnIndex("has_sort_date");
                COVER_ID_LOW = cursor.getColumnIndex("cover_id_low");
                COVER_ID_HIGH = cursor.getColumnIndex("cover_id_high");
                LOCAL_PATH = cursor.getColumnIndex("local_path");
                TAG_REVISION_ID = cursor.getColumnIndex("tag_revision_id");
                TAG_SYNC_VERSION = cursor.getColumnIndex("tag_sync_version");
                MEDIA_ITEMS_SYNC_VERSION = cursor.getColumnIndex("media_items_sync_version");
                TIME_STAMP = cursor.getColumnIndex("time_stamp");
                CUSTOM_COVER_ID_LOW = cursor.getColumnIndex("custom_cover_id_low");
                CUSTOM_COVER_ID_HIGH = cursor.getColumnIndex("custom_cover_id_high");
                DATABASE_VERSION = cursor.getColumnIndex("db_version");
                VALID = cursor.getColumnIndex("valid");
                initialized = true;
                return;
            }
        }

        private TagColumnIndices()
        {
            initialized = false;
            tagProperties = new TagPropertyDao();
        }

    }


    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/SQLiteDaoUtil.getName();
    private static ThreadLocal TempStringBuilders = new ThreadLocal() {

        public volatile Object get()
        {
            return get();
        }

        public StringBuilder get()
        {
            StringBuilder stringbuilder = (StringBuilder)super.get();
            stringbuilder.setLength(0);
            return stringbuilder;
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected StringBuilder initialValue()
        {
            return new StringBuilder(128);
        }

    };
    private static MediaItemColumnIndices contentProviderIndices = new MediaItemColumnIndices();
    private static MediaItemColumnIndices daoIndices = new MediaItemColumnIndices();
    private static ComponentProfiler profiler;
    private static TagColumnIndices tagProviderIndices = new TagColumnIndices();

    public SQLiteDaoUtil()
    {
    }

    private static transient String appendIntoClause(StringBuilder stringbuilder, String s, String as[])
    {
        stringbuilder.append(" INTO ").append(s);
        stringbuilder.append(" (");
        int k = as.length;
        for (int i = 0; i < k; i++)
        {
            stringbuilder.append(as[i]).append(",");
        }

        stringbuilder.replace(stringbuilder.length() - 1, stringbuilder.length(), ")");
        stringbuilder.append(" VALUES (");
        for (int j = 0; j < as.length; j++)
        {
            stringbuilder.append("?,");
        }

        stringbuilder.replace(stringbuilder.length() - 1, stringbuilder.length(), ")");
        return stringbuilder.toString();
    }

    public static List cursorToMediaItemsList(Cursor cursor, MediaItemDao mediaitemdao)
    {
        ArrayList arraylist = new ArrayList();
        if (cursor != null)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                arraylist.add(itemFromCursor(cursor, mediaitemdao));
            }

        }
        return arraylist;
    }

    public static String deleteClause(String s, String s1)
    {
        StringBuilder stringbuilder = (StringBuilder)TempStringBuilders.get();
        stringbuilder.append("DELETE FROM ").append(s);
        stringbuilder.append(" WHERE ").append(s1);
        return stringbuilder.toString();
    }

    public static transient String insertClause(String s, String as[])
    {
        StringBuilder stringbuilder = (StringBuilder)TempStringBuilders.get();
        stringbuilder.append("INSERT ");
        appendIntoClause(stringbuilder, s, as);
        return stringbuilder.toString();
    }

    public static MediaItem itemFromCursor(Cursor cursor, MediaItemDao mediaitemdao)
    {
        if (cursor == null)
        {
            return null;
        } else
        {
            contentProviderIndices.initialize(cursor);
            int i = cursor.getInt(cursor.getColumnIndex("type"));
            MediaType mediatype = MediaType.values()[i];
            GroupType grouptype = GroupType.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("group_type")));
            mediaitemdao = (MediaItemSqliteImpl)mediaitemdao.create(mediatype, grouptype);
            mediaitemdao.setId(cursor.getLong(cursor.getColumnIndex("_id")));
            return populateMediaItem(cursor, mediaitemdao, mediatype, grouptype, contentProviderIndices);
        }
    }

    public static MediaItem itemFromCursor(Cursor cursor, MediaItemDao mediaitemdao, MediaItemColumnIndices mediaitemcolumnindices)
    {
        mediaitemcolumnindices.initialize(cursor);
        int i = cursor.getInt(cursor.getColumnIndex("type"));
        MediaType mediatype = MediaType.values()[i];
        GroupType grouptype = GroupType.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("group_type")));
        mediaitemdao = (MediaItemSqliteImpl)mediaitemdao.create(mediatype, grouptype);
        if (cursor.getColumnIndex("_id") > 0)
        {
            i = cursor.getColumnIndex("_id");
        } else
        {
            i = mediaitemcolumnindices.ID;
        }
        mediaitemdao.setId(cursor.getLong(i));
        return populateMediaItem(cursor, mediaitemdao, mediatype, grouptype, mediaitemcolumnindices);
    }

    public static MediaItem itemFromCursor(Cursor cursor, LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        daoIndices.initialize(cursor);
        int i = cursor.getInt(daoIndices.TYPE);
        MediaType mediatype = MediaType.values()[i];
        GroupType grouptype = GroupType.valueOf(cursor.getInt(daoIndices.GROUP_TYPE));
        localmediaitemdaosqliteimpl = (MediaItemSqliteImpl)localmediaitemdaosqliteimpl.create(mediatype, grouptype);
        localmediaitemdaosqliteimpl.setId(cursor.getInt(daoIndices.ID));
        return populateMediaItem(cursor, localmediaitemdaosqliteimpl, mediatype, grouptype, daoIndices);
    }

    public static Tag itemFromCursor(Cursor cursor, TagDao tagdao)
    {
        tagProviderIndices.initialize(cursor);
        int i = cursor.getInt(cursor.getColumnIndex("type"));
        tagdao = (TagSqliteImpl)tagdao.create(TagType.values()[i]);
        tagdao.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        return populateTag(cursor, tagdao, tagProviderIndices);
    }

    public static ObjectID objectIdFromCursor(Cursor cursor)
    {
        return new ObjectID(cursor.getLong(cursor.getColumnIndex("object_id_hi")), cursor.getLong(cursor.getColumnIndex("object_id_low")));
    }

    private static MediaItem populateMediaItem(Cursor cursor, MediaItemSqliteImpl mediaitemsqliteimpl, MediaType mediatype, GroupType grouptype, MediaItemColumnIndices mediaitemcolumnindices)
    {
        mediaitemsqliteimpl.setObjectId(new ObjectID(cursor.getLong(mediaitemcolumnindices.OBJECT_ID_HIGH), cursor.getLong(mediaitemcolumnindices.OBJECT_ID_LOW)));
        mediaitemsqliteimpl.setAssetHash(cursor.getInt(mediaitemcolumnindices.ASSET_HASH));
        mediaitemsqliteimpl.setWidth(cursor.getInt(mediaitemcolumnindices.WIDTH));
        mediaitemsqliteimpl.setHeight(cursor.getInt(mediaitemcolumnindices.HEIGHT));
        mediaitemsqliteimpl.setName(cursor.getString(mediaitemcolumnindices.NAME));
        mediaitemsqliteimpl.setCaption(cursor.getString(mediaitemcolumnindices.CAPTION));
        mediaitemsqliteimpl.setDateCreatedMs(cursor.getLong(mediaitemcolumnindices.DATE_CREATED));
        mediaitemsqliteimpl.setDateCreatedUTCMs(cursor.getLong(mediaitemcolumnindices.DATE_CREATED_UTC));
        mediaitemsqliteimpl.setDateModifiedMs(cursor.getLong(mediaitemcolumnindices.DATE_MODIFIED));
        mediaitemsqliteimpl.setDateAddedMs(cursor.getLong(mediaitemcolumnindices.DATE_ADDED));
        mediaitemsqliteimpl.setTimestampMs(cursor.getLong(mediaitemcolumnindices.TIME_STAMP));
        mediaitemsqliteimpl.setMIMEType(cursor.getString(mediaitemcolumnindices.MIME_TYPE));
        mediaitemsqliteimpl.setEventId(cursor.getLong(mediaitemcolumnindices.EVENT_ID));
        mediaitemsqliteimpl.setLocalPath(cursor.getString(mediaitemcolumnindices.LOCAL_PATH));
        mediaitemsqliteimpl.setFullMd5(cursor.getString(mediaitemcolumnindices.FULL_MD5));
        int i = mediaitemcolumnindices.LAT;
        int j = mediaitemcolumnindices.LON;
        if (i != -1 && j != -1)
        {
            String s = cursor.getString(i);
            String s1 = cursor.getString(j);
            if (s != null && s1 != null)
            {
                mediaitemsqliteimpl.setLat(s);
                mediaitemsqliteimpl.setLon(s1);
            }
        }
        mediaitemsqliteimpl.setSize(cursor.getLong(mediaitemcolumnindices.SIZE));
        i = mediaitemcolumnindices.HIDDEN;
        if (i != -1)
        {
            ObjectID objectid;
            Object obj;
            long l;
            long l1;
            long l2;
            long l3;
            boolean flag;
            if (cursor.getInt(i) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mediaitemsqliteimpl.setHidden(flag);
        }
        l = cursor.getLong(mediaitemcolumnindices.UPLOADED_OBJECT_ID_HIGH);
        l1 = cursor.getLong(mediaitemcolumnindices.UPLOADED_OBJECT_ID_LOW);
        l2 = cursor.getLong(mediaitemcolumnindices.PARENT_MEDIA_ID_HIGH);
        l3 = cursor.getLong(mediaitemcolumnindices.PARENT_MEDIA_ID_LOW);
        obj = null;
        objectid = obj;
        if (l2 != 0L)
        {
            objectid = obj;
            if (l3 != 0L)
            {
                objectid = new ObjectID(l2, l3);
            }
        }
        mediaitemsqliteimpl.setParentObjectID(objectid);
        mediaitemsqliteimpl.setSyncState(SyncState.valueOf(cursor.getInt(mediaitemcolumnindices.SYNC_STATE)));
        mediaitemsqliteimpl.setOrientation(cursor.getInt(mediaitemcolumnindices.ORIENTATION));
        obj = null;
        objectid = obj;
        if (l != 0L)
        {
            objectid = obj;
            if (l1 != 0L)
            {
                objectid = new ObjectID(l, l1);
            }
        }
        mediaitemsqliteimpl.setUploadedObjectId(objectid);
        if (mediatype == MediaType.VIDEO)
        {
            ((Video)mediaitemsqliteimpl).setDuration(cursor.getInt(mediaitemcolumnindices.DURATION));
        }
        mediaitemsqliteimpl.setGroupType(grouptype);
        return mediaitemsqliteimpl;
    }

    private static Tag populateTag(Cursor cursor, TagSqliteImpl tagsqliteimpl, TagColumnIndices tagcolumnindices)
    {
        boolean flag1 = true;
        tagsqliteimpl.setObjectId(new ObjectID(cursor.getLong(cursor.getColumnIndex("object_id_hi")), cursor.getLong(cursor.getColumnIndex("object_id_low"))));
        tagsqliteimpl.setLabel(cursor.getString(tagcolumnindices.LABEL));
        tagsqliteimpl.setDateCreatedMs(cursor.getLong(tagcolumnindices.DATE_CREATED));
        tagsqliteimpl.setTimestampMs(cursor.getLong(tagcolumnindices.TIME_STAMP));
        tagsqliteimpl.setSortDateMs(cursor.getLong(tagcolumnindices.SORT_DATE));
        boolean flag;
        if (cursor.getInt(tagcolumnindices.HAS_SORT_DATE) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tagsqliteimpl.setHasSortDate(flag);
        if (!cursor.isNull(tagcolumnindices.COVER_ID_LOW) && !cursor.isNull(tagcolumnindices.COVER_ID_HIGH))
        {
            tagsqliteimpl.setCoverId(new ObjectID(cursor.getLong(tagcolumnindices.COVER_ID_HIGH), cursor.getLong(tagcolumnindices.COVER_ID_LOW)));
        }
        if (!cursor.isNull(tagcolumnindices.CUSTOM_COVER_ID_LOW) && !cursor.isNull(tagcolumnindices.CUSTOM_COVER_ID_HIGH))
        {
            tagsqliteimpl.setCustomCoverId(new ObjectID(cursor.getLong(tagcolumnindices.CUSTOM_COVER_ID_HIGH), cursor.getLong(tagcolumnindices.CUSTOM_COVER_ID_LOW)));
        }
        tagsqliteimpl.setLocalPath(cursor.getString(tagcolumnindices.LOCAL_PATH));
        tagsqliteimpl.setTagSyncVersion(cursor.getInt(tagcolumnindices.TAG_SYNC_VERSION));
        tagsqliteimpl.setMediaItemsSyncVersion(cursor.getInt(tagcolumnindices.MEDIA_ITEMS_SYNC_VERSION));
        tagsqliteimpl.setDatabaseVersion(cursor.getInt(tagcolumnindices.DATABASE_VERSION));
        if (cursor.getInt(tagcolumnindices.VALID) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        tagsqliteimpl.setValid(flag);
        tagcolumnindices.tagProperties.readTagProperties(cursor, tagsqliteimpl);
        return tagsqliteimpl;
    }

    public static transient String replaceClause(String s, String as[])
    {
        StringBuilder stringbuilder = (StringBuilder)TempStringBuilders.get();
        stringbuilder.append("INSERT OR REPLACE ");
        appendIntoClause(stringbuilder, s, as);
        return stringbuilder.toString();
    }

    public static void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/data/dao/sqlite/GalleryDBConnectionManager);
    }

    public static String updateClause(String s, String as[], String s1)
    {
        StringBuilder stringbuilder = (StringBuilder)TempStringBuilders.get();
        stringbuilder.append("UPDATE ").append(s).append(" SET");
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            s = as[i];
            stringbuilder.append(' ').append(s).append(" = ?,");
        }

        stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        stringbuilder.append(" WHERE ").append(s1);
        return stringbuilder.toString();
    }



}
