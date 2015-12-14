// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSObjectID

public class CMSDB
{
    static final class CMSDBOpenHelper extends SQLiteOpenHelper
    {

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


        public CMSDBOpenHelper(Context context1, String s)
        {
            super(context1, s, null, 2);
            dbName = s;
        }
    }

    static final class CMSDBOpenHelper.CMSColumn extends Enum
    {

        private static final CMSDBOpenHelper.CMSColumn $VALUES[];
        public static final CMSDBOpenHelper.CMSColumn ID;
        public static final CMSDBOpenHelper.CMSColumn TIMESTAMP;

        public static CMSDBOpenHelper.CMSColumn valueOf(String s)
        {
            return (CMSDBOpenHelper.CMSColumn)Enum.valueOf(com/amazon/gallery/framework/kindle/cms/CMSDB$CMSDBOpenHelper$CMSColumn, s);
        }

        public static CMSDBOpenHelper.CMSColumn[] values()
        {
            return (CMSDBOpenHelper.CMSColumn[])$VALUES.clone();
        }

        static 
        {
            ID = new CMSDBOpenHelper.CMSColumn("ID", 0);
            TIMESTAMP = new CMSDBOpenHelper.CMSColumn("TIMESTAMP", 1);
            $VALUES = (new CMSDBOpenHelper.CMSColumn[] {
                ID, TIMESTAMP
            });
        }

        private CMSDBOpenHelper.CMSColumn(String s, int i)
        {
            super(s, i);
        }
    }

    static final class CMSDBOpenHelper.CMSTable extends Enum
    {

        private static final CMSDBOpenHelper.CMSTable $VALUES[];
        public static final CMSDBOpenHelper.CMSTable RECENT_ALBUMS;

        public static CMSDBOpenHelper.CMSTable valueOf(String s)
        {
            return (CMSDBOpenHelper.CMSTable)Enum.valueOf(com/amazon/gallery/framework/kindle/cms/CMSDB$CMSDBOpenHelper$CMSTable, s);
        }

        public static CMSDBOpenHelper.CMSTable[] values()
        {
            return (CMSDBOpenHelper.CMSTable[])$VALUES.clone();
        }

        static 
        {
            RECENT_ALBUMS = new CMSDBOpenHelper.CMSTable("RECENT_ALBUMS", 0);
            $VALUES = (new CMSDBOpenHelper.CMSTable[] {
                RECENT_ALBUMS
            });
        }

        private CMSDBOpenHelper.CMSTable(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/cms/CMSDB.getName();
    private Context context;
    private CMSDBOpenHelper dbOpenHelper;

    public CMSDB()
    {
    }

    private void createAndCloseOldDB(String s)
    {
        s = String.format("tatecmsdb-%s.db", new Object[] {
            s
        });
        if (dbOpenHelper != null)
        {
            dbOpenHelper.close();
        }
        dbOpenHelper = new CMSDBOpenHelper(context, s);
    }

    public Map getAlbumsInRecentAlbumsTable(int i)
    {
        Object obj;
        Object obj1;
        if (i <= 0)
        {
            throw new IllegalArgumentException("MaxLimit cannot be <= 0");
        }
        obj = new LinkedHashMap();
        obj1 = dbOpenHelper.getReadableDatabase();
        String s = CMSDBOpenHelper.CMSColumn.ID.name();
        String s2 = CMSDBOpenHelper.CMSColumn.TIMESTAMP.name();
        String s3 = (new StringBuilder()).append(CMSDBOpenHelper.CMSColumn.TIMESTAMP.name()).append(" desc LIMIT ").append(i).toString();
        obj1 = ((SQLiteDatabase) (obj1)).query(CMSDBOpenHelper.CMSTable.RECENT_ALBUMS.name(), new String[] {
            s, s2
        }, null, null, null, null, s3);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        if (((Cursor) (obj1)).moveToFirst())
        {
            i = ((Cursor) (obj1)).getColumnIndex(CMSDBOpenHelper.CMSColumn.ID.name());
            int j = ((Cursor) (obj1)).getColumnIndex(CMSDBOpenHelper.CMSColumn.TIMESTAMP.name());
            for (; !((Cursor) (obj1)).isAfterLast(); ((Cursor) (obj1)).moveToNext())
            {
                String s1 = ((Cursor) (obj1)).getString(i);
                long l = ((Cursor) (obj1)).getLong(j);
                ((Map) (obj)).put(CMSObjectID.parse(s1), new Date(l));
            }

        }
        break MISSING_BLOCK_LABEL_215;
        obj;
        ((Cursor) (obj1)).close();
        throw obj;
        ((Cursor) (obj1)).close();
        return ((Map) (obj));
    }

    public void initWithContextAndUser(Context context1, String s)
    {
        context = context1;
        createAndCloseOldDB(s);
    }

}
