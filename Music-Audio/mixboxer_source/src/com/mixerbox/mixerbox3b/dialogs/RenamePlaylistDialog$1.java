// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.Stack;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            RenamePlaylistDialog

class val.strOri
    implements android.content.Listener
{

    final RenamePlaylistDialog this$0;
    final EditText val$etName;
    final String val$strOri;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (val$etName.getText() == null || val$etName.getText().toString().length() == 0)
        {
            MixerBoxUtils.toastMsg(RenamePlaylistDialog.access$000(RenamePlaylistDialog.this), RenamePlaylistDialog.access$000(RenamePlaylistDialog.this).getResources().getString(0x7f08006d), 1);
            (new RenamePlaylistDialog(RenamePlaylistDialog.access$000(RenamePlaylistDialog.this), RenamePlaylistDialog.access$100(RenamePlaylistDialog.this))).show();
        } else
        if (!val$etName.getText().equals(val$strOri))
        {
            if (((MainPage)RenamePlaylistDialog.access$000(RenamePlaylistDialog.this)).isLogIn)
            {
                MixerBoxUtils.renamePlaylist(RenamePlaylistDialog.access$000(RenamePlaylistDialog.this), RenamePlaylistDialog.access$100(RenamePlaylistDialog.this), val$etName.getText().toString());
                return;
            }
            MixerBoxUtils.toastMsg(RenamePlaylistDialog.access$000(RenamePlaylistDialog.this), RenamePlaylistDialog.access$000(RenamePlaylistDialog.this).getResources().getString(0x7f0800e9), 1);
            ((MainPage)RenamePlaylistDialog.access$000(RenamePlaylistDialog.this)).DB.updateMyPlaylist(RenamePlaylistDialog.access$100(RenamePlaylistDialog.this), val$etName.getText().toString());
            if (((Fragment)((MainPage)RenamePlaylistDialog.access$000(RenamePlaylistDialog.this)).stack.lastElement()).getClass().getSimpleName().equals("SongFragment"))
            {
                ((SongFragment)((MainPage)RenamePlaylistDialog.access$000(RenamePlaylistDialog.this)).stack.lastElement()).currentPlaylist.getPlaylistId().equals(RenamePlaylistDialog.access$100(RenamePlaylistDialog.this));
            }
            ((MainPage)RenamePlaylistDialog.access$000(RenamePlaylistDialog.this)).fragmentPlaylists.loadContent();
            return;
        }
    }

    ()
    {
        this$0 = final_renameplaylistdialog;
        val$etName = edittext;
        val$strOri = String.this;
        super();
    }
}
