// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import com.amazon.gallery.framework.data.dao.sqlite.EditHelper;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

public class TagKeys
{

    public static final String ALL_COLUMNS[] = {
        "id", "type", "object_id_low", "object_id_hi", "label", "date_created", "sort_date", "has_sort_date", "cover_id_low", "cover_id_high", 
        "local_path", "tag_revision_id", "misc", "update_status", "storage", "new_content", "auto_save", "tag_sync_version", "media_items_sync_version", "time_stamp", 
        "custom_cover_id_low", "custom_cover_id_high", "db_version", "valid", "shared"
    };

    public static EditHelper newEditHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return new EditHelper(readwritesqlitedatabase, "tag", ALL_COLUMNS, new String[] {
            "id"
        });
    }

}
