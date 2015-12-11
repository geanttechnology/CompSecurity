// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.recorder.InlineVineRecorder;
import co.vine.android.recorder.ProgressView;
import co.vine.android.recorder.RecordSession;
import co.vine.android.recorder.RecordSessionManager;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.recorder.ViewGoneAnimationListener;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import java.io.IOException;

// Referenced classes of package co.vine.android:
//            ConversationFragment, ConversationActivity

public class InlineRecorderManager extends RelativeLayout
    implements co.vine.android.recorder.InlineVineRecorder.ProcessingListener
{
    private class FinishRunnable
        implements Runnable
    {

        final InlineRecorderManager this$0;

        public void run()
        {
            mRecordingButtonContainer.setVisibility(0);
            mFragment.prepareUpload();
            mRecorder.deleteCurrentDraftFolder("inline finish.");
            mRecorder.swapSession("Inline record", getNewMessageRecordingFile());
            mTextToggle.setVisibility(0);
            mTextToggle.setEnabled(true);
            mFinishProgressView.animate().alpha(0.0F).setListener(new ViewGoneAnimationListener(mFinishProgressView)).start();
        }

        private FinishRunnable()
        {
            this$0 = InlineRecorderManager.this;
            super();
        }

    }

    public class ResumeThread extends Thread
    {

        private RecordingFile mFileToResume;
        final InlineRecorderManager this$0;

        public void run()
        {
            long l;
            try
            {
                Thread.sleep(1500L);
            }
            catch (InterruptedException interruptedexception)
            {
                SLog.e("Failed to sleep wait.");
            }
            l = System.currentTimeMillis();
            SLog.d("Start resuming for inline.");
            mRecorder.initPreviewSurface();
            mRecorder.swapSession("Inline record", mFileToResume);
            mFileToResume = null;
            mRecorder.start("Inline record", false, false);
            mIsWaitingForResumeThread = false;
            CrashUtil.log("Inline resume took {}ms.", new Object[] {
                Long.valueOf(System.currentTimeMillis() - l)
            });
        }

        public ResumeThread()
            throws IOException
        {
            this$0 = InlineRecorderManager.this;
            super();
            try
            {
                mFileToResume = getNewMessageRecordingFile();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InlineRecorderManager inlinerecordermanager)
            {
                throw new IOException("Failed to create new recording file.");
            }
        }
    }

    private class StartInlineRecording
        implements Runnable
    {

        final InlineRecorderManager this$0;

        public void run()
        {
            toggleRecorder(true);
            mFinishProgressView.setVisibility(0);
            mFinishProgressView.setAlpha(1.0F);
            mFinishProgressView.setProgressRatio(0.0F);
        }

        private StartInlineRecording()
        {
            this$0 = InlineRecorderManager.this;
            super();
        }

    }


    private static final long CLICK_LENGTH = 200L;
    private View mCameraView;
    private boolean mCanInline;
    private boolean mDownWasInRecordButton;
    private ProgressView mFinishProgressView;
    private FinishRunnable mFinishRunnable;
    private ConversationFragment mFragment;
    private Handler mHandler;
    private boolean mIsWaitingForResumeThread;
    private boolean mProcessing;
    private InlineVineRecorder mRecorder;
    private View mRecordingButtonContainer;
    private View mRecordingContainer;
    private ResumeThread mResumeThread;
    private Runnable mStartInlineRecording;
    private TextView mSwipeUpText;
    private View mTextToggle;
    private View mTopMask;
    private RecordSessionVersion mVersion;

    public InlineRecorderManager(Context context)
    {
        super(context);
        mStartInlineRecording = new StartInlineRecording();
        mFinishRunnable = new FinishRunnable();
    }

    public InlineRecorderManager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mStartInlineRecording = new StartInlineRecording();
        mFinishRunnable = new FinishRunnable();
    }

    public InlineRecorderManager(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mStartInlineRecording = new StartInlineRecording();
        mFinishRunnable = new FinishRunnable();
    }

    private RecordingFile getNewMessageRecordingFile()
    {
        RecordingFile recordingfile;
        try
        {
            recordingfile = new RecordingFile(mVersion.getManager(mFragment.getActivity()).createFolderForSession(), RecordSession.newSession(new co.vine.android.recorder.RecordConfigUtils.RecordConfig(mFragment.getActivity()), mVersion), false, false, false);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        return recordingfile;
    }

    private boolean isInCancelZone(float f)
    {
        ViewGroup viewgroup = (ViewGroup)mRecordingButtonContainer.getParent();
        return f < (float)(getMeasuredHeight() - viewgroup.getHeight() * 2);
    }

    private boolean isInRecordButton(MotionEvent motionevent)
    {
        if (mFragment == null || mFragment.isInTextInputMode())
        {
            return false;
        } else
        {
            ViewGroup viewgroup = (ViewGroup)mRecordingButtonContainer.getParent();
            Rect rect = new Rect();
            mRecordingButtonContainer.getHitRect(rect);
            rect.offset(viewgroup.getLeft(), viewgroup.getTop());
            return rect.contains((int)motionevent.getX(), (int)motionevent.getY());
        }
    }

    private void toggleRecorder(boolean flag)
    {
label0:
        {
            if (mCanInline)
            {
                if (!flag)
                {
                    break label0;
                }
                mCameraView.setVisibility(0);
                InlineVineRecorder.startnanos = System.nanoTime();
                mRecordingContainer.setAlpha(0.01F);
                mRecordingContainer.setVisibility(0);
                mRecordingContainer.animate().alpha(1.0F).setDuration(250L).start();
                mTopMask.setVisibility(0);
                mTextToggle.setVisibility(8);
                mTextToggle.setEnabled(false);
                mRecorder.onResume("start", true);
                mFragment.onRecorderShown();
            }
            return;
        }
        mRecordingContainer.animate().alpha(0.0F).setListener(new ViewGoneAnimationListener(mRecordingContainer)).start();
        mFragment.onRecorderHidden();
        mRecordingButtonContainer.setVisibility(0);
    }

    private void waitForResume()
    {
        if (!mIsWaitingForResumeThread)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        mResumeThread.join();
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        SLog.e("You can't interrupt this.");
        return;
    }

    InlineVineRecorder getRecorder()
    {
        return mRecorder;
    }

    public void init(ConversationFragment conversationfragment, ConversationActivity conversationactivity, RecordSessionVersion recordsessionversion)
    {
        mFragment = conversationfragment;
        mCanInline = Util.isCapableOfInline(conversationactivity);
        conversationfragment = mFragment.getView();
        mTextToggle = conversationfragment.findViewById(0x7f0a0098);
        mSwipeUpText = (TextView)conversationfragment.findViewById(0x7f0a00a2);
        mVersion = recordsessionversion;
        if (mCanInline)
        {
            mRecorder = new InlineVineRecorder(recordsessionversion, SystemUtil.getDisplaySize(conversationactivity), conversationactivity, this, conversationactivity.getResources().getDimensionPixelSize(0x7f0b008c), 0x7f0a00a1, 0x7f0a00a7, 0x7f0a009f, 0x7f0a00a0, 0x7f0a00a3, 0x7f0e0054, 0x7f0e0167, 0x7f0a0096, mFragment.getString(0x7f0e0256), new CharSequence[] {
                mFragment.getText(0x7f0e0106), mFragment.getText(0x7f0e00f6), mFragment.getText(0x7f0e00f7), mFragment.getText(0x7f0e00f8)
            });
        }
    }

    public void initDisabled(ConversationFragment conversationfragment)
    {
        mFragment = conversationfragment;
    }

    protected void onAttachedToWindow()
    {
        mHandler = getHandler();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mRecordingButtonContainer = findViewById(0x7f0a00a9);
        mRecordingContainer = findViewById(0x7f0a009e);
        mFinishProgressView = (ProgressView)findViewById(0x7f0a00a7);
        mTopMask = findViewById(0x7f0a00a0);
        mCameraView = findViewById(0x7f0a009f);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return isInRecordButton(motionevent);
    }

    public void onPaused()
    {
        if (mCanInline)
        {
            waitForResume();
            if (mRecorder != null)
            {
                mRecorder.setStarted(false);
                mRecorder.onUiPaused();
            }
        }
    }

    public void onProcessingFinish()
    {
        mProcessing = false;
        mRecordingButtonContainer.setAlpha(0.0F);
        mRecordingButtonContainer.setVisibility(0);
        mRecordingButtonContainer.animate().alpha(1.0F).start();
    }

    public void onProcessingStart()
    {
        toggleRecorder(false);
        mProcessing = true;
        mRecordingButtonContainer.animate().alpha(0.0F).setListener(new ViewGoneAnimationListener(mRecordingButtonContainer));
    }

    public void onResume()
        throws IOException
    {
        if (mCanInline)
        {
            try
            {
                mResumeThread = new ResumeThread();
            }
            catch (IOException ioexception)
            {
                mCanInline = false;
                mRecorder.release();
                mRecorder = null;
                throw ioexception;
            }
            mRecorder.setCameraView(mCameraView);
            mRecorder.onUiResumed(mFragment.getActivity(), mFinishRunnable, true);
            mIsWaitingForResumeThread = true;
            mResumeThread.start();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 36
    //                   1 215
    //                   2 153;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L5:
        return flag;
_L2:
        if (!mProcessing && isInRecordButton(motionevent) && mRecordingContainer.getVisibility() != 0)
        {
            mDownWasInRecordButton = true;
            if (mRecorder != null)
            {
                mSwipeUpText.setTextColor(getResources().getColor(0x7f090081));
                mRecorder.setStarted(true);
                waitForResume();
                mRecorder.openCamera();
                mHandler.postDelayed(mStartInlineRecording, 200L);
                return true;
            }
        } else
        if (mRecordingContainer.getVisibility() == 0)
        {
            mDownWasInRecordButton = false;
            mRecorder.setStarted(false);
            return true;
        } else
        {
            return false;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (mRecorder == null)
        {
            return mDownWasInRecordButton;
        }
        if (isInCancelZone(motionevent.getY()))
        {
            mSwipeUpText.setTextColor(mFragment.getMyColor());
        } else
        {
            mSwipeUpText.setTextColor(getResources().getColor(0x7f090081));
        }
        return mDownWasInRecordButton;
_L3:
        if (mDownWasInRecordButton && mRecorder == null)
        {
            mDownWasInRecordButton = false;
            mFragment.launchFullRecord();
            return true;
        }
        waitForResume();
        mHandler.removeCallbacks(mStartInlineRecording);
        if (mDownWasInRecordButton && motionevent.getEventTime() - motionevent.getDownTime() <= 200L && mRecordingContainer.getVisibility() != 0)
        {
            mDownWasInRecordButton = false;
            mRecorder.setStarted(false);
            mFragment.launchFullRecord();
            return true;
        }
        if (mRecordingContainer.getVisibility() == 0 && mDownWasInRecordButton && !mRecorder.isFinished())
        {
            if (isInCancelZone(motionevent.getY()))
            {
                if (mRecorder.isRecordingSegment())
                {
                    mRecorder.stopRecording(true);
                } else
                {
                    mRecorder.cancelStartCallback();
                }
                mRecorder.deleteCurrentDraftFolder("inline action up.");
                mRecorder.swapSession("Inline record", getNewMessageRecordingFile());
                toggleRecorder(false);
                mTextToggle.setEnabled(true);
                mFinishProgressView.animate().alpha(0.0F).setListener(new ViewGoneAnimationListener(mFinishProgressView)).start();
            } else
            if (mRecorder.isRecordingSegment())
            {
                mRecorder.stopRecording(false);
                mRecorder.onFinishPressed();
            } else
            {
                mRecorder.stopRecording(true);
                if (mRecorder.hasSessionFile())
                {
                    mRecorder.deleteCurrentDraftFolder("inline action up.");
                }
                mRecorder.swapSession("Inline record", getNewMessageRecordingFile());
                toggleRecorder(false);
                mTextToggle.setEnabled(true);
                mFinishProgressView.animate().alpha(0.0F).setListener(new ViewGoneAnimationListener(mFinishProgressView)).start();
            }
            mTextToggle.setVisibility(0);
            return true;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void release()
    {
        if (mCanInline)
        {
            waitForResume();
            mRecorder.stopAndDiscardChanges("release", null, true);
            mRecorder.release();
        }
    }









/*
    static boolean access$902(InlineRecorderManager inlinerecordermanager, boolean flag)
    {
        inlinerecordermanager.mIsWaitingForResumeThread = flag;
        return flag;
    }

*/
}
