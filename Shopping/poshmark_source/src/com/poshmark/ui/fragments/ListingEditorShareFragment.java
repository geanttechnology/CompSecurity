// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.fb_tmblr_twitter.FBPermissionStates;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApiError;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.ListingManager;
import com.poshmark.utils.ObjectPickupDropOff;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.view_holders.PinterestDialog;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PartyGuidelinesFragment

public class ListingEditorShareFragment extends PMFragment
    implements PMNotificationListener
{

    com.poshmark.data_model.models.ShareBannerInfo.BannnerResponse bannerResponse;
    android.view.View.OnClickListener doFacebookConnect;
    android.view.View.OnClickListener doPinterestConnect;
    android.view.View.OnClickListener doTumblrConnect;
    android.view.View.OnClickListener doTwitterConnect;
    private RelativeLayout fbShareLayout;
    android.widget.CompoundButton.OnCheckedChangeListener fbSwitchToggled;
    boolean isPinterestButtonEnabled;
    boolean isPinterestDialogShowable;
    private ListingManager listingManager;
    private RelativeLayout pinShareLayout;
    android.widget.CompoundButton.OnCheckedChangeListener pinterestSwitchToggled;
    private String shareBanner;
    ImageView share_banner_image;
    boolean showBanner;
    android.widget.CompoundButton.OnCheckedChangeListener tmSwitchToggled;
    private RelativeLayout tumblrShareLayout;
    android.widget.CompoundButton.OnCheckedChangeListener twSwitchToggled;
    private RelativeLayout twitterShareLayout;

    public ListingEditorShareFragment()
    {
        shareBanner = null;
        showBanner = false;
        doPinterestConnect = new android.view.View.OnClickListener() {

            final ListingEditorShareFragment this$0;

            public void onClick(View view)
            {
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                share_banner_image.setVisibility(8);
                showBanner = false;
                Analytics.getInstance().trackEvent(getViewNameForAnalytics(), "user", "connect_pinterest_initiated", PMApplicationSession.GetPMSession().getUserId());
                ExtServiceConnectManager.getGlobalConnectManager().pinterestLink(ListingEditorShareFragment.this);
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
        doFacebookConnect = new android.view.View.OnClickListener() {

            final ListingEditorShareFragment this$0;

            public void onClick(View view)
            {
                FbHelper.getInstance().link(ListingEditorShareFragment.this, 8, 8, FbHelper.FB_CONNECT_READ_REQUEST);
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
        doTwitterConnect = new android.view.View.OnClickListener() {

            final ListingEditorShareFragment this$0;

            public void onClick(View view)
            {
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                ExtServiceConnectManager.getGlobalConnectManager().twitterLink(ListingEditorShareFragment.this, new ExtServiceConnectInterface() {

                    final _cls4 this$1;

                    public void error(PMApiError pmapierror)
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_TWITTER));
                        }
                    }

                    public void success(int i, Bundle bundle)
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            twitterLoginComplete(bundle);
                        }
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
        doTumblrConnect = new android.view.View.OnClickListener() {

            final ListingEditorShareFragment this$0;

            public void onClick(View view)
            {
                showProgressDialogWithMessage(getResources().getString(0x7f060190));
                ExtServiceConnectManager.getGlobalConnectManager().tumblrLink(ListingEditorShareFragment.this, new ExtServiceConnectInterface() {

                    final _cls5 this$1;

                    public void error(PMApiError pmapierror)
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_TUMBLR));
                        }
                    }

                    public void success(int i, Bundle bundle)
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            tumblrLoginComplete(bundle);
                        }
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
        pinterestSwitchToggled = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ListingEditorShareFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                PMApplicationSession.GetPMSession().setPinterestSharingFlag(Boolean.valueOf(flag));
                listingManager.setPinterestShareFlag(flag);
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
        fbSwitchToggled = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ListingEditorShareFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.PUBLISH_PERMISSION))
                {
                    PMApplicationSession.GetPMSession().setFacebookSharingFlag(Boolean.valueOf(flag));
                    listingManager.setFacebookShareFlag(flag);
                } else
                if (flag)
                {
                    FbHelper.getInstance().link(ListingEditorShareFragment.this, 8, 8, FbHelper.FB_CONNECT_PUBLISH_REQUEST);
                    return;
                }
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
        twSwitchToggled = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ListingEditorShareFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                PMApplicationSession.GetPMSession().setTwitterSharingFlag(Boolean.valueOf(flag));
                listingManager.setTwitterShareFlag(flag);
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
        tmSwitchToggled = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ListingEditorShareFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                PMApplicationSession.GetPMSession().setTumblrSharingFlag(Boolean.valueOf(flag));
                listingManager.setTumblrShareFlag(flag);
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
        };
    }

    private void pinterestLoginComplete()
    {
        TextView textview = (TextView)pinShareLayout.findViewById(0x7f0c01bd);
        Switch switch1 = (Switch)pinShareLayout.findViewById(0x7f0c01bc);
        ImageView imageview = (ImageView)pinShareLayout.findViewById(0x7f0c01be);
        switch1.setVisibility(0);
        textview.setVisibility(8);
        imageview.setVisibility(8);
        pinShareLayout.setOnClickListener(null);
        switch1.setChecked(true);
        listingManager.setPinterestShareFlag(true);
        if (isPinterestDialogShowable && !PMApplicationSession.GetPMSession().isPinterestPostDialogShown())
        {
            PMApplicationSession.GetPMSession().setPinterestPostDialogShown(Boolean.valueOf(true));
            showPinterestSuccessConnectDialog();
        }
    }

    private void setupActionBarNextActionButton()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f060166).toUpperCase());
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final ListingEditorShareFragment this$0;

                public void onClick(View view)
                {
                    if (listingManager != null)
                    {
                        listingManager.postListing(ListingEditorShareFragment.this);
                    }
                }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupFacebookOptionView(LinearLayout linearlayout)
    {
        Switch switch1;
        ImageView imageview;
        boolean flag1;
label0:
        {
            fbShareLayout = (RelativeLayout)linearlayout.findViewById(0x7f0c01b7);
            int i = fbShareLayout.getPaddingTop();
            fbShareLayout.setPadding(i, i, i, i);
            ((TextView)fbShareLayout.findViewById(0x7f0c01ba)).setText(0x7f060108);
            linearlayout = (TextView)fbShareLayout.findViewById(0x7f0c01bd);
            switch1 = (Switch)fbShareLayout.findViewById(0x7f0c01bc);
            switch1.setOnCheckedChangeListener(fbSwitchToggled);
            imageview = (ImageView)fbShareLayout.findViewById(0x7f0c01be);
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                boolean flag = FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.READ_PERMISSION);
                flag1 = FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.PUBLISH_PERMISSION);
                if (flag)
                {
                    break label0;
                }
                switch1.setVisibility(8);
                linearlayout.setVisibility(0);
                imageview.setVisibility(0);
                fbShareLayout.setOnClickListener(doFacebookConnect);
            }
            return;
        }
        linearlayout.setVisibility(8);
        imageview.setVisibility(8);
        switch1.setVisibility(0);
        if (flag1)
        {
            switch1.setChecked(PMApplicationSession.GetPMSession().getFacebookSharingFlag().booleanValue());
            return;
        } else
        {
            switch1.setChecked(false);
            return;
        }
    }

    private void setupPartiesShareOptions(List list, LinearLayout linearlayout)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        linearlayout = (LinearLayout)linearlayout.findViewById(0x7f0c01b4);
        linearlayout.removeAllViews();
        int i = 0;
        while (i < list.size()) 
        {
            PartyEvent partyevent = (PartyEvent)list.get(i);
            String s = partyevent.getId();
            RelativeLayout relativelayout = (RelativeLayout)layoutinflater.inflate(0x7f03006f, null);
            Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            int j = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 30F);
            if (i == 0 && list.size() == 1)
            {
                relativelayout.setBackgroundDrawable(getResources().getDrawable(0x7f020023));
                ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, j, 0, 0);
            } else
            if (i == 0)
            {
                relativelayout.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
                ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, j, 0, 0);
            } else
            if (i == list.size() - 1)
            {
                relativelayout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
            } else
            {
                relativelayout.setBackgroundDrawable(getResources().getDrawable(0x7f020022));
            }
            relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = (TextView)relativelayout.findViewById(0x7f0c01ba);
            ((TextView) (obj)).setPadding(j / 3, j / 3, j / 3, j / 3);
            ((TextView) (obj)).setText(partyevent.getTitle());
            obj = (Switch)relativelayout.findViewById(0x7f0c01bc);
            ((Switch) (obj)).setPadding(j / 3, j / 3, j / 3, j / 3);
            ((Switch) (obj)).setTag(s);
            if (partyevent.isListingEligibleForParty(listingManager.getNewListing()))
            {
                ((Switch) (obj)).setChecked(true);
                listingManager.addEventId(s);
            } else
            {
                ((Switch) (obj)).setChecked(false);
            }
            ((Switch) (obj)).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final ListingEditorShareFragment this$0;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    String s1;
label0:
                    {
label1:
                        {
                            compoundbutton = (Switch)compoundbutton;
                            s1 = (String)compoundbutton.getTag();
                            Object obj1 = GlobalPartiesController.getGlobalPartiesController();
                            List list1 = ((GlobalPartiesController) (obj1)).getCurrentParties();
                            if (!compoundbutton.isChecked())
                            {
                                break label0;
                            }
                            if (list1 != null && list1.size() > 0)
                            {
                                obj1 = ((GlobalPartiesController) (obj1)).getParty(s1);
                                if (((PartyEvent) (obj1)).isListingEligibleForParty(listingManager.getNewListing()))
                                {
                                    break label1;
                                }
                                String s2 = String.format(new String(getString(0x7f060149)), new Object[] {
                                    ((PartyEvent) (obj1)).getTitle()
                                });
                                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
                                builder.setIcon(0x1080027);
                                builder.setTitle(getString(0x7f0600d0));
                                builder.setMessage(s2);
                                builder.setPositiveButton(getString(0x7f0602be), ((_cls1) (obj1)). new android.content.DialogInterface.OnClickListener() {

                                    final _cls10 this$1;
                                    final PartyEvent val$partyEvent;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, partyEvent);
                                    }

            
            {
                this$1 = final__pcls10;
                partyEvent = PartyEvent.this;
                super();
            }
                                });
                                builder.setNegativeButton(getString(0x7f0601e1), compoundbutton. new android.content.DialogInterface.OnClickListener() {

                                    final _cls10 this$1;
                                    final Switch val$partySwitch;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        partySwitch.setChecked(false);
                                    }

            
            {
                this$1 = final__pcls10;
                partySwitch = Switch.this;
                super();
            }
                                });
                                builder.show();
                                compoundbutton.performClick();
                                compoundbutton.setChecked(false);
                                listingManager.removeEventId(s1);
                            }
                            return;
                        }
                        listingManager.addEventId(s1);
                        return;
                    }
                    listingManager.removeEventId(s1);
                }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
            });
            linearlayout.addView(relativelayout, i);
            i++;
        }
    }

    private void setupPinterestOptionView(LinearLayout linearlayout)
    {
        pinShareLayout = (RelativeLayout)linearlayout.findViewById(0x7f0c01b6);
        if (!isPinterestButtonEnabled)
        {
            pinShareLayout.setVisibility(8);
        } else
        {
            int i = pinShareLayout.getPaddingTop();
            pinShareLayout.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
            pinShareLayout.setPadding(i, i, i, i);
            ((TextView)pinShareLayout.findViewById(0x7f0c01ba)).setText(0x7f060203);
            linearlayout = (TextView)pinShareLayout.findViewById(0x7f0c01bd);
            Switch switch1 = (Switch)pinShareLayout.findViewById(0x7f0c01bc);
            switch1.setOnCheckedChangeListener(pinterestSwitchToggled);
            ImageView imageview = (ImageView)pinShareLayout.findViewById(0x7f0c01be);
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                if (PMApplicationSession.GetPMSession().getPinterestToken() == null)
                {
                    switch1.setVisibility(8);
                    linearlayout.setVisibility(0);
                    imageview.setVisibility(0);
                    pinShareLayout.setOnClickListener(doPinterestConnect);
                    return;
                } else
                {
                    linearlayout.setVisibility(8);
                    imageview.setVisibility(8);
                    switch1.setVisibility(0);
                    switch1.setChecked(PMApplicationSession.GetPMSession().getPinterestSharingFlag().booleanValue());
                    return;
                }
            }
        }
    }

    private void setupShareBanner(View view)
    {
        if (showBanner && bannerResponse != null && bannerResponse.data != null && bannerResponse.data.image_url != null)
        {
            int i = Color.parseColor(bannerResponse.data.bg_color);
            if (bannerResponse.data.image_url != null && bannerResponse.data.image_url.length() > 0)
            {
                share_banner_image.setBackgroundColor(i);
                ImageLoader.getInstance().displayImage(bannerResponse.data.image_url, share_banner_image);
            }
            return;
        } else
        {
            share_banner_image.setVisibility(8);
            return;
        }
    }

    private void setupTopBorder(View view)
    {
        view = (LinearLayout)view.findViewById(0x7f0c01b5);
        int i = 0;
        do
        {
label0:
            {
                if (i < view.getChildCount())
                {
                    View view1 = view.getChildAt(i);
                    if (view1.getVisibility() != 0)
                    {
                        break label0;
                    }
                    i = view1.getPaddingTop();
                    view1.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
                    view1.setPadding(i, i, i, i);
                }
                return;
            }
            i++;
        } while (true);
    }

    private void setupTumblrOptionView(LinearLayout linearlayout)
    {
        Switch switch1;
        ImageView imageview;
label0:
        {
            tumblrShareLayout = (RelativeLayout)linearlayout.findViewById(0x7f0c01b9);
            int i = tumblrShareLayout.getPaddingTop();
            tumblrShareLayout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
            tumblrShareLayout.setPadding(i, i, i, i);
            ((TextView)tumblrShareLayout.findViewById(0x7f0c01ba)).setText(0x7f06029e);
            linearlayout = (TextView)tumblrShareLayout.findViewById(0x7f0c01bd);
            switch1 = (Switch)tumblrShareLayout.findViewById(0x7f0c01bc);
            switch1.setOnCheckedChangeListener(tmSwitchToggled);
            imageview = (ImageView)tumblrShareLayout.findViewById(0x7f0c01be);
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                if (PMApplicationSession.GetPMSession().getTumblrToken() != null)
                {
                    break label0;
                }
                switch1.setVisibility(8);
                linearlayout.setVisibility(0);
                imageview.setVisibility(0);
                tumblrShareLayout.setOnClickListener(doTumblrConnect);
            }
            return;
        }
        switch1.setVisibility(0);
        switch1.setChecked(PMApplicationSession.GetPMSession().getTumblrSharingFlag().booleanValue());
        linearlayout.setVisibility(8);
        imageview.setVisibility(8);
    }

    private void setupTwitterOptionView(LinearLayout linearlayout)
    {
        Switch switch1;
        ImageView imageview;
label0:
        {
            twitterShareLayout = (RelativeLayout)linearlayout.findViewById(0x7f0c01b8);
            ((TextView)twitterShareLayout.findViewById(0x7f0c01ba)).setText(0x7f0602a0);
            linearlayout = (TextView)twitterShareLayout.findViewById(0x7f0c01bd);
            switch1 = (Switch)twitterShareLayout.findViewById(0x7f0c01bc);
            switch1.setOnCheckedChangeListener(twSwitchToggled);
            imageview = (ImageView)twitterShareLayout.findViewById(0x7f0c01be);
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                if (PMApplicationSession.GetPMSession().getTwitterToken() != null)
                {
                    break label0;
                }
                switch1.setVisibility(8);
                linearlayout.setVisibility(0);
                imageview.setVisibility(0);
                twitterShareLayout.setOnClickListener(doTwitterConnect);
            }
            return;
        }
        switch1.setVisibility(0);
        switch1.setChecked(PMApplicationSession.GetPMSession().getTwitterSharingFlag().booleanValue());
        linearlayout.setVisibility(8);
        imageview.setVisibility(8);
    }

    private void setupView(View view)
    {
        LinearLayout linearlayout = (LinearLayout)view;
        setupPinterestOptionView(linearlayout);
        setupFacebookOptionView(linearlayout);
        setupTwitterOptionView(linearlayout);
        setupTumblrOptionView(linearlayout);
        List list = GlobalPartiesController.getGlobalPartiesController().getCurrentParties();
        if (list != null && list.size() > 0)
        {
            setupPartiesShareOptions(list, linearlayout);
        }
        setupTopBorder(view);
    }

    private void showPinterestSuccessConnectDialog()
    {
        final PinterestDialog dialog = new PinterestDialog();
        Analytics.getInstance().trackView("post_connect_pinterest_dlg_screen");
        dialog.setCurrent_mode(com.poshmark.utils.view_holders.PinterestDialog.PINTEREST_DIALOG_MODE.POST_CONN);
        dialog.setClickListener(new android.view.View.OnClickListener() {

            final ListingEditorShareFragment this$0;
            final PinterestDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = ListingEditorShareFragment.this;
                dialog = pinterestdialog;
                super();
            }
        });
        dialog.show(getFragmentManager(), "pin");
        PMApplicationSession.GetPMSession().setPinterestPostDialogShown(Boolean.valueOf(true));
        PMApplicationSession.GetPMSession().setPinterestPreDialogShownFlag(Boolean.valueOf(true));
    }

    public void fbLoginComplete(int i)
    {
        if ((i & 1) != 0)
        {
            TextView textview = (TextView)fbShareLayout.findViewById(0x7f0c01bd);
            Switch switch1 = (Switch)fbShareLayout.findViewById(0x7f0c01bc);
            ImageView imageview = (ImageView)fbShareLayout.findViewById(0x7f0c01be);
            switch1.setVisibility(0);
            textview.setVisibility(8);
            imageview.setVisibility(8);
            if ((i & 8) != 0)
            {
                switch1.setChecked(PMApplicationSession.GetPMSession().getFacebookSharingFlag().booleanValue());
            } else
            {
                switch1.setChecked(false);
            }
            fbShareLayout.setOnClickListener(null);
            switch1.setChecked(true);
            listingManager.setFacebookShareFlag(true);
        }
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED") && isAdded())
        {
            intent = getView();
            if (intent != null && intent.findViewById(0x7f0c01b2) != null)
            {
                setupView(intent);
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupActionBarNextActionButton();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (FacebookSdk.isFacebookRequestCode(i))
        {
            FbHelper.getInstance().getCallbackManager().onActivityResult(i, j, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED", this);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        ParcelUuid parceluuid = (ParcelUuid)bundle.getParcelable("LISTING_MANAGER_PICKUP_KEY");
        if (parceluuid != null)
        {
            listingManager = (ListingManager)ObjectPickupDropOff.pickupDataObject(parceluuid.getUuid());
        }
        showBanner = bundle.getBoolean("show_banner");
_L4:
        isPinterestDialogShowable = FeatureManager.getGlobalFeatureManager().isPinterestConnectionDialogShowable();
        isPinterestButtonEnabled = FeatureManager.getGlobalFeatureManager().isPinterestButtonEnabled();
        return;
_L2:
        listingManager = (ListingManager)getFragmentDataOfType(com/poshmark/utils/ListingManager);
        shareBanner = getArguments().getString("share_banner", null);
        if (shareBanner != null)
        {
            showBanner = true;
            bundle = new Gson();
            String s = shareBanner;
            if (!(bundle instanceof Gson))
            {
                bundle = ((Bundle) (bundle.fromJson(s, com/poshmark/data_model/models/ShareBannerInfo$BannnerResponse)));
            } else
            {
                bundle = ((Bundle) (GsonInstrumentation.fromJson((Gson)bundle, s, com/poshmark/data_model/models/ShareBannerInfo$BannnerResponse)));
            }
            bannerResponse = (com.poshmark.data_model.models.ShareBannerInfo.BannnerResponse)bundle;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03006e, viewgroup, false);
        share_banner_image = (ImageView)layoutinflater.findViewById(0x7f0c01b3);
        setupView(layoutinflater);
        setupShareBanner(layoutinflater);
        return layoutinflater;
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        if (i != 2) goto _L2; else goto _L1
_L1:
        listingManager.handleValidationResult(bundle);
_L4:
        return;
_L2:
        if (i != FbHelper.FB_CONNECT_READ_REQUEST)
        {
            break; /* Loop/switch isn't completed */
        }
        if (bundle != null)
        {
            if (!bundle.getBoolean("HAS_ERROR", false))
            {
                fbLoginComplete(bundle.getInt("ACCESS_LEVEL", 0));
                return;
            }
            bundle = bundle.getString("ERROR_JSON");
            if (bundle != null)
            {
                FbHelper.showFBLinkError(PMApiError.deserialize(bundle), this);
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i != FbHelper.FB_CONNECT_PUBLISH_REQUEST)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (bundle == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (bundle.getBoolean("HAS_ERROR", false))
        {
            break; /* Loop/switch isn't completed */
        }
        bundle = getView();
        if (bundle != null)
        {
            bundle = bundle.findViewById(0x7f0c01b2);
            if (bundle != null)
            {
                setupFacebookOptionView((LinearLayout)bundle);
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
        bundle = bundle.getString("ERROR_JSON");
        if (bundle != null)
        {
            FbHelper.showFBLinkError(PMApiError.deserialize(bundle), this);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (i != 8772) goto _L4; else goto _L6
_L6:
        share_banner_image.setVisibility(8);
        if (bundle != null)
        {
            if (bundle.getBoolean("HAS_ERROR"))
            {
                Analytics.getInstance().trackEvent(getViewNameForAnalytics(), "user", "connect_pinterest_failed", PMApplicationSession.GetPMSession().getUserId());
                showAutoHideProgressDialogWithMessage(getString(0x7f06022e));
                return;
            } else
            {
                Analytics.getInstance().trackEvent(getViewNameForAnalytics(), "user", "connect_pinterest_complete", PMApplicationSession.GetPMSession().getUserId());
                hideProgressDialog();
                pinterestLoginComplete();
                return;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (listingManager != null)
        {
            java.util.UUID uuid = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(uuid, listingManager);
            bundle.putParcelable("LISTING_MANAGER_PICKUP_KEY", new ParcelUuid(uuid));
        }
        bundle.putBoolean("show_banner", showBanner);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listing_confirmation_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setupActionBarNextActionButton();
        setTitle(0x7f060253);
    }

    public void tumblrLoginComplete(Bundle bundle)
    {
        bundle = (TextView)tumblrShareLayout.findViewById(0x7f0c01bd);
        Switch switch1 = (Switch)tumblrShareLayout.findViewById(0x7f0c01bc);
        ImageView imageview = (ImageView)tumblrShareLayout.findViewById(0x7f0c01be);
        switch1.setVisibility(0);
        bundle.setVisibility(8);
        imageview.setVisibility(8);
        tumblrShareLayout.setOnClickListener(null);
        switch1.setChecked(true);
        listingManager.setTumblrShareFlag(true);
    }

    public void twitterLoginComplete(Bundle bundle)
    {
        bundle = (TextView)twitterShareLayout.findViewById(0x7f0c01bd);
        Switch switch1 = (Switch)twitterShareLayout.findViewById(0x7f0c01bc);
        ImageView imageview = (ImageView)twitterShareLayout.findViewById(0x7f0c01be);
        switch1.setVisibility(0);
        bundle.setVisibility(8);
        imageview.setVisibility(8);
        twitterShareLayout.setOnClickListener(null);
        switch1.setChecked(true);
        listingManager.setTwitterShareFlag(true);
    }

}
