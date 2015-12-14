// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.artist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.model.Album;

public class ArtistAdapter extends BaseAdapter
{
    public static interface OnArtistAlbumClickListener
    {

        public abstract void onArtistAlbumClick(Album album);
    }


    static final boolean $assertionsDisabled;
    private List mAlbumList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnArtistAlbumClickListener mListener;

    public ArtistAdapter(Context context, List list, OnArtistAlbumClickListener onartistalbumclicklistener)
    {
        mAlbumList = list;
        mContext = context;
        mListener = onartistalbumclicklistener;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public int getCount()
    {
        return mAlbumList.size();
    }

    public Object getItem(int i)
    {
        return mAlbumList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ArtistAlbumClickListener {}

    /* block-local class not found */
    class FadeTouchListener {}

    /* block-local class not found */
    class ViewHolder {}

        Album album;
        if (view == null)
        {
            view = mLayoutInflater.inflate(0x7f03007b, viewgroup, false);
            viewgroup = new ViewHolder(null);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewgroup.image = (ImageView)view.findViewById(0x7f0d0296);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        album = (Album)mAlbumList.get(i);
        Picasso.with(mContext).load(album.getImage()).placeholder(0x7f0201dc).fit().into(((ViewHolder) (viewgroup)).image);
        ((ViewHolder) (viewgroup)).image.setOnClickListener(new ArtistAlbumClickListener(album));
        ((ViewHolder) (viewgroup)).image.setOnTouchListener(new FadeTouchListener(null));
        return view;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/artist/ArtistAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

}
