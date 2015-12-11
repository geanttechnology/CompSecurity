// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ni
{

    public static String a(InputStream inputstream)
    {
        byte abyte0[] = b(inputstream);
        inputstream.close();
        return new String(abyte0);
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0, 0, 1024);
            if (i == -1)
            {
                outputstream.flush();
                return;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
    }

    public static byte[] b(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        a(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }
}
