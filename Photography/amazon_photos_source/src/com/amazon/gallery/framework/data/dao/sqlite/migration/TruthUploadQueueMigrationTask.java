// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.gallery.foundation.utils.BasicPathProvider;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.messaging.TagAutoSaveChangedEvent;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadMediaItemsEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            DatabaseMigrationTask, DatabaseMigrationTaskFilter

public class TruthUploadQueueMigrationTask
    implements DatabaseMigrationTask
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/TruthUploadQueueMigrationTask.getName();
    private final boolean autoSaveEnabledInTruth;
    private final MediaItemDao mediaItemDao;
    private final TagDao tagDao;

    public TruthUploadQueueMigrationTask(MediaItemDao mediaitemdao, TagDao tagdao, boolean flag)
    {
        mediaItemDao = mediaitemdao;
        tagDao = tagdao;
        autoSaveEnabledInTruth = flag;
    }

    private void enableAutoSaveOnCameraFolder()
    {
        Object obj = tagDao.getTagsByPathPrefix(TagType.LOCAL_FOLDER, BasicPathProvider.getCameraDirPath());
        if (((List) (obj)).size() > 0)
        {
            obj = (Tag)((List) (obj)).get(0);
            if (!((Tag) (obj)).hasProperty(TagProperty.AUTO_SAVE))
            {
                ((Tag) (obj)).setProperty(TagProperty.AUTO_SAVE);
                tagDao.save(((Tag) (obj)), true);
                GlobalMessagingBus.post(new TagAutoSaveChangedEvent());
            }
        }
    }

    private MediaItem getUpdatedMediaItem(Cursor cursor)
    {
        Object obj = null;
        String s;
        int i;
        try
        {
            s = cursor.getString(cursor.getColumnIndexOrThrow("local_file_path"));
            i = cursor.getInt(cursor.getColumnIndexOrThrow("upload_type"));
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            GLogger.e(TAG, "Failed to find index for item at cursor position %d", new Object[] {
                Integer.valueOf(cursor.getPosition())
            });
            return null;
        }
        cursor = mediaItemDao.getItemsByLocalPath(s);
        if (cursor.getMediaItems().isEmpty())
        {
            GLogger.d(TAG, "mediaItem with path %s does not exist in local DB, skipping...", new Object[] {
                s
            });
            cursor = obj;
        } else
        {
            MediaItem mediaitem = (MediaItem)cursor.getMediaItems().get(0);
            if (i == 1)
            {
                mediaitem.setSyncState(SyncState.PENDING_AUTO);
                return mediaitem;
            }
            cursor = mediaitem;
            if (i == 0)
            {
                mediaitem.setSyncState(SyncState.PENDING_MANUAL);
                return mediaitem;
            }
        }
        return cursor;
    }

    public void executeTask(SQLiteDatabase sqlitedatabase)
    {
        SQLiteDatabase sqlitedatabase1;
        LinkedList linkedlist;
        if (autoSaveEnabledInTruth)
        {
            enableAutoSaveOnCameraFolder();
        }
        linkedlist = new LinkedList();
        sqlitedatabase1 = null;
        sqlitedatabase = sqlitedatabase.query("uploads", new String[] {
            "local_file_path", "upload_type"
        }, null, null, null, null, null);
        sqlitedatabase1 = sqlitedatabase;
        sqlitedatabase.moveToFirst();
_L2:
        sqlitedatabase1 = sqlitedatabase;
        if (sqlitedatabase.isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        sqlitedatabase1 = sqlitedatabase;
        MediaItem mediaitem = getUpdatedMediaItem(sqlitedatabase);
        if (mediaitem == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        sqlitedatabase1 = sqlitedatabase;
        if (mediaitem.getSyncState() != SyncState.PENDING_MANUAL)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        sqlitedatabase1 = sqlitedatabase;
        linkedlist.add(mediaitem);
        sqlitedatabase1 = sqlitedatabase;
        sqlitedatabase.moveToNext();
        if (true) goto _L2; else goto _L1
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
_L1:
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        if (!linkedlist.isEmpty())
        {
            GlobalMessagingBus.post(new UploadMediaItemsEvent(linkedlist, QueueType.MANUAL, UploadStrategy.WIFI_ONLY, TAG));
        }
        return;
    }

    public DatabaseMigrationTaskFilter getFilterForTask()
    {
        return new DatabaseMigrationTaskFilter() {

            final TruthUploadQueueMigrationTask this$0;

            public boolean doesTaskMatchFilter(DatabaseMigrationTask databasemigrationtask)
            {
                return databasemigrationtask instanceof TruthUploadQueueMigrationTask;
            }

            
            {
                this$0 = TruthUploadQueueMigrationTask.this;
                super();
            }
        };
    }

}
