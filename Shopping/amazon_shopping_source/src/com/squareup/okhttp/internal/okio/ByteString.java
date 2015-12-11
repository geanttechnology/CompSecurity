// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            Base64

public final class ByteString
{

    public static final ByteString EMPTY = of(new byte[0]);
    private static final char HEX_DIGITS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    final byte data[];
    private transient int hashCode;
    private transient String utf8;

    ByteString(byte abyte0[])
    {
        data = abyte0;
    }

    public static transient ByteString concat(ByteString abytestring[])
    {
        int k = 0;
        int l = abytestring.length;
        for (int i = 0; i < l; i++)
        {
            k += abytestring[i].size();
        }

        byte abyte0[] = new byte[k];
        k = 0;
        l = abytestring.length;
        for (int j = 0; j < l; j++)
        {
            ByteString bytestring = abytestring[j];
            System.arraycopy(bytestring.data, 0, abyte0, k, bytestring.size());
            k += bytestring.size();
        }

        return new ByteString(abyte0);
    }

    public static ByteString decodeBase64(String s)
    {
        s = Base64.decode(s);
        if (s != null)
        {
            return new ByteString(s);
        } else
        {
            return null;
        }
    }

    public static ByteString decodeHex(String s)
    {
        if (s.length() % 2 != 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected hex string: ").append(s).toString());
        }
        byte abyte0[] = new byte[s.length() / 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)((decodeHexDigit(s.charAt(i * 2)) << 4) + decodeHexDigit(s.charAt(i * 2 + 1)));
        }

        return of(abyte0);
    }

    private static int decodeHexDigit(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f')
        {
            return (c - 97) + 10;
        }
        if (c >= 'A' && c <= 'F')
        {
            return (c - 65) + 10;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected hex digit: ").append(c).toString());
        }
    }

    public static ByteString encodeUtf8(String s)
    {
        ByteString bytestring;
        try
        {
            bytestring = new ByteString(s.getBytes("UTF-8"));
            bytestring.utf8 = s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return bytestring;
    }

    public static transient ByteString of(byte abyte0[])
    {
        return new ByteString((byte[])abyte0.clone());
    }

    public static ByteString read(InputStream inputstream, int i)
        throws IOException
    {
        byte abyte0[] = new byte[i];
        int k;
        for (int j = 0; j < i; j += k)
        {
            k = inputstream.read(abyte0, j, i - j);
            if (k == -1)
            {
                throw new EOFException();
            }
        }

        return new ByteString(abyte0);
    }

    public String base64()
    {
        return Base64.encode(data);
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof ByteString) && Arrays.equals(((ByteString)obj).data, data);
    }

    public boolean equalsAscii(String s)
    {
        boolean flag1 = true;
        if (s != null && data.length == s.length()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (s == utf8)
        {
            continue;
        }
        int i = 0;
        do
        {
            flag = flag1;
            if (i >= data.length)
            {
                continue;
            }
            if (data[i] != s.charAt(i))
            {
                return false;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int hashCode()
    {
        int i = hashCode;
        if (i != 0)
        {
            return i;
        } else
        {
            int j = Arrays.hashCode(data);
            hashCode = j;
            return j;
        }
    }

    public String hex()
    {
        char ac[] = new char[data.length * 2];
        byte abyte0[] = data;
        int k = abyte0.length;
        int i = 0;
        int j = 0;
        for (; i < k; i++)
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac[j] = HEX_DIGITS[byte0 >> 4 & 0xf];
            j = l + 1;
            ac[l] = HEX_DIGITS[byte0 & 0xf];
        }

        return new String(ac);
    }

    public int size()
    {
        return data.length;
    }

    public ByteString toAsciiLowercase()
    {
        Object obj;
label0:
        {
            int i = 0;
            byte byte0;
            do
            {
                obj = this;
                if (i >= data.length)
                {
                    break label0;
                }
                byte0 = data[i];
                if (byte0 >= 65 && byte0 <= 90)
                {
                    break;
                }
                i++;
            } while (true);
            obj = (byte[])data.clone();
            obj[i] = (byte)(byte0 + 32);
            i++;
            while (i < obj.length) 
            {
                byte byte1 = obj[i];
                if (byte1 >= 65 && byte1 <= 90)
                {
                    obj[i] = (byte)(byte1 + 32);
                }
                i++;
            }
            obj = new ByteString(((byte []) (obj)));
        }
        return ((ByteString) (obj));
    }

    public byte[] toByteArray()
    {
        return (byte[])data.clone();
    }

    public String toString()
    {
        if (data.length == 0)
        {
            return "ByteString[size=0]";
        }
        if (data.length <= 16)
        {
            return String.format("ByteString[size=%s data=%s]", new Object[] {
                Integer.valueOf(data.length), hex()
            });
        }
        String s;
        try
        {
            s = String.format("ByteString[size=%s md5=%s]", new Object[] {
                Integer.valueOf(data.length), of(MessageDigest.getInstance("MD5").digest(data)).hex()
            });
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        return s;
    }

    public String utf8()
    {
        String s = utf8;
        if (s != null)
        {
            return s;
        }
        try
        {
            s = new String(data, "UTF-8");
            utf8 = s;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }

    public void write(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(data);
    }

}
