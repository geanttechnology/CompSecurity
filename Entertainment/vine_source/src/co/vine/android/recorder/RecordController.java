// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioRecord;
import android.os.Looper;
import android.os.Process;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import co.vine.android.VineLoggingException;
import co.vine.android.VineNotSupportedException;
import co.vine.android.service.ResourceService;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package co.vine.android.recorder:
//            CameraManager, VideoData, BasicVineRecorder, PictureConverter, 
//            RecordSegment, CameraSetting, RecordingFile, RecordConfigUtils, 
//            HwCombiningRunnable, SwVineFrameRecorder, AbstractCombiningRunnable, SwCombiningRunnable, 
//            RecordSession, AbstractEncodingRunnable, ByteBufferQueue, HwEncodingRunnable, 
//            SwEncodingRunnable, BaseFinishProcessTask, AudioArray, AudioData

public class RecordController
    implements android.view.TextureView.SurfaceTextureListener, android.hardware.Camera.PreviewCallback, android.view.SurfaceHolder.Callback, android.hardware.Camera.AutoFocusCallback
{
    public class AudioRecordRunnable
        implements Runnable
    {

        public boolean forceQuit;
        public volatile boolean isInitialized;
        private AudioArray mAudioDataBuffer;
        private final AudioRecord mAudioRecord;
        private int mCount;
        private final String mOutput;
        final RecordController this$0;

        private void record(RecordSegment recordsegment, AudioArray audioarray, int i)
        {
            audioarray.putInto(mAudioDataBufferMax, mCount, i);
            recordsegment.addAudioData(new AudioData(mCount, i));
            mCount = mCount + i;
        }

        public void run()
        {
            AudioArray.AudioArrayType audioarraytype;
            Process.setThreadPriority(-19);
            SLog.d("mAudioRecord.startRecording()");
            if (mHardwareEncoding)
            {
                audioarraytype = AudioArray.AudioArrayType.BYTE;
            } else
            {
                audioarraytype = AudioArray.AudioArrayType.SHORT;
            }
            mAudioDataBuffer = ResourceService.getAudioDataBuffer(audioarraytype);
            SLog.d("Buffer size {}.", Integer.valueOf(mAudioDataBuffer.length));
            isInitialized = false;
            while (mAudioRecord.getState() == 0) 
            {
                try
                {
                    Thread.sleep(100L);
                }
                catch (InterruptedException interruptedexception) { }
            }
            isInitialized = true;
            CrashUtil.log("mAudioRecord.isInitialized: {}.", new Object[] {
                mOutput
            });
            mAudioRecord.startRecording();
_L5:
            if ((mRunAudioThread || mVideoTimestamp > mAudioTimestamp) && !mIsRecordingEnded && !forceQuit) goto _L2; else goto _L1
_L1:
            ResourceService.releaseAudioBuffer(audioarraytype);
            SLog.d("AudioThread Finished, release mAudioRecord");
            mAudioRecord.stop();
            mAudioRecord.release();
            isInitialized = false;
            CrashUtil.log("mAudioRecord released: {} {} {}.", new Object[] {
                Boolean.valueOf(mRunAudioThread), Boolean.valueOf(mIsRecordingEnded), mOutput
            });
            return;
_L2:
            int i;
            updateTimestamp();
            i = mAudioDataBuffer.readFrom(mAudioRecord, mAudioDataBuffer.length);
            if (i != -3)
            {
                break; /* Loop/switch isn't completed */
            }
            SLog.d((new StringBuilder()).append("Audio Record in invalid state: (valid = 3) ").append(mAudioRecord.getState()).toString());
            if (true) goto _L1; else goto _L3
_L3:
            if (i <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj;
            if (mAudioTrim)
            {
                i = (int)Math.min((double)(mVideoTimestamp - mAudioTimestamp) * 0.0441D + 1.0D, i);
            }
            if (i <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = mCurrentSegment;
            if (obj != null && recordingAudio)
            {
                record(((RecordSegment) (obj)), mAudioDataBuffer, i);
                mLastAudioRecordingSegment = ((RecordSegment) (obj));
            } else
            {
                RecordSegment recordsegment1 = mLastAudioRecordingSegment;
                RecordSegment recordsegment = recordsegment1;
                if (recordsegment1 == null)
                {
                    recordsegment = mLastVideoSegment;
                }
                if (mVideoTimestamp > mAudioTimestamp)
                {
                    if (recordsegment == null)
                    {
                        SLog.e("Recording have not started yet? {} vs {}.", Long.valueOf(mVideoTimestamp), Long.valueOf(mAudioTimestamp));
                    } else
                    {
                        record(recordsegment, mAudioDataBuffer, i);
                    }
                }
            }
            if (mParent == null) goto _L1; else goto _L4
_L4:
            obj = mParent.getConfig();
            if (obj != null && mAudioTimestamp < (long)(((RecordConfigUtils.RecordConfig) (obj)).maxDuration * 1000)) goto _L5; else goto _L1
        }

        public void updateTimestamp()
        {
            if (RecordController.this.mOutput != null)
            {
                int i = RecordConfigUtils.getTimeStampInNsFromSampleCounted(mCount);
                if (mAudioTimestamp != (long)i)
                {
                    mAudioTimestamp = (long)i;
                    mAudioTimeRecorded = System.nanoTime();
                }
            }
        }

        private AudioRecordRunnable(String s, int i)
        {
            this$0 = RecordController.this;
            super();
            mAudioRecord = new AudioRecord(1, 44100, 16, 2, RecordConfigUtils.AUDIO_RUNNABLE_SAMPLE_SIZE);
            mCount = i;
            mOutput = s;
        }

    }

    public class GhostUpdateRunnable
        implements Runnable
    {

        final RecordController this$0;

        public void run()
        {
            initializeGhostBitmapsIfNeeded();
            updateGhostBitmap(true);
        }

        public GhostUpdateRunnable()
        {
            this$0 = RecordController.this;
            super();
        }
    }

    public static interface OnRecorderControllerStateChangedListener
    {

        public abstract void onCameraReady(RecordController recordcontroller);

        public abstract void onSurfaceReady(RecordController recordcontroller);
    }

    public static class RecordControllerReadyStartedException extends Exception
    {

        public RecordControllerReadyStartedException()
        {
        }
    }


    private static WeakReference sByteBufferQueue;
    private static ByteBufferQueue sByteBufferQueueReal;
    public static long sMaxKnownStopTime;
    private volatile boolean isRecordingStarted;
    private AudioArray mAudioDataBufferMax;
    private AudioRecordRunnable mAudioRunnable;
    private Thread mAudioThread;
    private volatile long mAudioTimeRecorded;
    private volatile long mAudioTimestamp;
    private boolean mAudioTrim;
    private boolean mAutoFocus;
    private final CameraManager mCameraManager = CameraManager.getInstance();
    private final Context mContext;
    private volatile RecordSegment mCurrentSegment;
    private boolean mCurrentSegmentEverReceivedFrames;
    private final ConcurrentLinkedQueue mDataQueue = new ConcurrentLinkedQueue();
    private AbstractEncodingRunnable mEncodingRunnable;
    private boolean mEncodingThreadWasRunning;
    private final boolean mFastEncoding;
    private BaseFinishProcessTask mFinishProcessTask;
    private boolean mFlash;
    private int mFrameRate;
    private long mFrameTime;
    private Bitmap mGhostBitmap;
    private Canvas mGhostCanvas;
    private VideoData mGhostFrame;
    private final boolean mHardwareEncoding;
    private CameraManager.InvalidPreviewSizeException mInvalidPreviewSizeException;
    private boolean mIsFocusing;
    private boolean mIsRecordingEnded;
    private RecordSegment mLastAudioRecordingSegment;
    private long mLastAudioTimestamp;
    private CameraSetting mLastCameraSetting;
    private VideoData mLastFrame;
    private VideoData mLastLastFrame;
    private RecordSegment mLastVideoSegment;
    private String mOutput;
    public BasicVineRecorder mParent;
    private Thread mProcessThread;
    private int mRotation;
    private volatile boolean mRunAudioThread;
    private RecordSession mSession;
    private boolean mSessionFeatureDisabled;
    private long mStartTime;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceTexture mSurfaceTexture;
    private TextureView mTextureView;
    private final boolean mUseMp4;
    private byte mVideoDataBufferMax[];
    private final int mVideoRecordLock[] = new int[0];
    private long mVideoTimestamp;
    private volatile boolean recordingAudio;

    public RecordController(BasicVineRecorder basicvinerecorder, Activity activity, boolean flag, boolean flag1, boolean flag2)
    {
        mRunAudioThread = true;
        isRecordingStarted = false;
        mFlash = false;
        mAutoFocus = true;
        mIsFocusing = false;
        mAudioTrim = false;
        mParent = basicvinerecorder;
        mHardwareEncoding = flag;
        mFastEncoding = flag1;
        mContext = activity.getApplicationContext();
        mCameraManager.setController(this);
        mUseMp4 = flag2;
    }

    private void clearLastFrames()
    {
        synchronized (mVideoRecordLock)
        {
            if (mLastFrame != null && !mCameraManager.isFrameAdded(mLastFrame.data))
            {
                SLog.d("[START] AHAHHHH");
                mCameraManager.addBuffer(mLastFrame.data, false);
                mLastFrame = null;
            }
            if (mLastLastFrame != null && !mCameraManager.isFrameAdded(mLastLastFrame.data))
            {
                SLog.d("[START] AHAHHHH");
                mCameraManager.addBuffer(mLastLastFrame.data, false);
                mLastLastFrame = null;
            }
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void onSurfaceCreated()
    {
        SLog.d("Surface created...");
        mParent.onSurfaceReady(this);
    }

    private void onSurfaceDestroyed()
    {
        mSurfaceTexture = null;
        mSurface = null;
    }

    private void onSurfaceUpdated()
    {
        if (!isRecordingStarted && mCameraManager.isPreviewing())
        {
            SLog.d("Surface updated. mCameraManager is previewing...");
            try
            {
                mCameraManager.stopPreview();
            }
            catch (Exception exception) { }
            if (!mCameraManager.isPreviewing())
            {
                startPreview();
            }
        }
    }

    private void updateGhostBitmap(boolean flag)
    {
        PictureConverter pictureconverter = ResourceService.getPictureConverter();
        int ai[] = pictureconverter.LOCK;
        ai;
        JVM INSTR monitorenter ;
        CameraSetting camerasetting = mGhostFrame.segment.getCameraSetting();
        boolean flag1 = pictureconverter.updateSettingsIfNeeded(camerasetting);
        pictureconverter.giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(camerasetting.degrees, camerasetting.frontFacing);
        if (!pictureconverter.convert(camerasetting, mGhostFrame, flag1))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        pictureconverter.draw(mGhostCanvas);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (mParent != null)
        {
            mParent.updateGhostBitmap(mGhostBitmap);
        }
        ai;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable writeToFile(ArrayList arraylist, byte abyte0[], AudioArray audioarray, boolean flag, int i)
    {
        try
        {
            SLog.i("Write to file: {}", Boolean.valueOf(flag));
            while (mAudioRunnable != null && mAudioRunnable.isInitialized) 
            {
                Thread.sleep(20L);
            }
        }
        catch (InterruptedException interruptedexception)
        {
            SLog.d("No...");
        }
        if (!mHardwareEncoding) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        Object obj = RecordConfigUtils.newVideoRecorder(mContext, (new StringBuilder()).append(mParent.getFile().getPreviewVideoPath()).append(".temp_video.mp4").toString(), i);
_L5:
        return (new HwCombiningRunnable(mParent.getFile(), flag, audioarray, abyte0, arraylist, ((HwVineFrameRecorder) (obj)), mFinishProcessTask)).combineVideos();
_L4:
        obj = RecordConfigUtils.newVideoRecorder(mContext, (new StringBuilder()).append(mOutput).append(".video.mp4").toString(), i);
        if (true) goto _L5; else goto _L2
_L2:
        if (!flag) goto _L7; else goto _L6
_L6:
        obj = RecordConfigUtils.newVideoRecorder((new StringBuilder()).append(mParent.getFile().getPreviewVideoPath()).append(".temp_video").append(RecordConfigUtils.VIDEO_CONTAINER_EXT).toString(), i, 480, mUseMp4);
_L9:
        ((SwVineFrameRecorder) (obj)).start();
        return (new SwCombiningRunnable(mParent.getFile(), flag, audioarray, abyte0, arraylist, ((SwVineFrameRecorder) (obj)), mFinishProcessTask, getPreviewBitmap(), getFrameBuffer()) {

            final RecordController this$0;

            
            {
                this$0 = RecordController.this;
                super(recordingfile, flag, audioarray, abyte0, arraylist, swvineframerecorder, basefinishprocesstask, bitmap, iplimage);
            }
        }).combineVideos();
_L7:
        obj = RecordConfigUtils.newVideoRecorder(mOutput, i, 480, mUseMp4);
        if (true) goto _L9; else goto _L8
_L8:
        arraylist;
        CrashUtil.logException(arraylist, "failed to write to file. ", new Object[0]);
        return null;
    }

    public void autoFocus(int i, int j)
    {
        if (!mIsFocusing && mCameraManager.setFocusAreas(i, j) && mCameraManager.autoFocus(this))
        {
            mIsFocusing = true;
            mParent.showFocusIndicator(i, j);
        }
    }

    public boolean canChangeFocus()
    {
        return mCameraManager.canChangeFocus();
    }

    public void finishLastIfNeeded()
        throws Exception
    {
        try
        {
            if (mProcessThread != null)
            {
                mProcessThread.join();
            }
        }
        catch (InterruptedException interruptedexception) { }
        mEncodingThreadWasRunning = false;
    }

    public CameraSetting getCameraSetting()
    {
        return mCameraManager.getCameraSetting();
    }

    public BaseFinishProcessTask getFinishProcessTask()
    {
        return mFinishProcessTask;
    }

    public com.googlecode.javacv.cpp.opencv_core.IplImage getFrameBuffer()
    {
        return ResourceService.getFrameImage();
    }

    public Bitmap getPreviewBitmap()
    {
        return ResourceService.getPreviewBitmap();
    }

    public long getTimestamp()
    {
        SLog.i("Recorder Timestamp: {}.", Long.valueOf(mAudioTimestamp));
        return mAudioTimestamp / 1000L;
    }

    protected void initializeGhostBitmapsIfNeeded()
    {
        if (mGhostBitmap == null)
        {
            mGhostBitmap = RecordConfigUtils.createDefaultSizeBitmap();
            mGhostCanvas = new Canvas(mGhostBitmap);
        }
    }

    public void invalidateGhostFrame()
    {
        mGhostFrame = null;
    }

    public boolean isAudioReady()
    {
        return mAudioRunnable != null && mAudioRunnable.isInitialized;
    }

    public boolean isCameraReady()
    {
        return mCameraManager.isCameraReady();
    }

    public boolean isFlashSupported()
    {
        return mCameraManager.isFlashSupported();
    }

    public boolean isPreviewing()
    {
        return mCameraManager.isPreviewing();
    }

    public boolean isRecording()
    {
        return mCurrentSegment != null;
    }

    public boolean isRecordingStarted()
    {
        return isRecordingStarted;
    }

    public boolean isSurfaceReady()
    {
        return mSurfaceTexture != null || mSurface != null;
    }

    public void logPreviewSizeExceptionIfNeeded()
    {
        if (mInvalidPreviewSizeException != null)
        {
            CrashUtil.logException(mInvalidPreviewSizeException);
        }
    }

    public void makePreview(RecordSegment recordsegment, boolean flag)
    {
        if (flag)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (recordsegment.videoPath != null && (new File(recordsegment.videoPath)).exists())
        {
            break MISSING_BLOCK_LABEL_195;
        }
        Object obj;
        obj = (new StringBuilder()).append(mParent.getFile().getPreviewVideoPath()).append(".temp_video").append(RecordConfigUtils.VIDEO_CONTAINER_EXT).toString();
        if (!mHardwareEncoding)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        int i = recordsegment.getCameraSetting().frameRate;
        obj = RecordConfigUtils.newVideoRecorder(mContext, ((String) (obj)), i);
        recordsegment = new HwCombiningRunnable(mParent.getFile(), recordsegment, ((HwVineFrameRecorder) (obj)), mFinishProcessTask, flag);
_L1:
        recordsegment = recordsegment.combineVideos();
        if (recordsegment != null)
        {
            try
            {
                recordsegment.run();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RecordSegment recordsegment)
            {
                CrashUtil.logException(recordsegment, "Cannot make previews", new Object[0]);
            }
        }
        break MISSING_BLOCK_LABEL_195;
        obj = RecordConfigUtils.newVideoRecorder(((String) (obj)), recordsegment.getCameraSetting().frameRate, 480, mUseMp4);
        ((SwVineFrameRecorder) (obj)).start();
        recordsegment = new SwCombiningRunnable(mParent.getFile(), recordsegment, ((SwVineFrameRecorder) (obj)), mFinishProcessTask, getPreviewBitmap(), getFrameBuffer(), flag);
          goto _L1
    }

    public void modifyAntiBanding(boolean flag)
    {
        mCameraManager.modifyAntiBanding(flag);
    }

    public void modifyColorEffects(boolean flag)
    {
        mCameraManager.modifyColorEffects(flag);
    }

    public void modifyExposure(boolean flag)
    {
        mCameraManager.modifyExposure(flag);
    }

    public void modifySceneMode(boolean flag)
    {
        mCameraManager.modifySceneMode(flag);
    }

    public void modifyWhiteBalance(boolean flag)
    {
        mCameraManager.modifyWhiteBalance(flag);
    }

    public void modifyZoom(boolean flag)
    {
        mCameraManager.modifyZoom(flag);
    }

    public void offerLastFrame(RecordSegment recordsegment, VideoData videodata)
    {
        int ai[] = mVideoRecordLock;
        ai;
        JVM INSTR monitorenter ;
        if (mLastFrame == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        mVideoTimestamp = mVideoTimestamp + mFrameTime;
        if (mLastFrame.timestamp > mVideoTimestamp)
        {
            mVideoTimestamp = mLastFrame.timestamp;
        }
        mLastFrame.setSegment(recordsegment);
        recordsegment.getVideoData().add(mLastFrame);
        mDataQueue.offer(mLastFrame);
        ByteBuffer bytebuffer = mCameraManager.getSharedByteBuffer();
        bytebuffer.rewind();
        bytebuffer.put(mLastFrame.data);
        mGhostFrame = new VideoData(0L, bytebuffer.array());
        mGhostFrame.setSegment(recordsegment);
        mLastVideoSegment = recordsegment;
        SLog.d("Video timestamp {}, actual {}, segment: {}", Long.valueOf(mVideoTimestamp), Long.valueOf(mLastFrame.timestamp), recordsegment);
        mLastFrame = videodata;
_L2:
        return;
        CrashUtil.log((new StringBuilder()).append("Offer last frame failed, did we ever got a frame? ").append(mCurrentSegmentEverReceivedFrames).append(", are we in controller? ").append(mCameraManager.getControllerId()).append(" - ").append(this).toString());
        if (true) goto _L2; else goto _L1
_L1:
        recordsegment;
        ai;
        JVM INSTR monitorexit ;
        throw recordsegment;
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        mIsFocusing = false;
        mParent.onAutoFocusComplete(flag);
    }

    public void onPause()
    {
        setRecording(null);
        releaseCameraAndPreview("onPause");
        mCameraManager.setController(null);
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        long l;
        l = 0L;
        mCurrentSegmentEverReceivedFrames = true;
        if (SLog.sLogsOn)
        {
            mCameraManager.onPreviewFrameReceived();
        }
        CameraManager.sCameraBufferCount--;
        if (!recordingAudio)
        {
            mParent.receivedFirstFrameAfterStartingPreview();
        }
        if (mAudioTimestamp == 0L)
        {
            if (mStartTime > 0L)
            {
                l = (System.currentTimeMillis() - mStartTime) * 1000L;
            }
        } else
        if (mLastAudioTimestamp == mAudioTimestamp)
        {
            l = mAudioTimestamp + mFrameTime;
        } else
        {
            long l1 = (System.nanoTime() - mAudioTimeRecorded) / 1000L;
            l = l1 + mAudioTimestamp;
            mLastAudioTimestamp = mAudioTimestamp;
            SLog.d("Offset {}.", Long.valueOf(l1));
        }
        if (abyte0 == null)
        {
            mParent.onDeviceNotSupported(new VineLoggingException("Camera is not supported yet."));
            return;
        }
        mCameraManager.removeBufferFromAvailableQueue(abyte0);
        camera = mVideoRecordLock;
        camera;
        JVM INSTR monitorenter ;
        RecordSegment recordsegment = mCurrentSegment;
        if (recordsegment == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        if (mLastFrame != null) goto _L2; else goto _L1
_L1:
        mLastFrame = new VideoData(l, abyte0);
        offerLastFrame(recordsegment, null);
_L3:
        camera;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        camera;
        JVM INSTR monitorexit ;
        throw abyte0;
_L2:
        offerLastFrame(recordsegment, new VideoData(l, abyte0));
          goto _L3
        if (mLastLastFrame != null)
        {
            mCameraManager.addCallbackBuffer(mLastLastFrame.data);
        }
        mLastLastFrame = mLastFrame;
        mLastFrame = new VideoData(l, abyte0);
          goto _L3
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        mSurfaceTexture = surfacetexture;
        onSurfaceCreated();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        onSurfaceDestroyed();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
        mSurfaceTexture = surfacetexture;
        onSurfaceCreated();
        onSurfaceUpdated();
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
        mSurfaceTexture = surfacetexture;
        onSurfaceUpdated();
    }

    public void onZoomUpdated(int i, boolean flag)
    {
        if (mParent != null)
        {
            mParent.onZoomUpdated(i, flag);
        }
    }

    public boolean openDefaultCamera(boolean flag, boolean flag1)
        throws VineNotSupportedException
    {
        long l = System.currentTimeMillis();
        CameraSetting camerasetting = mCameraManager.openDefaultCamera(mParent.getConfig(), flag, mRotation, flag1);
        SLog.d("Camera Open 1 took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        mLastCameraSetting = camerasetting;
        if (camerasetting != null)
        {
            SLog.d("Received camera info.");
            long l1 = System.currentTimeMillis();
            mCameraManager.setPreviewSize(camerasetting.originalW, camerasetting.originalH);
            startPreview();
            SLog.d("Camera Open 2 took {}ms.", Long.valueOf(System.currentTimeMillis() - l1));
            l1 = System.currentTimeMillis();
            mIsFocusing = false;
            mParent.onCameraReady(this);
            SLog.d("Camera Open 3 took {}ms.", Long.valueOf(System.currentTimeMillis() - l1));
            return true;
        } else
        {
            CrashUtil.log("Failed to open camera: {}.", new Object[] {
                Boolean.valueOf(flag)
            });
            return false;
        }
    }

    public void refreshBufferMax(RecordSession recordsession)
    {
        mSession = recordsession;
        mVideoDataBufferMax = mSession.getVideoData();
        mAudioDataBufferMax = mSession.getAudioData();
    }

    public void releaseCallbacks()
    {
        if (mSurfaceHolder != null)
        {
            SLog.d("releasing surface holder callback");
            mSurfaceHolder.removeCallback(this);
        }
        if (mTextureView != null)
        {
            SLog.d("releasing surface holder callback");
            mTextureView.setSurfaceTextureListener(null);
        }
    }

    protected void releaseCameraAndPreview(String s)
    {
        CrashUtil.log("Release camera and preview.");
        mCameraManager.releaseCameraAndPreview((new StringBuilder()).append("Controller ").append(s).toString());
    }

    public void releaseCameraResources()
    {
        mCameraManager.releaseCameraResources();
    }

    public void releaseParent()
    {
        mParent = null;
    }

    public void releaseResources()
    {
        SLog.d("releaseResources");
        mDataQueue.clear();
        mLastAudioRecordingSegment = null;
        mLastVideoSegment = null;
        mEncodingRunnable = null;
        System.gc();
    }

    public void requestGhostDrawing(boolean flag)
    {
label0:
        {
            if (mGhostFrame != null)
            {
                if (!flag)
                {
                    break label0;
                }
                initializeGhostBitmapsIfNeeded();
                updateGhostBitmap(false);
            }
            return;
        }
        (new Thread(new GhostUpdateRunnable())).start();
    }

    public void setAudioTimestamp(int i)
    {
        mAudioTimestamp = i;
    }

    public void setAudioTrim(boolean flag)
    {
        mAudioTrim = flag;
    }

    public void setAutoFocus(boolean flag)
    {
        mAutoFocus = flag;
        if (mAutoFocus)
        {
            if (mCameraManager.isPreviewing())
            {
                mCameraManager.startContinuousAutoFocus(mCameraManager.getParameters());
                return;
            }
            break MISSING_BLOCK_LABEL_106;
        }
        try
        {
            if (mCameraManager.isPreviewing())
            {
                mCameraManager.stopContinuousFocus(mCameraManager.getParameters());
                if (mAutoFocus && !mIsFocusing && mCameraManager.autoFocus(this))
                {
                    mIsFocusing = true;
                    return;
                }
            }
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception, "It's ok if we failed to auto focus here.", new Object[0]);
        }
    }

    public void setFinishProcessTask(BaseFinishProcessTask basefinishprocesstask)
    {
        mFinishProcessTask = basefinishprocesstask;
        if (mEncodingRunnable != null)
        {
            mEncodingRunnable.setAsyncTask(mFinishProcessTask);
        }
    }

    public void setPreviewSurface(View view)
        throws IOException
    {
        mCameraManager.setController(this);
        if (view instanceof TextureView)
        {
            switchSurface((TextureView)view);
        }
        if (view instanceof SurfaceView)
        {
            switchSurface((SurfaceView)view);
        }
    }

    public void setRecording(RecordSegment recordsegment)
    {
        if (isRecordingStarted())
        {
            if (recordsegment != null)
            {
                mCurrentSegmentEverReceivedFrames = false;
                mStartTime = System.currentTimeMillis();
                recordsegment.setCameraSetting(mCameraManager.getCameraSetting());
            }
            mCurrentSegment = recordsegment;
        }
    }

    public void setRecordingAudio(boolean flag)
    {
        recordingAudio = flag;
    }

    public void setSessionFeatureDisabled(boolean flag)
    {
        mSessionFeatureDisabled = flag;
    }

    public void setVideoTimeStamp(long l)
    {
        mVideoTimestamp = l;
    }

    public boolean start(Activity activity, String s, int i, int j)
        throws RecordControllerReadyStartedException
    {
        this;
        JVM INSTR monitorenter ;
        if (!mCameraManager.isCameraReady())
        {
            throw new RuntimeException("You have to choose a camera via open() first.");
        }
        break MISSING_BLOCK_LABEL_28;
        activity;
        this;
        JVM INSTR monitorexit ;
        throw activity;
        Object obj1;
        if (mTextureView == null && mSurfaceHolder == null)
        {
            throw new RuntimeException("You have to set a preview surface via switchSurface first.");
        }
        if (isRecordingStarted)
        {
            throw new RecordControllerReadyStartedException();
        }
        obj1 = mCameraManager.getCameraSetting();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        throw new RuntimeException("Camera is ready but camera setting is null, something is terribly wrong.");
        SLog.d("START Recorder, with ResourceService ready? {}.", Boolean.valueOf(ResourceService.IS_READY));
        finishLastIfNeeded();
_L12:
        long l;
        l = System.currentTimeMillis();
        mIsRecordingEnded = false;
        isRecordingStarted = true;
        if (mAudioRunnable == null || !mAudioRunnable.isInitialized) goto _L2; else goto _L1
_L1:
        Object obj;
        mAudioRunnable.forceQuit = true;
        obj = mAudioThread;
        if (obj == null) goto _L2; else goto _L3
_L3:
        mAudioThread.join();
_L2:
        int k;
        boolean flag;
        mAudioRunnable = new AudioRecordRunnable(s, i);
        SLog.i("Audio recorder initialized with count {}.", Integer.valueOf(i));
        SLog.i("Starting timestamps: {}", Long.valueOf(mVideoTimestamp), Long.valueOf(mAudioTimestamp));
        mRunAudioThread = true;
        clearLastFrames();
        mAudioThread = new Thread(mAudioRunnable, "AudioRunnable");
        mAudioThread.start();
        mStartTime = 0L;
        k = ((CameraSetting) (obj1)).frameRate;
        flag = SwVineFrameRecorder.hasEverSuccessfullyLoaded;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        SwVineFrameRecorder.tryLoad(activity);
_L13:
        Bitmap bitmap;
        Bitmap bitmap1;
        android.graphics.Matrix matrix;
        Canvas canvas;
        Canvas canvas1;
        android.support.v8.renderscript.RenderScript renderscript;
        mAudioRunnable.updateTimestamp();
        mOutput = (new StringBuilder()).append(s).append(".video").append(RecordConfigUtils.VIDEO_CONTAINER_EXT).toString();
        bitmap = getPreviewBitmap();
        mFrameRate = k;
        SLog.d("start 1 took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        bitmap1 = ResourceService.getThumbnailBitmap(activity);
        renderscript = ResourceService.getRenderScript(activity);
        matrix = ResourceService.getThumbnailMatrix(activity);
        canvas = ResourceService.getThumbnailCanvas(activity);
        canvas1 = ResourceService.getPreviewCanvas();
        SLog.d("start 4 took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        obj = ResourceService.getPictureConverter();
        if (obj == null) goto _L5; else goto _L4
_L4:
        ((PictureConverter) (obj)).updateSettingsIfNeeded(((CameraSetting) (obj1)));
_L14:
        SLog.d("start 5 took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (SLog.sLogsOn)
        {
            activity = new android.app.ActivityManager.MemoryInfo();
            ((ActivityManager)mParent.mActivity.getSystemService("activity")).getMemoryInfo(activity);
            SLog.d("[mem] Avaliable bytes: {}.", Long.valueOf(((android.app.ActivityManager.MemoryInfo) (activity)).availMem));
        }
        boolean flag1;
        if (mParent.getConfig().memRatio == 1.0D)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        activity = null;
        if (sByteBufferQueue != null || sByteBufferQueueReal != null) goto _L7; else goto _L6
_L6:
        activity = new ByteBufferQueue(mParent.getConfig().bufferCount, mCameraManager.getFrameSize(), mParent.getMemoryResponder());
        if (i == 0) goto _L9; else goto _L8
_L8:
        sByteBufferQueueReal = activity;
_L16:
        SLog.d("start 6 took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (mCameraManager.isCameraReady()) goto _L11; else goto _L10
_L10:
        CrashUtil.logException(new VineLoggingException("Camera was released already. "));
        mAudioRunnable.forceQuit = true;
        flag1 = false;
_L15:
        this;
        JVM INSTR monitorexit ;
        return flag1;
        obj;
        SLog.d("Finish last if needed Failed.", ((Throwable) (obj)));
          goto _L12
        obj;
        SLog.e("Error join audio thread.");
          goto _L2
        obj;
        CrashUtil.logException(((Throwable) (obj)), "Failed to load native libraries.", new Object[0]);
          goto _L13
_L5:
        obj = new PictureConverter(renderscript, 480, ((CameraSetting) (obj1)));
        ResourceService.setPictureConverter(((PictureConverter) (obj)));
          goto _L14
        activity;
        mParent.onDeviceNotSupported(new VineLoggingException("Camera is not supported yet."));
        flag1 = false;
          goto _L15
_L9:
        sByteBufferQueue = new WeakReference(activity);
          goto _L16
_L7:
        if (i == 0) goto _L18; else goto _L17
_L17:
        activity = sByteBufferQueueReal;
_L20:
        if (activity != null)
        {
            break MISSING_BLOCK_LABEL_785;
        }
        activity = new ByteBufferQueue(mParent.getConfig().bufferCount, mCameraManager.getFrameSize(), mParent.getMemoryResponder());
        sByteBufferQueue = new WeakReference(activity);
          goto _L16
_L18:
        if (sByteBufferQueue == null) goto _L20; else goto _L19
_L19:
        activity = (ByteBufferQueue)sByteBufferQueue.get();
          goto _L20
        activity.reset(mParent.getConfig().bufferCount, mCameraManager.getFrameSize());
          goto _L16
_L11:
        if (!mHardwareEncoding)
        {
            break MISSING_BLOCK_LABEL_915;
        }
        obj1 = ResourceService.getFrameBuffer();
        mEncodingRunnable = new HwEncodingRunnable(mContext, mDataQueue, mVideoDataBufferMax, this, s, k, ((ByteBuffer) (obj1)), bitmap, bitmap1, ((PictureConverter) (obj)), j, mCameraManager, activity, matrix, canvas, canvas1);
_L21:
        mProcessThread = new Thread(mEncodingRunnable, "EncodingRunnable");
        mProcessThread.start();
        SLog.d("start 7 took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        flag1 = true;
          goto _L15
        mEncodingRunnable = new SwEncodingRunnable(mDataQueue, mVideoDataBufferMax, this, s, k, getFrameBuffer(), bitmap, bitmap1, ((PictureConverter) (obj)), j, mCameraManager, activity, matrix, canvas, canvas1, mUseMp4);
          goto _L21
    }

    public void startPreview()
    {
        Object obj;
        RecordConfigUtils.RecordConfig recordconfig;
        if (!mCameraManager.isCameraReady() || mCameraManager.isPreviewing())
        {
            break MISSING_BLOCK_LABEL_425;
        }
        obj = mCameraManager.getCameraSetting();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        obj.frameRate = mCameraManager.setFrameRate(((CameraSetting) (obj)).originalFrameRate);
        if (((CameraSetting) (obj)).frameRate <= 0)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        recordconfig = mParent.getConfig();
        mFrameTime = 0xf4240L / (long)((CameraSetting) (obj)).frameRate;
        SLog.d("Determined frame rate: {}, frame time: {}.", Integer.valueOf(((CameraSetting) (obj)).frameRate), Long.valueOf(mFrameTime));
        if (mTextureView != null)
        {
            mCameraManager.startPreview(recordconfig, mSurfaceTexture, mFlash, mAutoFocus, ((CameraSetting) (obj)).frameRate, mRotation, (int)(mAudioTimestamp / 1000L));
            return;
        }
        try
        {
            mCameraManager.startPreview(recordconfig, mSurface, mFlash, mAutoFocus, ((CameraSetting) (obj)).frameRate, mRotation, (int)(mAudioTimestamp / 1000L));
            return;
        }
        catch (CameraManager.InvalidPreviewSizeException invalidpreviewsizeexception)
        {
            obj.originalH = 240;
            obj.originalW = 320;
            CrashUtil.log((new StringBuilder()).append("CAUGHT INVALID PREVIEW SIZE, trying to use a smaller size again: ").append(((CameraSetting) (obj)).originalW).append(" * ").append(((CameraSetting) (obj)).originalH).append(" ff: ").append(((CameraSetting) (obj)).frontFacing).toString());
            if (mParent != null && mParent.mActivity != null)
            {
                Point point = SystemUtil.getDisplaySize(mParent.mActivity);
                CrashUtil.log("Screen size: {} * {}", new Object[] {
                    Integer.valueOf(point.x), Integer.valueOf(point.y)
                });
            }
            mCameraManager.printSupportedPreviewSizes();
            mInvalidPreviewSizeException = invalidpreviewsizeexception;
            mCameraManager.setPreviewSize(((CameraSetting) (obj)).originalW, ((CameraSetting) (obj)).originalH);
        }
        try
        {
            if (mTextureView != null)
            {
                mCameraManager.startPreview(recordconfig, mSurfaceTexture, mFlash, mAutoFocus, ((CameraSetting) (obj)).frameRate, mRotation, (int)(mAudioTimestamp / 1000L));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        mCameraManager.startPreview(recordconfig, mSurface, mFlash, mAutoFocus, ((CameraSetting) (obj)).frameRate, mRotation, (int)(mAudioTimestamp / 1000L));
    }

    public co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable stop(boolean flag, boolean flag1)
    {
        Object obj;
        Object obj1;
        Object obj3;
        Object obj4;
        co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable generatethumbnailsrunnable;
        Object obj5;
        Object obj6;
        Object obj7;
        if (!isRecordingStarted && SLog.sLogsOn)
        {
            throw new IllegalStateException("You can't stop before you have start it.");
        }
        obj5 = null;
        obj4 = null;
        generatethumbnailsrunnable = null;
        obj3 = null;
        obj7 = null;
        obj6 = null;
        obj = obj5;
        obj1 = obj7;
        long l = System.currentTimeMillis();
        obj = obj5;
        obj1 = obj7;
        CrashUtil.log("Stop audio runnable and recording.");
        obj = obj5;
        obj1 = obj7;
        mRunAudioThread = false;
        Object obj2;
        obj2 = generatethumbnailsrunnable;
        obj = obj5;
        obj1 = obj7;
        if (!isRecordingStarted) goto _L2; else goto _L1
_L1:
        obj = obj5;
        obj1 = obj7;
        SLog.d("Finishing recording, calling stop and release on recorder");
        if (!flag1) goto _L4; else goto _L3
_L3:
        obj = obj5;
        obj1 = obj7;
        if (!mFastEncoding) goto _L6; else goto _L5
_L5:
        obj = obj5;
        obj1 = obj7;
        obj2 = new Thread(new Runnable() {

            final RecordController this$0;

            public void run()
            {
                releaseCameraAndPreview("Stop on thread.");
            }

            
            {
                this$0 = RecordController.this;
                super();
            }
        });
        ((Thread) (obj2)).start();
        obj4 = obj2;
_L9:
        obj = obj5;
        obj1 = obj4;
        SLog.d("Waiting...........");
        obj = obj5;
        obj1 = obj4;
        isRecordingStarted = false;
        if (!flag) goto _L8; else goto _L7
_L7:
        obj = obj5;
        obj1 = obj4;
        if (mEncodingRunnable == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        obj = obj5;
        obj1 = obj4;
        mEncodingRunnable.terminate();
        obj = obj5;
        obj1 = obj4;
        if (mProcessThread == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        obj = obj5;
        obj1 = obj4;
        mProcessThread.interrupt();
        finishLastIfNeeded();
        obj3 = obj4;
        obj2 = generatethumbnailsrunnable;
_L2:
        obj = obj2;
        obj1 = obj3;
        mIsRecordingEnded = true;
        obj1 = obj3;
        obj = obj2;
_L10:
        isRecordingStarted = false;
        if (flag1)
        {
            releaseCameraAndPreview("Force stop");
        } else
        {
            clearLastFrames();
            mCameraManager.setController(null);
        }
        if (mFinishProcessTask != null)
        {
            mFinishProcessTask.publish(100);
        }
        if (obj1 != null)
        {
            try
            {
                ((Thread) (obj1)).join();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                SLog.e("Camera still not released?!");
            }
        }
        SLog.d("Recorder is stopped.");
        return ((co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable) (obj));
_L6:
        obj = obj5;
        obj1 = obj7;
        releaseCameraAndPreview("Stop");
        obj4 = obj6;
          goto _L9
        obj2;
_L13:
        CrashUtil.logException(((Throwable) (obj2)), "Stop failed", new Object[0]);
          goto _L10
_L4:
        obj = obj5;
        obj1 = obj7;
        mCameraManager.setController(null);
        obj4 = obj6;
          goto _L9
        obj2;
        obj = obj5;
        obj1 = obj4;
        CrashUtil.logException(((Throwable) (obj2)), "discard failed.", new Object[0]);
        obj2 = generatethumbnailsrunnable;
        obj3 = obj4;
          goto _L2
_L8:
        obj = obj5;
        obj1 = obj4;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            break MISSING_BLOCK_LABEL_458;
        }
        obj = obj5;
        obj1 = obj4;
        mEncodingThreadWasRunning = true;
        obj2 = generatethumbnailsrunnable;
        obj3 = obj4;
          goto _L2
        obj = obj5;
        obj1 = obj4;
        if (mParent.canKeepRecording())
        {
            break MISSING_BLOCK_LABEL_487;
        }
        obj = obj5;
        obj1 = obj4;
        mEncodingThreadWasRunning = true;
        obj = obj5;
        obj1 = obj4;
        finishLastIfNeeded();
        obj2 = generatethumbnailsrunnable;
        obj3 = obj4;
        obj = obj5;
        obj1 = obj4;
        if (mParent.canKeepRecording()) goto _L2; else goto _L11
_L11:
        obj = obj5;
        obj1 = obj4;
        System.gc();
        obj = obj5;
        obj1 = obj4;
        generatethumbnailsrunnable = writeToFile(false);
        obj = generatethumbnailsrunnable;
        obj1 = obj4;
        l = System.currentTimeMillis() - l;
        obj = generatethumbnailsrunnable;
        obj1 = obj4;
        SLog.i("Stop wait time: {}.", Long.valueOf(l));
        obj2 = generatethumbnailsrunnable;
        obj3 = obj4;
        obj = generatethumbnailsrunnable;
        obj1 = obj4;
        if (l <= sMaxKnownStopTime) goto _L2; else goto _L12
_L12:
        obj = generatethumbnailsrunnable;
        obj1 = obj4;
        sMaxKnownStopTime = l;
        obj2 = generatethumbnailsrunnable;
        obj3 = obj4;
          goto _L2
        Exception exception;
        exception;
        obj1 = obj2;
        obj2 = exception;
        exception = ((Exception) (obj4));
          goto _L13
    }

    public void stopZoom()
    {
        mCameraManager.stopSmoothZoom();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        mSurfaceHolder = surfaceholder;
        mSurface = surfaceholder.getSurface();
        onSurfaceCreated();
        onSurfaceUpdated();
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        mSurfaceHolder = surfaceholder;
        mSurface = surfaceholder.getSurface();
        onSurfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        onSurfaceDestroyed();
    }

    public void swapSession()
    {
        mSession = mParent.getFile().getSession();
        mVideoDataBufferMax = mSession.getVideoData();
        mAudioDataBufferMax = mSession.getAudioData();
        mCurrentSegment = null;
        clearLastFrames();
        mLastLastFrame = null;
        mLastVideoSegment = null;
        mLastAudioRecordingSegment = null;
        mIsRecordingEnded = false;
        mOutput = null;
        if (mAudioThread != null && mAudioRunnable != null)
        {
            if (mAudioRunnable.isInitialized)
            {
                CrashUtil.log("Force quit audio runnable.");
                mAudioRunnable.forceQuit = true;
            }
            try
            {
                mAudioThread.join();
            }
            catch (InterruptedException interruptedexception) { }
        }
        mAudioThread = null;
        mAudioRunnable = null;
        mGhostFrame = null;
    }

    public void switchFlash()
    {
        boolean flag;
        if (!mFlash)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFlash = flag;
        mCameraManager.changeFlashState(mFlash);
    }

    public void switchImageStabilization()
    {
        mCameraManager.switchImageStabilization();
    }

    public void switchSurface(SurfaceView surfaceview)
        throws IOException
    {
        mSurfaceHolder = surfaceview.getHolder();
        mSurfaceHolder.addCallback(this);
    }

    public void switchSurface(TextureView textureview)
        throws IOException
    {
        mTextureView = textureview;
        mTextureView.setSurfaceTextureListener(this);
        if (mTextureView.isAvailable())
        {
            onSurfaceTextureAvailable(textureview.getSurfaceTexture(), textureview.getWidth(), textureview.getHeight());
        }
    }

    public void updateRotation(Activity activity)
    {
        mRotation = CameraManager.getCameraRotation(activity);
    }

    public void waitForPreviewToStart()
    {
        mCameraManager.waitForPreviewToStart();
    }

    public boolean wasEncodingThreadRunning()
    {
        return mEncodingThreadWasRunning;
    }

    public co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable writeToFile(boolean flag)
    {
        RecordSession recordsession = mParent.getFile().getSession();
        return writeToFile(recordsession.getSegments(), recordsession.getVideoData(), recordsession.getAudioData(), flag, mLastCameraSetting.frameRate);
    }

    public void writeToFile(ArrayList arraylist, byte abyte0[], AudioArray audioarray, int i)
    {
        arraylist = writeToFile(arraylist, abyte0, audioarray, true, i);
        if (arraylist != null)
        {
            arraylist.run();
        }
    }







/*
    static RecordSegment access$1302(RecordController recordcontroller, RecordSegment recordsegment)
    {
        recordcontroller.mLastAudioRecordingSegment = recordsegment;
        return recordsegment;
    }

*/





/*
    static long access$302(RecordController recordcontroller, long l)
    {
        recordcontroller.mAudioTimestamp = l;
        return l;
    }

*/


/*
    static long access$402(RecordController recordcontroller, long l)
    {
        recordcontroller.mAudioTimeRecorded = l;
        return l;
    }

*/





}
