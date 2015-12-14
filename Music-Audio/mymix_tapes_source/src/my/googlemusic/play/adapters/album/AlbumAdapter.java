// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.album;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;

public class AlbumAdapter extends BaseAdapter
    implements android.view.View.OnClickListener
{
    public static interface OnSongListener
    {

        public abstract void onSongMore(Song song);

        public abstract void onSongPlay(Song song);
    }


    static final boolean $assertionsDisabled;
    private LayoutInflater mInflater;
    private OnSongListener mListener;
    private List mPlayList;
    private Server mServer;

    public AlbumAdapter(Context context, Server server, List list, OnSongListener onsonglistener)
    {
        mServer = server;
        mListener = onsonglistener;
        mPlayList = list;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public int getCount()
    {
        return mPlayList.size();
    }

    public Object getItem(int i)
    {
        return mPlayList.get(i);
    }

    public long getItemId(int i)
    {
        return ((Song)mPlayList.get(i)).getId();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class SongListener {}

    /* block-local class not found */
    class ViewHolder {}

        Song song;
        SongListener songlistener;
        boolean flag;
        if (view == null)
        {
            ViewHolder viewholder = new ViewHolder(null);
            view = mInflater.inflate(0x7f030079, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewholder.content = (ImageButton)view.findViewById(0x7f0d028d);
            viewholder.song = (TextView)view.findViewById(0x7f0d028f);
            viewholder.more = (ImageButton)view.findViewById(0x7f0d028e);
            viewholder.artist = (TextView)view.findViewById(0x7f0d0291);
            viewholder.status = (ImageView)view.findViewById(0x7f0d0290);
            view.setTag(viewholder);
            viewgroup = viewholder;
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        song = (Song)mPlayList.get(i);
        songlistener = new SongListener(song);
        ((ViewHolder) (viewgroup)).song.setText(song.getName());
        ((ViewHolder) (viewgroup)).artist.setText(song.getAlbum().getArtist().getName());
        ((ViewHolder) (viewgroup)).more.setOnClickListener(songlistener);
        ((ViewHolder) (viewgroup)).content.setOnClickListener(songlistener);
        ((ViewHolder) (viewgroup)).content.setOnLongClickListener(songlistener);
        if (mServer.isDownloaded(song))
        {
            ((ViewHolder) (viewgroup)).status.setVisibility(0);
            ImageView imageview = ((ViewHolder) (viewgroup)).status;
            if (mServer.isDownloadFinished(song))
            {
                i = 0x7f02014b;
            } else
            {
                i = 0x7f02014a;
            }
            imageview.setImageResource(i);
        } else
        {
            ((ViewHolder) (viewgroup)).status.setVisibility(8);
        }
        viewgroup = ((ViewHolder) (viewgroup)).content;
        if (song.isDownloaded() || URLUtil.isValidUrl(song.getUrl()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewgroup.setEnabled(flag);
        return view;
    }

    public void onClick(View view)
    {
        view.showContextMenu();
    }

    public void removeSong(Song song)
    {
        mPlayList.remove(song);
    }

    public void setList(List list)
    {
        mPlayList = list;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/album/AlbumAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

}
