// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.Cursor;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            SQLiteDaoUtil

public static class initialized
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
                GLogger.ex(SQLiteDaoUtil.access$000(), "Hidden column was -1, do not set initialized true", new Throwable());
                if (SQLiteDaoUtil.access$100() != null)
                {
                    SQLiteDaoUtil.access$100().trackEvent(nMissing);
                    return;
                }
            } else
            {
                initialized = true;
                return;
            }
        }
    }

    public ()
    {
        initialized = false;
    }
}
