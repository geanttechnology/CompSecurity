// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import java.io.InputStream;

public class BoundInputStream extends InputStream
{

    static final int BUF_SIZE = 4096;
    private InputStream base;
    private byte buf[];
    private int bufPos;
    private int bufSize;
    private int remaining;

    public BoundInputStream(InputStream inputstream, int i)
    {
        base = inputstream;
        remaining = i;
        buf = new byte[Math.min(i, 4096)];
    }

    private boolean checkBuf()
    {
        if (remaining <= 0)
        {
            return false;
        }
        if (bufPos >= bufSize)
        {
            bufSize = base.read(buf, 0, Math.min(remaining, buf.length));
            if (bufSize <= 0)
            {
                remaining = 0;
                return false;
            }
            bufPos = 0;
        }
        return true;
    }

    public int available()
    {
        return bufSize - bufPos;
    }

    public int getRemaining()
    {
        return remaining;
    }

    public int read()
    {
        if (!checkBuf())
        {
            return -1;
        } else
        {
            remaining = remaining - 1;
            byte abyte0[] = buf;
            int i = bufPos;
            bufPos = i + 1;
            return abyte0[i] & 0xff;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (!checkBuf())
        {
            return -1;
        } else
        {
            j = Math.min(j, bufSize - bufPos);
            System.arraycopy(buf, bufPos, abyte0, i, j);
            bufPos = bufPos + j;
            remaining = remaining - j;
            return j;
        }
    }
}
