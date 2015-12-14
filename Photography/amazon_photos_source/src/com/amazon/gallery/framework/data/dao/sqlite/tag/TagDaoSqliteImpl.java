// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.TagPropertyDao;
import com.amazon.gallery.framework.data.dao.filter.MediaFilter;
import com.amazon.gallery.framework.data.dao.filter.MediaTypeFilter;
import com.amazon.gallery.framework.data.dao.mediaitem.LocalMediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.CursorListFactory;
import com.amazon.gallery.framework.data.dao.sqlite.CursorListFactoryImpl;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.EditHelper;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.MediaItemSqliteImpl;
import com.amazon.gallery.framework.data.dao.tag.LocalTagDao;
import com.amazon.gallery.framework.data.model.TagBeanImpl;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.tag:
//            TagKeys, TagSqliteImpl, TagDaoChangeList

public class TagDaoSqliteImpl
    implements LocalTagDao
{

    private static final SortOrder COLD_SYNC_ORDER;
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/tag/TagDaoSqliteImpl.getName();
    private GalleryDBConnectionManager connectionManager;
    private final Context context;
    private final CursorListFactory cursorListFactory;
    private LocalMediaItemDao mediaItemDao;
    private TagPropertyDao propDao;
    private final AtomicInteger sessionCounter = new AtomicInteger(0);

    public TagDaoSqliteImpl(Context context1, GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        propDao = new TagPropertyDao();
        context = context1;
        connectionManager = gallerydbconnectionmanager;
        cursorListFactory = new CursorListFactoryImpl(gallerydbconnectionmanager);
    }

    private void deleteHelper(Collection collection, ReadWriteSQLiteDatabase readwritesqlitedatabase, TagDaoChangeList tagdaochangelist)
    {
        readwritesqlitedatabase = new EditHelper(readwritesqlitedatabase, "tag", TagKeys.ALL_COLUMNS, new String[] {
            "object_id_low", "object_id_hi"
        });
        collection = collection.iterator();
_L1:
        Tag tag;
        TagSqliteImpl tagsqliteimpl;
        int i;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_153;
        }
        tag = (Tag)collection.next();
        tagsqliteimpl = (TagSqliteImpl)tag;
        i = readwritesqlitedatabase.delete(new Object[] {
            Long.valueOf(tag.getObjectId().getLeastSignificantBits()), Long.valueOf(tag.getObjectId().getMostSignificantBits())
        });
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED);
        GLogger.v(TAG, "Deleted tag: %s, %d rows modified", new Object[] {
            tagsqliteimpl, Integer.valueOf(i)
        });
          goto _L1
        collection;
        readwritesqlitedatabase.close();
        throw collection;
        readwritesqlitedatabase.close();
        return;
    }

    private TagSqliteImpl getTagByIdHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, ObjectID objectid)
    {
        Object obj;
        Cursor cursor;
        Object obj1 = null;
        obj = null;
        cursor = readonlysqlitedatabase.rawQuery(String.format("SELECT * FROM %s a WHERE %s = ? AND %s = ?;", new Object[] {
            "tag", "object_id_low", "object_id_hi"
        }), new String[] {
            (new StringBuilder()).append("").append(objectid.getLeastSignificantBits()).toString(), (new StringBuilder()).append("").append(objectid.getMostSignificantBits()).toString()
        });
        readonlysqlitedatabase = obj1;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (cursor.getCount() > 1)
        {
            throw new RuntimeException((new StringBuilder()).append("Two Items with matching objectIds! - ").append(objectid.toString()).toString());
        }
        break MISSING_BLOCK_LABEL_149;
        readonlysqlitedatabase;
        cursor.close();
        throw readonlysqlitedatabase;
        readonlysqlitedatabase = obj;
        if (cursor.moveToFirst())
        {
            readonlysqlitedatabase = tagFromCursor(cursor, false);
        }
        cursor.close();
        return readonlysqlitedatabase;
    }

    private Set getTagsByMediaItemHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, MediaItem mediaitem)
    {
        long l1 = ((MediaItemSqliteImpl)mediaitem).getId();
        long l = l1;
        if (l1 == -1L)
        {
            mediaitem = mediaitem.getObjectId();
            l = l1;
            if (mediaitem != null)
            {
                mediaitem = (MediaItemSqliteImpl)mediaItemDao.getItemById(mediaitem);
                l = l1;
                if (mediaitem != null)
                {
                    l = mediaitem.getId();
                }
            }
        }
        mediaitem = new HashSet();
        readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(String.format("SELECT * FROM %s a INNER JOIN %s b ON a.%s = b.%s WHERE b.%s = ?;", new Object[] {
            "tag", "tag_membership", "id", "tag_id", "media_item_id"
        }), new String[] {
            String.valueOf(l)
        });
        if (readonlysqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (readonlysqlitedatabase.moveToFirst())
        {
            for (; !readonlysqlitedatabase.isAfterLast(); readonlysqlitedatabase.moveToNext())
            {
                mediaitem.add(tagFromCursor(readonlysqlitedatabase, false));
            }

        }
        break MISSING_BLOCK_LABEL_178;
        mediaitem;
        readonlysqlitedatabase.close();
        throw mediaitem;
        readonlysqlitedatabase.close();
        return mediaitem;
    }

    private List getTagsByPropertyHelper(TagType tagtype, TagProperty tagproperty, SortOrder sortorder)
    {
        tagtype = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
            "*"
        }).from("tag").where((new StringBuilder()).append("valid = ? AND type = ? AND ").append(propDao.getColumn(tagproperty)).append(" = ? ").toString(), new String[] {
            Integer.toString(1), String.valueOf(tagtype.ordinal()), String.valueOf(tagproperty.ordinal())
        }).setRowProcessor(new CursorRowProcessor() {

            final TagDaoSqliteImpl this$0;

            public Tag process(Cursor cursor)
            {
                return tagFromCursor(cursor, true);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                super();
            }
        });
        if (sortorder != null)
        {
            tagtype.orderBy(sortorder);
        }
        return cursorListFactory.createCursorList(tagtype.build());
    }

    private boolean hasTagChanged(TagSqliteImpl tagsqliteimpl, TagSqliteImpl tagsqliteimpl1)
    {
        return !tagsqliteimpl1.getObjectId().equals(tagsqliteimpl.getObjectId()) || !tagsqliteimpl1.getLabel().equals(tagsqliteimpl.getLabel()) || tagsqliteimpl1.getDateCreatedMs() != tagsqliteimpl.getDateCreatedMs() || tagsqliteimpl1.getSortDateMs() != tagsqliteimpl.getSortDateMs() || tagsqliteimpl1.getHasSortDate() != tagsqliteimpl.getHasSortDate() || !ObjectID.objectIdEqual(tagsqliteimpl1.getCoverId(), tagsqliteimpl.getCoverId()) || !ObjectID.objectIdEqual(tagsqliteimpl1.getCustomCoverId(), tagsqliteimpl.getCustomCoverId()) || !tagsqliteimpl1.getProperties().equals(tagsqliteimpl.getProperties()) || tagsqliteimpl1.getTagSyncVersion() != tagsqliteimpl.getTagSyncVersion() || tagsqliteimpl1.getMediaItemsSyncVersion() != tagsqliteimpl.getMediaItemsSyncVersion() || tagsqliteimpl1.getDatabaseVersion() != tagsqliteimpl.getDatabaseVersion() || tagsqliteimpl1.isValid() != tagsqliteimpl.isValid() || tagsqliteimpl1.isShared() != tagsqliteimpl.isShared();
    }

    private void saveHelper(Collection collection, ReadWriteSQLiteDatabase readwritesqlitedatabase, TagDaoChangeList tagdaochangelist)
    {
        EditHelper edithelper = TagKeys.newEditHelper(readwritesqlitedatabase);
        Iterator iterator = collection.iterator();
_L15:
        TagSqliteImpl tagsqliteimpl;
        Tag tag;
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_858;
        }
        tag = (Tag)iterator.next();
        tagsqliteimpl = (TagSqliteImpl)tag;
        flag = tagsqliteimpl.clearLocalPathDirtyFlag();
        collection = getTagByIdHelper(readwritesqlitedatabase, tag.getObjectId());
        if (collection == null)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        if (tagsqliteimpl.getId() == -1L)
        {
            tagsqliteimpl.setId(collection.getId());
        }
        if (tagsqliteimpl.getCustomCoverId() == null)
        {
            tagsqliteimpl.setCustomCoverId(collection.getCustomCoverId());
        }
        if (tagsqliteimpl.getCoverId() == null)
        {
            tagsqliteimpl.setCoverId(collection.getCoverId());
        }
        if (tagsqliteimpl.getTimestampMs() <= collection.getTimestampMs()) goto _L2; else goto _L1
_L1:
        tagsqliteimpl.setTagSyncVersion(collection.getTagSyncVersion() + 1);
_L3:
        if (collection.getMediaItemsSyncVersion() > tagsqliteimpl.getMediaItemsSyncVersion())
        {
            tagsqliteimpl.setMediaItemsSyncVersion(collection.getMediaItemsSyncVersion());
        }
        if (collection.getDatabaseVersion() > tagsqliteimpl.getDatabaseVersion())
        {
            tagsqliteimpl.setDatabaseVersion(collection.getDatabaseVersion());
        }
        if (!tagsqliteimpl.getHasSortDate() && tagsqliteimpl.getSortDateMs() != TagBeanImpl.NO_SORT_DATE)
        {
            tagsqliteimpl.setHasSortDate(collection.getHasSortDate());
            tagsqliteimpl.setSortDateMs(collection.getSortDateMs());
        }
_L4:
        ContentValues contentvalues;
        if (tagsqliteimpl.getCustomCoverId() == null || mediaItemDao.getItemById(tagsqliteimpl.getCustomCoverId()) == null)
        {
            tagsqliteimpl.setCustomCoverId(tagsqliteimpl.getCoverId());
        }
        contentvalues = tagContentValues(tagsqliteimpl);
        propDao.writeTagProperties(contentvalues, (TagSqliteImpl)tag);
        Collection collection1;
        collection1 = collection;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_473;
        }
        Cursor cursor = readwritesqlitedatabase.rawQuery(String.format("SELECT * FROM %s a WHERE %s = ?;", new Object[] {
            "tag", "id"
        }), new String[] {
            (new StringBuilder()).append(tagsqliteimpl.getId()).append("").toString()
        });
        collection1 = collection;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_473;
        }
        if (cursor.getCount() > 1)
        {
            throw new RuntimeException((new StringBuilder()).append("Two Items with matching db ids! - ").append(tagsqliteimpl.getId()).toString());
        }
        break MISSING_BLOCK_LABEL_445;
        collection;
        cursor.close();
        throw collection;
        collection;
        edithelper.close();
        throw collection;
_L2:
        tagsqliteimpl.setTagSyncVersion(collection.getTagSyncVersion());
          goto _L3
        tagsqliteimpl.setTagSyncVersion(1);
        tagsqliteimpl.setDatabaseVersion(63);
          goto _L4
        if (cursor.moveToFirst())
        {
            collection = tagFromCursor(cursor, false);
        }
        cursor.close();
        collection1 = collection;
        if (!tagsqliteimpl.isPersisted()) goto _L6; else goto _L5
_L5:
        if (collection1 == null) goto _L8; else goto _L7
_L7:
        if (!hasTagChanged(collection1, tagsqliteimpl)) goto _L9; else goto _L8
_L8:
        int i = edithelper.update(contentvalues, new Object[] {
            Long.valueOf(tagsqliteimpl.getId())
        });
        if (i != 1) goto _L11; else goto _L10
_L10:
        if (!flag) goto _L13; else goto _L12
_L12:
        if (collection1 == null)
        {
            break MISSING_BLOCK_LABEL_546;
        }
        tagdaochangelist.addContentsOf(collection1, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED);
        tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
_L14:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_837;
        }
        DebugAssert.assertTrue(tagsqliteimpl.hasProperty(com.amazon.gallery.framework.model.tags.CommonTagProperty.Storage.LOCAL));
        Object obj = mediaItemDao.getItemsByTag(tag).getMediaItems();
        collection = tagsqliteimpl.getLocalPath();
        MediaItem mediaitem;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mediaItemDao.save(mediaitem))
        {
            mediaitem = (MediaItem)((Iterator) (obj)).next();
            DebugAssert.assertTrue(mediaitem.hasProperty(CommonMediaProperty.LOCAL));
            mediaitem.setLocalPath((new File(collection, (new File(mediaitem.getLocalPath())).getName())).getAbsolutePath());
        }

        break MISSING_BLOCK_LABEL_837;
_L13:
        tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
          goto _L14
_L11:
        GLogger.e(TAG, "Failed to update tag: %s. update returned: %d", new Object[] {
            tagsqliteimpl, Integer.valueOf(i)
        });
          goto _L14
_L9:
label0:
        {
            if (tagsqliteimpl.getCoverId() != null)
            {
                break label0;
            }
            tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
        }
          goto _L14
        GLogger.d(TAG, "Ignoring update to tag: %s; already persisted", new Object[] {
            tagsqliteimpl
        });
          goto _L14
_L6:
        long l = edithelper.replace(contentvalues);
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_808;
        }
        tagsqliteimpl.setId(l);
        tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
          goto _L14
        GLogger.e(TAG, "Failed to insert tag: %s. error: %d", new Object[] {
            tagsqliteimpl, Long.valueOf(l)
        });
          goto _L14
        GLogger.v(TAG, "Updated tag: %s", new Object[] {
            tagsqliteimpl
        });
          goto _L15
        edithelper.close();
        return;
    }

    private ContentValues tagContentValues(Tag tag)
    {
        ContentValues contentvalues = new ContentValues();
        ObjectID objectid = tag.getObjectId();
        ObjectID objectid1 = tag.getCoverId();
        ObjectID objectid2 = tag.getCustomCoverId();
        contentvalues.put("type", Integer.valueOf(tag.getType().ordinal()));
        contentvalues.put("object_id_low", Long.valueOf(objectid.getLeastSignificantBits()));
        contentvalues.put("object_id_hi", Long.valueOf(objectid.getMostSignificantBits()));
        contentvalues.put("label", tag.getLabel());
        contentvalues.put("date_created", Long.valueOf(tag.getDateCreatedMs()));
        contentvalues.put("time_stamp", Long.valueOf(tag.getTimestampMs()));
        contentvalues.put("sort_date", Long.valueOf(tag.getSortDateMs()));
        contentvalues.put("has_sort_date", Boolean.valueOf(tag.getHasSortDate()));
        if (objectid1 != null)
        {
            contentvalues.put("cover_id_low", Long.valueOf(objectid1.getLeastSignificantBits()));
            contentvalues.put("cover_id_high", Long.valueOf(objectid1.getMostSignificantBits()));
        } else
        {
            contentvalues.putNull("cover_id_low");
            contentvalues.putNull("cover_id_high");
        }
        if (objectid2 != null)
        {
            contentvalues.put("custom_cover_id_low", Long.valueOf(objectid2.getLeastSignificantBits()));
            contentvalues.put("custom_cover_id_high", Long.valueOf(objectid2.getMostSignificantBits()));
        } else
        {
            contentvalues.putNull("custom_cover_id_low");
            contentvalues.putNull("custom_cover_id_high");
        }
        contentvalues.put("local_path", tag.getLocalPath());
        contentvalues.put("tag_sync_version", Integer.valueOf(tag.getTagSyncVersion()));
        contentvalues.put("media_items_sync_version", Integer.valueOf(tag.getMediaItemsSyncVersion()));
        contentvalues.put("db_version", Integer.valueOf(tag.getDatabaseVersion()));
        contentvalues.put("valid", Boolean.valueOf(tag.isValid()));
        contentvalues.put("shared", Boolean.valueOf(tag.isShared()));
        return contentvalues;
    }

    private static transient String whereAndClause(String as[])
    {
        if (as.length == 0)
        {
            return (new StringBuilder()).append(as[0]).append("=?").toString();
        }
        StringBuilder stringbuilder = (new StringBuilder(as[0])).append(" =?");
        for (int i = 1; i < as.length; i++)
        {
            stringbuilder.append(" AND ").append(as[i]).append(" =?");
        }

        return stringbuilder.toString();
    }

    public TagDaoChangeList bulkInsert(final Collection tagList)
    {
        if (tagList.size() == 0)
        {
            return new TagDaoChangeList();
        } else
        {
            return (TagDaoChangeList)(new DBWriteExecutor() {

                final TagDaoSqliteImpl this$0;
                final Collection val$tagList;

                protected TagDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
                    saveHelper(tagList, readwritesqlitedatabase, tagdaochangelist);
                    return tagdaochangelist;
                }

                protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    return execute(readwritesqlitedatabase);
                }

                protected void postTransaction()
                {
                    context.getContentResolver().notifyChange(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, null);
                }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                tagList = collection;
                super();
            }
            }).execute(connectionManager);
        }
    }

    public Tag create(TagType tagtype)
    {
        static class _cls18
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$tags$TagType = new int[TagType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.ALL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.ALBUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.SOURCE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.FOLDER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.LOCAL_FOLDER.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.UNKNOWN.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls18..SwitchMap.com.amazon.gallery.framework.model.tags.TagType[tagtype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new TagSqliteImpl(TagType.ALL);

        case 2: // '\002'
            return new TagSqliteImpl(TagType.ALBUM);

        case 3: // '\003'
            return new TagSqliteImpl(TagType.SOURCE);

        case 4: // '\004'
            return new TagSqliteImpl(TagType.FOLDER);

        case 5: // '\005'
            return new TagSqliteImpl(TagType.LOCAL_FOLDER);

        case 6: // '\006'
            return new TagSqliteImpl(TagType.UNKNOWN);
        }
    }

    public TagDaoChangeList delete(final Collection tags)
    {
        if (tags.size() == 0)
        {
            return new TagDaoChangeList();
        } else
        {
            return (TagDaoChangeList)(new DBWriteExecutor() {

                final TagDaoSqliteImpl this$0;
                final Collection val$tags;

                public TagDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
                    deleteHelper(tags, readwritesqlitedatabase, tagdaochangelist);
                    if (!tagdaochangelist.getAllChangeList().isEmpty())
                    {
                        incrementSessionCounter();
                    }
                    return tagdaochangelist;
                }

                public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    return execute(readwritesqlitedatabase);
                }

                protected void postTransaction()
                {
                    context.getContentResolver().notifyChange(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, null);
                }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                tags = collection;
                super();
            }
            }).execute(connectionManager);
        }
    }

    public TagDaoChangeList deleteChildlessTags(final Set tags)
    {
        return (TagDaoChangeList)(new DBWriteExecutor() {

            final TagDaoSqliteImpl this$0;
            final Set val$tags;

            protected TagDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
                Iterator iterator = tags.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Tag tag = (Tag)iterator.next();
                    if (!tag.getType().equals(TagType.ALBUM))
                    {
                        String s = TagDaoSqliteImpl.whereAndClause(new String[] {
                            "object_id_low", "object_id_hi"
                        });
                        long l = readwritesqlitedatabase.delete("tag", (new StringBuilder()).append(s).append(" AND NOT EXISTS (SELECT * FROM tag_membership WHERE tag_id=id)").toString(), new String[] {
                            (new StringBuilder()).append(tag.getObjectId().getLeastSignificantBits()).append("").toString(), (new StringBuilder()).append(tag.getObjectId().getMostSignificantBits()).append("").toString()
                        });
                        if (l > 0L)
                        {
                            incrementSessionCounter();
                            tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED);
                            GLogger.v(TagDaoSqliteImpl.TAG, "Deleted childless tag: %s, %d rows modified", new Object[] {
                                tag, Long.valueOf(l)
                            });
                        }
                    }
                } while (true);
                return tagdaochangelist;
            }

            protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            protected void postTransaction()
            {
                context.getContentResolver().notifyChange(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, null);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                tags = set;
                super();
            }
        }).execute(connectionManager);
    }

    public Tag getTagById(final ObjectID id)
    {
        return (Tag)(new DBReadExecutor() {

            final TagDaoSqliteImpl this$0;
            final ObjectID val$id;

            protected Tag execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getTagByIdHelper(readonlysqlitedatabase, id);
            }

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                id = objectid;
                super();
            }
        }).execute(connectionManager);
    }

    public List getTags()
    {
        return getTags(null);
    }

    public List getTags(SortOrder sortorder)
    {
        com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder builder = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
            "*"
        }).from("tag").where("valid = ?", new String[] {
            Integer.toString(1)
        }).setRowProcessor(new CursorRowProcessor() {

            final TagDaoSqliteImpl this$0;

            public Tag process(Cursor cursor)
            {
                return tagFromCursor(cursor, false);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                super();
            }
        });
        if (sortorder != null)
        {
            builder.orderBy(sortorder);
        }
        return cursorListFactory.createCursorList(builder.build());
    }

    public Set getTagsByMediaItem(final MediaItem mediaItem)
    {
        return (Set)(new DBReadExecutor() {

            final TagDaoSqliteImpl this$0;
            final MediaItem val$mediaItem;

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            protected Set execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return getTagsByMediaItemHelper(readonlysqlitedatabase, mediaItem);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                mediaItem = mediaitem;
                super();
            }
        }).execute(connectionManager);
    }

    public List getTagsByPathPrefix(TagType tagtype, String s)
    {
        tagtype = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
            "*"
        }).from("tag").where("valid = ? AND type = ? AND local_path LIKE (? || '%')", new String[] {
            Integer.toString(1), String.valueOf(tagtype.ordinal()), s
        }).setRowProcessor(new CursorRowProcessor() {

            final TagDaoSqliteImpl this$0;

            public Tag process(Cursor cursor)
            {
                return tagFromCursor(cursor, false);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                super();
            }
        }).build();
        return cursorListFactory.createCursorList(tagtype);
    }

    public List getTagsByProperty(TagType tagtype, TagProperty tagproperty)
    {
        return getTagsByPropertyHelper(tagtype, tagproperty, null);
    }

    public List getTagsByProperty(TagType tagtype, TagProperty tagproperty, SortOrder sortorder)
    {
        return getTagsByPropertyHelper(tagtype, tagproperty, sortorder);
    }

    public List getTagsByType(TagType tagtype)
    {
        tagtype = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
            "*"
        }).from("tag").where("valid = ? AND type = ?", new String[] {
            Integer.toString(1), String.valueOf(tagtype.ordinal())
        }).setRowProcessor(new CursorRowProcessor() {

            final TagDaoSqliteImpl this$0;

            public Tag process(Cursor cursor)
            {
                return tagFromCursor(cursor, false);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                super();
            }
        }).build();
        return cursorListFactory.createCursorList(tagtype);
    }

    public List getTagsByType(TagType tagtype, SortOrder sortorder)
    {
        tagtype = (new com.amazon.gallery.framework.data.dao.sqlite.CursorRowDataProvider.Builder(connectionManager)).select(new String[] {
            "*"
        }).from("tag").where("valid = ? AND type = ?", new String[] {
            Integer.toString(1), String.valueOf(tagtype.ordinal())
        }).orderBy(sortorder).setRowProcessor(new CursorRowProcessor() {

            final TagDaoSqliteImpl this$0;

            public Tag process(Cursor cursor)
            {
                return tagFromCursor(cursor, true);
            }

            public volatile Object process(Cursor cursor)
            {
                return process(cursor);
            }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                super();
            }
        }).build();
        return cursorListFactory.createCursorList(tagtype);
    }

    public void incrementSessionCounter()
    {
        if (sessionCounter.incrementAndGet() == 0x7fffffff)
        {
            sessionCounter.set(0);
        }
    }

    public boolean removeTemporarySyncStates(Tag tag, boolean flag, boolean flag1)
    {
        SyncState syncstate = null;
        if (!flag || flag1) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new MediaFilter();
        ((MediaFilter) (obj)).setMediaTypeFilter(new MediaTypeFilter(MediaType.PHOTO));
_L4:
        if (obj == null)
        {
            tag = mediaItemDao.getItemsByTag(tag);
        } else
        {
            tag = mediaItemDao.getItemsByTag(tag, ((MediaFilter) (obj)));
        }
        tag = tag.getMediaItems();
        flag = false;
        tag = tag.iterator();
        do
        {
            flag1 = flag;
            if (!tag.hasNext())
            {
                break;
            }
            obj = (MediaItem)tag.next();
            syncstate = ((MediaItem) (obj)).getSyncState();
            if (syncstate == SyncState.PENDING_AUTO || syncstate == SyncState.SYNCING || syncstate == SyncState.SYNC_ERROR_TRANSIENT_AUTO || syncstate == SyncState.SYNC_ERROR_TERMINAL)
            {
                ((MediaItem) (obj)).setSyncState(SyncState.NOT_SYNCED);
                mediaItemDao.save(((MediaItem) (obj)));
                flag = true;
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        if (!flag && flag1)
        {
            obj = new MediaFilter();
            ((MediaFilter) (obj)).setMediaTypeFilter(new MediaTypeFilter(MediaType.VIDEO));
            continue; /* Loop/switch isn't completed */
        }
        obj = syncstate;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = syncstate;
        if (flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = false;
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        return flag1;
    }

    public TagDaoChangeList save(Tag tag)
    {
        return save(((Collection) (Collections.singletonList(tag))));
    }

    public TagDaoChangeList save(final Collection tags)
    {
        if (tags.size() == 0)
        {
            return new TagDaoChangeList();
        } else
        {
            return (TagDaoChangeList)(new DBWriteExecutor() {

                final TagDaoSqliteImpl this$0;
                final Collection val$tags;

                public TagDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
                    saveHelper(tags, readwritesqlitedatabase, tagdaochangelist);
                    if (!tagdaochangelist.getAllChangeList().isEmpty())
                    {
                        incrementSessionCounter();
                    }
                    return tagdaochangelist;
                }

                public volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
                {
                    return execute(readwritesqlitedatabase);
                }

                protected void postTransaction()
                {
                    context.getContentResolver().notifyChange(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, null);
                }

            
            {
                this$0 = TagDaoSqliteImpl.this;
                tags = collection;
                super();
            }
            }).execute(connectionManager);
        }
    }

    public void setMediaItemDao(LocalMediaItemDao localmediaitemdao)
    {
        mediaItemDao = localmediaitemdao;
    }

    public void setPropDao(TagPropertyDao tagpropertydao)
    {
        propDao = tagpropertydao;
    }

    public TagSqliteImpl tagFromCursor(Cursor cursor, boolean flag)
    {
        int i = cursor.getInt(cursor.getColumnIndex("type"));
        TagType tagtype = TagType.values()[i];
        TagSqliteImpl tagsqliteimpl = (TagSqliteImpl)create(tagtype);
        tagsqliteimpl.setObjectId(new ObjectID(cursor.getLong(cursor.getColumnIndex("object_id_hi")), cursor.getLong(cursor.getColumnIndex("object_id_low"))));
        tagsqliteimpl.setId(cursor.getInt(cursor.getColumnIndex("id")));
        tagsqliteimpl.setLabel(cursor.getString(cursor.getColumnIndex("label")));
        tagsqliteimpl.setDateCreatedMs(cursor.getLong(cursor.getColumnIndex("date_created")));
        tagsqliteimpl.setTimestampMs(cursor.getLong(cursor.getColumnIndex("time_stamp")));
        tagsqliteimpl.setSortDateMs(cursor.getLong(cursor.getColumnIndex("sort_date")));
        int j;
        boolean flag1;
        if (cursor.getInt(cursor.getColumnIndex("has_sort_date")) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        tagsqliteimpl.setHasSortDate(flag1);
        i = cursor.getColumnIndex("cover_id_low");
        j = cursor.getColumnIndex("cover_id_high");
        if (!cursor.isNull(i) && !cursor.isNull(j))
        {
            ObjectID objectid = new ObjectID(cursor.getLong(j), cursor.getLong(i));
            tagsqliteimpl.setCoverId(objectid);
            if (flag && tagtype.equals(TagType.ALBUM))
            {
                tagsqliteimpl.setCoverItem(mediaItemDao.getItemById(objectid));
            }
        }
        i = cursor.getColumnIndex("custom_cover_id_low");
        j = cursor.getColumnIndex("custom_cover_id_high");
        if (!cursor.isNull(i) && !cursor.isNull(j))
        {
            ObjectID objectid1 = new ObjectID(cursor.getLong(j), cursor.getLong(i));
            tagsqliteimpl.setCustomCoverId(objectid1);
            if (flag && tagtype.equals(TagType.LOCAL_FOLDER))
            {
                tagsqliteimpl.setCoverItem(mediaItemDao.getItemById(objectid1));
            }
        }
        tagsqliteimpl.setLocalPath(cursor.getString(cursor.getColumnIndex("local_path")));
        tagsqliteimpl.setTagSyncVersion(cursor.getInt(cursor.getColumnIndex("tag_sync_version")));
        tagsqliteimpl.setMediaItemsSyncVersion(cursor.getInt(cursor.getColumnIndex("media_items_sync_version")));
        tagsqliteimpl.setDatabaseVersion(cursor.getInt(cursor.getColumnIndex("db_version")));
        if (cursor.getInt(cursor.getColumnIndex("valid")) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tagsqliteimpl.setValid(flag);
        if (cursor.getInt(cursor.getColumnIndex("shared")) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tagsqliteimpl.setShared(flag);
        propDao.readTagProperties(cursor, tagsqliteimpl);
        return tagsqliteimpl;
    }

    static 
    {
        COLD_SYNC_ORDER = new SortOrder("date_created", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC);
    }







}
