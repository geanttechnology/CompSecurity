// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            MP3Fragment, SongFragment

class this._cls0
    implements android.widget.ItemClickListener
{

    final MP3Fragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        ((MainPage)getActivity()).arraySong.clear();
        view = (PlaylistItem)((ListView)lvPlaylist.getRefreshableView()).getItemAtPosition(i);
        adapterview = ((MainPage)getActivity()).setSong(view.getPlaylistId());
        adapterview.currentPlaylist = view;
        view = android.provider.io.Playlists.Members.getContentUri("external", Long.valueOf(view.getPlaylistOwnerId()).longValue());
        MixerBoxUtils.loadMP3Song(getActivity(), false, adapterview, "is_music != 0 ", view);
    }

    ers()
    {
        this$0 = MP3Fragment.this;
        super();
    }
}
