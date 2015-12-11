// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;


// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            AacExtractor

private static class tag
{

    public long contentSize;
    public long headerSize;
    public long tag;

    public (long l, long l1, long l2)
    {
        headerSize = l;
        contentSize = l1;
        tag = l2;
    }
}
