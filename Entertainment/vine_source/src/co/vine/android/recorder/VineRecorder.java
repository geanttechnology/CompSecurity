// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaActionSound;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.ToggleButton;
import co.vine.android.VineLoggingException;
import co.vine.android.dragsort.DragSortWidget;
import co.vine.android.player.SdkVideoView;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.ViewUtil;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package co.vine.android.recorder:
//            RegularVineRecorder, RecordSegment, RecordingAnimations, ViewGoneAnimationListener, 
//            SegmentEditorAdapter, RecordingFile, AudioData, RecordConfigUtils, 
//            ProgressView, RecordController, CameraManager, CameraSetting, 
//            RecordSession, AudioArray, RecordSessionVersion, SwVineFrameRecorder, 
//            SwCombiningRunnable, BaseFinishProcessTask

public class VineRecorder extends RegularVineRecorder
    implements android.view.View.OnTouchListener, RecordController.OnRecorderControllerStateChangedListener, co.vine.android.dragsort.DragSortWidget.SelectionChangedListener, co.vine.android.player.VideoViewInterface.OnPreparedListener, co.vine.android.dragsort.DragSortWidget.FloatViewInteractionListener, co.vine.android.dragsort.DragSortWidget.CurrentlyPlayingProvider, android.view.View.OnKeyListener
{
    private class EditModePreviewClickListener
        implements android.view.View.OnClickListener
    {

        final VineRecorder this$0;

        public void onClick(View view)
        {
            if (mVideoPlayer.isPlaying())
            {
                mPlayButtonOnClickListener.toPlay = mLastPlayingSegment;
                mPlayButtonOnClickListener.forceRefresh = false;
                pausePreview(true);
            }
        }

        private EditModePreviewClickListener()
        {
            this$0 = VineRecorder.this;
            super();
        }

    }

    private class PlayButtonOnClickListener
        implements android.view.View.OnClickListener
    {

        boolean forceRefresh;
        final VineRecorder this$0;
        RecordSegment toPlay;

        public void onClick(View view)
        {
            if (toPlay == null)
            {
                mLastSelectedPosition = -1;
                if (mDragSortWidget != null)
                {
                    mDragSortWidget.setSelection(-1);
                }
                animateTopButtons(2);
            }
            playPreview(toPlay, forceRefresh);
        }

        private PlayButtonOnClickListener()
        {
            this$0 = VineRecorder.this;
            super();
            toPlay = null;
            forceRefresh = false;
        }

    }

    private class RefreshPreviewTask extends AsyncTask
    {

        private final RecordSegment mSegment;
        final VineRecorder this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (isCancelled()) goto _L2; else goto _L1
_L1:
            if (mSegment == mLastPlayingSegment) goto _L4; else goto _L3
_L3:
            if (mSegment == null)
            {
                refreshFullPreview();
            } else
            {
                mVideoController.makePreview(mSegment, false);
            }
_L2:
            return null;
_L4:
            if (mSegment == null && mEditorAdapter.hasInitialized)
            {
                refreshFullPreview();
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        public void onCancelled()
        {
            animatePreviewSpinner(false);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
label0:
            {
                void1 = null;
                boolean flag = false;
                Object obj = mEditorAdapter;
                if (mVideoPlayer != null)
                {
                    if (obj == null || isCancelled() || ((SegmentEditorAdapter) (obj)).getCount() <= 0)
                    {
                        break label0;
                    }
                    obj = (ViewGroup)mVideoPlayer.getParent();
                    if (mVideoAttr == null)
                    {
                        mVideoAttr = mVideoPlayer.getAttributes();
                    }
                    mVideoPlayer.setLooping(true);
                    mVideoPlayer.setVisibility(0);
                    if (obj != null)
                    {
                        ((ViewGroup) (obj)).setOnClickListener(new EditModePreviewClickListener());
                    }
                    if (mDragSortWidget != null)
                    {
                        mDragSortWidget.setContentView(((View) (obj)), new Rect(0, mEditorButtonsHeight, mSize.x, mEditorButtonsHeight + mSize.x));
                    }
                    adjustEditBoundaries();
                    mLastPlayingSegment = mSegment;
                    if (mSegment == null)
                    {
                        if (mCurrentRecordingFile != null)
                        {
                            void1 = mCurrentRecordingFile.getPreviewVideoPath();
                        }
                    } else
                    {
                        void1 = mSegment.videoPath;
                    }
                    if (mVideoPlayer != null && void1 != null)
                    {
                        SdkVideoView sdkvideoview = mVideoPlayer;
                        if (mDragSortWidget == null || !mDragSortWidget.hasFloatView())
                        {
                            flag = true;
                        }
                        sdkvideoview.setAutoPlayOnPrepared(flag);
                        mVideoPlayer.setOnPreparedListener(VineRecorder.this);
                        mVideoPlayer.setOnErrorListener(VineRecorder.this);
                        mVideoPlayer.setVideoPath(void1);
                    }
                }
                return;
            }
            mVideoPlayer.setVisibility(8);
        }

        public RefreshPreviewTask(RecordSegment recordsegment)
        {
            this$0 = VineRecorder.this;
            super();
            mSegment = recordsegment;
        }
    }

    public class SegmentChangeDetector
        implements Runnable
    {

        private static final int SLEEP_MILLIS = 40;
        public int lastFirstItem;
        public boolean runThread;
        final VineRecorder this$0;

        public void run()
        {
_L12:
            if (!runThread)
            {
                break MISSING_BLOCK_LABEL_161;
            }
            if (mLastSelectedPosition != -1 || mEditorAdapter == null || !mVideoPlayer.isPlaying()) goto _L2; else goto _L1
_L1:
            int j = mVideoPlayer.getCurrentPosition() + 20;
            if (j <= 0) goto _L2; else goto _L3
_L3:
            Object obj;
            int i;
            obj = mEditorAdapter.getData();
            i = ((ArrayList) (obj)).size();
            if (i <= 0) goto _L2; else goto _L4
_L4:
            i--;
_L10:
            if (i < 0) goto _L2; else goto _L5
_L5:
            if ((long)j < ((RecordSegment)((ArrayList) (obj)).get(i)).startTimestamp) goto _L7; else goto _L6
_L6:
            if (lastFirstItem != i) goto _L8; else goto _L2
_L2:
            Thread.sleep(40L);
            continue; /* Loop/switch isn't completed */
_L8:
            lastFirstItem = i;
            obj = mActivity;
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((Activity) (obj)).runOnUiThread(new Runnable() {

                final SegmentChangeDetector this$1;

                public void run()
                {
                    if (mLastSelectedPosition == -1)
                    {
                        DragSortWidget dragsortwidget = mDragSortWidget;
                        if (dragsortwidget != null)
                        {
                            dragsortwidget.setFocused(lastFirstItem);
                        }
                    }
                }

            
            {
                this$1 = SegmentChangeDetector.this;
                super();
            }
            });
            if (true) goto _L2; else goto _L7
_L7:
            i--;
            if (true) goto _L10; else goto _L9
_L9:
            InterruptedException interruptedexception;
            interruptedexception;
            return;
            if (true) goto _L12; else goto _L11
_L11:
        }

        public SegmentChangeDetector()
        {
            this$0 = VineRecorder.this;
            super();
            lastFirstItem = 0;
            runThread = true;
        }
    }


    private static final String JAPANESE_LANG = "ja";
    private static final int JAPANESE_MCC = 440;
    private static final long REMOVE_THUMBNAIL_MILLIS = 100L;
    private static final long TRANSITION_DURATION = 250L;
    private static final int TRASH_BRIGHT = 1;
    private static final int TRASH_INVISIBLE = 2;
    private static final int TRASH_VISIBLE = 0;
    public boolean detectedInvalidSession;
    private ViewGroup mCameraSwitcher;
    private final int mCameraSwitcherId;
    private final android.view.View.OnClickListener mCameraSwitcherViewListener = new android.view.View.OnClickListener() {

        final VineRecorder this$0;

        public void onClick(View view)
        {
label0:
            {
                if (!mIsSwitchingCamera && mCanKeepRecording)
                {
                    if (!canSwitchCamera())
                    {
                        break label0;
                    }
                    mSwitchCameraTask = new RegularVineRecorder.ResumeCameraAsyncTask(true) {

                        final _cls3 this$1;

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            invalidateZoomSlider();
                        }

            
            {
                this$1 = _cls3.this;
                super(_fld0, flag);
            }
                    };
                    mSwitchCameraTask.execute(new Void[0]);
                }
                return;
            }
            CrashUtil.logException(new VineLoggingException("You can not switch camera after recording has started."), "Person trying to record and switch? not cool.", new Object[0]);
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    };
    private final Runnable mChangeProgressOverlayVisibilityRunnable = new Runnable() {

        final VineRecorder this$0;

        public void run()
        {
            mProgressOverlay.setVisibility(8);
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    };
    private int mCurrentFrameRate;
    private int mDefaultColor;
    private DragSortWidget mDragSortWidget;
    private final int mDragSortWidgetId;
    private boolean mEditing;
    private SegmentEditorAdapter mEditorAdapter;
    private View mEditorButtons;
    private int mEditorButtonsHeight;
    private final int mEditorButtonsId;
    private View mEditorCancelButton;
    private final int mEditorCancelButtonId;
    private View mEditorDoneButton;
    private final int mEditorDoneButtonId;
    private int mEnabledColor;
    private View mFinishButton;
    private final int mFinishButtonId;
    private final android.view.View.OnClickListener mFinishClicker = new android.view.View.OnClickListener() {

        final VineRecorder this$0;

        public void onClick(View view)
        {
            setHasPreviewedAlreadyIfNeeded();
            finish("finishClicker");
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    };
    private View mFinishLoadingOverlay;
    private final int mFinishLoadingOverlayId;
    private View mFlashSwitcher;
    private final int mFlashSwitcherId;
    private final AnimationSet mFocusAnimationSet;
    private final int mFocusDisabledDrawable;
    private final AlphaAnimation mFocusDismissAnimation;
    private final int mFocusEnabledDrawable;
    private final ImageView mFocusIndicator;
    private View mFocusView;
    private final int mFocusViewResourceId;
    private final ToggleButton mGhostButton;
    private boolean mGhostModeEnabled;
    private final ImageView mGhostView;
    private ToggleButton mGridSwitch;
    private final int mGridSwitchId;
    private boolean mHasPreviewedAlready;
    private final boolean mInitiallyStartedWithEditMode;
    private boolean mIsGridOn;
    private final boolean mIsMessaging;
    private RecordSegment mLastPlayingSegment;
    private int mLastSelectedPosition;
    private int mLastUpdatedZoom;
    private MediaActionSound mMediaActionSound;
    private int mPickedUpPosition;
    private View mPlayButton;
    private View mPlayButtonContainer;
    private final int mPlayButtonContainerId;
    private PlayButtonOnClickListener mPlayButtonOnClickListener;
    private View mPlayRefreshButton;
    private boolean mPlaySound;
    private View mPreviewLoadingOverlay;
    private final int mPreviewLoadingOverlayId;
    private View mProgressOverlay;
    private final int mProgressOverlayId;
    private View mRecordingOptions;
    private final int mRecordingOptionsRowId;
    private RefreshPreviewTask mRefreshPreviewTask;
    private Resources mResources;
    private boolean mReturnToPreview;
    private SegmentChangeDetector mSegmentChangeDetector;
    private Thread mSegmentChangeThread;
    private int mShortAnimTime;
    private boolean mStartWithEditMode;
    private final android.view.View.OnClickListener mSwitchFlashViewListener = new android.view.View.OnClickListener() {

        final VineRecorder this$0;

        public void onClick(View view)
        {
            mVideoController.switchFlash();
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    };
    private View mThumbnailList;
    private ImageView mThumbnailOverlay;
    private final int mThumbnailOverlayId;
    private int mThumbnailPadding;
    private RecordSegment mThumbnailSegment;
    private double mTimeLapseDelay;
    Runnable mTimeLapseRunnable;
    private boolean mTimelapsing;
    private View mTrashCanButton;
    private final int mTrashCanButtonId;
    private View mTrashUndoContainer;
    private final int mTrashUndoContainerId;
    private View mUndoButton;
    private final int mUndoButtonId;
    private AttributeSet mVideoAttr;
    private SdkVideoView mVideoPlayer;
    private android.widget.RelativeLayout.LayoutParams mVideoViewParams;
    private SeekBar mZoomSeek;
    private View mZoomSeekContainer;
    private final int mZoomSeekContainerId;
    private final int mZoomSeekId;
    private final android.widget.SeekBar.OnSeekBarChangeListener mZoomSeekListener = new android.widget.SeekBar.OnSeekBarChangeListener() {

        final VineRecorder this$0;

        public void onProgressChanged(SeekBar seekbar, int i9, boolean flag5)
        {
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            CameraManager.getInstance().modifyZoom(seekbar.getProgress() + 1);
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    };
    private final Runnable mZoomUpdateRunnable = new Runnable() {

        final VineRecorder this$0;

        public void run()
        {
            if (mZoomSeek != null && mLastUpdatedZoom >= 0)
            {
                SLog.d((new StringBuilder()).append("Zoom progress updated: ").append(mLastUpdatedZoom).toString());
                mZoomSeek.setProgress(mLastUpdatedZoom - 1);
            }
            requestZoomProgressUpdate();
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    };
    private final Runnable onCameraReadyRunnable = new Runnable() {

        final VineRecorder this$0;

        public void run()
        {
            if (mFocusView != null)
            {
                Drawable drawable;
                if (mVideoController.canChangeFocus())
                {
                    drawable = mResources.getDrawable(mFocusEnabledDrawable);
                } else
                {
                    drawable = mResources.getDrawable(mFocusDisabledDrawable);
                }
                if (mIsMessaging)
                {
                    drawable.setColorFilter(mEnabledColor, android.graphics.PorterDuff.Mode.SRC_ATOP);
                }
                if (mVideoController.canChangeFocus())
                {
                    mFocusView.setAlpha(0.35F);
                } else
                {
                    mFocusView.setAlpha(1.0F);
                }
                ViewUtil.setBackground(mFocusView, drawable);
            }
            setAutoFocusing(true);
            if (mCameraSwitcher != null)
            {
                if (mFrontFacing)
                {
                    mCameraSwitcher.getChildAt(0).setAlpha(1.0F);
                } else
                {
                    mCameraSwitcher.getChildAt(0).setAlpha(0.35F);
                }
            }
            if (mGridSwitch != null)
            {
                mGridSwitch.setChecked(mIsGridOn);
            }
        }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
    };

    public transient VineRecorder(RecordSessionVersion recordsessionversion, boolean flag, Point point, boolean flag1, boolean flag2, RecordingFile recordingfile, Activity activity, 
            SdkVideoView sdkvideoview, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3, 
            int j3, int k3, int l3, int i4, int j4, int k4, int l4, 
            int i5, int j5, int k5, int l5, int i6, int j6, int k6, 
            int l6, int i7, int j7, int k7, int l7, String s, ToggleButton togglebutton, 
            boolean flag3, boolean flag4, int i8, int j8, int k8, int l8, MediaActionSound mediaactionsound, 
            CharSequence acharsequence[])
    {
        char c;
        if (flag4)
        {
            c = 'B';
        } else
        {
            c = '\u03E8';
        }
        super(c, point, activity, i2, j2, j3, k3, k5, l5, k6, s, flag3, recordsessionversion, acharsequence);
        mGhostModeEnabled = false;
        mLastPlayingSegment = new RecordSegment(0L);
        mPlaySound = false;
        mLastUpdatedZoom = -1;
        mTimelapsing = false;
        mTimeLapseRunnable = new Runnable() {

            final VineRecorder this$0;

            public void run()
            {
                if (mSession != null && mSession.getConfig() != null && (double)mCurrentDuration < (double)mSession.getConfig().maxDuration * 0.94999999999999996D)
                {
                    doOneFrame();
                    mHandler.postDelayed(this, (long)mTimeLapseDelay);
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        };
        mReturnToPreview = flag1;
        mHasPreviewedAlready = flag2;
        mStartWithEditMode = flag;
        mInitiallyStartedWithEditMode = flag;
        mTrashUndoContainerId = k4;
        mEditorButtonsHeight = i7;
        mVideoPlayer = sdkvideoview;
        mShortAnimTime = mActivity.getResources().getInteger(0x10e0000);
        mThumbnailPadding = l6;
        mUndoButtonId = i5;
        mFinishButtonId = i3;
        mGhostButton = togglebutton;
        mFinishLastSegmentString = activity.getText(j5);
        mThumbnailOverlayId = j6;
        mFlashSwitcherId = l2;
        mCameraSwitcherId = k2;
        mGridSwitchId = k;
        mFinishLoadingOverlayId = j7;
        mPlayButtonContainerId = i6;
        mPreviewLoadingOverlayId = k7;
        mEditorButtonsId = l3;
        mEditorDoneButtonId = i4;
        mEditorCancelButtonId = j4;
        mTrashCanButtonId = l4;
        mRecordingOptionsRowId = i;
        mFocusViewResourceId = l1;
        mFocusEnabledDrawable = j1;
        mFocusDisabledDrawable = k1;
        mDragSortWidgetId = j;
        mFocusIndicator = (ImageView)activity.findViewById(i1);
        mGhostView = (ImageView)activity.findViewById(l);
        mGhostView.setAlpha(0.35F);
        mFocusDismissAnimation = RecordingAnimations.getFocusDismissAnimation(mFocusIndicator);
        mFocusAnimationSet = RecordingAnimations.getFocusAnimationSet(mFocusDismissAnimation, mFocusIndicator);
        mProgressOverlayId = l7;
        mMediaActionSound = mediaactionsound;
        recordsessionversion = Locale.getDefault();
        if (recordsessionversion != null && "ja".equals(recordsessionversion.getLanguage()) || mActivity.getResources().getConfiguration().mcc == 440)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPlaySound = flag;
        swapSession("Init", recordingfile);
        mIsMessaging = flag4;
        mEnabledColor = i8;
        mDefaultColor = j8;
        mZoomSeekContainerId = k8;
        mZoomSeekId = l8;
    }

    private void adjustEditBoundaries()
    {
        if (mVideoPlayer != null)
        {
            mVideoViewParams = (android.widget.RelativeLayout.LayoutParams)mVideoPlayer.getLayoutParams();
            mVideoViewParams.width = mSize.x;
            mVideoViewParams.height = mSize.x;
        }
        if (mPlayButtonContainer != null)
        {
            mPlayButtonContainer.setLayoutParams(mVideoViewParams);
        }
        if (mThumbnailOverlay != null)
        {
            mThumbnailOverlay.setLayoutParams(mVideoViewParams);
        }
        if (mPreviewLoadingOverlay != null)
        {
            mPreviewLoadingOverlay.setLayoutParams(mVideoViewParams);
        }
        final android.widget.RelativeLayout.LayoutParams thumbListParams;
        if (mThumbnailList != null)
        {
            thumbListParams = (android.widget.RelativeLayout.LayoutParams)mThumbnailList.getLayoutParams();
            thumbListParams.setMargins(0, mEditorButtonsHeight + mSize.x + mThumbnailPadding, 0, 0);
        } else
        {
            thumbListParams = null;
        }
        if (mActivity != null)
        {
            mActivity.runOnUiThread(new Runnable() {

                final VineRecorder this$0;
                final android.widget.RelativeLayout.LayoutParams val$thumbListParams;

                public void run()
                {
                    Object obj = mVideoPlayer;
                    if (obj != null)
                    {
                        ((View) (obj)).setLayoutParams(mVideoViewParams);
                    }
                    obj = mThumbnailList;
                    if (obj != null)
                    {
                        ((View) (obj)).setLayoutParams(thumbListParams);
                    }
                }

            
            {
                this$0 = VineRecorder.this;
                thumbListParams = layoutparams;
                super();
            }
            });
        }
    }

    private void animateCaptureControlsIn()
    {
        getHandler().postDelayed(new Runnable() {

            final VineRecorder this$0;

            public void run()
            {
                if (mRecordingOptions != null)
                {
                    mRecordingOptions.setAlpha(0.0F);
                    mRecordingOptions.setVisibility(0);
                    mRecordingOptions.animate().alpha(1.0F).setDuration(250L).start();
                }
                if (mTopMaskView != null)
                {
                    mTopMaskView.setAlpha(0.0F);
                    mTopMaskView.setVisibility(0);
                    mTopMaskView.animate().alpha(1.0F).setDuration(250L).start();
                }
                if (mProgressView != null)
                {
                    mProgressView.setTranslationY(mEditorButtonsHeight);
                    mProgressView.setScaleY(0.0F);
                    mProgressView.setVisibility(0);
                    mProgressView.animate().scaleY(1.0F).translationY(0.0F).setDuration(250L).start();
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        }, 250L);
        if (mCameraView != null)
        {
            mCameraView.setVisibility(0);
        }
    }

    private void animateCaptureControlsOut()
    {
        Object obj = mProgressView;
        if (obj != null)
        {
            ViewPropertyAnimator viewpropertyanimator = ((View) (obj)).animate();
            if (viewpropertyanimator != null)
            {
                viewpropertyanimator.scaleY(0.0F).translationY(mEditorButtonsHeight).setDuration(250L).setListener(new ViewGoneAnimationListener(((View) (obj)))).start();
            }
        }
        obj = mTopMaskView;
        if (obj != null)
        {
            ViewPropertyAnimator viewpropertyanimator1 = ((View) (obj)).animate();
            if (viewpropertyanimator1 != null)
            {
                viewpropertyanimator1.alpha(0.0F).setDuration(250L).setListener(new ViewGoneAnimationListener(((View) (obj)))).start();
            }
        }
        obj = mRecordingOptions;
        if (obj != null)
        {
            ViewPropertyAnimator viewpropertyanimator2 = ((View) (obj)).animate();
            if (viewpropertyanimator2 != null)
            {
                viewpropertyanimator2.alpha(0.0F).setDuration(250L).setListener(new ViewGoneAnimationListener(((View) (obj)))).start();
            }
        }
        if (mCameraView != null)
        {
            mCameraView.setVisibility(4);
        }
    }

    private void animateEditModeControlsIn()
    {
        getHandler().postDelayed(new Runnable() {

            final VineRecorder this$0;

            public void run()
            {
                if (mEditorButtons != null)
                {
                    mEditorButtons.setAlpha(0.0F);
                    mEditorButtons.setVisibility(0);
                    mEditorButtons.animate().alpha(1.0F).setDuration(250L).start();
                }
                if (mThumbnailList != null)
                {
                    int i = mThumbnailList.getHeight();
                    mThumbnailList.setTranslationY(-i / 2);
                    mThumbnailList.setScaleY(0.0F);
                    mThumbnailList.setVisibility(0);
                    mThumbnailList.animate().scaleY(1.0F).translationY(0.0F).setDuration(250L).start();
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        }, 250L);
        mVideoPlayer.setVisibility(0);
        if (mPreviewLoadingOverlay != null)
        {
            mPreviewLoadingOverlay.setVisibility(4);
            mPreviewLoadingOverlay.setAlpha(0.0F);
        }
        if (mPlayButtonContainer != null)
        {
            mPlayButtonContainer.setVisibility(4);
            mPlayButtonContainer.setAlpha(0.0F);
        }
        if (mTrashUndoContainer != null)
        {
            mTrashUndoContainer.setVisibility(0);
            mTrashUndoContainer.setAlpha(1.0F);
        }
        if (mTrashCanButton != null)
        {
            mTrashCanButton.setVisibility(4);
        }
        if (mUndoButton != null)
        {
            mUndoButton.setVisibility(4);
        }
        if (mThumbnailOverlay != null)
        {
            mThumbnailOverlay.setVisibility(4);
        }
    }

    private void animateEditModeControlsOut(boolean flag)
    {
        if (mEditorAdapter != null && mThumbnailOverlay != null && mTrashUndoContainer != null && mPlayButtonContainer != null && mPreviewLoadingOverlay != null && mThumbnailList != null && mPlayButton != null)
        {
            mEditorButtons.animate().alpha(0.0F).setDuration(250L).setListener(new ViewGoneAnimationListener(mEditorButtons)).start();
            mThumbnailOverlay.animate().alpha(0.0F).setDuration(250L).setListener(new ViewGoneAnimationListener(mThumbnailOverlay)).start();
            mTrashUndoContainer.animate().alpha(0.0F).setDuration(250L).setListener(new ViewGoneAnimationListener(mTrashUndoContainer)).start();
            mPlayButtonContainer.animate().alpha(0.0F).setDuration(250L).setListener(new ViewGoneAnimationListener(mPlayButtonContainer)).start();
            mPreviewLoadingOverlay.animate().alpha(0.0F).setDuration(250L).setListener(new ViewGoneAnimationListener(mPreviewLoadingOverlay)).start();
            mThumbnailList.animate().scaleY(0.0F).translationY(-mThumbnailList.getHeight() / 2).setDuration(250L).setListener(new ViewGoneAnimationListener(mThumbnailList)).start();
            mPlayButtonContainer.animate().alpha(0.0F).setDuration(250L).start();
            mTrashUndoContainer.setActivated(false);
            mDragSortWidget.setSelection(-1);
        }
        if (flag && mVideoPlayer != null)
        {
            mVideoPlayer.setVisibility(4);
        }
    }

    private void animatePlayButton(boolean flag)
    {
label0:
        {
            if (mPlayButton != null && mPlayRefreshButton != null && mPlayButtonContainer != null)
            {
                mPlayButtonContainer.animate().cancel();
                if (flag)
                {
                    break label0;
                }
                mPlayButtonContainer.animate().alpha(0.0F).setDuration(mShortAnimTime).setListener(new ViewGoneAnimationListener(mPlayButtonContainer)).start();
            }
            return;
        }
        if (mPlayButtonOnClickListener.toPlay != null)
        {
            mPlayButton.setVisibility(8);
            mPlayRefreshButton.setVisibility(0);
        } else
        {
            mPlayButton.setVisibility(0);
            mPlayRefreshButton.setVisibility(8);
        }
        mPlayButtonContainer.setVisibility(0);
        mPlayButtonContainer.animate().alpha(1.0F).setDuration(mShortAnimTime).start();
    }

    private void animatePreviewSpinner(boolean flag)
    {
        animateSpinner(mPreviewLoadingOverlay, flag);
    }

    private void animateSpinner(View view, boolean flag)
    {
label0:
        {
            if (view != null)
            {
                view.animate().cancel();
                if (flag)
                {
                    break label0;
                }
                view.animate().alpha(0.0F).setDuration(mShortAnimTime).setListener(new ViewGoneAnimationListener(view)).start();
            }
            return;
        }
        view.setVisibility(0);
        view.setAlpha(0.0F);
        view.animate().alpha(1.0F).setDuration(mShortAnimTime).start();
    }

    private void animateTopButtons(int i)
    {
        if (mTrashUndoContainer == null || mTrashCanButton == null) goto _L2; else goto _L1
_L1:
        mTrashUndoContainer.animate().cancel();
        mTrashCanButton.animate().cancel();
        i;
        JVM INSTR tableswitch 0 2: default 60
    //                   0 61
    //                   1 95
    //                   2 112;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        mTrashCanButton.setVisibility(0);
        mUndoButton.setVisibility(8);
        mTrashUndoContainer.setActivated(false);
        mTrashCanButton.setActivated(false);
        return;
_L4:
        mTrashUndoContainer.setActivated(true);
        mTrashCanButton.setActivated(true);
        return;
_L5:
        mTrashCanButton.setVisibility(8);
        mTrashUndoContainer.setActivated(false);
        mTrashCanButton.setActivated(false);
        if (mEditorAdapter != null && mEditorAdapter.canUndoDelete())
        {
            mUndoButton.setVisibility(0);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    private boolean commitChanges()
    {
        Object obj;
        SegmentEditorAdapter segmenteditoradapter;
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag = false;
        flag1 = false;
        segmenteditoradapter = mEditorAdapter;
        if (segmenteditoradapter == null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        segmenteditoradapter.commitDelete();
        i = mEditedSegments.size();
        obj = null;
        if (i > 0)
        {
            obj = (RecordSegment)mEditedSegments.get(i - 1);
        }
        i = segmenteditoradapter.getData().size();
        if (i <= 0) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (obj != segmenteditoradapter.getData().get(i - 1))
        {
            flag = true;
        }
_L4:
        mEditedSegments.clear();
        mEditedSegments.addAll(segmenteditoradapter.getData());
        mEditedSegments.addAll(segmenteditoradapter.getDeleted());
        for (obj = segmenteditoradapter.getDeleted().iterator(); ((Iterator) (obj)).hasNext();)
        {
            ((RecordSegment)((Iterator) (obj)).next()).removed = true;
        }

        break; /* Loop/switch isn't completed */
_L2:
        flag = flag2;
        if (obj != null)
        {
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        swapTimestampsFromSegments(mEditedSegments);
        mToRemove.addAll(RecordSegment.applyEditedChanges(mCurrentRecordingFile.getSession(), mEditedSegments));
        mCurrentRecordingFile.isDirty = true;
        SLog.d("Changes commited, last segment has changed? {}.", Boolean.valueOf(flag));
        return flag;
    }

    private void dismissFocusIndicator()
    {
        if (mFocusIndicator != null && mFocusIndicator.getVisibility() == 0)
        {
            mFocusIndicator.startAnimation(mFocusDismissAnimation);
        }
    }

    private boolean floatViewIntersectsTrashCan()
    {
        boolean flag = true;
        if (mVideoPlayer != null)
        {
            int i = ((android.widget.RelativeLayout.LayoutParams)mVideoPlayer.getLayoutParams()).topMargin;
            Rect rect = mDragSortWidget.getFloatViewBounds();
            if (mDragSortWidget.floatViewIsFromContentView())
            {
                return rect.top < i;
            }
            int j = (mVideoPlayer.getBottom() - mVideoPlayer.getTop()) / 2;
            if (rect.top >= j + i)
            {
                flag = false;
            }
            return flag;
        } else
        {
            return false;
        }
    }

    private long getDurationFromSegments()
    {
        int i = 0;
        Iterator iterator = mEditorAdapter.getData().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            RecordSegment recordsegment = (RecordSegment)iterator.next();
            if (!recordsegment.removed)
            {
                i += recordsegment.getCombinedAudioData().size;
            }
        } while (true);
        return (long)RecordConfigUtils.getTimeStampInNsFromSampleCounted(i) / 1000L;
    }

    private void hideCaptureControls()
    {
        if (mProgressView != null)
        {
            mProgressView.setVisibility(4);
        }
        if (mCameraView != null)
        {
            mCameraView.setVisibility(4);
        }
        if (mTopMaskView != null)
        {
            mTopMaskView.setVisibility(4);
        }
        if (mRecordingOptions != null)
        {
            mRecordingOptions.setVisibility(4);
        }
    }

    private void invalidateGhostView()
    {
        if (mEditedSegments.size() > 0 && mGhostView != null && mActivity != null && mCurrentRecordingFile != null)
        {
            mGhostView.setImageDrawable(new BitmapDrawable(mActivity.getResources(), mCurrentRecordingFile.getLastFramePath()));
        }
        mVideoController.invalidateGhostFrame();
    }

    private void invalidateZoomSlider()
    {
label0:
        {
label1:
            {
                RecordConfigUtils.RecordConfig recordconfig = getConfig();
                if (recordconfig != null && mZoomSeekContainer != null)
                {
                    if (!recordconfig.isZoomButtonEnabled || mZoomSeek == null)
                    {
                        break label0;
                    }
                    mZoomSeekContainer.setVisibility(0);
                    if (!recordconfig.zoomEnabled || !CameraManager.getInstance().isZoomSupported())
                    {
                        break label1;
                    }
                    mZoomSeek.setEnabled(true);
                    mZoomSeek.setMax(CameraManager.getInstance().getMaxZoom() - 1);
                }
                return;
            }
            mZoomSeekContainer.setVisibility(8);
            mZoomSeek.setProgress(0);
            mZoomSeek.setEnabled(false);
            return;
        }
        mZoomSeekContainer.setVisibility(8);
    }

    private void refreshFullPreview()
    {
        SLog.i("Refresh full preview.");
        RecordingFile recordingfile = getFile();
        Object obj = null;
        if (recordingfile != null)
        {
            obj = recordingfile.getSession();
        }
        if (obj != null)
        {
            ArrayList arraylist = mEditorAdapter.getData();
            byte abyte0[];
            int i;
            long l;
            if (arraylist.size() > 0)
            {
                i = ((RecordSegment)arraylist.get(0)).getCameraSetting().frameRate;
            } else
            {
                i = 30;
            }
            abyte0 = new byte[((RecordSession) (obj)).getVideoData().length];
            obj = new AudioArray(((RecordSession) (obj)).getAudioData().length, ((RecordSession) (obj)).getVersion().getAudioArrayType());
            mVideoController.writeToFile(RecordSegment.applyForEditedChanges(getFile().getSession(), abyte0, ((AudioArray) (obj)), arraylist), abyte0, ((AudioArray) (obj)), i);
            l = 0L;
            for (i = 0; i < arraylist.size(); i++)
            {
                RecordSegment recordsegment = (RecordSegment)arraylist.get(i);
                recordsegment.index = i;
                recordsegment.startTimestamp = l;
                l += RecordConfigUtils.getTimeStampInNsFromSampleCounted(recordsegment.getCombinedAudioData().size) / 1000;
                SLog.i("Timestamp modified to: {}.", Long.valueOf(recordsegment.startTimestamp));
            }

        }
    }

    private void releaseSegmentChangeDetector()
    {
        if (mSegmentChangeThread != null)
        {
            mSegmentChangeDetector.runThread = false;
            try
            {
                mSegmentChangeThread.join();
            }
            catch (InterruptedException interruptedexception) { }
            mSegmentChangeThread = null;
        }
    }

    private void returnToPreview(boolean flag)
    {
        if (mVideoController != null && mCurrentRecordingFile != null)
        {
            releaseSegmentChangeDetector();
            if (!flag)
            {
                commitChanges();
            }
            mCanKeepRecording = false;
            writePreviewToFile();
            startHashTask(false);
        }
    }

    private void showCameraSwitcher()
    {
        ViewGroup viewgroup = mCameraSwitcher;
        if (viewgroup != null && viewgroup.getVisibility() != 8)
        {
            viewgroup.setVisibility(0);
        }
    }

    protected void adjustBoundaries(CameraSetting camerasetting)
    {
        Activity activity = mActivity;
        if (activity == null || camerasetting == null) goto _L2; else goto _L1
_L1:
        float f = camerasetting.originalW;
        if (!camerasetting.frontFacing || camerasetting.frontFacingAspectRatio <= 0.0F) goto _L4; else goto _L3
_L3:
        f = (float)camerasetting.originalH * camerasetting.frontFacingAspectRatio;
_L6:
        if (camerasetting.frontFacingAspectRatio > 0.0F || camerasetting.backFacingAspectRatio > 0.0F)
        {
            CrashUtil.logException(new VineLoggingException((new StringBuilder()).append("Adjusting ratio originalW = ").append(camerasetting.originalW).append(" originalH = ").append(camerasetting.originalH).append(" hardware ").append("Hardware Version: ").append(Build.DEVICE).append(" - ").append(Build.MODEL).append(" (").append(Build.CPU_ABI).append(".").append(Build.HARDWARE).append(".").append(Build.BRAND).append(".").append(Build.PRODUCT).append(".").append(Build.MANUFACTURER).append(".").append(Build.CPU_ABI2).append(")").toString()));
        }
        if (mFinishLoadingOverlay != null && mVideoPlayer != null)
        {
            final android.view.ViewGroup.LayoutParams params = mVideoPlayer.getLayoutParams();
            params.width = mSize.x;
            params.height = mSize.x;
            mFinishLoadingOverlay.post(new Runnable() {

                final VineRecorder this$0;
                final android.view.ViewGroup.LayoutParams val$params;

                public void run()
                {
                    if (mFinishLoadingOverlay != null)
                    {
                        mFinishLoadingOverlay.setLayoutParams(params);
                    }
                }

            
            {
                this$0 = VineRecorder.this;
                params = layoutparams;
                super();
            }
            });
        }
        f /= camerasetting.originalH;
        int i = (int)((float)mSize.x * f);
        if (mTopMaskView != null && mBottomMaskView != null)
        {
            int j = mTopMaskView.getLayoutParams().height;
            int k = i / 2;
            int l = mSize.x / 2;
            final android.widget.RelativeLayout.LayoutParams cameraViewParams = (android.widget.RelativeLayout.LayoutParams)mCameraView.getLayoutParams();
            cameraViewParams.width = mSize.x;
            cameraViewParams.height = i;
            cameraViewParams.setMargins(0, (l + j) - k, 0, 0);
            i = mRootLayoutView.getMeasuredHeight() - j - mSize.x;
            final android.widget.RelativeLayout.LayoutParams bottomMaskParams = (android.widget.RelativeLayout.LayoutParams)mBottomMaskView.getLayoutParams();
            bottomMaskParams.height = i;
            activity.getSharedPreferences("capture", 0).edit().putInt(getBottomMaskHeightPref(camerasetting.frontFacing), i).commit();
            activity.runOnUiThread(new Runnable() {

                final VineRecorder this$0;
                final android.widget.RelativeLayout.LayoutParams val$bottomMaskParams;
                final android.widget.RelativeLayout.LayoutParams val$cameraViewParams;

                public void run()
                {
                    View view = mCameraView;
                    if (view != null)
                    {
                        SLog.d("Setting preview sizes to {} {}.", Integer.valueOf(cameraViewParams.width), Integer.valueOf(cameraViewParams.height));
                        view.setLayoutParams(cameraViewParams);
                    }
                    view = mBottomMaskView;
                    if (view != null)
                    {
                        view.setLayoutParams(bottomMaskParams);
                    }
                }

            
            {
                this$0 = VineRecorder.this;
                cameraViewParams = layoutparams;
                bottomMaskParams = layoutparams1;
                super();
            }
            });
        }
_L2:
        return;
_L4:
        if (camerasetting.backFacingAspectRatio > 0.0F)
        {
            f = (float)camerasetting.originalH * camerasetting.backFacingAspectRatio;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean canChangeFocus()
    {
        return mCurrentSegment == null && mVideoController.canChangeFocus();
    }

    public boolean canPickUpFloatView()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mPreviewLoadingOverlay != null)
        {
            flag = flag1;
            if (mPreviewLoadingOverlay.getVisibility() != 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public void changeProgress(long l)
    {
label0:
        {
            super.changeProgress(l);
            if (mProgressOverlay != null)
            {
                if (!SystemUtil.isOnMainThread())
                {
                    break label0;
                }
                mChangeProgressOverlayVisibilityRunnable.run();
            }
            return;
        }
        mHandler.post(mChangeProgressOverlayVisibilityRunnable);
    }

    public void doOneFrame()
    {
        if (mCurrentRecordingFile != null && !isEditing() && mAutoFocusing && startRelativeTime())
        {
            mHandler.postDelayed(new Runnable() {

                final VineRecorder this$0;

                public void run()
                {
                    endRelativeTime();
                }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
            }, 25L);
        }
    }

    public boolean endRelativeTime()
    {
        this;
        JVM INSTR monitorenter ;
        super.endRelativeTime();
        if (mGhostModeEnabled)
        {
            mVideoController.requestGhostDrawing(false);
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean floatViewDropped(int i)
    {
        boolean flag;
        flag = floatViewIntersectsTrashCan();
        animateTopButtons(0);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (i != 0 || mEditorAdapter.getCount() <= 1) goto _L4; else goto _L3
_L3:
        showThumbnailOverlay((RecordSegment)mEditorAdapter.getItem(1));
_L2:
        if (mPickedUpPosition != i || flag)
        {
            mPlayButtonOnClickListener.toPlay = null;
            mPlayButtonOnClickListener.forceRefresh = true;
        }
        if (!flag || mEditorAdapter.getCount() != 1)
        {
            animatePlayButton(true);
        }
        return flag;
_L4:
        if (mEditorAdapter.getCount() > 1)
        {
            showThumbnailOverlay((RecordSegment)mEditorAdapter.getItem(0));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void floatViewLanded(int i)
    {
    }

    public void floatViewMoved()
    {
        boolean flag;
        if (floatViewIntersectsTrashCan() && mDragSortWidget.canDelete())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            animateTopButtons(1);
            return;
        } else
        {
            animateTopButtons(0);
            return;
        }
    }

    public void floatViewPickedUp(int i)
    {
        mPickedUpPosition = i;
        if (mEditorAdapter != null)
        {
            RecordSegment recordsegment = (RecordSegment)mEditorAdapter.getItem(i);
            showThumbnailOverlay(recordsegment);
            mPlayButtonOnClickListener.toPlay = recordsegment;
            mPlayButtonOnClickListener.forceRefresh = false;
        }
        pausePreview(false);
    }

    public int getCurrentlyPlayingPosition()
    {
        if (mLastSelectedPosition == -1 && mSegmentChangeDetector != null)
        {
            if (mSegmentChangeDetector.lastFirstItem >= 0 && mEditorAdapter != null && mSegmentChangeDetector.lastFirstItem < mEditorAdapter.getCount())
            {
                return mSegmentChangeDetector.lastFirstItem;
            } else
            {
                return 0;
            }
        } else
        {
            return mLastSelectedPosition;
        }
    }

    protected BasicVineRecorder.FinishProcessRunnable getFinishProcessRunnable()
    {
        return new BasicVineRecorder.FinishProcessRunnable() {

            final VineRecorder this$0;

            public boolean doNotDeleteSession(boolean flag)
            {
                return flag || mInitiallyStartedWithEditMode;
            }

            public boolean isCompleteSession(boolean flag)
            {
                return flag || mInitiallyStartedWithEditMode;
            }

            protected void onPreCompleteSession(boolean flag)
            {
                if (flag)
                {
                    mLastPlayingSegment = new RecordSegment(mCurrentDuration);
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super(VineRecorder.this);
            }
        };
    }

    public BaseFinishProcessTask getFinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        if (mFastEncoding)
        {
            return new RegularVineRecorder.FinishProcessTask(s, runnable, flag, flag1) {

                final VineRecorder this$0;

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    animateSpinner(mFinishLoadingOverlay, false);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    animateSpinner(mFinishLoadingOverlay, true);
                }

            
            {
                this$0 = VineRecorder.this;
                super(VineRecorder.this, s, runnable, flag, flag1);
            }
            };
        } else
        {
            return super.getFinishProcessTask(s, runnable, flag, flag1);
        }
    }

    public View getGhostView()
    {
        return mGhostView;
    }

    public BasicVineRecorder.OnResumeTask getOnResumeTask(View view, String s)
    {
        return new RegularVineRecorder.OnResumeTask(view, s) {

            final VineRecorder this$0;

            protected void onPostExecute(RecordingFile recordingfile)
            {
                super.onPostExecute(recordingfile);
                invalidateZoomSlider();
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((RecordingFile)obj);
            }

            
            {
                this$0 = VineRecorder.this;
                super(VineRecorder.this, view, s);
            }
        };
    }

    public View getProgressView()
    {
        return mProgressView;
    }

    public Point getSize()
    {
        return mSize;
    }

    public void hideThumbnailOverlay()
    {
        if (mThumbnailOverlay != null)
        {
            mThumbnailOverlay.animate().setDuration(mShortAnimTime).alpha(0.0F).setListener(new ViewGoneAnimationListener(mThumbnailOverlay)).start();
            mThumbnailOverlay.setImageDrawable(null);
        }
    }

    public void hideThumbnailOverlayDelayed()
    {
        getHandler().postDelayed(new Runnable() {

            final VineRecorder this$0;

            public void run()
            {
                hideThumbnailOverlay();
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        }, 100L);
    }

    protected void invalidateFinishButton()
    {
        if (mCurrentDuration < (long)mThresholdMs)
        {
            View view = mFinishButton;
            if (view != null)
            {
                view.setVisibility(8);
            }
            return;
        } else
        {
            onProgressThresholdReached();
            return;
        }
    }

    public boolean isAutoFocusing()
    {
        return mAutoFocusing;
    }

    public boolean isEditing()
    {
        return mEditing && mEditorAdapter != null;
    }

    public boolean isEditingDirty()
    {
        return isEditing() && !mEditorAdapter.compareTo(mEditedSegments);
    }

    public void modifyZoom(boolean flag)
    {
        if (mVideoController.isRecordingStarted())
        {
            mVideoController.modifyZoom(flag);
        }
    }

    public void onCameraReady(RecordController recordcontroller)
    {
        if (mActivity != null)
        {
            if (mSession.getConfig().flashSwitchEnabled)
            {
                View view = mFlashSwitcher;
                if (view != null)
                {
                    int i;
                    if (mVideoController.isFlashSupported())
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    view.setVisibility(i);
                }
            }
            mHandler.post(onCameraReadyRunnable);
            super.onCameraReady(recordcontroller);
        }
    }

    public void onCameraSwitcherPressed(View view)
    {
        mCameraSwitcherViewListener.onClick(view);
    }

    public boolean onGhostSwitchPressed()
    {
        boolean flag;
        if (!mGhostModeEnabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return setGhostMode(flag);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        this;
        JVM INSTR monitorenter ;
        i;
        JVM INSTR tableswitch 27 27: default 20
    //                   27 28;
           goto _L1 _L2
_L1:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        keyevent.getAction();
        JVM INSTR tableswitch 0 1: default 77
    //                   0 56
    //                   1 69;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        startRelativeTime();
        break; /* Loop/switch isn't completed */
        view;
        throw view;
_L5:
        endRelativeTime();
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onPause()
    {
        super.onPause();
        if (android.os.Build.VERSION.SDK_INT >= 16 && mMediaActionSound != null)
        {
            mMediaActionSound.release();
        }
    }

    public void onPrepared(VideoViewInterface videoviewinterface)
    {
        if (mDragSortWidget != null)
        {
            if (mDragSortWidget.hasFloatView())
            {
                pausePreview(false);
            }
            hideThumbnailOverlayDelayed();
            animatePreviewSpinner(false);
        }
    }

    public void onProgressMaxReached()
    {
        if (!mHasPreviewedAlready)
        {
            finish("progressMaxReached");
        }
    }

    public void onProgressThresholdReached()
    {
        View view = mFinishButton;
        if (view != null)
        {
            view.setVisibility(0);
        }
    }

    public void onResume(String s, boolean flag)
    {
        boolean flag3;
        flag3 = true;
        boolean flag4 = canKeepRecording();
        boolean flag5 = isEditing();
        boolean flag1;
        if (finalFile != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        CrashUtil.log("Resume VineRecorder: delayDialog: {} canKeepRecording: {} isEditing: {} NullFinalFile: {}.", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag4), Boolean.valueOf(flag5), Boolean.valueOf(flag1)
        });
        if (!flag4) goto _L2; else goto _L1
_L1:
        if (isEditing()) goto _L4; else goto _L3
_L3:
        initPreviewSurface();
        if (!mStartWithEditMode) goto _L6; else goto _L5
_L5:
        setEditMode(true, false);
_L8:
        return;
_L6:
        mResumeTask = getOnResumeTask(null, (new StringBuilder()).append("OnResume_").append(s).toString());
        s = mResumeTask;
        boolean flag2 = flag3;
        if (!flag)
        {
            if (mCurrentRecordingFile.isSavedSession && mNeverResumedRecorder)
            {
                flag2 = flag3;
            } else
            {
                flag2 = false;
            }
        }
        s.showDialogDelayed = flag2;
        mResumeTask.execute(new Void[0]);
        return;
_L4:
        setEditMode(true, false);
        return;
_L2:
        if (finalFile != null)
        {
            mOnCompleteConsumer.run();
            return;
        }
        if (mStartProgressDialog != null)
        {
            mStartProgressDialog.setMessage(mFinishLastSegmentString);
            if (!flag)
            {
                try
                {
                    mStartProgressDialog.show();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return;
                }
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onSelectionChanged(int i, boolean flag)
    {
        mLastSelectedPosition = i;
        SegmentEditorAdapter segmenteditoradapter = mEditorAdapter;
        if (segmenteditoradapter != null)
        {
            if (i != -1 && i < mEditedSegments.size())
            {
                animateTopButtons(0);
                RecordSegment recordsegment = (RecordSegment)segmenteditoradapter.getItem(i);
                if (flag)
                {
                    playPreview(recordsegment, true);
                }
                segmenteditoradapter.commitDelete();
            } else
            if (segmenteditoradapter.getCount() > 0)
            {
                animateTopButtons(2);
                if (flag)
                {
                    playPreview(null, true);
                } else
                if (mLastPlayingSegment != null && !flag)
                {
                    pausePreview(true);
                }
                if (mDragSortWidget != null)
                {
                    mDragSortWidget.setFocused(0);
                    return;
                }
            } else
            {
                mVideoPlayer.suspend();
                animatePlayButton(false);
                animatePreviewSpinner(false);
                hideThumbnailOverlay();
                animateTopButtons(2);
                mVideoPlayer.setVisibility(8);
                return;
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        this;
        JVM INSTR monitorenter ;
        if (isEditing()) goto _L2; else goto _L1
_L1:
        boolean flag = super.onTouch(view, motionevent);
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        view;
        throw view;
    }

    public void onUiPaused()
    {
        releaseSegmentChangeDetector();
        if (mDragSortWidget != null)
        {
            mDragSortWidget.releaseReferences();
        }
        mResources = null;
        try
        {
            if (mRefreshPreviewTask != null)
            {
                mRefreshPreviewTask.cancel(false);
            }
        }
        catch (Exception exception)
        {
            SLog.e("It's probably detached already.", exception);
        }
        if (mVideoPlayer != null)
        {
            mVideoPlayer.setOnErrorListener(null);
            mVideoPlayer.setOnPreparedListener(null);
        }
        mRefreshPreviewTask = null;
        mRecordingOptions = null;
        mPreviewLoadingOverlay = null;
        if (mFlashSwitcher != null)
        {
            mFlashSwitcher.setOnClickListener(null);
        }
        mFinishLoadingOverlay = null;
        mFlashSwitcher = null;
        mZoomSeek = null;
        mZoomSeekContainer = null;
        mCameraSwitcher = null;
        mTrashUndoContainer = null;
        mThumbnailList = null;
        if (mPlayButtonContainer != null)
        {
            mPlayButtonContainer.setOnTouchListener(null);
            mPlayButtonContainer.setOnClickListener(null);
        }
        mPlayButtonContainer = null;
        mThumbnailSegment = null;
        if (mEditorCancelButton != null)
        {
            mEditorCancelButton.setOnClickListener(null);
        }
        mEditorCancelButton = null;
        if (mEditorDoneButton != null)
        {
            mEditorDoneButton.setOnClickListener(null);
        }
        mEditorDoneButton = null;
        if (mTrashCanButton != null)
        {
            mTrashCanButton.setOnClickListener(null);
            mTrashCanButton.setOnTouchListener(null);
        }
        mTrashCanButton = null;
        mEditorButtons = null;
        mThumbnailOverlay = null;
        mFocusView = null;
        if (mDragSortWidget != null)
        {
            mDragSortWidget.setSelectionChangedListener(null);
            mDragSortWidget.setFloatViewInteractionListener(null);
            mDragSortWidget.setCurrentlyPlayingProvider(null);
        }
        mDragSortWidget = null;
        mGridSwitch = null;
        if (mFinishButton != null)
        {
            mFinishButton.setOnClickListener(null);
        }
        mFinishButton = null;
        super.onUiPaused();
    }

    public void onUiResumed(Activity activity, Runnable runnable, boolean flag)
    {
        super.onUiResumed(activity, runnable, flag);
        mResources = activity.getResources();
        mRecordingOptions = activity.findViewById(mRecordingOptionsRowId);
        mThumbnailList = activity.findViewById(0x102000a);
        mThumbnailOverlay = (ImageView)activity.findViewById(mThumbnailOverlayId);
        mTrashUndoContainer = activity.findViewById(mTrashUndoContainerId);
        mTrashUndoContainer.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VineRecorder this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (mTrashUndoContainer != null)
                {
                    return mTrashUndoContainer.isActivated();
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mFinishLoadingOverlay = activity.findViewById(mFinishLoadingOverlayId);
        mPlayButtonContainer = activity.findViewById(mPlayButtonContainerId);
        mPlayButtonOnClickListener = new PlayButtonOnClickListener();
        mPlayButtonContainer.setOnClickListener(mPlayButtonOnClickListener);
        mPlayButtonContainer.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VineRecorder this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (mDragSortWidget != null)
                {
                    return mDragSortWidget.onTouch((View)mVideoPlayer.getParent(), motionevent, mPlayButtonContainer.getLeft(), mPlayButtonContainer.getTop());
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mFinishButton = activity.findViewById(mFinishButtonId);
        mFinishButton.setOnClickListener(mFinishClicker);
        mPlayButton = ((ViewGroup)mPlayButtonContainer).getChildAt(0);
        mPlayRefreshButton = ((ViewGroup)mPlayButtonContainer).getChildAt(1);
        mDragSortWidget = (DragSortWidget)activity.findViewById(mDragSortWidgetId);
        mDragSortWidget.setSelectionChangedListener(this);
        mDragSortWidget.setFloatViewInteractionListener(this);
        mDragSortWidget.setCurrentlyPlayingProvider(this);
        mEditorButtons = activity.findViewById(mEditorButtonsId);
        mEditorButtons.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VineRecorder this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mEditorDoneButton = activity.findViewById(mEditorDoneButtonId);
        mPreviewLoadingOverlay = activity.findViewById(mPreviewLoadingOverlayId);
        mEditorDoneButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VineRecorder this$0;

            public void onClick(View view)
            {
                boolean flag1 = true;
                if (mReturnToPreview && getDurationFromSegments() >= (long)mThresholdMs)
                {
                    animateEditModeControlsOut(true);
                    returnToPreview(false);
                    return;
                }
                view = VineRecorder.this;
                View view1 = mEditorDoneButton;
                if (mEditing)
                {
                    flag1 = false;
                }
                view.setEditMode(view1, flag1, false);
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mTrashCanButton = activity.findViewById(mTrashCanButtonId);
        mTrashCanButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VineRecorder this$0;

            public void onClick(View view)
            {
                mPlayButtonOnClickListener.toPlay = null;
                mPlayButtonOnClickListener.forceRefresh = true;
                if (mDragSortWidget != null)
                {
                    mDragSortWidget.removeSelection();
                }
                animateTopButtons(2);
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mUndoButton = activity.findViewById(mUndoButtonId);
        mUndoButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VineRecorder this$0;

            public void onClick(View view)
            {
                mPlayButtonOnClickListener.toPlay = null;
                mPlayButtonOnClickListener.forceRefresh = true;
                pausePreview(true);
                if (mEditorAdapter != null)
                {
                    mEditorAdapter.undoDelete();
                    showThumbnailOverlay((RecordSegment)mEditorAdapter.getItem(0));
                }
                animateTopButtons(2);
                if (mUndoButton != null)
                {
                    mUndoButton.setVisibility(8);
                }
                if (mDragSortWidget != null)
                {
                    mDragSortWidget.setFocused(0);
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mTrashCanButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VineRecorder this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                switch (motionevent.getAction())
                {
                default:
                    return false;

                case 0: // '\0'
                    animateTopButtons(1);
                    return false;

                case 2: // '\002'
                    animateTopButtons(1);
                    return false;

                case 1: // '\001'
                    animateTopButtons(0);
                    return false;
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mEditorCancelButton = activity.findViewById(mEditorCancelButtonId);
        mEditorCancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final VineRecorder this$0;

            public void onClick(View view)
            {
                if (mReturnToPreview)
                {
                    returnToPreview(true);
                    return;
                }
                view = VineRecorder.this;
                View view1 = mEditorCancelButton;
                boolean flag1;
                if (!mEditing)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                view.setEditMode(view1, flag1, true);
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        mGridSwitch = (ToggleButton)activity.findViewById(mGridSwitchId);
        mFocusView = activity.findViewById(mFocusViewResourceId);
        if (!isEditing() && mCurrentDuration >= (long)mThresholdMs)
        {
            onProgressThresholdReached();
        }
        if (mCameraSwitcherId > 0)
        {
            mCameraSwitcher = (ViewGroup)activity.findViewById(mCameraSwitcherId);
            if (!RecordConfigUtils.getGenericConfig(activity).cameraSwitchEnabled)
            {
                mCameraSwitcher.setVisibility(8);
            } else
            {
                mCameraSwitcher.setOnClickListener(mCameraSwitcherViewListener);
            }
        } else
        {
            mCameraSwitcher = null;
        }
        mProgressView.setOnClickListener(new android.view.View.OnClickListener() {

            final VineRecorder this$0;

            public void onClick(View view)
            {
                if (!mIsMessaging)
                {
                    view = VineRecorder.this;
                    ProgressView progressview = mProgressView;
                    boolean flag1;
                    if (!mEditing)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    view.setEditMode(progressview, flag1, false);
                }
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        if (mZoomSeekContainerId > 0 && mZoomSeekId > 0)
        {
            mZoomSeekContainer = activity.findViewById(mZoomSeekContainerId);
            mZoomSeek = (SeekBar)activity.findViewById(mZoomSeekId);
            mZoomSeek.setProgress(0);
            mZoomSeek.setOnSeekBarChangeListener(mZoomSeekListener);
        }
        if (mFlashSwitcherId > 0)
        {
            mFlashSwitcher = activity.findViewById(mFlashSwitcherId);
            if (mSession.getConfig().flashSwitchEnabled)
            {
                mFlashSwitcher.setVisibility(0);
                mFlashSwitcher.setOnClickListener(mSwitchFlashViewListener);
            } else
            {
                mFlashSwitcher.setVisibility(8);
            }
        } else
        {
            mFlashSwitcher = null;
        }
        if (canSwitchCamera())
        {
            showCameraSwitcher();
        }
        mIsSwitchingCamera = false;
        mProgressOverlay = activity.findViewById(mProgressOverlayId);
        if (!flag)
        {
            onResume("UI Resume", false);
        }
    }

    public void onZoomUpdated(int i, boolean flag)
    {
        mLastUpdatedZoom = i;
        SLog.d((new StringBuilder()).append("Zoom updated: ").append(i).toString());
        if (mZoomSeek != null && flag)
        {
            mLastUpdatedZoom = -1;
            SLog.d((new StringBuilder()).append("Zoom progress updated: ").append(i).toString());
            mZoomSeek.setProgress(i - 1);
            mHandler.removeCallbacks(mZoomUpdateRunnable);
        }
    }

    public void pausePreview(boolean flag)
    {
        if (flag)
        {
            animatePlayButton(true);
        } else
        {
            animatePlayButton(false);
        }
        if (mRefreshPreviewTask != null)
        {
            mRefreshPreviewTask.cancel(true);
        }
        mVideoPlayer.pause();
    }

    public void playPreview(RecordSegment recordsegment, boolean flag)
    {
        animatePlayButton(false);
        refreshVideoView(recordsegment, flag);
    }

    public void playStartRecordingSound()
    {
        try
        {
            if (android.os.Build.VERSION.SDK_INT >= 16 && mMediaActionSound != null && mPlaySound)
            {
                mMediaActionSound.play(2);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void playStopRecordingSound()
    {
        try
        {
            if (android.os.Build.VERSION.SDK_INT >= 16 && mMediaActionSound != null && mPlaySound)
            {
                mMediaActionSound.play(3);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void refreshVideoView(RecordSegment recordsegment, boolean flag)
    {
        releaseSegmentChangeDetector();
        mSegmentChangeDetector = new SegmentChangeDetector();
        mSegmentChangeThread = new Thread(mSegmentChangeDetector);
        mSegmentChangeThread.start();
        if (mLastPlayingSegment != recordsegment || flag)
        {
            if (mEditorAdapter.getCount() > 0)
            {
                showThumbnailOverlay(recordsegment);
            }
            if (recordsegment == null && mDragSortWidget != null)
            {
                mDragSortWidget.setFocused(0);
            }
            if (mRefreshPreviewTask != null)
            {
                mRefreshPreviewTask.cancel(true);
            }
            mVideoPlayer.suspend();
            animatePreviewSpinner(true);
            mRefreshPreviewTask = new RefreshPreviewTask(recordsegment);
            mRefreshPreviewTask.execute(new Void[0]);
            return;
        } else
        {
            mVideoPlayer.resume();
            hideThumbnailOverlayDelayed();
            animatePreviewSpinner(false);
            return;
        }
    }

    public boolean release()
    {
        mLastPlayingSegment = null;
        return super.release();
    }

    public void requestZoomProgressUpdate()
    {
        if (CameraManager.getInstance().isSmoothZoomingSupported())
        {
            mHandler.postDelayed(mZoomUpdateRunnable, 30L);
        }
    }

    public void reverseFrames()
    {
        if (isEditing())
        {
            mEditorAdapter.reverse();
        }
    }

    public void saveSession(Runnable runnable, boolean flag)
    {
        mCanKeepRecording = false;
        stop("saveSession", runnable, flag, true);
    }

    public void setAutoFocusing(boolean flag)
    {
        if (mVideoController != null)
        {
            mAutoFocusing = flag;
            mVideoController.setAutoFocus(mAutoFocusing);
            if (mAutoFocusing)
            {
                dismissFocusIndicator();
            }
        }
    }

    public void setDiscardChanges(boolean flag)
    {
        mDiscardChanges = flag;
    }

    public void setEditMode(View view, boolean flag, boolean flag1)
    {
        CrashUtil.log("Set edit mode: {} {}.", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1)
        });
        if (mTimelapsing && SLog.sLogsOn)
        {
            mTimelapsing = false;
            mHandler.removeCallbacks(mTimeLapseRunnable);
        } else
        {
            final boolean wasEditingAlready = mEditing;
            mEditing = flag;
            mUndoButton.setVisibility(8);
            if (mCurrentRecordingFile.hasData())
            {
                if (mEditing)
                {
                    mStartWithEditMode = false;
                    if (canKeepRecording())
                    {
                        if (mVideoController.isRecordingStarted())
                        {
                            stop("editMode", new Runnable() {

                                final VineRecorder this$0;
                                final boolean val$wasEditingAlready;

                                public void run()
                                {
                                    startEditMode(wasEditingAlready);
                                }

            
            {
                this$0 = VineRecorder.this;
                wasEditingAlready = flag;
                super();
            }
                            }, true, false);
                            return;
                        } else
                        {
                            startEditMode(wasEditingAlready);
                            return;
                        }
                    } else
                    {
                        mEditing = false;
                        return;
                    }
                }
                releaseSegmentChangeDetector();
                if (mRefreshPreviewTask != null)
                {
                    mRefreshPreviewTask.cancel(true);
                }
                if (mVideoPlayer != null)
                {
                    mVideoPlayer.stopPlayback();
                }
                if (mDragSortWidget != null)
                {
                    mDragSortWidget.cleanUp();
                }
                if (mIsGridOn)
                {
                    setGridOn(false);
                    mGridSwitch.setChecked(mIsGridOn);
                }
                if (mGhostModeEnabled)
                {
                    setGhostMode(false);
                }
                if (!flag1)
                {
                    if (commitChanges())
                    {
                        int i = mEditedSegments.size();
                        if (i > 0 && mVideoController != null)
                        {
                            mVideoController.makePreview((RecordSegment)mEditedSegments.get(i - 1), true);
                        }
                    }
                    if (mCurrentRecordingFile != null)
                    {
                        mCurrentRecordingFile.invalidateGhostThumbnail();
                    }
                }
                animateEditModeControlsOut(true);
                animateCaptureControlsIn();
                invalidateGhostView();
                invalidateFinishButton();
                setHasPreviewedAlreadyIfNeeded();
                mReturnToPreview = false;
                mResumeTask = new RegularVineRecorder.OnResumeTask(this, view, "Set EditMode.");
                mResumeTask.execute(new Void[0]);
                mEditorAdapter = null;
                return;
            }
            mEditing = false;
            if (SLog.sLogsOn)
            {
                showTimeLapseDialog();
                return;
            }
        }
    }

    public void setEditMode(boolean flag, boolean flag1)
    {
        setEditMode(null, flag, flag1);
    }

    public boolean setGhostMode(boolean flag)
    {
        if (mGhostView != null)
        {
            if (flag)
            {
                mGhostView.setVisibility(0);
            } else
            {
                mGhostView.setVisibility(8);
            }
            mGhostModeEnabled = flag;
            if (mGhostModeEnabled)
            {
                mVideoController.requestGhostDrawing(false);
            } else
            {
                updateGhostBitmap(null);
            }
            mGhostButton.setChecked(flag);
            return flag;
        } else
        {
            return false;
        }
    }

    public void setGridOn(boolean flag)
    {
        mIsGridOn = flag;
    }

    protected void setHasPreviewedAlreadyIfNeeded()
    {
        boolean flag;
        if (mCurrentDuration >= (long)mSession.getConfig().maxDuration)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasPreviewedAlready = flag;
    }

    public void showFocusIndicator(int i, int j)
    {
        if (mFocusIndicator != null)
        {
            int k = mFocusIndicator.getMeasuredWidth();
            int l = mFocusIndicator.getMeasuredHeight();
            mFocusIndicator.layout(i - k / 2, j - l / 2, k / 2 + i, l / 2 + j);
            mFocusIndicator.setVisibility(0);
            mFocusIndicator.startAnimation(mFocusAnimationSet);
        }
    }

    public void showThumbnailOverlay(RecordSegment recordsegment)
    {
        RecordSegment recordsegment1;
label0:
        {
            recordsegment1 = recordsegment;
            if (mThumbnailOverlay == null)
            {
                break label0;
            }
            if (mThumbnailOverlay.getVisibility() == 0)
            {
                recordsegment1 = recordsegment;
                if (recordsegment == mThumbnailSegment)
                {
                    break label0;
                }
            }
            mThumbnailOverlay.setVisibility(0);
            mThumbnailOverlay.setAlpha(1.0F);
            recordsegment1 = recordsegment;
            if (recordsegment == null)
            {
                recordsegment1 = recordsegment;
                if (mEditorAdapter.getCount() > 0)
                {
                    recordsegment1 = (RecordSegment)mEditorAdapter.getItem(0);
                }
            }
            recordsegment = recordsegment1.getDrawableCopy(mActivity);
            mThumbnailOverlay.setImageDrawable(recordsegment);
        }
        mThumbnailSegment = recordsegment1;
    }

    public void showTimeLapseDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mActivity);
        builder.setTitle("Time Lapse Mode");
        LinearLayout linearlayout = new LinearLayout(mActivity);
        final EditText et = new EditText(mActivity);
        et.setInputType(8194);
        et.setHint("time in seconds, decimals OK.");
        linearlayout.addView(et);
        builder.setView(linearlayout);
        builder.setPositiveButton("Start", new android.content.DialogInterface.OnClickListener() {

            final VineRecorder this$0;
            final EditText val$et;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (mVideoController != null)
                {
                    mVideoController.setAudioTrim(true);
                    startTimeLapse(Double.parseDouble(et.getText().toString()));
                }
                dialoginterface.dismiss();
            }

            
            {
                this$0 = VineRecorder.this;
                et = edittext;
                super();
            }
        });
        builder.setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final VineRecorder this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = VineRecorder.this;
                super();
            }
        });
        builder.show();
    }

    public void startEditMode(boolean flag)
    {
        adjustEditBoundaries();
        if (!mReturnToPreview)
        {
            animateCaptureControlsOut();
        } else
        {
            hideCaptureControls();
        }
        animateEditModeControlsIn();
        if (mTrashUndoContainer != null)
        {
            mTrashUndoContainer.setActivated(false);
        }
        mLastSelectedPosition = -1;
        mLastPlayingSegment = null;
        if (!flag)
        {
            mEditorAdapter = new SegmentEditorAdapter(mEditedSegments, mActivity, density);
        } else
        {
            mEditorAdapter = new SegmentEditorAdapter(mEditorAdapter);
        }
        if (mEditorAdapter.canUndoDelete())
        {
            mUndoButton.setVisibility(0);
        } else
        {
            mUndoButton.setVisibility(4);
        }
        if (mDragSortWidget != null)
        {
            mDragSortWidget.setAdapter(mEditorAdapter);
            mEditorAdapter.notifyDataSetChanged();
            mDragSortWidget.setSelection(-1);
            mDragSortWidget.setFocused(0);
        }
        setGhostMode(false);
        if (mGridSwitch != null)
        {
            mGridSwitch.setChecked(false);
        }
        refreshVideoView(null, true);
    }

    public void startTimeLapse(double d)
    {
        mTimeLapseDelay = 1000D * d;
        mTimelapsing = true;
        mTimeLapseRunnable.run();
    }

    public void stopZoom()
    {
        if (mVideoController.isRecordingStarted())
        {
            mVideoController.stopZoom();
            mHandler.removeCallbacks(mZoomUpdateRunnable);
        }
    }

    public RecordingFile swapSession(String s, RecordingFile recordingfile)
    {
        RecordingFile recordingfile1 = null;
        if (recordingfile != null)
        {
            recordingfile1 = super.swapSession(s, recordingfile);
            invalidateGhostView();
            setGhostMode(false);
        }
        return recordingfile1;
    }

    public void switchFlash()
    {
        mVideoController.switchFlash();
    }

    public void updateGhostBitmap(final Bitmap ghostBitmap)
    {
        mHandler.post(new Runnable() {

            final VineRecorder this$0;
            final Bitmap val$ghostBitmap;

            public void run()
            {
                if (ghostBitmap == null)
                {
                    if (mGhostView != null)
                    {
                        mGhostView.setVisibility(8);
                    }
                } else
                if (mResources != null && mGhostView != null)
                {
                    if (mEditedSegments.size() == 0)
                    {
                        mGhostView.setVisibility(8);
                        return;
                    }
                    if (mGhostView.getVisibility() != 0)
                    {
                        mGhostView.setVisibility(0);
                    }
                    mGhostView.setImageDrawable(new BitmapDrawable(mResources, ghostBitmap));
                    return;
                }
            }

            
            {
                this$0 = VineRecorder.this;
                ghostBitmap = bitmap;
                super();
            }
        });
    }

    public void writePreviewToFile()
    {
        if (mEditedSegments.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        mCurrentFrameRate = ((RecordSegment)mEditedSegments.get(0)).getCameraSetting().frameRate;
_L1:
        SwVineFrameRecorder swvineframerecorder = RecordConfigUtils.newVideoRecorder((new StringBuilder()).append(mCurrentRecordingFile.getVideoPath()).append(".video").append(RecordConfigUtils.VIDEO_CONTAINER_EXT).toString(), mCurrentFrameRate, 480, mUseMp4);
        swvineframerecorder.start();
        RecordSession recordsession = getFile().getSession();
        (new SwCombiningRunnable(getFile(), false, recordsession.getAudioData(), recordsession.getVideoData(), mEditedSegments, swvineframerecorder, mVideoController.getFinishProcessTask(), mVideoController.getPreviewBitmap(), mVideoController.getFrameBuffer())).combineVideos();
        return;
        try
        {
            mCurrentFrameRate = 30;
        }
        catch (SwVineFrameRecorder.Exception exception)
        {
            CrashUtil.logException(exception, "Cannot start audio/video recorder. ", new Object[0]);
            return;
        }
          goto _L1
    }






/*
    static RecordSegment access$1102(VineRecorder vinerecorder, RecordSegment recordsegment)
    {
        vinerecorder.mLastPlayingSegment = recordsegment;
        return recordsegment;
    }

*/
















/*
    static AttributeSet access$2402(VineRecorder vinerecorder, AttributeSet attributeset)
    {
        vinerecorder.mVideoAttr = attributeset;
        return attributeset;
    }

*/






















/*
    static int access$4402(VineRecorder vinerecorder, int i)
    {
        vinerecorder.mLastSelectedPosition = i;
        return i;
    }

*/






}
