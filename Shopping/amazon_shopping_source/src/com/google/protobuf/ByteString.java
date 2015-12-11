// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.google.protobuf:
//            CodedInputStream, CodedOutputStream

public final class ByteString
{
    static final class CodedBuilder
    {

        private final byte buffer[];
        private final CodedOutputStream output;

        public ByteString build()
        {
            output.checkNoSpaceLeft();
            return new ByteString(buffer);
        }

        public CodedOutputStream getCodedOutput()
        {
            return output;
        }

        private CodedBuilder(int i)
        {
            buffer = new byte[i];
            output = CodedOutputStream.newInstance(buffer);
        }

    }


    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private final byte bytes[];
    private volatile int hash;

    private ByteString(byte abyte0[])
    {
        hash = 0;
        bytes = abyte0;
    }


    public static ByteString copyFrom(byte abyte0[])
    {
        return copyFrom(abyte0, 0, abyte0.length);
    }

    public static ByteString copyFrom(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        return new ByteString(abyte1);
    }

    public static ByteString copyFromUtf8(String s)
    {
        try
        {
            s = new ByteString(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported?", s);
        }
        return s;
    }

    static CodedBuilder newCodedBuilder(int i)
    {
        return new CodedBuilder(i);
    }

    public byte byteAt(int i)
    {
        return bytes[i];
    }

    public void copyTo(byte abyte0[], int i, int j, int k)
    {
        System.arraycopy(bytes, i, abyte0, j, k);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ByteString))
            {
                return false;
            }
            ByteString bytestring = (ByteString)obj;
            int j = bytes.length;
            if (j != bytestring.bytes.length)
            {
                return false;
            }
            obj = bytes;
            byte abyte0[] = bytestring.bytes;
            int i = 0;
            while (i < j) 
            {
                if (obj[i] != abyte0[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int i = hash;
        int k = i;
        if (i == 0)
        {
            byte abyte0[] = bytes;
            int l = bytes.length;
            k = 0;
            int j;
            byte byte0;
            for (j = l; k < l; j = byte0 + j * 31)
            {
                byte0 = abyte0[k];
                k++;
            }

            k = j;
            if (j == 0)
            {
                k = 1;
            }
            hash = k;
        }
        return k;
    }

    public CodedInputStream newCodedInput()
    {
        return CodedInputStream.newInstance(bytes);
    }

    public InputStream newInput()
    {
        return new ByteArrayInputStream(bytes);
    }

    public int size()
    {
        return bytes.length;
    }

    public String toStringUtf8()
    {
        String s;
        try
        {
            s = new String(bytes, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("UTF-8 not supported?", unsupportedencodingexception);
        }
        return s;
    }

}
