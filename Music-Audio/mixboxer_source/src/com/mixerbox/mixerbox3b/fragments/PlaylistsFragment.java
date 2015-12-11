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
import android.widget.ListView;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.PlaylistAdapter;
import com.mixerbox.mixerbox3b.classes.SectionAdapter;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import java.util.ArrayList;

public class PlaylistsFragment extends Fragment
{

    ArrayList array;
    ArrayList arrayMP3;
    ArrayList arraySubs;
    public PullToRefreshListView lv;
    View v;

    public PlaylistsFragment()
    {
    }

    public void loadContent()
    {
        if (isAdded())
        {
            if (!((MainPage)getActivity()).isLogIn)
            {
                ((MainPage)getActivity()).parseDBMyPlaylists();
                ((MainPage)getActivity()).parseDefaultSubsPlaylists();
            }
            String s;
            String s1;
            String s2;
            SectionAdapter sectionadapter;
            if (((MainPage)getActivity()).arrayMyPlaylists != null)
            {
                array = new ArrayList(((MainPage)getActivity()).arrayMyPlaylists);
            } else
            {
                array = null;
            }
            if (((MainPage)getActivity()).arrayMySubsPlaylists != null)
            {
                arraySubs = new ArrayList(((MainPage)getActivity()).arrayMySubsPlaylists);
            } else
            {
                arraySubs = null;
            }
            if (((MainPage)getActivity()).arrayMP3 != null)
            {
                arrayMP3 = new ArrayList(((MainPage)getActivity()).arrayMP3);
            } else
            {
                arrayMP3 = null;
            }
            s = (new StringBuilder()).append("  ").append(getActivity().getResources().getString(0x7f080079)).toString();
            s1 = (new StringBuilder()).append("  ").append(getActivity().getResources().getString(0x7f08007a)).toString();
            s2 = (new StringBuilder()).append("  ").append(getActivity().getResources().getString(0x7f080128)).toString();
            sectionadapter = new SectionAdapter(getActivity());
            if (array != null)
            {
                sectionadapter.addSection(s, new PlaylistAdapter(getActivity(), array));
            }
            if (arraySubs != null)
            {
                sectionadapter.addSection(s1, new PlaylistAdapter(getActivity(), arraySubs));
            }
            if (arrayMP3 != null)
            {
                sectionadapter.addSection(s2, new PlaylistAdapter(getActivity(), arrayMP3));
            }
            if ((array != null || arraySubs != null || arrayMP3 != null) && lv != null)
            {
                lv.setAdapter(sectionadapter);
            }
            if (lv != null && !MixerBoxSharedPreferences.getOnboardingFinish(getActivity()))
            {
                ((ListView)lv.getRefreshableView()).setSelection(array.size() + 2);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        v = layoutinflater.inflate(0x7f030033, viewgroup, false);
        lv = (PullToRefreshListView)v.findViewById(0x7f07008d);
        lv.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lv.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lv.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        if (((MainPage)getActivity()).isLogIn)
        {
            lv.setOnRefreshListener(new _cls1());
        }
        loadContent();
        lv.setOnItemClickListener(new _cls2());
        return v;
    }

    private class _cls1
        implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
    {

        final PlaylistsFragment this$0;

        public void onRefresh(PullToRefreshBase pulltorefreshbase)
        {
            class _cls1 extends MixerBoxAsyncHttpResponseHandler
            {

                final _cls1 this$1;

                public void onFailure(Throwable throwable, String s)
                {
                    super.onFailure(throwable, s);
                    lv.onRefreshComplete();
                }

                public void onSuccess(String s)
                {
                    super.onSuccess(s);
                    if (s == null || getActivity() == null)
                    {
                        return;
                    }
                    MixerBoxSharedPreferences.putAuthLoginResponse(getActivity(), s);
                    Object obj;
                    Object obj1;
                    JSONArray jsonarray;
                    obj = (new JSONObject(s)).getJSONObject("authLoginV2").getJSONObject("data");
                    obj1 = new ArrayList();
                    jsonarray = ((JSONObject) (obj)).getJSONArray("playlists");
                    int i;
                    if (android.os.Build.VERSION.SDK_INT >= 15)
                    {
                        s = "coverhq";
                    } else
                    {
                        s = "cover";
                    }
                    ((MainPage)getActivity()).myPlaylists.clear();
                    i = jsonarray.length() - 1;
_L10:
                    if (i < 0) goto _L2; else goto _L1
_L1:
                    if (!jsonarray.isNull(i)) goto _L4; else goto _L3
_L3:
                    ((ArrayList) (obj1)).add(new PlaylistItem("", "", "", "", "", "", "", 0, false));
                      goto _L5
_L4:
                    JSONObject jsonobject1 = jsonarray.getJSONObject(i);
                    ((ArrayList) (obj1)).add(MixerBoxUtils.getPlaylistItem(jsonobject1, s, 1));
                    ((MainPage)getActivity()).myPlaylists.add(jsonobject1.getString("_id"));
                      goto _L5
_L8:
                    loadContent();
                    lv.onRefreshComplete();
                    return;
_L2:
                    ((MainPage)getActivity()).arrayMyPlaylists = new ArrayList(((java.util.Collection) (obj1)));
                    obj1 = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(((MainPage)getActivity()).DB.getLastHistory()).append("/mqdefault.jpg").toString();
                    ((MainPage)getActivity()).arrayMyPlaylists.add(new PlaylistItem("PLAYLISTHISTORYID", ((MainPage)getActivity()).getResources().getString(0x7f080111), "", "", (new StringBuilder()).append("").append(((MainPage)getActivity()).DB.getSongCount("PLAYLISTHISTORYID")).toString(), "", ((String) (obj1)), 6, false));
                    ((MainPage)getActivity()).mySubscriptions.clear();
                    obj1 = new ArrayList();
                    obj = ((JSONObject) (obj)).getJSONArray("subs_playlists");
                    i = ((JSONArray) (obj)).length() - 1;
_L7:
                    if (i < 0)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(i);
                    ((MainPage)getActivity()).mySubscriptions.add(jsonobject.getString("_id"));
                    ((ArrayList) (obj1)).add(MixerBoxUtils.getPlaylistItem(jsonobject, s, 2));
                    i--;
                    if (true) goto _L7; else goto _L6
_L6:
                    try
                    {
                        ((MainPage)getActivity()).arrayMySubsPlaylists = new ArrayList(((java.util.Collection) (obj1)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        s.printStackTrace();
                    }
                    if (true) goto _L8; else goto _L5
_L5:
                    i--;
                    if (true) goto _L10; else goto _L9
_L9:
                }

                _cls1(Context context)
                {
                    this$1 = _cls1.this;
                    super(context);
                }
            }

            if (((MainPage)getActivity()).isLogIn)
            {
                MixerBoxClient.get(MixerBoxClient.getAuthLoginUrl(MixerBoxSharedPreferences.getUUID(getActivity()), MixerBoxSharedPreferences.getFacebookToken(getActivity())), null, new _cls1(getActivity()));
            }
        }

        _cls1()
        {
            this$0 = PlaylistsFragment.this;
            super();
        }
    }


    private class _cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final PlaylistsFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (PlaylistItem)((ListView)lv.getRefreshableView()).getItemAtPosition(i);
            if (!MixerBoxClient.isConnectingToInternet(getActivity()) && adapterview.getPlaylistType() != 8)
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            }
            try
            {
                if (adapterview.getPlaylistId().equals("-999"))
                {
                    (new LoginDialog(getActivity(), 3)).show();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (AdapterView adapterview)
            {
                return;
            }
            if (adapterview.getPlaylistType() == 8)
            {
                ((MainPage)getActivity()).setMP3();
                return;
            }
            if (adapterview.getPlaylistType() == 6)
            {
                ((MainPage)getActivity()).arraySong.clear();
                view = ((MainPage)getActivity()).setSong(adapterview.getPlaylistId());
                view.currentPlaylist = adapterview;
                MixerBoxUtils.loadDBSong(getActivity(), "PLAYLISTHISTORYID", false, view);
                return;
            }
            if (adapterview.getPlaylistType() == 5)
            {
                ((MainPage)getActivity()).arraySong.clear();
                view = ((MainPage)getActivity()).setSong(adapterview.getPlaylistId());
                view.currentPlaylist = adapterview;
                MixerBoxUtils.loadDBSong(getActivity(), adapterview.getPlaylistId(), false, view);
                return;
            }
            ((MainPage)getActivity()).arraySong.clear();
            view = ((MainPage)getActivity()).setSong(adapterview.getPlaylistId());
            view.currentPlaylist = adapterview;
            MixerBoxUtils.loadSong(getActivity(), adapterview.getPlaylistId(), false, 1, -1, view);
            return;
        }

        _cls2()
        {
            this$0 = PlaylistsFragment.this;
            super();
        }
    }

}
