// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

// Referenced classes of package u.aly:
//            bv

public class bu
{

    public static int a;

    public bu()
    {
    }

    public static String a(byte abyte0[], String s)
        throws UnsupportedEncodingException, DataFormatException
    {
        abyte0 = b(abyte0);
        if (abyte0 != null)
        {
            return new String(abyte0, s);
        } else
        {
            return null;
        }
    }

    public static byte[] a(String s, String s1)
        throws IOException
    {
        if (bv.d(s))
        {
            return null;
        } else
        {
            return a(s.getBytes(s1));
        }
    }

    public static byte[] a(byte abyte0[])
        throws IOException
    {
        Deflater deflater;
        if (abyte0 == null || abyte0.length <= 0)
        {
            return null;
        }
        deflater = new Deflater();
        deflater.setInput(abyte0);
        deflater.finish();
        abyte0 = new byte[8192];
        a = 0;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
_L1:
        if (!deflater.finished())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        deflater.end();
        if (bytearrayoutputstream != null)
        {
            bytearrayoutputstream.close();
        }
        return bytearrayoutputstream.toByteArray();
        int i = deflater.deflate(abyte0);
        a += i;
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L1
        abyte0;
_L3:
        if (bytearrayoutputstream != null)
        {
            bytearrayoutputstream.close();
        }
        throw abyte0;
        abyte0;
        bytearrayoutputstream = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static byte[] b(byte abyte0[])
        throws UnsupportedEncodingException, DataFormatException
    {
        int i = 0;
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        }
        Inflater inflater = new Inflater();
        inflater.setInput(abyte0, 0, abyte0.length);
        abyte0 = new ByteArrayOutputStream();
        byte abyte1[] = new byte[1024];
        do
        {
            if (inflater.needsInput())
            {
                inflater.end();
                return abyte0.toByteArray();
            }
            int j = inflater.inflate(abyte1);
            abyte0.write(abyte1, i, j);
            i += j;
        } while (true);
    }
}
