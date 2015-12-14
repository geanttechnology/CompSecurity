// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            PacksItemsColumns

public static final class packId extends 
{

    String contentPath;
    String displayName;
    String identifier;
    byte options[];
    final long packId;

    public static  create(Cursor cursor)
    {
        if (per.isValid(cursor))
        {
              = new <init>(cursor.getLong(cursor.getColumnIndex("item_id")), cursor.getLong(cursor.getColumnIndex("item_packId")));
            int i = cursor.getColumnIndex("item_identifier");
            if (i > -1)
            {
                .identifier = cursor.getString(i);
            }
            i = cursor.getColumnIndex("item_displayName");
            if (i > -1)
            {
                .displayName = cursor.getString(i);
            }
            i = cursor.getColumnIndex("item_contentPath");
            if (i > -1)
            {
                .contentPath = cursor.getString(i);
            }
            i = cursor.getColumnIndex("item_options");
            if (i > -1)
            {
                .options = cursor.getBlob(i);
            }
            return ;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        options options1 = new <init>(id, packId);
        options1.identifier = identifier;
        options1.displayName = displayName;
        options1.contentPath = contentPath;
        options1.options = options;
        return options1;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof options))
        {
            obj = (options)obj;
            if (id == ((id) (obj)).id && packId == ((packId) (obj)).packId)
            {
                return true;
            }
        }
        return false;
    }

    public String getContentPath()
    {
        return contentPath;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public byte[] getOptions()
    {
        return options;
    }

    public long getPackId()
    {
        return packId;
    }

    public int hashCode()
    {
        return Long.valueOf(id + 0x1869fL + packId).hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("PacksItemsColumns.Content{id: ").append(id).append(", packId: ").append(packId).append(", displayName: ").append(displayName).append("}").toString();
    }

    per(long l, long l1)
    {
        super(l);
        packId = l1;
    }
}
