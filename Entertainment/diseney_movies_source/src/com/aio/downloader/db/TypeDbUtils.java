// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.db;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.RemoteViews;
import com.aio.downloader.activity.MyDownloaderList;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MD5;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.db:
//            TypeDb

public class TypeDbUtils
    implements ContentValue
{

    public static NotificationManager mNotificationManager;
    private TypeDb db;
    private FinalDBChen finalDBChen;
    private Context mContext;
    private PackageInfo packageInfo;
    public publicTools puTools;

    public TypeDbUtils(Context context)
    {
        packageInfo = null;
        db = new TypeDb(context);
        mContext = context;
        mNotificationManager = (NotificationManager)context.getSystemService("notification");
        finalDBChen = new FinalDBChen(context, context.getDatabasePath("download2.db").getAbsolutePath());
        puTools = new publicTools(context);
    }

    public void deleteall()
    {
        db.getWritableDatabase().delete("file_list", null, null);
    }

    public void deleteallfile(String s)
    {
        db.getWritableDatabase().delete("file_list", "typ=?", new String[] {
            (new StringBuilder(String.valueOf(s))).toString()
        });
    }

    public void deletefile(String s)
    {
        db.getWritableDatabase().delete("file_list", "id=?", new String[] {
            (new StringBuilder(String.valueOf(s))).toString()
        });
    }

    public void insertApk(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            Long long1, String s6)
    {
        s6 = db.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", s);
        contentvalues.put("typ", s1);
        contentvalues.put("title", s2);
        contentvalues.put("icon", s3);
        contentvalues.put("size", s4);
        contentvalues.put("path", s5);
        contentvalues.put("serial", Integer.valueOf(i));
        contentvalues.put("create_time", long1);
        s6.insert("file_list", null, contentvalues);
        s6.close();
    }

    public List myqueryfile()
    {
        ArrayList arraylist;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        sqlitedatabase = db.getWritableDatabase();
        cursor = sqlitedatabase.query("file_list", null, null, null, null, null, null);
        arraylist = new ArrayList();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.moveToNext()) goto _L3; else goto _L2
_L3:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setFile_id(cursor.getString(cursor.getColumnIndex("id")));
        downloadmovieitem.setType(cursor.getString(cursor.getColumnIndex("typ")));
        downloadmovieitem.setMovieName(cursor.getString(cursor.getColumnIndex("title")));
        downloadmovieitem.setMovieHeadImagePath(cursor.getString(cursor.getColumnIndex("icon")));
        downloadmovieitem.setFileSize(cursor.getString(cursor.getColumnIndex("size")));
        downloadmovieitem.setFilePath(cursor.getString(cursor.getColumnIndex("path")));
        downloadmovieitem.setSerial(cursor.getInt(cursor.getColumnIndex("serial")));
        downloadmovieitem.setCreate_time(Long.valueOf(cursor.getLong(cursor.getColumnIndex("create_time"))));
        arraylist.add(downloadmovieitem);
          goto _L1
        Exception exception1;
        exception1;
          goto _L2
_L5:
        if (cursor.getCount() != 0)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        sqlitedatabase.close();
        return null;
        try
        {
            sqlitedatabase.close();
        }
        catch (Exception exception) { }
        break; /* Loop/switch isn't completed */
_L2:
        if (cursor == null)
        {
            return null;
        }
        if (true) goto _L5; else goto _L4
_L4:
        return arraylist;
    }

    public List queryApk(String s, String s1)
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = db.getWritableDatabase();
        cursor = null;
        if (!s1.equals("timesort")) goto _L2; else goto _L1
_L1:
        cursor = sqlitedatabase.query("file_list", null, (new StringBuilder("typ='")).append(s).append("'").toString(), null, null, null, "create_time DESC");
_L8:
        s = new ArrayList();
        if (cursor == null) goto _L4; else goto _L3
_L3:
        boolean flag = cursor.moveToNext();
        if (flag) goto _L5; else goto _L4
_L4:
        if (cursor == null)
        {
            return null;
        }
          goto _L6
_L2:
        if (s1.equals("zimusort"))
        {
            cursor = sqlitedatabase.query("file_list", null, (new StringBuilder("typ='")).append(s).append("'").toString(), null, null, null, "title ASC");
        }
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = new DownloadMovieItem();
        s1.setFile_id(cursor.getString(cursor.getColumnIndex("id")));
        s1.setType(cursor.getString(cursor.getColumnIndex("typ")));
        s1.setMovieName(cursor.getString(cursor.getColumnIndex("title")));
        s1.setMovieHeadImagePath(cursor.getString(cursor.getColumnIndex("icon")));
        s1.setFileSize(cursor.getString(cursor.getColumnIndex("size")));
        s1.setFilePath(cursor.getString(cursor.getColumnIndex("path")));
        s1.setSerial(cursor.getInt(cursor.getColumnIndex("serial")));
        s1.setCreate_time(Long.valueOf(cursor.getLong(cursor.getColumnIndex("create_time"))));
        s.add(s1);
          goto _L3
        s1;
          goto _L4
_L6:
        if (cursor.getCount() != 0)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        sqlitedatabase.close();
        return null;
        try
        {
            sqlitedatabase.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
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
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setFile_id(s.getString(s.getColumnIndex("file_id")));
        arraylist.add(downloadmovieitem);
        if (true) goto _L1; else goto _L4
_L4:
        if (s.getCount() == 0)
        {
            sqlitedatabase.close();
            return null;
        } else
        {
            sqlitedatabase.close();
            return ((DownloadMovieItem)arraylist.get(0)).getFile_id();
        }
    }

    public String queryfile(String s)
    {
        ArrayList arraylist;
        s = db.getWritableDatabase().query("file_list", null, (new StringBuilder("id='")).append(s).append("'").toString(), null, null, null, null);
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
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setFile_id(s.getString(s.getColumnIndex("id")));
        arraylist.add(downloadmovieitem);
        if (true) goto _L1; else goto _L4
_L4:
        if (s.getCount() == 0)
        {
            db.close();
            return null;
        } else
        {
            return ((DownloadMovieItem)arraylist.get(0)).getFile_id();
        }
    }

    public List queryfile2()
    {
        Cursor cursor;
        ArrayList arraylist;
        cursor = db.getWritableDatabase().query("file_list", null, null, null, null, null, null);
        arraylist = new ArrayList();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.moveToNext()) goto _L3; else goto _L2
_L2:
        if (cursor == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L3:
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        downloadmovieitem.setFile_id(cursor.getString(cursor.getColumnIndex("id")));
        downloadmovieitem.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        downloadmovieitem.setSerial(cursor.getInt(cursor.getColumnIndex("serial")));
        downloadmovieitem.setType(cursor.getString(cursor.getColumnIndex("typ")));
        downloadmovieitem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
        try
        {
            Log.v("vfvf", (new StringBuilder("/////")).append(downloadmovieitem.getFile_id()).append("//////").append(downloadmovieitem.getTitle()).append("////////").append(downloadmovieitem.getSerial()).toString());
            packageInfo = mContext.getPackageManager().getPackageInfo(downloadmovieitem.getFile_id(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            packageInfo = null;
            namenotfoundexception.printStackTrace();
        }
        if (packageInfo == null && downloadmovieitem.getType().equals("app"))
        {
            Notification notification = new Notification();
            notification.flags = 16;
            notification.icon = 0x7f0200ec;
            Object obj = new Intent(mContext, com/aio/downloader/activity/MyDownloaderList);
            ((Intent) (obj)).setFlags(0x10000000);
            Bundle bundle = new Bundle();
            bundle.putString("saomiao", "ok");
            ((Intent) (obj)).putExtras(bundle);
            notification.contentIntent = PendingIntent.getActivity(mContext, downloadmovieitem.getSerial(), ((Intent) (obj)), 0x8000000);
            obj = new RemoteViews(mContext.getPackageName(), 0x7f030092);
            ((RemoteViews) (obj)).setTextViewText(0x7f070334, downloadmovieitem.getTitle());
            ((RemoteViews) (obj)).setTextViewText(0x7f070335, DateFormat.format("kk:mm", System.currentTimeMillis()));
            ((RemoteViews) (obj)).setImageViewBitmap(0x7f070277, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(downloadmovieitem.getIcon())).toString()));
            notification.contentView = ((RemoteViews) (obj));
            mNotificationManager.notify(downloadmovieitem.getSerial(), notification);
        }
        arraylist.add(downloadmovieitem);
        if (true) goto _L1; else goto _L4
_L4:
        if (cursor.getCount() == 0)
        {
            db.close();
            return null;
        } else
        {
            return null;
        }
    }
}
