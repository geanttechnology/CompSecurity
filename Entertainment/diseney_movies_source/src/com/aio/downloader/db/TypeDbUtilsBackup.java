// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.aio.downloader.model.BackupModel;
import com.aio.downloader.mydownload.ContentValue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.db:
//            TypeDbBackup

public class TypeDbUtilsBackup
    implements ContentValue
{

    private TypeDbBackup db;
    private FinalDBChen finalDBChen;

    public TypeDbUtilsBackup(Context context)
    {
        db = new TypeDbBackup(context);
        finalDBChen = new FinalDBChen(context, context.getDatabasePath("download2.db").getAbsolutePath());
    }

    public void deleteallfile(String s)
    {
        db.getWritableDatabase().delete("backup", "typ=?", new String[] {
            (new StringBuilder(String.valueOf(s))).toString()
        });
    }

    public void deletefile(String s)
    {
        db.getWritableDatabase().delete("backup", "package_name=?", new String[] {
            (new StringBuilder(String.valueOf(s))).toString()
        });
    }

    public void insertApk(String s, String s1, String s2, String s3, String s4, String s5)
    {
        SQLiteDatabase sqlitedatabase = db.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("package_name", s);
        contentvalues.put("app_name", s1);
        contentvalues.put("typ", s2);
        contentvalues.put("img", s3);
        contentvalues.put("size", s4);
        contentvalues.put("version", s5);
        sqlitedatabase.insert("backup", null, contentvalues);
        sqlitedatabase.close();
    }

    public List queryApk(String s, String s1)
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = db.getWritableDatabase();
        cursor = null;
        if (!s1.equals("timesort")) goto _L2; else goto _L1
_L1:
        cursor = sqlitedatabase.query("backup", null, (new StringBuilder("typ='")).append(s).append("'").toString(), null, null, null, null);
_L8:
        s = new ArrayList();
        if (cursor == null) goto _L4; else goto _L3
_L3:
        if (cursor.moveToNext()) goto _L5; else goto _L4
_L4:
        if (cursor == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (s1.equals("zimusort"))
        {
            cursor = sqlitedatabase.query("backup", null, (new StringBuilder("typ='")).append(s).append("'").toString(), null, null, null, "title ASC");
        }
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = new BackupModel();
        s1.setPackage_name(cursor.getString(cursor.getColumnIndex("package_name")));
        s1.setApp_name(cursor.getString(cursor.getColumnIndex("app_name")));
        s1.setImg(cursor.getString(cursor.getColumnIndex("img")));
        s1.setSize(cursor.getString(cursor.getColumnIndex("size")));
        s1.setVersion(cursor.getString(cursor.getColumnIndex("version")));
        s.add(s1);
        if (true) goto _L3; else goto _L6
_L6:
        if (cursor.getCount() == 0)
        {
            sqlitedatabase.close();
            return null;
        }
        sqlitedatabase.close();
        return s;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String querydownloading(String s)
    {
        SQLiteDatabase sqlitedatabase;
        ArrayList arraylist;
        sqlitedatabase = finalDBChen.getDatabase();
        s = sqlitedatabase.query("downloadtask", null, (new StringBuilder("file_id='")).append(s).append("'").toString(), null, null, null, null);
        arraylist = new ArrayList();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.moveToNext()) goto _L3; else goto _L2
_L2:
        if (s == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L3:
        BackupModel backupmodel = new BackupModel();
        backupmodel.setPackage_name(s.getString(s.getColumnIndex("package_name")));
        arraylist.add(backupmodel);
        if (true) goto _L1; else goto _L4
_L4:
        if (s.getCount() == 0)
        {
            sqlitedatabase.close();
            return null;
        } else
        {
            sqlitedatabase.close();
            return ((BackupModel)arraylist.get(0)).getPackage_name();
        }
    }

    public String queryfile(String s)
    {
        ArrayList arraylist;
        s = db.getWritableDatabase().query("backup", null, (new StringBuilder("package_name='")).append(s).append("'").toString(), null, null, null, null);
        arraylist = new ArrayList();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.moveToNext()) goto _L3; else goto _L2
_L2:
        if (s == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L3:
        BackupModel backupmodel = new BackupModel();
        backupmodel.setPackage_name(s.getString(s.getColumnIndex("package_name")));
        arraylist.add(backupmodel);
        if (true) goto _L1; else goto _L4
_L4:
        if (s.getCount() == 0)
        {
            db.close();
            return null;
        } else
        {
            return ((BackupModel)arraylist.get(0)).getPackage_name();
        }
    }
}
