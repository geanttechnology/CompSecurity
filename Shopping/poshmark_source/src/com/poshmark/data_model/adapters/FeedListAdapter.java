// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.ListingStatusView;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMCovershotImageView;
import com.poshmark.ui.customviews.PMImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.SearchFilterTextView;
import com.poshmark.ui.fragments.CommentFragment;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.ui.fragments.ShareFragment;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.ListingUtils;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.TextFormatter;
import com.poshmark.utils.view_holders.ListingViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FeedListAdapter extends CursorAdapter
{

    android.view.View.OnClickListener commentButtonListener;
    Set imageList;
    private LayoutInflater inflater;
    android.view.View.OnClickListener likeButtonListener;
    android.view.View.OnClickListener shareButtonListener;
    TextFormatter textFormatter;
    android.view.View.OnClickListener viewDetailsListener;

    public FeedListAdapter(Context context, Fragment fragment, Cursor cursor, int i)
    {
        super(context, cursor, i);
        textFormatter = new TextFormatter();
        imageList = new HashSet();
        commentButtonListener = new android.view.View.OnClickListener() {

            final FeedListAdapter this$0;

            public void onClick(View view)
            {
                ListingSocial listingsocial = (ListingSocial)view.getTag();
                view = (PMActivity)view.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("ID", listingsocial.getIdAsString());
                view.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingsocial);
            }

            
            {
                this$0 = FeedListAdapter.this;
                super();
            }
        };
        likeButtonListener = new android.view.View.OnClickListener() {

            final FeedListAdapter this$0;

            public void onClick(View view)
            {
                ListingSocial listingsocial = (ListingSocial)view.getTag();
                boolean flag;
                if (!listingsocial.getListingLikeStatus())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    view = MetricsTrackingUtils.getTrackingJson((Activity)view.getContext(), "lk");
                    Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "like", null);
                    PMApi.like(listingsocial.getIdAsString(), view, null);
                } else
                {
                    Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "unlike", null);
                    PMApi.unLike(listingsocial.getIdAsString(), null);
                }
                ListingNotificationManager.getListingNotificationManager().fireListingLikedMessage(listingsocial.getIdAsString(), flag);
            }

            
            {
                this$0 = FeedListAdapter.this;
                super();
            }
        };
        shareButtonListener = new android.view.View.OnClickListener() {

            final FeedListAdapter this$0;

            public void onClick(final View v)
            {
                ListingSocial listingsocial = (ListingSocial)v.getTag();
                ImageLoader.getInstance().loadImage(listingsocial.getCovershot(), listingsocial. new ImageLoadingListener() {

                    final _cls3 this$1;
                    final ListingSocial val$feedItem;
                    final View val$v;

                    public void onLoadingCancelled(String s, View view)
                    {
                    }

                    public void onLoadingComplete(String s, View view, Bitmap bitmap)
                    {
                        s = ImageUtils.saveBitmapToDisk(bitmap, "ListingCoverShot.jpg");
                        view = new Bundle();
                        view.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.name());
                        view.putString("IMAGE_URI", s.toString());
                        ((PMActivity)v.getContext()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/ShareFragment, feedItem);
                    }

                    public void onLoadingFailed(String s, View view, FailReason failreason)
                    {
                        s = new Bundle();
                        s.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.name());
                        ((PMActivity)v.getContext()).launchFragmentInNewActivity(s, com/poshmark/ui/fragments/ShareFragment, feedItem);
                    }

                    public void onLoadingStarted(String s, View view)
                    {
                    }

            
            {
                this$1 = final__pcls3;
                v = view;
                feedItem = ListingSocial.this;
                super();
            }
                });
            }

            
            {
                this$0 = FeedListAdapter.this;
                super();
            }
        };
        viewDetailsListener = new android.view.View.OnClickListener() {

            final FeedListAdapter this$0;

            public void onClick(View view)
            {
                ListingSocial listingsocial = (ListingSocial)view.getTag();
                Bundle bundle = new Bundle();
                bundle.putString("ID", listingsocial.getIdAsString());
                ((PMActivity)view.getContext()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingDetailsFragment, null);
            }

            
            {
                this$0 = FeedListAdapter.this;
                super();
            }
        };
    }

    private void addComments(Context context, Cursor cursor, ListingViewHolder listingviewholder)
    {
        cursor = (CustomMatrixCursor)cursor;
        cursor = ((ListingSocial)cursor.get(cursor.getColumnIndex(PMData.DATA_COL))).getComments();
        if (cursor.size() >= 1)
        {
            listingviewholder.commentLayout1.setVisibility(0);
            Comment comment = (Comment)cursor.get(0);
            listingviewholder.comment1.setComment((new StringBuilder()).append(comment.getCommenterDisplayHandle()).append(" ").append(comment.getComment().toString()).toString());
            listingviewholder.commenterAvataar1.setUser(comment.getCommenterName());
            listingviewholder.commenterAvataar1.loadImage(comment.getCommenterPicture());
        } else
        {
            listingviewholder.commentLayout1.setVisibility(8);
        }
        if (cursor.size() >= 2)
        {
            listingviewholder.commentLayout2.setVisibility(0);
            Comment comment1 = (Comment)cursor.get(1);
            listingviewholder.comment2.setComment((new StringBuilder()).append(comment1.getCommenterDisplayHandle()).append(" ").append(comment1.getComment().toString()).toString());
            listingviewholder.commenterAvataar2.setUser(comment1.getCommenterName());
            listingviewholder.commenterAvataar2.loadImage(comment1.getCommenterPicture());
        } else
        {
            listingviewholder.commentLayout2.setVisibility(8);
        }
        listingviewholder.allCommentsView.setVisibility(0);
        listingviewholder.allCommentsView.setOnClickListener(viewDetailsListener);
        if (cursor.size() > 2)
        {
            context = String.format(context.getResources().getString(0x7f06018e), new Object[] {
                Integer.toString(cursor.size())
            });
        } else
        {
            context = context.getResources().getString(0x7f0602bf);
        }
        listingviewholder.allCommentsView.setText(context);
    }

    private void setLikeButtonState(ListingViewHolder listingviewholder, boolean flag)
    {
        Resources resources = PMApplication.getContext().getResources();
        if (flag)
        {
            listingviewholder.likeButton.setBackgroundDrawable(resources.getDrawable(0x7f020017));
            listingviewholder.likeButton.setCompoundDrawablesWithIntrinsicBounds(0x7f020095, 0, 0, 0);
            return;
        } else
        {
            listingviewholder.likeButton.setBackgroundDrawable(resources.getDrawable(0x7f020016));
            listingviewholder.likeButton.setCompoundDrawablesWithIntrinsicBounds(0x7f020093, 0, 0, 0);
            return;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        Object obj = (CustomMatrixCursor)cursor;
        obj = (ListingSocial)((CustomMatrixCursor) (obj)).get(((CustomMatrixCursor) (obj)).getColumnIndex(PMData.DATA_COL));
        ListingViewHolder listingviewholder = (ListingViewHolder)view.getTag();
        com.poshmark.data_model.models.inner_models.Inventory.ListingStatus listingstatus;
        int i;
        if (cursor.getPosition() == 0)
        {
            listingviewholder.topBorder.setVisibility(8);
        } else
        {
            listingviewholder.topBorder.setVisibility(0);
        }
        listingviewholder.userNameView.setUserName(((ListingSocial) (obj)).getUserName());
        view = listingviewholder.coverShotViewBig;
        view.setListingId(((ListingSocial) (obj)).getIdAsString());
        if (!view.getImageURL().equals(((ListingSocial) (obj)).getCovershot()))
        {
            view.loadImage(((ListingSocial) (obj)).getCovershot());
        }
        view = listingviewholder.statusView;
        listingstatus = ((ListingSocial) (obj)).getListingStatus();
        if (listingstatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD || listingstatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.RESERVED)
        {
            view.setVisibility(0);
            view.setListingStatus(listingstatus);
            view.bringToFront();
        } else
        {
            view.setVisibility(8);
        }
        view = listingviewholder.avataarView;
        view.setUser(((ListingSocial) (obj)).getUserId());
        view.loadImage(((ListingSocial) (obj)).getAvataar());
        view = textFormatter.getPublishedAtMessageString(((ListingSocial) (obj)));
        listingviewholder.attributionView.setText(view);
        if (((ListingSocial) (obj)).isNWT())
        {
            listingviewholder.nwtTextView.setVisibility(0);
        } else
        {
            listingviewholder.nwtTextView.setVisibility(8);
        }
        listingviewholder.titleView.setText(((ListingSocial) (obj)).getTitle());
        listingviewholder.priceView.setText(((ListingSocial) (obj)).getPriceString());
        listingviewholder.originalPriceView.setText(((ListingSocial) (obj)).getOriginalPriceString());
        i = ListingUtils.getDrawableIconForCategory(((ListingSocial) (obj)).getCategoryLabel());
        view = context.getResources().getDrawable(i);
        listingviewholder.categoryView.setImageDrawable(view);
        listingviewholder.sizeView.setText((new StringBuilder()).append(context.getString(0x7f060281)).append(" ").append(((ListingSocial) (obj)).getSize()).toString());
        listingviewholder.brandView.setText(((ListingSocial) (obj)).getBrand());
        listingviewholder.sizeView.setCategory(((ListingSocial) (obj)).getCategoryLabel());
        listingviewholder.sizeView.setSubCategoryList(((ListingSocial) (obj)).getSubCategoryList());
        view = ((ListingSocial) (obj)).getSize();
        if (view == null)
        {
            view = new String("");
        } else
        {
            view = view.toString();
        }
        listingviewholder.sizeView.setSize(view);
        listingviewholder.brandView.setBrand(((ListingSocial) (obj)).getBrand());
        if (((ListingSocial) (obj)).isNWT())
        {
            listingviewholder.nwtTextView.setNWTConditionFlag(Boolean.valueOf(true));
            listingviewholder.nwtTextView.setCategory(((ListingSocial) (obj)).getCategoryLabel());
            listingviewholder.nwtTextView.setSubCategoryList(((ListingSocial) (obj)).getSubCategoryList());
        }
        listingviewholder.descriptionView.setText(((ListingSocial) (obj)).getDescription());
        view = ((ListingSocial) (obj)).getLikes();
        if (view.size() > 0)
        {
            listingviewholder.likesLayout.setVisibility(0);
            listingviewholder.likesView.setLikesMessage(view, ((ListingSocial) (obj)).getIdAsString());
        } else
        {
            listingviewholder.likesLayout.setVisibility(8);
        }
        addComments(context, cursor, listingviewholder);
        setLikeButtonState(listingviewholder, ((ListingSocial) (obj)).getListingLikeStatus());
        listingviewholder.likeButton.setTag(obj);
        listingviewholder.shareButton.setTag(obj);
        listingviewholder.commentButton.setTag(obj);
        listingviewholder.allCommentsView.setTag(obj);
    }

    public void clearImageList()
    {
        for (Iterator iterator = imageList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((PMImageView)iterator.next()).releaseInternalBitmap();
        }

    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context);
        context = inflater.inflate(0x7f03003f, viewgroup, false);
        cursor = new ListingViewHolder();
        cursor.topBorder = context.findViewById(0x7f0c010f);
        viewgroup = (LinearLayout)context.findViewById(0x7f0c0110);
        cursor.avataarView = (PMAvataarImageView)viewgroup.findViewById(0x7f0c011b);
        cursor.userNameView = (PMTextView)viewgroup.findViewById(0x7f0c01cd);
        cursor.attributionView = (TextView)viewgroup.findViewById(0x7f0c011c);
        viewgroup = (LinearLayout)context.findViewById(0x7f0c0111);
        cursor.coverShotViewBig = (PMCovershotImageView)viewgroup.findViewById(0x7f0c0121);
        cursor.statusView = (ListingStatusView)viewgroup.findViewById(0x7f0c0127);
        cursor.titleView = (TextView)viewgroup.findViewById(0x7f0c0130);
        cursor.nwtTextView = (SearchFilterTextView)viewgroup.findViewById(0x7f0c007d);
        cursor.priceView = (TextView)viewgroup.findViewById(0x7f0c007f);
        cursor.originalPriceView = (TextView)viewgroup.findViewById(0x7f0c0080);
        ((ListingViewHolder) (cursor)).originalPriceView.setPaintFlags(((ListingViewHolder) (cursor)).originalPriceView.getPaintFlags() | 0x10);
        cursor.categoryView = (ImageView)viewgroup.findViewById(0x7f0c0132);
        cursor.sizeView = (SearchFilterTextView)viewgroup.findViewById(0x7f0c0081);
        cursor.brandView = (SearchFilterTextView)viewgroup.findViewById(0x7f0c0134);
        cursor.descriptionView = (TextView)viewgroup.findViewById(0x7f0c0135);
        ((ListingViewHolder) (cursor)).descriptionView.setMaxLines(2);
        ((ListingViewHolder) (cursor)).descriptionView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        cursor.likesLayout = (LinearLayout)context.findViewById(0x7f0c0112);
        cursor.likesView = (PMTextView)((ListingViewHolder) (cursor)).likesLayout.findViewById(0x7f0c01d2);
        viewgroup = (LinearLayout)context.findViewById(0x7f0c0116);
        cursor.likeButton = (Button)viewgroup.findViewById(0x7f0c0045);
        cursor.commentButton = (Button)viewgroup.findViewById(0x7f0c0168);
        cursor.shareButton = (Button)viewgroup.findViewById(0x7f0c0046);
        cursor.commentLayout1 = (LinearLayout)context.findViewById(0x7f0c0113);
        cursor.commentLayout2 = (LinearLayout)context.findViewById(0x7f0c0114);
        cursor.commenterAvataar1 = (PMAvataarImageView)((ListingViewHolder) (cursor)).commentLayout1.findViewById(0x7f0c016f);
        cursor.commenterAvataar2 = (PMAvataarImageView)((ListingViewHolder) (cursor)).commentLayout2.findViewById(0x7f0c016f);
        cursor.comment1 = (PMTextView)((ListingViewHolder) (cursor)).commentLayout1.findViewById(0x7f0c0171);
        cursor.comment2 = (PMTextView)((ListingViewHolder) (cursor)).commentLayout2.findViewById(0x7f0c0171);
        cursor.allCommentsView = (PMTextView)context.findViewById(0x7f0c0115);
        ((ListingViewHolder) (cursor)).nwtTextView.setTextSize(2, 10F);
        ((ListingViewHolder) (cursor)).sizeView.setTextSize(2, 13F);
        ((ListingViewHolder) (cursor)).brandView.setTextSize(2, 13F);
        ((ListingViewHolder) (cursor)).commentButton.setOnClickListener(commentButtonListener);
        ((ListingViewHolder) (cursor)).likeButton.setOnClickListener(likeButtonListener);
        ((ListingViewHolder) (cursor)).shareButton.setOnClickListener(shareButtonListener);
        context.setTag(cursor);
        return context;
    }
}
