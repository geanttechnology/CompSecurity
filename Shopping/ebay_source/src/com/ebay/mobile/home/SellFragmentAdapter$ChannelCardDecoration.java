// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.SellingOverviewModel;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            SellFragmentAdapter

private class <init> extends android.support.v7.widget.>
{

    final SellFragmentAdapter this$0;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.> >)
    {
        int j = recyclerview.getChildAdapterPosition(view);
        if (j >= 0 && j < SellFragmentAdapter.access$200(SellFragmentAdapter.this).size())
        {
            view = (ViewModel)SellFragmentAdapter.access$300(SellFragmentAdapter.this).get(j);
            int i;
            if (SellFragmentAdapter.isTablet)
            {
                i = SellFragmentAdapter.access$400(SellFragmentAdapter.this).getDimensionPixelSize(0x7f09007a);
            } else
            {
                i = 0;
            }
            if (view == null || ((ViewModel) (view)).viewType != 18)
            {
                if (recyclerview.getLayoutManager() instanceof GridLayoutManager)
                {
                    if (((Integer)SellFragmentAdapter.access$100(SellFragmentAdapter.this).get(j)).intValue() == 1)
                    {
                        if (j == 0 || j == 1 && ((Integer)SellFragmentAdapter.access$100(SellFragmentAdapter.this).get(0)).intValue() == 1)
                        {
                            rect.top = i;
                        }
                        if (j == SellFragmentAdapter.access$500(SellFragmentAdapter.this).size() - 2 && ((Integer)SellFragmentAdapter.access$100(SellFragmentAdapter.this).get(SellFragmentAdapter.access$600(SellFragmentAdapter.this).size() - 1)).intValue() == 1 || j == SellFragmentAdapter.access$700(SellFragmentAdapter.this).size() - 1)
                        {
                            rect.bottom = i;
                        }
                        view = (SellingOverviewModel)view;
                        if (view != null && ((SellingOverviewModel) (view)).sellingImageList != null)
                        {
                            if (((SellingOverviewModel) (view)).sellingImageList.name == com.ebay.nautilus.domain.data.UnifiedStream.alet)
                            {
                                rect.left = i;
                                rect.right = 0;
                                return;
                            }
                            if (((SellingOverviewModel) (view)).sellingImageList.name == com.ebay.nautilus.domain.data.UnifiedStream.ellingTips)
                            {
                                rect.right = i;
                                rect.left = 0;
                                return;
                            }
                        }
                    } else
                    {
                        rect.left = i;
                        rect.right = i;
                        if (j == 0)
                        {
                            rect.top = i;
                        }
                        if (j == SellFragmentAdapter.access$800(SellFragmentAdapter.this).size() - 1)
                        {
                            rect.bottom = i;
                            return;
                        }
                    }
                } else
                {
                    if (j == 0)
                    {
                        rect.top = i;
                    }
                    if (j == SellFragmentAdapter.access$900(SellFragmentAdapter.this).size() - 1)
                    {
                        rect.bottom = i;
                    }
                    rect.left = i;
                    rect.right = i;
                    return;
                }
            }
        }
    }

    private up.ContentRecord.Name()
    {
        this$0 = SellFragmentAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
