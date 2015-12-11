// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMOfferInfo;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.OfferFlowHandler;
import java.math.BigDecimal;
import java.util.HashMap;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, CheckoutConfirmationFragment_Offers, MappPageFragment

public class MakeOfferFragment extends PMFragment
{

    int CHEKOUT_CONIRMATION_REQUEST;
    private OfferFlowHandler flowHandler;
    EditText offerText;

    public MakeOfferFragment()
    {
        CHEKOUT_CONIRMATION_REQUEST = 1;
    }

    private void handleAddProductResponse(PMApiResponse pmapiresponse)
    {
        hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            flowHandler.setOffer((PMOfferInfo)pmapiresponse.data);
            showConfirmationForm();
            return;
        } else
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.ADD_PRODUCT_TO_ORDER, getString(0x7f0600d5), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            return;
        }
    }

    private boolean offerValid(String s)
    {
        int i;
        int j;
        int k;
        float f = Float.parseFloat(flowHandler.getListingDetails().getPrice().toString());
        i = (int)Math.ceil(f / 10F);
        j = Integer.parseInt(FeatureManager.getGlobalFeatureManager().getListingFeature().getMinimumSellingPrice().toString());
        if (s == null || s.length() == 0)
        {
            showAlertMessage("Make An Offer", "Invalid Offer Price");
            return false;
        }
        s = s.substring(1);
        try
        {
            k = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            showAlertMessage("Make An Offer", "Invalid Offer Price");
            return false;
        }
        if ((float)k < f)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        showAlertMessage("Make An Offer", String.format("Offer price should not exceed $%s", new Object[] {
            Integer.valueOf((int)f - 1)
        }));
        return false;
        if (i <= j)
        {
            i = j;
        }
        if (k >= i)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        showAlertMessage("Make An Offer", String.format("Offer price should be at least $%s", new Object[] {
            Integer.valueOf(i)
        }));
        return false;
        return true;
    }

    private void setupOffer(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("offer_amount", s);
        showProgressDialogWithMessage(getString(0x7f06009b));
        s = MetricsTrackingUtils.getTrackingJson(getActivity(), "ofr_i");
        PMApi.addProductToOffer(flowHandler.getListingDetails().getIdAsString(), hashmap, s, new PMApiResponseHandler() {

            final MakeOfferFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    handleAddProductResponse(pmapiresponse);
                }
            }

            
            {
                this$0 = MakeOfferFragment.this;
                super();
            }
        });
    }

    private void setupView(View view)
    {
        offerText = (EditText)view.findViewById(0x7f0c0201);
        if (flowHandler != null)
        {
            PMListingImageView pmlistingimageview = (PMListingImageView)view.findViewById(0x7f0c00b5);
            TextView textview = (TextView)view.findViewById(0x7f0c00b7);
            TextView textview1 = (TextView)view.findViewById(0x7f0c0202);
            pmlistingimageview.loadImage(flowHandler.getListingDetails().getSmallCovershot());
            textview.setText(flowHandler.getListingDetails().getTitle());
            textview1.setText((new StringBuilder()).append(getString(0x7f06017e)).append(": ").append(flowHandler.getListingDetails().getPriceString()).toString());
            ((ImageButton)view.findViewById(0x7f0c01ff)).setOnClickListener(new android.view.View.OnClickListener() {

                final MakeOfferFragment this$0;

                public void onClick(View view1)
                {
                    view1 = new Bundle();
                    view1.putString("URL", "https://www.poshmark.com/mapp/offers_help");
                    view1.putString("ANALYTICS_PAGE_NAME", "offers_help_screen");
                    ((PMActivity)getActivity()).launchFragmentInNewActivity(view1, com/poshmark/ui/fragments/MappPageFragment, null);
                }

            
            {
                this$0 = MakeOfferFragment.this;
                super();
            }
            });
            offerText.addTextChangedListener(new TextWatcher() {

                final MakeOfferFragment this$0;

                public void afterTextChanged(Editable editable)
                {
                    if (!editable.toString().contains(CurrencyUtils.getCurrencySymbol()))
                    {
                        editable = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(offerText.getText().toString()).toString();
                        offerText.setText(editable);
                        Selection.setSelection(offerText.getText(), offerText.getText().length());
                    }
                }

                public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

                public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

            
            {
                this$0 = MakeOfferFragment.this;
                super();
            }
            });
        }
    }

    private void showConfirmationForm()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("CHECKOUT_FORM_MODE", CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal());
        PMActivity pmactivity = (PMActivity)getActivity();
        if (pmactivity != null)
        {
            pmactivity.launchFragmentForResult(bundle, com/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers, flowHandler, this, CHEKOUT_CONIRMATION_REQUEST);
        }
    }

    public void done(int i)
    {
        Object obj = new Bundle();
        PMFragment pmfragment = (PMFragment)getTargetFragment();
        if (pmfragment != null)
        {
            ((Bundle) (obj)).putInt("RESULT_CODE", i);
            pmfragment.onFragmentResult(((Bundle) (obj)), getTargetRequestCode());
            obj = getActivity();
            if (obj != null)
            {
                ((Activity) (obj)).onBackPressed();
            }
            return;
        } else
        {
            finishActivityWithResult(i, null);
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == CHEKOUT_CONIRMATION_REQUEST && i == -1)
        {
            done(j);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            flowHandler = (OfferFlowHandler)getFragmentDataOfType(com/poshmark/utils/CheckoutFlowHandler);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03007f, viewgroup, false);
        setupView(layoutinflater);
        return layoutinflater;
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        super.onFragmentResult(bundle, i);
        if (i == CHEKOUT_CONIRMATION_REQUEST)
        {
            i = bundle.getInt("RESULT_CODE", 0);
            if (i == -1)
            {
                done(i);
            }
        }
    }

    public void onPMResume()
    {
        super.onPMResume();
        flowHandler.setCallingFragment(this);
        if (offerText.requestFocus())
        {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "offer_price_form_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(getString(0x7f06019a));
        setNextActionButton(getString(0x7f0601cc), new android.view.View.OnClickListener() {

            final MakeOfferFragment this$0;

            public void onClick(View view)
            {
                if (flowHandler != null && (flowHandler instanceof OfferFlowHandler))
                {
                    String s = offerText.getText().toString();
                    if (offerValid(s))
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "offer_price_entered_next_tapped", flowHandler.getListingDetails().getIdAsString());
                        PMContainerActivity pmcontaineractivity = (PMContainerActivity)getActivity();
                        view.clearFocus();
                        getActivity().getWindow().setSoftInputMode(2);
                        setupOffer(s.substring(1));
                    }
                }
            }

            
            {
                this$0 = MakeOfferFragment.this;
                super();
            }
        });
    }




}
