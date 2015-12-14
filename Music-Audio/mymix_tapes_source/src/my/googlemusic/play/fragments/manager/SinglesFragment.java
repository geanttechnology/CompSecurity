// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import java.util.List;
import my.googlemusic.play.activities.AlbumActivity;
import my.googlemusic.play.adapters.manager.GridAlbumAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.ListSpaceUtil;
import my.googlemusic.play.utils.views.RobotoTextView;

public class SinglesFragment extends Fragment
    implements my.googlemusic.play.adapters.manager.GridAlbumAdapter.OnAlbumClickListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, my.googlemusic.play.interfaces.Server.ServerCallback
{

    private SwingBottomInAnimationAdapter mAdapter;
    GridAlbumAdapter mGridAdapter;
    private ViewHolder mHolder;
    private Server mServer;

    public SinglesFragment()
    {
    }

    private void initData()
    {
        mServer = ((App)getActivity().getApplication()).getServer();
    }

    private void initSingles()
    {
        mServer.getSinglesFromServer(this);
    }

    private void initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder(null);
        mHolder.grid = (ListView)view.findViewById(0x7f0d0235);
        mHolder.errorView = view.findViewById(0x7f0d01aa);
        mHolder.refresh = (ImageView)view.findViewById(0x7f0d01ab);
        mHolder.loading = (ProgressBar)view.findViewById(0x7f0d0236);
        ViewHolder.access._mth102(mHolder, (SwipeRefreshLayout)view.findViewById(0x7f0d0234));
        mHolder.errorMessage = (RobotoTextView)view.findViewById(0x7f0d01ac);
        mHolder.errorView.setOnClickListener(new _cls1());
        ViewHolder.access._mth100(mHolder).setOnRefreshListener(this);
        setLoading(true);
    }

    public static SinglesFragment newInstance()
    {
        return new SinglesFragment();
    }

    private void setErrorView(boolean flag)
    {
        View view = mHolder.errorView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void setLoading(boolean flag)
    {
        ProgressBar progressbar = mHolder.loading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        progressbar.setVisibility(i);
    }

    public void onAlbumClick(Album album)
    {
        Intent intent = new Intent(getActivity(), my/googlemusic/play/activities/AlbumActivity);
        intent.putExtra("albumId", album.getId());
        startActivity(intent);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030065, viewgroup, false);
        initData();
        initView(layoutinflater);
        initSingles();
        return layoutinflater;
    }

    public void onFailed(Object obj)
    {
        setLoading(false);
        setErrorView(true);
    }

    public void onRefresh()
    {
        initSingles();
    }

    public void onResume()
    {
        super.onResume();
        initSingles();
    }

    public void onSuccess(Object obj)
    {
        if (obj != null)
        {
            obj = (List)obj;
            if (mGridAdapter == null)
            {
                mGridAdapter = new GridAlbumAdapter(getActivity(), ((List) (obj)), 3, this);
                mAdapter = new SwingBottomInAnimationAdapter(mGridAdapter);
                if (mHolder.grid.getFooterViewsCount() == 0)
                {
                    if (mServer.getUser().isPremium())
                    {
                        mHolder.grid.addFooterView(ListSpaceUtil.getSpace(getActivity(), 50), null, false);
                    } else
                    {
                        mHolder.grid.addFooterView(ListSpaceUtil.getSpace(getActivity(), 100), null, false);
                    }
                }
                mAdapter.setAbsListView(mHolder.grid);
                mHolder.grid.setAdapter(mAdapter);
            } else
            {
                mGridAdapter.setList(((List) (obj)));
                mGridAdapter.notifyDataSetChanged();
            }
        }
        setLoading(false);
        setErrorView(false);
        ViewHolder.access._mth100(mHolder).setRefreshing(false);
    }

    /* member class not found */
    class _cls1 {}

}
