// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.extractor.ChunkIndex;
import shared_presage.com.google.android.exoplayer.extractor.Extractor;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.extractor.PositionHolder;
import shared_presage.com.google.android.exoplayer.extractor.SeekMap;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.LongArray;
import shared_presage.com.google.android.exoplayer.util.MimeTypes;
import shared_presage.com.google.android.exoplayer.util.NalUnitUtil;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.webm:
//            a, b, e, d, 
//            c

public final class WebmExtractor
    implements Extractor
{
    private final class a
        implements c
    {

        final WebmExtractor a;

        public final int a(int i)
        {
            return a.getElementType(i);
        }

        public final void a(int i, double d1)
        {
            a.floatElement(i, d1);
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

        private a()
        {
            a = WebmExtractor.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b
    {

        public String a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public byte f[];
        public byte g[];
        public byte h[];
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public long n;
        public long o;
        public TrackOutput p;

        private static Pair a(ParsableByteArray parsablebytearray)
        {
            boolean flag = false;
            ArrayList arraylist;
            int i1;
            int j1;
            int k1;
            boolean flag1;
            try
            {
                parsablebytearray.setPosition(4);
                j1 = (parsablebytearray.readUnsignedByte() & 3) + 1;
            }
            // Misplaced declaration of an exception variable
            catch (ParsableByteArray parsablebytearray)
            {
                throw new ParserException("Error parsing AVC codec private");
            }
            if (j1 != 3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assertions.checkState(flag1);
            arraylist = new ArrayList();
            k1 = parsablebytearray.readUnsignedByte();
            i1 = 0;
_L2:
            if (i1 >= (k1 & 0x1f))
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
            i1++;
            if (true) goto _L2; else goto _L1
_L1:
            k1 = parsablebytearray.readUnsignedByte();
            i1 = ((flag) ? 1 : 0);
_L4:
            if (i1 >= k1)
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
            i1++;
            if (true) goto _L4; else goto _L3
_L3:
            parsablebytearray = Pair.create(arraylist, Integer.valueOf(j1));
            return parsablebytearray;
        }

        private static List a(byte abyte0[])
        {
_L2:
            k1 = j1 + 1;
            j1 = abyte0[j1];
            if (abyte0[k1] == 1)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            throw new ParserException("Error parsing vorbis codec private");
            abyte1 = new byte[i2];
            System.arraycopy(abyte0, k1, abyte1, 0, i2);
            k1 = i2 + k1;
            if (abyte0[k1] == 3)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            throw new ParserException("Error parsing vorbis codec private");
            i1 = i1 + j1 + k1;
            if (abyte0[i1] == 5)
            {
                break MISSING_BLOCK_LABEL_154;
            }
            throw new ParserException("Error parsing vorbis codec private");
            byte abyte2[] = new byte[abyte0.length - i1];
            System.arraycopy(abyte0, i1, abyte2, 0, abyte0.length - i1);
            abyte0 = new ArrayList(2);
            abyte0.add(abyte1);
            abyte0.add(abyte2);
            return abyte0;
            int k1 = 0;
            if (abyte0[0] != 2)
            {
                try
                {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    throw new ParserException("Error parsing vorbis codec private");
                }
            }
            int i1 = 0;
            byte abyte1[];
            int j1;
            int i2;
            for (j1 = 1; abyte0[j1] == -1;)
            {
                j1++;
                i1 += 255;
            }

            int l1 = j1 + 1;
            i2 = i1 + abyte0[j1];
            j1 = l1;
            i1 = k1;
            while (abyte0[j1] == -1) 
            {
                i1 += 255;
                j1++;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        private static Pair b(ParsableByteArray parsablebytearray)
        {
            int i1;
            int j1;
            byte abyte0[];
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            try
            {
                parsablebytearray.setPosition(21);
                i2 = parsablebytearray.readUnsignedByte();
                j2 = parsablebytearray.readUnsignedByte();
                l1 = parsablebytearray.getPosition();
            }
            // Misplaced declaration of an exception variable
            catch (ParsableByteArray parsablebytearray)
            {
                throw new ParserException("Error parsing HEVC codec private");
            }
            j1 = 0;
            i1 = 0;
_L10:
            if (j1 >= j2) goto _L2; else goto _L1
_L1:
            parsablebytearray.skipBytes(1);
            k2 = parsablebytearray.readUnsignedShort();
            k1 = 0;
_L4:
            if (k1 >= k2)
            {
                break; /* Loop/switch isn't completed */
            }
            l2 = parsablebytearray.readUnsignedShort();
            i1 += l2 + 4;
            parsablebytearray.skipBytes(l2);
            k1++;
            if (true) goto _L4; else goto _L3
_L2:
            parsablebytearray.setPosition(l1);
            abyte0 = new byte[i1];
            j1 = 0;
            l1 = 0;
_L11:
            if (j1 >= j2) goto _L6; else goto _L5
_L5:
            parsablebytearray.skipBytes(1);
            k2 = parsablebytearray.readUnsignedShort();
            k1 = 0;
_L8:
            if (k1 >= k2)
            {
                continue; /* Loop/switch isn't completed */
            }
            l2 = parsablebytearray.readUnsignedShort();
            System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, abyte0, l1, NalUnitUtil.NAL_START_CODE.length);
            l1 += NalUnitUtil.NAL_START_CODE.length;
            System.arraycopy(parsablebytearray.data, parsablebytearray.getPosition(), abyte0, l1, l2);
            l1 += l2;
            parsablebytearray.skipBytes(l2);
            k1++;
            if (true) goto _L8; else goto _L7
_L7:
            continue; /* Loop/switch isn't completed */
_L9:
            return Pair.create(parsablebytearray, Integer.valueOf((i2 & 3) + 1));
_L13:
            parsablebytearray = Collections.singletonList(abyte0);
              goto _L9
_L3:
            j1++;
              goto _L10
            j1++;
              goto _L11
_L6:
            if (i1 != 0) goto _L13; else goto _L12
_L12:
            parsablebytearray = null;
              goto _L9
        }

        public final MediaFormat a(long l1)
        {
            Object obj;
            Object obj1;
            obj = null;
            obj1 = a;
            ((String) (obj1)).hashCode();
            JVM INSTR lookupswitch 12: default 120
        //                       -2095576542: 262
        //                       -2095575984: 230
        //                       -1730367663: 311
        //                       -1482641357: 362
        //                       -538363189: 246
        //                       -538363109: 278
        //                       62923557: 345
        //                       62923603: 379
        //                       82338133: 198
        //                       82338134: 214
        //                       855502857: 294
        //                       1951062397: 328;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
            char c1 = '\uFFFF';
_L26:
            c1;
            JVM INSTR tableswitch 0 11: default 188
        //                       0 396
        //                       1 430
        //                       2 442
        //                       3 442
        //                       4 442
        //                       5 472
        //                       6 519
        //                       7 566
        //                       8 586
        //                       9 665
        //                       10 683
        //                       11 697;
               goto _L14 _L15 _L16 _L17 _L17 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L14:
            throw new ParserException("Unrecognized codec identifier.");
_L10:
            if (!((String) (obj1)).equals("V_VP8")) goto _L1; else goto _L25
_L25:
            c1 = '\0';
              goto _L26
_L11:
            if (!((String) (obj1)).equals("V_VP9")) goto _L1; else goto _L27
_L27:
            c1 = '\001';
              goto _L26
_L3:
            if (!((String) (obj1)).equals("V_MPEG4/ISO/SP")) goto _L1; else goto _L28
_L28:
            c1 = '\002';
              goto _L26
_L6:
            if (!((String) (obj1)).equals("V_MPEG4/ISO/ASP")) goto _L1; else goto _L29
_L29:
            c1 = '\003';
              goto _L26
_L2:
            if (!((String) (obj1)).equals("V_MPEG4/ISO/AP")) goto _L1; else goto _L30
_L30:
            c1 = '\004';
              goto _L26
_L7:
            if (!((String) (obj1)).equals("V_MPEG4/ISO/AVC")) goto _L1; else goto _L31
_L31:
            c1 = '\005';
              goto _L26
_L12:
            if (!((String) (obj1)).equals("V_MPEGH/ISO/HEVC")) goto _L1; else goto _L32
_L32:
            c1 = '\006';
              goto _L26
_L4:
            if (!((String) (obj1)).equals("A_VORBIS")) goto _L1; else goto _L33
_L33:
            c1 = '\007';
              goto _L26
_L13:
            if (!((String) (obj1)).equals("A_OPUS")) goto _L1; else goto _L34
_L34:
            c1 = '\b';
              goto _L26
_L8:
            if (!((String) (obj1)).equals("A_AAC")) goto _L1; else goto _L35
_L35:
            c1 = '\t';
              goto _L26
_L5:
            if (!((String) (obj1)).equals("A_MPEG/L3")) goto _L1; else goto _L36
_L36:
            c1 = '\n';
              goto _L26
_L9:
            if (!((String) (obj1)).equals("A_AC3")) goto _L1; else goto _L37
_L37:
            c1 = '\013';
              goto _L26
_L15:
            obj1 = null;
            obj = "video/x-vnd.on2.vp8";
            c1 = '\uFFFF';
_L39:
            if (MimeTypes.isAudio(((String) (obj))))
            {
                return MediaFormat.createAudioFormat(((String) (obj)), c1, l1, l, m, ((List) (obj1)));
            }
            break; /* Loop/switch isn't completed */
_L16:
            obj1 = null;
            obj = "video/x-vnd.on2.vp9";
            c1 = '\uFFFF';
            continue; /* Loop/switch isn't completed */
_L17:
            if (h != null)
            {
                obj = Collections.singletonList(h);
            }
            obj1 = obj;
            obj = "video/mp4v-es";
            c1 = '\uFFFF';
            continue; /* Loop/switch isn't completed */
_L18:
            obj = a(new ParsableByteArray(h));
            obj1 = (List)((Pair) (obj)).first;
            k = ((Integer)((Pair) (obj)).second).intValue();
            c1 = '\uFFFF';
            obj = "video/avc";
            continue; /* Loop/switch isn't completed */
_L19:
            obj = b(new ParsableByteArray(h));
            obj1 = (List)((Pair) (obj)).first;
            k = ((Integer)((Pair) (obj)).second).intValue();
            c1 = '\uFFFF';
            obj = "video/hevc";
            continue; /* Loop/switch isn't completed */
_L20:
            obj = "audio/vorbis";
            c1 = '\u2000';
            obj1 = a(h);
            continue; /* Loop/switch isn't completed */
_L21:
            obj = "audio/opus";
            c1 = '\u1680';
            obj1 = new ArrayList(3);
            ((List) (obj1)).add(h);
            ((List) (obj1)).add(ByteBuffer.allocate(64).putLong(n).array());
            ((List) (obj1)).add(ByteBuffer.allocate(64).putLong(o).array());
            continue; /* Loop/switch isn't completed */
_L22:
            obj = "audio/mp4a-latm";
            obj1 = Collections.singletonList(h);
            c1 = '\uFFFF';
            continue; /* Loop/switch isn't completed */
_L23:
            obj1 = null;
            obj = "audio/mpeg";
            c1 = '\u1000';
            continue; /* Loop/switch isn't completed */
_L24:
            obj1 = null;
            obj = "audio/ac3";
            c1 = '\uFFFF';
            if (true) goto _L39; else goto _L38
_L38:
            if (MimeTypes.isVideo(((String) (obj))))
            {
                return MediaFormat.createVideoFormat(((String) (obj)), c1, l1, i, j, ((List) (obj1)));
            } else
            {
                throw new ParserException("Unexpected MIME type.");
            }
        }

        private b()
        {
            b = -1;
            c = -1;
            d = -1;
            i = -1;
            j = -1;
            k = -1;
            l = -1;
            m = -1;
            n = -1L;
            o = -1L;
        }

        b(byte byte0)
        {
            this();
        }
    }


    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final int CUES_STATE_BUILDING = 1;
    private static final int CUES_STATE_BUILT = 2;
    private static final int CUES_STATE_NOT_BUILT = 0;
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    private static final int ID_AUDIO = 225;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 0x1f43b675;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 0x1c53bb6b;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 0x23e383;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 0x1a45dfa3;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_INFO = 0x1549a966;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 0x114d9b74;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 0x18538067;
    private static final int ID_SEGMENT_INFO = 0x1549a966;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_TIMECODE_SCALE = 0x2ad7b1;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 0x1654ae6b;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int MP3_MAX_INPUT_SIZE = 4096;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int TRACK_TYPE_VIDEO = 1;
    private static final int UNKNOWN = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private b audioTrackFormat;
    private byte blockEncryptionKeyId[];
    private int blockFlags;
    private int blockLacingSampleCount;
    private int blockLacingSampleIndex;
    private int blockLacingSampleSizes[];
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private int cuesState;
    private long durationTimecode;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final shared_presage.com.google.android.exoplayer.extractor.webm.b reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleRead;
    private boolean sampleSeenReferenceBlock;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentDrmInitData;
    private long timecodeScale;
    private b trackFormat;
    private final e varintReader;
    private b videoTrackFormat;
    private final ParsableByteArray vorbisNumPageSamples;

    public WebmExtractor()
    {
        this(((shared_presage.com.google.android.exoplayer.extractor.webm.b) (new shared_presage.com.google.android.exoplayer.extractor.webm.a())));
    }

    WebmExtractor(shared_presage.com.google.android.exoplayer.extractor.webm.b b1)
    {
        segmentContentPosition = -1L;
        segmentContentSize = -1L;
        timecodeScale = -1L;
        durationTimecode = -1L;
        durationUs = -1L;
        cuesContentPosition = -1L;
        seekPositionAfterBuildingCues = -1L;
        cuesState = 0;
        clusterTimecodeUs = -1L;
        reader = b1;
        reader.a(new a((byte)0));
        varintReader = new e();
        scratch = new ParsableByteArray(4);
        vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        seekEntryIdBytes = new ParsableByteArray(4);
        nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        nalLength = new ParsableByteArray(4);
        sampleStrippedBytes = new ParsableByteArray();
    }

    private SeekMap buildSeekMap()
    {
        boolean flag = false;
        if (segmentContentPosition == -1L || durationUs == -1L || cueTimesUs == null || cueTimesUs.size() == 0 || cueClusterPositions == null || cueClusterPositions.size() != cueTimesUs.size())
        {
            cueTimesUs = null;
            cueClusterPositions = null;
            return SeekMap.UNSEEKABLE;
        }
        int k = cueTimesUs.size();
        int ai[] = new int[k];
        long al[] = new long[k];
        long al1[] = new long[k];
        long al2[] = new long[k];
        int i = 0;
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= k)
            {
                break;
            }
            al2[i] = cueTimesUs.get(i);
            al[i] = segmentContentPosition + cueClusterPositions.get(i);
            i++;
        } while (true);
        for (; j < k - 1; j++)
        {
            ai[j] = (int)(al[j + 1] - al[j]);
            al1[j] = al2[j + 1] - al2[j];
        }

        ai[k - 1] = (int)((segmentContentPosition + segmentContentSize) - al[k - 1]);
        al1[k - 1] = durationUs - al2[k - 1];
        cueTimesUs = null;
        cueClusterPositions = null;
        return new ChunkIndex(ai, al, al1, al2);
    }

    private static int[] ensureArrayCapacity(int ai[], int i)
    {
        int ai1[];
        if (ai == null)
        {
            ai1 = new int[i];
        } else
        {
            ai1 = ai;
            if (ai.length < i)
            {
                return new int[Math.max(ai.length * 2, i)];
            }
        }
        return ai1;
    }

    private static boolean isCodecSupported(String s)
    {
        return "V_VP8".equals(s) || "V_VP9".equals(s) || "V_MPEG4/ISO/SP".equals(s) || "V_MPEG4/ISO/ASP".equals(s) || "V_MPEG4/ISO/AP".equals(s) || "V_MPEG4/ISO/AVC".equals(s) || "V_MPEGH/ISO/HEVC".equals(s) || "A_OPUS".equals(s) || "A_VORBIS".equals(s) || "A_AAC".equals(s) || "A_MPEG/L3".equals(s) || "A_AC3".equals(s);
    }

    private boolean maybeSeekForCues(PositionHolder positionholder, long l)
    {
        if (seekForCues)
        {
            seekPositionAfterBuildingCues = l;
            positionholder.position = cuesContentPosition;
            cuesState = 1;
            seekForCues = false;
            return true;
        }
        if (cuesState == 2 && seekPositionAfterBuildingCues != -1L)
        {
            positionholder.position = seekPositionAfterBuildingCues;
            seekPositionAfterBuildingCues = -1L;
            return true;
        } else
        {
            return false;
        }
    }

    private void outputSampleMetadata(TrackOutput trackoutput, long l)
    {
        trackoutput.sampleMetadata(l, blockFlags, sampleBytesWritten, 0, blockEncryptionKeyId);
        sampleRead = true;
        resetSample();
    }

    private void readScratch(ExtractorInput extractorinput, int i)
    {
        if (scratch.limit() >= i)
        {
            return;
        }
        if (scratch.capacity() < i)
        {
            scratch.reset(Arrays.copyOf(scratch.data, Math.max(scratch.data.length * 2, i)), scratch.limit());
        }
        extractorinput.readFully(scratch.data, scratch.limit(), i - scratch.limit());
        scratch.setLimit(i);
    }

    private int readToOutput(ExtractorInput extractorinput, TrackOutput trackoutput, int i)
    {
        int j = sampleStrippedBytes.bytesLeft();
        if (j > 0)
        {
            i = Math.min(i, j);
            trackoutput.sampleData(sampleStrippedBytes, i);
        } else
        {
            i = trackoutput.sampleData(extractorinput, i, false);
        }
        sampleBytesRead = sampleBytesRead + i;
        sampleBytesWritten = sampleBytesWritten + i;
        return i;
    }

    private void readToTarget(ExtractorInput extractorinput, byte abyte0[], int i, int j)
    {
        int k = Math.min(j, sampleStrippedBytes.bytesLeft());
        extractorinput.readFully(abyte0, i + k, j - k);
        if (k > 0)
        {
            sampleStrippedBytes.readBytes(abyte0, i, k);
        }
        sampleBytesRead = sampleBytesRead + j;
    }

    private void resetSample()
    {
        sampleBytesRead = 0;
        sampleBytesWritten = 0;
        sampleCurrentNalBytesRemaining = 0;
        sampleEncodingHandled = false;
        sampleStrippedBytes.reset();
    }

    private long scaleTimecodeToUs(long l)
    {
        if (timecodeScale == -1L)
        {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        } else
        {
            return Util.scaleLargeTimestamp(l, timecodeScale, 1000L);
        }
    }

    private void writeSampleData(ExtractorInput extractorinput, TrackOutput trackoutput, b b1, int i)
    {
        if (sampleEncodingHandled) goto _L2; else goto _L1
_L1:
        if (!b1.e) goto _L4; else goto _L3
_L3:
        blockFlags = blockFlags & -3;
        extractorinput.readFully(scratch.data, 0, 1);
        sampleBytesRead = sampleBytesRead + 1;
        if ((scratch.data[0] & 0x80) == 128)
        {
            throw new ParserException("Extension bit is set in signal byte");
        }
        if ((scratch.data[0] & 1) == 1)
        {
            scratch.data[0] = 8;
            scratch.setPosition(0);
            trackoutput.sampleData(scratch, 1);
            sampleBytesWritten = sampleBytesWritten + 1;
            blockFlags = blockFlags | 2;
        }
_L6:
        sampleEncodingHandled = true;
_L2:
        i = sampleStrippedBytes.limit() + i;
        if (!"V_MPEG4/ISO/AVC".equals(b1.a) && !"V_MPEGH/ISO/HEVC".equals(b1.a))
        {
            break; /* Loop/switch isn't completed */
        }
        byte abyte0[] = nalLength.data;
        abyte0[0] = 0;
        abyte0[1] = 0;
        abyte0[2] = 0;
        int j = b1.k;
        int k = b1.k;
        while (sampleBytesRead < i) 
        {
            if (sampleCurrentNalBytesRemaining == 0)
            {
                readToTarget(extractorinput, abyte0, 4 - k, j);
                nalLength.setPosition(0);
                sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
                nalStartCode.setPosition(0);
                trackoutput.sampleData(nalStartCode, 4);
                sampleBytesWritten = sampleBytesWritten + 4;
            } else
            {
                sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - readToOutput(extractorinput, trackoutput, sampleCurrentNalBytesRemaining);
            }
        }
        break MISSING_BLOCK_LABEL_376;
_L4:
        if (b1.f != null)
        {
            sampleStrippedBytes.reset(b1.f, b1.f.length);
        }
        if (true) goto _L6; else goto _L5
_L5:
        while (sampleBytesRead < i) 
        {
            readToOutput(extractorinput, trackoutput, i - sampleBytesRead);
        }
        if ("A_VORBIS".equals(b1.a))
        {
            vorbisNumPageSamples.setPosition(0);
            trackoutput.sampleData(vorbisNumPageSamples, 4);
            sampleBytesWritten = sampleBytesWritten + 4;
        }
        return;
    }

    final void binaryElement(int i, int j, ExtractorInput extractorinput)
    {
        b b1;
        TrackOutput trackoutput;
        switch (i)
        {
        default:
            throw new ParserException((new StringBuilder("Unexpected id: ")).append(i).toString());

        case 21419: 
            Arrays.fill(seekEntryIdBytes.data, (byte)0);
            extractorinput.readFully(seekEntryIdBytes.data, 4 - j, j);
            seekEntryIdBytes.setPosition(0);
            seekEntryId = (int)seekEntryIdBytes.readUnsignedInt();
            return;

        case 25506: 
            trackFormat.h = new byte[j];
            extractorinput.readFully(trackFormat.h, 0, j);
            return;

        case 16981: 
            trackFormat.f = new byte[j];
            extractorinput.readFully(trackFormat.f, 0, j);
            return;

        case 18402: 
            trackFormat.g = new byte[j];
            extractorinput.readFully(trackFormat.g, 0, j);
            return;

        case 161: 
        case 163: 
            break;
        }
        if (blockState == 0)
        {
            blockTrackNumber = (int)varintReader.a(extractorinput, false, true);
            blockTrackNumberLength = varintReader.b();
            blockState = 1;
            scratch.reset();
        }
        if (audioTrackFormat != null && videoTrackFormat != null && audioTrackFormat.b != blockTrackNumber && videoTrackFormat.b != blockTrackNumber || audioTrackFormat != null && videoTrackFormat == null && audioTrackFormat.b != blockTrackNumber || audioTrackFormat == null && videoTrackFormat != null && videoTrackFormat.b != blockTrackNumber)
        {
            extractorinput.skipFully(j - blockTrackNumberLength);
            blockState = 0;
            return;
        }
        if (audioTrackFormat != null && blockTrackNumber == audioTrackFormat.b)
        {
            b1 = audioTrackFormat;
        } else
        {
            b1 = videoTrackFormat;
        }
        trackoutput = b1.p;
        if (blockState == 1)
        {
            readScratch(extractorinput, 3);
            int k = (scratch.data[2] & 6) >> 1;
            if (k == 0)
            {
                blockLacingSampleCount = 1;
                blockLacingSampleSizes = ensureArrayCapacity(blockLacingSampleSizes, 1);
                blockLacingSampleSizes[0] = j - blockTrackNumberLength - 3;
            } else
            {
                if (i != 163)
                {
                    throw new ParserException("Lacing only supported in SimpleBlocks.");
                }
                readScratch(extractorinput, 4);
                blockLacingSampleCount = (scratch.data[3] & 0xff) + 1;
                blockLacingSampleSizes = ensureArrayCapacity(blockLacingSampleSizes, blockLacingSampleCount);
                if (k == 2)
                {
                    j = (j - blockTrackNumberLength - 4) / blockLacingSampleCount;
                    Arrays.fill(blockLacingSampleSizes, 0, blockLacingSampleCount, j);
                } else
                if (k == 1)
                {
                    int l = 0;
                    k = 4;
                    for (int j1 = 0; j1 < blockLacingSampleCount - 1; j1++)
                    {
                        blockLacingSampleSizes[j1] = 0;
                        int l1 = k;
                        int j2;
                        do
                        {
                            k = l1 + 1;
                            readScratch(extractorinput, k);
                            j2 = scratch.data[k - 1] & 0xff;
                            int ai[] = blockLacingSampleSizes;
                            ai[j1] = ai[j1] + j2;
                            l1 = k;
                        } while (j2 == 255);
                        l += blockLacingSampleSizes[j1];
                    }

                    blockLacingSampleSizes[blockLacingSampleCount - 1] = j - blockTrackNumberLength - k - l;
                } else
                {
label0:
                    {
                        if (k != 3)
                        {
                            break label0;
                        }
                        int i1 = 0;
                        k = 4;
                        int k1 = 0;
                        do
                        {
                            if (k1 >= blockLacingSampleCount - 1)
                            {
                                break;
                            }
                            blockLacingSampleSizes[k1] = 0;
                            int k2 = k + 1;
                            readScratch(extractorinput, k2);
                            if (scratch.data[k2 - 1] == 0)
                            {
                                throw new ParserException("No valid varint length mask found");
                            }
                            long l4 = 0L;
                            int i2 = 0;
                            long l3;
label1:
                            do
                            {
label2:
                                {
                                    k = k2;
                                    l3 = l4;
                                    if (i2 < 8)
                                    {
                                        k = 1 << 7 - i2;
                                        if ((scratch.data[k2 - 1] & k) == 0)
                                        {
                                            break label2;
                                        }
                                        int l2 = k2 - 1;
                                        k2 += i2;
                                        readScratch(extractorinput, k2);
                                        long l5 = scratch.data[l2] & 0xff & ~k;
                                        for (k = l2 + 1; k < k2; k++)
                                        {
                                            l5 = (long)(scratch.data[k] & 0xff) | l5 << 8;
                                        }

                                        k = k2;
                                        l3 = l5;
                                        if (k1 > 0)
                                        {
                                            l3 = l5 - ((1L << i2 * 7 + 6) - 1L);
                                            k = k2;
                                        }
                                    }
                                    if (l3 < 0xffffffff80000000L || l3 > 0x7fffffffL)
                                    {
                                        throw new ParserException("EBML lacing sample size out of range.");
                                    }
                                    break label1;
                                }
                                i2++;
                            } while (true);
                            i2 = (int)l3;
                            int ai1[] = blockLacingSampleSizes;
                            if (k1 != 0)
                            {
                                i2 += blockLacingSampleSizes[k1 - 1];
                            }
                            ai1[k1] = i2;
                            i1 += blockLacingSampleSizes[k1];
                            k1++;
                        } while (true);
                        blockLacingSampleSizes[blockLacingSampleCount - 1] = j - blockTrackNumberLength - k - i1;
                    }
                }
            }
            j = scratch.data[0];
            k = scratch.data[1];
            blockTimeUs = clusterTimecodeUs + scaleTimecodeToUs(j << 8 | k & 0xff);
            if ((scratch.data[2] & 8) == 8)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (i == 163 && (scratch.data[2] & 0x80) == 128)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (k != 0)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (j != 0)
            {
                j = 0x8000000;
            } else
            {
                j = 0;
            }
            blockFlags = j | k;
            blockEncryptionKeyId = b1.g;
            blockState = 2;
            blockLacingSampleIndex = 0;
        }
        if (i != 163)
        {
            break MISSING_BLOCK_LABEL_1356;
        }
        for (; blockLacingSampleIndex < blockLacingSampleCount; blockLacingSampleIndex = blockLacingSampleIndex + 1)
        {
            writeSampleData(extractorinput, trackoutput, b1, blockLacingSampleSizes[blockLacingSampleIndex]);
            outputSampleMetadata(trackoutput, blockTimeUs + (long)((blockLacingSampleIndex * b1.d) / 1000));
        }

        break MISSING_BLOCK_LABEL_1350;
        throw new IllegalStateException((new StringBuilder("Unexpected lacing value: ")).append(k).toString());
        blockState = 0;
        return;
        writeSampleData(extractorinput, trackoutput, b1, blockLacingSampleSizes[0]);
        return;
    }

    final void endMasterElement(int i)
    {
        i;
        JVM INSTR lookupswitch 8: default 76
    //                   160: 194
    //                   174: 375
    //                   19899: 119
    //                   25152: 274
    //                   28032: 344
    //                   357149030: 77
    //                   374648427: 615
    //                   475249515: 167;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_615;
_L10:
        return;
_L7:
        if (timecodeScale == -1L)
        {
            timecodeScale = 0xf4240L;
        }
        if (durationTimecode != -1L)
        {
            durationUs = scaleTimecodeToUs(durationTimecode);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (seekEntryId == -1 || seekEntryPosition == -1L)
        {
            throw new ParserException("Mandatory element SeekID or SeekPosition not found");
        }
        if (seekEntryId == 0x1c53bb6b)
        {
            cuesContentPosition = seekEntryPosition;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (cuesState != 2)
        {
            extractorOutput.seekMap(buildSeekMap());
            cuesState = 2;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (blockState == 2)
        {
            if (!sampleSeenReferenceBlock)
            {
                blockFlags = blockFlags | 1;
            }
            TrackOutput trackoutput;
            if (audioTrackFormat != null && blockTrackNumber == audioTrackFormat.b)
            {
                trackoutput = audioTrackFormat.p;
            } else
            {
                trackoutput = videoTrackFormat.p;
            }
            outputSampleMetadata(trackoutput, blockTimeUs);
            blockState = 0;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (trackFormat.e)
        {
            if (trackFormat.g == null)
            {
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            }
            if (!sentDrmInitData)
            {
                extractorOutput.drmInitData(new shared_presage.com.google.android.exoplayer.drm.DrmInitData.Universal("video/webm", trackFormat.g));
                sentDrmInitData = true;
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (trackFormat.e && trackFormat.f != null)
        {
            throw new ParserException("Combining encryption and compression is not supported");
        }
        if (true) goto _L10; else goto _L3
_L3:
        if (trackFormat.b == -1 || trackFormat.c == -1)
        {
            throw new ParserException("Mandatory element TrackNumber or TrackType not found");
        }
        if (trackFormat.c == 2 && audioTrackFormat != null || trackFormat.c == 1 && videoTrackFormat != null)
        {
            trackFormat = null;
            return;
        }
        if (trackFormat.c == 2 && isCodecSupported(trackFormat.a))
        {
            audioTrackFormat = trackFormat;
            audioTrackFormat.p = extractorOutput.track(audioTrackFormat.b);
            audioTrackFormat.p.format(audioTrackFormat.a(durationUs));
        } else
        if (trackFormat.c == 1 && isCodecSupported(trackFormat.a))
        {
            videoTrackFormat = trackFormat;
            videoTrackFormat.p = extractorOutput.track(videoTrackFormat.b);
            videoTrackFormat.p.format(videoTrackFormat.a(durationUs));
        }
        trackFormat = null;
        return;
        if (videoTrackFormat == null && audioTrackFormat == null)
        {
            throw new ParserException("No valid tracks were found");
        } else
        {
            extractorOutput.endTracks();
            return;
        }
    }

    final void floatElement(int i, double d1)
    {
        switch (i)
        {
        default:
            return;

        case 17545: 
            durationTimecode = (long)d1;
            return;

        case 181: 
            trackFormat.m = (int)d1;
            return;
        }
    }

    final int getElementType(int i)
    {
        switch (i)
        {
        default:
            return 0;

        case 160: 
        case 174: 
        case 183: 
        case 187: 
        case 224: 
        case 225: 
        case 18407: 
        case 19899: 
        case 20532: 
        case 20533: 
        case 25152: 
        case 28032: 
        case 290298740: 
        case 357149030: 
        case 374648427: 
        case 408125543: 
        case 440786851: 
        case 475249515: 
        case 524531317: 
            return 1;

        case 131: 
        case 159: 
        case 176: 
        case 179: 
        case 186: 
        case 215: 
        case 231: 
        case 241: 
        case 251: 
        case 16980: 
        case 17029: 
        case 17143: 
        case 18401: 
        case 18408: 
        case 20529: 
        case 20530: 
        case 21420: 
        case 22186: 
        case 22203: 
        case 2352003: 
        case 2807729: 
            return 2;

        case 134: 
        case 17026: 
            return 3;

        case 161: 
        case 163: 
        case 16981: 
        case 18402: 
        case 21419: 
        case 25506: 
            return 4;

        case 181: 
        case 17545: 
            return 5;
        }
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
    }

    final void integerElement(int i, long l)
    {
        i;
        JVM INSTR lookupswitch 21: default 180
    //                   131: 310
    //                   159: 348
    //                   176: 280
    //                   179: 553
    //                   186: 290
    //                   215: 300
    //                   231: 587
    //                   241: 566
    //                   251: 358
    //                   16980: 438
    //                   17029: 218
    //                   17143: 181
    //                   18401: 477
    //                   18408: 516
    //                   20529: 364
    //                   20530: 401
    //                   21420: 263
    //                   22186: 330
    //                   22203: 339
    //                   2352003: 320
    //                   2807729: 274;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L1:
        return;
_L13:
        if (l != 1L)
        {
            throw new ParserException((new StringBuilder("EBMLReadVersion ")).append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (l < 1L || l > 2L)
        {
            throw new ParserException((new StringBuilder("DocTypeReadVersion ")).append(l).append(" not supported").toString());
        }
        if (true) goto _L1; else goto _L18
_L18:
        seekEntryPosition = segmentContentPosition + l;
        return;
_L22:
        timecodeScale = l;
        return;
_L4:
        trackFormat.i = (int)l;
        return;
_L6:
        trackFormat.j = (int)l;
        return;
_L7:
        trackFormat.b = (int)l;
        return;
_L2:
        trackFormat.c = (int)l;
        return;
_L21:
        trackFormat.d = (int)l;
        return;
_L19:
        trackFormat.n = l;
        return;
_L20:
        trackFormat.o = l;
        return;
_L3:
        trackFormat.l = (int)l;
        return;
_L10:
        sampleSeenReferenceBlock = true;
        return;
_L16:
        if (l != 0L)
        {
            throw new ParserException((new StringBuilder("ContentEncodingOrder ")).append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L17:
        if (l != 1L)
        {
            throw new ParserException((new StringBuilder("ContentEncodingScope ")).append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (l != 3L)
        {
            throw new ParserException((new StringBuilder("ContentCompAlgo ")).append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (l != 5L)
        {
            throw new ParserException((new StringBuilder("ContentEncAlgo ")).append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L15:
        if (l != 1L)
        {
            throw new ParserException((new StringBuilder("AESSettingsCipherMode ")).append(l).append(" not supported").toString());
        }
        if (true) goto _L1; else goto _L5
_L5:
        cueTimesUs.add(scaleTimecodeToUs(l));
        return;
_L9:
        if (!seenClusterPositionForCurrentCuePoint)
        {
            cueClusterPositions.add(l);
            seenClusterPositionForCurrentCuePoint = true;
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        clusterTimecodeUs = scaleTimecodeToUs(l);
        return;
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        sampleRead = false;
        boolean flag;
        for (flag = true; flag && !sampleRead;)
        {
            boolean flag1 = reader.a(extractorinput);
            flag = flag1;
            if (flag1)
            {
                flag = flag1;
                if (maybeSeekForCues(positionholder, extractorinput.getPosition()))
                {
                    return 1;
                }
            }
        }

        return !flag ? -1 : 0;
    }

    public final void seek()
    {
        clusterTimecodeUs = -1L;
        blockState = 0;
        reader.a();
        varintReader.a();
        resetSample();
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        return (new d()).a(extractorinput);
    }

    final void startMasterElement(int i, long l, long l1)
    {
        i;
        JVM INSTR lookupswitch 9: default 84
    //                   160: 212
    //                   174: 227
    //                   187: 164
    //                   19899: 128
    //                   20533: 218
    //                   25152: 84
    //                   408125543: 85
    //                   475249515: 141
    //                   524531317: 170;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L7 _L8 _L9
_L1:
        return;
_L7:
        if (segmentContentPosition != -1L && segmentContentPosition != l)
        {
            throw new ParserException("Multiple Segment elements not supported");
        } else
        {
            segmentContentPosition = l;
            segmentContentSize = l1;
            return;
        }
_L5:
        seekEntryId = -1;
        seekEntryPosition = -1L;
        return;
_L8:
        cueTimesUs = new LongArray();
        cueClusterPositions = new LongArray();
        return;
_L4:
        seenClusterPositionForCurrentCuePoint = false;
        return;
_L9:
        if (cuesState == 0)
        {
            if (cuesContentPosition != -1L)
            {
                seekForCues = true;
                return;
            } else
            {
                extractorOutput.seekMap(SeekMap.UNSEEKABLE);
                cuesState = 2;
                return;
            }
        }
          goto _L1
_L2:
        sampleSeenReferenceBlock = false;
        return;
_L6:
        trackFormat.e = true;
        return;
_L3:
        trackFormat = new b((byte)0);
        return;
    }

    final void stringElement(int i, String s)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   134: 78
    //                   17026: 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (!"webm".equals(s) && !"matroska".equals(s))
        {
            throw new ParserException((new StringBuilder("DocType ")).append(s).append(" not supported").toString());
        }
          goto _L1
_L2:
        trackFormat.a = s;
        return;
    }
}
