// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.models.Place;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchResultFragment

protected class inflater extends BaseAdapter
{

    private LayoutInflater inflater;
    final GlobalSearchResultFragment this$0;

    public int getCount()
    {
        return GlobalSearchResultFragment.access$700(GlobalSearchResultFragment.this)[4];
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
label0:
        {
            if (view != null)
            {
                view1 = view;
                if (view.getId() == 0x7f1002ff)
                {
                    break label0;
                }
            }
            view1 = inflater.inflate(0x7f030104, viewgroup, false);
        }
        view = (TextView)view1.findViewById(0x7f100300);
        viewgroup = getGlobalSearchResultActivity().getPlace();
        if (Strings.equalsIgnoreCase(((Place) (viewgroup)).label, getResources().getString(0x7f0801fa)))
        {
            view.setText(getString(0x7f0801f9));
            return view1;
        } else
        {
            view.setText(String.format(getString(0x7f0801f8), new Object[] {
                ((Place) (viewgroup)).label
            }));
            return view1;
        }
    }

    public (LayoutInflater layoutinflater)
    {
        this$0 = GlobalSearchResultFragment.this;
        super();
        inflater = layoutinflater;
    }
}
