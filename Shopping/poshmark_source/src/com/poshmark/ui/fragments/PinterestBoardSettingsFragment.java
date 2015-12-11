// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.fb_tmblr_twitter.PinterestHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.PinterestBoard;
import com.poshmark.utils.meta_data.PinterestSettings;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PinterestBoardPickerFragment

public class PinterestBoardSettingsFragment extends PMFragment
{

    public static final int COMMUNITY_SHARES = 1;
    public static final int MY_LISTINGS_SHARES = 2;
    RelativeLayout community_shares_layout;
    android.view.View.OnClickListener listener;
    RelativeLayout my_listing_shares_layout;
    PinterestSettings pins;
    PMButton unlink_button;

    public PinterestBoardSettingsFragment()
    {
        listener = new android.view.View.OnClickListener() {

            final PinterestBoardSettingsFragment this$0;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131493477: 
                    view = new Bundle();
                    view.putInt("mode", 1);
                    getParentActivity().launchFragmentForResult(view, com/poshmark/ui/fragments/PinterestBoardPickerFragment, pins, PinterestBoardSettingsFragment.this, 1);
                    return;

                case 2131493476: 
                    view = new Bundle();
                    view.putInt("mode", 2);
                    getParentActivity().launchFragmentForResult(view, com/poshmark/ui/fragments/PinterestBoardPickerFragment, pins, PinterestBoardSettingsFragment.this, 2);
                    return;

                case 2131493478: 
                    view = new android.app.AlertDialog.Builder(getActivity());
                    break;
                }
                view.setTitle((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
                view.setMessage(String.format(getString(0x7f0602aa), new Object[] {
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
                        showProgressDialogWithMessage(getString(0x7f060190));
                        PMApi.unlinkExternalService("pn", new PMApiResponseHandler() {

                            final _cls2 this$2;

                            public void handleResponse(PMApiResponse pmapiresponse)
                            {
                                ExtServiceConnectManager.getGlobalConnectManager().pinterestUnlink();
                                PinterestHelper.getInstance().unlink();
                                PinterestHelper.getInstance().destroy();
                                hideProgressDialog();
                                getActivity().onBackPressed();
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                view.create().show();
            }

            
            {
                this$0 = PinterestBoardSettingsFragment.this;
                super();
            }
        };
    }

    private void setupView()
    {
        PinterestBoard pinterestboard = pins.self_board;
        Object obj = pins.others_board;
        ((PMTextView)community_shares_layout.findViewById(0x7f0c01ba)).setText(getString(0x7f06008f));
        PMTextView pmtextview = (PMTextView)community_shares_layout.findViewById(0x7f0c01bd);
        int i = community_shares_layout.getPaddingTop();
        community_shares_layout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
        community_shares_layout.setPadding(i, i, i, i);
        pmtextview.setTextColor(getResources().getColor(0x7f090039));
        if (obj != null && ((PinterestBoard) (obj)).getDisplay().length() > 0)
        {
            pmtextview.setText(((PinterestBoard) (obj)).getDisplay());
        } else
        {
            pmtextview.setText(getString(0x7f0600be));
        }
        ((PMTextView)my_listing_shares_layout.findViewById(0x7f0c01ba)).setText(getString(0x7f0601b4));
        obj = (PMTextView)my_listing_shares_layout.findViewById(0x7f0c01bd);
        ((PMTextView) (obj)).setTextColor(getResources().getColor(0x7f090039));
        if (pinterestboard != null && pinterestboard.getDisplay().length() > 0)
        {
            ((PMTextView) (obj)).setText(pinterestboard.getDisplay());
        } else
        {
            ((PMTextView) (obj)).setText(getString(0x7f0600be));
        }
        unlink_button.setText(getString(0x7f0602a7));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.getPinterestSettings(new PMApiResponseHandler() {

            final PinterestBoardSettingsFragment this$0;

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
                        pins = (PinterestSettings)pmapiresponse.data;
                        setupView();
                    }
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_USER_SETTINGS, getString(0x7f0600ed)));
            }

            
            {
                this$0 = PinterestBoardSettingsFragment.this;
                super();
            }
        });
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        intent = intent.getBundleExtra("RETURNED_RESULTS").getString("DATA_SELECTED");
        if (intent == null) goto _L2; else goto _L1
_L1:
        intent = (PinterestBoard)StringUtils.fromJson(intent, com/poshmark/utils/meta_data/PinterestBoard);
        i;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 57
    //                   2 66;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        pins.others_board = intent;
        return;
_L4:
        pins.self_board = intent;
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0300a2, null);
        community_shares_layout = (RelativeLayout)layoutinflater.findViewById(0x7f0c0265);
        my_listing_shares_layout = (RelativeLayout)layoutinflater.findViewById(0x7f0c0264);
        community_shares_layout.setOnClickListener(listener);
        my_listing_shares_layout.setOnClickListener(listener);
        unlink_button = (PMButton)layoutinflater.findViewById(0x7f0c0266);
        unlink_button.setOnClickListener(listener);
        return layoutinflater;
    }

    public void onPMResume()
    {
        super.onPMResume();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "pinterest_share_settings_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(0x7f060203);
    }

}
