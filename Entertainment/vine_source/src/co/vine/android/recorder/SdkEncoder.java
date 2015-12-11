// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import com.edisonwang.android.slog.FormattingTuple;
import com.edisonwang.android.slog.MessageFormatter;
import com.edisonwang.android.slog.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.recorder:
//            RecordConfigUtils

public class SdkEncoder
    implements EncoderManager.Encoder
{

    public SdkEncoder()
    {
        SLog.d("*****************************");
        int k = MediaCodecList.getCodecCount();
        for (int i = 0; i < k; i++)
        {
            MediaCodecInfo mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
            SLog.d("Codec: {}.", mediacodecinfo.getName());
            String as[] = mediacodecinfo.getSupportedTypes();
            int l = as.length;
            for (int j = 0; j < l; j++)
            {
                String s = as[j];
                android.media.MediaCodecInfo.CodecCapabilities codeccapabilities = mediacodecinfo.getCapabilitiesForType(s);
                SLog.d("Codec support {} with {} and {}.", s, codeccapabilities.colorFormats, codeccapabilities.profileLevels);
            }

        }

        SLog.d("*****************************");
    }

    public void transcode(EncoderManager.EncoderBoss encoderboss, String s, String s1, ArrayList arraylist)
        throws EncoderManager.EncodingException
    {
        BufferedOutputStream bufferedoutputstream;
        MediaCodec mediacodec;
        MediaExtractor mediaextractor;
        int i;
        MediaFormat mediaformat;
        try
        {
            bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(new File(s1)));
            mediacodec = MediaCodec.createEncoderByType("video/avc");
            mediaextractor = new MediaExtractor();
            mediaextractor.setDataSource(s);
        }
        // Misplaced declaration of an exception variable
        catch (EncoderManager.EncoderBoss encoderboss)
        {
            throw new EncoderManager.EncodingException(encoderboss);
        }
        s1 = null;
        arraylist = null;
        i = 0;
_L5:
        s = s1;
        encoderboss = arraylist;
        if (i >= mediaextractor.getTrackCount()) goto _L2; else goto _L1
_L1:
        mediaformat = mediaextractor.getTrackFormat(i);
        s = mediaformat.getString("mime");
        if (!s.startsWith("video/")) goto _L4; else goto _L3
_L3:
        mediaextractor.selectTrack(i);
        encoderboss = MediaFormat.createVideoFormat("video/avc", 480, 480);
        encoderboss.setInteger("bitrate", RecordConfigUtils.VIDEO_BIT_RATE);
        encoderboss.setInteger("frame-rate", 30);
        encoderboss.setInteger("color-format", 21);
        encoderboss.setInteger("i-frame-interval", 5);
        s = MediaCodec.createDecoderByType(s);
        mediaformat.setInteger("color-format", 19);
        s.configure(mediaformat, null, null, 0);
          goto _L2
_L28:
        throw new IOException(MessageFormatter.format("Invalid file: {}, {}.", s, encoderboss).getMessage());
_L4:
        i++;
          goto _L5
_L29:
        ByteBuffer abytebuffer[];
        ByteBuffer abytebuffer1[];
        android.media.MediaCodec.BufferInfo bufferinfo;
        mediacodec.configure(encoderboss, null, null, 1);
        mediacodec.start();
        s.start();
        abytebuffer = s.getInputBuffers();
        s1 = s.getOutputBuffers();
        abytebuffer1 = mediacodec.getInputBuffers();
        encoderboss = mediacodec.getOutputBuffers();
        bufferinfo = new android.media.MediaCodec.BufferInfo();
        int j = 0;
_L24:
        if (Thread.interrupted()) goto _L7; else goto _L6
_L6:
        i = j;
        if (j != 0) goto _L9; else goto _L8
_L8:
        int k = s.dequeueInputBuffer(-1L);
        i = j;
        if (k < 0) goto _L9; else goto _L10
_L10:
        i = mediaextractor.readSampleData(abytebuffer[k], 0);
        if (i >= 0) goto _L12; else goto _L11
_L11:
        SLog.d("InputBuffer BUFFER_FLAG_END_OF_STREAM");
        s.queueInputBuffer(k, 0, 0, 0L, 4);
        i = 1;
_L9:
        j = s.dequeueOutputBuffer(bufferinfo, -1L);
        j;
        JVM INSTR tableswitch -3 -1: default 802
    //                   -3 691
    //                   -2 705
    //                   -1 718;
           goto _L13 _L14 _L15 _L16
_L13:
        arraylist = s1[j];
        SLog.d((new StringBuilder()).append("We can't use this buffer but render it due to the API limit, ").append(arraylist).toString());
        k = mediacodec.dequeueInputBuffer(-1L);
        if (k < 0) goto _L18; else goto _L17
_L17:
        Object obj = abytebuffer1[k];
        ((ByteBuffer) (obj)).clear();
        SLog.d((new StringBuilder()).append("Input buffer: ").append(obj).toString());
        ((ByteBuffer) (obj)).put(arraylist);
        mediacodec.queueInputBuffer(k, 0, ((ByteBuffer) (obj)).limit(), bufferinfo.presentationTimeUs, 0);
_L26:
        obj = new android.media.MediaCodec.BufferInfo();
        k = mediacodec.dequeueOutputBuffer(((android.media.MediaCodec.BufferInfo) (obj)), 0L);
        k;
        JVM INSTR tableswitch -3 -1: default 805
    //                   -3 749
    //                   -2 768
    //                   -1 782;
           goto _L19 _L20 _L21 _L22
_L22:
        break MISSING_BLOCK_LABEL_782;
_L19:
        arraylist = encoderboss[k];
        byte abyte0[] = new byte[((android.media.MediaCodec.BufferInfo) (obj)).size];
        arraylist.get(abyte0);
        bufferedoutputstream.write(abyte0, 0, abyte0.length);
        SLog.i("AvcEncoder", (new StringBuilder()).append(abyte0.length).append(" bytes written").toString());
        mediacodec.releaseOutputBuffer(k, false);
_L27:
        s.releaseOutputBuffer(j, true);
        mediaextractor.advance();
_L25:
        j = i;
        if ((bufferinfo.flags & 4) == 0) goto _L24; else goto _L23
_L23:
        Log.d("DecodeActivity", "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
_L7:
        s.stop();
        s.release();
        mediaextractor.release();
        mediacodec.stop();
        mediacodec.release();
        bufferedoutputstream.flush();
        bufferedoutputstream.close();
        return;
_L12:
        s.queueInputBuffer(k, 0, i, mediaextractor.getSampleTime(), 0);
        i = j;
          goto _L9
_L14:
        SLog.d("INFO_OUTPUT_BUFFERS_CHANGED");
        s1 = s.getOutputBuffers();
          goto _L25
_L15:
        SLog.d("New format found: {}", s.getOutputFormat());
          goto _L25
_L16:
        SLog.d("dequeueOutputBuffer timed out!");
          goto _L25
_L18:
        SLog.e("Input buffer timeout.");
          goto _L26
        arraylist;
        SLog.e("Something wrong.", arraylist);
          goto _L27
_L20:
        SLog.d("INFO_OUTPUT_BUFFERS_CHANGED");
        arraylist = mediacodec.getOutputBuffers();
        encoderboss = arraylist;
          goto _L27
_L21:
        SLog.d("New format found: {}", mediacodec.getOutputFormat());
          goto _L27
        SLog.d("dequeueOutputBuffer timed out!");
          goto _L27
_L2:
        if (s != null && encoderboss != null) goto _L29; else goto _L28
    }
}
