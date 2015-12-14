// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.net;

import com.socialin.android.util.FileUtils;
import com.socialin.android.util.an;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class d extends an
{

    private final String a = com/socialin/android/net/d.getSimpleName();

    public d()
    {
    }

    public transient Integer a(String as[])
    {
        int i = -1;
        if (!FileUtils.a()) goto _L2; else goto _L1
_L1:
        String s1;
        File file;
        File file1;
        String s = as[1];
        s1 = (new StringBuilder()).append(s).append(hashCode()).toString();
        file = new File(s1);
        file1 = new File(s);
        if (!file1.exists()) goto _L4; else goto _L3
_L3:
        Object obj = Integer.valueOf(1);
_L16:
        return ((Integer) (obj));
_L4:
        Object obj2;
        byte abyte0[];
        abyte0 = null;
        obj = null;
        obj2 = null;
        as = (HttpURLConnection)(new URL(as[0])).openConnection();
        as.setReadTimeout(20000);
        as.setConnectTimeout(20000);
        as.setRequestMethod("GET");
        as.setRequestProperty("Content-Type", "application/octet-stream");
        as.connect();
        as.setReadTimeout(20000);
        as.setConnectTimeout(20000);
        obj = new BufferedInputStream(as.getInputStream());
        if (!FileUtils.a()) goto _L6; else goto _L5
_L5:
        file.getParentFile().mkdirs();
        obj2 = new FileOutputStream(file);
        abyte0 = new byte[4096];
_L12:
        int j = ((InputStream) (obj)).read(abyte0);
        if (j == -1) goto _L8; else goto _L7
_L7:
        if (!isCancelled()) goto _L10; else goto _L9
_L9:
        ((OutputStream) (obj2)).flush();
        ((OutputStream) (obj2)).close();
        ((InputStream) (obj)).close();
        FileUtils.c(s1);
_L11:
        Object obj1;
        if (as != null)
        {
            try
            {
                as.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                });
            }
        }
        return Integer.valueOf(-1);
        obj;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L11
        obj1;
_L21:
        obj = as;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((MalformedURLException) (obj1)).getMessage()).toString()
        });
        if (as != null)
        {
            try
            {
                as.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                });
            }
        }
        return Integer.valueOf(-1);
_L10:
        ((OutputStream) (obj2)).write(abyte0, 0, j);
          goto _L12
        obj1;
_L20:
        obj = as;
        j = as.getResponseCode();
        i = j;
_L17:
        obj = as;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
        });
        if (i != 200) goto _L14; else goto _L13
_L13:
        obj1 = Integer.valueOf(-2);
        obj = obj1;
        if (as == null) goto _L16; else goto _L15
_L15:
        try
        {
            as.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
            });
            return ((Integer) (obj1));
        }
        return ((Integer) (obj1));
_L8:
        ((OutputStream) (obj2)).flush();
        ((OutputStream) (obj2)).close();
        ((InputStream) (obj)).close();
        try
        {
            file.renameTo(file1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (as != null)
            {
                try
                {
                    as.disconnect();
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    com.socialin.android.d.b(a, new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                    });
                }
            }
            return Integer.valueOf(-1);
        }
        if (as != null)
        {
            try
            {
                as.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                });
            }
        }
        return Integer.valueOf(1);
_L6:
        if (as != null)
        {
            try
            {
                as.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                });
            }
        }
        return Integer.valueOf(-2);
        obj2;
        obj = as;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj2)).getMessage()).toString()
        });
          goto _L17
        as;
_L19:
        if (obj != null)
        {
            try
            {
                ((HttpURLConnection) (obj)).disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
                });
            }
        }
        throw as;
_L14:
        obj1 = Integer.valueOf(-1);
        obj = obj1;
        if (as == null) goto _L16; else goto _L18
_L18:
        try
        {
            as.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
            });
            return ((Integer) (obj1));
        }
        return ((Integer) (obj1));
_L2:
        return Integer.valueOf(-2);
        obj1;
        obj = as;
        as = ((String []) (obj1));
          goto _L19
        obj1;
        as = abyte0;
          goto _L20
        obj1;
        as = ((String []) (obj2));
          goto _L21
    }

    public Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }
}
