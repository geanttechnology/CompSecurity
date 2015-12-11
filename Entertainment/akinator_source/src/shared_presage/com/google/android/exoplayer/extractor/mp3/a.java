// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp3;

import java.io.EOFException;
import java.nio.BufferOverflowException;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

final class a
{

    private final ParsableByteArray a = new ParsableByteArray(24576);
    private final int b = 12288;
    private int c;
    private int d;
    private int e;

    public a()
    {
    }

    private boolean b(ExtractorInput extractorinput, byte abyte0[], int i)
    {
        if (!c(extractorinput, i))
        {
            return false;
        }
        if (abyte0 != null)
        {
            System.arraycopy(a.data, c, abyte0, 0, i);
        }
        c = c + i;
        return true;
    }

    private boolean c(ExtractorInput extractorinput, int i)
    {
label0:
        {
            boolean flag = true;
            if ((c + i) - e > b)
            {
                throw new BufferOverflowException();
            }
            i -= d - c;
            if (i > 0)
            {
                if (extractorinput.readFully(a.data, d, i, true))
                {
                    break label0;
                }
                flag = false;
            }
            return flag;
        }
        d = i + d;
        return true;
    }

    public final int a(TrackOutput trackoutput, int i)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            a.setPosition(c);
            i = Math.min(d - c, i);
            trackoutput.sampleData(a, i);
            c = c + i;
            return i;
        }
    }

    public final ParsableByteArray a(ExtractorInput extractorinput, int i)
    {
        if (!c(extractorinput, i))
        {
            throw new EOFException();
        } else
        {
            extractorinput = new ParsableByteArray(a.data, d);
            extractorinput.setPosition(c);
            c = c + i;
            return extractorinput;
        }
    }

    public final void a()
    {
        c = 0;
        d = 0;
        e = 0;
    }

    public final void a(ExtractorInput extractorinput, byte abyte0[], int i)
    {
        if (!b(extractorinput, abyte0, i))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final boolean a(ExtractorInput extractorinput, byte abyte0[])
    {
        return b(extractorinput, abyte0, 4);
    }

    public final void b()
    {
        if (c > b)
        {
            System.arraycopy(a.data, c, a.data, 0, d - c);
            d = d - c;
            c = 0;
        }
        e = c;
    }

    public final void b(ExtractorInput extractorinput, int i)
    {
        if (!b(extractorinput, null, i))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final void c()
    {
        c = e;
    }

    public final int d()
    {
        return d - c;
    }
}
