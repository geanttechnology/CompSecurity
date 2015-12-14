// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSDB

static final class dbName extends SQLiteOpenHelper
{
    static final class CMSColumn extends Enum
    {

        private static final CMSColumn $VALUES[];
        public static final CMSColumn ID;
        public static final CMSColumn TIMESTAMP;

        public static CMSColumn valueOf(String s)
        {
            return (CMSColumn)Enum.valueOf(com/amazon/gallery/framework/kindle/cms/CMSDB$CMSDBOpenHelper$CMSColumn, s);
        }

        public static CMSColumn[] values()
        {
            return (CMSColumn[])$VALUES.clone();
        }

        static 
        {
            ID = new CMSColumn("ID", 0);
            TIMESTAMP = new CMSColumn("TIMESTAMP", 1);
            $VALUES = (new CMSColumn[] {
                ID, TIMESTAMP
            });
        }

        private CMSColumn(String s, int i)
        {
            super(s, i);
        }
    }

    static final class CMSTable extends Enum
    {

        private static final CMSTable $VALUES[];
        public static final CMSTable RECENT_ALBUMS;

        public static CMSTable valueOf(String s)
        {
            return (CMSTable)Enum.valueOf(com/amazon/gallery/framework/kindle/cms/CMSDB$CMSDBOpenHelper$CMSTable, s);
        }

        public static CMSTable[] values()
        {
            return (CMSTable[])$VALUES.clone();
        }

        static 
        {
            RECENT_ALBUMS = new CMSTable("RECENT_ALBUMS", 0);
            $VALUES = (new CMSTable[] {
                RECENT_ALBUMS
            });
        }

        private CMSTable(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/cms/CMSDB$CMSDBOpenHelper.getName();
    private final String dbName;

    private void createRecentAlbumsTable(SQLiteDatabase sqlitedatabase)
    {
        String s = String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s INTEGER);", new Object[] {
            CMSTable.RECENT_ALBUMS.name(), CMSColumn.ID.name(), CMSColumn.TIMESTAMP.name()
        });
        String s1 = String.format("CREATE TRIGGER %s AFTER INSERT ON %s WHEN (SELECT COUNT(*) FROM %s) > %d BEGIN DELETE FROM %s WHERE %s NOT IN (SELECT %s FROM %s ORDER BY %s desc limit 20); END;", new Object[] {
            "DELETE_OLD_ITEMS_TRIGGER", CMSTable.RECENT_ALBUMS.name(), CMSTable.RECENT_ALBUMS.name(), Integer.valueOf(40), CMSTable.RECENT_ALBUMS.name(), CMSColumn.ID.name(), CMSColumn.ID.name(), CMSTable.RECENT_ALBUMS.name(), CMSColumn.TIMESTAMP.name()
        });
        sqlitedatabase.execSQL(s);
        sqlitedatabase.execSQL(s1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        GLogger.d(TAG, "Created Configuration Table", new Object[0]);
        createRecentAlbumsTable(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        GLogger.d(TAG, (new StringBuilder()).append("Upgrading ").append(dbName).append(" from version ").append(i).append(" to ").append(j).toString(), new Object[0]);
        sqlitedatabase.execSQL(String.format("DROP TABLE IF EXISTS %s;", new Object[] {
            CMSTable.RECENT_ALBUMS.name()
        }));
        sqlitedatabase.execSQL("DROP TRIGGER IF EXISTS DELETE_OLD_ITEMS_TRIGGER");
        onCreate(sqlitedatabase);
    }


    public CMSTable(Context context, String s)
    {
        super(context, s, null, 2);
        dbName = s;
    }
}
