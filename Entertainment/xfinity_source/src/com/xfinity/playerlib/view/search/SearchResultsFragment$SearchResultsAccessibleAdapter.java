// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

private class inflater extends BaseAdapter
{

    private Context context;
    private LayoutInflater inflater;
    private List searchResults;
    final SearchResultsFragment this$0;

    public int getCount()
    {
        return searchResults.size();
    }

    public Object getItem(int i)
    {
        return searchResults.get(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Tuple tuple;
        DibicProgram dibicprogram;
        int j;
        if (view == null)
        {
            view = inflater.inflate(com.xfinity.playerlib.ibleAdapter.inflater, null);
            viewgroup = new inflater(null);
            _mth2402(viewgroup, (TextView)view.findViewById(com.xfinity.playerlib.lder));
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (_cls2402)view.getTag();
        }
        tuple = (Tuple)CommonUtils.uncheckedCast(getItem(i));
        dibicprogram = (DibicProgram)tuple.e2;
        _mth2400(viewgroup).setText(dibicprogram.getTitle());
        if (dibicprogram.isMovie())
        {
            j = com.xfinity.playerlib.lder;
        } else
        {
            j = com.xfinity.playerlib.lder;
        }
        _mth2400(viewgroup).setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(j), null, null, null);
        _mth2400(viewgroup).setContentDescription(getVideoContentDescription(tuple, i, getCount()));
        return view;
    }

    public void setSearchResults(List list)
    {
        searchResults = list;
    }

    public (Context context1)
    {
        this$0 = SearchResultsFragment.this;
        super();
        searchResults = Lists.newArrayList();
        context = context1;
        inflater = LayoutInflater.from(context1);
    }
}
