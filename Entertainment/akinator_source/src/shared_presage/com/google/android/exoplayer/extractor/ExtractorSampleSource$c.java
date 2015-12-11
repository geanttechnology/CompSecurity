// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor;

import shared_presage.com.google.android.exoplayer.upstream.Allocator;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor:
//            DefaultTrackOutput, ExtractorSampleSource

private final class > extends DefaultTrackOutput
{

    final ExtractorSampleSource a;

    public final void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        super.sampleMetadata(l, i, j, k, abyte0);
        int _tmp = ExtractorSampleSource.access$008(a);
    }

    public (ExtractorSampleSource extractorsamplesource, Allocator allocator)
    {
        a = extractorsamplesource;
        super(allocator);
    }
}
