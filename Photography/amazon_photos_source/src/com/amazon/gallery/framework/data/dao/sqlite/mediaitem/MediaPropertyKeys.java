// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.EditHelper;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

public class MediaPropertyKeys
{

    public static final String ALL_COLUMNS[] = {
        "media_item_id", "property"
    };

    public static EditHelper newEditHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return new EditHelper(readwritesqlitedatabase, "media_property", ALL_COLUMNS, new String[] {
            "media_item_id"
        });
    }

}
