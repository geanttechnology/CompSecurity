// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

public class SearchMoreAdapter extends BaseAdapter
{
    public static interface OnItemSearchListClickListener
    {

        public abstract void onItemSearchListClick(Object obj);
    }


    static final boolean $assertionsDisabled;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnItemSearchListClickListener mListener;
    private List mSearchList;

    public SearchMoreAdapter(Context context, OnItemSearchListClickListener onitemsearchlistclicklistener)
    {
        mContext = context;
        mListener = onitemsearchlistclicklistener;
        mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public int getCount()
    {
        if (mSearchList == null)
        {
            return 0;
        } else
        {
            return mSearchList.size();
        }
    }

    public Object getItem(int i)
    {
        return mSearchList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public List getSongList()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < mSearchList.size(); i++)
        {
            arraylist.add((Song)mSearchList.get(i));
        }

        return arraylist;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ItemSearchListClickListener {}

    /* block-local class not found */
    class ViewHolder {}

        Object obj;
        if (view == null)
        {
            view = mLayoutInflater.inflate(0x7f030089, viewgroup, false);
            viewgroup = new ViewHolder(null);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewgroup.title = (TextView)view.findViewById(0x7f0d02e6);
            viewgroup.image = (ImageView)view.findViewById(0x7f0d02e5);
            viewgroup.content = (Button)view.findViewById(0x7f0d02e4);
            viewgroup.subtitle = (TextView)view.findViewById(0x7f0d02e7);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        obj = mSearchList.get(i);
        if (obj instanceof Album)
        {
            obj = (Album)obj;
            ((ViewHolder) (viewgroup)).title.setText(((Album) (obj)).getName());
            ((ViewHolder) (viewgroup)).subtitle.setText(((Album) (obj)).getArtist().getName());
            ((ViewHolder) (viewgroup)).content.setOnClickListener(new ItemSearchListClickListener(i));
            Picasso.with(mContext).load(((Album) (obj)).getImage()).placeholder(0x7f0201dc).fit().into(((ViewHolder) (viewgroup)).image);
        } else
        {
            if (obj instanceof Artist)
            {
                obj = (Artist)obj;
                ((ViewHolder) (viewgroup)).title.setText(((Artist) (obj)).getName());
                ((ViewHolder) (viewgroup)).subtitle.setText(((Artist) (obj)).getTwitter());
                ((ViewHolder) (viewgroup)).content.setOnClickListener(new ItemSearchListClickListener(i));
                Picasso.with(mContext).load(((Artist) (obj)).getImage()).placeholder(0x7f02003e).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().into(((ViewHolder) (viewgroup)).image);
                return view;
            }
            if (obj instanceof Song)
            {
                obj = (Song)obj;
                ((ViewHolder) (viewgroup)).title.setText(((Song) (obj)).getName());
                ((ViewHolder) (viewgroup)).subtitle.setText(((Song) (obj)).getAlbum().getName());
                ((ViewHolder) (viewgroup)).content.setOnClickListener(new ItemSearchListClickListener(i));
                Picasso.with(mContext).load(((Song) (obj)).getAlbum().getImage()).placeholder(0x7f0201dc).fit().into(((ViewHolder) (viewgroup)).image);
                return view;
            }
        }
        return view;
    }

    public void setSearchList(List list)
    {
        mSearchList = list;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/search/SearchMoreAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

}
