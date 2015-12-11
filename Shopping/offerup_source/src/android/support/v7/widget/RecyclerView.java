// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.a.a;
import android.support.v4.view.at;
import android.support.v4.view.ay;
import android.support.v4.view.bc;
import android.support.v4.view.be;
import android.support.v4.view.bi;
import android.support.v4.view.bv;
import android.support.v4.widget.ab;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.offerup.android.network.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            DefaultItemAnimator, RecyclerViewAccessibilityDelegate, ChildHelper, AdapterHelper

public class RecyclerView extends ViewGroup
    implements ay, bc
{

    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    private static final Class LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE[];
    private static final Interpolator sQuinticInterpolator = new _cls3();
    private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private OnItemTouchListener mActiveOnItemTouchListener;
    private Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private ab mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    private boolean mEatRequestLayout;
    private int mEatenAccessibilityChangeFlags;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private final ArrayList mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    private LayoutManager mLayout;
    private boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    private boolean mLayoutRequestEaten;
    private ab mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int mMinMaxLayoutPositions[];
    private final int mNestedOffsets[];
    private final RecyclerViewDataObserver mObserver;
    private List mOnChildAttachStateListeners;
    private final ArrayList mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final Recycler mRecycler;
    private RecyclerListener mRecyclerListener;
    private ab mRightGlow;
    private final int mScrollConsumed[];
    private float mScrollFactor;
    private OnScrollListener mScrollListener;
    private List mScrollListeners;
    private final int mScrollOffset[];
    private int mScrollPointerId;
    private int mScrollState;
    private final b mScrollingChildHelper$5df96aa;
    final State mState;
    private final Rect mTempRect;
    private ab mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final ViewFlinger mViewFlinger;

    public RecyclerView(Context context)
    {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mObserver = new RecyclerViewDataObserver(null);
        mRecycler = new Recycler();
        mUpdateChildViewsRunnable = new _cls1();
        mTempRect = new Rect();
        mItemDecorations = new ArrayList();
        mOnItemTouchListeners = new ArrayList();
        mDataSetHasChangedAfterLayout = false;
        mLayoutOrScrollCounter = 0;
        mItemAnimator = new DefaultItemAnimator();
        mScrollState = 0;
        mScrollPointerId = -1;
        mScrollFactor = 1.401298E-45F;
        mViewFlinger = new ViewFlinger();
        mState = new State();
        mItemsAddedOrRemoved = false;
        mItemsChanged = false;
        mItemAnimatorListener = new ItemAnimatorRestoreListener(null);
        mPostedAnimatorRunner = false;
        mMinMaxLayoutPositions = new int[2];
        mScrollOffset = new int[2];
        mScrollConsumed = new int[2];
        mNestedOffsets = new int[2];
        mItemAnimatorRunner = new _cls2();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewconfiguration;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPostUpdatesOnAnimation = flag;
        viewconfiguration = ViewConfiguration.get(context);
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        if (bi.a(this) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        mItemAnimator.setListener(mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (bi.e(this) == 0)
        {
            bi.c(this, 1);
        }
        mAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeset != null)
        {
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.v7.recyclerview.R.styleable.RecyclerView, i, 0);
            String s = typedarray.getString(android.support.v7.recyclerview.R.styleable.RecyclerView_layoutManager);
            typedarray.recycle();
            createLayoutManager(context, s, attributeset, i, 0);
        }
        mScrollingChildHelper$5df96aa = new b(this);
        setNestedScrollingEnabled(true);
    }

    private void addAnimatingView(ViewHolder viewholder)
    {
        View view = viewholder.itemView;
        boolean flag;
        if (view.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRecycler.unscrapView(getChildViewHolder(view));
        if (viewholder.isTmpDetached())
        {
            mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!flag)
        {
            mChildHelper.addView(view, true);
            return;
        } else
        {
            mChildHelper.hide(view);
            return;
        }
    }

    private void animateAppearance(ViewHolder viewholder, Rect rect, int i, int j)
    {
        View view = viewholder.itemView;
        if (rect != null && (rect.left != i || rect.top != j))
        {
            viewholder.setIsRecyclable(false);
            if (mItemAnimator.animateMove(viewholder, rect.left, rect.top, i, j))
            {
                postAnimationRunner();
            }
        } else
        {
            viewholder.setIsRecyclable(false);
            if (mItemAnimator.animateAdd(viewholder))
            {
                postAnimationRunner();
                return;
            }
        }
    }

    private void animateChange(ViewHolder viewholder, ViewHolder viewholder1)
    {
        viewholder.setIsRecyclable(false);
        addAnimatingView(viewholder);
        viewholder.mShadowedHolder = viewholder1;
        mRecycler.unscrapView(viewholder);
        int k = viewholder.itemView.getLeft();
        int l = viewholder.itemView.getTop();
        int i;
        int j;
        if (viewholder1 == null || viewholder1.shouldIgnore())
        {
            j = l;
            i = k;
        } else
        {
            i = viewholder1.itemView.getLeft();
            j = viewholder1.itemView.getTop();
            viewholder1.setIsRecyclable(false);
            viewholder1.mShadowingHolder = viewholder;
        }
        if (mItemAnimator.animateChange(viewholder, viewholder1, k, l, i, j))
        {
            postAnimationRunner();
        }
    }

    private void animateDisappearance(ItemHolderInfo itemholderinfo)
    {
        View view = itemholderinfo.holder.itemView;
        addAnimatingView(itemholderinfo.holder);
        int i = itemholderinfo.left;
        int j = itemholderinfo.top;
        int k = view.getLeft();
        int l = view.getTop();
        if (!itemholderinfo.holder.isRemoved() && (i != k || j != l))
        {
            itemholderinfo.holder.setIsRecyclable(false);
            view.layout(k, l, view.getWidth() + k, view.getHeight() + l);
            if (mItemAnimator.animateMove(itemholderinfo.holder, i, j, k, l))
            {
                postAnimationRunner();
            }
        } else
        {
            itemholderinfo.holder.setIsRecyclable(false);
            if (mItemAnimator.animateRemove(itemholderinfo.holder))
            {
                postAnimationRunner();
                return;
            }
        }
    }

    private void cancelTouch()
    {
        resetTouch();
        setScrollState(0);
    }

    private void considerReleasingGlowsOnScroll(int i, int j)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mLeftGlow != null)
        {
            flag = flag1;
            if (!mLeftGlow.a())
            {
                flag = flag1;
                if (i > 0)
                {
                    flag = mLeftGlow.c();
                }
            }
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag;
            if (!mRightGlow.a())
            {
                flag1 = flag;
                if (i < 0)
                {
                    flag1 = flag | mRightGlow.c();
                }
            }
        }
        flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1;
            if (!mTopGlow.a())
            {
                flag = flag1;
                if (j > 0)
                {
                    flag = flag1 | mTopGlow.c();
                }
            }
        }
        flag1 = flag;
        if (mBottomGlow != null)
        {
            flag1 = flag;
            if (!mBottomGlow.a())
            {
                flag1 = flag;
                if (j < 0)
                {
                    flag1 = flag | mBottomGlow.c();
                }
            }
        }
        if (flag1)
        {
            bi.d(this);
        }
    }

    private void consumePendingUpdateOperations()
    {
        mUpdateChildViewsRunnable.run();
    }

    private void createLayoutManager(Context context, String s, AttributeSet attributeset, int i, int j)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        s = s.trim();
        if (s.length() == 0) goto _L2; else goto _L3
_L3:
        String s1 = getFullClassName(context, s);
        if (!isInEditMode()) goto _L5; else goto _L4
_L4:
        s = getClass().getClassLoader();
_L8:
        Class class1 = s.loadClass(s1).asSubclass(android/support/v7/widget/RecyclerView$LayoutManager);
        Object aobj[];
        s = class1.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
        aobj = new Object[4];
        aobj[0] = context;
        aobj[1] = attributeset;
        aobj[2] = Integer.valueOf(i);
        aobj[3] = Integer.valueOf(j);
        context = ((Context) (aobj));
_L6:
        try
        {
            s.setAccessible(true);
            setLayoutManager((LayoutManager)s.newInstance(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Unable to find LayoutManager ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Cannot access non-public constructor ").append(s1).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Class is not a LayoutManager ").append(s1).toString(), context);
        }
_L5:
        s = context.getClassLoader();
        continue; /* Loop/switch isn't completed */
        context;
        s = class1.getConstructor(new Class[0]);
        context = null;
          goto _L6
        s;
        s.initCause(context);
        throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error creating LayoutManager ").append(s1).toString(), s);
_L2:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void defaultOnMeasure(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getMode(i);
        int k = android.view.View.MeasureSpec.getMode(j);
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        switch (l)
        {
        default:
            i = bi.o(this);
            // fall through

        case -2147483648: 
        case 1073741824: 
            switch (k)
            {
            default:
                j = bi.p(this);
                // fall through

            case -2147483648: 
            case 1073741824: 
                setMeasuredDimension(i, j);
                break;
            }
            break;
        }
    }

    private boolean didChildRangeChange(int i, int j)
    {
        int l;
        boolean flag1;
        flag1 = false;
        l = mChildHelper.getChildCount();
        if (l != 0) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            if (i == 0)
            {
                flag = flag1;
                if (j == 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        int k = 0;
        do
        {
            flag = flag1;
            if (k >= l)
            {
                continue;
            }
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(k));
            if (!viewholder.shouldIgnore())
            {
                int i1 = viewholder.getLayoutPosition();
                if (i1 < i || i1 > j)
                {
                    return true;
                }
            }
            k++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void dispatchChildAttached(View view)
    {
        ViewHolder viewholder = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (mAdapter != null && viewholder != null)
        {
            mAdapter.onViewAttachedToWindow(viewholder);
        }
        if (mOnChildAttachStateListeners != null)
        {
            for (int i = mOnChildAttachStateListeners.size() - 1; i >= 0; i--)
            {
                ((OnChildAttachStateChangeListener)mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(view);
            }

        }
    }

    private void dispatchChildDetached(View view)
    {
        ViewHolder viewholder = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (mAdapter != null && viewholder != null)
        {
            mAdapter.onViewDetachedFromWindow(viewholder);
        }
        if (mOnChildAttachStateListeners != null)
        {
            for (int i = mOnChildAttachStateListeners.size() - 1; i >= 0; i--)
            {
                ((OnChildAttachStateChangeListener)mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(view);
            }

        }
    }

    private void dispatchContentChangedIfNecessary()
    {
        int i = mEatenAccessibilityChangeFlags;
        mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled())
        {
            AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain();
            accessibilityevent.setEventType(2048);
            a.a(accessibilityevent, i);
            sendAccessibilityEventUnchecked(accessibilityevent);
        }
    }

    private boolean dispatchOnItemTouch(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (mActiveOnItemTouchListener == null) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        mActiveOnItemTouchListener = null;
_L2:
        if (i == 0) goto _L6; else goto _L5
_L5:
        int j;
        j = mOnItemTouchListeners.size();
        i = 0;
_L7:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        OnItemTouchListener onitemtouchlistener = (OnItemTouchListener)mOnItemTouchListeners.get(i);
        if (onitemtouchlistener.onInterceptTouchEvent(this, motionevent))
        {
            mActiveOnItemTouchListener = onitemtouchlistener;
            return true;
        }
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        mActiveOnItemTouchListener.onTouchEvent(this, motionevent);
        if (i == 3 || i == 1)
        {
            mActiveOnItemTouchListener = null;
        }
        return true;
        if (true) goto _L7; else goto _L6
_L6:
        return false;
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionevent)
    {
        int j = motionevent.getAction();
        if (j == 3 || j == 0)
        {
            mActiveOnItemTouchListener = null;
        }
        int k = mOnItemTouchListeners.size();
        for (int i = 0; i < k; i++)
        {
            OnItemTouchListener onitemtouchlistener = (OnItemTouchListener)mOnItemTouchListeners.get(i);
            if (onitemtouchlistener.onInterceptTouchEvent(this, motionevent) && j != 3)
            {
                mActiveOnItemTouchListener = onitemtouchlistener;
                return true;
            }
        }

        return false;
    }

    private void findMinMaxChildLayoutPositions(int ai[])
    {
        int i;
        int k;
        int i1;
        int k1;
        k1 = mChildHelper.getChildCount();
        if (k1 == 0)
        {
            ai[0] = 0;
            ai[1] = 0;
            return;
        }
        i = 0x7fffffff;
        k = 0x80000000;
        i1 = 0;
_L2:
        int j;
        int l;
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(i1));
        l = i;
        if (viewholder.shouldIgnore())
        {
            break MISSING_BLOCK_LABEL_123;
        }
        int j1 = viewholder.getLayoutPosition();
        j = i;
        if (j1 < i)
        {
            j = j1;
        }
        l = j;
        if (j1 <= k)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        i = j1;
_L3:
        i1++;
        k = i;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        ai[0] = i;
        ai[1] = k;
        return;
        i = k;
        j = l;
          goto _L3
    }

    static ViewHolder getChildViewHolderInt(View view)
    {
        if (view == null)
        {
            return null;
        } else
        {
            return ((LayoutParams)view.getLayoutParams()).mViewHolder;
        }
    }

    private String getFullClassName(Context context, String s)
    {
        if (s.charAt(0) == '.')
        {
            context = (new StringBuilder()).append(context.getPackageName()).append(s).toString();
        } else
        {
            context = s;
            if (!s.contains("."))
            {
                return (new StringBuilder()).append(android/support/v7/widget/RecyclerView.getPackage().getName()).append('.').append(s).toString();
            }
        }
        return context;
    }

    private float getScrollFactor()
    {
label0:
        {
            if (mScrollFactor == 1.401298E-45F)
            {
                TypedValue typedvalue = new TypedValue();
                if (!getContext().getTheme().resolveAttribute(0x101004d, typedvalue, true))
                {
                    break label0;
                }
                mScrollFactor = typedvalue.getDimension(getContext().getResources().getDisplayMetrics());
            }
            return mScrollFactor;
        }
        return 0.0F;
    }

    private void initChildrenHelper()
    {
        mChildHelper = new ChildHelper(new _cls4());
    }

    private void jumpToPositionForSmoothScroller(int i)
    {
        if (mLayout == null)
        {
            return;
        } else
        {
            mLayout.scrollToPosition(i);
            awakenScrollBars();
            return;
        }
    }

    private void onEnterLayoutOrScroll()
    {
        mLayoutOrScrollCounter = mLayoutOrScrollCounter + 1;
    }

    private void onExitLayoutOrScroll()
    {
        mLayoutOrScrollCounter = mLayoutOrScrollCounter - 1;
        if (mLayoutOrScrollCounter <= 0)
        {
            mLayoutOrScrollCounter = 0;
            dispatchContentChangedIfNecessary();
        }
    }

    private void onPointerUp(MotionEvent motionevent)
    {
        int i = at.b(motionevent);
        if (at.b(motionevent, i) == mScrollPointerId)
        {
            int j;
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            mScrollPointerId = at.b(motionevent, i);
            j = (int)(at.c(motionevent, i) + 0.5F);
            mLastTouchX = j;
            mInitialTouchX = j;
            i = (int)(at.d(motionevent, i) + 0.5F);
            mLastTouchY = i;
            mInitialTouchY = i;
        }
    }

    private void postAnimationRunner()
    {
        if (!mPostedAnimatorRunner && mIsAttached)
        {
            bi.a(this, mItemAnimatorRunner);
            mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled()
    {
        return mItemAnimator != null && mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags()
    {
        boolean flag2 = true;
        if (mDataSetHasChangedAfterLayout)
        {
            mAdapterHelper.reset();
            markKnownViewsInvalid();
            mLayout.onItemsChanged(this);
        }
        State state;
        boolean flag;
        boolean flag1;
        if (mItemAnimator != null && mLayout.supportsPredictiveItemAnimations())
        {
            mAdapterHelper.preProcess();
        } else
        {
            mAdapterHelper.consumeUpdatesInOnePass();
        }
        if (mItemsAddedOrRemoved && !mItemsChanged || mItemsAddedOrRemoved || mItemsChanged && supportsChangeAnimations())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        state = mState;
        if (mFirstLayoutComplete && mItemAnimator != null && (mDataSetHasChangedAfterLayout || flag || mLayout.mRequestedSimpleAnimations) && (!mDataSetHasChangedAfterLayout || mAdapter.hasStableIds()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        state.mRunSimpleAnimations = flag1;
        state = mState;
        if (mState.mRunSimpleAnimations && flag && !mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled())
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        state.mRunPredictiveAnimations = flag1;
    }

    private void processDisappearingList(android.support.v4.g.a a1)
    {
        List list = mState.mDisappearingViewsInLayoutPass;
        int i = list.size() - 1;
        while (i >= 0) 
        {
            View view = (View)list.get(i);
            ViewHolder viewholder = getChildViewHolderInt(view);
            ItemHolderInfo itemholderinfo = (ItemHolderInfo)mState.mPreLayoutHolderMap.remove(viewholder);
            if (!mState.isPreLayout())
            {
                mState.mPostLayoutHolderMap.remove(viewholder);
            }
            if (a1.remove(view) != null)
            {
                mLayout.removeAndRecycleView(view, mRecycler);
            } else
            if (itemholderinfo != null)
            {
                animateDisappearance(itemholderinfo);
            } else
            {
                animateDisappearance(new ItemHolderInfo(viewholder, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
            i--;
        }
        list.clear();
    }

    private void pullGlows(float f, float f1, float f2, float f3)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        boolean flag2 = false;
        if (f1 < 0.0F)
        {
            ensureLeftGlow();
            flag = flag2;
            if (mLeftGlow.a(-f1 / (float)getWidth(), 1.0F - f2 / (float)getHeight()))
            {
                flag = true;
            }
        } else
        {
            flag = flag2;
            if (f1 > 0.0F)
            {
                ensureRightGlow();
                flag = flag2;
                if (mRightGlow.a(f1 / (float)getWidth(), f2 / (float)getHeight()))
                {
                    flag = true;
                }
            }
        }
        if (f3 >= 0.0F) goto _L2; else goto _L1
_L1:
        ensureTopGlow();
        if (!mTopGlow.a(-f3 / (float)getHeight(), f / (float)getWidth())) goto _L4; else goto _L3
_L3:
        if (flag1 || f1 != 0.0F || f3 != 0.0F)
        {
            bi.d(this);
        }
        return;
_L2:
        if (f3 > 0.0F)
        {
            ensureBottomGlow();
            if (mBottomGlow.a(f3 / (float)getHeight(), 1.0F - f / (float)getWidth()))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
_L4:
        flag1 = flag;
        if (true) goto _L3; else goto _L5
_L5:
    }

    private void releaseGlows()
    {
        boolean flag1 = false;
        if (mLeftGlow != null)
        {
            flag1 = mLeftGlow.c();
        }
        boolean flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1 | mTopGlow.c();
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag | mRightGlow.c();
        }
        flag = flag1;
        if (mBottomGlow != null)
        {
            flag = flag1 | mBottomGlow.c();
        }
        if (flag)
        {
            bi.d(this);
        }
    }

    private boolean removeAnimatingView(View view)
    {
        eatRequestLayout();
        boolean flag = mChildHelper.removeViewIfHidden(view);
        if (flag)
        {
            view = getChildViewHolderInt(view);
            mRecycler.unscrapView(view);
            mRecycler.recycleViewHolderInternal(view);
        }
        resumeRequestLayout(false);
        return flag;
    }

    private void resetTouch()
    {
        if (mVelocityTracker != null)
        {
            mVelocityTracker.clear();
        }
        stopNestedScroll();
        releaseGlows();
    }

    private void setAdapterInternal(Adapter adapter, boolean flag, boolean flag1)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterAdapterDataObserver(mObserver);
            mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!flag || flag1)
        {
            if (mItemAnimator != null)
            {
                mItemAnimator.endAnimations();
            }
            if (mLayout != null)
            {
                mLayout.removeAndRecycleAllViews(mRecycler);
                mLayout.removeAndRecycleScrapInt(mRecycler);
            }
            mRecycler.clear();
        }
        mAdapterHelper.reset();
        Adapter adapter1 = mAdapter;
        mAdapter = adapter;
        if (adapter != null)
        {
            adapter.registerAdapterDataObserver(mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        if (mLayout != null)
        {
            mLayout.onAdapterChanged(adapter1, mAdapter);
        }
        mRecycler.onAdapterChanged(adapter1, mAdapter, flag);
        mState.mStructureChanged = true;
        markKnownViewsInvalid();
    }

    private void setDataSetChangedAfterLayout()
    {
        if (mDataSetHasChangedAfterLayout)
        {
            return;
        }
        mDataSetHasChangedAfterLayout = true;
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                viewholder.addFlags(512);
            }
        }

        mRecycler.setAdapterPositionsAsUnknown();
    }

    private void setScrollState(int i)
    {
        if (i == mScrollState)
        {
            return;
        }
        mScrollState = i;
        if (i != 2)
        {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i);
    }

    private void stopScrollersInternal()
    {
        mViewFlinger.stop();
        if (mLayout != null)
        {
            mLayout.stopSmoothScroller();
        }
    }

    private boolean supportsChangeAnimations()
    {
        return mItemAnimator != null && mItemAnimator.getSupportsChangeAnimations();
    }

    void absorbGlows(int i, int j)
    {
        if (i < 0)
        {
            ensureLeftGlow();
            mLeftGlow.a(-i);
        } else
        if (i > 0)
        {
            ensureRightGlow();
            mRightGlow.a(i);
        }
        if (j < 0)
        {
            ensureTopGlow();
            mTopGlow.a(-j);
        } else
        if (j > 0)
        {
            ensureBottomGlow();
            mBottomGlow.a(j);
        }
        if (i != 0 || j != 0)
        {
            bi.d(this);
        }
    }

    public void addFocusables(ArrayList arraylist, int i, int j)
    {
        if (mLayout == null || !mLayout.onAddFocusables(this, arraylist, i, j))
        {
            super.addFocusables(arraylist, i, j);
        }
    }

    void assertNotInLayoutOrScroll(String s)
    {
        if (isComputingLayout())
        {
            if (s == null)
            {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && mLayout.checkLayoutParams((LayoutParams)layoutparams);
    }

    void clearOldPositions()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (!viewholder.shouldIgnore())
            {
                viewholder.clearOldPosition();
            }
        }

        mRecycler.clearOldPositions();
    }

    public int computeHorizontalScrollExtent()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollExtent(mState);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollOffset()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollOffset(mState);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollRange()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollRange(mState);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollExtent()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollExtent(mState);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollOffset()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollOffset(mState);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollRange()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollRange(mState);
        } else
        {
            return 0;
        }
    }

    void dispatchLayout()
    {
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "No adapter attached; skipping layout");
_L13:
        return;
_L2:
        if (mLayout == null)
        {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        mState.mDisappearingViewsInLayoutPass.clear();
        eatRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        State state1 = mState;
        Object obj;
        if (mState.mRunSimpleAnimations && mItemsChanged && supportsChangeAnimations())
        {
            obj = new android.support.v4.g.a();
        } else
        {
            obj = null;
        }
        state1.mOldChangedHolders = ((android.support.v4.g.a) (obj));
        mItemsChanged = false;
        mItemsAddedOrRemoved = false;
        mState.mInPreLayout = mState.mRunPredictiveAnimations;
        mState.mItemCount = mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
        if (mState.mRunSimpleAnimations)
        {
            mState.mPreLayoutHolderMap.clear();
            mState.mPostLayoutHolderMap.clear();
            int i1 = mChildHelper.getChildCount();
            for (int i = 0; i < i1; i++)
            {
                obj = getChildViewHolderInt(mChildHelper.getChildAt(i));
                if (!((ViewHolder) (obj)).shouldIgnore() && (!((ViewHolder) (obj)).isInvalid() || mAdapter.hasStableIds()))
                {
                    View view1 = ((ViewHolder) (obj)).itemView;
                    mState.mPreLayoutHolderMap.put(obj, new ItemHolderInfo(((ViewHolder) (obj)), view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom()));
                }
            }

        }
        if (!mState.mRunPredictiveAnimations) goto _L4; else goto _L3
_L3:
        Object obj2;
        int k;
        saveOldPositions();
        if (mState.mOldChangedHolders != null)
        {
            int j1 = mChildHelper.getChildCount();
            for (int j = 0; j < j1; j++)
            {
                ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(j));
                if (viewholder.isChanged() && !viewholder.isRemoved() && !viewholder.shouldIgnore())
                {
                    long l1 = getChangedHolderKey(viewholder);
                    mState.mOldChangedHolders.put(Long.valueOf(l1), viewholder);
                    mState.mPreLayoutHolderMap.remove(viewholder);
                }
            }

        }
        boolean flag = mState.mStructureChanged;
        mState.mStructureChanged = false;
        mLayout.onLayoutChildren(mRecycler, mState);
        mState.mStructureChanged = flag;
        obj2 = new android.support.v4.g.a();
        k = 0;
_L11:
        if (k >= mChildHelper.getChildCount()) goto _L6; else goto _L5
_L5:
        View view = mChildHelper.getChildAt(k);
        if (getChildViewHolderInt(view).shouldIgnore()) goto _L8; else goto _L7
_L7:
        int k1 = 0;
_L12:
        if (k1 >= mState.mPreLayoutHolderMap.size())
        {
            break MISSING_BLOCK_LABEL_1676;
        }
        if (((ViewHolder)mState.mPreLayoutHolderMap.b(k1)).itemView != view) goto _L10; else goto _L9
_L9:
        k1 = 1;
_L15:
        if (k1 == 0)
        {
            ((android.support.v4.g.a) (obj2)).put(view, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        }
_L8:
        k++;
          goto _L11
_L10:
        k1++;
          goto _L12
_L6:
        clearOldPositions();
        mAdapterHelper.consumePostponedUpdates();
_L14:
        mState.mItemCount = mAdapter.getItemCount();
        mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        mState.mInPreLayout = false;
        mLayout.onLayoutChildren(mRecycler, mState);
        mState.mStructureChanged = false;
        mPendingSavedState = null;
        State state = mState;
        boolean flag1;
        if (mState.mRunSimpleAnimations && mItemAnimator != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        state.mRunSimpleAnimations = flag1;
        if (mState.mRunSimpleAnimations)
        {
            Object obj1;
            int l;
            if (mState.mOldChangedHolders != null)
            {
                obj1 = new android.support.v4.g.a();
            } else
            {
                obj1 = null;
            }
            k1 = mChildHelper.getChildCount();
            l = 0;
            while (l < k1) 
            {
                ViewHolder viewholder1 = getChildViewHolderInt(mChildHelper.getChildAt(l));
                if (!viewholder1.shouldIgnore())
                {
                    View view3 = viewholder1.itemView;
                    long l2 = getChangedHolderKey(viewholder1);
                    if (obj1 != null && mState.mOldChangedHolders.get(Long.valueOf(l2)) != null)
                    {
                        ((android.support.v4.g.a) (obj1)).put(Long.valueOf(l2), viewholder1);
                    } else
                    {
                        mState.mPostLayoutHolderMap.put(viewholder1, new ItemHolderInfo(viewholder1, view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom()));
                    }
                }
                l++;
            }
            processDisappearingList(((android.support.v4.g.a) (obj2)));
            for (l = mState.mPreLayoutHolderMap.size() - 1; l >= 0; l--)
            {
                ViewHolder viewholder2 = (ViewHolder)mState.mPreLayoutHolderMap.b(l);
                if (!mState.mPostLayoutHolderMap.containsKey(viewholder2))
                {
                    ItemHolderInfo itemholderinfo = (ItemHolderInfo)mState.mPreLayoutHolderMap.c(l);
                    mState.mPreLayoutHolderMap.d(l);
                    View view4 = itemholderinfo.holder.itemView;
                    mRecycler.unscrapView(itemholderinfo.holder);
                    animateDisappearance(itemholderinfo);
                }
            }

            l = mState.mPostLayoutHolderMap.size();
            if (l > 0)
            {
                l--;
                while (l >= 0) 
                {
                    ViewHolder viewholder3 = (ViewHolder)mState.mPostLayoutHolderMap.b(l);
                    ItemHolderInfo itemholderinfo3 = (ItemHolderInfo)mState.mPostLayoutHolderMap.c(l);
                    if (mState.mPreLayoutHolderMap.isEmpty() || !mState.mPreLayoutHolderMap.containsKey(viewholder3))
                    {
                        mState.mPostLayoutHolderMap.d(l);
                        Rect rect;
                        if (obj2 != null)
                        {
                            rect = (Rect)((android.support.v4.g.a) (obj2)).get(viewholder3.itemView);
                        } else
                        {
                            rect = null;
                        }
                        animateAppearance(viewholder3, rect, itemholderinfo3.left, itemholderinfo3.top);
                    }
                    l--;
                }
            }
            k1 = mState.mPostLayoutHolderMap.size();
            for (l = 0; l < k1; l++)
            {
                obj2 = (ViewHolder)mState.mPostLayoutHolderMap.b(l);
                ItemHolderInfo itemholderinfo1 = (ItemHolderInfo)mState.mPostLayoutHolderMap.c(l);
                ItemHolderInfo itemholderinfo2 = (ItemHolderInfo)mState.mPreLayoutHolderMap.get(obj2);
                if (itemholderinfo2 == null || itemholderinfo1 == null || itemholderinfo2.left == itemholderinfo1.left && itemholderinfo2.top == itemholderinfo1.top)
                {
                    continue;
                }
                ((ViewHolder) (obj2)).setIsRecyclable(false);
                if (mItemAnimator.animateMove(((ViewHolder) (obj2)), itemholderinfo2.left, itemholderinfo2.top, itemholderinfo1.left, itemholderinfo1.top))
                {
                    postAnimationRunner();
                }
            }

            if (mState.mOldChangedHolders != null)
            {
                l = mState.mOldChangedHolders.size();
            } else
            {
                l = 0;
            }
            for (l--; l >= 0; l--)
            {
                long l3 = ((Long)mState.mOldChangedHolders.b(l)).longValue();
                obj2 = (ViewHolder)mState.mOldChangedHolders.get(Long.valueOf(l3));
                View view2 = ((ViewHolder) (obj2)).itemView;
                if (!((ViewHolder) (obj2)).shouldIgnore() && mRecycler.mChangedScrap != null && mRecycler.mChangedScrap.contains(obj2))
                {
                    animateChange(((ViewHolder) (obj2)), (ViewHolder)((android.support.v4.g.a) (obj1)).get(Long.valueOf(l3)));
                }
            }

        }
        resumeRequestLayout(false);
        mLayout.removeAndRecycleScrapInt(mRecycler);
        mState.mPreviousLayoutItemCount = mState.mItemCount;
        mDataSetHasChangedAfterLayout = false;
        mState.mRunSimpleAnimations = false;
        mState.mRunPredictiveAnimations = false;
        onExitLayoutOrScroll();
        mLayout.mRequestedSimpleAnimations = false;
        if (mRecycler.mChangedScrap != null)
        {
            mRecycler.mChangedScrap.clear();
        }
        mState.mOldChangedHolders = null;
        if (didChildRangeChange(mMinMaxLayoutPositions[0], mMinMaxLayoutPositions[1]))
        {
            dispatchOnScrolled(0, 0);
            return;
        }
          goto _L13
_L4:
        clearOldPositions();
        mAdapterHelper.consumeUpdatesInOnePass();
        if (mState.mOldChangedHolders != null)
        {
            k1 = mChildHelper.getChildCount();
            for (l = 0; l < k1; l++)
            {
                obj1 = getChildViewHolderInt(mChildHelper.getChildAt(l));
                if (((ViewHolder) (obj1)).isChanged() && !((ViewHolder) (obj1)).isRemoved() && !((ViewHolder) (obj1)).shouldIgnore())
                {
                    l2 = getChangedHolderKey(((ViewHolder) (obj1)));
                    mState.mOldChangedHolders.put(Long.valueOf(l2), obj1);
                    mState.mPreLayoutHolderMap.remove(obj1);
                }
            }

        }
        obj2 = null;
          goto _L14
        k1 = 0;
          goto _L15
    }

    public boolean dispatchNestedFling(float f, float f1, boolean flag)
    {
        return mScrollingChildHelper$5df96aa.a(f, f1, flag);
    }

    public boolean dispatchNestedPreFling(float f, float f1)
    {
        return mScrollingChildHelper$5df96aa.a(f, f1);
    }

    public boolean dispatchNestedPreScroll(int i, int j, int ai[], int ai1[])
    {
        return mScrollingChildHelper$5df96aa.a(i, j, ai, ai1);
    }

    public boolean dispatchNestedScroll(int i, int j, int k, int l, int ai[])
    {
        return mScrollingChildHelper$5df96aa.a(i, j, k, l, ai);
    }

    void dispatchOnScrollStateChanged(int i)
    {
        if (mLayout != null)
        {
            mLayout.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        if (mScrollListener != null)
        {
            mScrollListener.onScrollStateChanged(this, i);
        }
        if (mScrollListeners != null)
        {
            for (int j = mScrollListeners.size() - 1; j >= 0; j--)
            {
                ((OnScrollListener)mScrollListeners.get(j)).onScrollStateChanged(this, i);
            }

        }
    }

    void dispatchOnScrolled(int i, int j)
    {
        int k = getScrollX();
        int i1 = getScrollY();
        onScrollChanged(k, i1, k, i1);
        onScrolled(i, j);
        if (mScrollListener != null)
        {
            mScrollListener.onScrolled(this, i, j);
        }
        if (mScrollListeners != null)
        {
            for (int l = mScrollListeners.size() - 1; l >= 0; l--)
            {
                ((OnScrollListener)mScrollListeners.get(l)).onScrolled(this, i, j);
            }

        }
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        dispatchFreezeSelfOnly(sparsearray);
    }

    public void draw(Canvas canvas)
    {
        boolean flag = true;
        boolean flag1 = false;
        super.draw(canvas);
        int k = mItemDecorations.size();
        for (int i = 0; i < k; i++)
        {
            ((ItemDecoration)mItemDecorations.get(i)).onDrawOver(canvas, this, mState);
        }

        int j;
        if (mLeftGlow != null && !mLeftGlow.a())
        {
            int l = canvas.save();
            int i1;
            if (mClipToPadding)
            {
                j = getPaddingBottom();
            } else
            {
                j = 0;
            }
            canvas.rotate(270F);
            canvas.translate(j + -getHeight(), 0.0F);
            if (mLeftGlow != null && mLeftGlow.a(canvas))
            {
                k = 1;
            } else
            {
                k = 0;
            }
            canvas.restoreToCount(l);
        } else
        {
            k = 0;
        }
        j = k;
        if (mTopGlow != null)
        {
            j = k;
            if (!mTopGlow.a())
            {
                l = canvas.save();
                if (mClipToPadding)
                {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                if (mTopGlow != null && mTopGlow.a(canvas))
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                j = k | j;
                canvas.restoreToCount(l);
            }
        }
        k = j;
        if (mRightGlow != null)
        {
            k = j;
            if (!mRightGlow.a())
            {
                l = canvas.save();
                i1 = getWidth();
                if (mClipToPadding)
                {
                    k = getPaddingTop();
                } else
                {
                    k = 0;
                }
                canvas.rotate(90F);
                canvas.translate(-k, -i1);
                if (mRightGlow != null && mRightGlow.a(canvas))
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                k = j | k;
                canvas.restoreToCount(l);
            }
        }
        j = k;
        if (mBottomGlow != null)
        {
            j = k;
            if (!mBottomGlow.a())
            {
                l = canvas.save();
                canvas.rotate(180F);
                if (mClipToPadding)
                {
                    canvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
                } else
                {
                    canvas.translate(-getWidth(), -getHeight());
                }
                j = ((flag1) ? 1 : 0);
                if (mBottomGlow != null)
                {
                    j = ((flag1) ? 1 : 0);
                    if (mBottomGlow.a(canvas))
                    {
                        j = 1;
                    }
                }
                j = k | j;
                canvas.restoreToCount(l);
            }
        }
        if (j == 0 && mItemAnimator != null && mItemDecorations.size() > 0 && mItemAnimator.isRunning())
        {
            j = ((flag) ? 1 : 0);
        }
        if (j != 0)
        {
            bi.d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l)
    {
        return super.drawChild(canvas, view, l);
    }

    void eatRequestLayout()
    {
        if (!mEatRequestLayout)
        {
            mEatRequestLayout = true;
            if (!mLayoutFrozen)
            {
                mLayoutRequestEaten = false;
            }
        }
    }

    void ensureBottomGlow()
    {
        if (mBottomGlow != null)
        {
            return;
        }
        mBottomGlow = new ab(getContext());
        if (mClipToPadding)
        {
            mBottomGlow.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mBottomGlow.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    void ensureLeftGlow()
    {
        if (mLeftGlow != null)
        {
            return;
        }
        mLeftGlow = new ab(getContext());
        if (mClipToPadding)
        {
            mLeftGlow.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mLeftGlow.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void ensureRightGlow()
    {
        if (mRightGlow != null)
        {
            return;
        }
        mRightGlow = new ab(getContext());
        if (mClipToPadding)
        {
            mRightGlow.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mRightGlow.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void ensureTopGlow()
    {
        if (mTopGlow != null)
        {
            return;
        }
        mTopGlow = new ab(getContext());
        if (mClipToPadding)
        {
            mTopGlow.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mTopGlow.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    ViewHolder findViewHolderForPosition(int i, boolean flag)
    {
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
            if (viewholder != null && !viewholder.isRemoved() && (flag ? viewholder.mPosition == i : viewholder.getLayoutPosition() == i))
            {
                return viewholder;
            }
        }

        return null;
    }

    public boolean fling(int i, int j)
    {
        if (mLayout != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
_L4:
        return false;
_L2:
        int k;
        boolean flag;
        boolean flag1;
label0:
        {
            if (mLayoutFrozen)
            {
                continue; /* Loop/switch isn't completed */
            }
            flag = mLayout.canScrollHorizontally();
            flag1 = mLayout.canScrollVertically();
            if (flag)
            {
                k = i;
                if (Math.abs(i) >= mMinFlingVelocity)
                {
                    break label0;
                }
            }
            k = 0;
        }
        if (flag1)
        {
            i = j;
            if (Math.abs(j) >= mMinFlingVelocity)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        i = 0;
        if (k == 0 && i == 0 || dispatchNestedPreFling(k, i)) goto _L4; else goto _L3
_L3:
        if (flag || flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dispatchNestedFling(k, i, flag);
        if (flag)
        {
            j = Math.max(-mMaxFlingVelocity, Math.min(k, mMaxFlingVelocity));
            i = Math.max(-mMaxFlingVelocity, Math.min(i, mMaxFlingVelocity));
            mViewFlinger.fling(j, i);
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public View focusSearch(View view, int i)
    {
        View view2 = mLayout.onInterceptFocusSearch(view, i);
        if (view2 == null)
        {
            view2 = FocusFinder.getInstance().findNextFocus(this, view, i);
            View view1 = view2;
            if (view2 == null)
            {
                view1 = view2;
                if (mAdapter != null)
                {
                    view1 = view2;
                    if (mLayout != null)
                    {
                        view1 = view2;
                        if (!isComputingLayout())
                        {
                            view1 = view2;
                            if (!mLayoutFrozen)
                            {
                                eatRequestLayout();
                                view1 = mLayout.onFocusSearchFailed(view, i, mRecycler, mState);
                                resumeRequestLayout(false);
                            }
                        }
                    }
                }
            }
            view2 = view1;
            if (view1 == null)
            {
                return super.focusSearch(view, i);
            }
        }
        return view2;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateDefaultLayoutParams();
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateLayoutParams(getContext(), attributeset);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateLayoutParams(layoutparams);
        }
    }

    public Adapter getAdapter()
    {
        return mAdapter;
    }

    public int getBaseline()
    {
        if (mLayout != null)
        {
            return mLayout.getBaseline();
        } else
        {
            return super.getBaseline();
        }
    }

    long getChangedHolderKey(ViewHolder viewholder)
    {
        if (mAdapter.hasStableIds())
        {
            return viewholder.getItemId();
        } else
        {
            return (long)viewholder.mPosition;
        }
    }

    protected int getChildDrawingOrder(int i, int j)
    {
        if (mChildDrawingOrderCallback == null)
        {
            return super.getChildDrawingOrder(i, j);
        } else
        {
            return mChildDrawingOrderCallback.onGetChildDrawingOrder(i, j);
        }
    }

    public int getChildLayoutPosition(View view)
    {
        view = getChildViewHolderInt(view);
        if (view != null)
        {
            return view.getLayoutPosition();
        } else
        {
            return -1;
        }
    }

    public ViewHolder getChildViewHolder(View view)
    {
        ViewParent viewparent = view.getParent();
        if (viewparent != null && viewparent != this)
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a direct child of ").append(this).toString());
        } else
        {
            return getChildViewHolderInt(view);
        }
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
    {
        return mAccessibilityDelegate;
    }

    public ItemAnimator getItemAnimator()
    {
        return mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.mInsetsDirty)
        {
            return layoutparams.mDecorInsets;
        }
        Rect rect = layoutparams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int j = mItemDecorations.size();
        for (int i = 0; i < j; i++)
        {
            mTempRect.set(0, 0, 0, 0);
            ((ItemDecoration)mItemDecorations.get(i)).getItemOffsets(mTempRect, view, this, mState);
            rect.left = rect.left + mTempRect.left;
            rect.top = rect.top + mTempRect.top;
            rect.right = rect.right + mTempRect.right;
            rect.bottom = rect.bottom + mTempRect.bottom;
        }

        layoutparams.mInsetsDirty = false;
        return rect;
    }

    public LayoutManager getLayoutManager()
    {
        return mLayout;
    }

    public int getMaxFlingVelocity()
    {
        return mMaxFlingVelocity;
    }

    public int getMinFlingVelocity()
    {
        return mMinFlingVelocity;
    }

    public RecycledViewPool getRecycledViewPool()
    {
        return mRecycler.getRecycledViewPool();
    }

    public int getScrollState()
    {
        return mScrollState;
    }

    public boolean hasNestedScrollingParent()
    {
        return mScrollingChildHelper$5df96aa.c();
    }

    public boolean hasPendingAdapterUpdates()
    {
        return !mFirstLayoutComplete || mDataSetHasChangedAfterLayout || mAdapterHelper.hasPendingUpdates();
    }

    void initAdapterManager()
    {
        mAdapterHelper = new AdapterHelper(new _cls5());
    }

    void invalidateGlows()
    {
        mBottomGlow = null;
        mTopGlow = null;
        mRightGlow = null;
        mLeftGlow = null;
    }

    boolean isAccessibilityEnabled()
    {
        return mAccessibilityManager != null && mAccessibilityManager.isEnabled();
    }

    public boolean isAttachedToWindow()
    {
        return mIsAttached;
    }

    public boolean isComputingLayout()
    {
        return mLayoutOrScrollCounter > 0;
    }

    public boolean isNestedScrollingEnabled()
    {
        return mScrollingChildHelper$5df96aa.b();
    }

    void markItemDecorInsetsDirty()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ((LayoutParams)mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }

        mRecycler.markItemDecorInsetsDirty();
    }

    void markKnownViewsInvalid()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                viewholder.addFlags(6);
            }
        }

        markItemDecorInsetsDirty();
        mRecycler.markKnownViewsInvalid();
    }

    public void offsetChildrenHorizontal(int i)
    {
        int k = mChildHelper.getChildCount();
        for (int j = 0; j < k; j++)
        {
            mChildHelper.getChildAt(j).offsetLeftAndRight(i);
        }

    }

    public void offsetChildrenVertical(int i)
    {
        int k = mChildHelper.getChildCount();
        for (int j = 0; j < k; j++)
        {
            mChildHelper.getChildAt(j).offsetTopAndBottom(i);
        }

    }

    void offsetPositionRecordsForInsert(int i, int j)
    {
        int l = mChildHelper.getUnfilteredChildCount();
        for (int k = 0; k < l; k++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(k));
            if (viewholder != null && !viewholder.shouldIgnore() && viewholder.mPosition >= i)
            {
                viewholder.offsetPosition(j, false);
                mState.mStructureChanged = true;
            }
        }

        mRecycler.offsetPositionRecordsForInsert(i, j);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i, int j)
    {
        int j1 = mChildHelper.getUnfilteredChildCount();
        byte byte0;
        int k;
        int l;
        int i1;
        if (i < j)
        {
            byte0 = -1;
            k = j;
            l = i;
        } else
        {
            byte0 = 1;
            k = i;
            l = j;
        }
        i1 = 0;
        while (i1 < j1) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i1));
            if (viewholder != null && viewholder.mPosition >= l && viewholder.mPosition <= k)
            {
                if (viewholder.mPosition == i)
                {
                    viewholder.offsetPosition(j - i, false);
                } else
                {
                    viewholder.offsetPosition(byte0, false);
                }
                mState.mStructureChanged = true;
            }
            i1++;
        }
        mRecycler.offsetPositionRecordsForMove(i, j);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int j, boolean flag)
    {
        int l = mChildHelper.getUnfilteredChildCount();
        int k = 0;
        while (k < l) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(k));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                if (viewholder.mPosition >= i + j)
                {
                    viewholder.offsetPosition(-j, flag);
                    mState.mStructureChanged = true;
                } else
                if (viewholder.mPosition >= i)
                {
                    viewholder.flagRemovedAndOffsetPosition(i - 1, -j, flag);
                    mState.mStructureChanged = true;
                }
            }
            k++;
        }
        mRecycler.offsetPositionRecordsForRemove(i, j, flag);
        requestLayout();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mLayoutOrScrollCounter = 0;
        mIsAttached = true;
        mFirstLayoutComplete = false;
        if (mLayout != null)
        {
            mLayout.dispatchAttachedToWindow(this);
        }
        mPostedAnimatorRunner = false;
    }

    public void onChildAttachedToWindow(View view)
    {
    }

    public void onChildDetachedFromWindow(View view)
    {
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mItemAnimator != null)
        {
            mItemAnimator.endAnimations();
        }
        mFirstLayoutComplete = false;
        stopScroll();
        mIsAttached = false;
        if (mLayout != null)
        {
            mLayout.dispatchDetachedFromWindow(this, mRecycler);
        }
        removeCallbacks(mItemAnimatorRunner);
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int j = mItemDecorations.size();
        for (int i = 0; i < j; i++)
        {
            ((ItemDecoration)mItemDecorations.get(i)).onDraw(canvas, this, mState);
        }

    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if (mLayout != null && !mLayoutFrozen && (at.d(motionevent) & 2) != 0 && motionevent.getAction() == 8)
        {
            float f;
            float f1;
            if (mLayout.canScrollVertically())
            {
                f = -at.e(motionevent, 9);
            } else
            {
                f = 0.0F;
            }
            if (mLayout.canScrollHorizontally())
            {
                f1 = at.e(motionevent, 10);
            } else
            {
                f1 = 0.0F;
            }
            if (f != 0.0F || f1 != 0.0F)
            {
                float f2 = getScrollFactor();
                scrollByInternal((int)(f1 * f2), (int)(f * f2), motionevent);
                return false;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        byte byte0;
        boolean flag;
        byte0 = -1;
        flag = true;
        if (!mLayoutFrozen) goto _L2; else goto _L1
_L1:
        flag = false;
_L11:
        return flag;
_L2:
        int i;
        int j;
        boolean flag1;
        boolean flag2;
        if (dispatchOnItemTouchIntercept(motionevent))
        {
            cancelTouch();
            return true;
        }
        if (mLayout == null)
        {
            return false;
        }
        flag1 = mLayout.canScrollHorizontally();
        flag2 = mLayout.canScrollVertically();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        j = at.a(motionevent);
        i = at.b(motionevent);
        j;
        JVM INSTR tableswitch 0 6: default 136
    //                   0 146
    //                   1 547
    //                   2 311
    //                   3 561
    //                   4 136
    //                   5 257
    //                   6 539;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L8 _L9
_L7:
        break MISSING_BLOCK_LABEL_561;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L12:
        if (mScrollState != 1)
        {
            return false;
        }
        if (true) goto _L11; else goto _L10
_L10:
        if (mIgnoreMotionEventTillDown)
        {
            mIgnoreMotionEventTillDown = false;
        }
        mScrollPointerId = at.b(motionevent, 0);
        i = (int)(motionevent.getX() + 0.5F);
        mLastTouchX = i;
        mInitialTouchX = i;
        i = (int)(motionevent.getY() + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
        if (mScrollState == 2)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
            setScrollState(1);
        }
        int k;
        int l;
        int i1;
        if (flag1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        k = i;
        if (flag2)
        {
            k = i | 2;
        }
        startNestedScroll(k);
          goto _L12
_L8:
        mScrollPointerId = at.b(motionevent, i);
        k = (int)(at.c(motionevent, i) + 0.5F);
        mLastTouchX = k;
        mInitialTouchX = k;
        i = (int)(at.d(motionevent, i) + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
          goto _L12
_L6:
        k = at.a(motionevent, mScrollPointerId);
        if (k < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        i = (int)(at.c(motionevent, k) + 0.5F);
        k = (int)(at.d(motionevent, k) + 0.5F);
        if (mScrollState != 1)
        {
            i -= mInitialTouchX;
            l = k - mInitialTouchY;
            if (flag1 && Math.abs(i) > mTouchSlop)
            {
                k = mInitialTouchX;
                i1 = mTouchSlop;
                if (i < 0)
                {
                    i = -1;
                } else
                {
                    i = 1;
                }
                mLastTouchX = i * i1 + k;
                i = 1;
            } else
            {
                i = 0;
            }
            k = i;
            if (flag2)
            {
                k = i;
                if (Math.abs(l) > mTouchSlop)
                {
                    k = mInitialTouchY;
                    i1 = mTouchSlop;
                    if (l < 0)
                    {
                        i = byte0;
                    } else
                    {
                        i = 1;
                    }
                    mLastTouchY = k + i * i1;
                    k = 1;
                }
            }
            if (k != 0)
            {
                motionevent = getParent();
                if (motionevent != null)
                {
                    motionevent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        }
          goto _L12
_L9:
        onPointerUp(motionevent);
          goto _L12
_L5:
        mVelocityTracker.clear();
        stopNestedScroll();
          goto _L12
        cancelTouch();
          goto _L12
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        eatRequestLayout();
        android.support.v4.e.a.c("RV OnLayout");
        dispatchLayout();
        android.support.v4.e.a.l();
        resumeRequestLayout(false);
        mFirstLayoutComplete = true;
    }

    protected void onMeasure(int i, int j)
    {
        if (mAdapterUpdateDuringMeasure)
        {
            eatRequestLayout();
            processAdapterUpdatesAndSetAnimationFlags();
            if (mState.mRunPredictiveAnimations)
            {
                mState.mInPreLayout = true;
            } else
            {
                mAdapterHelper.consumeUpdatesInOnePass();
                mState.mInPreLayout = false;
            }
            mAdapterUpdateDuringMeasure = false;
            resumeRequestLayout(false);
        }
        if (mAdapter != null)
        {
            mState.mItemCount = mAdapter.getItemCount();
        } else
        {
            mState.mItemCount = 0;
        }
        if (mLayout == null)
        {
            defaultOnMeasure(i, j);
        } else
        {
            mLayout.onMeasure(mRecycler, mState, i, j);
        }
        mState.mInPreLayout = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        mPendingSavedState = (SavedState)parcelable;
        super.onRestoreInstanceState(mPendingSavedState.getSuperState());
        if (mLayout != null && mPendingSavedState.mLayoutState != null)
        {
            mLayout.onRestoreInstanceState(mPendingSavedState.mLayoutState);
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (mPendingSavedState != null)
        {
            savedstate.copyFrom(mPendingSavedState);
            return savedstate;
        }
        if (mLayout != null)
        {
            savedstate.mLayoutState = mLayout.onSaveInstanceState();
            return savedstate;
        } else
        {
            savedstate.mLayoutState = null;
            return savedstate;
        }
    }

    public void onScrollStateChanged(int i)
    {
    }

    public void onScrolled(int i, int j)
    {
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k || j != l)
        {
            invalidateGlows();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        if (!mLayoutFrozen && !mIgnoreMotionEventTillDown) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (dispatchOnItemTouch(motionevent))
        {
            cancelTouch();
            return true;
        }
        if (mLayout == null) goto _L1; else goto _L3
_L3:
        MotionEvent motionevent1;
        int i;
        int j;
        int k;
        boolean flag1;
        boolean flag2;
        flag1 = mLayout.canScrollHorizontally();
        flag2 = mLayout.canScrollVertically();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        motionevent1 = MotionEvent.obtain(motionevent);
        k = at.a(motionevent);
        j = at.b(motionevent);
        if (k == 0)
        {
            int ai[] = mNestedOffsets;
            mNestedOffsets[1] = 0;
            ai[0] = 0;
        }
        motionevent1.offsetLocation(mNestedOffsets[0], mNestedOffsets[1]);
        i = ((flag) ? 1 : 0);
        k;
        JVM INSTR tableswitch 0 6: default 180
    //                   0 205
    //                   1 834
    //                   2 364
    //                   3 942
    //                   4 184
    //                   5 297
    //                   6 822;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L9:
        break; /* Loop/switch isn't completed */
_L4:
        i = ((flag) ? 1 : 0);
_L13:
        if (i == 0)
        {
            mVelocityTracker.addMovement(motionevent1);
        }
        motionevent1.recycle();
        return true;
_L5:
        mScrollPointerId = at.b(motionevent, 0);
        i = (int)(motionevent.getX() + 0.5F);
        mLastTouchX = i;
        mInitialTouchX = i;
        i = (int)(motionevent.getY() + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
        float f;
        float f1;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if (flag1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = i;
        if (flag2)
        {
            j = i | 2;
        }
        startNestedScroll(j);
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L10:
        mScrollPointerId = at.b(motionevent, j);
        i = (int)(at.c(motionevent, j) + 0.5F);
        mLastTouchX = i;
        mInitialTouchX = i;
        i = (int)(at.d(motionevent, j) + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L7:
        i = at.a(motionevent, mScrollPointerId);
        if (i < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        l1 = (int)(at.c(motionevent, i) + 0.5F);
        i2 = (int)(at.d(motionevent, i) + 0.5F);
        i1 = mLastTouchX - l1;
        l = mLastTouchY - i2;
        i = l;
        j = i1;
        if (dispatchNestedPreScroll(i1, l, mScrollConsumed, mScrollOffset))
        {
            j = i1 - mScrollConsumed[0];
            i = l - mScrollConsumed[1];
            motionevent1.offsetLocation(mScrollOffset[0], mScrollOffset[1]);
            motionevent = mNestedOffsets;
            motionevent[0] = motionevent[0] + mScrollOffset[0];
            motionevent = mNestedOffsets;
            motionevent[1] = motionevent[1] + mScrollOffset[1];
        }
        l = i;
        i1 = j;
        if (mScrollState != 1)
        {
            if (flag1 && Math.abs(j) > mTouchSlop)
            {
                if (j > 0)
                {
                    j -= mTouchSlop;
                } else
                {
                    j += mTouchSlop;
                }
                l = 1;
            } else
            {
                l = 0;
            }
            j1 = i;
            k1 = l;
            if (flag2)
            {
                j1 = i;
                k1 = l;
                if (Math.abs(i) > mTouchSlop)
                {
                    if (i > 0)
                    {
                        j1 = i - mTouchSlop;
                    } else
                    {
                        j1 = i + mTouchSlop;
                    }
                    k1 = 1;
                }
            }
            l = j1;
            i1 = j;
            if (k1 != 0)
            {
                motionevent = getParent();
                if (motionevent != null)
                {
                    motionevent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
                i1 = j;
                l = j1;
            }
        }
        i = ((flag) ? 1 : 0);
        if (mScrollState == 1)
        {
            mLastTouchX = l1 - mScrollOffset[0];
            mLastTouchY = i2 - mScrollOffset[1];
            if (!flag1)
            {
                i1 = 0;
            }
            if (!flag2)
            {
                l = 0;
            }
            i = ((flag) ? 1 : 0);
            if (scrollByInternal(i1, l, motionevent1))
            {
                getParent().requestDisallowInterceptTouchEvent(true);
                i = ((flag) ? 1 : 0);
            }
        }
        continue; /* Loop/switch isn't completed */
_L11:
        onPointerUp(motionevent);
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L6:
        mVelocityTracker.addMovement(motionevent1);
        mVelocityTracker.computeCurrentVelocity(1000, mMaxFlingVelocity);
        if (flag1)
        {
            f = -be.a(mVelocityTracker, mScrollPointerId);
        } else
        {
            f = 0.0F;
        }
        if (flag2)
        {
            f1 = -be.b(mVelocityTracker, mScrollPointerId);
        } else
        {
            f1 = 0.0F;
        }
        if (f == 0.0F && f1 == 0.0F || !fling((int)f, (int)f1))
        {
            setScrollState(0);
        }
        resetTouch();
        i = 1;
        continue; /* Loop/switch isn't completed */
_L8:
        cancelTouch();
        i = ((flag) ? 1 : 0);
        if (true) goto _L13; else goto _L12
_L12:
    }

    void rebindUpdatedViewHolders()
    {
        int i;
        int j;
        j = mChildHelper.getChildCount();
        i = 0;
_L2:
        ViewHolder viewholder;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        viewholder = getChildViewHolderInt(mChildHelper.getChildAt(i));
        if (viewholder != null && !viewholder.shouldIgnore())
        {
            if (!viewholder.isRemoved() && !viewholder.isInvalid())
            {
                break; /* Loop/switch isn't completed */
            }
            requestLayout();
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!viewholder.needsUpdate()) goto _L4; else goto _L3
_L3:
label0:
        {
            int k = mAdapter.getItemViewType(viewholder.mPosition);
            if (viewholder.getItemViewType() != k)
            {
                break label0;
            }
            if (!viewholder.isChanged() || !supportsChangeAnimations())
            {
                mAdapter.bindViewHolder(viewholder, viewholder.mPosition);
            } else
            {
                requestLayout();
            }
        }
          goto _L4
        requestLayout();
    }

    protected void removeDetachedView(View view, boolean flag)
    {
        ViewHolder viewholder = getChildViewHolderInt(view);
        if (viewholder != null)
        {
            if (viewholder.isTmpDetached())
            {
                viewholder.clearTmpDetachFlag();
            } else
            if (!viewholder.shouldIgnore())
            {
                throw new IllegalArgumentException((new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.")).append(viewholder).toString());
            }
        }
        dispatchChildDetached(view);
        super.removeDetachedView(view, flag);
    }

    public void requestChildFocus(View view, View view1)
    {
        if (!mLayout.onRequestChildFocus(this, mState, view, view1) && view1 != null)
        {
            mTempRect.set(0, 0, view1.getWidth(), view1.getHeight());
            Object obj = view1.getLayoutParams();
            if (obj instanceof LayoutParams)
            {
                obj = (LayoutParams)obj;
                if (!((LayoutParams) (obj)).mInsetsDirty)
                {
                    obj = ((LayoutParams) (obj)).mDecorInsets;
                    Rect rect = mTempRect;
                    rect.left = rect.left - ((Rect) (obj)).left;
                    rect = mTempRect;
                    rect.right = rect.right + ((Rect) (obj)).right;
                    rect = mTempRect;
                    rect.top = rect.top - ((Rect) (obj)).top;
                    rect = mTempRect;
                    int i = rect.bottom;
                    rect.bottom = ((Rect) (obj)).bottom + i;
                }
            }
            offsetDescendantRectToMyCoords(view1, mTempRect);
            offsetRectIntoDescendantCoords(view, mTempRect);
            obj = mTempRect;
            boolean flag;
            if (!mFirstLayoutComplete)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            requestChildRectangleOnScreen(view, ((Rect) (obj)), flag);
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        return mLayout.requestChildRectangleOnScreen(this, view, rect, flag);
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        int j = mOnItemTouchListeners.size();
        for (int i = 0; i < j; i++)
        {
            ((OnItemTouchListener)mOnItemTouchListeners.get(i)).onRequestDisallowInterceptTouchEvent(flag);
        }

        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        if (!mEatRequestLayout && !mLayoutFrozen)
        {
            super.requestLayout();
            return;
        } else
        {
            mLayoutRequestEaten = true;
            return;
        }
    }

    void resumeRequestLayout(boolean flag)
    {
        if (mEatRequestLayout)
        {
            if (flag && mLayoutRequestEaten && !mLayoutFrozen && mLayout != null && mAdapter != null)
            {
                dispatchLayout();
            }
            mEatRequestLayout = false;
            if (!mLayoutFrozen)
            {
                mLayoutRequestEaten = false;
            }
        }
    }

    void saveOldPositions()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (!viewholder.shouldIgnore())
            {
                viewholder.saveOldPosition();
            }
        }

    }

    public void scrollBy(int i, int j)
    {
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        if (!mLayoutFrozen)
        {
            boolean flag = mLayout.canScrollHorizontally();
            boolean flag1 = mLayout.canScrollVertically();
            if (flag || flag1)
            {
                if (!flag)
                {
                    i = 0;
                }
                if (!flag1)
                {
                    j = 0;
                }
                scrollByInternal(i, j, null);
                return;
            }
        }
    }

    boolean scrollByInternal(int i, int j, MotionEvent motionevent)
    {
        int l = 0;
        boolean flag2 = false;
        int j1 = 0;
        boolean flag = false;
        int k = 0;
        boolean flag3 = false;
        int i1 = 0;
        boolean flag1 = false;
        consumePendingUpdateOperations();
        if (mAdapter != null)
        {
            eatRequestLayout();
            onEnterLayoutOrScroll();
            android.support.v4.e.a.c("RV Scroll");
            k = ((flag3) ? 1 : 0);
            l = ((flag2) ? 1 : 0);
            if (i != 0)
            {
                k = mLayout.scrollHorizontallyBy(i, mRecycler, mState);
                l = i - k;
            }
            i1 = ((flag1) ? 1 : 0);
            j1 = ((flag) ? 1 : 0);
            if (j != 0)
            {
                i1 = mLayout.scrollVerticallyBy(j, mRecycler, mState);
                j1 = j - i1;
            }
            android.support.v4.e.a.l();
            if (supportsChangeAnimations())
            {
                int l1 = mChildHelper.getChildCount();
                int k1 = 0;
                while (k1 < l1) 
                {
                    View view = mChildHelper.getChildAt(k1);
                    Object obj = getChildViewHolder(view);
                    if (obj == null || ((ViewHolder) (obj)).mShadowingHolder == null)
                    {
                        continue;
                    }
                    obj = ((ViewHolder) (obj)).mShadowingHolder;
                    int i2;
                    int j2;
                    if (obj != null)
                    {
                        obj = ((ViewHolder) (obj)).itemView;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    i2 = view.getLeft();
                    j2 = view.getTop();
                    if (i2 != ((View) (obj)).getLeft() || j2 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(i2, j2, ((View) (obj)).getWidth() + i2, ((View) (obj)).getHeight() + j2);
                    }
                    k1++;
                }
            }
            onExitLayoutOrScroll();
            resumeRequestLayout(false);
        }
        if (!mItemDecorations.isEmpty())
        {
            invalidate();
        }
        if (dispatchNestedScroll(k, i1, l, j1, mScrollOffset))
        {
            mLastTouchX = mLastTouchX - mScrollOffset[0];
            mLastTouchY = mLastTouchY - mScrollOffset[1];
            if (motionevent != null)
            {
                motionevent.offsetLocation(mScrollOffset[0], mScrollOffset[1]);
            }
            motionevent = mNestedOffsets;
            motionevent[0] = motionevent[0] + mScrollOffset[0];
            motionevent = mNestedOffsets;
            motionevent[1] = motionevent[1] + mScrollOffset[1];
        } else
        if (bi.a(this) != 2)
        {
            if (motionevent != null)
            {
                pullGlows(motionevent.getX(), l, motionevent.getY(), j1);
            }
            considerReleasingGlowsOnScroll(i, j);
        }
        if (k != 0 || i1 != 0)
        {
            dispatchOnScrolled(k, i1);
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        return k != 0 || i1 != 0;
    }

    public void scrollTo(int i, int j)
    {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityevent)
    {
        if (shouldDeferAccessibilityEvent(accessibilityevent))
        {
            return;
        } else
        {
            super.sendAccessibilityEventUnchecked(accessibilityevent);
            return;
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerviewaccessibilitydelegate)
    {
        mAccessibilityDelegate = recyclerviewaccessibilitydelegate;
        bi.a(this, mAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter)
    {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childdrawingordercallback)
    {
        if (childdrawingordercallback == mChildDrawingOrderCallback)
        {
            return;
        }
        mChildDrawingOrderCallback = childdrawingordercallback;
        boolean flag;
        if (mChildDrawingOrderCallback != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChildrenDrawingOrderEnabled(flag);
    }

    public void setClipToPadding(boolean flag)
    {
        if (flag != mClipToPadding)
        {
            invalidateGlows();
        }
        mClipToPadding = flag;
        super.setClipToPadding(flag);
        if (mFirstLayoutComplete)
        {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean flag)
    {
        mHasFixedSize = flag;
    }

    public void setItemAnimator(ItemAnimator itemanimator)
    {
        if (mItemAnimator != null)
        {
            mItemAnimator.endAnimations();
            mItemAnimator.setListener(null);
        }
        mItemAnimator = itemanimator;
        if (mItemAnimator != null)
        {
            mItemAnimator.setListener(mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i)
    {
        mRecycler.setViewCacheSize(i);
    }

    public void setLayoutFrozen(boolean flag)
    {
label0:
        {
            if (flag != mLayoutFrozen)
            {
                assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
                if (flag)
                {
                    break label0;
                }
                mLayoutFrozen = flag;
                if (mLayoutRequestEaten && mLayout != null && mAdapter != null)
                {
                    requestLayout();
                }
                mLayoutRequestEaten = false;
            }
            return;
        }
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        mLayoutFrozen = flag;
        mIgnoreMotionEventTillDown = true;
        stopScroll();
    }

    public void setLayoutManager(LayoutManager layoutmanager)
    {
        if (layoutmanager == mLayout)
        {
            return;
        }
        if (mLayout != null)
        {
            if (mIsAttached)
            {
                mLayout.dispatchDetachedFromWindow(this, mRecycler);
            }
            mLayout.setRecyclerView(null);
        }
        mRecycler.clear();
        mChildHelper.removeAllViewsUnfiltered();
        mLayout = layoutmanager;
        if (layoutmanager != null)
        {
            if (layoutmanager.mRecyclerView != null)
            {
                throw new IllegalArgumentException((new StringBuilder("LayoutManager ")).append(layoutmanager).append(" is already attached to a RecyclerView: ").append(layoutmanager.mRecyclerView).toString());
            }
            mLayout.setRecyclerView(this);
            if (mIsAttached)
            {
                mLayout.dispatchAttachedToWindow(this);
            }
        }
        requestLayout();
    }

    public void setNestedScrollingEnabled(boolean flag)
    {
        mScrollingChildHelper$5df96aa.a(flag);
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener)
    {
        mScrollListener = onscrolllistener;
    }

    public void setRecycledViewPool(RecycledViewPool recycledviewpool)
    {
        mRecycler.setRecycledViewPool(recycledviewpool);
    }

    public void setRecyclerListener(RecyclerListener recyclerlistener)
    {
        mRecyclerListener = recyclerlistener;
    }

    public void setScrollingTouchSlop(int i)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        switch (i)
        {
        default:
            Log.w("RecyclerView", (new StringBuilder("setScrollingTouchSlop(): bad argument constant ")).append(i).append("; using default value").toString());
            // fall through

        case 0: // '\0'
            mTouchSlop = viewconfiguration.getScaledTouchSlop();
            return;

        case 1: // '\001'
            mTouchSlop = bv.a(viewconfiguration);
            break;
        }
    }

    public void setViewCacheExtension(ViewCacheExtension viewcacheextension)
    {
        mRecycler.setViewCacheExtension(viewcacheextension);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        boolean flag1 = false;
        boolean flag = false;
        if (isComputingLayout())
        {
            int i;
            if (accessibilityevent != null)
            {
                i = a.b(accessibilityevent);
            } else
            {
                i = 0;
            }
            if (i == 0)
            {
                i = ((flag) ? 1 : 0);
            }
            mEatenAccessibilityChangeFlags = i | mEatenAccessibilityChangeFlags;
            flag1 = true;
        }
        return flag1;
    }

    public void smoothScrollBy(int i, int j)
    {
        boolean flag = false;
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        if (!mLayoutFrozen)
        {
            if (!mLayout.canScrollHorizontally())
            {
                i = 0;
            }
            if (!mLayout.canScrollVertically())
            {
                j = ((flag) ? 1 : 0);
            }
            if (i != 0 || j != 0)
            {
                mViewFlinger.smoothScrollBy(i, j);
                return;
            }
        }
    }

    public boolean startNestedScroll(int i)
    {
        return mScrollingChildHelper$5df96aa.a(i);
    }

    public void stopNestedScroll()
    {
        mScrollingChildHelper$5df96aa.d();
    }

    public void stopScroll()
    {
        setScrollState(0);
        stopScrollersInternal();
    }

    void viewRangeUpdate(int i, int j, Object obj)
    {
        int l = mChildHelper.getUnfilteredChildCount();
        for (int k = 0; k < l; k++)
        {
            View view = mChildHelper.getUnfilteredChildAt(k);
            ViewHolder viewholder = getChildViewHolderInt(view);
            if (viewholder == null || viewholder.shouldIgnore() || viewholder.mPosition < i || viewholder.mPosition >= i + j)
            {
                continue;
            }
            viewholder.addFlags(2);
            viewholder.addChangePayload(obj);
            if (supportsChangeAnimations())
            {
                viewholder.addFlags(64);
            }
            ((LayoutParams)view.getLayoutParams()).mInsetsDirty = true;
        }

        mRecycler.viewRangeUpdate(i, j);
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT == 18 || android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = flag;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = (new Class[] {
            android/content/Context, android/util/AttributeSet, Integer.TYPE, Integer.TYPE
        });
    }
























/*
    static boolean access$502(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mPostedAnimatorRunner = flag;
        return flag;
    }

*/







    private class RecyclerViewDataObserver extends AdapterDataObserver
    {
        private class AdapterDataObserver
        {

            public void onChanged()
            {
            }

            public AdapterDataObserver()
            {
            }
        }


        final RecyclerView this$0;

        public void onChanged()
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapter.hasStableIds())
            {
                mState.mStructureChanged = true;
                setDataSetChangedAfterLayout();
            } else
            {
                mState.mStructureChanged = true;
                setDataSetChangedAfterLayout();
            }
            if (!mAdapterHelper.hasPendingUpdates())
            {
                requestLayout();
            }
        }

        private RecyclerViewDataObserver()
        {
            this$0 = RecyclerView.this;
            super();
        }

        RecyclerViewDataObserver(_cls1 _pcls1)
        {
            this();
        }
    }


    private class Recycler
    {

        final ArrayList mAttachedScrap = new ArrayList();
        final ArrayList mCachedViews = new ArrayList();
        private ArrayList mChangedScrap;
        private RecycledViewPool mRecyclerPool;
        private final List mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        private int mViewCacheMax;
        final RecyclerView this$0;

        private void attachAccessibilityDelegate(View view)
        {
            if (isAccessibilityEnabled())
            {
                if (bi.e(view) == 0)
                {
                    bi.c(view, 1);
                }
                if (!bi.b(view))
                {
                    bi.a(view, mAccessibilityDelegate.getItemDelegate());
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewholder)
        {
            if (viewholder.itemView instanceof ViewGroup)
            {
                invalidateDisplayListInt((ViewGroup)viewholder.itemView, false);
            }
        }

        private void invalidateDisplayListInt(ViewGroup viewgroup, boolean flag)
        {
            for (int i = viewgroup.getChildCount() - 1; i >= 0; i--)
            {
                View view = viewgroup.getChildAt(i);
                if (view instanceof ViewGroup)
                {
                    invalidateDisplayListInt((ViewGroup)view, true);
                }
            }

            if (!flag)
            {
                return;
            }
            if (viewgroup.getVisibility() == 4)
            {
                viewgroup.setVisibility(0);
                viewgroup.setVisibility(4);
                return;
            } else
            {
                int j = viewgroup.getVisibility();
                viewgroup.setVisibility(4);
                viewgroup.setVisibility(j);
                return;
            }
        }

        final void addViewHolderToRecycledViewPool(ViewHolder viewholder)
        {
            bi.a(viewholder.itemView, null);
            dispatchViewRecycled(viewholder);
            viewholder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewholder);
        }

        public final void bindViewToPosition(View view, int i)
        {
            boolean flag = true;
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder == null)
            {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int j = mAdapterHelper.findPositionOffset(i);
            if (j < 0 || j >= mAdapter.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid item position ")).append(i).append("(offset:").append(j).append(").state:").append(mState.getItemCount()).toString());
            }
            viewholder.mOwnerRecyclerView = RecyclerView.this;
            mAdapter.bindViewHolder(viewholder, j);
            attachAccessibilityDelegate(view);
            if (mState.isPreLayout())
            {
                viewholder.mPreLayoutPosition = i;
            }
            view = viewholder.itemView.getLayoutParams();
            if (view == null)
            {
                view = (LayoutParams)generateDefaultLayoutParams();
                viewholder.itemView.setLayoutParams(view);
            } else
            if (!checkLayoutParams(view))
            {
                view = (LayoutParams)generateLayoutParams(view);
                viewholder.itemView.setLayoutParams(view);
            } else
            {
                view = (LayoutParams)view;
            }
            view.mInsetsDirty = true;
            view.mViewHolder = viewholder;
            if (viewholder.itemView.getParent() != null)
            {
                flag = false;
            }
            view.mPendingInvalidate = flag;
        }

        public final void clear()
        {
            mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        final void clearOldPositions()
        {
            boolean flag = false;
            int l = mCachedViews.size();
            for (int i = 0; i < l; i++)
            {
                ((ViewHolder)mCachedViews.get(i)).clearOldPosition();
            }

            l = mAttachedScrap.size();
            for (int j = 0; j < l; j++)
            {
                ((ViewHolder)mAttachedScrap.get(j)).clearOldPosition();
            }

            if (mChangedScrap != null)
            {
                int i1 = mChangedScrap.size();
                for (int k = ((flag) ? 1 : 0); k < i1; k++)
                {
                    ((ViewHolder)mChangedScrap.get(k)).clearOldPosition();
                }

            }
        }

        final void clearScrap()
        {
            mAttachedScrap.clear();
        }

        final void dispatchViewRecycled(ViewHolder viewholder)
        {
            if (mRecyclerListener != null)
            {
                mRecyclerListener.onViewRecycled(viewholder);
            }
            if (mAdapter != null)
            {
                mAdapter.onViewRecycled(viewholder);
            }
            if (mState != null)
            {
                mState.onViewRecycled(viewholder);
            }
        }

        final ViewHolder getChangedScrapViewForPosition(int i)
        {
            boolean flag;
            int k;
label0:
            {
                flag = false;
                if (mChangedScrap != null)
                {
                    k = mChangedScrap.size();
                    if (k != 0)
                    {
                        break label0;
                    }
                }
                return null;
            }
            for (int j = 0; j < k; j++)
            {
                ViewHolder viewholder = (ViewHolder)mChangedScrap.get(j);
                if (!viewholder.wasReturnedFromScrap() && viewholder.getLayoutPosition() == i)
                {
                    viewholder.addFlags(32);
                    return viewholder;
                }
            }

            if (mAdapter.hasStableIds())
            {
                i = mAdapterHelper.findPositionOffset(i);
                if (i > 0 && i < mAdapter.getItemCount())
                {
                    long l = mAdapter.getItemId(i);
                    for (i = ((flag) ? 1 : 0); i < k; i++)
                    {
                        ViewHolder viewholder1 = (ViewHolder)mChangedScrap.get(i);
                        if (!viewholder1.wasReturnedFromScrap() && viewholder1.getItemId() == l)
                        {
                            viewholder1.addFlags(32);
                            return viewholder1;
                        }
                    }

                }
            }
            return null;
        }

        final RecycledViewPool getRecycledViewPool()
        {
            if (mRecyclerPool == null)
            {
                mRecyclerPool = new RecycledViewPool();
            }
            return mRecyclerPool;
        }

        final int getScrapCount()
        {
            return mAttachedScrap.size();
        }

        public final List getScrapList()
        {
            return mUnmodifiableAttachedScrap;
        }

        final View getScrapViewAt(int i)
        {
            return ((ViewHolder)mAttachedScrap.get(i)).itemView;
        }

        final ViewHolder getScrapViewForId(long l, int i, boolean flag)
        {
            int j = mAttachedScrap.size() - 1;
_L5:
            if (j < 0) goto _L2; else goto _L1
_L1:
            ViewHolder viewholder1;
            viewholder1 = (ViewHolder)mAttachedScrap.get(j);
            if (viewholder1.getItemId() != l || viewholder1.wasReturnedFromScrap())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (i != viewholder1.getItemViewType()) goto _L4; else goto _L3
_L3:
            ViewHolder viewholder;
            viewholder1.addFlags(32);
            viewholder = viewholder1;
            if (viewholder1.isRemoved())
            {
                viewholder = viewholder1;
                if (!mState.isPreLayout())
                {
                    viewholder1.setFlags(2, 14);
                    viewholder = viewholder1;
                }
            }
_L8:
            return viewholder;
_L4:
            if (!flag)
            {
                mAttachedScrap.remove(j);
                removeDetachedView(viewholder1.itemView, false);
                quickRecycleScrapView(viewholder1.itemView);
            }
            j--;
              goto _L5
_L2:
            j = mCachedViews.size() - 1;
_L9:
            if (j < 0) goto _L7; else goto _L6
_L6:
label0:
            {
                ViewHolder viewholder2 = (ViewHolder)mCachedViews.get(j);
                if (viewholder2.getItemId() != l)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (i != viewholder2.getItemViewType())
                {
                    break label0;
                }
                viewholder = viewholder2;
                if (!flag)
                {
                    mCachedViews.remove(j);
                    return viewholder2;
                }
            }
              goto _L8
            if (!flag)
            {
                recycleCachedViewAt(j);
            }
            j--;
              goto _L9
_L7:
            return null;
              goto _L8
        }

        final ViewHolder getScrapViewForPosition(int i, int j, boolean flag)
        {
            int k;
            boolean flag1;
            int l;
            flag1 = false;
            l = mAttachedScrap.size();
            k = 0;
_L10:
            if (k >= l) goto _L2; else goto _L1
_L1:
            Object obj = (ViewHolder)mAttachedScrap.get(k);
            if (((ViewHolder) (obj)).wasReturnedFromScrap() || ((ViewHolder) (obj)).getLayoutPosition() != i || ((ViewHolder) (obj)).isInvalid() || !mState.mInPreLayout && ((ViewHolder) (obj)).isRemoved()) goto _L4; else goto _L3
_L3:
            if (j == -1 || ((ViewHolder) (obj)).getItemViewType() == j) goto _L6; else goto _L5
_L5:
            Log.e("RecyclerView", (new StringBuilder("Scrap view for position ")).append(i).append(" isn't dirty but has wrong view type! (found ").append(((ViewHolder) (obj)).getItemViewType()).append(" but expected ").append(j).append(")").toString());
_L2:
            if (!flag)
            {
                obj = mChildHelper.findHiddenNonRemovedView(i, j);
                if (obj != null)
                {
                    mItemAnimator.endAnimation(getChildViewHolder(((View) (obj))));
                }
            }
            k = mCachedViews.size();
            j = ((flag1) ? 1 : 0);
_L8:
            if (j >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (ViewHolder)mCachedViews.get(j);
            if (!((ViewHolder) (obj)).isInvalid() && ((ViewHolder) (obj)).getLayoutPosition() == i)
            {
                if (!flag)
                {
                    mCachedViews.remove(j);
                }
                return ((ViewHolder) (obj));
            }
            j++;
            continue; /* Loop/switch isn't completed */
_L6:
            ((ViewHolder) (obj)).addFlags(32);
            return ((ViewHolder) (obj));
_L4:
            k++;
            continue; /* Loop/switch isn't completed */
            if (true) goto _L8; else goto _L7
_L7:
            return null;
            if (true) goto _L10; else goto _L9
_L9:
        }

        public final View getViewForPosition(int i)
        {
            return getViewForPosition(i, false);
        }

        final View getViewForPosition(int i, boolean flag)
        {
            boolean flag1 = true;
            if (i < 0 || i >= mState.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Invalid item position ")).append(i).append("(").append(i).append("). Item count:").append(mState.getItemCount()).toString());
            }
            Object obj;
            Object obj1;
            Object obj2;
            int j;
            int k;
            int l;
            int i1;
            if (mState.isPreLayout())
            {
                obj1 = getChangedScrapViewForPosition(i);
                if (obj1 != null)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
            } else
            {
                obj1 = null;
                j = 0;
            }
            obj = obj1;
            if (obj1 != null) goto _L2; else goto _L1
_L1:
            obj1 = getScrapViewForPosition(i, -1, flag);
            obj = obj1;
            if (obj1 == null) goto _L2; else goto _L3
_L3:
            if (validateViewHolderForOffsetPosition(((ViewHolder) (obj1)))) goto _L5; else goto _L4
_L4:
            if (flag) goto _L7; else goto _L6
_L6:
            ((ViewHolder) (obj1)).addFlags(4);
            if (!((ViewHolder) (obj1)).isScrap()) goto _L9; else goto _L8
_L8:
            removeDetachedView(((ViewHolder) (obj1)).itemView, false);
            ((ViewHolder) (obj1)).unScrap();
_L17:
            recycleViewHolderInternal(((ViewHolder) (obj1)));
_L7:
            obj = null;
_L2:
            obj2 = obj;
            l = j;
            if (obj != null) goto _L11; else goto _L10
_L10:
            l = mAdapterHelper.findPositionOffset(i);
            if (l < 0 || l >= mAdapter.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid item position ")).append(i).append("(offset:").append(l).append(").state:").append(mState.getItemCount()).toString());
            }
            i1 = mAdapter.getItemViewType(l);
            obj1 = obj;
            k = j;
            if (mAdapter.hasStableIds())
            {
                obj = getScrapViewForId(mAdapter.getItemId(l), i1, flag);
                obj1 = obj;
                k = j;
                if (obj != null)
                {
                    obj.mPosition = l;
                    k = 1;
                    obj1 = obj;
                }
            }
            obj = obj1;
            if (obj1 == null)
            {
                obj = obj1;
                if (mViewCacheExtension != null)
                {
                    obj2 = mViewCacheExtension.getViewForPositionAndType(this, i, i1);
                    obj = obj1;
                    if (obj2 != null)
                    {
                        obj1 = getChildViewHolder(((View) (obj2)));
                        if (obj1 == null)
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                        }
                        obj = obj1;
                        if (((ViewHolder) (obj1)).shouldIgnore())
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                        }
                    }
                }
            }
            obj1 = obj;
            if (obj == null)
            {
                obj = getRecycledViewPool().getRecycledView(i1);
                obj1 = obj;
                if (obj != null)
                {
                    ((ViewHolder) (obj)).resetInternal();
                    obj1 = obj;
                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
                    {
                        invalidateDisplayListInt(((ViewHolder) (obj)));
                        obj1 = obj;
                    }
                }
            }
            obj2 = obj1;
            l = k;
              goto _L12
_L9:
            if (((ViewHolder) (obj1)).wasReturnedFromScrap())
            {
                ((ViewHolder) (obj1)).clearReturnedFromScrapFlag();
            }
            continue; /* Loop/switch isn't completed */
_L5:
            j = 1;
            obj = obj1;
              goto _L2
_L12:
            if (obj1 != null) goto _L11; else goto _L13
_L13:
            obj1 = mAdapter.createViewHolder(RecyclerView.this, i1);
            j = k;
_L15:
            if (mState.isPreLayout() && ((ViewHolder) (obj1)).isBound())
            {
                obj1.mPreLayoutPosition = i;
                i = 0;
            } else
            if (!((ViewHolder) (obj1)).isBound() || ((ViewHolder) (obj1)).needsUpdate() || ((ViewHolder) (obj1)).isInvalid())
            {
                k = mAdapterHelper.findPositionOffset(i);
                obj1.mOwnerRecyclerView = RecyclerView.this;
                mAdapter.bindViewHolder(((ViewHolder) (obj1)), k);
                attachAccessibilityDelegate(((ViewHolder) (obj1)).itemView);
                if (mState.isPreLayout())
                {
                    obj1.mPreLayoutPosition = i;
                }
                i = 1;
            } else
            {
                i = 0;
            }
            obj = ((ViewHolder) (obj1)).itemView.getLayoutParams();
            if (obj == null)
            {
                obj = (LayoutParams)generateDefaultLayoutParams();
                ((ViewHolder) (obj1)).itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
            {
                obj = (LayoutParams)generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                ((ViewHolder) (obj1)).itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj = (LayoutParams)obj;
            }
            obj.mViewHolder = ((ViewHolder) (obj1));
            if (j != 0 && i != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            obj.mPendingInvalidate = flag;
            return ((ViewHolder) (obj1)).itemView;
_L11:
            j = l;
            obj1 = obj2;
            if (true) goto _L15; else goto _L14
_L14:
            if (true) goto _L17; else goto _L16
_L16:
        }

        final void markItemDecorInsetsDirty()
        {
            int j = mCachedViews.size();
            for (int i = 0; i < j; i++)
            {
                LayoutParams layoutparams = (LayoutParams)((ViewHolder)mCachedViews.get(i)).itemView.getLayoutParams();
                if (layoutparams != null)
                {
                    layoutparams.mInsetsDirty = true;
                }
            }

        }

        final void markKnownViewsInvalid()
        {
            if (mAdapter != null && mAdapter.hasStableIds())
            {
                int j = mCachedViews.size();
                for (int i = 0; i < j; i++)
                {
                    ViewHolder viewholder = (ViewHolder)mCachedViews.get(i);
                    if (viewholder != null)
                    {
                        viewholder.addFlags(6);
                        viewholder.addChangePayload(null);
                    }
                }

            } else
            {
                recycleAndClearCachedViews();
            }
        }

        final void offsetPositionRecordsForInsert(int i, int j)
        {
            int l = mCachedViews.size();
            for (int k = 0; k < l; k++)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(k);
                if (viewholder != null && viewholder.getLayoutPosition() >= i)
                {
                    viewholder.offsetPosition(j, true);
                }
            }

        }

        final void offsetPositionRecordsForMove(int i, int j)
        {
            byte byte0;
            int k;
            int l;
            int i1;
            int j1;
            if (i < j)
            {
                byte0 = -1;
                k = j;
                l = i;
            } else
            {
                byte0 = 1;
                k = i;
                l = j;
            }
            j1 = mCachedViews.size();
            i1 = 0;
            while (i1 < j1) 
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(i1);
                if (viewholder != null && viewholder.mPosition >= l && viewholder.mPosition <= k)
                {
                    if (viewholder.mPosition == i)
                    {
                        viewholder.offsetPosition(j - i, false);
                    } else
                    {
                        viewholder.offsetPosition(byte0, false);
                    }
                }
                i1++;
            }
        }

        final void offsetPositionRecordsForRemove(int i, int j, boolean flag)
        {
            int k = mCachedViews.size() - 1;
            while (k >= 0) 
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(k);
                if (viewholder != null)
                {
                    if (viewholder.getLayoutPosition() >= i + j)
                    {
                        viewholder.offsetPosition(-j, flag);
                    } else
                    if (viewholder.getLayoutPosition() >= i)
                    {
                        viewholder.addFlags(8);
                        recycleCachedViewAt(k);
                    }
                }
                k--;
            }
        }

        final void onAdapterChanged(Adapter adapter, Adapter adapter1, boolean flag)
        {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter1, flag);
        }

        final void quickRecycleScrapView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.mScrapContainer = null;
            view.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(view);
        }

        final void recycleAndClearCachedViews()
        {
            for (int i = mCachedViews.size() - 1; i >= 0; i--)
            {
                recycleCachedViewAt(i);
            }

            mCachedViews.clear();
        }

        final void recycleCachedViewAt(int i)
        {
            addViewHolderToRecycledViewPool((ViewHolder)mCachedViews.get(i));
            mCachedViews.remove(i);
        }

        public final void recycleView(View view)
        {
            ViewHolder viewholder;
            viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.isTmpDetached())
            {
                removeDetachedView(view, false);
            }
            if (!viewholder.isScrap()) goto _L2; else goto _L1
_L1:
            viewholder.unScrap();
_L4:
            recycleViewHolderInternal(viewholder);
            return;
_L2:
            if (viewholder.wasReturnedFromScrap())
            {
                viewholder.clearReturnedFromScrapFlag();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        final void recycleViewHolderInternal(ViewHolder viewholder)
        {
            int i;
            boolean flag1 = true;
            boolean flag = false;
            if (viewholder.isScrap() || viewholder.itemView.getParent() != null)
            {
                StringBuilder stringbuilder = (new StringBuilder("Scrapped or attached views may not be recycled. isScrap:")).append(viewholder.isScrap()).append(" isAttached:");
                if (viewholder.itemView.getParent() == null)
                {
                    flag1 = false;
                }
                throw new IllegalArgumentException(stringbuilder.append(flag1).toString());
            }
            if (viewholder.isTmpDetached())
            {
                throw new IllegalArgumentException((new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ")).append(viewholder).toString());
            }
            if (viewholder.shouldIgnore())
            {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            }
            flag1 = viewholder.doesTransientStatePreventRecycling();
            if (mAdapter != null && flag1 && mAdapter.onFailedToRecycleView(viewholder))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i == 0 && !viewholder.isRecyclable())
            {
                break MISSING_BLOCK_LABEL_287;
            }
            if (viewholder.hasAnyOfTheFlags(78)) goto _L2; else goto _L1
_L1:
            i = mCachedViews.size();
            if (i == mViewCacheMax && i > 0)
            {
                recycleCachedViewAt(0);
            }
            if (i >= mViewCacheMax) goto _L2; else goto _L3
_L3:
            mCachedViews.add(viewholder);
            i = 1;
_L4:
            if (i == 0)
            {
                addViewHolderToRecycledViewPool(viewholder);
                flag = true;
            }
_L5:
            mState.onViewRecycled(viewholder);
            if (i == 0 && !flag && flag1)
            {
                viewholder.mOwnerRecyclerView = null;
            }
            return;
_L2:
            i = 0;
              goto _L4
            i = 0;
              goto _L5
        }

        final void scrapView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.setScrapContainer(this);
            if (!view.isChanged() || !supportsChangeAnimations())
            {
                if (view.isInvalid() && !view.isRemoved() && !mAdapter.hasStableIds())
                {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                } else
                {
                    mAttachedScrap.add(view);
                    return;
                }
            }
            if (mChangedScrap == null)
            {
                mChangedScrap = new ArrayList();
            }
            mChangedScrap.add(view);
        }

        final void setAdapterPositionsAsUnknown()
        {
            int j = mCachedViews.size();
            for (int i = 0; i < j; i++)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(i);
                if (viewholder != null)
                {
                    viewholder.addFlags(512);
                }
            }

        }

        final void setRecycledViewPool(RecycledViewPool recycledviewpool)
        {
            if (mRecyclerPool != null)
            {
                mRecyclerPool.detach();
            }
            mRecyclerPool = recycledviewpool;
            if (recycledviewpool != null)
            {
                mRecyclerPool.attach(getAdapter());
            }
        }

        final void setViewCacheExtension(ViewCacheExtension viewcacheextension)
        {
            mViewCacheExtension = viewcacheextension;
        }

        public final void setViewCacheSize(int i)
        {
            mViewCacheMax = i;
            for (int j = mCachedViews.size() - 1; j >= 0 && mCachedViews.size() > i; j--)
            {
                recycleCachedViewAt(j);
            }

        }

        final void unscrapView(ViewHolder viewholder)
        {
            if (!viewholder.isChanged() || !supportsChangeAnimations() || mChangedScrap == null)
            {
                mAttachedScrap.remove(viewholder);
            } else
            {
                mChangedScrap.remove(viewholder);
            }
            viewholder.mScrapContainer = null;
            viewholder.clearReturnedFromScrapFlag();
        }

        final boolean validateViewHolderForOffsetPosition(ViewHolder viewholder)
        {
            if (!viewholder.isRemoved())
            {
                if (viewholder.mPosition < 0 || viewholder.mPosition >= mAdapter.getItemCount())
                {
                    throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid view holder adapter position")).append(viewholder).toString());
                }
                if (!mState.isPreLayout() && mAdapter.getItemViewType(viewholder.mPosition) != viewholder.getItemViewType())
                {
                    return false;
                }
                if (mAdapter.hasStableIds() && viewholder.getItemId() != mAdapter.getItemId(viewholder.mPosition))
                {
                    return false;
                }
            }
            return true;
        }

        final void viewRangeUpdate(int i, int j)
        {
            for (int k = mCachedViews.size() - 1; k >= 0; k--)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(k);
                if (viewholder == null)
                {
                    continue;
                }
                int l = viewholder.getLayoutPosition();
                if (l >= i && l < i + j)
                {
                    viewholder.addFlags(2);
                    recycleCachedViewAt(k);
                }
            }

        }


        public Recycler()
        {
            this$0 = RecyclerView.this;
            super();
            mChangedScrap = null;
            mUnmodifiableAttachedScrap = Collections.unmodifiableList(mAttachedScrap);
            mViewCacheMax = 2;
        }

        private class RecycledViewPool
        {

            private int mAttachCount;
            private SparseIntArray mMaxScrap;
            private SparseArray mScrap;

            private ArrayList getScrapHeapForType(int i)
            {
                ArrayList arraylist1 = (ArrayList)mScrap.get(i);
                ArrayList arraylist = arraylist1;
                if (arraylist1 == null)
                {
                    ArrayList arraylist2 = new ArrayList();
                    mScrap.put(i, arraylist2);
                    arraylist = arraylist2;
                    if (mMaxScrap.indexOfKey(i) < 0)
                    {
                        mMaxScrap.put(i, 5);
                        arraylist = arraylist2;
                    }
                }
                return arraylist;
            }

            void attach(Adapter adapter)
            {
                mAttachCount = mAttachCount + 1;
            }

            public void clear()
            {
                mScrap.clear();
            }

            void detach()
            {
                mAttachCount = mAttachCount - 1;
            }

            public ViewHolder getRecycledView(int i)
            {
                ArrayList arraylist = (ArrayList)mScrap.get(i);
                if (arraylist != null && !arraylist.isEmpty())
                {
                    i = arraylist.size() - 1;
                    ViewHolder viewholder = (ViewHolder)arraylist.get(i);
                    arraylist.remove(i);
                    return viewholder;
                } else
                {
                    return null;
                }
            }

            void onAdapterChanged(Adapter adapter, Adapter adapter1, boolean flag)
            {
                if (adapter != null)
                {
                    detach();
                }
                if (!flag && mAttachCount == 0)
                {
                    clear();
                }
                if (adapter1 != null)
                {
                    attach(adapter1);
                }
            }

            public void putRecycledView(ViewHolder viewholder)
            {
                int i = viewholder.getItemViewType();
                ArrayList arraylist = getScrapHeapForType(i);
                if (mMaxScrap.get(i) <= arraylist.size())
                {
                    return;
                } else
                {
                    viewholder.resetInternal();
                    arraylist.add(viewholder);
                    return;
                }
            }

            public RecycledViewPool()
            {
                mScrap = new SparseArray();
                mMaxScrap = new SparseIntArray();
                mAttachCount = 0;
            }
        }


        private class RecyclerListener
        {

            public abstract void onViewRecycled(ViewHolder viewholder);
        }


        private class ViewCacheExtension
        {

            public abstract View getViewForPositionAndType(Recycler recycler, int i, int j);
        }

    }


    private class _cls1
        implements Runnable
    {

        final RecyclerView this$0;

        public void run()
        {
            if (mFirstLayoutComplete)
            {
                if (mDataSetHasChangedAfterLayout)
                {
                    android.support.v4.e.a.c("RV FullInvalidate");
                    dispatchLayout();
                    android.support.v4.e.a.l();
                    return;
                }
                if (mAdapterHelper.hasPendingUpdates())
                {
                    android.support.v4.e.a.c("RV PartialInvalidate");
                    eatRequestLayout();
                    mAdapterHelper.preProcess();
                    if (!mLayoutRequestEaten)
                    {
                        rebindUpdatedViewHolders();
                    }
                    resumeRequestLayout(true);
                    android.support.v4.e.a.l();
                    return;
                }
            }
        }

        _cls1()
        {
            this$0 = RecyclerView.this;
            super();
        }
    }


    private class ViewFlinger
        implements Runnable
    {

        private boolean mEatRunOnAnimationRequest;
        private Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        private boolean mReSchedulePostAnimationCallback;
        private au mScroller;
        final RecyclerView this$0;

        private int computeScrollDuration(int i, int j, int k, int l)
        {
            int i1 = Math.abs(i);
            int j1 = Math.abs(j);
            float f;
            float f1;
            float f2;
            boolean flag;
            if (i1 > j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = (int)Math.sqrt(k * k + l * l);
            j = (int)Math.sqrt(i * i + j * j);
            if (flag)
            {
                i = getWidth();
            } else
            {
                i = getHeight();
            }
            l = i / 2;
            f2 = Math.min(1.0F, ((float)j * 1.0F) / (float)i);
            f = l;
            f1 = l;
            f2 = distanceInfluenceForSnapDuration(f2);
            if (k > 0)
            {
                i = Math.round(1000F * Math.abs((f2 * f1 + f) / (float)k)) * 4;
            } else
            {
                if (flag)
                {
                    j = i1;
                } else
                {
                    j = j1;
                }
                i = (int)(((float)j / (float)i + 1.0F) * 300F);
            }
            return Math.min(i, 2000);
        }

        private void disableRunOnAnimationRequests()
        {
            mReSchedulePostAnimationCallback = false;
            mEatRunOnAnimationRequest = true;
        }

        private float distanceInfluenceForSnapDuration(float f)
        {
            return (float)Math.sin((float)((double)(f - 0.5F) * 0.4712389167638204D));
        }

        private void enableRunOnAnimationRequests()
        {
            mEatRunOnAnimationRequest = false;
            if (mReSchedulePostAnimationCallback)
            {
                postOnAnimation();
            }
        }

        public void fling(int i, int j)
        {
            setScrollState(2);
            mLastFlingY = 0;
            mLastFlingX = 0;
            mScroller.a(0, 0, i, j, 0x80000000, 0x7fffffff, 0x80000000, 0x7fffffff);
            postOnAnimation();
        }

        void postOnAnimation()
        {
            if (mEatRunOnAnimationRequest)
            {
                mReSchedulePostAnimationCallback = true;
                return;
            } else
            {
                removeCallbacks(this);
                bi.a(RecyclerView.this, this);
                return;
            }
        }

        public void run()
        {
            au au1;
            SmoothScroller smoothscroller;
            disableRunOnAnimationRequests();
            consumePendingUpdateOperations();
            au1 = mScroller;
            smoothscroller = mLayout.mSmoothScroller;
            if (!au1.g()) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            k2 = au1.b();
            l2 = au1.c();
            i2 = k2 - mLastFlingX;
            j2 = l2 - mLastFlingY;
            j1 = 0;
            i = 0;
            k1 = 0;
            l = 0;
            mLastFlingX = k2;
            mLastFlingY = l2;
            l1 = 0;
            j = 0;
            i1 = 0;
            k = 0;
            if (mAdapter == null)
            {
                break MISSING_BLOCK_LABEL_840;
            }
            eatRequestLayout();
            onEnterLayoutOrScroll();
            android.support.v4.e.a.c("RV Scroll");
            if (i2 != 0)
            {
                i = mLayout.scrollHorizontallyBy(i2, mRecycler, mState);
                j = i2 - i;
            }
            if (j2 != 0)
            {
                l = mLayout.scrollVerticallyBy(j2, mRecycler, mState);
                k = j2 - l;
            }
            android.support.v4.e.a.l();
            if (supportsChangeAnimations())
            {
                j1 = mChildHelper.getChildCount();
                for (i1 = 0; i1 < j1; i1++)
                {
                    View view = mChildHelper.getChildAt(i1);
                    Object obj = getChildViewHolder(view);
                    if (obj == null || ((ViewHolder) (obj)).mShadowingHolder == null)
                    {
                        continue;
                    }
                    obj = ((ViewHolder) (obj)).mShadowingHolder.itemView;
                    k1 = view.getLeft();
                    l1 = view.getTop();
                    if (k1 != ((View) (obj)).getLeft() || l1 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(k1, l1, ((View) (obj)).getWidth() + k1, ((View) (obj)).getHeight() + l1);
                    }
                }

            }
            onExitLayoutOrScroll();
            resumeRequestLayout(false);
            i1 = k;
            k1 = l;
            l1 = j;
            j1 = i;
            if (smoothscroller == null)
            {
                break MISSING_BLOCK_LABEL_840;
            }
            i1 = k;
            k1 = l;
            l1 = j;
            j1 = i;
            if (smoothscroller.isPendingInitialRun())
            {
                break MISSING_BLOCK_LABEL_840;
            }
            i1 = k;
            k1 = l;
            l1 = j;
            j1 = i;
            if (!smoothscroller.isRunning())
            {
                break MISSING_BLOCK_LABEL_840;
            }
            i1 = mState.getItemCount();
            if (i1 != 0) goto _L4; else goto _L3
_L3:
            smoothscroller.stop();
            j1 = i;
_L5:
            if (!mItemDecorations.isEmpty())
            {
                invalidate();
            }
            if (bi.a(RecyclerView.this) != 2)
            {
                considerReleasingGlowsOnScroll(i2, j2);
            }
            if (j != 0 || k != 0)
            {
                i1 = (int)au1.f();
                if (j != k2)
                {
                    if (j < 0)
                    {
                        i = -i1;
                    } else
                    if (j > 0)
                    {
                        i = i1;
                    } else
                    {
                        i = 0;
                    }
                    k1 = i;
                } else
                {
                    k1 = 0;
                }
                if (k != l2)
                {
                    if (k < 0)
                    {
                        i = -i1;
                    } else
                    {
                        i = i1;
                        if (k <= 0)
                        {
                            i = 0;
                        }
                    }
                } else
                {
                    i = 0;
                }
                if (bi.a(RecyclerView.this) != 2)
                {
                    absorbGlows(k1, i);
                }
                if ((k1 != 0 || j == k2 || au1.d() == 0) && (i != 0 || k == l2 || au1.e() == 0))
                {
                    au1.h();
                }
            }
            if (j1 != 0 || l != 0)
            {
                dispatchOnScrolled(j1, l);
            }
            if (!awakenScrollBars())
            {
                invalidate();
            }
            if (j2 != 0 && mLayout.canScrollVertically() && l == j2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i2 != 0 && mLayout.canScrollHorizontally() && j1 == i2)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (i2 == 0 && j2 == 0 || j != 0 || i != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (au1.a() || i == 0)
            {
                setScrollState(0);
            } else
            {
                postOnAnimation();
            }
_L2:
            if (smoothscroller != null)
            {
                if (smoothscroller.isPendingInitialRun())
                {
                    smoothscroller.onAnimation(0, 0);
                }
                if (!mReSchedulePostAnimationCallback)
                {
                    smoothscroller.stop();
                }
            }
            enableRunOnAnimationRequests();
            return;
_L4:
            if (smoothscroller.getTargetPosition() >= i1)
            {
                smoothscroller.setTargetPosition(i1 - 1);
            }
            smoothscroller.onAnimation(i2 - j, j2 - k);
            j1 = i;
            l1 = j;
            k1 = l;
            i1 = k;
            l = k1;
            j = l1;
            k = i1;
              goto _L5
        }

        public void smoothScrollBy(int i, int j)
        {
            smoothScrollBy(i, j, 0, 0);
        }

        public void smoothScrollBy(int i, int j, int k)
        {
            smoothScrollBy(i, j, k, RecyclerView.sQuinticInterpolator);
        }

        public void smoothScrollBy(int i, int j, int k, int l)
        {
            smoothScrollBy(i, j, computeScrollDuration(i, j, k, l));
        }

        public void smoothScrollBy(int i, int j, int k, Interpolator interpolator)
        {
            if (mInterpolator != interpolator)
            {
                mInterpolator = interpolator;
                mScroller = au.a(getContext(), interpolator);
            }
            setScrollState(2);
            mLastFlingY = 0;
            mLastFlingX = 0;
            mScroller.a(0, 0, i, j, k);
            postOnAnimation();
        }

        public void stop()
        {
            removeCallbacks(this);
            mScroller.h();
        }

        public ViewFlinger()
        {
            this$0 = RecyclerView.this;
            super();
            mInterpolator = RecyclerView.sQuinticInterpolator;
            mEatRunOnAnimationRequest = false;
            mReSchedulePostAnimationCallback = false;
            mScroller = au.a(getContext(), RecyclerView.sQuinticInterpolator);
        }

        private class SmoothScroller
        {

            private LayoutManager mLayoutManager;
            private boolean mPendingInitialRun;
            private RecyclerView mRecyclerView;
            private final Action mRecyclingAction;
            private boolean mRunning;
            private int mTargetPosition;
            private View mTargetView;

            private void onAnimation(int i, int j)
            {
label0:
                {
                    RecyclerView recyclerview = mRecyclerView;
                    if (!mRunning || mTargetPosition == -1 || recyclerview == null)
                    {
                        stop();
                    }
                    mPendingInitialRun = false;
                    class Action
                    {

                        private boolean changed;
                        private int consecutiveUpdates;
                        private int mDuration;
                        private int mDx;
                        private int mDy;
                        private Interpolator mInterpolator;
                        private int mJumpToPosition;

                        private void runIfNecessary(RecyclerView recyclerview1)
                        {
                            if (mJumpToPosition >= 0)
                            {
                                int k = mJumpToPosition;
                                mJumpToPosition = -1;
                                recyclerview1.jumpToPositionForSmoothScroller(k);
                                changed = false;
                                return;
                            }
                            if (changed)
                            {
                                validate();
                                if (mInterpolator == null)
                                {
                                    if (mDuration == 0x80000000)
                                    {
                                        recyclerview1.mViewFlinger.smoothScrollBy(mDx, mDy);
                                    } else
                                    {
                                        recyclerview1.mViewFlinger.smoothScrollBy(mDx, mDy, mDuration);
                                    }
                                } else
                                {
                                    recyclerview1.mViewFlinger.smoothScrollBy(mDx, mDy, mDuration, mInterpolator);
                                }
                                consecutiveUpdates = consecutiveUpdates + 1;
                                if (consecutiveUpdates > 10)
                                {
                                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                                }
                                changed = false;
                                return;
                            } else
                            {
                                consecutiveUpdates = 0;
                                return;
                            }
                        }

                        private void validate()
                        {
                            if (mInterpolator != null && mDuration <= 0)
                            {
                                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                            }
                            if (mDuration <= 0)
                            {
                                throw new IllegalStateException("Scroll duration must be a positive number");
                            } else
                            {
                                return;
                            }
                        }

                        boolean hasJumpTarget()
                        {
                            return mJumpToPosition >= 0;
                        }

                    }

                    if (mTargetView != null)
                    {
                        if (getChildPosition(mTargetView) == mTargetPosition)
                        {
                            onTargetFound(mTargetView, recyclerview.mState, mRecyclingAction);
                            mRecyclingAction.runIfNecessary(recyclerview);
                            stop();
                        } else
                        {
                            Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                            mTargetView = null;
                        }
                    }
                    if (mRunning)
                    {
                        onSeekTargetStep(i, j, recyclerview.mState, mRecyclingAction);
                        boolean flag = mRecyclingAction.hasJumpTarget();
                        mRecyclingAction.runIfNecessary(recyclerview);
                        if (flag)
                        {
                            if (!mRunning)
                            {
                                break label0;
                            }
                            mPendingInitialRun = true;
                            recyclerview.mViewFlinger.postOnAnimation();
                        }
                    }
                    return;
                }
                stop();
            }

            public int getChildPosition(View view)
            {
                return mRecyclerView.getChildLayoutPosition(view);
            }

            public int getTargetPosition()
            {
                return mTargetPosition;
            }

            public boolean isPendingInitialRun()
            {
                return mPendingInitialRun;
            }

            public boolean isRunning()
            {
                return mRunning;
            }

            protected void onChildAttachedToWindow(View view)
            {
                if (getChildPosition(view) == getTargetPosition())
                {
                    mTargetView = view;
                }
            }

            protected abstract void onSeekTargetStep(int i, int j, State state, Action action);

            protected abstract void onStop();

            protected abstract void onTargetFound(View view, State state, Action action);

            public void setTargetPosition(int i)
            {
                mTargetPosition = i;
            }

            protected final void stop()
            {
                if (!mRunning)
                {
                    return;
                } else
                {
                    onStop();
                    mRecyclerView.mState.mTargetPosition = -1;
                    mTargetView = null;
                    mTargetPosition = -1;
                    mPendingInitialRun = false;
                    mRunning = false;
                    mLayoutManager.onSmoothScrollerStopped(this);
                    mLayoutManager = null;
                    mRecyclerView = null;
                    return;
                }
            }

        }

    }


    private class State
    {

        private SparseArray mData;
        private int mDeletedInvisibleItemCountSincePreviousLayout;
        final List mDisappearingViewsInLayoutPass = new ArrayList();
        private boolean mInPreLayout;
        int mItemCount;
        android.support.v4.g.a mOldChangedHolders;
        android.support.v4.g.a mPostLayoutHolderMap;
        android.support.v4.g.a mPreLayoutHolderMap;
        private int mPreviousLayoutItemCount;
        private boolean mRunPredictiveAnimations;
        private boolean mRunSimpleAnimations;
        private boolean mStructureChanged;
        private int mTargetPosition;

        private void removeFrom(android.support.v4.g.a a1, ViewHolder viewholder)
        {
            int i = a1.size() - 1;
            do
            {
label0:
                {
                    if (i >= 0)
                    {
                        if (viewholder != a1.c(i))
                        {
                            break label0;
                        }
                        a1.d(i);
                    }
                    return;
                }
                i--;
            } while (true);
        }

        void addToDisappearingList(View view)
        {
            if (!mDisappearingViewsInLayoutPass.contains(view))
            {
                mDisappearingViewsInLayoutPass.add(view);
            }
        }

        public int getItemCount()
        {
            if (mInPreLayout)
            {
                return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
            } else
            {
                return mItemCount;
            }
        }

        public int getTargetScrollPosition()
        {
            return mTargetPosition;
        }

        public boolean hasTargetScrollPosition()
        {
            return mTargetPosition != -1;
        }

        public boolean isPreLayout()
        {
            return mInPreLayout;
        }

        void onViewRecycled(ViewHolder viewholder)
        {
            mPreLayoutHolderMap.remove(viewholder);
            mPostLayoutHolderMap.remove(viewholder);
            if (mOldChangedHolders != null)
            {
                removeFrom(mOldChangedHolders, viewholder);
            }
            mDisappearingViewsInLayoutPass.remove(viewholder.itemView);
        }

        void removeFromDisappearingList(View view)
        {
            mDisappearingViewsInLayoutPass.remove(view);
        }

        public String toString()
        {
            return (new StringBuilder("State{mTargetPosition=")).append(mTargetPosition).append(", mPreLayoutHolderMap=").append(mPreLayoutHolderMap).append(", mPostLayoutHolderMap=").append(mPostLayoutHolderMap).append(", mData=").append(mData).append(", mItemCount=").append(mItemCount).append(", mPreviousLayoutItemCount=").append(mPreviousLayoutItemCount).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(mDeletedInvisibleItemCountSincePreviousLayout).append(", mStructureChanged=").append(mStructureChanged).append(", mInPreLayout=").append(mInPreLayout).append(", mRunSimpleAnimations=").append(mRunSimpleAnimations).append(", mRunPredictiveAnimations=").append(mRunPredictiveAnimations).append('}').toString();
        }

        public boolean willRunPredictiveAnimations()
        {
            return mRunPredictiveAnimations;
        }


/*
        static int access$1202(State state, int i)
        {
            state.mDeletedInvisibleItemCountSincePreviousLayout = i;
            return i;
        }

*/


/*
        static int access$1212(State state, int i)
        {
            i = state.mDeletedInvisibleItemCountSincePreviousLayout + i;
            state.mDeletedInvisibleItemCountSincePreviousLayout = i;
            return i;
        }

*/



/*
        static boolean access$1402(State state, boolean flag)
        {
            state.mStructureChanged = flag;
            return flag;
        }

*/



/*
        static boolean access$1602(State state, boolean flag)
        {
            state.mRunPredictiveAnimations = flag;
            return flag;
        }

*/



/*
        static boolean access$1702(State state, boolean flag)
        {
            state.mInPreLayout = flag;
            return flag;
        }

*/



/*
        static boolean access$1802(State state, boolean flag)
        {
            state.mRunSimpleAnimations = flag;
            return flag;
        }

*/


/*
        static int access$2102(State state, int i)
        {
            state.mPreviousLayoutItemCount = i;
            return i;
        }

*/


/*
        static int access$4802(State state, int i)
        {
            state.mTargetPosition = i;
            return i;
        }

*/

        public State()
        {
            mTargetPosition = -1;
            mPreLayoutHolderMap = new android.support.v4.g.a();
            mPostLayoutHolderMap = new android.support.v4.g.a();
            mOldChangedHolders = new android.support.v4.g.a();
            mItemCount = 0;
            mPreviousLayoutItemCount = 0;
            mDeletedInvisibleItemCountSincePreviousLayout = 0;
            mStructureChanged = false;
            mInPreLayout = false;
            mRunSimpleAnimations = false;
            mRunPredictiveAnimations = false;
        }
    }


    private class ItemAnimatorRestoreListener
        implements ItemAnimator.ItemAnimatorListener
    {

        final RecyclerView this$0;

        public void onAddFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onChangeFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (viewholder.mShadowedHolder != null && viewholder.mShadowingHolder == null)
            {
                viewholder.mShadowedHolder = null;
                viewholder.setFlags(-65, viewholder.mFlags);
            }
            viewholder.mShadowingHolder = null;
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onMoveFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onRemoveFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!removeAnimatingView(viewholder.itemView) && viewholder.isTmpDetached())
            {
                removeDetachedView(viewholder.itemView, false);
            }
        }

        private ItemAnimatorRestoreListener()
        {
            this$0 = RecyclerView.this;
            super();
        }

        ItemAnimatorRestoreListener(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls2
        implements Runnable
    {

        final RecyclerView this$0;

        public void run()
        {
            if (mItemAnimator != null)
            {
                mItemAnimator.runPendingAnimations();
            }
            mPostedAnimatorRunner = false;
        }

        _cls2()
        {
            this$0 = RecyclerView.this;
            super();
        }
    }


    private class ItemAnimator
    {

        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;
        private boolean mSupportsChangeAnimations;

        public abstract boolean animateAdd(ViewHolder viewholder);

        public abstract boolean animateChange(ViewHolder viewholder, ViewHolder viewholder1, int i, int j, int k, int l);

        public abstract boolean animateMove(ViewHolder viewholder, int i, int j, int k, int l);

        public abstract boolean animateRemove(ViewHolder viewholder);

        public final void dispatchAddFinished(ViewHolder viewholder)
        {
            onAddFinished(viewholder);
            class ItemAnimatorListener
            {

                public abstract void onAddFinished(ViewHolder viewholder1);

                public abstract void onChangeFinished(ViewHolder viewholder1);

                public abstract void onMoveFinished(ViewHolder viewholder1);

                public abstract void onRemoveFinished(ViewHolder viewholder1);
            }

            if (mListener != null)
            {
                mListener.onAddFinished(viewholder);
            }
        }

        public final void dispatchAddStarting(ViewHolder viewholder)
        {
            onAddStarting(viewholder);
        }

        public final void dispatchAnimationsFinished()
        {
            int j = mFinishedListeners.size();
            for (int i = 0; i < j; i++)
            {
                class ItemAnimatorFinishedListener
                {

                    public abstract void onAnimationsFinished();
                }

                ((ItemAnimatorFinishedListener)mFinishedListeners.get(i)).onAnimationsFinished();
            }

            mFinishedListeners.clear();
        }

        public final void dispatchChangeFinished(ViewHolder viewholder, boolean flag)
        {
            onChangeFinished(viewholder, flag);
            if (mListener != null)
            {
                mListener.onChangeFinished(viewholder);
            }
        }

        public final void dispatchChangeStarting(ViewHolder viewholder, boolean flag)
        {
            onChangeStarting(viewholder, flag);
        }

        public final void dispatchMoveFinished(ViewHolder viewholder)
        {
            onMoveFinished(viewholder);
            if (mListener != null)
            {
                mListener.onMoveFinished(viewholder);
            }
        }

        public final void dispatchMoveStarting(ViewHolder viewholder)
        {
            onMoveStarting(viewholder);
        }

        public final void dispatchRemoveFinished(ViewHolder viewholder)
        {
            onRemoveFinished(viewholder);
            if (mListener != null)
            {
                mListener.onRemoveFinished(viewholder);
            }
        }

        public final void dispatchRemoveStarting(ViewHolder viewholder)
        {
            onRemoveStarting(viewholder);
        }

        public abstract void endAnimation(ViewHolder viewholder);

        public abstract void endAnimations();

        public long getAddDuration()
        {
            return mAddDuration;
        }

        public long getChangeDuration()
        {
            return mChangeDuration;
        }

        public long getMoveDuration()
        {
            return mMoveDuration;
        }

        public long getRemoveDuration()
        {
            return mRemoveDuration;
        }

        public boolean getSupportsChangeAnimations()
        {
            return mSupportsChangeAnimations;
        }

        public abstract boolean isRunning();

        public void onAddFinished(ViewHolder viewholder)
        {
        }

        public void onAddStarting(ViewHolder viewholder)
        {
        }

        public void onChangeFinished(ViewHolder viewholder, boolean flag)
        {
        }

        public void onChangeStarting(ViewHolder viewholder, boolean flag)
        {
        }

        public void onMoveFinished(ViewHolder viewholder)
        {
        }

        public void onMoveStarting(ViewHolder viewholder)
        {
        }

        public void onRemoveFinished(ViewHolder viewholder)
        {
        }

        public void onRemoveStarting(ViewHolder viewholder)
        {
        }

        public abstract void runPendingAnimations();

        void setListener(ItemAnimatorListener itemanimatorlistener)
        {
            mListener = itemanimatorlistener;
        }

        public ItemAnimator()
        {
            mListener = null;
            mFinishedListeners = new ArrayList();
            mAddDuration = 120L;
            mRemoveDuration = 120L;
            mMoveDuration = 250L;
            mChangeDuration = 250L;
            mSupportsChangeAnimations = true;
        }
    }


    private class ViewHolder
    {

        private static final List FULLUPDATE_PAYLOADS;
        public final View itemView;
        private int mFlags;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List mPayloads;
        int mPosition;
        int mPreLayoutPosition;
        private Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;
        List mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        private void createPayloadsIfNeeded()
        {
            if (mPayloads == null)
            {
                mPayloads = new ArrayList();
                mUnmodifiedPayloads = Collections.unmodifiableList(mPayloads);
            }
        }

        private boolean doesTransientStatePreventRecycling()
        {
            return (mFlags & 0x10) == 0 && bi.c(itemView);
        }

        private void onEnteredHiddenState()
        {
            mWasImportantForAccessibilityBeforeHidden = bi.e(itemView);
            bi.c(itemView, 4);
        }

        private void onLeftHiddenState()
        {
            bi.c(itemView, mWasImportantForAccessibilityBeforeHidden);
            mWasImportantForAccessibilityBeforeHidden = 0;
        }

        private boolean shouldBeKeptAsChild()
        {
            return (mFlags & 0x10) != 0;
        }

        void addChangePayload(Object obj)
        {
            if (obj == null)
            {
                addFlags(1024);
            } else
            if ((mFlags & 0x400) == 0)
            {
                createPayloadsIfNeeded();
                mPayloads.add(obj);
                return;
            }
        }

        void addFlags(int i)
        {
            mFlags = mFlags | i;
        }

        void clearOldPosition()
        {
            mOldPosition = -1;
            mPreLayoutPosition = -1;
        }

        void clearPayload()
        {
            if (mPayloads != null)
            {
                mPayloads.clear();
            }
            mFlags = mFlags & 0xfffffbff;
        }

        void clearReturnedFromScrapFlag()
        {
            mFlags = mFlags & 0xffffffdf;
        }

        void clearTmpDetachFlag()
        {
            mFlags = mFlags & 0xfffffeff;
        }

        void flagRemovedAndOffsetPosition(int i, int j, boolean flag)
        {
            addFlags(8);
            offsetPosition(j, flag);
            mPosition = i;
        }

        public final long getItemId()
        {
            return mItemId;
        }

        public final int getItemViewType()
        {
            return mItemViewType;
        }

        public final int getLayoutPosition()
        {
            if (mPreLayoutPosition == -1)
            {
                return mPosition;
            } else
            {
                return mPreLayoutPosition;
            }
        }

        List getUnmodifiedPayloads()
        {
            if ((mFlags & 0x400) == 0)
            {
                if (mPayloads == null || mPayloads.size() == 0)
                {
                    return FULLUPDATE_PAYLOADS;
                } else
                {
                    return mUnmodifiedPayloads;
                }
            } else
            {
                return FULLUPDATE_PAYLOADS;
            }
        }

        boolean hasAnyOfTheFlags(int i)
        {
            return (mFlags & i) != 0;
        }

        boolean isAdapterPositionUnknown()
        {
            return (mFlags & 0x200) != 0 || isInvalid();
        }

        boolean isBound()
        {
            return (mFlags & 1) != 0;
        }

        boolean isChanged()
        {
            return (mFlags & 0x40) != 0;
        }

        boolean isInvalid()
        {
            return (mFlags & 4) != 0;
        }

        public final boolean isRecyclable()
        {
            return (mFlags & 0x10) == 0 && !bi.c(itemView);
        }

        boolean isRemoved()
        {
            return (mFlags & 8) != 0;
        }

        boolean isScrap()
        {
            return mScrapContainer != null;
        }

        boolean isTmpDetached()
        {
            return (mFlags & 0x100) != 0;
        }

        boolean needsUpdate()
        {
            return (mFlags & 2) != 0;
        }

        void offsetPosition(int i, boolean flag)
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
            if (mPreLayoutPosition == -1)
            {
                mPreLayoutPosition = mPosition;
            }
            if (flag)
            {
                mPreLayoutPosition = mPreLayoutPosition + i;
            }
            mPosition = mPosition + i;
            if (itemView.getLayoutParams() != null)
            {
                ((LayoutParams)itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        void resetInternal()
        {
            mFlags = 0;
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mPreLayoutPosition = -1;
            mIsRecyclableCount = 0;
            mShadowedHolder = null;
            mShadowingHolder = null;
            clearPayload();
            mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void saveOldPosition()
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
        }

        void setFlags(int i, int j)
        {
            mFlags = mFlags & ~j | i & j;
        }

        public final void setIsRecyclable(boolean flag)
        {
            int i;
            if (flag)
            {
                i = mIsRecyclableCount - 1;
            } else
            {
                i = mIsRecyclableCount + 1;
            }
            mIsRecyclableCount = i;
            if (mIsRecyclableCount < 0)
            {
                mIsRecyclableCount = 0;
                Log.e("View", (new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ")).append(this).toString());
            } else
            {
                if (!flag && mIsRecyclableCount == 1)
                {
                    mFlags = mFlags | 0x10;
                    return;
                }
                if (flag && mIsRecyclableCount == 0)
                {
                    mFlags = mFlags & 0xffffffef;
                    return;
                }
            }
        }

        void setScrapContainer(Recycler recycler)
        {
            mScrapContainer = recycler;
        }

        boolean shouldIgnore()
        {
            return (mFlags & 0x80) != 0;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder((new StringBuilder("ViewHolder{")).append(Integer.toHexString(hashCode())).append(" position=").append(mPosition).append(" id=").append(mItemId).append(", oldPos=").append(mOldPosition).append(", pLpos:").append(mPreLayoutPosition).toString());
            if (isScrap())
            {
                stringbuilder.append(" scrap");
            }
            if (isInvalid())
            {
                stringbuilder.append(" invalid");
            }
            if (!isBound())
            {
                stringbuilder.append(" unbound");
            }
            if (needsUpdate())
            {
                stringbuilder.append(" update");
            }
            if (isRemoved())
            {
                stringbuilder.append(" removed");
            }
            if (shouldIgnore())
            {
                stringbuilder.append(" ignored");
            }
            if (isChanged())
            {
                stringbuilder.append(" changed");
            }
            if (isTmpDetached())
            {
                stringbuilder.append(" tmpDetached");
            }
            if (!isRecyclable())
            {
                stringbuilder.append((new StringBuilder(" not recyclable(")).append(mIsRecyclableCount).append(")").toString());
            }
            if (isAdapterPositionUnknown())
            {
                stringbuilder.append("undefined adapter position");
            }
            if (itemView.getParent() == null)
            {
                stringbuilder.append(" no parent");
            }
            stringbuilder.append("}");
            return stringbuilder.toString();
        }

        void unScrap()
        {
            mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap()
        {
            return (mFlags & 0x20) != 0;
        }

        static 
        {
            FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        }





/*
        static Recycler access$4202(ViewHolder viewholder, Recycler recycler)
        {
            viewholder.mScrapContainer = recycler;
            return recycler;
        }

*/



        public ViewHolder(View view)
        {
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mItemViewType = -1;
            mPreLayoutPosition = -1;
            mShadowedHolder = null;
            mShadowingHolder = null;
            mPayloads = null;
            mUnmodifiedPayloads = null;
            mIsRecyclableCount = 0;
            mScrapContainer = null;
            mWasImportantForAccessibilityBeforeHidden = 0;
            if (view == null)
            {
                throw new IllegalArgumentException("itemView may not be null");
            } else
            {
                itemView = view;
                return;
            }
        }
    }


    private class ItemHolderInfo
    {

        int bottom;
        ViewHolder holder;
        int left;
        int right;
        int top;

        ItemHolderInfo(ViewHolder viewholder, int i, int j, int k, int l)
        {
            holder = viewholder;
            left = i;
            top = j;
            right = k;
            bottom = l;
        }
    }


    private class LayoutManager
    {

        ChildHelper mChildHelper;
        private boolean mIsAttachedToWindow;
        RecyclerView mRecyclerView;
        private boolean mRequestedSimpleAnimations;
        SmoothScroller mSmoothScroller;

        private void addViewInt(View view, int i, boolean flag)
        {
            ViewHolder viewholder;
            LayoutParams layoutparams;
            viewholder = RecyclerView.getChildViewHolderInt(view);
            if (flag || viewholder.isRemoved())
            {
                mRecyclerView.mState.addToDisappearingList(view);
            } else
            {
                mRecyclerView.mState.removeFromDisappearingList(view);
            }
            layoutparams = (LayoutParams)view.getLayoutParams();
            if (!viewholder.wasReturnedFromScrap() && !viewholder.isScrap()) goto _L2; else goto _L1
_L1:
            if (viewholder.isScrap())
            {
                viewholder.unScrap();
            } else
            {
                viewholder.clearReturnedFromScrapFlag();
            }
            mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
_L4:
            if (layoutparams.mPendingInvalidate)
            {
                viewholder.itemView.invalidate();
                layoutparams.mPendingInvalidate = false;
            }
            return;
_L2:
            if (view.getParent() == mRecyclerView)
            {
                int k = mChildHelper.indexOfChild(view);
                int j = i;
                if (i == -1)
                {
                    j = mChildHelper.getChildCount();
                }
                if (k == -1)
                {
                    throw new IllegalStateException((new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:")).append(mRecyclerView.indexOfChild(view)).toString());
                }
                if (k != j)
                {
                    mRecyclerView.mLayout.moveView(k, j);
                }
            } else
            {
                mChildHelper.addView(view, i, false);
                layoutparams.mInsetsDirty = true;
                if (mSmoothScroller != null && mSmoothScroller.isRunning())
                {
                    mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void detachViewInternal(int i, View view)
        {
            mChildHelper.detachViewFromParent(i);
        }

        public static int getChildMeasureSpec(int i, int j, int k, boolean flag)
        {
            int l;
            int i1;
            i1 = 0x40000000;
            l = Math.max(0, i - j);
            if (!flag) goto _L2; else goto _L1
_L1:
            if (k >= 0)
            {
                i = k;
                j = i1;
            } else
            {
                j = 0;
                i = 0;
            }
_L4:
            return android.view.View.MeasureSpec.makeMeasureSpec(i, j);
_L2:
            j = i1;
            i = k;
            if (k < 0)
            {
                if (k == -1)
                {
                    i = l;
                    j = i1;
                } else
                if (k == -2)
                {
                    j = 0x80000000;
                    i = l;
                } else
                {
                    j = 0;
                    i = 0;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void onSmoothScrollerStopped(SmoothScroller smoothscroller)
        {
            if (mSmoothScroller == smoothscroller)
            {
                mSmoothScroller = null;
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.shouldIgnore())
            {
                return;
            }
            if (viewholder.isInvalid() && !viewholder.isRemoved() && !viewholder.isChanged() && !mRecyclerView.mAdapter.hasStableIds())
            {
                removeViewAt(i);
                recycler.recycleViewHolderInternal(viewholder);
                return;
            } else
            {
                detachViewAt(i);
                recycler.scrapView(view);
                return;
            }
        }

        public void addDisappearingView(View view)
        {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i)
        {
            addViewInt(view, i, true);
        }

        public void addView(View view)
        {
            addView(view, -1);
        }

        public void addView(View view, int i)
        {
            addViewInt(view, i, false);
        }

        public void assertNotInLayoutOrScroll(String s)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.assertNotInLayoutOrScroll(s);
            }
        }

        public void attachView(View view, int i)
        {
            attachView(view, i, (LayoutParams)view.getLayoutParams());
        }

        public void attachView(View view, int i, LayoutParams layoutparams)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.isRemoved())
            {
                mRecyclerView.mState.addToDisappearingList(view);
            } else
            {
                mRecyclerView.mState.removeFromDisappearingList(view);
            }
            mChildHelper.attachViewToParent(view, i, layoutparams, viewholder.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect)
        {
            if (mRecyclerView == null)
            {
                rect.set(0, 0, 0, 0);
                return;
            } else
            {
                rect.set(mRecyclerView.getItemDecorInsetsForChild(view));
                return;
            }
        }

        public boolean canScrollHorizontally()
        {
            return false;
        }

        public boolean canScrollVertically()
        {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutparams)
        {
            return layoutparams != null;
        }

        public int computeHorizontalScrollExtent(State state)
        {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state)
        {
            return 0;
        }

        public int computeHorizontalScrollRange(State state)
        {
            return 0;
        }

        public int computeVerticalScrollExtent(State state)
        {
            return 0;
        }

        public int computeVerticalScrollOffset(State state)
        {
            return 0;
        }

        public int computeVerticalScrollRange(State state)
        {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler)
        {
            for (int i = getChildCount() - 1; i >= 0; i--)
            {
                scrapOrRecycleView(recycler, i, getChildAt(i));
            }

        }

        public void detachViewAt(int i)
        {
            detachViewInternal(i, getChildAt(i));
        }

        void dispatchAttachedToWindow(RecyclerView recyclerview)
        {
            mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerview);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerview, Recycler recycler)
        {
            mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerview, recycler);
        }

        public View findViewByPosition(int i)
        {
            int k = getChildCount();
            for (int j = 0; j < k; j++)
            {
                View view = getChildAt(j);
                ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
                if (viewholder != null && viewholder.getLayoutPosition() == i && !viewholder.shouldIgnore() && (mRecyclerView.mState.isPreLayout() || !viewholder.isRemoved()))
                {
                    return view;
                }
            }

            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeset)
        {
            return new LayoutParams(context, attributeset);
        }

        public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            if (layoutparams instanceof LayoutParams)
            {
                return new LayoutParams((LayoutParams)layoutparams);
            }
            if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
            {
                return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
            } else
            {
                return new LayoutParams(layoutparams);
            }
        }

        public int getBaseline()
        {
            return -1;
        }

        public int getBottomDecorationHeight(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int i)
        {
            if (mChildHelper != null)
            {
                return mChildHelper.getChildAt(i);
            } else
            {
                return null;
            }
        }

        public int getChildCount()
        {
            if (mChildHelper != null)
            {
                return mChildHelper.getChildCount();
            } else
            {
                return 0;
            }
        }

        public boolean getClipToPadding()
        {
            return mRecyclerView != null && mRecyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state)
        {
            while (mRecyclerView == null || mRecyclerView.mAdapter == null || !canScrollHorizontally()) 
            {
                return 1;
            }
            return mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view)
        {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public int getDecoratedLeft(View view)
        {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            int i = view.getMeasuredHeight();
            int j = rect.top;
            return rect.bottom + (i + j);
        }

        public int getDecoratedMeasuredWidth(View view)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            int i = view.getMeasuredWidth();
            int j = rect.left;
            return rect.right + (i + j);
        }

        public int getDecoratedRight(View view)
        {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view)
        {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild()
        {
            View view;
            if (mRecyclerView != null)
            {
                if ((view = mRecyclerView.getFocusedChild()) != null && !mChildHelper.isHidden(view))
                {
                    return view;
                }
            }
            return null;
        }

        public int getHeight()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getHeight();
            } else
            {
                return 0;
            }
        }

        public int getItemCount()
        {
            Adapter adapter;
            if (mRecyclerView != null)
            {
                adapter = mRecyclerView.getAdapter();
            } else
            {
                adapter = null;
            }
            if (adapter != null)
            {
                return adapter.getItemCount();
            } else
            {
                return 0;
            }
        }

        public int getLayoutDirection()
        {
            return bi.h(mRecyclerView);
        }

        public int getLeftDecorationWidth(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.left;
        }

        public int getPaddingBottom()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingBottom();
            } else
            {
                return 0;
            }
        }

        public int getPaddingLeft()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingLeft();
            } else
            {
                return 0;
            }
        }

        public int getPaddingRight()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingRight();
            } else
            {
                return 0;
            }
        }

        public int getPaddingTop()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingTop();
            } else
            {
                return 0;
            }
        }

        public int getPosition(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state)
        {
            while (mRecyclerView == null || mRecyclerView.mAdapter == null || !canScrollVertically()) 
            {
                return 1;
            }
            return mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state)
        {
            return 0;
        }

        public int getTopDecorationHeight(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.top;
        }

        public int getWidth()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getWidth();
            } else
            {
                return 0;
            }
        }

        public boolean isAttachedToWindow()
        {
            return mIsAttachedToWindow;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state)
        {
            return false;
        }

        public boolean isSmoothScrolling()
        {
            return mSmoothScroller != null && mSmoothScroller.isRunning();
        }

        public void layoutDecorated(View view, int i, int j, int k, int l)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            view.layout(rect.left + i, rect.top + j, k - rect.right, l - rect.bottom);
        }

        public void measureChildWithMargins(View view, int i, int j)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            Rect rect = mRecyclerView.getItemDecorInsetsForChild(view);
            int k = rect.left;
            int l = rect.right;
            int i1 = rect.top;
            int j1 = rect.bottom;
            view.measure(getChildMeasureSpec(getWidth(), k + l + i + (getPaddingLeft() + getPaddingRight() + layoutparams.leftMargin + layoutparams.rightMargin), layoutparams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), j1 + i1 + j + (getPaddingTop() + getPaddingBottom() + layoutparams.topMargin + layoutparams.bottomMargin), layoutparams.height, canScrollVertically()));
        }

        public void moveView(int i, int j)
        {
            View view = getChildAt(i);
            if (view == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Cannot move a child from non-existing index:")).append(i).toString());
            } else
            {
                detachViewAt(i);
                attachView(view, j);
                return;
            }
        }

        public void offsetChildrenHorizontal(int i)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter1)
        {
        }

        public boolean onAddFocusables(RecyclerView recyclerview, ArrayList arraylist, int i, int j)
        {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerview)
        {
        }

        public void onDetachedFromWindow(RecyclerView recyclerview)
        {
        }

        public void onDetachedFromWindow(RecyclerView recyclerview, Recycler recycler)
        {
            onDetachedFromWindow(recyclerview);
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state)
        {
            return null;
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityevent)
        {
            boolean flag1 = true;
            recycler = a.a(accessibilityevent);
            if (mRecyclerView != null)
            {
                boolean flag = flag1;
                if (!bi.b(mRecyclerView, 1))
                {
                    flag = flag1;
                    if (!bi.b(mRecyclerView, -1))
                    {
                        flag = flag1;
                        if (!bi.a(mRecyclerView, -1))
                        {
                            if (bi.a(mRecyclerView, 1))
                            {
                                flag = flag1;
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
                recycler.a(flag);
                if (mRecyclerView.mAdapter != null)
                {
                    recycler.a(mRecyclerView.mAdapter.getItemCount());
                    return;
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            onInitializeAccessibilityEvent(mRecyclerView.mRecycler, mRecyclerView.mState, accessibilityevent);
        }

        void onInitializeAccessibilityNodeInfo(f f1)
        {
            onInitializeAccessibilityNodeInfo(mRecyclerView.mRecycler, mRecyclerView.mState, f1);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, f f1)
        {
            if (bi.b(mRecyclerView, -1) || bi.a(mRecyclerView, -1))
            {
                f1.a(8192);
                f1.i(true);
            }
            if (bi.b(mRecyclerView, 1) || bi.a(mRecyclerView, 1))
            {
                f1.a(4096);
                f1.i(true);
            }
            f1.a(o.a(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, f f1)
        {
            int i;
            int j;
            if (canScrollVertically())
            {
                i = getPosition(view);
            } else
            {
                i = 0;
            }
            if (canScrollHorizontally())
            {
                j = getPosition(view);
            } else
            {
                j = 0;
            }
            f1.b(p.a(i, 1, j, 1, false, false));
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, f f1)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder != null && !viewholder.isRemoved() && !mChildHelper.isHidden(viewholder.itemView))
            {
                onInitializeAccessibilityNodeInfoForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, f1);
            }
        }

        public View onInterceptFocusSearch(View view, int i)
        {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerview, int i, int j)
        {
        }

        public void onItemsChanged(RecyclerView recyclerview)
        {
        }

        public void onItemsMoved(RecyclerView recyclerview, int i, int j, int k)
        {
        }

        public void onItemsRemoved(RecyclerView recyclerview, int i, int j)
        {
        }

        public void onItemsUpdated(RecyclerView recyclerview, int i, int j)
        {
        }

        public void onItemsUpdated(RecyclerView recyclerview, int i, int j, Object obj)
        {
            onItemsUpdated(recyclerview, i, j);
        }

        public void onLayoutChildren(Recycler recycler, State state)
        {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(Recycler recycler, State state, int i, int j)
        {
            mRecyclerView.defaultOnMeasure(i, j);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerview, State state, View view, View view1)
        {
            return onRequestChildFocus(recyclerview, view, view1);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerview, View view, View view1)
        {
            return isSmoothScrolling() || recyclerview.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable)
        {
        }

        public Parcelable onSaveInstanceState()
        {
            return null;
        }

        public void onScrollStateChanged(int i)
        {
        }

        boolean performAccessibilityAction(int i, Bundle bundle)
        {
            return performAccessibilityAction(mRecyclerView.mRecycler, mRecyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int i, Bundle bundle)
        {
            if (mRecyclerView != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            i;
            JVM INSTR lookupswitch 2: default 36
        //                       4096: 129
        //                       8192: 62;
               goto _L3 _L4 _L5
_L3:
            int j;
            i = 0;
            j = 0;
_L8:
            if (j != 0 || i != 0)
            {
                mRecyclerView.scrollBy(i, j);
                return true;
            }
              goto _L1
_L5:
            int k;
            int l;
            int i1;
            if (bi.b(mRecyclerView, -1))
            {
                i = -(getHeight() - getPaddingTop() - getPaddingBottom());
            } else
            {
                i = 0;
            }
            j = i;
            if (!bi.a(mRecyclerView, -1)) goto _L7; else goto _L6
_L6:
            k = -(getWidth() - getPaddingLeft() - getPaddingRight());
            j = i;
            i = k;
              goto _L8
_L4:
            if (bi.b(mRecyclerView, 1))
            {
                i = getHeight() - getPaddingTop() - getPaddingBottom();
            } else
            {
                i = 0;
            }
            j = i;
            if (!bi.a(mRecyclerView, 1)) goto _L7; else goto _L9
_L9:
            k = getWidth();
            l = getPaddingLeft();
            i1 = getPaddingRight();
            j = i;
            i = k - l - i1;
              goto _L8
_L7:
            i = 0;
              goto _L8
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle)
        {
            return false;
        }

        boolean performAccessibilityActionForItem(View view, int i, Bundle bundle)
        {
            return performAccessibilityActionForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, i, bundle);
        }

        public void postOnAnimation(Runnable runnable)
        {
            if (mRecyclerView != null)
            {
                bi.a(mRecyclerView, runnable);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler)
        {
            for (int i = getChildCount() - 1; i >= 0; i--)
            {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore())
                {
                    removeAndRecycleViewAt(i, recycler);
                }
            }

        }

        void removeAndRecycleScrapInt(Recycler recycler)
        {
            int j = recycler.getScrapCount();
            for (int i = j - 1; i >= 0; i--)
            {
                View view = recycler.getScrapViewAt(i);
                ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
                if (viewholder.shouldIgnore())
                {
                    continue;
                }
                viewholder.setIsRecyclable(false);
                if (viewholder.isTmpDetached())
                {
                    mRecyclerView.removeDetachedView(view, false);
                }
                if (mRecyclerView.mItemAnimator != null)
                {
                    mRecyclerView.mItemAnimator.endAnimation(viewholder);
                }
                viewholder.setIsRecyclable(true);
                recycler.quickRecycleScrapView(view);
            }

            recycler.clearScrap();
            if (j > 0)
            {
                mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler)
        {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler)
        {
            View view = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(view);
        }

        public boolean removeCallbacks(Runnable runnable)
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.removeCallbacks(runnable);
            } else
            {
                return false;
            }
        }

        public void removeView(View view)
        {
            mChildHelper.removeView(view);
        }

        public void removeViewAt(int i)
        {
            if (getChildAt(i) != null)
            {
                mChildHelper.removeViewAt(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerview, View view, Rect rect, boolean flag)
        {
            int k1 = getPaddingLeft();
            int l = getPaddingTop();
            int l1 = getWidth() - getPaddingRight();
            int j1 = getHeight();
            int k2 = getPaddingBottom();
            int i2 = view.getLeft() + rect.left;
            int i1 = view.getTop() + rect.top;
            int j2 = i2 + rect.width();
            int l2 = rect.height();
            int i = Math.min(0, i2 - k1);
            int j = Math.min(0, i1 - l);
            int k = Math.max(0, j2 - l1);
            j1 = Math.max(0, (i1 + l2) - (j1 - k2));
            if (getLayoutDirection() == 1)
            {
                if (k != 0)
                {
                    i = k;
                } else
                {
                    i = Math.max(i, j2 - l1);
                }
            } else
            if (i == 0)
            {
                i = Math.min(i2 - k1, k);
            }
            if (j == 0)
            {
                j = Math.min(i1 - l, j1);
            }
            if (i != 0 || j != 0)
            {
                if (flag)
                {
                    recyclerview.scrollBy(i, j);
                } else
                {
                    recyclerview.smoothScrollBy(i, j);
                }
                return true;
            } else
            {
                return false;
            }
        }

        public void requestLayout()
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout()
        {
            mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state)
        {
            return 0;
        }

        public void scrollToPosition(int i)
        {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state)
        {
            return 0;
        }

        public void setMeasuredDimension(int i, int j)
        {
            mRecyclerView.setMeasuredDimension(i, j);
        }

        void setRecyclerView(RecyclerView recyclerview)
        {
            if (recyclerview == null)
            {
                mRecyclerView = null;
                mChildHelper = null;
                return;
            } else
            {
                mRecyclerView = recyclerview;
                mChildHelper = recyclerview.mChildHelper;
                return;
            }
        }

        void stopSmoothScroller()
        {
            if (mSmoothScroller != null)
            {
                mSmoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations()
        {
            return false;
        }



/*
        static boolean access$1902(LayoutManager layoutmanager, boolean flag)
        {
            layoutmanager.mRequestedSimpleAnimations = flag;
            return flag;
        }

*/


        public LayoutManager()
        {
            mRequestedSimpleAnimations = false;
            mIsAttachedToWindow = false;
        }
    }


    private class Adapter
    {
        private class AdapterDataObservable extends Observable
        {

            public void notifyChanged()
            {
                for (int i = mObservers.size() - 1; i >= 0; i--)
                {
                    ((AdapterDataObserver)mObservers.get(i)).onChanged();
                }

            }

            AdapterDataObservable()
            {
            }
        }


        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable = new AdapterDataObservable();

        public final void bindViewHolder(ViewHolder viewholder, int i)
        {
            viewholder.mPosition = i;
            if (hasStableIds())
            {
                viewholder.mItemId = getItemId(i);
            }
            viewholder.setFlags(1, 519);
            android.support.v4.e.a.c("RV OnBindView");
            onBindViewHolder(viewholder, i, viewholder.getUnmodifiedPayloads());
            viewholder.clearPayload();
            android.support.v4.e.a.l();
        }

        public final ViewHolder createViewHolder(ViewGroup viewgroup, int i)
        {
            android.support.v4.e.a.c("RV CreateView");
            viewgroup = onCreateViewHolder(viewgroup, i);
            viewgroup.mItemViewType = i;
            android.support.v4.e.a.l();
            return viewgroup;
        }

        public abstract int getItemCount();

        public long getItemId(int i)
        {
            return -1L;
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public final boolean hasStableIds()
        {
            return mHasStableIds;
        }

        public final void notifyDataSetChanged()
        {
            mObservable.notifyChanged();
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerview)
        {
        }

        public abstract void onBindViewHolder(ViewHolder viewholder, int i);

        public void onBindViewHolder(ViewHolder viewholder, int i, List list)
        {
            onBindViewHolder(viewholder, i);
        }

        public abstract ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerview)
        {
        }

        public boolean onFailedToRecycleView(ViewHolder viewholder)
        {
            return false;
        }

        public void onViewAttachedToWindow(ViewHolder viewholder)
        {
        }

        public void onViewDetachedFromWindow(ViewHolder viewholder)
        {
        }

        public void onViewRecycled(ViewHolder viewholder)
        {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterdataobserver)
        {
            mObservable.registerObserver(adapterdataobserver);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterdataobserver)
        {
            mObservable.unregisterObserver(adapterdataobserver);
        }

        public Adapter()
        {
            mHasStableIds = false;
        }
    }


    private class OnChildAttachStateChangeListener
    {

        public abstract void onChildViewAttachedToWindow(View view);

        public abstract void onChildViewDetachedFromWindow(View view);
    }


    private class OnItemTouchListener
    {

        public abstract boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent);

        public abstract void onRequestDisallowInterceptTouchEvent(boolean flag);

        public abstract void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent);
    }


    private class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public int getViewLayoutPosition()
        {
            return mViewHolder.getLayoutPosition();
        }

        public boolean isItemChanged()
        {
            return mViewHolder.isChanged();
        }

        public boolean isItemRemoved()
        {
            return mViewHolder.isRemoved();
        }

        public LayoutParams(int i, int j)
        {
            super(i, j);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }
    }


    private class _cls4
        implements ChildHelper.Callback
    {

        final RecyclerView this$0;

        public void addView(View view, int i)
        {
            RecyclerView.this.addView(view, i);
            dispatchChildAttached(view);
        }

        public void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder != null)
            {
                if (!viewholder.isTmpDetached() && !viewholder.shouldIgnore())
                {
                    throw new IllegalArgumentException((new StringBuilder("Called attach on a child which is not detached: ")).append(viewholder).toString());
                }
                viewholder.clearTmpDetachFlag();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutparams);
        }

        public void detachViewFromParent(int i)
        {
            Object obj = getChildAt(i);
            if (obj != null)
            {
                obj = RecyclerView.getChildViewHolderInt(((View) (obj)));
                if (obj != null)
                {
                    if (((ViewHolder) (obj)).isTmpDetached() && !((ViewHolder) (obj)).shouldIgnore())
                    {
                        throw new IllegalArgumentException((new StringBuilder("called detach on an already detached child ")).append(obj).toString());
                    }
                    ((ViewHolder) (obj)).addFlags(256);
                }
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        public View getChildAt(int i)
        {
            return RecyclerView.this.getChildAt(i);
        }

        public int getChildCount()
        {
            return RecyclerView.this.getChildCount();
        }

        public ViewHolder getChildViewHolder(View view)
        {
            return RecyclerView.getChildViewHolderInt(view);
        }

        public int indexOfChild(View view)
        {
            return RecyclerView.this.indexOfChild(view);
        }

        public void onEnteredHiddenState(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            if (view != null)
            {
                view.onEnteredHiddenState();
            }
        }

        public void onLeftHiddenState(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            if (view != null)
            {
                view.onLeftHiddenState();
            }
        }

        public void removeAllViews()
        {
            int j = getChildCount();
            for (int i = 0; i < j; i++)
            {
                dispatchChildDetached(getChildAt(i));
            }

            RecyclerView.this.removeAllViews();
        }

        public void removeViewAt(int i)
        {
            View view = RecyclerView.this.getChildAt(i);
            if (view != null)
            {
                dispatchChildDetached(view);
            }
            RecyclerView.this.removeViewAt(i);
        }

        _cls4()
        {
            this$0 = RecyclerView.this;
            super();
        }
    }


    private class OnScrollListener
    {

        public void onScrollStateChanged(RecyclerView recyclerview, int i)
        {
        }

        public void onScrolled(RecyclerView recyclerview, int i, int j)
        {
        }

        public OnScrollListener()
        {
        }
    }


    private class ItemDecoration
    {

        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerview)
        {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, State state)
        {
            getItemOffsets(rect, ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition(), recyclerview);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerview, State state)
        {
            onDraw(canvas, recyclerview);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview, State state)
        {
            onDrawOver(canvas, recyclerview);
        }

        public ItemDecoration()
        {
        }
    }


    private class ChildDrawingOrderCallback
    {

        public abstract int onGetChildDrawingOrder(int i, int j);
    }


    private class _cls5
        implements AdapterHelper.Callback
    {

        final RecyclerView this$0;

        void dispatchUpdate(AdapterHelper.UpdateOp updateop)
        {
            switch (updateop.cmd)
            {
            default:
                return;

            case 0: // '\0'
                mLayout.onItemsAdded(RecyclerView.this, updateop.positionStart, updateop.itemCount);
                return;

            case 1: // '\001'
                mLayout.onItemsRemoved(RecyclerView.this, updateop.positionStart, updateop.itemCount);
                return;

            case 2: // '\002'
                mLayout.onItemsUpdated(RecyclerView.this, updateop.positionStart, updateop.itemCount, updateop.payload);
                return;

            case 3: // '\003'
                mLayout.onItemsMoved(RecyclerView.this, updateop.positionStart, updateop.itemCount, 1);
                break;
            }
        }

        public ViewHolder findViewHolder(int i)
        {
            ViewHolder viewholder;
            for (viewholder = findViewHolderForPosition(i, true); viewholder == null || mChildHelper.isHidden(viewholder.itemView);)
            {
                return null;
            }

            return viewholder;
        }

        public void markViewHoldersUpdated(int i, int j, Object obj)
        {
            viewRangeUpdate(i, j, obj);
            mItemsChanged = true;
        }

        public void offsetPositionsForAdd(int i, int j)
        {
            offsetPositionRecordsForInsert(i, j);
            mItemsAddedOrRemoved = true;
        }

        public void offsetPositionsForMove(int i, int j)
        {
            offsetPositionRecordsForMove(i, j);
            mItemsAddedOrRemoved = true;
        }

        public void offsetPositionsForRemovingInvisible(int i, int j)
        {
            offsetPositionRecordsForRemove(i, j, true);
            mItemsAddedOrRemoved = true;
            i = ((onItemsUpdated) (this)).onItemsUpdated + i;
        }

        public void offsetPositionsForRemovingLaidOutOrNewView(int i, int j)
        {
            offsetPositionRecordsForRemove(i, j, false);
            mItemsAddedOrRemoved = true;
        }

        public void onDispatchFirstPass(AdapterHelper.UpdateOp updateop)
        {
            dispatchUpdate(updateop);
        }

        public void onDispatchSecondPass(AdapterHelper.UpdateOp updateop)
        {
            dispatchUpdate(updateop);
        }

        _cls5()
        {
            this$0 = RecyclerView.this;
            super();
        }
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        Parcelable mLayoutState;

        private void copyFrom(SavedState savedstate)
        {
            mLayoutState = savedstate.mLayoutState;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(mLayoutState, 0);
        }



        SavedState(Parcel parcel)
        {
            super(parcel);
            mLayoutState = parcel.readParcelable(android/support/v7/widget/RecyclerView$LayoutManager.getClassLoader());
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public final volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

                _cls1()
                {
                }
        }

    }


    private class _cls3
        implements Interpolator
    {

        public final float getInterpolation(float f)
        {
            f--;
            return f * (f * f * f * f) + 1.0F;
        }

        _cls3()
        {
        }
    }

}
