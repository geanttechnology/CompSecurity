// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.view.ActionMode;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

public class PlaylistAdapter extends BaseAdapter
{

    private ArrayList array;
    private Context ctx;
    LayoutInflater mInflater;
    ActionMode mMode;

    public PlaylistAdapter(Context context, ArrayList arraylist)
    {
        ctx = context;
        array = new ArrayList(arraylist);
        mInflater = (LayoutInflater)ctx.getSystemService("layout_inflater");
    }

    public int getCount()
    {
        return array.size();
    }

    public Object getItem(int i)
    {
        return array.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        String s;
        if (view == null)
        {
            view = mInflater.inflate(0x7f03004c, null);
            viewgroup = new ViewHolder(null);
            viewgroup.tvName = (TextView)view.findViewById(0x7f07011c);
            viewgroup.tvOwner = (TextView)view.findViewById(0x7f07011d);
            viewgroup.tvItemCount = (TextView)view.findViewById(0x7f07011b);
            viewgroup.iv = (ImageView)view.findViewById(0x7f070119);
            viewgroup.ivQuickPlay = (ImageView)view.findViewById(0x7f07011a);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).tvName.setText(((PlaylistItem)array.get(position)).getPlaylistName());
        if (((PlaylistItem)array.get(position)).getPlaylistOwnerName().length() != 0)
        {
            ((ViewHolder) (viewgroup)).tvOwner.setVisibility(0);
            ((ViewHolder) (viewgroup)).tvOwner.setText((new StringBuilder()).append(ctx.getResources().getString(0x7f0800d1)).append(" ").append(((PlaylistItem)array.get(position)).getPlaylistOwnerName()).toString());
        } else
        {
            ((ViewHolder) (viewgroup)).tvOwner.setVisibility(8);
        }
        ((ViewHolder) (viewgroup)).tvItemCount.setText(((PlaylistItem)array.get(position)).getPlaylistItemCount());
        s = ((PlaylistItem)array.get(position)).getPlaylistCover();
        ImageLoader.getInstance().displayImage(s, ((ViewHolder) (viewgroup)).iv);
        ((ViewHolder) (viewgroup)).ivQuickPlay.setOnClickListener(new _cls1());
        return view;
    }


    private class ViewHolder
    {

        public ImageView iv;
        public ImageView ivQuickPlay;
        public TextView tvItemCount;
        public TextView tvName;
        public TextView tvOwner;

        private ViewHolder()
        {
        }

        ViewHolder(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PlaylistAdapter this$0;
        final int val$position;

        public void onClick(View view)
        {
            view = (PlaylistItem)getItem(position);
            if (!view.getPlaylistId().equals("-999"))
            {
                if (view.getPlaylistType() == 8 && ((MainPage)ctx).currentFragment == 0)
                {
                    ((MainPage)ctx).setMP3();
                    return;
                }
                if (((MainPage)ctx).currentFragment == 14)
                {
                    if (view.getPlaylistId() == "PLAYLISTMP3PLAYLISTID")
                    {
                        ((MainPage)ctx).arraySong.clear();
                        SongFragment songfragment = ((MainPage)ctx).setSong(view.getPlaylistId());
                        songfragment.currentPlaylist = view;
                        view = android.provider.MediaStore.Audio.Playlists.Members.getContentUri("external", Long.valueOf(view.getPlaylistOwnerId()).longValue());
                        MixerBoxUtils.loadMP3Song(ctx, true, songfragment, "is_music != 0 ", view);
                        return;
                    }
                    if (view.getPlaylistId() == "PLAYLISTMP3ALBUMID")
                    {
                        ((MainPage)ctx).arraySong.clear();
                        SongFragment songfragment1 = ((MainPage)ctx).setSong(view.getPlaylistId());
                        songfragment1.currentPlaylist = view;
                        view = (new StringBuilder()).append("album_id = ").append(songfragment1.currentPlaylist.getPlaylistOwnerId()).toString();
                        MixerBoxUtils.loadMP3Song(ctx, true, songfragment1, view, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                        return;
                    }
                    if (view.getPlaylistId() == "PLAYLISTMP3ARTISTID")
                    {
                        ((MainPage)ctx).arraySong.clear();
                        SongFragment songfragment2 = ((MainPage)ctx).setSong(view.getPlaylistId());
                        songfragment2.currentPlaylist = view;
                        view = (new StringBuilder()).append("artist_id = ").append(songfragment2.currentPlaylist.getPlaylistOwnerId()).toString();
                        MixerBoxUtils.loadMP3Song(ctx, true, songfragment2, view, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                        return;
                    }
                } else
                {
                    if (view.getPlaylistType() == 5 || view.getPlaylistId().equals("PLAYLISTHISTORYID"))
                    {
                        ((MainPage)ctx).arraySong.clear();
                        SongFragment songfragment3 = ((MainPage)ctx).setSong(view.getPlaylistId());
                        songfragment3.currentPlaylist = view;
                        MixerBoxUtils.loadDBSong(ctx, view.getPlaylistId(), true, songfragment3);
                        return;
                    }
                    if (!MixerBoxClient.isConnectingToInternet(ctx))
                    {
                        AlertDialogFactory.NoNetworkAlertDialog((Activity)ctx).show();
                        return;
                    } else
                    {
                        ((MainPage)ctx).arraySong.clear();
                        Object obj = ((MainPage)ctx).setSong(view.getPlaylistId());
                        obj.currentPlaylist = view;
                        MixerBoxUtils.loadSong(ctx, view.getPlaylistId(), false, 1, 0, ((SongFragment) (obj)));
                        obj = new HashMap();
                        ((Map) (obj)).put("id", view.getPlaylistId());
                        FlurryAgent.logEvent("action:playlist_play", ((Map) (obj)));
                        return;
                    }
                }
            }
        }

        _cls1()
        {
            this$0 = PlaylistAdapter.this;
            position = i;
            super();
        }
    }

}
