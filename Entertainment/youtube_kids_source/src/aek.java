// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class aek
{

    private static final String ALL_COLUMNS[] = {
        "video_id", "datetime", "recording_path", "thumbnail_path"
    };
    private static final String COL_DATETIME = "datetime";
    private static final int COL_INDEX_DATETIME = 1;
    private static final int COL_INDEX_RECODING_PATH = 2;
    private static final int COL_INDEX_THUMBNAIL_PATH = 3;
    private static final int COL_INDEX_VIDEO_ID = 0;
    private static final String COL_RECODING_PATH = "recording_path";
    private static final String COL_THUMBNAIL_PATH = "thumbnail_path";
    private static final String COL_VIDEO_ID = "video_id";
    private static final String SQL_CREATE_TABLE = "CREATE TABLE SingAlong(video_id TEXT NOT NULL, datetime INTEGER NOT NULL, recording_path TEXT NOT NULL, thumbnail_path TEXT NOT NULL, PRIMARY KEY (video_id, datetime));";
    private static final String TABLE_NAME = "SingAlong";
    private SQLiteOpenHelper helper;

    public aek(SQLiteOpenHelper sqliteopenhelper)
    {
        helper = sqliteopenhelper;
    }

    private ContentValues convertToContentValues(aei aei1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("video_id", aei1.getVideoId());
        contentvalues.put("datetime", Long.valueOf(aei1.getDatetime().getTime()));
        contentvalues.put("recording_path", aei1.getRecordingPath());
        contentvalues.put("thumbnail_path", aei1.getThumbnailPath());
        return contentvalues;
    }

    private aei covertToHolder(Cursor cursor)
    {
        aei aei1 = new aei(cursor.getString(0), new Date(cursor.getLong(1)));
        aei1.setRecordingPath(cursor.getString(2));
        aei1.setThumbnailPath(cursor.getString(3));
        return aei1;
    }

    public static void onTableCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE SingAlong(video_id TEXT NOT NULL, datetime INTEGER NOT NULL, recording_path TEXT NOT NULL, thumbnail_path TEXT NOT NULL, PRIMARY KEY (video_id, datetime));");
    }

    public static void onTableUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    private Cursor query(String s, String as[], String s1, String s2, String s3)
    {
        SQLiteDatabase sqlitedatabase = helper.getReadableDatabase();
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("SingAlong");
        return sqlitequerybuilder.query(sqlitedatabase, ALL_COLUMNS, s, as, s1, s2, s3);
    }

    public void delete(aei aei1)
    {
        helper.getWritableDatabase().delete("SingAlong", "video_id = ? AND datetime = ?", new String[] {
            aei1.getVideoId(), Long.toString(aei1.getDatetime().getTime())
        });
    }

    public List getAllRecordingsForVideo(String s)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        s = query("video_id = ?", new String[] {
            s
        }, null, null, "video_id ASC, datetime DESC");
        if (s != null)
        {
            if (s.moveToFirst())
            {
                do
                {
                    aei aei1 = covertToHolder(s);
                    if (aei1.isValidRecording())
                    {
                        arraylist.add(aei1);
                    } else
                    {
                        arraylist1.add(aei1);
                    }
                } while (s.moveToNext());
            }
            s.close();
        }
        for (s = arraylist1.iterator(); s.hasNext(); delete((aei)s.next())) { }
        return arraylist;
    }

    public List getMostRecentRecordingForAllVideos()
    {
        ArrayList arraylist = new ArrayList();
        Cursor cursor = query(null, null, null, null, "video_id ASC, datetime DESC");
        if (cursor != null)
        {
            if (cursor.moveToFirst())
            {
                String s = null;
                do
                {
                    String s1 = s;
                    if (!cursor.getString(0).equals(s))
                    {
                        arraylist.add(covertToHolder(cursor));
                        s1 = cursor.getString(0);
                    }
                    s = s1;
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return arraylist;
    }

    public void save(aei aei1)
    {
        helper.getWritableDatabase().insertOrThrow("SingAlong", null, convertToContentValues(aei1));
    }

}
