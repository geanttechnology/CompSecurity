// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.fotoable.photoselector.MediaStorePhotosDB;
import com.fotoable.photoselector.MediaStoreScannerService;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

public class ari
{

    HashMap a;
    HashMap b;
    HashMap c;
    final MediaStoreScannerService d;

    ari(MediaStoreScannerService mediastorescannerservice)
    {
        d = mediastorescannerservice;
        super();
        a = new HashMap(200);
        b = new HashMap(200);
        c = new HashMap(200);
    }

    private void c()
    {
        Cursor cursor = d.getContentResolver().query(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[] {
            "_data", "image_id", "_id"
        }, "kind=1", null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                int i = cursor.getColumnIndexOrThrow("_id");
                int k = cursor.getColumnIndexOrThrow("image_id");
                String s = cursor.getString(i);
                String s2 = cursor.getString(k);
                b.put(s2, s);
            }

        }
        cursor = d.getContentResolver().query(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[] {
            "_data", "image_id", "_id"
        }, "kind=3", null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                int j = cursor.getColumnIndexOrThrow("_id");
                int l = cursor.getColumnIndexOrThrow("image_id");
                String s1 = cursor.getString(j);
                String s3 = cursor.getString(l);
                a.put(s3, s1);
            }

        }
    }

    public void a()
    {
        c();
        MediaStorePhotosDB.a().c();
    }

    protected void a(arh arh1)
    {
        aqz aqz1 = new aqz();
        aqz1.a(arh1.c);
        aqz1.b(arh1.b);
        aqz1.c(arh1.a);
        aqz1.a(arh1.f);
        aqz1.a(arh1.i);
        aqz1.e(arh1.d);
        aqz1.f(arh1.e);
        if (arh1.g != null)
        {
            aqz1.d(arh1.g);
        }
        if (arh1.h != null)
        {
            aqz1.b(arh1.h);
        }
        String s = (String)a.get(arh1.a);
        if (s != null)
        {
            aqz1.b(Uri.withAppendedPath(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, (new StringBuilder()).append("").append(s).toString()));
        }
        arh1 = (String)b.get(arh1.a);
        if (arh1 != null)
        {
            aqz1.c(Uri.withAppendedPath(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, (new StringBuilder()).append("").append(arh1).toString()));
        }
        MediaStorePhotosDB.a().a(aqz1);
    }

    public boolean b()
    {
        Log.v("MediaStoreScannerService", "MediaStoreScannerService doInBackground start");
        new Date();
        Object obj = d.getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "_data", "bucket_display_name", "datetaken", "bucket_id", "orientation", "_size", "date_added", "date_modified"
        }, null, null, "date_added DESC");
        Object obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        int i = ((Cursor) (obj)).getColumnIndex("bucket_display_name");
        obj1 = obj;
        int j = ((Cursor) (obj)).getColumnIndex("bucket_id");
        obj1 = obj;
        int k = ((Cursor) (obj)).getColumnIndex("datetaken");
        obj1 = obj;
        int l = ((Cursor) (obj)).getColumnIndexOrThrow("_id");
        obj1 = obj;
        int i1 = ((Cursor) (obj)).getColumnIndexOrThrow("_data");
        obj1 = obj;
        ((Cursor) (obj)).getColumnIndexOrThrow("_size");
        obj1 = obj;
        int j1 = ((Cursor) (obj)).getColumnIndexOrThrow("date_added");
        obj1 = obj;
        int k1 = ((Cursor) (obj)).getColumnIndexOrThrow("date_added");
        obj1 = obj;
        int l1 = ((Cursor) (obj)).getColumnIndexOrThrow("orientation");
_L7:
        obj1 = obj;
        arh arh1 = new arh(d);
        obj1 = obj;
        arh1.a = ((Cursor) (obj)).getString(l);
        obj1 = obj;
        arh1.c = ((Cursor) (obj)).getString(j);
        obj1 = obj;
        arh1.b = ((Cursor) (obj)).getString(i);
        obj1 = obj;
        Object obj2 = ((Cursor) (obj)).getString(k);
        obj1 = obj2;
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        obj1 = obj;
        obj2 = ((Cursor) (obj)).getString(k1);
        obj1 = obj2;
        Object obj3;
        obj2 = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_666;
        }
        obj1 = obj;
        boolean flag;
        try
        {
            obj2 = ((Cursor) (obj)).getString(j1);
            break MISSING_BLOCK_LABEL_666;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
        finally { }
          goto _L3
        obj3 = obj2;
        if (obj2 == null)
        {
            obj3 = "99999";
        }
        obj1 = obj;
        arh1.d = ((String) (obj3));
        obj1 = obj;
        arh1.e = ((Cursor) (obj)).getString(i1);
        obj1 = obj;
        obj2 = arh1.e;
        if (obj2 == null) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        if (((String) (obj2)).length() > 0) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L7; else goto _L2
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        Log.v("MediaStoreScannerService", "MediaStoreScannerService doInBackground end");
        flag = true;
_L16:
        return flag;
_L6:
        obj1 = obj;
        obj3 = ((String) (obj2)).split("\\.");
        obj1 = obj;
        obj3 = obj3[obj3.length - 1].toLowerCase();
        obj1 = obj;
        if (((String) (obj3)).equalsIgnoreCase("png")) goto _L9; else goto _L8
_L8:
        obj1 = obj;
        if (((String) (obj3)).equalsIgnoreCase("jpeg")) goto _L9; else goto _L10
_L10:
        obj1 = obj;
        if (((String) (obj3)).equalsIgnoreCase("jpg")) goto _L9; else goto _L11
_L11:
        obj1 = obj;
        flag = ((String) (obj3)).equalsIgnoreCase("bmp");
        if (!flag) goto _L5; else goto _L9
_L9:
        if (obj2 == null) goto _L5; else goto _L12
_L12:
        obj1 = obj;
        if (((String) (obj2)).length() <= 0) goto _L5; else goto _L13
_L13:
        obj1 = obj;
        obj2 = new File(((String) (obj2)));
        obj1 = obj;
        if (!((File) (obj2)).exists()) goto _L5; else goto _L14
_L14:
        obj1 = obj;
        flag = ((File) (obj2)).isFile();
        if (!flag) goto _L5; else goto _L15
_L15:
        obj1 = obj;
        arh1.i = Integer.parseInt(((Cursor) (obj)).getString(l1));
_L17:
        obj1 = obj;
        arh1.f = ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.parseLong(arh1.a));
        obj1 = obj;
        a(arh1);
          goto _L5
_L3:
        obj1 = obj;
        ((Exception) (obj2)).printStackTrace();
        obj1 = obj;
        Log.e("MediaStoreScannerService", (new StringBuilder()).append("Read images db failed").append(((Exception) (obj2)).getMessage()).toString());
        flag = false;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return false;
        }
          goto _L16
        obj1;
        obj1 = obj;
        arh1.i = -1;
          goto _L17
_L19:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        obj;
        obj1 = null;
        if (true) goto _L19; else goto _L18
_L18:
        obj2;
        obj = null;
          goto _L3
        exception;
          goto _L5
    }
}
