// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.emilsjolander.components.StickyListHeaders.StickyListHeadersBaseAdapter;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

private static class fullResultsHeader extends StickyListHeadersBaseAdapter
{

    private final String fullResultsHeader;
    private LayoutInflater inflater;
    private final String newResultsHeader;
    private List searchResults;

    public int getCount()
    {
        return searchResults.size();
    }

    public long getHeaderId(int i)
    {
        return !((searchResults)((Tuple)CommonUtils.uncheckedCast(getItem(i))).e1).getItem(getItem) ? 2L : 1L;
    }

    public View getHeaderView(int i, View view)
    {
        Object obj;
        TextView textview;
        Tuple tuple;
        if (view == null)
        {
            obj = new t>(null);
            view = inflater.inflate(com.xfinity.playerlib.ultsAdapter.inflater, null);
            ss._mth2202(((ss._cls2202) (obj)), (TextView)view.findViewById(com.xfinity.playerlib.wHolder));
            view.setTag(obj);
        } else
        {
            obj = (ss._cls2202)view.getTag();
        }
        tuple = (Tuple)CommonUtils.uncheckedCast(getItem(i));
        textview = ss._mth2200(((ss._cls2200) (obj)));
        if (((ss._cls2200)tuple.e1)._mth2200(ss._fld2200))
        {
            obj = newResultsHeader;
        } else
        {
            obj = fullResultsHeader;
        }
        textview.setText(((CharSequence) (obj)));
        return view;
    }

    public Object getItem(int i)
    {
        return searchResults.get(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    protected View getView(int i, View view)
    {
        er er;
        DibicProgram dibicprogram;
        if (view == null)
        {
            view = inflater.inflate(com.xfinity.playerlib.ultsAdapter.inflater, null);
            er = new er(null);
            er.access._mth2402(er, (TextView)view.findViewById(com.xfinity.playerlib.ultsViewHolder));
            view.setTag(er);
        } else
        {
            er = (er)view.getTag();
        }
        dibicprogram = (DibicProgram)((Tuple)CommonUtils.uncheckedCast(getItem(i))).e2;
        er.access._mth2400(er).setText(dibicprogram.getTitle());
        if (dibicprogram.isMovie())
        {
            i = com.xfinity.playerlib.ultsViewHolder;
        } else
        {
            i = com.xfinity.playerlib.ultsViewHolder;
        }
        er.access._mth2400(er).setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(i), null, null, null);
        return view;
    }

    public void setSearchResults(List list)
    {
        searchResults = list;
    }

    public er(Context context)
    {
        super(context);
        searchResults = Lists.newArrayList();
        inflater = LayoutInflater.from(context);
        newResultsHeader = context.getResources().getString(com.xfinity.playerlib.ultsAdapter.newResultsHeader);
        fullResultsHeader = context.getResources().getString(com.xfinity.playerlib.ultsAdapter.fullResultsHeader);
    }
}
