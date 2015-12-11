// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import java.util.Stack;

public class RenamePlaylistDialog extends android.app.AlertDialog.Builder
{

    private Context ctx;
    private String currentPlaylistId;

    public RenamePlaylistDialog(Context context, String s)
    {
        super(context);
        ctx = context;
        currentPlaylistId = s;
        getContent();
    }

    private void getContent()
    {
        final EditText etName = LayoutInflater.from(ctx).inflate(0x7f030026, null);
        setView(etName);
        etName = (EditText)etName.findViewById(0x7f070062);
        final String strOri = ((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.getPlaylistName();
        etName.setText(strOri);
        etName.setSelection(strOri.length());
        setTitle(ctx.getResources().getString(0x7f080064));
        setPositiveButton(ctx.getResources().getString(0x7f08007e), new _cls1());
        setNegativeButton(ctx.getResources().getString(0x7f080063), new _cls2());
    }



    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final RenamePlaylistDialog this$0;
        final EditText val$etName;
        final String val$strOri;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (etName.getText() == null || etName.getText().toString().length() == 0)
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f08006d), 1);
                (new RenamePlaylistDialog(ctx, currentPlaylistId)).show();
            } else
            if (!etName.getText().equals(strOri))
            {
                if (((MainPage)ctx).isLogIn)
                {
                    MixerBoxUtils.renamePlaylist(ctx, currentPlaylistId, etName.getText().toString());
                    return;
                }
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 1);
                ((MainPage)ctx).DB.updateMyPlaylist(currentPlaylistId, etName.getText().toString());
                if (((Fragment)((MainPage)ctx).stack.lastElement()).getClass().getSimpleName().equals("SongFragment"))
                {
                    ((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.getPlaylistId().equals(currentPlaylistId);
                }
                ((MainPage)ctx).fragmentPlaylists.loadContent();
                return;
            }
        }

        _cls1()
        {
            this$0 = RenamePlaylistDialog.this;
            etName = edittext;
            strOri = s;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final RenamePlaylistDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls2()
        {
            this$0 = RenamePlaylistDialog.this;
            super();
        }
    }

}
