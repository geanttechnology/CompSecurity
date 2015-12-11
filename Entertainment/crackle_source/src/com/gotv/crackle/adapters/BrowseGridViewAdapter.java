// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.model.QueueItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import java.util.ArrayList;
import java.util.List;

public class BrowseGridViewAdapter extends BaseAdapter
{

    private Context mContext;
    private ImageLoader mImageLoader;
    public DisplayImageOptions mImageOptions;
    private boolean mIsRecommendedWatchlist;
    private List mItems;
    private com.gotv.crackle.base.BaseActivity.AppSection mSection;

    public BrowseGridViewAdapter(Context context, List list, com.gotv.crackle.base.BaseActivity.AppSection appsection)
    {
        mImageLoader = ImageLoader.getInstance();
        mImageOptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).build();
        mIsRecommendedWatchlist = false;
        mSection = appsection;
        mContext = context;
        mItems = new ArrayList(list);
    }

    public int getCount()
    {
        return mItems.size();
    }

    public Object getItem(int i)
    {
        return mItems.get(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s;
        Object obj;
        Object obj1;
        final ImageView imageThumbnail;
        BrowseModel browsemodel;
        viewgroup = view;
        view = viewgroup;
        if (viewgroup == null)
        {
            view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f030078, null);
        }
        int j = Application.getDisplayIndependantPixelSize(10);
        view.setPadding(j, j, j, j);
        obj = null;
        TextView textview = null;
        LinearLayout linearlayout = null;
        s = null;
        viewgroup = null;
        obj1 = (ImageButton)view.findViewById(0x7f0a0077);
        ((ImageButton) (obj1)).setOnClickListener(null);
        ((ImageButton) (obj1)).setVisibility(8);
        ((LinearLayout)view.findViewById(0x7f0a015b)).setVisibility(4);
        obj1 = (TextView)view.findViewById(0x7f0a0078);
        imageThumbnail = (ImageView)view.findViewById(0x7f0a0191);
        imageThumbnail.setImageBitmap(null);
        if (mIsRecommendedWatchlist)
        {
            obj = (LinearLayout)view.findViewById(0x7f0a0192);
            textview = (TextView)view.findViewById(0x7f0a0193);
        } else
        {
            linearlayout = (LinearLayout)view.findViewById(0x7f0a0194);
            s = (TextView)view.findViewById(0x7f0a0195);
            viewgroup = (TextView)view.findViewById(0x7f0a0196);
        }
        browsemodel = (BrowseModel)mItems.get(i);
        if (mSection != com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS || i != 0)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        if (mIsRecommendedWatchlist)
        {
            ((LinearLayout) (obj)).setVisibility(0);
            if (Application.getInstance().isTablet())
            {
                ((LinearLayout) (obj)).setPadding(Application.dpToPx(5), Application.dpToPx(10), Application.dpToPx(5), Application.dpToPx(10));
                textview.setTextSize(1, 17F);
            }
        }
        if (mSection != com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS || mIsRecommendedWatchlist || !Application.getInstance().isTablet()) goto _L2; else goto _L1
_L1:
        obj = (QueueItem)browsemodel;
        linearlayout.setVisibility(0);
        if (!((QueueItem) (obj)).getItemType().equalsIgnoreCase("Channel") || !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("46") && !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("114")) goto _L4; else goto _L3
_L3:
        s.setText(mContext.getResources().getString(0x7f0b00ae));
        viewgroup.setText("");
_L2:
        if (!browsemodel.getID().equalsIgnoreCase(mContext.getString(0x7f0b00d8)) && !browsemodel.getID().equalsIgnoreCase(mContext.getString(0x7f0b00d9)))
        {
            break MISSING_BLOCK_LABEL_636;
        }
        imageThumbnail.setImageResource(0x7f020061);
        ((TextView) (obj1)).setVisibility(0);
        ((TextView) (obj1)).setText(browsemodel.getID());
        return view;
_L4:
        if (!((QueueItem) (obj)).getItemType().equalsIgnoreCase("Media") || !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("46") && !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("114"))
        {
            break MISSING_BLOCK_LABEL_620;
        }
        if (((QueueItem) (obj)).getSeason() != null && !((QueueItem) (obj)).getSeason().equalsIgnoreCase("") && ((QueueItem) (obj)).getEpisode() != null && !((QueueItem) (obj)).getEpisode().equalsIgnoreCase(""))
        {
            break MISSING_BLOCK_LABEL_576;
        }
        s.setText("");
        s.setVisibility(8);
_L5:
        String s1 = ((QueueItem) (obj)).getTitle();
        s = s1;
        final boolean shouldAnimate;
        try
        {
            if (s1.contains(":"))
            {
                s = s1.split(":")[1].trim();
            }
            viewgroup.setText(s);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return view;
        }
          goto _L2
        s.setText((new StringBuilder()).append("S").append(((QueueItem) (obj)).getSeason()).append(" E").append(((QueueItem) (obj)).getEpisode()).toString());
          goto _L5
        s.setText("");
        viewgroup.setText("");
          goto _L2
        ((TextView) (obj1)).setVisibility(8);
        if (MemoryCacheUtil.findCachedBitmapsForImageUri(browsemodel.getImageUrl(), ImageLoader.getInstance().getMemoryCache()).size() == 0)
        {
            shouldAnimate = true;
        } else
        {
            shouldAnimate = false;
        }
        mImageLoader.displayImage(browsemodel.getImageUrl(), imageThumbnail, mImageOptions, new SimpleImageLoadingListener() {

            final BrowseGridViewAdapter this$0;
            final ImageView val$imageThumbnail;
            final boolean val$shouldAnimate;

            public void onLoadingComplete(String s2, View view1, Bitmap bitmap)
            {
                if (shouldAnimate)
                {
                    imageThumbnail.startAnimation(AnimationUtils.loadAnimation(mContext, 0x10a0000));
                }
            }

            
            {
                this$0 = BrowseGridViewAdapter.this;
                shouldAnimate = flag;
                imageThumbnail = imageview;
                super();
            }
        });
        return view;
    }

    public void setIsRecommendedWatchlist(boolean flag)
    {
        mIsRecommendedWatchlist = flag;
    }

}
