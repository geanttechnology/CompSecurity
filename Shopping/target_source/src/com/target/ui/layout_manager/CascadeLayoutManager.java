// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.layout_manager;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.x;
import android.view.View;
import java.util.Arrays;

// Referenced classes of package com.target.ui.layout_manager:
//            BaseLayoutManager

public class CascadeLayoutManager extends BaseLayoutManager
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i)
            {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        float aspectRatio;
        int baseElementHeight;
        int baseElementWidth;
        int baselineDiff;
        boolean baselineDiffInitialized;
        int columns;
        int itemMarginHorizontal;
        int itemMarginVertical;
        Parcelable superState;

        public Parcelable a()
        {
            return superState;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            byte byte0;
            if (baselineDiffInitialized)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            parcel.writeFloat(aspectRatio);
            parcel.writeInt(baseElementHeight);
            parcel.writeInt(baseElementWidth);
            parcel.writeInt(baselineDiff);
            parcel.writeInt(columns);
            parcel.writeInt(itemMarginHorizontal);
            parcel.writeInt(itemMarginVertical);
            parcel.writeParcelable(superState, 0);
        }


        private SavedState(Parcel parcel)
        {
            boolean flag = true;
            super();
            if (parcel.readByte() != 1)
            {
                flag = false;
            }
            baselineDiffInitialized = flag;
            aspectRatio = parcel.readFloat();
            baseElementHeight = parcel.readInt();
            baseElementWidth = parcel.readInt();
            baselineDiff = parcel.readInt();
            columns = parcel.readInt();
            itemMarginHorizontal = parcel.readInt();
            itemMarginVertical = parcel.readInt();
            superState = parcel.readParcelable(getClass().getClassLoader());
        }


        SavedState(Parcelable parcelable)
        {
            superState = parcelable;
        }
    }

    public static interface a
    {

        public abstract Rect getAdditionalMargins();

        public abstract int getGridHeight();

        public abstract int getGridPositionColumn();

        public abstract int getGridPositionRow();

        public abstract int getGridWidth();
    }

    private class b
    {

        float aspectRatio;
        int baseElementHeight;
        int baseElementWidth;
        int baselineDiff;
        int columns;
        int itemMarginHorizontal;
        int itemMarginVertical;
        final CascadeLayoutManager this$0;

        private b()
        {
            this$0 = CascadeLayoutManager.this;
            super();
        }

    }


    public static final float DEFAULT_ASPECT_RATIO = 1F;
    public static final int DEFAULT_COLUMNS = 3;
    public static final int DEFAULT_MARGIN = 0;
    private static final String INVALID_ASPECT_RATIO = "The aspect ratio must a positive, non-zero number";
    private static final String INVALID_COLUMNS = "The number of columns must be greater than or equal to 1.";
    private static final String INVALID_MARGIN = "The base item margins must be positive";
    private static final boolean LAYOUT_DEBUG = false;
    private static final String NO_HORIZONTAL_RENDERING = "Horizontal rendering is not currently supported.";
    private static final String TAG = com/target/ui/layout_manager/CascadeLayoutManager.getSimpleName();
    private static final String VIEW_ERROR = "CascadeLayoutManager can only be used with views that implements the CascadeElement interface";
    private float mAspectRatio;
    private int mBaseElementHeight;
    private int mBaseElementWidth;
    private int mBaselineDiff;
    private boolean mBaselineDiffInitialized;
    private int mColumns;
    private int mItemMarginHorizontal;
    private int mItemMarginVertical;
    private Point mPoint;
    private Rect mRect;
    private View mSet[];

    public CascadeLayoutManager(Context context)
    {
        this(context, 3, 1.0F, 0, 0);
    }

    public CascadeLayoutManager(Context context, int i, float f, int j, int l)
    {
        super(context, 1, false);
        mBaselineDiffInitialized = false;
        mBaselineDiff = 0;
        mBaseElementWidth = 0;
        mBaseElementHeight = 0;
        mColumns = 3;
        mItemMarginHorizontal = 0;
        mItemMarginVertical = 0;
        mAspectRatio = 1.0F;
        mPoint = new Point();
        mRect = new Rect();
        mSet = new View[mColumns];
        k(i);
        a(f);
        d(j, l);
    }

    private void A()
    {
        if (mBaseElementWidth == 0)
        {
            mBaseElementWidth = (p() - r() - t()) / mColumns;
        }
        if (mBaseElementHeight == 0)
        {
            int i = mItemMarginHorizontal;
            int j = mItemMarginVertical;
            mBaseElementHeight = Math.round((float)(mBaseElementWidth - i * 2) / mAspectRatio) + j * 2;
        }
    }

    private int[] B()
    {
        int ai[] = new int[mColumns];
        int l = d(i());
        int i = 0;
        do
        {
            View view;
label0:
            {
                if (i < mColumns)
                {
                    view = c(l - i);
                    if (view != null)
                    {
                        break label0;
                    }
                }
                return ai;
            }
            a a1 = o(view);
            int i1 = mOrientationHelper.b(view);
            int j1 = a1.getGridPositionColumn();
            for (int j = 0; j < a1.getGridWidth(); j++)
            {
                int k1 = j1 + j;
                if (i1 > ai[k1])
                {
                    ai[k1] = i1;
                }
            }

            i++;
        } while (true);
    }

    private int[] C()
    {
        int ai[] = new int[mColumns];
        int l = d(h());
        int i = 0;
        do
        {
            View view;
label0:
            {
                if (i < mColumns)
                {
                    view = c(l + i);
                    if (view != null)
                    {
                        break label0;
                    }
                }
                return ai;
            }
            a a1 = o(view);
            int i1 = mOrientationHelper.a(view);
            int j1 = a1.getGridPositionColumn();
            int j = 0;
            while (j < a1.getGridWidth()) 
            {
                int k1 = j1 + j;
                if (ai[k1] == 0)
                {
                    ai[k1] = i1;
                } else
                if (i1 < ai[k1])
                {
                    ai[k1] = i1;
                }
                j++;
            }
            i++;
        } while (true);
    }

    private b D()
    {
        A();
        b b1 = new b();
        b1.baseElementHeight = mBaseElementHeight;
        b1.baseElementWidth = mBaseElementWidth;
        b1.baselineDiff = mBaselineDiff;
        b1.columns = mColumns;
        b1.itemMarginHorizontal = mItemMarginHorizontal;
        b1.itemMarginVertical = mItemMarginVertical;
        b1.aspectRatio = mAspectRatio;
        return b1;
    }

    private int E()
    {
        return a(B());
    }

    private int F()
    {
        return a(C());
    }

    private int G()
    {
        return b(B());
    }

    private int a(int ai[])
    {
        int i1 = ai.length;
        int j = 0;
        int i = 0x80000000;
        for (; j < i1; j++)
        {
            int l = ai[j];
            if (l > i && l != 0)
            {
                i = l;
            }
        }

        j = i;
        if (i == 0x80000000)
        {
            j = 0;
        }
        return j;
    }

    private Point a(a a1, b b1)
    {
        mPoint.set(a1.getGridWidth() * b1.baseElementWidth, a1.getGridHeight() * b1.baseElementHeight);
        return mPoint;
    }

    private void a(float f)
    {
        if (Float.compare(f, 0.0F) <= 0)
        {
            throw new IllegalArgumentException("The aspect ratio must a positive, non-zero number");
        } else
        {
            mAspectRatio = f;
            return;
        }
    }

    private void a(Rect rect, View view, BaseLayoutManager.c c1, x x1, b b1)
    {
        boolean flag = true;
        Object obj = o(view);
        int i = ((a) (obj)).getGridPositionColumn();
        int j = ((a) (obj)).getGridPositionRow();
        obj = a(((a) (obj)), b1);
        int l = ((Point) (obj)).x;
        int i1 = ((Point) (obj)).y;
        boolean flag1 = f();
        if (c1.mLayoutDirection != 1)
        {
            flag = false;
        }
        if (flag1 == flag)
        {
            int j1 = p();
            int k1 = t();
            int l1 = b1.baseElementWidth;
            rect.right = (j1 - k1 - (b1.columns - i) * l1) + l;
            rect.left = rect.right - x1.d(view);
        } else
        {
            rect.left = b1.baseElementWidth * i + r();
            rect.right = rect.left + x1.d(view);
        }
        if (c1.mLayoutDirection == -1)
        {
            rect.bottom = (b1.baseElementHeight * j + i1) - b1.baselineDiff;
            rect.top = rect.bottom - i1;
            return;
        } else
        {
            rect.top = b1.baseElementHeight * j - b1.baselineDiff;
            rect.bottom = rect.top + i1;
            return;
        }
    }

    private void a(View view, BaseLayoutManager.c c1, b b1)
    {
        android.support.v7.widget.RecyclerView.i i;
        Rect rect;
        int j;
        if (c1.mItemDirection == 1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        i = (android.support.v7.widget.RecyclerView.i)view.getLayoutParams();
        if (c1.mScrapList == null)
        {
            if (j != 0)
            {
                b(view);
            } else
            {
                b(view, 0);
            }
        } else
        if (j != 0)
        {
            a(view);
        } else
        {
            a(view, 0);
        }
        c1 = o(view);
        rect = c1.getAdditionalMargins();
        i.bottomMargin = b1.itemMarginVertical + rect.bottom;
        i.leftMargin = b1.itemMarginHorizontal + rect.left;
        i.rightMargin = b1.itemMarginHorizontal + rect.right;
        j = b1.itemMarginVertical;
        i.topMargin = rect.top + j;
        c1 = a(((a) (c1)), b1);
        i.width = ((Point) (c1)).x - i.leftMargin - i.rightMargin;
        i.height = ((Point) (c1)).y - i.topMargin - i.bottomMargin;
        a(view, 0, 0);
    }

    private void a(SavedState savedstate)
    {
        g();
        mBaselineDiffInitialized = savedstate.baselineDiffInitialized;
        mAspectRatio = savedstate.aspectRatio;
        mBaseElementHeight = savedstate.baseElementHeight;
        mBaseElementWidth = savedstate.baseElementWidth;
        mBaselineDiff = savedstate.baselineDiff;
        mColumns = savedstate.columns;
        mItemMarginHorizontal = savedstate.itemMarginHorizontal;
        mItemMarginVertical = savedstate.itemMarginVertical;
    }

    private int b(int i)
    {
        if (i == 1)
        {
            if (w() - mLayoutState.mCurrentPosition > mColumns)
            {
                return G();
            } else
            {
                return E();
            }
        } else
        {
            return F();
        }
    }

    private int b(int ai[])
    {
        int i1 = ai.length;
        int j = 0;
        int i = 0x7fffffff;
        for (; j < i1; j++)
        {
            int l = ai[j];
            if (l < i && l != 0)
            {
                i = l;
            }
        }

        j = i;
        if (i == 0x7fffffff)
        {
            j = 0;
        }
        return j;
    }

    private void b(SavedState savedstate)
    {
        g();
        savedstate.baselineDiffInitialized = mBaselineDiffInitialized;
        savedstate.aspectRatio = mAspectRatio;
        savedstate.baseElementHeight = mBaseElementHeight;
        savedstate.baseElementWidth = mBaseElementWidth;
        savedstate.baselineDiff = mBaselineDiff;
        savedstate.columns = mColumns;
        savedstate.itemMarginHorizontal = mItemMarginHorizontal;
        savedstate.itemMarginVertical = mItemMarginVertical;
    }

    private void d(int i, int j)
    {
        if (i < 0 || j < 0)
        {
            throw new IllegalArgumentException("The base item margins must be positive");
        } else
        {
            mItemMarginHorizontal = i;
            mItemMarginVertical = j;
            return;
        }
    }

    private void k(int i)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException("The number of columns must be greater than or equal to 1.");
        }
        mColumns = i;
        if (mSet.length != mColumns)
        {
            mSet = new View[mColumns];
        }
    }

    private a o(View view)
    {
        try
        {
            view = (a)view;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            throw new IllegalStateException("CascadeLayoutManager can only be used with views that implements the CascadeElement interface");
        }
        return view;
    }

    private void p(View view)
    {
        a a1 = o(view);
        int i = mOrientationHelper.a(view);
        mBaselineDiff = a1.getGridPositionRow() * mBaseElementHeight - i;
    }

    protected int a(android.support.v7.widget.RecyclerView.q q)
    {
        if (q.d())
        {
            return mOrientationHelper.f();
        } else
        {
            return mBaseElementHeight;
        }
    }

    public void a(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Horizontal rendering is not currently supported.");
        } else
        {
            super.a(i);
            return;
        }
    }

    protected void a(int i, int j, boolean flag, android.support.v7.widget.RecyclerView.q q)
    {
        byte byte0 = -1;
        boolean flag1 = true;
        mLayoutState.mExtra = a(q);
        mLayoutState.mLayoutDirection = i;
        mLayoutState.mOffset = b(i);
        if (i == 1)
        {
            q = i();
            BaseLayoutManager.c c1 = mLayoutState;
            if (mShouldReverseLayout)
            {
                i = byte0;
            } else
            {
                i = 1;
            }
            c1.mItemDirection = i;
            mLayoutState.mCurrentPosition = d(q) + mLayoutState.mItemDirection;
            i = mLayoutState.mOffset - mOrientationHelper.d();
        } else
        {
            q = h();
            BaseLayoutManager.c c2 = mLayoutState;
            if (mShouldReverseLayout)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = -1;
            }
            c2.mItemDirection = i;
            mLayoutState.mCurrentPosition = d(q) + mLayoutState.mItemDirection;
            i = -mLayoutState.mOffset + mOrientationHelper.c();
        }
        p(q);
        mLayoutState.mAvailable = j;
        if (flag)
        {
            q = mLayoutState;
            q.mAvailable = ((BaseLayoutManager.c) (q)).mAvailable - i;
        }
        mLayoutState.mScrollingOffset = i;
    }

    public void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.a(parcelable.a());
        a(((SavedState) (parcelable)));
    }

    void a(android.support.v7.widget.RecyclerView.m m, android.support.v7.widget.RecyclerView.q q, BaseLayoutManager.c c1, BaseLayoutManager.b b1)
    {
        int j = mColumns;
        int j1 = -1;
        int i1 = 0;
label0:
        do
        {
            View view;
label1:
            {
                if (i1 < mColumns && c1.a(q) && j > 0)
                {
                    view = c1.a(m);
                    if (view != null)
                    {
                        break label1;
                    }
                }
                if (i1 == 0)
                {
                    b1.mFinished = true;
                    return;
                }
                break label0;
            }
            a a1 = o(view);
            j = a1.getGridWidth();
            int k1 = a1.getGridPositionColumn();
            int l1 = a1.getGridPositionRow();
            if (c1.mLayoutDirection == 1)
            {
                j = k1 + j;
            } else
            {
                j = mColumns - k1;
            }
            j = mColumns - j;
            k1 = j1;
            if (j1 < 0)
            {
                k1 = l1;
            }
            if (l1 != k1)
            {
                j = 0;
            }
            mSet[i1] = view;
            i1++;
            j1 = k1;
        } while (true);
        m = D();
        for (int l = 0; l < i1; l++)
        {
            q = mSet[l];
            a(((View) (q)), c1, ((b) (m)));
            mRect.set(0, 0, 0, 0);
            a(mRect, ((View) (q)), c1, mOrientationHelper, ((b) (m)));
            android.support.v7.widget.RecyclerView.i i = (android.support.v7.widget.RecyclerView.i)q.getLayoutParams();
            a(((View) (q)), mRect.left + i.leftMargin, mRect.top + i.topMargin, mRect.right - i.rightMargin, mRect.bottom - i.bottomMargin);
            if (i.c() || i.d())
            {
                b1.mIgnoreConsumed = true;
            }
            b1.mFocusable = b1.mFocusable | q.isFocusable();
        }

        Arrays.fill(mSet, null);
        b1.mConsumed = Math.abs(b(c1.mLayoutDirection) - c1.mOffset);
    }

    protected void b(int i, int j)
    {
        mLayoutState.mAvailable = mOrientationHelper.d() - j;
        Object obj = mLayoutState;
        int l;
        if (mShouldReverseLayout)
        {
            l = -1;
        } else
        {
            l = 1;
        }
        obj.mItemDirection = l;
        mLayoutState.mCurrentPosition = i;
        mLayoutState.mLayoutDirection = 1;
        mLayoutState.mOffset = j;
        mLayoutState.mScrollingOffset = 0x80000000;
        obj = i();
        if (obj != null)
        {
            p(((View) (obj)));
        }
    }

    public boolean b()
    {
        return false;
    }

    protected int c(int i, android.support.v7.widget.RecyclerView.m m, android.support.v7.widget.RecyclerView.q q)
    {
        i = super.c(i, m, q);
        mBaselineDiff = mBaselineDiff + i;
        return i;
    }

    public Parcelable c()
    {
        SavedState savedstate = new SavedState(super.c());
        b(savedstate);
        return savedstate;
    }

    protected void c(int i, int j)
    {
        mLayoutState.mAvailable = j - mOrientationHelper.c();
        mLayoutState.mCurrentPosition = i;
        Object obj = mLayoutState;
        if (mShouldReverseLayout)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        obj.mItemDirection = i;
        mLayoutState.mLayoutDirection = -1;
        mLayoutState.mOffset = j;
        mLayoutState.mScrollingOffset = 0x80000000;
        obj = h();
        if (obj != null)
        {
            p(((View) (obj)));
        }
    }

    public void c(android.support.v7.widget.RecyclerView.m m, android.support.v7.widget.RecyclerView.q q)
    {
        if (!mBaselineDiffInitialized)
        {
            mBaselineDiffInitialized = true;
            mBaselineDiff = -s();
        }
        super.c(m, q);
    }

}
