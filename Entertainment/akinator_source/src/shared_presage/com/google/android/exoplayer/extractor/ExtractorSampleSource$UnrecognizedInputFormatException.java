// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor;

import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor:
//            ExtractorSampleSource, Extractor

public static final class  extends ParserException
{

    public (Extractor aextractor[])
    {
        super((new StringBuilder("None of the available extractors (")).append(Util.getCommaDelimitedSimpleClassNames(aextractor)).append(") could read the stream.").toString());
    }
}
