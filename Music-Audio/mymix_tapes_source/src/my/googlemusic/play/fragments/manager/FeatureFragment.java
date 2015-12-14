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
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.ListSpaceUtil;
import my.googlemusic.play.utils.views.RobotoTextView;

public class FeatureFragment extends Fragment
    implements my.googlemusic.play.adapters.manager.GridAlbumAdapter.OnAlbumClickListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, my.googlemusic.play.interfaces.Server.ServerCallback
{

    private SwingBottomInAnimationAdapter mAdapter;
    private GridAlbumAdapter mGridAdapter;
    private ViewHolder mHolder;
    private Server mServer;

    public FeatureFragment()
    {
    }

    private void initData()
    {
        mServer = ((App)getActivity().getApplication()).getServer();
    }

    private void initFeatures()
    {
        mServer.getFeaturesFromServer(this);
    }

    private void initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder(null);
        ViewHolder.access._mth102(mHolder, (ListView)view.findViewById(0x7f0d0235));
        ViewHolder.access._mth202(mHolder, view.findViewById(0x7f0d01aa));
        ViewHolder.access._mth302(mHolder, (ImageView)view.findViewById(0x7f0d01ab));
        ViewHolder.access._mth402(mHolder, (ProgressBar)view.findViewById(0x7f0d0236));
        ViewHolder.access._mth502(mHolder, (SwipeRefreshLayout)view.findViewById(0x7f0d0234));
        ViewHolder.access._mth602(mHolder, (RobotoTextView)view.findViewById(0x7f0d01ac));
        ViewHolder.access._mth500(mHolder).setOnRefreshListener(this);
        ViewHolder.access._mth200(mHolder).setOnClickListener(new _cls1());
        setLoading(true);
        setErrorView(false);
    }

    public static FeatureFragment newInstance()
    {
        return new FeatureFragment();
    }

    private void setErrorView(boolean flag)
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

    private void setLoading(boolean flag)
    {
        ProgressBar progressbar = ViewHolder.access._mth400(mHolder);
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
        initFeatures();
        return layoutinflater;
    }

    public void onFailed(Object obj)
    {
        setLoading(false);
        setErrorView(false);
    }

    public void onRefresh()
    {
        initFeatures();
    }

    public void onSuccess(Object obj)
    {
        if (obj != null)
        {
            obj = (List)obj;
            if (mGridAdapter == null)
            {
                mGridAdapter = new GridAlbumAdapter(getActivity(), ((List) (obj)), 1, this);
                mAdapter = new SwingBottomInAnimationAdapter(mGridAdapter);
                if (CompatibilityUtil.getSdkVersion() > 10 && ViewHolder.access._mth100(mHolder).getFooterViewsCount() == 0)
                {
                    if (mServer.getUser().isPremium())
                    {
                        ViewHolder.access._mth100(mHolder).addFooterView(ListSpaceUtil.getSpace(getActivity(), 50), null, false);
                    } else
                    {
                        ViewHolder.access._mth100(mHolder).addFooterView(ListSpaceUtil.getSpace(getActivity(), 100), null, false);
                    }
                }
                mAdapter.setAbsListView(ViewHolder.access._mth100(mHolder));
                ViewHolder.access._mth100(mHolder).setAdapter(mAdapter);
            } else
            {
                mGridAdapter.setList(((List) (obj)));
                mGridAdapter.notifyDataSetChanged();
            }
        }
        setLoading(false);
        ViewHolder.access._mth500(mHolder).setRefreshing(false);
    }


    /* member class not found */
    class _cls1 {}

}
