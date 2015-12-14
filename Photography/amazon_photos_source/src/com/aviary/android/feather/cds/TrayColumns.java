// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;
import android.provider.BaseColumns;

public final class TrayColumns
    implements BaseColumns
{
    public static final class TrayCursorWrapper
    {

        private String displayName;
        private boolean free;
        private final long id;
        private String identifier;
        private String installDate;
        private long packId;
        private String packageName;
        private String path;
        private int type;

        public static TrayCursorWrapper create(Cursor cursor)
        {
            boolean flag = true;
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                TrayCursorWrapper traycursorwrapper = new TrayCursorWrapper(cursor.getLong(cursor.getColumnIndex("_id")));
                int i = cursor.getColumnIndex("displayName");
                if (i > -1)
                {
                    traycursorwrapper.displayName = cursor.getString(i);
                }
                i = cursor.getColumnIndex("identifier");
                if (i > -1)
                {
                    traycursorwrapper.identifier = cursor.getString(i);
                }
                i = cursor.getColumnIndex("type");
                if (i > -1)
                {
                    traycursorwrapper.type = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("path");
                if (i > -1)
                {
                    traycursorwrapper.path = cursor.getString(i);
                }
                i = cursor.getColumnIndex("packagename");
                if (i > -1)
                {
                    traycursorwrapper.packageName = cursor.getString(i);
                }
                i = cursor.getColumnIndex("installDate");
                if (i > -1)
                {
                    traycursorwrapper.installDate = cursor.getString(i);
                }
                i = cursor.getColumnIndex("isFree");
                if (i > -1)
                {
                    if (cursor.getInt(i) != 1)
                    {
                        flag = false;
                    }
                    traycursorwrapper.free = flag;
                }
                i = cursor.getColumnIndex("packId");
                if (i > -1)
                {
                    traycursorwrapper.packId = cursor.getLong(i);
                }
                return traycursorwrapper;
            } else
            {
                return null;
            }
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public boolean getFree()
        {
            return free;
        }

        public long getId()
        {
            return id;
        }

        public String getIdentifier()
        {
            return identifier;
        }

        public String getInstallDate()
        {
            return installDate;
        }

        public long getPackId()
        {
            return packId;
        }

        public String getPackageName()
        {
            return packageName;
        }

        public String getPath()
        {
            return path;
        }

        public int getType()
        {
            return type;
        }

        TrayCursorWrapper(long l)
        {
            id = l;
        }
    }


    public static final String DISPLAY_NAME = "displayName";
    public static final String IDENTIFIER = "identifier";
    public static final int IDENTIFIER_COLUMN_INDEX = 3;
    public static final int ID_COLUMN_INDEX = 0;
    public static final int ID_PACKAGENAME_INDEX = 2;
    public static final String INSTALL_DATE = "installDate";
    public static final int INSTALL_DATE_COLUMN_INDEX = 6;
    public static final String IS_FREE = "isFree";
    public static final int IS_FREE_COLUMN_INDEX = 7;
    public static final int LABEL_COLUMN_INDEX = 5;
    public static final String ORDER = "_order";
    public static final String PACKAGE_NAME = "packagename";
    public static final String PACK_ID = "packId";
    public static final int PACK_ID_COLUMN_INDEX = 8;
    public static final String PATH = "path";
    public static final int PATH_COLUMN_INDEX = 6;
    public static final String TYPE = "type";
    public static final int TYPE_COLUMN_INDEX = 4;
    public static final int TYPE_CONTENT = 0;
    public static final int TYPE_LEFT_DIVIDER = 3;
    public static final int TYPE_LEFT_GETMORE = 5;
    public static final int TYPE_PACK_EXTERNAL = 1;
    public static final int TYPE_PACK_INTERNAL = 2;
    public static final int TYPE_RIGHT_DIVIDER = 4;
    public static final int TYPE_RIGHT_GETMORE = 6;

    private TrayColumns()
    {
    }
}
