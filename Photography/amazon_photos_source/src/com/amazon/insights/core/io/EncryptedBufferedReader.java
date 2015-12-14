// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.apache.commons.codec.binary.Base64;

// Referenced classes of package com.amazon.insights.core.io:
//            DecryptionException

public class EncryptedBufferedReader extends BufferedReader
{

    private Cipher cipher;
    private final BufferedReader reader;

    public EncryptedBufferedReader(BufferedReader bufferedreader, SecretKey secretkey)
    {
        super(bufferedreader);
        reader = bufferedreader;
        try
        {
            cipher = Cipher.getInstance(secretkey.getAlgorithm());
            cipher.init(2, secretkey);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (BufferedReader bufferedreader)
        {
            cipher = null;
            throw new IllegalArgumentException(bufferedreader);
        }
        // Misplaced declaration of an exception variable
        catch (BufferedReader bufferedreader)
        {
            cipher = null;
            throw new IllegalArgumentException(bufferedreader);
        }
        // Misplaced declaration of an exception variable
        catch (BufferedReader bufferedreader)
        {
            cipher = null;
        }
        throw new IllegalArgumentException(bufferedreader);
    }

    public void close()
        throws IOException
    {
        reader.close();
    }

    public void mark(int i)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the mark(int) method");
    }

    public boolean markSupported()
    {
        return false;
    }

    public int read()
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the read() method");
    }

    public int read(CharBuffer charbuffer)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the read(CharBuffer) method");
    }

    public int read(char ac[])
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the read(char[]) method");
    }

    public int read(char ac[], int i, int j)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the read(char[],int,int) method");
    }

    public String readLine()
        throws IOException, DecryptionException
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        byte abyte0[];
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        Object obj22;
        Object obj23;
        Object obj24;
        Object obj25;
        if (cipher == null)
        {
            throw new IOException("Could not build a Cipher to decrpyt the underlying writer");
        }
        obj25 = null;
        obj19 = null;
        obj22 = null;
        obj21 = null;
        obj23 = null;
        obj = null;
        obj18 = null;
        obj8 = null;
        obj15 = null;
        obj16 = null;
        obj14 = null;
        obj9 = null;
        abyte0 = null;
        obj24 = null;
        obj17 = null;
        obj4 = null;
        obj7 = null;
        obj6 = null;
        obj12 = null;
        obj20 = null;
        obj13 = null;
        obj11 = null;
        obj10 = null;
        obj1 = obj25;
        obj2 = obj;
        obj3 = obj24;
        String s = reader.readLine();
        if (s == null)
        {
            if (false)
            {
                throw new NullPointerException();
            }
            if (false)
            {
                throw new NullPointerException();
            }
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                return null;
            }
        }
        obj1 = obj25;
        obj2 = obj;
        obj3 = obj24;
        obj = new ByteArrayInputStream(cipher.doFinal(Base64.decodeBase64(s.getBytes("UTF-8"))));
        obj1 = new ByteArrayOutputStream();
        obj8 = obj9;
        obj3 = obj12;
        obj6 = obj20;
        obj4 = obj13;
        obj7 = obj11;
        abyte0 = new byte[1024];
        obj8 = obj9;
        obj3 = obj12;
        obj4 = obj13;
        obj7 = obj11;
        obj2 = new GZIPInputStream(((java.io.InputStream) (obj)));
_L3:
        int i = ((GZIPInputStream) (obj2)).read(abyte0);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        ((ByteArrayOutputStream) (obj1)).write(abyte0, 0, i);
          goto _L3
        Exception exception;
        exception;
_L9:
        obj8 = obj2;
        obj3 = obj2;
        obj6 = obj2;
        obj4 = obj2;
        obj7 = obj2;
        throw new DecryptionException(exception);
        obj2;
        obj4 = obj;
        obj3 = obj8;
        obj = obj2;
        obj2 = obj1;
        obj1 = obj4;
_L8:
        throw new DecryptionException(((Exception) (obj)));
        obj;
_L4:
        if (obj3 != null)
        {
            ((GZIPInputStream) (obj3)).close();
        }
        if (obj1 != null)
        {
            ((ByteArrayInputStream) (obj1)).close();
        }
        if (obj2 != null)
        {
            ((ByteArrayOutputStream) (obj2)).close();
        }
        throw obj;
_L2:
        obj3 = new String(((ByteArrayOutputStream) (obj1)).toByteArray(), "UTF-8");
        if (obj2 != null)
        {
            ((GZIPInputStream) (obj2)).close();
        }
        if (obj != null)
        {
            ((ByteArrayInputStream) (obj)).close();
        }
        if (obj1 != null)
        {
            ((ByteArrayOutputStream) (obj1)).close();
        }
        return ((String) (obj3));
        obj;
        obj3 = obj4;
        obj2 = obj8;
        obj1 = obj19;
_L7:
        throw new DecryptionException(((Exception) (obj)));
_L6:
        throw obj;
_L5:
        throw new IOException(((Exception) (obj)).toString());
        obj4;
        obj1 = obj;
        obj2 = obj18;
        obj3 = obj17;
        obj = obj4;
          goto _L4
        obj4;
        obj2 = obj1;
        obj1 = obj;
        obj = obj4;
          goto _L4
        obj4;
        obj3 = obj2;
        obj2 = obj1;
        obj1 = obj;
        obj = obj4;
          goto _L4
        obj3;
        obj1 = obj;
        obj2 = obj16;
        obj = obj3;
        obj3 = obj6;
          goto _L5
        obj3;
        obj2 = obj1;
        obj1 = obj;
        obj = obj3;
        obj3 = obj6;
          goto _L5
        obj4;
        obj3 = obj2;
        obj2 = obj1;
        obj1 = obj;
        obj = obj4;
          goto _L5
        obj3;
        obj1 = obj;
        obj2 = obj15;
        obj = obj3;
        obj3 = obj7;
          goto _L6
        obj3;
        obj2 = obj1;
        obj1 = obj;
        obj = obj3;
        obj3 = obj4;
          goto _L6
        obj4;
        obj3 = obj2;
        obj2 = obj1;
        obj1 = obj;
        obj = obj4;
          goto _L6
        obj3;
        obj1 = obj;
        obj2 = obj8;
        obj = obj3;
        obj3 = obj4;
          goto _L7
        obj3;
        obj2 = obj1;
        obj1 = obj;
        obj = obj3;
        obj3 = obj7;
          goto _L7
        Object obj5;
        obj5;
        obj3 = obj2;
        obj2 = obj1;
        obj1 = obj;
        obj = obj5;
          goto _L7
        obj;
        obj1 = obj23;
        obj2 = obj14;
        obj3 = abyte0;
          goto _L8
        obj3;
        obj1 = obj;
        obj2 = obj14;
        obj = obj3;
        obj3 = abyte0;
          goto _L8
        obj5;
        obj3 = obj2;
        obj2 = obj1;
        obj1 = obj;
        obj = obj5;
          goto _L8
        exception;
        obj2 = obj10;
          goto _L9
        obj;
        obj1 = obj22;
        obj2 = obj15;
        obj3 = obj7;
          goto _L6
        obj;
        obj1 = obj21;
        obj2 = obj16;
        obj3 = obj6;
          goto _L5
    }

    public boolean ready()
        throws IOException
    {
        return reader.ready();
    }

    public void reset()
        throws IOException
    {
        reader.reset();
    }

    public long skip(long l)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the skip(long) method");
    }
}
