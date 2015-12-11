// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.MpegAudioHeader;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            c

final class g extends c
{

    private final ParsableByteArray b = new ParsableByteArray(4);
    private final MpegAudioHeader c = new MpegAudioHeader();
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private long h;
    private int i;
    private long j;

    public g(TrackOutput trackoutput)
    {
        super(trackoutput);
        d = 0;
        b.data[0] = -1;
    }

    public final void a()
    {
        d = 0;
        e = 0;
        g = false;
    }

    public final void a(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        if (flag)
        {
            j = l;
        }
label0:
        do
        {
            if (parsablebytearray.bytesLeft() <= 0)
            {
                break;
            }
            switch (d)
            {
            default:
                break;

            case 0: // '\0'
                byte abyte0[] = parsablebytearray.data;
                int k = parsablebytearray.getPosition();
                int k1 = parsablebytearray.limit();
                do
                {
                    if (k >= k1)
                    {
                        break;
                    }
                    boolean flag1;
                    if ((abyte0[k] & 0xff) == 255)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (g && (abyte0[k] & 0xe0) == 224)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    g = flag;
                    if (flag1)
                    {
                        parsablebytearray.setPosition(k + 1);
                        g = false;
                        b.data[1] = abyte0[k];
                        e = 2;
                        d = 1;
                        continue label0;
                    }
                    k++;
                } while (true);
                parsablebytearray.setPosition(k1);
                break;

            case 1: // '\001'
                int i1 = Math.min(parsablebytearray.bytesLeft(), 4 - e);
                parsablebytearray.readBytes(b.data, e, i1);
                e = i1 + e;
                if (e >= 4)
                {
                    b.setPosition(0);
                    if (!MpegAudioHeader.populateHeader(b.readInt(), c))
                    {
                        e = 0;
                        d = 1;
                    } else
                    {
                        i = c.frameSize;
                        if (!f)
                        {
                            h = (0xf4240L * (long)c.samplesPerFrame) / (long)c.sampleRate;
                            MediaFormat mediaformat = MediaFormat.createAudioFormat(c.mimeType, 4096, -1L, c.channels, c.sampleRate, null);
                            a.format(mediaformat);
                            f = true;
                        }
                        b.setPosition(0);
                        a.sampleData(b, 4);
                        d = 2;
                    }
                }
                break;

            case 2: // '\002'
                int j1 = Math.min(parsablebytearray.bytesLeft(), i - e);
                a.sampleData(parsablebytearray, j1);
                e = j1 + e;
                if (e >= i)
                {
                    a.sampleMetadata(j, 1, i, 0, null);
                    j = j + h;
                    e = 0;
                    d = 0;
                }
                break;
            }
        } while (true);
    }

    public final void b()
    {
    }
}
