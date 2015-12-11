// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            FoundItemsCategoriesActivity

private class childLayoutResource extends BaseExpandableListAdapter
{

    private final ArrayList categoryNodeList;
    private final int childLayoutResource;
    private final int groupLayoutResource;
    private final LayoutInflater inflater;
    final FoundItemsCategoriesActivity this$0;

    public com.ebay.common.model.search.ildLayoutResource getChild(int i, int j)
    {
        Object obj = getGroup(i);
        if (obj != null)
        {
            if ((obj = ((com.ebay.common.model.search.tGroup) (obj)).tGroup) != null && j < ((ArrayList) (obj)).size())
            {
                return (com.ebay.common.model.search.tGroup)((ArrayList) (obj)).get(j);
            }
        }
        return null;
    }

    public volatile Object getChild(int i, int j)
    {
        return getChild(i, j);
    }

    public long getChildId(int i, int j)
    {
        com.ebay.common.model.search.tChild tchild = getChild(i, j);
        if (tchild != null)
        {
            return tchild.tChild;
        } else
        {
            return 0L;
        }
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        boolean flag1 = false;
        View view1 = view;
        view = view1;
        if (view1 == null)
        {
            view = inflater.inflate(childLayoutResource, viewgroup, false);
        }
        viewgroup = getChild(i, j);
        if (viewgroup == null)
        {
            return null;
        }
        ((TextView)view.findViewById(0x7f1001c5)).setText(((com.ebay.common.model.search.tChild) (viewgroup)).tChild);
        ((TextView)view.findViewById(0x7f1001c6)).setText((new StringBuilder()).append("(").append(((com.ebay.common.model.search.tChild) (viewgroup)).tChild).append(")").toString());
        view1 = view.findViewById(0x7f1001c7);
        if (FoundItemsCategoriesActivity.access$000(FoundItemsCategoriesActivity.this) == ((com.ebay.common.model.search.is._cls0) (viewgroup))._fld0)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 4;
        }
        view1.setVisibility(i);
        return view;
    }

    public int getChildrenCount(int i)
    {
        Object obj = getGroup(i);
        if (obj != null)
        {
            if ((obj = ((com.ebay.common.model.search.tGroup) (obj)).tGroup) != null)
            {
                return ((List) (obj)).size();
            }
        }
        return 0;
    }

    public com.ebay.common.model.search.tGroup getGroup(int i)
    {
        if (i < categoryNodeList.size())
        {
            return (com.ebay.common.model.search.tegoryNodeList)categoryNodeList.get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getGroup(int i)
    {
        return getGroup(i);
    }

    public int getGroupCount()
    {
        return categoryNodeList.size();
    }

    public long getGroupId(int i)
    {
        com.ebay.common.model.search.tegoryNodeList tegorynodelist = getGroup(i);
        if (tegorynodelist != null)
        {
            return tegorynodelist.tGroup;
        } else
        {
            return 0L;
        }
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        Object obj1 = null;
        Object obj = view;
        view = ((View) (obj));
        if (obj == null)
        {
            view = inflater.inflate(groupLayoutResource, viewgroup, false);
        }
        obj = getGroup(i);
        if (obj == null)
        {
            return null;
        }
        ((TextView)view.findViewById(0x7f1001c5)).setText(((com.ebay.common.model.search.tGroup) (obj)).tGroup);
        TextView textview = (TextView)view.findViewById(0x7f1001c6);
        viewgroup = obj1;
        if (((com.ebay.common.model.search.tGroup) (obj)).tGroup > 0)
        {
            viewgroup = (new StringBuilder()).append("(").append(((com.ebay.common.model.search.tGroup) (obj)).tGroup).append(")").toString();
        }
        textview.setText(viewgroup);
        viewgroup = view.findViewById(0x7f1001c7);
        if (FoundItemsCategoriesActivity.access$000(FoundItemsCategoriesActivity.this) == ((com.ebay.common.model.search.is._cls0) (obj))._fld0)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        viewgroup.setVisibility(i);
        return view;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public (FoundItemsCategoriesActivity founditemscategoriesactivity1, int i, int j, ArrayList arraylist)
    {
        this$0 = FoundItemsCategoriesActivity.this;
        super();
        inflater = (LayoutInflater)founditemscategoriesactivity1.getSystemService("layout_inflater");
        categoryNodeList = arraylist;
        groupLayoutResource = i;
        childLayoutResource = j;
    }
}
