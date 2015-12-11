// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;

import android.util.Log;
import com.rdio.android.audioplayer.io.MediaBuffer;
import com.rdio.android.audioplayer.sources.MediaSource;
import java.io.IOException;

// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            AudioExtractor, MediaFormat

public class AacExtractor extends AudioExtractor
{
    public class AACParseException extends MediaExtractor.MediaParseException
    {

        final AacExtractor this$0;

        public AACParseException(String s)
        {
            this$0 = AacExtractor.this;
            super(s);
        }
    }

    private static class AACTag
    {

        public static final long CO64 = 0x636f3634L;
        public static final long DINF = 0x64696e66L;
        public static final long ESDS = 0x65736473L;
        public static final long FTYP = 0x66747970L;
        public static final long HDLR = 0x68646c72L;
        public static final long MDAT = 0x6d646174L;
        public static final long MDHD = 0x6d646864L;
        public static final long MDIA = 0x6d646961L;
        public static final long MINF = 0x6d696e66L;
        public static final long MOOV = 0x6d6f6f76L;
        public static final long MP4A = 0x6d703461L;
        public static final long MVHD = 0x6d766864L;
        public static final long NONE = 0L;
        public static final long SMHD = 0x736d6864L;
        public static final long STBL = 0x7374626cL;
        public static final long STCO = 0x7374636fL;
        public static final long STSC = 0x73747363L;
        public static final long STSD = 0x73747364L;
        public static final long STSZ = 0x7374737aL;
        public static final long STTS = 0x73747473L;
        public static final long TKHD = 0x746b6864L;
        public static final long TRAK = 0x7472616bL;
        public static final long UUID = 0x75756964L;
        public final long DREF = 0x64726566L;

        public static String toString(long l)
        {
            if (l == 0L)
            {
                return "Unknown/Unsupported";
            }
            if (l == 0x75756964L)
            {
                return "uuid (unsupported)";
            }
            char ac[] = new char[4];
            for (int i = 3; i >= 0; i--)
            {
                ac[3 - i] = (char)(int)(l >> i * 8 & 255L);
            }

            return new String(ac);
        }

        private AACTag()
        {
        }
    }

    private static interface BoxHandler
    {

        public abstract boolean handleBox(long l, long l1);
    }

    private static class BoxHeaderParameters
    {

        public long contentSize;
        public long headerSize;
        public long tag;

        public BoxHeaderParameters(long l, long l1, long l2)
        {
            headerSize = l;
            contentSize = l1;
            tag = l2;
        }
    }

    private static class FullBoxParameters
    {

        public long flags;
        public byte version;

        public FullBoxParameters(byte byte0, long l)
        {
            version = byte0;
            flags = l;
        }
    }


    private static final byte MP4_DECODER_CONFIG_DESCR_TAG = 4;
    private static final byte MP4_DECODER_SPEC_DESCR_TAG = 5;
    private static final byte MP4_DESCR_TAG = 3;
    protected static final char hexArray[] = "0123456789ABCDEF".toCharArray();
    private int ESDS_CHANNEL_TABLE[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 0, 0, 
        0, 0, 0, 0, 0, 0
    };
    private int ESDS_FREQ_TABLE[] = {
        0x17700, 0x15888, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 
        11025, 8000, 7350, 0, 0, 0
    };
    private String ESDS_OBJTYPE_TABLE[] = {
        "Null", "AAC Main", "AAC LC (Low Complexity)", "AAC SSR (Scalable Sample Rate)", "AAC LTP (Long Term Prediction)", "SBR (Spectral Band Replication)", "AAC Scalable", "TwinVQ", "CELP (Code Excited Linear Prediction)", "HXVC (Harmonic Vector eXcitation Coding)", 
        "[10] Reserved", "[11] Reserved", "TTSI (Text-To-Speech Interface)", "Main Synthesis", "Wavetable Synthesis", "General MIDI", "Algorithmic Synthesis and Audio Effects", "ER (Error Resilient) AAC LC", "[18] Reserved", "ER AAC LTP", 
        "ER AAC Scalable", "ER TwinVQ", "ER BSAC (Bit-Sliced Arithmetic Coding)", "ER AAC LD (Low Delay)", "ER CELP", "ER HVXC", "ER HILN (Harmonic and Individual Lines plus Noise)", "ER Parametric", "SSC (SinuSoidal Coding)", "PS (Parametric Stereo)", 
        "MPEG Surround", "(Escape value)", "Layer-1", "Layer-2", "Layer-3", "DST (Direct Stream Transfer)", "ALS (Audio Lossless)", "SLS (Scalable LosslesS)", "SLS non-core", "ER AAC ELD (Enhanced Low Delay)", 
        "SMR (Symbolic Music Representation) Simple", "SMR Main", "USAC (Unified Speech and Audio Coding) (no SBR)", "SAOC (Spatial Audio Object Coding)", "LD MPEG Surround", "USAC"
    };
    private final long HANDLER_TYPE_AUDIO = 0x736f756eL;
    private final long HANDLER_TYPE_AUXVIDEO = 0x61757876L;
    private final long HANDLER_TYPE_HINT = 0x68696e74L;
    private final long HANDLER_TYPE_METADATA = 0x6d657461L;
    private final long HANDLER_TYPE_VIDEO = 0x76696465L;
    private final String TAG = "AACExtractor";
    private int average_bit_rate;
    private long curr_frame;
    private BoxHandler dataInfoBoxHandler;
    private byte esds_config[];
    private long frame_count;
    private long frame_offset[];
    private long frame_size[];
    private int indent_level;
    private boolean inspect;
    private BoxHandler mediaBoxHandler;
    private BoxHandler mediaInfoBoxHandler;
    private long media_handler;
    private BoxHandler movieBoxHandler;
    private long mv_tk_timescale;
    private long presentation_time;
    private byte read_buffer[];
    private BoxHandler sampleDescBoxHandler;
    private BoxHandler sampleTableBoxHandler;
    private BoxHandler trackBoxHandler;

    public AacExtractor()
    {
        inspect = false;
        indent_level = 0;
        esds_config = null;
        frame_count = 0L;
        frame_size = null;
        frame_offset = null;
        curr_frame = 0L;
        mv_tk_timescale = 0L;
        presentation_time = 0L;
        average_bit_rate = 0;
        movieBoxHandler = new BoxHandler() {

            final AacExtractor this$0;

            public boolean handleBox(long l, long l1)
            {
                boolean flag = false;
                if (l1 == 0x6d766864L)
                {
                    flag = processMovieHeaderBox(l);
                } else
                if (l1 == 0x7472616bL)
                {
                    return processContainer(l, trackBoxHandler);
                }
                return flag;
            }

            
            {
                this$0 = AacExtractor.this;
                super();
            }
        };
        trackBoxHandler = new BoxHandler() {

            final AacExtractor this$0;

            public boolean handleBox(long l, long l1)
            {
                boolean flag = false;
                if (l1 == 0x746b6864L)
                {
                    flag = processTrackHeaderBox(l);
                } else
                if (l1 == 0x6d646961L)
                {
                    return processContainer(l, mediaBoxHandler);
                }
                return flag;
            }

            
            {
                this$0 = AacExtractor.this;
                super();
            }
        };
        mediaBoxHandler = new BoxHandler() {

            final AacExtractor this$0;

            public boolean handleBox(long l, long l1)
            {
                boolean flag = false;
                if (l1 == 0x6d646864L)
                {
                    flag = processMediaHeaderBox(l);
                } else
                {
                    if (l1 == 0x68646c72L)
                    {
                        return processMediaHandlerBox(l);
                    }
                    if (l1 == 0x6d696e66L)
                    {
                        return processContainer(l, mediaInfoBoxHandler);
                    }
                }
                return flag;
            }

            
            {
                this$0 = AacExtractor.this;
                super();
            }
        };
        mediaInfoBoxHandler = new BoxHandler() {

            final AacExtractor this$0;

            public boolean handleBox(long l, long l1)
            {
                boolean flag = false;
                if (l1 == 0x736d6864L)
                {
                    flag = processSoundMediaHeaderBox(l);
                } else
                {
                    if (l1 == 0x64696e66L)
                    {
                        return processContainer(l, dataInfoBoxHandler);
                    }
                    if (l1 == 0x7374626cL)
                    {
                        return processContainer(l, sampleTableBoxHandler);
                    }
                }
                return flag;
            }

            
            {
                this$0 = AacExtractor.this;
                super();
            }
        };
        dataInfoBoxHandler = new BoxHandler() {

            final AacExtractor this$0;

            public boolean handleBox(long l, long l1)
            {
                return false;
            }

            
            {
                this$0 = AacExtractor.this;
                super();
            }
        };
        sampleTableBoxHandler = new BoxHandler() {

            final AacExtractor this$0;

            public boolean handleBox(long l, long l1)
            {
                boolean flag = false;
                if (l1 == 0x73747364L)
                {
                    flag = processSampleDescBox(l);
                } else
                {
                    if (l1 == 0x73747473L)
                    {
                        return processDecodingTimeToSampleBox(l);
                    }
                    if (l1 == 0x7374737aL)
                    {
                        return processSampleSizeBox(l);
                    }
                    if (l1 == 0x73747363L)
                    {
                        return processSampleToChunkBox(l);
                    }
                    if (l1 == 0x7374636fL)
                    {
                        return processChunkOffsetBox(l, false);
                    }
                    if (l1 == 0x636f3634L)
                    {
                        return processChunkOffsetBox(l, true);
                    }
                }
                return flag;
            }

            
            {
                this$0 = AacExtractor.this;
                super();
            }
        };
        sampleDescBoxHandler = new BoxHandler() {

            final AacExtractor this$0;

            public boolean handleBox(long l, long l1)
            {
                boolean flag = false;
                if (media_handler == 0x736f756eL || media_handler == 0x61757876L || media_handler == 0x68696e74L || media_handler == 0x6d657461L || media_handler == 0x76696465L)
                {
                    flag = processAudioSampleEntry(l);
                }
                return flag;
            }

            
            {
                this$0 = AacExtractor.this;
                super();
            }
        };
    }

    private String Indent(int i)
    {
        String s = "";
        for (; i > 0; i--)
        {
            s = (new StringBuilder()).append(s).append("--").toString();
        }

        return s;
    }

    private static String bytesToHex(byte abyte0[])
    {
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i * 2] = hexArray[j >>> 4];
            ac[i * 2 + 1] = hexArray[j & 0xf];
        }

        return new String(ac);
    }

    private boolean ensureBytesAvailable(long l)
    {
        return getMediaSource() != null && getMediaSource().waitForData(l, 10000) == com.rdio.android.audioplayer.sources.MediaSource.WaitStatus.Success;
    }

    private void logInspection(String s)
    {
        if (inspect)
        {
            String.format("%s%s", new Object[] {
                Indent(indent_level), s
            });
        }
    }

    private boolean processAudioSampleEntry(long l)
    {
        indent_level = indent_level + 1;
        skipBytes(8L);
        skipBytes(8L);
        int i = getMediaSource().readUShort();
        int j = getMediaSource().readUShort();
        skipBytes(4L);
        l = getMediaSource().readUInt(2);
        skipBytes(2L);
        logInspection(String.format("Channels: %d", new Object[] {
            Integer.valueOf(i)
        }));
        logInspection(String.format("Sample Size: %d", new Object[] {
            Integer.valueOf(j)
        }));
        logInspection(String.format("Sample Rate: %d", new Object[] {
            Long.valueOf(l)
        }));
        BoxHeaderParameters boxheaderparameters = new BoxHeaderParameters(0L, 0L, 0L);
        if (!processBoxHeader(boxheaderparameters, false) || boxheaderparameters.tag != 0x65736473L)
        {
            throw new AACParseException("Unable to find esds box inside mp4a box!");
        }
        if (!processESDSBox(boxheaderparameters.contentSize))
        {
            throw new AACParseException("Could not parse esds box!");
        } else
        {
            indent_level = indent_level - 1;
            return true;
        }
    }

    private boolean processBoxHeader(BoxHeaderParameters boxheaderparameters, boolean flag)
    {
        boxheaderparameters.headerSize = 0L;
        boxheaderparameters.contentSize = 0L;
        boxheaderparameters.tag = 0L;
        if (!flag || ensureBytesAvailable(4L)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        long l = getMediaSource().readUInt();
        if (l > 0L)
        {
            if (flag && !ensureBytesAvailable(4L))
            {
                continue; /* Loop/switch isn't completed */
            }
            boxheaderparameters.tag = getMediaSource().readUInt();
            boxheaderparameters.headerSize = boxheaderparameters.headerSize + 8L;
            if (l != 1L)
            {
                break; /* Loop/switch isn't completed */
            }
            if (flag && !ensureBytesAvailable(8L))
            {
                continue; /* Loop/switch isn't completed */
            }
            boxheaderparameters.contentSize = getMediaSource().readLong();
            boxheaderparameters.headerSize = boxheaderparameters.headerSize + 8L;
            break; /* Loop/switch isn't completed */
        } else
        {
            logInspection("End");
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (boxheaderparameters.tag == 0x75756964L)
        {
            Log.e("AACExtractor", "Box with extended type currently is not supported!");
            skipBytes(16L);
            boxheaderparameters.headerSize = boxheaderparameters.headerSize + 16L;
        }
        if (l == 1L && boxheaderparameters.contentSize < 16L)
        {
            Log.e("AACExtractor", String.format("Expecting box extended size to be >= 16, but extended size is %d", new Object[] {
                Long.valueOf(boxheaderparameters.contentSize)
            }));
            return false;
        }
        if (l > 1L && l < 8L)
        {
            Log.e("AACExtractor", String.format("Expecting box size to be >= 8, but size is %d", new Object[] {
                Long.valueOf(l)
            }));
            return false;
        } else
        {
            boxheaderparameters.contentSize = l - boxheaderparameters.headerSize;
            logInspection(String.format("Box %s, size %d", new Object[] {
                AACTag.toString(boxheaderparameters.tag), Long.valueOf(boxheaderparameters.contentSize)
            }));
            return true;
        }
    }

    private boolean processChunkOffsetBox(long l, boolean flag)
    {
        indent_level = indent_level + 1;
        if (processFullBoxParams(new FullBoxParameters((byte)0, 0L)))
        {
            long l1 = getMediaSource().readUInt();
            frame_offset = new long[(int)l1];
            logInspection(String.format("Entries: %d", new Object[] {
                Long.valueOf(l1)
            }));
            l = 0L;
            while (l < l1) 
            {
                if (flag)
                {
                    long l2 = getMediaSource().readLong();
                    frame_offset[(int)l] = l2;
                    if (l < 20L)
                    {
                        logInspection(String.format("[%d] Chunk Offset: %d", new Object[] {
                            Long.valueOf(l), Long.valueOf(l2)
                        }));
                    }
                } else
                {
                    long l3 = getMediaSource().readUInt();
                    frame_offset[(int)l] = l3;
                    if (l < 20L)
                    {
                        logInspection(String.format("[%d] Chunk Offset: %d", new Object[] {
                            Long.valueOf(l), Long.valueOf(l3)
                        }));
                    }
                }
                l++;
            }
            if (l1 - 20L > 0L)
            {
                logInspection(String.format(" ... %d more entries ...", new Object[] {
                    Long.valueOf(l1 - 20L)
                }));
            }
        }
        indent_level = indent_level - 1;
        return true;
    }

    private boolean processContainer(long l, BoxHandler boxhandler)
    {
        BoxHeaderParameters boxheaderparameters = new BoxHeaderParameters(0L, 0L, 0L);
        do
        {
            if (l <= 0L || !processBoxHeader(boxheaderparameters, false))
            {
                break;
            }
            indent_level = indent_level + 1;
            try
            {
                if (!boxhandler.handleBox(boxheaderparameters.contentSize, boxheaderparameters.tag))
                {
                    skipBytes(boxheaderparameters.contentSize);
                }
            }
            catch (AACParseException aacparseexception)
            {
                Log.e("AACExtractor", "Parse exception", aacparseexception);
                try
                {
                    skipBytes(boxheaderparameters.contentSize);
                }
                catch (AACParseException aacparseexception1)
                {
                    Log.e("AACExtractor", "Parse exception, bailing", aacparseexception);
                }
            }
            l -= boxheaderparameters.headerSize + boxheaderparameters.contentSize;
            indent_level = indent_level - 1;
        } while (true);
        return true;
    }

    private boolean processDecodingTimeToSampleBox(long l)
    {
        l = 0L;
        indent_level = indent_level + 1;
        if (processFullBoxParams(new FullBoxParameters((byte)0, 0L)))
        {
            long l1 = getMediaSource().readUInt();
            logInspection(String.format("Entries: %d", new Object[] {
                Long.valueOf(l1)
            }));
            for (; l < l1; l++)
            {
                logInspection(String.format("[%d] Sample count: %d, Sample delta: %d", new Object[] {
                    Long.valueOf(l), Long.valueOf(getMediaSource().readUInt()), Long.valueOf(getMediaSource().readUInt())
                }));
            }

        }
        indent_level = indent_level - 1;
        return true;
    }

    private boolean processESDSBox(long l)
    {
        l = getMediaSource().getBytesRead() + l;
        if (!processFullBoxParams(new FullBoxParameters((byte)0, 0L))) goto _L2; else goto _L1
_L1:
        if (getMediaSource().readByte() != 3) goto _L4; else goto _L3
_L3:
        long l1 = readDescrLength();
        int i = getMediaSource().readUShort();
        byte byte0 = getMediaSource().readByte();
        logInspection(String.format("Elementary Stream Descriptor: Length %d", new Object[] {
            Long.valueOf(l1)
        }));
        indent_level = indent_level + 1;
        logInspection(String.format("es ID: %d", new Object[] {
            Integer.valueOf(i)
        }));
        logInspection(String.format("Priority: %d", new Object[] {
            Byte.valueOf(byte0)
        }));
        indent_level = indent_level - 1;
_L13:
        if (getMediaSource().readByte() != 4) goto _L6; else goto _L5
_L5:
        long l2 = readDescrLength();
        byte byte1 = getMediaSource().readByte();
        byte byte2 = getMediaSource().readByte();
        skipBytes(3L);
        long l4 = getMediaSource().readUInt();
        average_bit_rate = (int)getMediaSource().readUInt();
        logInspection(String.format("Decoder Config Descriptor: Length %d", new Object[] {
            Long.valueOf(l2)
        }));
        indent_level = indent_level + 1;
        logInspection(String.format("Obj ID: 0x%x", new Object[] {
            Byte.valueOf(byte1)
        }));
        logInspection(String.format("Stream type: 0x%x", new Object[] {
            Byte.valueOf(byte2)
        }));
        logInspection(String.format("Max bitrate: %d", new Object[] {
            Long.valueOf(l4)
        }));
        logInspection(String.format("Avg bitrate: %d", new Object[] {
            Integer.valueOf(average_bit_rate)
        }));
        if (getMediaSource().readByte() != 5) goto _L8; else goto _L7
_L7:
        long l3;
        l3 = readDescrLength();
        logInspection(String.format("Decoder Spec Descriptor: Length %d", new Object[] {
            Long.valueOf(l3)
        }));
        indent_level = indent_level + 1;
        esds_config = new byte[(int)l3];
        int j = getMediaSource().readBytes(esds_config, 0, (int)l3);
        if (j < 2) goto _L10; else goto _L9
_L9:
        logInspection(String.format("Config: 0x%s", new Object[] {
            bytesToHex(esds_config)
        }));
_L11:
        indent_level = indent_level - 1;
_L8:
        indent_level = indent_level - 1;
_L6:
        if (l - getMediaSource().getBytesRead() > 0L)
        {
            skipBytes(l - getMediaSource().getBytesRead());
        }
        break; /* Loop/switch isn't completed */
_L4:
        try
        {
            logInspection(String.format("Elementary Stream Descriptor: es ID: %d", new Object[] {
                Integer.valueOf(getMediaSource().readUShort())
            }));
        }
        catch (Exception exception)
        {
            Log.e("AACExtractor", "Exception caught", exception);
            break; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
_L10:
        throw new AACParseException(String.format("Need at least 2 bytes for ESDS config! Bytes read was %d", new Object[] {
            Integer.valueOf(j)
        }));
        Exception exception1;
        exception1;
        Log.e("AACExtractor", "Exception caught", exception1);
        if (true) goto _L11; else goto _L2
_L2:
        return true;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private boolean processFileTypeBox(long l)
    {
        if (inspect)
        {
            indent_level = indent_level + 1;
            long l1 = getMediaSource().readUInt();
            long l2 = getMediaSource().readUInt();
            logInspection(String.format("Major brand: %s", new Object[] {
                AACTag.toString(l1)
            }));
            String s;
            if (l2 == 0L)
            {
                s = "None";
            } else
            {
                s = AACTag.toString(l2);
            }
            logInspection(String.format("Minor version: %s", new Object[] {
                s
            }));
            for (l -= 8L; l > 0L; l -= 4L)
            {
                logInspection(String.format("Compatible brand: %s", new Object[] {
                    AACTag.toString(getMediaSource().readUInt())
                }));
            }

            indent_level = indent_level - 1;
            return true;
        } else
        {
            return false;
        }
    }

    private boolean processFullBoxParams(FullBoxParameters fullboxparameters)
    {
        fullboxparameters.version = getMediaSource().readByte();
        fullboxparameters.flags = getMediaSource().readUInt(3);
        return true;
    }

    private boolean processMediaHandlerBox(long l)
    {
label0:
        {
            indent_level = indent_level + 1;
            if (processFullBoxParams(new FullBoxParameters((byte)0, 0L)))
            {
                skipBytes(4L);
                long l1 = getMediaSource().readUInt();
                if (l1 != 0x76696465L && l1 != 0x736f756eL && l1 != 0x68696e74L && l1 != 0x6d657461L && l1 != 0x61757876L)
                {
                    break label0;
                }
                media_handler = l1;
                skipBytes(12L);
                String s = getMediaSource().readString((int)(l - 24L));
                logInspection(String.format("Handler: %s", new Object[] {
                    Long.valueOf(media_handler)
                }));
                logInspection(String.format("Name: %s", new Object[] {
                    s.substring(1)
                }));
            }
            indent_level = indent_level - 1;
            return true;
        }
        throw new AACParseException("Unknown media handler type in hdlr box!");
    }

    private boolean processMediaHeaderBox(long l)
    {
        boolean flag = false;
        if (inspect)
        {
            indent_level = indent_level + 1;
            FullBoxParameters fullboxparameters = new FullBoxParameters((byte)0, 0L);
            if (processFullBoxParams(fullboxparameters))
            {
                if (fullboxparameters.version == 1)
                {
                    l = getMediaSource().readLong();
                    long l1 = getMediaSource().readLong();
                    long l3 = getMediaSource().readUInt();
                    long l5 = getMediaSource().readLong();
                    logInspection(String.format("Created: %d", new Object[] {
                        Long.valueOf(l)
                    }));
                    logInspection(String.format("Modified: %d", new Object[] {
                        Long.valueOf(l1)
                    }));
                    double d;
                    if (l5 == -1L || l3 == 0L)
                    {
                        d = 0.0D;
                    } else
                    {
                        d = (double)l5 / (double)l3;
                    }
                    logInspection(String.format("Duration: %f sec", new Object[] {
                        Double.valueOf(d)
                    }));
                } else
                {
                    l = getMediaSource().readUInt();
                    long l2 = getMediaSource().readUInt();
                    long l4 = getMediaSource().readUInt();
                    long l6 = getMediaSource().readUInt();
                    logInspection(String.format("Created: %d", new Object[] {
                        Long.valueOf(l)
                    }));
                    logInspection(String.format("Modified: %d", new Object[] {
                        Long.valueOf(l2)
                    }));
                    double d1;
                    if (l6 == -1L || l4 == 0L)
                    {
                        d1 = 0.0D;
                    } else
                    {
                        d1 = (double)l6 / (double)l4;
                    }
                    logInspection(String.format("Duration: %f sec", new Object[] {
                        Double.valueOf(d1)
                    }));
                }
                skipBytes(4L);
            }
            indent_level = indent_level - 1;
            flag = true;
        }
        return flag;
    }

    private boolean processMetaData()
    {
        if (getMediaSource() == null)
        {
            throw new AACParseException("Cannot process meta data, audio source is null!");
        }
        BoxHeaderParameters boxheaderparameters = new BoxHeaderParameters(0L, 0L, 0L);
        boolean flag = false;
        while (boxheaderparameters.tag != 0x6d6f6f76L && processBoxHeader(boxheaderparameters, true)) 
        {
            if (boxheaderparameters.tag == 0x6d6f6f76L)
            {
                if (ensureBytesAvailable(boxheaderparameters.contentSize))
                {
                    flag = processContainer(boxheaderparameters.contentSize, movieBoxHandler);
                } else
                {
                    Log.e("AACExtractor", String.format("ProcessMetaData() - moov box found but could not get enough bytes, needed %d bytes", new Object[] {
                        Long.valueOf(boxheaderparameters.contentSize)
                    }));
                }
            } else
            {
                skipBytes(boxheaderparameters.contentSize);
            }
        }
        return flag;
    }

    private boolean processMovieHeaderBox(long l)
    {
        boolean flag = false;
        if (inspect)
        {
            indent_level = indent_level + 1;
            FullBoxParameters fullboxparameters = new FullBoxParameters((byte)0, 0L);
            if (processFullBoxParams(fullboxparameters))
            {
                if (fullboxparameters.version == 1)
                {
                    l = getMediaSource().readLong();
                    long l1 = getMediaSource().readLong();
                    mv_tk_timescale = getMediaSource().readUInt();
                    long l3 = getMediaSource().readLong();
                    logInspection(String.format("Created: %d", new Object[] {
                        Long.valueOf(l)
                    }));
                    logInspection(String.format("Modified: %d", new Object[] {
                        Long.valueOf(l1)
                    }));
                    double d;
                    if (l3 == -1L || mv_tk_timescale == 0L)
                    {
                        d = 0.0D;
                    } else
                    {
                        d = (double)l3 / (double)mv_tk_timescale;
                    }
                    logInspection(String.format("Duration: %f sec", new Object[] {
                        Double.valueOf(d)
                    }));
                } else
                {
                    l = getMediaSource().readUInt();
                    long l2 = getMediaSource().readUInt();
                    mv_tk_timescale = getMediaSource().readUInt();
                    long l4 = getMediaSource().readUInt();
                    logInspection(String.format("Created: %d", new Object[] {
                        Long.valueOf(l)
                    }));
                    logInspection(String.format("Modified: %d", new Object[] {
                        Long.valueOf(l2)
                    }));
                    double d1;
                    if (l4 == -1L || mv_tk_timescale == 0L)
                    {
                        d1 = 0.0D;
                    } else
                    {
                        d1 = (double)l4 / (double)mv_tk_timescale;
                    }
                    logInspection(String.format("Duration: %f sec", new Object[] {
                        Double.valueOf(d1)
                    }));
                }
                skipBytes(80L);
            }
            indent_level = indent_level - 1;
            flag = true;
        }
        return flag;
    }

    private boolean processSampleDescBox(long l)
    {
        indent_level = indent_level + 1;
        if (!processFullBoxParams(new FullBoxParameters((byte)0, 0L))) goto _L2; else goto _L1
_L1:
        BoxHeaderParameters boxheaderparameters;
        l = getMediaSource().readUInt();
        boxheaderparameters = new BoxHeaderParameters(0L, 0L, 0L);
_L4:
        long l1 = l - 1L;
        if (l <= 0L) goto _L2; else goto _L3
_L3:
        if (!processBoxHeader(boxheaderparameters, false))
        {
            throw new AACParseException("Unable to find a box in sample description - stsd box!");
        }
        if (!sampleDescBoxHandler.handleBox(boxheaderparameters.contentSize, boxheaderparameters.tag))
        {
            skipBytes(boxheaderparameters.contentSize);
            l = l1;
        } else
        {
            l = l1;
        }
        if (true) goto _L4; else goto _L2
_L2:
        indent_level = indent_level - 1;
        return true;
    }

    private boolean processSampleSizeBox(long l)
    {
        indent_level = indent_level + 1;
        if (processFullBoxParams(new FullBoxParameters((byte)0, 0L)))
        {
            l = getMediaSource().readUInt();
            long l1 = getMediaSource().readUInt();
            logInspection(String.format("Sample size: %d, Sample count: %d", new Object[] {
                Long.valueOf(l), Long.valueOf(l1)
            }));
            if (l == 0L)
            {
                frame_count = l1;
                frame_size = new long[(int)frame_count];
                for (l = 0L; l < l1; l++)
                {
                    long l2 = getMediaSource().readUInt();
                    if (l < 20L)
                    {
                        logInspection(String.format("[%d] Entry size: %d", new Object[] {
                            Long.valueOf(l), Long.valueOf(l2)
                        }));
                    }
                    frame_size[(int)l] = l2;
                }

                if (l1 - 20L > 0L)
                {
                    logInspection(String.format(" ... %d more entries ...", new Object[] {
                        Long.valueOf(l1 - 20L)
                    }));
                }
            } else
            {
                frame_size = new long[1];
                frame_size[0] = l;
            }
        }
        indent_level = indent_level - 1;
        return true;
    }

    private boolean processSampleToChunkBox(long l)
    {
        indent_level = indent_level + 1;
        if (processFullBoxParams(new FullBoxParameters((byte)0, 0L)))
        {
            long l1 = getMediaSource().readUInt();
            logInspection(String.format("Entries: %d", new Object[] {
                Long.valueOf(l1)
            }));
            for (l = 0L; l < l1; l++)
            {
                logInspection(String.format("[%d] First chunk: %d, Samples per chunk: %d, Sample description index:%d", new Object[] {
                    Long.valueOf(l), Long.valueOf(getMediaSource().readUInt()), Long.valueOf(getMediaSource().readUInt()), Long.valueOf(getMediaSource().readUInt())
                }));
            }

        }
        indent_level = indent_level - 1;
        return true;
    }

    private boolean processSoundMediaHeaderBox(long l)
    {
        if (inspect)
        {
            indent_level = indent_level + 1;
            if (processFullBoxParams(new FullBoxParameters((byte)0, 0L)))
            {
                logInspection(String.format("Balance: %d", new Object[] {
                    Integer.valueOf(getMediaSource().readUShort())
                }));
                skipBytes(2L);
            }
            indent_level = indent_level - 1;
            return true;
        } else
        {
            return false;
        }
    }

    private boolean processTrackHeaderBox(long l)
    {
        boolean flag = false;
        if (inspect)
        {
            indent_level = indent_level + 1;
            FullBoxParameters fullboxparameters = new FullBoxParameters((byte)0, 0L);
            if (processFullBoxParams(fullboxparameters))
            {
                if (fullboxparameters.version == 1)
                {
                    l = getMediaSource().readLong();
                    long l1 = getMediaSource().readLong();
                    long l3 = getMediaSource().readUInt();
                    skipBytes(4L);
                    long l5 = getMediaSource().readLong();
                    logInspection(String.format("Created: %d", new Object[] {
                        Long.valueOf(l)
                    }));
                    logInspection(String.format("Modified: %d", new Object[] {
                        Long.valueOf(l1)
                    }));
                    logInspection(String.format("Track ID: %d", new Object[] {
                        Long.valueOf(l3)
                    }));
                    double d;
                    if (l5 == -1L || mv_tk_timescale == 0L)
                    {
                        d = 0.0D;
                    } else
                    {
                        d = (double)l5 / (double)mv_tk_timescale;
                    }
                    logInspection(String.format("Duration: %f sec", new Object[] {
                        Double.valueOf(d)
                    }));
                } else
                {
                    l = getMediaSource().readUInt();
                    long l2 = getMediaSource().readUInt();
                    long l4 = getMediaSource().readUInt();
                    skipBytes(4L);
                    long l6 = getMediaSource().readUInt();
                    logInspection(String.format("Created: %d", new Object[] {
                        Long.valueOf(l)
                    }));
                    logInspection(String.format("Modified: %d", new Object[] {
                        Long.valueOf(l2)
                    }));
                    logInspection(String.format("Track ID: %d", new Object[] {
                        Long.valueOf(l4)
                    }));
                    double d1;
                    if (l6 == -1L || mv_tk_timescale == 0L)
                    {
                        d1 = 0.0D;
                    } else
                    {
                        d1 = (double)l6 / (double)mv_tk_timescale;
                    }
                    logInspection(String.format("Duration: %f sec", new Object[] {
                        Double.valueOf(d1)
                    }));
                }
                skipBytes(60L);
            }
            indent_level = indent_level - 1;
            flag = true;
        }
        return flag;
    }

    private long readDescrLength()
    {
        int i = 0;
        long l = 0L;
        do
        {
            int j;
            byte byte0;
            long l1;
            try
            {
                byte0 = getMediaSource().readByte();
            }
            catch (Exception exception)
            {
                Log.e("AACExtractor", "Exception caught:", exception);
                return l;
            }
            l1 = l;
            j = i;
            if (byte0 >= 0)
            {
                j = i + 1;
                l1 = l << 7 | (long)(byte0 & 0x7f);
            }
            if (byte0 < 0 || (byte0 & 0x80) <= 0)
            {
                break;
            }
            l = l1;
            i = j;
        } while (j < 4);
        return l1;
    }

    private void skipBytes(long l)
    {
        try
        {
            getMediaSource().seekBytes(l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.Current);
            return;
        }
        catch (IOException ioexception)
        {
            Log.e("AACExtractor", "Could not skipBytes!", ioexception);
        }
        throw new AACParseException("Exception caught when skipping bytes");
    }

    public boolean advance()
    {
        if (curr_frame < frame_count)
        {
            curr_frame = curr_frame + 1L;
            return true;
        } else
        {
            return false;
        }
    }

    public void cancelIfWaiting()
    {
        if (getMediaSource() != null)
        {
            getMediaSource().cancelWait();
        }
    }

    public long getBytesRead()
    {
        if (getMediaSource() == null)
        {
            return 0L;
        } else
        {
            return getMediaSource().getBytesRead();
        }
    }

    public byte[] getESDSConfig()
    {
        return esds_config;
    }

    public long getSampleTime()
    {
        return presentation_time;
    }

    public boolean getTrackFormat(int i, MediaFormat mediaformat)
    {
        if (esds_config != null && esds_config.length >= 2)
        {
            String s = ESDS_OBJTYPE_TABLE[(esds_config[0] & 0xf8) >> 3];
            i = ESDS_FREQ_TABLE[(esds_config[0] & 7) << 1 | esds_config[1] >> 7];
            int j = ESDS_CHANNEL_TABLE[(esds_config[1] & 0x78) >> 3];
            String.format("Creating AAC MediaFormat, obj type: %s, sampling rate: %d, channels: %d", new Object[] {
                s, Integer.valueOf(i), Integer.valueOf(j)
            });
            mediaformat.setAAC(i, j, esds_config);
            return true;
        } else
        {
            return false;
        }
    }

    protected void onSetDataSource(MediaSource mediasource)
    {
    }

    public int readSampleData(MediaBuffer mediabuffer, int i)
    {
        if (curr_frame < frame_count) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (!waitForData(presentation_time / 1000L, i = (int)frame_size[(int)curr_frame], average_bit_rate)) goto _L1; else goto _L3
_L3:
        int j;
        try
        {
            if (read_buffer == null || read_buffer.length < i)
            {
                read_buffer = new byte[i * 2];
            }
            j = getMediaSource().readBytes(read_buffer, 0, i);
        }
        // Misplaced declaration of an exception variable
        catch (MediaBuffer mediabuffer)
        {
            Log.e("AACExtractor", "ReadSampleData(), Exception caught}", mediabuffer);
            return -1;
        }
        if (j == i)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.e("AACExtractor", String.format("Error! Framesize is %d but read %d bytes!!!", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }));
        if (j < 0) goto _L1; else goto _L4
_L4:
        mediabuffer.put(read_buffer, 0, j);
        presentation_time = (long)(((double)curr_frame / (double)frame_count) * getMediaSource().getDuration() * 1000D);
        return j;
    }

    public void releaseDataSource()
    {
        super.releaseDataSource();
        indent_level = 0;
        mv_tk_timescale = 0L;
        curr_frame = 0L;
        esds_config = null;
        frame_count = 0L;
        frame_size = null;
        frame_offset = null;
        presentation_time = 0L;
    }

    public int seek(int i, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
    {
        long l = (long)getMediaSource().getDuration();
        if (l > 0L && frame_offset != null && frame_offset.length > 0)
        {
            curr_frame = (long)(Math.max(Math.min((double)i / (double)l, 1.0D), 0.0D) * (double)frame_offset.length);
            l = frame_offset[(int)curr_frame];
            String.format("Requested seek for %d msec, computed AAC frame is %d, with byte offset %d", new Object[] {
                Integer.valueOf(i), Long.valueOf(curr_frame), Long.valueOf(l)
            });
            try
            {
                getMediaSource().seekBytes(l, seekorigin);
            }
            // Misplaced declaration of an exception variable
            catch (com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
            {
                Log.e("AACExtractor", "Could not seek!", seekorigin);
                return i;
            }
            return i;
        } else
        {
            return -1;
        }
    }

    public void selectTrack(int i)
    {
        try
        {
            if (!processMetaData())
            {
                throw new AACParseException("Could not process aac metadata (moov box)");
            }
        }
        catch (Exception exception)
        {
            Log.e("AACExtractor", String.format("SelectTrack(%d), Exception caught", new Object[] {
                Integer.valueOf(i)
            }), exception);
            return;
        }
        if (frame_offset == null || frame_offset.length == 0)
        {
            throw new AACParseException("Invalid frame offset table");
        } else
        {
            getMediaSource().seekBytes(frame_offset[0], com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.Begin);
            getMediaSource().updateMediaBitrate(average_bit_rate);
            getMediaSource().updateMediaType(MediaTypeUtil.MediaType.AAC);
            return;
        }
    }



















}
