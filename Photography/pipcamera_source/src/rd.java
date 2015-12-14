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
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class rd
{

    private static SharedPreferences a;
    private static android.content.SharedPreferences.Editor b;

    public static File a(Bitmap bitmap)
    {
        boolean flag;
        flag = false;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        Log.v("savePhotoTool", (new StringBuilder()).append("savePhotoToolbHaveSdcard :").append(flag).toString());
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
        String s = (new StringBuilder()).append(((String) (obj))).append("/Camera/").toString();
        File file = new File(s);
        obj = s;
        if (!file.exists())
        {
            file.mkdirs();
            obj = s;
        }
_L4:
        Object obj1;
        obj1 = new File(((String) (obj)), (new StringBuilder()).append("img").append(System.currentTimeMillis()).append(".jpg").toString());
        Log.v("savePhotoTool", (new StringBuilder()).append("savePhotoToolmediaStorageDir :").append(obj1).toString());
        obj = new FileOutputStream(((File) (obj1)));
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj)));
        ((FileOutputStream) (obj)).flush();
        ((FileOutputStream) (obj)).close();
        return ((File) (obj1));
_L2:
        obj = PIPCameraApplication.a;
        obj1 = PIPCameraApplication.a;
        obj1 = ((Context) (obj)).getDir("PIPCamera", 1).getAbsolutePath();
        File file1 = new File(((String) (obj1)));
        obj = obj1;
        if (!file1.exists())
        {
            file1.mkdirs();
            obj = obj1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        bitmap;
        obj = null;
_L6:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
                Crashlytics.logException(ioexception);
            }
        }
        Crashlytics.logException(bitmap);
        return ((File) (obj1));
        bitmap;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static File a(String s)
    {
        File file = new File(a(), (new StringBuilder()).append("img").append(System.currentTimeMillis()).append(".jpg").toString());
        Log.v("savePhotoTool", (new StringBuilder()).append("savePhotoToolmediaStorageDir :").append(file).toString());
        boolean flag;
        try
        {
            flag = a(s, file.getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return null;
        }
        if (!flag)
        {
            return null;
        } else
        {
            return file;
        }
    }

    public static String a()
    {
        boolean flag = false;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        Log.v("savePhotoTool", (new StringBuilder()).append("savePhotoToolbHaveSdcard :").append(flag).toString());
        String s = a.getString("storePath", null);
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
            obj = PIPCameraApplication.a;
            Object obj1 = PIPCameraApplication.a;
            obj1 = ((Context) (obj)).getDir("FotoRus", 1).getAbsolutePath();
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

    public static void a(String s, Context context)
    {
        b(s, context);
        c(s, context);
        d(s, context);
    }

    public static boolean a(String s, String s1)
    {
        byte abyte0[];
        if (!(new File(s)).exists())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        s = new FileInputStream(s);
        s1 = new FileOutputStream(s1);
        abyte0 = new byte[1444];
        int i = 0;
_L1:
        int j = s.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        i += j;
        System.out.println(i);
        s1.write(abyte0, 0, j);
          goto _L1
        s;
        System.out.println("\u590D\u5236\u5355\u4E2A\u6587\u4EF6\u64CD\u4F5C\u51FA\u9519");
        s.printStackTrace();
        return false;
        s.close();
        return true;
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
            android.media.MediaScannerConnection.OnScanCompletedListener onscancompletedlistener = new android.media.MediaScannerConnection.OnScanCompletedListener() {

                public void onScanCompleted(String s1, Uri uri)
                {
                }

            };
            MediaScannerConnection.scanFile(context, new String[] {
                s
            }, null, onscancompletedlistener);
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
        a = PIPCameraApplication.b().getSharedPreferences("acquirePath", 0);
        b = a.edit();
    }
}
