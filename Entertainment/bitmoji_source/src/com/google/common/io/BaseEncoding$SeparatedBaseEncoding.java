// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

static final class separatorChars extends BaseEncoding
{

    private final int afterEveryChars;
    private final BaseEncoding _flddelegate;
    private final String separator;
    private final CharMatcher separatorChars;

    int decodeTo(byte abyte0[], CharSequence charsequence)
        throws separatorChars
    {
        return _flddelegate.decodeTo(abyte0, separatorChars.removeFrom(charsequence));
    }

    public InputStream decodingStream(Reader reader)
    {
        return _flddelegate.decodingStream(ignoringReader(reader, separatorChars));
    }

    void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
        throws IOException
    {
        _flddelegate.encodeTo(separatingAppendable(appendable, separator, afterEveryChars), abyte0, i, j);
    }

    public OutputStream encodingStream(Writer writer)
    {
        return _flddelegate.encodingStream(separatingWriter(writer, separator, afterEveryChars));
    }

    public BaseEncoding lowerCase()
    {
        return _flddelegate.lowerCase().withSeparator(separator, afterEveryChars);
    }

    int maxDecodedSize(int i)
    {
        return _flddelegate.maxDecodedSize(i);
    }

    int maxEncodedSize(int i)
    {
        i = _flddelegate.maxEncodedSize(i);
        return separator.length() * IntMath.divide(Math.max(0, i - 1), afterEveryChars, RoundingMode.FLOOR) + i;
    }

    public BaseEncoding omitPadding()
    {
        return _flddelegate.omitPadding().withSeparator(separator, afterEveryChars);
    }

    CharMatcher padding()
    {
        return _flddelegate.padding();
    }

    public String toString()
    {
        String s = String.valueOf(_flddelegate.toString());
        String s1 = separator;
        int i = afterEveryChars;
        return (new StringBuilder(String.valueOf(s).length() + 31 + String.valueOf(s1).length())).append(s).append(".withSeparator(\"").append(s1).append("\", ").append(i).append(")").toString();
    }

    public BaseEncoding upperCase()
    {
        return _flddelegate.upperCase().withSeparator(separator, afterEveryChars);
    }

    public BaseEncoding withPadChar(char c)
    {
        return _flddelegate.withPadChar(c).withSeparator(separator, afterEveryChars);
    }

    public BaseEncoding withSeparator(String s, int i)
    {
        throw new UnsupportedOperationException("Already have a separator");
    }

    (BaseEncoding baseencoding, String s, int i)
    {
        _flddelegate = (BaseEncoding)Preconditions.checkNotNull(baseencoding);
        separator = (String)Preconditions.checkNotNull(s);
        afterEveryChars = i;
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot add a separator after every %s chars", new Object[] {
            Integer.valueOf(i)
        });
        separatorChars = CharMatcher.anyOf(s).precomputed();
    }
}
