// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.amazon.now.search.SearchIntentBuilder;
import com.amazon.retailsearch.android.api.log.CategoryBrowseLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import java.util.List;

class BrowseListAdapter extends BaseAdapter
{

    private final CategoryBrowseLogger mBrowseLogger = RetailSearchLoggingProvider.getInstance().getCategoryBrowseLogger();
    private final Context mContext;
    private final Department mDepartment;

    public BrowseListAdapter(Context context, Department department)
    {
        mContext = context;
        mDepartment = department;
    }

    public int getCount()
    {
        if (!Utils.isEmpty(mDepartment.getCategories()))
        {
            return mDepartment.getCategories().size();
        } else
        {
            return 0;
        }
    }

    public RefinementLink getItem(int i)
    {
        if (!Utils.isEmpty(mDepartment.getCategories()))
        {
            return (RefinementLink)mDepartment.getCategories().get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, final View link, ViewGroup viewgroup)
    {
        View view = link;
        if (link == null)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f030004, viewgroup, false);
        }
        link = getItem(i);
        viewgroup = (TextView)view;
        viewgroup.setText(link.getText());
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            final BrowseListAdapter this$0;
            final RefinementLink val$link;

            public void onClick(View view1)
            {
                view1 = new SearchIntentBuilder(mContext);
                view1.dataUrl(link.getUrl());
                view1.categoryName(link.getText());
                mContext.startActivity(view1.build());
                mBrowseLogger.recordDepartmentMenuClickInBrowse();
            }

            
            {
                this$0 = BrowseListAdapter.this;
                link = refinementlink;
                super();
            }
        });
        return view;
    }


}
