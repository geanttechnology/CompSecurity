// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;

public class NewsfeedFragment extends Fragment
{

    public VectorAdapter adapter;
    public boolean canScroll;
    boolean endList;
    LayoutInflater f;
    LinearLayout llLoading;
    public PullToRefreshListView lvNewsfeed;
    View v;

    public NewsfeedFragment()
    {
        endList = false;
        canScroll = false;
    }

    public void loadContent()
    {
        final EndlessScrollListener scroller = new EndlessScrollListener();
        ((ListView)lvNewsfeed.getRefreshableView()).setOnScrollListener(scroller);
        lvNewsfeed.setOnItemClickListener(new _cls1());
        lvNewsfeed.setOnRefreshListener(new _cls2());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = (LayoutInflater)getActivity().getSystemService("layout_inflater");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        v = layoutinflater.inflate(0x7f03002f, viewgroup, false);
        llLoading = (LinearLayout)v.findViewById(0x7f070071);
        if (((MainPage)getActivity()).arrayNewsfeed == null)
        {
            return v;
        } else
        {
            lvNewsfeed = (PullToRefreshListView)v.findViewById(0x7f070072);
            adapter = new VectorAdapter(getActivity(), f, ((MainPage)getActivity()).arrayNewsfeed);
            lvNewsfeed.setAdapter(adapter);
            lvNewsfeed.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
            lvNewsfeed.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
            lvNewsfeed.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
            lvNewsfeed.setRefreshing();
            return v;
        }
    }

    private class EndlessScrollListener
        implements android.widget.AbsListView.OnScrollListener
    {

        private int currentPage;
        private boolean loading;
        private int previousTotal;
        final NewsfeedFragment this$0;
        private int visibleThreshold;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            if (canScroll)
            {
                if (loading && k > previousTotal)
                {
                    loading = false;
                    previousTotal = k;
                    currentPage = currentPage + 1;
                    MixerBoxUtils.logMsg((new StringBuilder()).append("current page = ").append(currentPage).toString());
                }
                if (!endList && !loading && i + j == k && k - j <= visibleThreshold + i)
                {
                    llLoading.setVisibility(0);
                    (new LoadVectorTask(null)).execute(new Integer[] {
                        Integer.valueOf(currentPage), Integer.valueOf(k), Integer.valueOf(j)
                    });
                    loading = true;
                    return;
                }
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
        }


/*
        static int access$002(EndlessScrollListener endlessscrolllistener, int i)
        {
            endlessscrolllistener.currentPage = i;
            return i;
        }

*/


/*
        static int access$102(EndlessScrollListener endlessscrolllistener, int i)
        {
            endlessscrolllistener.previousTotal = i;
            return i;
        }

*/


/*
        static boolean access$202(EndlessScrollListener endlessscrolllistener, boolean flag)
        {
            endlessscrolllistener.loading = flag;
            return flag;
        }

*/

        public EndlessScrollListener()
        {
            this$0 = NewsfeedFragment.this;
            super();
            visibleThreshold = 500;
            currentPage = -1;
            previousTotal = 0;
            loading = true;
        }

        private class LoadVectorTask extends AsyncTask
        {

            final NewsfeedFragment this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Integer[])aobj);
            }

            protected transient String[] doInBackground(final Integer params[])
            {
                if (getActivity() == null)
                {
                    return null;
                } else
                {
                    class _cls1
                        implements Runnable
                    {

                        final LoadVectorTask this$1;
                        final Integer val$params[];

                        public void run()
                        {
                            if (endList || getActivity() == null)
                            {
                                return;
                            } else
                            {
                                class _cls1 extends MixerBoxAsyncHttpResponseHandler
                                {

                                    final _cls1 this$2;

                                    public void onSuccess(String s)
                                    {
                                        boolean flag;
                                        flag = false;
                                        super.onSuccess(s);
                                        if (getActivity() == null)
                                        {
                                            return;
                                        }
                                        if (((MainPage)getActivity()).arrayNewsfeed == null)
                                        {
                                            ((MainPage)getActivity()).arrayNewsfeed = new ArrayList();
                                        }
                                        if (params[0].intValue() == -1)
                                        {
                                            ((MainPage)getActivity()).arrayNewsfeed.clear();
                                        }
                                        s = (new JSONObject(s)).getJSONObject("newsPage").getJSONArray("items");
                                        int i = ((flag) ? 1 : 0);
                                        if (s.length() >= 20)
                                        {
                                            break MISSING_BLOCK_LABEL_161;
                                        }
                                        endList = true;
                                        i = ((flag) ? 1 : 0);
_L2:
                                        if (i >= s.length())
                                        {
                                            break; /* Loop/switch isn't completed */
                                        }
                                        JSONObject jsonobject = s.getJSONObject(i);
                                        MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, jsonobject, getActivity(), i, s.length() - i - 1);
                                        i++;
                                        if (true) goto _L2; else goto _L1
                                        s;
                                        s.printStackTrace();
_L1:
                                        adapter.notifyDataSetChanged();
                                        lvNewsfeed.onRefreshComplete();
                                        llLoading.setVisibility(8);
                                        return;
                                    }

                                    _cls1(Context context)
                                    {
                                        this$2 = _cls1.this;
                                        super(context);
                                    }
                                }

                                MixerBoxClient.get(MixerBoxClient.getNewsfeedUrl(getActivity(), params[0].intValue() + 1), null, new _cls1(getActivity()));
                                return;
                            }
                        }

                    _cls1()
                    {
                        this$1 = LoadVectorTask.this;
                        params = ainteger;
                        super();
                    }
                    }

                    getActivity().runOnUiThread(new _cls1());
                    return null;
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((String[])obj);
            }

            protected void onPostExecute(String as[])
            {
                super.onPostExecute(as);
            }

            private LoadVectorTask()
            {
                this$0 = NewsfeedFragment.this;
                super();
            }

            LoadVectorTask(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final NewsfeedFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            } else
            {
                adapterview = (MyItem)((ListView)lvNewsfeed.getRefreshableView()).getItemAtPosition(i);
                VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
                return;
            }
        }

        _cls1()
        {
            this$0 = NewsfeedFragment.this;
            super();
        }
    }


    private class _cls2
        implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
    {

        final NewsfeedFragment this$0;
        final EndlessScrollListener val$scroller;

        public void onRefresh(PullToRefreshBase pulltorefreshbase)
        {
            endList = false;
            scroller.currentPage = 0;
            scroller.previousTotal = 0;
            scroller.loading = false;
            class _cls1 extends MixerBoxAsyncHttpResponseHandler
            {

                final _cls2 this$1;

                public void onFailure(Throwable throwable, String s)
                {
                    super.onFailure(throwable, s);
                    lvNewsfeed.onRefreshComplete();
                }

                public void onSuccess(String s)
                {
                    int i = 0;
                    super.onSuccess(s);
                    if (getActivity() == null || s == null)
                    {
                        return;
                    }
                    Object obj;
                    if (((MainPage)getActivity()).arrayNewsfeed != null)
                    {
                        ((MainPage)getActivity()).arrayNewsfeed.clear();
                    } else
                    {
                        ((MainPage)getActivity()).arrayNewsfeed = new ArrayList();
                    }
                    obj = ((MainPage)getActivity()).DB.getLastPushed();
                    if (obj != null)
                    {
                        try
                        {
                            obj = new JSONObject((new StringBuilder()).append("{margin: true,type: \"general\",views: {header: {mainText: \"").append(getResources().getString(0x7f080112)).append("\"},main: {mainLink: {type: \"playlist\",ref: \"").append(((PlaylistItem) (obj)).getPlaylistId()).append("\",title: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",owner: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",size: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",thumbnailHQ: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",ownerId: \"\"},mainText: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",subText: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",sideText: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: {style: \"square\",url: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\"}},footer: {bgColor: true,links: [{type: \"button\",title: \"").append(getResources().getString(0x7f0800e7)).append("\",action: \"subscribe\",switch: {type: \"button\",title: \"").append(getResources().getString(0x7f0800e8)).append("\",action: \"unsubscribe\"}},{type: \"dummy\"},{type: \"dummy\"}]}}}").toString());
                            MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, ((JSONObject) (obj)), getActivity(), 0, 0);
                        }
                        catch (Exception exception)
                        {
                            exception.toString();
                        }
                    }
                    s = (new JSONObject(s)).getJSONObject("newsPage").getJSONArray("items");
_L1:
                    if (i >= s.length())
                    {
                        break MISSING_BLOCK_LABEL_452;
                    }
                    obj = s.getJSONObject(i);
                    MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, ((JSONObject) (obj)), getActivity(), i, s.length() - i - 1);
                    i++;
                      goto _L1
                    s;
                    s.printStackTrace();
                    adapter.notifyDataSetChanged();
                    lvNewsfeed.onRefreshComplete();
                    canScroll = true;
                    return;
                }

                _cls1(Context context)
                {
                    this$1 = _cls2.this;
                    super(context);
                }
            }

            MixerBoxClient.get(MixerBoxClient.getNewsfeedUrl(getActivity(), 0), null, new _cls1(getActivity()));
        }

        _cls2()
        {
            this$0 = NewsfeedFragment.this;
            scroller = endlessscrolllistener;
            super();
        }
    }

}
