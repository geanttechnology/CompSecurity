// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.UnsupportedEncodingException;
import org.apache.thrift.TByteArrayOutputStream;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport

public class TMemoryBuffer extends TTransport
{

    private TByteArrayOutputStream a;
    private int b;

    public TMemoryBuffer(int i)
    {
        a = new TByteArrayOutputStream(i);
    }

    public void close()
    {
    }

    public String inspect()
    {
        String s = "";
        byte abyte0[] = a.toByteArray();
        int i = 0;
        while (i < abyte0.length) 
        {
            StringBuilder stringbuilder = (new StringBuilder()).append(s);
            if (b == i)
            {
                s = "==>";
            } else
            {
                s = "";
            }
            s = stringbuilder.append(s).append(Integer.toHexString(abyte0[i] & 0xff)).append(" ").toString();
            i++;
        }
        return s;
    }

    public boolean isOpen()
    {
        return true;
    }

    public int length()
    {
        return a.size();
    }

    public void open()
    {
    }

    public int read(byte abyte0[], int i, int j)
    {
        byte abyte1[] = a.get();
        int k = j;
        if (j > a.len() - b)
        {
            k = a.len() - b;
        }
        if (k > 0)
        {
            System.arraycopy(abyte1, b, abyte0, i, k);
            b = b + k;
        }
        return k;
    }

    public String toString(String s)
        throws UnsupportedEncodingException
    {
        return a.toString(s);
    }

    public void write(byte abyte0[], int i, int j)
    {
        a.write(abyte0, i, j);
    }
}
