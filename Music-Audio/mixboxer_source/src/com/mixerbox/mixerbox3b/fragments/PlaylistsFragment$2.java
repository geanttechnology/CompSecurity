// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.dialogs.LoginDialog;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            PlaylistsFragment, SongFragment

class this._cls0
    implements android.widget.ickListener
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

    ew()
    {
        this$0 = PlaylistsFragment.this;
        super();
    }
}
