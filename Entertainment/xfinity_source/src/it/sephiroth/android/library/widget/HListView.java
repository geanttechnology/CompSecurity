// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import java.util.ArrayList;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView, HeaderViewListAdapter

public class HListView extends AbsHListView
{
    private static class ArrowScrollFocusResult
    {

        private int mAmountToScroll;
        private int mSelectedPosition;

        public int getAmountToScroll()
        {
            return mAmountToScroll;
        }

        public int getSelectedPosition()
        {
            return mSelectedPosition;
        }

        void populate(int i, int j)
        {
            mSelectedPosition = i;
            mAmountToScroll = j;
        }

        private ArrowScrollFocusResult()
        {
        }

    }

    public static class FixedViewInfo
    {

        public Object data;
        public boolean isSelectable;
        public View view;

        public FixedViewInfo()
        {
        }
    }

    private class FocusSelector
        implements Runnable
    {

        private int mPosition;
        private int mPositionLeft;
        final HListView this$0;

        public void run()
        {
            setSelectionFromLeft(mPosition, mPositionLeft);
        }

        public FocusSelector setup(int i, int j)
        {
            mPosition = i;
            mPositionLeft = j;
            return this;
        }

        private FocusSelector()
        {
            this$0 = HListView.this;
            super();
        }

    }


    private boolean mAreAllItemsSelectable;
    private final ArrowScrollFocusResult mArrowScrollFocusResult;
    Drawable mDivider;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    int mDividerWidth;
    private FocusSelector mFocusSelector;
    private boolean mFooterDividersEnabled;
    private ArrayList mFooterViewInfos;
    private boolean mHeaderDividersEnabled;
    private ArrayList mHeaderViewInfos;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    int mMeasureWithChild;
    Drawable mOverScrollFooter;
    Drawable mOverScrollHeader;
    private final Rect mTempRect;

    public HListView(Context context)
    {
        this(context, null);
    }

    public HListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, it.sephiroth.android.library.R.attr.hlv_listViewStyle);
    }

    public HListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mHeaderViewInfos = new ArrayList();
        mFooterViewInfos = new ArrayList();
        mAreAllItemsSelectable = true;
        mItemsCanFocus = false;
        mTempRect = new Rect();
        mArrowScrollFocusResult = new ArrowScrollFocusResult();
        TypedArray typedarray = context.getTheme().obtainStyledAttributes(attributeset, it.sephiroth.android.library.R.styleable.HListView, i, 0);
        CharSequence acharsequence[] = null;
        attributeset = null;
        Drawable drawable1 = null;
        Drawable drawable = null;
        i = 0;
        boolean flag1 = true;
        boolean flag = true;
        int j = -1;
        if (typedarray != null)
        {
            acharsequence = typedarray.getTextArray(0);
            attributeset = typedarray.getDrawable(1);
            drawable1 = typedarray.getDrawable(5);
            drawable = typedarray.getDrawable(6);
            i = typedarray.getDimensionPixelSize(2, 0);
            flag1 = typedarray.getBoolean(3, true);
            flag = typedarray.getBoolean(4, true);
            j = typedarray.getInteger(7, -1);
            typedarray.recycle();
        }
        if (acharsequence != null)
        {
            setAdapter(new ArrayAdapter(context, 0x1090003, acharsequence));
        }
        if (attributeset != null)
        {
            setDivider(attributeset);
        }
        if (drawable1 != null)
        {
            setOverscrollHeader(drawable1);
        }
        if (drawable != null)
        {
            setOverscrollFooter(drawable);
        }
        if (i != 0)
        {
            setDividerWidth(i);
        }
        mHeaderDividersEnabled = flag1;
        mFooterDividersEnabled = flag;
        mMeasureWithChild = j;
    }

    private View addViewAfter(View view, int i)
    {
        i++;
        View view1 = obtainView(i, mIsScrap);
        setupChild(view1, i, view.getRight() + mDividerWidth, true, mListPadding.top, false, mIsScrap[0]);
        return view1;
    }

    private View addViewBefore(View view, int i)
    {
        i--;
        View view1 = obtainView(i, mIsScrap);
        setupChild(view1, i, view.getLeft() - mDividerWidth, false, mListPadding.top, false, mIsScrap[0]);
        return view1;
    }

    private void adjustViewsLeftOrRight()
    {
        int l = getChildCount();
        if (l <= 0) goto _L2; else goto _L1
_L1:
        if (mStackFromRight) goto _L4; else goto _L3
_L3:
        int i;
        i = getChildAt(0).getLeft() - mListPadding.left;
        int j = i;
        if (mFirstPosition != 0)
        {
            j = i - mDividerWidth;
        }
        i = j;
        if (j < 0)
        {
            i = 0;
        }
_L6:
        if (i != 0)
        {
            offsetChildrenLeftAndRight(-i);
        }
_L2:
        return;
_L4:
        i = getChildAt(l - 1).getRight() - (getWidth() - mListPadding.right);
        int k = i;
        if (mFirstPosition + l < mItemCount)
        {
            k = i + mDividerWidth;
        }
        i = k;
        if (k > 0)
        {
            i = 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private int amountToScroll(int i, int j)
    {
        int k1 = getWidth() - mListPadding.right;
        int l1 = mListPadding.left;
        int i2 = getChildCount();
        if (i == 130)
        {
            i = i2 - 1;
            if (j != -1)
            {
                i = j - mFirstPosition;
            }
            l1 = mFirstPosition;
            View view = getChildAt(i);
            int k = k1;
            int i1 = k;
            if (l1 + i < mItemCount - 1)
            {
                i1 = k - getArrowScrollPreviewLength();
            }
            if (view.getRight() <= i1)
            {
                return 0;
            }
            if (j != -1 && i1 - view.getLeft() >= getMaxScrollAmount())
            {
                return 0;
            }
            j = view.getRight() - i1;
            i = j;
            if (mFirstPosition + i2 == mItemCount)
            {
                i = Math.min(j, getChildAt(i2 - 1).getRight() - k1);
            }
            return Math.min(i, getMaxScrollAmount());
        }
        i = 0;
        if (j != -1)
        {
            i = j - mFirstPosition;
        }
        k1 = mFirstPosition;
        View view1 = getChildAt(i);
        int l = l1;
        int j1 = l;
        if (k1 + i > 0)
        {
            j1 = l + getArrowScrollPreviewLength();
        }
        if (view1.getLeft() >= j1)
        {
            return 0;
        }
        if (j != -1 && view1.getRight() - j1 >= getMaxScrollAmount())
        {
            return 0;
        }
        j = j1 - view1.getLeft();
        i = j;
        if (mFirstPosition == 0)
        {
            i = Math.min(j, l1 - getChildAt(0).getLeft());
        }
        return Math.min(i, getMaxScrollAmount());
    }

    private int amountToScrollToNewFocus(int i, View view, int j)
    {
        int k = 0;
        view.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view, mTempRect);
        if (i == 33)
        {
            i = k;
            if (mTempRect.left < mListPadding.left)
            {
                k = mListPadding.left - mTempRect.left;
                i = k;
                if (j > 0)
                {
                    i = k + getArrowScrollPreviewLength();
                }
            }
        } else
        {
            int i1 = getWidth() - mListPadding.right;
            i = k;
            if (mTempRect.bottom > i1)
            {
                int l = mTempRect.right - i1;
                i = l;
                if (j < mItemCount - 1)
                {
                    return l + getArrowScrollPreviewLength();
                }
            }
        }
        return i;
    }

    private ArrowScrollFocusResult arrowScrollFocused(int i)
    {
        View view = getSelectedView();
        if (view != null && view.hasFocus())
        {
            view = view.findFocus();
            view = FocusFinder.getInstance().findNextFocus(this, view, i);
        } else
        {
            if (i == 130)
            {
                int l;
                if (mFirstPosition > 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                l = mListPadding.left;
                if (j != 0)
                {
                    j = getArrowScrollPreviewLength();
                } else
                {
                    j = 0;
                }
                j = l + j;
                if (view != null && view.getLeft() > j)
                {
                    j = view.getLeft();
                }
                mTempRect.set(j, 0, j, 0);
            } else
            {
                int i1;
                int k1;
                if ((mFirstPosition + getChildCount()) - 1 < mItemCount)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                i1 = getWidth();
                k1 = mListPadding.right;
                if (j != 0)
                {
                    j = getArrowScrollPreviewLength();
                } else
                {
                    j = 0;
                }
                j = i1 - k1 - j;
                if (view != null && view.getRight() < j)
                {
                    j = view.getRight();
                }
                mTempRect.set(j, 0, j, 0);
            }
            view = FocusFinder.getInstance().findNextFocusFromRect(this, mTempRect, i);
        }
        if (view != null)
        {
            int j = positionOfNewFocus(view);
            if (mSelectedPosition != -1 && j != mSelectedPosition)
            {
                int k = lookForSelectablePositionOnScreen(i);
                if (k != -1 && (i == 130 && k < j || i == 33 && k > j))
                {
                    return null;
                }
            }
            int j1 = amountToScrollToNewFocus(i, view, j);
            int l1 = getMaxScrollAmount();
            if (j1 < l1)
            {
                view.requestFocus(i);
                mArrowScrollFocusResult.populate(j, j1);
                return mArrowScrollFocusResult;
            }
            if (distanceToView(view) < l1)
            {
                view.requestFocus(i);
                mArrowScrollFocusResult.populate(j, l1);
                return mArrowScrollFocusResult;
            }
        }
        return null;
    }

    private boolean arrowScrollImpl(int i)
    {
        if (getChildCount() > 0)
        {
            View view1 = getSelectedView();
            int l = mSelectedPosition;
            int j = lookForSelectablePositionOnScreen(i);
            int k = amountToScroll(i, j);
            View view;
            Object obj;
            boolean flag;
            if (mItemsCanFocus)
            {
                obj = arrowScrollFocused(i);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                j = ((ArrowScrollFocusResult) (obj)).getSelectedPosition();
                k = ((ArrowScrollFocusResult) (obj)).getAmountToScroll();
            }
            if (obj != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view = view1;
            if (j != -1)
            {
                boolean flag1;
                if (obj != null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                handleNewSelectionChange(view1, i, j, flag1);
                setSelectedPositionInt(j);
                setNextSelectedPositionInt(j);
                view = getSelectedView();
                l = j;
                if (mItemsCanFocus && obj == null)
                {
                    View view2 = getFocusedChild();
                    if (view2 != null)
                    {
                        view2.clearFocus();
                    }
                }
                flag = true;
                checkSelectionChanged();
            }
            if (k > 0)
            {
                if (i != 33)
                {
                    k = -k;
                }
                scrollListItemsBy(k);
                flag = true;
            }
            if (mItemsCanFocus && obj == null && view != null && view.hasFocus())
            {
                obj = view.findFocus();
                if (!isViewAncestorOf(((View) (obj)), this) || distanceToView(((View) (obj))) > 0)
                {
                    ((View) (obj)).clearFocus();
                }
            }
            obj = view;
            if (j == -1)
            {
                obj = view;
                if (view != null)
                {
                    obj = view;
                    if (!isViewAncestorOf(view, this))
                    {
                        obj = null;
                        hideSelector();
                        mResurrectToPosition = -1;
                    }
                }
            }
            if (flag)
            {
                if (obj != null)
                {
                    positionSelector(l, ((View) (obj)));
                    mSelectedLeft = ((View) (obj)).getLeft();
                }
                if (!awakenScrollBars())
                {
                    invalidate();
                }
                invokeOnItemScrollListener();
                return true;
            }
        }
        return false;
    }

    private void clearRecycledState(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                AbsHListView.LayoutParams layoutparams = (AbsHListView.LayoutParams)((FixedViewInfo)arraylist.get(i)).view.getLayoutParams();
                if (layoutparams != null)
                {
                    layoutparams.recycledHeaderFooter = false;
                }
            }

        }
    }

    private boolean commonKey(int i, int j, KeyEvent keyevent)
    {
        if (mAdapter != null && mIsAttached) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (mDataChanged)
        {
            layoutChildren();
        }
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L1; else goto _L3
_L3:
        int k;
        int j1;
        boolean flag;
        boolean flag1;
        flag1 = false;
        j1 = keyevent.getAction();
        flag = flag1;
        k = j;
        if (j1 == 1) goto _L5; else goto _L4
_L4:
        i;
        JVM INSTR lookupswitch 11: default 156
    //                   19: 170
    //                   20: 284
    //                   21: 400
    //                   22: 428
    //                   23: 456
    //                   62: 529
    //                   66: 456
    //                   92: 595
    //                   93: 679
    //                   122: 765
    //                   123: 810;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L11 _L13 _L14 _L15 _L16
_L6:
        k = j;
        flag = flag1;
_L5:
        if (flag)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L7:
        if (keyevent.hasNoModifiers())
        {
            flag1 = resurrectSelectionIfNeeded();
            flag = flag1;
            k = j;
            if (flag1)
            {
                continue; /* Loop/switch isn't completed */
            }
            do
            {
                int l = j - 1;
                flag = flag1;
                k = l;
                if (j <= 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                flag = flag1;
                k = l;
                if (!arrowScroll(33))
                {
                    continue; /* Loop/switch isn't completed */
                }
                flag1 = true;
                j = l;
            } while (true);
        }
        flag = flag1;
        k = j;
        if (keyevent.hasModifiers(2))
        {
            if (resurrectSelectionIfNeeded() || fullScroll(33))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = j;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (keyevent.hasNoModifiers())
        {
            flag1 = resurrectSelectionIfNeeded();
            flag = flag1;
            k = j;
            if (flag1)
            {
                continue; /* Loop/switch isn't completed */
            }
            do
            {
                int i1 = j - 1;
                flag = flag1;
                k = i1;
                if (j <= 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                flag = flag1;
                k = i1;
                if (!arrowScroll(130))
                {
                    continue; /* Loop/switch isn't completed */
                }
                flag1 = true;
                j = i1;
            } while (true);
        }
        flag = flag1;
        k = j;
        if (keyevent.hasModifiers(2))
        {
            if (resurrectSelectionIfNeeded() || fullScroll(130))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = j;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        flag = flag1;
        k = j;
        if (keyevent.hasNoModifiers())
        {
            flag = handleHorizontalFocusWithinListItem(17);
            k = j;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        flag = flag1;
        k = j;
        if (keyevent.hasNoModifiers())
        {
            flag = handleHorizontalFocusWithinListItem(66);
            k = j;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        flag = flag1;
        k = j;
        if (keyevent.hasNoModifiers())
        {
            flag1 = resurrectSelectionIfNeeded();
            flag = flag1;
            k = j;
            if (!flag1)
            {
                flag = flag1;
                k = j;
                if (keyevent.getRepeatCount() == 0)
                {
                    flag = flag1;
                    k = j;
                    if (getChildCount() > 0)
                    {
                        keyPressed();
                        flag = true;
                        k = j;
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (keyevent.hasNoModifiers())
        {
            if (!resurrectSelectionIfNeeded() && !pageScroll(130));
        } else
        if (keyevent.hasModifiers(1) && (!resurrectSelectionIfNeeded() && !pageScroll(33)));
        flag = true;
        k = j;
        continue; /* Loop/switch isn't completed */
_L13:
        if (keyevent.hasNoModifiers())
        {
            if (resurrectSelectionIfNeeded() || pageScroll(33))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = j;
        } else
        {
            flag = flag1;
            k = j;
            if (keyevent.hasModifiers(2))
            {
                if (resurrectSelectionIfNeeded() || fullScroll(33))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                k = j;
            }
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (keyevent.hasNoModifiers())
        {
            if (resurrectSelectionIfNeeded() || pageScroll(130))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = j;
        } else
        {
            flag = flag1;
            k = j;
            if (keyevent.hasModifiers(2))
            {
                if (resurrectSelectionIfNeeded() || fullScroll(130))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                k = j;
            }
        }
        continue; /* Loop/switch isn't completed */
_L15:
        flag = flag1;
        k = j;
        if (keyevent.hasNoModifiers())
        {
            if (resurrectSelectionIfNeeded() || fullScroll(33))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = j;
        }
        continue; /* Loop/switch isn't completed */
_L16:
        flag = flag1;
        k = j;
        if (keyevent.hasNoModifiers())
        {
            if (resurrectSelectionIfNeeded() || fullScroll(130))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = j;
        }
        if (true) goto _L5; else goto _L17
_L17:
        switch (j1)
        {
        default:
            return false;

        case 0: // '\0'
            return super.onKeyDown(i, keyevent);

        case 1: // '\001'
            return super.onKeyUp(i, keyevent);

        case 2: // '\002'
            return super.onKeyMultiple(i, k, keyevent);
        }
    }

    private void correctTooSmall(int i)
    {
        if (mFirstPosition == 0 && i > 0)
        {
            int j = getChildAt(0).getLeft();
            int l = mListPadding.left;
            int k = getRight() - getLeft() - mListPadding.right;
            j -= l;
            View view = getChildAt(i - 1);
            l = view.getRight();
            int i1 = (mFirstPosition + i) - 1;
            if (j > 0)
            {
                if (i1 < mItemCount - 1 || l > k)
                {
                    i = j;
                    if (i1 == mItemCount - 1)
                    {
                        i = Math.min(j, l - k);
                    }
                    offsetChildrenLeftAndRight(-i);
                    if (i1 < mItemCount - 1)
                    {
                        fillRight(i1 + 1, view.getRight() + mDividerWidth);
                        adjustViewsLeftOrRight();
                    }
                } else
                if (i1 == mItemCount - 1)
                {
                    adjustViewsLeftOrRight();
                    return;
                }
            }
        }
    }

    private void correctTooWide(int i)
    {
        if ((mFirstPosition + i) - 1 == mItemCount - 1 && i > 0)
        {
            i = getChildAt(i - 1).getRight();
            int j = getRight() - getLeft() - mListPadding.right - i;
            View view = getChildAt(0);
            int k = view.getLeft();
            if (j > 0 && (mFirstPosition > 0 || k < mListPadding.top))
            {
                i = j;
                if (mFirstPosition == 0)
                {
                    i = Math.min(j, mListPadding.top - k);
                }
                offsetChildrenLeftAndRight(i);
                if (mFirstPosition > 0)
                {
                    fillLeft(mFirstPosition - 1, view.getLeft() - mDividerWidth);
                    adjustViewsLeftOrRight();
                }
            }
        }
    }

    private int distanceToView(View view)
    {
        int i = 0;
        view.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(view, mTempRect);
        int j = getRight() - getLeft() - mListPadding.right;
        if (mTempRect.right < mListPadding.left)
        {
            i = mListPadding.left - mTempRect.right;
        } else
        if (mTempRect.left > j)
        {
            return mTempRect.left - j;
        }
        return i;
    }

    private void fillBeforeAndAfter(View view, int i)
    {
        int j = mDividerWidth;
        if (!mStackFromRight)
        {
            fillLeft(i - 1, view.getLeft() - j);
            adjustViewsLeftOrRight();
            fillRight(i + 1, view.getRight() + j);
            return;
        } else
        {
            fillRight(i + 1, view.getRight() + j);
            adjustViewsLeftOrRight();
            fillLeft(i - 1, view.getLeft() - j);
            return;
        }
    }

    private View fillFromLeft(int i)
    {
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        if (mFirstPosition < 0)
        {
            mFirstPosition = 0;
        }
        return fillRight(mFirstPosition, i);
    }

    private View fillFromMiddle(int i, int j)
    {
        j -= i;
        int k = reconcileSelectedPosition();
        View view = makeAndAddView(k, i, true, mListPadding.top, true);
        mFirstPosition = k;
        i = view.getMeasuredWidth();
        if (i <= j)
        {
            view.offsetLeftAndRight((j - i) / 2);
        }
        fillBeforeAndAfter(view, k);
        if (!mStackFromRight)
        {
            correctTooWide(getChildCount());
            return view;
        } else
        {
            correctTooSmall(getChildCount());
            return view;
        }
    }

    private View fillFromSelection(int i, int j, int k)
    {
        int i1 = getHorizontalFadingEdgeLength();
        int l = mSelectedPosition;
        j = getLeftSelectionPixel(j, i1, l);
        k = getRightSelectionPixel(k, i1, l);
        View view = makeAndAddView(l, i, true, mListPadding.top, true);
        if (view.getRight() > k)
        {
            view.offsetLeftAndRight(-Math.min(view.getLeft() - j, view.getRight() - k));
        } else
        if (view.getLeft() < j)
        {
            view.offsetLeftAndRight(Math.min(j - view.getLeft(), k - view.getRight()));
        }
        fillBeforeAndAfter(view, l);
        if (!mStackFromRight)
        {
            correctTooWide(getChildCount());
            return view;
        } else
        {
            correctTooSmall(getChildCount());
            return view;
        }
    }

    private View fillLeft(int i, int j)
    {
        View view = null;
        while (j > 0 && i >= 0) 
        {
            View view1;
            boolean flag;
            if (i == mSelectedPosition)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view1 = makeAndAddView(i, j, false, mListPadding.top, flag);
            j = view1.getLeft() - mDividerWidth;
            if (flag)
            {
                view = view1;
            }
            i--;
        }
        mFirstPosition = i + 1;
        setVisibleRangeHint(mFirstPosition, (mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private View fillRight(int i, int j)
    {
        View view = null;
        int k = getRight();
        int l = getLeft();
        while (j < k - l && i < mItemCount) 
        {
            View view1;
            boolean flag;
            if (i == mSelectedPosition)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view1 = makeAndAddView(i, j, true, mListPadding.top, flag);
            j = view1.getRight() + mDividerWidth;
            if (flag)
            {
                view = view1;
            }
            i++;
        }
        setVisibleRangeHint(mFirstPosition, (mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private View fillSpecific(int i, int j)
    {
        View view;
        View view1;
        View view6;
        View view2;
        View view4;
        boolean flag;
        if (i == mSelectedPosition)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view6 = makeAndAddView(i, j, true, mListPadding.top, flag);
        mFirstPosition = i;
        j = mDividerWidth;
        if (mStackFromRight) goto _L2; else goto _L1
_L1:
        view2 = fillLeft(i - 1, view6.getLeft() - j);
        adjustViewsLeftOrRight();
        view4 = fillRight(i + 1, view6.getRight() + j);
        i = getChildCount();
        view = view4;
        view1 = view2;
        if (i > 0)
        {
            correctTooWide(i);
            view1 = view2;
            view = view4;
        }
_L4:
        if (flag)
        {
            return view6;
        }
        break; /* Loop/switch isn't completed */
_L2:
        View view3 = fillRight(i + 1, view6.getRight() + j);
        adjustViewsLeftOrRight();
        View view5 = fillLeft(i - 1, view6.getLeft() - j);
        i = getChildCount();
        view = view3;
        view1 = view5;
        if (i > 0)
        {
            correctTooSmall(i);
            view = view3;
            view1 = view5;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (view1 != null)
        {
            return view1;
        } else
        {
            return view;
        }
    }

    private int getArrowScrollPreviewLength()
    {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int getLeftSelectionPixel(int i, int j, int k)
    {
        int l = i;
        if (k > 0)
        {
            l = i + j;
        }
        return l;
    }

    private int getRightSelectionPixel(int i, int j, int k)
    {
        int l = i;
        if (k != mItemCount - 1)
        {
            l = i - j;
        }
        return l;
    }

    private boolean handleHorizontalFocusWithinListItem(int i)
    {
        if (i != 17 && i != 66)
        {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
        }
        int j = getChildCount();
        if (mItemsCanFocus && j > 0 && mSelectedPosition != -1)
        {
            View view1 = getSelectedView();
            if (view1 != null && view1.hasFocus() && (view1 instanceof ViewGroup))
            {
                View view = view1.findFocus();
                view1 = FocusFinder.getInstance().findNextFocus((ViewGroup)view1, view, i);
                if (view1 != null)
                {
                    view.getFocusedRect(mTempRect);
                    offsetDescendantRectToMyCoords(view, mTempRect);
                    offsetRectIntoDescendantCoords(view1, mTempRect);
                    if (view1.requestFocus(i, mTempRect))
                    {
                        return true;
                    }
                }
                view = FocusFinder.getInstance().findNextFocus((ViewGroup)getRootView(), view, i);
                if (view != null)
                {
                    return isViewAncestorOf(view, this);
                }
            }
        }
        return false;
    }

    private void handleNewSelectionChange(View view, int i, int j, boolean flag)
    {
        if (j == -1)
        {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        boolean flag1 = false;
        int k = mSelectedPosition - mFirstPosition;
        j -= mFirstPosition;
        View view1;
        int l;
        if (i == 33)
        {
            View view2 = getChildAt(j);
            i = 1;
            view1 = view;
            view = view2;
        } else
        {
            int i1 = j;
            view1 = getChildAt(i1);
            i = ((flag1) ? 1 : 0);
            j = k;
            k = i1;
        }
        l = getChildCount();
        if (view != null)
        {
            boolean flag2;
            if (!flag && i != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            view.setSelected(flag2);
            measureAndAdjustRight(view, j, l);
        }
        if (view1 != null)
        {
            if (!flag && i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view1.setSelected(flag);
            measureAndAdjustRight(view1, k, l);
        }
    }

    private boolean isDirectChildHeaderOrFooter(View view)
    {
        ArrayList arraylist = mHeaderViewInfos;
        int k = arraylist.size();
        for (int i = 0; i < k; i++)
        {
            if (view == ((FixedViewInfo)arraylist.get(i)).view)
            {
                return true;
            }
        }

        arraylist = mFooterViewInfos;
        k = arraylist.size();
        for (int j = 0; j < k; j++)
        {
            if (view == ((FixedViewInfo)arraylist.get(j)).view)
            {
                return true;
            }
        }

        return false;
    }

    private boolean isViewAncestorOf(View view, View view1)
    {
        if (view != view1)
        {
            if (!((view = view.getParent()) instanceof ViewGroup) || !isViewAncestorOf((View)view, view1))
            {
                return false;
            }
        }
        return true;
    }

    private int lookForSelectablePositionOnScreen(int i)
    {
        int k = mFirstPosition;
        if (i != 130) goto _L2; else goto _L1
_L1:
        int j;
        if (mSelectedPosition != -1)
        {
            j = mSelectedPosition + 1;
        } else
        {
            j = k;
        }
        if (j < mAdapter.getCount()) goto _L4; else goto _L3
_L3:
        i = -1;
_L6:
        return i;
_L4:
        ListAdapter listadapter;
        int l;
        i = j;
        if (j < k)
        {
            i = k;
        }
        l = getLastVisiblePosition();
        listadapter = getAdapter();
        j = i;
_L7:
        if (j > l)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        if (!listadapter.isEnabled(j))
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (getChildAt(j - k).getVisibility() == 0) goto _L6; else goto _L5
_L5:
        j++;
          goto _L7
_L2:
        int i1 = (getChildCount() + k) - 1;
        if (mSelectedPosition != -1)
        {
            i = mSelectedPosition - 1;
        } else
        {
            i = (getChildCount() + k) - 1;
        }
        if (i < 0 || i >= mAdapter.getCount())
        {
            return -1;
        }
        j = i;
        if (i > i1)
        {
            j = i1;
        }
        listadapter = getAdapter();
_L11:
        if (j < k) goto _L9; else goto _L8
_L8:
        if (!listadapter.isEnabled(j))
        {
            continue; /* Loop/switch isn't completed */
        }
        i = j;
        if (getChildAt(j - k).getVisibility() == 0) goto _L6; else goto _L10
_L10:
        j--;
          goto _L11
_L9:
        return -1;
    }

    private View makeAndAddView(int i, int j, boolean flag, int k, boolean flag1)
    {
        if (!mDataChanged)
        {
            View view = mRecycler.getActiveView(i);
            if (view != null)
            {
                setupChild(view, i, j, flag, k, flag1, true);
                return view;
            }
        }
        View view1 = obtainView(i, mIsScrap);
        setupChild(view1, i, j, flag, k, flag1, mIsScrap[0]);
        return view1;
    }

    private void measureAndAdjustRight(View view, int i, int j)
    {
        int k = view.getWidth();
        measureItem(view);
        if (view.getMeasuredWidth() != k)
        {
            relayoutMeasuredItem(view);
            int l = view.getMeasuredWidth();
            for (i++; i < j; i++)
            {
                getChildAt(i).offsetLeftAndRight(l - k);
            }

        }
    }

    private void measureItem(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
        }
        int j = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, mListPadding.top + mListPadding.bottom, layoutparams.height);
        int i = layoutparams.width;
        if (i > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i, j);
    }

    private void measureScrapChildWidth(View view, int i, int j)
    {
        AbsHListView.LayoutParams layoutparams1 = (AbsHListView.LayoutParams)view.getLayoutParams();
        AbsHListView.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = (AbsHListView.LayoutParams)generateDefaultLayoutParams();
            view.setLayoutParams(layoutparams);
        }
        layoutparams.viewType = mAdapter.getItemViewType(i);
        layoutparams.forceAdd = true;
        j = ViewGroup.getChildMeasureSpec(j, mListPadding.top + mListPadding.bottom, layoutparams.height);
        i = layoutparams.width;
        if (i > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i, j);
    }

    private View moveSelection(View view, View view1, int i, int j, int k)
    {
        int i1 = getHorizontalFadingEdgeLength();
        int j1 = mSelectedPosition;
        int l = getLeftSelectionPixel(j, i1, j1);
        i1 = getRightSelectionPixel(j, i1, j1);
        if (i > 0)
        {
            view = makeAndAddView(j1 - 1, view.getLeft(), true, mListPadding.top, false);
            i = mDividerWidth;
            view1 = makeAndAddView(j1, view.getRight() + i, true, mListPadding.top, true);
            if (view1.getRight() > i1)
            {
                j1 = view1.getLeft();
                int k1 = view1.getRight();
                j = (k - j) / 2;
                j = Math.min(Math.min(j1 - l, k1 - i1), j);
                view.offsetLeftAndRight(-j);
                view1.offsetLeftAndRight(-j);
            }
            if (!mStackFromRight)
            {
                fillLeft(mSelectedPosition - 2, view1.getLeft() - i);
                adjustViewsLeftOrRight();
                fillRight(mSelectedPosition + 1, view1.getRight() + i);
                return view1;
            } else
            {
                fillRight(mSelectedPosition + 1, view1.getRight() + i);
                adjustViewsLeftOrRight();
                fillLeft(mSelectedPosition - 2, view1.getLeft() - i);
                return view1;
            }
        }
        if (i < 0)
        {
            if (view1 != null)
            {
                view = makeAndAddView(j1, view1.getLeft(), true, mListPadding.top, true);
            } else
            {
                view = makeAndAddView(j1, view.getLeft(), false, mListPadding.top, true);
            }
            if (view.getLeft() < l)
            {
                i = view.getLeft();
                int l1 = view.getRight();
                j = (k - j) / 2;
                view.offsetLeftAndRight(Math.min(Math.min(l - i, i1 - l1), j));
            }
            fillBeforeAndAfter(view, j1);
            return view;
        }
        i = view.getLeft();
        view = makeAndAddView(j1, i, true, mListPadding.top, true);
        if (i < j && view.getRight() < j + 20)
        {
            view.offsetLeftAndRight(j - view.getLeft());
        }
        fillBeforeAndAfter(view, j1);
        return view;
    }

    private int positionOfNewFocus(View view)
    {
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
            if (isViewAncestorOf(view, getChildAt(i)))
            {
                return mFirstPosition + i;
            }
        }

        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private void relayoutMeasuredItem(View view)
    {
        int i = view.getMeasuredWidth();
        int j = view.getMeasuredHeight();
        int k = mListPadding.top;
        int l = view.getLeft();
        view.layout(l, k, l + i, k + j);
    }

    private void scrollListItemsBy(int i)
    {
        offsetChildrenLeftAndRight(i);
        int j = getWidth() - mListPadding.right;
        int k = mListPadding.left;
        AbsHListView.RecycleBin recyclebin = mRecycler;
        if (i < 0)
        {
            i = getChildCount();
            View view = getChildAt(i - 1);
            do
            {
                if (view.getRight() >= j)
                {
                    break;
                }
                int l = (mFirstPosition + i) - 1;
                if (l >= mItemCount - 1)
                {
                    break;
                }
                view = addViewAfter(view, l);
                i++;
            } while (true);
            if (view.getBottom() < j)
            {
                offsetChildrenLeftAndRight(j - view.getRight());
            }
            view = getChildAt(0);
            while (view.getRight() < k) 
            {
                if (recyclebin.shouldRecycleViewType(((AbsHListView.LayoutParams)view.getLayoutParams()).viewType))
                {
                    detachViewFromParent(view);
                    recyclebin.addScrapView(view, mFirstPosition);
                } else
                {
                    removeViewInLayout(view);
                }
                view = getChildAt(0);
                mFirstPosition = mFirstPosition + 1;
            }
        } else
        {
            View view1;
            for (view1 = getChildAt(0); view1.getLeft() > k && mFirstPosition > 0; mFirstPosition = mFirstPosition - 1)
            {
                view1 = addViewBefore(view1, mFirstPosition);
            }

            if (view1.getLeft() > k)
            {
                offsetChildrenLeftAndRight(k - view1.getLeft());
            }
            i = getChildCount() - 1;
            view1 = getChildAt(i);
            while (view1.getLeft() > j) 
            {
                if (recyclebin.shouldRecycleViewType(((AbsHListView.LayoutParams)view1.getLayoutParams()).viewType))
                {
                    detachViewFromParent(view1);
                    recyclebin.addScrapView(view1, mFirstPosition + i);
                } else
                {
                    removeViewInLayout(view1);
                }
                i--;
                view1 = getChildAt(i);
            }
        }
    }

    private void setupChild(View view, int i, int j, boolean flag, int k, boolean flag1, boolean flag2)
    {
        AbsHListView.LayoutParams layoutparams;
        AbsHListView.LayoutParams layoutparams1;
        int l;
        boolean flag3;
        int i1;
        int j1;
        boolean flag4;
        if (flag1 && shouldShowSelector())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 != view.isSelected())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        l = mTouchMode;
        if (l > 0 && l < 3 && mMotionPosition == i)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (flag4 != view.isPressed())
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (!flag2 || i1 != 0 || view.isLayoutRequested())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        layoutparams1 = (AbsHListView.LayoutParams)view.getLayoutParams();
        layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = (AbsHListView.LayoutParams)generateDefaultLayoutParams();
        }
        layoutparams.viewType = mAdapter.getItemViewType(i);
        if (flag2 && !layoutparams.forceAdd || layoutparams.recycledHeaderFooter && layoutparams.viewType == -2)
        {
            byte byte0;
            if (flag)
            {
                byte0 = -1;
            } else
            {
                byte0 = 0;
            }
            attachViewToParent(view, byte0, layoutparams);
        } else
        {
            layoutparams.forceAdd = false;
            if (layoutparams.viewType == -2)
            {
                layoutparams.recycledHeaderFooter = true;
            }
            byte byte1;
            if (flag)
            {
                byte1 = -1;
            } else
            {
                byte1 = 0;
            }
            addViewInLayout(view, byte1, layoutparams, true);
        }
        if (i1 != 0)
        {
            view.setSelected(flag1);
        }
        if (j1 != 0)
        {
            view.setPressed(flag4);
        }
        if (mChoiceMode != 0 && mCheckStates != null)
        {
            if (view instanceof Checkable)
            {
                ((Checkable)view).setChecked(((Boolean)mCheckStates.get(i, Boolean.valueOf(false))).booleanValue());
            } else
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                view.setActivated(((Boolean)mCheckStates.get(i, Boolean.valueOf(false))).booleanValue());
            }
        }
        if (flag3)
        {
            j1 = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, mListPadding.top + mListPadding.bottom, layoutparams.height);
            i1 = layoutparams.width;
            if (i1 > 0)
            {
                i1 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            } else
            {
                i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i1, j1);
        } else
        {
            cleanupLayoutState(view);
        }
        i1 = view.getMeasuredWidth();
        j1 = view.getMeasuredHeight();
        if (!flag)
        {
            j -= i1;
        }
        if (flag3)
        {
            view.layout(j, k, j + i1, k + j1);
        } else
        {
            view.offsetLeftAndRight(j - view.getLeft());
            view.offsetTopAndBottom(k - view.getTop());
        }
        if (mCachingStarted && !view.isDrawingCacheEnabled())
        {
            view.setDrawingCacheEnabled(true);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11 && flag2 && ((AbsHListView.LayoutParams)view.getLayoutParams()).scrappedFromPosition != i)
        {
            view.jumpDrawablesToCurrentState();
        }
    }

    private boolean showingLeftFadingEdge()
    {
        boolean flag = false;
        int i = getScrollX();
        int j = mListPadding.left;
        if (mFirstPosition > 0 || getChildAt(0).getLeft() > i + j)
        {
            flag = true;
        }
        return flag;
    }

    private boolean showingRightFadingEdge()
    {
        int i = getChildCount();
        int j = getChildAt(i - 1).getRight();
        int k = mFirstPosition;
        int l = getScrollX();
        int i1 = getWidth();
        int j1 = mListPadding.right;
        return (k + i) - 1 < mItemCount - 1 || j < (l + i1) - j1;
    }

    public void addHeaderView(View view)
    {
        addHeaderView(view, null, true);
    }

    public void addHeaderView(View view, Object obj, boolean flag)
    {
        if (mAdapter != null && !(mAdapter instanceof HeaderViewListAdapter))
        {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        FixedViewInfo fixedviewinfo = new FixedViewInfo();
        fixedviewinfo.view = view;
        fixedviewinfo.data = obj;
        fixedviewinfo.isSelectable = flag;
        mHeaderViewInfos.add(fixedviewinfo);
        if (mAdapter != null && mDataSetObserver != null)
        {
            mDataSetObserver.onChanged();
        }
    }

    boolean arrowScroll(int i)
    {
        boolean flag;
        mInLayout = true;
        flag = arrowScrollImpl(i);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        mInLayout = false;
        return flag;
        Exception exception;
        exception;
        mInLayout = false;
        throw exception;
    }

    protected boolean canAnimate()
    {
        return super.canAnimate() && mItemCount > 0;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        Drawable drawable;
        Drawable drawable1;
        Rect rect;
        ListAdapter listadapter;
        Paint paint;
        int i;
        boolean flag;
        int k;
        boolean flag1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if (mCachingStarted)
        {
            mCachingActive = true;
        }
        l1 = mDividerWidth;
        drawable = mOverScrollHeader;
        drawable1 = mOverScrollFooter;
        boolean flag2;
        int j1;
        if (drawable != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (drawable1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (l1 > 0 && mDivider != null)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (k == 0 && i == 0 && !flag) goto _L2; else goto _L1
_L1:
        rect = mTempRect;
        rect.top = getPaddingTop();
        rect.bottom = getBottom() - getTop() - getPaddingBottom();
        i2 = getChildCount();
        k2 = mHeaderViewInfos.size();
        j3 = mItemCount;
        l2 = j3 - mFooterViewInfos.size() - 1;
        flag3 = mHeaderDividersEnabled;
        flag4 = mFooterDividersEnabled;
        j2 = mFirstPosition;
        flag5 = mAreAllItemsSelectable;
        listadapter = mAdapter;
        if (isOpaque() && !super.isOpaque())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 && mDividerPaint == null && mIsCacheColorOpaque)
        {
            mDividerPaint = new Paint();
            mDividerPaint.setColor(getCacheColorHint());
        }
        paint = mDividerPaint;
        i3 = (getRight() - getLeft() - 0) + getScrollX();
        if (mStackFromRight) goto _L4; else goto _L3
_L3:
        flag2 = false;
        j1 = getScrollX();
        if (i2 <= 0 || j1 >= 0) goto _L6; else goto _L5
_L5:
        if (i == 0) goto _L8; else goto _L7
_L7:
        rect.right = 0;
        rect.left = j1;
        drawOverscrollHeader(canvas, drawable, rect);
          goto _L6
_L8:
        if (k != 0)
        {
            rect.right = 0;
            rect.left = -l1;
            drawDivider(canvas, rect, -1);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        j1 = 0;
        i = ((flag2) ? 1 : 0);
label0:
        do
        {
label1:
            {
                if (j1 >= i2)
                {
                    break label0;
                }
                int l;
                if (!flag3)
                {
                    l = i;
                    if (j2 + j1 < k2)
                    {
                        break label1;
                    }
                }
                if (!flag4)
                {
                    l = i;
                    if (j2 + j1 >= l2)
                    {
                        break label1;
                    }
                }
                i = getChildAt(j1).getRight();
                l = i;
                if (k == 0)
                {
                    break label1;
                }
                l = i;
                if (i >= i3)
                {
                    break label1;
                }
                if (flag)
                {
                    l = i;
                    if (j1 == i2 - 1)
                    {
                        break label1;
                    }
                }
                if (flag5 || listadapter.isEnabled(j2 + j1) && (j1 == i2 - 1 || listadapter.isEnabled(j2 + j1 + 1)))
                {
                    rect.left = i;
                    rect.right = i + l1;
                    drawDivider(canvas, rect, j1);
                    l = i;
                } else
                {
                    l = i;
                    if (flag1)
                    {
                        rect.left = i;
                        rect.right = i + l1;
                        canvas.drawRect(rect, paint);
                        l = i;
                    }
                }
            }
            j1++;
            i = l;
        } while (true);
        k = getRight() + getScrollX();
        if (flag && j2 + i2 == j3 && k > i)
        {
            rect.left = i;
            rect.right = k;
            drawOverscrollFooter(canvas, drawable1, rect);
        }
_L2:
        super.dispatchDraw(canvas);
        return;
_L4:
        int i1 = getScrollX();
        if (i2 > 0 && i != 0)
        {
            rect.left = i1;
            rect.right = getChildAt(0).getLeft();
            drawOverscrollHeader(canvas, drawable, rect);
        }
        if (i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        while (i < i2) 
        {
            if (!flag3 && j2 + i < k2 || !flag4 && j2 + i >= l2)
            {
                continue;
            }
            int k1 = getChildAt(i).getLeft();
            if (k1 > 0)
            {
                if (flag5 || listadapter.isEnabled(j2 + i) && (i == i2 - 1 || listadapter.isEnabled(j2 + i + 1)))
                {
                    rect.left = k1 - l1;
                    rect.right = k1;
                    drawDivider(canvas, rect, i - 1);
                } else
                if (flag1)
                {
                    rect.left = k1 - l1;
                    rect.right = k1;
                    canvas.drawRect(rect, paint);
                }
            }
            i++;
        }
        if (i2 > 0 && i1 > 0)
        {
            if (flag)
            {
                int j = getRight();
                rect.left = j;
                rect.right = j + i1;
                drawOverscrollFooter(canvas, drawable1, rect);
            } else
            if (k != 0)
            {
                rect.left = i3;
                rect.right = i3 + l1;
                drawDivider(canvas, rect, -1);
            }
        }
        if (true) goto _L2; else goto _L9
_L9:
        if (true) goto _L6; else goto _L10
_L10:
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        boolean flag1 = super.dispatchKeyEvent(keyevent);
        boolean flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (getFocusedChild() != null)
            {
                flag = flag1;
                if (keyevent.getAction() == 0)
                {
                    flag = onKeyDown(keyevent.getKeyCode(), keyevent);
                }
            }
        }
        return flag;
    }

    protected boolean drawChild(Canvas canvas, View view, long l)
    {
        boolean flag = super.drawChild(canvas, view, l);
        if (mCachingActive)
        {
            mCachingActive = false;
        }
        return flag;
    }

    void drawDivider(Canvas canvas, Rect rect, int i)
    {
        Drawable drawable = mDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect)
    {
        int i = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < i)
        {
            rect.right = rect.left + i;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect)
    {
        int i = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < i)
        {
            rect.left = rect.right - i;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    protected void fillGap(boolean flag)
    {
        int k = getChildCount();
        if (flag)
        {
            int i;
            if (k > 0)
            {
                i = getChildAt(k - 1).getRight() + mDividerWidth;
            } else
            {
                i = 0;
            }
            fillRight(mFirstPosition + k, i);
            correctTooWide(getChildCount());
            return;
        }
        int j;
        if (k > 0)
        {
            j = getChildAt(0).getLeft() - mDividerWidth;
        } else
        {
            j = getWidth() - 0;
        }
        fillLeft(mFirstPosition - 1, j);
        correctTooSmall(getChildCount());
    }

    protected int findMotionCol(int i)
    {
        int l = getChildCount();
        if (l > 0)
        {
            if (!mStackFromRight)
            {
                for (int j = 0; j < l; j++)
                {
                    if (i <= getChildAt(j).getRight())
                    {
                        return mFirstPosition + j;
                    }
                }

            } else
            {
                for (int k = l - 1; k >= 0; k--)
                {
                    if (i >= getChildAt(k).getLeft())
                    {
                        return mFirstPosition + k;
                    }
                }

            }
        }
        return -1;
    }

    boolean fullScroll(int i)
    {
        boolean flag1 = false;
        if (i != 33) goto _L2; else goto _L1
_L1:
        boolean flag;
        flag = flag1;
        if (mSelectedPosition != 0)
        {
            i = lookForSelectablePosition(0, true);
            if (i >= 0)
            {
                mLayoutMode = 1;
                setSelectionInt(i);
                invokeOnItemScrollListener();
            }
            flag = true;
        }
_L4:
        if (flag && !awakenScrollBars())
        {
            awakenScrollBars();
            invalidate();
        }
        return flag;
_L2:
        flag = flag1;
        if (i == 130)
        {
            flag = flag1;
            if (mSelectedPosition < mItemCount - 1)
            {
                i = lookForSelectablePosition(mItemCount - 1, true);
                if (i >= 0)
                {
                    mLayoutMode = 3;
                    setSelectionInt(i);
                    invokeOnItemScrollListener();
                }
                flag = true;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return mAdapter;
    }

    public long[] getCheckItemIds()
    {
        Object obj;
        if (mAdapter != null && mAdapter.hasStableIds())
        {
            obj = getCheckedItemIds();
        } else
        if (mChoiceMode != 0 && mCheckStates != null && mAdapter != null)
        {
            obj = mCheckStates;
            int l = ((SparseArrayCompat) (obj)).size();
            long al1[] = new long[l];
            ListAdapter listadapter = mAdapter;
            int j = 0;
            int i = 0;
            for (; j < l; j++)
            {
                if (((Boolean)((SparseArrayCompat) (obj)).valueAt(j)).booleanValue())
                {
                    int k = i + 1;
                    al1[i] = listadapter.getItemId(((SparseArrayCompat) (obj)).keyAt(j));
                    i = k;
                }
            }

            obj = al1;
            if (i != l)
            {
                long al[] = new long[i];
                System.arraycopy(al1, 0, al, 0, i);
                return al;
            }
        } else
        {
            return new long[0];
        }
        return ((long []) (obj));
    }

    public Drawable getDivider()
    {
        return mDivider;
    }

    public int getDividerWidth()
    {
        return mDividerWidth;
    }

    public int getFooterViewsCount()
    {
        return mFooterViewInfos.size();
    }

    public int getHeaderViewsCount()
    {
        return mHeaderViewInfos.size();
    }

    public boolean getItemsCanFocus()
    {
        return mItemsCanFocus;
    }

    public int getMaxScrollAmount()
    {
        return (int)(0.33F * (float)(getRight() - getLeft()));
    }

    public Drawable getOverscrollFooter()
    {
        return mOverScrollFooter;
    }

    public Drawable getOverscrollHeader()
    {
        return mOverScrollHeader;
    }

    public boolean isOpaque()
    {
        boolean flag;
        boolean flag1;
        View view;
        if (mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque || super.isOpaque())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (!flag) goto _L2; else goto _L1
_L1:
        int i;
        if (mListPadding != null)
        {
            i = mListPadding.left;
        } else
        {
            i = getPaddingLeft();
        }
        view = getChildAt(0);
        if (view != null && view.getLeft() <= i) goto _L4; else goto _L3
_L3:
        flag1 = false;
_L2:
        return flag1;
_L4:
        int k = getWidth();
        View view1;
        int j;
        if (mListPadding != null)
        {
            j = mListPadding.right;
        } else
        {
            j = getPaddingRight();
        }
        view1 = getChildAt(getChildCount() - 1);
        if (view1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        if (view1.getRight() >= k - j) goto _L2; else goto _L5
_L5:
        return false;
    }

    protected void layoutChildren()
    {
        boolean flag = mBlockLayoutRequests;
        if (flag) goto _L2; else goto _L1
_L1:
        mBlockLayoutRequests = true;
        super.layoutChildren();
        invalidate();
        if (mAdapter != null) goto _L4; else goto _L3
_L3:
        resetList();
        invokeOnItemScrollListener();
        if (!flag)
        {
            mBlockLayoutRequests = false;
        }
_L2:
        return;
_L4:
        int j;
        int i1;
        int j1;
        j = mListPadding.left;
        i1 = getRight() - getLeft() - mListPadding.right;
        j1 = getChildCount();
        Object obj;
        View view;
        View view1;
        View view2;
        View view3;
        View view4;
        View view5;
        Object obj1;
        AbsHListView.RecycleBin recyclebin;
        int i;
        int k;
        int l;
        l = 0;
        k = 0;
        obj1 = null;
        view5 = null;
        view = null;
        recyclebin = null;
        view1 = null;
        view4 = null;
        view3 = obj1;
        obj = recyclebin;
        i = l;
        view2 = view;
        mLayoutMode;
        JVM INSTR tableswitch 1 5: default 1203
    //                   1 238
    //                   2 279
    //                   3 238
    //                   4 238
    //                   5 238;
           goto _L5 _L6 _L7 _L6 _L6 _L6
_L5:
        l = mSelectedPosition - mFirstPosition;
        view = view5;
        if (l < 0)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        view = view5;
        if (l >= j1)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        view = getChildAt(l);
        view2 = getChildAt(0);
        i = k;
        if (mNextSelectedPosition >= 0)
        {
            i = mNextSelectedPosition - mSelectedPosition;
        }
        obj = getChildAt(l + i);
        view3 = view;
_L6:
        boolean flag1 = mDataChanged;
        if (!flag1) goto _L9; else goto _L8
_L8:
        handleDataChanged();
_L9:
        if (mItemCount != 0) goto _L11; else goto _L10
_L10:
        resetList();
        invokeOnItemScrollListener();
        if (flag) goto _L2; else goto _L12
_L12:
        mBlockLayoutRequests = false;
        return;
_L7:
        k = mNextSelectedPosition - mFirstPosition;
        view3 = obj1;
        obj = recyclebin;
        i = l;
        view2 = view;
        if (k < 0) goto _L6; else goto _L13
_L13:
        view3 = obj1;
        obj = recyclebin;
        i = l;
        view2 = view;
        if (k >= j1) goto _L6; else goto _L14
_L14:
        obj = getChildAt(k);
        view3 = obj1;
        i = l;
        view2 = view;
          goto _L6
_L11:
        if (mItemCount != mAdapter.getCount())
        {
            throw new IllegalStateException((new StringBuilder()).append("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(").append(getId()).append(", ").append(getClass()).append(") with Adapter(").append(mAdapter.getClass()).append(")]").toString());
        }
          goto _L15
        obj;
        if (!flag)
        {
            mBlockLayoutRequests = false;
        }
        throw obj;
_L15:
        setSelectedPositionInt(mNextSelectedPosition);
        l = mFirstPosition;
        recyclebin = mRecycler;
        view = null;
        obj1 = null;
        if (!flag1) goto _L17; else goto _L16
_L16:
        k = 0;
_L19:
        if (k >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        recyclebin.addScrapView(getChildAt(k), l + k);
        k++;
        if (true) goto _L19; else goto _L18
_L17:
        recyclebin.fillActiveViews(j1, l);
_L18:
        view5 = getFocusedChild();
        if (view5 == null) goto _L21; else goto _L20
_L20:
        if (!flag1) goto _L23; else goto _L22
_L22:
        view = obj1;
        view1 = view4;
        if (!isDirectChildHeaderOrFooter(view5))
        {
            break MISSING_BLOCK_LABEL_583;
        }
_L23:
        view4 = view5;
        view5 = findFocus();
        view = view4;
        view1 = view5;
        if (view5 == null)
        {
            break MISSING_BLOCK_LABEL_583;
        }
        view5.onStartTemporaryDetach();
        view1 = view5;
        view = view4;
        requestFocus();
_L21:
        detachAllViewsFromParent();
        recyclebin.removeSkippedScrap();
        mLayoutMode;
        JVM INSTR tableswitch 1 6: default 1206
    //                   1 914
    //                   2 846
    //                   3 894
    //                   4 933
    //                   5 878
    //                   6 949;
           goto _L24 _L25 _L26 _L27 _L28 _L29 _L30
_L24:
        if (j1 != 0) goto _L32; else goto _L31
_L31:
        if (mStackFromRight) goto _L34; else goto _L33
_L33:
        setSelectedPositionInt(lookForSelectablePosition(0, true));
        obj = fillFromLeft(j);
_L51:
        recyclebin.scrapActiveViews();
        if (obj == null) goto _L36; else goto _L35
_L35:
        if (!mItemsCanFocus || !hasFocus() || ((View) (obj)).hasFocus()) goto _L38; else goto _L37
_L37:
        if (obj != view || view1 == null) goto _L40; else goto _L39
_L39:
        if (view1.requestFocus()) goto _L41; else goto _L40
_L40:
        if (!((View) (obj)).requestFocus()) goto _L42; else goto _L41
_L67:
        if (i != 0) goto _L44; else goto _L43
_L43:
        view = getFocusedChild();
        if (view == null) goto _L46; else goto _L45
_L45:
        view.clearFocus();
_L46:
        positionSelector(-1, ((View) (obj)));
_L60:
        mSelectedLeft = ((View) (obj)).getLeft();
_L66:
        if (view1 == null) goto _L48; else goto _L47
_L47:
        if (view1.getWindowToken() != null)
        {
            view1.onFinishTemporaryDetach();
        }
_L48:
        mLayoutMode = 0;
        mDataChanged = false;
        if (mPositionScrollAfterLayout != null)
        {
            post(mPositionScrollAfterLayout);
            mPositionScrollAfterLayout = null;
        }
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
        updateScrollIndicators();
        if (mItemCount > 0)
        {
            checkSelectionChanged();
        }
        invokeOnItemScrollListener();
        if (!flag)
        {
            mBlockLayoutRequests = false;
            return;
        }
          goto _L2
_L26:
        if (obj == null) goto _L50; else goto _L49
_L49:
        obj = fillFromSelection(((View) (obj)).getLeft(), j, i1);
          goto _L51
_L50:
        obj = fillFromMiddle(j, i1);
          goto _L51
_L29:
        obj = fillSpecific(mSyncPosition, mSpecificLeft);
          goto _L51
_L27:
        obj = fillLeft(mItemCount - 1, i1);
        adjustViewsLeftOrRight();
          goto _L51
_L25:
        mFirstPosition = 0;
        obj = fillFromLeft(j);
        adjustViewsLeftOrRight();
          goto _L51
_L28:
        obj = fillSpecific(reconcileSelectedPosition(), mSpecificLeft);
          goto _L51
_L30:
        obj = moveSelection(view3, ((View) (obj)), i, j, i1);
          goto _L51
_L34:
        setSelectedPositionInt(lookForSelectablePosition(mItemCount - 1, false));
        obj = fillLeft(mItemCount - 1, i1);
          goto _L51
_L32:
        if (mSelectedPosition < 0 || mSelectedPosition >= mItemCount) goto _L53; else goto _L52
_L52:
        i = mSelectedPosition;
        if (view3 != null) goto _L55; else goto _L54
_L54:
        obj = fillSpecific(i, j);
          goto _L51
_L55:
        j = view3.getLeft();
          goto _L54
_L53:
        if (mFirstPosition >= mItemCount) goto _L57; else goto _L56
_L56:
        i = mFirstPosition;
        if (view2 != null) goto _L59; else goto _L58
_L58:
        obj = fillSpecific(i, j);
          goto _L51
_L59:
        j = view2.getLeft();
          goto _L58
_L57:
        obj = fillSpecific(0, j);
          goto _L51
_L44:
        ((View) (obj)).setSelected(false);
        mSelectorRect.setEmpty();
          goto _L60
_L38:
        positionSelector(-1, ((View) (obj)));
          goto _L60
_L36:
        if (mTouchMode <= 0 || mTouchMode >= 3) goto _L62; else goto _L61
_L61:
        obj = getChildAt(mMotionPosition - mFirstPosition);
        if (obj == null) goto _L64; else goto _L63
_L63:
        positionSelector(mMotionPosition, ((View) (obj)));
_L64:
        if (!hasFocus() || view1 == null) goto _L66; else goto _L65
_L65:
        view1.requestFocus();
          goto _L66
_L62:
        mSelectedLeft = 0;
        mSelectorRect.setEmpty();
          goto _L64
_L41:
        i = 1;
          goto _L67
_L42:
        i = 0;
          goto _L67
    }

    protected int lookForSelectablePosition(int i, boolean flag)
    {
        ListAdapter listadapter = mAdapter;
        if (listadapter != null && !isInTouchMode()) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int j;
        int k;
        k = listadapter.getCount();
        if (mAreAllItemsSelectable)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (flag)
        {
            i = Math.max(0, i);
            do
            {
                j = i;
                if (i >= k)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j = i;
                if (listadapter.isEnabled(i))
                {
                    continue; /* Loop/switch isn't completed */
                }
                i++;
            } while (true);
        }
        i = Math.min(i, k - 1);
        do
        {
            j = i;
            if (i < 0)
            {
                break;
            }
            j = i;
            if (listadapter.isEnabled(i))
            {
                break;
            }
            i--;
        } while (true);
        if (j < 0 || j >= k) goto _L1; else goto _L3
_L3:
        return j;
        if (i < 0 || i >= k) goto _L1; else goto _L4
_L4:
        return i;
    }

    final int measureWidthOfChildren(int i, int j, int k, int l, int i1)
    {
        Object obj = mAdapter;
        if (obj != null) goto _L2; else goto _L1
_L1:
        j = mListPadding.left + mListPadding.right;
_L4:
        return j;
_L2:
        int i2 = mListPadding.left + mListPadding.right;
        boolean aflag[];
        int j1;
        int k1;
        int l1;
        boolean flag;
        boolean flag1;
        if (mDividerWidth > 0 && mDivider != null)
        {
            j1 = mDividerWidth;
        } else
        {
            j1 = 0;
        }
        flag = false;
        k1 = k;
        if (k == -1)
        {
            k1 = ((ListAdapter) (obj)).getCount() - 1;
        }
        obj = mRecycler;
        flag1 = recycleOnMeasure();
        aflag = mIsScrap;
        l1 = j;
        k = i2;
        int j2;
        for (j = ((flag) ? 1 : 0); l1 <= k1; j = j2)
        {
            View view = obtainView(l1, aflag);
            measureScrapChildWidth(view, l1, i);
            j2 = k;
            if (l1 > 0)
            {
                j2 = k + j1;
            }
            if (flag1 && ((AbsHListView.RecycleBin) (obj)).shouldRecycleViewType(((AbsHListView.LayoutParams)view.getLayoutParams()).viewType))
            {
                ((AbsHListView.RecycleBin) (obj)).addScrapView(view, -1);
            }
            k = j2 + view.getMeasuredWidth();
            if (k >= l)
            {
                if (i1 < 0 || l1 <= i1 || j <= 0 || k == l)
                {
                    return l;
                }
                continue; /* Loop/switch isn't completed */
            }
            j2 = j;
            if (i1 >= 0)
            {
                j2 = j;
                if (l1 >= i1)
                {
                    j2 = k;
                }
            }
            l1++;
        }

        return k;
        if (true) goto _L4; else goto _L3
_L3:
    }

    final int[] measureWithLargeChildren(int i, int j, int k, int l, int i1, int j1)
    {
        Object obj = mAdapter;
        if (obj == null)
        {
            return (new int[] {
                mListPadding.left + mListPadding.right, mListPadding.top + mListPadding.bottom
            });
        }
        int i2 = mListPadding.left;
        int j2 = mListPadding.right;
        int k2 = mListPadding.top;
        int l2 = mListPadding.bottom;
        boolean aflag[];
        int k1;
        int l1;
        boolean flag;
        boolean flag1;
        if (mDividerWidth > 0 && mDivider != null)
        {
            j1 = mDividerWidth;
        } else
        {
            j1 = 0;
        }
        l1 = 0;
        flag = false;
        k1 = k;
        if (k == -1)
        {
            k1 = ((ListAdapter) (obj)).getCount() - 1;
        }
        obj = mRecycler;
        flag1 = recycleOnMeasure();
        aflag = mIsScrap;
        k = ((flag) ? 1 : 0);
        for (; j <= k1; j++)
        {
            View view = obtainView(j, aflag);
            measureScrapChildWidth(view, j, i);
            if (flag1 && ((AbsHListView.RecycleBin) (obj)).shouldRecycleViewType(((AbsHListView.LayoutParams)view.getLayoutParams()).viewType))
            {
                ((AbsHListView.RecycleBin) (obj)).addScrapView(view, -1);
            }
            l1 = Math.max(l1, view.getMeasuredWidth() + j1);
            k = Math.max(k, view.getMeasuredHeight());
        }

        return (new int[] {
            Math.min(i2 + j2 + l1, l), Math.min(k2 + l2 + k, i1)
        });
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        int j = getChildCount();
        if (j > 0)
        {
            for (int i = 0; i < j; i++)
            {
                addHeaderView(getChildAt(i));
            }

            removeAllViews();
        }
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        ListAdapter listadapter = mAdapter;
        int k = -1;
        boolean flag1 = false;
        int l = 0;
        int j1 = ((flag1) ? 1 : 0);
        int k1 = k;
        if (listadapter != null)
        {
            j1 = ((flag1) ? 1 : 0);
            k1 = k;
            if (flag)
            {
                j1 = ((flag1) ? 1 : 0);
                k1 = k;
                if (rect != null)
                {
                    rect.offset(getScrollX(), getScrollY());
                    if (listadapter.getCount() < getChildCount() + mFirstPosition)
                    {
                        mLayoutMode = 0;
                        layoutChildren();
                    }
                    Rect rect1 = mTempRect;
                    int i1 = 0x7fffffff;
                    int l1 = getChildCount();
                    int i2 = mFirstPosition;
                    int j = 0;
                    do
                    {
                        j1 = l;
                        k1 = k;
                        if (j >= l1)
                        {
                            break;
                        }
                        if (!listadapter.isEnabled(i2 + j))
                        {
                            j1 = i1;
                        } else
                        {
                            View view = getChildAt(j);
                            view.getDrawingRect(rect1);
                            offsetDescendantRectToMyCoords(view, rect1);
                            k1 = getDistance(rect, rect1, i);
                            j1 = i1;
                            if (k1 < i1)
                            {
                                j1 = k1;
                                k = j;
                                l = view.getLeft();
                            }
                        }
                        j++;
                        i1 = j1;
                    } while (true);
                }
            }
        }
        if (k1 >= 0)
        {
            setSelectionFromLeft(mFirstPosition + k1, j1);
            return;
        } else
        {
            requestLayout();
            return;
        }
    }

    public void onGlobalLayout()
    {
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(it/sephiroth/android/library/widget/HListView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(it/sephiroth/android/library/widget/HListView.getName());
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return commonKey(i, 1, keyevent);
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent)
    {
        return commonKey(i, j, keyevent);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        return commonKey(i, 1, keyevent);
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        int j1;
        int k1;
        int k2;
label0:
        {
            super.onMeasure(i, j);
            int j2 = android.view.View.MeasureSpec.getMode(i);
            k2 = android.view.View.MeasureSpec.getMode(j);
            j1 = android.view.View.MeasureSpec.getSize(i);
            k1 = android.view.View.MeasureSpec.getSize(j);
            int l1 = 0;
            int i2 = 0;
            boolean flag1 = false;
            boolean flag = false;
            View view;
            int l;
            int i1;
            if (mAdapter == null)
            {
                i = 0;
            } else
            {
                i = mAdapter.getCount();
            }
            mItemCount = i;
            i1 = i2;
            k = ((flag1) ? 1 : 0);
            l = l1;
            if (mItemCount <= 0)
            {
                break label0;
            }
            if (j2 != 0)
            {
                i1 = i2;
                k = ((flag1) ? 1 : 0);
                l = l1;
                if (k2 != 0)
                {
                    break label0;
                }
            }
            view = obtainView(0, mIsScrap);
            measureScrapChildWidth(view, 0, j);
            l1 = view.getMeasuredWidth();
            i2 = view.getMeasuredHeight();
            i = ((flag) ? 1 : 0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                i = combineMeasuredStates(0, view.getMeasuredState());
            }
            i1 = i2;
            k = i;
            l = l1;
            if (recycleOnMeasure())
            {
                i1 = i2;
                k = i;
                l = l1;
                if (mRecycler.shouldRecycleViewType(((AbsHListView.LayoutParams)view.getLayoutParams()).viewType))
                {
                    mRecycler.addScrapView(view, -1);
                    l = l1;
                    k = i;
                    i1 = i2;
                }
            }
        }
        if (k2 != 0) goto _L2; else goto _L1
_L1:
        i = mListPadding.top + mListPadding.bottom + i1 + getHorizontalScrollbarHeight();
_L4:
        k = j1;
        if (j2 == 0)
        {
            k = mListPadding.left + mListPadding.right + l + getHorizontalFadingEdgeLength() * 2;
        }
        l = k;
        if (j2 == 0x80000000)
        {
            l = measureWidthOfChildren(j, 0, -1, k, -1);
        }
        setMeasuredDimension(l, i);
        mHeightMeasureSpec = j;
        return;
_L2:
        if (k2 == 0x80000000 && mItemCount > 0 && mMeasureWithChild > -1)
        {
            i = measureWithLargeChildren(j, mMeasureWithChild, mMeasureWithChild, j1, k1, -1)[1];
        } else
        {
            i = k1;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                i = k1 | 0xff000000 & k;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if (getChildCount() > 0)
        {
            View view = getFocusedChild();
            if (view != null)
            {
                int i1 = mFirstPosition;
                int j1 = indexOfChild(view);
                int k1 = Math.max(0, view.getRight() - (i - getPaddingLeft()));
                int l1 = view.getLeft();
                if (mFocusSelector == null)
                {
                    mFocusSelector = new FocusSelector();
                }
                post(mFocusSelector.setup(i1 + j1, l1 - k1));
            }
        }
        super.onSizeChanged(i, j, k, l);
    }

    boolean pageScroll(int i)
    {
        int j;
        boolean flag;
        j = -1;
        flag = false;
        if (i != 33) goto _L2; else goto _L1
_L1:
        j = Math.max(0, mSelectedPosition - getChildCount() - 1);
_L4:
        if (j >= 0)
        {
            i = lookForSelectablePosition(j, flag);
            if (i >= 0)
            {
                mLayoutMode = 4;
                mSpecificLeft = getPaddingLeft() + getHorizontalFadingEdgeLength();
                if (flag && i > mItemCount - getChildCount())
                {
                    mLayoutMode = 3;
                }
                if (!flag && i < getChildCount())
                {
                    mLayoutMode = 1;
                }
                setSelectionInt(i);
                invokeOnItemScrollListener();
                if (!awakenScrollBars())
                {
                    invalidate();
                }
                return true;
            }
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (i == 130)
        {
            j = Math.min(mItemCount - 1, (mSelectedPosition + getChildCount()) - 1);
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    protected boolean recycleOnMeasure()
    {
        return true;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        int i;
        int j;
        int i1;
        int j1;
label0:
        {
            int k1 = rect.left;
            rect.offset(view.getLeft(), view.getTop());
            rect.offset(-view.getScrollX(), -view.getScrollY());
            j1 = getWidth();
            int k = getScrollX();
            i = k + j1;
            i1 = getHorizontalFadingEdgeLength();
            j = k;
            if (!showingLeftFadingEdge())
            {
                break label0;
            }
            if (mSelectedPosition <= 0)
            {
                j = k;
                if (k1 <= i1)
                {
                    break label0;
                }
            }
            j = k + i1;
        }
        int l;
        int l1;
label1:
        {
            l1 = getChildAt(getChildCount() - 1).getRight();
            l = i;
            if (!showingRightFadingEdge())
            {
                break label1;
            }
            if (mSelectedPosition >= mItemCount - 1)
            {
                l = i;
                if (rect.right >= l1 - i1)
                {
                    break label1;
                }
            }
            l = i - i1;
        }
        i1 = 0;
        if (rect.right > l && rect.left > j)
        {
            if (rect.width() > j1)
            {
                i = 0 + (rect.left - j);
            } else
            {
                i = 0 + (rect.right - l);
            }
            i = Math.min(i, l1 - l);
        } else
        {
            i = i1;
            if (rect.left < j)
            {
                i = i1;
                if (rect.right < l)
                {
                    if (rect.width() > j1)
                    {
                        i = 0 - (l - rect.right);
                    } else
                    {
                        i = 0 - (j - rect.left);
                    }
                    i = Math.max(i, getChildAt(0).getLeft() - j);
                }
            }
        }
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            scrollListItemsBy(-i);
            positionSelector(-1, view);
            mSelectedLeft = view.getTop();
            invalidate();
        }
        return flag;
    }

    protected void resetList()
    {
        clearRecycledState(mHeaderViewInfos);
        clearRecycledState(mFooterViewInfos);
        super.resetList();
        mLayoutMode = 0;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mAdapter != null && mDataSetObserver != null)
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }
        resetList();
        mRecycler.clear();
        if (mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0)
        {
            mAdapter = new HeaderViewListAdapter(mHeaderViewInfos, mFooterViewInfos, listadapter);
        } else
        {
            mAdapter = listadapter;
        }
        mOldSelectedPosition = -1;
        mOldSelectedColId = 0x8000000000000000L;
        super.setAdapter(listadapter);
        if (mAdapter != null)
        {
            mAreAllItemsSelectable = mAdapter.areAllItemsEnabled();
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            checkFocus();
            mDataSetObserver = new AbsHListView.AdapterDataSetObserver(this);
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());
            int i;
            if (mStackFromRight)
            {
                i = lookForSelectablePosition(mItemCount - 1, false);
            } else
            {
                i = lookForSelectablePosition(0, true);
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (mItemCount == 0)
            {
                checkSelectionChanged();
            }
        } else
        {
            mAreAllItemsSelectable = true;
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setCacheColorHint(int i)
    {
        boolean flag;
        if (i >>> 24 == 255)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsCacheColorOpaque = flag;
        if (flag)
        {
            if (mDividerPaint == null)
            {
                mDividerPaint = new Paint();
            }
            mDividerPaint.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setDivider(Drawable drawable)
    {
        boolean flag = false;
        if (drawable != null)
        {
            mDividerWidth = drawable.getIntrinsicWidth();
        } else
        {
            mDividerWidth = 0;
        }
        mDivider = drawable;
        if (drawable == null || drawable.getOpacity() == -1)
        {
            flag = true;
        }
        mDividerIsOpaque = flag;
        requestLayout();
        invalidate();
    }

    public void setDividerWidth(int i)
    {
        mDividerWidth = i;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean flag)
    {
        mFooterDividersEnabled = flag;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean flag)
    {
        mHeaderDividersEnabled = flag;
        invalidate();
    }

    public void setItemsCanFocus(boolean flag)
    {
        mItemsCanFocus = flag;
        if (!flag)
        {
            setDescendantFocusability(0x60000);
        }
    }

    public void setOverscrollFooter(Drawable drawable)
    {
        mOverScrollFooter = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable)
    {
        mOverScrollHeader = drawable;
        if (getScrollX() < 0)
        {
            invalidate();
        }
    }

    public void setSelection(int i)
    {
        setSelectionFromLeft(i, 0);
    }

    public void setSelectionFromLeft(int i, int j)
    {
        if (mAdapter != null)
        {
            if (!isInTouchMode())
            {
                int k = lookForSelectablePosition(i, true);
                i = k;
                if (k >= 0)
                {
                    setNextSelectedPositionInt(k);
                    i = k;
                }
            } else
            {
                mResurrectToPosition = i;
            }
            if (i >= 0)
            {
                mLayoutMode = 4;
                mSpecificLeft = mListPadding.left + j;
                if (mNeedSync)
                {
                    mSyncPosition = i;
                    mSyncColId = mAdapter.getItemId(i);
                }
                if (mPositionScroller != null)
                {
                    mPositionScroller.stop();
                }
                requestLayout();
                return;
            }
        }
    }

    public void setSelectionInt(int i)
    {
        boolean flag;
        boolean flag1;
        int j;
        setNextSelectedPositionInt(i);
        flag1 = false;
        j = mSelectedPosition;
        flag = flag1;
        if (j < 0) goto _L2; else goto _L1
_L1:
        if (i != j - 1) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        if (mPositionScroller != null)
        {
            mPositionScroller.stop();
        }
        layoutChildren();
        if (flag)
        {
            awakenScrollBars();
        }
        return;
_L4:
        flag = flag1;
        if (i == j + 1)
        {
            flag = true;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
