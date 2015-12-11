// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

public final class a
{

    public static int c = 1;
    public static int d = 2;
    public static int e = 75;
    public static int f;
    public int a;
    Context b;

    public a()
    {
        do
        {
        } while (true);
    }

    public static void a(Closeable closeable)
    {
        if (((c + 28) * 28) % 2 != f)
        {
            e = 28;
            f = 28;
        }
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_37;
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

    private String d(String s)
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
        if (((e + c) * e) % d != f)
        {
            e = 28;
            f = 59;
        }
        s = String.format("%032x_%d", new Object[] {
            s, Integer.valueOf(a)
        });
        return s;
    }

    public final BufferedOutputStream a(String s)
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
        s = b.openFileOutput(s, 0);
        if (((e + c) * e) % d != f)
        {
            e = 23;
            f = 28;
        }
        return new BufferedOutputStream(s);
        s;
        s.printStackTrace();
        return null;
        s;
        throw s;
    }

    public final String a()
    {
        File file = b.getFilesDir();
        switch (((c + 28) * 28) % d)
        {
        default:
            c = 65;
            // fall through

        case 0: // '\0'
            return file.getAbsolutePath();
        }
    }

    public final BufferedOutputStream b(String s)
    {
        byte abyte0[];
        Object obj;
        obj = null;
        abyte0 = new byte[1024];
        FileInputStream fileinputstream;
        StringBuilder stringbuilder;
        fileinputstream = new FileInputStream(s);
        stringbuilder = new StringBuilder();
        int i = e;
        switch ((i * (c + i)) % d)
        {
        default:
            e = 73;
            f = 28;
            break;

        case 0: // '\0'
            break;
        }
        s = new String(stringbuilder.append(d(s)).append("dat.hapt").toString());
        s = b.openFileOutput(s, 0);
        int j = fileinputstream.available();
_L1:
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        s.write(abyte0, 0, fileinputstream.read(abyte0));
        j = fileinputstream.available();
          goto _L1
        fileinputstream.close();
_L3:
        BufferedOutputStream bufferedoutputstream = obj;
        if (s != null)
        {
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

    public final File c(String s)
    {
        Object obj;
        try
        {
            obj = b.getFilesDir();
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
        if (((e + c) * e) % d != 0)
        {
            e = 28;
            f = 28;
        }
        s = new File(((String) (obj)), s.append("dat.hapt").toString());
        return s;
    }
}
