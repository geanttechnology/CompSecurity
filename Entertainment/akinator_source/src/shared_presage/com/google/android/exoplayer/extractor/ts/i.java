// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.text.eia608.Eia608Parser;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            c

final class i extends c
{

    public i(TrackOutput trackoutput)
    {
        super(trackoutput);
        trackoutput.format(MediaFormat.createTextFormat("application/eia-608"));
    }

    public final void a()
    {
    }

    public final void a(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        while (parsablebytearray.bytesLeft() > 1) 
        {
            int j = 0;
            int k;
            int i1;
            do
            {
                i1 = parsablebytearray.readUnsignedByte();
                k = j + i1;
                j = k;
            } while (i1 == 255);
            j = 0;
            int j1;
            do
            {
                j1 = parsablebytearray.readUnsignedByte();
                i1 = j + j1;
                j = i1;
            } while (j1 == 255);
            if (Eia608Parser.isSeiMessageEia608(k, i1, parsablebytearray))
            {
                a.sampleData(parsablebytearray, i1);
                a.sampleMetadata(l, 1, i1, 0, null);
            } else
            {
                parsablebytearray.skipBytes(i1);
            }
        }
    }

    public final void b()
    {
    }
}
