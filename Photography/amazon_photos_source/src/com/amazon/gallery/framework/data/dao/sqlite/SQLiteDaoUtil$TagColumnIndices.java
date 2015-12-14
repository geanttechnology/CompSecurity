// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.TagPropertyDao;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            SQLiteDaoUtil

private static class <init>
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

    private Q()
    {
        initialized = false;
        tagProperties = new TagPropertyDao();
    }

    tagProperties(tagProperties tagproperties)
    {
        this();
    }
}
