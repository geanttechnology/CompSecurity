// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.flurry.android.FlurryAgent;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            CreatePlaylistDialog

class val.view
    implements android.content.Listener
{

    final CreatePlaylistDialog this$0;
    final View val$view;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (EditText)val$view.findViewById(0x7f070062);
        if (dialoginterface.getText() == null || dialoginterface.getText().toString().length() == 0)
        {
            MixerBoxUtils.toastMsg(CreatePlaylistDialog.access$000(CreatePlaylistDialog.this), CreatePlaylistDialog.access$000(CreatePlaylistDialog.this).getResources().getString(0x7f08006d), 1);
            (new CreatePlaylistDialog(CreatePlaylistDialog.access$000(CreatePlaylistDialog.this), type, name)).show();
            return;
        }
        if (((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).isLogIn)
        {
            if (((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).fragmentPlaylists.lv != null)
            {
                ((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).fragmentPlaylists.lv.setRefreshing();
            }
            MixerBoxUtils.createPlaylist(CreatePlaylistDialog.access$000(CreatePlaylistDialog.this), dialoginterface.getText().toString());
            return;
        }
        long l = ((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).DB.addMyPlaylist("", dialoginterface.getText().toString(), "", "", "0", "0", "", 5);
        if (String.valueOf(l).equals("-1"))
        {
            MixerBoxUtils.toastMsg(CreatePlaylistDialog.access$000(CreatePlaylistDialog.this), CreatePlaylistDialog.access$000(CreatePlaylistDialog.this).getResources().getString(0x7f080049), 1);
            return;
        } else
        {
            FlurryAgent.logEvent("action:playlist_create_local");
            dialoginterface = new PlaylistItem(String.valueOf(l), dialoginterface.getText().toString(), "", "", "0", "0", "", 5, false);
            ((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).arrayMyPlaylists.add(dialoginterface);
            ((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).myPlaylists.add(String.valueOf(l));
            MixerBoxUtils.toastMsg(CreatePlaylistDialog.access$000(CreatePlaylistDialog.this), CreatePlaylistDialog.access$000(CreatePlaylistDialog.this).getResources().getString(0x7f0800e9), 1);
            ((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).fragmentPlaylists.loadContent();
            ((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).arraySong.clear();
            SongFragment songfragment = ((MainPage)CreatePlaylistDialog.access$000(CreatePlaylistDialog.this)).setSong(dialoginterface.getPlaylistId());
            songfragment.currentPlaylist = dialoginterface;
            MixerBoxUtils.loadDBSong(CreatePlaylistDialog.access$000(CreatePlaylistDialog.this), dialoginterface.getPlaylistId(), false, songfragment);
            return;
        }
    }

    w()
    {
        this$0 = final_createplaylistdialog;
        val$view = View.this;
        super();
    }
}
