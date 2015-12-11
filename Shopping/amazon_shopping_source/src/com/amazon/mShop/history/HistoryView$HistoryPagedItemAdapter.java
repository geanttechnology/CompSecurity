// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.PagedItemAdapter;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.history.HistoryBrowser;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.ui.BottomToolBar;
import java.util.List;

// Referenced classes of package com.amazon.mShop.history:
//            HistoryView, HistoryItemView

private class this._cls0 extends PagedItemAdapter
{

    final HistoryView this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        browser.setCurrentIndex(i);
        byte abyte0[];
        int j;
        int k;
        if (view == null)
        {
            view = (HistoryItemView)layoutInflater.inflate(rowResId, null);
            view.setObserver(HistoryView.this);
        } else
        {
            view = (HistoryItemView)view;
        }
        viewgroup = ((ViewGroup) (browser.getObjectAtIndex(i)));
        j = i;
        k = j;
        if (HistoryView.access$000(HistoryView.this) != -1)
        {
            k = j;
            if (i > HistoryView.access$000(HistoryView.this))
            {
                k = j - 1;
            }
        }
        abyte0 = browser.getImageAtIndex(i);
        view.setObjectIndex(i);
        view.setTag(HistoryView.access$100(HistoryView.this).get(i));
        view.update(this, viewgroup, abyte0, k);
        if (i == HistoryView.access$000(HistoryView.this))
        {
            view.showUndoGroup();
            return view;
        } else
        {
            view.showItemGroup();
            return view;
        }
    }

    public boolean isEnabled(int i)
    {
        return i != HistoryView.access$000(HistoryView.this);
    }

    protected Object makeObjectForForward()
    {
        ProductController productcontroller = (ProductController)super.makeObjectForForward();
        productcontroller.setClickStreamTag(ClickStreamTag.ORIGIN_RVI);
        return productcontroller;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        RefMarkerObserver.logRefMarker("dp_rvi");
        super.onItemClick(adapterview, view, i, l);
        if (deleteAsinsFromDB())
        {
            refresh();
        }
    }

    public void onPageComplete()
    {
        super.onPageComplete();
        HistoryView.access$200(HistoryView.this).setToolBarEnabled(true);
        if (HistoryView.access$300(HistoryView.this).getAvailableItemCount() > HistoryView.access$300(HistoryView.this).getReceivedCount())
        {
            HistoryView.access$400(HistoryView.this);
            return;
        } else
        {
            HistoryView.access$500(HistoryView.this);
            return;
        }
    }

    public (AmazonActivity amazonactivity, int i)
    {
        this$0 = HistoryView.this;
        super(amazonactivity, i);
    }
}
