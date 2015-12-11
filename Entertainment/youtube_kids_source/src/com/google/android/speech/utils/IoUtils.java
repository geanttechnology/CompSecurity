// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.utils;

import android.util.Log;
import emp;
import eyk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class IoUtils
{

    private static final String TAG = "IoUtils";

    public IoUtils()
    {
    }

    public static void addHttpHeaders(HttpURLConnection httpurlconnection, eyk eyk1)
    {
        for (int i = 0; i < eyk1.b.size(); i++)
        {
            httpurlconnection.addRequestProperty((String)eyk1.b.get(i), (String)eyk1.c.get(i));
        }

    }

    public static void closeQuietly(Socket socket)
    {
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        socket.close();
        return;
        socket;
    }

    public static boolean uncompress(File file, File file1)
    {
        Object obj;
        byte abyte0[];
        Object obj1;
        obj1 = null;
        abyte0 = null;
        IOException ioexception;
        int i;
        try
        {
            obj = new FileOutputStream(file1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = null;
            abyte0 = ((byte []) (obj1));
        }
        obj1 = new GZIPInputStream(new FileInputStream(file));
        abyte0 = new byte[1024];
_L3:
        i = ((InputStream) (obj1)).read(abyte0);
        if (i == -1) goto _L2; else goto _L1
_L1:
        ((OutputStream) (obj)).write(abyte0, 0, i);
          goto _L3
        ioexception;
        abyte0 = ((byte []) (obj));
        obj = obj1;
        obj1 = ioexception;
_L7:
        Log.e("IoUtils", (new StringBuilder("Failed to uncompress ")).append(file).append(" into ").append(file1).toString(), ((Throwable) (obj1)));
        emp.a(abyte0);
        emp.a(((java.io.Closeable) (obj)));
        return false;
_L2:
        emp.a(((java.io.Closeable) (obj)));
        emp.a(((java.io.Closeable) (obj1)));
        return true;
_L5:
        emp.a(abyte0);
        emp.a(((java.io.Closeable) (obj)));
        throw file;
        file;
        file1 = null;
        abyte0 = ((byte []) (obj));
        obj = file1;
        continue; /* Loop/switch isn't completed */
        file;
        abyte0 = ((byte []) (obj));
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        file;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
        Object obj2 = null;
        abyte0 = ((byte []) (obj));
        obj = obj2;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
