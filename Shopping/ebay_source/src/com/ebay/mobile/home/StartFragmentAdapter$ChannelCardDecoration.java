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
import com.ebay.mobile.home.cards.BuyingOverviewModel;
import com.ebay.mobile.home.cards.SellingOverviewModel;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragmentAdapter

private class <init> extends android.support.v7.widget.>
{

    final StartFragmentAdapter this$0;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.> >)
    {
        int j = recyclerview.getChildAdapterPosition(view);
        if (j >= 0 && j < StartFragmentAdapter.access$200(StartFragmentAdapter.this).size())
        {
            view = (ViewModel)StartFragmentAdapter.access$300(StartFragmentAdapter.this).get(j);
            int i;
            if (StartFragmentAdapter.isTablet)
            {
                i = StartFragmentAdapter.access$400(StartFragmentAdapter.this).getDimensionPixelSize(0x7f090072);
            } else
            {
                i = 0;
            }
            if (view == null || ((ViewModel) (view)).viewType != 0)
            {
                if (recyclerview.getLayoutManager() instanceof GridLayoutManager)
                {
                    if (((Integer)StartFragmentAdapter.access$100(StartFragmentAdapter.this).get(j)).intValue() == 1)
                    {
                        if (j == 0 || j == 1 && ((Integer)StartFragmentAdapter.access$100(StartFragmentAdapter.this).get(0)).intValue() == 1)
                        {
                            rect.top = i;
                        }
                        if (j == StartFragmentAdapter.access$500(StartFragmentAdapter.this).size() - 2 && ((Integer)StartFragmentAdapter.access$100(StartFragmentAdapter.this).get(StartFragmentAdapter.access$600(StartFragmentAdapter.this).size() - 1)).intValue() == 1 || j == StartFragmentAdapter.access$700(StartFragmentAdapter.this).size() - 1)
                        {
                            rect.bottom = i;
                        }
                        if (view != null && (view instanceof BuyingOverviewModel))
                        {
                            rect.left = i;
                            rect.right = 0;
                            return;
                        }
                        if (view != null && (view instanceof SellingOverviewModel))
                        {
                            rect.right = i;
                            rect.left = 0;
                            return;
                        }
                    } else
                    {
                        rect.left = i;
                        rect.right = i;
                        if (j == 0)
                        {
                            rect.top = i;
                        }
                        if (j == StartFragmentAdapter.access$800(StartFragmentAdapter.this).size() - 1)
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
                    if (j == StartFragmentAdapter.access$900(StartFragmentAdapter.this).size() - 1)
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

    private ()
    {
        this$0 = StartFragmentAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
