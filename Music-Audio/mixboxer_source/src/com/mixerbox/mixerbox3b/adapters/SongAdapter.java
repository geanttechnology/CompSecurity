// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

public class SongAdapter extends BaseAdapter
{

    public ArrayList array;
    private Context ctx;
    String currentPlaylistId;
    LayoutInflater mInflater;

    public SongAdapter(Context context, ArrayList arraylist, String s)
    {
        ctx = context;
        array = new ArrayList(arraylist);
        mInflater = (LayoutInflater)ctx.getSystemService("layout_inflater");
        currentPlaylistId = s;
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
        View view1;
        if (view == null)
        {
            view1 = mInflater.inflate(0x7f03004f, null);
            viewgroup = new ViewHolder(null);
            viewgroup.tvName = (TextView)view1.findViewById(0x7f070121);
            viewgroup.tvTime = (TextView)view1.findViewById(0x7f070120);
            viewgroup.iv = (ImageView)view1.findViewById(0x7f07011e);
            viewgroup.btnEdit = (ImageButton)view1.findViewById(0x7f070122);
            view1.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
            view1 = view;
        }
        ((ViewHolder) (viewgroup)).tvName.setText(((SongItem)array.get(position)).getSongName());
        ((ViewHolder) (viewgroup)).tvTime.setText(MixerBoxUtils.getSongTime(((SongItem)array.get(position)).getSongTime()));
        if (currentPlaylistId.equals("PLAYLISTMP3ID") || currentPlaylistId.equals("PLAYLISTMP3ALBUMID") || currentPlaylistId.equals("PLAYLISTMP3PLAYLISTID") || currentPlaylistId.equals("PLAYLISTMP3ARTISTID"))
        {
            view = Uri.parse("content://media/external/audio/albumart");
            if (((SongItem)array.get(position)).getSongId() != null)
            {
                view = ContentUris.withAppendedId(view, Long.valueOf(((SongItem)array.get(position)).getSongId()).longValue()).toString();
            } else
            {
                view = "";
            }
        } else
        if (((SongItem)array.get(position)).getSongSource() == 3)
        {
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                view = new android.widget.RelativeLayout.LayoutParams(ctx.getResources().getDimensionPixelSize(0x7f0b0041), ctx.getResources().getDimensionPixelSize(0x7f0b0042));
                int i = (int)(ctx.getResources().getDisplayMetrics().density * 10F);
                int k = (int)(ctx.getResources().getDisplayMetrics().density * 5F);
                view.setMargins(i, k, 0, k);
                ((ViewHolder) (viewgroup)).iv.setLayoutParams(view);
            }
            view = ((SongItem)array.get(position)).getSongThumbnail();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            view = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(((SongItem)array.get(position)).getSongYtId()).append("/mqdefault.jpg").toString();
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(ctx.getResources().getDimensionPixelSize(0x7f0b0041), ctx.getResources().getDimensionPixelSize(0x7f0b0042));
            int j = (int)(ctx.getResources().getDisplayMetrics().density * 10F);
            int l = (int)(ctx.getResources().getDisplayMetrics().density * 5F);
            layoutparams.setMargins(j, l, 0, l);
            ((ViewHolder) (viewgroup)).iv.setLayoutParams(layoutparams);
            layoutparams = (android.widget.RelativeLayout.LayoutParams)((ViewHolder) (viewgroup)).tvTime.getLayoutParams();
            layoutparams.addRule(8, 0x7f07011e);
            layoutparams.addRule(7, 0x7f07011e);
            ((ViewHolder) (viewgroup)).tvTime.setLayoutParams(layoutparams);
        } else
        {
            view = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(((SongItem)array.get(position)).getSongYtId()).append("/default.jpg").toString();
        }
        ImageLoader.getInstance().displayImage(view, ((ViewHolder) (viewgroup)).iv);
        if (currentPlaylistId.equals("PLAYLISTMP3ID") || currentPlaylistId.equals("PLAYLISTMP3ALBUMID") || currentPlaylistId.equals("PLAYLISTMP3PLAYLISTID") || currentPlaylistId.equals("PLAYLISTMP3ARTISTID"))
        {
            ((ViewHolder) (viewgroup)).btnEdit.setVisibility(4);
            return view1;
        }
        if (((MainPage)ctx).currentFragment == 8)
        {
            ((ViewHolder) (viewgroup)).btnEdit.setImageResource(0x7f0200c7);
            ((ViewHolder) (viewgroup)).btnEdit.setOnClickListener(new _cls1());
            return view1;
        }
        if (((MainPage)ctx).myPlaylists.contains(currentPlaylistId) && ((MainPage)ctx).currentFragment != 8 && ((MainPage)ctx).currentFragment != 9 || currentPlaylistId.equals("PLAYLISTHISTORYID"))
        {
            ((ViewHolder) (viewgroup)).btnEdit.setImageResource(0x7f020103);
        }
        ((ViewHolder) (viewgroup)).btnEdit.setOnClickListener(new _cls2());
        return view1;
    }


    private class ViewHolder
    {

        public ImageButton btnEdit;
        public ImageView iv;
        public TextView tvName;
        public TextView tvTime;

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

        final SongAdapter this$0;
        final int val$position;

        public void onClick(View view)
        {
            MixerBoxUtils.performSongAction(ctx, 1, (SongItem)array.get(position), currentPlaylistId, array.size() - position - 1);
        }

        _cls1()
        {
            this$0 = SongAdapter.this;
            position = i;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final SongAdapter this$0;
        final int val$position;

        public void onClick(View view)
        {
            MixerBoxUtils.createPopupMenu(ctx, view, (SongItem)array.get(position), currentPlaylistId, array.size() - position - 1);
            view = new HashMap();
            view.put("id", ((SongItem)array.get(position)).getSongId());
            view.put("playlist", currentPlaylistId);
            FlurryAgent.logEvent("action:music_edit", view);
        }

        _cls2()
        {
            this$0 = SongAdapter.this;
            position = i;
            super();
        }
    }

}
