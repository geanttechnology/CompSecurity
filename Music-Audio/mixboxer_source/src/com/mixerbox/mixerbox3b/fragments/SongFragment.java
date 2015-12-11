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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.SongAdapter;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.utils.ActionBarSettings;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import java.util.ArrayList;

public class SongFragment extends Fragment
{

    public SongAdapter adapter;
    ArrayList array;
    TextView btnAdd;
    TextView btnShare;
    TextView btnSubs;
    public PlaylistItem currentPlaylist;
    ImageView i;
    ImageView ivAdd;
    LinearLayout llAdd;
    LinearLayout llMain;
    LinearLayout llSubs;
    public PullToRefreshListView lv;
    RelativeLayout rl;
    public int subsCnt;
    TextView t;
    TextView tvHeader;
    View view;

    public SongFragment()
    {
        subsCnt = 0;
        currentPlaylist = new PlaylistItem("", "", "", "", "", "", "", 0, false);
    }

    public void loadContent()
    {
        if (isAdded()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        array = new ArrayList(((MainPage)getActivity()).arraySong);
        if (array == null)
        {
            t.setVisibility(8);
            lv.setVisibility(8);
            return;
        }
        if (array.size() == 0 && ((MainPage)getActivity()).currentFragment == 4 && currentPlaylist.getPlaylistItemCount().equals("0"))
        {
            t.setVisibility(0);
            lv.setVisibility(8);
            i.setVisibility(0);
            btnShare.setVisibility(4);
            ActionBarSettings.hideOption(((MainPage)getActivity()).menu, 11);
        } else
        {
            t.setVisibility(8);
            lv.setVisibility(0);
            tvHeader.setText((new StringBuilder()).append("  ").append(currentPlaylist.getPlaylistName()).toString());
            adapter = new SongAdapter(getActivity(), array, currentPlaylist.getPlaylistId());
            lv.setAdapter(adapter);
            i.setVisibility(8);
        }
        lv.onRefreshComplete();
        if (currentPlaylist.getPlaylistType() == 6 || currentPlaylist.getPlaylistType() == 8)
        {
            llMain.setVisibility(8);
        } else
        if (currentPlaylist.getPlaylistType() == 5)
        {
            btnAdd.setText(getActivity().getResources().getString(0x7f080097));
            ivAdd.setVisibility(0);
        } else
        if (((MainPage)getActivity()).myPlaylists.contains(currentPlaylist.getPlaylistId()))
        {
            btnAdd.setText(getActivity().getResources().getString(0x7f080097));
            ivAdd.setVisibility(0);
        } else
        if (((MainPage)getActivity()).mySubscriptions.contains(currentPlaylist.getPlaylistId()))
        {
            btnAdd.setText(getActivity().getResources().getString(0x7f0800e8));
            ivAdd.setVisibility(8);
        } else
        {
            btnAdd.setText(getActivity().getResources().getString(0x7f0800e7));
            ivAdd.setVisibility(8);
        }
        if (!currentPlaylist.getPlaylistSubsCount().equals("") && Integer.valueOf(currentPlaylist.getPlaylistSubsCount()).intValue() > 0)
        {
            llSubs.setVisibility(0);
            btnSubs.setText(currentPlaylist.getPlaylistSubsCount());
        } else
        {
            llSubs.setVisibility(4);
        }
        if (array.size() != 0 || ((MainPage)getActivity()).currentFragment != 4 || !currentPlaylist.getPlaylistItemCount().equals("0"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (MixerBoxSharedPreferences.getTipFirstEmptyPlaylist(getActivity())) goto _L1; else goto _L3
_L3:
        ((MainPage)getActivity()).setOnboardingGuide(5, new boolean[0]);
        return;
        if (((MainPage)getActivity()).currentFragment != 4 || array.size() <= 0 || currentPlaylist.getPlaylistItemCount().equals("0") || ((MainPage)getActivity()).mySubscriptions.contains(currentPlaylist.getPlaylistId()) || MixerBoxSharedPreferences.getTipFirstNonEmptyPlaylist(getActivity())) goto _L1; else goto _L4
_L4:
        ((MainPage)getActivity()).setOnboardingGuide(9, new boolean[0]);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030036, viewgroup, false);
        rl = (RelativeLayout)layoutinflater.findViewById(0x7f070088);
        lv = (PullToRefreshListView)layoutinflater.findViewById(0x7f0700a9);
        view = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f03003c, null);
        tvHeader = (TextView)view.findViewById(0x7f0700b0);
        ((ListView)lv.getRefreshableView()).addHeaderView(view);
        i = (ImageView)layoutinflater.findViewById(0x7f0700a1);
        i.setImageResource(0x7f0200c9);
        t = (TextView)layoutinflater.findViewById(0x7f0700a0);
        btnAdd = (TextView)layoutinflater.findViewById(0x7f0700a5);
        btnSubs = (TextView)layoutinflater.findViewById(0x7f0700a7);
        btnShare = (TextView)layoutinflater.findViewById(0x7f0700a8);
        ivAdd = (ImageView)layoutinflater.findViewById(0x7f0700a4);
        llSubs = (LinearLayout)layoutinflater.findViewById(0x7f0700a6);
        llAdd = (LinearLayout)layoutinflater.findViewById(0x7f0700a3);
        llMain = (LinearLayout)layoutinflater.findViewById(0x7f0700a2);
        lv.setOnItemClickListener(new _cls1());
        lv.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lv.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lv.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        if (((MainPage)getActivity()).isLogIn)
        {
            lv.setOnRefreshListener(new _cls2());
        }
        array = new ArrayList();
        array.add(new SongItem("", "", "", "", 0, 1, ""));
        lv.setAdapter(new SongAdapter(getActivity(), array, currentPlaylist.getPlaylistId()));
        if (((MainPage)getActivity()).isLogIn)
        {
            lv.setRefreshing();
        } else
        {
            loadContent();
        }
        llAdd.setOnClickListener(new _cls3());
        llSubs.setOnClickListener(new _cls4());
        btnShare.setOnClickListener(new _cls5());
        return layoutinflater;
    }

    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final SongFragment this$0;

        public void onItemClick(AdapterView adapterview, View view1, int j, long l)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()) && currentPlaylist.getPlaylistType() != 8)
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
            } else
            if (j > 0)
            {
                adapterview = (SongItem)((ListView)lv.getRefreshableView()).getItemAtPosition(j);
                ((MainPage)getActivity()).arrayPlayingSong = new ArrayList(((MainPage)getActivity()).arraySong);
                ((MainPage)getActivity()).playingSong = adapterview;
                ((MainPage)getActivity()).playingPlaylist = currentPlaylist;
                ((MainPage)getActivity()).playingSongIndex = j - 2;
                ((MainPage)getActivity()).playMusic(true);
                return;
            }
        }

        _cls1()
        {
            this$0 = SongFragment.this;
            super();
        }
    }


    private class _cls2
        implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
    {

        final SongFragment this$0;

        public void onRefresh(PullToRefreshBase pulltorefreshbase)
        {
            if (currentPlaylist.getPlaylistType() == 6 || currentPlaylist.getPlaylistType() == 8)
            {
                lv.onRefreshComplete();
            } else
            if (getActivity() != null)
            {
                pulltorefreshbase = MixerBoxClient.getSongUrl(currentPlaylist.getPlaylistId());
                if (!currentPlaylist.getPlaylistId().equals(""))
                {
                    class _cls1 extends MixerBoxAsyncHttpResponseHandler
                    {

                        final _cls2 this$1;

                        public void onSuccess(String s)
                        {
                            super.onSuccess(s);
                            ArrayList arraylist = new ArrayList();
                            if (s != null)
                            {
                                s = MixerBoxUtils.getSongArray(s, _fld0);
                            } else
                            {
                                s = arraylist;
                            }
                            if (getActivity() == null)
                            {
                                return;
                            } else
                            {
                                ((MainPage)getActivity()).arraySong = new ArrayList(s);
                                lv.onRefreshComplete();
                                loadContent();
                                return;
                            }
                        }

                _cls1(Context context)
                {
                    this$1 = _cls2.this;
                    super(context);
                }
                    }

                    MixerBoxClient.get(pulltorefreshbase, null, new _cls1(getActivity()));
                    return;
                }
            }
        }

        _cls2()
        {
            this$0 = SongFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final SongFragment this$0;

        public void onClick(View view1)
        {
            if (btnAdd.getText().toString().equals(getActivity().getResources().getString(0x7f0800e7)))
            {
                ((MainPage)getActivity()).subscribePlaylist(currentPlaylist, true);
                btnAdd.setText(getActivity().getResources().getString(0x7f0800e8));
            } else
            {
                if (btnAdd.getText().toString().equals(getActivity().getResources().getString(0x7f0800e8)))
                {
                    if (((MainPage)getActivity()).isLogIn)
                    {
                        MixerBoxUtils.unsubsPlaylist((MainPage)getActivity(), currentPlaylist.getPlaylistId());
                    } else
                    {
                        ((MainPage)getActivity()).DB.deletePlaylist(currentPlaylist.getPlaylistId());
                        ((MainPage)getActivity()).mySubscriptions.remove(currentPlaylist.getPlaylistId());
                        ((MainPage)getActivity()).fragmentPlaylists.loadContent();
                    }
                    btnAdd.setText(getActivity().getResources().getString(0x7f0800e7));
                    return;
                }
                if (btnAdd.getText().toString().equals(getActivity().getResources().getString(0x7f080097)))
                {
                    view1 = ((MainPage)getActivity()).menu.findItem(999);
                    if (view1 != null)
                    {
                        view1.expandActionView();
                        MixerBoxSharedPreferences.putDefaultAddedPlaylist(getActivity(), currentPlaylist.getPlaylistId(), currentPlaylist.getPlaylistName());
                    }
                    if (!MixerBoxSharedPreferences.getTipFirstAddMusic(getActivity()))
                    {
                        ((MainPage)getActivity()).setOnboardingGuide(8, new boolean[0]);
                        return;
                    }
                }
            }
        }

        _cls3()
        {
            this$0 = SongFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final SongFragment this$0;

        public void onClick(View view1)
        {
            view1 = currentPlaylist.getPlaylistId();
            VectorFragment vectorfragment = ((MainPage)getActivity()).setVector(view1, "dj", 1, "");
            MixerBoxUtils.getSubsInfo(getActivity(), view1, vectorfragment);
        }

        _cls4()
        {
            this$0 = SongFragment.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final SongFragment this$0;

        public void onClick(View view1)
        {
            if (currentPlaylist.getPlaylistType() == 5)
            {
                (new LoginDialog(getActivity(), 8)).show();
                return;
            } else
            {
                view1 = currentPlaylist.getPlaylistName();
                String s = currentPlaylist.getPlaylistId();
                Object obj = new HashMap();
                ((Map) (obj)).put("id", s);
                FlurryAgent.logEvent("action:share_playlist", ((Map) (obj)));
                s = (new StringBuilder()).append("http://www.mixerbox.com/list/").append(s).toString();
                obj = (new StringBuilder()).append(getResources().getString(0x7f0800ba)).append(getResources().getString(0x7f0800b8)).toString();
                String s1 = getResources().getString(0x7f0800b9);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(((String) (obj))).append(view1).append(s1).toString());
                intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(((String) (obj))).append(view1).append(s1).append(s).toString());
                startActivity(Intent.createChooser(intent, null));
                return;
            }
        }

        _cls5()
        {
            this$0 = SongFragment.this;
            super();
        }
    }

}
