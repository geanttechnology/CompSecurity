// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import co.vine.android.VineLoggingException;
import co.vine.android.VineNotSupportedException;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import com.googlecode.javacv.cpp.opencv_imgproc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;

// Referenced classes of package co.vine.android.recorder:
//            RecordConfigUtils, RecordController, CameraManager, RecordSegment, 
//            RecordingFile, RecordSessionManager, RecordSession, ReusableHashAsyncTask, 
//            ProgressTimer, RecordSessionVersion, EncoderManager, BaseFinishProcessTask, 
//            AudioData, CameraSetting

public abstract class BasicVineRecorder
    implements RecordController.OnRecorderControllerStateChangedListener, co.vine.android.player.VideoViewInterface.OnErrorListener
{
    private class ChangeProgressRunnable
        implements Runnable
    {

        public int progress;
        final BasicVineRecorder this$0;

        public void run()
        {
            changeProgress(progress);
        }

        private ChangeProgressRunnable()
        {
            this$0 = BasicVineRecorder.this;
            super();
        }

    }

    public class FinishProcessRunnable
    {

        private boolean isResumed;
        final BasicVineRecorder this$0;

        public boolean doNotDeleteSession(boolean flag)
        {
            return flag;
        }

        public boolean isCompleteSession(boolean flag)
        {
            return flag;
        }

        public void onCompleteSessionFinish(boolean flag)
        {
            boolean flag3 = true;
            Object obj = mCurrentRecordingFile;
            if (obj == null)
            {
                CrashUtil.logException(new VineLoggingException("Failed to stop recording."));
            } else
            {
                RecordSession recordsession = ((RecordingFile) (obj)).getSession();
                recordsession.setAudioDataCount(recordsession.calculateAudioCount());
                recordsession.setVideoDataCount(recordsession.calculateVideoCount());
                if (!mDiscardChanges)
                {
                    boolean flag1;
                    boolean flag2;
                    if (mFinished && ((RecordingFile) (obj)).hasData() && !canKeepRecording())
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    mDoNotDeleteSession = doNotDeleteSession(flag2);
                    if (mEditedSegments.size() > 0 && recordsession.getVideoDataCount() > 0)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (mEditedSegments.size() > 0 && !flag1)
                    {
                        CrashUtil.log("Invalid session found.");
                    }
                    if (flag1)
                    {
                        try
                        {
                            RecordSessionManager.writeRecordingFile(((RecordingFile) (obj)), flag);
                        }
                        catch (IOException ioexception1)
                        {
                            if (flag)
                            {
                                throw new RuntimeException(ioexception1);
                            }
                            CrashUtil.log((new StringBuilder()).append("Failed to save the files due to IOException: ").append(ioexception1.getMessage()).toString());
                        }
                    } else
                    if (!mCanKeepRecording)
                    {
                        try
                        {
                            RecordSessionManager.deleteSession(((RecordingFile) (obj)).folder, "Invalid session");
                        }
                        catch (IOException ioexception2)
                        {
                            CrashUtil.log((new StringBuilder()).append("Failed to delete session: ").append(ioexception2.getMessage()).toString());
                        }
                    }
                    if (flag)
                    {
                        if (!((RecordingFile) (obj)).isLastSession)
                        {
                            obj.isSavedSession = true;
                            obj.isDirty = false;
                        }
                        if (flag1)
                        {
                            cleanThumbnails(false);
                        }
                    }
                    if (flag2)
                    {
                        obj = BasicVineRecorder.this;
                        if (!flag1)
                        {
                            flag = flag3;
                        } else
                        {
                            flag = false;
                        }
                        ((BasicVineRecorder) (obj)).startHashTask(flag);
                        return;
                    }
                } else
                {
                    if (!mDoNotDeleteSession && !mCurrentRecordingFile.isSavedSession)
                    {
                        try
                        {
                            CrashUtil.log("Session {} deleted.", new Object[] {
                                mCurrentRecordingFile.folder
                            });
                            RecordSessionManager.deleteSession(mCurrentRecordingFile.folder, "Discard Changes.");
                        }
                        catch (IOException ioexception)
                        {
                            CrashUtil.logException(ioexception, "Failed to delete session.", new Object[0]);
                        }
                    }
                    mToRemove.clear();
                    return;
                }
            }
        }

        public void onIncompleteSessionFinish()
        {
            if (mFinished && !canKeepRecording() && mHashTask != null && !mHashTask.isComplete() && !isResumed)
            {
                isResumed = true;
                mHashTask.resumeAll();
            }
        }

        public boolean onMakeRecordingStop(String s, boolean flag, boolean flag1)
        {
            if (mVideoController != null)
            {
                boolean flag2 = mVideoController.isRecordingStarted();
                CrashUtil.log("Stop recording in VineRecorder from {} : wasRecordingStarted {} releasePreview {} saveSession {} mDiscardChanges {} mDoNotDeleteSession {} mCurrentRecordingFile {}", new Object[] {
                    s, Boolean.valueOf(flag2), Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(mDiscardChanges), Boolean.valueOf(mDoNotDeleteSession), mCurrentRecordingFile
                });
                if (flag2)
                {
                    endRelativeTime();
                    grabThumbnailsRunnable = mVideoController.stop(mDiscardChanges, flag);
                }
                return flag2;
            } else
            {
                return false;
            }
        }

        protected void onPreCompleteSession(boolean flag)
        {
        }

        public void reset()
        {
            isResumed = false;
        }

        public void run(String s, boolean flag, boolean flag1)
        {
            this;
            JVM INSTR monitorenter ;
            flag = onMakeRecordingStop(s, flag, flag1);
            onPreCompleteSession(flag);
            if (!isCompleteSession(flag)) goto _L2; else goto _L1
_L1:
            onCompleteSessionFinish(flag1);
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            onIncompleteSessionFinish();
            if (true) goto _L4; else goto _L3
_L3:
            s;
            throw s;
        }

        public FinishProcessRunnable()
        {
            this$0 = BasicVineRecorder.this;
            super();
        }
    }

    public class FinishProcessTask extends BaseFinishProcessTask
    {

        final BasicVineRecorder this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            mFinishProcessRunnable.run(tag, releasePreview, saveSession);
            return null;
        }

        public FinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
        {
            this$0 = BasicVineRecorder.this;
            super(s, runnable, flag, flag1);
        }
    }

    protected abstract class OnResumeTask extends AsyncTask
    {

        public boolean isRunning;
        protected final View mClicker;
        protected long mStartTime;
        protected final String mTag;
        public boolean showDialogDelayed;
        final BasicVineRecorder this$0;

        protected transient RecordingFile doInBackground(Void avoid[])
        {
            RecordController recordcontroller;
            CrashUtil.log("OnResume task started from {}.", new Object[] {
                mTag
            });
            recordcontroller = mVideoController;
            if (recordcontroller != null) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            if (recordcontroller.wasEncodingThreadRunning())
            {
                publishFinishLastSegmentProgress();
                boolean flag;
                try
                {
                    recordcontroller.finishLastIfNeeded();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    CrashUtil.logException(avoid, "Failed to finish last one.", new Object[0]);
                }
                publishStartProgres();
            }
            stopProgressTimer();
            if (!canKeepRecording())
            {
                break MISSING_BLOCK_LABEL_315;
            }
            CrashUtil.log("Async open camera");
            try
            {
                if (!onMakingSureCameraReady(recordcontroller))
                {
                    continue; /* Loop/switch isn't completed */
                }
                avoid = recordcontroller.getCameraSetting();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                onDeviceNotSupported(avoid);
                return null;
            }
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            mCurrentFrameRate = ((CameraSetting) (avoid)).frameRate;
            if (mHashTask != null)
            {
                mHashTask.reset();
            }
            startProgressTimer();
            CrashUtil.log("Open camera successful: {} fps.", new Object[] {
                Integer.valueOf(mCurrentFrameRate)
            });
            if (mSession == null) goto _L1; else goto _L3
_L3:
            avoid = mSession.getConfig();
_L7:
            if (recordcontroller == null || avoid == null) goto _L1; else goto _L4
_L4:
            if (mCurrentDuration >= (long)((RecordConfigUtils.RecordConfig) (avoid)).maxDuration || recordcontroller.isAudioReady()) goto _L1; else goto _L5
_L5:
            SLog.d((new StringBuilder()).append("Wait for audio to be ready. ").append(this).toString());
            flag = isCancelled();
            if (flag) goto _L1; else goto _L6
_L6:
            try
            {
                Thread.sleep(100L);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            if (mSession == null)
            {
                break MISSING_BLOCK_LABEL_283;
            }
            avoid = mSession.getConfig();
_L8:
            recordcontroller = mVideoController;
              goto _L7
            avoid = null;
              goto _L8
            if (isCancelled()) goto _L1; else goto _L9
_L9:
            showCameraFailedToast();
            return null;
            avoid = mActivity;
            if (mHashTask != null && mHashTask.isComplete() && avoid != null)
            {
                avoid.finish();
                return null;
            }
            if (mHashTask != null && mHashTask.getComputedFile() != null)
            {
                return mHashTask.getComputedFile();
            } else
            {
                startHashTask(false);
                return null;
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected boolean onMakingSureCameraReady(RecordController recordcontroller)
            throws VineNotSupportedException
        {
            return recordcontroller.openDefaultCamera(mFrontFacing, false);
        }

        protected void onPostExecute(RecordingFile recordingfile)
        {
            isRunning = false;
            if (mClicker != null)
            {
                mClicker.setEnabled(true);
            }
            if (recordingfile != null)
            {
                mHashTask.resumeAll();
            }
            long l = System.currentTimeMillis() - mStartTime;
            if (l > BasicVineRecorder.sTimeTaken)
            {
                BasicVineRecorder.sTimeTaken = l;
            }
            SLog.d("OnResumeTask took {}ms.", Long.valueOf(l));
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RecordingFile)obj);
        }

        protected void onPreExecute()
        {
            mStartTime = System.currentTimeMillis();
            if (mClicker != null)
            {
                mClicker.setEnabled(false);
            }
            if (canKeepRecording() && !mVideoController.isRecordingStarted() && !isCancelled())
            {
                try
                {
                    if (showDialogDelayed)
                    {
                        isRunning = true;
                    }
                }
                catch (android.view.WindowManager.BadTokenException badtokenexception) { }
            }
            SLog.d("OnResume PreExecute took {}ms.", Long.valueOf(System.currentTimeMillis() - mStartTime));
        }

        protected abstract void publishFinishLastSegmentProgress();

        protected abstract void publishStartProgres();

        public OnResumeTask(View view, String s)
        {
            this$0 = BasicVineRecorder.this;
            super();
            mClicker = view;
            mTag = s;
        }
    }

    protected class ResumeCameraAsyncTask extends AsyncTask
    {

        private final boolean mSwitchCamera;
        final BasicVineRecorder this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            boolean flag;
            flag = true;
            if (!canSwitchCamera() && (mVideoController.isRecording() || mSwitchCamera))
            {
                break MISSING_BLOCK_LABEL_140;
            }
            System.gc();
            if (!mSwitchCamera)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            avoid = BasicVineRecorder.this;
            if (mFrontFacing)
            {
                flag = false;
            }
            avoid.mFrontFacing = flag;
            if (!mVideoController.openDefaultCamera(mFrontFacing, true))
            {
                break MISSING_BLOCK_LABEL_123;
            }
            avoid = mVideoController.getCameraSetting();
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_109;
            }
            mCurrentFrameRate = ((CameraSetting) (avoid)).frameRate;
            start("Switch camera", false, true);
            break MISSING_BLOCK_LABEL_140;
            try
            {
                showCameraFailedToast();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                SLog.e("Error on cancel camera switching.", avoid);
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            mIsSwitchingCamera = false;
        }

        protected void onPreExecute()
        {
            mIsSwitchingCamera = true;
        }

        public ResumeCameraAsyncTask(boolean flag)
        {
            this$0 = BasicVineRecorder.this;
            super();
            mSwitchCamera = flag;
        }
    }


    public static final String LOG_RECORDER_INIT_COMPLETE = "Recorder fully initialized.";
    public static final String PREFS_CAPTURE = "capture";
    public static long sTimeTaken;
    public boolean detectedInvalidSession;
    public volatile RecordingFile finalFile;
    public co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable grabThumbnailsRunnable;
    protected Activity mActivity;
    protected final ArrayList mAddedSegments = new ArrayList();
    private boolean mAlreadyStoppingForUnspportedReasons;
    protected boolean mAutoFocusing;
    protected View mCameraView;
    protected boolean mCanKeepRecording;
    protected final ChangeProgressRunnable mChangeProgressRunnable = new ChangeProgressRunnable();
    protected volatile long mCurrentDuration;
    protected int mCurrentFrameRate;
    protected RecordingFile mCurrentRecordingFile;
    protected RecordSegment mCurrentSegment;
    public volatile boolean mDiscardChanges;
    protected boolean mDoNotDeleteSession;
    protected final ArrayList mEditedSegments = new ArrayList();
    protected boolean mEnabled;
    protected final boolean mFastEncoding;
    protected final FinishProcessRunnable mFinishProcessRunnable = getFinishProcessRunnable();
    protected boolean mFinished;
    protected boolean mFrontFacing;
    protected final Handler mHandler = new Handler();
    protected final boolean mHardwareEncoding;
    protected ReusableHashAsyncTask mHashTask;
    protected volatile boolean mIsSwitchingCamera;
    protected boolean mNeverResumedRecorder;
    public volatile Runnable mOnCompleteConsumer;
    protected ProgressTimer mProgressTimer;
    protected int mRecordingFileDuration;
    protected OnResumeTask mResumeTask;
    protected RecordSession mSession;
    protected ResumeCameraAsyncTask mSwitchCameraTask;
    protected final int mThresholdMs;
    protected final HashSet mToRemove = new HashSet();
    protected final boolean mUseMp4;
    protected RecordController mVideoController;

    public BasicVineRecorder(int i, Activity activity, boolean flag, boolean flag1, boolean flag2)
    {
        mAutoFocusing = true;
        mEnabled = true;
        mThresholdMs = i;
        mNeverResumedRecorder = true;
        mHardwareEncoding = flag1;
        mFastEncoding = RecordConfigUtils.isFastEncoding(flag1);
        mUseMp4 = flag2;
        mVideoController = new RecordController(this, activity, mHardwareEncoding, mFastEncoding, flag2);
        mActivity = activity;
        if (flag || RecordConfigUtils.isDefaultFrontFacing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFrontFacing = flag;
    }

    protected abstract void adjustBoundaries(CameraSetting camerasetting);

    public boolean canKeepRecording()
    {
        return mCanKeepRecording && !mDiscardChanges;
    }

    public boolean canSwitchCamera()
    {
        return CameraManager.hasFrontFacingCamera() && CameraManager.hasBackFacingCamera() && !mVideoController.isRecording();
    }

    public void changeFocusTo(float f, float f1)
    {
        mVideoController.autoFocus((int)f, (int)f1);
    }

    public abstract void changeProgress(long l);

    public void cleanThumbnails(boolean flag)
    {
        Object obj = new HashSet(mToRemove);
        mToRemove.clear();
        if (flag)
        {
            ((HashSet) (obj)).addAll(mAddedSegments);
        }
        obj = ((HashSet) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = ((RecordSegment)((Iterator) (obj)).next()).getThumbnailPath();
            if (!TextUtils.isEmpty(s))
            {
                FileUtils.deleteQuietly(new File(s));
            }
        } while (true);
    }

    public boolean deleteCurrentDraftFolder(String s)
    {
        try
        {
            RecordSessionManager.deleteSession(mCurrentRecordingFile.folder, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashUtil.logException(s);
            return false;
        }
        return true;
    }

    public boolean endRelativeTime()
    {
        this;
        JVM INSTR monitorenter ;
        if (mCurrentSegment != null)
        {
            CrashUtil.log("END RELATIVE TIME.");
            mVideoController.offerLastFrame(mCurrentSegment, null);
            mRecordingFileDuration = (int)mVideoController.getTimestamp();
            mCurrentRecordingFile.getSession().add(mCurrentSegment);
            mEditedSegments.add(mCurrentSegment);
            mAddedSegments.add(mCurrentSegment);
            mCurrentRecordingFile.isDirty = true;
            mCurrentSegment = null;
            mCurrentDuration = mRecordingFileDuration;
            mVideoController.setRecordingAudio(false);
            mVideoController.setRecording(mCurrentSegment);
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finish(String s)
    {
        mFinished = true;
        if (mVideoController != null && mVideoController.isRecordingStarted())
        {
            stop(s, null, true, false);
            mCanKeepRecording = false;
        } else
        if (mOnCompleteConsumer != null)
        {
            mOnCompleteConsumer.run();
            return;
        }
    }

    public View getCameraView()
    {
        return mCameraView;
    }

    public RecordConfigUtils.RecordConfig getConfig()
    {
        RecordSession recordsession = mSession;
        if (recordsession != null)
        {
            return recordsession.getConfig();
        } else
        {
            return null;
        }
    }

    public long getCurrentDuration()
    {
        return mCurrentDuration;
    }

    public RecordingFile getFile()
    {
        return mCurrentRecordingFile;
    }

    protected FinishProcessRunnable getFinishProcessRunnable()
    {
        return new FinishProcessRunnable();
    }

    public BaseFinishProcessTask getFinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        if (flag1 || mCurrentRecordingFile.isSavedSession)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return new FinishProcessTask(s, runnable, flag, flag1);
    }

    public Handler getHandler()
    {
        return mHandler;
    }

    public ByteBufferQueue.MemoryResponder getMemoryResponder()
    {
        if (mActivity instanceof ByteBufferQueue.MemoryResponder)
        {
            return (ByteBufferQueue.MemoryResponder)mActivity;
        } else
        {
            return null;
        }
    }

    public Runnable getOnCompleteConsumer()
    {
        return mOnCompleteConsumer;
    }

    protected abstract Runnable getOnDeviceNotSupportedAction();

    public abstract OnResumeTask getOnResumeTask(View view, String s);

    public String getThumbnailPath()
    {
        return mCurrentRecordingFile.getThumbnailPath();
    }

    public long getTimestamp()
    {
        return mVideoController.getTimestamp();
    }

    protected void guardedStartRecording(String s)
    {
        if (!mVideoController.isRecordingStarted())
        {
            startRecording(s);
        }
    }

    public boolean hasSessionFile()
    {
        return mCurrentRecordingFile != null;
    }

    public void initPreviewSurface()
    {
        try
        {
            mVideoController.setPreviewSurface(mCameraView);
            return;
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception, "Cannot resume.", new Object[0]);
        }
    }

    protected void invalidateFinishButton()
    {
    }

    public boolean isCurrentlyRecording()
    {
        return mCurrentSegment != null;
    }

    public boolean isFinished()
    {
        return mFinished;
    }

    public boolean isRecordingSegment()
    {
        return mCurrentSegment != null;
    }

    public boolean isResuming()
    {
        OnResumeTask onresumetask = mResumeTask;
        return onresumetask != null && onresumetask.isRunning;
    }

    public boolean isSavedSession()
    {
        return mCurrentRecordingFile.isSavedSession;
    }

    public boolean isSessionDirty()
    {
        return mCurrentRecordingFile.isDirty;
    }

    public void modifyAntiBanding(boolean flag)
    {
        if (mVideoController != null)
        {
            mVideoController.modifyAntiBanding(flag);
        }
    }

    public void modifyColorEffects(boolean flag)
    {
        if (mVideoController != null)
        {
            mVideoController.modifyColorEffects(flag);
        }
    }

    public void modifyExposure(boolean flag)
    {
        if (mVideoController != null)
        {
            mVideoController.modifyExposure(flag);
        }
    }

    public void modifySceneMode(boolean flag)
    {
        if (mVideoController != null)
        {
            mVideoController.modifySceneMode(flag);
        }
    }

    public void modifyWhiteBalance(boolean flag)
    {
        if (mVideoController != null)
        {
            mVideoController.modifyWhiteBalance(flag);
        }
    }

    public void onAutoFocusComplete(boolean flag)
    {
        SLog.d("Auto focus {}.", Boolean.valueOf(flag));
    }

    public void onCameraReady(RecordController recordcontroller)
    {
label0:
        {
            if (mActivity != null)
            {
                if (!mVideoController.isSurfaceReady() || mVideoController.isRecordingStarted())
                {
                    break label0;
                }
                start("Camera ready", false, true);
            }
            return;
        }
        SLog.d("Do not start recording: {} {}", Boolean.valueOf(mVideoController.isSurfaceReady()), Boolean.valueOf(mVideoController.isRecordingStarted()));
    }

    public void onDeviceNotSupported(Throwable throwable)
    {
        if (!mAlreadyStoppingForUnspportedReasons)
        {
            mAlreadyStoppingForUnspportedReasons = true;
            if (throwable != null)
            {
                CrashUtil.logException(throwable);
                CrashUtil.log("Device not supported happened.");
            }
            stopAndDiscardChanges("OnDeviceNotSupported", getOnDeviceNotSupportedAction(), true);
        }
    }

    public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
    {
        return false;
    }

    public void onFinishPressed()
    {
        setHasPreviewedAlreadyIfNeeded();
        finish("onFinishPressed");
    }

    public void onPause()
    {
        mNeverResumedRecorder = false;
        if (mSwitchCameraTask != null)
        {
            mSwitchCameraTask.cancel(true);
        }
        if (mResumeTask != null)
        {
            SLog.d((new StringBuilder()).append("Cancel resume task: ").append(mResumeTask).toString());
            mResumeTask.cancel(true);
        }
        mFinishProcessRunnable.run("onPause", true, false);
        mVideoController.onPause();
        if (mHashTask != null)
        {
            mHashTask.cancel(false);
        }
        if (mProgressTimer != null)
        {
            mProgressTimer.release();
            mProgressTimer = null;
        }
    }

    public void onProgressMaxReached()
    {
    }

    public void onProgressThresholdReached()
    {
    }

    public void onResume(String s, boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = canKeepRecording();
        if (finalFile == null)
        {
            flag1 = false;
        }
        CrashUtil.log("Resume VineRecorder: delayDialog: {} canKeepRecording: {} isEditing: {} NullFinalFile: {}.", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag2), Boolean.valueOf(false), Boolean.valueOf(flag1)
        });
        if (flag2)
        {
            mResumeTask = getOnResumeTask(null, (new StringBuilder()).append("OnResume_").append(s).toString());
            mResumeTask.showDialogDelayed = flag;
            mResumeTask.execute(new Void[0]);
        } else
        if (finalFile != null)
        {
            mOnCompleteConsumer.run();
            return;
        }
    }

    protected abstract boolean onStop();

    public void onSurfaceReady(RecordController recordcontroller)
    {
        if (mVideoController.isCameraReady())
        {
            SLog.d("Start recording on surface ready.");
            if (!mVideoController.isRecordingStarted())
            {
                start("Surface Ready", false, true);
                return;
            }
            if (mVideoController != null)
            {
                adjustBoundaries(mVideoController.getCameraSetting());
            }
            mVideoController.startPreview();
            return;
        } else
        {
            SLog.d("Do not start recording: {} {}.", Boolean.valueOf(false), Boolean.valueOf(mVideoController.isRecordingStarted()));
            return;
        }
    }

    public void onUiPaused()
    {
        mActivity = null;
        mCameraView = null;
        mOnCompleteConsumer = null;
        onPause();
    }

    public void onUiResumed(Activity activity, Runnable runnable, boolean flag)
    {
        mActivity = activity;
        mVideoController.updateRotation(activity);
        mOnCompleteConsumer = runnable;
        mFinishProcessRunnable.reset();
    }

    public void onZoomUpdated(int i, boolean flag)
    {
    }

    public void postProgressUpdate(int i)
    {
        mChangeProgressRunnable.progress = i;
        mHandler.post(mChangeProgressRunnable);
    }

    public void receivedFirstFrameAfterStartingPreview()
    {
    }

    public boolean release()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        CrashUtil.log("Recorder Released.");
        mVideoController.releaseParent();
        mVideoController.releaseCameraResources();
        mVideoController.releaseResources();
        mVideoController.releaseCallbacks();
        mVideoController.logPreviewSizeExceptionIfNeeded();
        flag = false;
        flag1 = false;
        if (mCurrentRecordingFile == null) goto _L2; else goto _L1
_L1:
        File file = mCurrentRecordingFile.folder;
        if (mDoNotDeleteSession || RecordSessionManager.isSessionSaved(file)) goto _L4; else goto _L3
_L3:
        flag = deleteCurrentDraftFolder("release");
_L6:
        SLog.i("Session deleted: {}", Boolean.valueOf(flag));
_L2:
        mSession = null;
        mCurrentRecordingFile = null;
        mCurrentSegment = null;
        mVideoController = null;
        mAddedSegments.clear();
        flag1 = flag2;
        if (mEditedSegments.size() > 0)
        {
            flag1 = flag2;
            if (flag)
            {
                flag1 = true;
            }
        }
        mEditedSegments.clear();
        return flag1;
_L4:
        file = RecordSessionManager.getDataFile(file, false);
        flag = flag1;
        if (file.exists())
        {
            FileUtils.deleteQuietly(file);
            flag = flag1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setCameraView(View view)
    {
        mCameraView = view;
    }

    public void setDiscardChanges(boolean flag)
    {
        mDiscardChanges = flag;
    }

    public void setEnabled(boolean flag)
    {
        mEnabled = flag;
    }

    public void setFinalFile(RecordingFile recordingfile)
    {
        finalFile = recordingfile;
    }

    protected void setHasPreviewedAlreadyIfNeeded()
    {
    }

    protected abstract void showCameraFailedToast();

    public void showFocusIndicator(int i, int j)
    {
    }

    public void start(final String tag, boolean flag, boolean flag1)
    {
        long l = System.currentTimeMillis();
        if (!mCanKeepRecording)
        {
            CrashUtil.logException(new IllegalStateException("You cannot start recording again if it is finished."));
            CrashUtil.log("Start failed.");
        } else
        {
            if (flag1)
            {
                adjustBoundaries(mVideoController.getCameraSetting());
            }
            if (mVideoController.isRecordingStarted() && flag)
            {
                stop("stopPrevious", new Runnable() {

                    final BasicVineRecorder this$0;
                    final String val$tag;

                    public void run()
                    {
                        guardedStartRecording(tag);
                    }

            
            {
                this$0 = BasicVineRecorder.this;
                tag = s;
                super();
            }
                }, true, false);
            } else
            {
                guardedStartRecording(tag);
            }
        }
        CrashUtil.log("Start called from {} took {}ms.", new Object[] {
            tag, Long.valueOf(System.currentTimeMillis() - l)
        });
    }

    protected void startHashTask(boolean flag)
    {
        mHashTask = new ReusableHashAsyncTask(this);
        detectedInvalidSession = flag;
        mHashTask.execute(new RecordingFile[] {
            mCurrentRecordingFile
        });
    }

    protected void startProgressTimer()
    {
        mProgressTimer = new ProgressTimer(this, mHandler, mThresholdMs);
        mProgressTimer.start();
    }

    protected void startRecording(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Activity activity;
        activity = mActivity;
        CrashUtil.log("Start recording called from {}.", new Object[] {
            s
        });
        if (activity == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mVideoController.isCameraReady();
        boolean flag;
        flag = flag1;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        CrashUtil.log("Start recording.");
        flag = mVideoController.openDefaultCamera(mFrontFacing, false);
_L3:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        if (!mVideoController.isPreviewing())
        {
            mVideoController.startPreview();
        }
        s = mCurrentRecordingFile.getSession();
        if (mVideoController.isRecordingStarted())
        {
            break MISSING_BLOCK_LABEL_201;
        }
        s.setAudioDataCount(s.calculateAudioCount());
        s.setVideoDataCount(s.calculateVideoCount());
        if (!mHardwareEncoding)
        {
            if (s.getVersion() == RecordSessionVersion.SW_MP4)
            {
                EncoderManager.tryLoad();
            }
            opencv_imgproc.tryLoad();
        }
        long l = System.currentTimeMillis();
        mVideoController.start(activity, mCurrentRecordingFile.getVideoPath(), s.getAudioDataCount(), s.getVideoDataCount());
        CrashUtil.log("Start recording: {} took {}ms.", new Object[] {
            mCurrentRecordingFile.getVideoPath(), Long.valueOf(System.currentTimeMillis() - l)
        });
_L4:
        mVideoController.waitForPreviewToStart();
        if (!mVideoController.isPreviewing())
        {
            mVideoController.startPreview();
        }
        SLog.dWithTag("TestLog", "Recorder fully initialized.");
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        onDeviceNotSupported(s);
        flag = flag1;
          goto _L3
        s;
        throw s;
        s;
        onDeviceNotSupported(s);
          goto _L4
        s;
        CrashUtil.logException(s);
          goto _L4
        showCameraFailedToast();
          goto _L4
    }

    public boolean startRelativeTime()
    {
        if (mVideoController == null || mSession == null || mSession.getConfig() == null || !mVideoController.isRecordingStarted() || !mCanKeepRecording || !mVideoController.isCameraReady() || mCurrentDuration >= (long)mSession.getConfig().maxDuration || mCurrentSegment != null && !endRelativeTime())
        {
            return false;
        } else
        {
            mCurrentDuration = (long)mRecordingFileDuration - System.currentTimeMillis();
            mCurrentSegment = new RecordSegment(mCurrentDuration);
            CrashUtil.log((new StringBuilder()).append("START RELATIVE TIME: ").append(mVideoController).append(" bc: ").append(CameraManager.sCameraBufferCount).append(", added: ").append(CameraManager.getInstance().getAddedBufferArrayCount()).toString());
            mVideoController.setRecordingAudio(true);
            mVideoController.setRecording(mCurrentSegment);
            return true;
        }
    }

    protected void stop(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        if (onStop())
        {
            s = getFinishProcessTask(s, runnable, flag, flag1);
            mVideoController.setFinishProcessTask(s);
            s.execute(new Void[0]);
        }
    }

    public void stopAndDiscardChanges(String s, Runnable runnable, boolean flag)
    {
        setDiscardChanges(true);
        mFinishProcessRunnable.run(s, flag, false);
        if (runnable != null)
        {
            runnable.run();
        }
    }

    protected void stopProgressTimer()
    {
        if (mProgressTimer != null)
        {
            mProgressTimer.release();
            mProgressTimer = null;
        }
    }

    public RecordingFile swapSession(String s, RecordingFile recordingfile)
    {
        if (recordingfile != null)
        {
            CrashUtil.log("Swap new Recorder for {} from {}.", new Object[] {
                s, recordingfile.folder.getAbsolutePath()
            });
            mSession = recordingfile.getSession();
            if (SLog.sLogsOn)
            {
                int i;
                if (mCurrentRecordingFile == null)
                {
                    i = 0;
                } else
                {
                    i = mCurrentRecordingFile.hashCode();
                }
                SLog.i("[session] Swapping file {} for {}.", Integer.valueOf(i), Integer.valueOf(recordingfile.hashCode()));
            }
            mCurrentRecordingFile = recordingfile;
            mFinished = false;
            mEditedSegments.clear();
            mEditedSegments.addAll(mCurrentRecordingFile.getSession().getSegments());
            mToRemove.clear();
            mAddedSegments.clear();
            mCurrentRecordingFile.editedSegments = mEditedSegments;
            swapTimestampsFromSegments(mEditedSegments);
            mCanKeepRecording = true;
            setHasPreviewedAlreadyIfNeeded();
            changeProgress(mCurrentDuration);
            mDiscardChanges = false;
            finalFile = null;
            mVideoController.swapSession();
        }
        return recordingfile;
    }

    protected void swapTimestampsFromSegments(ArrayList arraylist)
    {
        int i = 0;
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            RecordSegment recordsegment = (RecordSegment)arraylist.next();
            if (!recordsegment.removed)
            {
                i += recordsegment.getCombinedAudioData().size;
            }
        } while (true);
        i = RecordConfigUtils.getTimeStampInNsFromSampleCounted(i);
        mVideoController.setAudioTimestamp(i);
        mVideoController.setVideoTimeStamp(i);
        mCurrentDuration = mVideoController.getTimestamp();
        mRecordingFileDuration = (int)mCurrentDuration;
        invalidateFinishButton();
    }

    public void switchImageStabilization()
    {
        if (mVideoController != null)
        {
            mVideoController.switchImageStabilization();
        }
    }

    public void updateGhostBitmap(Bitmap bitmap)
    {
    }
}
