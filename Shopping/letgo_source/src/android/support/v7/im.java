// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;

// Referenced classes of package android.support.v7:
//            aqo

public class im
{

    public static String a(Context context, Uri uri)
    {
        Object obj;
        obj = null;
        String s = null;
        aqo.a("ImageFileUtils File -", new Object[] {
            (new StringBuilder()).append("Authority: ").append(uri.getAuthority()).append(", Fragment: ").append(uri.getFragment()).append(", Port: ").append(uri.getPort()).append(", Query: ").append(uri.getQuery()).append(", Scheme: ").append(uri.getScheme()).append(", Host: ").append(uri.getHost()).append(", Segments: ").append(uri.getPathSegments().toString()).toString()
        });
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
        if (e(uri))
        {
            if (d(uri))
            {
                return uri.getLastPathSegment();
            } else
            {
                return a(context, uri, null, null);
            }
        }
        if (f(uri))
        {
            return uri.getPath();
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

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

    public static boolean a(Uri uri)
    {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean a(Uri uri, Context context)
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        while (flag && DocumentsContract.isDocumentUri(context, uri) && b(uri) || f(uri) || e(uri) && d(uri)) 
        {
            return true;
        }
        return false;
    }

    public static boolean b(Uri uri)
    {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean c(Uri uri)
    {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean d(Uri uri)
    {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static boolean e(Uri uri)
    {
        return "content".equalsIgnoreCase(uri.getScheme());
    }

    private static boolean f(Uri uri)
    {
        return "file".equalsIgnoreCase(uri.getScheme());
    }
}
