// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.content.res.Configuration;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.BrowseModel;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.QueueItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import java.util.ArrayList;
import java.util.List;

public class BrowseGridAdapter extends BaseAdapter
{

    private static final int MAX_ITEMS = 6;
    private static final String VIEW = "view_";
    private Context mContext;
    private ImageLoader mImageLoader;
    public DisplayImageOptions mImageOptions;
    private boolean mIsRecommendedWatchlist;
    private List mItems;
    private int mNumOfItems;
    private android.view.View.OnClickListener mOnClickListener;
    private MediaDetailsItem mResumeItem;
    private com.gotv.crackle.base.BaseActivity.AppSection mSection;

    public BrowseGridAdapter(Context context, List list, android.view.View.OnClickListener onclicklistener, com.gotv.crackle.base.BaseActivity.AppSection appsection, MediaDetailsItem mediadetailsitem)
    {
        mImageLoader = ImageLoader.getInstance();
        mImageOptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).build();
        mIsRecommendedWatchlist = false;
        mOnClickListener = onclicklistener;
        mSection = appsection;
        mContext = context;
        mItems = new ArrayList(list);
        mResumeItem = mediadetailsitem;
        if (Application.getInstance().isTabletSizedScreen() && context.getResources().getConfiguration().orientation == 2)
        {
            mNumOfItems = 6;
            return;
        }
        if (Application.getInstance().isTabletSizedScreen() && context.getResources().getConfiguration().orientation == 1)
        {
            mNumOfItems = 4;
            return;
        }
        if (!Application.getInstance().isTabletSizedScreen() && context.getResources().getConfiguration().orientation == 2)
        {
            mNumOfItems = 5;
            return;
        } else
        {
            mNumOfItems = 3;
            return;
        }
    }

    public int getCount()
    {
        int j = mItems.size();
        int i = j;
        if (mResumeItem != null)
        {
            i = j + 1;
        }
        int k = i / mNumOfItems;
        j = k;
        if (i % mNumOfItems != 0)
        {
            j = k + 1;
        }
        return j;
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
        TextView textview;
        TextView textview1;
        TextView textview2;
        LinearLayout linearlayout;
        LinearLayout linearlayout1;
        int j;
        linearlayout1 = null;
        textview = null;
        linearlayout = null;
        textview1 = null;
        textview2 = null;
        viewgroup = view;
        if (view == null)
        {
            viewgroup = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f030077, null);
        }
        j = 0;
_L17:
        Object obj;
        final ImageButton mainButton;
        TextView textview3;
        LinearLayout linearlayout2;
        ProgressBar progressbar;
        TextView textview4;
        final ImageView imageThumbnail;
        if (j >= mNumOfItems)
        {
            break MISSING_BLOCK_LABEL_1117;
        }
        view = viewgroup.findViewById(mContext.getResources().getIdentifier((new StringBuilder()).append("view_").append(j).toString(), "id", mContext.getPackageName()));
        mainButton = (ImageButton)view.findViewById(0x7f0a0077);
        mainButton.setOnClickListener(null);
        textview3 = (TextView)view.findViewById(0x7f0a015c);
        linearlayout2 = (LinearLayout)view.findViewById(0x7f0a015b);
        linearlayout2.setVisibility(4);
        progressbar = (ProgressBar)view.findViewById(0x7f0a00ee);
        textview4 = (TextView)view.findViewById(0x7f0a0078);
        imageThumbnail = (ImageView)view.findViewById(0x7f0a0191);
        imageThumbnail.setImageBitmap(null);
        int k;
        if (mIsRecommendedWatchlist)
        {
            linearlayout1 = (LinearLayout)view.findViewById(0x7f0a0192);
            textview = (TextView)view.findViewById(0x7f0a0193);
        } else
        {
            linearlayout = (LinearLayout)view.findViewById(0x7f0a0194);
            textview1 = (TextView)view.findViewById(0x7f0a0195);
            textview2 = (TextView)view.findViewById(0x7f0a0196);
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        k = j;
        if (mResumeItem != null)
        {
            k = j - 1;
        }
        if (k < 0) goto _L4; else goto _L3
_L3:
        obj = (BrowseModel)mItems.get(k);
        view = ((View) (obj));
        if (mSection != com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        view = ((View) (obj));
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        view = ((View) (obj));
        if (!mIsRecommendedWatchlist)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        linearlayout1.setVisibility(0);
        view = ((View) (obj));
        if (!Application.getInstance().isTablet())
        {
            break MISSING_BLOCK_LABEL_334;
        }
        linearlayout1.setPadding(Application.dpToPx(5), Application.dpToPx(10), Application.dpToPx(5), Application.dpToPx(10));
        textview.setTextSize(1, 17F);
        view = ((View) (obj));
_L11:
        if (mSection != com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS || mIsRecommendedWatchlist || !Application.getInstance().isTablet()) goto _L6; else goto _L5
_L5:
        obj = (QueueItem)view;
        linearlayout.setVisibility(0);
        if (!((QueueItem) (obj)).getItemType().equalsIgnoreCase("Channel") || !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("46") && !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("114")) goto _L8; else goto _L7
_L7:
        textview1.setText(mContext.getResources().getString(0x7f0b00ae));
        textview2.setText("");
_L6:
        if (!view.getID().equalsIgnoreCase(mContext.getString(0x7f0b00d8)) && !view.getID().equalsIgnoreCase(mContext.getString(0x7f0b00d9))) goto _L10; else goto _L9
_L9:
        imageThumbnail.setImageResource(0x7f020061);
        mainButton.setOnClickListener(mOnClickListener);
        textview4.setVisibility(0);
        textview4.setText(view.getID());
        mainButton.setTag(view);
_L15:
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        view = (BrowseModel)mItems.get(0);
          goto _L11
_L2:
        int l = j;
        if (mResumeItem != null)
        {
            l = j - 1;
        }
        obj = (BrowseModel)mItems.get(mNumOfItems * i + l);
        view = ((View) (obj));
        if (mSection != com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS) goto _L11; else goto _L12
_L12:
        view = ((View) (obj));
        if (!mIsRecommendedWatchlist) goto _L11; else goto _L13
_L13:
        linearlayout1.setVisibility(4);
        view = ((View) (obj));
          goto _L11
_L8:
        if (!((QueueItem) (obj)).getItemType().equalsIgnoreCase("Media") || !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("46") && !((QueueItem) (obj)).getRootChannelID().equalsIgnoreCase("114"))
        {
            break MISSING_BLOCK_LABEL_846;
        }
        if (((QueueItem) (obj)).getSeason() != null && !((QueueItem) (obj)).getSeason().equalsIgnoreCase("") && ((QueueItem) (obj)).getEpisode() != null && !((QueueItem) (obj)).getEpisode().equalsIgnoreCase(""))
        {
            break MISSING_BLOCK_LABEL_800;
        }
        textview1.setText("");
        textview1.setVisibility(8);
_L14:
        String s = ((QueueItem) (obj)).getTitle();
        obj = s;
        if (s.contains(":"))
        {
            obj = s.split(":")[1].trim();
        }
        textview2.setText(((CharSequence) (obj)));
          goto _L6
        textview1.setText((new StringBuilder()).append("S").append(((QueueItem) (obj)).getSeason()).append(" E").append(((QueueItem) (obj)).getEpisode()).toString());
          goto _L14
        textview1.setText("");
        textview2.setText("");
          goto _L6
_L10:
        if (j != 0 || i != 0)
        {
            break MISSING_BLOCK_LABEL_1028;
        }
        if (mResumeItem == null)
        {
            break MISSING_BLOCK_LABEL_1028;
        }
        textview4.setVisibility(8);
        mainButton.setTag(mResumeItem);
        final boolean shouldAnimate;
        if (MemoryCacheUtil.findCachedBitmapsForImageUri(view.getImageUrl(), ImageLoader.getInstance().getMemoryCache()).size() == 0)
        {
            shouldAnimate = true;
        } else
        {
            shouldAnimate = false;
        }
        mImageLoader.displayImage(mResumeItem.getThumbnailOneSheet185x277(), imageThumbnail, mImageOptions, new SimpleImageLoadingListener() {

            final BrowseGridAdapter this$0;
            final ImageView val$imageThumbnail;
            final ImageButton val$mainButton;
            final boolean val$shouldAnimate;

            public void onLoadingComplete(String s1, View view1, Bitmap bitmap)
            {
                if (shouldAnimate)
                {
                    imageThumbnail.startAnimation(AnimationUtils.loadAnimation(mContext, 0x10a0000));
                }
                mainButton.setOnClickListener(mOnClickListener);
            }

            
            {
                this$0 = BrowseGridAdapter.this;
                shouldAnimate = flag;
                imageThumbnail = imageview;
                mainButton = imagebutton;
                super();
            }
        });
        textview3.setVisibility(0);
        linearlayout2.setVisibility(0);
        linearlayout2.setTag(mResumeItem);
        l = SharedPrefsManager.getPlayProgressForItem(mResumeItem.getID());
        if (l > 0)
        {
            try
            {
                progressbar.setProgress((int)Math.round(((double)l / (double)(Integer.parseInt(mResumeItem.getDurationInSeconds()) * 1000)) * 100D));
            }
            // Misplaced declaration of an exception variable
            catch (View view) { }
        }
          goto _L15
        textview4.setVisibility(8);
        mainButton.setTag(view);
        if (MemoryCacheUtil.findCachedBitmapsForImageUri(view.getImageUrl(), ImageLoader.getInstance().getMemoryCache()).size() == 0)
        {
            shouldAnimate = true;
        } else
        {
            shouldAnimate = false;
        }
        mImageLoader.displayImage(view.getImageUrl(), imageThumbnail, mImageOptions, new SimpleImageLoadingListener() {

            final BrowseGridAdapter this$0;
            final ImageView val$imageThumbnail;
            final ImageButton val$mainButton;
            final boolean val$shouldAnimate;

            public void onLoadingComplete(String s1, View view1, Bitmap bitmap)
            {
                if (shouldAnimate)
                {
                    imageThumbnail.startAnimation(AnimationUtils.loadAnimation(mContext, 0x10a0000));
                }
                mainButton.setOnClickListener(mOnClickListener);
            }

            
            {
                this$0 = BrowseGridAdapter.this;
                shouldAnimate = flag;
                imageThumbnail = imageview;
                mainButton = imagebutton;
                super();
            }
        });
        textview3.setVisibility(4);
        linearlayout2.setVisibility(4);
          goto _L15
        if (mNumOfItems < 6)
        {
            for (i = mNumOfItems; i < 6; i++)
            {
                view = viewgroup.findViewById(mContext.getResources().getIdentifier((new StringBuilder()).append("view_").append(i).toString(), "id", mContext.getPackageName()));
                ((ImageView)view.findViewById(0x7f0a0191)).setTag("null");
                view.setVisibility(8);
            }

        }
        return viewgroup;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public void setIsRecommendedWatchlist(boolean flag)
    {
        mIsRecommendedWatchlist = flag;
    }


}
