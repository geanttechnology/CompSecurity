// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.poshmark.data_model.models.PMData;
import com.poshmark.utils.ViewUtils;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMListView

class this._cls0
    implements android.widget.nScrollListener
{

    final PMListView this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
label0:
        {
            if (!PMListView.access$000(PMListView.this) && k > 1 && i + j >= k)
            {
                PMListView.access$002(PMListView.this, true);
                if (listData == null || listData.getNextPageMaxValue() == null)
                {
                    break label0;
                }
                ViewUtils.showLoadingProgress(getContext(), footerView);
                if (loadMoreItemsListener != null)
                {
                    loadMoreItemsListener.loadItems(true);
                }
            }
            return;
        }
        PMListView.access$002(PMListView.this, false);
        abslistview = (LinearLayout)footerView.findViewById(0x7f0c012d);
        abslistview.removeAllViews();
        ViewUtils.addEmptyView(getContext(), abslistview, 15, false);
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    adMoreItemsListener()
    {
        this$0 = PMListView.this;
        super();
    }
}
