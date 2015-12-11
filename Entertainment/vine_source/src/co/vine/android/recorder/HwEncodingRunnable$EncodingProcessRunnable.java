// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.os.Process;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;

// Referenced classes of package co.vine.android.recorder:
//            HwEncodingRunnable, VideoData, HwVineFrameRecorder, RecordConfigUtils, 
//            ByteBufferQueue, PictureConverter, RecordSegment, CameraSetting, 
//            RecordSessionManager, RecordController, BaseFinishProcessTask

class mBufferedVideoData
    implements Runnable, com.lifevibes.mediacoder.Listener
{

    private final int LOCK[] = new int[0];
    private LinkedList mBufferedVideoData;
    private ByteBuffer mByteBuffer;
    private int mErrorCount;
    private VideoData mLast;
    private RecordSegment mLastSegment;
    private int mReceived;
    public boolean mRun;
    private boolean notFirst;
    final HwEncodingRunnable this$0;
    private int totalSizeToWait;

    private boolean doVideoFrameEncoded(ByteBuffer bytebuffer)
        throws Listener
    {
        VideoData videodata = (VideoData)mBufferedVideoData.getFirst();
        videodata.size = HwEncodingRunnable.access$500(HwEncodingRunnable.this).putEncodedData(bytebuffer, HwEncodingRunnable.access$300(HwEncodingRunnable.this), HwEncodingRunnable.access$400(HwEncodingRunnable.this));
        return putVideoFrame(videodata);
    }

    private boolean doVideoFrameRaw(byte abyte0[], boolean flag, boolean flag1)
        throws putVideoFrame
    {
        if (HwEncodingRunnable.access$500(HwEncodingRunnable.this) == null)
        {
            makeNewEncoder();
        } else
        {
            if (flag && notFirst)
            {
                stopEncoder(1);
                makeNewEncoder();
            }
            notFirst = true;
        }
        int _tmp = HwEncodingRunnable.access$608(HwEncodingRunnable.this);
        if (android.os.ocessRunnable.this._fld0 < 16)
        {
            HwEncodingRunnable.access$500(HwEncodingRunnable.this).encode(ByteBuffer.wrap(abyte0), HwEncodingRunnable.access$300(HwEncodingRunnable.this), HwEncodingRunnable.access$400(HwEncodingRunnable.this), flag1);
            return false;
        } else
        {
            VideoData videodata = (VideoData)mBufferedVideoData.getFirst();
            videodata.size = HwEncodingRunnable.access$500(HwEncodingRunnable.this).encode(ByteBuffer.wrap(abyte0), HwEncodingRunnable.access$300(HwEncodingRunnable.this), HwEncodingRunnable.access$400(HwEncodingRunnable.this), flag1);
            SLog.d("onFrameAvailable Write video frame size {}. Total processed {}, last Frame? {}.", Integer.valueOf(videodata.size), Integer.valueOf(HwEncodingRunnable.access$600(HwEncodingRunnable.this)), Boolean.valueOf(flag1));
            return putVideoFrame(videodata);
        }
    }

    private void makeNewEncoder()
    {
        HwEncodingRunnable.access$602(HwEncodingRunnable.this, 0);
        mReceived = 0;
        HwEncodingRunnable.access$502(HwEncodingRunnable.this, RecordConfigUtils.newVideoRecorder(HwEncodingRunnable.access$800(HwEncodingRunnable.this), null, HwEncodingRunnable.access$900(HwEncodingRunnable.this)));
        if (android.os.ocessRunnable.this._fld0 < 16)
        {
            HwEncodingRunnable.access$500(HwEncodingRunnable.this).setDataListener(this);
        }
    }

    private boolean putVideoFrame(VideoData videodata)
    {
        if (videodata.size != -1)
        {
            videodata.start = HwEncodingRunnable.access$400(HwEncodingRunnable.this);
            HwEncodingRunnable.access$702(HwEncodingRunnable.this, Math.max(HwEncodingRunnable.access$700(HwEncodingRunnable.this), videodata.size));
            HwEncodingRunnable.access$412(HwEncodingRunnable.this, videodata.size);
            mBufferedVideoData.pop();
            return true;
        } else
        {
            SLog.d("******Image was buffered to the next frame.********");
            return false;
        }
    }

    private void stopEncoder(int i)
    {
        SLog.d("Stopping encoder. Error count: {}.", Integer.valueOf(mErrorCount));
        HwEncodingRunnable.access$500(HwEncodingRunnable.this).stopEncoding();
        SLog.d("Frames left? {}, allowed? {}.", Integer.valueOf(mBufferedVideoData.size()), Integer.valueOf(i));
_L1:
        int j = mBufferedVideoData.size();
        if (j <= i)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        Thread.sleep(10L);
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        try
        {
            interruptedexception.printStackTrace();
        }
        catch (mBufferedVideoData mbufferedvideodata)
        {
            SLog.e("Error flushing...", mbufferedvideodata);
            return;
        }
          goto _L1
        mErrorCount = 0;
        return;
    }

    public byte[] add(VideoData videodata)
    {
        synchronized (LOCK)
        {
            SLog.d((new StringBuilder()).append("Added to the queue. ").append(this).toString());
            if (!HwEncodingRunnable.access$000(HwEncodingRunnable.this).put(new this._cls0(videodata.data, videodata)))
            {
                CrashUtil.log("Not enough memory left. (BufferOverflow)");
            }
            videodata = videodata.data;
        }
        return videodata;
        videodata;
        ai;
        JVM INSTR monitorexit ;
        throw videodata;
    }

    public void onComplete()
    {
    }

    public void onError(Exception exception, int i)
    {
        SLog.d("Encoding error: {}.", Integer.valueOf(i), exception);
        mErrorCount = mErrorCount + 1;
    }

    public void onFrameAvailable(ByteBuffer bytebuffer)
    {
        mReceived = mReceived + 1;
        SLog.d("Got Frame! Processed: {}, Received: {}.", Integer.valueOf(HwEncodingRunnable.access$600(HwEncodingRunnable.this)), Integer.valueOf(mReceived));
        doVideoFrameEncoded(bytebuffer);
    }

    public byte[] processVideoData(VideoData videodata, boolean flag)
        throws doVideoFrameEncoded, IOException
    {
        boolean flag1;
        if (mLastSegment != videodata.segment)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mLastSegment = videodata.segment;
        synchronized (HwEncodingRunnable.access$1000(HwEncodingRunnable.this).LOCK)
        {
            long l = System.currentTimeMillis();
            CameraSetting camerasetting = videodata.segment.getCameraSetting();
            boolean flag2 = HwEncodingRunnable.access$1000(HwEncodingRunnable.this).updateSettingsIfNeeded(camerasetting);
            HwEncodingRunnable.access$1000(HwEncodingRunnable.this).giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(camerasetting.degrees, false);
            HwEncodingRunnable.access$1000(HwEncodingRunnable.this).convert(camerasetting, videodata, flag2);
            HwEncodingRunnable.access$1114(HwEncodingRunnable.this, System.currentTimeMillis() - l);
            l = System.currentTimeMillis();
            HwEncodingRunnable.access$1000(HwEncodingRunnable.this).draw(HwEncodingRunnable.access$1200(HwEncodingRunnable.this));
            HwEncodingRunnable.access$1314(HwEncodingRunnable.this, System.currentTimeMillis() - l);
        }
        mByteBuffer.clear();
        HwEncodingRunnable.access$1400(HwEncodingRunnable.this).copyPixelsToBuffer(mByteBuffer);
        if (flag1 && !HwEncodingRunnable.access$1500(HwEncodingRunnable.this))
        {
            HwEncodingRunnable.access$1000(HwEncodingRunnable.this).drawGeneric(HwEncodingRunnable.access$1600(HwEncodingRunnable.this), HwEncodingRunnable.access$1400(HwEncodingRunnable.this), HwEncodingRunnable.access$1700(HwEncodingRunnable.this));
            file = (new StringBuilder()).append(HwEncodingRunnable.access$1800(HwEncodingRunnable.this)).append(".").append(System.currentTimeMillis()).append(".jpg").toString();
            videodata.segment.setThumbnailPath(file);
            Object obj = new File(file);
            file = ((File) (obj)).getParentFile();
            long l1;
            try
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                HwEncodingRunnable.access$1900(HwEncodingRunnable.this).compress(android.graphics.unnable.this._fld0, 100, bytearrayoutputstream);
                byte abyte0[] = bytearrayoutputstream.toByteArray();
                obj = new FileOutputStream(((File) (obj)));
                ((FileOutputStream) (obj)).write(abyte0);
                ((FileOutputStream) (obj)).close();
            }
            catch (Throwable throwable)
            {
                if (RecordSessionManager.wasSessionJustDeleted(file))
                {
                    HwEncodingRunnable.access$1502(HwEncodingRunnable.this, true);
                    CrashUtil.logException(throwable);
                } else
                {
                    throw throwable;
                }
            }
        }
        l1 = System.currentTimeMillis();
        mBufferedVideoData.add(videodata);
        doVideoFrameRaw(mByteBuffer.array(), flag1, flag);
        HwEncodingRunnable.access$2014(HwEncodingRunnable.this, System.currentTimeMillis() - l1);
        file = videodata.data;
        videodata.data = null;
        return file;
        videodata;
        file;
        JVM INSTR monitorexit ;
        throw videodata;
    }

    public void run()
    {
        Process.setThreadPriority(19);
        mLastSegment = null;
        SLog.d("EncodingProcessRunnable started.");
_L2:
        VideoData videodata;
        if (!mRun)
        {
            break; /* Loop/switch isn't completed */
        }
        this._cls0 _lcls0 = HwEncodingRunnable.access$000(HwEncodingRunnable.this).get();
        if (!HwEncodingRunnable.access$100(HwEncodingRunnable.this).isRecordingStarted() && HwEncodingRunnable.access$200(HwEncodingRunnable.this) != null)
        {
            int i = Math.max(HwEncodingRunnable.access$000(HwEncodingRunnable.this).size(), 1);
            if (totalSizeToWait == -1)
            {
                totalSizeToWait = i;
                Process.setThreadPriority(-8);
                SLog.i("Size to wait: {}.", Integer.valueOf(totalSizeToWait));
            }
            HwEncodingRunnable.access$200(HwEncodingRunnable.this).publish(((totalSizeToWait - i) * 90) / totalSizeToWait);
        }
        if (_lcls0 == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        SLog.d("Got data. {}", this);
        videodata = (VideoData)_lcls0.totalSizeToWait;
        videodata.data = _lcls0.totalSizeToWait;
        if (mLast == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        VideoData videodata1 = mLast;
        boolean flag;
        if (mLast.segment != videodata.segment)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            processVideoData(videodata1, flag);
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        mLast = null;
        mLast = videodata;
        continue; /* Loop/switch isn't completed */
        if (HwEncodingRunnable.access$000(HwEncodingRunnable.this).isEndOfPut())
        {
            mRun = false;
        } else
        {
            try
            {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedexception)
            {
                SLog.e("Interrupted.");
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (mLast != null)
        {
            try
            {
                processVideoData(mLast, true);
            }
            catch (Exception exception1)
            {
                throw new RuntimeException(exception1);
            }
            mLast = null;
        }
        stopEncoder(0);
        return;
    }

    public Listener(ByteBuffer bytebuffer)
    {
        this$0 = HwEncodingRunnable.this;
        super();
        totalSizeToWait = -1;
        mByteBuffer = bytebuffer;
        makeNewEncoder();
        mBufferedVideoData = new LinkedList();
    }
}
