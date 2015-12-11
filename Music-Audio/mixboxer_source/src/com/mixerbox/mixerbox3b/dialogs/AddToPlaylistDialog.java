// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import java.util.ArrayList;

public class AddToPlaylistDialog extends android.app.AlertDialog.Builder
{

    ArrayList arrayMyPlaylists;
    private Context ctx;
    SongItem song;

    public AddToPlaylistDialog(Context context, SongItem songitem)
    {
        super(context);
        ctx = context;
        song = songitem;
        getContent();
    }

    private void getContent()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(ctx);
        View view = layoutinflater.inflate(0x7f030025, null);
        setView(view);
        final EditText etName = (EditText)view.findViewById(0x7f070062);
        final RadioGroup radioGroup = (RadioGroup)view.findViewById(0x7f070060);
        final ImageView iv = (ImageView)view.findViewById(0x7f07004a);
        iv.setOnClickListener(new _cls1());
        if (song != null && song.getSongName() != null)
        {
            etName.setText(song.getSongName());
            etName.setSelection(song.getSongName().length());
        }
        byte byte0;
        if (((MainPage)ctx).arrayMyPlaylists != null && ((MainPage)ctx).arrayMyPlaylists.size() > 0)
        {
            arrayMyPlaylists = new ArrayList(((MainPage)ctx).arrayMyPlaylists);
            if (((PlaylistItem)arrayMyPlaylists.get(arrayMyPlaylists.size() - 1)).getPlaylistId().equals("PLAYLISTHISTORYID"))
            {
                arrayMyPlaylists.remove(arrayMyPlaylists.size() - 1);
            }
        } else
        {
            arrayMyPlaylists = null;
        }
        if (arrayMyPlaylists != null)
        {
            int i = arrayMyPlaylists.size() - 1;
            byte0 = 0;
            while (i >= 0) 
            {
                if (((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistId().equals("-999"))
                {
                    byte0 = 2;
                } else
                {
                    RadioButton radiobutton = (RadioButton)layoutinflater.inflate(0x7f030054, null);
                    radiobutton.setId(i);
                    radiobutton.setText(((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistName());
                    radioGroup.addView(radiobutton, 0);
                    byte0 = 1;
                }
                i--;
            }
        } else
        {
            byte0 = 0;
        }
        if (byte0 == 1)
        {
            radioGroup.check(0);
        } else
        if (byte0 == 2 && arrayMyPlaylists.size() > 1)
        {
            radioGroup.check(1);
        } else
        {
            radioGroup.check(0x7f070061);
            etName.setVisibility(0);
            iv.setVisibility(0);
            etName.requestFocus();
        }
        ((RadioButton)view.findViewById(0x7f070061)).setOnCheckedChangeListener(new _cls2());
        etName.addTextChangedListener(new _cls3());
        setTitle(ctx.getResources().getString(0x7f080060));
        setPositiveButton(ctx.getResources().getString(0x7f08007e), new _cls4());
        setNegativeButton(ctx.getResources().getString(0x7f080063), new _cls5());
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final AddToPlaylistDialog this$0;
        final EditText val$etName;

        public void onClick(View view)
        {
            etName.setText("");
        }

        _cls1()
        {
            this$0 = AddToPlaylistDialog.this;
            etName = edittext;
            super();
        }
    }


    private class _cls2
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final AddToPlaylistDialog this$0;
        final EditText val$etName;
        final ImageView val$iv;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (flag)
            {
                etName.setVisibility(0);
                iv.setVisibility(0);
                etName.requestFocus();
                return;
            } else
            {
                etName.setVisibility(8);
                iv.setVisibility(8);
                return;
            }
        }

        _cls2()
        {
            this$0 = AddToPlaylistDialog.this;
            etName = edittext;
            iv = imageview;
            super();
        }
    }


    private class _cls3
        implements TextWatcher
    {

        final AddToPlaylistDialog this$0;
        final RadioGroup val$radioGroup;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            radioGroup.check(0x7f070061);
        }

        _cls3()
        {
            this$0 = AddToPlaylistDialog.this;
            radioGroup = radiogroup;
            super();
        }
    }


    private class _cls4
        implements android.content.DialogInterface.OnClickListener
    {

        final AddToPlaylistDialog this$0;
        final EditText val$etName;
        final RadioGroup val$radioGroup;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            i = radioGroup.getCheckedRadioButtonId();
            if (i == 0x7f070061 && (etName.getText() == null || etName.getText().toString().length() == 0))
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f08006d), 1);
                (new AddToPlaylistDialog(ctx, song)).show().getWindow().setSoftInputMode(16);
                return;
            }
            if (((MainPage)ctx).isLogIn)
            {
                if (arrayMyPlaylists != null && i < arrayMyPlaylists.size() && i >= 0)
                {
                    MixerBoxUtils.addSong(ctx, ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistId(), song, true, ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistName());
                    return;
                } else
                {
                    MixerBoxUtils.addSongToNewPlaylist(ctx, etName.getText().toString(), song);
                    return;
                }
            }
            FlurryAgent.logEvent("action:music_add_local");
            if (arrayMyPlaylists != null && i < arrayMyPlaylists.size() && i >= 0)
            {
                MixerBoxSharedPreferences.putDefaultAddedPlaylist(ctx, ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistId(), ((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistName());
                ((MainPage)ctx).DB.addSong(((PlaylistItem)arrayMyPlaylists.get(i)).getPlaylistId(), song.getSongName(), song.getSongTime(), song.getSongYtId(), song.getSongOrder(), song.getSongSource(), song.getSongThumbnail());
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080077), 1);
                ((MainPage)ctx).fragmentPlaylists.loadContent();
                return;
            }
            long l = ((MainPage)ctx).DB.addMyPlaylist("", etName.getText().toString(), "", "", "0", "0", "", 5);
            if (String.valueOf(l).equals("-1"))
            {
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080049), 1);
                return;
            } else
            {
                ((MainPage)ctx).arrayMyPlaylists.add(new PlaylistItem(String.valueOf(l), etName.getText().toString(), "", "", "0", "0", "", 5, false));
                ((MainPage)ctx).myPlaylists.add(String.valueOf(l));
                MixerBoxSharedPreferences.putDefaultAddedPlaylist(ctx, String.valueOf(l), etName.getText().toString());
                ((MainPage)ctx).DB.addSong(String.valueOf(l), song.getSongName(), song.getSongTime(), song.getSongYtId(), song.getSongOrder(), song.getSongSource(), song.getSongThumbnail());
                MixerBoxUtils.toastMsg(ctx, ctx.getResources().getString(0x7f080077), 1);
                ((MainPage)ctx).fragmentPlaylists.loadContent();
                return;
            }
        }

        _cls4()
        {
            this$0 = AddToPlaylistDialog.this;
            radioGroup = radiogroup;
            etName = edittext;
            super();
        }
    }


    private class _cls5
        implements android.content.DialogInterface.OnClickListener
    {

        final AddToPlaylistDialog this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
        }

        _cls5()
        {
            this$0 = AddToPlaylistDialog.this;
            super();
        }
    }

}
