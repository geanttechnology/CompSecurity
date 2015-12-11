// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.item.ProductController;

// Referenced classes of package com.amazon.mShop:
//            PagedListingAdapter, AmazonActivity, ItemView

public class PagedItemAdapter extends PagedListingAdapter
    implements android.widget.AdapterView.OnItemClickListener
{

    protected final LayoutInflater layoutInflater;
    private ListView listView;
    protected final int rowResId;

    public PagedItemAdapter(AmazonActivity amazonactivity, int i)
    {
        super(amazonactivity);
        layoutInflater = LayoutInflater.from(amazonactivity);
        rowResId = i;
    }

    public void forward(int i)
    {
        if (i < 0 || i >= browser.getReceivedCount())
        {
            return;
        } else
        {
            browser.setCurrentIndex(i);
            getAmazonActivity().forward(makeObjectForForward());
            return;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        browser.setCurrentIndex(i);
        if (view == null)
        {
            view = (ItemView)layoutInflater.inflate(rowResId, null);
        } else
        {
            view = (ItemView)view;
        }
        view.update(this, browser.getObjectAtIndex(i), browser.getImageAtIndex(i), i);
        return view;
    }

    protected Object makeObjectForForward()
    {
        ProductController productcontroller = new ProductController(browser.getCurrentObject());
        productcontroller.setThumbnail(browser.getCurrentImage());
        return productcontroller;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j;
        if (listView == null)
        {
            j = 0;
        } else
        {
            j = listView.getHeaderViewsCount();
        }
        forward(i - j);
    }

    public void setListView(ListView listview)
    {
        listView = listview;
        listview.setAdapter(this);
        listview.setOnItemClickListener(this);
    }
}
