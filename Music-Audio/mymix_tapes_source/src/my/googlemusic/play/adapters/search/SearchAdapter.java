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

public class SearchAdapter extends BaseAdapter
{

    static final boolean $assertionsDisabled;
    private List mAlbumList;
    private List mArtistList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnItemSearchClickListener mListener;
    private List mSearchList;
    private List mSongList;

    public SearchAdapter(Context context, List list, List list1, List list2, OnItemSearchClickListener onitemsearchclicklistener)
    {
        if (context == null)
        {
            return;
        } else
        {
            mContext = context;
            mListener = onitemsearchclicklistener;
            setSearchList(list, list1, list2);
            mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
            return;
        }
    }

    private void generateSearchList()
    {
        mSearchList = new ArrayList();
        if (mAlbumList.size() <= 0) goto _L2; else goto _L1
_L1:
    /* block-local class not found */
    class Item {}

        int i;
        mSearchList.add(new Item(2, "Mixtapes"));
        i = 0;
_L22:
        if (i >= mAlbumList.size()) goto _L4; else goto _L3
_L3:
        if (i != 3) goto _L6; else goto _L5
_L5:
        mSearchList.add(new Item(0, "Mixtapes"));
_L4:
        if (mArtistList.size() <= 0) goto _L8; else goto _L7
_L7:
        mSearchList.add(new Item(2, "Artists"));
        i = 0;
_L19:
        if (i >= mArtistList.size()) goto _L10; else goto _L9
_L9:
        if (i != 3) goto _L12; else goto _L11
_L11:
        mSearchList.add(new Item(0, "Artists"));
_L10:
        if (mSongList.size() <= 0) goto _L14; else goto _L13
_L13:
        mSearchList.add(new Item(2, "Tracks"));
        i = 0;
_L20:
        if (i >= mSongList.size()) goto _L16; else goto _L15
_L15:
        if (i != 3) goto _L18; else goto _L17
_L17:
        mSearchList.add(new Item(0, "Tracks"));
_L16:
        return;
_L6:
        Album album = (Album)mAlbumList.get(i);
        mSearchList.add(new Item(album));
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        mSearchList.add(new Item(2, "Mixtapes"));
        mSearchList.add(new Item(1, "Mixtapes"));
          goto _L4
_L12:
        Artist artist = (Artist)mArtistList.get(i);
        mSearchList.add(new Item(artist));
        i++;
          goto _L19
_L8:
        mSearchList.add(new Item(2, "Artists"));
        mSearchList.add(new Item(1, "Artists"));
          goto _L10
_L18:
        Song song = (Song)mSongList.get(i);
        mSearchList.add(new Item(song));
        i++;
          goto _L20
_L14:
        mSearchList.add(new Item(2, "Tracks"));
        mSearchList.add(new Item(1, "Tracks"));
        return;
        if (true) goto _L22; else goto _L21
_L21:
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ViewHolder {}

        Item item;
        if (view == null)
        {
            view = mLayoutInflater.inflate(0x7f030088, viewgroup, false);
            viewgroup = new ViewHolder(null);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewgroup.empty = view.findViewById(0x7f0d02e2);
            viewgroup.header = view.findViewById(0x7f0d02d9);
            viewgroup.container = view.findViewById(0x7f0d02db);
            viewgroup.more = (Button)view.findViewById(0x7f0d02e1);
            viewgroup.title = (TextView)view.findViewById(0x7f0d02de);
            viewgroup.image = (ImageView)view.findViewById(0x7f0d02dd);
            viewgroup.content = (Button)view.findViewById(0x7f0d02dc);
            viewgroup.info = (TextView)view.findViewById(0x7f0d02e3);
            viewgroup.subtitle = (TextView)view.findViewById(0x7f0d02df);
            viewgroup.category = (TextView)view.findViewById(0x7f0d02da);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).more.setVisibility(8);
        ((ViewHolder) (viewgroup)).empty.setVisibility(8);
        ((ViewHolder) (viewgroup)).header.setVisibility(8);
        ((ViewHolder) (viewgroup)).container.setVisibility(8);
        item = (Item)mSearchList.get(i);
        if (item.isHeader())
        {
            ((ViewHolder) (viewgroup)).category.setText(item.getCategory());
            ((ViewHolder) (viewgroup)).header.setVisibility(0);
        } else
        {
    /* block-local class not found */
    class ItemSearchClickListener {}

            if (item.isContainer())
            {
                ((ViewHolder) (viewgroup)).content.setOnClickListener(new ItemSearchClickListener(item));
                ((ViewHolder) (viewgroup)).title.setText(item.getTitle());
                ((ViewHolder) (viewgroup)).subtitle.setText(item.getSubtitle());
                if (item.getCategory().equals("Artists"))
                {
                    Picasso.with(mContext).load(item.image).placeholder(0x7f02003e).fit().centerCrop().transform(new CropSquareTransformation()).into(((ViewHolder) (viewgroup)).image);
                } else
                {
                    Picasso.with(mContext).load(item.getImage()).placeholder(0x7f0201dc).fit().into(((ViewHolder) (viewgroup)).image);
                }
                ((ViewHolder) (viewgroup)).container.setVisibility(0);
                return view;
            }
            if (item.isMore())
            {
                ((ViewHolder) (viewgroup)).more.setOnClickListener(new ItemSearchClickListener(item));
                ((ViewHolder) (viewgroup)).more.setText("See more");
                ((ViewHolder) (viewgroup)).more.setVisibility(0);
                return view;
            }
            if (item.isEmpty())
            {
                ((ViewHolder) (viewgroup)).info.setText((new StringBuilder()).append("No ").append(item.getCategory().toLowerCase()).append(" found").toString());
                ((ViewHolder) (viewgroup)).empty.setVisibility(0);
                return view;
            }
        }
        return view;
    }

    public void setSearchList(List list, List list1, List list2)
    {
        mSongList = list;
        mAlbumList = list1;
        mArtistList = list2;
        generateSearchList();
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/search/SearchAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }


    // Unreferenced inner class my/googlemusic/play/adapters/search/SearchAdapter$OnItemSearchClickListener
    /* block-local class not found */
    class OnItemSearchClickListener {}

}
