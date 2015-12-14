// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            EditHelper, ReadWriteSQLiteDatabase

public class TagMembershipKeys
{

    public static final String ALL_COLUMNS[] = {
        "media_item_id", "tag_id", "tag_media_revision_id"
    };

    public static EditHelper newEditHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return new EditHelper(readwritesqlitedatabase, "tag_membership", ALL_COLUMNS, new String[] {
            "media_item_id"
        });
    }

}
