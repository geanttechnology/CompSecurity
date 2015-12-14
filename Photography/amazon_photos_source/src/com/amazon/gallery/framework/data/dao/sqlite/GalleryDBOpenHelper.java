// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.resource.ResourceUtils;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.migration.AlbumVisualCollectionKindMigrator;
import com.amazon.gallery.framework.data.dao.sqlite.migration.AutoSaveCameraMigrationPolicy;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DeduplicateMigrationPolicy;
import com.amazon.gallery.framework.data.dao.sqlite.migration.HideMigration;
import com.amazon.gallery.framework.data.dao.sqlite.migration.MediaSizeMigration;
import com.amazon.gallery.framework.data.dao.sqlite.migration.MigrationPolicy;
import com.amazon.gallery.framework.data.dao.sqlite.migration.NewAttributeMigrator;
import com.amazon.gallery.framework.data.dao.sqlite.migration.UnifiedMetadataMigration;
import com.amazon.gallery.framework.data.dao.sqlite.migration.UpdateSortTypeMigrationPolicy;
import com.amazon.gallery.framework.data.dao.sqlite.migration.UpdateTimestampMigrationPolicy;
import com.amazon.gallery.framework.data.dao.sqlite.migration.VideoDateCreatedMigrationPolicy;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.thor.cds.CDSUtil;
import org.apache.commons.lang3.StringUtils;

public class GalleryDBOpenHelper extends SQLiteOpenHelper
{

    public static final String LOG_TAG = (new StringBuilder()).append(com/amazon/gallery/framework/data/dao/sqlite/GalleryDBOpenHelper.getPackage()).append("SQLStackTrace").toString();
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/GalleryDBOpenHelper.getName();
    private AuthenticationManager authenticationManager;
    private final Context context;
    private MediaItemDao mediaItemDao;
    private final NewAttributeMigrator newAttributeMigrator = new NewAttributeMigrator();
    private ComponentProfiler profiler;
    private final ResourceUtils resourceUtils;
    private SortTypeDao sortDao;
    private TagDao tagDao;

    public GalleryDBOpenHelper(Context context1, ResourceUtils resourceutils, String s)
    {
        super(context1, createDBName(s), null, 63);
        context = context1;
        resourceUtils = resourceutils;
    }

    private boolean columnExists(Cursor cursor, String s)
    {
        return cursor.getColumnIndex(s) != -1;
    }

    protected static String createDBName(String s)
    {
        if (s == null)
        {
            return "gallery.db";
        } else
        {
            return (new StringBuilder()).append(s).append("gallery.db").toString();
        }
    }

    private void createSchema(SQLiteDatabase sqlitedatabase)
    {
        executeCompoundStatement(sqlitedatabase, resourceUtils.loadResourceAsString(context, "com/amazon/gallery/framework/data/dao/sqlite/res/create-schema.sql"));
        sqlitedatabase.execSQL("CREATE TRIGGER mark_orphaned_media_items\nAFTER DELETE ON tag_membership\nFOR EACH ROW BEGIN\n    UPDATE media_item SET potentially_orphaned = 1 WHERE id = OLD.media_item_id;\nEND;");
    }

    private void dropSchema(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DROP TRIGGER IF EXISTS mark_orphaned_media_items;");
        executeCompoundStatement(sqlitedatabase, resourceUtils.loadResourceAsString(context, "com/amazon/gallery/framework/data/dao/sqlite/res/drop-schema.sql"));
    }

    private static void executeCompoundStatement(SQLiteDatabase sqlitedatabase, String s)
    {
        s = s.split(";");
        GLogger.v(TAG, "Executing DDL", new Object[0]);
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            CharSequence charsequence = s[i];
            if (StringUtils.isNotBlank(charsequence))
            {
                GLogger.i(TAG, "executeCompoundStatement: %s", new Object[] {
                    charsequence
                });
                sqlitedatabase.execSQL((new StringBuilder()).append(charsequence).append(";").toString());
            }
        }

    }

    private void recreateSchema(SQLiteDatabase sqlitedatabase)
    {
        GLogger.i(TAG, "recreate DB schema", new Object[0]);
        dropSchema(sqlitedatabase);
        createSchema(sqlitedatabase);
    }

    private boolean tableExists(SQLiteDatabase sqlitedatabase, String s)
    {
        SQLiteDatabase sqlitedatabase1;
        boolean flag;
        flag = true;
        sqlitedatabase1 = null;
        sqlitedatabase = sqlitedatabase.rawQuery("SELECT count(*) FROM sqlite_master where type = 'table' AND name = ?", new String[] {
            s
        });
        sqlitedatabase1 = sqlitedatabase;
        if (!sqlitedatabase.moveToNext()) goto _L2; else goto _L1
_L1:
        sqlitedatabase1 = sqlitedatabase;
        int i = sqlitedatabase.getInt(0);
        if (i != 1) goto _L2; else goto _L3
_L3:
        CDSUtil.closeCursorQuietly(sqlitedatabase);
        return flag;
_L2:
        flag = false;
        if (true) goto _L3; else goto _L4
_L4:
        sqlitedatabase;
        CDSUtil.closeCursorQuietly(sqlitedatabase1);
        throw sqlitedatabase;
    }

    private void triggerNewAttributeMigrator(MigrationPolicy migrationpolicy)
    {
        newAttributeMigrator.addMigrationPolicy(migrationpolicy);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        createSchema(sqlitedatabase);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        if (Api.isAtLeastJellyBean())
        {
            setWriteAheadLoggingEnabled(true);
        }
        newAttributeMigrator.executePendingMigrations();
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        if (i < 36 || BuildFlavors.isDuke() && tableExists(sqlitedatabase, "sync_item"))
        {
            GLogger.i(TAG, "DB version %d is too old, recreating schema", new Object[] {
                Integer.valueOf(i)
            });
            recreateSchema(sqlitedatabase);
            return;
        }
        GLogger.i(TAG, "DB upgrade from version %d to %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        cursor = null;
        cursor2 = null;
        cursor1 = cursor2;
        Cursor cursor3 = sqlitedatabase.rawQuery("SELECT * FROM media_item LIMIT 0", null);
        cursor = cursor3;
        cursor1 = cursor2;
        cursor2 = sqlitedatabase.rawQuery("SELECT * FROM tag LIMIT 0", null);
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "DROP INDEX IF EXISTS date_created_media_item_index;");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor3, "date_created_utc"))
        {
            break MISSING_BLOCK_LABEL_156;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE media_item ADD COLUMN date_created_utc DATE NOT NULL DEFAULT 0;UPDATE media_item SET date_created_utc = date_created;");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor2, "auto_save"))
        {
            break MISSING_BLOCK_LABEL_189;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE tag ADD COLUMN auto_save INTEGER DEFAULT 0");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor3, "event_id"))
        {
            break MISSING_BLOCK_LABEL_222;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE media_item ADD COLUMN event_id INTEGER DEFAULT 0");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor2, "valid"))
        {
            break MISSING_BLOCK_LABEL_255;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE tag ADD COLUMN valid INTEGER DEFAULT 1;");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor3, "full_md5"))
        {
            break MISSING_BLOCK_LABEL_288;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE media_item ADD COLUMN full_md5 TEXT;");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor3, "file_size"))
        {
            break MISSING_BLOCK_LABEL_321;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE media_item ADD COLUMN file_size INTEGER DEFAULT 0");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor3, "hidden"))
        {
            break MISSING_BLOCK_LABEL_354;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE media_item ADD COLUMN hidden INTEGER DEFAULT 0");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor3, "timeline_time_stamp"))
        {
            break MISSING_BLOCK_LABEL_387;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE media_item ADD COLUMN timeline_time_stamp INTEGER DEFAULT 0;ALTER TABLE media_item ADD COLUMN timeline_date_added INTEGER DEFAULT 0;UPDATE media_item SET timeline_time_stamp=(case when time_stamp == 0 then 0 else strftime('%Y%m', time_stamp/1000, 'unixepoch') end);UPDATE media_item SET timeline_date_added=(case when date_added == 0 then 0 else strftime('%Y%m', date_added/1000, 'unixepoch') end);");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor3, "has_time_stamp"))
        {
            break MISSING_BLOCK_LABEL_422;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE media_item ADD COLUMN has_time_stamp INTEGER DEFAULT 1;UPDATE media_item SET has_time_stamp=0 WHERE time_stamp IS 0;DROP INDEX IF EXISTS time_stamp_media_item_index;");
        cursor = cursor3;
        cursor1 = cursor2;
        if (columnExists(cursor2, "shared"))
        {
            break MISSING_BLOCK_LABEL_457;
        }
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "ALTER TABLE tag ADD COLUMN shared INTEGER DEFAULT 0");
        cursor = cursor3;
        cursor1 = cursor2;
        executeCompoundStatement(sqlitedatabase, "CREATE TABLE IF NOT EXISTS dynamic_album_membership (media_item_id INTEGER, tag_id INTEGER, cache_time INTEGER, PRIMARY KEY (media_item_id, tag_id), FOREIGN KEY(media_item_id) REFERENCES media_item(id) ON DELETE CASCADE, FOREIGN KEY(tag_id) REFERENCES tag(id) ON DELETE CASCADE);CREATE TABLE IF NOT EXISTS audit (key TEXT NOT NULL, value TEXT NOT NULL, PRIMARY KEY (key));CREATE INDEX IF NOT EXISTS md5_media_item_index ON media_item (full_md5);CREATE INDEX IF NOT EXISTS date_added_media_item_index ON media_item (date_added DESC, object_id_low DESC);CREATE INDEX IF NOT EXISTS type_media_item_index ON media_item (type);CREATE INDEX IF NOT EXISTS local_dupe_search_index ON media_item (name, width, height, mime_type, duration);CREATE INDEX IF NOT EXISTS local_cut_dupe_search_index ON media_item (name, mime_type, local_path);CREATE INDEX IF NOT EXISTS timeline_time_stamp_index ON media_item (timeline_time_stamp);CREATE INDEX IF NOT EXISTS timeline_date_added_index ON media_item (timeline_date_added);CREATE INDEX IF NOT EXISTS hidden_time_stamp_media_item_index ON media_item (hidden DESC, time_stamp DESC, date_added DESC);CREATE INDEX IF NOT EXISTS time_stamp_media_item_index ON media_item (has_time_stamp DESC, time_stamp DESC, date_added DESC);CREATE INDEX IF NOT EXISTS sync_state_md5_media_item_index ON media_item (sync_state, full_md5);CREATE INDEX IF NOT EXISTS dynamic_album_membership_tag_id_index ON dynamic_album_membership (tag_id);");
        CDSUtil.closeCursorQuietly(cursor3);
        CDSUtil.closeCursorQuietly(cursor2);
        triggerNewAttributeMigrator(new AlbumVisualCollectionKindMigrator(i, context, authenticationManager));
        triggerNewAttributeMigrator(new VideoDateCreatedMigrationPolicy(i, context, mediaItemDao, tagDao));
        triggerNewAttributeMigrator(new AutoSaveCameraMigrationPolicy(i, tagDao));
        triggerNewAttributeMigrator(new UpdateTimestampMigrationPolicy(i, mediaItemDao, tagDao, sortDao));
        triggerNewAttributeMigrator(new UnifiedMetadataMigration(i, context, mediaItemDao, sqlitedatabase));
        triggerNewAttributeMigrator(new MediaSizeMigration(i, context));
        triggerNewAttributeMigrator(new HideMigration(i, context, mediaItemDao, authenticationManager.getAccountId()));
        triggerNewAttributeMigrator(new DeduplicateMigrationPolicy(i, context, mediaItemDao, authenticationManager.getAccountId()));
        triggerNewAttributeMigrator(new UpdateSortTypeMigrationPolicy(i, context, sortDao));
        return;
        sqlitedatabase;
        CDSUtil.closeCursorQuietly(cursor);
        CDSUtil.closeCursorQuietly(cursor1);
        throw sqlitedatabase;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationmanager)
    {
        authenticationManager = authenticationmanager;
    }

    public void setMediaItemDao(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }

    public void setProfiler(ComponentProfiler componentprofiler)
    {
        profiler = componentprofiler;
    }

    public void setSortTypeDao(SortTypeDao sorttypedao)
    {
        sortDao = sorttypedao;
    }

    public void setTagDao(TagDao tagdao)
    {
        tagDao = tagdao;
    }

}
