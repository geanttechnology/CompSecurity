// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ym
{

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
}
