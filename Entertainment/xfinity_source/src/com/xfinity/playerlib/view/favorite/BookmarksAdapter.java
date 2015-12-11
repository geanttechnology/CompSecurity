// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.Favorite;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.browsehistory.MultiDeleteBrowseAdapter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookmarksAdapter extends MultiDeleteBrowseAdapter
{
    class CoverArtLoadListener
        implements com.comcast.cim.android.image.CimImageLoader.OnLoadListener
    {

        ViewHolder holder;
        final BookmarksAdapter this$0;

        public void onLoad(ImageView imageview, String s, Bitmap bitmap)
        {
            if (isTablet)
            {
                holder.title.setVisibility(8);
            }
        }

        public void onLoadError(ImageView imageview, String s)
        {
        }

        public CoverArtLoadListener(ViewHolder viewholder)
        {
            this$0 = BookmarksAdapter.this;
            super();
            holder = viewholder;
        }
    }

    protected static class ViewHolder
    {

        public View container;
        public ImageView coverArt;
        public View layout;
        public ImageView lockedIndicator;
        public TextView title;

        protected ViewHolder()
        {
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/favorite/BookmarksAdapter);
    private List bookmarks;
    protected Context context;
    private final CoverArtImageLoader coverArtImageLoader;
    private DibicResource dibicResource;
    private final boolean isInBabyGuide;
    private boolean isTablet;
    private HalLiveStreamResource liveStreamResource;
    private VideoEntitlement videoEntitlement;

    public BookmarksAdapter(LayoutInflater layoutinflater, CoverArtImageLoader coverartimageloader, boolean flag)
    {
        super(layoutinflater);
        bookmarks = new ArrayList();
        coverArtImageLoader = coverartimageloader;
        isInBabyGuide = flag;
        context = layoutinflater.getContext();
    }

    protected void bindItem(ViewHolder viewholder, Favorite favorite)
    {
        viewholder.title.setText(favorite.getTitle());
        viewholder.coverArt.setImageResource(com.xfinity.playerlib.R.color.MissingImage);
        viewholder.title.setVisibility(0);
        boolean flag = false;
        if (favorite instanceof VideoFavorite)
        {
            coverArtImageLoader.loadImage(((VideoFavorite)favorite).getMerlinId(), viewholder.coverArt, new CoverArtLoadListener(viewholder));
            com.xfinity.playerlib.model.dibic.DibicProgram dibicprogram = dibicResource.getProgramByMerlinId(((VideoFavorite)favorite).getMerlinId());
            flag = videoEntitlement.isEntitled(dibicprogram);
        } else
        {
            int i = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.cover_art_src_width);
            int j = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.cover_art_src_height);
            Object obj = HalLiveStream.getArtworkUrl(((LiveStreamFavorite)favorite).getArtworkUrl(), i, j);
            coverArtImageLoader.loadImage(((String) (obj)), viewholder.coverArt, new CoverArtLoadListener(viewholder));
            obj = liveStreamResource.getLiveStream(((LiveStreamFavorite)favorite).getStreamId());
            if (obj != null)
            {
                obj = ((HalLiveStream) (obj)).getProviderCodes();
                flag = videoEntitlement.isEntitledToList((String[])((List) (obj)).toArray(new String[((List) (obj)).size()]));
            }
        }
        if (flag)
        {
            viewholder.lockedIndicator.setVisibility(4);
        } else
        {
            viewholder.lockedIndicator.setVisibility(0);
        }
        if (isTablet)
        {
            viewholder.container.setContentDescription(favorite.getTitle());
        }
    }

    protected volatile void bindItem(Object obj, Object obj1)
    {
        bindItem((ViewHolder)obj, (Favorite)obj1);
    }

    protected ViewHolder createViewHolder()
    {
        return new ViewHolder();
    }

    protected volatile Object createViewHolder()
    {
        return createViewHolder();
    }

    public int getCount()
    {
        return bookmarks.size();
    }

    public List getData()
    {
        return bookmarks;
    }

    public Favorite getItem(int i)
    {
        return (Favorite)bookmarks.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    protected int getViewLayoutId()
    {
        if (isInBabyGuide)
        {
            return com.xfinity.playerlib.R.layout.bookmarks_item_babyguide;
        } else
        {
            return com.xfinity.playerlib.R.layout.bookmarks_item;
        }
    }

    protected void initializeViewHolder(View view, ViewGroup viewgroup, ViewHolder viewholder)
    {
        viewholder.layout = view;
        viewholder.coverArt = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
        viewholder.title = (TextView)view.findViewById(com.xfinity.playerlib.R.id.favorite_title);
        viewholder.lockedIndicator = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.locked_indicator);
        viewholder.container = view.findViewById(com.xfinity.playerlib.R.id.favorite_container);
        boolean flag;
        if (viewholder.container != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isTablet = flag;
    }

    protected volatile void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
    {
        initializeViewHolder(view, viewgroup, (ViewHolder)obj);
    }

    public void removeItems(List list)
    {
        bookmarks.removeAll(list);
        notifyDataSetChanged();
    }

    public void setData(List list)
    {
        bookmarks = list;
    }

    public void setDibicResource(DibicResource dibicresource)
    {
        dibicResource = dibicresource;
    }

    public void setLiveStreamResource(HalLiveStreamResource hallivestreamresource)
    {
        liveStreamResource = hallivestreamresource;
    }

    public void setVideoEntitlement(VideoEntitlement videoentitlement)
    {
        videoEntitlement = videoentitlement;
    }


}
