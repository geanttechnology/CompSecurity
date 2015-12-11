// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            MP3Fragment

class this._cls0
    implements android.widget.ItemClickListener
{

    final MP3Fragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (SongItem)((ListView)lvSong.getRefreshableView()).getItemAtPosition(i);
        ((MainPage)getActivity()).arrayPlayingSong = new ArrayList(arraySong);
        ((MainPage)getActivity()).playingSong = adapterview;
        ((MainPage)getActivity()).playingPlaylist = new PlaylistItem("PLAYLISTMP3ID", getActivity().getResources().getString(0x7f080128), "", "", "0", "0", "", 8, false);
        ((MainPage)getActivity()).playingSongIndex = i - 1;
        ((MainPage)getActivity()).playMusic(true);
    }

    ListView()
    {
        this$0 = MP3Fragment.this;
        super();
    }
}
