// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.EditHelper;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

public class MediaItemKeys
{

    public static final String ALL_COLUMNS[] = {
        "id", "asset_hash", "name", "type", "object_id_low", "object_id_hi", "width", "height", "caption", "local_path", 
        "lat", "lon", "date_created", "date_created_utc", "date_modified", "date_added", "duration", "uploaded_id_hi", "uploaded_id_low", "orientation", 
        "parent_media_id_low", "parent_media_id_hi", "group_type", "sync_state", "has_date", "time_stamp", "mime_type", "event_id", "full_md5", "file_size", 
        "hidden", "timeline_time_stamp", "timeline_date_added", "has_time_stamp"
    };

    public static EditHelper newEditHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return new EditHelper(readwritesqlitedatabase, "media_item", ALL_COLUMNS, new String[] {
            "id"
        });
    }

}
