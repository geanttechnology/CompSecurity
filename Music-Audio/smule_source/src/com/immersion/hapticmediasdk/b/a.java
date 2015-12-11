// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;

import android.content.Context;
import android.os.Process;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class a
{

    public static int b = 1;
    public static int c = 2;
    public static int d = 75;
    public static int e;
    Context a;
    private int f;

    public a(Context context)
    {
        int i = 3;
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        continue label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        super();
        try
        {
            do
            {
                i /= 0;
            } while (true);
        }
        catch (Exception exception)
        {
            f = 0;
        }
        a = context;
        f = Process.myTid();
    }

    public static int b()
    {
        return 28;
    }

    public static int d()
    {
        return 0;
    }

    public static int e()
    {
        return 2;
    }

    public BufferedOutputStream a(String s)
    {
        try
        {
            s = (new StringBuilder()).append(d(s)).append("dat.hapt").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        s = a.openFileOutput(s, 0);
        if (((d + b) * d) % c != e)
        {
            d = 23;
            e = b();
        }
        return new BufferedOutputStream(s);
        s;
        s.printStackTrace();
        return null;
        s;
        throw s;
    }

    public String a()
    {
        File file = a.getFilesDir();
        int i = b();
        switch ((i * (b + i)) % c)
        {
        default:
            b = 65;
            // fall through

        case 0: // '\0'
            return file.getAbsolutePath();
        }
    }

    public void a(Closeable closeable)
    {
        if (((b() + b) * b()) % e() != e)
        {
            d = b();
            e = b();
        }
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        closeable.close();
        return;
        closeable;
        try
        {
            closeable.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            throw closeable;
        }
        closeable;
        throw closeable;
    }

    public BufferedOutputStream b(String s)
    {
        byte abyte0[];
        Object obj;
        obj = null;
        abyte0 = new byte[1024];
        FileInputStream fileinputstream;
        StringBuilder stringbuilder;
        fileinputstream = new FileInputStream(s);
        stringbuilder = new StringBuilder();
        int i = d;
        switch ((i * (b + i)) % c)
        {
        default:
            d = 73;
            e = b();
            break;

        case 0: // '\0'
            break;
        }
        s = new String(stringbuilder.append(d(s)).append("dat.hapt").toString());
        s = a.openFileOutput(s, 0);
        int j = fileinputstream.available();
_L1:
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        s.write(abyte0, 0, fileinputstream.read(abyte0));
        j = fileinputstream.available();
          goto _L1
        fileinputstream.close();
_L3:
        BufferedOutputStream bufferedoutputstream = obj;
        if (s != null)
        {
label0:
            do
            {
                switch (1)
                {
                default:
                    while (true) 
                    {
                        switch (0)
                        {
                        default:
                            break;

                        case 0: // '\0'
                            break label0;

                        case 1: // '\001'
                            continue label0;
                        }
                    }
                    break;

                case 0: // '\0'
                    break;

                case 1: // '\001'
                    break label0;
                }
            } while (true);
            bufferedoutputstream = new BufferedOutputStream(s);
        }
        return bufferedoutputstream;
        Exception exception;
        exception;
        s = null;
_L4:
        exception.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        exception;
          goto _L4
    }

    public File c(String s)
    {
        Object obj;
        try
        {
            obj = a.getFilesDir();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        try
        {
            obj = ((File) (obj)).getPath();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        s = (new StringBuilder()).append(d(s));
        if (((d + b) * d) % c != d())
        {
            d = b();
            e = b();
        }
        s = new File(((String) (obj)), s.append("dat.hapt").toString());
        return s;
    }

    public void c()
    {
        File afile[];
        File file;
        String s;
        StringBuilder stringbuilder;
        int i;
        int j;
        int k;
        boolean flag;
        try
        {
            afile = (new File(a())).listFiles();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (afile == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        i = b();
        switch ((i * (b + i)) % c)
        {
        default:
            b = 63;
            break;

        case 0: // '\0'
            break;
        }
        j = afile.length;
        i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        file = afile[i];
        s = file.getName();
        try
        {
            stringbuilder = new StringBuilder();
            k = f;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        flag = s.endsWith(stringbuilder.append(k).append("dat.hapt").toString());
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        file.delete();
        i++;
          goto _L3
_L2:
    }

    public String d(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.reset();
            messagedigest.update(s.getBytes(), 0, s.length());
            s = new BigInteger(1, messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                s.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
            return null;
        }
        if (((d + b) * d) % c != e)
        {
            d = b();
            e = 59;
        }
        s = String.format("%032x_%d", new Object[] {
            s, Integer.valueOf(f)
        });
        return s;
    }
}
