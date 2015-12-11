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
        view = (PlaylistItem)((ListView)lvAlbum.getRefreshableView()).getItemAtPosition(i);
        adapterview = ((MainPage)getActivity()).setSong(view.getPlaylistId());
        adapterview.currentPlaylist = view;
        view = (new StringBuilder()).append("album_id = ").append(((SongFragment) (adapterview)).currentPlaylist.getPlaylistOwnerId()).toString();
        MixerBoxUtils.loadMP3Song(getActivity(), false, adapterview, view, android.provider.io.Media.EXTERNAL_CONTENT_URI);
    }

    ListView()
    {
        this$0 = MP3Fragment.this;
        super();
    }
}
