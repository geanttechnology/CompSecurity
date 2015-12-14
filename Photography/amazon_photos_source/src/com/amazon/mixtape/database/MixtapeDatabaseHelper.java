// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mixtape.database:
//            MetadataCleanupTask

public class MixtapeDatabaseHelper extends SQLiteOpenHelper
{

    private static final int RELEASE_DB_VERSIONS[] = {
        8, 9, 10, 11, 17, 18, 19, 20, 21, 22, 
        28, 29, 30, 31, 32
    };

    public MixtapeDatabaseHelper(Context context, String s)
    {
        super(context, getDatabaseNameForAccount(s), null, 32);
    }

    private void createAllTables(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE cloud_nodes(_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id TEXT UNIQUE NOT NULL , change_type TEXT NOT NULL, created_by TEXT, created_date TEXT, description TEXT, exclusively_trashed INTEGER, is_root INTEGER, is_shared INTEGER, kind TEXT, modified_date TEXT, name TEXT, recursively_trashed INTEGER, restricted INTEGER, status TEXT, version INTEGER, content_type TEXT, content_extension TEXT, content_md5 TEXT, content_sort_date TEXT, content_date TEXT, content_size INTEGER, content_version INTEGER, document_version TEXT, document_title TEXT, image_aperture_value TEXT, image_capture_mode TEXT, image_color_space TEXT, image_date_time TEXT, image_date_time_digitized TEXT, image_date_time_original TEXT, image_exposure_mode TEXT, image_exposure_program TEXT, image_exposure_time TEXT, image_flash TEXT, image_focal_length TEXT, image_gps_time_stamp TEXT, image_height INTEGER, image_iso_speed_ratings TEXT, image_location TEXT, image_make TEXT, image_metering_mode TEXT, image_model TEXT, image_orientation TEXT, image_resolution_unit TEXT, image_sensing_method TEXT, image_sharpness TEXT, image_software TEXT, image_white_balance TEXT, image_width INTEGER, image_x_resolution TEXT, image_y_resolution TEXT, is_content INTEGER, is_document INTEGER, is_image INTEGER, is_video INTEGER, video_audio_bitrate DOUBLE, video_audio_channels INTEGER, video_audio_channel_layout TEXT, video_audio_codec TEXT, video_audio_sample_rate DOUBLE, video_bitrate DOUBLE, video_creation_date TEXT, video_duration DOUBLE, video_encoder TEXT, video_height INTEGER, video_location INTEGER, video_make TEXT, video_model TEXT, video_rotate INTEGER, video_title TEXT, video_overall_bitrate DOUBLE, video_codec TEXT, video_frame_rate DOUBLE, video_width INTEGER, favorite INTEGER, hidden INTEGER, metadata_version INTEGER, has_share_parent INTEGER )");
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_nid ON cloud_nodes (node_id)");
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_csd_iv_ii ON cloud_nodes(kind, status, content_sort_date, is_video, is_image)");
        createIdxNodesEventIdNodeId_v10(sqlitedatabase);
        createIdxNodesKeyStatusContentSortDateNodeIdHiddenIsVideoIsImage_v17(sqlitedatabase);
        createIdxNodesKeyStatusIsVideoContentSortDateNodeIdHidden_v17(sqlitedatabase);
        createIdxNodesKeyStatusFavoriteContentSortDateNodeIdHiddenIsVideoIsImage_v17(sqlitedatabase);
        createIdxNodesKeyStatusFavoriteContentSortDateNodeIdHiddenIsVideo_v17(sqlitedatabase);
        createIdxNodesKeyStatusCreatedDateNodeIdHiddenIsVideoIsImage_v22(sqlitedatabase);
        createIdxNodesKeyStatusIsVideoCreatedDateNodeIdHidden_v22(sqlitedatabase);
        createIdxNodesKeyStatusFavoriteCreatedDateNodeIdHiddenIsVideoIsImage_v22(sqlitedatabase);
        createIdxNodesKeyStatusFavoriteCreatedDateNodeIdHiddenIsVideo_v22(sqlitedatabase);
        sqlitedatabase.execSQL("CREATE TABLE cloud_node_labels(_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id TEXT NOT NULL, label TEXT NOT NULL )");
        sqlitedatabase.execSQL("CREATE INDEX idx_node_parents_eid_nid_l ON cloud_node_labels (event_id, node_id, label)");
        sqlitedatabase.execSQL("CREATE TABLE cloud_node_parents(_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id TEXT NOT NULL, parent_node_id TEXT NOT NULL )");
        sqlitedatabase.execSQL("CREATE INDEX idx_node_parents_eid_nid_pnid ON cloud_node_parents (event_id, node_id, parent_node_id)");
        sqlitedatabase.execSQL("CREATE INDEX idx_node_parents_eid_pnid_nid ON cloud_node_parents (event_id, parent_node_id, node_id)");
        createIdxNodeParentsNodeId_v10(sqlitedatabase);
        sqlitedatabase.execSQL("CREATE TABLE cloud_node_properties(_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id TEXT NOT NULL, owner TEXT, key TEXT, value TEXT )");
        sqlitedatabase.execSQL("CREATE INDEX idx_node_properties_eid_nid_o_k ON cloud_node_properties (event_id, node_id, owner, key)");
        sqlitedatabase.execSQL("CREATE TABLE document_authors(_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id TEXT NOT NULL, author TEXT )");
        sqlitedatabase.execSQL("CREATE INDEX idx_document_authors_eid_nid ON document_authors (event_id, node_id)");
        sqlitedatabase.execSQL("CREATE TABLE checkpoints(_id INTEGER PRIMARY KEY AUTOINCREMENT, checkpoint_id TEXT NOT NULL )");
        sqlitedatabase.execSQL("CREATE INDEX idx_checkpoints_aid_cid ON checkpoints (checkpoint_id)");
        sqlitedatabase.execSQL("CREATE TABLE events(_id INTEGER PRIMARY KEY AUTOINCREMENT, changed_object_id TEXT, change_type TEXT )");
        sqlitedatabase.execSQL("CREATE INDEX idx_changes_id_coid ON events (_id, changed_object_id)");
        sqlitedatabase.execSQL("CREATE TABLE account_metadata_states(_id INTEGER PRIMARY KEY AUTOINCREMENT, state TEXT NOT NULL, change_date TEXT NOT NULL, metadata_version INTEGER NOT NULL DEFAULT 1)");
        sqlitedatabase.execSQL("CREATE INDEX idx_account_metadata_states_aid_cid ON account_metadata_states (change_date)");
        createCloudMediaParents_v12(sqlitedatabase);
        createIdxCloudMediaParentsNodeId_v10(sqlitedatabase);
        createIdxCloudMediaParentsIsDirty_v10(sqlitedatabase);
        createIdxCloudMediaParentsStatusKindHiddenSortDateNodeId_v18(sqlitedatabase);
        createIdxCloudMediaParentsStatusKindHidenNameAscNodeId_v18(sqlitedatabase);
        createIdxCloudMediaParentsStatusKindHiddenNameDescNodeId_v18(sqlitedatabase);
        createCloudNodeChildren_v12(sqlitedatabase);
        createCloudNodeTransforms_v14(sqlitedatabase);
        createIdxCloudNodeTransforms_v14(sqlitedatabase);
        createMetadataCleanQueue_v21(sqlitedatabase);
        createUploadRequests_v28(sqlitedatabase);
        createUploadRequestBlockers_v24(sqlitedatabase);
        createUploadQueueBlockers_v24(sqlitedatabase);
        createUploadLog_v26(sqlitedatabase);
        createCoverPhotos_v30(sqlitedatabase);
        createCoverPhotosIdx_v30(sqlitedatabase);
        createQueryInclude_v32(sqlitedatabase);
        createQueryExcludedIds_v32(sqlitedatabase);
    }

    private void createCloudMediaParents_v10(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE cloud_media_parents(_id INTEGER PRIMARY KEY AUTOINCREMENT, node_id TEXT UNIQUE, created_by TEXT, created_date TEXT, description TEXT, exclusively_trashed INTEGER, is_root INTEGER, is_shared INTEGER, kind TEXT, modified_date TEXT, name TEXT, recursively_trashed INTEGER, restricted INTEGER, status TEXT, version INTEGER, sort_date TEXT, count INTEGER, is_dirty INTEGER )");
    }

    private void createCloudMediaParents_v12(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE cloud_media_parents(_id INTEGER PRIMARY KEY AUTOINCREMENT, node_id TEXT UNIQUE, created_by TEXT, created_date TEXT, description TEXT, exclusively_trashed INTEGER, is_root INTEGER, is_shared INTEGER, kind TEXT, modified_date TEXT, name TEXT, recursively_trashed INTEGER, restricted INTEGER, status TEXT, version INTEGER, sort_date TEXT, count INTEGER, is_dirty INTEGER, favorite INTEGER, hidden INTEGER, metadata_version INTEGER )");
    }

    private void createCloudNodeChildren_v12(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE VIEW IF NOT EXISTS cloud_node_children AS select     c._id,     c.event_id,     c.node_id,     c.change_type,     c.created_by,     c.created_date,     c.description,     c.exclusively_trashed,     c.is_root,     c.is_shared,     c.kind,     c.modified_date,     c.name,     c.recursively_trashed,     c.restricted,     c.status,     c.version,     c.content_sort_date,     c.content_date,     c.content_type,     c.content_extension,     c.content_md5,     c.content_size,     c.content_version,     c.document_version,     c.document_title,     c.image_aperture_value,     c.image_capture_mode,     c.image_color_space,     c.image_date_time,     c.image_date_time_digitized,     c.image_date_time_original,     c.image_exposure_mode,     c.image_exposure_program,     c.image_exposure_time,     c.image_flash,     c.image_focal_length,     c.image_gps_time_stamp,     c.image_height,     c.image_iso_speed_ratings,     c.image_location,     c.image_make,     c.image_metering_mode,     c.image_model,     c.image_orientation,     c.image_resolution_unit,     c.image_sensing_method,     c.image_sharpness,     c.image_software,     c.image_white_balance,     c.image_width,     c.image_x_resolution,     c.image_y_resolution,     c.is_content,     c.is_document,     c.is_image,     c.is_video,     c.video_audio_bitrate,     c.video_audio_channels,     c.video_audio_channel_layout,     c.video_audio_codec,     c.video_audio_sample_rate,     c.video_bitrate,     c.video_creation_date,     c.video_duration,     c.video_encoder,     c.video_height,     c.video_location,     c.video_make,     c.video_model,     c.video_rotate,     c.video_title,     c.video_overall_bitrate,     c.video_codec,     c.video_frame_rate,     c.video_width,     c.favorite,     c.hidden,     c.metadata_version,     p.parent_node_id from cloud_node_parents p cross join cloud_nodes c on     c.event_id=p.event_id and     c.node_id=p.node_id");
    }

    private void createCloudNodeTransforms_v14(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE cloud_node_transforms(_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id TEXT, transform TEXT)");
    }

    private void createCoverPhotosIdx_v30(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_node_cover_photos_eid_nid_cid ON cloud_node_cover_photos (event_id, node_id, cover_id)");
    }

    private void createCoverPhotos_v30(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS cloud_node_cover_photos (_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id TEXT NOT NULL, cover_id TEXT NOT NULL)");
    }

    private void createIdxCloudMediaParentsIsDirty_v10(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_cloud_media_parents_dty ON cloud_media_parents (is_dirty)");
    }

    private void createIdxCloudMediaParentsNodeId_v10(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_cloud_media_parents_nid ON cloud_media_parents (node_id)");
    }

    private void createIdxCloudMediaParentsStatusKindHiddenNameDescNodeId_v18(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_cloud_media_parents_s_k_h_nd_ni ON cloud_media_parents (status, kind, hidden, name DESC, node_id ASC)");
    }

    private void createIdxCloudMediaParentsStatusKindHiddenSortDateNodeId_v18(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_cloud_media_parents_s_k_h_sd_ni ON cloud_media_parents (status, kind, hidden, sort_date DESC, node_id ASC)");
    }

    private void createIdxCloudMediaParentsStatusKindHidenNameAscNodeId_v18(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_cloud_media_parents_s_k_h_na_ni ON cloud_media_parents (status, kind, hidden, name ASC, node_id ASC)");
    }

    private void createIdxCloudNodeTransforms_v14(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_cloud_node_transforms_ent ON cloud_node_transforms(event_id, node_id, transform)");
    }

    private void createIdxNodeParentsNodeId_v10(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_node_parents_nid ON cloud_node_parents (node_id)");
    }

    private void createIdxNodesEventIdNodeId_v10(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_eid_nid ON cloud_nodes (event_id DESC, node_id)");
    }

    private void createIdxNodesKeyStatusContentSortDateNodeIdHiddenIsVideoIsImage_v17(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_csd_ni_iv_h_ii ON cloud_nodes(kind, status, content_sort_date DESC, node_id ASC, hidden, is_video, is_image)");
    }

    private void createIdxNodesKeyStatusCreatedDateNodeIdHiddenIsVideoIsImage_v22(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_cd_ni_iv_h_ii ON cloud_nodes(kind, status, created_date DESC, node_id ASC, hidden, is_video, is_image)");
    }

    private void createIdxNodesKeyStatusFavoriteContentSortDateNodeIdHiddenIsVideoIsImage_v17(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_f_csd_ni_iv_h_ii ON cloud_nodes(kind, status, favorite, content_sort_date DESC, node_id ASC, hidden, is_video, is_image)");
    }

    private void createIdxNodesKeyStatusFavoriteContentSortDateNodeIdHiddenIsVideo_v17(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_f_h_iv_csd_ni ON cloud_nodes(kind, status, favorite, hidden, is_video, content_sort_date DESC, node_id ASC )");
    }

    private void createIdxNodesKeyStatusFavoriteCreatedDateNodeIdHiddenIsVideoIsImage_v22(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_f_cd_ni_iv_h_ii ON cloud_nodes(kind, status, favorite, created_date DESC, node_id ASC, hidden, is_video, is_image)");
    }

    private void createIdxNodesKeyStatusFavoriteCreatedDateNodeIdHiddenIsVideo_v22(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_f_h_iv_cd_ni ON cloud_nodes(kind, status, favorite, hidden, is_video, created_date DESC, node_id ASC )");
    }

    private void createIdxNodesKeyStatusIsVideoContentSortDateNodeIdHidden_v17(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_h_iv_csd_ni ON cloud_nodes(kind, status, hidden, is_video, content_sort_date DESC, node_id ASC )");
    }

    private void createIdxNodesKeyStatusIsVideoCreatedDateNodeIdHidden_v22(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE INDEX idx_nodes_k_s_h_iv_cd_ni ON cloud_nodes(kind, status, hidden, is_video, created_date DESC, node_id ASC )");
    }

    private void createMetadataCleanQueue_v21(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE metadata_cleanup_queue(_id INTEGER PRIMARY KEY AUTOINCREMENT, task_id INTEGER UNIQUE)");
    }

    private void createQueryExcludedIds_v32(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE cloud_node_query_excluded_ids (_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id  TEXT NOT NULL, excluded_node_id TEXT NOT NULL)");
    }

    private void createQueryInclude_v32(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE cloud_node_query_include (_id INTEGER PRIMARY KEY AUTOINCREMENT, event_id INTEGER, node_id  TEXT NOT NULL, and_block_position INTEGER, filter_position INTEGER, filter_type TEXT NOT NULL, value TEXT NOT NULL)");
    }

    private void createUploadLog_v26(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL((new StringBuilder()).append("CREATE TABLE upload_log(_id INTEGER PRIMARY KEY AUTOINCREMENT, ").append(com.amazon.mixtape.provider.UploadContract.LogEntry.TIME).append(" INTEGER, ").append(com.amazon.mixtape.provider.UploadContract.LogEntry.UPLOAD_REQUEST).append(" INTEGER, ").append(com.amazon.mixtape.provider.UploadContract.LogEntry.EVENT).append(" INTEGER, ").append(com.amazon.mixtape.provider.UploadContract.LogEntry.ERROR).append(" INTEGER, ").append(com.amazon.mixtape.provider.UploadContract.LogEntry.MESSAGE).append(" TEXT").append(")").toString());
    }

    private void createUploadQueueBlockers_v24(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE upload_queue_blockers(queue_name TEXT, blocker_name TEXT, UNIQUE(queue_name, blocker_name) ON CONFLICT IGNORE)");
    }

    private void createUploadRequestBlockers_v24(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE upload_request_blockers(request_id INTEGER, blocker_name TEXT, UNIQUE(request_id, blocker_name) ON CONFLICT IGNORE)");
    }

    private void createUploadRequests_v28(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE upload_requests(_id INTEGER PRIMARY KEY AUTOINCREMENT, queue TEXT, parent_id TEXT, file_uri TEXT, file_size INTEGER, name TEXT, priority INTEGER, state TEXT,suppress_deduplication INTEGER, rename_on_name_conflict INTEGER, retry_exceptions INTEGER, last_error INTEGER, attempts INTEGER, md5 TEXT)");
    }

    private void deleteAllTables(SQLiteDatabase sqlitedatabase)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj3 = new ArrayList();
        obj2 = new ArrayList();
        obj1 = new ArrayList();
        obj = new ArrayList();
        Cursor cursor = sqlitedatabase.rawQuery("SELECT name, type FROM sqlite_master", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) 
        {
            String s4 = cursor.getString(cursor.getColumnIndex("type"));
            String s5 = cursor.getString(cursor.getColumnIndex("name"));
            if (s4.equalsIgnoreCase("table"))
            {
                if (!s5.equalsIgnoreCase("sqlite_sequence") && !s5.equalsIgnoreCase("android_metadata"))
                {
                    ((List) (obj3)).add(s5);
                }
            } else
            if (s4.equalsIgnoreCase("index"))
            {
                ((List) (obj2)).add(s5);
            } else
            if (s4.equalsIgnoreCase("trigger"))
            {
                ((List) (obj1)).add(s5);
            } else
            if (s4.equalsIgnoreCase("view"))
            {
                ((List) (obj)).add(s5);
            }
            cursor.moveToNext();
        }
        cursor.close();
        sqlitedatabase.beginTransaction();
        String s3;
        for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); sqlitedatabase.execSQL((new StringBuilder()).append("DROP TABLE IF EXISTS ").append(s3).toString()))
        {
            s3 = (String)((Iterator) (obj3)).next();
        }

        break MISSING_BLOCK_LABEL_303;
        obj;
        sqlitedatabase.endTransaction();
        throw obj;
        String s2;
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); sqlitedatabase.execSQL((new StringBuilder()).append("DROP INDEX IF EXISTS ").append(s2).toString()))
        {
            s2 = (String)((Iterator) (obj2)).next();
        }

        String s1;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); sqlitedatabase.execSQL((new StringBuilder()).append("DROP TRIGGER IF EXISTS ").append(s1).toString()))
        {
            s1 = (String)((Iterator) (obj1)).next();
        }

        String s;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); sqlitedatabase.execSQL((new StringBuilder()).append("DROP VIEW IF EXISTS ").append(s).toString()))
        {
            s = (String)((Iterator) (obj)).next();
        }

        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
    }

    private void enableWriteAheadLogging()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            setWriteAheadLoggingEnabled(true);
        }
    }

    public static String getDatabaseNameForAccount(String s)
    {
        return (new StringBuilder()).append(s).append(".").append("mixtape.db").toString();
    }

    private boolean isDevelopVersion(int i)
    {
        int ai[] = RELEASE_DB_VERSIONS;
        int k = ai.length;
        for (int j = 0; j < k; j++)
        {
            if (ai[j] == i)
            {
                return false;
            }
        }

        return true;
    }

    public SQLiteDatabase getReadableDatabase()
    {
        enableWriteAheadLogging();
        return super.getReadableDatabase();
    }

    public SQLiteDatabase getWritableDatabase()
    {
        enableWriteAheadLogging();
        return super.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        createAllTables(sqlitedatabase);
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        deleteAllTables(sqlitedatabase);
        createAllTables(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (isDevelopVersion(i))
        {
            deleteAllTables(sqlitedatabase);
            createAllTables(sqlitedatabase);
            return;
        }
        switch (i)
        {
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        default:
            return;

        case 8: // '\b'
        case 9: // '\t'
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_eid_nid");
            createIdxNodesEventIdNodeId_v10(sqlitedatabase);
            createIdxNodeParentsNodeId_v10(sqlitedatabase);
            sqlitedatabase.execSQL("DROP VIEW IF EXISTS cloud_media_parents");
            createCloudMediaParents_v10(sqlitedatabase);
            createIdxCloudMediaParentsNodeId_v10(sqlitedatabase);
            createIdxCloudMediaParentsIsDirty_v10(sqlitedatabase);
            // fall through

        case 10: // '\n'
        case 11: // '\013'
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s", new Object[] {
                "cloud_nodes", "favorite", "INTEGER"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s", new Object[] {
                "cloud_nodes", "hidden", "INTEGER"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s", new Object[] {
                "cloud_nodes", "metadata_version", "INTEGER"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s", new Object[] {
                "cloud_media_parents", "favorite", "INTEGER"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s", new Object[] {
                "cloud_media_parents", "hidden", "INTEGER"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s", new Object[] {
                "cloud_media_parents", "metadata_version", "INTEGER"
            }));
            sqlitedatabase.execSQL("DROP VIEW IF EXISTS cloud_node_children");
            createCloudNodeChildren_v12(sqlitedatabase);
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s NOT NULL DEFAULT 1", new Object[] {
                "account_metadata_states", "metadata_version", "INTEGER"
            }));
            createCloudNodeTransforms_v14(sqlitedatabase);
            createIdxCloudNodeTransforms_v14(sqlitedatabase);
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_csd_iv_ii");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_iv_ii_csd");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_f_csd_iv_ii");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_f_iv_ii_csd");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_n");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_sd");
            // fall through

        case 17: // '\021'
        case 18: // '\022'
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_csd_ni_iv_ii");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_iv_csd_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_f_csd_ni_iv_ii");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_f_iv_csd_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_k_sd_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_k_na_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_k_nd_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_csd_ni_iv_h_ii");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_h_iv_csd_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_f_csd_ni_iv_h_ii");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_nodes_k_s_f_h_iv_csd_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_s_k_h_sd_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_s_k_h_na_ni");
            sqlitedatabase.execSQL("DROP INDEX IF EXISTS idx_cloud_media_parents_s_k_h_nd_ni");
            createIdxNodesKeyStatusContentSortDateNodeIdHiddenIsVideoIsImage_v17(sqlitedatabase);
            createIdxNodesKeyStatusIsVideoContentSortDateNodeIdHidden_v17(sqlitedatabase);
            createIdxNodesKeyStatusFavoriteContentSortDateNodeIdHiddenIsVideoIsImage_v17(sqlitedatabase);
            createIdxNodesKeyStatusFavoriteContentSortDateNodeIdHiddenIsVideo_v17(sqlitedatabase);
            createIdxCloudMediaParentsStatusKindHiddenSortDateNodeId_v18(sqlitedatabase);
            createIdxCloudMediaParentsStatusKindHidenNameAscNodeId_v18(sqlitedatabase);
            createIdxCloudMediaParentsStatusKindHiddenNameDescNodeId_v18(sqlitedatabase);
            // fall through

        case 19: // '\023'
        case 20: // '\024'
            createMetadataCleanQueue_v21(sqlitedatabase);
            MetadataCleanupTask.CLEAR_NODE_PROPERTIES.scheduleTaskForExecution(sqlitedatabase);
            if (i != 20)
            {
                MetadataCleanupTask.REBUILD_MEDIA_PARENTS.scheduleTaskForExecution(sqlitedatabase);
            }
            // fall through

        case 21: // '\025'
            createIdxNodesKeyStatusCreatedDateNodeIdHiddenIsVideoIsImage_v22(sqlitedatabase);
            createIdxNodesKeyStatusIsVideoCreatedDateNodeIdHidden_v22(sqlitedatabase);
            createIdxNodesKeyStatusFavoriteCreatedDateNodeIdHiddenIsVideoIsImage_v22(sqlitedatabase);
            createIdxNodesKeyStatusFavoriteCreatedDateNodeIdHiddenIsVideo_v22(sqlitedatabase);
            // fall through

        case 22: // '\026'
            createUploadRequests_v28(sqlitedatabase);
            createUploadRequestBlockers_v24(sqlitedatabase);
            createUploadQueueBlockers_v24(sqlitedatabase);
            createUploadLog_v26(sqlitedatabase);
            // fall through

        case 28: // '\034'
        case 29: // '\035'
            createCoverPhotos_v30(sqlitedatabase);
            createCoverPhotosIdx_v30(sqlitedatabase);
            // fall through

        case 30: // '\036'
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s %s", new Object[] {
                "cloud_nodes", "has_share_parent", "INTEGER"
            }));
            // fall through

        case 31: // '\037'
            createQueryInclude_v32(sqlitedatabase);
            createQueryExcludedIds_v32(sqlitedatabase);
            return;
        }
    }

}
