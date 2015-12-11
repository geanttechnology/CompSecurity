// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.FacebookSdk;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.Referral;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.ColorConverter;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.ViewUtils;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class ShareFragment extends PMFragment
{

    static final String fbMessengerPackageName = "com.facebook.orca";
    static final String instagramPackageName = "com.instagram.android";
    private Button emailShareButton;
    private Button fbMessengerShareButton;
    private Button fbShareButton;
    private Button followersShareButton;
    Uri imageURI;
    private Button instagramShareButton;
    com.poshmark.utils.ShareManager.SHARE_MODE mode;
    private Button pinterestShareButton;
    TextView referralCodeView;
    TextView referralMessageView;
    ShareManager shareManager;
    private Button smsShareButton;
    private Button tumblrShareButton;
    private Button twitterShareButton;

    public ShareFragment()
    {
    }

    private void doEmailShare()
    {
        shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE);
        shareManager.doEmailShare();
    }

    private void doMessengerShare()
    {
        if (!isFbMessengerInstalled())
        {
            return;
        } else
        {
            shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.FB_MESSENGER_SHARE);
            shareManager.doFBMessengerShare();
            return;
        }
    }

    private void doPinterestShare()
    {
        shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.PINTEREST_SHARE);
        shareManager.doPinterestShare();
    }

    private void doSMSShare()
    {
        shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.SMS_SHARE);
        shareManager.doSMSShare();
    }

    private boolean isFbAppInstalled()
    {
        return true;
    }

    private boolean isFbMessengerInstalled()
    {
        getActivity().getPackageManager().getApplicationInfo("com.facebook.orca", 0);
        boolean flag = true;
_L2:
        if (!flag)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setTitle(String.format(getString(0x7f06014c), new Object[] {
                getString(0x7f06010a)
            }));
            builder.setPositiveButton(0x7f06014b, new android.content.DialogInterface.OnClickListener() {

                final ShareFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    try
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.facebook.orca")));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (DialogInterface dialoginterface)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.facebook.orca")));
                    }
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
            builder.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                final ShareFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
            builder.create().show();
        }
        return flag;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean isInstagramInstalled()
    {
        getActivity().getPackageManager().getApplicationInfo("com.instagram.android", 0);
        boolean flag = true;
_L2:
        if (!flag)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setTitle(String.format(getString(0x7f06014c), new Object[] {
                getString(0x7f06014a)
            }));
            builder.setPositiveButton(0x7f06014b, new android.content.DialogInterface.OnClickListener() {

                final ShareFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    try
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.instagram.android")));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (DialogInterface dialoginterface)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.instagram.android")));
                    }
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
            builder.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                final ShareFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
            builder.create().show();
        }
        return flag;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void loadReferralData()
    {
        if (shareManager.getReferralData() != null)
        {
            return;
        } else
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getReferralCode(new PMApiResponseHandler() {

                final ShareFragment this$0;

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
                            shareManager.setReferralData((Referral)pmapiresponse.data);
                            if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
                            {
                                referralMessageView.setText(shareManager.getReferralData().getProgram());
                                referralCodeView.setText(shareManager.getReferralData().getId());
                            }
                        }
                        return;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_REFERRAL_CODE, getString(0x7f0600ec)), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                        final _cls1 this$1;

                        public void dialogDismissed()
                        {
                            getActivity().onBackPressed();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupButtonHandlers()
    {
        if (fbShareButton != null)
        {
            fbShareButton.setOnClickListener(new android.view.View.OnClickListener() {

                final ShareFragment this$0;

                public void onClick(View view)
                {
                    shareOnFb();
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
        }
        twitterShareButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareFragment this$0;

            public void onClick(View view)
            {
                shareOnTwitter();
            }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
        });
        tumblrShareButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareFragment this$0;

            public void onClick(View view)
            {
                shareOnTumblr();
            }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
        });
        if (instagramShareButton != null)
        {
            instagramShareButton.setOnClickListener(new android.view.View.OnClickListener() {

                final ShareFragment this$0;

                public void onClick(View view)
                {
                    shareOnInstagram();
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
        }
        emailShareButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareFragment this$0;

            public void onClick(View view)
            {
                doEmailShare();
            }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
        });
        smsShareButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareFragment this$0;

            public void onClick(View view)
            {
                doSMSShare();
            }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
        });
        fbMessengerShareButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareFragment this$0;

            public void onClick(View view)
            {
                doMessengerShare();
            }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
        });
        if (pinterestShareButton != null)
        {
            pinterestShareButton.setOnClickListener(new android.view.View.OnClickListener() {

                final ShareFragment this$0;

                public void onClick(View view)
                {
                    doPinterestShare();
                }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
            });
        }
    }

    private void setupListViewForBrandShare(View view)
    {
        setupPinterestView(view);
    }

    private void setupListViewForClosetShare(View view)
    {
        setupPinterestView(view);
    }

    private void setupListViewForListingShare(View view)
    {
        ScrollView scrollview = (ScrollView)view.findViewById(0x7f0c02a5);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f0c02a6);
        ((LinearLayout)scrollview.findViewById(0x7f0c02a7)).setVisibility(0);
        followersShareButton = (Button)view.findViewById(0x7f0c02a8);
        followersShareButton.setText(0x7f0601b1);
        followersShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200fa, 0, 0, 0);
        followersShareButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareFragment this$0;

            public void onClick(View view1)
            {
                shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.DEFAULT);
                shareManager.shareToFollowers();
            }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
        });
        List list = GlobalPartiesController.getGlobalPartiesController().getCurrentParties();
        if (list != null && list.size() > 0)
        {
            LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
            int i = 0;
            while (i < list.size()) 
            {
                PartyEvent partyevent = (PartyEvent)list.get(i);
                partyevent.getId();
                Button button;
                if (i == 0)
                {
                    button = (Button)layoutinflater.inflate(0x7f03001c, null);
                    int k = (int)ViewUtils.dipToPixels(getActivity(), 30F);
                    android.widget.LinearLayout.LayoutParams layoutparams2 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    layoutparams2.setMargins(0, k, 0, 0);
                    button.setLayoutParams(layoutparams2);
                } else
                {
                    button = (Button)layoutinflater.inflate(0x7f03001a, null);
                }
                button.setText(partyevent.getTitle());
                button.setTag(partyevent);
                button.setCompoundDrawablesWithIntrinsicBounds(0x7f0200fb, 0, 0, 0);
                button.setOnClickListener(new android.view.View.OnClickListener() {

                    final ShareFragment this$0;

                    public void onClick(View view1)
                    {
                        shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.DEFAULT);
                        shareManager.setPartyEvent((PartyEvent)view1.getTag());
                        shareManager.shareToEventWithId();
                    }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
                });
                linearlayout.addView(button, i);
                i++;
            }
            followersShareButton.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
            i = (int)ViewUtils.dipToPixels(getActivity(), 10F);
            followersShareButton.setPadding(i, 0, 0, 0);
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)followersShareButton.getLayoutParams();
            layoutparams.setMargins(0, 0, 0, 0);
            followersShareButton.setLayoutParams(layoutparams);
        } else
        {
            int j = (int)ViewUtils.dipToPixels(getActivity(), 30F);
            android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
            layoutparams1.setMargins(0, j, 0, 0);
            followersShareButton.setLayoutParams(layoutparams1);
        }
        setupPinterestView(view);
    }

    private void setupListViewForPartyShare(View view)
    {
    }

    private void setupListViewForReferralShare(View view)
    {
        view = (LinearLayout)((ScrollView)view.findViewById(0x7f0c02a5)).findViewById(0x7f0c02a9);
        view.setVisibility(0);
        referralMessageView = (TextView)view.findViewById(0x7f0c02aa);
        referralCodeView = (TextView)view.findViewById(0x7f0c02ab);
    }

    private void setupListViewForShowroomShare(View view)
    {
        setupPinterestView(view);
    }

    private void setupPinterestView(View view)
    {
        pinterestShareButton = (Button)view.findViewById(0x7f0c02b5);
        pinterestShareButton.setVisibility(0);
        pinterestShareButton.setText("Pinterest");
        pinterestShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f9, 0, 0, 0);
    }

    private void setupProTipView(PMTextView pmtextview, com.poshmark.data_model.models.inner_models.FbDialogShareFeature.TipInfo tipinfo)
    {
        pmtextview.setVisibility(0);
        pmtextview.setText(tipinfo.message);
        if (tipinfo.text_color != null)
        {
            int i = ((ColorDrawable)(ColorDrawable)getResources().getDrawable(0x7f09003b)).getColor();
            pmtextview.setTextColor(ColorConverter.getColorValueFromHexString(tipinfo.text_color, i));
        }
        if (tipinfo.background_color != null)
        {
            int j = ((ColorDrawable)(ColorDrawable)getResources().getDrawable(0x7f09000b)).getColor();
            pmtextview.setBackgroundColor(ColorConverter.getColorValueFromHexString(tipinfo.background_color, j));
        }
    }

    private void setupView(View view)
    {
        pinterestShareButton = (Button)view.findViewById(0x7f0c02b5);
        pinterestShareButton.setVisibility(8);
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING)
        {
            setupListViewForListingShare(view);
        } else
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY)
        {
            setupListViewForPartyShare(view);
        } else
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET)
        {
            setupListViewForClosetShare(view);
        } else
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            setupListViewForShowroomShare(view);
        } else
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND)
        {
            setupListViewForBrandShare(view);
        } else
        {
            setupListViewForReferralShare(view);
        }
        if (FeatureManager.getGlobalFeatureManager().isFbShareProTipEnabled(mode))
        {
            if (isFbAppInstalled())
            {
                com.poshmark.data_model.models.inner_models.FbDialogShareFeature.TipInfo tipinfo = FeatureManager.getGlobalFeatureManager().getFbShareProTipInfo(mode);
                int i;
                if (tipinfo.use_separate_section_for_tip)
                {
                    ((LinearLayout)view.findViewById(0x7f0c02ac)).setVisibility(0);
                    setupProTipView((PMTextView)view.findViewById(0x7f0c02ad), tipinfo);
                    fbShareButton = (Button)view.findViewById(0x7f0c02ae);
                    fbShareButton.setText(0x7f060108);
                    fbShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f2, 0, 0, 0);
                    ((Button)view.findViewById(0x7f0c02b6)).setVisibility(8);
                } else
                {
                    setupProTipView((PMTextView)view.findViewById(0x7f0c02b4), tipinfo);
                    fbShareButton = (Button)view.findViewById(0x7f0c02b6);
                    fbShareButton.setText(0x7f060108);
                    fbShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f2, 0, 0, 0);
                    fbShareButton.setVisibility(0);
                    ((LinearLayout)view.findViewById(0x7f0c02ac)).setVisibility(8);
                }
            }
        } else
        {
            fbShareButton = (Button)view.findViewById(0x7f0c02b6);
            fbShareButton.setText(0x7f060108);
            fbShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f2, 0, 0, 0);
            fbShareButton.setVisibility(0);
            ((LinearLayout)view.findViewById(0x7f0c02ac)).setVisibility(8);
        }
        twitterShareButton = (Button)view.findViewById(0x7f0c02b7);
        twitterShareButton.setText(0x7f0602a0);
        twitterShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f02010b, 0, 0, 0);
        tumblrShareButton = (Button)view.findViewById(0x7f0c02b8);
        tumblrShareButton.setText(0x7f06029e);
        tumblrShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f02010a, 0, 0, 0);
        instagramShareButton = (Button)view.findViewById(0x7f0c02b9);
        instagramShareButton.setText(0x7f06014a);
        instagramShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f7, 0, 0, 0);
        if (imageURI == null)
        {
            instagramShareButton.setVisibility(8);
            i = (int)ViewUtils.dipToPixels(getActivity(), 10F);
            tumblrShareButton.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
            tumblrShareButton.setPadding(i, i, i, i);
        }
        emailShareButton = (Button)view.findViewById(0x7f0c02b2);
        emailShareButton.setText(0x7f0600c7);
        emailShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f1, 0, 0, 0);
        smsShareButton = (Button)view.findViewById(0x7f0c02b1);
        smsShareButton.setText(0x7f060284);
        smsShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200ff, 0, 0, 0);
        fbMessengerShareButton = (Button)view.findViewById(0x7f0c02b0);
        fbMessengerShareButton.setText(0x7f0601a4);
        fbMessengerShareButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f3, 0, 0, 0);
        if (FeatureManager.getGlobalFeatureManager().isFbMessengerSharingEnabled())
        {
            i = (int)ViewUtils.dipToPixels(getActivity(), 10F);
            fbMessengerShareButton.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
            fbMessengerShareButton.setPadding(i, i, i, i);
            smsShareButton.setBackgroundDrawable(getResources().getDrawable(0x7f020022));
            smsShareButton.setPadding(i, i, i, i);
            fbMessengerShareButton.setVisibility(0);
        }
    }

    private void shareOnFb()
    {
label0:
        {
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                if (!FeatureManager.getGlobalFeatureManager().isFbExplicitShareEnabled() || !isFbAppInstalled())
                {
                    break label0;
                }
                shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.FB_DIALOG_SHARE);
                shareManager.doFbShareViaShareDialog();
            }
            return;
        }
        shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE);
        shareManager.doFbShareViaServer();
    }

    private void shareOnInstagram()
    {
        if (!isInstagramInstalled() || imageURI == null)
        {
            return;
        } else
        {
            shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.INSTAGRAM_SHARE);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", imageURI);
            intent.setPackage("com.instagram.android");
            startActivity(intent);
            shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_INITIALED);
            return;
        }
    }

    private void shareOnTumblr()
    {
        shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.TM_SHARE);
        shareManager.doTumblrShare();
    }

    private void shareOnTwitter()
    {
        shareManager.setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE.TW_SHARE);
        shareManager.doTwitterShare();
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED") && isAdded())
        {
            intent = getView();
            if (intent != null)
            {
                setupView(intent);
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (FacebookSdk.isFacebookRequestCode(i))
        {
            intent = intent.getExtras();
            if (intent != null)
            {
                intent.putInt("REQUEST_CODE", i);
                intent.putInt("RESPONSE_CODE", j);
                PMNotificationManager.fireNotification("com.poshmark.intents.FBDIALOG_SHARE_RESULTS", intent);
            }
        }
        if (i == 14 || i == 13)
        {
            getActivity().finish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED", this);
        shareManager = ShareManager.getInstance();
        if (bundle == null)
        {
            shareManager.deInit();
            mode = com.poshmark.utils.ShareManager.SHARE_MODE.valueOf(getArguments().getString("MODE"));
            if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING)
            {
                shareManager.setListingItem((ListingSocial)getFragmentDataOfType(com/poshmark/data_model/models/ListingSocial));
            } else
            if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY)
            {
                shareManager.setPartyEvent((PartyEvent)getFragmentDataOfType(com/poshmark/data_model/models/PartyEvent));
            } else
            if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET)
            {
                shareManager.setUserProfile((UserInfoDetails)getFragmentDataOfType(com/poshmark/user/UserInfoDetails));
            } else
            if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM)
            {
                shareManager.setShowroom((Showroom)getFragmentDataOfType(com/poshmark/data_model/models/Showroom));
            } else
            if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND)
            {
                shareManager.setBrand((Brand)getFragmentDataOfType(com/poshmark/data_model/models/Brand));
            }
            bundle = getArguments().getString("IMAGE_URI");
            if (bundle != null && bundle.length() > 0)
            {
                imageURI = Uri.parse(bundle);
            }
        } else
        {
            mode = (com.poshmark.utils.ShareManager.SHARE_MODE)bundle.getSerializable("SHARING_MODE");
            bundle = bundle.getString("IMAGE_URI", null);
            if (bundle != null)
            {
                imageURI = Uri.parse(bundle);
            }
        }
        shareManager.init(getActivity(), mode, this);
        shareManager.trackShareFragmentDisplayed();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0300b3, viewgroup, false);
        setupView(layoutinflater);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
    }

    public void onPMResume()
    {
        super.onPMResume();
        hideAllActionButtons(true);
        setupButtonHandlers();
        setTitle(shareManager.getTitleString());
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS || mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET)
        {
            loadReferralData();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("SHARING_MODE", mode);
        if (imageURI != null)
        {
            bundle.putString("IMAGE_URI", imageURI.toString());
        }
    }

    public void setViewNameForAnalytics()
    {
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING)
        {
            viewNameForAnalytics = "share_listing_options_screen";
            return;
        }
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY)
        {
            viewNameForAnalytics = "share_party_options_screen";
            return;
        }
        if (shareManager.getShareMode() == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET)
        {
            viewNameForAnalytics = "share_closet_options_screen";
            return;
        } else
        {
            viewNameForAnalytics = "referral_screen";
            return;
        }
    }








}
