// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.CharMatcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

class dding extends InputStream
{

    int bitBuffer;
    int bitBufferLength;
    boolean hitPadding;
    final CharMatcher paddingMatcher;
    int readChars;
    final bitBufferLength this$0;
    final Reader val$reader;

    public void close()
        throws IOException
    {
        val$reader.close();
    }

    public int read()
        throws IOException
    {
        byte byte0 = -1;
        int i;
label0:
        do
        {
            char c;
            do
            {
                i = val$reader.read();
                if (i == -1)
                {
                    i = byte0;
                    if (!hitPadding)
                    {
                        i = byte0;
                        if (!phabet.StartPosition(readChars))
                        {
                            i = readChars;
                            throw new >((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
                        }
                    }
                    break label0;
                }
                readChars = readChars + 1;
                c = (char)i;
                if (!paddingMatcher.matches(c))
                {
                    break;
                }
                if (!hitPadding && (readChars == 1 || !phabet.StartPosition(readChars - 1)))
                {
                    i = readChars;
                    throw new >((new StringBuilder(41)).append("Padding cannot start at index ").append(i).toString());
                }
                hitPadding = true;
            } while (true);
            if (hitPadding)
            {
                i = readChars;
                throw new >((new StringBuilder(61)).append("Expected padding character but found '").append(c).append("' at index ").append(i).toString());
            }
            bitBuffer = bitBuffer << phabet.phabet;
            bitBuffer = bitBuffer | phabet.phabet(c);
            bitBufferLength = bitBufferLength + phabet.phabet;
            if (bitBufferLength < 8)
            {
                continue;
            }
            bitBufferLength = bitBufferLength - 8;
            i = bitBuffer >> bitBufferLength & 0xff;
            break;
        } while (true);
        return i;
    }

    ()
    {
        this$0 = final_;
        val$reader = Reader.this;
        super();
        bitBuffer = 0;
        bitBufferLength = 0;
        readChars = 0;
        hitPadding = false;
        paddingMatcher = dding();
    }
}
