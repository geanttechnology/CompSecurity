// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

public final class PacksColumns
{
    public static final class PackCursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        PacksContentColumns.ContentCursorWrapper content;
        String creationDate;
        int displayOrder;
        String identifier;
        int markedForDeletion;
        String packType;
        String versionKey;
        int visible;

        public static PackCursorWrapper create(Cursor cursor)
        {
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                PackCursorWrapper packcursorwrapper = new PackCursorWrapper(cursor.getLong(cursor.getColumnIndex("pack_id")));
                int i = cursor.getColumnIndex("pack_identifier");
                if (i > -1)
                {
                    packcursorwrapper.identifier = cursor.getString(i);
                }
                i = cursor.getColumnIndex("pack_versionKey");
                if (i > -1)
                {
                    packcursorwrapper.versionKey = cursor.getString(i);
                }
                i = cursor.getColumnIndex("pack_type");
                if (i > -1)
                {
                    packcursorwrapper.packType = cursor.getString(i);
                }
                i = cursor.getColumnIndex("pack_markedForDeletion");
                if (i > -1)
                {
                    packcursorwrapper.markedForDeletion = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("pack_visible");
                if (i > -1)
                {
                    packcursorwrapper.visible = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("pack_displayOrder");
                if (i > -1)
                {
                    packcursorwrapper.displayOrder = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("pack_creationDate");
                if (i > -1)
                {
                    packcursorwrapper.creationDate = cursor.getString(i);
                }
                return packcursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            PackCursorWrapper packcursorwrapper = new PackCursorWrapper(id);
            packcursorwrapper.identifier = identifier;
            packcursorwrapper.packType = packType;
            packcursorwrapper.versionKey = versionKey;
            packcursorwrapper.displayOrder = displayOrder;
            packcursorwrapper.visible = visible;
            packcursorwrapper.creationDate = creationDate;
            packcursorwrapper.markedForDeletion = markedForDeletion;
            if (content != null)
            {
                packcursorwrapper.content = (PacksContentColumns.ContentCursorWrapper)content.clone();
            }
            return packcursorwrapper;
        }

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof PackCursorWrapper))
            {
                obj = (PackCursorWrapper)obj;
                if (id == ((PackCursorWrapper) (obj)).id)
                {
                    return true;
                }
            }
            return false;
        }

        public PacksContentColumns.ContentCursorWrapper getContent()
        {
            return content;
        }

        public String getCreationDate()
        {
            return creationDate;
        }

        public int getDisplayOrder()
        {
            return displayOrder;
        }

        public String getIdentifier()
        {
            return identifier;
        }

        public int getMarkedForDeletion()
        {
            return markedForDeletion;
        }

        public String getPackType()
        {
            return packType;
        }

        public String getVersionKey()
        {
            return versionKey;
        }

        public int getVisible()
        {
            return visible;
        }

        public int hashCode()
        {
            return Long.valueOf(id).hashCode();
        }

        public void setContent(PacksContentColumns.ContentCursorWrapper contentcursorwrapper)
        {
            content = contentcursorwrapper;
        }

        public String toString()
        {
            return (new StringBuilder()).append("PacksColumn.Pack{ id: ").append(id).append(", identifier: ").append(identifier).append(", packType: ").append(packType).append(", versionKey: ").append(versionKey).append(", markedForDeletion: ").append(markedForDeletion).append(", order: ").append(displayOrder).append(", visible: ").append(visible).append(" }").toString();
        }

        PackCursorWrapper(long l)
        {
            super(l);
        }
    }


    public static final String CREATION_DATE = "pack_creationDate";
    public static final String DISPLAY_ORDER = "pack_displayOrder";
    public static final String FINISHED_DOWNLOADING = "pack_finishedDownloading";
    public static final String IDENTIFIER = "pack_identifier";
    public static final String MARKED_FOR_DELETION = "pack_markedForDeletion";
    public static final String PACK_TYPE = "pack_type";
    public static final String TABLE_NAME = "packs_table";
    public static final String VERSION_KEY = "pack_versionKey";
    public static final String VISIBLE = "pack_visible";
    public static final String _ID = "pack_id";

    private PacksColumns()
    {
    }
}
