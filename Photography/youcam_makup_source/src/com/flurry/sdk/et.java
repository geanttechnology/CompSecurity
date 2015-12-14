// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// Referenced classes of package com.flurry.sdk:
//            ex, fh

public final class et
{

    private static String a = com/flurry/sdk/et.getSimpleName();

    public et()
    {
    }

    public static void a(File file, String s)
    {
        if (file == null)
        {
            ex.a(4, a, "No persistent file specified.");
            return;
        }
        if (s == null)
        {
            ex.a(4, a, (new StringBuilder()).append("No data specified; deleting persistent file: ").append(file.getAbsolutePath()).toString());
            file.delete();
            return;
        }
        ex.a(4, a, (new StringBuilder()).append("Writing persistent data: ").append(file.getAbsolutePath()).toString());
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        file = fileoutputstream;
        fileoutputstream.write(s.getBytes());
        fh.a(fileoutputstream);
        return;
        Throwable throwable;
        throwable;
        s = null;
_L4:
        file = s;
        ex.a(6, a, "Error writing persistent file", throwable);
        fh.a(s);
        return;
        s;
        file = null;
_L2:
        fh.a(file);
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        throwable;
        s = fileoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean a(File file)
    {
        while (file == null || file.getAbsoluteFile() == null) 
        {
            return false;
        }
        file = file.getParentFile();
        if (file == null)
        {
            return true;
        }
        if (!file.mkdirs() && !file.isDirectory())
        {
            ex.a(6, a, (new StringBuilder()).append("Unable to create persistent dir: ").append(file).toString());
            return false;
        } else
        {
            return true;
        }
    }

    public static String b(File file)
    {
        if (file != null && file.exists()) goto _L2; else goto _L1
_L1:
        ex.a(4, a, "Persistent file doesn't exist.");
_L5:
        return null;
_L2:
        ex.a(4, a, (new StringBuilder()).append("Loading persistent data: ").append(file.getAbsolutePath()).toString());
        Object obj = new FileInputStream(file);
        file = ((File) (obj));
        Object obj1 = new StringBuilder();
        file = ((File) (obj));
        byte abyte0[] = new byte[1024];
_L4:
        file = ((File) (obj));
        int i = ((FileInputStream) (obj)).read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        file = ((File) (obj));
        ((StringBuilder) (obj1)).append(new String(abyte0, 0, i));
        if (true) goto _L4; else goto _L3
        obj1;
_L9:
        file = ((File) (obj));
        ex.a(6, a, "Error when loading persistent file", ((Throwable) (obj1)));
        fh.a(((java.io.Closeable) (obj)));
        file = null;
_L6:
        if (file != null)
        {
            return file.toString();
        }
          goto _L5
_L3:
        fh.a(((java.io.Closeable) (obj)));
        file = ((File) (obj1));
          goto _L6
        file;
        obj1 = null;
        obj = file;
_L8:
        fh.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        obj1 = file;
        if (true) goto _L8; else goto _L7
_L7:
        obj1;
        obj = null;
          goto _L9
    }

}
