// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.ExtractorInput;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            EbmlReaderOutput, WebmExtractor

private final class <init>
    implements EbmlReaderOutput
{

    final WebmExtractor this$0;

    public void binaryElement(int i, int j, ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        WebmExtractor.this.binaryElement(i, j, extractorinput);
    }

    public void endMasterElement(int i)
        throws ParserException
    {
        WebmExtractor.this.endMasterElement(i);
    }

    public void floatElement(int i, double d)
        throws ParserException
    {
        WebmExtractor.this.floatElement(i, d);
    }

    public int getElementType(int i)
    {
        return WebmExtractor.this.getElementType(i);
    }

    public void integerElement(int i, long l)
        throws ParserException
    {
        WebmExtractor.this.integerElement(i, l);
    }

    public void startMasterElement(int i, long l, long l1)
        throws ParserException
    {
        WebmExtractor.this.startMasterElement(i, l, l1);
    }

    public void stringElement(int i, String s)
        throws ParserException
    {
        WebmExtractor.this.stringElement(i, s);
    }

    private ()
    {
        this$0 = WebmExtractor.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
