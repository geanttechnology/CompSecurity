// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.BitshopPack;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.adapters.FavouriteAdapter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavouriteFragment extends Fragment
{

    private com.bitstrips.imoji.ui.adapters.FavouriteAdapter.FavouriteClickListener mFavouriteClickListener;
    RecyclerView mRecyclerView;
    RecentImojiesManager recentImojiesManager;
    TemplatesManager templatesManager;

    public FavouriteFragment()
    {
    }

    private LinkedList createAdapterList()
    {
        LinkedList linkedlist;
        boolean flag1;
        linkedlist = new LinkedList();
        linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("RECENT", 0));
        Object obj = recentImojiesManager.getRecentImojies();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("RECENT", (Imoji)((Iterator) (obj)).next(), 2, "recent"))) { }
        } else
        {
            linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("RECENT", 3));
        }
        linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("NEW", 0));
        for (obj = templatesManager.getListForTag("#popmoji").iterator(); ((Iterator) (obj)).hasNext(); linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("NEW", (Imoji)((Iterator) (obj)).next(), 2, "#popmoji"))) { }
        flag1 = true;
        obj = templatesManager.getPacks().iterator();
        do
        {
label0:
            {
                Object obj1;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    obj1 = (BitshopPack)((Iterator) (obj)).next();
                } while (obj1 == null || !((BitshopPack) (obj1)).isPurchased());
                linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem(((BitshopPack) (obj1)).getName(), ((BitshopPack) (obj1)), 1));
                obj1 = ((BitshopPack) (obj1)).getTemplates().iterator();
                boolean flag = flag1;
                do
                {
                    flag1 = flag;
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    Imoji imoji = (Imoji)((Iterator) (obj1)).next();
                    flag1 = flag;
                    if (flag)
                    {
                        flag1 = false;
                    }
                    linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("THEME PACKS", imoji, 2, "#purchased"));
                    flag = flag1;
                } while (true);
            }
        } while (true);
        if (flag1)
        {
            linkedlist.add(new com.bitstrips.imoji.ui.adapters.PolyAdapter.PolyImojiItem("THEME PACKS", 4));
        }
        return linkedlist;
    }

    private GridLayoutManager createLayoutManager(final FavouriteAdapter adapter)
    {
        GridLayoutManager gridlayoutmanager = new GridLayoutManager(getContext(), 3, 1, false);
        gridlayoutmanager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

            final FavouriteFragment this$0;
            final FavouriteAdapter val$adapter;

            public int getSpanSize(int i)
            {
                return adapter.getSpanSizeForItem(i);
            }

            
            {
                this$0 = FavouriteFragment.this;
                adapter = favouriteadapter;
                super();
            }
        });
        return gridlayoutmanager;
    }

    public static FavouriteFragment newInstance()
    {
        return new FavouriteFragment();
    }

    protected int getLayout()
    {
        return 0x7f030038;
    }

    protected void initSubViews(View view)
    {
        ButterKnife.bind(this, view);
        mRecyclerView.setHasFixedSize(true);
        view = new FavouriteAdapter(getContext(), createAdapterList());
        view.setFavouriteClickListener(new com.bitstrips.imoji.ui.adapters.FavouriteAdapter.FavouriteClickListener() {

            final FavouriteFragment this$0;

            public void onClick(Imoji imoji)
            {
                if (mFavouriteClickListener != null)
                {
                    mFavouriteClickListener.onClick(imoji);
                }
            }

            
            {
                this$0 = FavouriteFragment.this;
                super();
            }
        });
        mRecyclerView.setAdapter(view);
        mRecyclerView.setLayoutManager(createLayoutManager(view));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!(activity instanceof com.bitstrips.imoji.ui.adapters.FavouriteAdapter.FavouriteClickListener))
        {
            throw new RuntimeException("the activity must implement FavouriteClickListener");
        } else
        {
            mFavouriteClickListener = (com.bitstrips.imoji.ui.adapters.FavouriteAdapter.FavouriteClickListener)activity;
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        ((InjectorApplication)viewgroup.getContext().getApplicationContext()).inject(this);
        layoutinflater = layoutinflater.inflate(getLayout(), viewgroup, false);
        initSubViews(layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mRecyclerView = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mFavouriteClickListener = null;
    }

}
