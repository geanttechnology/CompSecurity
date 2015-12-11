// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.util.BitSet;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.io.MaxHeaderLengthLimitException;
import org.apache.james.mime4j.util.ByteArrayBuffer;

// Referenced classes of package org.apache.james.mime4j.stream:
//            FieldBuilder, RawFieldParser, RawField

public class DefaultFieldBuilder
    implements FieldBuilder
{

    private static final BitSet FIELD_CHARS;
    private final ByteArrayBuffer buf = new ByteArrayBuffer(1024);
    private final int maxlen;

    public DefaultFieldBuilder(int i)
    {
        maxlen = i;
    }

    public void append(ByteArrayBuffer bytearraybuffer)
        throws MaxHeaderLengthLimitException
    {
        if (bytearraybuffer == null)
        {
            return;
        }
        int i = bytearraybuffer.length();
        if (maxlen > 0 && buf.length() + i >= maxlen)
        {
            throw new MaxHeaderLengthLimitException("Maximum header length limit exceeded");
        } else
        {
            buf.append(bytearraybuffer.buffer(), 0, bytearraybuffer.length());
            return;
        }
    }

    public RawField build()
        throws MimeException
    {
        int l = buf.length();
        int k = l;
        if (l > 0)
        {
            int i = l;
            if (buf.byteAt(l - 1) == 10)
            {
                i = l - 1;
            }
            k = i;
            if (buf.byteAt(i - 1) == 13)
            {
                k = i - 1;
            }
        }
        Object obj = new ByteArrayBuffer(buf.buffer(), k, false);
        obj = RawFieldParser.DEFAULT.parseField(((org.apache.james.mime4j.util.ByteSequence) (obj)));
        String s = ((RawField) (obj)).getName();
        for (int j = 0; j < s.length(); j++)
        {
            char c = s.charAt(j);
            if (!FIELD_CHARS.get(c))
            {
                throw new MimeException((new StringBuilder()).append("MIME field name contains illegal characters: ").append(((RawField) (obj)).getName()).toString());
            }
        }

        return ((RawField) (obj));
    }

    public ByteArrayBuffer getRaw()
    {
        return buf;
    }

    public void reset()
    {
        buf.clear();
    }

    static 
    {
        FIELD_CHARS = new BitSet();
        for (int i = 33; i <= 57; i++)
        {
            FIELD_CHARS.set(i);
        }

        for (int j = 59; j <= 126; j++)
        {
            FIELD_CHARS.set(j);
        }

    }
}
