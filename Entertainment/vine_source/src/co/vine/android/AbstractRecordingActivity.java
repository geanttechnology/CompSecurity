// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.v4.app.DraftFragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.DraftViewPager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import co.vine.android.animation.MoveResizeAnimator;
import co.vine.android.animation.SimpleAnimationListener;
import co.vine.android.animation.SimpleAnimatorListener;
import co.vine.android.client.AppController;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.player.SdkVideoView;
import co.vine.android.recorder.CameraManager;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RecordSessionManager;
import co.vine.android.recorder.RecordSessionMeta;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.recorder.RecordingActivityHelper;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.recorder.ViewGoneAnimationListener;
import co.vine.android.recorder.VineRecorder;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FloatingViewUtils;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.IntentionalObjectCounter;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.UploadManager;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.DotIndicators;
import co.vine.android.widget.DragUpToDeleteContainer;
import co.vine.android.widgets.PromptDialogFragment;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            BaseActionBarActivity, DraftFragment, RecordingFragment, RecordingActivity, 
//            RecordingPreviewFragment, VineLoggingException, DraftCameraPreviewFragment, Settings

public abstract class AbstractRecordingActivity extends BaseActionBarActivity
    implements co.vine.android.widgets.PromptDialogFragment.OnDialogDoneListener, android.support.v4.view.DraftViewPager.OnPageChangeListener, co.vine.android.animation.SmoothAnimator.AnimationListener, co.vine.android.widget.DragUpToDeleteContainer.DragUpListener, co.vine.android.recorder.ByteBufferQueue.MemoryResponder
{
    private class DraftPagerImpl extends DraftFragmentStatePagerAdapter
    {

        final AbstractRecordingActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            try
            {
                super.destroyItem(viewgroup, i, obj);
                if (obj instanceof DraftFragment)
                {
                    viewgroup = getSupportFragmentManager().beginTransaction();
                    viewgroup.remove((DraftFragment)obj);
                    viewgroup.commit();
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                CrashUtil.log("Failed to remove draft, it's probably not there any more.");
            }
        }

        public void finishUpdate(ViewGroup viewgroup)
        {
            super.finishUpdate(viewgroup);
            if (mFirstDraftLaunch)
            {
                viewgroup = AbstractRecordingActivity.this;
                boolean flag;
                if (!setCurrentSession())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                viewgroup.mFirstDraftLaunch = flag;
            }
        }

        public int getCount()
        {
            return mSessions.size() + 1;
        }

        public Fragment getItem(int i)
        {
            if (i == mSessions.size())
            {
                DraftCameraPreviewFragment draftcamerapreviewfragment = new DraftCameraPreviewFragment(mPreviewDimen);
                mCameraFragment = new WeakReference(draftcamerapreviewfragment);
                return draftcamerapreviewfragment;
            }
            Object obj = (co.vine.android.recorder.RecordSessionManager.RecordSessionInfo)mSessions.get(i);
            boolean flag;
            if (i == 0 && !mFirstPageSet)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = new DraftFragment(flag, i, ((co.vine.android.recorder.RecordSessionManager.RecordSessionInfo) (obj)).video.getPath(), ((co.vine.android.recorder.RecordSessionManager.RecordSessionInfo) (obj)).thumb.getPath(), ((co.vine.android.recorder.RecordSessionManager.RecordSessionInfo) (obj)).folder, ((co.vine.android.recorder.RecordSessionManager.RecordSessionInfo) (obj)).meta.getProgress(), mPreviewDimen);
            ((DraftFragment) (obj)).setListener(((_cls1) (obj)). new android.view.View.OnClickListener() {

                final DraftPagerImpl this$1;
                final DraftFragment val$fragment;

                public void onClick(View view)
                {
                    view.getId();
                    JVM INSTR tableswitch 2131362006 2131362006: default 24
                //                               2131362006 25;
                       goto _L1 _L2
_L1:
                    return;
_L2:
                    if (!mAnimatingIntoDrafts && !isResuming())
                    {
                        CrashUtil.log("User clicked on fragment to resume.");
                        mIsGoingToRecord = true;
                        buildAndShowFloatingView(fragment);
                        releasePlayers();
                        float f = (float)mScreenSize.x / (float)mPreviewOverlay.getLayoutParams().width;
                        (new MoveResizeAnimator(2, mProgressOverlay, 0, f, 2D, 300, null, view.getTag())).start();
                        (new MoveResizeAnimator(1, mPreviewOverlay, mProgressOverlay.getLayoutParams().height * 2, f, f, 300, _fld0, view.getTag())).start();
                        return;
                    }
                    if (true) goto _L1; else goto _L3
_L3:
                }

            
            {
                this$1 = final_draftpagerimpl;
                fragment = DraftFragment.this;
                super();
            }
            });
            mDraftFragments.put(i, new WeakReference(obj));
            return ((Fragment) (obj));
        }

        public int getItemPosition(Object obj)
        {
            if (obj instanceof DraftFragment)
            {
                return !((DraftFragment)obj).isExpired() ? -1 : -2;
            } else
            {
                return super.getItemPosition(obj);
            }
        }

        public DraftPagerImpl(FragmentManager fragmentmanager)
        {
            this$0 = AbstractRecordingActivity.this;
            super(fragmentmanager);
        }
    }

    public class SetSelectedRunnable
        implements Runnable
    {

        public final DraftFragment fragmentToSetSelectedFalse;
        public final DraftFragment fragmentToSetSelectedTrue;
        final AbstractRecordingActivity this$0;

        public void run()
        {
            if (fragmentToSetSelectedFalse != null)
            {
                fragmentToSetSelectedFalse.setSelected(false);
            }
            if (fragmentToSetSelectedTrue != null)
            {
                fragmentToSetSelectedTrue.setSelected(true);
            }
        }

        public SetSelectedRunnable(DraftFragment draftfragment, DraftFragment draftfragment1)
        {
            this$0 = AbstractRecordingActivity.this;
            super();
            fragmentToSetSelectedFalse = draftfragment;
            fragmentToSetSelectedTrue = draftfragment1;
        }
    }


    private static final int ANIMATION_CAMERA_ICON = 4;
    private static final int ANIMATION_DELETE = 3;
    private static final int ANIMATION_PREVIEW = 1;
    private static final int ANIMATION_PROGRESS = 2;
    private static final int ANIMATION_PROGRESS_TO_DRAFTS = 6;
    private static final int ANIMATION_TO_DRAFTS = 5;
    private static final int ANIMATION_TO_DRAFTS_CAMERA = 7;
    private static final int ANIM_DURATION = 300;
    public static final int DIALOG_DELETE = 1;
    public static final int DIALOG_DIRTY = 2;
    public static final int DIALOG_TOO_MANY_DRAFTS = 3;
    public static final int DIALOG_UNSAVED_CHANGES = 0;
    protected static final String EXTRA_AM_FOLLOWING = "am_following";
    protected static final String EXTRA_CONVERSATION_ROW_ID = "conv_row_id";
    protected static final String EXTRA_DIRECT_USER_ID = "direct_id";
    protected static final String EXTRA_IS_VM_ONBOARDING = "is_vm_onboarding";
    protected static final String EXTRA_MESSAGING = "messaging";
    protected static final String EXTRA_RECIPIENT_USERNAME = "recipient_username";
    protected static final String EXTRA_START_CONVERSATION = "start_conversation";
    private static final String EXTRA_TOP_OVERLAY = "arg_top_overlay";
    private static final int PAGE_INVALID = -1;
    public static final String PREF_CAPTURE_LAUNCH_COUNT = "recorder_launch_count";
    public static final int RESULT_RECORDING_CANCELLED = 100;
    private static final int SECRETS[] = {
        25, 24, 24, 24, 24, 24, 25
    };
    public static final String START_SESSION_ID_CAMERA = "camera_preview";
    private static final String STATE_FIRST_DRAFT_LAUNCH = "first_launch";
    private static final String STATE_FIRST_PAGE_SET = "state_fp";
    private static final int STEP_NONE = -1;
    private static final int STEP_PREVIEW = 1;
    private static final int STEP_RECORD = 0;
    private static final ArrayList sQueues = new ArrayList();
    private boolean isSecretModeOn;
    private DraftPagerImpl mAdapter;
    private Thread mAddToUploadThread;
    private boolean mAmFollowingRecipient;
    private boolean mAnimatingIntoDrafts;
    private View mAnimationPreviewOverlay;
    private WeakReference mCameraFragment;
    private Animation mCameraIconFadeIn;
    private View mCameraIconOverlay;
    private View mCameraIconOverlayImage;
    protected int mColor;
    protected long mConversationRowId;
    public long mCurrentDuration;
    protected Fragment mCurrentFragment;
    int mCurrentPage;
    private int mCurrentSecret;
    private co.vine.android.recorder.RecordSessionManager.RecordSessionInfo mCurrentSession;
    private boolean mDeleteWasDrag;
    protected long mDirectUserId;
    private DotIndicators mDots;
    private final SparseArray mDraftFragments = new SparseArray();
    private View mDraftFullMask;
    private View mDraftMaskLeft;
    private View mDraftMaskParent;
    private View mDraftMaskRight;
    private View mDraftMaskTop;
    private View mDraftRoot;
    private View mDraftTrashBackground;
    private View mDraftTrashButton;
    private View mDraftTrashContainer;
    private DragUpToDeleteContainer mDragUpToDeleteView;
    private final android.view.View.OnClickListener mEmptyClicker = new android.view.View.OnClickListener() {

        final AbstractRecordingActivity this$0;

        public void onClick(View view)
        {
        }

            
            {
                this$0 = AbstractRecordingActivity.this;
                super();
            }
    };
    private boolean mFirstDraftLaunch;
    private boolean mFirstPageSet;
    private final Handler mHandler = new Handler();
    private boolean mHasPreviewedAlready;
    private boolean mHasStartedRelativeTimeFromHardwareButton;
    private final RecordingActivityHelper mHelper = new RecordingActivityHelper();
    private final IntentionalObjectCounter mIntentionalObjectCounter = new IntentionalObjectCounter("recorder", this);
    private boolean mIsGoingToRecord;
    protected boolean mIsMessaging;
    protected boolean mIsVmOnboarding;
    private ImageView mLargeThumbnailOverlay;
    final android.view.View.OnTouchListener mOnMaskTouchListesner = new android.view.View.OnTouchListener() {

        final AbstractRecordingActivity this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return true;
        }

            
            {
                this$0 = AbstractRecordingActivity.this;
                super();
            }
    };
    private SetSelectedRunnable mOnPageIdleRunnable;
    private final Runnable mOnResumeDraftRunnable = new Runnable() {

        final AbstractRecordingActivity this$0;

        public void run()
        {
            if (mAdapter.getCount() != 1 && mCurrentPage != mAdapter.getCount() - 1)
            {
                mCurrentSession = (co.vine.android.recorder.RecordSessionManager.RecordSessionInfo)mSessions.get(mCurrentPage);
                Object obj = (WeakReference)mDraftFragments.get(mCurrentPage);
                if (obj != null)
                {
                    obj = (DraftFragment)((WeakReference) (obj)).get();
                    if (obj != null)
                    {
                        ((DraftFragment) (obj)).setSelected(true);
                    }
                }
            }
        }

            
            {
                this$0 = AbstractRecordingActivity.this;
                super();
            }
    };
    private int mPageScrollState;
    int mPreviewDimen;
    private View mPreviewOverlay;
    float mPreviewRatio;
    public int mProgressContainerWidth;
    private View mProgressOverlay;
    private PromptDialogFragment mPromptDialog;
    private String mRecipientUsername;
    private int mRegularUiMode;
    private Point mScreenSize;
    private ArrayList mSessions;
    private int mSideMaskWidth;
    private Animation mSlowFadeIn;
    private boolean mStartConversation;
    private String mStartSessionId;
    private int mStep;
    private int mTopMaskHeight;
    private Bitmap mTopOverlay;
    protected String mUploadFile;
    private RecordSessionVersion mVersion;
    private ArrayList mVideoViews;
    private DraftViewPager mViewPager;

    public AbstractRecordingActivity()
    {
        mVideoViews = new ArrayList();
        mStep = -1;
        mDeleteWasDrag = false;
        mAnimatingIntoDrafts = false;
        mAmFollowingRecipient = false;
        mCurrentSecret = 0;
        isSecretModeOn = false;
        if (sQueues.size() > 20)
        {
            sQueues.clear();
        }
        sQueues.add(new WeakReference(this));
        int i = 0;
        Iterator iterator = sQueues.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((WeakReference)iterator.next()).get() != null)
            {
                i++;
            }
        } while (true);
        CrashUtil.log("[mem] Current RecordingActivity queue count: {}.", new Object[] {
            Integer.valueOf(i)
        });
    }

    private void buildAndShowFloatingView(DraftFragment draftfragment)
    {
        releasePlayers();
        draftfragment.showImage();
        int ai[] = new int[2];
        View view = draftfragment.getThumbnailView();
        view.getLocationOnScreen(ai);
        int i = getResources().getDimensionPixelOffset(0x7f0b0031);
        FloatingViewUtils.buildFloatingViewFor(this, view, mPreviewOverlay, view.getWidth(), ai[0], ai[1] - i);
        ai = new int[2];
        draftfragment = draftfragment.getProgressView();
        draftfragment.getLocationOnScreen(ai);
        FloatingViewUtils.buildFloatingViewFor(this, draftfragment, mProgressOverlay, draftfragment.getWidth(), ai[0], ai[1] - i);
        mPreviewOverlay.setVisibility(0);
        mProgressOverlay.setVisibility(0);
        mDraftTrashContainer.setVisibility(8);
        mViewPager.setVisibility(8);
    }

    private RecordingFragment getActiveRecordingFragment()
    {
        if (!isDraftsShowing() && mStep == 0 && (mCurrentFragment instanceof RecordingFragment))
        {
            return (RecordingFragment)mCurrentFragment;
        } else
        {
            return null;
        }
    }

    private static Intent getIntent(Context context, int i, String s, boolean flag, long l, long l1, 
            boolean flag1, String s1, boolean flag2, boolean flag3)
    {
        context = new Intent(context, co/vine/android/RecordingActivity);
        context.setAction(s);
        if (i > 0)
        {
            context.setFlags(i);
        }
        context.putExtra("messaging", flag);
        context.putExtra("conv_row_id", l);
        context.putExtra("direct_id", l1);
        context.putExtra("start_conversation", flag1);
        context.putExtra("recipient_username", s1);
        context.putExtra("am_following", flag2);
        context.putExtra("is_vm_onboarding", flag3);
        return context;
    }

    public static Intent getIntentForConversation(Context context, int i, String s, long l, boolean flag, String s1, boolean flag1)
    {
        return getIntent(context, i, s, true, l, -1L, flag, s1, flag1, false);
    }

    public static Intent getIntentForGeneric(Context context, int i, String s)
    {
        return getIntent(context, i, s, false, -1L, -1L, false, null, false, false);
    }

    public static Intent getIntentForMessaging(Context context, int i, boolean flag, String s)
    {
        return getIntent(context, i, s, true, -1L, -1L, false, null, false, flag);
    }

    private RecordSessionVersion getVersion()
    {
        if (mVersion == null)
        {
            mVersion = RecordSessionManager.getCurrentVersion(this);
        }
        return mVersion;
    }

    private void handleDelete()
    {
        Object obj;
        boolean flag1;
        flag1 = false;
        obj = (WeakReference)mDraftFragments.get(mCurrentPage);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        final int offset;
        final int margin;
        obj1 = (DraftFragment)((WeakReference) (obj)).get();
        obj = AnimationUtils.loadAnimation(this, 0x7f040013);
        offset = getResources().getDimensionPixelOffset(0x7f0b0031);
        margin = getResources().getDimensionPixelOffset(0x7f0b0036);
        if (mCurrentPage <= 0) goto _L4; else goto _L3
_L3:
        final DraftFragment prevFragment = (DraftFragment)((WeakReference)mDraftFragments.get(mCurrentPage - 1)).get();
        if (prevFragment == null || obj1 == null) goto _L6; else goto _L5
_L5:
        final View prevView;
        prevView = prevFragment.getThumbnailView();
        final int previewLocation[] = new int[2];
        prevView.getLocationOnScreen(previewLocation);
        prevView = new SimpleAnimationListener() {

            final AbstractRecordingActivity this$0;
            final int val$margin;
            final int val$offset;
            final DraftFragment val$prevFragment;
            final View val$prevView;
            final int val$previewLocation[];

            public void onAnimationEnd(Animation animation)
            {
                FloatingViewUtils.buildFloatingViewFor(AbstractRecordingActivity.this, prevView, mPreviewOverlay, prevView.getWidth(), previewLocation[0], previewLocation[1] - offset);
                mPreviewOverlay.setVisibility(0);
                (new MoveResizeAnimator(3, mPreviewOverlay, mPreviewOverlay, (int)((float)mScreenSize.x * (1.0F - mPreviewRatio)) - margin * 5, previewLocation[1] - offset, 1.0D, 1.0D, 300, AbstractRecordingActivity.this, prevFragment.getView())).start();
            }

            
            {
                this$0 = AbstractRecordingActivity.this;
                prevView = view;
                previewLocation = ai;
                offset = i;
                margin = j;
                prevFragment = draftfragment;
                super();
            }
        };
        ((Animation) (obj)).setAnimationListener(prevView);
        prevFragment = prevFragment.getView();
        if (prevFragment != null)
        {
            prevFragment.setVisibility(4);
        }
        obj1 = ((DraftFragment) (obj1)).getView();
        if (obj1 == null || mDeleteWasDrag) goto _L8; else goto _L7
_L7:
        boolean flag;
        ((View) (obj1)).startAnimation(((Animation) (obj)));
        flag = flag1;
_L10:
        if (flag)
        {
            deleteCurrentDraft();
        }
        return;
_L8:
        flag = flag1;
        if (obj1 != null)
        {
            prevView.onAnimationEnd(((Animation) (obj)));
            flag = flag1;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if (mCurrentPage == 0)
        {
            if (mSessions.size() == 1)
            {
                deleteCurrentDraft();
                hideDrafts(true);
                swapFolder("Delete", null);
                flag = flag1;
            } else
            {
                Object obj2 = (WeakReference)mDraftFragments.get(mCurrentPage + 1);
                if (obj2 != null)
                {
                    obj2 = (DraftFragment)((WeakReference) (obj2)).get();
                    if (obj2 != null && obj1 != null)
                    {
                        View view = ((DraftFragment) (obj2)).getThumbnailView();
                        int ai[] = new int[2];
                        view.getLocationOnScreen(ai);
                        final MoveResizeAnimator animator;
                        try
                        {
                            FloatingViewUtils.buildFloatingViewFor(this, view, mPreviewOverlay, view.getWidth(), ai[0], ai[1] - offset);
                        }
                        catch (Exception exception)
                        {
                            CrashUtil.logException(exception);
                        }
                        mPreviewOverlay.setVisibility(0);
                        animator = new MoveResizeAnimator(3, mPreviewOverlay, mPreviewOverlay, (int)((float)mScreenSize.x * (1.0F - mPreviewRatio)) - margin * 4, ai[1] - offset, 1.0D, 1.0D, 300, this, ((DraftFragment) (obj2)).getView());
                        ((Animation) (obj)).setAnimationListener(new SimpleAnimationListener() {

                            final AbstractRecordingActivity this$0;
                            final MoveResizeAnimator val$animator;

                            public void onAnimationEnd(Animation animation)
                            {
                                animator.start();
                            }

            
            {
                this$0 = AbstractRecordingActivity.this;
                animator = moveresizeanimator;
                super();
            }
                        });
                        obj2 = ((DraftFragment) (obj2)).getView();
                        if (obj2 != null)
                        {
                            ((View) (obj2)).setVisibility(4);
                        }
                        obj1 = ((DraftFragment) (obj1)).getView();
                        if (obj1 != null && !mDeleteWasDrag)
                        {
                            ((View) (obj1)).startAnimation(((Animation) (obj)));
                            flag = flag1;
                        } else
                        {
                            animator.start();
                            flag = flag1;
                        }
                    } else
                    {
                        flag = true;
                    }
                } else
                {
                    flag = true;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void hideCurrentFragment()
    {
        Object obj = (WeakReference)mDraftFragments.get(mCurrentPage);
        if (obj != null)
        {
            obj = (DraftFragment)((WeakReference) (obj)).get();
            if (obj != null)
            {
                ((DraftFragment) (obj)).pausePlayer();
                obj = ((DraftFragment) (obj)).getView();
                if (obj != null)
                {
                    ((View) (obj)).setVisibility(8);
                }
            }
        }
    }

    private void hideDraftsInternal()
    {
        mDraftRoot.setVisibility(8);
        mProgressOverlay.setVisibility(8);
        mPreviewOverlay.setVisibility(8);
        mProgressOverlay.setVisibility(8);
        mDragUpToDeleteView.setVisibility(8);
        if (mCurrentFragment instanceof RecordingFragment)
        {
            ((RecordingFragment)mCurrentFragment).onHideDrafts();
        }
    }

    private boolean isResuming()
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            return mIsGoingToRecord || ((RecordingFragment)mCurrentFragment).isResuming();
        } else
        {
            return mIsGoingToRecord;
        }
    }

    private void releasePlayers()
    {
        for (int i = 0; i < mDraftFragments.size(); i++)
        {
            DraftFragment draftfragment = (DraftFragment)((WeakReference)mDraftFragments.get(mDraftFragments.keyAt(i))).get();
            if (draftfragment != null)
            {
                draftfragment.setSelected(false);
                draftfragment.release();
            }
        }

    }

    private void reload(ArrayList arraylist)
    {
        int i = arraylist.size();
        if (i > 9)
        {
            mPromptDialog = PromptDialogFragment.newInstance(3);
            mPromptDialog.setMessage(0x7f0e024c);
            mPromptDialog.setPositiveButton(0x7f0e0163);
            mPromptDialog.show(getFragmentManager());
            arraylist.remove(i - 1);
        }
        mSessions = arraylist;
        mAdapter = new DraftPagerImpl(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(mAdapter.getCount() + 1);
        mDots.setNumberOfDots(arraylist.size());
        mDots.invalidate();
    }

    private boolean setCurrentSession()
    {
        int i = 0;
        if (mViewPager.isDrawn() && !mFirstPageSet)
        {
            if (TextUtils.isEmpty(mStartSessionId) || "camera_preview".equals(mStartSessionId))
            {
                mViewPager.setCurrentItem(mAdapter.getCount() - 1, false);
                mFirstPageSet = true;
                return true;
            }
            for (Iterator iterator = mSessions.iterator(); iterator.hasNext();)
            {
                co.vine.android.recorder.RecordSessionManager.RecordSessionInfo recordsessioninfo = (co.vine.android.recorder.RecordSessionManager.RecordSessionInfo)iterator.next();
                if (mStartSessionId.equals(recordsessioninfo.folder.getName()))
                {
                    mViewPager.setCurrentItem(i, false);
                    mCurrentPage = i;
                    mFirstPageSet = true;
                    Object obj1 = (WeakReference)mDraftFragments.get(mCurrentPage);
                    Object obj = null;
                    View view = obj;
                    if (obj1 != null)
                    {
                        obj1 = (DraftFragment)((WeakReference) (obj1)).get();
                        view = obj;
                        if (obj1 != null)
                        {
                            view = ((DraftFragment) (obj1)).getView().findViewById(0x7f0a00d5);
                        }
                    }
                    mDragUpToDeleteView.setView(view, mViewPager.getLeftOfSelectedFragment());
                    return true;
                }
                i++;
            }

        }
        return false;
    }

    private void showCurrentFragment()
    {
        Object obj = (WeakReference)mDraftFragments.get(mCurrentPage);
        if (obj != null)
        {
            obj = (DraftFragment)((WeakReference) (obj)).get();
            if (obj != null)
            {
                obj.mCanUnhide = true;
                ((DraftFragment) (obj)).resumePlayer();
                obj = ((DraftFragment) (obj)).getView();
                if (obj != null)
                {
                    ((View) (obj)).setVisibility(0);
                }
            }
        }
    }

    private void unbindDrawables(View view)
    {
        if (view.getBackground() != null)
        {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup)
        {
            for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++)
            {
                unbindDrawables(((ViewGroup)view).getChildAt(i));
            }

            ((ViewGroup)view).removeAllViews();
        }
    }

    public void addPlayerToPool(SdkVideoView sdkvideoview)
    {
        this;
        JVM INSTR monitorenter ;
        mVideoViews.add(sdkvideoview);
        this;
        JVM INSTR monitorexit ;
        return;
        sdkvideoview;
        throw sdkvideoview;
    }

    public void cameraPreviewToRecorder(View view, View view1)
    {
        if (isResuming())
        {
            return;
        } else
        {
            mIsGoingToRecord = true;
            float f = (float)mScreenSize.x / (float)view.getLayoutParams().width;
            int i = getResources().getDimensionPixelOffset(0x7f0b006a);
            int j = getResources().getDimensionPixelOffset(0x7f0b0031);
            int ai[] = new int[2];
            view.getLocationInWindow(ai);
            view1.setVisibility(8);
            FloatingViewUtils.buildFloatingViewFor(this, view, mPreviewOverlay, view.getWidth(), ai[0], ai[1] - j);
            mPreviewOverlay.setVisibility(0);
            (new MoveResizeAnimator(4, mPreviewOverlay, mPreviewOverlay, 0, i, f, f, 300, this, view)).start();
            return;
        }
    }

    protected RecordingFragment createRecordingFragment()
    {
        return new RecordingFragment();
    }

    protected RecordingPreviewFragment createRecordingPreviewFragmentHw(RecordingFile recordingfile, String s)
    {
        return RecordingPreviewFragment.newInstance(recordingfile.getVideoPath(), null, s, mIsMessaging, mConversationRowId, mDirectUserId, isFromSony(), mColor, mRecipientUsername, mAmFollowingRecipient, mIsVmOnboarding);
    }

    protected RecordingPreviewFragment createRecordingPreviewFragmentSw(RecordingFile recordingfile, String s)
    {
        return RecordingPreviewFragment.newInstance(recordingfile.getVideoPath(), mUploadFile, s, mIsMessaging, mConversationRowId, mDirectUserId, isFromSony(), mColor, mRecipientUsername, mAmFollowingRecipient, mIsVmOnboarding);
    }

    protected boolean currentlyHoldsRecordingFragment()
    {
        return mCurrentFragment != null && (mCurrentFragment instanceof RecordingFragment);
    }

    public void deleteCurrentDraft()
    {
        if (mCurrentPage != 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        Object obj;
        try
        {
            mCurrentPage = -1;
            int j = mViewPager.getCurrentItem();
            obj = (WeakReference)mDraftFragments.get(j);
        }
        catch (IOException ioexception)
        {
            SLog.e("Failed to delete current draft.", ioexception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        obj = (DraftFragment)((WeakReference) (obj)).get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        ((DraftFragment) (obj)).setExpired(true);
        if (mCurrentSession != null)
        {
            RecordSessionManager.deleteSession(mCurrentSession.folder, "deleteCurrentDraft");
        }
        FlurryUtils.trackAbandonedStage("draft");
        mStartSessionId = null;
        obj = RecordSessionManager.getValidSessions(this, getVersion());
        reload(((ArrayList) (obj)));
        mSessions = ((ArrayList) (obj));
        mViewPager.requestLayout();
        mViewPager.invalidate();
        mAdapter.notifyDataSetChanged();
        mViewPager.setCurrentItem(i, false);
        onPageSelected(i);
        return;
_L2:
        i = mCurrentPage;
        i--;
          goto _L3
    }

    protected void discardUpload()
    {
        if (mUploadFile != null)
        {
            SLog.d("Upload discarded.");
            UploadManager.removeFromUploadQueue(this, mUploadFile);
        }
    }

    public boolean endRelativeTime()
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            return ((RecordingFragment)mCurrentFragment).endRelativeTime();
        } else
        {
            return false;
        }
    }

    public long getConversationRowId()
    {
        return mConversationRowId;
    }

    public RecordingActivityHelper getRecordingActivityHelper()
    {
        return mHelper;
    }

    public Point getScreenSize()
    {
        return mScreenSize;
    }

    public boolean hasPreviewedAlready()
    {
        return mHasPreviewedAlready;
    }

    public void hideDrafts(final boolean animate)
    {
        CrashUtil.log("Fading away drafts.");
        AnimationSet animationset = new AnimationSet(true);
        if (animate)
        {
            animationset.addAnimation(ViewUtil.makeResizeAnimation(co.vine.android.util.ViewUtil.ResizeAnimationType.COLLAPSE_HEIGHT, mDraftMaskTop, 0));
            animationset.addAnimation(ViewUtil.makeResizeAnimation(co.vine.android.util.ViewUtil.ResizeAnimationType.COLLAPSE_WIDTH, mDraftMaskLeft, 0));
            animationset.addAnimation(ViewUtil.makeResizeAnimation(co.vine.android.util.ViewUtil.ResizeAnimationType.COLLAPSE_WIDTH, mDraftMaskRight, 0));
        }
        animationset.addAnimation(AnimationUtils.loadAnimation(this, 0x7f04000f));
        animationset.setAnimationListener(new SimpleAnimationListener() {

            final AbstractRecordingActivity this$0;
            final boolean val$animate;

            public void onAnimationEnd(Animation animation)
            {
                hideDraftsInternal();
            }

            public void onAnimationStart(Animation animation)
            {
                if (animate)
                {
                    mDraftMaskParent.setVisibility(0);
                    return;
                } else
                {
                    mDraftMaskParent.setVisibility(8);
                    mDraftRoot.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = AbstractRecordingActivity.this;
                animate = flag;
                super();
            }
        });
        animationset.setDuration(300L);
        mDragUpToDeleteView.setView(null, mViewPager.getLeftOfSelectedFragment());
        mDraftRoot.startAnimation(animationset);
        mDraftTrashContainer.animate().cancel();
        mDraftTrashContainer.setVisibility(8);
    }

    public void initMasks(final View bottomMaskParams, final View bottomMask)
    {
        bottomMaskParams.setOnTouchListener(mOnMaskTouchListesner);
        bottomMask.setOnTouchListener(mOnMaskTouchListesner);
        int i = getSharedPreferences("capture", 0).getInt(VineRecorder.getBottomMaskHeightPref(RecordConfigUtils.isDefaultFrontFacing()), 0);
        if (i > 0)
        {
            bottomMaskParams = (android.widget.RelativeLayout.LayoutParams)bottomMask.getLayoutParams();
            bottomMaskParams.height = i;
            runOnUiThread(new Runnable() {

                final AbstractRecordingActivity this$0;
                final View val$bottomMask;
                final android.widget.RelativeLayout.LayoutParams val$bottomMaskParams;

                public void run()
                {
                    bottomMask.setLayoutParams(bottomMaskParams);
                }

            
            {
                this$0 = AbstractRecordingActivity.this;
                bottomMask = view;
                bottomMaskParams = layoutparams;
                super();
            }
            });
        }
    }

    public boolean isDraftsShowing()
    {
        return mDraftRoot.getVisibility() != 8;
    }

    public boolean isFromSony()
    {
        return false;
    }

    public String makeSureUploadIsReady()
    {
        if (mAddToUploadThread != null)
        {
            try
            {
                mAddToUploadThread.join();
            }
            catch (InterruptedException interruptedexception)
            {
                throw new RuntimeException(interruptedexception);
            }
        }
        return mUploadFile;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (mCurrentFragment instanceof RecordingPreviewFragment)
        {
            mCurrentFragment.onActivityResult(i, j, intent);
            return;
        }
        if (j == 31 || j == 32)
        {
            finish();
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onAnimationFinish(int i, Object obj)
    {
        switch (i)
        {
        case 2: // '\002'
        default:
            return;

        case 1: // '\001'
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f04000f);
            mDraftRoot.startAnimation(animation);
            hideDrafts(false);
            swapFolder("PreviewAnimationFinish", (File)obj);
            mIsGoingToRecord = false;
            return;

        case 3: // '\003'
            deleteCurrentDraft();
            mPreviewOverlay.setVisibility(8);
            return;

        case 4: // '\004'
            hideDrafts(false);
            break;
        }
        swapFolder("CameraAnimationFinish", null);
        mIsGoingToRecord = false;
    }

    public void onBackPressed()
    {
        makeSureUploadIsReady();
        RecordingFragment recordingfragment;
        boolean flag;
        try
        {
            if (mStep == -1)
            {
                super.onBackPressed();
                return;
            }
        }
        catch (IllegalStateException illegalstateexception)
        {
            return;
        }
        if (isDraftsShowing())
        {
            hideDrafts(true);
            releasePlayers();
            if (mCurrentFragment instanceof RecordingFragment)
            {
                ((RecordingFragment)mCurrentFragment).resumeFromDraft();
                return;
            }
            break MISSING_BLOCK_LABEL_172;
        }
        if (!currentlyHoldsRecordingFragment())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        recordingfragment = (RecordingFragment)mCurrentFragment;
        flag = recordingfragment.isEditing();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (!recordingfragment.isSessionModified())
        {
            recordingfragment.setDiscardChangesOnStop();
            setResult(100);
            recordingfragment.playStopSound();
            super.onBackPressed();
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (!recordingfragment.isEditingDirty())
        {
            recordingfragment.playStopSound();
            recordingfragment.discardEditing();
            return;
        }
        if (!mIsMessaging)
        {
            showUnSavedChangesDialog(0, recordingfragment);
            return;
        }
        setResult(100);
        super.onBackPressed();
        return;
        if (mCurrentFragment instanceof RecordingPreviewFragment)
        {
            ((RecordingPreviewFragment)mCurrentFragment).previewToRecord(this, false);
        }
    }

    public void onCameraSwitchPressed(View view)
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            FlurryUtils.trackCameraSwitchPressed(view);
            ((RecordingFragment)mCurrentFragment).onCameraSwitchPressed(view);
        }
    }

    public void onCreate(Bundle bundle)
    {
        Object obj1 = getIntent();
        Object obj = null;
        if (obj1 != null)
        {
            obj = ((Intent) (obj1)).getAction();
        }
        CrashUtil.log("AbstractRecordingActivity {} pid: {}, action tag {}.", new Object[] {
            this, Integer.valueOf(Process.myPid()), obj
        });
        mIntentionalObjectCounter.add();
        FlurryUtils.trackRecordingStart();
        super.onCreate(bundle, 0x7f030085, false, true);
        mHelper.bindCameraService(this);
        mScreenSize = SystemUtil.getDisplaySize(this);
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("co.vine.android.session.logout");
        ((IntentFilter) (obj)).addAction("co.vine.android.session.login");
        obj = getResources();
        if (SystemUtil.getMemoryRatio(this, true) < 1.0D)
        {
            Util.showCenteredToast(this, 0x7f0e0257);
            finish();
        } else
        {
            mVersion = RecordSessionManager.getCurrentVersion(this);
            if (bundle == null)
            {
                if (obj1 != null)
                {
                    obj1 = ((Intent) (obj1)).getExtras();
                    if (obj1 != null)
                    {
                        mIsMessaging = ((Bundle) (obj1)).getBoolean("messaging");
                        mConversationRowId = ((Bundle) (obj1)).getLong("conv_row_id", -1L);
                        mTopOverlay = (Bitmap)((Bundle) (obj1)).getParcelable("arg_top_overlay");
                        mDirectUserId = ((Bundle) (obj1)).getLong("direct_id", -1L);
                        mStartConversation = ((Bundle) (obj1)).getBoolean("start_conversation");
                        mRecipientUsername = ((Bundle) (obj1)).getString("recipient_username");
                        mIsVmOnboarding = ((Bundle) (obj1)).getBoolean("is_vm_onboarding");
                    }
                }
                toRecord(true, false, null);
            }
            VineAccountHelper.resetActiveSession();
            startService(VineUploadService.getClearNotificationsIntent(this));
            mPreviewRatio = (float)((Resources) (obj)).getInteger(0x7f0c0003) / 100F;
            mDraftRoot = findViewById(0x7f0a01d5);
            mDraftRoot.setVisibility(8);
            mViewPager = (DraftViewPager)findViewById(0x7f0a00da);
            mDots = (DotIndicators)findViewById(0x7f0a00db);
            mPreviewDimen = (int)((float)mScreenSize.x * mPreviewRatio);
            mPreviewOverlay = findViewById(0x7f0a00dd);
            mProgressOverlay = findViewById(0x7f0a00dc);
            mDraftMaskTop = findViewById(0x7f0a01db);
            mDraftMaskTop.setOnClickListener(mEmptyClicker);
            mDraftMaskLeft = findViewById(0x7f0a01dc);
            mDraftMaskLeft.setOnClickListener(mEmptyClicker);
            mDraftMaskRight = findViewById(0x7f0a01dd);
            mDraftMaskRight.setOnClickListener(mEmptyClicker);
            mDraftMaskParent = findViewById(0x7f0a01da);
            mDraftTrashContainer = findViewById(0x7f0a01de);
            mDraftTrashBackground = findViewById(0x7f0a01df);
            mDraftTrashButton = findViewById(0x7f0a01e0);
            mDraftTrashButton.setOnClickListener(new android.view.View.OnClickListener() {

                final AbstractRecordingActivity this$0;

                public void onClick(View view)
                {
                    if (mCurrentPage != mDraftFragments.size())
                    {
                        mDeleteWasDrag = false;
                        showDeleteDialog();
                    }
                }

            
            {
                this$0 = AbstractRecordingActivity.this;
                super();
            }
            });
            mDraftTrashButton.setOnTouchListener(new android.view.View.OnTouchListener() {

                boolean hasMovedOut;
                final AbstractRecordingActivity this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    boolean flag2 = true;
                    motionevent.getAction();
                    JVM INSTR tableswitch 0 2: default 32
                //                               0 34
                //                               1 72
                //                               2 85;
                       goto _L1 _L2 _L3 _L4
_L1:
                    return false;
_L2:
                    if (mCurrentPage != mDraftFragments.size())
                    {
                        mDraftTrashBackground.setActivated(true);
                        hasMovedOut = false;
                        return false;
                    }
                      goto _L1
_L3:
                    mDraftTrashBackground.setActivated(false);
                    return false;
_L4:
                    float f = motionevent.getX();
                    float f1 = motionevent.getY();
                    boolean flag;
                    boolean flag1;
                    if (f >= 0.0F && f <= (float)mDraftTrashButton.getWidth() && f1 >= 0.0F && f1 <= (float)mDraftTrashButton.getHeight())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        hasMovedOut = true;
                    }
                    view = mDraftTrashBackground;
                    if (flag && !hasMovedOut)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    view.setActivated(flag1);
                    view = mDraftTrashButton;
                    if (flag && !hasMovedOut)
                    {
                        flag1 = flag2;
                    } else
                    {
                        flag1 = false;
                    }
                    view.setActivated(flag1);
                    return false;
                }

            
            {
                this$0 = AbstractRecordingActivity.this;
                super();
                hasMovedOut = false;
            }
            });
            mDragUpToDeleteView = (DragUpToDeleteContainer)findViewById(0x7f0a01d4);
            mDragUpToDeleteView.setVisibility(8);
            mDragUpToDeleteView.setInteractionListner(this);
            mDraftTrashContainer.setVisibility(8);
            int j = ((Resources) (obj)).getDimensionPixelOffset(0x7f0b0033);
            int i = ((Resources) (obj)).getDimensionPixelOffset(0x7f0b006a);
            mTopMaskHeight = i + j;
            mSideMaskWidth = mScreenSize.x / 2 - mPreviewDimen / 2;
            obj1 = findViewById(0x7f0a00d9);
            android.view.ViewGroup.LayoutParams layoutparams = ((View) (obj1)).getLayoutParams();
            layoutparams.width = (int)(mPreviewRatio + (float)mScreenSize.x * ((1.0F - mPreviewRatio) / 2.0F));
            ((View) (obj1)).setLayoutParams(layoutparams);
            if (bundle != null)
            {
                if (bundle.containsKey("state_fp"))
                {
                    mFirstPageSet = bundle.getBoolean("state_fp");
                }
                int k;
                if (bundle.containsKey("first_launch"))
                {
                    mFirstDraftLaunch = bundle.getBoolean("first_launch");
                } else
                {
                    mFirstDraftLaunch = true;
                }
            } else
            {
                mFirstDraftLaunch = true;
            }
            k = ((Resources) (obj)).getDimensionPixelOffset(0x7f0b0030);
            bundle = mViewPager.getLayoutParams();
            bundle.height = mScreenSize.x + i + k;
            mViewPager.setLayoutParams(bundle);
            k = ((Resources) (obj)).getDimensionPixelOffset(0x7f0b0030);
            mDots.setY(mScreenSize.x + i + k / 4);
            mLargeThumbnailOverlay = (ImageView)findViewById(0x7f0a01d7);
            mAnimationPreviewOverlay = findViewById(0x7f0a01d8);
            mCameraIconOverlay = findViewById(0x7f0a01d9);
            mCameraIconOverlay.setVisibility(8);
            mCameraIconOverlayImage = findViewById(0x7f0a00d3);
            mDraftFullMask = findViewById(0x7f0a01d6);
            mSlowFadeIn = AnimationUtils.loadAnimation(this, 0x7f040019);
            mCameraIconFadeIn = AnimationUtils.loadAnimation(this, 0x7f040019);
            if (!mIsMessaging)
            {
                bundle = getSharedPreferences("capture", 0);
                i = bundle.getInt("recorder_launch_count", 0);
                bundle.edit().putInt("recorder_launch_count", i + 1).apply();
                return;
            }
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        mHelper.unBindCameraService(this);
        int i;
        mIntentionalObjectCounter.release();
        i = mIntentionalObjectCounter.getCount();
label0:
        {
            {
                if (i != 0)
                {
                    break label0;
                }
                View view;
                try
                {
                    CrashUtil.log("Clean up folders because we are the last one.");
                    getVersion().getManager(this).cleanUnusedFolders();
                }
                catch (IOException ioexception)
                {
                    CrashUtil.logException(ioexception);
                }
            }
            mCurrentFragment = null;
            CrashUtil.log("[mem] AbstractRecordingActivity {} Destroyed.", new Object[] {
                this
            });
            FlurryUtils.trackRecordingDestroy();
            view = findViewById(0x7f0a01d3);
            try
            {
                unbindDrawables(view);
            }
            catch (Exception exception)
            {
                SLog.e("Failed to remove all drawables, but FINE.");
            }
            System.gc();
            return;
        }
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        CrashUtil.logException(new VineLoggingException("Double instance violation, but it's ok."));
        break MISSING_BLOCK_LABEL_48;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 169
    //                   1 33
    //                   2 99
    //                   3 32;
           goto _L1 _L2 _L3 _L4 _L1
_L1:
        return;
_L3:
        switch (j)
        {
        default:
            return;

        case -2: 
            showCurrentFragment();
            mDraftTrashButton.setActivated(false);
            mDraftTrashBackground.setActivated(false);
            return;

        case -1: 
            handleDelete();
            break;
        }
        mDraftTrashButton.setActivated(false);
        mDraftTrashBackground.setActivated(false);
        return;
_L4:
        switch (j)
        {
        default:
            return;

        case -1: 
            continue; /* Loop/switch isn't completed */

        case -2: 
            if (mCurrentFragment instanceof RecordingFragment)
            {
                ((RecordingFragment)mCurrentFragment).startDrafts(false);
                return;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (!(mCurrentFragment instanceof RecordingFragment)) goto _L1; else goto _L5
_L5:
        ((RecordingFragment)mCurrentFragment).startDrafts(true);
        return;
_L2:
        switch (j)
        {
        default:
            return;

        case -2: 
            if (currentlyHoldsRecordingFragment())
            {
                dialoginterface = (RecordingFragment)mCurrentFragment;
                dialoginterface.setDiscardChangesOnStop();
                dialoginterface.playStopSound();
            }
            discardUpload();
            setResult(100);
            finish();
            return;

        case -1: 
            break;
        }
        if (currentlyHoldsRecordingFragment())
        {
            setResult(100);
            ((RecordingFragment)mCurrentFragment).saveSessionAndQuit();
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onFinishPressed(View view)
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            ((RecordingFragment)mCurrentFragment).onFinishPressed(view);
        }
    }

    public void onFocusSwitchPressed(View view)
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            FlurryUtils.trackFocusSwitchPressed(view);
            ((RecordingFragment)mCurrentFragment).onFocusSwitchPressed(view);
        }
    }

    public void onGhostSwitchPressed(View view)
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            FlurryUtils.trackGhostSwitchPressed(view);
            ((RecordingFragment)mCurrentFragment).onGhostSwitchPressed(view);
        }
    }

    public void onGridSwitchPressed(View view)
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            FlurryUtils.trackGridSwitchPressed(view);
            ((RecordingFragment)mCurrentFragment).onGridSwitchPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        SLog.d("KEY DOWN {}.", Integer.valueOf(i));
        i;
        JVM INSTR lookupswitch 6: default 68
    //                   24: 181
    //                   25: 193
    //                   27: 205
    //                   80: 179
    //                   168: 181
    //                   169: 193;
           goto _L1 _L2 _L3 _L4 _L5 _L2 _L3
_L4:
        break MISSING_BLOCK_LABEL_205;
_L1:
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = false;
        flag1 = false;
        flag2 = false;
_L6:
        RecordingFragment recordingfragment;
        recordingfragment = getActiveRecordingFragment();
        if (isSecretModeOn)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        if (i == SECRETS[mCurrentSecret] && SLog.sLogsOn)
        {
            mCurrentSecret = mCurrentSecret + 1;
            if (mCurrentSecret >= SECRETS.length && recordingfragment != null)
            {
                recordingfragment.enableSecretMode(Util.showCenteredToast(this, "Secret mode enabled."));
                isSecretModeOn = true;
                mCurrentSecret = 0;
            }
        } else
        {
            mCurrentSecret = 0;
        }
        if (recordingfragment == null)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        if (!flag1 || recordingfragment.isEditing())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        recordingfragment.modifyZoom(flag2);
        recordingfragment.requestZoomProgressUpdate();
_L5:
        return true;
_L2:
        flag2 = true;
        flag1 = true;
        flag = false;
          goto _L6
_L3:
        flag2 = false;
        flag1 = true;
        flag = false;
          goto _L6
        flag = true;
        flag1 = false;
        flag2 = false;
          goto _L6
        if (flag)
        {
            mHasStartedRelativeTimeFromHardwareButton = true;
            recordingfragment.startRelativeTime();
            return true;
        }
        break MISSING_BLOCK_LABEL_309;
        if (recordingfragment != null)
        {
            if (flag1)
            {
                if (!recordingfragment.isEditing())
                {
                    if (flag2)
                    {
                        recordingfragment.doSecretVolumeUp();
                        return true;
                    } else
                    {
                        recordingfragment.doSecretVolumeDown();
                        return true;
                    }
                } else
                {
                    Util.showCenteredToast(getApplicationContext(), "Reversed.");
                    recordingfragment.reverseFrames();
                    return true;
                }
            }
            if (flag)
            {
                mHasStartedRelativeTimeFromHardwareButton = true;
                recordingfragment.startRelativeTime();
                return true;
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   24: 100
    //                   25: 100
    //                   27: 109
    //                   80: 98
    //                   168: 100
    //                   169: 100;
           goto _L1 _L2 _L2 _L3 _L4 _L2 _L2
_L1:
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
_L6:
        RecordingFragment recordingfragment;
        recordingfragment = getActiveRecordingFragment();
        if (recordingfragment == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        if (isSecretModeOn || !flag1 || recordingfragment.isEditing())
        {
            break; /* Loop/switch isn't completed */
        }
        recordingfragment.stopZoom();
_L4:
        return true;
_L2:
        flag1 = true;
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        flag1 = false;
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        if (mHasStartedRelativeTimeFromHardwareButton && flag)
        {
            recordingfragment.endRelativeTime();
        }
        return super.onKeyUp(i, keyevent);
    }

    public void onPageScrollStateChanged(int i)
    {
        mPageScrollState = i;
        if (i == 0 && mOnPageIdleRunnable != null)
        {
            mOnPageIdleRunnable.run();
            mOnPageIdleRunnable = null;
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        if (mSessions == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj5;
        Object obj6;
        boolean flag;
        int j;
        obj5 = null;
        obj6 = null;
        Object obj4 = null;
        obj2 = null;
        obj1 = null;
        obj3 = null;
        if (mPageScrollState == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = mSessions.size();
        if (i != -1) goto _L4; else goto _L3
_L3:
        obj = obj4;
        obj1 = obj3;
        if (mCurrentPage <= j)
        {
            obj2 = (WeakReference)mDraftFragments.get(mCurrentPage);
            obj = obj4;
            obj1 = obj3;
            if (obj2 != null)
            {
                obj2 = (DraftFragment)((WeakReference) (obj2)).get();
                obj = obj4;
                obj1 = obj3;
                if (obj2 != null)
                {
                    if (flag)
                    {
                        ((DraftFragment) (obj2)).setSelected(false);
                        obj1 = obj3;
                        obj = obj4;
                    } else
                    {
                        obj = obj2;
                        obj1 = obj3;
                    }
                }
            }
        }
_L6:
        if (obj != null || obj1 != null)
        {
            mOnPageIdleRunnable = new SetSelectedRunnable(((DraftFragment) (obj)), ((DraftFragment) (obj1)));
        }
_L2:
        return;
_L4:
        mDots.setActiveDot(i);
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj5;
        if (mCurrentPage != -1)
        {
            obj = obj5;
            if (mCurrentPage <= j)
            {
                obj1 = (WeakReference)mDraftFragments.get(mCurrentPage);
                obj = obj5;
                if (obj1 != null)
                {
                    obj1 = (DraftFragment)((WeakReference) (obj1)).get();
                    obj = obj5;
                    WeakReference weakreference;
                    View view;
                    if (obj1 != null)
                    {
                        if (flag)
                        {
                            ((DraftFragment) (obj1)).setSelected(false);
                            obj = obj5;
                        } else
                        {
                            obj = obj1;
                        }
                    }
                }
            }
        }
        weakreference = (WeakReference)mDraftFragments.get(i);
        obj1 = obj2;
        if (weakreference != null)
        {
            DraftFragment draftfragment1 = (DraftFragment)weakreference.get();
            obj1 = obj2;
            if (draftfragment1 != null)
            {
                view = draftfragment1.getView();
                obj1 = obj2;
                if (view != null)
                {
                    view = view.findViewById(0x7f0a00d5);
                    obj1 = obj2;
                    if (view != null)
                    {
                        obj1 = obj2;
                        if (mDragUpToDeleteView != null)
                        {
                            mDragUpToDeleteView.setView(view, mViewPager.getLeftOfSelectedFragment());
                            if (!mAnimatingIntoDrafts || i < j)
                            {
                                mDraftTrashContainer.setVisibility(0);
                                mDraftTrashContainer.animate().alpha(1.0F).start();
                            }
                            mHandler.removeCallbacks(mOnResumeDraftRunnable);
                            if (mPageScrollState == 0)
                            {
                                draftfragment1.setSelected(true);
                                obj1 = obj2;
                            } else
                            {
                                obj1 = draftfragment1;
                            }
                        }
                    }
                }
            }
        }
        mCurrentSession = (co.vine.android.recorder.RecordSessionManager.RecordSessionInfo)mSessions.get(i);
_L7:
        mCurrentPage = i;
        if (true) goto _L6; else goto _L5
_L5:
        obj = obj6;
        if (mCurrentPage != -1)
        {
            obj = (WeakReference)mDraftFragments.get(mCurrentPage);
            if (obj != null)
            {
                DraftFragment draftfragment = (DraftFragment)((WeakReference) (obj)).get();
                obj = obj6;
                if (draftfragment != null)
                {
                    if (flag)
                    {
                        draftfragment.setSelected(false);
                        obj = obj6;
                    } else
                    {
                        obj = draftfragment;
                    }
                }
            } else
            {
                SLog.d("Fragment {} is null: size: {}.", Integer.valueOf(mCurrentPage), Integer.valueOf(mDraftFragments.size()));
                obj = obj6;
            }
        }
        if (mCameraFragment != null && (DraftCameraPreviewFragment)mCameraFragment.get() != null)
        {
            mHandler.removeCallbacks(mOnResumeDraftRunnable);
        }
        mCurrentSession = null;
        mDragUpToDeleteView.setView(null, mViewPager.getLeftOfSelectedFragment());
        mDraftTrashContainer.animate().alpha(0.0F).setListener(new SimpleAnimatorListener() {

            final AbstractRecordingActivity this$0;

            public void onAnimationEnd(Animator animator)
            {
                mDraftTrashContainer.setVisibility(8);
                mDraftTrashContainer.animate().setListener(null);
            }

            
            {
                this$0 = AbstractRecordingActivity.this;
                super();
            }
        }).start();
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
    }

    protected void onPause()
    {
        super.onPause();
        if (mPromptDialog != null && mPromptDialog.isVisible())
        {
            mPromptDialog.dismiss();
        }
        releasePlayers();
    }

    public void onRecorderBackPressed(View view)
    {
        try
        {
            onBackPressed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("state_fp", mFirstPageSet);
        bundle.putBoolean("first_launch", mFirstDraftLaunch);
    }

    public void onSessionSwitchPressed(View view)
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            ((RecordingFragment)mCurrentFragment).onSessionSwitchPressed(view);
        }
    }

    public void preSetContentView()
    {
        if (!CameraManager.hasCamera())
        {
            Util.showNoCameraToast(this);
            finish();
        }
    }

    public boolean prepareForPickup()
    {
        boolean flag = false;
        if (!mAnimatingIntoDrafts)
        {
            Object obj = (WeakReference)mDraftFragments.get(mCurrentPage);
            if (obj != null)
            {
                obj = (DraftFragment)((WeakReference) (obj)).get();
                obj.mCanUnhide = false;
                ((DraftFragment) (obj)).pausePlayer();
                ((DraftFragment) (obj)).showImage();
            }
        }
        if (!mAnimatingIntoDrafts)
        {
            flag = true;
        }
        return flag;
    }

    public void releaseOtherPlayers(SdkVideoView sdkvideoview)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = mVideoViews.iterator();
_L2:
        SdkVideoView sdkvideoview1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_46;
            }
            sdkvideoview1 = (SdkVideoView)iterator.next();
        } while (sdkvideoview1 == sdkvideoview);
        sdkvideoview1.suspend();
        if (true) goto _L2; else goto _L1
_L1:
        sdkvideoview;
        throw sdkvideoview;
        mVideoViews.clear();
        this;
        JVM INSTR monitorexit ;
    }

    public void requestForMoreMemory()
    {
        try
        {
            AppController.getInstance(this).clearImageCacheFromMemory();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            CrashUtil.log("Failed to clear image cache memory.");
        }
    }

    public void showDeleteDialog()
    {
        PromptDialogFragment promptdialogfragment = PromptDialogFragment.newInstance(1);
        promptdialogfragment.setListener(this);
        promptdialogfragment.setMessage(0x7f0e00b3);
        promptdialogfragment.setPositiveButton(0x7f0e00b6);
        promptdialogfragment.setNegativeButton(0x7f0e0057);
        promptdialogfragment.show(getFragmentManager());
    }

    public void showDrafts(String s)
    {
        int j;
        int k;
        int l;
        final boolean goToCamera;
        CrashUtil.log("Started showing drafts.");
        goToCamera = "camera_preview".equals(s);
        mAnimatingIntoDrafts = true;
        mStartSessionId = s;
        mFirstPageSet = false;
        reload(RecordSessionManager.getValidSessions(this, getVersion()));
        mDraftFullMask.setVisibility(0);
        mDraftMaskParent.setVisibility(0);
        mCameraIconOverlayImage.setVisibility(8);
        s = getResources();
        k = s.getDimensionPixelSize(0x7f0b006a);
        l = s.getDimensionPixelOffset(0x7f0b0033);
        j = mTopMaskHeight;
        int i;
        i = j;
        if (goToCamera)
        {
            i = j + l;
        }
        if (goToCamera) goto _L2; else goto _L1
_L1:
        if (!(mCurrentFragment instanceof RecordingFragment)) goto _L2; else goto _L3
_L3:
        s = mLargeThumbnailOverlay;
        Object obj = (android.widget.RelativeLayout.LayoutParams)s.getLayoutParams();
        obj.width = mScreenSize.x;
        obj.height = mScreenSize.x;
        obj.leftMargin = 0;
        obj.topMargin = k;
        s.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = ((RecordingFragment)mCurrentFragment).getThumbnailPath();
        ViewUtil.setBackground(s, new BitmapDrawable(getResources(), ((String) (obj))));
        s.setVisibility(0);
_L4:
        mViewPager.setOnTouchListener(new android.view.View.OnTouchListener() {

            final AbstractRecordingActivity this$0;
            final boolean val$goToCamera;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                if (goToCamera)
                {
                    mCameraIconOverlay.setVisibility(8);
                } else
                {
                    mLargeThumbnailOverlay.setVisibility(8);
                    mAnimationPreviewOverlay.setVisibility(8);
                }
                return false;
            }

            
            {
                this$0 = AbstractRecordingActivity.this;
                goToCamera = flag;
                super();
            }
        });
        s = new AnimationSet(true);
        s.addAnimation(ViewUtil.makeResizeAnimation(co.vine.android.util.ViewUtil.ResizeAnimationType.EXPAND_HEIGHT, mDraftMaskTop, i));
        s.addAnimation(ViewUtil.makeResizeAnimation(co.vine.android.util.ViewUtil.ResizeAnimationType.EXPAND_WIDTH, mDraftMaskLeft, mSideMaskWidth));
        s.addAnimation(ViewUtil.makeResizeAnimation(co.vine.android.util.ViewUtil.ResizeAnimationType.EXPAND_WIDTH, mDraftMaskRight, mSideMaskWidth));
        s.setAnimationListener(new SimpleAnimationListener() {

            final AbstractRecordingActivity this$0;
            final boolean val$goToCamera;

            public void onAnimationEnd(Animation animation)
            {
                if (mCurrentPage != mDraftFragments.size())
                {
                    mDraftTrashContainer.setAlpha(0.0F);
                    mDraftTrashContainer.setVisibility(0);
                    if (!isResuming())
                    {
                        mDraftTrashContainer.animate().alpha(1.0F).start();
                    }
                }
                mSlowFadeIn.setAnimationListener(new SimpleAnimationListener() {

                    final _cls9 this$1;

                    public void onAnimationEnd(Animation animation)
                    {
                        mAnimatingIntoDrafts = false;
                        mHandler.postDelayed(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                if (!goToCamera)
                                {
                                    mLargeThumbnailOverlay.setVisibility(8);
                                    mAnimationPreviewOverlay.setVisibility(8);
                                }
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        }, 300L);
                    }

                    public void onAnimationStart(Animation animation)
                    {
                        if (goToCamera)
                        {
                            mCameraIconOverlayImage.setVisibility(0);
                            mCameraIconOverlayImage.setAlpha(0.0F);
                            mCameraIconOverlayImage.animate().alpha(1.0F).setDuration(mSlowFadeIn.getDuration()).setListener(new ViewGoneAnimationListener(mCameraIconOverlayImage)).start();
                            mHandler.postDelayed(new Runnable() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    mCameraIconOverlay.setVisibility(8);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            }, mCameraIconFadeIn.getDuration());
                        }
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
                mHandler.postDelayed(new Runnable() {

                    final _cls9 this$1;

                    public void run()
                    {
                        mDraftFullMask.setVisibility(8);
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                }, 150L);
                mViewPager.setVisibility(0);
                mViewPager.startAnimation(mSlowFadeIn);
                mPageScrollState = 0;
                mDraftRoot.setVisibility(0);
                if (mCurrentFragment instanceof RecordingFragment)
                {
                    ((RecordingFragment)mCurrentFragment).onShowDrafts();
                }
                mDraftMaskParent.setVisibility(8);
                mDraftMaskTop.setVisibility(8);
                mDraftMaskLeft.setVisibility(8);
                mDraftMaskRight.setVisibility(8);
            }

            public void onAnimationStart(Animation animation)
            {
                mHandler.removeCallbacks(mOnResumeDraftRunnable);
                mHandler.postDelayed(mOnResumeDraftRunnable, 300L);
            }

            
            {
                this$0 = AbstractRecordingActivity.this;
                goToCamera = flag;
                super();
            }
        });
        s.setDuration(300L);
        setCurrentSession();
        mDragUpToDeleteView.setVisibility(0);
        if (goToCamera)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        View view;
        if (!(mCurrentFragment instanceof RecordingFragment))
        {
            break MISSING_BLOCK_LABEL_372;
        }
        view = ((RecordingFragment)mCurrentFragment).getProgressView();
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_364;
        }
        FloatingViewUtils.buildFloatingViewFor(this, view, mAnimationPreviewOverlay, view.getWidth(), 0, 0);
        mAnimationPreviewOverlay.setVisibility(0);
        if (!goToCamera)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        (new MoveResizeAnimator(7, mCameraIconOverlay, mCameraIconOverlay, (int)(((float)mScreenSize.x * (1.0F - mPreviewRatio)) / 2.0F), k + l * 2, mPreviewRatio, mPreviewRatio, 300, this, null)).start();
_L5:
        mDraftRoot.startAnimation(s);
        return;
_L2:
        if (goToCamera)
        {
            try
            {
                mCameraIconOverlay.setVisibility(0);
                s = (android.widget.RelativeLayout.LayoutParams)mCameraIconOverlay.getLayoutParams();
                s.width = mScreenSize.x;
                s.height = mScreenSize.x;
                s.topMargin = k;
                s.leftMargin = 0;
                mCameraIconOverlay.setLayoutParams(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                CrashUtil.logException(s, "Error refresh reloading drafts.", new Object[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                CrashUtil.logException(s, "Error showing reloading drafts.", new Object[0]);
                return;
            }
        }
          goto _L4
        (new MoveResizeAnimator(6, mAnimationPreviewOverlay, mAnimationPreviewOverlay, (int)(((float)mScreenSize.x * (1.0F - mPreviewRatio)) / 2.0F), k + l, mPreviewRatio, 0.5D, 300, this, null)).start();
        (new MoveResizeAnimator(5, mLargeThumbnailOverlay, mLargeThumbnailOverlay, (int)(((float)mScreenSize.x * (1.0F - mPreviewRatio)) / 2.0F), k + l * 2, mPreviewRatio, mPreviewRatio, 300, this, null)).start();
          goto _L5
    }

    public void showUnSavedChangesDialog(int i, RecordingFragment recordingfragment)
    {
        mPromptDialog = PromptDialogFragment.newInstance(i);
        PromptDialogFragment promptdialogfragment = mPromptDialog;
        if (recordingfragment.isSavedSession())
        {
            i = 0x7f0e01b8;
        } else
        {
            i = 0x7f0e01b7;
        }
        promptdialogfragment.setMessage(i);
        mPromptDialog.setPositiveButton(0x7f0e01b5);
        mPromptDialog.setNegativeButton(0x7f0e00bb);
        try
        {
            mPromptDialog.show(getFragmentManager());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RecordingFragment recordingfragment)
        {
            return;
        }
    }

    public boolean startConversationOnFinish()
    {
        return mStartConversation;
    }

    public boolean startRelativeTime()
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            return ((RecordingFragment)mCurrentFragment).startRelativeTime();
        } else
        {
            return false;
        }
    }

    public void swapFolder(String s, File file)
    {
        if (mCurrentFragment instanceof RecordingFragment)
        {
            RecordingFragment recordingfragment = (RecordingFragment)mCurrentFragment;
            if (!recordingfragment.isResuming())
            {
                recordingfragment.swapFolder(s, file);
            }
        }
    }

    public void toPreview(String s, final RecordingFile finalFile, final String thumbNailPath, final co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable grabThumbnailRunnable)
    {
        CrashUtil.log("From {} to preview fragment: {} {}", new Object[] {
            s, finalFile, thumbNailPath
        });
        getWindow().getDecorView().setSystemUiVisibility(mRegularUiMode);
        s = UploadManager.getReferenceCursor(this, finalFile.folder.getName());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        if (s.moveToFirst())
        {
            CrashUtil.log("User have edited the vine already, discard until new one comes in.");
            startService(VineUploadService.getDiscardIntent(this, s.getString(1)));
        }
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                CrashUtil.log("Failed to delete previous vines.");
            }
        }
        if (BuildUtil.isIsHwEncodingEnabled())
        {
            mAddToUploadThread = new Thread() {

                final AbstractRecordingActivity this$0;
                final RecordingFile val$finalFile;
                final co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable val$grabThumbnailRunnable;
                final String val$thumbNailPath;

                public void run()
                {
                    if (grabThumbnailRunnable != null)
                    {
                        grabThumbnailRunnable.run();
                    }
                    if (AppController.getInstance(getApplicationContext()).isLoggedIn())
                    {
                        try
                        {
                            mUploadFile = UploadManager.addToUploadQueue(getApplicationContext(), finalFile, thumbNailPath, finalFile.folder.getName(), mIsMessaging, mConversationRowId);
                        }
                        catch (Exception exception)
                        {
                            throw new RuntimeException(exception);
                        }
                    }
                    mAddToUploadThread = null;
                }

            
            {
                this$0 = AbstractRecordingActivity.this;
                grabThumbnailRunnable = generatethumbnailsrunnable;
                finalFile = recordingfile;
                thumbNailPath = s;
                super();
            }
            };
            mAddToUploadThread.start();
        } else
        if (AppController.getInstance(this).isLoggedIn())
        {
            try
            {
                mUploadFile = UploadManager.addToUploadQueue(this, finalFile, thumbNailPath, finalFile.folder.getName(), mIsMessaging, mConversationRowId);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
        }
        if (mCurrentFragment instanceof RecordingFragment)
        {
            mCurrentFragment.onPause();
        }
        if (BuildUtil.isIsHwEncodingEnabled())
        {
            s = createRecordingPreviewFragmentHw(finalFile, thumbNailPath);
        } else
        {
            s = createRecordingPreviewFragmentSw(finalFile, thumbNailPath);
        }
        s.setFinalFile(finalFile);
        mStep = 1;
        mHasPreviewedAlready = true;
        getSupportFragmentManager().beginTransaction().replace(0x7f0a0102, s).commit();
        if (mCurrentFragment instanceof RecordingFragment)
        {
            ((RecordingFragment)mCurrentFragment).release();
        }
        mCurrentFragment = s;
        return;
    }

    public void toRecord(boolean flag, boolean flag1, RecordingFile recordingfile)
    {
        boolean flag3 = false;
        mStep = 0;
        mFirstPageSet = false;
        onPageSelected(-1);
        RecordingFragment recordingfragment;
        Bundle bundle;
        boolean flag2;
        if (recordingfile != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (recordingfile != null)
        {
            flag3 = true;
        }
        CrashUtil.log("To recording fragment: {} {} {}", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag3)
        });
        if (flag2)
        {
            discardUpload();
        }
        recordingfragment = createRecordingFragment();
        bundle = new Bundle();
        bundle.putParcelable("arg_top_overlay", mTopOverlay);
        bundle.putParcelable("screen_size", mScreenSize);
        bundle.putBoolean("is_messaging", mIsMessaging);
        bundle.putBoolean("is_vm_onboarding", mIsVmOnboarding);
        bundle.putString("recipient_username", mRecipientUsername);
        mColor = Util.getDefaultSharedPrefs(this).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
        bundle.putInt("color", mColor);
        recordingfragment.setArguments(bundle);
        recordingfragment.setFileFileToUse(recordingfile);
        recordingfragment.setStartWithEdit(flag1);
        recordingfile = getSupportFragmentManager().beginTransaction();
        if (flag)
        {
            recordingfile.add(0x7f0a0102, recordingfragment);
        } else
        {
            recordingfile.replace(0x7f0a0102, recordingfragment);
        }
        recordingfile.commit();
        mCurrentFragment = recordingfragment;
        mRegularUiMode = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(1);
    }

    public void viewDestroyFinished()
    {
        mDraftTrashButton.setActivated(false);
        mDraftTrashBackground.setActivated(false);
    }

    public boolean viewDropped(int i)
    {
        boolean flag;
        if (i <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && mCurrentPage != mDraftFragments.size())
        {
            mDeleteWasDrag = true;
            showDeleteDialog();
            return flag;
        } else
        {
            mDraftTrashButton.setActivated(false);
            return flag;
        }
    }

    public void viewLanded()
    {
        showCurrentFragment();
    }

    public boolean viewMoved(int i)
    {
        boolean flag1 = true;
        View view;
        boolean flag;
        if (i < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mDraftTrashBackground.setActivated(flag);
        view = mDraftTrashButton;
        if (i >= mDraftTrashContainer.getHeight())
        {
            flag1 = false;
        }
        view.setActivated(flag1);
        return flag;
    }

    public void viewPickedUp()
    {
        hideCurrentFragment();
    }





/*
    static boolean access$102(AbstractRecordingActivity abstractrecordingactivity, boolean flag)
    {
        abstractrecordingactivity.mDeleteWasDrag = flag;
        return flag;
    }

*/









/*
    static boolean access$1702(AbstractRecordingActivity abstractrecordingactivity, boolean flag)
    {
        abstractrecordingactivity.mAnimatingIntoDrafts = flag;
        return flag;
    }

*/





/*
    static int access$2002(AbstractRecordingActivity abstractrecordingactivity, int i)
    {
        abstractrecordingactivity.mPageScrollState = i;
        return i;
    }

*/





/*
    static Thread access$2402(AbstractRecordingActivity abstractrecordingactivity, Thread thread)
    {
        abstractrecordingactivity.mAddToUploadThread = thread;
        return thread;
    }

*/



/*
    static co.vine.android.recorder.RecordSessionManager.RecordSessionInfo access$2602(AbstractRecordingActivity abstractrecordingactivity, co.vine.android.recorder.RecordSessionManager.RecordSessionInfo recordsessioninfo)
    {
        abstractrecordingactivity.mCurrentSession = recordsessioninfo;
        return recordsessioninfo;
    }

*/



/*
    static WeakReference access$2802(AbstractRecordingActivity abstractrecordingactivity, WeakReference weakreference)
    {
        abstractrecordingactivity.mCameraFragment = weakreference;
        return weakreference;
    }

*/




/*
    static boolean access$3002(AbstractRecordingActivity abstractrecordingactivity, boolean flag)
    {
        abstractrecordingactivity.mIsGoingToRecord = flag;
        return flag;
    }

*/








/*
    static boolean access$3602(AbstractRecordingActivity abstractrecordingactivity, boolean flag)
    {
        abstractrecordingactivity.mFirstDraftLaunch = flag;
        return flag;
    }

*/







}
