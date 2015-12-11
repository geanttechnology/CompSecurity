// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchResultFragment

protected class inflater extends BaseAdapter
{

    private LayoutInflater inflater;
    final GlobalSearchResultFragment this$0;

    public int getCount()
    {
        return GlobalSearchResultFragment.access$700(GlobalSearchResultFragment.this)[1];
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
        ((TextView)view1.findViewById(0x7f100300)).setText(getString(0x7f0801fb));
        return view1;
    }

    public (LayoutInflater layoutinflater)
    {
        this$0 = GlobalSearchResultFragment.this;
        super();
        inflater = layoutinflater;
    }
}
