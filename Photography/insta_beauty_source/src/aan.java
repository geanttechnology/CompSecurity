// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.HashMap;

public class aan
{

    public static String a(Context context, Uri uri, String s, String as[])
    {
        Object obj = null;
        uri = context.getContentResolver().query(uri, new String[] {
            "_data"
        }, s, as, null);
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (!uri.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_64;
        }
        context = uri.getString(uri.getColumnIndexOrThrow("_data"));
        if (uri != null)
        {
            uri.close();
        }
        return context;
        if (uri != null)
        {
            uri.close();
        }
        return null;
        context;
        uri = obj;
_L2:
        if (uri != null)
        {
            uri.close();
        }
        throw context;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static HashMap a(Context context, Uri uri)
    {
        return a(b(context, uri));
    }

    public static HashMap a(String s)
    {
        double d1;
        HashMap hashmap;
        d1 = 0.0D;
        hashmap = new HashMap();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() <= 0) goto _L2; else goto _L3
_L3:
        String s1;
        String s2;
        String s3;
        String s4;
        Object obj;
        obj = new ExifInterface(s);
        s = ((ExifInterface) (obj)).getAttribute("Model");
        s1 = ((ExifInterface) (obj)).getAttribute("ImageWidth");
        s2 = ((ExifInterface) (obj)).getAttribute("ImageLength");
        s3 = ((ExifInterface) (obj)).getAttribute("GPSLatitude");
        s4 = ((ExifInterface) (obj)).getAttribute("GPSLongitude");
        obj = ((ExifInterface) (obj)).getAttribute("DateTime");
        if (s3 == null || s4 == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        double d2;
        d2 = b(s3);
        d1 = b(s4);
_L4:
        hashmap.put("TAG_IMAGE_WIDTH", s1);
        hashmap.put("TAG_IMAGE_LENGTH", s2);
        hashmap.put("TAG_MODEL", s);
        hashmap.put("TAG_GPS_LATITUDE", Double.toString(d2));
        hashmap.put("TAG_GPS_LONGITUDE", Double.toString(d1));
        hashmap.put("TAG_DATETIME", obj);
_L2:
        return hashmap;
        s;
        s.printStackTrace();
        return hashmap;
        d2 = 0.0D;
          goto _L4
    }

    public static boolean a(Uri uri)
    {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static double b(String s)
    {
        float f;
        float f1;
        float f2;
        int i;
        int j;
        try
        {
            s = s.split(",");
            String as[] = s[0].split("/");
            i = (int)(Float.parseFloat(as[0].trim()) / Float.parseFloat(as[1].trim()));
            as = s[1].split("/");
            j = (int)(Float.parseFloat(as[0].trim()) / Float.parseFloat(as[1].trim()));
            s = s[2].split("/");
            f = Float.parseFloat(s[0].trim());
            f1 = Float.parseFloat(s[1].trim());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return 0.0D;
        }
        f /= f1;
        f1 = i;
        f2 = (float)j / 60F;
        return (double)(f / 3600F + (f1 + f2));
    }

    public static String b(Context context, Uri uri)
    {
        Object obj;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = null;
        if (uri != null)
        {
            if (flag)
            {
                obj = c(context, uri);
                Log.v("ExifManager", (new StringBuilder()).append("ExifManager fileName:").append(((String) (obj))).toString());
            } else
            {
                context = d(context, uri);
                obj = context;
                if (uri.getScheme().toString().compareTo("content") != 0)
                {
                    obj = context;
                    if (uri.getScheme().compareTo("file") == 0)
                    {
                        uri.toString();
                        return uri.toString().replace("file://", "");
                    }
                }
            }
        }
        return ((String) (obj));
    }

    public static boolean b(Uri uri)
    {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static String c(Context context, Uri uri)
    {
        Object obj;
        obj = null;
        String s = null;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || !DocumentsContract.isDocumentUri(context, uri)) goto _L2; else goto _L1
_L1:
        if (!a(uri)) goto _L4; else goto _L3
_L3:
        context = DocumentsContract.getDocumentId(uri).split(":");
        if ("primary".equalsIgnoreCase(context[0]))
        {
            s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(context[1]).toString();
        }
_L9:
        return s;
_L4:
        String as[];
        String s1;
        if (b(uri))
        {
            uri = DocumentsContract.getDocumentId(uri);
            return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(uri).longValue()), null, null);
        }
        if (!c(uri))
        {
            continue; /* Loop/switch isn't completed */
        }
        as = DocumentsContract.getDocumentId(uri).split(":");
        s1 = as[0];
        if (!"image".equals(s1)) goto _L6; else goto _L5
_L5:
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
_L7:
        return a(context, uri, "_id=?", new String[] {
            as[1]
        });
_L6:
        if ("video".equals(s1))
        {
            uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else
        {
            uri = obj;
            if ("audio".equals(s1))
            {
                uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
        }
        if (true) goto _L7; else goto _L2
_L2:
        if ("content".equalsIgnoreCase(uri.getScheme()))
        {
            return a(context, uri, null, null);
        }
        if ("file".equalsIgnoreCase(uri.getScheme()))
        {
            return uri.getPath();
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static boolean c(Uri uri)
    {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static String d(Context context, Uri uri)
    {
        Object obj = null;
        String s = obj;
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            context = context.getContentResolver().query(uri, new String[] {
                "_data"
            }, null, null, null);
            s = obj;
            if (context != null)
            {
                int i = context.getColumnIndexOrThrow("_data");
                context.moveToFirst();
                s = context.getString(i);
            }
        }
        return s;
    }
}
