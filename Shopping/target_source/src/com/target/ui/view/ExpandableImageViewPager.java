// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.target.ui.adapter.b.b;
import com.target.ui.layout_manager.EagerLinearLayoutManager;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.List;

public class ExpandableImageViewPager extends RecyclerView
    implements com.target.ui.adapter.b.b.a
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        boolean areEndPagesCentered;
        String baseContentDescription;
        android.graphics.Bitmap.Config bitmapConfig;
        boolean expandDisabled;
        int firstSelectedItem;
        int heightMax;
        int heightMin;
        boolean isCollapsed;
        int itemsPerPage;
        int itemsPerPageCurrent;
        Parcelable superState;
        float viewWidthFractionCurrent;
        float viewWidthFractionMin;

        public Parcelable a()
        {
            return superState;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeParcelable(superState, i1);
            parcel.writeBooleanArray(new boolean[] {
                areEndPagesCentered, expandDisabled, isCollapsed
            });
            parcel.writeFloat(viewWidthFractionCurrent);
            parcel.writeFloat(viewWidthFractionMin);
            parcel.writeInt(firstSelectedItem);
            parcel.writeInt(heightMax);
            parcel.writeInt(heightMin);
            parcel.writeInt(itemsPerPage);
            parcel.writeInt(itemsPerPageCurrent);
            if (bitmapConfig == null)
            {
                i1 = -1;
            } else
            {
                i1 = bitmapConfig.ordinal();
            }
            parcel.writeInt(i1);
            parcel.writeString(baseContentDescription);
        }


        private SavedState(Parcel parcel)
        {
            superState = parcel.readParcelable(android/support/v7/widget/RecyclerView.getClassLoader());
            boolean aflag[] = new boolean[3];
            parcel.readBooleanArray(aflag);
            areEndPagesCentered = aflag[0];
            expandDisabled = aflag[1];
            isCollapsed = aflag[2];
            viewWidthFractionCurrent = parcel.readFloat();
            viewWidthFractionMin = parcel.readFloat();
            firstSelectedItem = parcel.readInt();
            heightMax = parcel.readInt();
            heightMin = parcel.readInt();
            itemsPerPage = parcel.readInt();
            itemsPerPageCurrent = parcel.readInt();
            int i1 = parcel.readInt();
            android.graphics.Bitmap.Config config;
            if (i1 == -1)
            {
                config = android.graphics.Bitmap.Config.ARGB_8888;
            } else
            {
                config = android.graphics.Bitmap.Config.values()[i1];
            }
            bitmapConfig = config;
            baseContentDescription = parcel.readString();
        }


        SavedState(Parcelable parcelable)
        {
            superState = parcelable;
        }
    }

    public static interface a
    {

        public abstract void a(int i1);

        public abstract void a(int i1, int j1);
    }


    private static final int HEIGHT_ANIMATION_TIME = 300;
    private static final int NUM_EAGERLY_LOADED_SCREENS = 1;
    private static final int PAGING_ANIMATION_TIME = 500;
    private static final int PAGING_LISTENER_DELAY = 100;
    private static final String TAG = com/target/ui/view/ExpandableImageViewPager.getSimpleName();
    private b mAdapter;
    private View mAnchorView;
    private boolean mAreEndPagesCentered;
    private String mBaseContentDescription;
    private android.graphics.Bitmap.Config mBitmapConfig;
    private List mData;
    private Integer mDesiredAnchorViewLeftValue;
    private int mDisplayWidth;
    private boolean mExpandDisabled;
    private Integer mFinalAnchorViewLeftValue;
    private Integer mFirstSelectedItemSaved;
    private GestureDetector mFlingDetector;
    private int mHeightMax;
    private int mHeightMin;
    private boolean mIsAnimatingExpandedState;
    private boolean mIsAnimatingLeftEdge;
    private boolean mIsCollapsed;
    private int mItemsPerPage;
    private int mItemsPerPageCurrent;
    private EagerLinearLayoutManager mLayoutManager;
    private a mListener;
    private Runnable mRefreshCurrentStateRunnable = new Runnable() {

        final ExpandableImageViewPager this$0;

        public void run()
        {
            t();
            s();
        }

            
            {
                this$0 = ExpandableImageViewPager.this;
                super();
            }
    };
    private float mViewWidthFractionCurrent;
    private float mViewWidthFractionMax;
    private float mViewWidthFractionMin;

    public ExpandableImageViewPager(Context context)
    {
        super(context);
        mIsAnimatingExpandedState = false;
        mIsAnimatingLeftEdge = false;
        mIsCollapsed = true;
        mAreEndPagesCentered = false;
        mExpandDisabled = false;
        mItemsPerPage = 1;
        mItemsPerPageCurrent = mItemsPerPage;
        mViewWidthFractionMin = 0.5F;
        mViewWidthFractionMax = 1.0F;
        mViewWidthFractionCurrent = mViewWidthFractionMin;
        mBitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        mData = new ArrayList();
        u();
    }

    public ExpandableImageViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsAnimatingExpandedState = false;
        mIsAnimatingLeftEdge = false;
        mIsCollapsed = true;
        mAreEndPagesCentered = false;
        mExpandDisabled = false;
        mItemsPerPage = 1;
        mItemsPerPageCurrent = mItemsPerPage;
        mViewWidthFractionMin = 0.5F;
        mViewWidthFractionMax = 1.0F;
        mViewWidthFractionCurrent = mViewWidthFractionMin;
        mBitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        mData = new ArrayList();
        u();
    }

    public ExpandableImageViewPager(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        mIsAnimatingExpandedState = false;
        mIsAnimatingLeftEdge = false;
        mIsCollapsed = true;
        mAreEndPagesCentered = false;
        mExpandDisabled = false;
        mItemsPerPage = 1;
        mItemsPerPageCurrent = mItemsPerPage;
        mViewWidthFractionMin = 0.5F;
        mViewWidthFractionMax = 1.0F;
        mViewWidthFractionCurrent = mViewWidthFractionMin;
        mBitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        mData = new ArrayList();
        u();
    }

    private void A()
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        if (mIsCollapsed)
        {
            layoutparams.height = mHeightMin;
        } else
        {
            layoutparams.height = mHeightMax;
        }
        setLayoutParams(layoutparams);
    }

    private void B()
    {
        if (mIsCollapsed)
        {
            mViewWidthFractionCurrent = mViewWidthFractionMin;
            return;
        } else
        {
            mViewWidthFractionCurrent = mViewWidthFractionMax;
            return;
        }
    }

    static float a(ExpandableImageViewPager expandableimageviewpager)
    {
        return expandableimageviewpager.mViewWidthFractionMin;
    }

    private int a(int i1, int j1, Float float1, boolean flag)
    {
        int k1 = h(i1);
        int l1 = mItemsPerPageCurrent;
        if (i1 == 0 && mAreEndPagesCentered)
        {
            l1 = 1;
        }
        k1 = i1 - k1;
        i1 = k1 + l1;
        if (flag)
        {
            if (-Math.signum(float1.floatValue()) <= 0.0F)
            {
                i1 = k1;
            }
        } else
        {
            int i2 = getViewWidth() / 2;
            if (j1 < 0)
            {
                if (Math.abs(j1) <= i2)
                {
                    i1 = k1;
                }
            } else
            if (Math.abs(j1) > i2)
            {
                i1 = k1 - l1;
            } else
            {
                i1 = k1;
            }
        }
        if (i1 < 0)
        {
            j1 = 0;
        } else
        {
            j1 = i1;
            if (i1 > getLastPosition())
            {
                j1 = getLastPosition();
            }
        }
        i1 = j1;
        if (!j(j1))
        {
            q.a(TAG, (new StringBuilder()).append("Target position set to invalid value : ").append(j1).toString());
            i1 = i(j1);
            q.a(TAG, (new StringBuilder()).append("Recalculated target position : ").append(i1).toString());
        }
        return i1;
    }

    private Animator a(int i1, int j1, final int initialPadding, final int finalPadding)
    {
        final boolean isCollapsed = mIsCollapsed;
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            i1, j1
        });
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final ExpandableImageViewPager this$0;
            final int val$finalPadding;
            final int val$initialPadding;
            final boolean val$isCollapsed;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                int k1 = ((Integer)valueanimator1.getAnimatedValue()).intValue();
                getLayoutParams().height = k1;
                float f2 = valueanimator1.getAnimatedFraction();
                float f1;
                float f3;
                if (!isCollapsed)
                {
                    f1 = 1.0F - f2;
                } else
                {
                    f1 = f2;
                }
                valueanimator1 = ExpandableImageViewPager.this;
                f3 = ExpandableImageViewPager.a(ExpandableImageViewPager.this);
                ExpandableImageViewPager.a(valueanimator1, f1 * (com.target.ui.view.ExpandableImageViewPager.b(ExpandableImageViewPager.this) - ExpandableImageViewPager.a(ExpandableImageViewPager.this)) + f3, isCollapsed);
                for (int l1 = 0; l1 < ExpandableImageViewPager.c(ExpandableImageViewPager.this).o(); l1++)
                {
                    ExpandableImageViewPager.c(ExpandableImageViewPager.this).g(l1).getLayoutParams().width = getViewWidth();
                }

                if (ExpandableImageViewPager.d(ExpandableImageViewPager.this) && initialPadding != finalPadding)
                {
                    int i2 = Math.round((float)initialPadding + f2 * (float)(finalPadding - initialPadding));
                    setPadding(i2, 0, i2, 0);
                    return;
                } else
                {
                    requestLayout();
                    return;
                }
            }

            
            {
                this$0 = ExpandableImageViewPager.this;
                isCollapsed = flag;
                initialPadding = i1;
                finalPadding = j1;
                super();
            }
        });
        return valueanimator;
    }

    private Animator a(View view, int i1, int j1)
    {
        mAnchorView = view;
        mDesiredAnchorViewLeftValue = Integer.valueOf(i1);
        mFinalAnchorViewLeftValue = Integer.valueOf(j1);
        view = ValueAnimator.ofInt(new int[] {
            i1, j1
        });
        view.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final ExpandableImageViewPager this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                ExpandableImageViewPager.a(ExpandableImageViewPager.this, Integer.valueOf(((Integer)valueanimator.getAnimatedValue()).intValue()));
            }

            
            {
                this$0 = ExpandableImageViewPager.this;
                super();
            }
        });
        view.addListener(new AnimatorListenerAdapter() {

            final ExpandableImageViewPager this$0;

            public void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                ExpandableImageViewPager.a(ExpandableImageViewPager.this, false);
            }

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                ExpandableImageViewPager.a(ExpandableImageViewPager.this, true);
            }

            
            {
                this$0 = ExpandableImageViewPager.this;
                super();
            }
        });
        return view;
    }

    static Integer a(ExpandableImageViewPager expandableimageviewpager, Integer integer)
    {
        expandableimageviewpager.mDesiredAnchorViewLeftValue = integer;
        return integer;
    }

    private void a(float f1, boolean flag)
    {
        mViewWidthFractionCurrent = f1;
        c(flag);
        b(flag);
    }

    private void a(SavedState savedstate)
    {
        mAreEndPagesCentered = savedstate.areEndPagesCentered;
        mExpandDisabled = savedstate.expandDisabled;
        mIsCollapsed = savedstate.isCollapsed;
        mViewWidthFractionCurrent = savedstate.viewWidthFractionCurrent;
        mViewWidthFractionMin = savedstate.viewWidthFractionMin;
        mFirstSelectedItemSaved = Integer.valueOf(savedstate.firstSelectedItem);
        mHeightMax = savedstate.heightMax;
        mHeightMin = savedstate.heightMin;
        mItemsPerPage = savedstate.itemsPerPage;
        mItemsPerPageCurrent = savedstate.itemsPerPageCurrent;
        mBitmapConfig = savedstate.bitmapConfig;
        mBaseContentDescription = savedstate.baseContentDescription;
        t();
    }

    static void a(ExpandableImageViewPager expandableimageviewpager, float f1, boolean flag)
    {
        expandableimageviewpager.a(f1, flag);
    }

    static void a(ExpandableImageViewPager expandableimageviewpager, int i1)
    {
        expandableimageviewpager.k(i1);
    }

    static void a(ExpandableImageViewPager expandableimageviewpager, Float float1, boolean flag)
    {
        expandableimageviewpager.a(float1, flag);
    }

    private void a(Float float1, boolean flag)
    {
        final int desiredScrollAmount = 0;
        c();
        if (flag && float1 == null)
        {
            q.a(TAG, "A fling velocity was not specified when snapping in a fling gesture. Aborting animation.");
        } else
        {
            y();
            int i1 = mLayoutManager.i();
            View view = mLayoutManager.c(i1);
            if (view == null)
            {
                q.a(TAG, "First visible is null");
                return;
            }
            int j1 = view.getLeft();
            final int targetPosition = a(i1, j1, float1, flag);
            if (targetPosition == 0)
            {
                desiredScrollAmount = f(0);
            } else
            if (targetPosition == getLastPosition())
            {
                desiredScrollAmount = f(getLastPosition());
            }
            desiredScrollAmount = ((targetPosition - i1) * getViewWidth() + j1) - desiredScrollAmount;
            if (desiredScrollAmount != 0)
            {
                float1 = new android.support.v7.widget.RecyclerView.p() {

                    final ExpandableImageViewPager this$0;
                    final int val$desiredScrollAmount;
                    final int val$targetPosition;

                    protected void a(int k1, int l1, android.support.v7.widget.RecyclerView.q q1, android.support.v7.widget.RecyclerView.p.a a1)
                    {
                    }

                    protected void a(View view1, android.support.v7.widget.RecyclerView.q q1, android.support.v7.widget.RecyclerView.p.a a1)
                    {
                        a1.a(desiredScrollAmount);
                        a1.b(500);
                    }

                    protected void e()
                    {
                    }

                    protected void f()
                    {
                        postDelayed(new Runnable() {

                            final _cls6 this$1;

                            public void run()
                            {
                                ExpandableImageViewPager.a(_fld0, targetPosition);
                            }

            
            {
                this$1 = _cls6.this;
                super();
            }
                        }, 100L);
                    }

            
            {
                this$0 = ExpandableImageViewPager.this;
                targetPosition = i1;
                desiredScrollAmount = j1;
                super();
            }
                };
                float1.a(targetPosition);
                mLayoutManager.a(float1);
                return;
            }
        }
    }

    static boolean a(ExpandableImageViewPager expandableimageviewpager, boolean flag)
    {
        expandableimageviewpager.mIsAnimatingLeftEdge = flag;
        return flag;
    }

    static float b(ExpandableImageViewPager expandableimageviewpager)
    {
        return expandableimageviewpager.mViewWidthFractionMax;
    }

    private int b(int i1, boolean flag)
    {
        if (flag && !mAreEndPagesCentered && i1 == getLastPosition() && e(i1) > mDisplayWidth)
        {
            return mDisplayWidth - getViewWidthMin();
        } else
        {
            return c(i1, flag);
        }
    }

    private void b(SavedState savedstate)
    {
        savedstate.areEndPagesCentered = mAreEndPagesCentered;
        savedstate.expandDisabled = mExpandDisabled;
        savedstate.isCollapsed = mIsCollapsed;
        savedstate.viewWidthFractionCurrent = mViewWidthFractionCurrent;
        savedstate.viewWidthFractionMin = mViewWidthFractionMin;
        savedstate.firstSelectedItem = getFirstSelectedItem();
        savedstate.heightMax = mHeightMax;
        savedstate.heightMin = mHeightMin;
        savedstate.itemsPerPage = mItemsPerPage;
        savedstate.itemsPerPageCurrent = mItemsPerPageCurrent;
        savedstate.bitmapConfig = mBitmapConfig;
        savedstate.baseContentDescription = mBaseContentDescription;
    }

    private void b(boolean flag)
    {
        mAdapter.a(mBitmapConfig);
        mAdapter.f(getViewWidth());
        mAdapter.b(flag);
    }

    static boolean b(ExpandableImageViewPager expandableimageviewpager, boolean flag)
    {
        expandableimageviewpager.mIsAnimatingExpandedState = flag;
        return flag;
    }

    private int c(int i1, boolean flag)
    {
        if (e(i1, flag))
        {
            return getPaddingToCenterFirstItem();
        } else
        {
            return 0;
        }
    }

    static EagerLinearLayoutManager c(ExpandableImageViewPager expandableimageviewpager)
    {
        return expandableimageviewpager.mLayoutManager;
    }

    private void c(boolean flag)
    {
        if (flag)
        {
            mItemsPerPageCurrent = mItemsPerPage;
            return;
        } else
        {
            mItemsPerPageCurrent = 1;
            return;
        }
    }

    private int d(int i1, boolean flag)
    {
        if (!flag || i1 == 0)
        {
            return 0;
        } else
        {
            return (i1 - getFirstPagePagingOffset()) % mItemsPerPage;
        }
    }

    static boolean d(ExpandableImageViewPager expandableimageviewpager)
    {
        return expandableimageviewpager.mAreEndPagesCentered;
    }

    private int e(int i1)
    {
        return (i1 + 1) * getViewWidth();
    }

    private boolean e(int i1, boolean flag)
    {
        boolean flag1 = true;
        if (!flag || !mAreEndPagesCentered)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (i1 != getLastPosition())
            {
                int j1 = getViewWidthMin() / 2;
                long l1 = Math.round(Math.ceil((float)(mDisplayWidth / j1 / 2) / 2.0F));
                flag = flag1;
                if ((long)i1 > l1)
                {
                    return false;
                }
            }
        }
        return flag;
    }

    static boolean e(ExpandableImageViewPager expandableimageviewpager)
    {
        return expandableimageviewpager.mIsAnimatingExpandedState;
    }

    private int f(int i1)
    {
        return c(i1, mIsCollapsed);
    }

    private int g(int i1)
    {
        int j1 = d(i1, true);
        if (i1 == 0 || i1 == getLastPosition() || j1 != 0)
        {
            i1 = b(i1, true);
        } else
        {
            i1 = 0;
        }
        return Math.round((float)i1 + (float)(j1 * mDisplayWidth) * mViewWidthFractionMin);
    }

    private int getFirstPagePagingOffset()
    {
        return !mAreEndPagesCentered ? 0 : 1;
    }

    private int getLastPosition()
    {
        return mAdapter.a() - 1;
    }

    private int getPaddingToCenterFirstItem()
    {
        float f1 = (float)getViewWidthMin() / 2.0F;
        return Math.round(f1 * ((float)mDisplayWidth / f1 / 2.0F - 1.0F));
    }

    private int h(int i1)
    {
        return d(i1, mIsCollapsed);
    }

    private int i(int i1)
    {
        return i1 - h(i1);
    }

    private boolean j(int i1)
    {
        while (i1 == 0 || (i1 - getFirstPagePagingOffset()) % mItemsPerPageCurrent == 0) 
        {
            return true;
        }
        return false;
    }

    private void k(int i1)
    {
        int j1 = d(i1);
        if (mListener != null)
        {
            mListener.a(i1, j1);
        }
    }

    private void l(int i1)
    {
        boolean flag = false;
        if (mIsAnimatingExpandedState)
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        Object obj = mLayoutManager.c(i1);
        int j1;
        int k1;
        int l1;
        int i2;
        if (mIsCollapsed)
        {
            j1 = mHeightMin;
            i2 = mHeightMax;
            l1 = getPaddingToCenterFirstItem();
            k1 = 0;
        } else
        {
            j1 = mHeightMax;
            i2 = mHeightMin;
            k1 = getPaddingToCenterFirstItem();
            l1 = 0;
        }
        arraylist.add(a(j1, i2, l1, k1));
        if (mIsCollapsed)
        {
            i1 = ((View) (obj)).getLeft();
            j1 = ((flag) ? 1 : 0);
        } else
        {
            j1 = g(i1);
            i1 = 0;
        }
        arraylist.add(a(((View) (obj)), i1, j1));
        obj = new AnimatorSet();
        ((AnimatorSet) (obj)).playTogether(arraylist);
        ((AnimatorSet) (obj)).addListener(new AnimatorListenerAdapter() {

            final ExpandableImageViewPager this$0;

            public void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                if (ExpandableImageViewPager.e(ExpandableImageViewPager.this))
                {
                    requestLayout();
                }
            }

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                com.target.ui.view.ExpandableImageViewPager.b(ExpandableImageViewPager.this, true);
                ExpandableImageViewPager.c(ExpandableImageViewPager.this).a(0);
            }

            
            {
                this$0 = ExpandableImageViewPager.this;
                super();
            }
        });
        ((AnimatorSet) (obj)).setDuration(300L);
        ((AnimatorSet) (obj)).start();
    }

    private void setViewWidthFractionCurrent(float f1)
    {
        a(f1, mIsCollapsed);
    }

    private void u()
    {
        mDisplayWidth = getResources().getDisplayMetrics().widthPixels;
        mAdapter = new b(mData);
        mAdapter.a(this);
        mLayoutManager = new EagerLinearLayoutManager(getContext(), 0, false, 1);
        setAdapter(mAdapter);
        setLayoutManager(mLayoutManager);
        w();
        setClipToPadding(false);
        mBaseContentDescription = getResources().getString(0x7f09016d);
        mFlingDetector = new GestureDetector(getContext(), new android.view.GestureDetector.SimpleOnGestureListener() {

            final ExpandableImageViewPager this$0;

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
            {
                ExpandableImageViewPager.a(ExpandableImageViewPager.this, Float.valueOf(f1), true);
                return true;
            }

            
            {
                this$0 = ExpandableImageViewPager.this;
                super();
            }
        });
    }

    private void v()
    {
        mAdapter.d();
    }

    private void w()
    {
        b(mIsCollapsed);
    }

    private void x()
    {
        mAdapter.a(mBaseContentDescription);
    }

    private void y()
    {
        c(mIsCollapsed);
    }

    private void z()
    {
        if (mIsCollapsed && mAreEndPagesCentered)
        {
            setPadding(getPaddingToCenterFirstItem(), 0, getPaddingToCenterFirstItem(), 0);
            return;
        } else
        {
            setPadding(0, 0, 0, 0);
            return;
        }
    }

    public void a(int i1)
    {
        if (mListener != null)
        {
            mListener.a(i1);
        }
        if (mExpandDisabled)
        {
            return;
        } else
        {
            l(i1);
            return;
        }
    }

    public int d(int i1)
    {
        if (!j(i1))
        {
            q.a(TAG, (new StringBuilder()).append("Attempted to get selectable items for invalid paging position : ").append(i1).toString());
        } else
        if (i1 != 0 || !mIsCollapsed || !mAreEndPagesCentered)
        {
            if (mItemsPerPageCurrent + i1 > mAdapter.a())
            {
                return mAdapter.a() - i1;
            } else
            {
                return mItemsPerPageCurrent;
            }
        }
        return 1;
    }

    public int getFirstSelectedItem()
    {
        if (mLayoutManager.o() == 0)
        {
            if (mFirstSelectedItemSaved != null && mData.size() > mFirstSelectedItemSaved.intValue())
            {
                return mFirstSelectedItemSaved.intValue();
            } else
            {
                return 0;
            }
        } else
        {
            mFirstSelectedItemSaved = null;
            return mLayoutManager.i();
        }
    }

    public int getViewWidth()
    {
        return Math.round((float)mDisplayWidth * mViewWidthFractionCurrent);
    }

    public int getViewWidthMin()
    {
        return Math.round((float)mDisplayWidth * mViewWidthFractionMin);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return getScrollState() == 2 || super.onInterceptTouchEvent(motionevent);
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        boolean flag1 = false;
        super.onLayout(flag, i1, j1, k1, l1);
        if (mAnchorView != null && mDesiredAnchorViewLeftValue != null && mFinalAnchorViewLeftValue != null && mLayoutManager != null)
        {
            i1 = mAnchorView.getLeft();
            j1 = mDesiredAnchorViewLeftValue.intValue();
            mLayoutManager.h(-(i1 - j1));
            if (!mIsAnimatingLeftEdge)
            {
                mIsAnimatingExpandedState = false;
                mFinalAnchorViewLeftValue = null;
                mDesiredAnchorViewLeftValue = null;
                mAnchorView = null;
                flag = flag1;
                if (!mIsCollapsed)
                {
                    flag = true;
                }
                mIsCollapsed = flag;
                mLayoutManager.a(1);
                post(mRefreshCurrentStateRunnable);
                return;
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.a());
        a(parcelable);
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        b(savedstate);
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mFlingDetector.onTouchEvent(motionevent))
        {
            return false;
        }
        motionevent.getActionMasked();
        JVM INSTR tableswitch 1 3: default 44
    //                   1 50
    //                   2 44
    //                   3 50;
           goto _L1 _L2 _L1 _L2
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        if (getScrollState() == 1)
        {
            a(((Float) (null)), false);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void r()
    {
        mData.clear();
        setAdapter(mAdapter);
    }

    public void s()
    {
        k(getFirstSelectedItem());
    }

    public void setBaseContentDescription(String s1)
    {
        mBaseContentDescription = s1;
        x();
    }

    public void setBitmapConfig(android.graphics.Bitmap.Config config)
    {
        mBitmapConfig = config;
    }

    public void setCollapsed(boolean flag)
    {
        mIsCollapsed = flag;
    }

    public void setCollapsedNumberOfItemsPerPage(int i1)
    {
        mItemsPerPage = i1;
    }

    public void setCollapsedViewWidth(float f1)
    {
        mViewWidthFractionMin = f1;
    }

    public void setEndPagesCentered(boolean flag)
    {
        mAreEndPagesCentered = flag;
    }

    public void setHeroImagePlaceholderDrawable(Drawable drawable)
    {
        mAdapter.a(drawable);
    }

    public void setImageUrls(List list)
    {
        mData.clear();
        mData.addAll(list);
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }

    public void setPagerHeightMin(int i1)
    {
        mHeightMin = i1;
    }

    public void setPagingHeightMax(int i1)
    {
        mHeightMax = i1;
    }

    public void t()
    {
        B();
        y();
        w();
        x();
        z();
        A();
        v();
    }

}
