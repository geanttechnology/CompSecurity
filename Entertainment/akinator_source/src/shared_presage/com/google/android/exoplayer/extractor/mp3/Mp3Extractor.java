// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp3;

import java.io.EOFException;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.extractor.Extractor;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.extractor.PositionHolder;
import shared_presage.com.google.android.exoplayer.extractor.SeekMap;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.MpegAudioHeader;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.mp3:
//            a, d, c, b

public final class Mp3Extractor
    implements Extractor
{
    static interface a
        extends SeekMap
    {

        public abstract long a();

        public abstract long a(long l);
    }


    private static final int HEADER_MASK = 0xfffe0c00;
    private static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private static final int INFO_HEADER = Util.getIntegerCodeForString("Info");
    private static final int MAX_SNIFF_BYTES = 4096;
    private static final int MAX_SYNC_BYTES = 0x20000;
    private static final int VBRI_HEADER = Util.getIntegerCodeForString("VBRI");
    private static final int XING_HEADER = Util.getIntegerCodeForString("Xing");
    private long basisTimeUs;
    private ExtractorOutput extractorOutput;
    private final shared_presage.com.google.android.exoplayer.extractor.mp3.a inputBuffer = new shared_presage.com.google.android.exoplayer.extractor.mp3.a();
    private int sampleBytesRemaining;
    private int samplesRead;
    private final ParsableByteArray scratch = new ParsableByteArray(4);
    private a seeker;
    private final MpegAudioHeader synchronizedHeader = new MpegAudioHeader();
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;

    public Mp3Extractor()
    {
    }

    private static long getPosition(ExtractorInput extractorinput, shared_presage.com.google.android.exoplayer.extractor.mp3.a a1)
    {
        return extractorinput.getPosition() - (long)a1.d();
    }

    private long maybeResynchronize(ExtractorInput extractorinput)
    {
        inputBuffer.b();
        if (!inputBuffer.a(extractorinput, scratch.data))
        {
            return -1L;
        }
        inputBuffer.c();
        scratch.setPosition(0);
        int i = scratch.readInt();
        if ((i & 0xfffe0c00) == (synchronizedHeaderData & 0xfffe0c00) && MpegAudioHeader.getFrameSize(i) != -1)
        {
            MpegAudioHeader.populateHeader(i, synchronizedHeader);
            return 0L;
        } else
        {
            synchronizedHeaderData = 0;
            inputBuffer.b(extractorinput, 1);
            return synchronizeCatchingEndOfInput(extractorinput);
        }
    }

    private boolean parseSeekerFrame(ExtractorInput extractorinput, long l, long l1)
    {
        int i;
        i = 17;
        inputBuffer.b();
        seeker = null;
        extractorinput = inputBuffer.a(extractorinput, synchronizedHeader.frameSize);
        if ((synchronizedHeader.version & 1) != 1) goto _L2; else goto _L1
_L1:
        if (synchronizedHeader.channels != 1)
        {
            i = 32;
        }
_L4:
        extractorinput.setPosition(i + 4);
        i = extractorinput.readInt();
        if (i == XING_HEADER || i == INFO_HEADER)
        {
            seeker = d.a(synchronizedHeader, extractorinput, l, l1);
            return true;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (synchronizedHeader.channels == 1)
        {
            i = 9;
        }
        if (true) goto _L4; else goto _L3
_L3:
        extractorinput.setPosition(36);
        if (extractorinput.readInt() == VBRI_HEADER)
        {
            seeker = c.a(synchronizedHeader, extractorinput, l);
            return true;
        } else
        {
            return false;
        }
    }

    private int readSample(ExtractorInput extractorinput)
    {
        byte byte0 = 0;
        if (sampleBytesRemaining != 0) goto _L2; else goto _L1
_L1:
        if (maybeResynchronize(extractorinput) != -1L) goto _L4; else goto _L3
_L3:
        byte0 = -1;
_L6:
        return byte0;
_L4:
        if (basisTimeUs == -1L)
        {
            basisTimeUs = seeker.a(getPosition(extractorinput, inputBuffer));
        }
        sampleBytesRemaining = synchronizedHeader.frameSize;
_L2:
        long l;
        long l1;
        l = basisTimeUs;
        l1 = ((long)samplesRead * 0xf4240L) / (long)synchronizedHeader.sampleRate;
        sampleBytesRemaining = sampleBytesRemaining - inputBuffer.a(trackOutput, sampleBytesRemaining);
        if (sampleBytesRemaining <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        inputBuffer.b();
        int i = trackOutput.sampleData(extractorinput, sampleBytesRemaining, true);
        if (i == -1)
        {
            return -1;
        }
        sampleBytesRemaining = sampleBytesRemaining - i;
        if (sampleBytesRemaining > 0) goto _L6; else goto _L5
_L5:
        trackOutput.sampleMetadata(l + l1, 1, synchronizedHeader.frameSize, 0, null);
        samplesRead = samplesRead + synchronizedHeader.samplesPerFrame;
        sampleBytesRemaining = 0;
        return 0;
    }

    private void setupSeeker(ExtractorInput extractorinput, long l)
    {
        if (parseSeekerFrame(extractorinput, l, extractorinput.getLength()))
        {
            inputBuffer.b();
            if (seeker != null)
            {
                return;
            }
            inputBuffer.a(extractorinput, scratch.data, 4);
            scratch.setPosition(0);
            l += synchronizedHeader.frameSize;
            MpegAudioHeader.populateHeader(scratch.readInt(), synchronizedHeader);
        }
        inputBuffer.c();
        seeker = new b(l, synchronizedHeader.bitrate * 1000, extractorinput.getLength());
    }

    private long synchronize(ExtractorInput extractorinput)
    {
        int i;
        int j;
        long l1;
        long l2;
        if (extractorinput.getPosition() == 0L)
        {
            inputBuffer.a();
        } else
        {
            inputBuffer.c();
        }
        l2 = getPosition(extractorinput, inputBuffer);
        l1 = l2;
        if (l2 == 0L)
        {
            inputBuffer.a(extractorinput, scratch.data, 3);
            scratch.setPosition(0);
            if (scratch.readUnsignedInt24() == ID3_TAG)
            {
                extractorinput.skipFully(3);
                extractorinput.readFully(scratch.data, 0, 4);
                extractorinput.skipFully((scratch.data[0] & 0x7f) << 21 | (scratch.data[1] & 0x7f) << 14 | (scratch.data[2] & 0x7f) << 7 | scratch.data[3] & 0x7f);
                inputBuffer.a();
                l1 = getPosition(extractorinput, inputBuffer);
            } else
            {
                inputBuffer.c();
                l1 = l2;
            }
        }
        inputBuffer.b();
        i = 0;
        l2 = l1;
        j = 0;
        do
        {
            int k;
            int l;
label0:
            {
                if (l2 - l1 >= 0x20000L)
                {
                    throw new ParserException("Searched too many bytes while resynchronizing.");
                }
                if (!inputBuffer.a(extractorinput, scratch.data))
                {
                    return -1L;
                }
                scratch.setPosition(0);
                k = scratch.readInt();
                if (i == 0 || (0xfffe0c00 & k) == (0xfffe0c00 & i))
                {
                    l = MpegAudioHeader.getFrameSize(k);
                    if (l != -1)
                    {
                        break label0;
                    }
                }
                i = 0;
                inputBuffer.c();
                inputBuffer.b(extractorinput, 1);
                inputBuffer.b();
                l2++;
                j = 0;
                continue;
            }
            if (j == 0)
            {
                MpegAudioHeader.populateHeader(k, synchronizedHeader);
                i = k;
            }
            j++;
            if (j == 4)
            {
                break;
            }
            inputBuffer.b(extractorinput, l - 4);
        } while (true);
        inputBuffer.c();
        synchronizedHeaderData = i;
        if (seeker == null)
        {
            setupSeeker(extractorinput, l2);
            extractorOutput.seekMap(seeker);
            trackOutput.format(MediaFormat.createAudioFormat(synchronizedHeader.mimeType, 4096, seeker.a(), synchronizedHeader.channels, synchronizedHeader.sampleRate, null));
        }
        return l2;
    }

    private long synchronizeCatchingEndOfInput(ExtractorInput extractorinput)
    {
        long l;
        try
        {
            l = synchronize(extractorinput);
        }
        // Misplaced declaration of an exception variable
        catch (ExtractorInput extractorinput)
        {
            return -1L;
        }
        return l;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
        trackOutput = extractoroutput.track(0);
        extractoroutput.endTracks();
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        if (synchronizedHeaderData == 0 && synchronizeCatchingEndOfInput(extractorinput) == -1L)
        {
            return -1;
        } else
        {
            return readSample(extractorinput);
        }
    }

    public final void seek()
    {
        synchronizedHeaderData = 0;
        samplesRead = 0;
        basisTimeUs = -1L;
        sampleBytesRemaining = 0;
        inputBuffer.a();
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        ParsableByteArray parsablebytearray = new ParsableByteArray(4);
        extractorinput.peekFully(parsablebytearray.data, 0, 3);
        int j;
        int k;
        int l;
        int i1;
        if (parsablebytearray.readUnsignedInt24() == ID3_TAG)
        {
            extractorinput.advancePeekPosition(3);
            extractorinput.peekFully(parsablebytearray.data, 0, 4);
            int i = (parsablebytearray.data[0] & 0x7f) << 21 | (parsablebytearray.data[1] & 0x7f) << 14 | (parsablebytearray.data[2] & 0x7f) << 7 | parsablebytearray.data[3] & 0x7f;
            extractorinput.advancePeekPosition(i);
            k = i + 10;
        } else
        {
            extractorinput.resetPeekPosition();
            k = 0;
        }
        j = 0;
        l = 0;
        i1 = k;
        do
        {
            int j1;
            int k1;
label0:
            {
                if (i1 - k >= 4096)
                {
                    return false;
                }
                extractorinput.peekFully(parsablebytearray.data, 0, 4);
                parsablebytearray.setPosition(0);
                j1 = parsablebytearray.readInt();
                if (j == 0 || (j1 & 0xfffe0c00) == (j & 0xfffe0c00))
                {
                    k1 = MpegAudioHeader.getFrameSize(j1);
                    if (k1 != -1)
                    {
                        break label0;
                    }
                }
                extractorinput.resetPeekPosition();
                i1++;
                extractorinput.advancePeekPosition(i1);
                j = 0;
                l = 0;
                continue;
            }
            if (l == 0)
            {
                j = j1;
            }
            l++;
            if (l == 4)
            {
                return true;
            }
            extractorinput.advancePeekPosition(k1 - 4);
        } while (true);
    }

}
