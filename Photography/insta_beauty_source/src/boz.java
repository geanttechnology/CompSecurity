// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;

public class boz
{

    public static void a(String s, String s1, boolean flag)
    {
        s = new FileWriter(s, flag);
        s.write(s1);
        s.flush();
        s.close();
    }

    public static void a(String s, boolean flag)
    {
        try
        {
            c(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        (new File(s.toString())).delete();
    }

    public static boolean a(Bitmap bitmap, String s)
    {
        try
        {
            new File(s);
            s = new FileOutputStream(s);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, s);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return false;
        }
        return true;
    }

    public static byte[] a(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                byte abyte1[] = bytearrayoutputstream.toByteArray();
                inputstream.close();
                bytearrayoutputstream.close();
                return abyte1;
            }
        } while (true);
    }

    public static byte[] a(String s)
    {
        return a(((InputStream) (new FileInputStream(new File(s)))));
    }

    public static String b(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                bytearrayoutputstream.close();
                inputstream.close();
                return bytearrayoutputstream.toString();
            }
        } while (true);
    }

    public static String b(String s)
    {
        s = new FileReader(s);
        BufferedReader bufferedreader = new BufferedReader(s);
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            String s1 = bufferedreader.readLine();
            if (s1 != null)
            {
                stringbuffer.append(s1);
            } else
            {
                bufferedreader.close();
                s.close();
                return stringbuffer.toString();
            }
        } while (true);
    }

    public static boolean c(String s)
    {
        File file;
        for (file = new File(s); !file.exists() || !file.isDirectory();)
        {
            return false;
        }

        String as[] = file.list();
        int i = 0;
        boolean flag = false;
        while (i < as.length) 
        {
            File file1;
            if (s.endsWith(File.separator))
            {
                file1 = new File((new StringBuilder()).append(s).append(as[i]).toString());
            } else
            {
                file1 = new File((new StringBuilder()).append(s).append(File.separator).append(as[i]).toString());
            }
            if (file1.isFile())
            {
                file1.delete();
            } else
            if (file1.isDirectory())
            {
                c((new StringBuilder()).append(s).append(File.separator).append(as[i]).toString());
                a((new StringBuilder()).append(s).append(File.separator).append(as[i]).toString(), true);
                flag = true;
            }
            i++;
        }
        return flag;
    }

    public static boolean d(String s)
    {
label0:
        {
            boolean flag;
            try
            {
                s = new File(s);
                if (s.exists())
                {
                    break label0;
                }
                flag = s.mkdirs();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            return flag;
        }
        return true;
    }
}
