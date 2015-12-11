// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.list_view.SnapGroceryDetailsWrapper;
import com.groupon.view.dealcards.GroceryItemView;
import java.util.Iterator;
import java.util.List;

public class GroceryItemLayout extends LinearLayout
{
    private class OnGroceryClicked
        implements android.view.View.OnClickListener
    {

        private GroceryItemView groceryItem;
        final GroceryItemLayout this$0;
        private IViewCallback viewCallback;

        public void onClick(View view)
        {
            if (viewCallback != null)
            {
                viewCallback.onViewClick(groceryItem);
            }
        }

        public OnGroceryClicked(IViewCallback iviewcallback, GroceryItemView groceryitemview)
        {
            this$0 = GroceryItemLayout.this;
            super();
            viewCallback = iviewcallback;
            groceryItem = groceryitemview;
        }
    }


    public GroceryItemLayout(Context context)
    {
        super(context);
    }

    public GroceryItemLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public GroceryItemLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setGroceryDetailsList(SnapGroceryDetailsWrapper snapgrocerydetailswrapper, IViewCallback iviewcallback)
    {
        removeAllViews();
        GroceryItemView groceryitemview;
        for (snapgrocerydetailswrapper = snapgrocerydetailswrapper.snapGroceryDetailList.iterator(); snapgrocerydetailswrapper.hasNext(); addView(groceryitemview))
        {
            SnapGroceryDetail snapgrocerydetail = (SnapGroceryDetail)snapgrocerydetailswrapper.next();
            groceryitemview = (GroceryItemView)LayoutInflater.from(getContext()).inflate(0x7f030123, this, false);
            if (snapgrocerydetail.isPlaceHolder)
            {
                groceryitemview.setVisibility(4);
            }
            groceryitemview.setGroceryDetail(snapgrocerydetail);
            groceryitemview.setOnClickListener(new OnGroceryClicked(iviewcallback, groceryitemview));
        }

    }
}
