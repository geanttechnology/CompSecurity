// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.ChunkIndex;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.LongArray;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            DefaultEbmlReader, EbmlReader, VarintReader, Sniffer, 
//            EbmlReaderOutput

public final class WebmExtractor
    implements Extractor
{
    private final class InnerEbmlReaderOutput
        implements EbmlReaderOutput
    {

        final WebmExtractor this$0;

        public void binaryElement(int i, int j, ExtractorInput extractorinput)
            throws IOException, InterruptedException
        {
            WebmExtractor.this.binaryElement(i, j, extractorinput);
        }

        public void endMasterElement(int i)
            throws ParserException
        {
            WebmExtractor.this.endMasterElement(i);
        }

        public void floatElement(int i, double d)
            throws ParserException
        {
            WebmExtractor.this.floatElement(i, d);
        }

        public int getElementType(int i)
        {
            return WebmExtractor.this.getElementType(i);
        }

        public void integerElement(int i, long l)
            throws ParserException
        {
            WebmExtractor.this.integerElement(i, l);
        }

        public void startMasterElement(int i, long l, long l1)
            throws ParserException
        {
            WebmExtractor.this.startMasterElement(i, l, l1);
        }

        public void stringElement(int i, String s)
            throws ParserException
        {
            WebmExtractor.this.stringElement(i, s);
        }

        private InnerEbmlReaderOutput()
        {
            this$0 = WebmExtractor.this;
            super();
        }

    }

    private static final class TrackFormat
    {

        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte codecPrivate[];
        public int defaultSampleDurationNs;
        public byte encryptionKeyId[];
        public boolean hasContentEncryption;
        public int nalUnitLengthFieldLength;
        public int number;
        public int pixelHeight;
        public int pixelWidth;
        public int sampleRate;
        public byte sampleStrippedBytes[];
        public long seekPreRollNs;
        public TrackOutput trackOutput;
        public int type;

        private static Pair parseAvcCodecPrivate(ParsableByteArray parsablebytearray)
            throws ParserException
        {
            ArrayList arraylist;
            int i;
            int j;
            int k;
            boolean flag;
            try
            {
                parsablebytearray.setPosition(4);
                j = (parsablebytearray.readUnsignedByte() & 3) + 1;
            }
            // Misplaced declaration of an exception variable
            catch (ParsableByteArray parsablebytearray)
            {
                throw new ParserException("Error parsing AVC codec private");
            }
            if (j != 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            arraylist = new ArrayList();
            k = parsablebytearray.readUnsignedByte();
            i = 0;
_L2:
            if (i >= (k & 0x1f))
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            k = parsablebytearray.readUnsignedByte();
            i = 0;
_L4:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            parsablebytearray = Pair.create(arraylist, Integer.valueOf(j));
            return parsablebytearray;
        }

        private static Pair parseHevcCodecPrivate(ParsableByteArray parsablebytearray)
            throws ParserException
        {
            int i;
            int j;
            byte abyte0[];
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            try
            {
                parsablebytearray.setPosition(21);
                i1 = parsablebytearray.readUnsignedByte();
                j1 = parsablebytearray.readUnsignedByte();
            }
            // Misplaced declaration of an exception variable
            catch (ParsableByteArray parsablebytearray)
            {
                throw new ParserException("Error parsing HEVC codec private");
            }
            i = 0;
            l = parsablebytearray.getPosition();
            j = 0;
_L10:
            if (j >= j1) goto _L2; else goto _L1
_L1:
            parsablebytearray.skipBytes(1);
            k1 = parsablebytearray.readUnsignedShort();
            k = 0;
_L4:
            if (k >= k1)
            {
                break; /* Loop/switch isn't completed */
            }
            l1 = parsablebytearray.readUnsignedShort();
            i += l1 + 4;
            parsablebytearray.skipBytes(l1);
            k++;
            if (true) goto _L4; else goto _L3
_L2:
            parsablebytearray.setPosition(l);
            abyte0 = new byte[i];
            l = 0;
            j = 0;
_L11:
            if (j >= j1) goto _L6; else goto _L5
_L5:
            parsablebytearray.skipBytes(1);
            k1 = parsablebytearray.readUnsignedShort();
            k = 0;
_L8:
            if (k >= k1)
            {
                continue; /* Loop/switch isn't completed */
            }
            l1 = parsablebytearray.readUnsignedShort();
            System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, abyte0, l, NalUnitUtil.NAL_START_CODE.length);
            l += NalUnitUtil.NAL_START_CODE.length;
            System.arraycopy(parsablebytearray.data, parsablebytearray.getPosition(), abyte0, l, l1);
            l += l1;
            parsablebytearray.skipBytes(l1);
            k++;
            if (true) goto _L8; else goto _L7
_L7:
            continue; /* Loop/switch isn't completed */
_L9:
            return Pair.create(parsablebytearray, Integer.valueOf((i1 & 3) + 1));
_L13:
            parsablebytearray = Collections.singletonList(abyte0);
              goto _L9
_L3:
            j++;
              goto _L10
            j++;
              goto _L11
_L6:
            if (i != 0) goto _L13; else goto _L12
_L12:
            parsablebytearray = null;
              goto _L9
        }

        private static List parseVorbisCodecPrivate(byte abyte0[])
            throws ParserException
        {
_L2:
            k = j + 1;
            j = abyte0[j];
            if (abyte0[k] == 1)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            throw new ParserException("Error parsing vorbis codec private");
            abyte1 = new byte[l];
            System.arraycopy(abyte0, k, abyte1, 0, l);
            k += l;
            if (abyte0[k] == 3)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            throw new ParserException("Error parsing vorbis codec private");
            i = k + (i + j);
            if (abyte0[i] == 5)
            {
                break MISSING_BLOCK_LABEL_150;
            }
            throw new ParserException("Error parsing vorbis codec private");
            byte abyte2[] = new byte[abyte0.length - i];
            System.arraycopy(abyte0, i, abyte2, 0, abyte0.length - i);
            abyte0 = new ArrayList(2);
            abyte0.add(abyte1);
            abyte0.add(abyte2);
            return abyte0;
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
            int j = 0;
            byte abyte1[];
            int i;
            int k;
            int l;
            for (i = 1; abyte0[i] == -1; i++)
            {
                j += 255;
            }

            l = j + abyte0[i];
            j = 0;
            k = i + 1;
            i = j;
            j = k;
            while (abyte0[j] == -1) 
            {
                i += 255;
                j++;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public MediaFormat getMediaFormat(long l)
            throws ParserException
        {
            String s;
            Object obj;
            char c;
            byte byte0;
            obj = null;
            byte0 = -1;
            s = codecId;
            c = '\uFFFF';
            s.hashCode();
            JVM INSTR lookupswitch 12: default 124
        //                       -2095576542: 258
        //                       -2095575984: 228
        //                       -1730367663: 304
        //                       -1482641357: 352
        //                       -538363189: 243
        //                       -538363109: 273
        //                       62923557: 336
        //                       62923603: 368
        //                       82338133: 198
        //                       82338134: 213
        //                       855502857: 288
        //                       1951062397: 320;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
            c;
            JVM INSTR tableswitch 0 11: default 188
        //                       0 384
        //                       1 416
        //                       2 426
        //                       3 426
        //                       4 426
        //                       5 458
        //                       6 509
        //                       7 560
        //                       8 580
        //                       9 659
        //                       10 678
        //                       11 689;
               goto _L14 _L15 _L16 _L17 _L17 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L14:
            throw new ParserException("Unrecognized codec identifier.");
_L10:
            if (s.equals("V_VP8"))
            {
                c = '\0';
            }
              goto _L1
_L11:
            if (s.equals("V_VP9"))
            {
                c = '\001';
            }
              goto _L1
_L3:
            if (s.equals("V_MPEG4/ISO/SP"))
            {
                c = '\002';
            }
              goto _L1
_L6:
            if (s.equals("V_MPEG4/ISO/ASP"))
            {
                c = '\003';
            }
              goto _L1
_L2:
            if (s.equals("V_MPEG4/ISO/AP"))
            {
                c = '\004';
            }
              goto _L1
_L7:
            if (s.equals("V_MPEG4/ISO/AVC"))
            {
                c = '\005';
            }
              goto _L1
_L12:
            if (s.equals("V_MPEGH/ISO/HEVC"))
            {
                c = '\006';
            }
              goto _L1
_L4:
            if (s.equals("A_VORBIS"))
            {
                c = '\007';
            }
              goto _L1
_L13:
            if (s.equals("A_OPUS"))
            {
                c = '\b';
            }
              goto _L1
_L8:
            if (s.equals("A_AAC"))
            {
                c = '\t';
            }
              goto _L1
_L5:
            if (s.equals("A_MPEG/L3"))
            {
                c = '\n';
            }
              goto _L1
_L9:
            if (s.equals("A_AC3"))
            {
                c = '\013';
            }
              goto _L1
_L15:
            s = "video/x-vnd.on2.vp8";
            c = byte0;
_L26:
            if (MimeTypes.isAudio(s))
            {
                return MediaFormat.createAudioFormat(s, c, l, channelCount, sampleRate, ((List) (obj)));
            }
            break; /* Loop/switch isn't completed */
_L16:
            s = "video/x-vnd.on2.vp9";
            c = byte0;
            continue; /* Loop/switch isn't completed */
_L17:
            s = "video/mp4v-es";
            if (codecPrivate == null)
            {
                obj = null;
            } else
            {
                obj = Collections.singletonList(codecPrivate);
            }
            c = byte0;
            continue; /* Loop/switch isn't completed */
_L18:
            s = "video/avc";
            Pair pair = parseAvcCodecPrivate(new ParsableByteArray(codecPrivate));
            obj = (List)pair.first;
            nalUnitLengthFieldLength = ((Integer)pair.second).intValue();
            c = byte0;
            continue; /* Loop/switch isn't completed */
_L19:
            s = "video/hevc";
            Pair pair1 = parseHevcCodecPrivate(new ParsableByteArray(codecPrivate));
            obj = (List)pair1.first;
            nalUnitLengthFieldLength = ((Integer)pair1.second).intValue();
            c = byte0;
            continue; /* Loop/switch isn't completed */
_L20:
            s = "audio/vorbis";
            c = '\u2000';
            obj = parseVorbisCodecPrivate(codecPrivate);
            continue; /* Loop/switch isn't completed */
_L21:
            s = "audio/opus";
            c = '\u1680';
            obj = new ArrayList(3);
            ((List) (obj)).add(codecPrivate);
            ((List) (obj)).add(ByteBuffer.allocate(64).putLong(codecDelayNs).array());
            ((List) (obj)).add(ByteBuffer.allocate(64).putLong(seekPreRollNs).array());
            continue; /* Loop/switch isn't completed */
_L22:
            s = "audio/mp4a-latm";
            obj = Collections.singletonList(codecPrivate);
            c = byte0;
            continue; /* Loop/switch isn't completed */
_L23:
            c = '\u1000';
            s = "audio/mpeg";
            continue; /* Loop/switch isn't completed */
_L24:
            s = "audio/ac3";
            c = byte0;
            if (true) goto _L26; else goto _L25
_L25:
            if (MimeTypes.isVideo(s))
            {
                return MediaFormat.createVideoFormat(s, c, l, pixelWidth, pixelHeight, ((List) (obj)));
            } else
            {
                throw new ParserException("Unexpected MIME type.");
            }
        }

        private TrackFormat()
        {
            number = -1;
            type = -1;
            defaultSampleDurationNs = -1;
            pixelWidth = -1;
            pixelHeight = -1;
            nalUnitLengthFieldLength = -1;
            channelCount = -1;
            sampleRate = -1;
            codecDelayNs = -1L;
            seekPreRollNs = -1L;
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
    private TrackFormat audioTrackFormat;
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
    private final EbmlReader reader;
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
    private TrackFormat trackFormat;
    private final VarintReader varintReader;
    private TrackFormat videoTrackFormat;
    private final ParsableByteArray vorbisNumPageSamples;

    public WebmExtractor()
    {
        this(((EbmlReader) (new DefaultEbmlReader())));
    }

    WebmExtractor(EbmlReader ebmlreader)
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
        reader = ebmlreader;
        reader.init(new InnerEbmlReaderOutput());
        varintReader = new VarintReader();
        scratch = new ParsableByteArray(4);
        vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        seekEntryIdBytes = new ParsableByteArray(4);
        nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        nalLength = new ParsableByteArray(4);
        sampleStrippedBytes = new ParsableByteArray();
    }

    private SeekMap buildSeekMap()
    {
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
        for (int i = 0; i < k; i++)
        {
            al2[i] = cueTimesUs.get(i);
            al[i] = segmentContentPosition + cueClusterPositions.get(i);
        }

        for (int j = 0; j < k - 1; j++)
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
        throws IOException, InterruptedException
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
        throws IOException, InterruptedException
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
        throws IOException, InterruptedException
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
        throws ParserException
    {
        if (timecodeScale == -1L)
        {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        } else
        {
            return Util.scaleLargeTimestamp(l, timecodeScale, 1000L);
        }
    }

    private void writeSampleData(ExtractorInput extractorinput, TrackOutput trackoutput, TrackFormat trackformat, int i)
        throws IOException, InterruptedException
    {
        if (sampleEncodingHandled) goto _L2; else goto _L1
_L1:
        if (!trackformat.hasContentEncryption) goto _L4; else goto _L3
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
        i += sampleStrippedBytes.limit();
        if (!"V_MPEG4/ISO/AVC".equals(trackformat.codecId) && !"V_MPEGH/ISO/HEVC".equals(trackformat.codecId))
        {
            break; /* Loop/switch isn't completed */
        }
        byte abyte0[] = nalLength.data;
        abyte0[0] = 0;
        abyte0[1] = 0;
        abyte0[2] = 0;
        int j = trackformat.nalUnitLengthFieldLength;
        int k = trackformat.nalUnitLengthFieldLength;
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
        if (trackformat.sampleStrippedBytes != null)
        {
            sampleStrippedBytes.reset(trackformat.sampleStrippedBytes, trackformat.sampleStrippedBytes.length);
        }
        if (true) goto _L6; else goto _L5
_L5:
        while (sampleBytesRead < i) 
        {
            readToOutput(extractorinput, trackoutput, i - sampleBytesRead);
        }
        if ("A_VORBIS".equals(trackformat.codecId))
        {
            vorbisNumPageSamples.setPosition(0);
            trackoutput.sampleData(vorbisNumPageSamples, 4);
            sampleBytesWritten = sampleBytesWritten + 4;
        }
        return;
    }

    void binaryElement(int i, int j, ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        TrackFormat trackformat;
        TrackOutput trackoutput;
        switch (i)
        {
        default:
            throw new ParserException((new StringBuilder()).append("Unexpected id: ").append(i).toString());

        case 21419: 
            Arrays.fill(seekEntryIdBytes.data, (byte)0);
            extractorinput.readFully(seekEntryIdBytes.data, 4 - j, j);
            seekEntryIdBytes.setPosition(0);
            seekEntryId = (int)seekEntryIdBytes.readUnsignedInt();
            return;

        case 25506: 
            trackFormat.codecPrivate = new byte[j];
            extractorinput.readFully(trackFormat.codecPrivate, 0, j);
            return;

        case 16981: 
            trackFormat.sampleStrippedBytes = new byte[j];
            extractorinput.readFully(trackFormat.sampleStrippedBytes, 0, j);
            return;

        case 18402: 
            trackFormat.encryptionKeyId = new byte[j];
            extractorinput.readFully(trackFormat.encryptionKeyId, 0, j);
            return;

        case 161: 
        case 163: 
            break;
        }
        if (blockState == 0)
        {
            blockTrackNumber = (int)varintReader.readUnsignedVarint(extractorinput, false, true);
            blockTrackNumberLength = varintReader.getLastLength();
            blockState = 1;
            scratch.reset();
        }
        if (audioTrackFormat != null && videoTrackFormat != null && audioTrackFormat.number != blockTrackNumber && videoTrackFormat.number != blockTrackNumber || audioTrackFormat != null && videoTrackFormat == null && audioTrackFormat.number != blockTrackNumber || audioTrackFormat == null && videoTrackFormat != null && videoTrackFormat.number != blockTrackNumber)
        {
            extractorinput.skipFully(j - blockTrackNumberLength);
            blockState = 0;
            return;
        }
        if (audioTrackFormat != null && blockTrackNumber == audioTrackFormat.number)
        {
            trackformat = audioTrackFormat;
        } else
        {
            trackformat = videoTrackFormat;
        }
        trackoutput = trackformat.trackOutput;
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
                    int j1 = 0;
                    k = 4;
                    for (int l = 0; l < blockLacingSampleCount - 1; l++)
                    {
                        blockLacingSampleSizes[l] = 0;
                        int l1 = k;
                        int j2;
                        do
                        {
                            k = l1 + 1;
                            readScratch(extractorinput, k);
                            j2 = scratch.data[k - 1] & 0xff;
                            int ai[] = blockLacingSampleSizes;
                            ai[l] = ai[l] + j2;
                            l1 = k;
                        } while (j2 == 255);
                        j1 += blockLacingSampleSizes[l];
                    }

                    blockLacingSampleSizes[blockLacingSampleCount - 1] = j - blockTrackNumberLength - k - j1;
                } else
                {
label0:
                    {
                        if (k != 3)
                        {
                            break label0;
                        }
                        int k1 = 0;
                        k = 4;
                        int i1 = 0;
                        do
                        {
                            if (i1 >= blockLacingSampleCount - 1)
                            {
                                break;
                            }
                            blockLacingSampleSizes[i1] = 0;
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
                                        int l2 = 1 << 7 - i2;
                                        if ((scratch.data[k2 - 1] & l2) == 0)
                                        {
                                            break label2;
                                        }
                                        int i3 = k2 - 1;
                                        k2 += i2;
                                        readScratch(extractorinput, k2);
                                        byte abyte0[] = scratch.data;
                                        k = i3 + 1;
                                        long l5 = abyte0[i3] & 0xff & ~l2;
                                        for (; k < k2; k++)
                                        {
                                            l5 = l5 << 8 | (long)(scratch.data[k] & 0xff);
                                        }

                                        k = k2;
                                        l3 = l5;
                                        if (i1 > 0)
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
                            if (i1 != 0)
                            {
                                i2 += blockLacingSampleSizes[i1 - 1];
                            }
                            ai1[i1] = i2;
                            k1 += blockLacingSampleSizes[i1];
                            i1++;
                        } while (true);
                        blockLacingSampleSizes[blockLacingSampleCount - 1] = j - blockTrackNumberLength - k - k1;
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
            blockEncryptionKeyId = trackformat.encryptionKeyId;
            blockState = 2;
            blockLacingSampleIndex = 0;
        }
        if (i != 163)
        {
            break MISSING_BLOCK_LABEL_1366;
        }
        for (; blockLacingSampleIndex < blockLacingSampleCount; blockLacingSampleIndex = blockLacingSampleIndex + 1)
        {
            writeSampleData(extractorinput, trackoutput, trackformat, blockLacingSampleSizes[blockLacingSampleIndex]);
            outputSampleMetadata(trackoutput, blockTimeUs + (long)((blockLacingSampleIndex * trackformat.defaultSampleDurationNs) / 1000));
        }

        break MISSING_BLOCK_LABEL_1360;
        throw new IllegalStateException((new StringBuilder()).append("Unexpected lacing value: ").append(k).toString());
        blockState = 0;
        return;
        writeSampleData(extractorinput, trackoutput, trackformat, blockLacingSampleSizes[0]);
        return;
    }

    void endMasterElement(int i)
        throws ParserException
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
            if (audioTrackFormat != null && blockTrackNumber == audioTrackFormat.number)
            {
                trackoutput = audioTrackFormat.trackOutput;
            } else
            {
                trackoutput = videoTrackFormat.trackOutput;
            }
            outputSampleMetadata(trackoutput, blockTimeUs);
            blockState = 0;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (trackFormat.hasContentEncryption)
        {
            if (trackFormat.encryptionKeyId == null)
            {
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            }
            if (!sentDrmInitData)
            {
                extractorOutput.drmInitData(new com.google.android.exoplayer.drm.DrmInitData.Universal("video/webm", trackFormat.encryptionKeyId));
                sentDrmInitData = true;
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (trackFormat.hasContentEncryption && trackFormat.sampleStrippedBytes != null)
        {
            throw new ParserException("Combining encryption and compression is not supported");
        }
        if (true) goto _L10; else goto _L3
_L3:
        if (trackFormat.number == -1 || trackFormat.type == -1)
        {
            throw new ParserException("Mandatory element TrackNumber or TrackType not found");
        }
        if (trackFormat.type == 2 && audioTrackFormat != null || trackFormat.type == 1 && videoTrackFormat != null)
        {
            trackFormat = null;
            return;
        }
        if (trackFormat.type == 2 && isCodecSupported(trackFormat.codecId))
        {
            audioTrackFormat = trackFormat;
            audioTrackFormat.trackOutput = extractorOutput.track(audioTrackFormat.number);
            audioTrackFormat.trackOutput.format(audioTrackFormat.getMediaFormat(durationUs));
        } else
        if (trackFormat.type == 1 && isCodecSupported(trackFormat.codecId))
        {
            videoTrackFormat = trackFormat;
            videoTrackFormat.trackOutput = extractorOutput.track(videoTrackFormat.number);
            videoTrackFormat.trackOutput.format(videoTrackFormat.getMediaFormat(durationUs));
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

    void floatElement(int i, double d)
    {
        switch (i)
        {
        default:
            return;

        case 17545: 
            durationTimecode = (long)d;
            return;

        case 181: 
            trackFormat.sampleRate = (int)d;
            return;
        }
    }

    int getElementType(int i)
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

    public void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
    }

    void integerElement(int i, long l)
        throws ParserException
    {
        i;
        JVM INSTR lookupswitch 21: default 180
    //                   131: 316
    //                   159: 354
    //                   176: 286
    //                   179: 574
    //                   186: 296
    //                   215: 306
    //                   231: 608
    //                   241: 587
    //                   251: 364
    //                   16980: 450
    //                   17029: 221
    //                   17143: 181
    //                   18401: 492
    //                   18408: 534
    //                   20529: 370
    //                   20530: 410
    //                   21420: 269
    //                   22186: 336
    //                   22203: 345
    //                   2352003: 326
    //                   2807729: 280;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L1:
        return;
_L13:
        if (l != 1L)
        {
            throw new ParserException((new StringBuilder()).append("EBMLReadVersion ").append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (l < 1L || l > 2L)
        {
            throw new ParserException((new StringBuilder()).append("DocTypeReadVersion ").append(l).append(" not supported").toString());
        }
        if (true) goto _L1; else goto _L18
_L18:
        seekEntryPosition = segmentContentPosition + l;
        return;
_L22:
        timecodeScale = l;
        return;
_L4:
        trackFormat.pixelWidth = (int)l;
        return;
_L6:
        trackFormat.pixelHeight = (int)l;
        return;
_L7:
        trackFormat.number = (int)l;
        return;
_L2:
        trackFormat.type = (int)l;
        return;
_L21:
        trackFormat.defaultSampleDurationNs = (int)l;
        return;
_L19:
        trackFormat.codecDelayNs = l;
        return;
_L20:
        trackFormat.seekPreRollNs = l;
        return;
_L3:
        trackFormat.channelCount = (int)l;
        return;
_L10:
        sampleSeenReferenceBlock = true;
        return;
_L16:
        if (l != 0L)
        {
            throw new ParserException((new StringBuilder()).append("ContentEncodingOrder ").append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L17:
        if (l != 1L)
        {
            throw new ParserException((new StringBuilder()).append("ContentEncodingScope ").append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (l != 3L)
        {
            throw new ParserException((new StringBuilder()).append("ContentCompAlgo ").append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (l != 5L)
        {
            throw new ParserException((new StringBuilder()).append("ContentEncAlgo ").append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L15:
        if (l != 1L)
        {
            throw new ParserException((new StringBuilder()).append("AESSettingsCipherMode ").append(l).append(" not supported").toString());
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

    public int read(ExtractorInput extractorinput, PositionHolder positionholder)
        throws IOException, InterruptedException
    {
        int i;
        boolean flag;
        i = 0;
        sampleRead = false;
        flag = true;
_L4:
        if (!flag || sampleRead) goto _L2; else goto _L1
_L1:
        boolean flag1;
        flag1 = reader.read(extractorinput);
        flag = flag1;
        if (!flag1) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (!maybeSeekForCues(positionholder, extractorinput.getPosition())) goto _L4; else goto _L5
_L5:
        i = 1;
_L7:
        return i;
_L2:
        if (!flag)
        {
            return -1;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void seek()
    {
        clusterTimecodeUs = -1L;
        blockState = 0;
        reader.reset();
        varintReader.reset();
        resetSample();
    }

    public boolean sniff(ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        return (new Sniffer()).sniff(extractorinput);
    }

    void startMasterElement(int i, long l, long l1)
        throws ParserException
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
        trackFormat.hasContentEncryption = true;
        return;
_L3:
        trackFormat = new TrackFormat();
        return;
    }

    void stringElement(int i, String s)
        throws ParserException
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   134: 81
    //                   17026: 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (!"webm".equals(s) && !"matroska".equals(s))
        {
            throw new ParserException((new StringBuilder()).append("DocType ").append(s).append(" not supported").toString());
        }
          goto _L1
_L2:
        trackFormat.codecId = s;
        return;
    }
}
