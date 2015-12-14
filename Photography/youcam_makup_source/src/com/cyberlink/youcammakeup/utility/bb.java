// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bb
{

    private static final String a = com/cyberlink/youcammakeup/utility/bb.getSimpleName();

    public bb()
    {
    }

    public static File a(String s)
    {
        s = new File(s);
        if (s.exists())
        {
            if (s.isDirectory());
        } else
        if (!s.mkdirs())
        {
            return null;
        }
        return s;
    }

    public static void a(File file)
    {
        file = new File(file, ".nomedia");
        try
        {
            if (!file.exists())
            {
                file.createNewFile();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
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

    public static void b(File file)
    {
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                for (int i = 0; i < j; i++)
                {
                    b(afile[i]);
                }

            }
        }
        if (file.delete());
    }

    public static String[] b(String s)
    {
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

}
