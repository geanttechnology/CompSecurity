// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.flurry.android.FlurryAgent;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.SongAdapter;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.Stack;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            RemoveDialog

class this._cls0
    implements android.content..OnClickListener
{

    final RemoveDialog this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (RemoveDialog.access$000(RemoveDialog.this) == 1)
        {
            if (((MainPage)RemoveDialog.access$100(RemoveDialog.this)).isLogIn)
            {
                ((MainPage)RemoveDialog.access$100(RemoveDialog.this)).backToPreviousFragment();
                if (((MainPage)RemoveDialog.access$100(RemoveDialog.this)).fragmentPlaylists.lv != null)
                {
                    ((MainPage)RemoveDialog.access$100(RemoveDialog.this)).fragmentPlaylists.lv.setRefreshing();
                }
                MixerBoxUtils.removePlaylist(RemoveDialog.access$100(RemoveDialog.this), playlistId);
                return;
            } else
            {
                FlurryAgent.logEvent("action:playlist_delete_local");
                ((MainPage)RemoveDialog.access$100(RemoveDialog.this)).DB.deleteMyPlaylist(((SongFragment)((MainPage)RemoveDialog.access$100(RemoveDialog.this)).stack.lastElement()).currentPlaylist.getPlaylistId());
                MixerBoxUtils.toastMsg(RemoveDialog.access$100(RemoveDialog.this), RemoveDialog.access$100(RemoveDialog.this).getResources().getString(0x7f0800e9), 1);
                ((MainPage)RemoveDialog.access$100(RemoveDialog.this)).fragmentPlaylists.loadContent();
                ((MainPage)RemoveDialog.access$100(RemoveDialog.this)).backToPreviousFragment();
                return;
            }
        }
        if (((MainPage)RemoveDialog.access$100(RemoveDialog.this)).isLogIn && !playlistId.equals("PLAYLISTHISTORYID"))
        {
            MixerBoxUtils.removeSong(RemoveDialog.access$100(RemoveDialog.this), playlistId, song, order);
            return;
        }
        FlurryAgent.logEvent("action:music_delete_local");
        ((MainPage)RemoveDialog.access$100(RemoveDialog.this)).DB.deleteSong(playlistId, song.getSongYtId(), song.getSongId());
        if (((Fragment)((MainPage)RemoveDialog.access$100(RemoveDialog.this)).stack.lastElement()).getClass().getSimpleName().equals("SongFragment") && ((SongFragment)((MainPage)RemoveDialog.access$100(RemoveDialog.this)).stack.lastElement()).currentPlaylist.getPlaylistId().equals(playlistId))
        {
            i = ((SongFragment)((MainPage)RemoveDialog.access$100(RemoveDialog.this)).stack.lastElement()).adapter.array.indexOf(song);
            if (i != -1)
            {
                ((SongFragment)((MainPage)RemoveDialog.access$100(RemoveDialog.this)).stack.lastElement()).adapter.array.remove(i);
                ((SongFragment)((MainPage)RemoveDialog.access$100(RemoveDialog.this)).stack.lastElement()).adapter.notifyDataSetChanged();
            }
        }
        MixerBoxUtils.toastMsg(RemoveDialog.access$100(RemoveDialog.this), RemoveDialog.access$100(RemoveDialog.this).getResources().getString(0x7f0800e9), 1);
        ((MainPage)RemoveDialog.access$100(RemoveDialog.this)).fragmentPlaylists.loadContent();
    }

    hListView()
    {
        this$0 = RemoveDialog.this;
        super();
    }
}
