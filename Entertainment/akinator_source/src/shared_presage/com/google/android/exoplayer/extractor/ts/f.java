// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            c

final class f extends c
{

    private boolean b;
    private long c;
    private int d;

    public f(TrackOutput trackoutput)
    {
        super(trackoutput);
        trackoutput.format(MediaFormat.createTextFormat("application/id3"));
    }

    public final void a()
    {
        b = false;
    }

    public final void a(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        if (flag)
        {
            b = true;
            c = l;
            d = 0;
        }
        if (b)
        {
            d = d + parsablebytearray.bytesLeft();
            a.sampleData(parsablebytearray, parsablebytearray.bytesLeft());
        }
    }

    public final void b()
    {
        a.sampleMetadata(c, 1, d, 0, null);
        b = false;
    }
}
