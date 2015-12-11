// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import co.vine.android.util.ViewUtil;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.recorder:
//            RecordSegment

public class SegmentEditorAdapter extends BaseAdapter
    implements ListAdapter, co.vine.android.dragsort.DragSortWidget.RemoveListener, co.vine.android.dragsort.DragSortWidget.DragListener
{

    private static final int NO_LAST_DELETION = -1;
    public boolean hasInitialized;
    private Context mContext;
    private final ArrayList mData;
    private final ArrayList mDeleted;
    private int mLastDeletedIndex;
    private final int mMargin;
    private final int mSize;

    public SegmentEditorAdapter(SegmentEditorAdapter segmenteditoradapter)
    {
        mLastDeletedIndex = -1;
        mDeleted = segmenteditoradapter.mDeleted;
        mData = segmenteditoradapter.mData;
        mContext = segmenteditoradapter.mContext;
        mMargin = segmenteditoradapter.mMargin;
        mSize = segmenteditoradapter.mSize;
        mLastDeletedIndex = segmenteditoradapter.mLastDeletedIndex;
    }

    public SegmentEditorAdapter(ArrayList arraylist, Context context, float f)
    {
        mLastDeletedIndex = -1;
        mDeleted = new ArrayList();
        mData = new ArrayList();
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            RecordSegment recordsegment = (RecordSegment)arraylist.next();
            if (!recordsegment.removed)
            {
                mData.add(recordsegment);
            }
        } while (true);
        hasInitialized = true;
        mContext = context;
        mMargin = (int)(2.0F * f);
        mSize = (int)(64F * f);
    }

    public boolean areAllItemsEnabled()
    {
        return true;
    }

    public boolean canUndoDelete()
    {
        return mLastDeletedIndex != -1;
    }

    public void commitDelete()
    {
        mLastDeletedIndex = -1;
    }

    public boolean compareTo(ArrayList arraylist)
    {
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        if (mData != null) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (mDeleted.size() > 0 || arraylist.size() != mData.size())
        {
            return false;
        }
        int j = mData.size();
        int i = 0;
        while (i < j) 
        {
            if (mData.get(i) != arraylist.get(i))
            {
                return false;
            }
            i++;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void drag(int i, int j)
    {
        if (i != j)
        {
            RecordSegment recordsegment = (RecordSegment)mData.get(i);
            mData.set(i, mData.get(j));
            mData.set(j, recordsegment);
            notifyDataSetChanged();
        }
    }

    public int getCount()
    {
        return mData.size();
    }

    public ArrayList getData()
    {
        return mData;
    }

    public ArrayList getDeleted()
    {
        return mDeleted;
    }

    public Object getItem(int i)
    {
        return mData.get(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j;
        if (view == null)
        {
            if (mContext == null)
            {
                mContext = viewgroup.getContext();
            }
            view = new View(mContext);
            viewgroup = new android.view.ViewGroup.MarginLayoutParams(mSize, mSize);
        } else
        {
            viewgroup = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        }
        if (i == getCount() - 1)
        {
            j = 0;
        } else
        {
            j = mMargin;
        }
        viewgroup.bottomMargin = j;
        view.setLayoutParams(viewgroup);
        viewgroup = (RecordSegment)mData.get(i);
        if (((RecordSegment) (viewgroup)).drawable == null && !TextUtils.isEmpty(viewgroup.getThumbnailPath()))
        {
            viewgroup.drawable = BitmapDrawable.createFromPath(viewgroup.getThumbnailPath());
        }
        ViewUtil.setBackground(view, ((RecordSegment)mData.get(i)).drawable);
        return view;
    }

    public int getViewTypeCount()
    {
        return 0;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return mData.size() == 0;
    }

    public boolean isEnabled(int i)
    {
        return true;
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        if (datasetobserver != null)
        {
            super.registerDataSetObserver(datasetobserver);
        }
    }

    public void remove(int i)
    {
        mLastDeletedIndex = i;
        mDeleted.add(mData.remove(i));
        notifyDataSetChanged();
    }

    public void reverse()
    {
        ArrayList arraylist = new ArrayList(mData.size());
        for (int i = mData.size() - 1; i >= 0; i--)
        {
            arraylist.add(mData.get(i));
        }

        mData.clear();
        mData.addAll(arraylist);
        notifyDataSetChanged();
    }

    public void undoDelete()
    {
        if (mLastDeletedIndex >= 0)
        {
            mData.add(mLastDeletedIndex, mDeleted.remove(mDeleted.size() - 1));
            mLastDeletedIndex = -1;
            notifyDataSetChanged();
        }
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        if (datasetobserver != null)
        {
            super.unregisterDataSetObserver(datasetobserver);
        }
    }
}
