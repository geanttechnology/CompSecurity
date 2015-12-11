// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.fb_tmblr_twitter.FBPermissionStates;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.view_holders.PinterestDialog;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PinterestBoardSettingsFragment

public class SharingSettingsFragment extends PMFragment
    implements PMNotificationListener
{

    private String FB;
    private String PN;
    private String TM;
    private String TW;
    private boolean autoLaunchServiceConnect;
    android.view.View.OnClickListener fbShareClickListener;
    private RelativeLayout fbShareLayout;
    private RelativeLayout gPlusShareLayout;
    android.view.View.OnClickListener googlePlusShareClickListener;
    boolean isPinterestButtonEnabled;
    private String launchConnectServiceId;
    android.view.View.OnClickListener pinterestShareClickListener;
    private RelativeLayout pinterestShareLayout;
    android.widget.CompoundButton.OnCheckedChangeListener searchIndexListener;
    private Switch searchIndexSwitch;
    com.poshmark.user.UserInfoDetails.Settings settingsData;
    android.view.View.OnClickListener shareToFbTimelineClickListener;
    android.widget.CompoundButton.OnCheckedChangeListener shareToFbTimelineListener;
    private Switch timelineOptionSwitch;
    android.view.View.OnClickListener tmShareClickListener;
    private RelativeLayout tumblrShareLayout;
    android.view.View.OnClickListener twShareClickListener;
    private RelativeLayout twitterShareLayout;

    public SharingSettingsFragment()
    {
        autoLaunchServiceConnect = false;
        FB = "fb";
        TW = "tw";
        TM = "tm";
        PN = "pn";
        isPinterestButtonEnabled = false;
        fbShareClickListener = new android.view.View.OnClickListener() {

            final SharingSettingsFragment this$0;

            public void onClick(View view)
            {
                if (PMApplicationSession.GetPMSession().getFacebookToken() != null)
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setTitle((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
                    view.setMessage(String.format(getString(0x7f0602a8), new Object[] {
                        PMApplicationSession.GetPMSession().getTwitterUsername()
                    }));
                    view.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.setPositiveButton(0x7f0602a6, new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            PMApi.unlinkExternalService("fb", null);
                            PMApi.postFacebookTimelineFlag(false, null);
                            PMApplicationSession.GetPMSession().clearFacebookInfo();
                            FbHelper.getInstance().logout();
                            updateFBShareLayout();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.create().show();
                    return;
                } else
                {
                    FbHelper.getInstance().link(SharingSettingsFragment.this, 8, 8, FbHelper.FB_CONNECT_PUBLISH_REQUEST);
                    return;
                }
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
        pinterestShareClickListener = new android.view.View.OnClickListener() {

            final SharingSettingsFragment this$0;

            public void onClick(View view)
            {
                if (PMApplicationSession.GetPMSession().getPinterestToken() != null)
                {
                    getParentActivity().launchFragment(null, com/poshmark/ui/fragments/PinterestBoardSettingsFragment, null);
                    return;
                } else
                {
                    connectToPinterest();
                    return;
                }
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
        twShareClickListener = new android.view.View.OnClickListener() {

            final SharingSettingsFragment this$0;

            public void onClick(View view)
            {
                if (PMApplicationSession.GetPMSession().getTwitterToken() != null)
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setTitle((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
                    view.setMessage(String.format(getString(0x7f0602ac), new Object[] {
                        PMApplicationSession.GetPMSession().getTwitterUsername()
                    }));
                    view.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    view.setPositiveButton(0x7f0602a6, new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            PMApi.unlinkExternalService("tw", null);
                            PMApplicationSession.GetPMSession().clearTwitterInfo();
                            updateTwitterShareLayout();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    view.create().show();
                    return;
                } else
                {
                    showProgressDialogWithMessage(getString(0x7f060190));
                    ExtServiceConnectManager.getGlobalConnectManager().twitterLink(SharingSettingsFragment.this, new ExtServiceConnectInterface() {

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
                                updateTwitterShareLayout();
                            }
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
        tmShareClickListener = new android.view.View.OnClickListener() {

            final SharingSettingsFragment this$0;

            public void onClick(View view)
            {
                if (PMApplicationSession.GetPMSession().getTumblrToken() != null)
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setTitle((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
                    view.setMessage(String.format(getString(0x7f0602ab), new Object[] {
                        PMApplicationSession.GetPMSession().getTumblrUsername()
                    }));
                    view.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.setPositiveButton(0x7f0602a6, new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            PMApi.unlinkExternalService("tm", null);
                            PMApplicationSession.GetPMSession().clearTumblrInfo();
                            updateTumblrShareLayout();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.create().show();
                    return;
                } else
                {
                    showProgressDialogWithMessage(getString(0x7f060190));
                    ExtServiceConnectManager.getGlobalConnectManager().tumblrLink(SharingSettingsFragment.this, new ExtServiceConnectInterface() {

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
                                updateTumblrShareLayout();
                            }
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
        googlePlusShareClickListener = new android.view.View.OnClickListener() {

            final SharingSettingsFragment this$0;

            public void onClick(View view)
            {
                if (PMApplicationSession.GetPMSession().getGoogleToken() != null)
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setTitle((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
                    view.setMessage(getString(0x7f0602a9));
                    view.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.setPositiveButton(0x7f0602a6, new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            showProgressDialogWithMessage(getString(0x7f0602ad));
                            PMApi.unlinkExternalService("gp", new PMApiResponseHandler() {

                                final _cls2 this$2;

                                public void handleResponse(PMApiResponse pmapiresponse)
                                {
                                    hideProgressDialog();
                                    if (!pmapiresponse.hasError())
                                    {
                                        PMApplicationSession.GetPMSession().clearGoogleInfo();
                                        updateGoogleShareLayout();
                                    }
                                }

            
            {
                this$2 = _cls2.this;
                super();
            }
                            });
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.create().show();
                    return;
                } else
                {
                    showProgressDialogWithMessage(getString(0x7f060190));
                    ExtServiceConnectManager.getGlobalConnectManager().tumblrLink(SharingSettingsFragment.this, new ExtServiceConnectInterface() {

                        final _cls6 this$1;

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
                                updateTumblrShareLayout();
                            }
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
        searchIndexListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SharingSettingsFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "update_search_visibility_setting", PMApplicationSession.GetPMSession().getUserId());
                setSearchSettings(flag);
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
        shareToFbTimelineClickListener = new android.view.View.OnClickListener() {

            final SharingSettingsFragment this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
        shareToFbTimelineListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SharingSettingsFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    compoundbutton = (new StringBuilder()).append("fbsettings/").append("on").toString();
                    if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.PUBLISH_PERMISSION))
                    {
                        PMApplicationSession.GetPMSession().setFacebookPostToTimelineFlag(true);
                        PMApi.postFacebookTimelineFlag(true, null);
                    } else
                    {
                        FbHelper.getInstance().link(SharingSettingsFragment.this, 8, 8, FbHelper.FB_CONNECT_AUTO_TIMELINE_REQUEST);
                    }
                } else
                {
                    PMApplicationSession.GetPMSession().setFacebookPostToTimelineFlag(false);
                    PMApi.postFacebookTimelineFlag(false, null);
                    compoundbutton = (new StringBuilder()).append("fbsettings/").append("off").toString();
                }
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "timeline_toggled", compoundbutton);
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        };
    }

    private void autoLaunchServiceConnect()
    {
        while (launchConnectServiceId.equals(FB) || launchConnectServiceId.equals(TW) || launchConnectServiceId.equals(TM) || !launchConnectServiceId.equals(PN) || PMApplicationSession.GetPMSession().getPinterestToken() != null) 
        {
            return;
        }
        autoLaunchServiceConnect = false;
        connectToPinterest();
    }

    private void connectToPinterest()
    {
        Analytics.getInstance().trackEvent(getViewNameForAnalytics(), "user", "connect_pinterest_initiated", PMApplicationSession.GetPMSession().getUserId());
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        ExtServiceConnectManager.getGlobalConnectManager().pinterestLink(this);
    }

    private void handleChangeSettingsResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError())
        {
            return;
        } else
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_USER_PROFILE, getString(0x7f060101)));
            return;
        }
    }

    private void pinterestConnectFinish()
    {
        final PinterestDialog dialog = new PinterestDialog();
        Analytics.getInstance().trackView("post_connect_pinterest_dlg_screen");
        dialog.setCurrent_mode(com.poshmark.utils.view_holders.PinterestDialog.PINTEREST_DIALOG_MODE.POST_CONN);
        dialog.setClickListener(new android.view.View.OnClickListener() {

            final SharingSettingsFragment this$0;
            final PinterestDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                dialog = pinterestdialog;
                super();
            }
        });
        dialog.show(getFragmentManager(), "pin");
        PMApplicationSession.GetPMSession().setPinterestPostDialogShown(Boolean.valueOf(true));
        PMApplicationSession.GetPMSession().setPinterestPreDialogShownFlag(Boolean.valueOf(true));
        setupView(getView());
    }

    private void setFacebookPostToTimelineSettings(boolean flag)
    {
        PMApplicationSession.GetPMSession().setFacebookPostToTimelineFlag(flag);
        PMApi.postFacebookTimelineFlag(flag, new PMApiResponseHandler() {

            final SharingSettingsFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    handleChangeSettingsResponse(pmapiresponse);
                }
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        });
    }

    private void setSearchSettings(final boolean bSearchVisibility)
    {
        PMApplicationSession.GetPMSession().setSearchVisibilityFlag(bSearchVisibility);
        showProgressDialogWithMessage(getString(0x7f0602b5));
        PMApi.postSearchVisibilityFlag(bSearchVisibility, new PMApiResponseHandler() {

            final SharingSettingsFragment this$0;
            final boolean val$bSearchVisibility;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                handleChangeSettingsResponse(pmapiresponse);
                if (!bSearchVisibility)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "turn_off_search_visibility", null);
                }
                hideProgressDialog();
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                bSearchVisibility = flag;
                super();
            }
        });
    }

    private void setupView(View view)
    {
        updateFBShareLayout();
        updateTwitterShareLayout();
        updateTumblrShareLayout();
        updatePinterestShareLayout();
        searchIndexSwitch = (Switch)view.findViewById(0x7f0c02c3);
        searchIndexSwitch.setChecked(settingsData.search_visibility);
        searchIndexSwitch.setOnCheckedChangeListener(searchIndexListener);
    }

    private void updateFBShareLayout()
    {
        fbShareLayout = (RelativeLayout)getView().findViewById(0x7f0c02bc);
        int i = fbShareLayout.getPaddingTop();
        fbShareLayout.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
        fbShareLayout.setPadding(i, i, i, i);
        ((PMTextView)fbShareLayout.findViewById(0x7f0c01ba)).setText(getString(0x7f060108));
        fbShareLayout.setOnClickListener(fbShareClickListener);
        Object obj = (PMTextView)fbShareLayout.findViewById(0x7f0c01bd);
        ImageView imageview = (ImageView)fbShareLayout.findViewById(0x7f0c01be);
        boolean flag = FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.READ_PERMISSION);
        boolean flag1 = FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.PUBLISH_PERMISSION);
        if (flag)
        {
            ((PMTextView) (obj)).setText(getString(0x7f060095));
            imageview.setImageDrawable(getResources().getDrawable(0x7f02007d));
            ((PMTextView) (obj)).setTextColor(getResources().getColor(0x7f090039));
            obj = (LinearLayout)fbShareLayout.findViewById(0x7f0c020b);
            ((LinearLayout) (obj)).setVisibility(0);
            timelineOptionSwitch = (Switch)((LinearLayout) (obj)).findViewById(0x7f0c02bb);
            if (settingsData.timeline)
            {
                if (flag1)
                {
                    timelineOptionSwitch.setChecked(true);
                } else
                {
                    timelineOptionSwitch.setChecked(false);
                }
            } else
            {
                timelineOptionSwitch.setChecked(settingsData.timeline);
            }
            timelineOptionSwitch.setOnCheckedChangeListener(shareToFbTimelineListener);
            return;
        } else
        {
            ((PMTextView) (obj)).setText(getString(0x7f060094));
            ((PMTextView) (obj)).setTextColor(getResources().getColor(0x7f09003c));
            imageview.setImageDrawable(getResources().getDrawable(0x7f0200a5));
            ((LinearLayout)fbShareLayout.findViewById(0x7f0c020b)).setVisibility(8);
            return;
        }
    }

    private void updateGoogleShareLayout()
    {
        Object obj = (LinearLayout)getView().findViewById(0x7f0c02c0);
        gPlusShareLayout = (RelativeLayout)((LinearLayout) (obj)).findViewById(0x7f0c02c1);
        if (PMApplicationSession.GetPMSession().getGoogleToken() != null)
        {
            ((LinearLayout) (obj)).setVisibility(0);
            int i = gPlusShareLayout.getPaddingTop();
            gPlusShareLayout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
            gPlusShareLayout.setPadding(i, i, i, i);
            gPlusShareLayout.setOnClickListener(googlePlusShareClickListener);
            ((PMTextView)gPlusShareLayout.findViewById(0x7f0c01ba)).setText(getString(0x7f06013a));
            obj = (PMTextView)gPlusShareLayout.findViewById(0x7f0c01bd);
            ImageView imageview = (ImageView)gPlusShareLayout.findViewById(0x7f0c01be);
            ((PMTextView) (obj)).setText(getString(0x7f060095));
            imageview.setImageDrawable(getResources().getDrawable(0x7f02007d));
            return;
        } else
        {
            ((LinearLayout) (obj)).setVisibility(8);
            return;
        }
    }

    private void updatePinterestShareLayout()
    {
        pinterestShareLayout = (RelativeLayout)getView().findViewById(0x7f0c02bd);
        if (isPinterestButtonEnabled)
        {
            ((PMTextView)pinterestShareLayout.findViewById(0x7f0c01ba)).setText(getString(0x7f060203));
            PMTextView pmtextview = (PMTextView)pinterestShareLayout.findViewById(0x7f0c01bd);
            ImageView imageview = (ImageView)pinterestShareLayout.findViewById(0x7f0c01be);
            if (PMApplicationSession.GetPMSession().getPinterestToken() != null)
            {
                pmtextview.setText(PMApplicationSession.GetPMSession().getPinterestUserName());
                pmtextview.setTextColor(getResources().getColor(0x7f090039));
            } else
            {
                pmtextview.setText(getString(0x7f060094));
                pmtextview.setTextColor(getResources().getColor(0x7f09003c));
                imageview.setImageDrawable(getResources().getDrawable(0x7f0200a5));
            }
            pinterestShareLayout.setOnClickListener(pinterestShareClickListener);
            return;
        } else
        {
            pinterestShareLayout.setVisibility(8);
            return;
        }
    }

    private void updateTumblrShareLayout()
    {
        tumblrShareLayout = (RelativeLayout)getView().findViewById(0x7f0c02bf);
        if (PMApplicationSession.GetPMSession().getGoogleToken() == null)
        {
            int i = tumblrShareLayout.getPaddingTop();
            tumblrShareLayout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
            tumblrShareLayout.setPadding(i, i, i, i);
        }
        tumblrShareLayout.setOnClickListener(tmShareClickListener);
        ((PMTextView)tumblrShareLayout.findViewById(0x7f0c01ba)).setText(getString(0x7f06029e));
        PMTextView pmtextview = (PMTextView)tumblrShareLayout.findViewById(0x7f0c01bd);
        ImageView imageview = (ImageView)tumblrShareLayout.findViewById(0x7f0c01be);
        if (PMApplicationSession.GetPMSession().getTumblrToken() != null)
        {
            pmtextview.setText(PMApplicationSession.GetPMSession().getTumblrUsername());
            pmtextview.setTextColor(getResources().getColor(0x7f090039));
            imageview.setImageDrawable(getResources().getDrawable(0x7f02007d));
            return;
        } else
        {
            pmtextview.setText(getString(0x7f060094));
            pmtextview.setTextColor(getResources().getColor(0x7f09003c));
            imageview.setImageDrawable(getResources().getDrawable(0x7f0200a5));
            return;
        }
    }

    private void updateTwitterShareLayout()
    {
        twitterShareLayout = (RelativeLayout)getView().findViewById(0x7f0c02be);
        twitterShareLayout.setOnClickListener(twShareClickListener);
        ((PMTextView)twitterShareLayout.findViewById(0x7f0c01ba)).setText(getString(0x7f0602a0));
        PMTextView pmtextview = (PMTextView)twitterShareLayout.findViewById(0x7f0c01bd);
        ImageView imageview = (ImageView)twitterShareLayout.findViewById(0x7f0c01be);
        if (PMApplicationSession.GetPMSession().getTwitterToken() != null)
        {
            pmtextview.setText(PMApplicationSession.GetPMSession().getTwitterUsername());
            imageview.setImageDrawable(getResources().getDrawable(0x7f02007d));
            pmtextview.setTextColor(getResources().getColor(0x7f090039));
            return;
        } else
        {
            pmtextview.setText(getString(0x7f060094));
            pmtextview.setTextColor(getResources().getColor(0x7f09003c));
            imageview.setImageDrawable(getResources().getDrawable(0x7f0200a5));
            return;
        }
    }

    public void handleNotification(Intent intent)
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(0x7f06025e);
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.getUserSettings(new PMApiResponseHandler() {

            final SharingSettingsFragment this$0;

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
                        settingsData = (com.poshmark.user.UserInfoDetails.Settings)pmapiresponse.data;
                        setupView(getView());
                        if (autoLaunchServiceConnect)
                        {
                            autoLaunchServiceConnect();
                        }
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_USER_SETTINGS, getString(0x7f0600ed)));
            }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED", this);
        if (bundle == null)
        {
            launchConnectServiceId = getArguments().getString("ext_service_id", null);
            if (launchConnectServiceId != null)
            {
                autoLaunchServiceConnect = true;
            }
        }
        isPinterestButtonEnabled = FeatureManager.getGlobalFeatureManager().isPinterestButtonEnabled();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300b5, viewgroup, false);
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        if (i != FbHelper.FB_CONNECT_PUBLISH_REQUEST) goto _L2; else goto _L1
_L1:
        if (bundle == null) goto _L4; else goto _L3
_L3:
        boolean flag;
        flag = bundle.getBoolean("HAS_ERROR", false);
        i = bundle.getInt("ACCESS_LEVEL", 0);
        if (flag || !isAdded()) goto _L6; else goto _L5
_L5:
        if ((i & 8) != 0)
        {
            updateFBShareLayout();
        }
_L4:
        return;
_L6:
        bundle = bundle.getString("ERROR_JSON");
        if (bundle != null)
        {
            FbHelper.showFBLinkError(PMApiError.deserialize(bundle), this);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i == FbHelper.FB_CONNECT_AUTO_TIMELINE_REQUEST)
        {
            if ((bundle.getInt("ACCESS_LEVEL", 0) & 8) != 0)
            {
                bundle = getView();
                if (bundle != null)
                {
                    setupView(bundle);
                }
                PMApplicationSession.GetPMSession().setFacebookPostToTimelineFlag(true);
                PMApi.postFacebookTimelineFlag(true, null);
                return;
            } else
            {
                timelineOptionSwitch.setChecked(false);
                return;
            }
        }
        if (i == 8772 && bundle != null)
        {
            if (bundle.getBoolean("HAS_ERROR"))
            {
                Analytics.getInstance().trackEvent(getViewNameForAnalytics(), "user", "connect_pinterest_failed", PMApplicationSession.GetPMSession().getUserId());
                showAutoHideProgressDialogWithMessage(getString(0x7f06022e));
                return;
            } else
            {
                Analytics.getInstance().trackEvent(getViewNameForAnalytics(), "user", "connect_pinterest_complete", PMApplicationSession.GetPMSession().getUserId());
                pinterestConnectFinish();
                return;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "share_settings_screen";
    }










}
