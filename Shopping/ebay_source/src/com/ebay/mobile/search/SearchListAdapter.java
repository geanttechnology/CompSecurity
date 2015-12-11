// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import com.ebay.common.view.SearchResultListAdapter;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.util.ArrayList;
import java.util.List;

public final class SearchListAdapter extends SearchResultListAdapter
{

    private static final int DEFAULT_RELATED_SEARCHES_MULTIPLE = 20;
    private static final int MAX_DISPLAYABLE_RELATED_SEARCHES = 5;
    public static final int RELATED_SEARCH_VIEW_ITEM_TYPE = 1;
    public static final int SEARCH_RESULT_VIEW_ITEM_TYPE = 0;
    private static int relatedSearchesMultiple = 20;
    private final List headerViews = new ArrayList();
    private int relatedSearchesLayoutId;
    private final String relatedSearchesText;

    public SearchListAdapter(Activity activity, boolean flag, int i, List list, List list1, int j)
    {
        super(activity, flag, i, list, false);
        setLayout(j);
        relatedSearchesMultiple = 20;
        if (list1 != null && list1.size() > 0 && list != null && list.size() > 0)
        {
            relatedSearchesLayoutId = 0x7f0301bf;
            if (list.size() < relatedSearchesMultiple)
            {
                relatedSearchesMultiple = list.size() + 1;
            }
            relatedSearchesText = createRelatedSearchesText(list1);
            return;
        } else
        {
            relatedSearchesText = null;
            return;
        }
    }

    private String createRelatedSearchesText(List list)
    {
        int j = Math.min(5, list.size());
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < j - 1; i++)
        {
            stringbuilder.append((new StringBuilder()).append((String)list.get(i)).append(", ").toString());
        }

        stringbuilder.append((String)list.get(j - 1));
        return stringbuilder.toString();
    }

    private boolean isHeaderView(int i)
    {
        return i < headerViews.size();
    }

    private boolean isRelatedSearchesAvailable()
    {
        return relatedSearchesText != null;
    }

    public static boolean isRelatedSearchesItem(int i)
    {
        return (i + 1) % relatedSearchesMultiple == 0;
    }

    private int removeRelatedSearchesFromPosition(int i)
    {
        return i - i / relatedSearchesMultiple;
    }

    public void addHeaderView(View view, GridView gridview)
    {
        headerViews.add(view);
        gridview.setAdapter(this);
    }

    public int getCount()
    {
        if (!isRelatedSearchesAvailable())
        {
            return super.getCount() + headerViews.size();
        } else
        {
            int i = super.getCount();
            return i + i / (relatedSearchesMultiple - 1) + headerViews.size();
        }
    }

    public List getHeaderViews()
    {
        return headerViews;
    }

    public EbaySearchListItem getItem(int i)
    {
        if (!isHeaderView(i))
        {
            i = removeHeaderFromPosition(i);
            if (!isRelatedSearchesAvailable())
            {
                return super.getItem(i);
            }
            if (!isRelatedSearchesItem(i))
            {
                return super.getItem(removeRelatedSearchesFromPosition(i));
            }
        }
        return null;
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public int getItemViewType(int i)
    {
        if (isHeaderView(i))
        {
            return -1;
        }
        if (!isRelatedSearchesAvailable())
        {
            return super.getItemViewType(i);
        }
        return !isRelatedSearchesItem(i - headerViews.size()) ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (isHeaderView(i))
        {
            return (View)headerViews.get(i);
        }
        if (isRelatedSearchesAvailable() && isRelatedSearchesItem(i - headerViews.size()))
        {
            View view1 = view;
            if (view == null)
            {
                view1 = inflater.inflate(relatedSearchesLayoutId, viewgroup, false);
                ((TextView)view1.findViewById(0x7f10054a)).setText(Html.fromHtml("<b>".concat(getContext().getString(0x7f07090d)).concat("</b><br/>").concat(relatedSearchesText)));
            }
            return view1;
        } else
        {
            return super.getView(i, view, viewgroup);
        }
    }

    public int getViewTypeCount()
    {
        int j = super.getViewTypeCount();
        int i = j;
        if (isRelatedSearchesAvailable())
        {
            i = j + 1;
        }
        return i;
    }

    public int removeHeaderFromPosition(int i)
    {
        return i - headerViews.size();
    }

}
