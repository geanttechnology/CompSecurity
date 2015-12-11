// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Process;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.InstanceCounter;
import com.edisonwang.android.slog.SLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.io.FileUtils;

// Referenced classes of package co.vine.android.recorder:
//            AbstractEncodingRunnable, ByteBufferQueue, VideoData, SwVineFrameRecorder, 
//            RecordConfigUtils, RecordController, CameraManager, PictureConverter, 
//            RecordSegment, CameraSetting, RecordSessionManager, BaseFinishProcessTask

public class SwEncodingRunnable extends AbstractEncodingRunnable
{
    static class EncodingProcessRunnable
        implements Runnable
    {

        private final int LOCK[] = new int[0];
        private LinkedList mBufferedVideoData;
        private SwEncodingRunnable mParent;
        public boolean mRun;
        private int totalSizeToWait;

        public byte[] add(VideoData videodata)
        {
            int ai[] = LOCK;
            ai;
            JVM INSTR monitorenter ;
            SwEncodingRunnable swencodingrunnable;
            byte abyte0[];
            swencodingrunnable = mParent;
            abyte0 = videodata.data;
            if (abyte0 == null || swencodingrunnable == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            if (!swencodingrunnable.mByteBufferQueue.put(new ByteBufferQueue.QueueItem(abyte0, videodata)))
            {
                CrashUtil.log("Not enough memory left. (BufferOverflow)");
            }
            videodata = videodata.data;
            ai;
            JVM INSTR monitorexit ;
            return videodata;
            videodata;
            ai;
            JVM INSTR monitorexit ;
            throw videodata;
        }

        public void run()
        {
            Process.setThreadPriority(19);
            while (mRun) 
            {
                ByteBufferQueue.QueueItem queueitem = mParent.mByteBufferQueue.get();
                if (!mParent.mProducer.isRecordingStarted() && mParent.mAsyncTask != null)
                {
                    int i = Math.max(mParent.mByteBufferQueue.size(), 1);
                    if (totalSizeToWait == -1)
                    {
                        totalSizeToWait = i;
                        Process.setThreadPriority(-8);
                        SLog.i("Size to wait: {}.", Integer.valueOf(totalSizeToWait));
                    }
                    mParent.mAsyncTask.publish(((totalSizeToWait - i) * 90) / totalSizeToWait);
                }
                if (queueitem != null)
                {
                    VideoData videodata = (VideoData)queueitem.tag;
                    videodata.data = queueitem.bytes;
                    try
                    {
                        mParent.processVideoData(mBufferedVideoData, videodata);
                    }
                    catch (Exception exception)
                    {
                        throw new RuntimeException(exception);
                    }
                } else
                if (mParent.mByteBufferQueue.isEndOfPut())
                {
                    mRun = false;
                } else
                {
                    try
                    {
                        Thread.sleep(50L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        SLog.e("Interrupted.");
                    }
                }
            }
            mParent.stopEncoder(mBufferedVideoData);
            mParent = null;
        }

        public EncodingProcessRunnable(SwEncodingRunnable swencodingrunnable)
        {
            totalSizeToWait = -1;
            mParent = swencodingrunnable;
            mParent.makeNewEncoder();
            mBufferedVideoData = new LinkedList();
        }
    }


    private static final InstanceCounter sInstanceCounter = new InstanceCounter(3);
    private static int sRunningInstances;
    private BaseFinishProcessTask mAsyncTask;
    private final ByteBufferQueue mByteBufferQueue;
    private final CameraManager mCameraManager;
    private final ConcurrentLinkedQueue mDataQueue;
    private SwVineFrameRecorder mEncoder;
    private final com.googlecode.javacv.cpp.opencv_core.IplImage mEncodingImage;
    private final String mEncodingTempPath;
    private RecordSegment mLastSegment;
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
    private final boolean mUseMp4;
    private final byte mVideoDataBufferMax[];
    private int mVideoDataBufferPosition;
    private long timeToMatrix;
    private long timeToRGB;
    private long timeToRecord;

    public SwEncodingRunnable(ConcurrentLinkedQueue concurrentlinkedqueue, byte abyte0[], RecordController recordcontroller, String s, int i, com.googlecode.javacv.cpp.opencv_core.IplImage iplimage, Bitmap bitmap, 
            Bitmap bitmap1, PictureConverter pictureconverter, int j, CameraManager cameramanager, ByteBufferQueue bytebufferqueue, Matrix matrix, Canvas canvas, 
            Canvas canvas1, boolean flag)
    {
        mTerminateImmediately = false;
        sInstanceCounter.onCreate(this);
        mEncodingImage = iplimage;
        mUseMp4 = flag;
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
        mEncodingTempPath = (new StringBuilder()).append(mOutput).append(".encode").toString();
        mByteBufferQueue = bytebufferqueue;
        if (mByteBufferQueue == null || !mByteBufferQueue.isFresh())
        {
            throw new RuntimeException("Invalid buffer queue.");
        } else
        {
            return;
        }
    }

    private boolean doVideoFrame(LinkedList linkedlist, com.googlecode.javacv.cpp.opencv_core.IplImage iplimage, boolean flag)
        throws SwVineFrameRecorder.Exception
    {
        VideoData videodata;
        if (mEncoder == null)
        {
            makeNewEncoder();
        } else
        if (flag)
        {
            stopEncoder(linkedlist);
            makeNewEncoder();
        }
        videodata = (VideoData)linkedlist.getFirst();
        videodata.size = mEncoder.encode(iplimage, mVideoDataBufferMax, mVideoDataBufferPosition);
        SLog.d("Encoded video frame size {}. Total processed {}.", Integer.valueOf(videodata.size), Integer.valueOf(mTotalProcessed));
        mTotalProcessed = mTotalProcessed + 1;
        if (videodata.size != -1)
        {
            videodata.start = mVideoDataBufferPosition;
            videodata.keyFrame = true;
            mMaxEncodedSize = Math.max(mMaxEncodedSize, videodata.size);
            mVideoDataBufferPosition = mVideoDataBufferPosition + videodata.size;
            linkedlist.pop();
            return true;
        } else
        {
            SLog.d("******Image was buffered to the next frame.********");
            return false;
        }
    }

    private void makeNewEncoder()
    {
        mEncoder = RecordConfigUtils.newVideoRecorder(mEncodingTempPath, mRecorderFrameRate, 480, mUseMp4);
        try
        {
            mEncoder.start();
            return;
        }
        catch (SwVineFrameRecorder.Exception exception)
        {
            CrashUtil.logException(exception, "Failed to start encoder", new Object[0]);
        }
    }

    private void process(EncodingProcessRunnable encodingprocessrunnable, boolean flag)
    {
        do
        {
            VideoData videodata;
label0:
            {
                if (!mTerminateImmediately)
                {
                    videodata = (VideoData)mDataQueue.poll();
                    if (videodata != null || mProducer.isRecordingStarted())
                    {
                        if (videodata != null)
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
                        catch (EncodingProcessRunnable encodingprocessrunnable)
                        {
                            SLog.d("Break signal reached.");
                        }
                    }
                }
                return;
            }
            byte abyte0[] = encodingprocessrunnable.add(videodata);
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

    private void stopEncoder(LinkedList linkedlist)
    {
        while (linkedlist.size() > 0 && doVideoFrame(linkedlist, null, false)) ;
        mEncoder.stopEncoding();
        mEncoder.release();
        return;
        linkedlist;
        SLog.e("Error flushing...", linkedlist);
        mEncoder.release();
        return;
        linkedlist;
        mEncoder.release();
        throw linkedlist;
    }

    public String getOutput()
    {
        return mOutput;
    }

    public byte[] processVideoData(LinkedList linkedlist, VideoData videodata)
        throws SwVineFrameRecorder.Exception, IOException
    {
        boolean flag;
        if (mLastSegment != videodata.segment)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mLastSegment = videodata.segment;
        synchronized (mPictureConverter.LOCK)
        {
            long l = System.currentTimeMillis();
            CameraSetting camerasetting = videodata.segment.getCameraSetting();
            boolean flag1 = mPictureConverter.updateSettingsIfNeeded(camerasetting);
            mPictureConverter.giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(camerasetting.degrees, false);
            mPictureConverter.convert(camerasetting, videodata, flag1);
            timeToRGB = timeToRGB + (System.currentTimeMillis() - l);
            l = System.currentTimeMillis();
            mPictureConverter.draw(mMatrixCanvas);
            timeToMatrix = timeToMatrix + (System.currentTimeMillis() - l);
        }
        mMatrixBitmap.copyPixelsToBuffer(mEncodingImage.getByteBuffer());
        if (flag && !mTerminateImmediately)
        {
            mPictureConverter.drawGeneric(mThumbnailCanvas, mMatrixBitmap, mThumbnailMatrix);
            obj = (new StringBuilder()).append(mOutput).append(".").append(System.currentTimeMillis()).append(".jpg").toString();
            videodata.segment.setThumbnailPath(((String) (obj)));
            Object obj1 = new File(((String) (obj)));
            obj = ((File) (obj1)).getParentFile();
            long l1;
            try
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                mThumbnailBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
                byte abyte0[] = bytearrayoutputstream.toByteArray();
                obj1 = new FileOutputStream(((File) (obj1)));
                ((FileOutputStream) (obj1)).write(abyte0);
                ((FileOutputStream) (obj1)).close();
            }
            catch (Throwable throwable)
            {
                if (RecordSessionManager.wasSessionJustDeleted(((File) (obj))))
                {
                    mTerminateImmediately = true;
                    CrashUtil.logException(throwable);
                } else
                {
                    throw throwable;
                }
            }
        }
        if (!mTerminateImmediately)
        {
            l1 = System.currentTimeMillis();
            linkedlist.add(videodata);
            doVideoFrame(linkedlist, mEncodingImage, flag);
            timeToRecord = timeToRecord + (System.currentTimeMillis() - l1);
        }
        linkedlist = videodata.data;
        videodata.data = null;
        return linkedlist;
        linkedlist;
        obj;
        JVM INSTR monitorexit ;
        throw linkedlist;
    }

    public void run()
    {
        sRunningInstances++;
        CrashUtil.set("Encoder Count", sRunningInstances);
        Process.setThreadPriority(19);
        CrashUtil.log("[ML] Processing started: {}, running: {}", new Object[] {
            mOutput, Integer.valueOf(sRunningInstances)
        });
        EncodingProcessRunnable encodingprocessrunnable = new EncodingProcessRunnable(this);
        encodingprocessrunnable.mRun = true;
        Thread thread = new Thread(encodingprocessrunnable);
        thread.start();
        for (; mProducer.isRecordingStarted() && !mTerminateImmediately; process(encodingprocessrunnable, true)) { }
        SLog.d("[ML] Flushing...");
        if (!mTerminateImmediately)
        {
            process(encodingprocessrunnable, false);
        } else
        {
            SLog.d("Terminate without saving....");
        }
        mByteBufferQueue.endOfPut();
        SLog.d("[ML] Waiting for encoding prcess thread to end...");
        try
        {
            thread.join();
        }
        catch (InterruptedException interruptedexception)
        {
            SLog.e("Interrupted.");
        }
        SLog.d("[ML] Encoding process thread ended");
        FileUtils.deleteQuietly(new File(mEncodingTempPath));
        if (mAsyncTask != null)
        {
            mAsyncTask.publish(90);
        }
        SLog.d("Time used: rgb: {}, matrix: {}, encode: {}, n: {}, max: {}.", new Object[] {
            Long.valueOf(timeToRGB), Long.valueOf(timeToMatrix), Long.valueOf(timeToRecord), Integer.valueOf(mTotalProcessed), Integer.valueOf(mMaxEncodedSize)
        });
        mLastSegment = null;
        CrashUtil.log("[ML] Processing Ended: {}.", new Object[] {
            mOutput
        });
        sRunningInstances--;
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






}
