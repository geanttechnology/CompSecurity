// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.Utils;
import com.handmark.pulltorefresh.library.internal.ViewCompat;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            IPullToRefresh, LoadingLayoutProxy, OverscrollHelper, ILoadingLayout

public abstract class PullToRefreshBase extends LinearLayout
    implements IPullToRefresh
{

    static final boolean DEBUG = true;
    static final int DEMO_SCROLL_INTERVAL = 225;
    static final float FRICTION = 2F;
    static final String LOG_TAG = "PullToRefresh";
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    static final String STATE_CURRENT_MODE = "ptr_current_mode";
    static final String STATE_MODE = "ptr_mode";
    static final String STATE_SCROLLING_REFRESHING_ENABLED = "ptr_disable_scrolling";
    static final String STATE_SHOW_REFRESHING_VIEW = "ptr_show_refreshing_view";
    static final String STATE_STATE = "ptr_state";
    static final String STATE_SUPER = "ptr_super";
    private Mode mCurrentMode;
    private SmoothScrollRunnable mCurrentSmoothScrollRunnable;
    private boolean mFilterTouchEvents;
    private LoadingLayout mFooterLayout;
    private LoadingLayout mHeaderLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionX;
    private float mLastMotionY;
    private boolean mLayoutVisibilityChangesEnabled;
    private AnimationStyle mLoadingAnimationStyle;
    private Mode mMode;
    private OnPullEventListener mOnPullEventListener;
    private OnRefreshListener mOnRefreshListener;
    private OnRefreshListener2 mOnRefreshListener2;
    private boolean mOverScrollEnabled;
    View mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private Interpolator mScrollAnimationInterpolator;
    private boolean mScrollingWhileRefreshingEnabled;
    private boolean mShowViewWhileRefreshing;
    private State mState;
    private int mTouchSlop;

    public PullToRefreshBase(Context context)
    {
        super(context);
        mIsBeingDragged = false;
        mState = State.RESET;
        mMode = Mode.getDefault();
        mShowViewWhileRefreshing = true;
        mScrollingWhileRefreshingEnabled = false;
        mFilterTouchEvents = true;
        mOverScrollEnabled = true;
        mLayoutVisibilityChangesEnabled = true;
        mLoadingAnimationStyle = AnimationStyle.getDefault();
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsBeingDragged = false;
        mState = State.RESET;
        mMode = Mode.getDefault();
        mShowViewWhileRefreshing = true;
        mScrollingWhileRefreshingEnabled = false;
        mFilterTouchEvents = true;
        mOverScrollEnabled = true;
        mLayoutVisibilityChangesEnabled = true;
        mLoadingAnimationStyle = AnimationStyle.getDefault();
        init(context, attributeset);
    }

    public PullToRefreshBase(Context context, Mode mode)
    {
        super(context);
        mIsBeingDragged = false;
        mState = State.RESET;
        mMode = Mode.getDefault();
        mShowViewWhileRefreshing = true;
        mScrollingWhileRefreshingEnabled = false;
        mFilterTouchEvents = true;
        mOverScrollEnabled = true;
        mLayoutVisibilityChangesEnabled = true;
        mLoadingAnimationStyle = AnimationStyle.getDefault();
        mMode = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationstyle)
    {
        super(context);
        mIsBeingDragged = false;
        mState = State.RESET;
        mMode = Mode.getDefault();
        mShowViewWhileRefreshing = true;
        mScrollingWhileRefreshingEnabled = false;
        mFilterTouchEvents = true;
        mOverScrollEnabled = true;
        mLayoutVisibilityChangesEnabled = true;
        mLoadingAnimationStyle = AnimationStyle.getDefault();
        mMode = mode;
        mLoadingAnimationStyle = animationstyle;
        init(context, null);
    }

    private void addRefreshableView(Context context, View view)
    {
        mRefreshableViewWrapper = new FrameLayout(context);
        mRefreshableViewWrapper.addView(view, -1, -1);
        addViewInternal(mRefreshableViewWrapper, new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    private android.widget.LinearLayout.LayoutParams getLoadingLayoutLayoutParams()
    {
        switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            return new android.widget.LinearLayout.LayoutParams(-1, -2);

        case 1: // '\001'
            return new android.widget.LinearLayout.LayoutParams(-2, -1);
        }
    }

    private int getMaximumPullScroll()
    {
        switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            return Math.round((float)getHeight() / 2.0F);

        case 1: // '\001'
            return Math.round((float)getWidth() / 2.0F);
        }
    }

    private void init(Context context, AttributeSet attributeset)
    {
        switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            setOrientation(1);
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_228;
        }
_L1:
        setGravity(17);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, R.styleable.PullToRefresh);
        if (typedarray.hasValue(4))
        {
            mMode = Mode.mapIntToValue(typedarray.getInteger(4, 0));
        }
        if (typedarray.hasValue(12))
        {
            mLoadingAnimationStyle = AnimationStyle.mapIntToValue(typedarray.getInteger(12, 0));
        }
        mRefreshableView = createRefreshableView(context, attributeset);
        addRefreshableView(context, mRefreshableView);
        mHeaderLayout = createLoadingLayout(context, Mode.PULL_FROM_START, typedarray);
        mFooterLayout = createLoadingLayout(context, Mode.PULL_FROM_END, typedarray);
        if (typedarray.hasValue(0))
        {
            context = typedarray.getDrawable(0);
            if (context != null)
            {
                mRefreshableView.setBackgroundDrawable(context);
            }
        } else
        if (typedarray.hasValue(16))
        {
            Utils.warnDeprecation("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            context = typedarray.getDrawable(16);
            if (context != null)
            {
                mRefreshableView.setBackgroundDrawable(context);
            }
        }
        if (typedarray.hasValue(9))
        {
            mOverScrollEnabled = typedarray.getBoolean(9, true);
        }
        if (typedarray.hasValue(13))
        {
            mScrollingWhileRefreshingEnabled = typedarray.getBoolean(13, false);
        }
        handleStyledAttributes(typedarray);
        typedarray.recycle();
        updateUIForMode();
        return;
        setOrientation(0);
          goto _L1
    }

    private boolean isReadyForPull()
    {
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[mMode.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 47
    //                   2 42
    //                   3 40
    //                   4 52;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return false;
_L3:
        return isReadyForPullStart();
_L2:
        return isReadyForPullEnd();
_L4:
        if (isReadyForPullEnd() || isReadyForPullStart())
        {
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void pullEvent()
    {
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 182;
           goto _L1 _L2
_L1:
        float f;
        float f1;
        f1 = mInitialMotionY;
        f = mLastMotionY;
_L15:
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[mCurrentMode.ordinal()];
        JVM INSTR tableswitch 1 1: default 68
    //                   1 195;
           goto _L3 _L4
_L3:
        int i;
        int j;
        j = Math.round(Math.min(f1 - f, 0.0F) / 2.0F);
        i = getHeaderSize();
_L11:
        setHeaderScroll(j);
        if (j == 0 || isRefreshing()) goto _L6; else goto _L5
_L5:
        f = (float)Math.abs(j) / (float)i;
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[mCurrentMode.ordinal()];
        JVM INSTR tableswitch 1 1: default 144
    //                   1 217;
           goto _L7 _L8
_L7:
        mHeaderLayout.onPull(f);
_L12:
        if (mState == State.PULL_TO_REFRESH || i < Math.abs(j)) goto _L10; else goto _L9
_L9:
        setState(State.PULL_TO_REFRESH, new boolean[0]);
_L6:
        return;
_L2:
        f1 = mInitialMotionX;
        f = mLastMotionX;
        continue; /* Loop/switch isn't completed */
_L4:
        j = Math.round(Math.max(f1 - f, 0.0F) / 2.0F);
        i = getFooterSize();
          goto _L11
_L8:
        mFooterLayout.onPull(f);
          goto _L12
_L10:
        if (mState != State.PULL_TO_REFRESH || i >= Math.abs(j)) goto _L6; else goto _L13
_L13:
        setState(State.RELEASE_TO_REFRESH, new boolean[0]);
        return;
        if (true) goto _L15; else goto _L14
_L14:
    }

    private final void smoothScrollTo(int i, long l)
    {
        smoothScrollTo(i, l, 0L, null);
    }

    private final void smoothScrollTo(int i, long l, long l1, OnSmoothScrollFinishedListener onsmoothscrollfinishedlistener)
    {
        if (mCurrentSmoothScrollRunnable != null)
        {
            mCurrentSmoothScrollRunnable.stop();
        }
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 1: default 44
    //                   1 111;
           goto _L1 _L2
_L1:
        int j = getScrollY();
_L4:
        if (j != i)
        {
            if (mScrollAnimationInterpolator == null)
            {
                mScrollAnimationInterpolator = new DecelerateInterpolator();
            }
            mCurrentSmoothScrollRunnable = new SmoothScrollRunnable(j, i, l, onsmoothscrollfinishedlistener);
            if (l1 <= 0L)
            {
                break; /* Loop/switch isn't completed */
            }
            postDelayed(mCurrentSmoothScrollRunnable, l1);
        }
        return;
_L2:
        j = getScrollX();
        if (true) goto _L4; else goto _L3
_L3:
        post(mCurrentSmoothScrollRunnable);
        return;
    }

    private final void smoothScrollToAndBack(int i)
    {
        smoothScrollTo(i, 200L, 0L, new _cls2());
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        (new StringBuilder()).append("addView: ").append(view.getClass().getSimpleName()).toString();
        View view1 = getRefreshableView();
        if (view1 instanceof ViewGroup)
        {
            ((ViewGroup)view1).addView(view, i, layoutparams);
            return;
        } else
        {
            throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
        }
    }

    protected final void addViewInternal(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, i, layoutparams);
    }

    protected final void addViewInternal(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, -1, layoutparams);
    }

    protected LoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray typedarray)
    {
        context = mLoadingAnimationStyle.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedarray);
        context.setVisibility(4);
        return context;
    }

    protected LoadingLayoutProxy createLoadingLayoutProxy(boolean flag, boolean flag1)
    {
        LoadingLayoutProxy loadinglayoutproxy = new LoadingLayoutProxy();
        if (flag && mMode.showHeaderLoadingLayout())
        {
            loadinglayoutproxy.addLayout(mHeaderLayout);
        }
        if (flag1 && mMode.showFooterLoadingLayout())
        {
            loadinglayoutproxy.addLayout(mFooterLayout);
        }
        return loadinglayoutproxy;
    }

    protected abstract View createRefreshableView(Context context, AttributeSet attributeset);

    public final boolean demo()
    {
        if (mMode.showHeaderLoadingLayout() && isReadyForPullStart())
        {
            smoothScrollToAndBack(-getHeaderSize() * 2);
            return true;
        }
        if (mMode.showFooterLoadingLayout() && isReadyForPullEnd())
        {
            smoothScrollToAndBack(getFooterSize() * 2);
            return true;
        } else
        {
            return false;
        }
    }

    protected final void disableLoadingLayoutVisibilityChanges()
    {
        mLayoutVisibilityChangesEnabled = false;
    }

    public final Mode getCurrentMode()
    {
        return mCurrentMode;
    }

    public final boolean getFilterTouchEvents()
    {
        return mFilterTouchEvents;
    }

    protected final LoadingLayout getFooterLayout()
    {
        return mFooterLayout;
    }

    protected final int getFooterSize()
    {
        return mFooterLayout.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout()
    {
        return mHeaderLayout;
    }

    protected final int getHeaderSize()
    {
        return mHeaderLayout.getContentSize();
    }

    public final ILoadingLayout getLoadingLayoutProxy()
    {
        return getLoadingLayoutProxy(true, true);
    }

    public final ILoadingLayout getLoadingLayoutProxy(boolean flag, boolean flag1)
    {
        return createLoadingLayoutProxy(flag, flag1);
    }

    public final Mode getMode()
    {
        return mMode;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration()
    {
        return 200;
    }

    protected int getPullToRefreshScrollDurationLonger()
    {
        return 325;
    }

    public final View getRefreshableView()
    {
        return mRefreshableView;
    }

    protected FrameLayout getRefreshableViewWrapper()
    {
        return mRefreshableViewWrapper;
    }

    public final boolean getShowViewWhileRefreshing()
    {
        return mShowViewWhileRefreshing;
    }

    public final State getState()
    {
        return mState;
    }

    protected void handleStyledAttributes(TypedArray typedarray)
    {
    }

    public final boolean isDisableScrollingWhileRefreshing()
    {
        return !isScrollingWhileRefreshingEnabled();
    }

    public final boolean isPullToRefreshEnabled()
    {
        return mMode.permitsPullToRefresh();
    }

    public final boolean isPullToRefreshOverScrollEnabled()
    {
        return android.os.Build.VERSION.SDK_INT >= 9 && mOverScrollEnabled && OverscrollHelper.isAndroidOverScrollEnabled(mRefreshableView);
    }

    protected abstract boolean isReadyForPullEnd();

    protected abstract boolean isReadyForPullStart();

    public final boolean isRefreshing()
    {
        return mState == State.REFRESHING || mState == State.MANUAL_REFRESHING;
    }

    public final boolean isScrollingWhileRefreshingEnabled()
    {
        return mScrollingWhileRefreshingEnabled;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        if (!isPullToRefreshEnabled())
        {
            return false;
        }
        i = motionevent.getAction();
        if (i == 3 || i == 1)
        {
            mIsBeingDragged = false;
            return false;
        }
        if (i != 0 && mIsBeingDragged)
        {
            return true;
        }
        i;
        JVM INSTR tableswitch 0 2: default 76
    //                   0 335
    //                   1 76
    //                   2 81;
           goto _L1 _L2 _L1 _L3
_L1:
        return mIsBeingDragged;
_L3:
        float f3;
        float f4;
        if (!mScrollingWhileRefreshingEnabled && isRefreshing())
        {
            return true;
        }
        if (!isReadyForPull())
        {
            continue; /* Loop/switch isn't completed */
        }
        f3 = motionevent.getY();
        f4 = motionevent.getX();
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 1: default 144
    //                   1 254;
           goto _L4 _L5
_L4:
        float f;
        float f2;
        f2 = f3 - mLastMotionY;
        f = f4 - mLastMotionX;
_L6:
        float f5 = Math.abs(f2);
        if (f5 > (float)mTouchSlop && (!mFilterTouchEvents || f5 > Math.abs(f)))
        {
            if (mMode.showHeaderLoadingLayout() && f2 >= 1.0F && isReadyForPullStart())
            {
                mLastMotionY = f3;
                mLastMotionX = f4;
                mIsBeingDragged = true;
                if (mMode == Mode.BOTH)
                {
                    mCurrentMode = Mode.PULL_FROM_START;
                }
            } else
            if (mMode.showFooterLoadingLayout() && f2 <= -1F && isReadyForPullEnd())
            {
                mLastMotionY = f3;
                mLastMotionX = f4;
                mIsBeingDragged = true;
                if (mMode == Mode.BOTH)
                {
                    mCurrentMode = Mode.PULL_FROM_END;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        f2 = f4 - mLastMotionX;
        f = f3 - mLastMotionY;
          goto _L6
_L2:
        if (isReadyForPull())
        {
            float f1 = motionevent.getY();
            mInitialMotionY = f1;
            mLastMotionY = f1;
            f1 = motionevent.getX();
            mInitialMotionX = f1;
            mLastMotionX = f1;
            mIsBeingDragged = false;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    protected void onPtrRestoreInstanceState(Bundle bundle)
    {
    }

    protected void onPtrSaveInstanceState(Bundle bundle)
    {
    }

    protected void onPullToRefresh()
    {
        switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[mCurrentMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mFooterLayout.pullToRefresh();
            return;

        case 2: // '\002'
            mHeaderLayout.pullToRefresh();
            break;
        }
    }

    public final void onRefreshComplete()
    {
        if (isRefreshing())
        {
            setState(State.RESET, new boolean[0]);
        }
    }

    protected void onRefreshing(boolean flag)
    {
label0:
        {
label1:
            {
                if (mMode.showHeaderLoadingLayout())
                {
                    mHeaderLayout.refreshing();
                }
                if (mMode.showFooterLoadingLayout())
                {
                    mFooterLayout.refreshing();
                }
                if (flag)
                {
                    if (!mShowViewWhileRefreshing)
                    {
                        break label0;
                    }
                    switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[mCurrentMode.ordinal()])
                    {
                    case 2: // '\002'
                    default:
                        smoothScrollTo(-getHeaderSize());
                        break;

                    case 1: // '\001'
                    case 3: // '\003'
                        break label1;
                    }
                }
                return;
            }
            smoothScrollTo(getFooterSize());
            return;
        }
        smoothScrollTo(0);
    }

    protected void onReleaseToRefresh()
    {
        switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[mCurrentMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mFooterLayout.releaseToRefresh();
            return;

        case 2: // '\002'
            mHeaderLayout.releaseToRefresh();
            break;
        }
    }

    protected void onReset()
    {
        mIsBeingDragged = false;
        mLayoutVisibilityChangesEnabled = true;
        mHeaderLayout.reset();
        mFooterLayout.reset();
        smoothScrollTo(0);
    }

    protected final void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            setMode(Mode.mapIntToValue(parcelable.getInt("ptr_mode", 0)));
            mCurrentMode = Mode.mapIntToValue(parcelable.getInt("ptr_current_mode", 0));
            mScrollingWhileRefreshingEnabled = parcelable.getBoolean("ptr_disable_scrolling", false);
            mShowViewWhileRefreshing = parcelable.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(parcelable.getParcelable("ptr_super"));
            State state = State.mapIntToValue(parcelable.getInt("ptr_state", 0));
            if (state == State.REFRESHING || state == State.MANUAL_REFRESHING)
            {
                setState(state, new boolean[] {
                    true
                });
            }
            onPtrRestoreInstanceState(parcelable);
            return;
        } else
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
    }

    protected final Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt("ptr_state", mState.getIntValue());
        bundle.putInt("ptr_mode", mMode.getIntValue());
        bundle.putInt("ptr_current_mode", mCurrentMode.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", mScrollingWhileRefreshingEnabled);
        bundle.putBoolean("ptr_show_refreshing_view", mShowViewWhileRefreshing);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    protected final void onSizeChanged(int i, int j, int k, int l)
    {
        String.format("onSizeChanged. W: %d, H: %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        super.onSizeChanged(i, j, k, l);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, j);
        post(new _cls1());
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isPullToRefreshEnabled()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!mScrollingWhileRefreshingEnabled && isRefreshing())
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0) goto _L1; else goto _L3
_L3:
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 72
    //                   0 74
    //                   1 142
    //                   2 113
    //                   3 142;
           goto _L4 _L5 _L6 _L7 _L6
_L6:
        continue; /* Loop/switch isn't completed */
_L4:
        return false;
_L5:
        if (!isReadyForPull()) goto _L1; else goto _L8
_L8:
        float f = motionevent.getY();
        mInitialMotionY = f;
        mLastMotionY = f;
        f = motionevent.getX();
        mInitialMotionX = f;
        mLastMotionX = f;
        return true;
_L7:
        if (!mIsBeingDragged) goto _L1; else goto _L9
_L9:
        mLastMotionY = motionevent.getY();
        mLastMotionX = motionevent.getX();
        pullEvent();
        return true;
        if (!mIsBeingDragged) goto _L1; else goto _L10
_L10:
        mIsBeingDragged = false;
        if (mState != State.RELEASE_TO_REFRESH) goto _L12; else goto _L11
_L11:
        if (mOnRefreshListener != null)
        {
            setState(State.REFRESHING, new boolean[] {
                true
            });
            mOnRefreshListener.onRefresh(this);
            return true;
        }
        if (mOnRefreshListener2 == null) goto _L12; else goto _L13
_L13:
        setState(State.REFRESHING, new boolean[] {
            true
        });
        if (mCurrentMode != Mode.PULL_FROM_START) goto _L15; else goto _L14
_L14:
        mOnRefreshListener2.onPullDownToRefresh(this);
_L16:
        return true;
_L15:
        if (mCurrentMode == Mode.PULL_FROM_END)
        {
            mOnRefreshListener2.onPullUpToRefresh(this);
        }
        if (true) goto _L16; else goto _L12
_L12:
        if (isRefreshing())
        {
            smoothScrollTo(0);
            return true;
        } else
        {
            setState(State.RESET, new boolean[0]);
            return true;
        }
    }

    protected final void refreshLoadingViewsSize()
    {
        int j;
        int k;
        int l;
        int i1;
        int l1;
        l1 = (int)((float)getMaximumPullScroll() * 1.2F);
        j = getPaddingLeft();
        i1 = getPaddingTop();
        k = getPaddingRight();
        l = getPaddingBottom();
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 133
    //                   2 218;
           goto _L1 _L2 _L3
_L1:
        int i;
        i = l;
        l1 = k;
        k = i1;
        l = j;
        j = l1;
_L5:
        String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", new Object[] {
            Integer.valueOf(l), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i)
        });
        setPadding(l, k, j, i);
        return;
_L2:
        if (mMode.showHeaderLoadingLayout())
        {
            mHeaderLayout.setWidth(l1);
            i = -l1;
        } else
        {
            i = 0;
        }
        if (mMode.showFooterLoadingLayout())
        {
            mFooterLayout.setWidth(l1);
            j = -l1;
            k = i1;
            i1 = i;
            i = l;
            l = i1;
        } else
        {
            k = i1;
            i1 = i;
            i = l;
            j = 0;
            l = i1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (mMode.showHeaderLoadingLayout())
        {
            mHeaderLayout.setHeight(l1);
            i = -l1;
        } else
        {
            i = 0;
        }
        if (mMode.showFooterLoadingLayout())
        {
            mFooterLayout.setHeight(l1);
            l1 = -l1;
            l = j;
            int j1 = i;
            i = l1;
            j = k;
            k = j1;
        } else
        {
            l = j;
            int k1 = i;
            i = 0;
            j = k;
            k = k1;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final void refreshRefreshableViewSize(int i, int j)
    {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)mRefreshableViewWrapper.getLayoutParams();
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 66;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (layoutparams.width != i)
        {
            layoutparams.width = i;
            mRefreshableViewWrapper.requestLayout();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (layoutparams.height != j)
        {
            layoutparams.height = j;
            mRefreshableViewWrapper.requestLayout();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setDisableScrollingWhileRefreshing(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mScrollingWhileRefreshingEnabled = flag;
    }

    public final void setFilterTouchEvents(boolean flag)
    {
        mFilterTouchEvents = flag;
    }

    protected final void setHeaderScroll(int i)
    {
        (new StringBuilder()).append("setHeaderScroll: ").append(i).toString();
        FrameLayout framelayout;
        byte byte0;
        if (mLayoutVisibilityChangesEnabled)
        {
            if (i < 0)
            {
                mHeaderLayout.setVisibility(0);
            } else
            if (i > 0)
            {
                mFooterLayout.setVisibility(0);
            } else
            {
                mHeaderLayout.setVisibility(4);
                mFooterLayout.setVisibility(4);
            }
        }
        framelayout = mRefreshableViewWrapper;
        if (i != 0)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        ViewCompat.setLayerType(framelayout, byte0);
        switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            scrollTo(0, i);
            return;

        case 1: // '\001'
            scrollTo(i, 0);
            return;
        }
    }

    public void setLastUpdatedLabel(CharSequence charsequence)
    {
        getLoadingLayoutProxy().setLastUpdatedLabel(charsequence);
    }

    public void setLoadingDrawable(Drawable drawable)
    {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    public void setLongClickable(boolean flag)
    {
        getRefreshableView().setLongClickable(flag);
    }

    public final void setMode(Mode mode)
    {
        if (mode != mMode)
        {
            (new StringBuilder()).append("Setting mode to: ").append(mode).toString();
            mMode = mode;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(OnPullEventListener onpulleventlistener)
    {
        mOnPullEventListener = onpulleventlistener;
    }

    public final void setOnRefreshListener(OnRefreshListener2 onrefreshlistener2)
    {
        mOnRefreshListener2 = onrefreshlistener2;
        mOnRefreshListener = null;
    }

    public final void setOnRefreshListener(OnRefreshListener onrefreshlistener)
    {
        mOnRefreshListener = onrefreshlistener;
        mOnRefreshListener2 = null;
    }

    public void setPullLabel(CharSequence charsequence)
    {
        getLoadingLayoutProxy().setPullLabel(charsequence);
    }

    public void setPullLabel(CharSequence charsequence, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charsequence);
    }

    public final void setPullToRefreshEnabled(boolean flag)
    {
        Mode mode;
        if (flag)
        {
            mode = Mode.getDefault();
        } else
        {
            mode = Mode.DISABLED;
        }
        setMode(mode);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean flag)
    {
        mOverScrollEnabled = flag;
    }

    public final void setRefreshing()
    {
        setRefreshing(true);
    }

    public final void setRefreshing(boolean flag)
    {
        if (!isRefreshing())
        {
            setState(State.MANUAL_REFRESHING, new boolean[] {
                flag
            });
        }
    }

    public void setRefreshingLabel(CharSequence charsequence)
    {
        getLoadingLayoutProxy().setRefreshingLabel(charsequence);
    }

    public void setRefreshingLabel(CharSequence charsequence, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charsequence);
    }

    public void setReleaseLabel(CharSequence charsequence)
    {
        setReleaseLabel(charsequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charsequence, Mode mode)
    {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charsequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator)
    {
        mScrollAnimationInterpolator = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean flag)
    {
        mScrollingWhileRefreshingEnabled = flag;
    }

    public final void setShowViewWhileRefreshing(boolean flag)
    {
        mShowViewWhileRefreshing = flag;
    }

    final transient void setState(State state, boolean aflag[])
    {
        mState = state;
        (new StringBuilder()).append("State: ").append(mState.name()).toString();
        _cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.State[mState.ordinal()];
        JVM INSTR tableswitch 1 5: default 76
    //                   1 102
    //                   2 109
    //                   3 116
    //                   4 123
    //                   5 123;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L1:
        if (mOnPullEventListener != null)
        {
            mOnPullEventListener.onPullEvent(this, mState, mCurrentMode);
        }
        return;
_L2:
        onReset();
        continue; /* Loop/switch isn't completed */
_L3:
        onPullToRefresh();
        continue; /* Loop/switch isn't completed */
_L4:
        onReleaseToRefresh();
        continue; /* Loop/switch isn't completed */
_L5:
        onRefreshing(aflag[0]);
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected final void smoothScrollTo(int i)
    {
        smoothScrollTo(i, getPullToRefreshScrollDuration());
    }

    protected final void smoothScrollToLonger(int i)
    {
        smoothScrollTo(i, getPullToRefreshScrollDurationLonger());
    }

    protected void updateUIForMode()
    {
        Object obj = getLoadingLayoutLayoutParams();
        if (this == mHeaderLayout.getParent())
        {
            removeView(mHeaderLayout);
        }
        if (mMode.showHeaderLoadingLayout())
        {
            super.addView(mHeaderLayout, 0, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
        if (this == mFooterLayout.getParent())
        {
            removeView(mFooterLayout);
        }
        if (mMode.showFooterLoadingLayout())
        {
            super.addView(mFooterLayout, -1, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
        refreshLoadingViewsSize();
        if (mMode != Mode.BOTH)
        {
            obj = mMode;
        } else
        {
            obj = Mode.PULL_FROM_START;
        }
        mCurrentMode = ((Mode) (obj));
    }



    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State MANUAL_REFRESHING;
        public static final State OVERSCROLLING;
        public static final State PULL_TO_REFRESH;
        public static final State REFRESHING;
        public static final State RELEASE_TO_REFRESH;
        public static final State RESET;
        private int mIntValue;

        static State mapIntToValue(int i)
        {
            State astate[] = values();
            int k = astate.length;
            for (int j = 0; j < k; j++)
            {
                State state = astate[j];
                if (i == state.getIntValue())
                {
                    return state;
                }
            }

            return RESET;
        }

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        final int getIntValue()
        {
            return mIntValue;
        }

        static 
        {
            RESET = new State("RESET", 0, 0);
            PULL_TO_REFRESH = new State("PULL_TO_REFRESH", 1, 1);
            RELEASE_TO_REFRESH = new State("RELEASE_TO_REFRESH", 2, 2);
            REFRESHING = new State("REFRESHING", 3, 8);
            MANUAL_REFRESHING = new State("MANUAL_REFRESHING", 4, 9);
            OVERSCROLLING = new State("OVERSCROLLING", 5, 16);
            $VALUES = (new State[] {
                RESET, PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING, MANUAL_REFRESHING, OVERSCROLLING
            });
        }

        private State(String s, int i, int j)
        {
            super(s, i);
            mIntValue = j;
        }
    }


    private class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode BOTH;
        public static final Mode DISABLED;
        public static final Mode MANUAL_REFRESH_ONLY;
        public static Mode PULL_DOWN_TO_REFRESH;
        public static final Mode PULL_FROM_END;
        public static final Mode PULL_FROM_START;
        public static Mode PULL_UP_TO_REFRESH;
        private int mIntValue;

        static Mode getDefault()
        {
            return PULL_FROM_START;
        }

        static Mode mapIntToValue(int i)
        {
            Mode amode[] = values();
            int k = amode.length;
            for (int j = 0; j < k; j++)
            {
                Mode mode = amode[j];
                if (i == mode.getIntValue())
                {
                    return mode;
                }
            }

            return getDefault();
        }

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        final int getIntValue()
        {
            return mIntValue;
        }

        final boolean permitsPullToRefresh()
        {
            return this != DISABLED && this != MANUAL_REFRESH_ONLY;
        }

        public final boolean showFooterLoadingLayout()
        {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public final boolean showHeaderLoadingLayout()
        {
            return this == PULL_FROM_START || this == BOTH;
        }

        static 
        {
            DISABLED = new Mode("DISABLED", 0, 0);
            PULL_FROM_START = new Mode("PULL_FROM_START", 1, 1);
            PULL_FROM_END = new Mode("PULL_FROM_END", 2, 2);
            BOTH = new Mode("BOTH", 3, 3);
            MANUAL_REFRESH_ONLY = new Mode("MANUAL_REFRESH_ONLY", 4, 4);
            $VALUES = (new Mode[] {
                DISABLED, PULL_FROM_START, PULL_FROM_END, BOTH, MANUAL_REFRESH_ONLY
            });
            PULL_DOWN_TO_REFRESH = PULL_FROM_START;
            PULL_UP_TO_REFRESH = PULL_FROM_END;
        }

        private Mode(String s, int i, int j)
        {
            super(s, i);
            mIntValue = j;
        }
    }


    private class AnimationStyle extends Enum
    {

        private static final AnimationStyle $VALUES[];
        public static final AnimationStyle FLIP;
        public static final AnimationStyle ROTATE;

        static AnimationStyle getDefault()
        {
            return ROTATE;
        }

        static AnimationStyle mapIntToValue(int i)
        {
            switch (i)
            {
            default:
                return ROTATE;

            case 1: // '\001'
                return FLIP;
            }
        }

        public static AnimationStyle valueOf(String s)
        {
            return (AnimationStyle)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$AnimationStyle, s);
        }

        public static AnimationStyle[] values()
        {
            return (AnimationStyle[])$VALUES.clone();
        }

        final LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedarray)
        {
            switch (_cls3..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle[ordinal()])
            {
            default:
                return new RotateLoadingLayout(context, mode, orientation, typedarray);

            case 2: // '\002'
                return new FlipLoadingLayout(context, mode, orientation, typedarray);
            }
        }

        static 
        {
            ROTATE = new AnimationStyle("ROTATE", 0);
            FLIP = new AnimationStyle("FLIP", 1);
            $VALUES = (new AnimationStyle[] {
                ROTATE, FLIP
            });
        }

        private AnimationStyle(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls3
    {

        static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[];
        static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[];
        static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[];
        static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[];

        static 
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle = new int[AnimationStyle.values().length];
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[AnimationStyle.ROTATE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[AnimationStyle.FLIP.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode = new int[Mode.values().length];
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_END.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_START.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.BOTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State = new int[State.values().length];
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.RESET.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.PULL_TO_REFRESH.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.REFRESHING.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.MANUAL_REFRESHING.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.OVERSCROLLING.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation = new int[Orientation.values().length];
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[Orientation.HORIZONTAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[Orientation.VERTICAL.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class Orientation extends Enum
    {

        private static final Orientation $VALUES[];
        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;

        public static Orientation valueOf(String s)
        {
            return (Orientation)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$Orientation, s);
        }

        public static Orientation[] values()
        {
            return (Orientation[])$VALUES.clone();
        }

        static 
        {
            VERTICAL = new Orientation("VERTICAL", 0);
            HORIZONTAL = new Orientation("HORIZONTAL", 1);
            $VALUES = (new Orientation[] {
                VERTICAL, HORIZONTAL
            });
        }

        private Orientation(String s, int i)
        {
            super(s, i);
        }
    }


    private class SmoothScrollRunnable
        implements Runnable
    {

        private boolean mContinueRunning;
        private int mCurrentY;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private OnSmoothScrollFinishedListener mListener;
        private final int mScrollFromY;
        private final int mScrollToY;
        private long mStartTime;
        final PullToRefreshBase this$0;

        public final void run()
        {
            if (mStartTime == -1L)
            {
                mStartTime = System.currentTimeMillis();
            } else
            {
                long l = Math.max(Math.min(((System.currentTimeMillis() - mStartTime) * 1000L) / mDuration, 1000L), 0L);
                float f = mScrollFromY - mScrollToY;
                int i = Math.round(mInterpolator.getInterpolation((float)l / 1000F) * f);
                mCurrentY = mScrollFromY - i;
                setHeaderScroll(mCurrentY);
            }
            if (mContinueRunning && mScrollToY != mCurrentY)
            {
                ViewCompat.postOnAnimation(PullToRefreshBase.this, this);
            } else
            if (mListener != null)
            {
                mListener.onSmoothScrollFinished();
                return;
            }
        }

        public final void stop()
        {
            mContinueRunning = false;
            removeCallbacks(this);
        }

        public SmoothScrollRunnable(int i, int j, long l, OnSmoothScrollFinishedListener onsmoothscrollfinishedlistener)
        {
            this$0 = PullToRefreshBase.this;
            super();
            mContinueRunning = true;
            mStartTime = -1L;
            mCurrentY = -1;
            mScrollFromY = i;
            mScrollToY = j;
            mInterpolator = mScrollAnimationInterpolator;
            mDuration = l;
            mListener = onsmoothscrollfinishedlistener;
        }

        private class OnSmoothScrollFinishedListener
        {

            public abstract void onSmoothScrollFinished();
        }

    }


    private class _cls2
        implements OnSmoothScrollFinishedListener
    {

        final PullToRefreshBase this$0;

        public void onSmoothScrollFinished()
        {
            smoothScrollTo(0, 200L, 225L, null);
        }

        _cls2()
        {
            this$0 = PullToRefreshBase.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final PullToRefreshBase this$0;

        public void run()
        {
            requestLayout();
        }

        _cls1()
        {
            this$0 = PullToRefreshBase.this;
            super();
        }
    }


    private class OnRefreshListener
    {

        public abstract void onRefresh(PullToRefreshBase pulltorefreshbase);
    }


    private class OnRefreshListener2
    {

        public abstract void onPullDownToRefresh(PullToRefreshBase pulltorefreshbase);

        public abstract void onPullUpToRefresh(PullToRefreshBase pulltorefreshbase);
    }


    private class OnPullEventListener
    {

        public abstract void onPullEvent(PullToRefreshBase pulltorefreshbase, State state, Mode mode);
    }

}
