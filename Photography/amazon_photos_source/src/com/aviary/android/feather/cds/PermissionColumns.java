// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

final class PermissionColumns
{
    static final class CursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        private String hashCode;
        private String value;

        public static CursorWrapper create(Cursor cursor)
        {
            if (isValid(cursor))
            {
                CursorWrapper cursorwrapper = new CursorWrapper(cursor.getLong(0));
                int i = cursor.getColumnIndex("perm_value");
                if (i > -1)
                {
                    cursorwrapper.value = cursor.getString(i);
                }
                i = cursor.getColumnIndex("perm_hash");
                if (i > -1)
                {
                    cursorwrapper.hashCode = cursor.getString(i);
                }
                return cursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            CursorWrapper cursorwrapper = new CursorWrapper(getId());
            cursorwrapper.hashCode = hashCode;
            cursorwrapper.value = value;
            return cursorwrapper;
        }

        public String getHashCode()
        {
            return hashCode;
        }

        public String getValue()
        {
            return value;
        }

        public String toString()
        {
            return (new StringBuilder()).append("PermissionColumns.Permission{").append(value).append(", ").append(hashCode).append("}").toString();
        }

        public CursorWrapper(long l)
        {
            super(l);
        }
    }


    static final String HASH = "perm_hash";
    static final String TABLE_NAME = "permission_table";
    static final String VALUE = "perm_value";
    static final String _ID = "perm_id";

    private PermissionColumns()
    {
    }

    static void create(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS permission_table (perm_id INTEGER PRIMARY KEY AUTOINCREMENT, perm_value TEXT, perm_hash TEXT NOT NULL DEFAULT 0);");
        sqlitedatabase.execSQL((new StringBuilder()).append(" INSERT OR REPLACE INTO permission_table (perm_value, perm_hash) VALUES ( '").append(AviaryCds.Permission.hires.name()).append(",").append(AviaryCds.Permission.whitelabel.name()).append("', '0' );").toString());
    }
}
