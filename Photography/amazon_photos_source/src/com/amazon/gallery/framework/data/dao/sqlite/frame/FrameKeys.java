// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.frame;

import com.amazon.gallery.framework.data.dao.sqlite.EditHelper;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

public class FrameKeys
{

    public static final String ALL_COLUMNS[] = {
        "media_item_id", "local_path", "frame_number"
    };

    public static EditHelper newEditHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return new EditHelper(readwritesqlitedatabase, "frame", ALL_COLUMNS, new String[] {
            "media_item_id"
        });
    }

}
