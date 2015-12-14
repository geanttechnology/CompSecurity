// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.manager.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;

public class LibraryAdapter extends BaseAdapter
{
    public static interface OnSongClickListener
    {

        public abstract void onSongMore(Song song);

        public abstract void onSongPlay(Song song);
    }


    static final boolean $assertionsDisabled;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnSongClickListener mListener;
    private Server mServer;
    private List mSongList;

    public LibraryAdapter(Context context, Server server, List list, OnSongClickListener onsongclicklistener)
    {
        mServer = server;
        mContext = context;
        mSongList = list;
        mListener = onsongclicklistener;
        mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public int getCount()
    {
        return mSongList.size();
    }

    public Object getItem(int i)
    {
        return mSongList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class SongClickListener {}

    /* block-local class not found */
    class ViewHolder {}

        Song song;
        SongClickListener songclicklistener;
        if (view == null)
        {
            view = mLayoutInflater.inflate(0x7f030082, viewgroup, false);
            viewgroup = new ViewHolder(null);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewgroup.song = (TextView)view.findViewById(0x7f0d02bd);
            viewgroup.artist = (TextView)view.findViewById(0x7f0d02bf);
            viewgroup.cover = (ImageView)view.findViewById(0x7f0d02bb);
            viewgroup.more = (ImageButton)view.findViewById(0x7f0d02bc);
            viewgroup.content = (Button)view.findViewById(0x7f0d02ba);
            viewgroup.status = (ImageView)view.findViewById(0x7f0d02be);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        song = (Song)mSongList.get(i);
        songclicklistener = new SongClickListener(song);
        ((ViewHolder) (viewgroup)).song.setText(song.getName());
        ((ViewHolder) (viewgroup)).more.setOnClickListener(songclicklistener);
        ((ViewHolder) (viewgroup)).content.setOnClickListener(songclicklistener);
        ((ViewHolder) (viewgroup)).content.setOnLongClickListener(songclicklistener);
        ((ViewHolder) (viewgroup)).artist.setText(song.getAlbum().getArtist().getName());
        Picasso.with(mContext).load(song.getAlbum().getImage()).placeholder(0x7f0201dc).fit().into(((ViewHolder) (viewgroup)).cover);
        if (mServer.isDownloaded(song))
        {
            ((ViewHolder) (viewgroup)).status.setVisibility(0);
            viewgroup = ((ViewHolder) (viewgroup)).status;
            if (mServer.isDownloadFinished(song))
            {
                i = 0x7f02014b;
            } else
            {
                i = 0x7f02014a;
            }
            viewgroup.setImageResource(i);
            return view;
        } else
        {
            ((ViewHolder) (viewgroup)).status.setVisibility(8);
            return view;
        }
    }

    public void removeSong(Song song)
    {
        mSongList.remove(song);
    }

    public void setSongList(List list)
    {
        mSongList = list;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/manager/library/LibraryAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

}
