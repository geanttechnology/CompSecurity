// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import shared_presage.com.google.android.exoplayer.extractor.Extractor;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.extractor.PositionHolder;
import shared_presage.com.google.android.exoplayer.extractor.SeekMap;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.NalUnitUtil;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.mp4:
//            f, a, b, Track, 
//            d

public final class Mp4Extractor
    implements Extractor, SeekMap
{
    private static final class a
    {

        public final Track a;
        public final f b;
        public final TrackOutput c;
        public int d;

        public a(Track track, f f1, TrackOutput trackoutput)
        {
            a = track;
            b = f1;
            c = trackoutput;
        }
    }


    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 0x40000L;
    private static final int STATE_AFTER_SEEK = 0;
    private static final int STATE_READING_ATOM_HEADER = 1;
    private static final int STATE_READING_ATOM_PAYLOAD = 2;
    private static final int STATE_READING_SAMPLE = 3;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader = new ParsableByteArray(16);
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final Stack containerAtoms = new Stack();
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength = new ParsableByteArray(4);
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private a tracks[];

    public Mp4Extractor()
    {
        nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        enterReadingAtomHeaderState();
    }

    private void enterReadingAtomHeaderState()
    {
        parserState = 1;
        atomHeaderBytesRead = 0;
    }

    private int getTrackIndexOfEarliestCurrentSample()
    {
        int j = -1;
        long l1 = 0x7fffffffffffffffL;
        for (int i = 0; i < tracks.length;)
        {
            a a1 = tracks[i];
            int l = a1.d;
            int k = j;
            long l2 = l1;
            if (l != a1.b.a)
            {
                long l3 = a1.b.b[l];
                k = j;
                l2 = l1;
                if (l3 < l1)
                {
                    l2 = l3;
                    k = i;
                }
            }
            i++;
            j = k;
            l1 = l2;
        }

        return j;
    }

    private void processMoovAtom(a.a a1)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < a1.aj.size(); i++)
        {
            Object obj = (a.a)a1.aj.get(i);
            if (((a.a) (obj)).ag != shared_presage.com.google.android.exoplayer.extractor.mp4.a.u)
            {
                continue;
            }
            Track track = b.a(((a.a) (obj)), a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.t));
            if (track == null)
            {
                continue;
            }
            obj = b.a(track, ((a.a) (obj)).e(shared_presage.com.google.android.exoplayer.extractor.mp4.a.v).e(shared_presage.com.google.android.exoplayer.extractor.mp4.a.w).e(shared_presage.com.google.android.exoplayer.extractor.mp4.a.x));
            if (((f) (obj)).a != 0)
            {
                a a2 = new a(track, ((f) (obj)), extractorOutput.track(i));
                a2.c.format(track.mediaFormat);
                arraylist.add(a2);
                long al[] = ((f) (obj)).b;
            }
        }

        tracks = (a[])arraylist.toArray(new a[0]);
        extractorOutput.endTracks();
        extractorOutput.seekMap(this);
    }

    private boolean readAtomHeader(ExtractorInput extractorinput)
    {
        if (atomHeaderBytesRead == 0)
        {
            if (!extractorinput.readFully(atomHeader.data, 0, 8, true))
            {
                return false;
            }
            atomHeaderBytesRead = 8;
            atomHeader.setPosition(0);
            atomSize = atomHeader.readUnsignedInt();
            atomType = atomHeader.readInt();
        }
        if (atomSize == 1L)
        {
            extractorinput.readFully(atomHeader.data, 8, 8);
            atomHeaderBytesRead = atomHeaderBytesRead + 8;
            atomSize = atomHeader.readUnsignedLongToLong();
        }
        if (shouldParseContainerAtom(atomType))
        {
            long l = extractorinput.getPosition();
            long l1 = atomSize;
            long l2 = atomHeaderBytesRead;
            containerAtoms.add(new a.a(atomType, (l + l1) - l2));
            enterReadingAtomHeaderState();
        } else
        if (shouldParseLeafAtom(atomType))
        {
            boolean flag;
            if (atomHeaderBytesRead == 8)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            if (atomSize <= 0x7fffffffL)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            atomData = new ParsableByteArray((int)atomSize);
            System.arraycopy(atomHeader.data, 0, atomData.data, 0, 8);
            parserState = 2;
        } else
        {
            atomData = null;
            parserState = 2;
        }
        return true;
    }

    private boolean readAtomPayload(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        long l = atomSize - (long)atomHeaderBytesRead;
        long l1 = extractorinput.getPosition();
        if (atomData != null)
        {
            extractorinput.readFully(atomData.data, atomHeaderBytesRead, (int)l);
            boolean flag;
            if (!containerAtoms.isEmpty())
            {
                ((a.a)containerAtoms.peek()).a(new a.b(atomType, atomData));
                flag = false;
            } else
            {
                flag = false;
            }
        } else
        if (l < 0x40000L)
        {
            extractorinput.skipFully((int)l);
            flag = false;
        } else
        {
            positionholder.position = l + extractorinput.getPosition();
            flag = true;
        }
        do
        {
            if (containerAtoms.isEmpty() || ((a.a)containerAtoms.peek()).ah != l1 + l)
            {
                break;
            }
            extractorinput = (a.a)containerAtoms.pop();
            if (((a.a) (extractorinput)).ag == shared_presage.com.google.android.exoplayer.extractor.mp4.a.s)
            {
                processMoovAtom(extractorinput);
                containerAtoms.clear();
                parserState = 3;
                return false;
            }
            if (!containerAtoms.isEmpty())
            {
                ((a.a)containerAtoms.peek()).a(extractorinput);
            }
        } while (true);
        enterReadingAtomHeaderState();
        return flag;
    }

    private int readSample(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        int i = getTrackIndexOfEarliestCurrentSample();
        if (i == -1)
        {
            return -1;
        }
        a a1 = tracks[i];
        TrackOutput trackoutput = a1.c;
        i = a1.d;
        long l1 = a1.b.b[i];
        long l2 = (l1 - extractorinput.getPosition()) + (long)sampleBytesWritten;
        if (l2 < 0L || l2 >= 0x40000L)
        {
            positionholder.position = l1;
            return 1;
        }
        extractorinput.skipFully((int)l2);
        sampleSize = a1.b.c[i];
        if (a1.a.nalUnitLengthFieldLength != -1)
        {
            positionholder = nalLength.data;
            positionholder[0] = 0;
            positionholder[1] = 0;
            positionholder[2] = 0;
            int j = a1.a.nalUnitLengthFieldLength;
            int l = 4 - a1.a.nalUnitLengthFieldLength;
            while (sampleBytesWritten < sampleSize) 
            {
                if (sampleCurrentNalBytesRemaining == 0)
                {
                    extractorinput.readFully(nalLength.data, l, j);
                    nalLength.setPosition(0);
                    sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
                    nalStartCode.setPosition(0);
                    trackoutput.sampleData(nalStartCode, 4);
                    sampleBytesWritten = sampleBytesWritten + 4;
                    sampleSize = sampleSize + l;
                } else
                {
                    int i1 = trackoutput.sampleData(extractorinput, sampleCurrentNalBytesRemaining, false);
                    sampleBytesWritten = sampleBytesWritten + i1;
                    sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - i1;
                }
            }
        } else
        {
            while (sampleBytesWritten < sampleSize) 
            {
                int k = trackoutput.sampleData(extractorinput, sampleSize - sampleBytesWritten, false);
                sampleBytesWritten = sampleBytesWritten + k;
                sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - k;
            }
        }
        trackoutput.sampleMetadata(a1.b.d[i], a1.b.e[i], sampleSize, 0, null);
        a1.d = a1.d + 1;
        sampleBytesWritten = 0;
        sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private static boolean shouldParseContainerAtom(int i)
    {
        return i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.s || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.u || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.v || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.w || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.x;
    }

    private static boolean shouldParseLeafAtom(int i)
    {
        return i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.F || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.t || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.G || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.V || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.W || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.H || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.b || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.y || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.i || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.A || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.Y || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.Z || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.aa || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.ab || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.ac || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.ad || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.ae || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.E || i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.f;
    }

    public final long getPosition(long l)
    {
        int k;
        long l1;
        l1 = 0x7fffffffffffffffL;
        k = 0;
_L11:
        f f1;
        int i;
        if (k >= tracks.length)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        f1 = tracks[k].b;
        i = Util.binarySearchFloor(f1.d, l, true, false);
_L8:
        if (i < 0) goto _L2; else goto _L1
_L1:
        if (f1.d[i] > l || (f1.e[i] & 1) == 0) goto _L4; else goto _L3
_L3:
        int j = i;
        if (i != -1) goto _L6; else goto _L5
_L5:
        j = Util.binarySearchCeil(f1.d, l, true, false);
_L9:
        if (j >= f1.d.length)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        if (f1.d[j] < l || (f1.e[j] & 1) == 0) goto _L7; else goto _L6
_L6:
        tracks[k].d = j;
        long l3 = f1.b[tracks[k].d];
        long l2 = l1;
        if (l3 < l1)
        {
            l2 = l3;
        }
        k++;
        l1 = l2;
        continue; /* Loop/switch isn't completed */
_L4:
        i--;
          goto _L8
_L2:
        i = -1;
          goto _L3
_L7:
        j++;
          goto _L9
        j = -1;
          goto _L6
        return l1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
    }

    public final boolean isSeekable()
    {
        return true;
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
label0:
        do
        {
label1:
            do
            {
                switch (parserState)
                {
                default:
                    return readSample(extractorinput, positionholder);

                case 2: // '\002'
                    continue label0;

                case 0: // '\0'
                    if (extractorinput.getPosition() == 0L)
                    {
                        enterReadingAtomHeaderState();
                    } else
                    {
                        parserState = 3;
                    }
                    break;

                case 1: // '\001'
                    if (!readAtomHeader(extractorinput))
                    {
                        break label1;
                    }
                    break;
                }
            } while (true);
            return -1;
        } while (!readAtomPayload(extractorinput, positionholder));
        return 1;
    }

    public final void seek()
    {
        containerAtoms.clear();
        atomHeaderBytesRead = 0;
        sampleBytesWritten = 0;
        sampleCurrentNalBytesRemaining = 0;
        parserState = 0;
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        return d.b(extractorinput);
    }
}
