// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacv.Frame;
import com.googlecode.javacv.cpp.avcodec;
import com.googlecode.javacv.cpp.avformat;
import com.googlecode.javacv.cpp.avutil;
import com.googlecode.javacv.cpp.swscale;
import java.nio.Buffer;
import java.nio.ByteBuffer;

// Referenced classes of package co.vine.android.recorder:
//            SwVineFrameRecorder

public class VineFrameGrabber
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

    public static final class ImageMode extends Enum
    {

        private static final ImageMode $VALUES[];
        public static final ImageMode COLOR;
        public static final ImageMode GRAY;
        public static final ImageMode RAW;

        public static ImageMode valueOf(String s)
        {
            return (ImageMode)Enum.valueOf(co/vine/android/recorder/VineFrameGrabber$ImageMode, s);
        }

        public static ImageMode[] values()
        {
            return (ImageMode[])$VALUES.clone();
        }

        static 
        {
            COLOR = new ImageMode("COLOR", 0);
            GRAY = new ImageMode("GRAY", 1);
            RAW = new ImageMode("RAW", 2);
            $VALUES = (new ImageMode[] {
                COLOR, GRAY, RAW
            });
        }

        private ImageMode(String s, int i)
        {
            super(s, i);
        }
    }


    static final boolean $assertionsDisabled;
    protected int audioChannels;
    private com.googlecode.javacv.cpp.avcodec.AVCodecContext audio_c;
    private com.googlecode.javacv.cpp.avformat.AVStream audio_st;
    private BytePointer buffer_rgb;
    protected boolean deinterlace;
    private String filename;
    protected String format;
    private Frame frame;
    private boolean frameGrabbed;
    protected int frameNumber;
    protected double frameRate;
    protected double gamma;
    private int got_frame[];
    protected int imageHeight;
    protected ImageMode imageMode;
    protected int imageWidth;
    private com.googlecode.javacv.cpp.swscale.SwsContext img_convert_ctx;
    protected int numBuffers;
    private com.googlecode.javacv.cpp.avformat.AVFormatContext oc;
    private com.googlecode.javacv.cpp.avutil.AVFrame picture;
    private com.googlecode.javacv.cpp.avutil.AVFrame picture_rgb;
    protected int pixelFormat;
    private com.googlecode.javacv.cpp.avcodec.AVPacket pkt;
    private com.googlecode.javacv.cpp.avcodec.AVPacket pkt2;
    private com.googlecode.javacv.cpp.opencv_core.IplImage return_image;
    protected int sampleFormat;
    protected int sampleRate;
    private Buffer samples_buf[];
    private com.googlecode.javacv.cpp.avutil.AVFrame samples_frame;
    private BytePointer samples_ptr[];
    private int sizeof_pkt;
    protected long timestamp;
    private com.googlecode.javacv.cpp.avcodec.AVCodecContext video_c;
    private com.googlecode.javacv.cpp.avformat.AVStream video_st;

    public VineFrameGrabber(String s)
    {
        format = null;
        imageWidth = 0;
        imageHeight = 0;
        audioChannels = 0;
        imageMode = ImageMode.COLOR;
        pixelFormat = -1;
        frameRate = 0.0D;
        sampleFormat = 0;
        sampleRate = 0;
        numBuffers = 4;
        gamma = 0.0D;
        deinterlace = false;
        frameNumber = 0;
        timestamp = 0L;
        filename = s;
    }

    private Frame grabFrame(boolean flag, boolean flag1)
        throws Exception
    {
        boolean flag2;
        frame.image = null;
        frame.samples = null;
        if (frameGrabbed)
        {
            frameGrabbed = false;
            if (flag)
            {
                processImage();
            }
            frame.image = return_image;
            return frame;
        }
        if (oc == null || oc.isNull())
        {
            throw new Exception("Could not grab: No AVFormatContext. (Has start() been called?)");
        }
        flag2 = false;
_L23:
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_910;
        }
        if (pkt2.size() > 0 || avformat.av_read_frame(oc, pkt) >= 0) goto _L2; else goto _L1
_L1:
        if (video_st == null) goto _L4; else goto _L3
_L3:
        pkt.stream_index(video_st.index());
        pkt.data(null);
        pkt.size(0);
_L2:
        if (video_st == null || pkt.stream_index() != video_st.index()) goto _L6; else goto _L5
_L5:
        if (avcodec.avcodec_decode_video2(video_c, picture, got_frame, pkt) < 0 || got_frame[0] == 0) goto _L8; else goto _L7
_L7:
        int i;
        long l1 = avutil.av_frame_get_best_effort_timestamp(picture);
        com.googlecode.javacv.cpp.avutil.AVRational avrational = video_st.time_base();
        timestamp = (0xf4240L * l1 * (long)avrational.num()) / (long)avrational.den();
        frameNumber = (int)(((double)timestamp * getFrameRate()) / 1000000D);
        if (flag)
        {
            processImage();
        }
        i = 1;
        frame.image = return_image;
_L10:
        flag2 = i;
        if (pkt2.size() <= 0)
        {
            avcodec.av_free_packet(pkt);
            flag2 = i;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        return null;
_L8:
        i = ((flag2) ? 1 : 0);
        if (pkt.data() == null)
        {
            i = ((flag2) ? 1 : 0);
            if (pkt.size() == 0)
            {
                return null;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        i = ((flag2) ? 1 : 0);
        if (!flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag2) ? 1 : 0);
        if (audio_st == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag2) ? 1 : 0);
        if (pkt.stream_index() != audio_st.index())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (pkt2.size() <= 0)
        {
            BytePointer.memcpy(pkt2, pkt, sizeof_pkt);
        }
        avcodec.avcodec_get_frame_defaults(samples_frame);
        i = avcodec.avcodec_decode_audio4(audio_c, samples_frame, got_frame, pkt2);
        if (i > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        pkt2.size(0);
        i = ((flag2) ? 1 : 0);
        if (true) goto _L10; else goto _L9
_L9:
        pkt2.data(pkt2.data().position(i));
        pkt2.size(pkt2.size() - i);
        i = ((flag2) ? 1 : 0);
        if (got_frame[0] == 0) goto _L10; else goto _L11
_L11:
        Object obj;
        int k;
        int j1;
        long l2 = avutil.av_frame_get_best_effort_timestamp(samples_frame);
        obj = audio_st.time_base();
        timestamp = (0xf4240L * l2 * (long)((com.googlecode.javacv.cpp.avutil.AVRational) (obj)).num()) / (long)((com.googlecode.javacv.cpp.avutil.AVRational) (obj)).den();
        boolean flag3 = true;
        int l = samples_frame.format();
        int j;
        int i1;
        if (avutil.av_sample_fmt_is_planar(l) != 0)
        {
            j = samples_frame.channels();
        } else
        {
            j = 1;
        }
        i1 = avutil.av_samples_get_buffer_size((IntPointer)null, audio_c.channels(), samples_frame.nb_samples(), audio_c.sample_fmt(), 1) / j;
        if (samples_buf == null || samples_buf.length != j)
        {
            samples_ptr = new BytePointer[j];
            samples_buf = new Buffer[j];
        }
        frame.samples = samples_buf;
        j1 = i1 / avutil.av_get_bytes_per_sample(l);
        k = 0;
_L21:
        i = ((flag3) ? 1 : 0);
        if (k >= j) goto _L10; else goto _L12
_L12:
        obj = samples_frame.data(k);
        if (((BytePointer) (obj)).equals(samples_ptr[k]) && samples_ptr[k].capacity() >= i1) goto _L14; else goto _L13
_L13:
        samples_ptr[k] = ((BytePointer) (obj)).capacity(i1);
        obj = ((BytePointer) (obj)).asBuffer();
        l;
        JVM INSTR tableswitch 0 9: default 800
    //                   0 820
    //                   1 854
    //                   2 868
    //                   3 882
    //                   4 896
    //                   5 820
    //                   6 854
    //                   7 868
    //                   8 882
    //                   9 896;
           goto _L15 _L16 _L17 _L18 _L19 _L20 _L16 _L17 _L18 _L19 _L20
_L20:
        break MISSING_BLOCK_LABEL_896;
_L15:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L16:
        samples_buf[k] = ((Buffer) (obj));
_L14:
        samples_buf[k].position(0).limit(j1);
        k++;
          goto _L21
_L17:
        samples_buf[k] = ((ByteBuffer) (obj)).asShortBuffer();
          goto _L14
_L18:
        samples_buf[k] = ((ByteBuffer) (obj)).asIntBuffer();
          goto _L14
_L19:
        samples_buf[k] = ((ByteBuffer) (obj)).asFloatBuffer();
          goto _L14
        samples_buf[k] = ((ByteBuffer) (obj)).asDoubleBuffer();
          goto _L14
        return frame;
        if (true) goto _L23; else goto _L22
_L22:
    }

    private void processImage()
        throws Exception
    {
        static class _cls1
        {

            static final int $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[];

            static 
            {
                $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode = new int[ImageMode.values().length];
                try
                {
                    $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[ImageMode.COLOR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[ImageMode.GRAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$co$vine$android$recorder$VineFrameGrabber$ImageMode[ImageMode.RAW.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.co.vine.android.recorder.VineFrameGrabber.ImageMode[imageMode.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 50
    //                   2 50
    //                   3 292;
           goto _L1 _L2 _L2 _L3
_L1:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (deinterlace)
        {
            com.googlecode.javacv.cpp.avcodec.AVPicture avpicture = new com.googlecode.javacv.cpp.avcodec.AVPicture(picture);
            avcodec.avpicture_deinterlace(avpicture, avpicture, video_c.pix_fmt(), video_c.width(), video_c.height());
        }
        img_convert_ctx = swscale.sws_getCachedContext(img_convert_ctx, video_c.width(), video_c.height(), video_c.pix_fmt(), getImageWidth(), getImageHeight(), getPixelFormat(), 2, null, null, (DoublePointer)null);
        if (img_convert_ctx == null)
        {
            throw new Exception("sws_getCachedContext() error: Cannot initialize the conversion context.");
        }
        swscale.sws_scale(img_convert_ctx, new PointerPointer(picture), picture.linesize(), 0, video_c.height(), new PointerPointer(picture_rgb), picture_rgb.linesize());
        return_image.imageData(buffer_rgb);
        return_image.widthStep(picture_rgb.linesize(0));
_L5:
        return_image.imageSize(return_image.height() * return_image.widthStep());
        return_image.nChannels(return_image.widthStep() / return_image.width());
        return;
_L3:
        if (!$assertionsDisabled && (video_c.width() != return_image.width() || video_c.height() != return_image.height()))
        {
            throw new AssertionError();
        }
        return_image.imageData(picture.data(0));
        return_image.widthStep(picture.linesize(0));
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        release();
    }

    public int getAudioChannels()
    {
        if (audio_c == null)
        {
            return audioChannels;
        } else
        {
            return audio_c.channels();
        }
    }

    public String getFormat()
    {
        if (oc == null)
        {
            return format;
        } else
        {
            return oc.iformat().name().getString();
        }
    }

    public double getFrameRate()
    {
        if (video_st == null)
        {
            return frameRate;
        } else
        {
            com.googlecode.javacv.cpp.avutil.AVRational avrational = video_st.r_frame_rate();
            return (double)avrational.num() / (double)avrational.den();
        }
    }

    public double getGamma()
    {
        if (gamma == 0.0D)
        {
            return 2.2000000000000002D;
        } else
        {
            return gamma;
        }
    }

    public int getImageHeight()
    {
        if (return_image == null)
        {
            return imageHeight;
        } else
        {
            return return_image.height();
        }
    }

    public int getImageWidth()
    {
        if (return_image == null)
        {
            return imageWidth;
        } else
        {
            return return_image.width();
        }
    }

    public int getLengthInFrames()
    {
        return (int)(((double)getLengthInTime() * getFrameRate()) / 1000000D);
    }

    public long getLengthInTime()
    {
        return (oc.duration() * 0xf4240L) / 0xf4240L;
    }

    public int getPixelFormat()
    {
        if (imageMode == ImageMode.COLOR || imageMode == ImageMode.GRAY)
        {
            if (pixelFormat == -1)
            {
                return imageMode != ImageMode.COLOR ? 8 : 3;
            } else
            {
                return pixelFormat;
            }
        }
        if (video_c != null)
        {
            return video_c.pix_fmt();
        } else
        {
            return pixelFormat;
        }
    }

    public int getSampleFormat()
    {
        if (audio_c == null)
        {
            return sampleFormat;
        } else
        {
            return audio_c.sample_fmt();
        }
    }

    public int getSampleRate()
    {
        if (audio_c == null)
        {
            return sampleRate;
        } else
        {
            return audio_c.sample_rate();
        }
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public com.googlecode.javacv.cpp.avcodec.AVCodecContext getVideoCodecContext()
    {
        return video_c;
    }

    public com.googlecode.javacv.cpp.opencv_core.IplImage grab()
        throws Exception
    {
        Frame frame1 = grabFrame(true, false);
        if (frame1 != null)
        {
            return frame1.image;
        } else
        {
            return null;
        }
    }

    public com.googlecode.javacv.cpp.opencv_core.IplImage grab(boolean flag)
        throws Exception
    {
        Frame frame1 = grabFrame(flag, false);
        if (frame1 != null)
        {
            return frame1.image;
        } else
        {
            return null;
        }
    }

    public Frame grabFrame()
        throws Exception
    {
        return grabFrame(true, true);
    }

    public void release()
    {
        if (pkt != null && pkt2 != null)
        {
            if (pkt2.size() > 0)
            {
                avcodec.av_free_packet(pkt);
            }
            pkt2 = null;
            pkt = null;
        }
        if (buffer_rgb != null)
        {
            avutil.av_free(buffer_rgb);
            buffer_rgb = null;
        }
        if (picture_rgb != null)
        {
            avcodec.avcodec_free_frame(picture_rgb);
            picture_rgb = null;
        }
        if (picture != null)
        {
            avcodec.avcodec_free_frame(picture);
            picture = null;
        }
        if (video_c != null)
        {
            avcodec.avcodec_close(video_c);
            video_c = null;
        }
        if (samples_frame != null)
        {
            avcodec.avcodec_free_frame(samples_frame);
            samples_frame = null;
        }
        if (audio_c != null)
        {
            avcodec.avcodec_close(audio_c);
            audio_c = null;
        }
        if (oc != null && !oc.isNull())
        {
            avformat.avformat_close_input(oc);
            oc = null;
        }
        if (img_convert_ctx != null)
        {
            swscale.sws_freeContext(img_convert_ctx);
            img_convert_ctx = null;
        }
        got_frame = null;
        return_image = null;
        frameGrabbed = false;
        frame = null;
        timestamp = 0L;
        frameNumber = 0;
    }

    public void setFormat(String s)
    {
        format = s;
    }

    public void setFrameNumber(int i)
        throws Exception
    {
        setTimestamp(Math.round((double)(0xf4240L * (long)i) / getFrameRate()));
    }

    public void setFrameRate(double d)
    {
        frameRate = d;
    }

    public void setTimestamp(long l)
        throws Exception
    {
        if (oc == null || video_c == null)
        {
            timestamp = l;
            return;
        }
        long l1 = (l * 0xf4240L) / 0xf4240L;
        l = l1;
        if (oc.start_time() != avutil.AV_NOPTS_VALUE)
        {
            l = l1 + oc.start_time();
        }
        int i = avformat.avformat_seek_file(oc, -1, 0x8000000000000000L, l, 0x7fffffffffffffffL, 1);
        if (i < 0)
        {
            throw new Exception((new StringBuilder()).append("avformat_seek_file() error ").append(i).append(": Could not seek file to timestamp ").append(l).append(".").toString());
        }
        avcodec.avcodec_flush_buffers(video_c);
        if (audio_c != null)
        {
            avcodec.avcodec_flush_buffers(audio_c);
        }
        while (timestamp > l && grab(false) != null) ;
        while (timestamp < l && grab(false) != null) ;
        frameGrabbed = true;
    }

    public void start()
        throws Exception
    {
        img_convert_ctx = null;
        oc = new com.googlecode.javacv.cpp.avformat.AVFormatContext(null);
        video_c = null;
        audio_c = null;
        pkt = new com.googlecode.javacv.cpp.avcodec.AVPacket();
        pkt2 = new com.googlecode.javacv.cpp.avcodec.AVPacket();
        sizeof_pkt = pkt.sizeof();
        got_frame = new int[1];
        return_image = null;
        frameGrabbed = false;
        frame = new Frame();
        timestamp = 0L;
        frameNumber = 0;
        pkt2.size(0);
        Object obj2 = null;
        com.googlecode.javacv.cpp.avformat.AVInputFormat avinputformat = obj2;
        if (format != null)
        {
            avinputformat = obj2;
            if (format.length() > 0)
            {
                com.googlecode.javacv.cpp.avformat.AVInputFormat avinputformat1 = avformat.av_find_input_format(format);
                avinputformat = avinputformat1;
                if (avinputformat1 == null)
                {
                    throw new Exception((new StringBuilder()).append("av_find_input_format() error: Could not find input format \"").append(format).append("\".").toString());
                }
            }
        }
        com.googlecode.javacv.cpp.avutil.AVDictionary avdictionary = new com.googlecode.javacv.cpp.avutil.AVDictionary(null);
        if (frameRate > 0.0D)
        {
            com.googlecode.javacv.cpp.avutil.AVRational avrational = avutil.av_d2q(frameRate, 0xf4628);
            avutil.av_dict_set(avdictionary, "framerate", (new StringBuilder()).append(avrational.num()).append("/").append(avrational.den()).toString(), 0);
        }
        if (imageMode != ImageMode.RAW)
        {
            String s;
            int i;
            if (imageMode == ImageMode.COLOR)
            {
                s = "bgr24";
            } else
            {
                s = "gray8";
            }
            avutil.av_dict_set(avdictionary, "pixel_format", s, 0);
        }
        if (imageWidth > 0 && imageHeight > 0)
        {
            avutil.av_dict_set(avdictionary, "video_size", (new StringBuilder()).append(imageWidth).append("x").append(imageHeight).toString(), 0);
        }
        if (sampleRate > 0)
        {
            avutil.av_dict_set(avdictionary, "sample_rate", (new StringBuilder()).append("").append(sampleRate).toString(), 0);
        }
        if (audioChannels > 0)
        {
            avutil.av_dict_set(avdictionary, "channels", (new StringBuilder()).append("").append(audioChannels).toString(), 0);
        }
        i = avformat.avformat_open_input(oc, filename, avinputformat, avdictionary);
        if (i < 0)
        {
            throw new Exception((new StringBuilder()).append("avformat_open_input() error ").append(i).append(": Could not open input \"").append(filename).append("\". (Has setFormat() been called?)").toString());
        }
        avutil.av_dict_free(avdictionary);
        int j = avformat.avformat_find_stream_info(oc, (PointerPointer)null);
        if (j < 0)
        {
            throw new Exception((new StringBuilder()).append("avformat_find_stream_info() error ").append(j).append(": Could not find stream information.").toString());
        }
        avformat.av_dump_format(oc, 0, filename, 0);
        audio_st = null;
        video_st = null;
        int i1 = oc.nb_streams();
        j = 0;
        while (j < i1) 
        {
            com.googlecode.javacv.cpp.avformat.AVStream avstream = oc.streams(j);
            com.googlecode.javacv.cpp.avcodec.AVCodecContext avcodeccontext = avstream.codec();
            if (video_st == null && avcodeccontext.codec_type() == 0)
            {
                video_st = avstream;
                video_c = avcodeccontext;
            } else
            if (audio_st == null && avcodeccontext.codec_type() == 1)
            {
                audio_st = avstream;
                audio_c = avcodeccontext;
            }
            j++;
        }
        if (video_st == null && audio_st == null)
        {
            throw new Exception((new StringBuilder()).append("Did not find a video or audio stream inside \"").append(filename).append("\".").toString());
        }
        if (video_st == null) goto _L2; else goto _L1
_L1:
        int k;
        int j1;
        Object obj = avcodec.avcodec_find_decoder(video_c.codec_id());
        if (obj == null)
        {
            throw new Exception((new StringBuilder()).append("avcodec_find_decoder() error: Unsupported video format or codec not found: ").append(video_c.codec_id()).append(".").toString());
        }
        k = avcodec.avcodec_open2(video_c, ((com.googlecode.javacv.cpp.avcodec.AVCodec) (obj)), (PointerPointer)null);
        if (k < 0)
        {
            throw new Exception((new StringBuilder()).append("avcodec_open2() error ").append(k).append(": Could not open video codec.").toString());
        }
        if (video_c.time_base().num() > 1000 && video_c.time_base().den() == 1)
        {
            video_c.time_base().den(1000);
        }
        obj = avcodec.avcodec_alloc_frame();
        picture = ((com.googlecode.javacv.cpp.avutil.AVFrame) (obj));
        if (obj == null)
        {
            throw new Exception("avcodec_alloc_frame() error: Could not allocate raw picture frame.");
        }
        obj = avcodec.avcodec_alloc_frame();
        picture_rgb = ((com.googlecode.javacv.cpp.avutil.AVFrame) (obj));
        if (obj == null)
        {
            throw new Exception("avcodec_alloc_frame() error: Could not allocate RGB picture frame.");
        }
        if (getImageWidth() > 0)
        {
            k = getImageWidth();
        } else
        {
            k = video_c.width();
        }
        if (getImageHeight() > 0)
        {
            j1 = getImageHeight();
        } else
        {
            j1 = video_c.height();
        }
        _cls1..SwitchMap.co.vine.android.recorder.VineFrameGrabber.ImageMode[imageMode.ordinal()];
        JVM INSTR tableswitch 1 3: default 988
    //                   1 1026
    //                   2 1026
    //                   3 1157;
           goto _L3 _L4 _L4 _L5
_L3:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L4:
        int k1 = getPixelFormat();
        buffer_rgb = new BytePointer(avutil.av_malloc(avcodec.avpicture_get_size(k1, k, j1)));
        avcodec.avpicture_fill(new com.googlecode.javacv.cpp.avcodec.AVPicture(picture_rgb), buffer_rgb, k1, k, j1);
        return_image = com.googlecode.javacv.cpp.opencv_core.IplImage.createHeader(k, j1, 8, 1);
_L2:
        Object obj1;
        if (audio_st == null)
        {
            break MISSING_BLOCK_LABEL_1267;
        }
        obj1 = avcodec.avcodec_find_decoder(audio_c.codec_id());
        if (obj1 == null)
        {
            throw new Exception((new StringBuilder()).append("avcodec_find_decoder() error: Unsupported audio format or codec not found: ").append(audio_c.codec_id()).append(".").toString());
        }
        break; /* Loop/switch isn't completed */
_L5:
        buffer_rgb = null;
        return_image = com.googlecode.javacv.cpp.opencv_core.IplImage.createHeader(video_c.width(), video_c.height(), 8, 1);
        if (true) goto _L2; else goto _L6
_L6:
        int l = avcodec.avcodec_open2(audio_c, ((com.googlecode.javacv.cpp.avcodec.AVCodec) (obj1)), (PointerPointer)null);
        if (l < 0)
        {
            throw new Exception((new StringBuilder()).append("avcodec_open2() error ").append(l).append(": Could not open audio codec.").toString());
        }
        obj1 = avcodec.avcodec_alloc_frame();
        samples_frame = ((com.googlecode.javacv.cpp.avutil.AVFrame) (obj1));
        if (obj1 == null)
        {
            throw new Exception("avcodec_alloc_frame() error: Could not allocate audio frame.");
        }
    }

    public void stop()
        throws Exception
    {
        release();
    }

    public void trigger()
        throws Exception
    {
        if (oc == null || oc.isNull())
        {
            throw new Exception("Could not trigger: No AVFormatContext. (Has start() been called?)");
        }
        if (pkt2.size() > 0)
        {
            pkt2.size(0);
            avcodec.av_free_packet(pkt);
        }
        int i = 0;
        do
        {
            if (i >= numBuffers + 1 || avformat.av_read_frame(oc, pkt) < 0)
            {
                return;
            }
            avcodec.av_free_packet(pkt);
            i++;
        } while (true);
    }

    static 
    {
        boolean flag;
        if (!co/vine/android/recorder/VineFrameGrabber.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        synchronized (SwVineFrameRecorder.LOCK)
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
