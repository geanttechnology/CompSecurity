// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

// Referenced classes of package it.sephiroth.android.library.widget:
//            HListView, ExpandableHListPosition, ExpandableHListConnector

public class ExpandableHListView extends HListView
{
    public static class ExpandableListContextMenuInfo
        implements android.view.ContextMenu.ContextMenuInfo
    {

        public long id;
        public long packedPosition;
        public View targetView;

        public ExpandableListContextMenuInfo(View view, long l, long l1)
        {
            targetView = view;
            packedPosition = l;
            id = l1;
        }
    }

    public static interface OnChildClickListener
    {

        public abstract boolean onChildClick(ExpandableHListView expandablehlistview, View view, int i, int j, long l);
    }

    public static interface OnGroupClickListener
    {

        public abstract boolean onGroupClick(ExpandableHListView expandablehlistview, View view, int i, long l);
    }

    public static interface OnGroupCollapseListener
    {

        public abstract void onGroupCollapse(int i);
    }

    public static interface OnGroupExpandListener
    {

        public abstract void onGroupExpand(int i);
    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        ArrayList expandedGroupMetadataList;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeList(expandedGroupMetadataList);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            expandedGroupMetadataList = new ArrayList();
            parcel.readList(expandedGroupMetadataList, it/sephiroth/android/library/widget/ExpandableHListConnector.getClassLoader());
        }


        SavedState(Parcelable parcelable, ArrayList arraylist)
        {
            super(parcelable);
            expandedGroupMetadataList = arraylist;
        }
    }


    public static final int CHILD_INDICATOR_INHERIT = -1;
    private static final int CHILD_LAST_STATE_SET[] = {
        0x10100a6
    };
    private static final int EMPTY_STATE_SET[];
    private static final int GROUP_EMPTY_STATE_SET[] = {
        0x10100a9
    };
    private static final int GROUP_EXPANDED_EMPTY_STATE_SET[] = {
        0x10100a8, 0x10100a9
    };
    private static final int GROUP_EXPANDED_STATE_SET[] = {
        0x10100a8
    };
    private static final int GROUP_STATE_SETS[][];
    private static final int INDICATOR_UNDEFINED = -2;
    private static final long PACKED_POSITION_INT_MASK_CHILD = -1L;
    private static final long PACKED_POSITION_INT_MASK_GROUP = 0x7fffffffL;
    private static final long PACKED_POSITION_MASK_CHILD = 0xffffffffL;
    private static final long PACKED_POSITION_MASK_GROUP = 0x7fffffff00000000L;
    private static final long PACKED_POSITION_MASK_TYPE = 0x8000000000000000L;
    private static final long PACKED_POSITION_SHIFT_GROUP = 32L;
    private static final long PACKED_POSITION_SHIFT_TYPE = 63L;
    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    public static final int PACKED_POSITION_TYPE_NULL = 2;
    public static final long PACKED_POSITION_VALUE_NULL = 0xffffffffL;
    private ExpandableListAdapter mAdapter;
    private Drawable mChildDivider;
    private Drawable mChildIndicator;
    private int mChildIndicatorGravity;
    private int mChildIndicatorHeight;
    private int mChildIndicatorLeft;
    private int mChildIndicatorTop;
    private int mChildIndicatorWidth;
    private ExpandableHListConnector mConnector;
    private Drawable mGroupIndicator;
    private int mGroupIndicatorHeight;
    private int mGroupIndicatorWidth;
    private int mIndicatorGravity;
    private int mIndicatorLeft;
    private final Rect mIndicatorRect;
    private int mIndicatorTop;
    private OnChildClickListener mOnChildClickListener;
    private OnGroupClickListener mOnGroupClickListener;
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;
    private final Rect mTempRect;

    public ExpandableHListView(Context context)
    {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, it.sephiroth.android.library.R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIndicatorRect = new Rect();
        mTempRect = new Rect();
        context = context.obtainStyledAttributes(attributeset, it.sephiroth.android.library.R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(context.getDrawable(3));
        setChildIndicator(context.getDrawable(4));
        mIndicatorLeft = context.getDimensionPixelSize(5, 0);
        mIndicatorTop = context.getDimensionPixelSize(6, 0);
        mIndicatorGravity = context.getInt(0, 0);
        mChildIndicatorGravity = context.getInt(1, 0);
        mChildIndicatorLeft = context.getDimensionPixelSize(7, 0);
        mChildIndicatorTop = context.getDimensionPixelSize(8, 0);
        mChildDivider = context.getDrawable(2);
        context.recycle();
    }

    private int getAbsoluteFlatPosition(int i)
    {
        return getHeaderViewsCount() + i;
    }

    private long getChildOrGroupId(ExpandableHListPosition expandablehlistposition)
    {
        if (expandablehlistposition.type == 1)
        {
            return mAdapter.getChildId(expandablehlistposition.groupPos, expandablehlistposition.childPos);
        } else
        {
            return mAdapter.getGroupId(expandablehlistposition.groupPos);
        }
    }

    private int getFlatPositionForConnector(int i)
    {
        return i - getHeaderViewsCount();
    }

    private Drawable getIndicator(ExpandableHListConnector.PositionMetadata positionmetadata)
    {
        boolean flag1 = true;
        byte byte0 = 0;
        Drawable drawable;
        if (positionmetadata.position.type == 2)
        {
            Drawable drawable1 = mGroupIndicator;
            drawable = drawable1;
            if (drawable1 != null)
            {
                drawable = drawable1;
                if (drawable1.isStateful())
                {
                    boolean flag;
                    if (positionmetadata.groupMetadata == null || positionmetadata.groupMetadata.lastChildFlPos == positionmetadata.groupMetadata.flPos)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!positionmetadata.isExpanded())
                    {
                        flag1 = false;
                    }
                    if (flag)
                    {
                        byte0 = 2;
                    }
                    drawable1.setState(GROUP_STATE_SETS[flag1 | byte0]);
                    drawable = drawable1;
                }
            }
        } else
        {
            Drawable drawable2 = mChildIndicator;
            drawable = drawable2;
            if (drawable2 != null)
            {
                drawable = drawable2;
                if (drawable2.isStateful())
                {
                    if (positionmetadata.position.flatListPos == positionmetadata.groupMetadata.lastChildFlPos)
                    {
                        positionmetadata = CHILD_LAST_STATE_SET;
                    } else
                    {
                        positionmetadata = EMPTY_STATE_SET;
                    }
                    drawable2.setState(positionmetadata);
                    return drawable2;
                }
            }
        }
        return drawable;
    }

    public static int getPackedPositionChild(long l)
    {
        while (l == 0xffffffffL || (l & 0x8000000000000000L) != 0x8000000000000000L) 
        {
            return -1;
        }
        return (int)(l & 0xffffffffL);
    }

    public static long getPackedPositionForChild(int i, int j)
    {
        return 0x8000000000000000L | ((long)i & 0x7fffffffL) << 32 | (long)j & -1L;
    }

    public static long getPackedPositionForGroup(int i)
    {
        return ((long)i & 0x7fffffffL) << 32;
    }

    public static int getPackedPositionGroup(long l)
    {
        if (l == 0xffffffffL)
        {
            return -1;
        } else
        {
            return (int)((0x7fffffff00000000L & l) >> 32);
        }
    }

    public static int getPackedPositionType(long l)
    {
        if (l == 0xffffffffL)
        {
            return 2;
        }
        return (l & 0x8000000000000000L) != 0x8000000000000000L ? 0 : 1;
    }

    private boolean isHeaderOrFooterPosition(int i)
    {
        int j = mItemCount;
        int k = getFooterViewsCount();
        return i < getHeaderViewsCount() || i >= j - k;
    }

    private void resolveChildIndicator()
    {
        if (mChildIndicator != null)
        {
            mChildIndicatorWidth = mChildIndicator.getIntrinsicWidth();
            mChildIndicatorHeight = mChildIndicator.getIntrinsicHeight();
            return;
        } else
        {
            mChildIndicatorWidth = 0;
            mChildIndicatorHeight = 0;
            return;
        }
    }

    private void resolveIndicator()
    {
        if (mGroupIndicator != null)
        {
            mGroupIndicatorWidth = mGroupIndicator.getIntrinsicWidth();
            mGroupIndicatorHeight = mGroupIndicator.getIntrinsicHeight();
            return;
        } else
        {
            mGroupIndicatorWidth = 0;
            mGroupIndicatorHeight = 0;
            return;
        }
    }

    public boolean collapseGroup(int i)
    {
        boolean flag = mConnector.collapseGroup(i);
        if (mOnGroupCollapseListener != null)
        {
            mOnGroupCollapseListener.onGroupCollapse(i);
        }
        return flag;
    }

    android.view.ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long l)
    {
        if (isHeaderOrFooterPosition(i))
        {
            return new AdapterView.AdapterContextMenuInfo(view, i, l);
        } else
        {
            i = getFlatPositionForConnector(i);
            ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(i);
            ExpandableHListPosition expandablehlistposition = positionmetadata.position;
            l = getChildOrGroupId(expandablehlistposition);
            long l1 = expandablehlistposition.getPackedPosition();
            positionmetadata.recycle();
            return new ExpandableListContextMenuInfo(view, l1, l);
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mChildIndicator != null || mGroupIndicator != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Rect rect;
        byte byte0;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        l = getHeaderViewsCount();
        i1 = mItemCount;
        j1 = getFooterViewsCount();
        k1 = getRight();
        byte0 = -4;
        rect = mIndicatorRect;
        l1 = getChildCount();
        k = 0;
        j = mFirstPosition - l;
_L4:
        if (k >= l1) goto _L1; else goto _L3
_L3:
        int i;
        if (j >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = byte0;
_L6:
        k++;
        j++;
        byte0 = i;
          goto _L4
        if (j > i1 - j1 - l - 1) goto _L1; else goto _L5
_L5:
        Object obj = getChildAt(k);
        int i2 = ((View) (obj)).getLeft();
        int j2 = ((View) (obj)).getRight();
        i = byte0;
        if (j2 >= 0)
        {
            i = byte0;
            if (i2 <= k1)
            {
                ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(j);
                i = byte0;
                if (positionmetadata.position.type != byte0)
                {
                    if (positionmetadata.position.type == 1)
                    {
                        rect.top = ((View) (obj)).getTop() + mChildIndicatorTop;
                        rect.bottom = ((View) (obj)).getBottom() + mChildIndicatorTop;
                    } else
                    {
                        rect.top = ((View) (obj)).getTop() + mIndicatorTop;
                        rect.bottom = ((View) (obj)).getBottom() + mIndicatorTop;
                    }
                    i = positionmetadata.position.type;
                }
                if (rect.top != rect.bottom)
                {
                    if (positionmetadata.position.type == 1)
                    {
                        rect.left = mChildIndicatorLeft + i2;
                        rect.right = mChildIndicatorLeft + j2;
                    } else
                    {
                        rect.left = mIndicatorLeft + i2;
                        rect.right = mIndicatorLeft + j2;
                    }
                    obj = getIndicator(positionmetadata);
                    if (obj != null)
                    {
                        if (positionmetadata.position.type == 1)
                        {
                            Gravity.apply(mChildIndicatorGravity, mChildIndicatorWidth, mChildIndicatorHeight, rect, mTempRect);
                        } else
                        {
                            Gravity.apply(mIndicatorGravity, mGroupIndicatorWidth, mGroupIndicatorHeight, rect, mTempRect);
                        }
                        ((Drawable) (obj)).setBounds(mTempRect);
                        ((Drawable) (obj)).draw(canvas);
                    }
                }
                positionmetadata.recycle();
            }
        }
          goto _L6
    }

    void drawDivider(Canvas canvas, Rect rect, int i)
    {
        i += mFirstPosition;
        if (i >= 0)
        {
            int j = getFlatPositionForConnector(i);
            ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(j);
            if (positionmetadata.position.type == 1 || positionmetadata.isExpanded() && positionmetadata.groupMetadata.lastChildFlPos != positionmetadata.groupMetadata.flPos)
            {
                Drawable drawable = mChildDivider;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                positionmetadata.recycle();
                return;
            }
            positionmetadata.recycle();
        }
        super.drawDivider(canvas, rect, i);
    }

    public boolean expandGroup(int i)
    {
        return expandGroup(i, false);
    }

    public boolean expandGroup(int i, boolean flag)
    {
        ExpandableHListPosition expandablehlistposition = ExpandableHListPosition.obtain(2, i, -1, -1);
        ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getFlattenedPos(expandablehlistposition);
        expandablehlistposition.recycle();
        boolean flag1 = mConnector.expandGroup(positionmetadata);
        if (mOnGroupExpandListener != null)
        {
            mOnGroupExpandListener.onGroupExpand(i);
        }
        if (flag)
        {
            int j = positionmetadata.position.flatListPos + getHeaderViewsCount();
            smoothScrollToPosition(mAdapter.getChildrenCount(i) + j, j);
        }
        positionmetadata.recycle();
        return flag1;
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return super.getAdapter();
    }

    public ExpandableListAdapter getExpandableListAdapter()
    {
        return mAdapter;
    }

    public long getExpandableListPosition(int i)
    {
        if (isHeaderOrFooterPosition(i))
        {
            return 0xffffffffL;
        } else
        {
            i = getFlatPositionForConnector(i);
            ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(i);
            long l = positionmetadata.position.getPackedPosition();
            positionmetadata.recycle();
            return l;
        }
    }

    public int getFlatListPosition(long l)
    {
        ExpandableHListPosition expandablehlistposition = ExpandableHListPosition.obtainPosition(l);
        ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getFlattenedPos(expandablehlistposition);
        expandablehlistposition.recycle();
        int i = positionmetadata.position.flatListPos;
        positionmetadata.recycle();
        return getAbsoluteFlatPosition(i);
    }

    public long getSelectedId()
    {
        long l = getSelectedPosition();
        if (l == 0xffffffffL)
        {
            return -1L;
        }
        int i = getPackedPositionGroup(l);
        if (getPackedPositionType(l) == 0)
        {
            return mAdapter.getGroupId(i);
        } else
        {
            return mAdapter.getChildId(i, getPackedPositionChild(l));
        }
    }

    public long getSelectedPosition()
    {
        return getExpandableListPosition(getSelectedItemPosition());
    }

    boolean handleItemClick(View view, int i, long l)
    {
        ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getUnflattenedPos(i);
        l = getChildOrGroupId(positionmetadata.position);
        boolean flag;
        if (positionmetadata.position.type == 2)
        {
            if (mOnGroupClickListener != null && mOnGroupClickListener.onGroupClick(this, view, positionmetadata.position.groupPos, l))
            {
                positionmetadata.recycle();
                return true;
            }
            if (positionmetadata.isExpanded())
            {
                mConnector.collapseGroup(positionmetadata);
                playSoundEffect(0);
                if (mOnGroupCollapseListener != null)
                {
                    mOnGroupCollapseListener.onGroupCollapse(positionmetadata.position.groupPos);
                }
            } else
            {
                mConnector.expandGroup(positionmetadata);
                playSoundEffect(0);
                if (mOnGroupExpandListener != null)
                {
                    mOnGroupExpandListener.onGroupExpand(positionmetadata.position.groupPos);
                }
                i = positionmetadata.position.groupPos;
                int j = positionmetadata.position.flatListPos + getHeaderViewsCount();
                smoothScrollToPosition(mAdapter.getChildrenCount(i) + j, j);
            }
            flag = true;
        } else
        {
            if (mOnChildClickListener != null)
            {
                playSoundEffect(0);
                return mOnChildClickListener.onChildClick(this, view, positionmetadata.position.groupPos, positionmetadata.position.childPos, l);
            }
            flag = false;
        }
        positionmetadata.recycle();
        return flag;
    }

    public boolean isGroupExpanded(int i)
    {
        return mConnector.isGroupExpanded(i);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(it/sephiroth/android/library/widget/ExpandableHListView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(it/sephiroth/android/library/widget/ExpandableHListView.getName());
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
        } else
        {
            parcelable = (SavedState)parcelable;
            super.onRestoreInstanceState(parcelable.getSuperState());
            if (mConnector != null && ((SavedState) (parcelable)).expandedGroupMetadataList != null)
            {
                mConnector.setExpandedGroupMetadataList(((SavedState) (parcelable)).expandedGroupMetadataList);
                return;
            }
        }
    }

    public void onRtlPropertiesChanged(int i)
    {
        resolveIndicator();
        resolveChildIndicator();
    }

    public Parcelable onSaveInstanceState()
    {
        Parcelable parcelable = super.onSaveInstanceState();
        ArrayList arraylist;
        if (mConnector != null)
        {
            arraylist = mConnector.getExpandedGroupMetadataList();
        } else
        {
            arraylist = null;
        }
        return new SavedState(parcelable, arraylist);
    }

    public boolean performItemClick(View view, int i, long l)
    {
        if (isHeaderOrFooterPosition(i))
        {
            return super.performItemClick(view, i, l);
        } else
        {
            return handleItemClick(view, getFlatPositionForConnector(i), l);
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ExpandableListAdapter expandablelistadapter)
    {
        mAdapter = expandablelistadapter;
        if (expandablelistadapter != null)
        {
            mConnector = new ExpandableHListConnector(expandablelistadapter);
        } else
        {
            mConnector = null;
        }
        super.setAdapter(mConnector);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    public void setChildDivider(Drawable drawable)
    {
        mChildDivider = drawable;
    }

    public void setChildIndicator(Drawable drawable)
    {
        mChildIndicator = drawable;
        resolveChildIndicator();
    }

    public void setGroupIndicator(Drawable drawable)
    {
        mGroupIndicator = drawable;
        resolveIndicator();
    }

    public void setOnChildClickListener(OnChildClickListener onchildclicklistener)
    {
        mOnChildClickListener = onchildclicklistener;
    }

    public void setOnGroupClickListener(OnGroupClickListener ongroupclicklistener)
    {
        mOnGroupClickListener = ongroupclicklistener;
    }

    public void setOnGroupCollapseListener(OnGroupCollapseListener ongroupcollapselistener)
    {
        mOnGroupCollapseListener = ongroupcollapselistener;
    }

    public void setOnGroupExpandListener(OnGroupExpandListener ongroupexpandlistener)
    {
        mOnGroupExpandListener = ongroupexpandlistener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onitemclicklistener)
    {
        super.setOnItemClickListener(onitemclicklistener);
    }

    public boolean setSelectedChild(int i, int j, boolean flag)
    {
        ExpandableHListPosition expandablehlistposition = ExpandableHListPosition.obtainChildPosition(i, j);
        ExpandableHListConnector.PositionMetadata positionmetadata1 = mConnector.getFlattenedPos(expandablehlistposition);
        ExpandableHListConnector.PositionMetadata positionmetadata = positionmetadata1;
        if (positionmetadata1 == null)
        {
            if (!flag)
            {
                return false;
            }
            expandGroup(i);
            ExpandableHListConnector.PositionMetadata positionmetadata2 = mConnector.getFlattenedPos(expandablehlistposition);
            positionmetadata = positionmetadata2;
            if (positionmetadata2 == null)
            {
                throw new IllegalStateException("Could not find child");
            }
        }
        super.setSelection(getAbsoluteFlatPosition(positionmetadata.position.flatListPos));
        expandablehlistposition.recycle();
        positionmetadata.recycle();
        return true;
    }

    public void setSelectedGroup(int i)
    {
        ExpandableHListPosition expandablehlistposition = ExpandableHListPosition.obtainGroupPosition(i);
        ExpandableHListConnector.PositionMetadata positionmetadata = mConnector.getFlattenedPos(expandablehlistposition);
        expandablehlistposition.recycle();
        super.setSelection(getAbsoluteFlatPosition(positionmetadata.position.flatListPos));
        positionmetadata.recycle();
    }

    static 
    {
        EMPTY_STATE_SET = new int[0];
        GROUP_STATE_SETS = (new int[][] {
            EMPTY_STATE_SET, GROUP_EXPANDED_STATE_SET, GROUP_EMPTY_STATE_SET, GROUP_EXPANDED_EMPTY_STATE_SET
        });
    }
}
