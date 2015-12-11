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
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SongFragment

class this._cls0
    implements android.widget.temClickListener
{

    final SongFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!MixerBoxClient.isConnectingToInternet(getActivity()) && currentPlaylist.getPlaylistType() != 8)
        {
            AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
        } else
        if (i > 0)
        {
            adapterview = (SongItem)((ListView)lv.getRefreshableView()).getItemAtPosition(i);
            ((MainPage)getActivity()).arrayPlayingSong = new ArrayList(((MainPage)getActivity()).arraySong);
            ((MainPage)getActivity()).playingSong = adapterview;
            ((MainPage)getActivity()).playingPlaylist = currentPlaylist;
            ((MainPage)getActivity()).playingSongIndex = i - 2;
            ((MainPage)getActivity()).playMusic(true);
            return;
        }
    }

    istView()
    {
        this$0 = SongFragment.this;
        super();
    }
}
