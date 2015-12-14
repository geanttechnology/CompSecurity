// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ik
{

    private static String a = "FotobeautyEngineResource";

    public static int a()
    {
        int i;
        try
        {
            i = (new File("/sys/devices/system/cpu/")).listFiles(new il()).length;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            return 1;
        }
        return i;
    }

    public static String a(Context context)
    {
        return aaj.a(context).getAbsolutePath();
    }

    public static String a(Context context, Uri uri)
    {
        Object obj = new File(uri.getPath());
        if (!((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        uri = ((File) (obj)).getAbsolutePath();
_L4:
        return uri;
_L2:
        context = context.getContentResolver().query(uri, new String[] {
            "_data"
        }, null, null, null);
        obj = context;
        int i = context.getColumnIndexOrThrow("_data");
        obj = context;
        context.moveToFirst();
        obj = context;
        String s = context.getString(i);
        obj = s;
        uri = ((Uri) (obj));
        if (context != null)
        {
            context.close();
            return ((String) (obj));
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        context = null;
_L8:
        obj = context;
        exception.printStackTrace();
        if (context != null)
        {
            context.close();
        }
        return uri.toString();
        context;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        context;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static int b()
    {
        int i;
        try
        {
            RandomAccessFile randomaccessfile = new RandomAccessFile("/proc/meminfo", "r");
            String s = randomaccessfile.readLine();
            randomaccessfile.close();
            i = Integer.parseInt(s.split(":")[1].split("k")[0].replace(" ", ""));
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return 1024;
        }
        return (int)((double)i / 1024D);
    }

}
