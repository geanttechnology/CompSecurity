// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.okio.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Huffman

static final class lengths extends Enum
{

    private static final RESPONSE $VALUES[];
    public static final RESPONSE REQUEST;
    public static final RESPONSE RESPONSE;
    private final int codes[];
    private final byte lengths[];
    private final RESPONSE root = new init>();

    private void addCode(int i, int j, byte byte0)
    {
        lengths lengths2 = new init>(i, byte0);
        lengths lengths1;
        for (lengths1 = root; byte0 > 8; lengths1 = ccess._mth400(lengths1)[i])
        {
            byte0 -= 8;
            i = j >>> byte0 & 0xff;
            if (ccess._mth400(lengths1) == null)
            {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (ccess._mth400(lengths1)[i] == null)
            {
                ccess._mth400(lengths1)[i] = new init>();
            }
        }

        byte0 = 8 - byte0;
        j = j << byte0 & 0xff;
        for (i = j; i < j + (1 << byte0); i++)
        {
            ccess._mth400(lengths1)[i] = lengths2;
        }

    }

    private void buildTree(int ai[], byte abyte0[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            addCode(i, ai[i], abyte0[i]);
        }

    }

    public static addCode valueOf(String s)
    {
        return (addCode)Enum.valueOf(com/squareup/okhttp/internal/spdy/Huffman$Codec, s);
    }

    public static addCode[] values()
    {
        return (addCode[])$VALUES.clone();
    }

    ByteString decode(ByteString bytestring)
        throws IOException
    {
        return ByteString.of(decode(bytestring.toByteArray()));
    }

    byte[] decode(byte abyte0[])
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        yteArray ytearray = root;
        int k = 0;
        int i = 0;
        int j = 0;
        yteArray ytearray1;
        int l;
        do
        {
            l = i;
            ytearray1 = ytearray;
            if (j >= abyte0.length)
            {
                break;
            }
            k = k << 8 | abyte0[j] & 0xff;
            for (i += 8; i >= 8;)
            {
                ytearray = ccess._mth400(ytearray)[k >>> i - 8 & 0xff];
                if (ccess._mth400(ytearray) == null)
                {
                    bytearrayoutputstream.write(ccess._mth500(ytearray));
                    i -= ccess._mth600(ytearray);
                    ytearray = root;
                } else
                {
                    i -= 8;
                }
            }

            j++;
        } while (true);
        while (l > 0 && (ccess._mth400(abyte0 = ccess._mth400(ytearray1)[k << 8 - l & 0xff]) == null && ccess._mth600(abyte0) <= l)) 
        {
            bytearrayoutputstream.write(ccess._mth500(abyte0));
            l -= ccess._mth600(abyte0);
            ytearray1 = root;
        }
        return bytearrayoutputstream.toByteArray();
    }

    void encode(byte abyte0[], OutputStream outputstream)
        throws IOException
    {
        long l1 = 0L;
        int i = 0;
        for (int j = 0; j < abyte0.length; j++)
        {
            int l = abyte0[j] & 0xff;
            int k = codes[l];
            l = lengths[l];
            l1 = l1 << l | (long)k;
            for (i += l; i >= 8;)
            {
                i -= 8;
                outputstream.write((int)(l1 >> i));
            }

        }

        if (i > 0)
        {
            outputstream.write((int)(l1 << 8 - i | (long)(255 >>> i)));
        }
    }

    int encodedLength(byte abyte0[])
    {
        long l = 0L;
        for (int i = 0; i < abyte0.length; i++)
        {
            byte byte0 = abyte0[i];
            l += lengths[byte0 & 0xff];
        }

        return (int)(7L + l >> 3);
    }

    static 
    {
        REQUEST = new <init>("REQUEST", 0, Huffman.access$000(), Huffman.access$100());
        RESPONSE = new <init>("RESPONSE", 1, Huffman.access$200(), Huffman.access$300());
        $VALUES = (new .VALUES[] {
            REQUEST, RESPONSE
        });
    }

    private (String s, int i, int ai[], byte abyte0[])
    {
        super(s, i);
        buildTree(ai, abyte0);
        codes = ai;
        lengths = abyte0;
    }
}
