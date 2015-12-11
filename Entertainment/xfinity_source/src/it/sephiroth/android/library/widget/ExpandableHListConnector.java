// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package it.sephiroth.android.library.widget:
//            ExpandableHListPosition

class ExpandableHListConnector extends BaseAdapter
    implements Filterable
{
    static class GroupMetadata
        implements Parcelable, Comparable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public GroupMetadata createFromParcel(Parcel parcel)
            {
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public GroupMetadata[] newArray(int i)
            {
                return new GroupMetadata[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;

        static GroupMetadata obtain(int i, int j, int k, long l)
        {
            GroupMetadata groupmetadata = new GroupMetadata();
            groupmetadata.flPos = i;
            groupmetadata.lastChildFlPos = j;
            groupmetadata.gPos = k;
            groupmetadata.gId = l;
            return groupmetadata;
        }

        public int compareTo(GroupMetadata groupmetadata)
        {
            if (groupmetadata == null)
            {
                throw new IllegalArgumentException();
            } else
            {
                return gPos - groupmetadata.gPos;
            }
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((GroupMetadata)obj);
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(flPos);
            parcel.writeInt(lastChildFlPos);
            parcel.writeInt(gPos);
            parcel.writeLong(gId);
        }


        private GroupMetadata()
        {
        }
    }

    protected class MyDataSetObserver extends DataSetObserver
    {

        final ExpandableHListConnector this$0;

        public void onChanged()
        {
            refreshExpGroupMetadataList(true, true);
            notifyDataSetChanged();
        }

        public void onInvalidated()
        {
            refreshExpGroupMetadataList(true, true);
            notifyDataSetInvalidated();
        }

        protected MyDataSetObserver()
        {
            this$0 = ExpandableHListConnector.this;
            super();
        }
    }

    public static class PositionMetadata
    {

        private static ArrayList sPool = new ArrayList(5);
        public int groupInsertIndex;
        public GroupMetadata groupMetadata;
        public ExpandableHListPosition position;

        private static PositionMetadata getRecycledOrCreate()
        {
label0:
            {
                PositionMetadata positionmetadata;
                synchronized (sPool)
                {
                    if (sPool.size() <= 0)
                    {
                        break label0;
                    }
                    positionmetadata = (PositionMetadata)sPool.remove(0);
                }
                positionmetadata.resetState();
                return positionmetadata;
            }
            PositionMetadata positionmetadata1 = new PositionMetadata();
            arraylist;
            JVM INSTR monitorexit ;
            return positionmetadata1;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        static PositionMetadata obtain(int i, int j, int k, int l, GroupMetadata groupmetadata, int i1)
        {
            PositionMetadata positionmetadata = getRecycledOrCreate();
            positionmetadata.position = ExpandableHListPosition.obtain(j, k, l, i);
            positionmetadata.groupMetadata = groupmetadata;
            positionmetadata.groupInsertIndex = i1;
            return positionmetadata;
        }

        private void resetState()
        {
            if (position != null)
            {
                position.recycle();
                position = null;
            }
            groupMetadata = null;
            groupInsertIndex = 0;
        }

        public boolean isExpanded()
        {
            return groupMetadata != null;
        }

        public void recycle()
        {
            resetState();
            synchronized (sPool)
            {
                if (sPool.size() < 5)
                {
                    sPool.add(this);
                }
            }
            return;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }


        private PositionMetadata()
        {
        }
    }


    private final DataSetObserver mDataSetObserver = new MyDataSetObserver();
    private ArrayList mExpGroupMetadataList;
    private ExpandableListAdapter mExpandableListAdapter;
    private int mMaxExpGroupCount;
    private int mTotalExpChildrenCount;

    public ExpandableHListConnector(ExpandableListAdapter expandablelistadapter)
    {
        mMaxExpGroupCount = 0x7fffffff;
        mExpGroupMetadataList = new ArrayList();
        setExpandableListAdapter(expandablelistadapter);
    }

    private void refreshExpGroupMetadataList(boolean flag, boolean flag1)
    {
        ArrayList arraylist = mExpGroupMetadataList;
        int i = arraylist.size();
        boolean flag4 = false;
        mTotalExpChildrenCount = 0;
        int j = i;
        if (flag1)
        {
            boolean flag2 = false;
            for (int l = i - 1; l >= 0;)
            {
                GroupMetadata groupmetadata = (GroupMetadata)arraylist.get(l);
                int l1 = findGroupPosition(groupmetadata.gId, groupmetadata.gPos);
                int j1 = i;
                boolean flag3 = flag2;
                if (l1 != groupmetadata.gPos)
                {
                    j = i;
                    if (l1 == -1)
                    {
                        arraylist.remove(l);
                        j = i - 1;
                    }
                    groupmetadata.gPos = l1;
                    j1 = j;
                    flag3 = flag2;
                    if (!flag2)
                    {
                        flag3 = true;
                        j1 = j;
                    }
                }
                l--;
                i = j1;
                flag2 = flag3;
            }

            j = i;
            if (flag2)
            {
                Collections.sort(arraylist);
                j = i;
            }
        }
        int i1 = 0;
        i = 0;
        int k = ((flag4) ? 1 : 0);
        while (i < j) 
        {
            GroupMetadata groupmetadata1 = (GroupMetadata)arraylist.get(i);
            int k1;
            if (groupmetadata1.lastChildFlPos == -1 || flag)
            {
                k1 = mExpandableListAdapter.getChildrenCount(groupmetadata1.gPos);
            } else
            {
                k1 = groupmetadata1.lastChildFlPos - groupmetadata1.flPos;
            }
            mTotalExpChildrenCount = mTotalExpChildrenCount + k1;
            k += groupmetadata1.gPos - i1;
            i1 = groupmetadata1.gPos;
            groupmetadata1.flPos = k;
            k += k1;
            groupmetadata1.lastChildFlPos = k;
            i++;
        }
    }

    public boolean areAllItemsEnabled()
    {
        return mExpandableListAdapter.areAllItemsEnabled();
    }

    boolean collapseGroup(int i)
    {
        ExpandableHListPosition expandablehlistposition = ExpandableHListPosition.obtain(2, i, -1, -1);
        PositionMetadata positionmetadata = getFlattenedPos(expandablehlistposition);
        expandablehlistposition.recycle();
        if (positionmetadata == null)
        {
            return false;
        } else
        {
            boolean flag = collapseGroup(positionmetadata);
            positionmetadata.recycle();
            return flag;
        }
    }

    boolean collapseGroup(PositionMetadata positionmetadata)
    {
        if (positionmetadata.groupMetadata == null)
        {
            return false;
        } else
        {
            mExpGroupMetadataList.remove(positionmetadata.groupMetadata);
            refreshExpGroupMetadataList(false, false);
            notifyDataSetChanged();
            mExpandableListAdapter.onGroupCollapsed(positionmetadata.groupMetadata.gPos);
            return true;
        }
    }

    boolean expandGroup(PositionMetadata positionmetadata)
    {
        if (positionmetadata.position.groupPos < 0)
        {
            throw new RuntimeException("Need group");
        }
        while (mMaxExpGroupCount == 0 || positionmetadata.groupMetadata != null) 
        {
            return false;
        }
        if (mExpGroupMetadataList.size() >= mMaxExpGroupCount)
        {
            GroupMetadata groupmetadata = (GroupMetadata)mExpGroupMetadataList.get(0);
            int i = mExpGroupMetadataList.indexOf(groupmetadata);
            collapseGroup(groupmetadata.gPos);
            if (positionmetadata.groupInsertIndex > i)
            {
                positionmetadata.groupInsertIndex = positionmetadata.groupInsertIndex - 1;
            }
        }
        GroupMetadata groupmetadata1 = GroupMetadata.obtain(-1, -1, positionmetadata.position.groupPos, mExpandableListAdapter.getGroupId(positionmetadata.position.groupPos));
        mExpGroupMetadataList.add(positionmetadata.groupInsertIndex, groupmetadata1);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupExpanded(groupmetadata1.gPos);
        return true;
    }

    int findGroupPosition(long l, int i)
    {
        ExpandableListAdapter expandablelistadapter;
        int j;
        int k;
        int i1;
        boolean flag;
        boolean flag1;
        int j1;
        long l1;
        j1 = mExpandableListAdapter.getGroupCount();
        if (j1 == 0)
        {
            return -1;
        }
        if (l == 0x8000000000000000L)
        {
            return -1;
        }
        j = Math.min(j1 - 1, Math.max(0, i));
        l1 = SystemClock.uptimeMillis();
        k = j;
        i1 = j;
        i = 0;
        expandablelistadapter = getAdapter();
        if (expandablelistadapter == null)
        {
            return -1;
        }
_L4:
        if (SystemClock.uptimeMillis() > l1 + 100L)
        {
            break; /* Loop/switch isn't completed */
        }
        if (expandablelistadapter.getGroupId(j) == l)
        {
            return j;
        }
        if (i1 == j1 - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag || !flag1) goto _L2; else goto _L1
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        if (flag1 || i != 0 && !flag)
        {
            i1++;
            j = i1;
            i = 0;
        } else
        if (flag || i == 0 && !flag1)
        {
            k--;
            j = k;
            i = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    ExpandableListAdapter getAdapter()
    {
        return mExpandableListAdapter;
    }

    public int getCount()
    {
        return mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount;
    }

    ArrayList getExpandedGroupMetadataList()
    {
        return mExpGroupMetadataList;
    }

    public Filter getFilter()
    {
        ExpandableListAdapter expandablelistadapter = getAdapter();
        if (expandablelistadapter instanceof Filterable)
        {
            return ((Filterable)expandablelistadapter).getFilter();
        } else
        {
            return null;
        }
    }

    PositionMetadata getFlattenedPos(ExpandableHListPosition expandablehlistposition)
    {
_L2:
        if (j <= k)
        {
            int l = (k - j) / 2 + j;
            GroupMetadata groupmetadata = (GroupMetadata)((ArrayList) (obj)).get(l);
            if (expandablehlistposition.groupPos > groupmetadata.gPos)
            {
                j = l + 1;
                i = l;
            } else
            if (expandablehlistposition.groupPos < groupmetadata.gPos)
            {
                k = l - 1;
                i = l;
            } else
            {
                i = l;
                if (expandablehlistposition.groupPos == groupmetadata.gPos)
                {
                    if (expandablehlistposition.type == 2)
                    {
                        return PositionMetadata.obtain(groupmetadata.flPos, expandablehlistposition.type, expandablehlistposition.groupPos, expandablehlistposition.childPos, groupmetadata, l);
                    }
                    if (expandablehlistposition.type == 1)
                    {
                        return PositionMetadata.obtain(groupmetadata.flPos + expandablehlistposition.childPos + 1, expandablehlistposition.type, expandablehlistposition.groupPos, expandablehlistposition.childPos, groupmetadata, l);
                    } else
                    {
                        return null;
                    }
                }
            }
        } else
        {
            if (expandablehlistposition.type != 2)
            {
                return null;
            }
            if (j > i)
            {
                obj = (GroupMetadata)((ArrayList) (obj)).get(j - 1);
                return PositionMetadata.obtain(((GroupMetadata) (obj)).lastChildFlPos + (expandablehlistposition.groupPos - ((GroupMetadata) (obj)).gPos), expandablehlistposition.type, expandablehlistposition.groupPos, expandablehlistposition.childPos, null, j);
            }
            if (k < i)
            {
                i = k + 1;
                obj = (GroupMetadata)((ArrayList) (obj)).get(i);
                return PositionMetadata.obtain(((GroupMetadata) (obj)).flPos - (((GroupMetadata) (obj)).gPos - expandablehlistposition.groupPos), expandablehlistposition.type, expandablehlistposition.groupPos, expandablehlistposition.childPos, null, i);
            } else
            {
                return null;
            }
        }
        continue; /* Loop/switch isn't completed */
        Object obj = mExpGroupMetadataList;
        int i = ((ArrayList) (obj)).size();
        int j = 0;
        int k = i - 1;
        if (i == 0)
        {
            return PositionMetadata.obtain(expandablehlistposition.groupPos, expandablehlistposition.type, expandablehlistposition.groupPos, expandablehlistposition.childPos, null, 0);
        }
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Object getItem(int i)
    {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        Object obj;
        if (positionmetadata.position.type == 2)
        {
            obj = mExpandableListAdapter.getGroup(positionmetadata.position.groupPos);
        } else
        if (positionmetadata.position.type == 1)
        {
            obj = mExpandableListAdapter.getChild(positionmetadata.position.groupPos, positionmetadata.position.childPos);
        } else
        {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        positionmetadata.recycle();
        return obj;
    }

    public long getItemId(int i)
    {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        long l = mExpandableListAdapter.getGroupId(positionmetadata.position.groupPos);
        if (positionmetadata.position.type == 2)
        {
            l = mExpandableListAdapter.getCombinedGroupId(l);
        } else
        if (positionmetadata.position.type == 1)
        {
            long l1 = mExpandableListAdapter.getChildId(positionmetadata.position.groupPos, positionmetadata.position.childPos);
            l = mExpandableListAdapter.getCombinedChildId(l, l1);
        } else
        {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        positionmetadata.recycle();
        return l;
    }

    public int getItemViewType(int i)
    {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        ExpandableHListPosition expandablehlistposition = positionmetadata.position;
        if (mExpandableListAdapter instanceof HeterogeneousExpandableList)
        {
            HeterogeneousExpandableList heterogeneousexpandablelist = (HeterogeneousExpandableList)mExpandableListAdapter;
            if (expandablehlistposition.type == 2)
            {
                i = heterogeneousexpandablelist.getGroupType(expandablehlistposition.groupPos);
            } else
            {
                i = heterogeneousexpandablelist.getChildType(expandablehlistposition.groupPos, expandablehlistposition.childPos);
                i = heterogeneousexpandablelist.getGroupTypeCount() + i;
            }
        } else
        if (expandablehlistposition.type == 2)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        positionmetadata.recycle();
        return i;
    }

    PositionMetadata getUnflattenedPos(int i)
    {
_L2:
        if (j <= l)
        {
            int i1 = (l - j) / 2 + j;
            GroupMetadata groupmetadata = (GroupMetadata)((ArrayList) (obj)).get(i1);
            if (i > groupmetadata.lastChildFlPos)
            {
                j = i1 + 1;
                k = i1;
            } else
            if (i < groupmetadata.flPos)
            {
                l = i1 - 1;
                k = i1;
            } else
            {
                if (i == groupmetadata.flPos)
                {
                    return PositionMetadata.obtain(i, 2, groupmetadata.gPos, -1, groupmetadata, i1);
                }
                k = i1;
                if (i <= groupmetadata.lastChildFlPos)
                {
                    j = groupmetadata.flPos;
                    return PositionMetadata.obtain(i, 1, groupmetadata.gPos, i - (j + 1), groupmetadata, i1);
                }
            }
        } else
        {
            if (j > k)
            {
                obj = (GroupMetadata)((ArrayList) (obj)).get(j - 1);
                l = (i - ((GroupMetadata) (obj)).lastChildFlPos) + ((GroupMetadata) (obj)).gPos;
                k = j;
                j = l;
            } else
            if (l < k)
            {
                k = l + 1;
                obj = (GroupMetadata)((ArrayList) (obj)).get(k);
                j = ((GroupMetadata) (obj)).gPos - (((GroupMetadata) (obj)).flPos - i);
            } else
            {
                throw new RuntimeException("Unknown state");
            }
            return PositionMetadata.obtain(i, 2, j, -1, null, k);
        }
        continue; /* Loop/switch isn't completed */
        Object obj = mExpGroupMetadataList;
        int k = ((ArrayList) (obj)).size();
        int j = 0;
        int l = k - 1;
        if (k == 0)
        {
            return PositionMetadata.obtain(i, 2, i, -1, null, 0);
        }
        k = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = true;
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        if (positionmetadata.position.type == 2)
        {
            view = mExpandableListAdapter.getGroupView(positionmetadata.position.groupPos, positionmetadata.isExpanded(), view, viewgroup);
        } else
        if (positionmetadata.position.type == 1)
        {
            if (positionmetadata.groupMetadata.lastChildFlPos != i)
            {
                flag = false;
            }
            view = mExpandableListAdapter.getChildView(positionmetadata.position.groupPos, positionmetadata.position.childPos, flag, view, viewgroup);
        } else
        {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        positionmetadata.recycle();
        return view;
    }

    public int getViewTypeCount()
    {
        if (mExpandableListAdapter instanceof HeterogeneousExpandableList)
        {
            HeterogeneousExpandableList heterogeneousexpandablelist = (HeterogeneousExpandableList)mExpandableListAdapter;
            return heterogeneousexpandablelist.getGroupTypeCount() + heterogeneousexpandablelist.getChildTypeCount();
        } else
        {
            return 2;
        }
    }

    public boolean hasStableIds()
    {
        return mExpandableListAdapter.hasStableIds();
    }

    public boolean isEmpty()
    {
        ExpandableListAdapter expandablelistadapter = getAdapter();
        if (expandablelistadapter != null)
        {
            return expandablelistadapter.isEmpty();
        } else
        {
            return true;
        }
    }

    public boolean isEnabled(int i)
    {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        ExpandableHListPosition expandablehlistposition = positionmetadata.position;
        boolean flag;
        if (expandablehlistposition.type == 1)
        {
            flag = mExpandableListAdapter.isChildSelectable(expandablehlistposition.groupPos, expandablehlistposition.childPos);
        } else
        {
            flag = true;
        }
        positionmetadata.recycle();
        return flag;
    }

    public void setExpandableListAdapter(ExpandableListAdapter expandablelistadapter)
    {
        if (mExpandableListAdapter != null)
        {
            mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        }
        mExpandableListAdapter = expandablelistadapter;
        expandablelistadapter.registerDataSetObserver(mDataSetObserver);
    }

    void setExpandedGroupMetadataList(ArrayList arraylist)
    {
        if (arraylist != null && mExpandableListAdapter != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j = mExpandableListAdapter.getGroupCount();
        int i = arraylist.size() - 1;
label0:
        do
        {
label1:
            {
                if (i < 0)
                {
                    break label1;
                }
                if (((GroupMetadata)arraylist.get(i)).gPos >= j)
                {
                    break label0;
                }
                i--;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        mExpGroupMetadataList = arraylist;
        refreshExpGroupMetadataList(true, false);
        return;
    }

}
