// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.alternates;

import a;
import eic;
import eie;
import euq;
import eus;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.speech.alternates:
//            Hypothesis

final class mAlternateSpans extends Hypothesis
{

    private final eic mAlternateSpans;

    private int getOffsetUtf16(byte abyte0[], int i)
    {
        int j;
        int k;
        j = 0;
        k = 0;
_L9:
        if (j >= i || j >= abyte0.length) goto _L2; else goto _L1
_L1:
        int l;
        l = abyte0[j] & 0xff;
        if (l >>> 7 == 0)
        {
            k++;
            j++;
            continue; /* Loop/switch isn't completed */
        }
        if (l >>> 5 != 6) goto _L4; else goto _L3
_L3:
        if (j + 1 < i) goto _L5; else goto _L2
_L2:
        return k;
_L5:
        j += 2;
        k++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (l >>> 4 != 14)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j + 2 < i)
        {
            j += 3;
            k++;
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L2; else goto _L6
_L6:
        if (l >>> 3 != 30)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j + 3 >= i) goto _L2; else goto _L7
_L7:
        j += 4;
        k += 2;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private byte[] getTextAsUtf8()
    {
        byte abyte0[];
        try
        {
            abyte0 = getText().getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw a.b(unsupportedencodingexception);
        }
        return abyte0;
    }

    protected final eic computeSpans()
    {
        eie eie1 = eic.h();
        eus eus1;
        eie eie2;
        int j;
        int k;
        for (Iterator iterator = mAlternateSpans.iterator(); iterator.hasNext(); eie1.b(new mAlternateSpans(j, k, eus1.a, eus1.b, eie2.a())))
        {
            eus1 = (eus)iterator.next();
            byte abyte0[] = getTextAsUtf8();
            j = getOffsetUtf16(abyte0, eus1.a);
            k = getOffsetUtf16(abyte0, eus1.a + eus1.b);
            eie2 = eic.h();
            for (int i = 0; i < eus1.c.size(); i++)
            {
                eie2.b(((euq)eus1.c.get(i)).a);
            }

        }

        return eie1.a();
    }

    public final int getSpanCount()
    {
        return mAlternateSpans.size();
    }

    public (CharSequence charsequence, Iterable iterable)
    {
        super(charsequence, null);
        mAlternateSpans = eic.a(iterable);
    }
}
