// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

public final class PacksItemsColumns
{
    public static final class CursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        String contentPath;
        String displayName;
        String identifier;
        byte options[];
        final long packId;

        public static CursorWrapper create(Cursor cursor)
        {
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                CursorWrapper cursorwrapper = new CursorWrapper(cursor.getLong(cursor.getColumnIndex("item_id")), cursor.getLong(cursor.getColumnIndex("item_packId")));
                int i = cursor.getColumnIndex("item_identifier");
                if (i > -1)
                {
                    cursorwrapper.identifier = cursor.getString(i);
                }
                i = cursor.getColumnIndex("item_displayName");
                if (i > -1)
                {
                    cursorwrapper.displayName = cursor.getString(i);
                }
                i = cursor.getColumnIndex("item_contentPath");
                if (i > -1)
                {
                    cursorwrapper.contentPath = cursor.getString(i);
                }
                i = cursor.getColumnIndex("item_options");
                if (i > -1)
                {
                    cursorwrapper.options = cursor.getBlob(i);
                }
                return cursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            CursorWrapper cursorwrapper = new CursorWrapper(id, packId);
            cursorwrapper.identifier = identifier;
            cursorwrapper.displayName = displayName;
            cursorwrapper.contentPath = contentPath;
            cursorwrapper.options = options;
            return cursorwrapper;
        }

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof CursorWrapper))
            {
                obj = (CursorWrapper)obj;
                if (id == ((CursorWrapper) (obj)).id && packId == ((CursorWrapper) (obj)).packId)
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

        CursorWrapper(long l, long l1)
        {
            super(l);
            packId = l1;
        }
    }


    public static final String CONTENT_PATH = "item_contentPath";
    public static final String DISPLAY_NAME = "item_displayName";
    public static final String IDENTIFIER = "item_identifier";
    public static final String OPTIONS = "item_options";
    public static final String PACK_ID = "item_packId";
    public static final String TABLE_NAME = "items_table";
    public static final String _ID = "item_id";

    private PacksItemsColumns()
    {
    }
}
