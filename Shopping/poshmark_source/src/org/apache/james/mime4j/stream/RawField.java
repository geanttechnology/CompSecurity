// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.CharsetUtil;
import org.apache.james.mime4j.util.ContentUtil;
import org.apache.james.mime4j.util.MimeUtil;

// Referenced classes of package org.apache.james.mime4j.stream:
//            Field

public final class RawField
    implements Field
{

    private final String body;
    private final int delimiterIdx;
    private final String name;
    private final ByteSequence raw;

    public RawField(String s, String s1)
    {
        this(null, -1, s, s1);
    }

    RawField(ByteSequence bytesequence, int i, String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Field may not be null");
        } else
        {
            raw = bytesequence;
            delimiterIdx = i;
            name = s.trim();
            body = s1;
            return;
        }
    }

    public String getBody()
    {
        if (body != null)
        {
            return body;
        }
        if (raw != null)
        {
            int k = raw.length();
            int j = delimiterIdx + 1;
            int i = j;
            if (k > j + 1)
            {
                i = j;
                if (CharsetUtil.isWhitespace((char)(raw.byteAt(j) & 0xff)))
                {
                    i = j + 1;
                }
            }
            return MimeUtil.unfold(ContentUtil.decode(raw, i, k - i));
        } else
        {
            return null;
        }
    }

    public int getDelimiterIdx()
    {
        return delimiterIdx;
    }

    public String getName()
    {
        return name;
    }

    public ByteSequence getRaw()
    {
        return raw;
    }

    public String toString()
    {
        if (raw != null)
        {
            return ContentUtil.decode(raw);
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(name);
        stringbuilder.append(": ");
        if (body != null)
        {
            stringbuilder.append(body);
        }
        return stringbuilder.toString();
    }
}
