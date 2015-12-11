// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.adapters.ListingDetailsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.BannerInfo;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.data_model.models.inner_models.AddToBundleButtonFeature;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.data_model.models.inner_models.Picture;
import com.poshmark.data_model.models.inner_models.SystemMessage;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.ListingDetailsColorItem;
import com.poshmark.ui.customviews.ListingDetailsMenuPopup;
import com.poshmark.ui.customviews.ListingStatusView;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.ui.customviews.PMPriceLayout;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.ui.customviews.SearchFilterTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.ColorConverter;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.DeepLinkLaunchInfo;
import com.poshmark.utils.DeepLinkUtils;
import com.poshmark.utils.FBDPAHelper;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.ListingUtils;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.NewRelicCustomInteractions;
import com.poshmark.utils.OfferFlowHandler;
import com.poshmark.utils.TextFormatter;
import com.poshmark.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apmem.tools.layouts.FlowLayout;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, ListingDetailsDrawerFragment, ViewBundleFragment, ListingEditorFragment, 
//            CommentFragment, MappPageFragment, ShareFragment

public class ListingDetailsFragment extends PMFragment
    implements ListingNotificationHandler, PMNotificationListener
{

    static String AVAILABLE = "AVAILABLE";
    static String NOT_FOR_SALE = "NOT_FOR_SALE";
    static String RESERVED = "RESERVED";
    static String SOLD = "SOLD";
    ListingDetailsAdapter adapter;
    BannerInfo bannerInfo;
    String bannerJson;
    android.view.View.OnClickListener deleteButtonListener;
    ListView detailsListView;
    ListingDetailsDrawerFragment drawerFragment;
    android.support.v4.widget.DrawerLayout.DrawerListener drawerListener;
    View footerView;
    LinearLayout headerContainerView;
    Boolean isEditListingWithNFSEnabled;
    ListingDetails listingDetails;
    String listingId;
    List listingImages;
    boolean listingNoMore;
    int menuButton;
    TextFormatter textFormatter;

    public ListingDetailsFragment()
    {
        listingDetails = null;
        textFormatter = new TextFormatter();
        listingNoMore = false;
        listingImages = new ArrayList();
        isEditListingWithNFSEnabled = Boolean.valueOf(false);
        deleteButtonListener = new android.view.View.OnClickListener() {

            final ListingDetailsFragment this$0;

            public void onClick(View view)
            {
                if (listingDetails.getListingStatus() == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD && !PMApplicationSession.GetPMSession().canPerformActionForRole("admin"))
                {
                    showAlertMessage("", getString(0x7f06016a));
                    return;
                } else
                {
                    showConfirmationMessage(getString(0x7f0600b7), getString(0x7f060169), new android.content.DialogInterface.OnClickListener() {

                        final _cls18 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (i == -1)
                            {
                                showProgressDialogWithMessage(getString(0x7f0600b7));
                                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "delete_listing", null);
                                PMApi.deleteListing(listingId, new PMApiResponseHandler() {

                                    final _cls1 this$2;

                                    public void handleResponse(PMApiResponse pmapiresponse)
                                    {
label0:
                                        {
                                            if (isAdded())
                                            {
                                                hideProgressDialog();
                                                if (pmapiresponse.hasError())
                                                {
                                                    break label0;
                                                }
                                                ListingNotificationManager.getListingNotificationManager().fireListingDeletedMessage(listingId);
                                                ((PMActivity)getActivity()).onBackPressed();
                                            }
                                            return;
                                        }
                                        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.DELETE_LISTING, getString(0x7f0600e2)));
                                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                });
                            }
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        };
        drawerListener = new android.support.v4.widget.DrawerLayout.DrawerListener() {

            final ListingDetailsFragment this$0;

            public void onDrawerClosed(View view)
            {
            }

            public void onDrawerOpened(View view)
            {
                if (drawerFragment != null)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_actions_button_tapped", null);
                    drawerFragment.updateDrawer(false);
                }
            }

            public void onDrawerSlide(View view, float f)
            {
            }

            public void onDrawerStateChanged(int i)
            {
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        };
    }

    private void createAllViews(View view)
    {
        detailsListView = (ListView)view.findViewById(0x7f0c0181);
        adapter.setParentListView(detailsListView);
        view = LayoutInflater.from(getActivity());
        headerContainerView = (LinearLayout)view.inflate(0x7f030064, null, false);
        detailsListView.addHeaderView(headerContainerView);
        footerView = view.inflate(0x7f030068, null, false);
        footerView.setVisibility(8);
        detailsListView.addFooterView(footerView);
        detailsListView.setAdapter(adapter);
        View view1 = view.inflate(0x7f030074, null);
        view1.setVisibility(4);
        headerContainerView.addView(view1, headerContainerView.getChildCount() - 2);
        view1 = view.inflate(0x7f030067, null);
        view1.setVisibility(4);
        headerContainerView.addView(view1, headerContainerView.getChildCount() - 1);
        view1 = view.inflate(0x7f030062, null);
        view1.setVisibility(4);
        headerContainerView.addView(view1, headerContainerView.getChildCount() - 1);
        if (FeatureManager.getGlobalFeatureManager().isAddToBundleButtonFeatureEnabled())
        {
            View view2 = view.inflate(0x7f030009, null);
            view2.setVisibility(4);
            headerContainerView.addView(view2, headerContainerView.getChildCount() - 1);
        }
        view = view.inflate(0x7f030077, null);
        view.setVisibility(4);
        headerContainerView.addView(view, headerContainerView.getChildCount() - 1);
    }

    private void fetchListingDetails()
    {
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        PMApi.postGoalTrackingInfo(MetricsTrackingUtils.getTrackingJson(getActivity(), "vw_l"));
        PMApi.getListingDetails(listingId, new PMApiResponseHandler() {

            final ListingDetailsFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        listingDetails = (ListingDetails)pmapiresponse.data;
                        FBDPAHelper.trackListingView(listingDetails, getTrackingList());
                        setupActionBarNextActionButton();
                        updateCursorData();
                        updateView();
                    }
                    return;
                }
                String s;
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND || pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_GONE)
                {
                    s = getResources().getString(0x7f0600e3);
                } else
                {
                    s = getResources().getString(0x7f0600e6);
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_LISTING, s));
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
    }

    private void insertListingImages(LinearLayout linearlayout)
    {
        int i = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 2.0F);
        linearlayout = (LinearLayout)linearlayout.findViewById(0x7f0c018f);
        linearlayout.removeAllViewsInLayout();
        Object obj = new PMListingImageView(getActivity(), null);
        linearlayout.addView(((View) (obj)));
        listingImages.add(obj);
        ((PMListingImageView) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        ((PMListingImageView) (obj)).loadImage(listingDetails.getCovershot());
        obj = listingDetails.getPictures();
        if (obj != null)
        {
            Picture picture;
            PMListingImageView pmlistingimageview;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); pmlistingimageview.loadImage(picture.getPictureUrl()))
            {
                picture = (Picture)((Iterator) (obj)).next();
                pmlistingimageview = new PMListingImageView(getActivity(), null);
                linearlayout.addView(pmlistingimageview);
                listingImages.add(pmlistingimageview);
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
                layoutparams.setMargins(0, i, 0, 0);
                pmlistingimageview.setLayoutParams(layoutparams);
            }

        }
    }

    private void setActionBarLikeButtonState(boolean flag)
    {
        Object obj;
        Resources resources;
label0:
        {
            obj = getActivity().getActionBar().getCustomView();
            if (obj != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f0c0045);
                resources = getResources();
                if (!flag)
                {
                    break label0;
                }
                ((ImageButton) (obj)).setBackgroundDrawable(resources.getDrawable(0x7f0200a0));
            }
            return;
        }
        ((ImageButton) (obj)).setBackgroundDrawable(resources.getDrawable(0x7f02009e));
    }

    private void setLikeButtonState(Button button, boolean flag)
    {
        Resources resources;
label0:
        {
            if (button != null)
            {
                resources = getResources();
                if (!flag)
                {
                    break label0;
                }
                button.setBackgroundDrawable(resources.getDrawable(0x7f020017));
                button.setCompoundDrawablesWithIntrinsicBounds(0x7f020095, 0, 0, 0);
            }
            return;
        }
        button.setBackgroundDrawable(resources.getDrawable(0x7f020016));
        button.setCompoundDrawablesWithIntrinsicBounds(0x7f020093, 0, 0, 0);
    }

    private void setLikeButtonState(ImageView imageview, boolean flag)
    {
        Resources resources;
label0:
        {
            if (imageview != null)
            {
                resources = getResources();
                if (!flag)
                {
                    break label0;
                }
                imageview.setImageDrawable(resources.getDrawable(0x7f0200a0));
                ((PMTextView)getView().findViewById(0x7f0c018a)).setText(getString(0x7f060164));
            }
            return;
        }
        imageview.setImageDrawable(resources.getDrawable(0x7f02009e));
        ((PMTextView)getView().findViewById(0x7f0c018a)).setText((new StringBuilder()).append(getString(0x7f060163)).append(" ").toString());
    }

    private void setupActionBarNextActionButton()
    {
        if (!listingDetails.getUserId().equals(PMApplicationSession.GetPMSession().getUserId()))
        {
            menuButton = 0x7f0c003e;
            View view = getActivity().getActionBar().getCustomView();
            if (view != null)
            {
                ((FrameLayout)view.findViewById(0x7f0c0043)).setVisibility(0);
                ((ImageButton)view.findViewById(0x7f0c0045)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsFragment this$0;

                    public void onClick(View view1)
                    {
                        toggleListingLikedButtons();
                    }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                });
                ((ImageButton)view.findViewById(0x7f0c0046)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsFragment this$0;

                    public void onClick(View view1)
                    {
                        shareListing();
                    }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                });
                ((ImageButton)view.findViewById(0x7f0c003e)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsFragment this$0;

                    public void onClick(View view1)
                    {
                        showPopupMenu(view1);
                    }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                });
            }
        } else
        {
            Object obj = getActivity().getActionBar().getCustomView();
            if (obj != null)
            {
                ((FrameLayout)((View) (obj)).findViewById(0x7f0c0043)).setVisibility(4);
            }
            obj = getNextActionButton();
            if (obj != null)
            {
                menuButton = ((Button) (obj)).getId();
                ((Button) (obj)).setText(getString(0x7f0600c3).toUpperCase());
                setTitle(0x7f06016c);
            }
            if (isEditListingWithNFSEnabled.booleanValue() && obj != null)
            {
                ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsFragment this$0;

                    public void onClick(View view1)
                    {
                        editListing();
                    }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                });
                return;
            }
            drawerFragment = (ListingDetailsDrawerFragment)setDrawerActionButton(com/poshmark/ui/fragments/ListingDetailsDrawerFragment, this, menuButton, this);
            if (drawerFragment != null)
            {
                PMContainerActivity pmcontaineractivity = (PMContainerActivity)getActivity();
                if (pmcontaineractivity != null)
                {
                    pmcontaineractivity.setDrawerListener(drawerListener);
                    return;
                }
            }
        }
    }

    private void setupBottomBar()
    {
        Button button;
        Button button1;
        Button button2;
        ListingStatusView listingstatusview;
        com.poshmark.data_model.models.inner_models.Inventory.ListingStatus listingstatus;
        boolean flag;
        Object obj = getView().findViewById(0x7f0c00ab);
        ((View) (obj)).setVisibility(0);
        button = (Button)((View) (obj)).findViewById(0x7f0c0186);
        button1 = (Button)((View) (obj)).findViewById(0x7f0c0185);
        button2 = (Button)((View) (obj)).findViewById(0x7f0c0184);
        listingstatusview = (ListingStatusView)((View) (obj)).findViewById(0x7f0c0127);
        listingstatus = listingDetails.getListingStatus();
        boolean flag2 = PMApplicationSession.GetPMSession().getUserId().equals(listingDetails.getUserId());
        boolean flag1 = false;
        boolean flag3 = listingDetails.hasOffers();
        boolean flag4 = listingDetails.haveIOffered();
        boolean flag5 = listingDetails.isPriceValidForOffer();
        flag = flag1;
        if (FeatureManager.getGlobalFeatureManager().isMakeAnOfferEnabled())
        {
            flag = flag1;
            if (flag5)
            {
                flag = flag1;
                if (listingstatus == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.AVAILABLE)
                {
                    if (flag2)
                    {
                        flag = flag1;
                        if (flag3)
                        {
                            button2.setVisibility(8);
                            button1.setVisibility(0);
                            if (listingDetails.getOfferCount() > 1)
                            {
                                button1.setText(getString(0x7f0602c0));
                            } else
                            {
                                button1.setText(getString(0x7f0602c6));
                            }
                            flag = true;
                            button1.setOnClickListener(new android.view.View.OnClickListener() {

                                final ListingDetailsFragment this$0;

                                public void onClick(View view)
                                {
                                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "seller_view_offers_link_tapped", listingDetails.getIdAsString());
                                    view = listingDetails.getOffersUrl();
                                    if (view != null)
                                    {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/").append(view).toString());
                                        bundle.putString("ANALYTICS_PAGE_NAME", "Offers");
                                        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
                                    }
                                }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                            });
                        }
                    } else
                    if (flag4)
                    {
                        button2.setVisibility(8);
                        button1.setVisibility(0);
                        flag = true;
                        button1.setOnClickListener(new android.view.View.OnClickListener() {

                            final ListingDetailsFragment this$0;

                            public void onClick(View view)
                            {
                                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "buyer_view_offer_link_tapped", listingDetails.getIdAsString());
                                view = listingDetails.getOffersUrl();
                                if (view != null)
                                {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/").append(view).toString());
                                    bundle.putString("ANALYTICS_PAGE_NAME", "Offers");
                                    ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
                                }
                            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                        });
                    } else
                    {
                        button1.setVisibility(8);
                        button2.setVisibility(0);
                        flag = true;
                        button2.setOnClickListener(new android.view.View.OnClickListener() {

                            final ListingDetailsFragment this$0;

                            public void onClick(View view)
                            {
                                FBDPAHelper.trackAddToCart(listingDetails, FBDPAHelper.PURCHASE_TYPE_OFFER);
                                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "buyer_make_offer_link_tapped", listingDetails.getIdAsString());
                                (new OfferFlowHandler(ListingDetailsFragment.this)).beginCheckoutForListing(listingDetails);
                            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                        });
                    }
                }
            }
        }
        if (listingstatus != com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.AVAILABLE || flag2) goto _L2; else goto _L1
_L1:
        button.setVisibility(0);
        listingstatusview.setVisibility(8);
        if (!flag)
        {
            button2.setVisibility(8);
            button1.setVisibility(8);
        }
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "buy_button_clicked", null);
                FBDPAHelper.trackAddToCart(listingDetails, FBDPAHelper.PURCHASE_TYPE_SINGLE_LISTING);
                FBDPAHelper.trackListingPurchaseInitiated(listingDetails, FBDPAHelper.PURCHASE_TYPE_SINGLE_LISTING);
                (new CheckoutFlowHandler(ListingDetailsFragment.this)).beginCheckoutForListing(listingDetails);
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
_L4:
        obj = (PMPriceLayout)((View) (obj)).findViewById(0x7f0c0187);
        if (obj != null)
        {
            ((PMPriceLayout) (obj)).setListingPrices((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(listingDetails.getPrice())).toString(), (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(listingDetails.getOriginalPrice())).toString());
        }
        return;
_L2:
        button.setVisibility(8);
        listingstatusview.setVisibility(0);
        listingstatusview.setListingStatus(listingstatus);
        if (!flag)
        {
            button2.setVisibility(8);
            button1.setVisibility(8);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setupListItemClickListener()
    {
        if (PMApplicationSession.GetPMSession().isUserAdmin())
        {
            detailsListView.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

                final ListingDetailsFragment this$0;

                public boolean onItemLongClick(final AdapterView comment, View view, int i, long l)
                {
                    i = ((Integer)view.getTag()).intValue();
                    comment = listingDetails.getComments();
                    if (comment != null && comment.size() > i)
                    {
                        comment = (Comment)comment.get(i);
                        view = ((Comment) (comment)).creator_display_handle;
                        String s = ((Comment) (comment)).comment;
                        showConfirmationMessage("Delete Comment!!", (new StringBuilder()).append("Are you sure you want to delete this comment by @").append(view).append(":\n").append(s).toString(), i. new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$1;
                            final Comment val$comment;
                            final int val$commentIndex;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                if (i == -1)
                                {
                                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "delete_listing_comment", listingId);
                                    showProgressDialogWithMessage("Deleting Comment...");
                                    PMApi.deleteComment(listingId, comment.id, new PMApiResponseHandler() {

                                        final _cls1 this$2;

                                        public void handleResponse(PMApiResponse pmapiresponse)
                                        {
                                            hideProgressDialog();
                                            if (!pmapiresponse.hasError())
                                            {
                                                listingDetails.deleteComment(commentIndex);
                                                updateCursorData();
                                            }
                                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                    });
                                }
                            }

            
            {
                this$1 = final__pcls1;
                comment = comment1;
                commentIndex = I.this;
                super();
            }
                        });
                    }
                    return true;
                }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
            });
        }
    }

    private void shareListing()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "share_button_tapped", null);
        ImageLoader.getInstance().loadImage(listingDetails.getCovershot(), new ImageLoadingListener() {

            final ListingDetailsFragment this$0;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                view = ImageUtils.saveBitmapToDisk(bitmap, "ListingCoverShot.jpg");
                s = new Bundle();
                s.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.name());
                if (view != null)
                {
                    s.putString("IMAGE_URI", view.toString());
                }
                view = (PMActivity)getActivity();
                if (isAdded())
                {
                    view.launchFragmentInNewActivity(s, com/poshmark/ui/fragments/ShareFragment, listingDetails);
                }
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                s = new Bundle();
                s.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.name());
                ((PMActivity)getActivity()).launchFragmentInNewActivity(s, com/poshmark/ui/fragments/ShareFragment, listingDetails);
            }

            public void onLoadingStarted(String s, View view)
            {
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
    }

    private void toggleListingLikedButtons()
    {
        boolean flag;
        if (!listingDetails.getListingLikeStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ListingNotificationManager.getListingNotificationManager().fireListingLikedMessage(listingDetails.getIdAsString(), flag);
        if (flag)
        {
            String s = MetricsTrackingUtils.getTrackingJson((Activity)getView().getContext(), "lk");
            Analytics.getInstance().trackEvent("listing_details_screen", "listing", "like", null);
            FBDPAHelper.trackListingLike(listingDetails);
            PMApi.like(listingDetails.getIdAsString(), s, null);
            AppEventsLogger.newLogger(PMApplication.getContext()).logEvent("like");
            return;
        } else
        {
            Analytics.getInstance().trackEvent("listing_details_screen", "listing", "unlike", null);
            PMApi.unLike(listingDetails.getIdAsString(), null);
            return;
        }
    }

    private void updateActionButtons(LinearLayout linearlayout)
    {
        linearlayout = linearlayout.findViewById(0x7f0c0167);
        linearlayout.setVisibility(0);
        setActionBarLikeButtonState(listingDetails.getListingLikeStatus());
        setLikeButtonState((ImageView)linearlayout.findViewById(0x7f0c004e), listingDetails.getListingLikeStatus());
        ((LinearLayout)linearlayout.findViewById(0x7f0c0189)).setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsFragment this$0;

            public void onClick(View view)
            {
                toggleListingLikedButtons();
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
        ((LinearLayout)linearlayout.findViewById(0x7f0c0174)).setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsFragment this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "comment_button_tapped", null);
                view = (PMActivity)view.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("ID", listingId);
                view.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingDetails);
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
        ((LinearLayout)linearlayout.findViewById(0x7f0c018c)).setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsFragment this$0;

            public void onClick(View view)
            {
                shareListing();
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)linearlayout.getLayoutParams();
        layoutparams.setMargins(0, (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 12F), 0, 0);
        linearlayout.setLayoutParams(layoutparams);
    }

    private void updateAddToBundleButton(LinearLayout linearlayout)
    {
        if (FeatureManager.getGlobalFeatureManager().isAddToBundleButtonFeatureEnabled())
        {
            AddToBundleButtonFeature addtobundlebuttonfeature = FeatureManager.getGlobalFeatureManager().getAddToBundleButtonFeature();
            linearlayout = linearlayout.findViewById(0x7f0c004c);
            linearlayout.setVisibility(0);
            ((PMTextView)linearlayout.findViewById(0x7f0c004f)).setText(addtobundlebuttonfeature.getTitle());
            linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

                final ListingDetailsFragment this$0;

                public void onClick(View view)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "add_listing_to_bundle_cell_tapped", null);
                    addListingToBundle();
                }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
            });
        }
    }

    private void updateCategoryAndColorsInfo(LinearLayout linearlayout)
    {
        ((LinearLayout)linearlayout.findViewById(0x7f0c0169)).setVisibility(0);
        Object obj1 = (SearchFilterTextView)linearlayout.findViewById(0x7f0c016a);
        Object obj = listingDetails.getCategory();
        ((SearchFilterTextView) (obj1)).setText(((MetaItem) (obj)).getDisplay());
        ((SearchFilterTextView) (obj1)).setCategory(((MetaItem) (obj)).getId());
        ((SearchFilterTextView) (obj1)).setParentScreenNameForAnalytics(viewNameForAnalytics);
        obj1 = (SearchFilterTextView)linearlayout.findViewById(0x7f0c016b);
        List list = listingDetails.getSubCategoryList();
        if (list != null && !list.isEmpty())
        {
            ((SearchFilterTextView) (obj1)).setVisibility(0);
            ((SearchFilterTextView) (obj1)).setCategory(((MetaItem) (obj)).getId());
            ((SearchFilterTextView) (obj1)).setSubCategoryList(list);
            ((SearchFilterTextView) (obj1)).setParentScreenNameForAnalytics(viewNameForAnalytics);
            ((SearchFilterTextView) (obj1)).setText(((MetaItem)list.get(0)).getDisplay());
        } else
        {
            ((SearchFilterTextView) (obj1)).setVisibility(4);
        }
        obj = (LinearLayout)linearlayout.findViewById(0x7f0c016c);
        ((LinearLayout) (obj)).setVisibility(8);
        linearlayout = (FlowLayout)linearlayout.findViewById(0x7f0c016d);
        linearlayout.removeAllViews();
        obj1 = listingDetails.getColorList();
        if (obj1 != null && !((List) (obj1)).isEmpty())
        {
            ((LinearLayout) (obj)).setVisibility(0);
            obj = LayoutInflater.from(getActivity());
            ListingDetailsColorItem listingdetailscoloritem;
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); listingdetailscoloritem.setCategory(listingDetails.getCategoryId()))
            {
                PMColor pmcolor = (PMColor)((Iterator) (obj1)).next();
                listingdetailscoloritem = (ListingDetailsColorItem)((LayoutInflater) (obj)).inflate(0x7f030063, null);
                new android.widget.LinearLayout.LayoutParams(-2, -2);
                linearlayout.addView(listingdetailscoloritem);
                listingdetailscoloritem.setColor(pmcolor);
                listingdetailscoloritem.setParentScreenNameForAnalytics(viewNameForAnalytics);
            }

        }
    }

    private void updateCursorData()
    {
        if (getUserVisibleHint() && listingDetails != null)
        {
            CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            listingDetails.fillCursorForComments(custommatrixcursor);
            adapter.changeCursor(custommatrixcursor);
            adapter.notifyDataSetChanged();
        }
    }

    private void updateListingFooter()
    {
    }

    private void updateListingHeader(LinearLayout linearlayout)
    {
        linearlayout = linearlayout.findViewById(0x7f0c011f);
        linearlayout.setVisibility(0);
        Object obj = (RoundedImageView)linearlayout.findViewById(0x7f0c011b);
        Object obj1 = ImageLoader.getInstance();
        if (listingDetails.getAvataar() != null)
        {
            ((ImageLoader) (obj1)).loadImage(listingDetails.getAvataar(), ((RoundedImageView) (obj)).listener);
        } else
        {
            ((RoundedImageView) (obj)).setBitmap(0x7f0200d4);
        }
        ((PMTextView)linearlayout.findViewById(0x7f0c01cd)).setUserName(listingDetails.getUserName());
        ((TextView)linearlayout.findViewById(0x7f0c011c)).setText(textFormatter.getPublishedAtMessageString(listingDetails));
        obj = (ImageView)linearlayout.findViewById(0x7f0c01ce);
        obj1 = (PMTextView)linearlayout.findViewById(0x7f0c01cf);
        if (FeatureManager.getGlobalFeatureManager().isListingDetailsPriceDropEnabled())
        {
            int i = listingDetails.getPriceDropPercentage();
            if (i > 0)
            {
                Resources resources = getResources();
                ((ImageView) (obj)).setVisibility(0);
                ((PMTextView) (obj1)).setVisibility(0);
                ((ImageView) (obj)).setBackgroundDrawable(resources.getDrawable(0x7f0200fd));
                ((PMTextView) (obj1)).setText((new StringBuilder()).append(Integer.toString(i)).append("%").toString());
            } else
            {
                ((ImageView) (obj)).setVisibility(4);
                ((PMTextView) (obj1)).setVisibility(4);
            }
        }
        if (bannerInfo != null && bannerInfo.message != null)
        {
            linearlayout = (RelativeLayout)linearlayout.findViewById(0x7f0c01c8);
            if (linearlayout != null)
            {
                linearlayout.setVisibility(0);
                if (bannerInfo.image_url != null)
                {
                    obj = (ImageView)linearlayout.findViewById(0x7f0c01c9);
                    ImageLoader.getInstance().displayImage(bannerInfo.image_url, ((ImageView) (obj)));
                }
                obj = (ImageView)linearlayout.findViewById(0x7f0c01cb);
                if (bannerInfo.right_image_url != null)
                {
                    ImageLoader.getInstance().displayImage(bannerInfo.right_image_url, ((ImageView) (obj)));
                } else
                {
                    ((ImageView) (obj)).setImageDrawable(getResources().getDrawable(0x7f0200a6));
                }
                obj = (PMTextView)linearlayout.findViewById(0x7f0c01ca);
                ((PMTextView) (obj)).setText(Html.fromHtml(bannerInfo.message));
                if (bannerInfo.text_color != null)
                {
                    i = ((ColorDrawable)(ColorDrawable)getResources().getDrawable(0x7f090040)).getColor();
                    ((PMTextView) (obj)).setTextColor(ColorConverter.getColorValueFromHexString(bannerInfo.text_color, i));
                }
                if (bannerInfo.background_color != null)
                {
                    i = ((ColorDrawable)(ColorDrawable)getResources().getDrawable(0x7f090007)).getColor();
                    linearlayout.setBackgroundColor(ColorConverter.getColorValueFromHexString(bannerInfo.background_color, i));
                }
                linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsFragment this$0;

                    public void onClick(View view)
                    {
                        if (bannerInfo.destination_url != null)
                        {
                            view = Uri.parse(bannerInfo.destination_url);
                            if (DeepLinkUtils.isValidDeepLink(view))
                            {
                                view = DeepLinkUtils.getDeepLinkLaunchInfo(view);
                                if (view != null && ((DeepLinkLaunchInfo) (view)).fragmentClass != null)
                                {
                                    if (bannerInfo.banner_tap_analytics_event != null)
                                    {
                                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", bannerInfo.banner_tap_analytics_event, null);
                                    }
                                    ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(((DeepLinkLaunchInfo) (view)).bundle, ((DeepLinkLaunchInfo) (view)).fragmentClass, ((DeepLinkLaunchInfo) (view)).data);
                                }
                            }
                        }
                    }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
                });
            }
        }
    }

    private void updateListingInfo(LinearLayout linearlayout)
    {
        int i = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 16F);
        linearlayout = (LinearLayout)linearlayout.findViewById(0x7f0c00b6);
        linearlayout.setVisibility(0);
        Object obj = (android.widget.LinearLayout.LayoutParams)linearlayout.getLayoutParams();
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(i, 0, i, 0);
        linearlayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((TextView)linearlayout.findViewById(0x7f0c0130)).setText(listingDetails.getTitle());
        obj = (SearchFilterTextView)linearlayout.findViewById(0x7f0c007d);
        ((SearchFilterTextView) (obj)).setTextSize(2, 10F);
        ((SearchFilterTextView) (obj)).setCategory(listingDetails.getCategoryId());
        ((SearchFilterTextView) (obj)).setSubCategoryList(listingDetails.getSubCategoryList());
        ((SearchFilterTextView) (obj)).setParentScreenNameForAnalytics(viewNameForAnalytics);
        if (listingDetails.isNWT())
        {
            ((SearchFilterTextView) (obj)).setText(getResources().getString(0x7f0601d6));
            ((SearchFilterTextView) (obj)).setVisibility(0);
            ((SearchFilterTextView) (obj)).setNWTConditionFlag(Boolean.valueOf(true));
        } else
        if (listingDetails.isRetail())
        {
            ((SearchFilterTextView) (obj)).setText(getResources().getString(0x7f0601d9).toUpperCase());
            ((SearchFilterTextView) (obj)).setVisibility(0);
            ((SearchFilterTextView) (obj)).setRetailConditionFlag(Boolean.valueOf(true));
        } else
        {
            ((SearchFilterTextView) (obj)).setVisibility(8);
        }
        ((TextView)linearlayout.findViewById(0x7f0c007f)).setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(listingDetails.getPrice())).toString());
        obj = (TextView)linearlayout.findViewById(0x7f0c0080);
        ((TextView) (obj)).setPaintFlags(((TextView) (obj)).getPaintFlags() | 0x10);
        ((TextView) (obj)).setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(listingDetails.getOriginalPrice())).toString());
        obj = (ImageView)linearlayout.findViewById(0x7f0c0132);
        i = ListingUtils.getDrawableIconForCategory(listingDetails.getCategoryId());
        ((ImageView) (obj)).setImageDrawable(getResources().getDrawable(i));
        obj = (SearchFilterTextView)linearlayout.findViewById(0x7f0c0081);
        ((SearchFilterTextView) (obj)).setTextSize(2, 13F);
        ((SearchFilterTextView) (obj)).setText((new StringBuilder()).append(getString(0x7f060281)).append(" ").append(listingDetails.getSize()).toString());
        ((SearchFilterTextView) (obj)).setCategory(listingDetails.getCategoryId());
        ((SearchFilterTextView) (obj)).setSubCategoryList(listingDetails.getSubCategoryList());
        ((SearchFilterTextView) (obj)).setSize(listingDetails.getSize().toString());
        ((SearchFilterTextView) (obj)).setParentScreenNameForAnalytics(viewNameForAnalytics);
        obj = (SearchFilterTextView)linearlayout.findViewById(0x7f0c0134);
        ((SearchFilterTextView) (obj)).setTextSize(2, 13F);
        ((SearchFilterTextView) (obj)).setText(listingDetails.getBrand());
        ((SearchFilterTextView) (obj)).setBrand(listingDetails.getBrand());
        ((SearchFilterTextView) (obj)).setParentScreenNameForAnalytics(viewNameForAnalytics);
        ((TextView)linearlayout.findViewById(0x7f0c0135)).setText(listingDetails.getDescription());
        getResources();
        linearlayout = (LinearLayout)linearlayout.findViewById(0x7f0c0197);
        if (linearlayout != null)
        {
            obj = LayoutInflater.from(getActivity());
            linearlayout.removeAllViewsInLayout();
            List list = listingDetails.getSystemMessages();
            int k = list.size();
            if (k > 0)
            {
                LinearLayout linearlayout1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f03006a, null, false);
                ((TextView)linearlayout1.findViewById(0x7f0c0198)).setVisibility(0);
                linearlayout1.findViewById(0x7f0c0199).setVisibility(0);
                linearlayout.addView(linearlayout1);
            }
            int j = 0;
            while (j < k) 
            {
                LinearLayout linearlayout2 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f03007b, null, false);
                PMListingImageView pmlistingimageview = (PMListingImageView)linearlayout2.findViewById(0x7f0c01da);
                PMListingImageView pmlistingimageview1 = (PMListingImageView)linearlayout2.findViewById(0x7f0c01cb);
                TextView textview = (TextView)linearlayout2.findViewById(0x7f0c01db);
                linearlayout2.setVisibility(0);
                linearlayout.addView(linearlayout2);
                final SystemMessage msg = (SystemMessage)list.get(j);
                pmlistingimageview.loadImage(msg.getImageUrl());
                if (msg.getRightImageUrl() != null && msg.getRightImageUrl().length() > 0)
                {
                    pmlistingimageview1.setVisibility(0);
                    pmlistingimageview1.loadImage(msg.getRightImageUrl());
                } else
                {
                    pmlistingimageview1.setVisibility(8);
                }
                textview.setText(Html.fromHtml(msg.getMessageText()));
                linearlayout2.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListingDetailsFragment this$0;
                    final SystemMessage val$msg;

                    public void onClick(View view)
                    {
                        view = new Bundle();
                        view.putString("URL", msg.getDestinationUrl());
                        ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
                    }

            
            {
                this$0 = ListingDetailsFragment.this;
                msg = systemmessage;
                super();
            }
                });
                j++;
            }
        }
    }

    private void updateListingLikes(LinearLayout linearlayout)
    {
        int i = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 10F);
        View view1 = linearlayout.findViewById(0x7f0c0136);
        if (listingDetails.getLikes().size() == 0)
        {
            if (view1 != null)
            {
                view1.setVisibility(8);
            }
            return;
        }
        View view = view1;
        if (view1 == null)
        {
            view = LayoutInflater.from(getActivity()).inflate(0x7f030076, null);
            linearlayout.addView(view, linearlayout.getChildCount() - 3);
        }
        view.setVisibility(0);
        if (!FeatureManager.getGlobalFeatureManager().isAddToBundleButtonFeatureEnabled())
        {
            linearlayout = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
            linearlayout.setMargins(0, i, 0, 0);
            view.setLayoutParams(linearlayout);
            linearlayout = view.findViewById(0x7f0c01d0);
            if (linearlayout != null)
            {
                linearlayout.setVisibility(0);
            }
        }
        ((PMTextView)view.findViewById(0x7f0c01d2)).setLikesMessage(listingDetails.getLikes(), listingId);
    }

    private void updateView()
    {
        while (getView() == null || !getUserVisibleHint() || listingDetails == null) 
        {
            return;
        }
        LinearLayout linearlayout = (LinearLayout)getView().findViewById(0x7f0c018e);
        linearlayout.setVisibility(0);
        updateListingHeader(linearlayout);
        insertListingImages(linearlayout);
        updateListingInfo(linearlayout);
        updateCategoryAndColorsInfo(linearlayout);
        updateActionButtons(linearlayout);
        updateAddToBundleButton(linearlayout);
        updateListingLikes(linearlayout);
        updateListingFooter();
        setupBottomBar();
    }

    private void viewBundle()
    {
        PMActivity pmactivity = (PMActivity)getActivity();
        if (pmactivity != null && pmactivity.isActivityInForeground())
        {
            Bundle bundle = new Bundle();
            bundle.putString("ID", listingDetails.getUserId());
            PMApi.postGoalTrackingInfo(MetricsTrackingUtils.getTrackingJson(getActivity(), "bnd_add"));
            pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/ViewBundleFragment, null);
        }
    }

    public void addCommentToListing(String s, Comment comment)
    {
        if (isAdded() && listingDetails != null && s.equals(listingDetails.getIdAsString()))
        {
            listingDetails.addComment(comment);
            updateCursorData();
        }
    }

    void addListingToBundle()
    {
        if (!listingDetails.isAvailableForPurchase())
        {
            showAlertMessage("", getString(0x7f060066));
            return;
        } else
        {
            showProgressDialogWithMessage(getString(0x7f060038));
            PMApi.addListingToBundle(listingDetails.getUserId(), listingId, new PMApiResponseHandler() {

                final ListingDetailsFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    hideProgressDialog();
                    if (pmapiresponse.hasError())
                    {
                        if (pmapiresponse.apiError.isAlreadyExistsError())
                        {
                            viewBundle();
                            return;
                        } else
                        {
                            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.ADD_TO_BUNDLE, getString(0x7f0600d3), com.poshmark.ui.model.ActionErrorContext.Severity.LOW));
                            return;
                        }
                    } else
                    {
                        FBDPAHelper.trackAddToCart(listingDetails, FBDPAHelper.PURCHASE_TYPE_BUNDLE);
                        viewBundle();
                        return;
                    }
                }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
            });
            return;
        }
    }

    public void deleteListing()
    {
        showProgressDialogWithMessage(getString(0x7f0600b7));
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "delete_listing", null);
        PMApi.deleteListing(listingId, new PMApiResponseHandler() {

            final ListingDetailsFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        ListingNotificationManager.getListingNotificationManager().fireListingDeletedMessage(listingId);
                        ((PMActivity)getActivity()).onBackPressed();
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.DELETE_LISTING, getString(0x7f0600e2), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
    }

    public void deleteListing(String s)
    {
        if (isAdded() && listingDetails != null && s.equals(listingDetails.getIdAsString()))
        {
            listingNoMore = true;
            updateView();
        }
    }

    public void editListing()
    {
        if (listingDetails.getListingStatus() == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD)
        {
            showAlertMessage("", getString(0x7f06016e));
            return;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("NEW_LISTING", false);
            bundle.putString("ID", listingId);
            bundle.putBoolean("NFS_ENABLED", isEditListingWithNFSEnabled.booleanValue());
            ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingEditorFragment, listingDetails);
            return;
        }
    }

    public String getTrackingLabel()
    {
        return "ld";
    }

    public void handleNotification(Intent intent)
    {
        Bundle bundle = intent.getBundleExtra("RESULT");
        ParcelUuid parceluuid = (ParcelUuid)bundle.getParcelable("PARENT_ID");
        if (intent.getAction().equals("com.poshmark.intents.VIEW_BUNDLE_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "view_bundle_tapped", null);
            PMActivity pmactivity = (PMActivity)getActivity();
            Bundle bundle1 = new Bundle();
            bundle1.putString("ID", listingDetails.getUserId());
            pmactivity.launchFragment(bundle1, com/poshmark/ui/fragments/ViewBundleFragment, null);
        }
        if (intent.getAction().equals("com.poshmark.intents.ADD_TO_BUNDLE_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "add_listing_to_bundle_tapped", null);
            addListingToBundle();
        }
        if (intent.getAction().equals("com.poshmark.intents.REPORT_LISTING_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            reportListing(bundle.getString("REPORT_REASON"));
        }
        if (intent.getAction().equals("com.poshmark.intents.REPORT_LISTING_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            reportListing(bundle.getString("REPORT_REASON"));
        }
        if (intent.getAction().equals("com.poshmark.intents.EDIT_LISTING_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            editListing();
        }
        if (intent.getAction().equals("com.poshmark.intents.NOT_FOR_SALE_LISTING_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            markAsNotForSale();
        }
        if (intent.getAction().equals("com.poshmark.intents.MAKE_AVAILABLE_LISTING_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            markForSale();
        }
        if (intent.getAction().equals("com.poshmark.intents.DELETE_LISTING_ACTION") && fragmentId.equals(parceluuid.getUuid()))
        {
            deleteListing();
        }
    }

    public void likeListing(String s, boolean flag)
    {
        if (isAdded() && listingDetails != null && s.equals(listingDetails.getIdAsString()))
        {
            listingDetails.setListingLikeStatus(flag);
            setLikeButtonState((ImageView)getView().findViewById(0x7f0c004e), flag);
            setActionBarLikeButtonState(flag);
            break MISSING_BLOCK_LABEL_59;
        }
        do
        {
            return;
        } while (getView() == null || !getUserVisibleHint() || listingDetails == null);
        s = (LinearLayout)getView().findViewById(0x7f0c018e);
        s.setVisibility(0);
        updateListingLikes(s);
    }

    public void markAsNotForSale()
    {
        PMApi.updateListingStatus(listingId, NOT_FOR_SALE.toLowerCase(), new PMApiResponseHandler() {

            final ListingDetailsFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(listingId);
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_LISTING, getString(0x7f0600e5)));
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
        setTitle(0x7f06016c);
    }

    public void markForSale()
    {
        PMApi.updateListingStatus(listingId, AVAILABLE.toLowerCase(), new PMApiResponseHandler() {

            final ListingDetailsFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(listingId);
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_LISTING, getString(0x7f0600e5)));
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
    }

    public void newListingCreated()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupListItemClickListener();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        listingId = getArguments().getString("ID");
        bannerJson = getArguments().getString("banner_json", null);
        if (bannerJson == null) goto _L2; else goto _L1
_L1:
        bundle = (new GsonBuilder()).create();
        String s = bannerJson;
        if (bundle instanceof Gson) goto _L4; else goto _L3
_L3:
        bundle = ((Bundle) (bundle.fromJson(s, com/poshmark/data_model/models/BannerInfo)));
_L5:
        bannerInfo = (BannerInfo)bundle;
_L2:
        adapter = new ListingDetailsAdapter(getActivity(), this, null, 0x80000000);
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
        fragmentType = PMFragment.FRAGMENT_TYPE.HAS_DRAWER;
        isEditListingWithNFSEnabled = Boolean.valueOf(FeatureManager.getGlobalFeatureManager().isEditListingWithNFSEnable());
        NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.LISTING_DETAILS);
        return;
_L4:
        bundle = ((Bundle) (GsonInstrumentation.fromJson((Gson)bundle, s, com/poshmark/data_model/models/BannerInfo)));
          goto _L5
        bundle;
          goto _L2
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        setTitle(0x7f06016c);
        layoutinflater = layoutinflater.inflate(0x7f030061, viewgroup, false);
        createAllViews(layoutinflater);
        return layoutinflater;
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (listingNoMore)
        {
            ((PMActivity)getActivity()).onBackPressed();
        } else
        if (listingDetails == null)
        {
            fetchListingDetails();
        } else
        {
            setupActionBarNextActionButton();
            updateView();
        }
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.VIEW_BUNDLE_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.ADD_TO_BUNDLE_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.REPORT_LISTING_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.EDIT_LISTING_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.NOT_FOR_SALE_LISTING_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.MAKE_AVAILABLE_LISTING_ACTION", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.DELETE_LISTING_ACTION", this);
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onStop()
    {
        super.onStop();
        for (Iterator iterator = listingImages.iterator(); iterator.hasNext(); ((PMListingImageView)iterator.next()).releaseInternalBitmap()) { }
    }

    public void replyToComment(String s)
    {
        PMActivity pmactivity = (PMActivity)getView().getContext();
        Bundle bundle = new Bundle();
        bundle.putString("ID", listingId);
        if (!s.equalsIgnoreCase(PMApplicationSession.GetPMSession().getUserName()))
        {
            bundle.putString("REPLY_TO_HANDLE", (new StringBuilder()).append("@").append(s).toString());
        }
        pmactivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingDetails);
    }

    public void reportListing(String s)
    {
        showProgressDialogWithMessage("Reporting...");
        PMApi.reportListing(listingId, s, new PMApiResponseHandler() {

            final ListingDetailsFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "report_listing", listingId);
                        showAutoHideSuccessMessage(getString(0x7f060228));
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.REPORT_LISTING, getString(0x7f0600f6)));
            }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
        });
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listing_details_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar(0x7f030004);
        setTitle(0x7f06016d);
    }

    public void showPopupMenu(View view)
    {
        ListingDetailsMenuPopup listingdetailsmenupopup = new ListingDetailsMenuPopup();
        listingdetailsmenupopup.setup(listingDetails, this);
        listingdetailsmenupopup.showPopup(view);
    }

    public void updateListing(ListingDetails listingdetails)
    {
        if (listingDetails != null && listingdetails.getIdAsString().equals(listingDetails.getIdAsString()))
        {
            listingDetails = listingdetails;
            if (isAdded())
            {
                updateCursorData();
                updateView();
                if (drawerFragment != null)
                {
                    drawerFragment.updateDrawer(true);
                }
            }
        }
    }







}
