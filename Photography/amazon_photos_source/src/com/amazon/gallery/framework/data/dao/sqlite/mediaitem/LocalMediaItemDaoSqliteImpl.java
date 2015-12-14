// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortClause;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.filter.MediaFilter;
import com.amazon.gallery.framework.data.dao.mediaitem.LocalMediaItemDao;
import com.amazon.gallery.framework.data.dao.mediaitem.RewindPhotoSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.CursorListFactory;
import com.amazon.gallery.framework.data.dao.sqlite.CursorListFactoryImpl;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.EditHelper;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.data.dao.sqlite.TagMembershipKeys;
import com.amazon.gallery.framework.data.dao.sqlite.frame.FrameKeys;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagSqliteImpl;
import com.amazon.gallery.framework.data.dao.tag.LocalTagDao;
import com.amazon.gallery.framework.data.model.LenticularSqliteImpl;
import com.amazon.gallery.framework.data.model.MediaItemCollectionBeanImpl;
import com.amazon.gallery.framework.data.model.TimelineQueryImpl;
import com.amazon.gallery.framework.data.model.TimelineUtils;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.Frame;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            MediaItemKeys, MediaPropertyKeys, MediaItemDaoChangeList, MediaItemSqliteImpl, 
//            MetadataKeys, PhotoSqliteImpl, VideoSqliteImpl

public class LocalMediaItemDaoSqliteImpl
    implements LocalMediaItemDao
{

    private static final Uri MEDIA_ITEM_URI;
    private static final DBWriteExecutor ORPHAN_COUNT_EXECUTOR = new DBWriteExecutor() {

        protected Long execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
        {
            return Long.valueOf(readwritesqlitedatabase.count("media_item", String.format("%s = %d", new Object[] {
                "potentially_orphaned", Integer.valueOf(1)
            }), new String[0]));
        }

        protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
        {
            return execute(readwritesqlitedatabase);
        }

    };
    private static final String SELECT_MEDIA_ITEM_IDS_NOT_ORPHANED = String.format("SELECT %s FROM %s WHERE %s = %s", new Object[] {
        "media_item_id", "tag_membership", "id", "media_item_id"
    });
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediaitem/LocalMediaItemDaoSqliteImpl.getName();
    private static final String UNUPLOADED_SYNC_STATES;
    private static final boolean UPLOAD_PRE_REGISTRATION_PHOTOS = BuildFlavors.isAosp();
    private final DBWriteExecutor RESET_NON_ORPHANED_EXECUTOR = new DBWriteExecutor() {

        final LocalMediaItemDaoSqliteImpl this$0;

        protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
        {
            return execute(readwritesqlitedatabase);
        }

        protected Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
        {
            String s = String.format("%s = %d AND %s IN (%s)", new Object[] {
                "potentially_orphaned", Integer.valueOf(1), "id", LocalMediaItemDaoSqliteImpl.SELECT_MEDIA_ITEM_IDS_NOT_ORPHANED
            });
            ContentValues contentvalues = new ContentValues(1);
            contentvalues.put("potentially_orphaned", Integer.valueOf(0));
            int i = readwritesqlitedatabase.update("media_item", contentvalues, s, new String[0]);
            GLogger.i(LocalMediaItemDaoSqliteImpl.TAG, "Reset potentially_orphaned flag on %d media items.", new Object[] {
                Integer.valueOf(i)
            });
            if (i > 0)
            {
                incrementSessionCounter();
            }
            return null;
        }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                super();
            }
    };
    private GalleryDBConnectionManager connectionManager;
    private final Context context;
    private final CursorListFactory cursorListFactory;
    private com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement deleteTagMembershipSqLiteStatement;
    private com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement insertSqLiteStatement;
    private com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement insertTagMembershipSqLiteStatement;
    private com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement replaceTagMembershipSqLiteStatement;
    private final AtomicInteger sessionCounter = new AtomicInteger(0);
    protected LocalTagDao tagDao;

    public LocalMediaItemDaoSqliteImpl(Context context1, GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        context = context1;
        connectionManager = gallerydbconnectionmanager;
        cursorListFactory = new CursorListFactoryImpl(gallerydbconnectionmanager);
    }

    private com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement compileGetIdStatement(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return readwritesqlitedatabase.compileStatement("SELECT id FROM media_item WHERE object_id_low = ? AND object_id_hi = ?");
    }

    private void deleteHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase, Collection collection, MediaItemDaoChangeList mediaitemdaochangelist, boolean flag)
    {
        EditHelper edithelper;
        EditHelper edithelper1;
        EditHelper edithelper2;
        MediaItemDaoChangeList mediaitemdaochangelist1;
        edithelper = new EditHelper(readwritesqlitedatabase, "media_item", MediaItemKeys.ALL_COLUMNS, new String[] {
            "object_id_low", "object_id_hi"
        });
        edithelper1 = MediaPropertyKeys.newEditHelper(readwritesqlitedatabase);
        edithelper2 = TagMembershipKeys.newEditHelper(readwritesqlitedatabase);
        readwritesqlitedatabase = MediaItemKeys.newEditHelper(readwritesqlitedatabase);
        mediaitemdaochangelist1 = new MediaItemDaoChangeList();
        collection = collection.iterator();
_L2:
        MediaItem mediaitem;
        Object obj1;
        boolean flag1;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_452;
        }
        mediaitem = (MediaItem)collection.next();
        GLogger.v(TAG, "Deleting item: %s", new Object[] {
            mediaitem
        });
        obj1 = mediaitem.getTags();
        flag1 = mediaitem.hasProperty(CommonMediaProperty.LOCAL);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        Object obj = (String)mediaitem.getMetadata().get("media-store.uri");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        context.getContentResolver().delete(Uri.parse(((String) (obj))), null, null);
        int i;
        mediaitemdaochangelist1.clear();
        mediaitemdaochangelist1.addContentsOf(mediaitem, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED);
        i = edithelper.delete(new Object[] {
            Long.valueOf(mediaitem.getObjectId().getLeastSignificantBits()), Long.valueOf(mediaitem.getObjectId().getMostSignificantBits())
        });
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        mediaitemdaochangelist.addAll(mediaitemdaochangelist1);
        obj = new ArrayList(((Set) (obj1)).size());
        obj1 = ((Set) (obj1)).iterator();
_L1:
        Tag tag;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_332;
        }
        tag = (Tag)((Iterator) (obj1)).next();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        tag.setDateCreatedMs((new Date()).getTime());
        ((List) (obj)).add(tag);
        mediaitemdaochangelist.addContentsOf(tag);
          goto _L1
        readwritesqlitedatabase;
        throw readwritesqlitedatabase;
        if (!((List) (obj)).isEmpty())
        {
            tagDao.save(((Collection) (obj)));
        }
        mediaitem.getProperties().clear();
        mediaitem.getMetadata().clear();
        mediaitem.getTags().clear();
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        updateTags(edithelper2, (MediaItemSqliteImpl)mediaitem, true);
        updateProperties(edithelper1, (MediaItemSqliteImpl)mediaitem, true);
        updateMetadata(readwritesqlitedatabase, (MediaItemSqliteImpl)mediaitem, true);
        GLogger.v(TAG, "Deleted item: %s", new Object[] {
            mediaitem
        });
          goto _L2
    }

    private transient String getAggregateQueryForTags(String s, String as[])
    {
        s = new StringBuilder(String.format("SELECT %s FROM %s a INNER JOIN %s b ON a.%s = b.%s INNER JOIN %s c on b.%s = c.%s ", new Object[] {
            s, "media_item", "tag_membership", "id", "media_item_id", "tag", "tag_id", "id"
        }));
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s1 = as[i];
                s.append(" AND ").append(s1);
            }

        }
        return s.toString();
    }

    private List getFramesByMediaItemHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, MediaItem mediaitem)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        String s = String.format("%s = ?", new Object[] {
            "media_item_id"
        });
        mediaitem = (new StringBuilder()).append(((MediaItemSqliteImpl)mediaitem).getId()).append("").toString();
        String s1 = String.format("%s ASC", new Object[] {
            "frame_number"
        });
        readonlysqlitedatabase = readonlysqlitedatabase.query("frame", new String[] {
            "media_item_id", "frame_number", "local_path"
        }, s, new String[] {
            mediaitem
        }, null, null, s1);
        if (readonlysqlitedatabase.moveToFirst())
        {
            for (; !readonlysqlitedatabase.isAfterLast(); readonlysqlitedatabase.moveToNext())
            {
                readonlysqlitedatabase.getInt(readonlysqlitedatabase.getColumnIndexOrThrow("frame_number"));
                arraylist.add(new Frame(readonlysqlitedatabase.getString(readonlysqlitedatabase.getColumnIndexOrThrow("local_path"))));
            }

        }
        break MISSING_BLOCK_LABEL_208;
        mediaitem;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        throw mediaitem;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        return arraylist;
    }

    private Long getIdByObjectIdHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, ObjectID objectid)
    {
        return rawMediaItemIdQuery(readonlysqlitedatabase, String.format("SELECT * FROM %s a WHERE %s = ? AND %s = ?;", new Object[] {
            "media_item", "object_id_low", "object_id_hi"
        }), new String[] {
            (new StringBuilder()).append("").append(objectid.getLeastSignificantBits()).toString(), (new StringBuilder()).append("").append(objectid.getMostSignificantBits()).toString()
        });
    }

    private MediaItem getItemByIdHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, ObjectID objectid)
    {
        return rawMediaItemQuery(readonlysqlitedatabase, String.format("SELECT * FROM %s a WHERE %s = ? AND %s = ?;", new Object[] {
            "media_item", "object_id_low", "object_id_hi"
        }), new String[] {
            (new StringBuilder()).append("").append(objectid.getLeastSignificantBits()).toString(), (new StringBuilder()).append("").append(objectid.getMostSignificantBits()).toString()
        });
    }

    private transient MediaItemCollection getItemsByFieldHelper(SortOrder sortorder, String s, String as[])
    {
        return getItemsByFieldHelper(String.format("%s a", new Object[] {
            "media_item"
        }), sortorder, s, as);
    }

    private transient MediaItemCollection getItemsByFieldHelper(String s, SortOrder sortorder, String s1, String as[])
    {
        com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider cursorrowdataprovider = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
            "a.*"
        }).from(s).where(s1, as).orderBy(sortorder).setRowProcessor(new CursorRowProcessor() {

            final LocalMediaItemDaoSqliteImpl this$0;

            public MediaItem process(Cursor cursor)
            {
                return SQLiteDaoUtil.itemFromCursor(cursor, LocalMediaItemDaoSqliteImpl.this);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                super();
            }
        }).build();
        MediaItemCollectionBeanImpl mediaitemcollectionbeanimpl = new MediaItemCollectionBeanImpl();
        mediaitemcollectionbeanimpl.setMediaItems(cursorListFactory.createCursorList(cursorrowdataprovider));
        mediaitemcollectionbeanimpl.setIterator(cursorListFactory.createIterator(cursorrowdataprovider));
        mediaitemcollectionbeanimpl.setDefaultCoverMediaItem();
        mediaitemcollectionbeanimpl.setTimelineQuery(new TimelineQueryImpl(s, s1, as, sortorder));
        return mediaitemcollectionbeanimpl;
    }

    private List getItemsByMetadataHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, String s, List list, SortOrder sortorder)
    {
        ArrayList arraylist = new ArrayList();
        if (!list.isEmpty()) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        int i = 0;
_L4:
        Cursor cursor;
        if (i >= list.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj = list.subList(i, Math.min(i + 100, list.size()));
        StringBuilder stringbuilder = (new StringBuilder()).append("WHERE ");
        String as[] = new String[((List) (obj)).size() * 2];
        String s1 = String.format(" (b.%s = ? AND b.%s = ?) ", new Object[] {
            "key", "value"
        });
        for (int j = 0; j < ((List) (obj)).size(); j++)
        {
            stringbuilder.append(s1);
            if (j < ((List) (obj)).size() - 1)
            {
                stringbuilder.append(" OR ");
            }
            as[j * 2] = s;
            as[j * 2 + 1] = (String)((List) (obj)).get(j);
        }

        obj = String.format("SELECT * FROM %s a INNER JOIN %s b ON a.%s = b.%s %s ORDER BY %s;", new Object[] {
            "media_item", "metadata", "id", "media_item_id", stringbuilder, sortorder.getOrderByString()
        });
        GLogger.d(TAG, "#getItemsByMetadataHelper: sql='%s'", new Object[] {
            obj
        });
        cursor = readonlysqlitedatabase.rawQuery(((String) (obj)), as);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        if (cursor.moveToFirst())
        {
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                arraylist.add(SQLiteDaoUtil.itemFromCursor(cursor, this));
            }

        }
        break MISSING_BLOCK_LABEL_332;
        readonlysqlitedatabase;
        cursor.close();
        throw readonlysqlitedatabase;
        cursor.close();
        i += 100;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    private MediaItemCollection getItemsByTagHelper(Tag tag, String s, String s1)
    {
        if (tag.hasProperty(TagProperty.CAMERA))
        {
            tag = com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC;
        } else
        {
            tag = com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC;
        }
        return getItemsByTagHelper(s, s1, new SortOrder(new SortClause[] {
            new SortClause("has_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("date_created", tag)
        }));
    }

    private MediaItemCollection getItemsByTagHelper(String s, String s1, SortOrder sortorder)
    {
        return getItemsByFieldHelper(String.format("%s a INNER JOIN %s b ON a.%s = b.%s", new Object[] {
            "media_item", "tag_membership", "id", "media_item_id"
        }), sortorder, s, new String[] {
            s1
        });
    }

    private long getMediaItemId(com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement, MediaItem mediaitem)
    {
        readwritesqlitestatement.bindLong(1, mediaitem.getObjectId().getLeastSignificantBits());
        readwritesqlitestatement.bindLong(2, mediaitem.getObjectId().getMostSignificantBits());
        long l;
        try
        {
            l = readwritesqlitestatement.simpleQueryForLong();
        }
        // Misplaced declaration of an exception variable
        catch (com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement)
        {
            return -1L;
        }
        return l;
    }

    private Map getMetadataByMediaItemHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, MediaItem mediaitem)
    {
        HashMap hashmap;
        hashmap = new HashMap();
        String s = String.format("%s = ?", new Object[] {
            "media_item_id"
        });
        mediaitem = (new StringBuilder()).append(((MediaItemSqliteImpl)mediaitem).getId()).append("").toString();
        readonlysqlitedatabase = readonlysqlitedatabase.query("metadata", new String[] {
            "key", "value"
        }, s, new String[] {
            mediaitem
        }, null, null, null);
        if (readonlysqlitedatabase.moveToFirst())
        {
            for (; !readonlysqlitedatabase.isAfterLast(); readonlysqlitedatabase.moveToNext())
            {
                hashmap.put(readonlysqlitedatabase.getString(readonlysqlitedatabase.getColumnIndexOrThrow("key")), readonlysqlitedatabase.getString(readonlysqlitedatabase.getColumnIndexOrThrow("value")));
            }

        }
        break MISSING_BLOCK_LABEL_176;
        mediaitem;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        throw mediaitem;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        return hashmap;
    }

    private Set getPropertiesByMediaItemHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, MediaItem mediaitem)
    {
        HashSet hashset;
        hashset = new HashSet();
        String s = String.format("%s = ?", new Object[] {
            "media_item_id"
        });
        mediaitem = (new StringBuilder()).append(((MediaItemSqliteImpl)mediaitem).getId()).append("").toString();
        readonlysqlitedatabase = readonlysqlitedatabase.query("media_property", new String[] {
            "property"
        }, s, new String[] {
            mediaitem
        }, null, null, null);
        if (!readonlysqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_188;
        }
_L1:
        MediaProperty mediaproperty;
        if (readonlysqlitedatabase.isAfterLast())
        {
            break MISSING_BLOCK_LABEL_188;
        }
        mediaitem = readonlysqlitedatabase.getString(0);
        mediaproperty = MediaProperty.fromString(mediaitem);
        if (mediaproperty != null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        GLogger.w(TAG, "Encountered bad property '%s'; skipping", new Object[] {
            mediaitem
        });
        readonlysqlitedatabase.moveToNext();
          goto _L1
        mediaitem;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        throw mediaitem;
        hashset.add(mediaproperty);
        readonlysqlitedatabase.moveToNext();
          goto _L1
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        return hashset;
    }

    private void insertMediaItem(ReadWriteSQLiteDatabase readwritesqlitedatabase, MediaItemSqliteImpl mediaitemsqliteimpl)
    {
        this;
        JVM INSTR monitorenter ;
        com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement;
        if (insertSqLiteStatement == null)
        {
            insertSqLiteStatement = readwritesqlitedatabase.compileStatement(SQLiteDaoUtil.insertClause("media_item", new String[] {
                "type", "object_id_low", "object_id_hi", "width", "height", "caption", "name", "asset_hash", "date_created", "date_created_utc", 
                "date_modified", "date_added", "orientation", "has_date", "time_stamp", "duration", "group_type", "mime_type", "sync_state", "event_id", 
                "full_md5", "local_path", "file_size", "hidden", "timeline_time_stamp", "timeline_date_added", "has_time_stamp"
            }));
        }
        readwritesqlitedatabase = mediaitemsqliteimpl.getObjectId();
        readwritesqlitestatement = insertSqLiteStatement;
        int j = 1 + 1;
        readwritesqlitestatement.bindLong(1, mediaitemsqliteimpl.getType().ordinal());
        readwritesqlitestatement = insertSqLiteStatement;
        int i = j + 1;
        readwritesqlitestatement.bindLong(j, readwritesqlitedatabase.getLeastSignificantBits());
        readwritesqlitestatement = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitestatement.bindLong(i, readwritesqlitedatabase.getMostSignificantBits());
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindLong(j, mediaitemsqliteimpl.getWidth());
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, mediaitemsqliteimpl.getHeight());
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindNull(j);
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindString(i, mediaitemsqliteimpl.getName());
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindLong(j, mediaitemsqliteimpl.getAssetHash());
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, mediaitemsqliteimpl.getDateCreatedMs());
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindLong(j, mediaitemsqliteimpl.getDateCreatedUTCMs());
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, mediaitemsqliteimpl.getDateModifiedMs());
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindLong(j, mediaitemsqliteimpl.getDateAddedMs());
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, 0L);
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        long l;
        if (mediaitemsqliteimpl.hasDate())
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        readwritesqlitedatabase.bindLong(j, l);
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, mediaitemsqliteimpl.getTimestampMs());
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        if (mediaitemsqliteimpl.getType() != MediaType.VIDEO) goto _L2; else goto _L1
_L1:
        l = ((Video)mediaitemsqliteimpl).getDuration();
_L5:
        readwritesqlitedatabase.bindLong(j, l);
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, mediaitemsqliteimpl.getGroupType().value);
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindString(j, mediaitemsqliteimpl.getMIMEType());
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, mediaitemsqliteimpl.getSyncState().value);
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindLong(j, mediaitemsqliteimpl.getEventId());
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindString(i, mediaitemsqliteimpl.getFullMd5());
        if (mediaitemsqliteimpl.getLocalPath() != null) goto _L4; else goto _L3
_L3:
        insertSqLiteStatement.bindNull(j);
        i = j + 1;
_L6:
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, mediaitemsqliteimpl.getSize());
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        if (mediaitemsqliteimpl.isHidden())
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        readwritesqlitedatabase.bindLong(j, l);
        readwritesqlitedatabase = insertSqLiteStatement;
        j = i + 1;
        readwritesqlitedatabase.bindLong(i, TimelineUtils.getTimelineTimestamp(mediaitemsqliteimpl));
        readwritesqlitedatabase = insertSqLiteStatement;
        i = j + 1;
        readwritesqlitedatabase.bindLong(j, TimelineUtils.getTimelineDateCreated(mediaitemsqliteimpl));
        readwritesqlitedatabase = insertSqLiteStatement;
        if (mediaitemsqliteimpl.hasTimestamp())
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        readwritesqlitedatabase.bindLong(i, l);
        mediaitemsqliteimpl.setId(insertSqLiteStatement.executeInsert());
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        l = 0L;
          goto _L5
_L4:
        insertSqLiteStatement.bindString(j, mediaitemsqliteimpl.getLocalPath());
        i = j + 1;
          goto _L6
        readwritesqlitedatabase;
        throw readwritesqlitedatabase;
          goto _L5
    }

    private void insertTagsMediaItem(ReadWriteSQLiteDatabase readwritesqlitedatabase, MediaItemSqliteImpl mediaitemsqliteimpl)
    {
        if (insertTagMembershipSqLiteStatement == null)
        {
            insertTagMembershipSqLiteStatement = readwritesqlitedatabase.compileStatement(SQLiteDaoUtil.insertClause("tag_membership", new String[] {
                "media_item_id", "tag_id", "tag_media_revision_id"
            }));
        }
        for (readwritesqlitedatabase = mediaitemsqliteimpl.getTags().iterator(); readwritesqlitedatabase.hasNext(); insertTagMembershipSqLiteStatement.executeInsert())
        {
            TagSqliteImpl tagsqliteimpl = (TagSqliteImpl)(Tag)readwritesqlitedatabase.next();
            insertTagMembershipSqLiteStatement.bindLong(1, mediaitemsqliteimpl.getId());
            insertTagMembershipSqLiteStatement.bindLong(2, tagsqliteimpl.getId());
            insertTagMembershipSqLiteStatement.bindLong(3, tagsqliteimpl.getDateCreatedMs());
        }

    }

    private ContentValues mediaItemContentValues(MediaItemSqliteImpl mediaitemsqliteimpl)
    {
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        ObjectID objectid = mediaitemsqliteimpl.getObjectId();
        contentvalues.put("type", Integer.valueOf(mediaitemsqliteimpl.getType().ordinal()));
        contentvalues.put("object_id_low", Long.valueOf(objectid.getLeastSignificantBits()));
        contentvalues.put("object_id_hi", Long.valueOf(objectid.getMostSignificantBits()));
        contentvalues.put("width", Integer.valueOf(mediaitemsqliteimpl.getWidth()));
        contentvalues.put("height", Integer.valueOf(mediaitemsqliteimpl.getHeight()));
        contentvalues.put("caption", mediaitemsqliteimpl.getCaption());
        contentvalues.put("name", mediaitemsqliteimpl.getName());
        contentvalues.put("asset_hash", Integer.valueOf(mediaitemsqliteimpl.getAssetHash()));
        contentvalues.put("date_created", Long.valueOf(mediaitemsqliteimpl.getDateCreatedMs()));
        contentvalues.put("date_created_utc", Long.valueOf(mediaitemsqliteimpl.getDateCreatedUTCMs()));
        contentvalues.put("date_modified", Long.valueOf(mediaitemsqliteimpl.getDateModifiedMs()));
        contentvalues.put("date_added", Long.valueOf(mediaitemsqliteimpl.getDateAddedMs()));
        contentvalues.put("orientation", Integer.valueOf(mediaitemsqliteimpl.getOrientation()));
        int i;
        if (mediaitemsqliteimpl.hasDate())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("has_date", Integer.valueOf(i));
        contentvalues.put("time_stamp", Long.valueOf(mediaitemsqliteimpl.getTimestampMs()));
        contentvalues.put("mime_type", mediaitemsqliteimpl.getMIMEType());
        contentvalues.put("event_id", Long.valueOf(mediaitemsqliteimpl.getEventId()));
        contentvalues.put("full_md5", mediaitemsqliteimpl.getFullMd5());
        contentvalues.put("file_size", Long.valueOf(mediaitemsqliteimpl.getSize()));
        if (mediaitemsqliteimpl.isHidden())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("hidden", Integer.valueOf(i));
        contentvalues.put("timeline_time_stamp", Integer.valueOf(TimelineUtils.getTimelineTimestamp(mediaitemsqliteimpl)));
        contentvalues.put("timeline_date_added", Integer.valueOf(TimelineUtils.getTimelineDateCreated(mediaitemsqliteimpl)));
        if (mediaitemsqliteimpl.hasTimestamp())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("has_time_stamp", Integer.valueOf(i));
        objectid = mediaitemsqliteimpl.getParentObjectID();
        if (objectid != null)
        {
            contentvalues.put("parent_media_id_low", Long.valueOf(objectid.getLeastSignificantBits()));
            contentvalues.put("parent_media_id_hi", Long.valueOf(objectid.getMostSignificantBits()));
        }
        objectid = mediaitemsqliteimpl.getUploadedObjectId();
        if (objectid != null)
        {
            contentvalues.put("uploaded_id_low", Long.valueOf(objectid.getLeastSignificantBits()));
            contentvalues.put("uploaded_id_hi", Long.valueOf(objectid.getMostSignificantBits()));
        }
        if (!mediaitemsqliteimpl.hasProperty(CommonMediaProperty.LOCAL)) goto _L2; else goto _L1
_L1:
        contentvalues.put("local_path", mediaitemsqliteimpl.getLocalPath());
        if (mediaitemsqliteimpl.getSyncState() == null)
        {
            if (shouldSkipUpload(mediaitemsqliteimpl))
            {
                GLogger.d(TAG, "Marking local MediaItem %s already synced because it was created before the device was registered.", new Object[] {
                    mediaitemsqliteimpl.getObjectId().toString()
                });
                mediaitemsqliteimpl.setSyncState(SyncState.SKIPPED);
                contentvalues.put("uploaded_id_low", "skipped");
                contentvalues.put("uploaded_id_hi", "skipped");
            } else
            {
                MediaItem mediaitem = getItemById(mediaitemsqliteimpl.getObjectId());
                if (mediaitem == null || mediaitem.getSyncState() == null)
                {
                    mediaitemsqliteimpl.setSyncState(SyncState.NOT_SYNCED);
                } else
                {
                    mediaitemsqliteimpl.setSyncState(mediaitem.getSyncState());
                }
            }
        }
_L4:
        if (mediaitemsqliteimpl.getGroupType() == null)
        {
            mediaitemsqliteimpl.setGroupType(GroupType.NONE);
        }
        contentvalues.put("sync_state", Integer.valueOf(mediaitemsqliteimpl.getSyncState().value));
        contentvalues.put("group_type", Integer.valueOf(mediaitemsqliteimpl.getGroupType().value));
        if (mediaitemsqliteimpl.getType() == MediaType.VIDEO)
        {
            contentvalues.put("duration", Long.valueOf(((Video)mediaitemsqliteimpl).getDuration()));
        }
        return contentvalues;
_L2:
        contentvalues.putNull("local_path");
        if (mediaitemsqliteimpl.getSyncState() == null)
        {
            mediaitemsqliteimpl.setSyncState(SyncState.SYNCED);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Long rawMediaItemIdQuery(ReadOnlySQLiteDatabase readonlysqlitedatabase, String s, String as[])
    {
        readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(s, as);
        if (readonlysqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (readonlysqlitedatabase.getCount() > 1)
        {
            throw new RuntimeException((new StringBuilder()).append("Two Items with matching objectIds! - ").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_58;
        s;
        readonlysqlitedatabase.close();
        throw s;
        long l;
        if (readonlysqlitedatabase.getCount() != 1 || !readonlysqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        l = readonlysqlitedatabase.getLong(readonlysqlitedatabase.getColumnIndex("id"));
        readonlysqlitedatabase.close();
        return Long.valueOf(l);
        readonlysqlitedatabase.close();
        return Long.valueOf(0L);
    }

    private MediaItem rawMediaItemQuery(ReadOnlySQLiteDatabase readonlysqlitedatabase, String s, String as[])
    {
        Object obj;
        Object obj1 = null;
        obj = null;
        as = readonlysqlitedatabase.rawQuery(s, as);
        readonlysqlitedatabase = obj1;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        if (as.getCount() > 1)
        {
            throw new RuntimeException((new StringBuilder()).append("Two Items with matching objectIds! - ").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_67;
        readonlysqlitedatabase;
        as.close();
        throw readonlysqlitedatabase;
        readonlysqlitedatabase = obj;
        if (as.getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        readonlysqlitedatabase = obj;
        if (as.moveToFirst())
        {
            readonlysqlitedatabase = SQLiteDaoUtil.itemFromCursor(as, this);
        }
        as.close();
        return readonlysqlitedatabase;
    }

    private void saveHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase, Collection collection, MediaItemDaoChangeList mediaitemdaochangelist)
    {
        EditHelper edithelper;
        EditHelper edithelper1;
        EditHelper edithelper2;
        EditHelper edithelper3;
        EditHelper edithelper4;
        edithelper = MediaItemKeys.newEditHelper(readwritesqlitedatabase);
        edithelper1 = MediaPropertyKeys.newEditHelper(readwritesqlitedatabase);
        edithelper2 = MetadataKeys.newEditHelper(readwritesqlitedatabase);
        edithelper3 = TagMembershipKeys.newEditHelper(readwritesqlitedatabase);
        edithelper4 = FrameKeys.newEditHelper(readwritesqlitedatabase);
        readwritesqlitedatabase = compileGetIdStatement(readwritesqlitedatabase);
        Iterator iterator = collection.iterator();
_L5:
        MediaItemSqliteImpl mediaitemsqliteimpl;
        MediaItem mediaitem;
        ContentValues contentvalues;
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_400;
        }
        mediaitem = (MediaItem)iterator.next();
        mediaitemsqliteimpl = (MediaItemSqliteImpl)mediaitem;
        contentvalues = mediaItemContentValues(mediaitemsqliteimpl);
        if (!mediaitemsqliteimpl.isPersisted())
        {
            mediaitemsqliteimpl.setId(getMediaItemId(readwritesqlitedatabase, mediaitem));
        }
        flag = mediaitemsqliteimpl.isPersisted();
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = edithelper.update(contentvalues, new Object[] {
            Long.valueOf(mediaitemsqliteimpl.getId())
        });
        if (i != 1) goto _L4; else goto _L3
_L3:
        mediaitemdaochangelist.addContentsOf(mediaitemsqliteimpl, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
_L6:
        updateProperties(edithelper1, mediaitemsqliteimpl, true);
        updateTags(edithelper3, mediaitemsqliteimpl, true);
        updateMetadata(edithelper2, mediaitemsqliteimpl, true);
        if (mediaitemsqliteimpl.getGroupType() == GroupType.LENTICULAR || mediaitemsqliteimpl.getGroupType() == GroupType.REWIND)
        {
            updateFrames(edithelper4, mediaitemsqliteimpl, false);
        }
        if (collection.size() < 10)
        {
            GLogger.v(TAG, "Updated item: %s", new Object[] {
                mediaitem
            });
        }
          goto _L5
        collection;
        readwritesqlitedatabase.close();
        edithelper.close();
        edithelper1.close();
        edithelper2.close();
        edithelper3.close();
        edithelper4.close();
        throw collection;
        SQLiteConstraintException sqliteconstraintexception;
        sqliteconstraintexception;
        GLogger.exf(TAG, sqliteconstraintexception, "Exception updating item: %s", new Object[] {
            mediaitemsqliteimpl
        });
        if (!DebugAssert.isUserBuild)
        {
            throw sqliteconstraintexception;
        }
          goto _L5
_L4:
        GLogger.e(TAG, "Failed to update item: %s. update returned: %d", new Object[] {
            mediaitemsqliteimpl, Integer.valueOf(i)
        });
          goto _L6
_L2:
        long l = edithelper.insert(contentvalues);
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        mediaitemdaochangelist.addContentsOf(mediaitemsqliteimpl, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
        mediaitemsqliteimpl.setId(l);
          goto _L6
        GLogger.e(TAG, "Failed to insert item: %s. error: %d", new Object[] {
            mediaitemsqliteimpl, Long.valueOf(l)
        });
          goto _L6
        readwritesqlitedatabase.close();
        edithelper.close();
        edithelper1.close();
        edithelper2.close();
        edithelper3.close();
        edithelper4.close();
        return;
          goto _L5
    }

    private boolean shouldSkipUpload(MediaItem mediaitem)
    {
        long l;
        if (!UPLOAD_PRE_REGISTRATION_PHOTOS)
        {
            if (mediaitem.getDateAddedMs() < (l = context.getSharedPreferences("galleryKindleSharedPrefs", 0).getLong("deregistrationTimestamp", 0L)) && mediaitem.hasProperty(CommonMediaProperty.CAMERA))
            {
                return true;
            }
        }
        return false;
    }

    private void updateFrames(EditHelper edithelper, MediaItemSqliteImpl mediaitemsqliteimpl, boolean flag)
    {
        if (flag)
        {
            edithelper.delete(new Object[] {
                Long.valueOf(mediaitemsqliteimpl.getId())
            });
        }
        List list = ((OrderedGroupPhoto)mediaitemsqliteimpl).getFrames();
        for (int i = 0; i < list.size(); i++)
        {
            Frame frame = (Frame)list.get(i);
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("media_item_id", Long.valueOf(mediaitemsqliteimpl.getId()));
            contentvalues.put("frame_number", Integer.valueOf(i));
            contentvalues.put("local_path", frame.getLocalPath());
            if (edithelper.replace(contentvalues) != -1L);
        }

    }

    private void updateMetadata(EditHelper edithelper, MediaItemSqliteImpl mediaitemsqliteimpl, boolean flag)
    {
        Object obj = mediaitemsqliteimpl.getMetadata();
        if (flag)
        {
            edithelper.delete(new Object[] {
                Long.valueOf(mediaitemsqliteimpl.getId())
            });
        }
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("media_item_id", Long.valueOf(mediaitemsqliteimpl.getId()));
            contentvalues.put("key", (String)entry.getKey());
            contentvalues.put("value", (String)entry.getValue());
            if (edithelper.replace(contentvalues) != -1L);
        }

    }

    private void updateProperties(EditHelper edithelper, MediaItemSqliteImpl mediaitemsqliteimpl, boolean flag)
    {
        Object obj = mediaitemsqliteimpl.getProperties();
        if (flag)
        {
            edithelper.delete(new Object[] {
                Long.valueOf(mediaitemsqliteimpl.getId())
            });
        }
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            MediaProperty mediaproperty = (MediaProperty)((Iterator) (obj)).next();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("media_item_id", Long.valueOf(mediaitemsqliteimpl.getId()));
            contentvalues.put("property", mediaproperty.getName());
            if (edithelper.replace(contentvalues) != -1L);
        }

    }

    private void updateTags(EditHelper edithelper, MediaItemSqliteImpl mediaitemsqliteimpl, boolean flag)
    {
        Object obj;
        obj = mediaitemsqliteimpl.getTags();
        if (flag)
        {
            edithelper.delete(new Object[] {
                Long.valueOf(mediaitemsqliteimpl.getId())
            });
        }
        obj = ((Set) (obj)).iterator();
_L2:
        ContentValues contentvalues;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = (Tag)((Iterator) (obj)).next();
        contentvalues = new ContentValues();
        obj1 = (TagSqliteImpl)obj1;
        contentvalues.put("media_item_id", Long.valueOf(mediaitemsqliteimpl.getId()));
        contentvalues.put("tag_id", Long.valueOf(((TagSqliteImpl) (obj1)).getId()));
        contentvalues.put("tag_media_revision_id", Long.valueOf(((TagSqliteImpl) (obj1)).getDateCreatedMs()));
        long l = edithelper.replace(contentvalues);
        if (l != -1L);
        continue; /* Loop/switch isn't completed */
        SQLiteConstraintException sqliteconstraintexception;
        sqliteconstraintexception;
        GLogger.exf(TAG, sqliteconstraintexception, "SQLiteConstraintException while updating tag membership table", new Object[0]);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void addTagMemberships(final List items, final Tag tag)
    {
        GLogger.v(TAG, "Adding %s items to tag %s", new Object[] {
            String.valueOf(items.size()), tag.getLabel()
        });
        (new DBWriteExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final List val$items;
            final Tag val$tag;

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                if (replaceTagMembershipSqLiteStatement == null)
                {
                    String s = SQLiteDaoUtil.replaceClause("tag_membership", new String[] {
                        "media_item_id", "tag_id", "tag_media_revision_id"
                    });
                    replaceTagMembershipSqLiteStatement = readwritesqlitedatabase.compileStatement(s);
                }
                replaceTagMembershipSqLiteStatement.bindLong(2, tag.getId());
                replaceTagMembershipSqLiteStatement.bindLong(3, tag.getDateCreatedMs());
                for (readwritesqlitedatabase = items.iterator(); readwritesqlitedatabase.hasNext(); replaceTagMembershipSqLiteStatement.executeInsert())
                {
                    MediaItem mediaitem = (MediaItem)readwritesqlitedatabase.next();
                    replaceTagMembershipSqLiteStatement.bindLong(1, mediaitem.getId());
                }

                return null;
            }

            protected void postTransaction()
            {
                context.getContentResolver().notifyChange(LocalMediaItemDaoSqliteImpl.MEDIA_ITEM_URI, null);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                tag = tag1;
                items = list;
                super();
            }
        }).execute(connectionManager);
    }

    public MediaItemDaoChangeList bulkInsert(final Collection items)
    {
        if (items.size() == 0)
        {
            return new MediaItemDaoChangeList();
        } else
        {
            return (MediaItemDaoChangeList)(new DBWriteExecutor() {

                final LocalMediaItemDaoSqliteImpl this$0;
                final Collection val$items;

                protected MediaItemDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
                    for (Iterator iterator = items.iterator(); iterator.hasNext();)
                    {
                        MediaItem mediaitem = (MediaItem)iterator.next();
                        MediaItemSqliteImpl mediaitemsqliteimpl = (MediaItemSqliteImpl)mediaitem;
                        try
                        {
                            insertMediaItem(readwritesqlitedatabase, mediaitemsqliteimpl);
                            insertTagsMediaItem(readwritesqlitedatabase, mediaitemsqliteimpl);
                            mediaitemdaochangelist.addContentsOf(mediaitem, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
                        }
                        catch (SQLiteConstraintException sqliteconstraintexception)
                        {
                            GLogger.w(LocalMediaItemDaoSqliteImpl.TAG, "constraint exception on %s", new Object[] {
                                mediaitemsqliteimpl.getObjectId()
                            });
                        }
                    }

                    return mediaitemdaochangelist;
                }

                protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    return execute(readwritesqlitedatabase);
                }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                items = collection;
                super();
            }
            }).execute(connectionManager);
        }
    }

    public MediaItem create(MediaType mediatype)
    {
        if (mediatype == MediaType.PHOTO)
        {
            return new PhotoSqliteImpl(this);
        } else
        {
            return new VideoSqliteImpl(this);
        }
    }

    public MediaItem create(MediaType mediatype, GroupType grouptype)
    {
        static class _cls31
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$GroupType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$GroupType = new int[GroupType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$GroupType[GroupType.LENTICULAR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$GroupType[GroupType.REWIND.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls31..SwitchMap.com.amazon.gallery.framework.model.media.GroupType[grouptype.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 47
    //                   2 59;
           goto _L1 _L2 _L3
_L1:
        mediatype = create(mediatype);
_L5:
        mediatype.setGroupType(grouptype);
        return mediatype;
_L2:
        mediatype = new LenticularSqliteImpl(this);
        continue; /* Loop/switch isn't completed */
_L3:
        mediatype = new RewindPhotoSqliteImpl(this);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public MediaItemDaoChangeList delete(MediaItem mediaitem)
    {
        return delete(((Collection) (Collections.singletonList(mediaitem))));
    }

    public MediaItemDaoChangeList delete(final Collection items)
    {
        GLogger.v(TAG, "Deleting items: %s", new Object[] {
            items
        });
        return (MediaItemDaoChangeList)(new DBWriteExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final Collection val$items;

            public MediaItemDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
                deleteHelper(readwritesqlitedatabase, items, mediaitemdaochangelist, false);
                if (!mediaitemdaochangelist.getAllChangeList().isEmpty())
                {
                    incrementSessionCounter();
                }
                return mediaitemdaochangelist;
            }

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            protected void postTransaction()
            {
                context.getContentResolver().notifyChange(LocalMediaItemDaoSqliteImpl.MEDIA_ITEM_URI, null);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                items = collection;
                super();
            }
        }).execute(connectionManager);
    }

    public MediaItemDaoChangeList deleteKeepFile(MediaItem mediaitem)
    {
        return deleteKeepFile(((Collection) (Collections.singletonList(mediaitem))));
    }

    public MediaItemDaoChangeList deleteKeepFile(final Collection items)
    {
        GLogger.v(TAG, "Deleting items: %s", new Object[] {
            items
        });
        return (MediaItemDaoChangeList)(new DBWriteExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final Collection val$items;

            public MediaItemDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
                deleteHelper(readwritesqlitedatabase, items, mediaitemdaochangelist, true);
                if (!mediaitemdaochangelist.getAllChangeList().isEmpty())
                {
                    incrementSessionCounter();
                }
                return mediaitemdaochangelist;
            }

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            protected void postTransaction()
            {
                context.getContentResolver().notifyChange(LocalMediaItemDaoSqliteImpl.MEDIA_ITEM_URI, null);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                items = collection;
                super();
            }
        }).execute(connectionManager);
    }

    public void deleteTagMemberships(final List mediaItems, final Tag tag)
    {
        GLogger.v(TAG, "Deleting %s items from tag %s", new Object[] {
            String.valueOf(mediaItems.size()), tag.getLabel()
        });
        (new DBWriteExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final List val$mediaItems;
            final Tag val$tag;

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            public Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                if (deleteTagMembershipSqLiteStatement == null)
                {
                    String s = SQLiteDaoUtil.deleteClause("tag_membership", "media_item_id=? AND tag_id=?");
                    deleteTagMembershipSqLiteStatement = readwritesqlitedatabase.compileStatement(s);
                }
                deleteTagMembershipSqLiteStatement.bindString(2, String.valueOf(tag.getId()));
                for (readwritesqlitedatabase = mediaItems.iterator(); readwritesqlitedatabase.hasNext(); deleteTagMembershipSqLiteStatement.executeUpdateDelete())
                {
                    MediaItem mediaitem = (MediaItem)readwritesqlitedatabase.next();
                    deleteTagMembershipSqLiteStatement.bindString(1, String.valueOf(mediaitem.getId()));
                }

                return null;
            }

            protected void postTransaction()
            {
                context.getContentResolver().notifyChange(LocalMediaItemDaoSqliteImpl.MEDIA_ITEM_URI, null);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                tag = tag1;
                mediaItems = list;
                super();
            }
        }).execute(connectionManager);
    }

    public MediaItemCollection getAllItems()
    {
        return getAllItems(MediaItemSortType.TIME_STAMP_DESC.getSortOrder());
    }

    public MediaItemCollection getAllItems(SortOrder sortorder)
    {
        return getAllItems(new MediaFilter(), sortorder);
    }

    public MediaItemCollection getAllItems(MediaFilter mediafilter, SortOrder sortorder)
    {
        if (mediafilter.isSet())
        {
            mediafilter = mediafilter.getWhereClause();
        } else
        {
            mediafilter = null;
        }
        return getItemsByFieldHelper(sortorder, mediafilter, new String[0]);
    }

    public int getAutosaveableMediaItemCount(final boolean onlyUnuploaded)
    {
        DBReadExecutor dbreadexecutor = new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final boolean val$onlyUnuploaded;

            public Integer execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                Object obj;
                String s;
                obj = new ArrayList();
                ((List) (obj)).add(String.format("c.%s = %d", new Object[] {
                    "valid", Integer.valueOf(1)
                }));
                ((List) (obj)).add(String.format("c.%s = %d", new Object[] {
                    "type", Integer.valueOf(TagType.LOCAL_FOLDER.ordinal())
                }));
                ((List) (obj)).add(String.format("c.%s = %d", new Object[] {
                    "auto_save", Integer.valueOf(1)
                }));
                if (onlyUnuploaded)
                {
                    ((List) (obj)).add(String.format("a.%s IN %s", new Object[] {
                        "sync_state", LocalMediaItemDaoSqliteImpl.UNUPLOADED_SYNC_STATES
                    }));
                }
                s = getAggregateQueryForTags("COUNT(*) AS COUNT", (String[])((List) (obj)).toArray(new String[((List) (obj)).size()]));
                obj = null;
                readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(s, null);
                obj = readonlysqlitedatabase;
                if (!readonlysqlitedatabase.moveToFirst())
                {
                    break MISSING_BLOCK_LABEL_206;
                }
                obj = readonlysqlitedatabase;
                int j = readonlysqlitedatabase.getInt(0);
                if (readonlysqlitedatabase != null)
                {
                    readonlysqlitedatabase.close();
                }
                return Integer.valueOf(j);
                if (readonlysqlitedatabase != null)
                {
                    readonlysqlitedatabase.close();
                }
                return Integer.valueOf(-1);
                readonlysqlitedatabase;
                if (obj != null)
                {
                    ((Cursor) (obj)).close();
                }
                throw readonlysqlitedatabase;
            }

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                onlyUnuploaded = flag;
                super();
            }
        };
        int i;
        try
        {
            i = ((Integer)dbreadexecutor.execute(connectionManager)).intValue();
        }
        catch (SQLiteException sqliteexception)
        {
            GLogger.ex(TAG, "Error fetching autosaveable media item count", sqliteexception);
            return -1;
        }
        return i;
    }

    public Map getCloudCountByType()
    {
        return (Map)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            protected Map execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                Object obj;
                obj = new HashMap();
                readonlysqlitedatabase = readonlysqlitedatabase.rawQuery("select type ordinal, count(*) count from media_item where local_path is NULL group by type", null);
                while (readonlysqlitedatabase.moveToNext()) 
                {
                    int i = readonlysqlitedatabase.getInt(readonlysqlitedatabase.getColumnIndexOrThrow("ordinal"));
                    int j = readonlysqlitedatabase.getInt(readonlysqlitedatabase.getColumnIndexOrThrow("count"));
                    ((Map) (obj)).put(MediaType.values()[i], Integer.valueOf(j));
                }
                break MISSING_BLOCK_LABEL_98;
                obj;
                if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
                {
                    readonlysqlitedatabase.close();
                }
                throw obj;
                if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
                {
                    readonlysqlitedatabase.close();
                }
                return ((Map) (obj));
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                super();
            }
        }).execute(connectionManager);
    }

    public List getFramesByMediaItem(final MediaItem mediaItem)
    {
        return (List)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final MediaItem val$mediaItem;

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            protected List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getFramesByMediaItemHelper(readonlysqlitedatabase, mediaItem);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                mediaItem = mediaitem;
                super();
            }
        }).execute(connectionManager);
    }

    public MediaItem getItemById(final ObjectID id)
    {
        return (MediaItem)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final ObjectID val$id;

            public MediaItem execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getItemByIdHelper(readonlysqlitedatabase, id);
            }

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                id = objectid;
                super();
            }
        }).execute(connectionManager);
    }

    public Long getItemIdByObjectID(final ObjectID id)
    {
        return (Long)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final ObjectID val$id;

            public Long execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getIdByObjectIdHelper(readonlysqlitedatabase, id);
            }

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                id = objectid;
                super();
            }
        }).execute(connectionManager);
    }

    public MediaItemCollection getItemsByFullMd5(String s)
    {
        return getItemsByFieldHelper(new SortOrder(new SortClause[] {
            new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC)
        }), String.format("a.%s = ?", new Object[] {
            "full_md5"
        }), new String[] {
            s
        });
    }

    public MediaItemCollection getItemsByFullMd5AndSyncState(String s, SyncState syncstate)
    {
        return getItemsByFieldHelper(new SortOrder(new SortClause[] {
            new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC)
        }), String.format("a.%s = ? AND a.%s = ?", new Object[] {
            "sync_state", "full_md5"
        }), new String[] {
            String.valueOf(syncstate.value), s
        });
    }

    public MediaItemCollection getItemsByGroupType(GroupType grouptype)
    {
        return getItemsByFieldHelper(new SortOrder(new SortClause[] {
            new SortClause("has_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC)
        }), String.format("a.%s = ?", new Object[] {
            "group_type"
        }), new String[] {
            (new StringBuilder()).append("").append(grouptype.value).toString()
        });
    }

    public MediaItemCollection getItemsByLocalPath(String s)
    {
        return getItemsByFieldHelper(new SortOrder(new SortClause[] {
            new SortClause("has_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC)
        }), String.format("a.%s = ?", new Object[] {
            "local_path"
        }), new String[] {
            s
        });
    }

    public List getItemsByMetadata(final String key, final List value)
    {
        return (List)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final String val$key;
            final List val$value;

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            public List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getItemsByMetadataHelper(readonlysqlitedatabase, key, value, new SortOrder("id"));
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                key = s;
                value = list;
                super();
            }
        }).execute(connectionManager);
    }

    public MediaItemCollection getItemsByMimeType(String s)
    {
        return getItemsByFieldHelper(new SortOrder(new SortClause[] {
            new SortClause("has_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC)
        }), String.format("a.%s = ?", new Object[] {
            "mime_type"
        }), new String[] {
            s
        });
    }

    public MediaItemCollection getItemsByProperty(MediaProperty mediaproperty, SortOrder sortorder)
    {
        return getItemsByProperty(mediaproperty, new MediaFilter(), sortorder);
    }

    public MediaItemCollection getItemsByProperty(MediaProperty mediaproperty, MediaFilter mediafilter, SortOrder sortorder)
    {
        String s2 = String.format("%s a INNER JOIN %s b ON a.%s = b.%s", new Object[] {
            "media_item", "media_property", "id", "media_item_id"
        });
        String s1 = String.format("b.%s = ?", new Object[] {
            "property"
        });
        String s = s1;
        if (mediafilter.isSet())
        {
            s = (new StringBuilder()).append(s1).append(" AND ").append(mediafilter.getWhereClause()).toString();
        }
        return getItemsByFieldHelper(s2, sortorder, s, new String[] {
            mediaproperty.getName()
        });
    }

    public MediaItemCollection getItemsBySyncState(SyncState syncstate)
    {
        return getItemsByFieldHelper(new SortOrder(new SortClause[] {
            new SortClause("has_date", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC), new SortClause("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC)
        }), String.format("a.%s = ?", new Object[] {
            "sync_state"
        }), new String[] {
            (new StringBuilder()).append("").append(syncstate.value).toString()
        });
    }

    public MediaItemCollection getItemsByTag(Tag tag)
    {
        return getItemsByTagHelper(tag, "b.tag_id = ?", String.valueOf(((TagSqliteImpl)tag).getId()));
    }

    public MediaItemCollection getItemsByTag(Tag tag, MediaFilter mediafilter)
    {
        TagSqliteImpl tagsqliteimpl = (TagSqliteImpl)tag;
        if (!mediafilter.isSet())
        {
            return getItemsByTag(tag);
        } else
        {
            return getItemsByTagHelper(tag, (new StringBuilder()).append("b.tag_id = ? AND ").append(mediafilter.getWhereClause()).toString(), String.valueOf(tagsqliteimpl.getId()));
        }
    }

    public int getMediaItemCount(final Tag tag)
    {
        return ((Integer)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final Tag val$tag;

            public Integer execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                String as[];
                Object obj;
                String s;
                obj = null;
                as = null;
                if (tag != null)
                {
                    obj = String.format("c.%s = ?", new Object[] {
                        "id", Long.valueOf(tag.getId())
                    });
                    as = new String[1];
                    as[0] = String.valueOf(tag.getId());
                }
                s = getAggregateQueryForTags("COUNT(*) AS COUNT", new String[] {
                    obj
                });
                obj = null;
                readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(s, as);
                obj = readonlysqlitedatabase;
                if (!readonlysqlitedatabase.moveToFirst())
                {
                    break MISSING_BLOCK_LABEL_128;
                }
                obj = readonlysqlitedatabase;
                int i = readonlysqlitedatabase.getInt(0);
                if (readonlysqlitedatabase != null)
                {
                    readonlysqlitedatabase.close();
                }
                return Integer.valueOf(i);
                if (readonlysqlitedatabase != null)
                {
                    readonlysqlitedatabase.close();
                }
                return Integer.valueOf(-1);
                readonlysqlitedatabase;
                if (obj != null)
                {
                    ((Cursor) (obj)).close();
                }
                throw readonlysqlitedatabase;
            }

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                tag = tag1;
                super();
            }
        }).execute(connectionManager)).intValue();
    }

    public void getMediaItemDataFromRawQuery(final String query, final String selectionArgs[], final CursorRowProcessor rowProcessor)
    {
        (new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final String val$query;
            final CursorRowProcessor val$rowProcessor;
            final String val$selectionArgs[];

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            protected Void execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(query, selectionArgs);
_L2:
                if (readonlysqlitedatabase == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (!readonlysqlitedatabase.moveToNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                rowProcessor.process(readonlysqlitedatabase);
                if (true) goto _L2; else goto _L1
                Exception exception;
                exception;
                if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
                {
                    readonlysqlitedatabase.close();
                }
                throw exception;
_L1:
                if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
                {
                    readonlysqlitedatabase.close();
                }
                return null;
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                query = s;
                selectionArgs = as;
                rowProcessor = cursorrowprocessor;
                super();
            }
        }).execute(connectionManager);
    }

    public long getMediaItemSizeForTag(final Tag tag)
    {
        return ((Long)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final Tag val$tag;

            public Long execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                ReadOnlySQLiteDatabase readonlysqlitedatabase1;
                String s;
                s = getAggregateQueryForTags(String.format("SUM(%s) as %s", new Object[] {
                    "file_size", "file_size"
                }), new String[] {
                    String.format("c.%s = ?", new Object[] {
                        "id"
                    })
                });
                readonlysqlitedatabase1 = null;
                readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(s, new String[] {
                    String.valueOf(tag.getId())
                });
                readonlysqlitedatabase1 = readonlysqlitedatabase;
                if (!readonlysqlitedatabase.moveToFirst())
                {
                    break MISSING_BLOCK_LABEL_113;
                }
                readonlysqlitedatabase1 = readonlysqlitedatabase;
                long l = readonlysqlitedatabase.getLong(0);
                if (readonlysqlitedatabase != null)
                {
                    readonlysqlitedatabase.close();
                }
                return Long.valueOf(l);
                if (readonlysqlitedatabase != null)
                {
                    readonlysqlitedatabase.close();
                }
                return Long.valueOf(-1L);
                readonlysqlitedatabase;
                if (readonlysqlitedatabase1 != null)
                {
                    readonlysqlitedatabase1.close();
                }
                throw readonlysqlitedatabase;
            }

            public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                tag = tag1;
                super();
            }
        }).execute(connectionManager)).longValue();
    }

    public Map getMetadataByMediaItem(final MediaItem mediaItem)
    {
        return (Map)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final MediaItem val$mediaItem;

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            protected Map execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getMetadataByMediaItemHelper(readonlysqlitedatabase, mediaItem);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                mediaItem = mediaitem;
                super();
            }
        }).execute(connectionManager);
    }

    public MediaItemCollection getPossibleDuplicateCutItems(MediaItem mediaitem)
    {
        if (mediaitem.getType() == MediaType.PHOTO)
        {
            return null;
        } else
        {
            Object obj = String.format("%s = ? AND %s = ? AND %s IS NOT NULL", new Object[] {
                "name", "mime_type", "local_path"
            });
            mediaitem = mediaitem.getName();
            mediaitem = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
                "a.*"
            }).from(String.format("%s a", new Object[] {
                "media_item"
            })).where(((String) (obj)), new String[] {
                mediaitem, "video/mp4"
            }).setRowProcessor(new CursorRowProcessor() {

                final LocalMediaItemDaoSqliteImpl this$0;

                public MediaItem process(Cursor cursor)
                {
                    return SQLiteDaoUtil.itemFromCursor(cursor, LocalMediaItemDaoSqliteImpl.this);
                }

                public volatile Object process(Cursor cursor)
                {
                    return process(cursor);
                }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                super();
            }
            }).build();
            obj = new MediaItemCollectionBeanImpl();
            ((MediaItemCollectionBeanImpl) (obj)).setMediaItems(cursorListFactory.createCursorList(mediaitem));
            ((MediaItemCollectionBeanImpl) (obj)).setIterator(cursorListFactory.createIterator(mediaitem));
            return ((MediaItemCollection) (obj));
        }
    }

    public MediaItemCollection getPossibleDuplicateLocalItems(MediaItem mediaitem)
    {
        Object obj;
        if (mediaitem.getType() == MediaType.PHOTO)
        {
            obj = String.format("%s = ? AND %s = ? AND %s = ? AND %s = ? AND %s IS NULL", new Object[] {
                "name", "width", "height", "mime_type", "duration"
            });
            String as[] = new String[4];
            as[0] = mediaitem.getName();
            as[1] = Integer.toString(mediaitem.getWidth());
            as[2] = Integer.toString(mediaitem.getHeight());
            as[3] = mediaitem.getMIMEType();
            mediaitem = as;
        } else
        {
            obj = String.format("%s = ? AND %s = ? AND %s = ? AND %s = ?", new Object[] {
                "name", "width", "height", "mime_type"
            });
            String as1[] = new String[4];
            as1[0] = mediaitem.getName();
            as1[1] = Integer.toString(mediaitem.getWidth());
            as1[2] = Integer.toString(mediaitem.getHeight());
            as1[3] = mediaitem.getMIMEType();
            mediaitem = as1;
        }
        mediaitem = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
            "a.*"
        }).from(String.format("%s a", new Object[] {
            "media_item"
        })).where(((String) (obj)), mediaitem).setRowProcessor(new CursorRowProcessor() {

            final LocalMediaItemDaoSqliteImpl this$0;

            public MediaItem process(Cursor cursor)
            {
                return SQLiteDaoUtil.itemFromCursor(cursor, LocalMediaItemDaoSqliteImpl.this);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                super();
            }
        }).build();
        obj = new MediaItemCollectionBeanImpl();
        ((MediaItemCollectionBeanImpl) (obj)).setMediaItems(cursorListFactory.createCursorList(mediaitem));
        ((MediaItemCollectionBeanImpl) (obj)).setIterator(cursorListFactory.createIterator(mediaitem));
        return ((MediaItemCollection) (obj));
    }

    public Set getPropertiesByMediaItem(final MediaItem item)
    {
        return (Set)(new DBReadExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final MediaItem val$item;

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            protected Set execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getPropertiesByMediaItemHelper(readonlysqlitedatabase, item);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                item = mediaitem;
                super();
            }
        }).execute(connectionManager);
    }

    public Set getTagsByMediaItem(MediaItem mediaitem)
    {
        return tagDao.getTagsByMediaItem(mediaitem);
    }

    public MediaItemCollection getUnuploadedItemsByTag(Tag tag)
    {
        TagSqliteImpl tagsqliteimpl = (TagSqliteImpl)tag;
        return getItemsByTagHelper(tag, (new StringBuilder()).append("a.sync_state IN ").append(UNUPLOADED_SYNC_STATES).append(" and b.").append("tag_id").append(" = ?").toString(), String.valueOf(tagsqliteimpl.getId()));
    }

    public MediaItemCollection getUnuploadedItemsByTag(Tag tag, MediaFilter mediafilter)
    {
        TagSqliteImpl tagsqliteimpl = (TagSqliteImpl)tag;
        return getItemsByTagHelper(tag, (new StringBuilder()).append("a.sync_state IN ").append(UNUPLOADED_SYNC_STATES).append(" and b.").append("tag_id").append(" = ? and ").append(mediafilter.getWhereClause()).toString(), String.valueOf(tagsqliteimpl.getId()));
    }

    public void incrementSessionCounter()
    {
        if (sessionCounter.incrementAndGet() == 0x7fffffff)
        {
            sessionCounter.set(0);
        }
    }

    public MediaItemDaoChangeList mergeToCloud(final MediaItem localItem, final ObjectID cloudId)
    {
        return (MediaItemDaoChangeList)(new DBWriteExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final ObjectID val$cloudId;
            final MediaItem val$localItem;

            protected MediaItemDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
                MediaItem mediaitem = getItemByIdHelper(readwritesqlitedatabase, cloudId);
                if (mediaitem != null && mediaitem.getId() != localItem.getId())
                {
                    mediaitem.setLocalPath(localItem.getLocalPath());
                    mediaitem.getProperties().addAll(localItem.getProperties());
                    long l = mediaitem.getTimestampMs();
                    mediaitem.getMetadata().putAll(localItem.getMetadata());
                    mediaitem.getTags().addAll(localItem.getTags());
                    boolean flag;
                    if (localItem.isHidden() || mediaitem.isHidden())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    mediaitem.setHidden(flag);
                    mediaitem.setSyncState(SyncState.SYNCED);
                    deleteHelper(readwritesqlitedatabase, Collections.singletonList(localItem), mediaitemdaochangelist, true);
                    mediaitem.setTimestampMs(l);
                    saveHelper(readwritesqlitedatabase, Collections.singletonList(mediaitem), mediaitemdaochangelist);
                    return mediaitemdaochangelist;
                } else
                {
                    localItem.setObjectId(cloudId);
                    localItem.setSyncState(SyncState.SYNCED);
                    saveHelper(readwritesqlitedatabase, Collections.singletonList(localItem), mediaitemdaochangelist);
                    return mediaitemdaochangelist;
                }
            }

            protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                cloudId = objectid;
                localItem = mediaitem;
                super();
            }
        }).execute(connectionManager);
    }

    public void onAccountDeregistered()
    {
        if (insertSqLiteStatement != null)
        {
            insertSqLiteStatement.close();
            insertSqLiteStatement = null;
        }
        if (insertTagMembershipSqLiteStatement != null)
        {
            insertTagMembershipSqLiteStatement.close();
            insertTagMembershipSqLiteStatement = null;
        }
    }

    public MediaItemDaoChangeList save(MediaItem mediaitem)
    {
        return save(((Collection) (Collections.singletonList(mediaitem))));
    }

    public MediaItemDaoChangeList save(final Collection items)
    {
        return (MediaItemDaoChangeList)(new DBWriteExecutor() {

            final LocalMediaItemDaoSqliteImpl this$0;
            final Collection val$items;

            public MediaItemDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
                saveHelper(readwritesqlitedatabase, items, mediaitemdaochangelist);
                if (!mediaitemdaochangelist.getAllChangeList().isEmpty())
                {
                    incrementSessionCounter();
                }
                return mediaitemdaochangelist;
            }

            public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            protected void postTransaction()
            {
                SharedPreferences sharedpreferences = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
                boolean flag = sharedpreferences.getBoolean("partialSyncStatus", false);
                boolean flag1 = sharedpreferences.getBoolean("coldBootStatus", false);
                if (!flag || flag1)
                {
                    context.getContentResolver().notifyChange(LocalMediaItemDaoSqliteImpl.MEDIA_ITEM_URI, null);
                }
            }

            
            {
                this$0 = LocalMediaItemDaoSqliteImpl.this;
                items = collection;
                super();
            }
        }).execute(connectionManager);
    }

    public void setTagDao(LocalTagDao localtagdao)
    {
        tagDao = localtagdao;
    }

    static 
    {
        UNUPLOADED_SYNC_STATES = (new StringBuilder()).append("(").append(SyncState.NOT_SYNCED.value).append(", ").append(SyncState.PENDING_AUTO.value).append(", ").append(SyncState.SYNC_ERROR_TRANSIENT_AUTO.value).append(")").toString();
        MEDIA_ITEM_URI = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI;
    }








/*
    static com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement access$1302(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl, com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement)
    {
        localmediaitemdaosqliteimpl.deleteTagMembershipSqLiteStatement = readwritesqlitestatement;
        return readwritesqlitestatement;
    }

*/



/*
    static com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement access$1402(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl, com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement)
    {
        localmediaitemdaosqliteimpl.replaceTagMembershipSqLiteStatement = readwritesqlitestatement;
        return readwritesqlitestatement;
    }

*/











}
