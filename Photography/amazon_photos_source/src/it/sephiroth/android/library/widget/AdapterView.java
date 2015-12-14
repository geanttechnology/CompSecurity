// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;

public abstract class AdapterView extends ViewGroup
{
    public static class AdapterContextMenuInfo
        implements android.view.ContextMenu.ContextMenuInfo
    {

        public long id;
        public int position;
        public View targetView;

        public AdapterContextMenuInfo(View view, int i, long l)
        {
            targetView = view;
            position = i;
            id = l;
        }
    }

    class AdapterDataSetObserver extends DataSetObserver
    {

        private Parcelable mInstanceState;
        final AdapterView this$0;

        public void clearSavedState()
        {
            mInstanceState = null;
        }

        public void onChanged()
        {
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = getAdapter().getCount();
            if (getAdapter().hasStableIds() && mInstanceState != null && mOldItemCount == 0 && mItemCount > 0)
            {
                onRestoreInstanceState(mInstanceState);
                mInstanceState = null;
            } else
            {
                rememberSyncState();
            }
            checkFocus();
            requestLayout();
        }

        public void onInvalidated()
        {
            mDataChanged = true;
            if (getAdapter().hasStableIds())
            {
                mInstanceState = onSaveInstanceState();
            }
            mOldItemCount = mItemCount;
            mItemCount = 0;
            mSelectedPosition = -1;
            mSelectedColId = 0x8000000000000000L;
            mNextSelectedPosition = -1;
            mNextSelectedColId = 0x8000000000000000L;
            mNeedSync = false;
            checkFocus();
            requestLayout();
        }

        AdapterDataSetObserver()
        {
            this$0 = AdapterView.this;
            super();
            mInstanceState = null;
        }
    }

    public static interface OnItemClickListener
    {

        public abstract void onItemClick(AdapterView adapterview, View view, int i, long l);
    }

    public static interface OnItemLongClickListener
    {

        public abstract boolean onItemLongClick(AdapterView adapterview, View view, int i, long l);
    }

    public static interface OnItemSelectedListener
    {

        public abstract void onItemSelected(AdapterView adapterview, View view, int i, long l);

        public abstract void onNothingSelected(AdapterView adapterview);
    }

    private class SelectionNotifier
        implements Runnable
    {

        final AdapterView this$0;

        public void run()
        {
            if (mDataChanged)
            {
                if (getAdapter() != null)
                {
                    post(this);
                }
                return;
            } else
            {
                fireOnSelected();
                performAccessibilityActionsOnSelected();
                return;
            }
        }

        private SelectionNotifier()
        {
            this$0 = AdapterView.this;
            super();
        }

    }


    public static final long INVALID_COL_ID = 0x8000000000000000L;
    public static final int INVALID_POSITION = -1;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "AdapterView";
    static final int SYNC_FIRST_POSITION = 1;
    static final int SYNC_MAX_DURATION_MILLIS = 100;
    static final int SYNC_SELECTED_POSITION = 0;
    AccessibilityManager mAccessibilityManager;
    protected boolean mBlockLayoutRequests;
    public boolean mDataChanged;
    private boolean mDesiredFocusableInTouchModeState;
    private boolean mDesiredFocusableState;
    private View mEmptyView;
    protected int mFirstPosition;
    protected boolean mInLayout;
    protected int mItemCount;
    private int mLayoutWidth;
    protected boolean mNeedSync;
    protected long mNextSelectedColId;
    protected int mNextSelectedPosition;
    protected int mOldItemCount;
    protected long mOldSelectedColId;
    protected int mOldSelectedPosition;
    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;
    OnItemSelectedListener mOnItemSelectedListener;
    protected long mSelectedColId;
    protected int mSelectedPosition;
    private SelectionNotifier mSelectionNotifier;
    protected int mSpecificLeft;
    protected long mSyncColId;
    int mSyncMode;
    protected int mSyncPosition;
    protected long mSyncWidth;

    public AdapterView(Context context)
    {
        super(context);
        mFirstPosition = 0;
        mSyncColId = 0x8000000000000000L;
        mNeedSync = false;
        mInLayout = false;
        mNextSelectedPosition = -1;
        mNextSelectedColId = 0x8000000000000000L;
        mSelectedPosition = -1;
        mSelectedColId = 0x8000000000000000L;
        mOldSelectedPosition = -1;
        mOldSelectedColId = 0x8000000000000000L;
        mBlockLayoutRequests = false;
    }

    public AdapterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFirstPosition = 0;
        mSyncColId = 0x8000000000000000L;
        mNeedSync = false;
        mInLayout = false;
        mNextSelectedPosition = -1;
        mNextSelectedColId = 0x8000000000000000L;
        mSelectedPosition = -1;
        mSelectedColId = 0x8000000000000000L;
        mOldSelectedPosition = -1;
        mOldSelectedColId = 0x8000000000000000L;
        mBlockLayoutRequests = false;
    }

    public AdapterView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFirstPosition = 0;
        mSyncColId = 0x8000000000000000L;
        mNeedSync = false;
        mInLayout = false;
        mNextSelectedPosition = -1;
        mNextSelectedColId = 0x8000000000000000L;
        mSelectedPosition = -1;
        mSelectedColId = 0x8000000000000000L;
        mOldSelectedPosition = -1;
        mOldSelectedColId = 0x8000000000000000L;
        mBlockLayoutRequests = false;
        if (android.os.Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0)
        {
            setImportantForAccessibility(1);
        }
        if (!isInEditMode())
        {
            mAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
        }
    }

    private void fireOnSelected()
    {
        if (mOnItemSelectedListener == null)
        {
            return;
        }
        int i = getSelectedItemPosition();
        if (i >= 0)
        {
            View view = getSelectedView();
            mOnItemSelectedListener.onItemSelected(this, view, i, getAdapter().getItemId(i));
            return;
        } else
        {
            mOnItemSelectedListener.onNothingSelected(this);
            return;
        }
    }

    private boolean isScrollableForAccessibility()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            Adapter adapter = getAdapter();
            flag = flag1;
            if (adapter == null)
            {
                break label0;
            }
            int i = adapter.getCount();
            flag = flag1;
            if (i <= 0)
            {
                break label0;
            }
            if (getFirstVisiblePosition() <= 0)
            {
                flag = flag1;
                if (getLastVisiblePosition() >= i - 1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private void performAccessibilityActionsOnSelected()
    {
        while (!mAccessibilityManager.isEnabled() || getSelectedItemPosition() < 0) 
        {
            return;
        }
        sendAccessibilityEvent(4);
    }

    private void updateEmptyStatus(boolean flag)
    {
        if (isInFilterMode())
        {
            flag = false;
        }
        if (flag)
        {
            if (mEmptyView != null)
            {
                mEmptyView.setVisibility(0);
                setVisibility(8);
            } else
            {
                setVisibility(0);
            }
            if (mDataChanged)
            {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            }
            return;
        }
        if (mEmptyView != null)
        {
            mEmptyView.setVisibility(8);
        }
        setVisibility(0);
    }

    public void addView(View view)
    {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i)
    {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    protected boolean canAnimate()
    {
        return super.canAnimate() && mItemCount > 0;
    }

    protected void checkFocus()
    {
label0:
        {
label1:
            {
                boolean flag2 = false;
                Adapter adapter = getAdapter();
                boolean flag;
                boolean flag1;
                if (adapter == null || adapter.getCount() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag || isInFilterMode())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && mDesiredFocusableInTouchModeState)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                super.setFocusableInTouchMode(flag1);
                if (flag && mDesiredFocusableState)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                super.setFocusable(flag1);
                if (mEmptyView == null)
                {
                    break label0;
                }
                if (adapter != null)
                {
                    flag1 = flag2;
                    if (!adapter.isEmpty())
                    {
                        break label1;
                    }
                }
                flag1 = true;
            }
            updateEmptyStatus(flag1);
        }
    }

    protected void checkSelectionChanged()
    {
        if (mSelectedPosition != mOldSelectedPosition || mSelectedColId != mOldSelectedColId)
        {
            selectionChanged();
            mOldSelectedPosition = mSelectedPosition;
            mOldSelectedColId = mSelectedColId;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        View view = getSelectedView();
        return view != null && view.getVisibility() == 0 && view.dispatchPopulateAccessibilityEvent(accessibilityevent);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        dispatchFreezeSelfOnly(sparsearray);
    }

    int findSyncPosition()
    {
        int i1 = mItemCount;
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        int l = -1;
_L5:
        return l;
_L2:
        Adapter adapter;
        int i;
        boolean flag;
        int j;
        int k;
        long l1;
        long l2;
        l1 = mSyncColId;
        i = mSyncPosition;
        if (l1 == 0x8000000000000000L)
        {
            return -1;
        }
        i = Math.min(i1 - 1, Math.max(0, i));
        l2 = SystemClock.uptimeMillis();
        j = i;
        k = i;
        flag = false;
        adapter = getAdapter();
        if (adapter == null)
        {
            return -1;
        }
          goto _L3
_L7:
        boolean flag1;
        if (flag1 || flag && l == 0)
        {
            k++;
            i = k;
            flag = false;
        } else
        if (l != 0 || !flag && !flag1)
        {
            j--;
            i = j;
            flag = true;
        }
_L3:
        if (SystemClock.uptimeMillis() > l2 + 100L)
        {
            break; /* Loop/switch isn't completed */
        }
        l = i;
        if (adapter.getItemId(i) == l1) goto _L5; else goto _L4
_L4:
        if (k == i1 - 1)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (j == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (l == 0 || !flag1) goto _L7; else goto _L6
_L6:
        return -1;
    }

    public abstract Adapter getAdapter();

    public int getCount()
    {
        return mItemCount;
    }

    public View getEmptyView()
    {
        return mEmptyView;
    }

    public int getFirstVisiblePosition()
    {
        return mFirstPosition;
    }

    public Object getItemAtPosition(int i)
    {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0)
        {
            return null;
        } else
        {
            return adapter.getItem(i);
        }
    }

    public long getItemIdAtPosition(int i)
    {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0)
        {
            return 0x8000000000000000L;
        } else
        {
            return adapter.getItemId(i);
        }
    }

    public int getLastVisiblePosition()
    {
        return (mFirstPosition + getChildCount()) - 1;
    }

    public final OnItemClickListener getOnItemClickListener()
    {
        return mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener()
    {
        return mOnItemLongClickListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener()
    {
        return mOnItemSelectedListener;
    }

    public int getPositionForView(View view)
    {
_L2:
        View view1;
        boolean flag;
        view1 = (View)view.getParent();
        flag = view1.equals(this);
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        view = view1;
        if (true) goto _L2; else goto _L1
        view;
_L4:
        return -1;
_L1:
        int j = getChildCount();
        int i = 0;
        while (i < j) 
        {
            if (getChildAt(i).equals(view))
            {
                return mFirstPosition + i;
            }
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object getSelectedItem()
    {
        Adapter adapter = getAdapter();
        int i = getSelectedItemPosition();
        if (adapter != null && adapter.getCount() > 0 && i >= 0)
        {
            return adapter.getItem(i);
        } else
        {
            return null;
        }
    }

    public long getSelectedItemId()
    {
        return mNextSelectedColId;
    }

    public int getSelectedItemPosition()
    {
        return mNextSelectedPosition;
    }

    public abstract View getSelectedView();

    void handleDataChanged()
    {
        int k = mItemCount;
        int i = 0;
        boolean flag1 = false;
        if (k > 0)
        {
            boolean flag = flag1;
            if (mNeedSync)
            {
                mNeedSync = false;
                i = findSyncPosition();
                flag = flag1;
                if (i >= 0)
                {
                    flag = flag1;
                    if (lookForSelectablePosition(i, true) == i)
                    {
                        setNextSelectedPositionInt(i);
                        flag = true;
                    }
                }
            }
            i = ((flag) ? 1 : 0);
            if (!flag)
            {
                int j = getSelectedItemPosition();
                i = j;
                if (j >= k)
                {
                    i = k - 1;
                }
                j = i;
                if (i < 0)
                {
                    j = 0;
                }
                i = lookForSelectablePosition(j, true);
                k = i;
                if (i < 0)
                {
                    k = lookForSelectablePosition(j, false);
                }
                i = ((flag) ? 1 : 0);
                if (k >= 0)
                {
                    setNextSelectedPositionInt(k);
                    checkSelectionChanged();
                    i = 1;
                }
            }
        }
        if (i == 0)
        {
            mSelectedPosition = -1;
            mSelectedColId = 0x8000000000000000L;
            mNextSelectedPosition = -1;
            mNextSelectedColId = 0x8000000000000000L;
            mNeedSync = false;
            checkSelectionChanged();
        }
    }

    boolean isInFilterMode()
    {
        return false;
    }

    protected int lookForSelectablePosition(int i, boolean flag)
    {
        return i;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(mSelectionNotifier);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(it/sephiroth/android/library/widget/AdapterView.getName());
        accessibilityevent.setScrollable(isScrollableForAccessibility());
        View view = getSelectedView();
        if (view != null)
        {
            accessibilityevent.setEnabled(view.isEnabled());
        }
        accessibilityevent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityevent.setFromIndex(getFirstVisiblePosition());
        accessibilityevent.setToIndex(getLastVisiblePosition());
        accessibilityevent.setItemCount(getCount());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(it/sephiroth/android/library/widget/AdapterView.getName());
        accessibilitynodeinfo.setScrollable(isScrollableForAccessibility());
        View view = getSelectedView();
        if (view != null)
        {
            accessibilitynodeinfo.setEnabled(view.isEnabled());
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        mLayoutWidth = getWidth();
    }

    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
    {
        if (super.onRequestSendAccessibilityEvent(view, accessibilityevent))
        {
            AccessibilityEvent accessibilityevent1 = AccessibilityEvent.obtain();
            onInitializeAccessibilityEvent(accessibilityevent1);
            view.dispatchPopulateAccessibilityEvent(accessibilityevent1);
            accessibilityevent.appendRecord(accessibilityevent1);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean performItemClick(View view, int i, long l)
    {
        boolean flag = false;
        if (mOnItemClickListener != null)
        {
            playSoundEffect(0);
            if (view != null)
            {
                view.sendAccessibilityEvent(1);
            }
            mOnItemClickListener.onItemClick(this, view, i, l);
            flag = true;
        }
        return flag;
    }

    public void rememberSyncState()
    {
label0:
        {
            if (getChildCount() > 0)
            {
                mNeedSync = true;
                mSyncWidth = mLayoutWidth;
                if (mSelectedPosition < 0)
                {
                    break label0;
                }
                View view = getChildAt(mSelectedPosition - mFirstPosition);
                mSyncColId = mNextSelectedColId;
                mSyncPosition = mNextSelectedPosition;
                if (view != null)
                {
                    mSpecificLeft = view.getLeft();
                }
                mSyncMode = 0;
            }
            return;
        }
        View view1 = getChildAt(0);
        Adapter adapter = getAdapter();
        if (mFirstPosition >= 0 && mFirstPosition < adapter.getCount())
        {
            mSyncColId = adapter.getItemId(mFirstPosition);
        } else
        {
            mSyncColId = -1L;
        }
        mSyncPosition = mFirstPosition;
        if (view1 != null)
        {
            mSpecificLeft = view1.getLeft();
        }
        mSyncMode = 1;
    }

    public void removeAllViews()
    {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view)
    {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i)
    {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    void selectionChanged()
    {
label0:
        {
            if (mOnItemSelectedListener != null || mAccessibilityManager.isEnabled())
            {
                if (!mInLayout && !mBlockLayoutRequests)
                {
                    break label0;
                }
                if (mSelectionNotifier == null)
                {
                    mSelectionNotifier = new SelectionNotifier();
                }
                post(mSelectionNotifier);
            }
            return;
        }
        fireOnSelected();
        performAccessibilityActionsOnSelected();
    }

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view)
    {
        boolean flag1 = true;
        mEmptyView = view;
        if (android.os.Build.VERSION.SDK_INT >= 16 && view != null && view.getImportantForAccessibility() == 0)
        {
            view.setImportantForAccessibility(1);
        }
        view = getAdapter();
        boolean flag = flag1;
        if (view != null)
        {
            if (view.isEmpty())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        updateEmptyStatus(flag);
    }

    public void setFocusable(boolean flag)
    {
        boolean flag2 = true;
        Adapter adapter = getAdapter();
        boolean flag1;
        if (adapter == null || adapter.getCount() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mDesiredFocusableState = flag;
        if (!flag)
        {
            mDesiredFocusableInTouchModeState = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = flag2;
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (!isInFilterMode()) goto _L2; else goto _L5
_L5:
        flag = flag2;
_L4:
        super.setFocusable(flag);
        return;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void setFocusableInTouchMode(boolean flag)
    {
        boolean flag2 = true;
        Adapter adapter = getAdapter();
        boolean flag1;
        if (adapter == null || adapter.getCount() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mDesiredFocusableInTouchModeState = flag;
        if (flag)
        {
            mDesiredFocusableState = true;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = flag2;
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (!isInFilterMode()) goto _L2; else goto _L5
_L5:
        flag = flag2;
_L4:
        super.setFocusableInTouchMode(flag);
        return;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void setNextSelectedPositionInt(int i)
    {
        mNextSelectedPosition = i;
        mNextSelectedColId = getItemIdAtPosition(i);
        if (mNeedSync && mSyncMode == 0 && i >= 0)
        {
            mSyncPosition = i;
            mSyncColId = mNextSelectedColId;
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(OnItemClickListener onitemclicklistener)
    {
        mOnItemClickListener = onitemclicklistener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onitemlongclicklistener)
    {
        if (!isLongClickable())
        {
            setLongClickable(true);
        }
        mOnItemLongClickListener = onitemlongclicklistener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onitemselectedlistener)
    {
        mOnItemSelectedListener = onitemselectedlistener;
    }

    protected void setSelectedPositionInt(int i)
    {
        mSelectedPosition = i;
        mSelectedColId = getItemIdAtPosition(i);
    }

    public abstract void setSelection(int i);




}
