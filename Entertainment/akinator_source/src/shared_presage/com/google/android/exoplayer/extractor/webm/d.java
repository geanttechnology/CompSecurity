// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.webm;

import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

final class d
{

    private final ParsableByteArray a = new ParsableByteArray(8);
    private int b;

    public d()
    {
    }

    private long b(ExtractorInput extractorinput)
    {
        int k = 0;
        extractorinput.peekFully(a.data, 0, 1);
        int l = a.data[0] & 0xff;
        if (l == 0)
        {
            return 0x8000000000000000L;
        }
        int j = 128;
        int i = 0;
        for (; (l & j) == 0; j >>= 1)
        {
            i++;
        }

        l = ~j & l;
        extractorinput.peekFully(a.data, 1, i);
        j = k;
        k = l;
        for (; j < i; j++)
        {
            k = (k << 8) + (a.data[j + 1] & 0xff);
        }

        b = b + (i + 1);
        return (long)k;
    }

    public final boolean a(ExtractorInput extractorinput)
    {
        long l;
        long l2;
        long l3;
        long l1 = extractorinput.getLength();
        int i;
        if (l1 == -1L || l1 > 1024L)
        {
            l = 1024L;
        } else
        {
            l = l1;
        }
        i = (int)l;
        extractorinput.peekFully(a.data, 0, 4);
        l = a.readUnsignedInt();
        b = 4;
        for (; l != 0x1a45dfa3L; l = l << 8 & -256L | (long)(a.data[0] & 0xff))
        {
            int j = b + 1;
            b = j;
            if (j == i)
            {
                return false;
            }
            extractorinput.peekFully(a.data, 0, 1);
        }

        l = b(extractorinput);
        l3 = b;
        if (l == 0x8000000000000000L || l1 != -1L && l3 + l >= l1)
        {
            return false;
        }
_L3:
        if ((long)b < l3 + l)
        {
            if (b(extractorinput) == 0x8000000000000000L)
            {
                return false;
            }
            l2 = b(extractorinput);
            if (l2 < 0L || l2 > 0x7fffffffL)
            {
                return false;
            }
        } else
        {
            return (long)b == l + l3;
        }
        if (true) goto _L2; else goto _L1
_L2:
        if (l2 != 0L)
        {
            extractorinput.advancePeekPosition((int)l2);
            b = (int)(l2 + (long)b);
        }
        if (true) goto _L3; else goto _L1
_L1:
    }
}
