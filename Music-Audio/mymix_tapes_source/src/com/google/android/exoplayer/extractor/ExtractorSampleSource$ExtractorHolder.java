// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import java.io.EOFException;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorSampleSource, Extractor, ExtractorInput, ExtractorOutput

private static final class extractorOutput
{

    private Extractor extractor;
    private final ExtractorOutput extractorOutput;
    private final Extractor extractors[];

    public Extractor selectExtractor(ExtractorInput extractorinput)
        throws tFormatException, IOException, InterruptedException
    {
        Extractor aextractor[];
        int i;
        int j;
        if (extractor != null)
        {
            return extractor;
        }
        aextractor = extractors;
        j = aextractor.length;
        i = 0;
_L2:
        Extractor extractor1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        extractor1 = aextractor[i];
        if (!extractor1.sniff(extractorinput))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        extractor = extractor1;
        EOFException eofexception;
        if (extractor == null)
        {
            throw new tFormatException(extractors);
        } else
        {
            extractor.init(extractorOutput);
            return extractor;
        }
        eofexception;
        extractorinput.resetPeekPosition();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public tFormatException(Extractor aextractor[], ExtractorOutput extractoroutput)
    {
        extractors = aextractor;
        extractorOutput = extractoroutput;
    }
}
