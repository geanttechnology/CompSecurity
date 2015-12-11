// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groupon.models.category.Category;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

protected class categories extends ArrayAdapter
{

    private List categories;
    private LayoutInflater inflater;
    final NearbyDealsFragment this$0;

    public int getCount()
    {
        return categories.size() + 1;
    }

    public final Category getItem(int i)
    {
        if (i == 0)
        {
            return null;
        } else
        {
            return (Category)categories.get(i - 1);
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = inflater.inflate(0x7f030178, viewgroup, false);
        }
        view = (TextView)view1.findViewById(0x7f100458);
        viewgroup = view1.findViewById(0x7f100327);
        Category category = getItem(i);
        viewgroup.setVisibility(8);
        if (category == null)
        {
            view.setText(0x7f08005e);
            return view1;
        }
        if (isGTGOnNearby && Strings.equals(category.id, "gtg_mock_category_id"))
        {
            if (isGTGNewFlagDivision)
            {
                viewgroup.setVisibility(0);
            }
            view.setText(0x7f08012f);
            return view1;
        } else
        {
            view.setText(category.name);
            return view1;
        }
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public void setCategories(List list)
    {
        categories = list;
    }

    public (Context context)
    {
        this$0 = NearbyDealsFragment.this;
        super(context, 0x1090006);
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        categories = new ArrayList();
    }
}
