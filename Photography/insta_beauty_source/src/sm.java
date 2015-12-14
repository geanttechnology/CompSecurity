// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.Test118.NativeView;
import com.crashlytics.android.Crashlytics;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.File;

public class sm
{

    private static String a = "";
    private static SharedPreferences b;
    private static android.content.SharedPreferences.Editor c;

    public static File a(Bitmap bitmap)
    {
        File file = new File(a(), (new StringBuilder()).append("img").append(System.currentTimeMillis()).append(".jpg").toString());
        Log.v("savePhotoTool", (new StringBuilder()).append("savePhotoToolmediaStorageDir :").append(file).toString());
        try
        {
            NativeView.a(bitmap, file.getAbsolutePath(), 100);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return file;
        }
        return file;
    }

    public static String a()
    {
        boolean flag = false;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        Log.v("savePhotoTool", (new StringBuilder()).append("savePhotoToolbHaveSdcard :").append(flag).toString());
        String s = b.getString("storePath", null);
        if (s == null)
        {
            return a(flag);
        }
        if (!(new File(s)).exists())
        {
            return a(flag);
        } else
        {
            return s;
        }
    }

    public static String a(boolean flag)
    {
        Object obj;
        if (flag)
        {
            obj = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
            String s = (new StringBuilder()).append(((String) (obj))).append("/Camera/").toString();
            File file = new File(s);
            obj = s;
            if (!file.exists())
            {
                file.mkdirs();
                obj = s;
            }
        } else
        {
            obj = InstaBeautyApplication.a;
            Object obj1 = InstaBeautyApplication.a;
            obj1 = ((Context) (obj)).getDir("InstaBeauty", 1).getAbsolutePath();
            File file1 = new File(((String) (obj1)));
            obj = obj1;
            if (!file1.exists())
            {
                file1.mkdirs();
                return ((String) (obj1));
            }
        }
        return ((String) (obj));
    }

    public static void a(String s)
    {
        a = s;
        c.putString("storePath", a);
        c.commit();
    }

    public static void a(String s, Context context)
    {
        b(s, context);
        c(s, context);
        d(s, context);
    }

    private static void b(String s, Context context)
    {
        try
        {
            Log.e("savePhotoTool", "scanPhotos1");
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("_data", s);
            contentvalues.put("datetaken", Long.valueOf((new File(s)).lastModified()));
            context.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentvalues);
            context.getContentResolver().notifyChange(Uri.parse((new StringBuilder()).append("file://").append(s).toString()), null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
    }

    private static void c(String s, Context context)
    {
        try
        {
            Log.e("savePhotoTool", "scanPhotos2");
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(s)));
            context.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
    }

    private static void d(String s, Context context)
    {
        try
        {
            Log.e("savePhotoTool", "scanPhotos3");
            sn sn1 = new sn();
            MediaScannerConnection.scanFile(context, new String[] {
                s
            }, null, sn1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
    }

    static 
    {
        b = InstaBeautyApplication.a().getSharedPreferences("acquirePath", 0);
        c = b.edit();
    }
}
