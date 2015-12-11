// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.e.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public final class a
{

    public static File a(Context context, String s)
    {
        s = System.mapLibraryName(s);
        return new File(context.getDir("lib", 0), s);
    }

    private static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    private static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[4096];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void b(Context context, String s)
    {
        Object obj;
        Object obj3;
        obj = null;
        obj3 = null;
        Object obj2 = context.getApplicationInfo();
        int i = 0;
_L5:
        if (i >= 5) goto _L2; else goto _L1
_L1:
        Object obj1 = new ZipFile(new File(((ApplicationInfo) (obj2)).sourceDir), 1);
_L18:
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        ((ZipFile) (obj1)).close();
_L12:
        return;
        obj1;
        i++;
          goto _L5
_L4:
        i = 0;
_L10:
        int j;
        j = i + 1;
        if (i >= 5)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (android.os.Build.VERSION.SDK_INT < 21) goto _L7; else goto _L6
_L6:
        String as[];
        int k;
        as = Build.SUPPORTED_ABIS;
        k = as.length;
        i = 0;
        obj = null;
_L9:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = as[i];
        obj2 = ((ZipFile) (obj1)).getEntry((new StringBuilder("lib/")).append(((String) (obj))).append("/").append(System.mapLibraryName(s)).toString());
        obj = obj2;
        if (obj2 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        obj = obj2;
        if (true) goto _L9; else goto _L8
_L7:
        obj = ((ZipFile) (obj1)).getEntry((new StringBuilder("lib/")).append(Build.CPU_ABI).append("/").append(System.mapLibraryName(s)).toString());
_L8:
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        File file;
        file = a(context, s);
        file.delete();
        boolean flag = file.createNewFile();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        i = j;
          goto _L10
        obj;
        i = j;
          goto _L10
        obj = ((ZipFile) (obj1)).getInputStream(((java.util.zip.ZipEntry) (obj)));
        obj2 = new FileOutputStream(file);
        a(((InputStream) (obj)), ((OutputStream) (obj2)));
        a(((Closeable) (obj)));
        a(((Closeable) (obj2)));
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
        if (obj1 == null) goto _L12; else goto _L11
_L11:
        try
        {
            ((ZipFile) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        obj;
        obj2 = null;
        obj = null;
_L17:
        a(((Closeable) (obj)));
        a(((Closeable) (obj2)));
        i = j;
          goto _L10
_L16:
        a(((Closeable) (obj)));
        a(((Closeable) (obj2)));
        i = j;
          goto _L10
_L15:
        a(((Closeable) (obj)));
        a(s);
        throw context;
        context;
        s = ((String) (obj1));
_L14:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw context;
        context;
        return;
        context;
        s = ((String) (obj));
        if (true) goto _L14; else goto _L13
_L13:
        context;
        s = obj3;
          goto _L15
        context;
        s = ((String) (obj2));
          goto _L15
        obj2;
        obj2 = null;
          goto _L16
        Object obj4;
        obj4;
          goto _L16
        obj2;
        obj2 = null;
          goto _L17
        obj4;
          goto _L17
_L2:
        obj1 = null;
          goto _L18
        IOException ioexception;
        ioexception;
        obj2 = null;
        ioexception = null;
          goto _L16
        context;
        ioexception = null;
        s = obj3;
          goto _L15
    }
}
