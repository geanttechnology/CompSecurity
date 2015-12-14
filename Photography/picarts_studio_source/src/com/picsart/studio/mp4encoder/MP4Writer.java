// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.mp4encoder;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Bundle;
import android.view.Surface;
import com.picsart.studio.gifencoder.GifDrawable;
import com.picsart.studio.gifencoder.GifEncoder;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.picsart.studio.mp4encoder:
//            MP4WriterFactory, c, b, a

public class MP4Writer
    implements MP4WriterFactory
{

    private static final String dotMP4 = ".mp4";
    private static final String dotgif = ".gif";
    private static boolean flag = false;
    private static final String gifDir = "gifDir";
    private static final String gifName = "gifName";
    private static MP4Writer instance;
    private int actionsCount;
    private int delay;
    private long durationInNanosec;
    private int frameRate;
    private boolean isNewApi;
    private android.media.MediaCodec.BufferInfo mBufferInfo;
    private MediaCodec mEncoder;
    private int mHeight;
    private Surface mInputSurface;
    private MediaMuxer mMuxer;
    private boolean mMuxerStarted;
    private int mTrackIndex;
    private int mWidth;
    private String name;
    private String outputDir;
    private long presentationTime;
    private int videoDuration;
    private String videoPath;
    private com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution videoResolution;

    private MP4Writer()
    {
        frameRate = 15;
        mWidth = 640;
        mHeight = 480;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isNewApi = flag1;
    }

    public MP4Writer(Bundle bundle)
    {
        frameRate = 15;
        mWidth = 640;
        mHeight = 480;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isNewApi = flag1;
        if (instance == null)
        {
            instance = new MP4Writer();
        }
        instance.outputDir = bundle.getString("gifDir");
        instance.name = bundle.getString("gifName");
    }

    private void drainEncoder(boolean flag1)
    {
        if (flag1)
        {
            mEncoder.signalEndOfInputStream();
        }
_L2:
        ByteBuffer abytebuffer[] = mEncoder.getOutputBuffers();
_L5:
        int i;
        do
        {
            i = mEncoder.dequeueOutputBuffer(mBufferInfo, 10000L);
            if (i != -1)
            {
                continue; /* Loop/switch isn't completed */
            }
        } while (flag1);
_L6:
        return;
        if (i == -3) goto _L2; else goto _L1
_L1:
        if (i != -2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mMuxerStarted)
        {
            throw new RuntimeException("format changed twice");
        }
        MediaFormat mediaformat = mEncoder.getOutputFormat();
        mTrackIndex = mMuxer.addTrack(mediaformat);
        mMuxer.start();
        mMuxerStarted = true;
        break; /* Loop/switch isn't completed */
        if (i < 0) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_117;
_L4:
        break; /* Loop/switch isn't completed */
        ByteBuffer bytebuffer;
        if (isNewApi)
        {
            bytebuffer = mEncoder.getOutputBuffer(i);
        } else
        {
            bytebuffer = abytebuffer[i];
        }
        if (bytebuffer == null)
        {
            throw new RuntimeException((new StringBuilder("encoderOutputBuffer ")).append(i).append(" was null").toString());
        }
        if ((mBufferInfo.flags & 2) != 0)
        {
            mBufferInfo.size = 0;
        }
        if (mBufferInfo.size != 0)
        {
            if (!mMuxerStarted)
            {
                throw new RuntimeException("muxer hasn't started");
            }
            bytebuffer.position(mBufferInfo.offset);
            bytebuffer.limit(mBufferInfo.offset + mBufferInfo.size);
            mMuxer.writeSampleData(mTrackIndex, bytebuffer, mBufferInfo);
        }
        mEncoder.releaseOutputBuffer(i, false);
        if ((mBufferInfo.flags & 4) != 0) goto _L6; else goto _L5
    }

    public static MP4Writer getInstance()
    {
        if (instance == null)
        {
            instance = new MP4Writer();
        }
        return instance;
    }

    public static MP4Writer initWithParams(Bundle bundle)
    {
        if (instance == null)
        {
            instance = new MP4Writer();
        }
        instance.outputDir = bundle.getString("gifDir");
        instance.name = bundle.getString("gifName");
        return instance;
    }

    public static transient MP4Writer initWithParams(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions videooptions, int ai[])
    {
        if (instance == null)
        {
            instance = new MP4Writer();
        }
        instance.outputDir = videooptions.getOutputDir();
        instance.name = videooptions.getOutputName();
        instance.videoResolution = videooptions.getResolution();
        instance.videoDuration = videooptions.getDuration();
        instance.mWidth = ai[0];
        instance.mHeight = ai[1];
        if (ai[2] != 0)
        {
            instance.actionsCount = ai[2];
        }
        instance.videoPath = (new StringBuilder()).append(instance.outputDir).append("/").append(instance.name).append(".mp4").toString();
        return instance;
    }

    private transient boolean prepareEncoder(boolean flag1, int ai[])
    {
        Object obj;
        mBufferInfo = new android.media.MediaCodec.BufferInfo();
        obj = c.a("video/avc");
        if (((b) (obj)).a == null) goto _L2; else goto _L1
_L1:
        int i;
        mEncoder = MediaCodec.createByCodecName(((b) (obj)).a);
        i = ((b) (obj)).b;
_L4:
        if (flag)
        {
            obj = Bitmap.createBitmap(mWidth, mHeight, android.graphics.Bitmap.Config.ARGB_8888);
            mWidth = ai[0] - ai[0] % 16;
            mHeight = ai[1] - ai[1] % 16;
            ai = getResizedBitmap(((Bitmap) (obj)), mWidth, mHeight);
            mWidth = ai.getWidth();
            mHeight = ai.getHeight();
            ((Bitmap) (obj)).recycle();
            ai.recycle();
        }
        ai = MediaFormat.createVideoFormat("video/avc", mWidth, mHeight);
        ai.setInteger("color-format", i);
        IOException ioexception;
        if (flag1)
        {
            i = 0x2dc6c0;
        } else
        {
            i = 0x1e8480;
        }
        ai.setInteger("bitrate", i);
        ai.setInteger("frame-rate", frameRate);
        ai.setInteger("i-frame-interval", 10);
        mEncoder.configure(ai, null, null, 1);
        mEncoder.start();
        ai = (new File(instance.outputDir, (new StringBuilder()).append(instance.name).append(".mp4").toString())).toString();
        try
        {
            mMuxer = new MediaMuxer(ai, 0);
        }
        // Misplaced declaration of an exception variable
        catch (int ai[])
        {
            return false;
        }
        mTrackIndex = -1;
        mMuxerStarted = false;
        return true;
        ioexception;
        ioexception.printStackTrace();
        obj.c = a.b[0];
        try
        {
            mEncoder = MediaCodec.createByCodecName(((b) (obj)).c);
            i = ((b) (obj)).b;
        }
        // Misplaced declaration of an exception variable
        catch (int ai[])
        {
            ai.printStackTrace();
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void releaseEncoder()
    {
        if (mEncoder != null)
        {
            mEncoder.stop();
            mEncoder.release();
            mEncoder = null;
        }
        if (mInputSurface != null)
        {
            mInputSurface.release();
            mInputSurface = null;
        }
        if (mMuxer != null)
        {
            try
            {
                mMuxer.stop();
                mMuxer.release();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            mMuxer = null;
        }
    }

    public void addFrame(Bitmap bitmap, long l)
    {
        drainEncoder(false);
        durationInNanosec = l;
        ByteBuffer bytebuffer;
        int i;
        if (flag)
        {
            Bitmap bitmap1 = getResizedBitmap(bitmap, mWidth, mHeight);
            bitmap = GifEncoder.getBitmapInYUV(bitmap1);
            bitmap1.recycle();
        } else
        {
            bitmap = GifEncoder.getBitmapInYUV(bitmap);
        }
        i = mEncoder.dequeueInputBuffer(1000L);
        if (isNewApi)
        {
            bytebuffer = mEncoder.getInputBuffer(i);
        } else
        {
            bytebuffer = mEncoder.getInputBuffers()[i];
        }
        bytebuffer.put(bitmap);
        presentationTime = presentationTime + durationInNanosec;
        mEncoder.queueInputBuffer(i, 0, bytebuffer.capacity(), presentationTime, 1);
        ImageOpCommon.freeNativeBuffer(bitmap);
    }

    public boolean canStartVideoGeneration()
    {
        return prepareEncoder(true, new int[] {
            mWidth, mHeight
        });
    }

    public void cancelVideoGeneration()
    {
        drainEncoder(true);
        releaseEncoder();
        File file = new File(videoPath);
        if (file.exists())
        {
            file.delete();
        }
    }

    public void createGifMovie()
    {
        Exception exception1;
        int i = 0;
        Object obj = (new StringBuilder()).append(instance.outputDir).append("/").append(instance.name).append(".gif").toString();
        int j;
        try
        {
            obj = new GifDrawable(((String) (obj)));
            mWidth = ((GifDrawable) (obj)).getCurrentFrame().getWidth();
            mHeight = ((GifDrawable) (obj)).getCurrentFrame().getHeight();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
        try
        {
            if ((float)((GifDrawable) (obj)).getCurrentFrame().getWidth() / ((float)((GifDrawable) (obj)).getCurrentFrame().getHeight() * 1.0F) < 1.333333F)
            {
                flag = true;
            }
            prepareEncoder(false, new int[] {
                ((GifDrawable) (obj)).getCurrentFrame().getWidth(), ((GifDrawable) (obj)).getCurrentFrame().getHeight()
            });
            presentationTime = 0L;
            j = ((GifDrawable) (obj)).getNumberOfFrames();
            delay = ((GifDrawable) (obj)).getFrameDuration(0) / 10;
        }
        catch (Exception exception)
        {
            releaseEncoder();
            return;
        }
        finally
        {
            releaseEncoder();
        }
        if (i > j + 1)
        {
            break; /* Loop/switch isn't completed */
        }
        durationInNanosec = delay * 10000;
        addFrame(((GifDrawable) (obj)).seekToFrameAndGet(i), durationInNanosec);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_153;
_L1:
        drainEncoder(true);
        releaseEncoder();
        return;
        throw exception1;
    }

    public void finalizeVideoGeneration()
    {
        try
        {
            drainEncoder(true);
            releaseEncoder();
            return;
        }
        catch (Exception exception) { }
        try
        {
            releaseEncoder();
            return;
        }
        catch (Exception exception1)
        {
            return;
        }
    }

    public String getOutputAbsolutePath()
    {
        return (new StringBuilder()).append(instance.outputDir).append("/").append(instance.name).append(".mp4").toString();
    }

    public Bitmap getResizedBitmap(Bitmap bitmap, int i, int j)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        float f = (float)i / (float)k;
        float f1 = (float)j / (float)l;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f1);
        return Bitmap.createBitmap(bitmap, 0, 0, k, l, matrix, false);
    }

    static 
    {
        flag = false;
    }
}
