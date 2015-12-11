// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.adapters:
//            PlaylistAdapter

class val.position
    implements android.view.er
{

    final PlaylistAdapter this$0;
    final int val$position;

    public void onClick(View view)
    {
        view = (PlaylistItem)getItem(val$position);
        if (!view.getPlaylistId().equals("-999"))
        {
            if (view.getPlaylistType() == 8 && ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).currentFragment == 0)
            {
                ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).setMP3();
                return;
            }
            if (((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).currentFragment == 14)
            {
                if (view.getPlaylistId() == "PLAYLISTMP3PLAYLISTID")
                {
                    ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).arraySong.clear();
                    SongFragment songfragment = ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).setSong(view.getPlaylistId());
                    songfragment.currentPlaylist = view;
                    view = android.provider.laylists.Members.getContentUri("external", Long.valueOf(view.getPlaylistOwnerId()).longValue());
                    MixerBoxUtils.loadMP3Song(PlaylistAdapter.access$100(PlaylistAdapter.this), true, songfragment, "is_music != 0 ", view);
                    return;
                }
                if (view.getPlaylistId() == "PLAYLISTMP3ALBUMID")
                {
                    ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).arraySong.clear();
                    SongFragment songfragment1 = ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).setSong(view.getPlaylistId());
                    songfragment1.currentPlaylist = view;
                    view = (new StringBuilder()).append("album_id = ").append(songfragment1.currentPlaylist.getPlaylistOwnerId()).toString();
                    MixerBoxUtils.loadMP3Song(PlaylistAdapter.access$100(PlaylistAdapter.this), true, songfragment1, view, android.provider.edia.EXTERNAL_CONTENT_URI);
                    return;
                }
                if (view.getPlaylistId() == "PLAYLISTMP3ARTISTID")
                {
                    ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).arraySong.clear();
                    SongFragment songfragment2 = ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).setSong(view.getPlaylistId());
                    songfragment2.currentPlaylist = view;
                    view = (new StringBuilder()).append("artist_id = ").append(songfragment2.currentPlaylist.getPlaylistOwnerId()).toString();
                    MixerBoxUtils.loadMP3Song(PlaylistAdapter.access$100(PlaylistAdapter.this), true, songfragment2, view, android.provider.edia.EXTERNAL_CONTENT_URI);
                    return;
                }
            } else
            {
                if (view.getPlaylistType() == 5 || view.getPlaylistId().equals("PLAYLISTHISTORYID"))
                {
                    ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).arraySong.clear();
                    SongFragment songfragment3 = ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).setSong(view.getPlaylistId());
                    songfragment3.currentPlaylist = view;
                    MixerBoxUtils.loadDBSong(PlaylistAdapter.access$100(PlaylistAdapter.this), view.getPlaylistId(), true, songfragment3);
                    return;
                }
                if (!MixerBoxClient.isConnectingToInternet(PlaylistAdapter.access$100(PlaylistAdapter.this)))
                {
                    AlertDialogFactory.NoNetworkAlertDialog((Activity)PlaylistAdapter.access$100(PlaylistAdapter.this)).show();
                    return;
                } else
                {
                    ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).arraySong.clear();
                    Object obj = ((MainPage)PlaylistAdapter.access$100(PlaylistAdapter.this)).setSong(view.getPlaylistId());
                    obj.currentPlaylist = view;
                    MixerBoxUtils.loadSong(PlaylistAdapter.access$100(PlaylistAdapter.this), view.getPlaylistId(), false, 1, 0, ((SongFragment) (obj)));
                    obj = new HashMap();
                    ((Map) (obj)).put("id", view.getPlaylistId());
                    FlurryAgent.logEvent("action:playlist_play", ((Map) (obj)));
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = final_playlistadapter;
        val$position = I.this;
        super();
    }
}
