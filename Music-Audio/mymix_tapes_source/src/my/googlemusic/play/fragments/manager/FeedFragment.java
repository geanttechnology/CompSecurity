// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import my.googlemusic.play.adapters.feed.ParallaxRecyclerAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.feed.FeedBox;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;

public class FeedFragment extends Fragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
{

    private boolean hasLoading;
    private ParallaxRecyclerAdapter mAdapter;
    private FeedBox mData;
    private ProgressBar mLoading;
    private View mNoActivity;
    private Server mServer;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshView;

    public FeedFragment()
    {
    }

    private void Load()
    {
        mServer.getFeed(mServer.getUser().getId(), 20, "", new _cls1());
    }

    private void initData()
    {
        mServer = ((App)getActivity().getApplication()).getServer();
        Load();
    }

    private void initView(View view)
    {
        recyclerView = (RecyclerView)view.findViewById(0x7f0d0255);
        refreshView = (SwipeRefreshLayout)view.findViewById(0x7f0d0254);
        mLoading = (ProgressBar)view.findViewById(0x7f0d0256);
        mNoActivity = view.findViewById(0x7f0d01a2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        refreshView.setOnRefreshListener(this);
    }

    private boolean isLoadingData()
    {
        return hasLoading;
    }

    private boolean isRefreshing()
    {
        return refreshView.isRefreshing();
    }

    private void setIsLoadingData(boolean flag)
    {
        hasLoading = flag;
        ProgressBar progressbar = mLoading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        progressbar.setVisibility(i);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006e, viewgroup, false);
        initView(layoutinflater);
        initData();
        return layoutinflater;
    }

    public void onRefresh()
    {
        Load();
    }



/*
    static FeedBox access$002(FeedFragment feedfragment, FeedBox feedbox)
    {
        feedfragment.mData = feedbox;
        return feedbox;
    }

*/



/*
    static ParallaxRecyclerAdapter access$102(FeedFragment feedfragment, ParallaxRecyclerAdapter parallaxrecycleradapter)
    {
        feedfragment.mAdapter = parallaxrecycleradapter;
        return parallaxrecycleradapter;
    }

*/





    /* member class not found */
    class _cls1 {}

}
