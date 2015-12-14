// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.manager.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;

public class LibraryRecyclerAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static interface OnSongClickListener
    {

        public abstract void onShuffle(List list);

        public abstract void onSongMore(Song song);

        public abstract void onSongPlay(Song song);
    }


    private Context context;
    private boolean hasFooter;
    private boolean hasHeader;
    private OnSongClickListener listener;
    private Server server;
    private List songs;

    public LibraryRecyclerAdapter(Context context1, OnSongClickListener onsongclicklistener)
    {
        context = context1;
        listener = onsongclicklistener;
        server = ((App)context1.getApplicationContext()).getServer();
    }

    public int getItemCount()
    {
        int i = 0;
        if (songs == null)
        {
            return 0;
        }
        int j = songs.size();
        if (hasHeader)
        {
            i = 1;
        }
        return i + j;
    }

    public int getItemViewType(int i)
    {
        if (i == 0 && hasHeader)
        {
            return 0;
        }
        return i != songs.size() || !hasFooter ? 1 : 2;
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
    /* block-local class not found */
    class SongClickListener {}

        if (i == 0 && hasHeader)
        {
    /* block-local class not found */
    class HeaderViewHolder {}

            viewholder = (HeaderViewHolder)viewholder;
            SongClickListener songclicklistener = new SongClickListener((Song)songs.get(i));
            ((HeaderViewHolder) (viewholder)).shuffle.setOnClickListener(songclicklistener);
        } else
        if (i != songs.size() || !hasFooter)
        {
    /* block-local class not found */
    class ViewHolder {}

            viewholder = (ViewHolder)viewholder;
            Object obj = songs;
            Album album;
            SongClickListener songclicklistener1;
            int j;
            if (hasHeader)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            obj = (Song)((List) (obj)).get(i - j);
            album = ((Song) (obj)).getAlbum();
            ((ViewHolder) (viewholder)).song.setText(((Song) (obj)).getName());
            songclicklistener1 = new SongClickListener(((Song) (obj)));
            ((ViewHolder) (viewholder)).song.setText(((Song) (obj)).getName());
            ((ViewHolder) (viewholder)).more.setOnClickListener(songclicklistener1);
            ((ViewHolder) (viewholder)).content.setOnClickListener(songclicklistener1);
            ((ViewHolder) (viewholder)).content.setOnLongClickListener(songclicklistener1);
            ((ViewHolder) (viewholder)).artist.setText(album.getArtist().getName());
            Picasso.with(context).load(((Song) (obj)).getAlbum().getImage()).placeholder(0x7f0201dc).fit().into(((ViewHolder) (viewholder)).cover);
            if (server.isDownloaded(((Song) (obj))))
            {
                ((ViewHolder) (viewholder)).status.setVisibility(0);
                viewholder = ((ViewHolder) (viewholder)).status;
                if (server.isDownloadFinished(((Song) (obj))))
                {
                    i = 0x7f02014b;
                } else
                {
                    i = 0x7f02014a;
                }
                viewholder.setImageResource(i);
                return;
            } else
            {
                ((ViewHolder) (viewholder)).status.setVisibility(8);
                return;
            }
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == 0 && hasHeader)
        {
            return new HeaderViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03008b, viewgroup, false));
        }
    /* block-local class not found */
    class FooterViewHolder {}

        if (i == 2 && hasFooter)
        {
            return new FooterViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030040, viewgroup, false));
        } else
        {
            return new ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030082, viewgroup, false));
        }
    }

    public void removeSong(Song song)
    {
        songs.remove(song);
        notifyItemRemoved(0);
    }

    public void setData(List list)
    {
        songs = list;
        notifyDataSetChanged();
    }

    public void setFooterEnabled(boolean flag)
    {
        hasFooter = flag;
    }

    public void setHeaderEnabled(boolean flag)
    {
        hasHeader = flag;
    }



    // Unreferenced inner class my/googlemusic/play/adapters/manager/library/LibraryRecyclerAdapter$VIEW_TYPES
    /* block-local class not found */
    class VIEW_TYPES {}

}
