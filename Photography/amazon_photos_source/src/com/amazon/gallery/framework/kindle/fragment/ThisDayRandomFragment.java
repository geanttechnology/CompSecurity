// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.accessibility.utils.ContentDescriptionHelper;
import com.amazon.gallery.framework.gallery.view.overlay.VideoOverlayHelper;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.gallery.widget.holder.LoadingHolderInterface;
import com.amazon.gallery.framework.glide.GlideWrapper;
import com.amazon.gallery.framework.kindle.activity.SingleViewActivity;
import com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider;
import com.amazon.gallery.framework.model.ThisDayYearInfo;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.thor.app.activity.ThisDayActivity;
import com.amazon.gallery.thor.thisday.CollageLayoutMeasureUtils;
import com.amazon.gallery.thor.thisday.ThisDayMetricsHelper;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import com.amazon.gallery.thor.widget.BanneredImageView;
import com.amazon.gallery.thor.widget.CollageLayout;
import com.amazon.gallery.thor.widget.MediaItemImageView;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ThisDayFragment

public class ThisDayRandomFragment extends ThisDayFragment
{
    private static class ImageLoadStatusTracker
        implements LoadingHolderInterface, RequestListener
    {

        private GridStatus gridStatus;

        public boolean isLoading()
        {
            return true;
        }

        public boolean onException(Exception exception, MediaItem mediaitem, Target target, boolean flag)
        {
            gridStatus.onHidden(this);
            return false;
        }

        public volatile boolean onException(Exception exception, Object obj, Target target, boolean flag)
        {
            return onException(exception, (MediaItem)obj, target, flag);
        }

        public boolean onResourceReady(Bitmap bitmap, MediaItem mediaitem, Target target, boolean flag, boolean flag1)
        {
            gridStatus.onHidden(this);
            return false;
        }

        public volatile boolean onResourceReady(Object obj, Object obj1, Target target, boolean flag, boolean flag1)
        {
            return onResourceReady((Bitmap)obj, (MediaItem)obj1, target, flag, flag1);
        }

        public ImageLoadStatusTracker(GridStatus gridstatus)
        {
            gridStatus = gridstatus;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/fragment/ThisDayRandomFragment.getName();
    private View collageContainer;
    private int collageItemMargin;
    private CollageLayoutMeasureUtils collageLayoutMeasureUtils;
    private CollageLayout firstCollageLayout;
    private LinearLayout footerMsgContainer;
    private double largestCollageChildWidthRatio;
    private View loadingView;
    private int maxCoverPhotos;
    private LinearLayout photosContainer;
    private CollageLayout secondCollageLayout;
    private SwipeRefreshLayout swipeToRefreshLayout;
    private int videoItemTextSize;
    private int yearBannerMargin;
    private int yearBannerTextSize;
    private int yearBannerWidth;

    public ThisDayRandomFragment()
    {
    }

    private void addImageViewAndBindData(CollageLayout collagelayout, BanneredImageView banneredimageview, final MediaItem mediaItem, final int itemCreationYear, int i, int j, byte byte0, 
            com.amazon.gallery.thor.thisday.ThisDayCollectionViewAdapter.CollageImageSizeOverrider collageimagesizeoverrider)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = new android.view.ViewGroup.MarginLayoutParams(-1, -1);
        marginlayoutparams.setMargins((byte0 >> 3 & 1) * j, (byte0 >> 2 & 1) * j, (byte0 >> 1 & 1) * j, (byte0 & 1) * j);
        banneredimageview.setLayoutParams(marginlayoutparams);
        banneredimageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        banneredimageview.setContentDescription(ContentDescriptionHelper.getContentDescription(mediaItem));
        banneredimageview.setOnClickListener(new android.view.View.OnClickListener() {

            final ThisDayRandomFragment this$0;
            final int val$itemCreationYear;
            final MediaItem val$mediaItem;

            public void onClick(View view)
            {
                view = (ThisDayActivity)getActivity();
                Intent intent = new Intent(view, com/amazon/gallery/framework/kindle/activity/SingleViewActivity);
                intent.setData(GalleryInternalContentProvider.createMediaItemUri(mediaItem.getId()));
                intent.putExtra("thisDayYear", itemCreationYear);
                intent.putExtra("shuffleData", true);
                intent.putExtra("thisDayItemDate", mediaItem.getDateCreatedMs());
                view.startActivity(intent);
                view.getMetricsHelper().onOpenShuffleSingleView();
            }

            
            {
                this$0 = ThisDayRandomFragment.this;
                mediaItem = mediaitem;
                itemCreationYear = i;
                super();
            }
        });
        collagelayout.addView(banneredimageview);
        if (mediaItem.getType() == MediaType.VIDEO)
        {
            banneredimageview.setText(VideoOverlayHelper.formatVideoDurationString(mediaItem));
        }
        collagelayout = new ImageLoadStatusTracker(gridStatus);
        gridStatus.onVisible(collagelayout);
        GlideWrapper.loadImage(mediaItem, banneredimageview, collagelayout, null, false, i, collageimagesizeoverrider);
    }

    private void bindDataToCollage(CollageLayout collagelayout, ThisDayViewCollection thisdayviewcollection, int i, int j)
    {
        com.amazon.gallery.thor.thisday.ThisDayCollectionViewAdapter.CollageImageSizeOverrider collageimagesizeoverrider = new com.amazon.gallery.thor.thisday.ThisDayCollectionViewAdapter.CollageImageSizeOverrider(i, collageLayoutMeasureUtils);
        int k = 0;
        while (k < i) 
        {
            BanneredImageView banneredimageview = new BanneredImageView(collagelayout.getContext());
            setVideoOverlayDimensions(banneredimageview, i, k);
            int l = ((ThisDayYearInfo)thisdayviewcollection.yearInfoList.get(k + j)).getYear();
            byte byte0 = collageLayoutMeasureUtils.getMarginsBitmaskForCollageItem(i, k, collagelayout.hasReverseLayoutDirection());
            MediaItem mediaitem = (MediaItem)((ThisDayYearInfo)thisdayviewcollection.yearInfoList.get(k + j)).getMediaItems().get(0);
            if (mediaitem.getDateCreatedUTCMs() != 0L)
            {
                setYearBannerAttributes(banneredimageview, l);
                banneredimageview.setBannerVisible(true);
            } else
            {
                banneredimageview.setBannerVisible(false);
            }
            addImageViewAndBindData(collagelayout, banneredimageview, mediaitem, l, k, collageItemMargin, byte0, collageimagesizeoverrider);
            k++;
        }
    }

    private void initDimensions()
    {
        Resources resources = getActivity().getResources();
        collageItemMargin = resources.getDimensionPixelSize(0x7f0a01c6);
        videoItemTextSize = resources.getDimensionPixelSize(0x7f0a01ed);
        yearBannerWidth = resources.getDimensionPixelSize(0x7f0a01d9);
        yearBannerMargin = resources.getDimensionPixelSize(0x7f0a01d7);
        yearBannerTextSize = resources.getDimensionPixelSize(0x7f0a01d8);
        int i = getActivity().getResources().getInteger(0x7f0d0001);
        largestCollageChildWidthRatio = (float)(i - getActivity().getResources().getInteger(0x7f0d0004)) / (1.0F * (float)i);
    }

    private void setBoundingSizeForCollage(CollageLayout collagelayout)
    {
        collagelayout.getLayoutParams().width = boundingWidth;
        collagelayout.getLayoutParams().height = boundingHeight;
    }

    private void setVideoOverlayDimensions(MediaItemImageView mediaitemimageview, int i, int j)
    {
        i = collageLayoutMeasureUtils.getBoundingBoxForCollageImage(i, j).second / 6;
        j = i / 5;
        mediaitemimageview.setTextSizeInPixels(videoItemTextSize);
        mediaitemimageview.setBannerHeightInPixels(i);
        mediaitemimageview.setIconSizeInPixels(i - j * 2);
        mediaitemimageview.setIconPaddingInPixels(j);
        mediaitemimageview.setTextPaddingInPixels(j);
    }

    private void setYearBannerAttributes(BanneredImageView banneredimageview, int i)
    {
        banneredimageview.setBannerWidthInPixels(yearBannerWidth);
        banneredimageview.setBannerMarginInPixels(yearBannerMargin);
        banneredimageview.setBannerTextSizeInPixels(yearBannerTextSize);
        banneredimageview.setBannerText(String.valueOf(i));
    }

    public void displayData(ThisDayViewCollection thisdayviewcollection)
    {
        if (getView() == null)
        {
            GLogger.e(TAG, "Attempting to display data in a fragment whose views are not created yet", new Object[0]);
            return;
        }
        loadingView.setVisibility(8);
        photosContainer.setVisibility(0);
        footerMsgContainer.setVisibility(0);
        firstCollageLayout.removeAllViews();
        secondCollageLayout.removeAllViews();
        swipeToRefreshLayout.setRefreshing(false);
        int i = thisdayviewcollection.yearInfoList.size();
        if (i == 0)
        {
            collageContainer.setVisibility(8);
            return;
        }
        collageContainer.setVisibility(0);
        if (i <= maxCoverPhotos)
        {
            secondCollageLayout.setVisibility(8);
            setBoundingSizeForCollage(firstCollageLayout);
            bindDataToCollage(firstCollageLayout, thisdayviewcollection, i, 0);
            return;
        } else
        {
            setBoundingSizeForCollage(firstCollageLayout);
            bindDataToCollage(firstCollageLayout, thisdayviewcollection, maxCoverPhotos, 0);
            secondCollageLayout.setVisibility(0);
            setBoundingSizeForCollage(secondCollageLayout);
            bindDataToCollage(secondCollageLayout, thisdayviewcollection, i - maxCoverPhotos, maxCoverPhotos);
            return;
        }
    }

    public void displayEmptyState()
    {
        loadingView.setVisibility(8);
        photosContainer.setVisibility(0);
        collageContainer.setVisibility(8);
        footerMsgContainer.setVisibility(0);
        firstCollageLayout.removeAllViews();
        secondCollageLayout.removeAllViews();
        swipeToRefreshLayout.setRefreshing(false);
    }

    protected void init(Bundle bundle)
    {
        maxCoverPhotos = getActivity().getResources().getInteger(0x7f0d0005);
        collageLayoutMeasureUtils = new CollageLayoutMeasureUtils();
        initDimensions();
        initBoundingSizeForChildren();
    }

    protected void initBoundingSizeForChildren()
    {
        Resources resources = getResources();
        boundingWidth = resources.getDisplayMetrics().widthPixels;
        boundingHeight = Math.round((boundingWidth / resources.getInteger(0x7f0d0001)) * 2);
        collageLayoutMeasureUtils.initializeDimensCache(boundingWidth, boundingHeight, (float)largestCollageChildWidthRatio);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300e7, viewgroup, false);
    }

    protected void setupViews(View view, Bundle bundle)
    {
        photosContainer = (LinearLayout)view.findViewById(0x7f0c01f9);
        footerMsgContainer = (LinearLayout)view.findViewById(0x7f0c01fc);
        collageContainer = view.findViewById(0x7f0c01fa);
        loadingView = view.findViewById(0x7f0c01f0);
        ((TextView)view.findViewById(0x7f0c01f5)).setText(view.getContext().getResources().getString(0x7f0e0218));
        firstCollageLayout = (CollageLayout)view.findViewById(0x7f0c01f4);
        secondCollageLayout = (CollageLayout)view.findViewById(0x7f0c01fb);
        firstCollageLayout.setLargestChildSpaceRatio(largestCollageChildWidthRatio);
        secondCollageLayout.setLargestChildSpaceRatio(largestCollageChildWidthRatio);
        swipeToRefreshLayout = (SwipeRefreshLayout)view.findViewById(0x7f0c01f8);
        swipeToRefreshLayout.setColorSchemeResources(new int[] {
            0x7f090004
        });
        swipeToRefreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final ThisDayRandomFragment this$0;

            public void onRefresh()
            {
                ((ThisDayActivity)getActivity()).loadDataForCollection(2, true);
            }

            
            {
                this$0 = ThisDayRandomFragment.this;
                super();
            }
        });
        textInputLayout = (TextInputLayout)view.findViewById(0x7f0c01fd);
        emailInputField = (EditText)view.findViewById(0x7f0c01fe);
        emailButton = (AppCompatButton)view.findViewById(0x7f0c0163);
        TextInputLayout textinputlayout = (TextInputLayout)view.findViewById(0x7f0c01fd);
        EditText edittext = emailInputField;
        if (bundle != null)
        {
            view = bundle.getCharSequence("emailInputText");
        } else
        {
            view = null;
        }
        setupEmailWidgets(textinputlayout, edittext, view, emailButton);
    }

}
