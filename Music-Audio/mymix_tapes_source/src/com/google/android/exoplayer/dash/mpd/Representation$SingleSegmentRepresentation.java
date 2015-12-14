// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.net.Uri;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            Representation, DashSingleSegmentIndex, RangedUri

public static class segmentIndex extends Representation
{

    public final long contentLength;
    private final RangedUri indexUri;
    private final DashSingleSegmentIndex segmentIndex;
    public final Uri uri;

    public static segmentIndex newInstance(long l, long l1, String s, long l2, Format format, 
            String s1, long l3, long l4, long l5, 
            long l6, long l7)
    {
        return new <init>(l, l1, s, l2, format, new <init>(new RangedUri(s1, null, l3, 1L + (l4 - l3)), 1L, 0L, s1, l5, (l6 - l5) + 1L), l7);
    }

    public DashSegmentIndex getIndex()
    {
        return segmentIndex;
    }

    public RangedUri getIndexUri()
    {
        return indexUri;
    }

    public (long l, long l1, String s, long l2, 
            Format format,  , long l3)
    {
        super(l, l1, s, l2, format, , null);
        uri = Uri.parse(.uri);
        indexUri = .indexUri();
        contentLength = l3;
        if (indexUri != null)
        {
            s = null;
        } else
        {
            s = new DashSingleSegmentIndex(l * 1000L, l1 * 1000L, new RangedUri(.indexUri, null, 0L, -1L));
        }
        segmentIndex = s;
    }
}
