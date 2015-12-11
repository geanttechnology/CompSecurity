// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

class b extends BufferedReader
{

    private static final int CHAR_CARRIAGE_RETURN = 13;
    private static final int CHAR_EOF = 0;
    private static final int CHAR_LINE_FEED = 10;
    private static final int DEFAULT_CHAR_MARK_LIMIT = 1;
    private static final int DEFAULT_MAX_LINES = 1024;
    private static final int DEFAULT_MAX_LINE_LENGTH = 1024;
    private static final int DEFAULT_OFFSET = 0;
    private final int mBufferReaderMaxLineLength = 1024;
    private final int mBufferReaderMaxLines = 1024;
    private int mCurrentLine;

    public b(Reader reader)
    {
        super(reader);
        mCurrentLine = 1;
    }

    public String readLine()
        throws IOException
    {
        char ac[];
        int k;
        int l;
        if (mCurrentLine > mBufferReaderMaxLines)
        {
            throw new IOException("BoundedBufferedReader - Line read limit has been reached.");
        }
        mCurrentLine = mCurrentLine + 1;
        ac = new char[mBufferReaderMaxLineLength];
        k = super.read();
        int i = 0;
        do
        {
            l = i;
            if (k == 13)
            {
                break;
            }
            l = i;
            if (k == 10)
            {
                break;
            }
            l = i;
            if (k < 0)
            {
                break;
            }
            l = i + 1;
            ac[i] = (char)k;
            if (l >= mBufferReaderMaxLineLength)
            {
                break;
            }
            k = super.read();
            i = l;
        } while (true);
        if (k < 0)
        {
            if (l > 0)
            {
                return new String(ac, 0, l);
            } else
            {
                return null;
            }
        }
        if (k != 13) goto _L2; else goto _L1
_L1:
        super.mark(1);
        if (super.read() != 10)
        {
            super.reset();
        }
_L4:
        return new String(ac, 0, l);
_L2:
        if (k != 10)
        {
            super.mark(1);
            int j = super.read();
            if (j == 13)
            {
                super.mark(1);
                if (super.read() != 10)
                {
                    super.reset();
                }
            } else
            if (j != 10)
            {
                super.reset();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
