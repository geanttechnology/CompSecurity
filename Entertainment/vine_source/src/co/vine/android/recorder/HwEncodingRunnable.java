// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Process;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package co.vine.android.recorder:
//            AbstractEncodingRunnable, ByteBufferQueue, VideoData, RecordController, 
//            CameraManager, BaseFinishProcessTask, HwVineFrameRecorder, PictureConverter, 
//            RecordConfigUtils, RecordSegment, CameraSetting, RecordSessionManager

public class HwEncodingRunnable extends AbstractEncodingRunnable
{
    class EncodingProcessRunnable
        implements Runnable, com.lifevibes.mediacoder.LVMediaCoder.LVMediaCoderICSEncoderProgressListener
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
            throws HwVineFrameRecorder.Exception
        {
            VideoData videodata = (VideoData)mBufferedVideoData.getFirst();
            videodata.size = mEncoder.putEncodedData(bytebuffer, mVideoDataBufferMax, mVideoDataBufferPosition);
            return putVideoFrame(videodata);
        }

        private boolean doVideoFrameRaw(byte abyte0[], boolean flag, boolean flag1)
            throws HwVineFrameRecorder.Exception
        {
            if (mEncoder == null)
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
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        private void makeNewEncoder()
        {
            mTotalProcessed = 0;
            mReceived = 0;
            mEncoder = RecordConfigUtils.newVideoRecorder(mContext, null, mRecorderFrameRate);
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                mEncoder.setDataListener(this);
            }
        }

        private boolean putVideoFrame(VideoData videodata)
        {
            if (videodata.size != -1)
            {
                videodata.start = mVideoDataBufferPosition;
                mMaxEncodedSize = Math.max(mMaxEncodedSize, videodata.size);
                videodata = 
// JavaClassFileOutputException: get_constant: invalid tag

        private void stopEncoder(int i)
        {
            SLog.d("Stopping encoder. Error count: {}.", Integer.valueOf(mErrorCount));
            mEncoder.stopEncoding();
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
            catch (HwVineFrameRecorder.Exception exception)
            {
                SLog.e("Error flushing...", exception);
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
                if (!mByteBufferQueue.put(new QueueItem(videodata.data, videodata)))
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
            SLog.d("Got Frame! Processed: {}, Received: {}.", Integer.valueOf(mTotalProcessed), Integer.valueOf(mReceived));
            doVideoFrameEncoded(bytebuffer);
        }

        public byte[] processVideoData(VideoData videodata, boolean flag)
            throws HwVineFrameRecorder.Exception, IOException
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
            synchronized (mPictureConverter.LOCK)
            {
                long l = System.currentTimeMillis();
                CameraSetting camerasetting = videodata.segment.getCameraSetting();
                boolean flag2 = mPictureConverter.updateSettingsIfNeeded(camerasetting);
                mPictureConverter.giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(camerasetting.degrees, false);
                mPictureConverter.convert(camerasetting, videodata, flag2);
                videodata = this.access$600 + videodata;
                l = System.currentTimeMillis();
                mPictureConverter.draw(mMatrixCanvas);
                videodata = ((Boolean) (this)).valueOf + videodata;
            }
            mByteBuffer.clear();
            mMatrixBitmap.copyPixelsToBuffer(mByteBuffer);
            if (flag1 && !mTerminateImmediately)
            {
                mPictureConverter.drawGeneric(mThumbnailCanvas, mMatrixBitmap, mThumbnailMatrix);
                file = (new StringBuilder()).append(mOutput).append(".").append(System.currentTimeMillis()).append(".jpg").toString();
                videodata.segment.setThumbnailPath(file);
                Object obj = new File(file);
                file = ((File) (obj)).getParentFile();
                long l1;
                try
                {
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                    mThumbnailBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
                    byte abyte0[] = bytearrayoutputstream.toByteArray();
                    obj = new FileOutputStream(((File) (obj)));
                    ((FileOutputStream) (obj)).write(abyte0);
                    ((FileOutputStream) (obj)).close();
                }
                catch (Throwable throwable)
                {
                    if (RecordSessionManager.wasSessionJustDeleted(file))
                    {
                        mTerminateImmediately = true;
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
            videodata = this.access$900 + videodata;
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
            ByteBufferQueue.QueueItem queueitem = mByteBufferQueue.get();
            if (!mProducer.isRecordingStarted() && mAsyncTask != null)
            {
                int i = Math.max(mByteBufferQueue.size(), 1);
                if (totalSizeToWait == -1)
                {
                    totalSizeToWait = i;
                    Process.setThreadPriority(-8);
                    SLog.i("Size to wait: {}.", Integer.valueOf(totalSizeToWait));
                }
                mAsyncTask.publish(((totalSizeToWait - i) * 90) / totalSizeToWait);
            }
            if (queueitem == null)
            {
                break MISSING_BLOCK_LABEL_220;
            }
            SLog.d("Got data. {}", this);
            videodata = (VideoData)queueitem.tag;
            videodata.data = queueitem.bytes;
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
            if (mByteBufferQueue.isEndOfPut())
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

        public EncodingProcessRunnable(ByteBuffer bytebuffer)
        {
            this$0 = HwEncodingRunnable.this;
            super();
            totalSizeToWait = -1;
            mByteBuffer = bytebuffer;
            makeNewEncoder();
            mBufferedVideoData = new LinkedList();
        }
    }


    private BaseFinishProcessTask mAsyncTask;
    private final ByteBufferQueue mByteBufferQueue;
    private final CameraManager mCameraManager;
    private final Context mContext;
    private final ConcurrentLinkedQueue mDataQueue;
    private HwVineFrameRecorder mEncoder;
    private final EncodingProcessRunnable mEncodingRunnable;
    private final Thread mEncodingThread;
    private Bitmap mMatrixBitmap;
    private Canvas mMatrixCanvas;
    private int mMaxEncodedSize;
    private final String mOutput;
    private final PictureConverter mPictureConverter;
    private final RecordController mProducer;
    private final int mRecorderFrameRate;
    private volatile boolean mTerminateImmediately;
    private final Bitmap mThumbnailBitmap;
    private final Canvas mThumbnailCanvas;
    private final Matrix mThumbnailMatrix;
    private int mTotalProcessed;
    private final byte mVideoDataBufferMax[];
    private int mVideoDataBufferPosition;
    private long timeToMatrix;
    private long timeToRGB;
    private long timeToRecord;

    public HwEncodingRunnable(Context context, ConcurrentLinkedQueue concurrentlinkedqueue, byte abyte0[], RecordController recordcontroller, String s, int i, ByteBuffer bytebuffer, 
            Bitmap bitmap, Bitmap bitmap1, PictureConverter pictureconverter, int j, CameraManager cameramanager, ByteBufferQueue bytebufferqueue, Matrix matrix, 
            Canvas canvas, Canvas canvas1)
    {
        mTerminateImmediately = false;
        mContext = context;
        mDataQueue = concurrentlinkedqueue;
        mProducer = recordcontroller;
        mMatrixBitmap = bitmap;
        mThumbnailBitmap = bitmap1;
        mCameraManager = cameramanager;
        mThumbnailCanvas = canvas;
        mMatrixCanvas = canvas1;
        mVideoDataBufferMax = abyte0;
        mVideoDataBufferPosition = j;
        mPictureConverter = pictureconverter;
        mRecorderFrameRate = i;
        mOutput = s;
        mThumbnailMatrix = matrix;
        mByteBufferQueue = bytebufferqueue;
        mEncodingRunnable = new EncodingProcessRunnable(bytebuffer);
        mEncodingThread = new Thread(mEncodingRunnable);
        if (!mByteBufferQueue.isFresh())
        {
            throw new RuntimeException("Invalid buffer queue.");
        } else
        {
            return;
        }
    }

    private void process(boolean flag)
    {
        do
        {
            Object obj;
label0:
            {
                if (!mTerminateImmediately)
                {
                    obj = (VideoData)mDataQueue.poll();
                    if (obj != null || mProducer.isRecordingStarted())
                    {
                        if (obj != null)
                        {
                            break label0;
                        }
                        if (!flag)
                        {
                            continue;
                        }
                        try
                        {
                            Thread.sleep(100L);
                            continue;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            SLog.d("Break signal reached.");
                        }
                    }
                }
                return;
            }
            byte abyte0[] = mEncodingRunnable.add(((VideoData) (obj)));
            CameraManager cameramanager = mCameraManager;
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            cameramanager.addBuffer(abyte0, flag1);
        } while (true);
    }

    public String getOutput()
    {
        return mOutput;
    }

    public void run()
    {
        Process.setThreadPriority(19);
        CrashUtil.log("Processing started: {}.", new Object[] {
            mOutput
        });
        mEncodingRunnable.mRun = true;
        mEncodingThread.start();
        for (; mProducer.isRecordingStarted() && !mTerminateImmediately; process(true)) { }
        SLog.d("Flushing...");
        if (!mTerminateImmediately)
        {
            process(false);
        } else
        {
            SLog.d("Terminate without saving....");
        }
        mByteBufferQueue.endOfPut();
        try
        {
            mEncodingThread.join();
        }
        catch (InterruptedException interruptedexception)
        {
            SLog.e("Interrupted.");
        }
        if (mAsyncTask != null)
        {
            mAsyncTask.publish(90);
        }
        SLog.b("Time used: rgb: {}ms", Long.valueOf(timeToRGB));
        SLog.b("Time used: matrix: {}ms.", Long.valueOf(timeToMatrix));
        SLog.b("Total Processed: {}.", Integer.valueOf(mTotalProcessed));
        SLog.b("Total Encoding time: {}ms.", Long.valueOf(timeToRecord));
        CrashUtil.log("Processing Ended: {}.", new Object[] {
            mOutput
        });
    }

    public void setAsyncTask(BaseFinishProcessTask basefinishprocesstask)
    {
        mAsyncTask = basefinishprocesstask;
    }

    public void terminate()
    {
        SLog.d("Terminate without saving turned on.");
        mTerminateImmediately = true;
    }





/*
    static long access$1114(HwEncodingRunnable hwencodingrunnable, long l)
    {
        l = hwencodingrunnable.timeToRGB + l;
        hwencodingrunnable.timeToRGB = l;
        return l;
    }

*/



/*
    static long access$1314(HwEncodingRunnable hwencodingrunnable, long l)
    {
        l = hwencodingrunnable.timeToMatrix + l;
        hwencodingrunnable.timeToMatrix = l;
        return l;
    }

*/




/*
    static boolean access$1502(HwEncodingRunnable hwencodingrunnable, boolean flag)
    {
        hwencodingrunnable.mTerminateImmediately = flag;
        return flag;
    }

*/







/*
    static long access$2014(HwEncodingRunnable hwencodingrunnable, long l)
    {
        l = hwencodingrunnable.timeToRecord + l;
        hwencodingrunnable.timeToRecord = l;
        return l;
    }

*/




/*
    static int access$412(HwEncodingRunnable hwencodingrunnable, int i)
    {
        i = hwencodingrunnable.mVideoDataBufferPosition + i;
        hwencodingrunnable.mVideoDataBufferPosition = i;
        return i;
    }

*/



/*
    static HwVineFrameRecorder access$502(HwEncodingRunnable hwencodingrunnable, HwVineFrameRecorder hwvineframerecorder)
    {
        hwencodingrunnable.mEncoder = hwvineframerecorder;
        return hwvineframerecorder;
    }

*/



/*
    static int access$602(HwEncodingRunnable hwencodingrunnable, int i)
    {
        hwencodingrunnable.mTotalProcessed = i;
        return i;
    }

*/


/*
    static int access$608(HwEncodingRunnable hwencodingrunnable)
    {
        int i = hwencodingrunnable.mTotalProcessed;
        hwencodingrunnable.mTotalProcessed = i + 1;
        return i;
    }

*/



/*
    static int access$702(HwEncodingRunnable hwencodingrunnable, int i)
    {
        hwencodingrunnable.mMaxEncodedSize = i;
        return i;
    }

*/


}
