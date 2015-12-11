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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.FeedItem;
import com.poshmark.data_model.models.FeedItemImageLayout;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.data_model.models.inner_models.FeedItemFooterLayout;
import com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout;
import com.poshmark.data_model.models.inner_models.FeedItemLayoutInfo;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.fragments.CommentFragment;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.ui.fragments.ShareFragment;
import com.poshmark.ui.fragments.UserListFragment;
import com.poshmark.utils.FBDPAHelper;
import com.poshmark.utils.FeedItemPopulator;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.view_holders.FeedItemViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HetroFeedListAdapter extends CursorAdapter
{

    public android.view.View.OnClickListener commentButtonListener;
    Set imageList;
    private LayoutInflater inflater;
    public android.view.View.OnClickListener likeButtonListener;
    public android.view.View.OnClickListener shareButtonListener;
    public android.view.View.OnClickListener viewDetailsListener;
    public android.view.View.OnClickListener viewLikesListener;

    public HetroFeedListAdapter(Context context, Fragment fragment, Cursor cursor, int i)
    {
        super(context, cursor, i);
        imageList = new HashSet();
        commentButtonListener = new android.view.View.OnClickListener() {

            final HetroFeedListAdapter this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "comment_button_tapped", null);
                ListingSocial listingsocial = (ListingSocial)view.getTag();
                view = (PMActivity)view.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("ID", listingsocial.getIdAsString());
                view.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingsocial);
            }

            
            {
                this$0 = HetroFeedListAdapter.this;
                super();
            }
        };
        likeButtonListener = new android.view.View.OnClickListener() {

            final HetroFeedListAdapter this$0;

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
                    FBDPAHelper.trackListingLike(listingsocial);
                    PMApi.like(listingsocial.getIdAsString(), view, null);
                    listingsocial.setListingLikeStatus(true);
                } else
                {
                    Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "unlike", null);
                    PMApi.unLike(listingsocial.getIdAsString(), null);
                    listingsocial.setListingLikeStatus(false);
                }
                ListingNotificationManager.getListingNotificationManager().fireListingLikedMessage(listingsocial.getIdAsString(), flag);
            }

            
            {
                this$0 = HetroFeedListAdapter.this;
                super();
            }
        };
        shareButtonListener = new android.view.View.OnClickListener() {

            final HetroFeedListAdapter this$0;

            public void onClick(final View v)
            {
                ListingSocial listingsocial = (ListingSocial)v.getTag();
                Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "share_button_tapped", null);
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
                this$0 = HetroFeedListAdapter.this;
                super();
            }
        };
        viewDetailsListener = new android.view.View.OnClickListener() {

            final HetroFeedListAdapter this$0;

            public void onClick(View view)
            {
                ListingSocial listingsocial = (ListingSocial)view.getTag();
                Bundle bundle = new Bundle();
                bundle.putString("ID", listingsocial.getIdAsString());
                ((PMActivity)view.getContext()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingDetailsFragment, null);
            }

            
            {
                this$0 = HetroFeedListAdapter.this;
                super();
            }
        };
        viewLikesListener = new android.view.View.OnClickListener() {

            final HetroFeedListAdapter this$0;

            public void onClick(View view)
            {
                ListingSocial listingsocial = (ListingSocial)view.getTag();
                Bundle bundle = new Bundle();
                bundle.putString("MODE", com.poshmark.ui.fragments.UserListFragment.USER_LIST_MODE.LIKES_MODE.name());
                bundle.putString("ID", listingsocial.getIdAsString());
                ((PMActivity)view.getContext()).launchFragment(bundle, com/poshmark/ui/fragments/UserListFragment, null);
            }

            
            {
                this$0 = HetroFeedListAdapter.this;
                super();
            }
        };
    }

    private com.poshmark.data_model.models.FeedItemImageLayout.Layout getFeedItemLayoutType(Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        return ((FeedItem)cursor.get(cursor.getColumnIndex(PMData.DATA_COL))).getViewType();
    }

    private void inflateFeedItem(Cursor cursor, Context context, View view, FeedItemViewHolder feeditemviewholder)
    {
        cursor = (CustomMatrixCursor)cursor;
        cursor = (FeedItem)cursor.get(cursor.getColumnIndex(PMData.DATA_COL));
        feeditemviewholder.topBorder = view.findViewById(0x7f0c010f);
        if (((FeedItem) (cursor)).layoutInfo.headerLayout == null) goto _L2; else goto _L1
_L1:
        static class _cls6
        {

            static final int $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[];
            static final int $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[];
            static final int $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[];

            static 
            {
                $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout = new int[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SIMPLE_LAUNCH_FOOTER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SOCIAL_ACTIONS_FOOTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.LEGACY_FOOTER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout = new int[com.poshmark.data_model.models.FeedItemImageLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_SOCIAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.MIFU_3_FLUID_LARGE_LEFT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.MIFU_4_GRID.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_SUMMARY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_LEFT_IMAGE_RIGHT_TEXT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout = new int[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.SINGLE_LEVEL_HEADER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.DOUBLE_LEVEL_HEADER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.LEGACY_HEADER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.SINGLE_LEVEL_HEADER_POSHPOST.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls6..SwitchMap.com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout[((FeedItem) (cursor)).layoutInfo.headerLayout.currentLayout.ordinal()];
        JVM INSTR tableswitch 1 4: default 88
    //                   1 201
    //                   2 231
    //                   3 261
    //                   4 291;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        if (((FeedItem) (cursor)).layoutInfo.imageLayout == null) goto _L8; else goto _L7
_L7:
        _cls6..SwitchMap.com.poshmark.data_model.models.FeedItemImageLayout.Layout[((FeedItem) (cursor)).layoutInfo.imageLayout.getCurrentLayout().ordinal()];
        JVM INSTR tableswitch 1 5: default 148
    //                   1 321
    //                   2 351
    //                   3 381
    //                   4 411
    //                   5 441;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        if (((FeedItem) (cursor)).layoutInfo.footerLayout == null) goto _L15; else goto _L14
_L14:
        _cls6..SwitchMap.com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout[((FeedItem) (cursor)).layoutInfo.footerLayout.currentLayout.ordinal()];
        JVM INSTR tableswitch 1 3: default 200
    //                   1 471
    //                   2 499
    //                   3 527;
           goto _L15 _L16 _L17 _L18
_L15:
        return;
_L3:
        context = inflater.inflate(0x7f030045, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithHeaderViews(cursor, context);
        continue; /* Loop/switch isn't completed */
_L4:
        context = inflater.inflate(0x7f030041, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithHeaderViews(cursor, context);
        continue; /* Loop/switch isn't completed */
_L5:
        context = inflater.inflate(0x7f030045, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithHeaderViews(cursor, context);
        continue; /* Loop/switch isn't completed */
_L6:
        context = inflater.inflate(0x7f03004a, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithHeaderViews(cursor, context);
        continue; /* Loop/switch isn't completed */
_L9:
        context = inflater.inflate(0x7f030048, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithImageViews(cursor, context);
          goto _L8
_L10:
        context = inflater.inflate(0x7f030046, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithImageViews(cursor, context);
          goto _L8
_L11:
        context = inflater.inflate(0x7f030047, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithImageViews(cursor, context);
          goto _L8
_L12:
        context = inflater.inflate(0x7f030048, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithImageViews(cursor, context);
          goto _L8
_L13:
        context = inflater.inflate(0x7f030049, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithImageViews(cursor, context);
          goto _L8
_L16:
        context = inflater.inflate(0x7f030042, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithFooterViews(cursor, context);
        return;
_L17:
        context = inflater.inflate(0x7f030043, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithFooterViews(cursor, context);
        return;
_L18:
        context = inflater.inflate(0x7f030044, null, false);
        ((LinearLayout)view).addView(context);
        feeditemviewholder.populateViewHolderWithFooterViews(cursor, context);
        return;
        if (true) goto _L2; else goto _L19
_L19:
    }

    private void populateViews(Context context, Cursor cursor, FeedItem feeditem, FeedItemViewHolder feeditemviewholder)
    {
        if (feeditem.layoutInfo.headerLayout != null)
        {
            FeedItemPopulator.populateHeader(context, this, feeditem, feeditemviewholder);
        }
        if (feeditem.layoutInfo.imageLayout != null)
        {
            FeedItemPopulator.populateImages(context, this, feeditem, feeditemviewholder);
        }
        if (feeditem.layoutInfo.footerLayout != null)
        {
            FeedItemPopulator.populateFooter(context, this, feeditem, feeditemviewholder);
        }
    }

    public void addComments(Context context, ListingSocial listingsocial, FeedItemViewHolder feeditemviewholder)
    {
        listingsocial = listingsocial.getComments();
        if (listingsocial.size() >= 1)
        {
            feeditemviewholder.commentLayout1.setVisibility(0);
            Comment comment = (Comment)listingsocial.get(0);
            feeditemviewholder.comment1.setComment((new StringBuilder()).append(comment.getCommenterDisplayHandle()).append(" ").append(comment.getComment().toString()).toString());
            feeditemviewholder.commenterAvataar1.setUser(comment.getCommenterName());
            feeditemviewholder.commenterAvataar1.loadImage(comment.getCommenterPicture());
        } else
        {
            feeditemviewholder.commentLayout1.setVisibility(8);
        }
        if (listingsocial.size() >= 2)
        {
            feeditemviewholder.commentLayout2.setVisibility(0);
            Comment comment1 = (Comment)listingsocial.get(1);
            feeditemviewholder.comment2.setComment((new StringBuilder()).append(comment1.getCommenterDisplayHandle()).append(" ").append(comment1.getComment().toString()).toString());
            feeditemviewholder.commenterAvataar2.setUser(comment1.getCommenterName());
            feeditemviewholder.commenterAvataar2.loadImage(comment1.getCommenterPicture());
        } else
        {
            feeditemviewholder.commentLayout2.setVisibility(8);
        }
        feeditemviewholder.allCommentsView.setVisibility(0);
        feeditemviewholder.allCommentsView.setOnClickListener(viewDetailsListener);
        if (listingsocial.size() > 2)
        {
            context = String.format(context.getResources().getString(0x7f06018e), new Object[] {
                Integer.toString(listingsocial.size())
            });
        } else
        {
            context = context.getResources().getString(0x7f0602bf);
        }
        feeditemviewholder.allCommentsView.setText(context);
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        CustomMatrixCursor custommatrixcursor = (CustomMatrixCursor)cursor;
        FeedItem feeditem = (FeedItem)custommatrixcursor.get(custommatrixcursor.getColumnIndex(PMData.DATA_COL));
        int i = cursor.getPosition();
        Log.d("BIND VIEW", (new StringBuilder()).append("pos=").append(Integer.toString(i)).toString());
        populateViews(context, custommatrixcursor, feeditem, (FeedItemViewHolder)view.getTag());
    }

    public void clearImageList()
    {
        for (Iterator iterator = imageList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((PMImageView)iterator.next()).releaseInternalBitmap();
        }

    }

    public int getItemViewType(int i)
    {
        CustomMatrixCursor custommatrixcursor = (CustomMatrixCursor)getCursor();
        custommatrixcursor.moveToPosition(i);
        return ((FeedItem)custommatrixcursor.get(custommatrixcursor.getColumnIndex(PMData.DATA_COL))).getViewLayoutTypeId();
    }

    public int getViewTypeCount()
    {
        return FeedItem.getViewLayoutTypeCount();
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        int i = cursor.getPosition();
        Log.d("BIND VIEW - new", (new StringBuilder()).append("pos=").append(Integer.toString(i)).toString());
        if (inflater == null)
        {
            inflater = LayoutInflater.from(context);
        }
        viewgroup = inflater.inflate(0x7f03004b, viewgroup, false);
        View view = viewgroup.findViewById(0x7f0c012b);
        FeedItemViewHolder feeditemviewholder = new FeedItemViewHolder();
        inflateFeedItem(cursor, context, view, feeditemviewholder);
        viewgroup.setTag(feeditemviewholder);
        return viewgroup;
    }

    public void setLikeButtonState(FeedItemViewHolder feeditemviewholder, boolean flag)
    {
        Resources resources = PMApplication.getContext().getResources();
        if (flag)
        {
            feeditemviewholder.likeButton.setBackgroundDrawable(resources.getDrawable(0x7f020017));
            feeditemviewholder.likeButton.setCompoundDrawablesWithIntrinsicBounds(0x7f020095, 0, 0, 0);
            return;
        } else
        {
            feeditemviewholder.likeButton.setBackgroundDrawable(resources.getDrawable(0x7f020016));
            feeditemviewholder.likeButton.setCompoundDrawablesWithIntrinsicBounds(0x7f020093, 0, 0, 0);
            return;
        }
    }
}
