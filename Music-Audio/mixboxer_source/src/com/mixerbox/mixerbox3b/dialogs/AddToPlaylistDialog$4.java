// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            AddToPlaylistDialog

class val.etName
    implements android.content.kListener
{

    final AddToPlaylistDialog this$0;
    final EditText val$etName;
    final RadioGroup val$radioGroup;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i = val$radioGroup.getCheckedRadioButtonId();
        if (i == 0x7f070061 && (val$etName.getText() == null || val$etName.getText().toString().length() == 0))
        {
            MixerBoxUtils.toastMsg(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), AddToPlaylistDialog.access$000(AddToPlaylistDialog.this).getResources().getString(0x7f08006d), 1);
            (new AddToPlaylistDialog(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), song)).show().getWindow().setSoftInputMode(16);
            return;
        }
        if (((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).isLogIn)
        {
            if (arrayMyPlaylists != null && i < arrayMyPlaylists.size() && i >= 0)
            {
                MixerBoxUtils.addSong(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistId(), song, true, ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistName());
                return;
            } else
            {
                MixerBoxUtils.addSongToNewPlaylist(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), val$etName.getText().toString(), song);
                return;
            }
        }
        FlurryAgent.logEvent("action:music_add_local");
        if (arrayMyPlaylists != null && i < arrayMyPlaylists.size() && i >= 0)
        {
            MixerBoxSharedPreferences.putDefaultAddedPlaylist(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistId(), ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistName());
            ((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).DB.addSong(((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistId(), song.getSongName(), song.getSongTime(), song.getSongYtId(), song.getSongOrder(), song.getSongSource(), song.getSongThumbnail());
            MixerBoxUtils.toastMsg(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), AddToPlaylistDialog.access$000(AddToPlaylistDialog.this).getResources().getString(0x7f080077), 1);
            ((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).fragmentPlaylists.loadContent();
            return;
        }
        long l = ((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).DB.addMyPlaylist("", val$etName.getText().toString(), "", "", "0", "0", "", 5);
        if (String.valueOf(l).equals("-1"))
        {
            MixerBoxUtils.toastMsg(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), AddToPlaylistDialog.access$000(AddToPlaylistDialog.this).getResources().getString(0x7f080049), 1);
            return;
        } else
        {
            ((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).arrayMyPlaylists.add(new PlaylistItem(String.valueOf(l), val$etName.getText().toString(), "", "", "0", "0", "", 5, false));
            ((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).myPlaylists.add(String.valueOf(l));
            MixerBoxSharedPreferences.putDefaultAddedPlaylist(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), String.valueOf(l), val$etName.getText().toString());
            ((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).DB.addSong(String.valueOf(l), song.getSongName(), song.getSongTime(), song.getSongYtId(), song.getSongOrder(), song.getSongSource(), song.getSongThumbnail());
            MixerBoxUtils.toastMsg(AddToPlaylistDialog.access$000(AddToPlaylistDialog.this), AddToPlaylistDialog.access$000(AddToPlaylistDialog.this).getResources().getString(0x7f080077), 1);
            ((MainPage)AddToPlaylistDialog.access$000(AddToPlaylistDialog.this)).fragmentPlaylists.loadContent();
            return;
        }
    }

    s()
    {
        this$0 = final_addtoplaylistdialog;
        val$radioGroup = radiogroup;
        val$etName = EditText.this;
        super();
    }
}
