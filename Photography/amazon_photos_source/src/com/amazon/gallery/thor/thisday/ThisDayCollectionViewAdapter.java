// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.accessibility.utils.ContentDescriptionHelper;
import com.amazon.gallery.framework.gallery.view.overlay.VideoOverlayHelper;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.ThisDayYearInfo;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.thor.widget.CollageLayout;
import com.amazon.gallery.thor.widget.MediaItemImageView;
import com.amazon.gallery.thor.widget.TextOverlayImageView;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            CollageLayoutMeasureUtils, ThisDayViewCollection, ThisDayUtils, ThisDayViewRouter

public class ThisDayCollectionViewAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class CollageImageSizeOverrider extends ItemViewFactory
    {

        private final CollageLayoutMeasureUtils collageLayoutMeasureUtils;
        private final int numTotalItems;

        public volatile void overrideSizeToGlideBuilder(int i, Persistable persistable, GenericRequestBuilder genericrequestbuilder)
        {
            overrideSizeToGlideBuilder(i, (MediaItem)persistable, genericrequestbuilder);
        }

        public void overrideSizeToGlideBuilder(int i, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
        {
            mediaitem = collageLayoutMeasureUtils.getBoundingBoxForCollageImage(numTotalItems, i);
            genericrequestbuilder.override(((CollageLayoutMeasureUtils.IntTuple) (mediaitem)).first, ((CollageLayoutMeasureUtils.IntTuple) (mediaitem)).second);
        }

        public CollageImageSizeOverrider(int i, CollageLayoutMeasureUtils collagelayoutmeasureutils)
        {
            super(null);
            numTotalItems = i;
            collageLayoutMeasureUtils = collagelayoutmeasureutils;
        }
    }

    static final class ThisDayCollectionViewHolder extends ItemViewHolder
        implements RequestListener
    {

        MediaItemImageView cachedImageViews[];
        private int numImagesLoaded;
        private final int numImagesToLoad;
        View parentView;
        TextView title;

        public boolean isLoading()
        {
            return isLoading;
        }

        public volatile boolean onException(Exception exception, Persistable persistable, Target target, boolean flag)
        {
            return onException(exception, (MediaItem)persistable, target, flag);
        }

        public boolean onException(Exception exception, MediaItem mediaitem, Target target, boolean flag)
        {
            numImagesLoaded = numImagesLoaded + 1;
            if (numImagesLoaded == numImagesToLoad)
            {
                isLoading = false;
            }
            return false;
        }

        public volatile boolean onException(Exception exception, Object obj, Target target, boolean flag)
        {
            return onException(exception, (MediaItem)obj, target, flag);
        }

        public volatile boolean onResourceReady(Bitmap bitmap, Persistable persistable, Target target, boolean flag, boolean flag1)
        {
            return onResourceReady(bitmap, (MediaItem)persistable, target, flag, flag1);
        }

        public boolean onResourceReady(Bitmap bitmap, MediaItem mediaitem, Target target, boolean flag, boolean flag1)
        {
            numImagesLoaded = numImagesLoaded + 1;
            if (numImagesLoaded == numImagesToLoad)
            {
                isLoading = false;
            }
            return false;
        }

        public volatile boolean onResourceReady(Object obj, Object obj1, Target target, boolean flag, boolean flag1)
        {
            return onResourceReady((Bitmap)obj, (MediaItem)obj1, target, flag, flag1);
        }

        public void resetLoading()
        {
            isLoading = true;
            numImagesLoaded = 0;
        }

        ThisDayCollectionViewHolder(View view, MediaItemImageView amediaitemimageview[])
        {
            super(null, view);
            parentView = view;
            cachedImageViews = amediaitemimageview;
            numImagesToLoad = cachedImageViews.length;
            title = (TextView)view.findViewById(0x7f0c01f5);
        }
    }


    private int boundingParentHeight;
    private int boundingParentWidth;
    private final int collageItemMargin;
    private final int collageItemOverlayTextColor;
    private final int collageItemOverlayTextSize;
    private final CollageLayoutMeasureUtils collageLayoutMeasureUtils = new CollageLayoutMeasureUtils();
    private final double largestCollageChildWidthRatio;
    private GridStatus loadingStatusTracker;
    private final ColorFilter overlayFilter;
    private final ThisDayViewRouter router;
    private ThisDayViewCollection thisDayCollectionData;
    private final int titleViewHeight;
    private int videoItemBannerHeight;
    private int videoItemIconSize;
    private int videoItemTextSize;
    private int videoOverlayItemPadding;

    public ThisDayCollectionViewAdapter(Activity activity, ThisDayViewRouter thisdayviewrouter)
    {
        collageItemMargin = activity.getResources().getDimensionPixelSize(0x7f0a01c6);
        titleViewHeight = activity.getResources().getDimensionPixelSize(0x7f0a01ca);
        int i = activity.getResources().getInteger(0x7f0d0001);
        largestCollageChildWidthRatio = (float)(i - activity.getResources().getInteger(0x7f0d0004)) / (1.0F * (float)i);
        collageItemOverlayTextColor = activity.getResources().getColor(0x106000b);
        collageItemOverlayTextSize = activity.getResources().getDimensionPixelSize(0x7f0a01c9);
        videoItemTextSize = activity.getResources().getDimensionPixelSize(0x7f0a01ed);
        overlayFilter = new PorterDuffColorFilter(activity.getResources().getColor(0x7f0900d4), android.graphics.PorterDuff.Mode.SRC_ATOP);
        router = thisdayviewrouter;
    }

    private void addImageViewToCollageLayout(CollageLayout collagelayout, ImageView imageview, int i, byte byte0)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = new android.view.ViewGroup.MarginLayoutParams(-1, -1);
        marginlayoutparams.setMargins((byte0 >> 3 & 1) * i, (byte0 >> 2 & 1) * i, (byte0 >> 1 & 1) * i, (byte0 & 1) * i);
        imageview.setLayoutParams(marginlayoutparams);
        imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        collagelayout.addView(imageview);
    }

    private void bindVideoMetadataIfNecessary(MediaItemImageView mediaitemimageview, String s)
    {
        mediaitemimageview.setText(s);
    }

    private void bindViewToRouterForGalleryViewNavigation(View view, final int year)
    {
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final ThisDayCollectionViewAdapter this$0;
            final int val$year;

            public void onClick(View view1)
            {
                router.onTitleClicked(year);
            }

            
            {
                this$0 = ThisDayCollectionViewAdapter.this;
                year = i;
                super();
            }
        });
    }

    private void bindViewToRouterForSingleViewNavigation(View view, final int year, final int position)
    {
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final ThisDayCollectionViewAdapter this$0;
            final int val$position;
            final int val$year;

            public void onClick(View view1)
            {
                router.onPhotoClicked(year, position);
            }

            
            {
                this$0 = ThisDayCollectionViewAdapter.this;
                year = i;
                position = j;
                super();
            }
        });
    }

    private void correctParentSizeIfNeeded(View view)
    {
        if (view.getWidth() != boundingParentWidth || view.getHeight() != boundingParentHeight)
        {
            view.getLayoutParams().width = boundingParentWidth;
            view.getLayoutParams().height = boundingParentHeight;
        }
    }

    private void loadImages(ThisDayCollectionViewHolder thisdaycollectionviewholder, ThisDayYearInfo thisdayyearinfo)
    {
        MediaItemImageView amediaitemimageview[] = thisdaycollectionviewholder.cachedImageViews;
        int j = amediaitemimageview.length;
        int k = thisdayyearinfo.getNumTotalMediaItems() - j;
        ColorFilter colorfilter = null;
        String s1 = "";
        String s = "";
        CollageImageSizeOverrider collageimagesizeoverrider = new CollageImageSizeOverrider(j, collageLayoutMeasureUtils);
        int i;
        for (i = 0; i < j - 1; i++)
        {
            MediaItem mediaitem = (MediaItem)thisdayyearinfo.getMediaItems().get(i);
            if (mediaitem.getType() == MediaType.VIDEO)
            {
                s = VideoOverlayHelper.formatVideoDurationString(mediaitem);
            }
            bindVideoMetadataIfNecessary(amediaitemimageview[i], s);
            GlideWrapper.loadImage(mediaitem, amediaitemimageview[i], thisdaycollectionviewholder, null, false, i, collageimagesizeoverrider);
            bindViewToRouterForSingleViewNavigation(amediaitemimageview[i], thisdayyearinfo.getYear(), i);
            amediaitemimageview[i].setContentDescription(ContentDescriptionHelper.getContentDescription(mediaitem));
        }

        MediaItem mediaitem1 = (MediaItem)thisdayyearinfo.getMediaItems().get(i);
        if (k > 0)
        {
            colorfilter = overlayFilter;
            s1 = (new StringBuilder()).append("+").append(k + 1).toString();
            bindViewToRouterForGalleryViewNavigation(amediaitemimageview[i], thisdayyearinfo.getYear());
            amediaitemimageview[i].setContentDescription(amediaitemimageview[i].getContext().getString(0x7f0e020c, new Object[] {
                Integer.valueOf(k + 1)
            }));
            thisdayyearinfo = colorfilter;
        } else
        {
            bindViewToRouterForSingleViewNavigation(amediaitemimageview[i], thisdayyearinfo.getYear(), i);
            amediaitemimageview[i].setContentDescription(ContentDescriptionHelper.getContentDescription(mediaitem1));
            thisdayyearinfo = colorfilter;
        }
        amediaitemimageview[i].setColorFilter(thisdayyearinfo);
        ((TextOverlayImageView)amediaitemimageview[i]).setOverlayText(s1);
        if (mediaitem1.getType() == MediaType.VIDEO)
        {
            s = VideoOverlayHelper.formatVideoDurationString(mediaitem1);
        }
        bindVideoMetadataIfNecessary(amediaitemimageview[i], s);
        GlideWrapper.loadImage(mediaitem1, amediaitemimageview[i], thisdaycollectionviewholder, null, false, i, collageimagesizeoverrider);
    }

    private void setVideoOverlayDimensions(MediaItemImageView mediaitemimageview, int i, int j)
    {
        CollageLayoutMeasureUtils.IntTuple inttuple = collageLayoutMeasureUtils.getBoundingBoxForCollageImage(i, j);
        videoItemBannerHeight = inttuple.second / 6;
        videoOverlayItemPadding = inttuple.second / 30;
        videoItemIconSize = videoItemBannerHeight - videoOverlayItemPadding * 2;
        mediaitemimageview.setTextSizeInPixels(videoItemTextSize);
        mediaitemimageview.setBannerHeightInPixels(videoItemBannerHeight);
        mediaitemimageview.setIconSizeInPixels(videoItemIconSize);
        mediaitemimageview.setIconPaddingInPixels(videoOverlayItemPadding);
        mediaitemimageview.setTextPaddingInPixels(videoOverlayItemPadding);
    }

    public int getItemCount()
    {
        if (thisDayCollectionData != null)
        {
            return thisDayCollectionData.yearInfoList.size();
        } else
        {
            return 0;
        }
    }

    public long getItemId(int i)
    {
        return (long)((ThisDayYearInfo)thisDayCollectionData.yearInfoList.get(i)).getYear();
    }

    public int getItemViewType(int i)
    {
        return ((ThisDayYearInfo)thisDayCollectionData.yearInfoList.get(i)).getMediaItems().size();
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((ThisDayCollectionViewHolder)viewholder, i);
    }

    public void onBindViewHolder(ThisDayCollectionViewHolder thisdaycollectionviewholder, int i)
    {
        correctParentSizeIfNeeded(thisdaycollectionviewholder.parentView);
        ThisDayYearInfo thisdayyearinfo = (ThisDayYearInfo)thisDayCollectionData.yearInfoList.get(i);
        thisdaycollectionviewholder.title.setText(ThisDayUtils.getTitleForThisDayCard(thisdaycollectionviewholder.parentView.getContext(), thisdayyearinfo.getYear()));
        bindViewToRouterForGalleryViewNavigation(thisdaycollectionviewholder.title, thisdayyearinfo.getYear());
        loadingStatusTracker.onVisible(thisdaycollectionviewholder);
        loadImages(thisdaycollectionviewholder, thisdayyearinfo);
    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public ThisDayCollectionViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300e5, viewgroup, false);
        CollageLayout collagelayout = (CollageLayout)viewgroup.findViewById(0x7f0c01f4);
        collagelayout.setLargestChildSpaceRatio(largestCollageChildWidthRatio);
        MediaItemImageView amediaitemimageview[] = new MediaItemImageView[i];
        for (int j = 0; j < i - 1; j++)
        {
            MediaItemImageView mediaitemimageview = new MediaItemImageView(collagelayout.getContext());
            setVideoOverlayDimensions(mediaitemimageview, i, j);
            byte byte0 = collageLayoutMeasureUtils.getMarginsBitmaskForCollageItem(i, j, collagelayout.hasReverseLayoutDirection());
            addImageViewToCollageLayout(collagelayout, mediaitemimageview, collageItemMargin, byte0);
            amediaitemimageview[j] = mediaitemimageview;
        }

        TextOverlayImageView textoverlayimageview = new TextOverlayImageView(collagelayout.getContext());
        setVideoOverlayDimensions(textoverlayimageview, i, i - 1);
        textoverlayimageview.setTextColor(collageItemOverlayTextColor);
        textoverlayimageview.setOverlayTextSizeInPixels(collageItemOverlayTextSize);
        byte byte1 = collageLayoutMeasureUtils.getMarginsBitmaskForCollageItem(i, i - 1, collagelayout.hasReverseLayoutDirection());
        addImageViewToCollageLayout(collagelayout, textoverlayimageview, collageItemMargin, byte1);
        amediaitemimageview[i - 1] = textoverlayimageview;
        return new ThisDayCollectionViewHolder(viewgroup, amediaitemimageview);
    }

    public volatile void onViewRecycled(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        onViewRecycled((ThisDayCollectionViewHolder)viewholder);
    }

    public void onViewRecycled(ThisDayCollectionViewHolder thisdaycollectionviewholder)
    {
        super.onViewRecycled(thisdaycollectionviewholder);
        if (thisdaycollectionviewholder != null)
        {
            loadingStatusTracker.onHidden(thisdaycollectionviewholder);
            thisdaycollectionviewholder.resetLoading();
            for (int i = 0; i < thisdaycollectionviewholder.cachedImageViews.length; i++)
            {
                GlideWrapper.cancelLoadImage(thisdaycollectionviewholder.cachedImageViews[i]);
            }

        }
    }

    public void setBoundingSizeForViews(int i, int j)
    {
        if (j <= 0 || i <= 0)
        {
            throw new IllegalArgumentException("Bounding width and height should be positive");
        } else
        {
            boundingParentWidth = i;
            boundingParentHeight = j;
            collageLayoutMeasureUtils.initializeDimensCache(i, j - titleViewHeight, (float)largestCollageChildWidthRatio);
            return;
        }
    }

    public void setLoadingStatusTracker(GridStatus gridstatus)
    {
        loadingStatusTracker = gridstatus;
    }

    public void setThisDayCollectionData(ThisDayViewCollection thisdayviewcollection)
    {
        thisDayCollectionData = thisdayviewcollection;
        notifyDataSetChanged();
    }

}
