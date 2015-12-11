// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaActionSound;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import co.vine.android.animation.SimpleAnimationListener;
import co.vine.android.player.SdkVideoView;
import co.vine.android.recorder.ProgressView;
import co.vine.android.recorder.RecordSession;
import co.vine.android.recorder.RecordSessionManager;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.recorder.RecordingAnimations;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.recorder.VineRecorder;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.views.FakeKeyEventTouchListener;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesTextView;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android:
//            BaseFragment, AbstractRecordingActivity, Settings, VineLoggingException

public class RecordingFragment extends BaseFragment
{
    public static class OnRecordingFinishRunnable
        implements Runnable
    {

        private WeakReference mFragment;

        public void run()
        {
            RecordingFragment recordingfragment = (RecordingFragment)mFragment.get();
            if (recordingfragment != null)
            {
                RecordingFile recordingfile = recordingfragment.mRecorder.finalFile;
                if (recordingfile != null && recordingfile.isValid())
                {
                    co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable generatethumbnailsrunnable = recordingfragment.mRecorder.grabThumbnailsRunnable;
                    recordingfragment.mRecorder.grabThumbnailsRunnable = null;
                    recordingfragment.notifyActivity("OnRecordingFinishRunnable", recordingfragment.mRecorder.detectedInvalidSession, generatethumbnailsrunnable);
                }
            }
        }

        public OnRecordingFinishRunnable(WeakReference weakreference)
        {
            mFragment = weakreference;
        }
    }

    public class PlusMinusTouchListener extends FakeKeyEventTouchListener
    {

        private final int mDrawableId;
        private final Resources mRes;
        private final ImageView mTarget;
        final RecordingFragment this$0;

        private void changeColor(int i)
        {
            switch (i)
            {
            default:
                return;

            case 0: // '\0'
                ViewUtil.fillColor(mRes, mColor, mDrawableId, mTarget);
                mTarget.setAlpha(1.0F);
                return;

            case 1: // '\001'
                ViewUtil.fillColor(mRes, mColor, mDrawableId, mTarget);
                break;
            }
            mTarget.setAlpha(0.35F);
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            changeColor(motionevent.getAction());
            return super.onTouch(view, motionevent);
        }

        public PlusMinusTouchListener(ImageView imageview, int i)
        {
            this$0 = RecordingFragment.this;
            FragmentActivity fragmentactivity = getActivity();
            char c;
            if (i == 0x7f020296)
            {
                c = '\251';
            } else
            {
                c = '\250';
            }
            super(fragmentactivity, c);
            mDrawableId = i;
            mRes = getActivity().getResources();
            mTarget = imageview;
            changeColor(1);
        }
    }

    public static final class SecretModes extends Enum
    {

        private static final SecretModes $VALUES[];
        public static final SecretModes ANTI_BANDING;
        public static final SecretModes COLOR_EFFECTS;
        public static final SecretModes EXPOSURE;
        public static final SecretModes FLASH;
        public static final SecretModes IMAGE_STAB;
        public static final SecretModes SCENE_MODE;
        public static final SecretModes STOP_MOTION;
        public static final SecretModes TIME_LAPSE;
        public static final SecretModes WHITE_BALANCE;

        public static SecretModes valueOf(String s)
        {
            return (SecretModes)Enum.valueOf(co/vine/android/RecordingFragment$SecretModes, s);
        }

        public static SecretModes[] values()
        {
            return (SecretModes[])$VALUES.clone();
        }

        static 
        {
            STOP_MOTION = new SecretModes("STOP_MOTION", 0);
            WHITE_BALANCE = new SecretModes("WHITE_BALANCE", 1);
            EXPOSURE = new SecretModes("EXPOSURE", 2);
            FLASH = new SecretModes("FLASH", 3);
            TIME_LAPSE = new SecretModes("TIME_LAPSE", 4);
            SCENE_MODE = new SecretModes("SCENE_MODE", 5);
            COLOR_EFFECTS = new SecretModes("COLOR_EFFECTS", 6);
            ANTI_BANDING = new SecretModes("ANTI_BANDING", 7);
            IMAGE_STAB = new SecretModes("IMAGE_STAB", 8);
            $VALUES = (new SecretModes[] {
                STOP_MOTION, WHITE_BALANCE, EXPOSURE, FLASH, TIME_LAPSE, SCENE_MODE, COLOR_EFFECTS, ANTI_BANDING, IMAGE_STAB
            });
        }

        private SecretModes(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String ARG_COLOR = "color";
    public static final String ARG_ENCODER_VERSION = "arg_encoder_version";
    public static final String ARG_IS_MESSAGING = "is_messaging";
    public static final String ARG_IS_VM_ONBOARDING = "is_vm_onboarding";
    public static final String ARG_RECIPIENT_USERNAME = "recipient_username";
    public static final String ARG_SCREEN_SIZE = "screen_size";
    public static final String ARG_TOP_OVERLAY = "arg_top_overlay";
    private static final float DISABLED_ALPHA = 0.35F;
    private static final float ENABLED_ALPHA = 1F;
    private int mColor;
    private int mCurrentSteadyCount;
    private AlphaAnimation mDismissGridAnimation;
    private View mDraftOverlayIcon;
    private int mDraftUpgradeCount;
    private TextView mDraftsButton;
    private Animation mFadeIn;
    private final android.view.animation.Animation.AnimationListener mFadeInListener = new android.view.animation.Animation.AnimationListener() {

        final RecordingFragment this$0;

        public void onAnimationEnd(Animation animation)
        {
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            mNoDraftsOverlay.setVisibility(0);
        }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
    };
    private Animation mFadeOut;
    private final android.view.animation.Animation.AnimationListener mFadeOutListener = new android.view.animation.Animation.AnimationListener() {

        final RecordingFragment this$0;

        public void onAnimationEnd(Animation animation)
        {
            mDraftsButton.setAlpha(0.35F);
            mNoDraftsOverlay.setVisibility(8);
            mNoDraftsOverlay.setOnTouchListener(null);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            mDraftOverlayIcon.setVisibility(8);
        }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
    };
    private RecordingFile mFileFileToUse;
    private View mFocusButton;
    private File mFolder;
    private ToggleButton mGhostButton;
    private View mGrid;
    private ToggleButton mGridButton;
    private int mHalfColor;
    private final Handler mHandler = new Handler();
    private boolean mIsDraftUpgradeAnimationRunning;
    private boolean mIsMessaging;
    private boolean mIsVmOnboarding;
    private MediaActionSound mMediaActionSound;
    private View mNoDraftsOverlay;
    private int mNumDrafts;
    final android.view.View.OnTouchListener mOnNoDraftOverlayTouchListener = new android.view.View.OnTouchListener() {

        final RecordingFragment this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            mFadeOut.setAnimationListener(mFadeOutListener);
            mNoDraftsOverlay.startAnimation(mFadeOut);
            mDraftsButton.setAlpha(0.35F);
            return true;
        }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
    };
    private String mRecipientUsername;
    private VineRecorder mRecorder;
    private View mRecordingOptions;
    private RecordSessionManager mRsm;
    private Point mScreenSize;
    private SecretModes mSecretMode;
    private Toast mSecretToast;
    private AlphaAnimation mShowGridAnimation;
    private final Runnable mStartDraftsRunnable = new Runnable() {

        final RecordingFragment this$0;

        public void run()
        {
            AbstractRecordingActivity abstractrecordingactivity = (AbstractRecordingActivity)getActivity();
            if (abstractrecordingactivity != null)
            {
                if (mGridButton.isChecked())
                {
                    mGridButton.setChecked(false);
                }
                if (mGhostButton.isChecked())
                {
                    mRecorder.setGhostMode(false);
                }
                if (mRecorder.grabThumbnailsRunnable != null)
                {
                    mRecorder.grabThumbnailsRunnable.run();
                    mRecorder.grabThumbnailsRunnable = null;
                }
                String s;
                if (mRecorder.isSavedSession())
                {
                    s = mRecorder.getFile().folder.getName();
                } else
                {
                    s = String.valueOf("camera_preview");
                }
                abstractrecordingactivity.showDrafts(s);
            }
        }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
    };
    private boolean mStartWithEdit;
    private double mTier;
    private Bitmap mTopOverlay;
    private ProgressBar mUpgradeSpinner;
    private RecordSessionVersion mVersion;
    private ViewGroup mVmOnboardOverlay;
    private final android.view.animation.Animation.AnimationListener mVmOnboardingFadeListener = new android.view.animation.Animation.AnimationListener() {

        final RecordingFragment this$0;

        public void onAnimationEnd(Animation animation)
        {
            mVmOnboardOverlay.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
    };

    public RecordingFragment()
    {
        mCurrentSteadyCount = 0;
    }

    private RecordingFile determineSessionFileForSwap(boolean flag)
    {
        AbstractRecordingActivity abstractrecordingactivity = (AbstractRecordingActivity)getActivity();
        ArrayList arraylist = RecordSessionManager.getValidSessions(abstractrecordingactivity, mVersion);
        Object obj = null;
        if (arraylist.size() > 9)
        {
            obj = ((co.vine.android.recorder.RecordSessionManager.RecordSessionInfo)arraylist.get(arraylist.size() - 1)).folder;
        }
        Object obj4;
        Object obj5;
        obj4 = null;
        obj5 = null;
        Object obj1 = mFileFileToUse;
        if (!flag || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        SLog.i("Is from preview, use existing final file.");
        int i;
        if (!((RecordingFile) (obj1)).isSavedSession)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1.isDirty = flag;
        return ((RecordingFile) (obj1));
        Object obj2;
        Object obj3;
        RecordSession recordsession;
        HashMap hashmap;
        int j;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if (mFolder != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag4 = false;
        flag3 = false;
        flag2 = false;
        flag1 = false;
        obj3 = null;
        recordsession = null;
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj3 = ((RecordingFile) (obj1)).getSession();
        obj2 = ((RecordingFile) (obj1)).folder;
        obj4 = obj;
        flag2 = flag1;
        flag3 = flag;
        break MISSING_BLOCK_LABEL_145;
_L7:
        flag1 = flag;
        j = i;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        if (!mFolder.exists())
        {
            break MISSING_BLOCK_LABEL_226;
        }
        flag1 = flag;
        j = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        flag5 = ((File) (obj)).exists();
        flag1 = flag;
        j = i;
        if (flag5)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        j = 1;
        flag1 = false;
        if (j == 0) goto _L4; else goto _L3
_L3:
        obj2 = obj4;
        obj1 = obj3;
        flag2 = flag3;
        hashmap = mRsm.getCrashedSession();
        obj2 = obj5;
        obj1 = recordsession;
        flag = flag4;
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_398;
        }
        obj2 = obj4;
        obj1 = obj3;
        flag2 = flag3;
        obj3 = (RecordSession)hashmap.keySet().iterator().next();
        obj2 = obj4;
        obj1 = obj3;
        flag2 = flag3;
        ((RecordSession) (obj3)).setConfig(new co.vine.android.recorder.RecordConfigUtils.RecordConfig(abstractrecordingactivity));
        obj2 = obj4;
        obj1 = obj3;
        flag2 = flag3;
        obj4 = (File)hashmap.get(obj3);
        obj2 = obj4;
        obj1 = obj3;
        flag2 = flag3;
        if (((RecordSession) (obj3)).getSegments().size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj2 = obj4;
        obj1 = obj3;
        flag2 = flag;
        CrashUtil.log("Restore from crashed session.");
        obj1 = obj3;
        obj2 = obj4;
_L8:
        obj3 = obj1;
        flag3 = flag1;
        flag2 = flag;
        obj4 = obj;
        if (obj1 != null) goto _L6; else goto _L5
_L5:
        CrashUtil.log("Creating new session.");
        obj1 = mRsm.createFolderForSession();
        recordsession = RecordSession.newSession(new co.vine.android.recorder.RecordConfigUtils.RecordConfig(abstractrecordingactivity), mVersion);
        i = arraylist.size();
        obj2 = obj1;
        obj3 = recordsession;
        flag3 = flag1;
        flag2 = flag;
        obj4 = obj;
        if (i == 9)
        {
            obj4 = obj1;
            obj2 = obj1;
            obj3 = recordsession;
            flag3 = flag1;
            flag2 = flag;
        }
          goto _L6
_L11:
        i = 0;
          goto _L7
        obj3;
        SLog.e("Failed to get a crashed session.");
        flag = flag2;
          goto _L8
_L6:
        if (obj2 == obj4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            return new RecordingFile(((File) (obj2)), ((RecordSession) (obj3)), flag3, flag2, flag);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            SLog.e((new StringBuilder()).append("Error creating folder: ").append(mFolder).toString(), ((Throwable) (obj)));
        }
        Toast.makeText(abstractrecordingactivity, 0x7f0e0232, 0).show();
        abstractrecordingactivity.finish();
        return null;
        obj;
        CrashUtil.log("Cannot create folder.", new Object[] {
            obj
        });
        getActivity().finish();
        return null;
_L4:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_667;
        }
        obj2 = mFolder;
_L9:
        obj3 = RecordSessionManager.readDataObject(((File) (obj2)));
        ((RecordSession) (obj3)).setConfig(new co.vine.android.recorder.RecordConfigUtils.RecordConfig(abstractrecordingactivity));
        ((RecordSession) (obj3)).setAudioDataCount(((RecordSession) (obj3)).calculateAudioCount());
        ((RecordSession) (obj3)).setVideoDataCount(((RecordSession) (obj3)).calculateVideoCount());
        SLog.i("Resume session {}.", ((File) (obj2)).getAbsolutePath());
        flag3 = flag1;
        obj4 = obj;
          goto _L6
        obj2 = obj;
        flag2 = true;
          goto _L9
_L2:
        if (obj != null || flag) goto _L11; else goto _L10
_L10:
        i = 1;
          goto _L7
    }

    private void doStopMotion()
    {
        if (mRecorder != null && mRecorder.canKeepRecording() && mCurrentSteadyCount < 40)
        {
            mHandler.postDelayed(new Runnable() , 50L);
        }
    }

    private void notifyActivity(String s, boolean flag, co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable generatethumbnailsrunnable)
    {
        AbstractRecordingActivity abstractrecordingactivity;
label0:
        {
            if (mRecorder.finalFile != null)
            {
                abstractrecordingactivity = (AbstractRecordingActivity)getActivity();
                if (abstractrecordingactivity != null)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    CrashUtil.logException(new IllegalStateException("Detected invalid session."));
                    Util.showCenteredToast(abstractrecordingactivity, 0x7f0e0116);
                    abstractrecordingactivity.finish();
                }
            }
            return;
        }
        abstractrecordingactivity.mProgressContainerWidth = ((ViewGroup)mRecorder.getCameraView().getParent()).getMeasuredWidth();
        abstractrecordingactivity.mCurrentDuration = mRecorder.getCurrentDuration();
        abstractrecordingactivity.toPreview(s, mRecorder.finalFile, mRecorder.getThumbnailPath(), generatethumbnailsrunnable);
    }

    private void refreshDraftNumber()
    {
        int i;
        int j;
        try
        {
            j = RecordSessionManager.getNumberOfValidSessions(getActivity(), mVersion);
        }
        catch (IOException ioexception)
        {
            CrashUtil.logException(ioexception);
            return;
        }
        if (j <= 0) goto _L2; else goto _L1
_L1:
        i = j;
        if (j > 9)
        {
            i = j - 1;
        }
        mDraftsButton.setText(String.valueOf(i));
_L3:
        mNumDrafts = i;
        return;
_L2:
        mDraftsButton.setText("");
        i = j;
          goto _L3
    }

    public void discardEditing()
    {
        if (mRecorder != null)
        {
            mRecorder.setEditMode(false, true);
        }
    }

    public void doOneFrame()
    {
        if (mRecorder != null && mRecorder.canKeepRecording())
        {
            mRecorder.doOneFrame();
        }
    }

    public void doSecretVolumeDown()
    {
        static class _cls16
        {

            static final int $SwitchMap$co$vine$android$RecordingFragment$SecretModes[];

            static 
            {
                $SwitchMap$co$vine$android$RecordingFragment$SecretModes = new int[SecretModes.values().length];
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.STOP_MOTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.WHITE_BALANCE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.EXPOSURE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.FLASH.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.TIME_LAPSE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.SCENE_MODE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.COLOR_EFFECTS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.ANTI_BANDING.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$co$vine$android$RecordingFragment$SecretModes[SecretModes.IMAGE_STAB.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls16..SwitchMap.co.vine.android.RecordingFragment.SecretModes[mSecretMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            doStopMotion();
            return;

        case 2: // '\002'
            mRecorder.modifyWhiteBalance(false);
            return;

        case 3: // '\003'
            mRecorder.modifyExposure(false);
            return;

        case 4: // '\004'
            mRecorder.switchFlash();
            return;

        case 5: // '\005'
            mRecorder.showTimeLapseDialog();
            return;

        case 6: // '\006'
            mRecorder.modifySceneMode(false);
            return;

        case 7: // '\007'
            mRecorder.modifyColorEffects(false);
            return;

        case 8: // '\b'
            mRecorder.modifyAntiBanding(false);
            return;

        case 9: // '\t'
            mRecorder.switchImageStabilization();
            break;
        }
    }

    public void doSecretVolumeUp()
    {
        if (mRecorder == null || !mRecorder.canKeepRecording()) goto _L2; else goto _L1
_L1:
        _cls16..SwitchMap.co.vine.android.RecordingFragment.SecretModes[mSecretMode.ordinal()];
        JVM INSTR tableswitch 1 9: default 80
    //                   1 81
    //                   2 86
    //                   3 95
    //                   4 104
    //                   5 112
    //                   6 120
    //                   7 129
    //                   8 138
    //                   9 147;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L2:
        return;
_L3:
        doOneFrame();
        return;
_L4:
        mRecorder.modifyWhiteBalance(true);
        return;
_L5:
        mRecorder.modifyExposure(true);
        return;
_L6:
        mRecorder.switchFlash();
        return;
_L7:
        mRecorder.showTimeLapseDialog();
        return;
_L8:
        mRecorder.modifySceneMode(true);
        return;
_L9:
        mRecorder.modifyColorEffects(true);
        return;
_L10:
        mRecorder.modifyAntiBanding(true);
        return;
_L11:
        mRecorder.switchImageStabilization();
        return;
    }

    public void enableSecretMode(Toast toast)
    {
        mSecretToast = toast;
        mSecretMode = SecretModes.STOP_MOTION;
    }

    public boolean endRelativeTime()
    {
        if (mRecorder != null && mRecorder.canKeepRecording() && mRecorder.isCurrentlyRecording())
        {
            return mRecorder.endRelativeTime();
        } else
        {
            return false;
        }
    }

    public View getProgressView()
    {
        return mRecorder.getProgressView();
    }

    public String getThumbnailPath()
    {
        return mRecorder.getThumbnailPath();
    }

    public boolean isEditing()
    {
        return mRecorder != null && mRecorder.isEditing();
    }

    public boolean isEditingDirty()
    {
        return mRecorder != null && mRecorder.isEditingDirty();
    }

    public boolean isResuming()
    {
        return mRecorder != null && mRecorder.isResuming();
    }

    public boolean isSavedSession()
    {
        return mRecorder.isSavedSession();
    }

    public boolean isSessionModified()
    {
        if (mRecorder != null)
        {
            return mRecorder.isSessionDirty();
        } else
        {
            return false;
        }
    }

    public void modifyZoom(boolean flag)
    {
        if (mRecorder != null)
        {
            mRecorder.modifyZoom(flag);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        onActivityCreated(bundle);
        mTier = SystemUtil.getMemoryRatio(getActivity(), true);
        bundle = (AbstractRecordingActivity)getActivity();
        Resources resources;
        Object obj;
        Object obj1;
        boolean flag1;
        mRsm = mVersion.getManager(getActivity());
        if (mIsMessaging)
        {
            bundle.findViewById(0x7f0a01c4).setVisibility(8);
        }
        resources = getResources();
        obj = (ViewGroup)bundle.findViewById(0x7f0a01c8);
        ((ViewGroup) (obj)).setOnTouchListener(new PlusMinusTouchListener((ImageView)((ViewGroup) (obj)).getChildAt(0), 0x7f020296));
        obj = (ViewGroup)bundle.findViewById(0x7f0a01ca);
        ((ViewGroup) (obj)).setOnTouchListener(new PlusMinusTouchListener((ImageView)((ViewGroup) (obj)).getChildAt(0), 0x7f020297));
        obj = bundle.findViewById(0x7f0a01c9);
        obj1 = ((View) (obj)).getLayoutParams();
        obj1.width = (int)((double)SystemUtil.getDisplaySize(getActivity()).x * 0.80000000000000004D - (double)(bundle.getResources().getDisplayMetrics().density * 2.0F * 36F));
        ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        obj = mVersion;
        flag1 = mStartWithEdit;
        obj1 = bundle.getScreenSize();
        boolean flag;
        if (mFileFileToUse != null && mStartWithEdit)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRecorder = new VineRecorder(((RecordSessionVersion) (obj)), flag1, ((Point) (obj1)), flag, bundle.hasPreviewedAlready(), determineSessionFileForSwap(true), bundle, (SdkVideoView)bundle.findViewById(0x7f0a0178), 0x7f0a01be, 0x7f0a01ac, 0x7f0a01c1, 0x7f0a01ce, 0x7f0a01b3, 0x7f020182, 0x7f020184, 0x7f0a01c2, 0x7f0a00b2, 0x7f0a009f, 0x7f0a01bf, -1, 0x7f0a01bc, 0x7f0a00a0, 0x7f0a00a3, 0x7f0a01b4, 0x7f0a01b6, 0x7f0a01b5, 0x7f0a01b7, 0x7f0a01b8, 0x7f0a01b9, 0x7f0e00f9, 0x7f0e0054, 0x7f0e0167, 0x7f0a01af, 0x7f0a01ad, 0x7f0a011d, resources.getDimensionPixelSize(0x7f0b003c), resources.getDimensionPixelSize(0x7f0b0038), 0x7f0a01b2, 0x7f0a01ae, 0x7f0a00dc, getString(0x7f0e0256), mGhostButton, false, mIsMessaging, mColor, mHalfColor, 0x7f0a01c7, 0x7f0a01c9, mMediaActionSound, new CharSequence[] {
            getText(0x7f0e0106), getText(0x7f0e00f6), getText(0x7f0e00f7), getText(0x7f0e00f8)
        });
        mShowGridAnimation = RecordingAnimations.getShowGridAinimation(new SimpleAnimationListener() {

            final RecordingFragment this$0;

            public void onAnimationEnd(Animation animation)
            {
                if (mRecorder != null)
                {
                    mRecorder.setGridOn(true);
                }
                mGrid.setVisibility(0);
            }

            public void onAnimationStart(Animation animation)
            {
                mGrid.setVisibility(0);
                mGridButton.setChecked(true);
            }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
        });
        mDismissGridAnimation = RecordingAnimations.getGridDimissAnimation(new SimpleAnimationListener() {

            final RecordingFragment this$0;

            public void onAnimationEnd(Animation animation)
            {
                mGrid.setVisibility(8);
                mGridButton.setChecked(false);
                if (mRecorder != null)
                {
                    mRecorder.setGridOn(false);
                }
            }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
        });
        if (mGrid.getVisibility() == 0)
        {
            mGrid.startAnimation(mDismissGridAnimation);
        }
        if (mIsVmOnboarding)
        {
            mVmOnboardOverlay.setVisibility(0);
            mVmOnboardOverlay.setOnTouchListener(new android.view.View.OnTouchListener() {

                final RecordingFragment this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (view.getVisibility() == 0)
                    {
                        view = AnimationUtils.loadAnimation(getActivity(), 0x7f04000f);
                        view.setAnimationListener(mVmOnboardingFadeListener);
                        mVmOnboardOverlay.startAnimation(view);
                    }
                    return false;
                }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
            });
        }
        try
        {
            mRecorder.playStartRecordingSound();
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            try
            {
                CrashUtil.logException(nullpointerexception, "NPE when playing sound", new Object[0]);
                return;
            }
            catch (IOException ioexception)
            {
                SLog.e("Error creating folder. ", ioexception);
                Toast.makeText(bundle, 0x7f0e0232, 0).show();
                bundle.finish();
                return;
            }
            catch (VerifyError verifyerror)
            {
                SLog.e("Invalid recorder object.");
            }
        }
        bundle.finish();
        return;
    }

    public void onCameraSwitchPressed(View view)
    {
        if (mRecorder != null)
        {
            mRecorder.onCameraSwitcherPressed(view);
        }
    }

    public void onCreate(Bundle bundle)
    {
        onCreate(bundle);
        bundle = getArguments();
        mVersion = (RecordSessionVersion)bundle.getSerializable("arg_encoder_version");
        if (mVersion == null)
        {
            mVersion = RecordSessionManager.getCurrentVersion(getActivity());
        }
        mTopOverlay = (Bitmap)bundle.getParcelable("arg_top_overlay");
        mScreenSize = (Point)bundle.getParcelable("screen_size");
        mIsMessaging = bundle.getBoolean("is_messaging", false);
        mIsVmOnboarding = bundle.getBoolean("is_vm_onboarding");
        mRecipientUsername = bundle.getString("recipient_username");
        mColor = bundle.getInt("color", 0);
        if (mColor == Settings.DEFAULT_PROFILE_COLOR || mColor <= 0)
        {
            mColor = getResources().getColor(0x7f090096) & 0xffffff;
        }
        if (!mIsMessaging)
        {
            mColor = 0xffffff;
        }
        mHalfColor = mColor | 0x5a000000;
        mColor = mColor | 0xff000000;
        mFadeIn = AnimationUtils.loadAnimation(getActivity(), 0x7f04000d);
        mFadeOut = AnimationUtils.loadAnimation(getActivity(), 0x7f04000f);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            mMediaActionSound = new MediaActionSound();
            mMediaActionSound.load(2);
            mMediaActionSound.load(3);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030084, viewgroup, false);
        viewgroup = layoutinflater.findViewById(0x7f0a00a0);
        bundle = layoutinflater.findViewById(0x7f0a00a3);
        final Resources res = getResources();
        if (mIsMessaging)
        {
            int i = res.getColor(0x7f090025);
            viewgroup.setBackgroundColor(i);
            bundle.setBackgroundColor(i);
            layoutinflater.findViewById(0x7f0a00b2).setBackgroundColor(i);
        }
        mFocusButton = layoutinflater.findViewById(0x7f0a01c2);
        ViewUtil.fillColor(res, mColor, 0x7f020182, mFocusButton);
        mFocusButton.setAlpha(0.35F);
        final View switchCameraButton = layoutinflater.findViewById(0x7f0a01c0);
        ViewUtil.fillColor(res, mColor, 0x7f020188, switchCameraButton);
        switchCameraButton.setAlpha(0.35F);
        switchCameraButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final RecordingFragment this$0;
            final Resources val$res;
            final View val$switchCameraButton;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                switch (view.getId())
                {
                case 2131362240: 
                    switch (motionevent.getAction())
                    {
                    case 0: // '\0'
                        ViewUtil.fillColor(res, mColor, 0x7f020188, switchCameraButton);
                        switchCameraButton.setAlpha(1.0F);
                        break;

                    case 1: // '\001'
                        ViewUtil.fillColor(res, mColor, 0x7f020188, switchCameraButton);
                        switchCameraButton.setAlpha(0.35F);
                        break;
                    }
                    break;
                }
                while (true) 
                {
                    return false;
                }
            }

            
            {
                this$0 = RecordingFragment.this;
                res = resources;
                switchCameraButton = view;
                super();
            }
        });
        switchCameraButton = layoutinflater.findViewById(0x7f0a01bb);
        ViewUtil.fillColor(res, mColor, 0x7f020213, switchCameraButton);
        switchCameraButton = layoutinflater.findViewById(0x7f0a01bd);
        ViewUtil.fillColor(res, mColor, 0x7f02014e, switchCameraButton);
        if (mIsMessaging)
        {
            switchCameraButton = (TypefacesTextView)layoutinflater.findViewById(0x7f0a0181);
            switchCameraButton.setWeight(3);
            switchCameraButton.setTypeface(Typefaces.get(getActivity()).mediumContent);
            switchCameraButton.setVisibility(0);
            if (!TextUtils.isEmpty(mRecipientUsername) && !TextUtils.isEmpty(mRecipientUsername))
            {
                switchCameraButton.setText(mRecipientUsername);
            }
            ((ProgressView)layoutinflater.findViewById(0x7f0a00b2)).setColor(mHalfColor);
        }
        mGridButton = (ToggleButton)layoutinflater.findViewById(0x7f0a01c1);
        mGridButton.setText(null);
        mGridButton.setTextOn(null);
        mGridButton.setTextOff(null);
        mGridButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final RecordingFragment this$0;
            final Resources val$res;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    mGrid.startAnimation(mShowGridAnimation);
                    ViewUtil.fillColor(res, mColor, 0x7f02018e, mGridButton);
                    mGridButton.setAlpha(1.0F);
                    return;
                } else
                {
                    mGrid.startAnimation(mDismissGridAnimation);
                    ViewUtil.fillColor(res, mColor, 0x7f02018e, mGridButton);
                    mGridButton.setAlpha(0.35F);
                    return;
                }
            }

            
            {
                this$0 = RecordingFragment.this;
                res = resources;
                super();
            }
        });
        ViewUtil.fillColor(res, mColor, 0x7f02018e, mGridButton);
        mGridButton.setAlpha(0.35F);
        mGrid = layoutinflater.findViewById(0x7f0a0129);
        switchCameraButton = layoutinflater.findViewById(0x7f0a00dc);
        if (mTopOverlay != null)
        {
            switchCameraButton.setVisibility(0);
            ViewUtil.setBackground(getResources(), switchCameraButton, mTopOverlay);
        } else
        {
            switchCameraButton.setVisibility(8);
        }
        mGhostButton = (ToggleButton)layoutinflater.findViewById(0x7f0a01c3);
        mGhostButton.setText(null);
        mGhostButton.setTextOn(null);
        mGhostButton.setTextOff(null);
        ViewUtil.fillColor(res, mColor, 0x7f02018b, mGhostButton);
        mGhostButton.setAlpha(0.35F);
        mGhostButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final RecordingFragment this$0;
            final Resources val$res;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    ViewUtil.fillColor(res, mColor, 0x7f02018b, mGhostButton);
                    mGhostButton.setAlpha(1.0F);
                    return;
                } else
                {
                    ViewUtil.fillColor(res, mColor, 0x7f02018b, mGhostButton);
                    mGhostButton.setAlpha(0.35F);
                    return;
                }
            }

            
            {
                this$0 = RecordingFragment.this;
                res = resources;
                super();
            }
        });
        mUpgradeSpinner = (ProgressBar)layoutinflater.findViewById(0x7f0a01c6);
        mDraftsButton = (TextView)layoutinflater.findViewById(0x7f0a01c5);
        mDraftsButton.setAlpha(0.35F);
        mDraftsButton.setOnTouchListener(new android.view.View.OnTouchListener() {

            final RecordingFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                switch (motionevent.getAction())
                {
                default:
                    return false;

                case 0: // '\0'
                    mDraftsButton.setAlpha(1.0F);
                    return true;

                case 1: // '\001'
                    mDraftsButton.setAlpha(0.35F);
                    break;
                }
                onSessionSwitchPressed(null);
                return true;
            }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
        });
        refreshDraftNumber();
        mRecordingOptions = layoutinflater.findViewById(0x7f0a01be);
        mNoDraftsOverlay = layoutinflater.findViewById(0x7f0a01cf);
        mVmOnboardOverlay = (ViewGroup)layoutinflater.findViewById(0x7f0a01cc);
        ((AbstractRecordingActivity)getActivity()).initMasks(viewgroup, bundle);
        return layoutinflater;
    }

    public void onDestroy()
    {
        onDestroy();
        release();
    }

    public void onDraftUpgradeNumberChanged(int i)
    {
label0:
        {
            SLog.d("Draft upgrade number changed with count {}", Integer.valueOf(i));
            mDraftUpgradeCount = i;
            if (mIsDraftUpgradeAnimationRunning)
            {
                if (i <= 0)
                {
                    break label0;
                }
                mUpgradeSpinner.setVisibility(0);
                mDraftsButton.setVisibility(8);
            }
            return;
        }
        mUpgradeSpinner.setVisibility(8);
        mDraftsButton.setVisibility(0);
    }

    public void onFinishPressed(View view)
    {
        if (mRecorder != null)
        {
            mRecorder.onFinishPressed();
        }
    }

    public void onFocusSwitchPressed(View view)
    {
        if (mRecorder != null && mRecorder.canChangeFocus())
        {
            float f;
            boolean flag;
            if (mRecorder.isAutoFocusing())
            {
                f = 1.0F;
            } else
            {
                f = 0.35F;
            }
            ViewUtil.fillColor(getResources(), mColor, 0x7f020182, mFocusButton);
            mFocusButton.setAlpha(f);
            view = mRecorder;
            if (!mRecorder.isAutoFocusing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setAutoFocusing(flag);
        }
    }

    public void onGhostSwitchPressed(View view)
    {
        if (mRecorder != null)
        {
            mRecorder.onGhostSwitchPressed();
        }
    }

    public void onGridSwitchPressed()
    {
        if (mSecretMode != null)
        {
            SecretModes asecretmodes[] = SecretModes.values();
            mSecretMode = asecretmodes[(mSecretMode.ordinal() + 1) % asecretmodes.length];
            mSecretToast.setText((new StringBuilder()).append("Secret Mode: ").append(mSecretMode.name()).toString());
            mSecretToast.show();
            return;
        }
        if (mGrid.getVisibility() == 8)
        {
            mGrid.startAnimation(mShowGridAnimation);
            return;
        } else
        {
            mGrid.startAnimation(mDismissGridAnimation);
            return;
        }
    }

    public void onHideDrafts()
    {
        refreshDraftNumber();
        mRecordingOptions.setAlpha(0.0F);
        mRecordingOptions.setVisibility(0);
        mRecordingOptions.animate().alpha(1.0F).start();
    }

    public void onPause()
    {
        onPause();
        if (mRecorder != null)
        {
            mRecorder.onUiPaused();
            mRecorder.playStopRecordingSound();
        }
    }

    public void onResume()
    {
        boolean flag = false;
        onResume();
        if (mRecorder != null)
        {
            AbstractRecordingActivity abstractrecordingactivity = (AbstractRecordingActivity)getActivity();
            boolean flag1 = abstractrecordingactivity.isDraftsShowing();
            if (!flag1)
            {
                refreshDraftNumber();
                RecordingFile recordingfile = mRecorder.getFile();
                if (recordingfile != null && !recordingfile.folder.exists())
                {
                    CrashUtil.logException(new VineLoggingException("Invalid folder"));
                    setFileFileToUse(null);
                    mRecorder.swapSession("Resume invalid.", determineSessionFileForSwap(false));
                }
            }
            mRecorder.onUiResumed(abstractrecordingactivity, new OnRecordingFinishRunnable(new WeakReference(this)), flag1);
            if (mGridButton.isChecked())
            {
                ToggleButton togglebutton = mGridButton;
                if (mGrid.getVisibility() != 8)
                {
                    flag = true;
                }
                togglebutton.setChecked(flag);
            }
        }
    }

    public void onSessionSwitchPressed(View view)
    {
        if (mDraftUpgradeCount > 0)
        {
            FlurryUtils.trackSessionSwitchPressedOnDraftUpgrade(mDraftUpgradeCount);
            mHandler.post(new Runnable() {

                final RecordingFragment this$0;

                public void run()
                {
                    FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        Util.showCenteredToast(fragmentactivity, 0x7f0e00c1);
                    }
                    if (!mIsDraftUpgradeAnimationRunning)
                    {
                        mIsDraftUpgradeAnimationRunning = true;
                        onDraftUpgradeNumberChanged(mDraftUpgradeCount);
                    }
                }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
            });
            return;
        }
        FlurryUtils.trackSessionSwitchPressed(view);
        if (mRecorder != null && (mNumDrafts > 0 || mRecorder.isSessionDirty()))
        {
            if (mRecorder.isSessionDirty())
            {
                ((AbstractRecordingActivity)getActivity()).showUnSavedChangesDialog(2, this);
                return;
            } else
            {
                startDrafts(false);
                return;
            }
        } else
        {
            mDraftOverlayIcon.setVisibility(0);
            view = new int[2];
            mDraftsButton.getLocationOnScreen(view);
            int j = view[0];
            int i = view[1];
            mDraftOverlayIcon.setX(j);
            j = getResources().getDimensionPixelOffset(0x7f0b0031);
            mDraftOverlayIcon.setY(i - j);
            mNoDraftsOverlay.setOnTouchListener(mOnNoDraftOverlayTouchListener);
            mFadeIn.setAnimationListener(mFadeInListener);
            mNoDraftsOverlay.startAnimation(mFadeIn);
            return;
        }
    }

    public void onShowDrafts()
    {
        mRecordingOptions.setVisibility(8);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        onViewCreated(view, bundle);
        bundle = getResources();
        View view1 = mNoDraftsOverlay.findViewById(0x7f0a01d0);
        float f = bundle.getDimensionPixelOffset(0x7f0b006a);
        float f1 = bundle.getDimensionPixelOffset(0x7f0b0034);
        view1.setY(((float)(mScreenSize.x / 2) + f) - f1);
        if (mIsMessaging)
        {
            View view2 = getActivity().findViewById(0x7f0a01be);
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)view2.getLayoutParams();
            int i = (int)((double)mScreenSize.x * 0.10000000000000001D);
            layoutparams.setMargins(i, 0, i, 0);
            view2.setLayoutParams(layoutparams);
        }
        View view3 = mNoDraftsOverlay.findViewById(0x7f0a01d1);
        f = bundle.getDimensionPixelOffset(0x7f0b0035);
        view3.setY(view1.getY() + f);
        mDraftOverlayIcon = view.findViewById(0x7f0a01d2);
    }

    public void playStopSound()
    {
        if (mRecorder != null)
        {
            mRecorder.playStopRecordingSound();
        }
    }

    public void release()
    {
        if (mRecorder != null)
        {
            if (mRecorder.release())
            {
                FlurryUtils.trackAbandonedStage("capture");
                FlurryUtils.trackAbandonedTier(String.valueOf((int)(mTier / 64D)));
            }
            mRecorder = null;
        }
        mFileFileToUse = null;
    }

    public void requestZoomProgressUpdate()
    {
        if (mRecorder != null)
        {
            mRecorder.requestZoomProgressUpdate();
        }
    }

    public void resumeFromDraft()
    {
        if (mRecorder != null && !mRecorder.isResuming())
        {
            RecordingFile recordingfile = mRecorder.getFile();
            if (recordingfile.folder.exists())
            {
                recordingfile = mRecorder.swapSession("BackPress, Resume from draft using resumeFile.", recordingfile);
            } else
            {
                recordingfile = mRecorder.swapSession("BackPress, Resume from draft using determined.", determineSessionFileForSwap(false));
            }
            if (recordingfile != null)
            {
                mRecorder.onResume("Resume draft", true);
            }
        }
    }

    public void reverseFrames()
    {
        if (mRecorder != null)
        {
            mRecorder.reverseFrames();
        }
    }

    public void saveSession()
    {
        if (mRecorder != null)
        {
            FlurryUtils.trackSaveSession("saveNoQuit");
            mRecorder.saveSession(null, true);
        }
    }

    public void saveSessionAndQuit()
    {
        if (mRecorder != null)
        {
            FlurryUtils.trackSaveSession("quit");
            mRecorder.saveSession(new Runnable() {

                final RecordingFragment this$0;

                public void run()
                {
                    FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        fragmentactivity.finish();
                    }
                }

            
            {
                this$0 = RecordingFragment.this;
                super();
            }
            }, true);
        }
    }

    public void setDiscardChangesOnStop()
    {
        if (mRecorder != null)
        {
            mRecorder.setDiscardChanges(true);
        }
    }

    public void setFileFileToUse(RecordingFile recordingfile)
    {
        mFileFileToUse = recordingfile;
    }

    public void setStartWithEdit(boolean flag)
    {
        mStartWithEdit = flag;
    }

    public void startDrafts(boolean flag)
    {
        SLog.d("Start Drafts: {}.", Boolean.valueOf(flag));
        if (flag)
        {
            FlurryUtils.trackSaveSession("drafts");
            mRecorder.saveSession(mStartDraftsRunnable, false);
            return;
        } else
        {
            mFileFileToUse = null;
            mRecorder.stopAndDiscardChanges("StartDrafts", mStartDraftsRunnable, false);
            return;
        }
    }

    public boolean startRelativeTime()
    {
        if (mRecorder != null && mRecorder.canKeepRecording() && !mRecorder.isCurrentlyRecording())
        {
            return mRecorder.startRelativeTime();
        } else
        {
            return false;
        }
    }

    public void stopZoom()
    {
        if (mRecorder != null)
        {
            mRecorder.stopZoom();
        }
    }

    public void swapFolder(String s, File file)
    {
        mFolder = file;
        if (mRecorder != null)
        {
            setFileFileToUse(null);
            mRecorder.swapSession((new StringBuilder()).append(s).append(" swap").toString(), determineSessionFileForSwap(false));
            mRecorder.onResume("Swap folder", true);
        }
    }









/*
    static boolean access$1402(RecordingFragment recordingfragment, boolean flag)
    {
        recordingfragment.mIsDraftUpgradeAnimationRunning = flag;
        return flag;
    }

*/



/*
    static int access$1608(RecordingFragment recordingfragment)
    {
        int i = recordingfragment.mCurrentSteadyCount;
        recordingfragment.mCurrentSteadyCount = i + 1;
        return i;
    }

*/










}
