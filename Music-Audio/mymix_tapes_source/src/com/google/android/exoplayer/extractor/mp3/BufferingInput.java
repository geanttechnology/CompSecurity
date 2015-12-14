// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.BufferOverflowException;

final class BufferingInput
{

    private final ParsableByteArray buffer;
    private final int capacity;
    private int markPosition;
    private int readPosition;
    private int writePosition;

    public BufferingInput(int i)
    {
        capacity = i;
        buffer = new ParsableByteArray(i * 2);
    }

    private boolean ensureLoaded(ExtractorInput extractorinput, int i)
        throws InterruptedException, IOException
    {
label0:
        {
            boolean flag = true;
            if ((readPosition + i) - markPosition > capacity)
            {
                throw new BufferOverflowException();
            }
            i -= writePosition - readPosition;
            if (i > 0)
            {
                if (extractorinput.readFully(buffer.data, writePosition, i, true))
                {
                    break label0;
                }
                flag = false;
            }
            return flag;
        }
        writePosition = writePosition + i;
        return true;
    }

    private boolean readInternal(ExtractorInput extractorinput, byte abyte0[], int i, int j)
        throws InterruptedException, IOException
    {
        if (!ensureLoaded(extractorinput, j))
        {
            return false;
        }
        if (abyte0 != null)
        {
            System.arraycopy(buffer.data, readPosition, abyte0, i, j);
        }
        readPosition = readPosition + j;
        return true;
    }

    public int drainToOutput(TrackOutput trackoutput, int i)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            buffer.setPosition(readPosition);
            i = Math.min(writePosition - readPosition, i);
            trackoutput.sampleData(buffer, i);
            readPosition = readPosition + i;
            return i;
        }
    }

    public int getAvailableByteCount()
    {
        return writePosition - readPosition;
    }

    public ParsableByteArray getParsableByteArray(ExtractorInput extractorinput, int i)
        throws IOException, InterruptedException
    {
        if (!ensureLoaded(extractorinput, i))
        {
            throw new EOFException();
        } else
        {
            extractorinput = new ParsableByteArray(buffer.data, writePosition);
            extractorinput.setPosition(readPosition);
            readPosition = readPosition + i;
            return extractorinput;
        }
    }

    public void mark()
    {
        if (readPosition > capacity)
        {
            System.arraycopy(buffer.data, readPosition, buffer.data, 0, writePosition - readPosition);
            writePosition = writePosition - readPosition;
            readPosition = 0;
        }
        markPosition = readPosition;
    }

    public void read(ExtractorInput extractorinput, byte abyte0[], int i, int j)
        throws IOException, InterruptedException
    {
        if (!readInternal(extractorinput, abyte0, i, j))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public boolean readAllowingEndOfInput(ExtractorInput extractorinput, byte abyte0[], int i, int j)
        throws IOException, InterruptedException
    {
        return readInternal(extractorinput, abyte0, i, j);
    }

    public void reset()
    {
        readPosition = 0;
        writePosition = 0;
        markPosition = 0;
    }

    public void returnToMark()
    {
        readPosition = markPosition;
    }

    public void skip(ExtractorInput extractorinput, int i)
        throws IOException, InterruptedException
    {
        if (!readInternal(extractorinput, null, 0, i))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }
}
