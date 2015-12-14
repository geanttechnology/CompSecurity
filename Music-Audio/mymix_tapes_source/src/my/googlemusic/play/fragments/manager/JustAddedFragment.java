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
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.activities.AlbumActivity;
import my.googlemusic.play.adapters.manager.GridAlbumAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.utils.views.RobotoTextView;

public class JustAddedFragment extends Fragment
    implements android.view.View.OnClickListener, android.widget.AbsListView.OnScrollListener, my.googlemusic.play.adapters.manager.GridAlbumAdapter.OnAlbumClickListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, my.googlemusic.play.interfaces.Server.ServerCallback
{

    private static final int size = 15;
    private SwingBottomInAnimationAdapter animationAdapter;
    private List mAlbumList;
    private GridAlbumAdapter mGridAdapter;
    private ViewHolder mHolder;
    private boolean mLoading;
    private Server mServer;

    public JustAddedFragment()
    {
    }

    private SwingBottomInAnimationAdapter getAnimationAdapter()
    {
        return animationAdapter;
    }

    private void initJustAdded()
    {
        mServer.getJustAddedFromServer(this);
    }

    private ViewHolder initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder(null);
        ViewHolder.access._mth102(mHolder, (ListView)view.findViewById(0x7f0d0235));
        ViewHolder.access._mth202(mHolder, LayoutInflater.from(getActivity()).inflate(0x7f030040, ViewHolder.access._mth100(mHolder), false));
        ViewHolder.access._mth302(mHolder, view.findViewById(0x7f0d01aa));
        ViewHolder.access._mth402(mHolder, (ImageView)view.findViewById(0x7f0d01ab));
        ViewHolder.access._mth502(mHolder, (ProgressBar)view.findViewById(0x7f0d0236));
        ViewHolder.access._mth602(mHolder, (SwipeRefreshLayout)view.findViewById(0x7f0d0234));
        ViewHolder.access._mth702(mHolder, (RobotoTextView)view.findViewById(0x7f0d01ac));
        ViewHolder.access._mth300(mHolder).setVisibility(4);
        ViewHolder.access._mth200(mHolder).setBackgroundColor(0xff000000);
        ViewHolder.access._mth100(mHolder).addFooterView(ViewHolder.access._mth200(mHolder));
        ViewHolder.access._mth300(mHolder).setOnClickListener(this);
        ViewHolder.access._mth600(mHolder).setOnRefreshListener(this);
        return mHolder;
    }

    public static JustAddedFragment newInstance()
    {
        return new JustAddedFragment();
    }

    private void setAdapter()
    {
        getAnimationAdapter().setAbsListView(ViewHolder.access._mth100(mHolder));
        ViewHolder.access._mth100(mHolder).setAdapter(getAnimationAdapter());
    }

    private void setAnimationAdapter(GridAlbumAdapter gridalbumadapter)
    {
        animationAdapter = new SwingBottomInAnimationAdapter(gridalbumadapter);
    }

    private void setErrorView(boolean flag)
    {
        View view = ViewHolder.access._mth300(mHolder);
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

    private void setLoadMoreScrollListener()
    {
        if (ViewHolder.access._mth100(mHolder) != null && mAlbumList.size() != 0)
        {
            ViewHolder.access._mth100(mHolder).setOnScrollListener(this);
        }
    }

    private void setLoading(boolean flag)
    {
        View view = ViewHolder.access._mth200(mHolder);
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

    private void setLoadingRefresh(boolean flag)
    {
        ProgressBar progressbar = ViewHolder.access._mth500(mHolder);
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

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0d01aa && mAlbumList.size() == 0)
        {
            ViewHolder.access._mth400(mHolder).setVisibility(8);
            ViewHolder.access._mth500(mHolder).setVisibility(0);
            initJustAdded();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030065, viewgroup, false);
        initView(layoutinflater);
        mAlbumList = new ArrayList();
        mServer = ((App)getActivity().getApplication()).getServer();
        initJustAdded();
        return layoutinflater;
    }

    public void onFailed(Object obj)
    {
        mLoading = false;
        setLoading(false);
        setErrorView(true);
    }

    public void onRefresh()
    {
        initJustAdded();
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (j + i >= k && !mLoading)
        {
            mLoading = true;
            mServer.loadMoreJustAdded(this, ((Album)mAlbumList.get(mAlbumList.size() - 1)).getId(), 15);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj != null)
        {
            obj = (List)obj;
            mAlbumList = ((List) (obj));
            if (mGridAdapter == null)
            {
                mGridAdapter = new GridAlbumAdapter(getActivity(), mAlbumList, 2, this);
                setAnimationAdapter(mGridAdapter);
                setAdapter();
                setLoadMoreScrollListener();
            } else
            {
                mGridAdapter.addList(((List) (obj)));
                mGridAdapter.notifyDataSetChanged();
            }
        }
        mLoading = false;
        setLoading(false);
        setLoadingRefresh(false);
        ViewHolder.access._mth600(mHolder).setRefreshing(false);
    }
}
