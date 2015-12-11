// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.h.c.u;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.ui.adapter.h.b;
import com.target.ui.e.f;
import com.target.ui.layout_manager.CascadeLayoutManager;
import com.target.ui.model.shop.a;
import com.target.ui.util.ac;
import com.target.ui.util.al;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.shop:
//            PageItemView

public class PageItemLayout extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        TargetErrorView errorView;
        View progressContainer;
        RecyclerView recyclerView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a extends android.support.v7.widget.RecyclerView.k
    {

        final u picasso;
        final PageItemLayout this$0;

        public void a(RecyclerView recyclerview, int i)
        {
            super.a(recyclerview, i);
            switch (i)
            {
            default:
                picasso.b(PageItemView.IMAGE_LOADING_TAG);
                if (com.target.ui.view.shop.PageItemLayout.a(PageItemLayout.this) != null)
                {
                    com.target.ui.view.shop.PageItemLayout.a(PageItemLayout.this).f();
                }
                return;

            case 2: // '\002'
                picasso.a(PageItemView.IMAGE_LOADING_TAG);
                return;
            }
        }

        public void a(RecyclerView recyclerview, int i, int j)
        {
            super.a(recyclerview, i, j);
            if (com.target.ui.view.shop.PageItemLayout.a(PageItemLayout.this) == null)
            {
                return;
            } else
            {
                com.target.ui.view.shop.PageItemLayout.a(PageItemLayout.this).b(j);
                return;
            }
        }

        private a()
        {
            this$0 = PageItemLayout.this;
            super();
            picasso = u.a(getContext());
        }

    }


    private static final float ASPECT_RATIO = 0.8F;
    private static final int NUM_COLUMNS = 3;
    public static final String TAG = com/target/ui/view/shop/PageItemLayout.getSimpleName();
    private b mAdapter;
    private List mPageItemElements;
    private f mScrollingTabCoordinator;
    private Views mViews;

    public PageItemLayout(Context context)
    {
        super(context);
        mPageItemElements = new ArrayList();
        a();
    }

    public PageItemLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mPageItemElements = new ArrayList();
        a();
    }

    public PageItemLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPageItemElements = new ArrayList();
        a();
    }

    static f a(PageItemLayout pageitemlayout)
    {
        return pageitemlayout.mScrollingTabCoordinator;
    }

    private void a()
    {
        inflate(getContext(), 0x7f03017d, this);
        mViews = new Views(this);
        b();
        c();
        c();
    }

    private void b()
    {
        int i = ac.b(getContext());
        CascadeLayoutManager cascadelayoutmanager = new CascadeLayoutManager(getContext(), 3, 0.8F, i, i);
        mAdapter = new b(mPageItemElements, 3);
        mViews.recyclerView.setLayoutManager(cascadelayoutmanager);
        mViews.recyclerView.setAdapter(mAdapter);
        mViews.recyclerView.setOnScrollListener(new a());
        mViews.recyclerView.setHasFixedSize(true);
    }

    private void c()
    {
        al.c(mViews.progressContainer);
    }

    private void setDataInternal(List list)
    {
        mPageItemElements.clear();
        PageItem pageitem;
        for (list = list.iterator(); list.hasNext(); mPageItemElements.add(new com.target.ui.model.shop.a(pageitem)))
        {
            pageitem = (PageItem)list.next();
        }

        mAdapter.e();
    }

    public void a(com.target.ui.view.common.b.a a1, boolean flag)
    {
        al.a(mViews.errorView, new View[] {
            mViews.recyclerView, mViews.progressContainer
        });
        mViews.errorView.a(a1, flag);
    }

    public void a(URL url, DvmDataResponse dvmdataresponse)
    {
        mAdapter.a(url, dvmdataresponse);
    }

    public void a(boolean flag)
    {
        al.a(mViews.errorView, false);
        if (flag)
        {
            al.a(mViews.progressContainer, new View[] {
                mViews.recyclerView
            });
            return;
        } else
        {
            al.a(mViews.recyclerView, new View[] {
                mViews.progressContainer
            });
            return;
        }
    }

    public void setData(List list)
    {
        setDataInternal(list);
    }

    public void setErrorViewTryAgainListener(c c1)
    {
        mViews.errorView.setClickListener(c1);
    }

    public void setOnDvmViewClickListener(com.target.ui.adapter.h.b.b b1)
    {
        mAdapter.a(b1);
    }

    public void setOnItemClickListener(com.target.ui.adapter.h.b.c c1)
    {
        mAdapter.a(c1);
    }

    public void setOnWeeklyAdCardViewClickListener(com.target.ui.adapter.h.b.d d)
    {
        mAdapter.a(d);
    }

    public void setScrollingTabCoordinator(f f1)
    {
        mScrollingTabCoordinator = f1;
        if (mScrollingTabCoordinator != null)
        {
            mViews.recyclerView.setClipToPadding(false);
            mViews.recyclerView.setPadding(mViews.recyclerView.getPaddingLeft(), mViews.recyclerView.getPaddingTop() + mScrollingTabCoordinator.e(), mViews.recyclerView.getPaddingRight(), mViews.recyclerView.getPaddingBottom());
        }
    }

    public void setShouldUseCustomWeeklyAdTile(boolean flag)
    {
        mAdapter.b(flag);
    }

    public void setWeeklyAdData(List list)
    {
        mAdapter.a(list);
    }

}
