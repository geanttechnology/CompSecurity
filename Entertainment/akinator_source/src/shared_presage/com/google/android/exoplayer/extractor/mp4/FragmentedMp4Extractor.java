// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp4;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import shared_presage.com.google.android.exoplayer.extractor.ChunkIndex;
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
//            e, Track, TrackEncryptionBox, a, 
//            PsshAtomUtil, b, c, d

public final class FragmentedMp4Extractor
    implements Extractor
{

    private static final byte PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE[] = {
        -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 
        108, 66, 124, 100, -115, -12
    };
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    public static final int WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final Stack containerAtoms;
    private final ParsableByteArray encryptionSignalByte;
    private final byte extendedTypeScratch[];
    private c extendsDefaults;
    private ExtractorOutput extractorOutput;
    private final e fragmentRun;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleIndex;
    private int sampleSize;
    private Track track;
    private TrackOutput trackOutput;
    private final int workaroundFlags;

    public FragmentedMp4Extractor()
    {
        this(0);
    }

    public FragmentedMp4Extractor(int i)
    {
        workaroundFlags = i;
        atomHeader = new ParsableByteArray(16);
        nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        nalLength = new ParsableByteArray(4);
        encryptionSignalByte = new ParsableByteArray(1);
        extendedTypeScratch = new byte[16];
        containerAtoms = new Stack();
        fragmentRun = new e();
        enterReadingAtomHeaderState();
    }

    private int appendSampleEncryptionData(ParsableByteArray parsablebytearray)
    {
        int j = track.sampleDescriptionEncryptionBoxes[fragmentRun.a].initializationVectorSize;
        boolean flag = fragmentRun.h[sampleIndex];
        byte abyte0[] = encryptionSignalByte.data;
        char c1;
        if (flag)
        {
            c1 = '\200';
        } else
        {
            c1 = '\0';
        }
        abyte0[0] = (byte)(c1 | j);
        encryptionSignalByte.setPosition(0);
        trackOutput.sampleData(encryptionSignalByte, 1);
        trackOutput.sampleData(parsablebytearray, j);
        if (!flag)
        {
            return j + 1;
        } else
        {
            int i = parsablebytearray.readUnsignedShort();
            parsablebytearray.skipBytes(-2);
            i = i * 6 + 2;
            trackOutput.sampleData(parsablebytearray, i);
            return i + (j + 1);
        }
    }

    private void enterReadingAtomHeaderState()
    {
        parserState = 0;
        atomHeaderBytesRead = 0;
    }

    private void onContainerAtomRead(a.a a1)
    {
        if (a1.ag == a.s)
        {
            onMoovContainerAtomRead(a1);
        } else
        {
            if (a1.ag == a.B)
            {
                onMoofContainerAtomRead(a1);
                return;
            }
            if (!containerAtoms.isEmpty())
            {
                ((a.a)containerAtoms.peek()).a(a1);
                return;
            }
        }
    }

    private void onLeafAtomRead(a.b b1, long l)
    {
        if (!containerAtoms.isEmpty())
        {
            ((a.a)containerAtoms.peek()).a(b1);
        } else
        if (b1.ag == a.r)
        {
            b1 = parseSidx(b1.ah, l);
            extractorOutput.seekMap(b1);
            haveOutputSeekMap = true;
            return;
        }
    }

    private void onMoofContainerAtomRead(a.a a1)
    {
        e e1 = fragmentRun;
        e1.b = 0;
        e1.g = false;
        e1.k = false;
        parseMoof(track, extendsDefaults, a1, fragmentRun, workaroundFlags, extendedTypeScratch);
        sampleIndex = 0;
    }

    private void onMoovContainerAtomRead(a.a a1)
    {
        List list = a1.ai;
        int j = list.size();
        byte abyte0[] = null;
        for (int i = 0; i < j;)
        {
            a.b b1 = (a.b)list.get(i);
            Object obj = abyte0;
            if (b1.ag == a.I)
            {
                obj = abyte0;
                if (abyte0 == null)
                {
                    obj = new shared_presage.com.google.android.exoplayer.drm.DrmInitData.Mapped("video/mp4");
                }
                abyte0 = b1.ah.data;
                ((shared_presage.com.google.android.exoplayer.drm.DrmInitData.Mapped) (obj)).put(PsshAtomUtil.parseUuid(abyte0), abyte0);
            }
            i++;
            abyte0 = ((byte []) (obj));
        }

        if (abyte0 != null)
        {
            extractorOutput.drmInitData(abyte0);
        }
        extendsDefaults = parseTrex(a1.e(a.D).d(a.p).ah);
        track = b.a(a1.e(a.u), a1.d(a.t));
        boolean flag;
        if (track != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        trackOutput.format(track.mediaFormat);
    }

    private static void parseMoof(Track track1, c c1, a.a a1, e e1, int i, byte abyte0[])
    {
        parseTraf(track1, c1, a1.e(a.C), e1, i, abyte0);
    }

    private static void parseSaiz(TrackEncryptionBox trackencryptionbox, ParsableByteArray parsablebytearray, e e1)
    {
        boolean flag = true;
        int i1 = trackencryptionbox.initializationVectorSize;
        parsablebytearray.setPosition(8);
        if ((a.b(parsablebytearray.readInt()) & 1) == 1)
        {
            parsablebytearray.skipBytes(8);
        }
        int i = parsablebytearray.readUnsignedByte();
        int l = parsablebytearray.readUnsignedIntToInt();
        if (l != e1.b)
        {
            throw new IllegalStateException((new StringBuilder("Length mismatch: ")).append(l).append(", ").append(e1.b).toString());
        }
        int k;
        if (i == 0)
        {
            trackencryptionbox = e1.h;
            i = 0;
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                k = parsablebytearray.readUnsignedByte();
                if (k > i1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                trackencryptionbox[j] = flag;
                j++;
                i += k;
            } while (true);
        } else
        {
            if (i <= i1)
            {
                flag = false;
            }
            k = i * l + 0;
            Arrays.fill(e1.h, 0, l, flag);
        }
        e1.a(k);
    }

    private static void parseSenc(ParsableByteArray parsablebytearray, int i, e e1)
    {
        parsablebytearray.setPosition(i + 8);
        i = a.b(parsablebytearray.readInt());
        if ((i & 1) != 0)
        {
            throw new IllegalStateException("Overriding TrackEncryptionBox parameters is unsupported");
        }
        boolean flag;
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = parsablebytearray.readUnsignedIntToInt();
        if (i != e1.b)
        {
            throw new IllegalStateException((new StringBuilder("Length mismatch: ")).append(i).append(", ").append(e1.b).toString());
        } else
        {
            Arrays.fill(e1.h, 0, i, flag);
            e1.a(parsablebytearray.bytesLeft());
            parsablebytearray.readBytes(e1.j.data, 0, e1.i);
            e1.j.setPosition(0);
            e1.k = false;
            return;
        }
    }

    private static void parseSenc(ParsableByteArray parsablebytearray, e e1)
    {
        parseSenc(parsablebytearray, 0, e1);
    }

    private static ChunkIndex parseSidx(ParsableByteArray parsablebytearray, long l)
    {
        parsablebytearray.setPosition(8);
        int i = a.a(parsablebytearray.readInt());
        parsablebytearray.skipBytes(4);
        long l3 = parsablebytearray.readUnsignedInt();
        int ai[];
        long al[];
        long al1[];
        long al2[];
        int k;
        long l1;
        long l2;
        if (i == 0)
        {
            l1 = parsablebytearray.readUnsignedInt();
            l = parsablebytearray.readUnsignedInt() + l;
        } else
        {
            l1 = parsablebytearray.readUnsignedLongToLong();
            l = parsablebytearray.readUnsignedLongToLong() + l;
        }
        parsablebytearray.skipBytes(2);
        k = parsablebytearray.readUnsignedShort();
        ai = new int[k];
        al = new long[k];
        al1 = new long[k];
        al2 = new long[k];
        l2 = Util.scaleLargeTimestamp(l1, 0xf4240L, l3);
        for (int j = 0; j < k; j++)
        {
            int i1 = parsablebytearray.readInt();
            if ((0x80000000 & i1) != 0)
            {
                throw new IllegalStateException("Unhandled indirect reference");
            }
            long l4 = parsablebytearray.readUnsignedInt();
            ai[j] = i1 & 0x7fffffff;
            al[j] = l;
            al2[j] = l2;
            l1 += l4;
            l2 = Util.scaleLargeTimestamp(l1, 0xf4240L, l3);
            al1[j] = l2 - al2[j];
            parsablebytearray.skipBytes(4);
            l += ai[j];
        }

        return new ChunkIndex(ai, al, al1, al2);
    }

    private static long parseTfdt(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(8);
        if (a.a(parsablebytearray.readInt()) == 1)
        {
            return parsablebytearray.readUnsignedLongToLong();
        } else
        {
            return parsablebytearray.readUnsignedInt();
        }
    }

    private static c parseTfhd(c c1, ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(8);
        int l = a.b(parsablebytearray.readInt());
        parsablebytearray.skipBytes(4);
        if ((l & 1) != 0)
        {
            parsablebytearray.skipBytes(8);
        }
        int i;
        int j;
        int k;
        if ((l & 2) != 0)
        {
            i = parsablebytearray.readUnsignedIntToInt() - 1;
        } else
        {
            i = c1.a;
        }
        if ((l & 8) != 0)
        {
            j = parsablebytearray.readUnsignedIntToInt();
        } else
        {
            j = c1.b;
        }
        if ((l & 0x10) != 0)
        {
            k = parsablebytearray.readUnsignedIntToInt();
        } else
        {
            k = c1.c;
        }
        if ((l & 0x20) != 0)
        {
            l = parsablebytearray.readUnsignedIntToInt();
        } else
        {
            l = c1.d;
        }
        return new c(i, j, k, l);
    }

    private static void parseTraf(Track track1, c c1, a.a a1, e e1, int i, byte abyte0[])
    {
        a.b b1;
        int j;
        long l;
        if (a1.d(a.n) == null)
        {
            l = 0L;
        } else
        {
            l = parseTfdt(a1.d(a.n).ah);
        }
        c1 = parseTfhd(c1, a1.d(a.o).ah);
        e1.a = c1.a;
        parseTrun(track1, c1, l, i, a1.d(a.q).ah, e1);
        b1 = a1.d(a.Q);
        if (b1 != null)
        {
            parseSaiz(track1.sampleDescriptionEncryptionBoxes[c1.a], b1.ah, e1);
        }
        track1 = a1.d(a.S);
        if (track1 != null)
        {
            parseSenc(((a.b) (track1)).ah, 0, e1);
        }
        j = a1.ai.size();
        for (i = 0; i < j; i++)
        {
            track1 = (a.b)a1.ai.get(i);
            if (((a.b) (track1)).ag == a.R)
            {
                parseUuid(((a.b) (track1)).ah, e1, abyte0);
            }
        }

    }

    private static c parseTrex(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(16);
        return new c(parsablebytearray.readUnsignedIntToInt() - 1, parsablebytearray.readUnsignedIntToInt(), parsablebytearray.readUnsignedIntToInt(), parsablebytearray.readInt());
    }

    private static void parseTrun(Track track1, c c1, long l, int i, ParsableByteArray parsablebytearray, e e1)
    {
        parsablebytearray.setPosition(8);
        int k = a.b(parsablebytearray.readInt());
        int i2 = parsablebytearray.readUnsignedIntToInt();
        if ((k & 1) != 0)
        {
            parsablebytearray.skipBytes(4);
        }
        int ai[];
        int ai1[];
        long al[];
        int j;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        int j1;
        long l2;
        if ((k & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = c1.d;
        if (flag)
        {
            j = parsablebytearray.readUnsignedIntToInt();
        }
        if ((k & 0x100) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if ((k & 0x200) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if ((k & 0x400) != 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if ((k & 0x800) != 0)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        e1.b = i2;
        if (e1.c == null || e1.c.length < e1.b)
        {
            int i1 = (i2 * 125) / 100;
            e1.c = new int[i1];
            e1.d = new int[i1];
            e1.e = new long[i1];
            e1.f = new boolean[i1];
            e1.h = new boolean[i1];
        }
        ai = e1.c;
        ai1 = e1.d;
        al = e1.e;
        e1 = e1.f;
        l2 = track1.timescale;
        if (track1.type == Track.TYPE_VIDEO && (i & 1) == 1)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        j1 = 0;
        while (j1 < i2) 
        {
            int k1;
            int l1;
            byte byte0;
            if (flag1)
            {
                k1 = parsablebytearray.readUnsignedIntToInt();
            } else
            {
                k1 = c1.b;
            }
            if (flag2)
            {
                l1 = parsablebytearray.readUnsignedIntToInt();
            } else
            {
                l1 = c1.c;
            }
            if (j1 == 0 && flag)
            {
                i = j;
            } else
            if (flag3)
            {
                i = parsablebytearray.readInt();
            } else
            {
                i = c1.d;
            }
            if (flag4)
            {
                ai1[j1] = (int)((long)(parsablebytearray.readInt() * 1000) / l2);
            } else
            {
                ai1[j1] = 0;
            }
            al[j1] = (1000L * l) / l2;
            ai[j1] = l1;
            if ((i >> 16 & 1) == 0 && (!flag5 || j1 == 0))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            e1[j1] = byte0;
            l += k1;
            j1++;
        }
    }

    private static void parseUuid(ParsableByteArray parsablebytearray, e e1, byte abyte0[])
    {
        parsablebytearray.setPosition(8);
        parsablebytearray.readBytes(abyte0, 0, 16);
        if (!Arrays.equals(abyte0, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE))
        {
            return;
        } else
        {
            parseSenc(parsablebytearray, 16, e1);
            return;
        }
    }

    private boolean readAtomHeader(ExtractorInput extractorinput)
    {
        boolean flag = false;
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
        if (atomType == a.h)
        {
            if (!haveOutputSeekMap)
            {
                extractorOutput.seekMap(SeekMap.UNSEEKABLE);
                haveOutputSeekMap = true;
            }
            if (fragmentRun.k)
            {
                parserState = 2;
                return true;
            } else
            {
                parserState = 3;
                return true;
            }
        }
        if (shouldParseAtom(atomType))
        {
            if (shouldParseContainerAtom(atomType))
            {
                long l = extractorinput.getPosition();
                long l1 = atomSize;
                containerAtoms.add(new a.a(atomType, (l + l1) - 8L));
                enterReadingAtomHeaderState();
                return true;
            }
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
            parserState = 1;
            return true;
        }
        if (atomSize <= 0x7fffffffL)
        {
            flag = true;
        }
        Assertions.checkState(flag);
        atomData = null;
        parserState = 1;
        return true;
    }

    private void readAtomPayload(ExtractorInput extractorinput)
    {
        int i = (int)atomSize - atomHeaderBytesRead;
        long l;
        if (atomData != null)
        {
            extractorinput.readFully(atomData.data, 8, i);
            onLeafAtomRead(new a.b(atomType, atomData), extractorinput.getPosition());
        } else
        {
            extractorinput.skipFully(i);
        }
        for (l = extractorinput.getPosition(); !containerAtoms.isEmpty() && ((a.a)containerAtoms.peek()).ah == l; onContainerAtomRead((a.a)containerAtoms.pop())) { }
        enterReadingAtomHeaderState();
    }

    private void readEncryptionData(ExtractorInput extractorinput)
    {
        e e1 = fragmentRun;
        extractorinput.readFully(e1.j.data, 0, e1.i);
        e1.j.setPosition(0);
        e1.k = false;
        parserState = 3;
    }

    private boolean readSample(ExtractorInput extractorinput)
    {
        byte byte0 = 2;
        if (sampleIndex >= fragmentRun.b)
        {
            enterReadingAtomHeaderState();
            return false;
        }
        if (parserState == 3)
        {
            sampleSize = fragmentRun.c[sampleIndex];
            byte abyte0[];
            int i;
            int k;
            if (fragmentRun.g)
            {
                sampleBytesWritten = appendSampleEncryptionData(fragmentRun.j);
                sampleSize = sampleSize + sampleBytesWritten;
            } else
            {
                sampleBytesWritten = 0;
            }
            sampleCurrentNalBytesRemaining = 0;
            parserState = 4;
        }
        if (track.nalUnitLengthFieldLength != -1)
        {
            abyte0 = nalLength.data;
            abyte0[0] = 0;
            abyte0[1] = 0;
            abyte0[2] = 0;
            i = track.nalUnitLengthFieldLength;
            k = 4 - track.nalUnitLengthFieldLength;
            while (sampleBytesWritten < sampleSize) 
            {
                if (sampleCurrentNalBytesRemaining == 0)
                {
                    extractorinput.readFully(nalLength.data, k, i);
                    nalLength.setPosition(0);
                    sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
                    nalStartCode.setPosition(0);
                    trackOutput.sampleData(nalStartCode, 4);
                    sampleBytesWritten = sampleBytesWritten + 4;
                    sampleSize = sampleSize + k;
                } else
                {
                    int l = trackOutput.sampleData(extractorinput, sampleCurrentNalBytesRemaining, false);
                    sampleBytesWritten = sampleBytesWritten + l;
                    sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - l;
                }
            }
        } else
        {
            for (; sampleBytesWritten < sampleSize; sampleBytesWritten = trackOutput.sampleData(extractorinput, sampleSize - sampleBytesWritten, false) + sampleBytesWritten) { }
        }
        extractorinput = fragmentRun;
        int j = sampleIndex;
        long l1 = ((e) (extractorinput)).e[j];
        long l2 = ((e) (extractorinput)).d[j];
        if (!fragmentRun.g)
        {
            byte0 = 0;
        }
        if (fragmentRun.f[sampleIndex])
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (fragmentRun.g)
        {
            extractorinput = track.sampleDescriptionEncryptionBoxes[fragmentRun.a].keyId;
        } else
        {
            extractorinput = null;
        }
        trackOutput.sampleMetadata((l2 + l1) * 1000L, byte0 | j, sampleSize, 0, extractorinput);
        sampleIndex = sampleIndex + 1;
        parserState = 3;
        return true;
    }

    private static boolean shouldParseAtom(int i)
    {
        return i == a.b || i == a.c || i == a.A || i == a.G || i == a.h || i == a.F || i == a.B || i == a.s || i == a.i || i == a.t || i == a.r || i == a.H || i == a.n || i == a.o || i == a.E || i == a.C || i == a.u || i == a.p || i == a.q || i == a.D || i == a.v || i == a.w || i == a.x || i == a.I || i == a.Q || i == a.R || i == a.S || i == a.T || i == a.f;
    }

    private static boolean shouldParseContainerAtom(int i)
    {
        return i == a.s || i == a.u || i == a.v || i == a.w || i == a.x || i == a.y || i == a.B || i == a.C || i == a.D;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
        trackOutput = extractoroutput.track(0);
        extractorOutput.endTracks();
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        do
        {
            switch (parserState)
            {
            default:
                if (readSample(extractorinput))
                {
                    return 0;
                }
                break;

            case 0: // '\0'
                if (!readAtomHeader(extractorinput))
                {
                    return -1;
                }
                break;

            case 1: // '\001'
                readAtomPayload(extractorinput);
                break;

            case 2: // '\002'
                readEncryptionData(extractorinput);
                break;
            }
        } while (true);
    }

    public final void seek()
    {
        containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    public final void setTrack(Track track1)
    {
        extendsDefaults = new c(0, 0, 0, 0);
        track = track1;
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        return d.a(extractorinput);
    }

}
