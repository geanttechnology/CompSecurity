// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.activities.PlayerVideoActivity;
import my.googlemusic.play.adapters.video.VideosAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;
import my.googlemusic.play.model.Video;
import my.googlemusic.play.utils.ListSpaceUtil;

public class VideosFragment extends Fragment
    implements my.googlemusic.play.adapters.video.VideosAdapter.OnVideosClick
{

    private VideosAdapter mAdapter;
    private ViewHolder mHolder;
    private Server mServer;

    public VideosFragment()
    {
    }

    private void initData()
    {
        setLoading(true);
        mServer = ((App)getActivity().getApplication()).getServer();
        mServer.getVideos(new _cls1());
    }

    private void initVideos(List list)
    {
        if (mAdapter == null)
        {
            mAdapter = new VideosAdapter(getActivity(), list, this);
    /* block-local class not found */
    class ViewHolder {}

            mHolder.list.setAdapter(mAdapter);
            if (mServer.getUser().isPremium())
            {
                mHolder.list.addFooterView(ListSpaceUtil.getSpace(getActivity(), 50), null, false);
            } else
            {
                mHolder.list.addFooterView(ListSpaceUtil.getSpace(getActivity(), 100), null, false);
            }
        } else
        {
            mAdapter.setVideosList(list);
            mAdapter.notifyDataSetChanged();
        }
        setLoading(false);
    }

    private void initView(View view)
    {
        mHolder = new ViewHolder(null);
        mHolder.offline = view.findViewById(0x7f0d01a3);
        mHolder.loading = view.findViewById(0x7f0d019b);
        mHolder.list = (ListView)view.findViewById(0x7f0d017a);
        mHolder.goToLibrary = (Button)view.findViewById(0x7f0d01a7);
        mHolder.offlineMessage = (TextView)view.findViewById(0x7f0d01a6);
    }

    private void setLoading(boolean flag)
    {
        View view = mHolder.loading;
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030039, viewgroup, false);
        initView(layoutinflater);
        initData();
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onVideoClick(Video video)
    {
        List list = mAdapter.getVideoList();
        Bundle bundle = new Bundle();
        bundle.putInt("VideoSelected", list.indexOf(video));
        bundle.putParcelableArrayList("VideoList", (ArrayList)mAdapter.getVideoList());
        video = new Intent(getActivity(), my/googlemusic/play/activities/PlayerVideoActivity);
        video.putExtras(bundle);
        startActivity(video);
    }




    /* member class not found */
    class _cls1 {}

}
