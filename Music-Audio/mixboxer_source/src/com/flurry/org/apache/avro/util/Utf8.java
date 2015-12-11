// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.util;

import com.flurry.org.apache.avro.io.BinaryData;
import java.io.UnsupportedEncodingException;

public class Utf8
    implements Comparable, CharSequence
{

    private static final byte EMPTY[] = new byte[0];
    private byte bytes[];
    private int length;
    private String string;

    public Utf8()
    {
        bytes = EMPTY;
    }

    public Utf8(Utf8 utf8)
    {
        bytes = EMPTY;
        length = utf8.length;
        bytes = new byte[utf8.length];
        System.arraycopy(utf8.bytes, 0, bytes, 0, length);
        string = utf8.string;
    }

    public Utf8(String s)
    {
        bytes = EMPTY;
        bytes = getBytesFor(s);
        length = bytes.length;
        string = s;
    }

    public Utf8(byte abyte0[])
    {
        bytes = EMPTY;
        bytes = abyte0;
        length = abyte0.length;
    }

    public static final byte[] getBytesFor(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return new byte[0];
        }
        return s;
    }

    public char charAt(int i)
    {
        return toString().charAt(i);
    }

    public int compareTo(Utf8 utf8)
    {
        return BinaryData.compareBytes(bytes, 0, length, utf8.bytes, 0, utf8.length);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Utf8)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Utf8))
            {
                return false;
            }
            obj = (Utf8)obj;
            if (length != ((Utf8) (obj)).length)
            {
                return false;
            }
            obj = ((Utf8) (obj)).bytes;
            int i = 0;
            while (i < length) 
            {
                if (bytes[i] != obj[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public int getByteLength()
    {
        return length;
    }

    public byte[] getBytes()
    {
        return bytes;
    }

    public int getLength()
    {
        return length;
    }

    public int hashCode()
    {
        int j = 0;
        for (int i = 0; i < length; i++)
        {
            j = j * 31 + bytes[i];
        }

        return j;
    }

    public int length()
    {
        return toString().length();
    }

    public Utf8 setByteLength(int i)
    {
        if (length < i)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(bytes, 0, abyte0, 0, length);
            bytes = abyte0;
        }
        length = i;
        string = null;
        return this;
    }

    public Utf8 setLength(int i)
    {
        return setByteLength(i);
    }

    public CharSequence subSequence(int i, int j)
    {
        return toString().subSequence(i, j);
    }

    public String toString()
    {
        if (string == null)
        {
            try
            {
                string = new String(bytes, 0, length, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
            }
        }
        return string;
    }

}
