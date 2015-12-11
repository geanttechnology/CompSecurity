// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.DataSetObserver;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;

public class fd extends BaseExpandableListAdapter
{

    private final ExpandableListAdapter a;
    private final SparseBooleanArray b = new SparseBooleanArray();

    public fd(ExpandableListAdapter expandablelistadapter)
    {
        a = expandablelistadapter;
    }

    public boolean a(int i)
    {
        Boolean boolean1 = Boolean.valueOf(b.get(i));
        if (boolean1 != null)
        {
            return boolean1.booleanValue();
        } else
        {
            return false;
        }
    }

    public boolean areAllItemsEnabled()
    {
        return a.areAllItemsEnabled();
    }

    public Object getChild(int i, int j)
    {
        return a.getChild(i, j);
    }

    public long getChildId(int i, int j)
    {
        return a.getChildId(i, j);
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        return a.getChildView(i, j, flag, view, viewgroup);
    }

    public int getChildrenCount(int i)
    {
        return a.getChildrenCount(i);
    }

    public long getCombinedChildId(long l, long l1)
    {
        return a.getCombinedChildId(l, l1);
    }

    public long getCombinedGroupId(long l)
    {
        return a.getCombinedGroupId(l);
    }

    public Object getGroup(int i)
    {
        return a.getGroup(i);
    }

    public int getGroupCount()
    {
        return a.getGroupCount();
    }

    public long getGroupId(int i)
    {
        return a.getGroupId(i);
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            Object obj = view.getTag(0x7f0c0008);
            if ((obj instanceof Boolean) && ((Boolean)obj).booleanValue())
            {
                view.setVisibility(0);
            }
            view.setTag(0x7f0c0008, null);
        }
        b.put(i, flag);
        return a.getGroupView(i, flag, view, viewgroup);
    }

    public boolean hasStableIds()
    {
        return a.hasStableIds();
    }

    public boolean isChildSelectable(int i, int j)
    {
        return a.isChildSelectable(i, j);
    }

    public boolean isEmpty()
    {
        return a.isEmpty();
    }

    public void onGroupCollapsed(int i)
    {
        b.put(i, false);
        a.onGroupCollapsed(i);
    }

    public void onGroupExpanded(int i)
    {
        b.put(i, true);
        a.onGroupExpanded(i);
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        a.registerDataSetObserver(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        a.unregisterDataSetObserver(datasetobserver);
    }
}
