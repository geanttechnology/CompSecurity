// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;
import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;
import com.googlecode.javacv.Frame;
import com.googlecode.javacv.cpp.avcodec;
import com.googlecode.javacv.cpp.avformat;
import com.googlecode.javacv.cpp.avutil;
import com.googlecode.javacv.cpp.swresample;
import com.googlecode.javacv.cpp.swscale;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android.recorder:
//            RecordConfigUtils

public class SwVineFrameRecorder
{
    public static class Exception extends java.lang.Exception
    {

        public Exception(String s)
        {
            super(s);
        }

        public Exception(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    static final boolean $assertionsDisabled;
    public static final int LOCK[];
    public static boolean hasEverSuccessfullyLoaded;
    private static Exception loadingException;
    protected int audioBitrate;
    protected int audioChannels;
    protected int audioCodec;
    protected String audioCodecName;
    protected HashMap audioOptions;
    protected double audioQuality;
    private long audioRecordTime;
    private com.googlecode.javacv.cpp.avcodec.AVCodecContext audio_c;
    private long audio_clock;
    private com.googlecode.javacv.cpp.avcodec.AVCodec audio_codec;
    private int audio_input_frame_size;
    private BytePointer audio_outbuf;
    private int audio_outbuf_size;
    public com.googlecode.javacv.cpp.avcodec.AVPacket audio_pkt;
    private com.googlecode.javacv.cpp.avformat.AVStream audio_st;
    private String filename;
    protected String format;
    private com.googlecode.javacv.cpp.avutil.AVFrame frame;
    protected int frameNumber;
    protected double frameRate;
    private int got_audio_packet[];
    private int got_video_packet[];
    private boolean hasData;
    protected int imageHeight;
    protected int imageWidth;
    private com.googlecode.javacv.cpp.swscale.SwsContext img_convert_ctx;
    protected boolean interleaved;
    private volatile boolean isReleased;
    private boolean isVorbis;
    private com.googlecode.javacv.cpp.avformat.AVFormatContext oc;
    private com.googlecode.javacv.cpp.avformat.AVOutputFormat oformat;
    private com.googlecode.javacv.cpp.avutil.AVFrame picture;
    private BytePointer picture_buf;
    protected int pixelFormat;
    protected int sampleFormat;
    protected int sampleRate;
    private com.googlecode.javacv.cpp.swresample.SwrContext samples_convert_ctx;
    private Pointer samples_in[];
    private PointerPointer samples_in_ptr;
    private BytePointer samples_out[];
    private PointerPointer samples_out_ptr;
    protected long timestamp;
    private com.googlecode.javacv.cpp.avutil.AVFrame tmp_picture;
    protected int videoBitrate;
    protected int videoCodec;
    protected String videoCodecName;
    private long videoEncodeTime;
    protected HashMap videoOptions;
    protected double videoQuality;
    private long videoScaleTime;
    private long videoWriteTime;
    private com.googlecode.javacv.cpp.avcodec.AVCodecContext video_c;
    private com.googlecode.javacv.cpp.avcodec.AVCodec video_codec;
    private BytePointer video_outbuf;
    private int video_outbuf_size;
    public com.googlecode.javacv.cpp.avcodec.AVPacket video_pkt;
    private com.googlecode.javacv.cpp.avformat.AVStream video_st;

    public SwVineFrameRecorder(File file, int i)
    {
        this(file, 0, 0, i);
    }

    public SwVineFrameRecorder(File file, int i, int j)
    {
        this(file, i, j, 0);
    }

    public SwVineFrameRecorder(File file, int i, int j, int k)
    {
        this(file.getAbsolutePath(), i, j, k);
    }

    public SwVineFrameRecorder(String s, int i)
    {
        this(s, 0, 0, i);
    }

    public SwVineFrameRecorder(String s, int i, int j)
    {
        this(s, i, j, 0);
    }

    public SwVineFrameRecorder(String s, int i, int j, int k)
    {
        this(s, i, j, k, null, null);
    }

    public SwVineFrameRecorder(String s, int i, int j, int k, com.googlecode.javacv.cpp.avcodec.AVPacket avpacket, com.googlecode.javacv.cpp.avcodec.AVPacket avpacket1)
    {
        videoQuality = -1D;
        audioQuality = -1D;
        videoOptions = new HashMap();
        audioOptions = new HashMap();
        frameNumber = 0;
        timestamp = 0L;
        hasData = false;
        isReleased = false;
        SLog.d("Creating a recorder thats {} * {}", Integer.valueOf(i), Integer.valueOf(j));
        filename = s;
        imageWidth = i;
        imageHeight = j;
        audioChannels = k;
        pixelFormat = -1;
        videoCodec = 0;
        videoBitrate = RecordConfigUtils.VIDEO_BIT_RATE;
        frameRate = 30D;
        sampleFormat = -1;
        audioCodec = 0;
        audioBitrate = RecordConfigUtils.AUDIO_BIT_RATE;
        sampleRate = 44100;
        interleaved = true;
        if (avpacket == null)
        {
            avpacket = new com.googlecode.javacv.cpp.avcodec.AVPacket();
        }
        video_pkt = avpacket;
        if (avpacket1 == null)
        {
            avpacket1 = new com.googlecode.javacv.cpp.avcodec.AVPacket();
        }
        audio_pkt = avpacket1;
    }

    public static void tryLoad(Context context)
        throws Exception
    {
        if (loadingException != null)
        {
            throw loadingException;
        }
        try
        {
            Loader.load(com/googlecode/javacv/cpp/avutil);
            Loader.load(com/googlecode/javacv/cpp/avcodec);
            Loader.load(com/googlecode/javacv/cpp/avformat);
            Loader.load(com/googlecode/javacv/cpp/swscale);
            Loader.load(com/googlecode/javacv/cpp/swresample);
            hasEverSuccessfullyLoaded = true;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (context instanceof Exception)
            {
                context = (Exception)context;
                loadingException = context;
                throw context;
            } else
            {
                context = new Exception((new StringBuilder()).append("Failed to load ").append(co/vine/android/recorder/SwVineFrameRecorder).toString(), context);
                loadingException = context;
                throw context;
            }
        }
        RecordConfigUtils.setLoadWasEverSuccessful(context, true);
    }

    private int writeVideoFrame()
        throws Exception
    {
        long l = System.currentTimeMillis();
        com.googlecode.javacv.cpp.avformat.AVFormatContext avformatcontext = oc;
        avformatcontext;
        JVM INSTR monitorenter ;
        int j;
        if (!interleaved || audio_st == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        j = avformat.av_interleaved_write_frame(oc, video_pkt);
        int i;
        i = j;
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        throw new Exception((new StringBuilder()).append("av_interleaved_write_frame() error ").append(j).append(" while writing interleaved video frame.").toString());
        java.lang.Exception exception;
        exception;
        avformatcontext;
        JVM INSTR monitorexit ;
        throw exception;
        j = avformat.av_write_frame(oc, video_pkt);
        i = j;
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        throw new Exception((new StringBuilder()).append("av_write_frame() error ").append(j).append(" while writing video frame.").toString());
        videoWriteTime = videoWriteTime + (System.currentTimeMillis() - l);
        avformatcontext;
        JVM INSTR monitorexit ;
        return i;
    }

    public int encode(com.googlecode.javacv.cpp.opencv_core.IplImage iplimage, byte abyte0[], int i)
        throws Exception
    {
        byte byte0 = -1;
        int j = byte0;
        if (record(iplimage, -1, true))
        {
            iplimage = video_pkt.data();
            j = byte0;
            if (iplimage != null)
            {
                j = video_pkt.size();
                iplimage.get(abyte0, i, j);
            }
        }
        return j;
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        release();
    }

    public String getAudioCodecName()
    {
        return audioCodecName;
    }

    public String getErrorString(int i)
    {
        byte abyte0[] = new byte[64];
        avutil.av_make_error_string(abyte0, abyte0.length, i);
        int j = 0;
        int k = abyte0.length;
        i = 0;
        do
        {
            if (i >= k || abyte0[i] == 0)
            {
                return new String(abyte0, 0, j);
            }
            j++;
            i++;
        } while (true);
    }

    public String getFilename()
    {
        return filename;
    }

    public String getFormat()
    {
        return format;
    }

    public int getFrameNumber()
    {
        if (picture == null)
        {
            return (int)audio_pkt.pts();
        } else
        {
            return (int)picture.pts();
        }
    }

    public double getFrameRate()
    {
        return frameRate;
    }

    public long getTimestamp()
    {
        if (picture == null)
        {
            return (audio_clock * 0xf4240L) / (long)sampleRate;
        } else
        {
            return Math.round((double)((long)getFrameNumber() * 0xf4240L) / getFrameRate());
        }
    }

    public String getVideoCodecName()
    {
        return videoCodecName;
    }

    public int getVideoCodecPixFormat()
    {
        return video_c.pix_fmt();
    }

    public boolean hasData()
    {
        return hasData;
    }

    public boolean isReleased()
    {
        return isReleased;
    }

    public void record(Frame frame1)
        throws Exception
    {
        if (frame1 == null || frame1.image == null && frame1.samples == null)
        {
            record((com.googlecode.javacv.cpp.opencv_core.IplImage)null);
        } else
        {
            if (frame1.image != null)
            {
                frame1.keyFrame = record(frame1.image);
            }
            if (frame1.samples != null)
            {
                frame1.keyFrame = record(frame1.samples);
                return;
            }
        }
    }

    boolean record(com.googlecode.javacv.cpp.avutil.AVFrame avframe)
        throws Exception
    {
        boolean flag;
        flag = false;
        avcodec.av_init_packet(audio_pkt);
        audio_pkt.data(audio_outbuf);
        audio_pkt.size(audio_outbuf_size);
        int i = avcodec.avcodec_encode_audio2(audio_c, audio_pkt, avframe, got_audio_packet);
        if (i < 0)
        {
            throw new Exception((new StringBuilder()).append("avcodec_encode_audio2() error ").append(i).append(": Could not encode audio packet.").toString());
        }
        if (got_audio_packet[0] == 0)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        if (audio_pkt.pts() != avutil.AV_NOPTS_VALUE)
        {
            audio_pkt.pts(avutil.av_rescale_q(audio_pkt.pts(), audio_c.time_base(), audio_c.time_base()));
        }
        if (audio_pkt.dts() != avutil.AV_NOPTS_VALUE)
        {
            audio_pkt.dts(avutil.av_rescale_q(audio_pkt.dts(), audio_c.time_base(), audio_c.time_base()));
        }
        audio_pkt.flags(audio_pkt.flags() | 1);
        audio_pkt.stream_index(audio_st.index());
        avframe = oc;
        avframe;
        JVM INSTR monitorenter ;
        int j;
        if (!interleaved || video_st == null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        j = avformat.av_interleaved_write_frame(oc, audio_pkt);
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        throw new Exception((new StringBuilder()).append("av_interleaved_write_frame() error ").append(j).append(" while writing interleaved audio frame.").toString());
        java.lang.Exception exception;
        exception;
        avframe;
        JVM INSTR monitorexit ;
        throw exception;
        j = avformat.av_write_frame(oc, audio_pkt);
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        throw new Exception((new StringBuilder()).append("av_write_frame() error ").append(j).append(" while writing audio frame.").toString());
        avframe;
        JVM INSTR monitorexit ;
        flag = true;
        return flag;
    }

    public boolean record(com.googlecode.javacv.cpp.opencv_core.IplImage iplimage)
        throws Exception
    {
        return record(iplimage, -1, false);
    }

    public boolean record(com.googlecode.javacv.cpp.opencv_core.IplImage iplimage, int i, boolean flag)
        throws Exception
    {
        if (video_st == null)
        {
            throw new Exception("No video output stream (Is imageWidth > 0 && imageHeight > 0 and has start() been called?)");
        }
        if (iplimage != null)
        {
            hasData = true;
            int l = iplimage.width();
            int j1 = iplimage.height();
            int i1 = iplimage.widthStep();
            BytePointer bytepointer = iplimage.imageData();
            int k = i1;
            int j = i;
            long l1;
            if (i == -1)
            {
                i = iplimage.depth();
                j = iplimage.nChannels();
                if ((i == 8 || i == 0x80000008) && j == 3)
                {
                    j = 3;
                    k = i1;
                } else
                if ((i == 8 || i == 0x80000008) && j == 1)
                {
                    j = 8;
                    k = i1;
                } else
                if ((i == 16 || i == 0x80000010) && j == 1)
                {
                    if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN))
                    {
                        j = 31;
                    } else
                    {
                        j = 32;
                    }
                    k = i1;
                } else
                if ((i == 8 || i == 0x80000008) && j == 4)
                {
                    j = 28;
                    k = i1;
                } else
                if ((i == 8 || i == 0x80000008) && j == 2)
                {
                    j = 26;
                    k = l;
                } else
                {
                    throw new Exception((new StringBuilder()).append("Could not guess pixel format of image: depth=").append(i).append(", channels=").append(j).toString());
                }
            }
            l1 = System.currentTimeMillis();
            if (video_c.pix_fmt() != j || video_c.width() != l || video_c.height() != j1)
            {
                img_convert_ctx = swscale.sws_getCachedContext(img_convert_ctx, l, j1, j, video_c.width(), video_c.height(), video_c.pix_fmt(), 2, null, null, (DoublePointer)null);
                if (img_convert_ctx == null)
                {
                    throw new Exception("sws_getCachedContext() error: Cannot initialize the conversion context.");
                }
                avcodec.avpicture_fill(new com.googlecode.javacv.cpp.avcodec.AVPicture(tmp_picture), bytepointer, j, l, j1);
                avcodec.avpicture_fill(new com.googlecode.javacv.cpp.avcodec.AVPicture(picture), picture_buf, video_c.pix_fmt(), video_c.width(), video_c.height());
                tmp_picture.linesize(0, k);
                swscale.sws_scale(img_convert_ctx, new PointerPointer(tmp_picture), tmp_picture.linesize(), 0, j1, new PointerPointer(picture), picture.linesize());
                videoScaleTime = videoScaleTime + (System.currentTimeMillis() - l1);
            } else
            {
                avcodec.avpicture_fill(new com.googlecode.javacv.cpp.avcodec.AVPicture(picture), bytepointer, j, l, j1);
                picture.linesize(0, k);
            }
        }
        if ((oformat.flags() & 0x20) != 0)
        {
            if (iplimage == null)
            {
                return false;
            }
            avcodec.av_init_packet(video_pkt);
            video_pkt.flags(video_pkt.flags() | 1);
            video_pkt.stream_index(video_st.index());
            video_pkt.data(new BytePointer(picture));
            video_pkt.size(Loader.sizeof(com/googlecode/javacv/cpp/avcodec$AVPicture));
        } else
        {
            avcodec.av_init_packet(video_pkt);
            video_pkt.data(video_outbuf);
            video_pkt.size(video_outbuf_size);
            picture.quality(video_c.global_quality());
            long l2 = System.currentTimeMillis();
            com.googlecode.javacv.cpp.avcodec.AVCodecContext avcodeccontext = video_c;
            com.googlecode.javacv.cpp.avcodec.AVPacket avpacket = video_pkt;
            if (iplimage == null)
            {
                iplimage = null;
            } else
            {
                iplimage = picture;
            }
            i = avcodec.avcodec_encode_video2(avcodeccontext, avpacket, iplimage, got_video_packet);
            if (i < 0)
            {
                throw new Exception((new StringBuilder()).append("avcodec_encode_video2() error ").append(i).append(": Could not encode video packet.").toString());
            }
            picture.pts(picture.pts() + 1L);
            if (got_video_packet[0] != 0)
            {
                if (!flag)
                {
                    if (video_pkt.pts() != avutil.AV_NOPTS_VALUE)
                    {
                        video_pkt.pts(avutil.av_rescale_q(video_pkt.pts(), video_c.time_base(), video_st.time_base()));
                    }
                    if (video_pkt.dts() != avutil.AV_NOPTS_VALUE)
                    {
                        video_pkt.dts(avutil.av_rescale_q(video_pkt.dts(), video_c.time_base(), video_st.time_base()));
                    }
                    video_pkt.stream_index(video_st.index());
                }
                videoEncodeTime = videoEncodeTime + (System.currentTimeMillis() - l2);
            } else
            {
                return false;
            }
        }
        if (!flag)
        {
            writeVideoFrame();
        }
        return picture.key_frame() != 0;
    }

    public transient boolean record(Buffer abuffer[])
        throws Exception
    {
        byte byte0;
        int i2;
        int j2;
        int l3;
        int i4;
        long l4;
        if (audio_st == null)
        {
            throw new Exception("No audio output stream (Is audioChannels > 0 and has start() been called?)");
        }
        hasData = true;
        l4 = System.currentTimeMillis();
        int j4 = abuffer[0].limit() - abuffer[0].position();
        int i;
        if (abuffer.length > 1)
        {
            i2 = 1;
        } else
        {
            i2 = audioChannels;
        }
        l3 = audio_c.sample_fmt();
        if (samples_out.length > 1)
        {
            j2 = 1;
        } else
        {
            j2 = audioChannels;
        }
        i4 = avutil.av_get_bytes_per_sample(l3);
        if (abuffer[0] instanceof ByteBuffer)
        {
            byte byte1;
            int k2;
            boolean flag;
            if (abuffer.length > 1)
            {
                byte1 = 5;
            } else
            {
                byte1 = 0;
            }
            flag = true;
            k2 = 0;
            do
            {
                i = byte1;
                byte0 = flag;
                if (k2 >= abuffer.length)
                {
                    break;
                }
                ByteBuffer bytebuffer = (ByteBuffer)abuffer[k2];
                if ((samples_in[k2] instanceof BytePointer) && samples_in[k2].capacity() >= j4 && bytebuffer.hasArray())
                {
                    ((BytePointer)samples_in[k2]).position(0).put(bytebuffer.array(), bytebuffer.position(), j4);
                } else
                {
                    samples_in[k2] = new BytePointer(bytebuffer);
                }
                k2++;
            } while (true);
        } else
        if (abuffer[0] instanceof ShortBuffer)
        {
            byte byte2;
            int l2;
            byte byte6;
            if (abuffer.length > 1)
            {
                byte2 = 6;
            } else
            {
                byte2 = 1;
            }
            byte6 = 2;
            l2 = 0;
            do
            {
                i = byte2;
                byte0 = byte6;
                if (l2 >= abuffer.length)
                {
                    break;
                }
                ShortBuffer shortbuffer = (ShortBuffer)abuffer[l2];
                if ((samples_in[l2] instanceof ShortPointer) && samples_in[l2].capacity() >= j4 && shortbuffer.hasArray())
                {
                    ((ShortPointer)samples_in[l2]).position(0).put(shortbuffer.array(), abuffer[l2].position(), j4);
                } else
                {
                    samples_in[l2] = new ShortPointer(shortbuffer);
                }
                l2++;
            } while (true);
        } else
        if (abuffer[0] instanceof IntBuffer)
        {
            byte byte3;
            int i3;
            byte byte7;
            if (abuffer.length > 1)
            {
                byte3 = 7;
            } else
            {
                byte3 = 2;
            }
            byte7 = 4;
            i3 = 0;
            do
            {
                i = byte3;
                byte0 = byte7;
                if (i3 >= abuffer.length)
                {
                    break;
                }
                IntBuffer intbuffer = (IntBuffer)abuffer[i3];
                if ((samples_in[i3] instanceof IntPointer) && samples_in[i3].capacity() >= j4 && intbuffer.hasArray())
                {
                    ((IntPointer)samples_in[i3]).position(0).put(intbuffer.array(), abuffer[i3].position(), j4);
                } else
                {
                    samples_in[i3] = new IntPointer(intbuffer);
                }
                i3++;
            } while (true);
        } else
        if (abuffer[0] instanceof FloatBuffer)
        {
            byte byte4;
            int j3;
            byte byte8;
            if (abuffer.length > 1)
            {
                byte4 = 8;
            } else
            {
                byte4 = 3;
            }
            byte8 = 4;
            j3 = 0;
            do
            {
                i = byte4;
                byte0 = byte8;
                if (j3 >= abuffer.length)
                {
                    break;
                }
                FloatBuffer floatbuffer = (FloatBuffer)abuffer[j3];
                if ((samples_in[j3] instanceof FloatPointer) && samples_in[j3].capacity() >= j4 && floatbuffer.hasArray())
                {
                    ((FloatPointer)samples_in[j3]).position(0).put(floatbuffer.array(), floatbuffer.position(), j4);
                } else
                {
                    samples_in[j3] = new FloatPointer(floatbuffer);
                }
                j3++;
            } while (true);
        } else
        if (abuffer[0] instanceof DoubleBuffer)
        {
            byte byte5;
            int k3;
            byte byte9;
            if (abuffer.length > 1)
            {
                byte5 = 9;
            } else
            {
                byte5 = 4;
            }
            byte9 = 8;
            k3 = 0;
            do
            {
                i = byte5;
                byte0 = byte9;
                if (k3 >= abuffer.length)
                {
                    break;
                }
                DoubleBuffer doublebuffer = (DoubleBuffer)abuffer[k3];
                if ((samples_in[k3] instanceof DoublePointer) && samples_in[k3].capacity() >= j4 && doublebuffer.hasArray())
                {
                    ((DoublePointer)samples_in[k3]).position(0).put(doublebuffer.array(), doublebuffer.position(), j4);
                } else
                {
                    samples_in[k3] = new DoublePointer(doublebuffer);
                }
                k3++;
            } while (true);
        } else
        {
            throw new Exception((new StringBuilder()).append("Audio samples Buffer has unsupported type: ").append(abuffer).toString());
        }
        if (samples_convert_ctx == null)
        {
            samples_convert_ctx = swresample.swr_alloc_set_opts(null, audio_c.channel_layout(), l3, audio_c.sample_rate(), audio_c.channel_layout(), i, audio_c.sample_rate(), 0, null);
            if (samples_convert_ctx == null)
            {
                throw new Exception("swr_alloc_set_opts() error: Cannot allocate the conversion context.");
            }
            i = swresample.swr_init(samples_convert_ctx);
            if (i < 0)
            {
                throw new Exception((new StringBuilder()).append("swr_init() error ").append(i).append(": Cannot initialize the conversion context.").toString());
            }
        }
        for (int j = 0; j < abuffer.length; j++)
        {
            samples_in[j].position(samples_in[j].position() * byte0).limit((samples_in[j].position() + j4) * byte0);
        }

_L4:
        do
        {
            if (samples_in[0].position() >= samples_in[0].limit())
            {
                break; /* Loop/switch isn't completed */
            }
            int l1 = Math.min((samples_in[0].limit() - samples_in[0].position()) / (i2 * byte0), (samples_out[0].limit() - samples_out[0].position()) / (j2 * i4));
            for (int k = 0; k < abuffer.length; k++)
            {
                samples_in_ptr.put(k, samples_in[k]);
            }

            for (int l = 0; l < samples_out.length; l++)
            {
                samples_out_ptr.put(l, samples_out[l]);
            }

            l1 = swresample.swr_convert(samples_convert_ctx, samples_out_ptr, l1, samples_in_ptr, l1);
            if (l1 < 0)
            {
                throw new Exception((new StringBuilder()).append("swr_convert() error ").append(l1).append(": Cannot convert audio samples.").toString());
            }
            for (int i1 = 0; i1 < abuffer.length; i1++)
            {
                samples_in[i1].position(samples_in[i1].position() + l1 * i2 * byte0);
            }

            for (int j1 = 0; j1 < samples_out.length; j1++)
            {
                samples_out[j1].position(samples_out[j1].position() + l1 * j2 * i4);
            }

        } while (samples_out[0].position() < samples_out[0].limit());
        frame.nb_samples(audio_input_frame_size);
        if (isVorbis)
        {
            frame.pts((audio_clock * 1000L) / (long)sampleRate);
        }
        if (frame != null)
        {
            audio_clock = audio_clock + (long)audio_input_frame_size;
        }
        avcodec.avcodec_fill_audio_frame(frame, audio_c.channels(), l3, samples_out[0], samples_out[0].limit(), 0);
        int k1 = 0;
        while (k1 < samples_out.length) 
        {
            frame.data(k1, samples_out[k1].position(0));
            frame.linesize(k1, samples_out[k1].limit());
            k1++;
        }
        if (true) goto _L2; else goto _L1
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        frame.quality(audio_c.global_quality());
        record(frame);
        if (true) goto _L4; else goto _L3
_L3:
        audioRecordTime = audioRecordTime + (System.currentTimeMillis() - l4);
        return frame.key_frame() != 0;
    }

    public void release()
    {
        if (SLog.sLogsOn && !isReleased)
        {
            if (videoScaleTime > 0L)
            {
                SLog.b("Video Scale: {}.", Long.valueOf(videoScaleTime));
            }
            if (videoEncodeTime > 0L)
            {
                SLog.b("Video Encode: {}.", Long.valueOf(videoEncodeTime));
            }
            if (videoWriteTime > 0L)
            {
                SLog.b("Video Write: {}.", Long.valueOf(videoWriteTime));
            }
            if (audioRecordTime > 0L)
            {
                SLog.b("Audio Record: {}.", Long.valueOf(audioRecordTime));
            }
        }
        isReleased = true;
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        if (video_c != null)
        {
            avcodec.avcodec_close(video_c);
            video_c = null;
        }
        if (audio_c != null)
        {
            avcodec.avcodec_close(audio_c);
            audio_c = null;
        }
        if (picture_buf != null)
        {
            avutil.av_free(picture_buf);
            picture_buf = null;
        }
        if (picture != null)
        {
            avcodec.avcodec_free_frame(picture);
            picture = null;
        }
        if (tmp_picture != null)
        {
            avcodec.avcodec_free_frame(tmp_picture);
            tmp_picture = null;
        }
        if (video_outbuf != null)
        {
            avutil.av_free(video_outbuf);
            video_outbuf = null;
        }
        if (frame != null)
        {
            avcodec.avcodec_free_frame(frame);
            frame = null;
        }
        if (samples_out == null)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        int i = 0;
_L2:
        if (i >= samples_out.length)
        {
            break; /* Loop/switch isn't completed */
        }
        avutil.av_free(samples_out[i].position(0));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        samples_out = null;
        int j;
        if (audio_outbuf != null)
        {
            avutil.av_free(audio_outbuf);
            audio_outbuf = null;
        }
        video_st = null;
        audio_st = null;
        if (oc == null)
        {
            break MISSING_BLOCK_LABEL_387;
        }
        j = oc.nb_streams();
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        avutil.av_free(oc.streams(i).codec());
        avutil.av_free(oc.streams(i));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        avutil.av_free(oc);
        oc = null;
        if (img_convert_ctx != null)
        {
            swscale.sws_freeContext(img_convert_ctx);
            img_convert_ctx = null;
        }
        if (samples_convert_ctx != null)
        {
            swresample.swr_free(samples_convert_ctx);
            samples_convert_ctx = null;
        }
        ai;
        JVM INSTR monitorexit ;
        return;
        java.lang.Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setAudioCodec(int i)
    {
        audioCodec = i;
    }

    public void setAudioCodecName(String s)
    {
        audioCodecName = s;
    }

    public void setFormat(String s)
    {
        format = s;
    }

    public void setFrameNumber(int i)
    {
        if (picture == null)
        {
            frameNumber = i;
            return;
        } else
        {
            picture.pts(i);
            return;
        }
    }

    public void setFrameRate(double d)
    {
        frameRate = d;
    }

    public void setSampleFormat(int i)
    {
        sampleFormat = i;
    }

    public void setSampleRate(int i)
    {
        sampleRate = i;
    }

    public void setTimestamp(long l)
    {
        if (picture != null)
        {
            setFrameNumber((int)Math.round(((double)l * getFrameRate()) / 1000000D));
        }
    }

    public int setTimestampAndGetFrameNumber(long l)
    {
        int i = (int)Math.round(((double)l * getFrameRate()) / 1000000D);
        setFrameNumber(i);
        return i;
    }

    public void setVideoCodec(int i)
    {
        videoCodec = i;
    }

    public void setVideoCodecName(String s)
    {
        videoCodecName = s;
    }

    public void start()
        throws Exception
    {
        String s;
        picture = null;
        tmp_picture = null;
        picture_buf = null;
        frame = null;
        video_outbuf = null;
        audio_outbuf = null;
        oc = null;
        video_c = null;
        audio_c = null;
        video_st = null;
        audio_st = null;
        got_video_packet = new int[1];
        got_audio_packet = new int[1];
        videoEncodeTime = 0L;
        videoWriteTime = 0L;
        videoScaleTime = 0L;
        audioRecordTime = 0L;
        Object obj;
        com.googlecode.javacv.cpp.avformat.AVOutputFormat avoutputformat;
        if (format == null || format.length() == 0)
        {
            obj = null;
        } else
        {
            obj = format;
        }
        avoutputformat = avformat.av_guess_format(((String) (obj)), filename, null);
        oformat = avoutputformat;
        if (avoutputformat == null)
        {
            int i = filename.indexOf("://");
            if (i > 0)
            {
                obj = filename.substring(0, i);
            }
            obj = avformat.av_guess_format(((String) (obj)), filename, null);
            oformat = ((com.googlecode.javacv.cpp.avformat.AVOutputFormat) (obj));
            if (obj == null)
            {
                throw new Exception((new StringBuilder()).append("av_guess_format() error: Could not guess output format for \"").append(filename).append("\" and ").append(format).append(" format.").toString());
            }
        }
        s = oformat.name().getString();
        obj = avformat.avformat_alloc_context();
        oc = ((com.googlecode.javacv.cpp.avformat.AVFormatContext) (obj));
        if (obj == null)
        {
            throw new Exception("avformat_alloc_context() error: Could not allocate format context");
        }
        oc.oformat(oformat);
        oc.filename().putString(filename);
        if (imageWidth <= 0 || imageHeight <= 0) goto _L2; else goto _L1
_L1:
        if (videoCodec == 0) goto _L4; else goto _L3
_L3:
        oformat.video_codec(videoCodec);
_L6:
        Object obj1;
        obj1 = avcodec.avcodec_find_encoder_by_name(videoCodecName);
        video_codec = ((com.googlecode.javacv.cpp.avcodec.AVCodec) (obj1));
        if (obj1 == null)
        {
            com.googlecode.javacv.cpp.avcodec.AVCodec avcodec1 = avcodec.avcodec_find_encoder(oformat.video_codec());
            video_codec = avcodec1;
            if (avcodec1 == null)
            {
                release();
                throw new Exception("avcodec_find_encoder() error: Video codec not found.");
            }
        }
        break; /* Loop/switch isn't completed */
_L4:
        if ("flv".equals(s))
        {
            oformat.video_codec(22);
        } else
        if ("mp4".equals(s))
        {
            oformat.video_codec(13);
        } else
        if ("3gp".equals(s))
        {
            oformat.video_codec(5);
        } else
        if ("avi".equals(s))
        {
            oformat.video_codec(26);
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (obj1 != null)
        {
            oformat.video_codec(video_codec.id());
        }
        Object obj2 = avutil.av_d2q(frameRate, 0xf4628);
        com.googlecode.javacv.cpp.avutil.AVRational avrational = video_codec.supported_framerates();
        obj1 = obj2;
        if (avrational != null)
        {
            obj1 = avrational.position(avutil.av_find_nearest_q_idx(((com.googlecode.javacv.cpp.avutil.AVRational) (obj2)), avrational));
        }
        obj2 = avformat.avformat_new_stream(oc, video_codec);
        video_st = ((com.googlecode.javacv.cpp.avformat.AVStream) (obj2));
        if (obj2 == null)
        {
            release();
            throw new Exception("avformat_new_stream() error: Could not allocate video stream.");
        }
        video_c = video_st.codec();
        video_c.codec_id(oformat.video_codec());
        video_c.codec_type(0);
        video_c.bit_rate(videoBitrate);
        video_c.width(((imageWidth + 15) / 16) * 16);
        video_c.height(imageHeight);
        video_c.time_base(avutil.av_inv_q(((com.googlecode.javacv.cpp.avutil.AVRational) (obj1))));
        video_c.gop_size(12);
        if (videoQuality >= 0.0D)
        {
            video_c.flags(video_c.flags() | 2);
            video_c.global_quality((int)Math.round(118D * videoQuality));
        }
        if (pixelFormat != -1)
        {
            video_c.pix_fmt(pixelFormat);
        } else
        if (video_c.codec_id() == 14 || video_c.codec_id() == 62 || video_c.codec_id() == 26 || video_c.codec_id() == 34)
        {
            video_c.pix_fmt(avutil.AV_PIX_FMT_RGB32);
        } else
        {
            video_c.pix_fmt(0);
        }
        if (video_c.codec_id() != 2) goto _L8; else goto _L7
_L7:
        video_c.max_b_frames(2);
_L32:
        if ((oformat.flags() & 0x40) != 0)
        {
            video_c.flags(video_c.flags() | 0x400000);
        }
        if ((video_codec.capabilities() & 0x200) != 0)
        {
            video_c.strict_std_compliance(-2);
        }
_L2:
        if (audioChannels <= 0 || audioBitrate <= 0 || sampleRate <= 0) goto _L10; else goto _L9
_L9:
        if (audioCodec == 0) goto _L12; else goto _L11
_L11:
        oformat.audio_codec(audioCodec);
_L14:
        obj1 = avcodec.avcodec_find_encoder_by_name(audioCodecName);
        audio_codec = ((com.googlecode.javacv.cpp.avcodec.AVCodec) (obj1));
        if (obj1 == null)
        {
            obj1 = avcodec.avcodec_find_encoder(oformat.audio_codec());
            audio_codec = ((com.googlecode.javacv.cpp.avcodec.AVCodec) (obj1));
            if (obj1 == null)
            {
                release();
                throw new Exception("avcodec_find_encoder() error: Audio codec not found.");
            }
        }
        break; /* Loop/switch isn't completed */
_L8:
        if (video_c.codec_id() == 1)
        {
            video_c.mb_decision(2);
        } else
        if (video_c.codec_id() == 5)
        {
            if (imageWidth <= 128 && imageHeight <= 96)
            {
                video_c.width(128).height(96);
            } else
            if (imageWidth <= 176 && imageHeight <= 144)
            {
                video_c.width(176).height(144);
            } else
            if (imageWidth <= 352 && imageHeight <= 288)
            {
                video_c.width(352).height(288);
            } else
            if (imageWidth <= 704 && imageHeight <= 576)
            {
                video_c.width(704).height(576);
            } else
            {
                video_c.width(1408).height(1152);
            }
        } else
        if (video_c.codec_id() == 28)
        {
            video_c.profile(578);
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if ("flv".equals(s) || "mp4".equals(s) || "3gp".equals(s))
        {
            oformat.audio_codec(0x15002);
        } else
        if ("avi".equals(s))
        {
            oformat.audio_codec(0x10000);
        }
        if (true) goto _L14; else goto _L13
_L13:
        obj1 = avformat.avformat_new_stream(oc, audio_codec);
        audio_st = ((com.googlecode.javacv.cpp.avformat.AVStream) (obj1));
        if (obj1 == null)
        {
            release();
            throw new Exception("avformat_new_stream() error: Could not allocate audio stream.");
        }
        isVorbis = "libvorbis".equals(audioCodecName);
        audio_c = audio_st.codec();
        audio_c.codec_id(oformat.audio_codec());
        audio_c.codec_type(1);
        audio_c.bit_rate(audioBitrate);
        audio_c.sample_rate(sampleRate);
        audio_c.channels(audioChannels);
        audio_c.channel_layout(avutil.av_get_default_channel_layout(audioChannels));
        if (sampleFormat != -1)
        {
            audio_c.sample_fmt(sampleFormat);
        } else
        if (isVorbis || audio_c.codec_id() == 0x15002 && (audio_codec.capabilities() & 0x200) != 0)
        {
            audio_c.sample_fmt(8);
        } else
        {
            audio_c.sample_fmt(1);
        }
        audio_c.time_base().num(1).den(sampleRate);
        audio_c.sample_fmt();
        JVM INSTR tableswitch 0 9: default 1516
    //                   0 1589
    //                   1 1830
    //                   2 1843
    //                   3 1856
    //                   4 1869
    //                   5 1589
    //                   6 1830
    //                   7 1843
    //                   8 1856
    //                   9 1869;
           goto _L15 _L16 _L17 _L18 _L19 _L20 _L16 _L17 _L18 _L19 _L20
_L15:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L16:
        audio_c.bits_per_raw_sample(8);
_L24:
        if (audioQuality >= 0.0D)
        {
            audio_c.flags(audio_c.flags() | 2);
            audio_c.global_quality((int)Math.round(118D * audioQuality));
        }
        if ((oformat.flags() & 0x40) != 0)
        {
            audio_c.flags(audio_c.flags() | 0x400000);
        }
        if ((audio_codec.capabilities() & 0x200) != 0)
        {
            audio_c.strict_std_compliance(-2);
        }
_L10:
        avformat.av_dump_format(oc, 0, filename, 1);
        if (video_st == null) goto _L22; else goto _L21
_L21:
        obj1 = new com.googlecode.javacv.cpp.avutil.AVDictionary(null);
        if (videoQuality >= 0.0D)
        {
            avutil.av_dict_set(((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)), "crf", (new StringBuilder()).append("").append(videoQuality).toString(), 0);
        }
        java.util.Map.Entry entry;
        for (Iterator iterator = videoOptions.entrySet().iterator(); iterator.hasNext(); avutil.av_dict_set(((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)), (String)entry.getKey(), (String)entry.getValue(), 0))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

          goto _L23
_L17:
        audio_c.bits_per_raw_sample(16);
          goto _L24
_L18:
        audio_c.bits_per_raw_sample(32);
          goto _L24
_L19:
        audio_c.bits_per_raw_sample(32);
          goto _L24
_L20:
        audio_c.bits_per_raw_sample(64);
          goto _L24
_L23:
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        int j = avcodec.avcodec_open2(video_c, video_codec, ((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)));
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_1951;
        }
        release();
        throw new Exception((new StringBuilder()).append("avcodec_open2() error ").append(j).append(": Could not open video codec.").toString());
        obj1;
        ai;
        JVM INSTR monitorexit ;
        throw obj1;
        ai;
        JVM INSTR monitorexit ;
        avutil.av_dict_free(((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)));
        video_outbuf = null;
        if ((oformat.flags() & 0x20) == 0)
        {
            video_outbuf_size = Math.max(0x40000, video_c.width() * 8 * video_c.height());
            video_outbuf = new BytePointer(avutil.av_malloc(video_outbuf_size));
        }
        obj1 = avcodec.avcodec_alloc_frame();
        picture = ((com.googlecode.javacv.cpp.avutil.AVFrame) (obj1));
        if (obj1 == null)
        {
            release();
            throw new Exception("avcodec_alloc_frame() error: Could not allocate picture.");
        }
        picture.pts(0L);
        obj1 = new BytePointer(avutil.av_malloc(avcodec.avpicture_get_size(video_c.pix_fmt(), video_c.width(), video_c.height())));
        picture_buf = ((BytePointer) (obj1));
        if (((BytePointer) (obj1)).isNull())
        {
            release();
            throw new Exception("av_malloc() error: Could not allocate picture buffer.");
        }
        obj1 = avcodec.avcodec_alloc_frame();
        tmp_picture = ((com.googlecode.javacv.cpp.avutil.AVFrame) (obj1));
        if (obj1 == null)
        {
            release();
            throw new Exception("avcodec_alloc_frame() error: Could not allocate temporary picture.");
        }
_L22:
        if (audio_st == null) goto _L26; else goto _L25
_L25:
        obj1 = new com.googlecode.javacv.cpp.avutil.AVDictionary(null);
        if (audioQuality >= 0.0D)
        {
            avutil.av_dict_set(((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)), "crf", (new StringBuilder()).append("").append(audioQuality).toString(), 0);
        }
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = audioOptions.entrySet().iterator(); iterator1.hasNext(); avutil.av_dict_set(((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)), (String)entry1.getKey(), (String)entry1.getValue(), 0))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        iterator1 = LOCK;
        iterator1;
        JVM INSTR monitorenter ;
        j = avcodec.avcodec_open2(audio_c, audio_codec, ((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)));
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_2335;
        }
        release();
        throw new Exception((new StringBuilder()).append("avcodec_open2() error ").append(j).append(": Could not open audio codec.").toString());
        obj1;
        iterator1;
        JVM INSTR monitorexit ;
        throw obj1;
        iterator1;
        JVM INSTR monitorexit ;
        avutil.av_dict_free(((com.googlecode.javacv.cpp.avutil.AVDictionary) (obj1)));
        audio_outbuf_size = 0x40000;
        audio_outbuf = new BytePointer(avutil.av_malloc(audio_outbuf_size));
        if (audio_c.frame_size() > 1) goto _L28; else goto _L27
_L27:
        audio_outbuf_size = 16384;
        audio_input_frame_size = audio_outbuf_size / audio_c.channels();
        audio_c.codec_id();
        JVM INSTR tableswitch 65536 65539: default 2440
    //                   65536 2549
    //                   65537 2549
    //                   65538 2549
    //                   65539 2549;
           goto _L29 _L30 _L30 _L30 _L30
_L30:
        audio_input_frame_size = audio_input_frame_size >> 1;
          goto _L29
_L28:
        audio_input_frame_size = audio_c.frame_size();
_L29:
        int k;
        int i1;
        if (avutil.av_sample_fmt_is_planar(audio_c.sample_fmt()) != 0)
        {
            k = audio_c.channels();
        } else
        {
            k = 1;
        }
        i1 = avutil.av_samples_get_buffer_size((IntPointer)null, audio_c.channels(), audio_input_frame_size, audio_c.sample_fmt(), 1) / k;
        samples_out = new BytePointer[k];
        for (k = 0; k < samples_out.length; k++)
        {
            samples_out[k] = (new BytePointer(avutil.av_malloc(i1))).capacity(i1);
        }

        samples_in = new Pointer[8];
        samples_in_ptr = new PointerPointer(8);
        samples_out_ptr = new PointerPointer(8);
        com.googlecode.javacv.cpp.avutil.AVFrame avframe = avcodec.avcodec_alloc_frame();
        frame = avframe;
        if (avframe == null)
        {
            release();
            throw new Exception("avcodec_alloc_frame() error: Could not allocate audio frame.");
        }
_L26:
        SystemUtil.quietlyEnsureParentExists(new File(filename));
        if ((oformat.flags() & 1) == 0)
        {
            com.googlecode.javacv.cpp.avformat.AVIOContext aviocontext = new com.googlecode.javacv.cpp.avformat.AVIOContext(null);
            int l = avformat.avio_open(aviocontext, filename, 2);
            if (l < 0)
            {
                release();
                throw new Exception((new StringBuilder()).append("BAD avio_open error() error ").append(l).append(": Could not open '").append(filename).toString());
            }
            oc.pb(aviocontext);
        }
        avformat.avformat_write_header(oc, (PointerPointer)null);
        return;
        if (true) goto _L32; else goto _L31
_L31:
    }

    public void stop()
        throws Exception
    {
        if (oc != null)
        {
            while (video_st != null && record(null, -1, false)) ;
            while (audio_st != null && record((com.googlecode.javacv.cpp.avutil.AVFrame)null)) ;
            if (interleaved && video_st != null && audio_st != null)
            {
                avformat.av_interleaved_write_frame(oc, null);
            } else
            {
                avformat.av_write_frame(oc, null);
            }
            oc.duration((audio_clock * 1000L) / (long)sampleRate);
            avformat.av_write_trailer(oc);
            if ((oformat.flags() & 1) == 0)
            {
                avformat.avio_close(oc.pb());
            }
        }
        release();
    }

    public void stopEncoding()
        throws Exception
    {
        if (oc != null && (oformat.flags() & 1) == 0)
        {
            avformat.avio_close(oc.pb());
        }
        release();
    }

    public void writeEncodedImage(byte abyte0[], int i, int j, boolean flag)
        throws Exception
    {
        hasData = true;
        avcodec.av_init_packet(video_pkt);
        video_pkt.data(video_outbuf);
        BytePointer bytepointer = video_pkt.data();
        bytepointer.position(0);
        bytepointer.put(abyte0, i, j);
        bytepointer.limit(j);
        video_pkt.size(j);
        video_pkt.pts(picture.pts());
        video_pkt.dts(video_pkt.pts());
        picture.pts(picture.pts() + 1L);
        if (video_pkt.pts() != avutil.AV_NOPTS_VALUE)
        {
            video_pkt.pts(avutil.av_rescale_q(video_pkt.pts(), video_c.time_base(), video_st.time_base()));
        }
        if (video_pkt.dts() != avutil.AV_NOPTS_VALUE)
        {
            video_pkt.dts(avutil.av_rescale_q(video_pkt.dts(), video_c.time_base(), video_st.time_base()));
        }
        video_pkt.stream_index(video_st.index());
        if (flag)
        {
            video_pkt.flags(video_pkt.flags() | 1);
        }
        writeVideoFrame();
    }

    static 
    {
        boolean flag;
        if (!co/vine/android/recorder/SwVineFrameRecorder.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        LOCK = new int[0];
        loadingException = null;
        hasEverSuccessfullyLoaded = false;
        synchronized (LOCK)
        {
            avcodec.avcodec_register_all();
            avformat.av_register_all();
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
