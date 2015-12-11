// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            DERTags, DERObject, DEREncodable

public class DEROutputStream extends FilterOutputStream
    implements DERTags
{

    public DEROutputStream(OutputStream outputstream)
    {
        super(outputstream);
    }

    private void writeLength(int i)
        throws IOException
    {
        if (i > 127)
        {
            int j = 1;
            int k = i;
            do
            {
                k >>>= 8;
                if (k == 0)
                {
                    break;
                }
                j++;
            } while (true);
            write((byte)(j | 0x80));
            for (j = (j - 1) * 8; j >= 0; j -= 8)
            {
                write((byte)(i >> j));
            }

        } else
        {
            write((byte)i);
        }
    }

    public void write(byte abyte0[])
        throws IOException
    {
        out.write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
    }

    void writeEncoded(int i, int j, byte abyte0[])
        throws IOException
    {
        writeTag(i, j);
        writeLength(abyte0.length);
        write(abyte0);
    }

    void writeEncoded(int i, byte abyte0[])
        throws IOException
    {
        write(i);
        writeLength(abyte0.length);
        write(abyte0);
    }

    protected void writeNull()
        throws IOException
    {
        write(5);
        write(0);
    }

    public void writeObject(Object obj)
        throws IOException
    {
        if (obj == null)
        {
            writeNull();
            return;
        }
        if (obj instanceof DERObject)
        {
            ((DERObject)obj).encode(this);
            return;
        }
        if (obj instanceof DEREncodable)
        {
            ((DEREncodable)obj).getDERObject().encode(this);
            return;
        } else
        {
            throw new IOException("object not DEREncodable");
        }
    }

    void writeTag(int i, int j)
        throws IOException
    {
        if (j < 31)
        {
            write(i | j);
            return;
        }
        write(i | 0x1f);
        if (j < 128)
        {
            write(j);
            return;
        }
        byte abyte0[] = new byte[5];
        i = abyte0.length - 1;
        abyte0[i] = (byte)(j & 0x7f);
        int k;
        int l;
        do
        {
            k = j >> 7;
            l = i - 1;
            abyte0[l] = (byte)(k & 0x7f | 0x80);
            i = l;
            j = k;
        } while (k > 127);
        write(abyte0, l, abyte0.length - l);
    }
}
