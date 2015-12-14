// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.manager;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;

public class GridAlbumAdapter extends BaseAdapter
{
    public static interface OnAlbumClickListener
    {

        public abstract void onAlbumClick(Album album);
    }


    static final boolean $assertionsDisabled;
    public static final int ALBUM_TYPE_FEATURES = 1;
    public static final int ALBUM_TYPE_JUST_ADDED = 2;
    public static final int ALBUM_TYPE_SINGLES = 3;
    private List mAdapterList;
    private int mAlbumType;
    private Context mContext;
    private int mCount;
    private LayoutInflater mInflater;
    private OnAlbumClickListener mListener;

    public GridAlbumAdapter(Context context, List list, int i, OnAlbumClickListener onalbumclicklistener)
    {
        if (context == null)
        {
            return;
        } else
        {
            mContext = context;
            mAlbumType = i;
            mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
            mAdapterList = createAdapterList(new ArrayList(list));
            mCount = mAdapterList.size();
            mListener = onalbumclicklistener;
            return;
        }
    }

    private List createAdapterList(List list)
    {
        ArrayList arraylist = new ArrayList();
_L11:
        if (list.size() <= 0) goto _L2; else goto _L1
_L1:
        int i;
        ArrayList arraylist1 = new ArrayList(2);
        Album album = (Album)list.remove(0);
        arraylist1.add(album);
        Album album1;
        if (mAlbumType == 1 && album.isBiggerFeatures() || mAlbumType == 2 && album.isBiggerJustAdded() || mAlbumType == 3 && album.isBiggerSingles())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0) goto _L4; else goto _L3
_L3:
        i = 0;
_L9:
        if (i >= list.size()) goto _L6; else goto _L5
_L5:
        album1 = (Album)list.get(i);
        boolean flag;
        if (mAlbumType == 1 && album.isBiggerFeatures() || mAlbumType == 2 && album.isBiggerJustAdded() || mAlbumType == 3 && album.isBiggerSingles())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L8; else goto _L7
_L7:
        list.remove(i);
        arraylist1.add(album1);
_L6:
        if (arraylist1.size() == 1)
        {
            arraylist1.add(null);
        }
_L4:
        arraylist.add(arraylist1);
        continue; /* Loop/switch isn't completed */
_L8:
        i++;
        if (true) goto _L9; else goto _L2
_L2:
        return arraylist;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void addList(List list)
    {
        mAdapterList.addAll(createAdapterList(new ArrayList(list)));
        mCount = mAdapterList.size();
        System.out.println((new StringBuilder()).append("mAdapter size ").append(mAdapterList.size()).toString());
    }

    public int getCount()
    {
        return mCount;
    }

    public Object getItem(int i)
    {
        return mAdapterList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class AlbumClickListener {}

    /* block-local class not found */
    class FadeTouchListener {}

    /* block-local class not found */
    class ViewHolder {}

        Album album;
        boolean flag;
        if (view == null)
        {
            view = mInflater.inflate(0x7f030081, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewgroup = new ViewHolder();
            viewgroup.itemLeft = view.findViewById(0x7f0d02ad);
            viewgroup.itemRight = view.findViewById(0x7f0d02b1);
            viewgroup.itemBigger = view.findViewById(0x7f0d02b5);
            viewgroup.albumLeft = (TextView)view.findViewById(0x7f0d02b0);
            viewgroup.albumRight = (TextView)view.findViewById(0x7f0d02b4);
            viewgroup.albumBigger = (TextView)view.findViewById(0x7f0d02b8);
            viewgroup.artistLeft = (TextView)view.findViewById(0x7f0d02af);
            viewgroup.artistRight = (TextView)view.findViewById(0x7f0d02b3);
            viewgroup.artistBigger = (TextView)view.findViewById(0x7f0d02b7);
            viewgroup.imageLeft = (SimpleDraweeView)view.findViewById(0x7f0d02ae);
            viewgroup.imageRight = (SimpleDraweeView)view.findViewById(0x7f0d02b2);
            viewgroup.imageBigger = (SimpleDraweeView)view.findViewById(0x7f0d02b6);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        album = (Album)((List)mAdapterList.get(i)).get(0);
        if (mAlbumType == 1 && album.isBiggerFeatures() || mAlbumType == 2 && album.isBiggerJustAdded() || mAlbumType == 3 && album.isBiggerSingles())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((ViewHolder) (viewgroup)).itemLeft.setVisibility(8);
            ((ViewHolder) (viewgroup)).itemRight.setVisibility(8);
            ((ViewHolder) (viewgroup)).itemBigger.setVisibility(0);
            ((ViewHolder) (viewgroup)).albumBigger.setText(album.getName().toUpperCase());
            ((ViewHolder) (viewgroup)).artistBigger.setText(album.getArtist().getName().toUpperCase());
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/Bebas Neue.ttf");
            ((ViewHolder) (viewgroup)).albumBigger.setTypeface(typeface);
            ((ViewHolder) (viewgroup)).artistBigger.setTypeface(typeface);
            ((ViewHolder) (viewgroup)).itemBigger.setOnTouchListener(new FadeTouchListener());
            ((ViewHolder) (viewgroup)).itemBigger.setOnClickListener(new AlbumClickListener(album));
            album.getImage();
            ((ViewHolder) (viewgroup)).imageBigger.setImageURI(Uri.parse(album.getImage()));
            return view;
        }
        ((ViewHolder) (viewgroup)).itemBigger.setVisibility(8);
        ((ViewHolder) (viewgroup)).itemLeft.setVisibility(0);
        ((ViewHolder) (viewgroup)).albumLeft.setText(album.getName().toUpperCase());
        ((ViewHolder) (viewgroup)).artistLeft.setText(album.getArtist().getName().toUpperCase());
        ((ViewHolder) (viewgroup)).itemLeft.setOnTouchListener(new FadeTouchListener());
        ((ViewHolder) (viewgroup)).itemLeft.setOnClickListener(new AlbumClickListener(album));
        ((ViewHolder) (viewgroup)).imageLeft.setImageURI(Uri.parse(album.getImage()));
        if (((List)mAdapterList.get(i)).get(1) == null)
        {
            ((ViewHolder) (viewgroup)).itemRight.setVisibility(8);
            return view;
        } else
        {
            Album album1 = (Album)((List)mAdapterList.get(i)).get(1);
            ((ViewHolder) (viewgroup)).itemRight.setVisibility(0);
            ((ViewHolder) (viewgroup)).albumRight.setText(album1.getName().toUpperCase());
            ((ViewHolder) (viewgroup)).artistRight.setText(album1.getArtist().getName().toUpperCase());
            ((ViewHolder) (viewgroup)).itemRight.setOnTouchListener(new FadeTouchListener());
            ((ViewHolder) (viewgroup)).itemRight.setOnClickListener(new AlbumClickListener(album1));
            ((ViewHolder) (viewgroup)).imageRight.setImageURI(Uri.parse(album1.getImage()));
            return view;
        }
    }

    public void setList(List list)
    {
        mAdapterList = createAdapterList(new ArrayList(list));
        mCount = mAdapterList.size();
        System.out.println((new StringBuilder()).append("mAdapter size ").append(mAdapterList.size()).toString());
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/manager/GridAlbumAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

}
