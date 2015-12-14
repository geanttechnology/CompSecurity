// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class SubscriptionsColumns
{
    public static final class CursorWrapper extends VersionColumns.BaseCursorWrapper
    {

        SubscriptionsContentColumns.CursorWrapper content;
        String identifier;
        String versionKey;
        int visible;

        public static CursorWrapper create(Cursor cursor)
        {
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                CursorWrapper cursorwrapper = new CursorWrapper(cursor.getLong(cursor.getColumnIndex("subscription_id")));
                int i = cursor.getColumnIndex("subscription_identifier");
                if (i > -1)
                {
                    cursorwrapper.identifier = cursor.getString(i);
                }
                i = cursor.getColumnIndex("subscription_version_key");
                if (i > -1)
                {
                    cursorwrapper.versionKey = cursor.getString(i);
                }
                i = cursor.getColumnIndex("subscription_visible");
                if (i > -1)
                {
                    cursorwrapper.visible = cursor.getInt(i);
                }
                return cursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            CursorWrapper cursorwrapper = new CursorWrapper(id);
            cursorwrapper.identifier = identifier;
            cursorwrapper.versionKey = versionKey;
            cursorwrapper.visible = visible;
            if (content != null)
            {
                cursorwrapper.content = (SubscriptionsContentColumns.CursorWrapper)content.clone();
            }
            return cursorwrapper;
        }

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof CursorWrapper))
            {
                obj = (CursorWrapper)obj;
                if (id == ((CursorWrapper) (obj)).id)
                {
                    return true;
                }
            }
            return false;
        }

        public SubscriptionsContentColumns.CursorWrapper getContent()
        {
            return content;
        }

        public String getIdentifier()
        {
            return identifier;
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

        public void setContent(SubscriptionsContentColumns.CursorWrapper cursorwrapper)
        {
            content = cursorwrapper;
        }

        CursorWrapper(long l)
        {
            super(l);
        }
    }


    public static final String IDENTIFIER = "subscription_identifier";
    public static final String TABLE_NAME = "subscription_table";
    public static final String VERSION_KEY = "subscription_version_key";
    public static final String VISIBLE = "subscription_visible";
    public static final String _ID = "subscription_id";

    private SubscriptionsColumns()
    {
    }

    static void create(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS subscription_table (subscription_id INTEGER PRIMARY KEY AUTOINCREMENT, subscription_version_key VARCHAR(255) NOT NULL, subscription_visible INTEGER NOT NULL DEFAULT 1, subscription_identifier VARCHAR(255) NOT NULL UNIQUE);");
    }
}
