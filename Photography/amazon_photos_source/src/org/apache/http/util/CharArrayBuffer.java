// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.util;

import org.apache.http.protocol.HTTP;

public final class CharArrayBuffer
{

    private char buffer[];
    private int len;

    public CharArrayBuffer(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        } else
        {
            buffer = new char[i];
            return;
        }
    }

    private void expand(int i)
    {
        char ac[] = new char[Math.max(buffer.length << 1, i)];
        System.arraycopy(buffer, 0, ac, 0, len);
        buffer = ac;
    }

    public void append(char c)
    {
        int i = len + 1;
        if (i > buffer.length)
        {
            expand(i);
        }
        buffer[len] = c;
        len = i;
    }

    public void append(Object obj)
    {
        append(String.valueOf(obj));
    }

    public void append(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "null";
        }
        int i = s1.length();
        int j = len + i;
        if (j > buffer.length)
        {
            expand(j);
        }
        s1.getChars(0, i, buffer, len);
        len = j;
    }

    public void append(char ac[], int i, int j)
    {
        if (ac != null)
        {
            if (i < 0 || i > ac.length || j < 0 || i + j < 0 || i + j > ac.length)
            {
                throw new IndexOutOfBoundsException();
            }
            if (j != 0)
            {
                int k = len + j;
                if (k > buffer.length)
                {
                    expand(k);
                }
                System.arraycopy(ac, i, buffer, len, j);
                len = k;
                return;
            }
        }
    }

    public char charAt(int i)
    {
        return buffer[i];
    }

    public void clear()
    {
        len = 0;
    }

    public void ensureCapacity(int i)
    {
        while (i <= 0 || i <= buffer.length - len) 
        {
            return;
        }
        expand(len + i);
    }

    public String substring(int i, int j)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j > len)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i > j)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return new String(buffer, i, j - i);
        }
    }

    public String substringTrimmed(int i, int j)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j > len)
        {
            throw new IndexOutOfBoundsException();
        }
        int k = i;
        if (i > j)
        {
            throw new IndexOutOfBoundsException();
        }
        do
        {
            i = j;
            if (k >= j)
            {
                break;
            }
            i = j;
            if (!HTTP.isWhitespace(buffer[k]))
            {
                break;
            }
            k++;
        } while (true);
        for (; i > k && HTTP.isWhitespace(buffer[i - 1]); i--) { }
        return new String(buffer, k, i - k);
    }

    public String toString()
    {
        return new String(buffer, 0, len);
    }
}
