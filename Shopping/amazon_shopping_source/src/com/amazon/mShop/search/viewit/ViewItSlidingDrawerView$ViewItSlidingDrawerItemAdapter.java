// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.PagedItemAdapter;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawerView, ViewItSlidingDrawerBrowser, ViewItSearchResultWrapper, ViewItItemView, 
//            ViewItActivity, ViewItPhotoCaptureView, ViewItDialogHelper

public class this._cls0 extends PagedItemAdapter
{

    final ViewItSlidingDrawerView this$0;

    public int getCount()
    {
        return ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).getRecentlyScannedObjects().size() + ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).getReceivedCount();
    }

    public View getView(int i, final View itemView, ViewGroup viewgroup)
    {
        if (i >= ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).getRecentlyScannedObjects().size())
        {
            ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).setCurrentIndex(i - ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).getRecentlyScannedObjects().size());
        }
        viewgroup = (ViewItSearchResultWrapper)browser.getObjectAtIndex(i);
        SearchResult searchresult = (SearchResult)viewgroup.getSearchResults().get(0);
        if (itemView == null)
        {
            itemView = (ViewItItemView)layoutInflater.inflate(rowResId, null);
        } else
        {
            itemView = (ViewItItemView)itemView;
        }
        itemView.setObject(viewgroup, searchresult, ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this), this._fld0);
        itemView.updateButtonVisibility();
        if (ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).isObjectToDelete(viewgroup, searchresult, this._fld0))
        {
            itemView.showUndoButtonContent();
        } else
        {
            itemView.showItemContent();
        }
        itemView.update(this, viewgroup.getSearchResults().get(0), (byte[])null, i);
        itemView.setItemClickAction(ViewItSlidingDrawerView.this, (SearchResult)viewgroup.getSearchResults().get(0), viewgroup, false);
        if (i == 0 && isClosed())
        {
            com.amazon.mShop.platform.pter.this._mth0().invokeLater(new Runnable() {

                final ViewItSlidingDrawerView.ViewItSlidingDrawerItemAdapter this$1;
                final ViewItItemView val$itemView;

                public void run()
                {
                    if (ViewItSlidingDrawerView.access$200(this$0).getVisibility() == 8)
                    {
                        setBottomOffsetToFirstItemHeight(itemView);
                    }
                }

            
            {
                this$1 = ViewItSlidingDrawerView.ViewItSlidingDrawerItemAdapter.this;
                itemView = viewititemview;
                super();
            }
            });
        }
        return itemView;
    }

    public void onCancelled()
    {
        ViewItSlidingDrawerView.access$100(ViewItSlidingDrawerView.this);
        ViewItSlidingDrawerView.access$600(ViewItSlidingDrawerView.this);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        ViewItSlidingDrawerView.access$100(ViewItSlidingDrawerView.this);
        ViewItSlidingDrawerView.access$600(ViewItSlidingDrawerView.this);
        ViewItSlidingDrawerView.access$700(ViewItSlidingDrawerView.this).getPhotoCaptureView().getViewItDialogHelper().showDialog(null, UIUtils.getMessageForException(ViewItSlidingDrawerView.access$700(ViewItSlidingDrawerView.this), exception), this._fld0);
    }

    public void onPageComplete()
    {
        super.onPageComplete();
        if (ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).getAllHistoryDBObjects().size() > ViewItSlidingDrawerView.access$000(ViewItSlidingDrawerView.this).getNextPageStartIndex())
        {
            ViewItSlidingDrawerView.access$800(ViewItSlidingDrawerView.this);
        } else
        {
            ViewItSlidingDrawerView.access$100(ViewItSlidingDrawerView.this);
        }
        ViewItSlidingDrawerView.access$500(ViewItSlidingDrawerView.this).notifyDataSetChanged();
    }

    public void setBrowser(PagedListingBrowser pagedlistingbrowser)
    {
        super.setBrowser(pagedlistingbrowser);
        ((ViewItSlidingDrawerBrowser)pagedlistingbrowser).setSlidingDrawerPageListingAdapter(this);
    }

    public _cls1.val.itemView(AmazonActivity amazonactivity, int i)
    {
        this$0 = ViewItSlidingDrawerView.this;
        super(amazonactivity, i);
    }
}
