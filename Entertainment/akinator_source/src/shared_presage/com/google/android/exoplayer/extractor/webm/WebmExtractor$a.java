// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.webm;

import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.webm:
//            c, WebmExtractor

private final class <init>
    implements c
{

    final WebmExtractor a;

    public final int a(int i)
    {
        return a.getElementType(i);
    }

    public final void a(int i, double d)
    {
        a.floatElement(i, d);
    }

    public final void a(int i, int j, ExtractorInput extractorinput)
    {
        a.binaryElement(i, j, extractorinput);
    }

    public final void a(int i, long l)
    {
        a.integerElement(i, l);
    }

    public final void a(int i, long l, long l1)
    {
        a.startMasterElement(i, l, l1);
    }

    public final void a(int i, String s)
    {
        a.stringElement(i, s);
    }

    public final void b(int i)
    {
        a.endMasterElement(i);
    }

    private (WebmExtractor webmextractor)
    {
        a = webmextractor;
        super();
    }

    a(WebmExtractor webmextractor, byte byte0)
    {
        this(webmextractor);
    }
}
