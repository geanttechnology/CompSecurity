// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.perfectcorp.utility:
//            e, ImageUtils, j, i

public class h
{

    public static Uri a(Uri uri)
    {
        Uri uri1;
        if (uri == null)
        {
            uri1 = null;
        } else
        {
            String s = uri.getScheme();
            uri1 = uri;
            if (s != null)
            {
                uri1 = uri;
                if (s.equals("file"))
                {
                    return Uri.parse((new StringBuilder()).append("file://").append(uri.getPath()).toString());
                }
            }
        }
        return uri1;
    }

    public static String a(Context context)
    {
        if (context == null)
        {
            return "";
        } else
        {
            context = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            String s = (new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US)).format(new Date());
            return (new StringBuilder()).append(context).append(File.separator).append("BC_").append(s).append(".jpg").toString();
        }
    }

    public static String a(Context context, Uri uri)
    {
        return a(context, uri, true);
    }

    public static String a(Context context, Uri uri, boolean flag)
    {
        Object obj;
        Object obj3;
        Object obj4;
        Context context1;
        Object obj7;
        Object obj8;
        context1 = null;
        obj8 = null;
        obj3 = null;
        obj4 = null;
        obj7 = null;
        if (context == null)
        {
            return null;
        }
        obj = uri.getScheme();
        if (obj != null) goto _L2; else goto _L1
_L1:
        e.e(new Object[] {
            "No Scheme: ", uri
        });
        obj = null;
_L22:
        return ((String) (obj));
_L2:
        if (((String) (obj)).equals("file"))
        {
            obj = uri.getPath();
            continue; /* Loop/switch isn't completed */
        }
        if (!((String) (obj)).equals("content"))
        {
            break MISSING_BLOCK_LABEL_1019;
        }
        if (!b(context, uri)) goto _L4; else goto _L3
_L3:
        Object obj1;
        Object obj2;
        Object obj6;
        obj6 = b(uri).split(":")[1];
        obj = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        obj1 = (new StringBuilder()).append("_id=? AND ").append("mime_type IN (?, ?)").toString();
        obj2 = new String[3];
        obj2[0] = ((String) (obj6));
        obj2[1] = "image/jpeg";
        obj2[2] = "image/png";
_L10:
        obj = context.getContentResolver().query(((Uri) (obj)), new String[] {
            "_data"
        }, ((String) (obj1)), ((String []) (obj2)), null);
        obj1 = obj;
        int i = ((Cursor) (obj)).getColumnIndexOrThrow("_data");
        obj1 = obj;
        ((Cursor) (obj)).moveToFirst();
        obj1 = obj;
        obj2 = ((Cursor) (obj)).getString(i);
        obj1 = obj2;
        obj2 = obj1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            obj2 = obj1;
        }
_L11:
        if (obj2 != null)
        {
            obj = obj2;
            if (!((String) (obj2)).isEmpty())
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = obj2;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = context.getContentResolver().openInputStream(uri);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_1008;
        }
        uri = context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor();
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_1008;
        }
        uri = new FileInputStream(uri);
_L20:
        if (uri == null) goto _L6; else goto _L5
_L5:
        String s;
        s = ImageUtils.a(context, null);
        context = new FileOutputStream(s);
        obj1 = new BufferedInputStream(uri);
        obj6 = obj1;
        context1 = context;
        obj3 = uri;
        obj = new BufferedOutputStream(context);
        obj3 = new byte[2048];
_L9:
        i = ((BufferedInputStream) (obj1)).read(((byte []) (obj3)));
        if (i <= 0) goto _L8; else goto _L7
_L7:
        ((BufferedOutputStream) (obj)).write(((byte []) (obj3)), 0, i);
          goto _L9
        obj4;
        obj3 = obj;
        obj = uri;
        uri = context;
        context = ((Context) (obj1));
        obj1 = obj4;
_L16:
        ((FileNotFoundException) (obj1)).printStackTrace();
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                obj = obj2;
                continue; /* Loop/switch isn't completed */
            }
        }
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        uri.close();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        context.close();
        obj = obj2;
        if (obj3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((BufferedOutputStream) (obj3)).close();
        obj = obj2;
        continue; /* Loop/switch isn't completed */
_L4:
        obj2 = null;
        obj1 = null;
        obj = uri;
          goto _L10
        obj2;
        obj = null;
_L18:
        obj1 = obj;
        ((Exception) (obj2)).printStackTrace();
        FileNotFoundException filenotfoundexception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            obj2 = null;
        } else
        {
            obj2 = null;
        }
          goto _L11
        context;
        uri = context1;
_L17:
        if (uri != null)
        {
            uri.close();
        }
        throw context;
_L8:
        uri.close();
        ((BufferedOutputStream) (obj)).close();
        context.close();
        obj2 = s;
        obj3 = context;
        context = ((Context) (obj));
_L19:
        if (uri != null)
        {
            try
            {
                uri.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                obj = obj2;
                continue; /* Loop/switch isn't completed */
            }
        }
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        ((OutputStream) (obj3)).close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_554;
        }
        ((BufferedInputStream) (obj1)).close();
        obj = obj2;
        if (context == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context.close();
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = null;
        context = null;
        uri = null;
        obj7 = obj8;
_L15:
        obj6 = obj1;
        context1 = context;
        obj3 = uri;
        obj4 = obj7;
        ((IOException) (obj)).printStackTrace();
        if (uri != null)
        {
            try
            {
                uri.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                obj = obj2;
                continue; /* Loop/switch isn't completed */
            }
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_628;
        }
        context.close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_638;
        }
        ((BufferedInputStream) (obj1)).close();
        obj = obj2;
        if (obj7 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((BufferedOutputStream) (obj7)).close();
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = null;
        context = null;
        uri = null;
        obj2 = obj3;
_L13:
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_688;
        }
        uri.close();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_696;
        }
        context.close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_706;
        }
        ((BufferedInputStream) (obj1)).close();
        if (obj2 != null)
        {
            try
            {
                ((BufferedOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
        }
        throw obj;
        obj2;
        obj1 = null;
        context = null;
        uri = ((Uri) (obj));
        obj = obj2;
        obj2 = obj3;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = null;
        context = null;
        obj2 = obj3;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = null;
        obj2 = obj3;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = obj6;
        context = context1;
        uri = ((Uri) (obj3));
        obj2 = obj4;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj2 = obj;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj2 = obj;
        obj = obj1;
        obj1 = context;
        context = uri;
        uri = ((Uri) (obj2));
        obj2 = obj3;
        if (true) goto _L13; else goto _L12
_L12:
        obj3;
        obj1 = null;
        context = null;
        uri = ((Uri) (obj));
        obj = obj3;
        obj7 = obj8;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = null;
        context = null;
        obj7 = obj8;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = null;
        obj7 = obj8;
        continue; /* Loop/switch isn't completed */
        obj;
        obj7 = obj8;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj7 = obj;
        obj = obj3;
        if (true) goto _L15; else goto _L14
_L14:
        obj1;
        context = null;
        uri = null;
        obj = null;
        obj3 = obj7;
          goto _L16
        obj1;
        uri = null;
        context = null;
        obj3 = obj7;
          goto _L16
        obj1;
        context = null;
        obj3 = null;
        obj = uri;
        uri = ((Uri) (obj3));
        obj3 = obj7;
          goto _L16
        obj1;
        Object obj5 = null;
        obj = context;
        obj3 = uri;
        context = obj5;
        uri = ((Uri) (obj));
        obj = obj3;
        obj3 = obj7;
          goto _L16
        filenotfoundexception;
        obj = obj1;
        obj3 = context;
        Uri uri1 = uri;
        obj1 = filenotfoundexception;
        context = ((Context) (obj));
        uri = ((Uri) (obj3));
        obj = uri1;
        obj3 = obj7;
          goto _L16
        context;
        uri = ((Uri) (obj1));
          goto _L17
        obj2;
          goto _L18
_L6:
        context = null;
        obj1 = null;
        obj3 = null;
          goto _L19
        uri = ((Uri) (obj));
          goto _L20
        obj = null;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public static String a(String s)
    {
        String s1 = s;
        if (s.indexOf("assets://") == 0)
        {
            s1 = s.substring("assets://".length());
        }
        return s1;
    }

    public static transient String a(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(File.separator);
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static void a(byte abyte0[], String s)
    {
        try
        {
            s = new FileOutputStream(s);
            s.write(abyte0);
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
    }

    public static j b(Context context)
    {
        return new j(context) {

            final Context a;

            protected volatile Object a(Object obj)
            {
                return a((i)obj);
            }

            protected String a(i k)
            {
                File file = new File(k.b);
                if (!file.isDirectory())
                {
                    file.mkdirs();
                }
                if (!k.a.startsWith("assets://")) goto _L2; else goto _L1
_L1:
                Object obj = a.getAssets().open(h.a(k.a));
_L6:
                byte abyte0[];
                obj = new ZipInputStream(((InputStream) (obj)));
                abyte0 = new byte[1024];
_L5:
                Object obj1 = ((ZipInputStream) (obj)).getNextEntry();
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_318;
                }
                String s;
                e.a(new Object[] {
                    ((ZipEntry) (obj1)).getName()
                });
                s = h.a(new String[] {
                    k.b, ((ZipEntry) (obj1)).getName()
                });
                if (!((ZipEntry) (obj1)).isDirectory()) goto _L4; else goto _L3
_L3:
                obj1 = new File(s);
                if (!((File) (obj1)).isDirectory())
                {
                    ((File) (obj1)).mkdirs();
                }
                  goto _L5
                try
                {
                    ((ZipInputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    e.e(new Object[] {
                        obj
                    });
                }
                return k.b;
_L2:
                obj = new FileInputStream(k.a);
                  goto _L6
_L4:
                l = s.lastIndexOf(File.separatorChar);
                obj2 = s.substring(0, l);
                s = s.substring(l);
                obj2 = new File(((String) (obj2)));
                ((File) (obj2)).mkdirs();
                l1 = ((ZipEntry) (obj1)).getSize();
                obj1 = new FileOutputStream(new File(((File) (obj2)), s));
_L8:
                if (l1 <= 0L)
                {
                    break; /* Loop/switch isn't completed */
                }
                l = ((ZipInputStream) (obj)).read(abyte0, 0, (int)Math.min(l1, abyte0.length));
                ((FileOutputStream) (obj1)).write(abyte0, 0, l);
                l1 -= l;
                if (true) goto _L8; else goto _L7
_L7:
                ((ZipInputStream) (obj)).closeEntry();
                ((FileOutputStream) (obj1)).close();
                  goto _L5
            }

            
            {
                a = context;
                super();
            }
        };
    }

    private static String b(Uri uri)
    {
        List list = uri.getPathSegments();
        if (list.size() < 2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Not a document: ").append(uri).toString());
        }
        if (!"document".equals(list.get(0)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Not a document: ").append(uri).toString());
        } else
        {
            return (String)list.get(1);
        }
    }

    private static boolean b(Context context, Uri uri)
    {
        List list = uri.getPathSegments();
        if (list.size() < 2)
        {
            return false;
        }
        if (!"document".equals(list.get(0)))
        {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            Intent intent = new Intent("android.content.action.DOCUMENTS_PROVIDER");
            for (context = context.getPackageManager().queryIntentContentProviders(intent, 0).iterator(); context.hasNext();)
            {
                ResolveInfo resolveinfo = (ResolveInfo)context.next();
                if (uri.getAuthority().equals(resolveinfo.providerInfo.authority))
                {
                    return true;
                }
            }

            return false;
        } else
        {
            return uri.toString().contains("content://");
        }
    }

    public static String[] b(String s)
    {
        if (s == null)
        {
            return null;
        }
        int i = s.lastIndexOf(".");
        String s1;
        if (i > 0)
        {
            s1 = s.substring(0, i);
        } else
        {
            s1 = s;
        }
        if (i > 0)
        {
            s = s.substring(i + 1);
        } else
        {
            s = "";
        }
        return (new String[] {
            s1, s
        });
    }

    public static String c(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        s = new BufferedReader(new InputStreamReader(new FileInputStream(s), "UTF-8"));
_L3:
        String s1 = s.readLine();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append(s1);
          goto _L3
_L5:
        return stringbuilder.toString();
_L2:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static FileFilter d(String s)
    {
        return new FileFilter(s) {

            final String a;

            public boolean accept(File file)
            {
                return file.getPath().contains(a);
            }

            
            {
                a = s;
                super();
            }
        };
    }
}
