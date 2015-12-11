// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class CreatePlaylistDialog extends android.app.AlertDialog.Builder
{

    private Context ctx;
    String name;
    int type;

    public CreatePlaylistDialog(Context context, int i, String s)
    {
        super(context);
        ctx = context;
        type = i;
        name = s;
        getContent();
    }

    private void getContent()
    {
        final View view = LayoutInflater.from(ctx).inflate(0x7f030026, null);
        setView(view);
        EditText edittext = (EditText)view.findViewById(0x7f070062);
        edittext.setText(name);
        edittext.setSelection(name.length());
        setTitle(ctx.getResources().getString(0x7f080067));
        setPositiveButton(ctx.getResources().getString(0x7f08007e), new _cls1());
        setNegativeButton(ctx.getResources().getString(0x7f080063), new _cls2());
    }


    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final CreatePlaylistDialog this$0;
        final View val$view;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface = (EditText)view.findViewById(0x7f070062);
            if (dialoginterface.getText() == null || dialoginterface.getText().toString().length() == 0)
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f08006d), 1);
                (new CreatePlaylistDialog(ctx, type, name)).show();
                return;
            }
            if (((MainPage)ctx).isLogIn)
            {
                if (((MainPage)ctx).fragmentPlaylists.lv != null)
                {
                    ((MainPage)ctx).fragmentPlaylists.lv.setRefreshing();
                }
                MixerBoxUtils.createPlaylist(ctx, dialoginterface.getText().toString());
                return;
            }
            long l = ((MainPage)ctx).DB.addMyPlaylist("", dialoginterface.getText().toString(), "", "", "0", "0", "", 5);
            if (String.valueOf(l).equals("-1"))
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
                return;
            } else
            {
                FlurryAgent.logEvent("action:playlist_create_local");
                dialoginterface = new PlaylistItem(String.valueOf(l), dialoginterface.getText().toString(), "", "", "0", "0", "", 5, false);
                ((MainPage)ctx).arrayMyPlaylists.add(dialoginterface);
                ((MainPage)ctx).myPlaylists.add(String.valueOf(l));
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 1);
                ((MainPage)ctx).fragmentPlaylists.loadContent();
                ((MainPage)ctx).arraySong.clear();
                SongFragment songfragment = ((MainPage)ctx).setSong(dialoginterface.getPlaylistId());
                songfragment.currentPlaylist = dialoginterface;
                MixerBoxUtils.loadDBSong(ctx, dialoginterface.getPlaylistId(), false, songfragment);
                return;
            }
        }

        _cls1()
        {
            this$0 = CreatePlaylistDialog.this;
            view = view1;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final CreatePlaylistDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls2()
        {
            this$0 = CreatePlaylistDialog.this;
            super();
        }
    }

}
