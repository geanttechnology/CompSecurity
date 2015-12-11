// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.util.Log;
import com.edisonwang.android.slog.SLog;
import com.lifevibes.mediacoder.LVMediaCoderFactory;
import com.lifevibes.mediacoder.LVMediaCoderImpl;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

// Referenced classes of package co.vine.android.recorder:
//            RecordConfigUtils

public class HwVineFrameRecorder
{
    public static class Exception extends RuntimeException
    {

        public Exception()
        {
        }
    }


    private static final int LOCK[] = new int[0];
    private static final boolean LOGGING = false;
    private static final String TAG = "Recorder";
    private long mAudioRecordTime;
    private final LVMediaCoderImpl mCoder;
    private int mEncodingCount;
    private int mFrameNumber;
    private boolean mHasData;
    private int mLastTimestamp;
    private ObjectOutputStream mLoggingVideoFile;
    private final String mOutput;
    private final double mTpfMs;
    private final double mTpfUs;
    private long mVideoEncodeTime;
    private long mVideoRecordTime;

    public HwVineFrameRecorder(Context context, String s, int i)
    {
        int ai[];
        StringBuilder stringbuilder = (new StringBuilder()).append("Created frame recorder: encoding only? ");
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Log.d("Recorder", stringbuilder.append(flag).toString());
        ai = LOCK;
        ai;
        JVM INSTR monitorenter ;
        Thread.dumpStack();
        mOutput = s;
        mCoder = LVMediaCoderFactory.create(context, RecordConfigUtils.getEncoderConfiguration());
        if (mOutput != null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        mCoder.startEncoding();
_L2:
        mTpfMs = 1000D / (double)i;
        mTpfUs = mTpfMs * 1000D;
        return;
        mCoder.startRecording(mOutput);
        if (true) goto _L2; else goto _L1
_L1:
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
    }

    public int encode(ByteBuffer bytebuffer, byte abyte0[], int i, boolean flag)
    {
        ByteBuffer bytebuffer1;
        long l;
label0:
        {
            l = System.currentTimeMillis();
            mHasData = true;
            bytebuffer1 = null;
            if (bytebuffer != null)
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    bytebuffer1 = mCoder.encodeVideo(bytebuffer, 1);
                } else
                {
                    mCoder.encodeVideoAsync(bytebuffer, 1, flag);
                }
                if (mLoggingVideoFile != null)
                {
                    bytebuffer.position(0);
                    try
                    {
                        mLoggingVideoFile.writeObject(bytebuffer.array());
                    }
                    // Misplaced declaration of an exception variable
                    catch (ByteBuffer bytebuffer)
                    {
                        bytebuffer.printStackTrace();
                    }
                }
                if (bytebuffer1 != null)
                {
                    break label0;
                }
            }
            return -1;
        }
        i = putEncodedData(bytebuffer1, abyte0, i);
        mEncodingCount = mEncodingCount + 1;
        mVideoEncodeTime = mVideoEncodeTime + (System.currentTimeMillis() - l);
        return i;
    }

    public int getFrameNumber()
    {
        return mFrameNumber;
    }

    public long getLastTimestamp()
    {
        return (long)mLastTimestamp;
    }

    public String getOutput()
    {
        return mOutput;
    }

    public long getTimestamp()
    {
        return Math.round((double)mFrameNumber * mTpfUs);
    }

    public boolean hasData()
    {
        return mHasData;
    }

    public int putEncodedData(ByteBuffer bytebuffer, byte abyte0[], int i)
    {
        abyte0 = ByteBuffer.wrap(abyte0);
        abyte0.position(i);
        abyte0.put(bytebuffer);
        return abyte0.position() - i;
    }

    public void recordAudio(byte abyte0[], int i, int j)
    {
        mHasData = true;
        int k = 2048;
        SLog.e("Audio buffer size: {}.", Integer.valueOf(j));
        long l1 = System.currentTimeMillis();
        while (j > 0) 
        {
            int l = k;
            if (j < k)
            {
                l = j;
            }
            ShortBuffer shortbuffer = mCoder.encodeAudio(abyte0, i, l);
            j -= l;
            i += l;
            shortbuffer.position(0);
            mCoder.recordAudio(shortbuffer);
            k = l;
        }
        mAudioRecordTime = mAudioRecordTime + (System.currentTimeMillis() - l1);
    }

    public void setDataListener(HwEncodingRunnable.EncodingProcessRunnable encodingprocessrunnable)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            mCoder.setEncoderVideoAsyncListener(encodingprocessrunnable);
        }
    }

    public void setTimestamp(long l)
    {
        mFrameNumber = (int)Math.round((double)l / mTpfUs);
    }

    public void stopCombining()
    {
        if (mLoggingVideoFile != null)
        {
            try
            {
                mLoggingVideoFile.flush();
                mLoggingVideoFile.close();
                Log.d("Recorder", "Video file binary saved.");
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        SLog.b("Recording audio took: {}ms", Long.valueOf(mAudioRecordTime));
        SLog.b("Recording video took: {}ms.", Long.valueOf(mVideoRecordTime));
        mCoder.stop();
    }

    public void stopEncoding()
    {
        SLog.d("Stop Encoding Start.");
        mCoder.stop();
        SLog.d("Stop Encoding Done.");
        if (mEncodingCount > 0)
        {
            SLog.b("Encoding video took: {}ms.", Long.valueOf(mVideoEncodeTime));
            SLog.b("Encoding fps: {}fps, ", Long.valueOf((long)(mEncodingCount * 1000) / mVideoEncodeTime));
        }
    }

    public void writeEncodedImage(byte abyte0[], int i, int j)
    {
        long l = System.currentTimeMillis();
        mHasData = true;
        mLastTimestamp = (int)((double)mFrameNumber * mTpfMs);
        mCoder.recordVideo(ByteBuffer.wrap(abyte0, i, j), mLastTimestamp + 33);
        mFrameNumber = mFrameNumber + 1;
        mVideoRecordTime = mVideoRecordTime + (System.currentTimeMillis() - l);
    }

    static 
    {
        System.loadLibrary("LV3GPWriterAndColorFilters");
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            System.loadLibrary("LifeVibesSFEncoder");
        }
    }
}
