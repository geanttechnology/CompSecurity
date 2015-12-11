// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import java.util.Stack;

public class RemoveDialog extends android.app.AlertDialog.Builder
{

    private Context ctx;
    private int dialogType;
    int order;
    String playlistId;
    SongItem song;

    public RemoveDialog(Context context, int i, String s, SongItem songitem, int j)
    {
        super(context);
        ctx = context;
        dialogType = i;
        playlistId = s;
        song = songitem;
        order = j;
        getContent();
    }

    private void getContent()
    {
        Object obj = LayoutInflater.from(ctx).inflate(0x7f03002b, null);
        setView(((View) (obj)));
        obj = (TextView)((View) (obj)).findViewById(0x7f070063);
        if (song != null)
        {
            ((TextView) (obj)).setText((new StringBuilder()).append(ctx.getResources().getString(0x7f080056)).append(song.getSongName()).toString());
        } else
        {
            ((TextView) (obj)).setText((new StringBuilder()).append(ctx.getResources().getString(0x7f080054)).append(((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.getPlaylistName()).toString());
        }
        if (dialogType == 1)
        {
            setTitle(ctx.getResources().getString(0x7f080053));
        } else
        {
            setTitle(ctx.getResources().getString(0x7f080055));
        }
        setPositiveButton(ctx.getResources().getString(0x7f08007e), new _cls1());
        setNegativeButton(ctx.getResources().getString(0x7f080063), new _cls2());
    }



    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final RemoveDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (dialogType == 1)
            {
                if (((MainPage)ctx).isLogIn)
                {
                    ((MainPage)ctx).backToPreviousFragment();
                    if (((MainPage)ctx).fragmentPlaylists.lv != null)
                    {
                        ((MainPage)ctx).fragmentPlaylists.lv.setRefreshing();
                    }
                    MixerBoxUtils.removePlaylist(ctx, playlistId);
                    return;
                } else
                {
                    FlurryAgent.logEvent("action:playlist_delete_local");
                    ((MainPage)ctx).DB.deleteMyPlaylist(((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.getPlaylistId());
                    MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 1);
                    ((MainPage)ctx).fragmentPlaylists.loadContent();
                    ((MainPage)ctx).backToPreviousFragment();
                    return;
                }
            }
            if (((MainPage)ctx).isLogIn && !playlistId.equals("PLAYLISTHISTORYID"))
            {
                MixerBoxUtils.removeSong(ctx, playlistId, song, order);
                return;
            }
            FlurryAgent.logEvent("action:music_delete_local");
            ((MainPage)ctx).DB.deleteSong(playlistId, song.getSongYtId(), song.getSongId());
            if (((Fragment)((MainPage)ctx).stack.lastElement()).getClass().getSimpleName().equals("SongFragment") && ((SongFragment)((MainPage)ctx).stack.lastElement()).currentPlaylist.getPlaylistId().equals(playlistId))
            {
                i = ((SongFragment)((MainPage)ctx).stack.lastElement()).adapter.array.indexOf(song);
                if (i != -1)
                {
                    ((SongFragment)((MainPage)ctx).stack.lastElement()).adapter.array.remove(i);
                    ((SongFragment)((MainPage)ctx).stack.lastElement()).adapter.notifyDataSetChanged();
                }
            }
            MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f0800e9), 1);
            ((MainPage)ctx).fragmentPlaylists.loadContent();
        }

        _cls1()
        {
            this$0 = RemoveDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final RemoveDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls2()
        {
            this$0 = RemoveDialog.this;
            super();
        }
    }

}
