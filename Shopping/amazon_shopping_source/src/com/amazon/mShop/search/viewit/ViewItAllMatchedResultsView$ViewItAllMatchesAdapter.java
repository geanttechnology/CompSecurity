// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItAllMatchedResultsView, ViewItSearchResultWrapper, ViewItItemView, ViewItSlidingDrawerBrowser

public class this._cls0 extends BaseAdapter
{

    final ViewItAllMatchedResultsView this$0;

    public int getCount()
    {
        if (Util.isEmpty(ViewItAllMatchedResultsView.access$000(ViewItAllMatchedResultsView.this).getSearchResults()))
        {
            return 0;
        } else
        {
            return ViewItAllMatchedResultsView.access$000(ViewItAllMatchedResultsView.this).getSearchResults().size();
        }
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (SearchResult)ViewItAllMatchedResultsView.access$000(ViewItAllMatchedResultsView.this).getSearchResults().get(i);
        if (view == null)
        {
            view = (ViewItItemView)LayoutInflater.from(ViewItAllMatchedResultsView.access$100(ViewItAllMatchedResultsView.this)).inflate(com.amazon.mShop.android.lib.r.this._fld0, null);
        } else
        {
            view = (ViewItItemView)view;
        }
        view.setObject(ViewItAllMatchedResultsView.access$000(ViewItAllMatchedResultsView.this), viewgroup, ViewItAllMatchedResultsView.access$200(ViewItAllMatchedResultsView.this), );
        view.updateButtonVisibility();
        if (ViewItAllMatchedResultsView.access$200(ViewItAllMatchedResultsView.this).isObjectToDelete(ViewItAllMatchedResultsView.access$000(ViewItAllMatchedResultsView.this), viewgroup, ))
        {
            view.showUndoButtonContent();
        } else
        {
            view.showItemContent();
        }
        view.update(null, viewgroup, (byte[])null, i);
        view.setItemClickAction(ViewItAllMatchedResultsView.access$300(ViewItAllMatchedResultsView.this), viewgroup, ViewItAllMatchedResultsView.access$000(ViewItAllMatchedResultsView.this), true);
        return view;
    }

    public ()
    {
        this$0 = ViewItAllMatchedResultsView.this;
        super();
    }
}
