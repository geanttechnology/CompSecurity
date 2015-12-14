// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.kindle.activity.BasicListActivity;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import com.amazon.gallery.thor.widget.RibbonMarkerView;
import com.bumptech.glide.GenericRequestBuilder;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ViewFactory, ItemViewFactory

public class ThisDayBannerViewFactory
    implements ViewFactory
{
    static class BannerImageSizeOverrider extends ItemViewFactory
    {

        private final int boundingHeight;
        private final int boundingWidth;

        public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
        {
            overrideSizeToGlideBuilder(i, (MediaItem)persistable, genericrequestbuilder);
        }

        public void overrideSizeToGlideBuilder(int i, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
        {
            genericrequestbuilder.override(boundingWidth, boundingHeight);
        }

        public BannerImageSizeOverrider(int i, int j)
        {
            super(null);
            boundingWidth = i;
            boundingHeight = j;
        }
    }

    static class ThisDayBannerViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        LinearLayout photosContainer;
        ProgressBar progressBar;
        RibbonMarkerView ribbonView;

        public ThisDayBannerViewHolder(View view)
        {
            super(view);
            photosContainer = (LinearLayout)view.findViewById(0x7f0c01f1);
            progressBar = (ProgressBar)view.findViewById(0x7f0c01f0);
            ribbonView = (RibbonMarkerView)view.findViewById(0x7f0c01f2);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/widget/ThisDayBannerViewFactory.getName();
    private static final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    private int bannerChildrenPadding;
    private int boundingHeight;
    private int boundingWidth;
    private Context context;

    public ThisDayBannerViewFactory()
    {
    }

    private void addImageViewToContainer(ViewGroup viewgroup, MediaItem mediaitem, String s, int i, int j, int k, int l, 
            int i1, int j1)
    {
        FrameLayout framelayout = new FrameLayout(context);
        Object obj = new android.widget.LinearLayout.LayoutParams(k, l);
        if (i == 0)
        {
            framelayout.setPadding(0, 0, i1, 0);
        } else
        if (i == j - 1)
        {
            framelayout.setPadding(i1, 0, 0, 0);
        } else
        {
            framelayout.setPadding(i1, 0, i1, 0);
        }
        framelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new ImageView(context);
        ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        framelayout.addView(((View) (obj)));
        if (s != null)
        {
            LayoutInflater.from(context).inflate(0x7f0300e4, framelayout);
            TextView textview = (TextView)framelayout.findViewById(0x7f0c01f3);
            textview.setPadding(j1, j1, 0, j1);
            textview.setText(s);
        }
        viewgroup.addView(framelayout);
        GlideWrapper.loadImage(mediaitem, ((ImageView) (obj)), null, null, false, 0, new BannerImageSizeOverrider(k, l));
    }

    public volatile View createView(Object obj)
    {
        return createView((List)obj);
    }

    public View createView(List list)
    {
        list = (ViewGroup)LayoutInflater.from(context).inflate(0x7f0300e3, null, false);
        list.setTag(new ThisDayBannerViewHolder(list));
        list.setTag(0x7f0c000e, GalleryBaseAdapter.ItemViewType.BANNER);
        return list;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (List)obj, view);
    }

    public View getView(int i, List list, View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = createView(list);
        }
        Object obj = (ThisDayBannerViewHolder)view1.getTag();
        FrameLayout framelayout = (FrameLayout)((ThisDayBannerViewHolder) (obj)).itemView;
        view = ((ThisDayBannerViewHolder) (obj)).photosContainer;
        ProgressBar progressbar = ((ThisDayBannerViewHolder) (obj)).progressBar;
        obj = ((ThisDayBannerViewHolder) (obj)).ribbonView;
        if (view.getWidth() != boundingWidth || view.getHeight() != boundingHeight)
        {
            view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, boundingHeight));
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(Math.round((float)boundingWidth / 2.75F), boundingHeight / 5);
            layoutparams.setMargins(0, boundingHeight / 10, 0, 0);
            ((RibbonMarkerView) (obj)).setLayoutParams(layoutparams);
        }
        if (list != null)
        {
            if (list.isEmpty())
            {
                framelayout.removeView(progressbar);
                framelayout.removeView(((View) (obj)));
                view.removeAllViews();
                view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(0, 0));
                (new ThisDaySharedPrefsManager(context)).setPrefetchedBannerData("");
                return view1;
            }
            framelayout.removeView(progressbar);
            view.removeAllViews();
            i = 0;
            int l = -1;
            int j1 = list.size();
            int k = 0;
            int k1 = bannerChildrenPadding * 5;
            int j = boundingWidth;
            int l1 = boundingHeight;
            if (j1 > 1)
            {
                j = boundingWidth / list.size();
                k = bannerChildrenPadding;
            }
            list = list.iterator();
            while (list.hasNext()) 
            {
                MediaItem mediaitem = (MediaItem)list.next();
                calendar.setTimeInMillis(mediaitem.getDateCreatedMs());
                int i1 = calendar.get(1);
                if (l != i1)
                {
                    l = i1;
                    addImageViewToContainer(view, mediaitem, String.valueOf(l), i, j1, j, l1, k, k1);
                    i++;
                } else
                {
                    addImageViewToContainer(view, mediaitem, null, i, j1, j, l1, k, k1);
                    i++;
                }
            }
        }
        return view1;
    }

    public void onViewDestroy(View view)
    {
        view = ((ThisDayBannerViewHolder)view.getTag()).photosContainer;
        for (int i = 0; i < view.getChildCount(); i++)
        {
            GlideWrapper.cancelLoadImage((ImageView)((FrameLayout)view.getChildAt(i)).getChildAt(0));
        }

    }

    public void reset()
    {
    }

    public void setBoundingSize(int i, int j)
    {
        boundingWidth = i;
        boundingHeight = j;
    }

    public void setContext(Context context1)
    {
        context = context1;
        setBoundingSize(BasicListActivity.calculateImageWidth(context1, 1, 0, 0), Math.round(1.25F * (float)BasicListActivity.calculateImageWidth(context1, context1.getResources().getInteger(0x7f0d0001), 0, context1.getResources().getDimensionPixelSize(0x7f0a003c))));
        bannerChildrenPadding = context1.getResources().getDimensionPixelSize(0x7f0a003c) / 2;
    }

}
